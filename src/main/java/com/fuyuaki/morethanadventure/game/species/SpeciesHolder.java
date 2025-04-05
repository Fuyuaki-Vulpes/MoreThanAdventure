package com.fuyuaki.morethanadventure.game.species;

import com.fuyuaki.morethanadventure.game.species.trait.Trait;
import net.minecraft.advancements.Advancement;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public record SpeciesHolder (Species definition, ResourceLocation location){

    public static final StreamCodec<RegistryFriendlyByteBuf, SpeciesHolder> STREAM_CODEC = StreamCodec.composite(
            Species.STREAM_CODEC, SpeciesHolder::definition, ResourceLocation.STREAM_CODEC, SpeciesHolder::location, SpeciesHolder::new
    );
    public static final StreamCodec<RegistryFriendlyByteBuf, List<SpeciesHolder>> LIST_STREAM_CODEC = STREAM_CODEC.apply(ByteBufCodecs.list());



    public Species definition() {
        return definition;
    }



    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else {
            if (other instanceof SpeciesHolder speciesHolder && this.definition.equals(speciesHolder.definition)) {
                return true;
            }

            return false;
        }
    }

    public void tickTraits(Player player){
        this.definition.traits().forEach(trait -> {
            trait.tick(player,player.level());
        });
    }

    public boolean hasTrait(Trait trait){
        return this.definition.traits().contains(trait);
    }

    public List<Trait> getTraits(){
        return this.definition.traits();
    }

    public List<Species.AttributeModifierType> getAttributeModifiers(){
        return this.definition.modifiers();
    }


    @Override
    public String toString() {
        return this.definition.id().toString();
    }
}
