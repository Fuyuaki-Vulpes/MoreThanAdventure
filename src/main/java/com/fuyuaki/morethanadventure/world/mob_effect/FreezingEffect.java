package com.fuyuaki.morethanadventure.world.mob_effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FreezingEffect extends MobEffect {
    public FreezingEffect() {
        super(MobEffectCategory.HARMFUL, 0xCEEAED);
    }


    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        if (entity.getTicksFrozen() < 200){
            entity.setTicksFrozen(entity.getTicksFrozen() + 10 + (10 * amplifier));
        }

        if (entity.getRandom().nextBoolean()) {
            entity.level().addParticle(
                    ParticleTypes.SNOWFLAKE,
                    entity.getX() + (Mth.randomBetween(entity.getRandom(), -0.2F, 0.2F)),
                    (double) (entity.getY( + (Mth.randomBetween(entity.getRandom(), 0.3F, 0.8F)))),
                    entity.getZ() + (Mth.randomBetween(entity.getRandom(), -0.2F, 0.2F)) ,
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
