package com.fuyuaki.morethanadventure.world.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class MtaFoods {
    public static final FoodProperties ONION = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.6F)
            .build();
    public static final FoodProperties SHRIMP = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.3F)
            .build();
    public static final FoodProperties COOKED_SHRIMP = new FoodProperties.Builder()
            .nutrition(5)
            .saturationModifier(1.6F)
            .build();
    public static final FoodProperties TOMATO = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.3F)
            .build();
    public static final FoodProperties BELL_PEPPER = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.5F)
            .build();
    public static final FoodProperties CHILI_PEPPER = new FoodProperties.Builder()
            .nutrition(1)
            .saturationModifier(1.0F)
            .build();

    public static final FoodProperties ONIGIRI = new FoodProperties.Builder()
            .nutrition(7)
            .saturationModifier(1.3F)
            .build();
    public static final FoodProperties COCONUT_SLICE = new FoodProperties.Builder()
            .nutrition(2)
            .saturationModifier(0.5F)
            .build();
    public static final FoodProperties COCONUT_MILK = new FoodProperties.Builder()
            .nutrition(3)
            .saturationModifier(0.6F)
            .build();
    public static final FoodProperties SWEET_BEEF_CURRY = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(1.3F)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 1), 1.0F)
            .build();
    public static final FoodProperties SWEET_PORK_CURRY = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(1.3F)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 1), 1.0F)
            .build();
    public static final FoodProperties SWEET_CHICKEN_CURRY = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(1.3F)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 1), 1.0F)
            .build();
    public static final FoodProperties SWEET_SHRIMP_CURRY = new FoodProperties.Builder()
            .nutrition(7)
            .saturationModifier(1.3F)
            .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 1), 1.0F)
            .build();
    public static final FoodProperties MILD_BEEF_CURRY = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(1.3F)
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 1), 1.0F)
            .build();
     public static final FoodProperties MILD_PORK_CURRY = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(1.3F)
             .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 1), 1.0F)
             .build();
     public static final FoodProperties MILD_CHICKEN_CURRY = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(1.3F)
             .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 1), 1.0F)
             .build();
     public static final FoodProperties MILD_SHRIMP_CURRY = new FoodProperties.Builder()
            .nutrition(7)
            .saturationModifier(1.3F)
             .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 1), 1.0F)
            .build();
     public static final FoodProperties SPICY_BEEF_CURRY = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(1.3F)
             .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 1), 1.0F)
            .build();
     public static final FoodProperties SPICY_PORK_CURRY = new FoodProperties.Builder()
            .nutrition(10)
            .saturationModifier(1.3F)
             .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 1), 1.0F)
            .build();
     public static final FoodProperties SPICY_CHICKEN_CURRY = new FoodProperties.Builder()
            .nutrition(8)
            .saturationModifier(1.3F)
             .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 1), 1.0F)
            .build();
     public static final FoodProperties SPICY_SHRIMP_CURRY = new FoodProperties.Builder()
            .nutrition(7)
            .saturationModifier(1.3F)
             .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 1), 1.0F)
            .build();

}
