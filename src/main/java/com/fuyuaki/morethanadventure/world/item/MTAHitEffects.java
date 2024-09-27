package com.fuyuaki.morethanadventure.world.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;

import java.util.Objects;

public class MTASwordHitEffects extends SwordItem {

    public final MobEffect effect;
    public final float chance;



    public MTASwordHitEffects(Tier tier, Properties properties, MobEffect effect, float chance) {
        super(tier, properties);
        this.effect = effect;
        this.chance = chance;
    }



    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        pStack.hurtAndBreak(1, pAttacker, );
        if (effect != null && pAttacker.level().random.nextFloat() < chance * 2) {
            pTarget.addEffect(new MobEffectInstance(effect,40,0,false,false));
        }
        return true;
    }
}
