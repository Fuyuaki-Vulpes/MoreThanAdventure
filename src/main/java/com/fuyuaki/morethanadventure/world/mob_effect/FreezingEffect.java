package com.fuyuaki.morethanadventure.world.mob_effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FreezingEffect extends MobEffect {
    public FreezingEffect() {
        super(MobEffectCategory.HARMFUL, 0xCEEAED);
    }


    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.getTicksFrozen() < 200){
            entity.setTicksFrozen(entity.getTicksFrozen() + 10 + (10 * amplifier));
        }

        if (entity.getRandom().nextBoolean()) {
            entity.level().addParticle(
                    ParticleTypes.SNOWFLAKE,
                    entity.getX(),
                    (double) (entity.getY(0.75)),
                    entity.getZ(),
                    (double) (Mth.randomBetween(entity.getRandom(), -1.0F, 1.0F) * 0.083333336F),
                    0.05F,
                    (double) (Mth.randomBetween(entity.getRandom(), -1.0F, 1.0F) * 0.083333336F)
            );
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
