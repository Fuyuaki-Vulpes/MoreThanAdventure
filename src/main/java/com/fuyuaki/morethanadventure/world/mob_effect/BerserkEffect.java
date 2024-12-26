package com.fuyuaki.morethanadventure.world.mob_effect;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEffects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

import java.util.Objects;

public class BerserkEffect extends MobEffect {
    public BerserkEffect() {
        super(MobEffectCategory.BENEFICIAL, 16733525, ParticleTypes.TRIAL_OMEN);
    }

    @Override
    public boolean applyEffectTick(ServerLevel p_376587_, LivingEntity livingEntity, int amplifier) {
        if (amplifier > 0 && Objects.requireNonNull(livingEntity.getEffect(MtaEffects.BERSERK)).getDuration() < 5){
            livingEntity.forceAddEffect(new MobEffectInstance(MtaEffects.BERSERK, 60, amplifier - 1),livingEntity);
        }

        return super.applyEffectTick(p_376587_, livingEntity, amplifier);
    }



    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
