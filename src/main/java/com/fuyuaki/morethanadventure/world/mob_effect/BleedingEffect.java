package com.fuyuaki.morethanadventure.world.mob_effect;

import com.fuyuaki.morethanadventure.core.registry.MTADamageTypes;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaParticles;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

public class BleedingEffect extends MobEffect {
    public BleedingEffect() {
        super(MobEffectCategory.HARMFUL, 0xc62236);
    }

    @Override
    public ParticleOptions createParticleOptions(MobEffectInstance effect) {
        return MtaParticles.BLOOD.get();
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity livingEntity, int amplifier) {
        livingEntity.hurt(livingEntity.damageSources().source(MTADamageTypes.BLEEDING),2.0F + amplifier * 2);

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        int i = 25 - (amplifier * 2);
        return i > 0 ? duration % i == 0 : true;
    }
}
