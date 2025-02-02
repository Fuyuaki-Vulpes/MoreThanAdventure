package com.fuyuaki.morethanadventure.core.deferred_registries;

import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTAEnchantmentEffectsComponents {
    public static final DeferredRegister.DataComponents ENCHANT_COMPONENTS = DeferredRegister.createDataComponents(Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE,MODID);

    //public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<ConditionalEffect<PullingComponent>>>> PULLING = ENCHANT_COMPONENTS.registerComponentType(
    //        "pulling", data -> data
    //                .persistent(ConditionalEffect.codec(PullingComponent.CODEC, LootContextParamSets.ENCHANTED_ENTITY).listOf())
    //);

    public static void register(IEventBus eventBus){
        ENCHANT_COMPONENTS.register(eventBus);
    }
}
