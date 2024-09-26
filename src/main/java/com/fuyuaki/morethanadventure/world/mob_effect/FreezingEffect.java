package com.fuyuaki.morethanadventure.world.mob_effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class FreezingEffect extends MobEffect {
    public FreezingEffect() {
        super(MobEffectCategory.HARMFUL, 0xCEEAED, ParticleTypes.SNOWFLAKE);
    }


    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (entity.getTicksFrozen() < 200){
            entity.setTicksFrozen(entity.getTicksFrozen() + (10 * amplifier));
        }
        return true;
    }

}
