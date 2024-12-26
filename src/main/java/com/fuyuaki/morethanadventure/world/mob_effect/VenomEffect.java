package com.fuyuaki.morethanadventure.world.mob_effect;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class VenomEffect extends MobEffect {
    public VenomEffect() {
        super(MobEffectCategory.HARMFUL, 0x4b990e);
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity living, int amplifier) {

        var dTypeReg = living.damageSources().damageTypes;
        var dType = dTypeReg.get(net.neoforged.neoforge.common.NeoForgeMod.POISON_DAMAGE).orElse(dTypeReg.get(net.minecraft.world.damagesource.DamageTypes.MAGIC).get());
        living.hurt(new net.minecraft.world.damagesource.DamageSource(dType), 2.0F);
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        int i = 25 - (amplifier * 2);
        return i > 0 ? duration % i == 0 : true;
    }
}
