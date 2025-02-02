package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.world.item.enchantment.PullingEnchantmentEffect;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.enchantment.TargetedConditionalEffect;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTAEnchantmentEffectsComponents {
    public static final DeferredRegister.DataComponents ENCHANT_COMPONENTS = DeferredRegister.createDataComponents(Registries.ENCHANTMENT_EFFECT_COMPONENT_TYPE,MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<List<TargetedConditionalEffect<PullingEnchantmentEffect>>>> PULLING = ENCHANT_COMPONENTS.registerComponentType(
            "pulling", data -> data
                    .persistent(TargetedConditionalEffect.codec(PullingEnchantmentEffect.MAP_CODEC.codec(), LootContextParamSets.ENCHANTED_ENTITY).listOf())
    );

    public static void register(IEventBus eventBus){
        ENCHANT_COMPONENTS.register(eventBus);
    }
}
