package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.world.mob_effect.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MtaEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS = DeferredRegister.create(Registries.MOB_EFFECT, MODID);

    public static final DeferredHolder<MobEffect, MobEffect> FREEZING = MOB_EFFECTS.register("freezing", () -> new FreezingEffect().addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(MODID,"effect.frost_slow"), -0.05F,AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

    public static final DeferredHolder<MobEffect, MobEffect> STUN = MOB_EFFECTS.register("stun", () -> new StunEffect()
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(MODID,"effect.stun.slow"), -5.0F,AttributeModifier.Operation.ADD_VALUE)
            .addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(MODID,"effect.stun.damage"), 0.0F,AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static final DeferredHolder<MobEffect, MobEffect> BLEEDING = MOB_EFFECTS.register("bleeding", () -> new BleedingEffect()
            .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(MODID,"effect.bleed.slow"), -0.10F,AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(Attributes.BLOCK_BREAK_SPEED, ResourceLocation.fromNamespaceAndPath(MODID,"effect.bleed.fatigue"), -0.10F,AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
            .addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(MODID,"effect.bleed.weakness"), -0.10F,AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );


    public static final DeferredHolder<MobEffect, MobEffect> BERSERK = MOB_EFFECTS.register("berserk",
            () -> new BerserkEffect()
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED, ResourceLocation.fromNamespaceAndPath(MODID,"effect.berserk_a"), 0.3F,AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(MODID,"effect.berserk_b"), 0.3F,AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(MODID,"effect.berserk_c"), 1.0F,AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)

    );


    public static final DeferredHolder<MobEffect, MobEffect> TWO_HANDED_BLOCK = MOB_EFFECTS.register("two_handed_block",
            () -> new MobEffect(MobEffectCategory.HARMFUL,0xff2929)
                    .addAttributeModifier(Attributes.ATTACK_KNOCKBACK, ResourceLocation.fromNamespaceAndPath(MODID,"effect.two_handed.knockback"), -2.0F,AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(Attributes.ATTACK_SPEED, ResourceLocation.fromNamespaceAndPath(MODID,"effect.two_handed.speed"), -20.0F,AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE, ResourceLocation.fromNamespaceAndPath(MODID,"effect.two_handed.damage"), -50.0F,AttributeModifier.Operation.ADD_VALUE)
                    .withSoundOnAdded(SoundEvents.ARMOR_EQUIP_GENERIC.value())
                    .setBlendDuration(0)
    );

    public static final DeferredHolder<MobEffect, MobEffect> CHARGING = MOB_EFFECTS.register("charging", () ->
             new MobEffect(MobEffectCategory.NEUTRAL,0x93eee0)
                     .addAttributeModifier(Attributes.KNOCKBACK_RESISTANCE,ResourceLocation.fromNamespaceAndPath(MODID,"effect.charging_knockback"), 1.0F,AttributeModifier.Operation.ADD_VALUE)
                     .addAttributeModifier(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE,ResourceLocation.fromNamespaceAndPath(MODID,"effect.charging_explosion"), 1.0F,AttributeModifier.Operation.ADD_VALUE));

    public static final DeferredHolder<MobEffect, MobEffect> VENOM = MOB_EFFECTS.register("venom", () ->
            new VenomEffect().withSoundOnAdded(SoundEvents.VILLAGER_WORK_CLERIC));

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}
