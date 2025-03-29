package com.fuyuaki.morethanadventure.game.species;

import com.fuyuaki.morethanadventure.game.species.trait.Trait;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.List;

public record Species(ResourceLocation icon, ResourceLocation id, float playerSize, List<AttributeModifierType> modifiers, List<Trait> traits) {

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else {
            if (other instanceof Species species && this.id.equals(species.id)) {
                return true;
            }

            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return this.id.toString();
    }



    public record AttributeModifierType(Holder<Attribute> attribute, AttributeModifier modifier) {
        public static final Codec<AttributeModifierType> CODEC = RecordCodecBuilder.create(
                p_348388_ -> p_348388_.group(
                                Attribute.CODEC.fieldOf("type").forGetter(AttributeModifierType::attribute),
                                AttributeModifier.MAP_CODEC.forGetter(AttributeModifierType::modifier)
                        )
                        .apply(p_348388_, AttributeModifierType::new)
        );
        public static final StreamCodec<RegistryFriendlyByteBuf, AttributeModifierType> STREAM_CODEC = StreamCodec.composite(
                Attribute.STREAM_CODEC,
                AttributeModifierType::attribute,
                AttributeModifier.STREAM_CODEC,
                AttributeModifierType::modifier,
                AttributeModifierType::new
        );

        public boolean matches(Holder<Attribute> attribute, ResourceLocation id) {
            return attribute.equals(this.attribute) && this.modifier.is(id);
        }
    }


}
