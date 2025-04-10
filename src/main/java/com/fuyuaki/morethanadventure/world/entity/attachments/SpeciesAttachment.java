package com.fuyuaki.morethanadventure.world.entity.attachments;

import com.fuyuaki.morethanadventure.core.deferred_registries.MTAAttachments;
import com.fuyuaki.morethanadventure.core.mod.MTAMod;
import com.fuyuaki.morethanadventure.core.registry.MTARegistries;
import com.fuyuaki.morethanadventure.game.species.Species;
import com.fuyuaki.morethanadventure.game.species.traits.AbilityTrait;
import com.fuyuaki.morethanadventure.game.species.traits.TickingTrait;
import com.fuyuaki.morethanadventure.world.entity.attachments.helper.AbilityTraitCooldown;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.UnknownNullability;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class SpeciesAttachment implements INBTSerializable<CompoundTag> {

    private ResourceKey<Species> speciesKey;
    private Optional<ResourceKey<Species>> speciesO;
    int level;
    int experience;
    List<AbilityTraitCooldown> cooldowns;

    public SpeciesAttachment(ResourceKey<Species> speciesKey, int level, int experience){
        this();
        this.speciesKey = speciesKey;
        this.speciesO = Optional.of(speciesKey);
        this.level = level;
        this.experience = experience;
        this.cooldowns = new ArrayList<>();
    }

    public SpeciesAttachment(){
        this.speciesKey = ResourceKey.create(MTARegistries.Keys.SPECIES, ResourceLocation.fromNamespaceAndPath(MODID, "human"));
        this.speciesO = Optional.of(this.speciesKey);
        this.level = 0;
        this.experience = 0;
        this.cooldowns = new ArrayList<>();
    }


    public void updatePlayer(Player player){
        Species species = Species.getSpeciesFromKey(speciesKey);
        this.speciesO = Optional.of(this.speciesKey);
    }


    public void changeSpecies(ResourceKey<Species> key){
        this.speciesKey = key;
    }

    public void tick(Player player){
        Species species = Species.getSpeciesFromKey(speciesKey);
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
        CompoundTag nbt = new CompoundTag();

        this.speciesKey = MTAMod.loadResourceKey(MTARegistries.Keys.SPECIES,"species",nbt);
        this.speciesO = Optional.of(MTAMod.loadResourceKey(MTARegistries.Keys.SPECIES,"species_old",nbt));

        this.level = nbt.getInt("level");
        this.experience = nbt.getInt("exp");
        CompoundTag tag = nbt.getCompound("cooldowns");
        tag.getAllKeys().forEach(string -> {
            if (AbilityTrait.AbilitySlot.PRIMARY.getId().equals(string))
                this.cooldowns.add(new AbilityTraitCooldown(AbilityTrait.AbilitySlot.PRIMARY, tag.getInt(string)));
        });

        return tag;
    }
    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag tag) {
        MTAMod.saveResourceKey("species",this.speciesKey,tag);
        speciesO.ifPresent(key -> MTAMod.saveResourceKey("species_old", key, tag));
        tag.putInt("level", this.level);
        tag.putInt("exp",this.experience);
        CompoundTag cooldownList = new CompoundTag();
        this.cooldowns.forEach(cooldown -> cooldownList.putInt(cooldown.slot().name(),cooldown.time()));
        tag.put("cooldowns",cooldownList);


    }

    public void setCooldowns(List<AbilityTraitCooldown> cooldowns) {
        this.cooldowns = cooldowns;
    }

    public SpeciesAttachment withExperience(int experience) {
        this.experience = experience;
        return this;
    }

    public SpeciesAttachment withLevel(int level) {
        this.level = level;
        return this;
    }


    public SpeciesAttachment withSpeciesKey(ResourceKey<Species> speciesKey) {
        this.speciesKey = speciesKey;
        return this;
    }

    public SpeciesAttachment withCooldowns(List<AbilityTraitCooldown> cooldowns) {
        this.cooldowns = cooldowns;
        return this;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setSpeciesKey(ResourceKey<Species> speciesKey) {
        this.speciesKey = speciesKey;
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }

    public List<AbilityTraitCooldown> getCooldowns() {
        return cooldowns;
    }

    public ResourceKey<Species> getSpeciesKey() {
        return speciesKey;
    }
}
