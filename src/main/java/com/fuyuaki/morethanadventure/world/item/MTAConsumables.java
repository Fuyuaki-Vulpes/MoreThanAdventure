package com.fuyuaki.morethanadventure.world.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;

import static net.minecraft.world.item.component.Consumables.defaultFood;

public class MTAConsumables {
    public static final Consumable SWEET_CURRY = defaultFood()
            .onConsume(
                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 1), 1.0F)
                    )
            .build();
    public static final Consumable MILD_CURRY = defaultFood()
            .onConsume(
                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 1), 1.0F)
                    )
            .build();
    public static final Consumable SPICY_CURRY = defaultFood()
            .onConsume(
                    new ApplyStatusEffectsConsumeEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 1), 1.0F)
                    )
            .build();


}
