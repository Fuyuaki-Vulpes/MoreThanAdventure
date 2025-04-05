package com.fuyuaki.morethanadventure.game.species.trait;

import com.fuyuaki.morethanadventure.core.registry.MTARegistries;
import com.fuyuaki.morethanadventure.game.species.Species;
import com.fuyuaki.morethanadventure.game.species.trait.type.TraitType;
import com.fuyuaki.morethanadventure.game.species.trait.type.TraitTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.advancements.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public record Trait(ResourceLocation id, ResourceLocation icon, TraitType type, Component name, Component description) {
    public static final Codec<Trait> CODEC = RecordCodecBuilder.<Trait>create(
            instance -> instance.group(
                    ResourceLocation.CODEC.fieldOf("id").forGetter(Trait::id),
                    ResourceLocation.CODEC.fieldOf("icon").forGetter(Trait::icon),
                    TraitTypes.CODEC.fieldOf("type").forGetter(Trait::type),
                    ComponentSerialization.CODEC.fieldOf("name").forGetter(Trait::name),
                    ComponentSerialization.CODEC.fieldOf("description").forGetter(Trait::description)

            ).apply(instance,Trait::new)
    );
    public static final StreamCodec<RegistryFriendlyByteBuf, Trait> STREAM_CODEC = StreamCodec.ofMember(
            Trait::write, Trait::read
    );

    private void write(RegistryFriendlyByteBuf byteBuf) {
        byteBuf.writeResourceLocation(this.id);
        byteBuf.writeResourceLocation(this.icon);
        TraitTypes.STREAM_CODEC.encode(byteBuf,this.type);
        ComponentSerialization.TRUSTED_STREAM_CODEC.encode(byteBuf, this.name);
        ComponentSerialization.TRUSTED_STREAM_CODEC.encode(byteBuf, this.description);

    }

    private static Trait read(RegistryFriendlyByteBuf byteBuf) {
        return new Trait(
                byteBuf.readResourceLocation(),
                byteBuf.readResourceLocation(),
                TraitTypes.STREAM_CODEC.decode(byteBuf),
                ComponentSerialization.TRUSTED_STREAM_CODEC.decode(byteBuf),
                ComponentSerialization.TRUSTED_STREAM_CODEC.decode(byteBuf)

        );
    }

    private static <T extends CriterionTriggerInstance> Codec<Criterion<T>> criterionCodec(CriterionTrigger<T> trigger) {
        return trigger.codec().xmap(p_312166_ -> new Criterion<>(trigger, (T)p_312166_), Criterion::triggerInstance);
    }

    public void tick(Player player, Level level){

    }



    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else {
            if (other instanceof Trait trait && this.id.equals(trait.id)) {
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
}
