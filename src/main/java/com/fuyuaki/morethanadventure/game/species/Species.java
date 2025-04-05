package com.fuyuaki.morethanadventure.game.species;

import com.fuyuaki.morethanadventure.game.species.trait.Trait;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public record Species(ResourceLocation icon, ResourceLocation id, float playerSize, List<AttributeModifierType> modifiers, List<Trait> traits) {
    public static final Codec<Species> CODEC = RecordCodecBuilder.<Species>create(
                    instance -> instance.group(
                                    ResourceLocation.CODEC.fieldOf("icon").forGetter(Species::icon),
                                    ResourceLocation.CODEC.fieldOf("id").forGetter(Species::id),
                                    Codec.FLOAT.fieldOf("player_size").forGetter(Species::playerSize),
                                AttributeModifierType.CODEC.listOf().fieldOf("modifiers").forGetter(Species::modifiers),
                                Trait.CODEC.listOf().fieldOf("modifiers").forGetter(Species::traits)
                            )
                            .apply(instance,Species::new)
            );

    public static final StreamCodec<RegistryFriendlyByteBuf, Species> STREAM_CODEC = StreamCodec.composite(
            ResourceLocation.STREAM_CODEC,
            Species::icon,
            ResourceLocation.STREAM_CODEC,
            Species::id,
            ByteBufCodecs.FLOAT,
            Species::playerSize,
            AttributeModifierType.STREAM_CODEC.apply(ByteBufCodecs.list()),
            Species::modifiers,
            Trait.STREAM_CODEC.apply(ByteBufCodecs.list()),
            Species::traits,
            Species::new
    );



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

    public void validate(ProblemReporter.Collector problemreporter$collector, HolderLookup.Provider registries) {

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
