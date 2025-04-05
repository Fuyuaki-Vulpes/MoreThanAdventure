package com.fuyuaki.morethanadventure.game.species.trait;

import com.fuyuaki.morethanadventure.game.species.Species;
import com.fuyuaki.morethanadventure.game.species.SpeciesHolder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public record TraitHolder(Trait definition, ResourceLocation location){
    public static final StreamCodec<RegistryFriendlyByteBuf, TraitHolder> STREAM_CODEC = StreamCodec.composite(
            Trait.STREAM_CODEC, TraitHolder::definition, ResourceLocation.STREAM_CODEC, TraitHolder::location,TraitHolder::new
    );

    public Trait definition() {
        return definition;
    }



    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else {
            if (other instanceof TraitHolder traitHolder && this.definition.equals(traitHolder.definition)) {
                return true;
            }

            return false;
        }
    }

    public void tickTraits(Player player){
        this.definition.tick(player,player.level());
    }


}
