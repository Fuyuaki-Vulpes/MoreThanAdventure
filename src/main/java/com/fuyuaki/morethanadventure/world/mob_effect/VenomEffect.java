package com.fuyuaki.morethanadventure.world.mob_effect;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class VenomEffect extends MobEffect {
    public VenomEffect() {
        super(MobEffectCategory.HARMFUL, 0x4b990e);
    }

    @Override
    public boolean applyEffectTick(LivingEntity p_296276_, int p_296233_) {
        var dTypeReg = p_296276_.damageSources().damageTypes;
        var dType = dTypeReg.get(net.neoforged.neoforge.common.NeoForgeMod.POISON_DAMAGE).orElse(dTypeReg.get(net.minecraft.world.damagesource.DamageTypes.MAGIC).get());
        p_296276_.hurt(new net.minecraft.world.damagesource.DamageSource(dType), 2.0F);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        int i = 25 - (amplifier * 2);
        return i > 0 ? duration % i == 0 : true;
    }
}
