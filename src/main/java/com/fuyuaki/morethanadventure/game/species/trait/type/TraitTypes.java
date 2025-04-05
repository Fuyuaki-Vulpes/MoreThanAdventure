package com.fuyuaki.morethanadventure.game.species.trait.type;

import com.fuyuaki.morethanadventure.core.registry.MTARegistries;
import com.fuyuaki.morethanadventure.game.species.trait.Trait;
import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import net.minecraft.advancements.CriterionTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class TraitTypes {
    public static final Codec<TraitType> CODEC = MTARegistries.Registries.TRAIT_TYPE.byNameCodec();
    public static final StreamCodec<RegistryFriendlyByteBuf,TraitType> STREAM_CODEC = ByteBufCodecs.fromCodecWithRegistriesTrusted(CODEC);

    public static final DeferredRegister<TraitType> TRAIT_REGISTRY =
            DeferredRegister.create(MTARegistries.Registries.TRAIT_TYPE,MODID);



    public static final Supplier<TraitType> EMPTY = TRAIT_REGISTRY.register("empty", TraitType::new);

    public static void register(IEventBus eventBus){
        TRAIT_REGISTRY.register(eventBus);

    }
}
