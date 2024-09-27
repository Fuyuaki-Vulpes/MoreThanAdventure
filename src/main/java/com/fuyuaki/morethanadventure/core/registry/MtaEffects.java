package com.fuyuaki.morethanadventure.core.registry;

import com.fuyuaki.morethanadventure.world.mob_effect.FreezingEffect;
import dev.shadowsoffire.apothic_attributes.mob_effect.BleedingEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MtaEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, MODID);

    public static final DeferredHolder<MobEffect, MobEffect> FREEZING = MOB_EFFECTS.register("freezing", () -> new FreezingEffect().addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(MODID,"effect.frost_slow"), -0.05F,AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));


    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
