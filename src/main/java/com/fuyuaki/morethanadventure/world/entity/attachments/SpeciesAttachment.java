package com.fuyuaki.morethanadventure.world.entity.attachments;

import com.fuyuaki.morethanadventure.core.registry.MTARegistries;
import com.fuyuaki.morethanadventure.game.species.Species;
import com.fuyuaki.morethanadventure.game.species.traits.TickingTrait;
import com.fuyuaki.morethanadventure.world.entity.attachments.helper.AbilityTraitCooldown;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.UnknownNullability;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class SpeciesAttachment implements INBTSerializable<CompoundTag> {

    private ResourceKey<Species> speciesKey = ResourceKey.create(MTARegistries.Keys.SPECIES, ResourceLocation.fromNamespaceAndPath(MODID, "human"));
    private Optional<Species> speciesO = Optional.empty();
    int level = 0;
    float experience = 0;
    List<AbilityTraitCooldown> cooldowns = new ArrayList<>();


    public void updatePlayer(Player player){
        Species species = Species.getSpeciesFromKey(speciesKey, player.registryAccess());
        if (speciesO.isPresent()){

        }
    }

    public void tick(Player player){
        Species species = Species.getSpeciesFromKey(speciesKey, player.registryAccess());
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
        tag.putString("key",this.speciesKey.toString());
        if (speciesO.isPresent()) tag.putString("keyOld",this.speciesO.get().getNameKey());
        tag.putInt("level", this.level);
        tag.putFloat("exp",this.experience);

        return tag;
    }
    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag nbt) {

    }
}
