package com.fuyuaki.morethanadventure.game.species;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;

import java.util.List;

public record SpeciesHolder (Species value, ResourceLocation id){

    public static final StreamCodec<RegistryFriendlyByteBuf, SpeciesHolder> STREAM_CODEC = StreamCodec.composite(
            Species.STREAM_CODEC, SpeciesHolder::value, ResourceLocation.STREAM_CODEC, SpeciesHolder::id, SpeciesHolder::new
    );
    public static final StreamCodec<RegistryFriendlyByteBuf, List<SpeciesHolder>> LIST_STREAM_CODEC = STREAM_CODEC.apply(ByteBufCodecs.list());



    public Species value() {
        return value;
    }



    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else {
            if (other instanceof SpeciesHolder speciesHolder && this.value.equals(speciesHolder.value)) {
                return true;
            }

            return false;
        }
    }


    @Override
    public String toString() {
        return this.id().toString();
    }
}
