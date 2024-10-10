package com.fuyuaki.morethanadventure.core.registry;

import com.fuyuaki.morethanadventure.world.mob_effect.BerserkEffect;
import com.fuyuaki.morethanadventure.world.mob_effect.FreezingEffect;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import dev.shadowsoffire.apothic_attributes.mob_effect.BleedingEffect;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MtaEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, MODID);

    public static final DeferredHolder<MobEffect, MobEffect> FREEZING = MOB_EFFECTS.register("freezing", () -> new FreezingEffect().addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(MODID,"effect.frost_slow"), -0.05F,AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final DeferredHolder<MobEffect, MobEffect> BERSERK = MOB_EFFECTS.register("berserk",
            () -> new BerserkEffect()
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(MODID,"effect.berserk_a"), 0.3F,AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(MODID,"effect.berserk_b"), 0.3F,AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(MODID,"effect.berserk_c"), 1.0F,AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(ALObjects.Attributes.ARMOR_SHRED, ResourceLocation.fromNamespaceAndPath(MODID,"effect.berserk_d"), 0.5F,AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(ALObjects.Attributes.LIFE_STEAL, ResourceLocation.fromNamespaceAndPath(MODID,"effect.berserk_e"), 2.0F,AttributeModifier.Operation.ADD_VALUE)
    );

    public static final DeferredHolder<MobEffect, MobEffect> CHARGING = MOB_EFFECTS.register("charging", () ->
             new MobEffect(MobEffectCategory.NEUTRAL,0x93eee0)
                     .addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE,ResourceLocation.fromNamespaceAndPath(MODID,"effect.charging_knockback"), 1.0F,AttributeModifier.Operation.ADD_VALUE)
                     .addAttributeModifier(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE,ResourceLocation.fromNamespaceAndPath(MODID,"effect.charging_explosion"), 1.0F,AttributeModifier.Operation.ADD_VALUE));


    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
