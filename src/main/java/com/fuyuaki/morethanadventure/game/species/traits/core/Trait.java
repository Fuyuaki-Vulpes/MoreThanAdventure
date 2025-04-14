package com.fuyuaki.morethanadventure.game.species.traits.core;

import com.fuyuaki.morethanadventure.core.deferred_registries.MTATraits;
import com.fuyuaki.morethanadventure.core.registry.MTARegistries;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.entity.player.Player;

public class Trait {
    public static final Codec<Trait> CODEC = MTARegistries.Registries.TRAITS.byNameCodec();
    public static final StreamCodec<RegistryFriendlyByteBuf, Trait> STREAM_CODEC = ByteBufCodecs.fromCodecWithRegistriesTrusted(CODEC);
    public final Component description;

    private final Holder<Trait> builtInRegistryHolder = MTARegistries.Registries.TRAITS.wrapAsHolder(this);



    public static final Codec<Holder<Trait>> HOLDER_CODEC = MTARegistries.Registries.TRAITS
            .holderByNameCodec()
            .validate(
                    p_381630_ -> p_381630_.is(MTATraits.EMPTY.get().builtInRegistryHolder().getKey())
                            ? DataResult.error(() -> "Item must not be morethanadventure:empty")
                            : DataResult.success(p_381630_)
            );
    private final boolean hidden;


    public Trait(Component description, boolean hidden) {
        this.description = description;
        this.hidden = hidden;
    }


    public Component getDescription() {
        return description;
    }

    public boolean active(Player player){
        return true;
    }

    public Holder<Trait> builtInRegistryHolder() {
        return this.builtInRegistryHolder;
    }



}
