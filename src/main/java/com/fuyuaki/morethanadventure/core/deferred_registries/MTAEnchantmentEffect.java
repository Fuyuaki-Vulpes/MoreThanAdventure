package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.world.item.enchantment.DisarmEnchantmentEffect;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTAEnchantmentEffect {
    public static final DeferredRegister<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_ECHANTMENT_EFFECTS =
            DeferredRegister.create(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, MODID);

public static final Supplier<MapCodec<? extends EnchantmentEntityEffect>> DISARM = registerEnchantmentEffect("disarm", DisarmEnchantmentEffect.CODEC);

private static Supplier<MapCodec<? extends EnchantmentEntityEffect>> registerEnchantmentEffect(String name, MapCodec<? extends  EnchantmentEntityEffect> codec){
    return ENTITY_ECHANTMENT_EFFECTS.register(name, () -> codec);
}

    public static void register(IEventBus eventBus){
        ENTITY_ECHANTMENT_EFFECTS.register(eventBus);
    }
}
