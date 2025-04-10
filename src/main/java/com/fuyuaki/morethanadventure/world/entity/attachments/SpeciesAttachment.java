package com.fuyuaki.morethanadventure.world.entity.attachments;

import com.fuyuaki.morethanadventure.core.deferred_registries.MTAAttachments;
import com.fuyuaki.morethanadventure.core.deferred_registries.MTAAttributes;
import com.fuyuaki.morethanadventure.core.mod.MTAMod;
import com.fuyuaki.morethanadventure.core.registry.MTARegistries;
import com.fuyuaki.morethanadventure.core.registry.MTASpecies;
import com.fuyuaki.morethanadventure.game.species.Species;
import com.fuyuaki.morethanadventure.game.species.traits.AbilityTrait;
import com.fuyuaki.morethanadventure.game.species.traits.TickingTrait;
import com.fuyuaki.morethanadventure.world.entity.attachments.helper.AbilityTraitCooldown;
import com.fuyuaki.morethanadventure.world.entity.attachments.helper.MTASoulHelper;
import com.google.common.collect.Multimap;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

import java.util.*;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class SpeciesAttachment implements INBTSerializable<CompoundTag> {


    private ResourceKey<Species> speciesKey;
    private Optional<ResourceKey<Species>> speciesO;
    boolean changed = true;
    List<AbilityTraitCooldown> cooldowns;

    public SpeciesAttachment(ResourceKey<Species> speciesKey){
        this();
        this.speciesKey = speciesKey;
        this.speciesO = Optional.of(speciesKey);
        this.cooldowns = new ArrayList<>();
        this.changed = true;
    }


    public SpeciesAttachment(){
        this.speciesKey = MTASpecies.HUMAN;
        this.speciesO = Optional.of(this.speciesKey);
        this.cooldowns = new ArrayList<>();
    }


    public static void sync(Player oldPlayer, Player newPlayer){
        newPlayer.setData(MTAAttachments.SPECIES.get(), oldPlayer.getData(MTAAttachments.SPECIES.get()).changed());
    }

    private SpeciesAttachment changed() {
        this.changed = true;
        return this;
    }


    public void updatePlayer(Player player) {
        if (this.speciesO.isPresent() && this.speciesO.get() != this.speciesKey && this.changed) {
            Species species = Species.getSpeciesFromKey(speciesKey, player.level());
            Species speciesOld = Species.getSpeciesFromKey(speciesO.get(), player.level());

            Multimap<Holder<Attribute>, AttributeModifier> modifierMap = species.modifierMap();
            Multimap<Holder<Attribute>, AttributeModifier> oldModifierMap = speciesOld.modifierMap();

            removeModifiers(oldModifierMap,player);
            addModifiers(modifierMap,player);


            MTASoulHelper.playerSetMaxSoul((int) (200 * player.getAttribute(MTAAttributes.MAGIC_STORAGE_SCALE).getValue()), player);

            this.speciesO = Optional.of(this.speciesKey);
        }else {

            Species species = Species.getSpeciesFromKey(speciesKey, player.level());
            Multimap<Holder<Attribute>, AttributeModifier> modifierMap = species.modifierMap();
            addModifiers(modifierMap,player);
            MTASoulHelper.playerSetMaxSoul((int) (200 * player.getAttribute(MTAAttributes.MAGIC_STORAGE_SCALE).getValue()), player);
            this.speciesO = Optional.of(this.speciesKey);

        }


    }

    private void addModifiers(Multimap<Holder<Attribute>, AttributeModifier> addMap, Player player) {
        addMap.asMap().forEach((holder, modifiers) -> {
            AttributeInstance instance = player.getAttributes().getInstance(holder);
            if (instance == null) return;

            modifiers.stream()
                    .filter(modifier -> !instance.hasModifier(modifier.id()))
                    .forEach(instance::addTransientModifier);
        });
    }

    private void removeModifiers(Multimap<Holder<Attribute>, AttributeModifier> removeMap, Player player) {

        removeMap.asMap().forEach((holder, modifiers) -> {
            AttributeInstance instance = player.getAttributes().getInstance(holder);
            if (instance == null) return;

            modifiers.stream()
                    .map(AttributeModifier::id)
                    .forEach(instance::removeModifier);
        });
    }


    public void changeSpecies(ResourceKey<Species> key){
        this.speciesKey = key;
        this.changed = true;
    }

    public void tick(Player player){
        this.updatePlayer(player);

        Species species = Species.getSpeciesFromKey(speciesKey, player.level());
        species.traits().forEach(trait -> {
            if (trait instanceof TickingTrait tickingTrait && tickingTrait.shouldTick(player)){
                tickingTrait.tick();
            }
        });
        List<AbilityTraitCooldown> cooldownList = new ArrayList<>();
        this.cooldowns.forEach(cooldown -> {
            if (cooldown.time() -1 > 0){
                cooldownList.add(cooldown.runTick());
            }
        });
        this.cooldowns = cooldownList;

    }

    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.Provider provider) {
        CompoundTag tag = new CompoundTag();

        tag = MTAMod.saveResourceKey("species",this.speciesKey,tag);
        if (this.speciesO.isPresent()){
            tag = MTAMod.saveResourceKey("species_old", this.speciesO.get(), tag);
        }

        CompoundTag cooldownList = new CompoundTag();
        this.cooldowns.forEach(cooldown -> cooldownList.putInt(cooldown.slot().name(),cooldown.time()));
        tag.put("cooldowns",cooldownList);

        return tag;
    }
    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag nbt) {
        if (!(nbt.isEmpty()) ) {
            this.speciesKey = MTAMod.loadResourceKey(MTARegistries.Keys.SPECIES, "species", nbt);
            this.speciesO = Optional.of(MTAMod.loadResourceKey(MTARegistries.Keys.SPECIES, "species_old", nbt));

            CompoundTag tag = nbt.getCompound("cooldowns");
            tag.getAllKeys().forEach(string -> {
                if (AbilityTrait.AbilitySlot.PRIMARY.getId().equals(string))
                    this.cooldowns.add(new AbilityTraitCooldown(AbilityTrait.AbilitySlot.PRIMARY, tag.getInt(string)));
            });
            this.changed = true;
        }
    }

    public void setCooldowns(List<AbilityTraitCooldown> cooldowns) {
        this.cooldowns = cooldowns;
    }




    public SpeciesAttachment withSpeciesKey(ResourceKey<Species> speciesKey) {
        this.speciesKey = speciesKey;
        this.changed = true;
        return this;
    }

    public SpeciesAttachment withCooldowns(List<AbilityTraitCooldown> cooldowns) {
        this.cooldowns = cooldowns;
        return this;
    }



    public void setSpeciesKey(ResourceKey<Species> speciesKey) {
        this.speciesKey = speciesKey;
        this.changed = true;
    }



    public List<AbilityTraitCooldown> getCooldowns() {
        return cooldowns;
    }

    public ResourceKey<Species> getSpeciesKey() {
        return speciesKey;
    }
}
