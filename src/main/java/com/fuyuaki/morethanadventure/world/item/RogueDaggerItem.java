package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.world.item.weaponry.DaggerItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class RogueDaggerItem extends DaggerItem {


    public RogueDaggerItem(ToolMaterial pTier, Properties pProperties) {
        super(pTier, pProperties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));

    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 72000;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        player.startUsingItem(usedHand);
        return InteractionResult.CONSUME;
    }

    @Override
    public boolean releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeCharged) {
        if (livingEntity instanceof Player player){
        int i = this.getUseDuration(stack, livingEntity) - timeCharged;
        if (i > 10) i = 10;
        float p = ((float) i )/ 10;
        Vec3 pushVec = livingEntity.getViewVector(1).scale(3.0);
        livingEntity.push(pushVec.scale(p));
        player.getCooldowns().addCooldown(stack,100);
        player.playSound(SoundEvents.BREEZE_WIND_CHARGE_BURST.value(),0.5F,1.5F);
        player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY,10));
        level.addParticle(ParticleTypes.GUST,player.getX(),player.getY(),player.getZ(),0,0,0);
        player.setIgnoreFallDamageFromCurrentImpulse(true);
        }

        super.releaseUsing(stack, level, livingEntity, timeCharged);
        return true;
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {

        double d0 = (double)(-Mth.sin(pAttacker.getYRot() * (float) (Math.PI / 180.0)));
        double d1 = (double)Mth.cos(pAttacker.getYRot() * (float) (Math.PI / 180.0));
        if (pAttacker.level() instanceof ServerLevel) {
            ((ServerLevel)pAttacker.level()).sendParticles(ParticleTypes.SWEEP_ATTACK, pAttacker.getX() + d0, pAttacker.getY(0.5), pAttacker.getZ() + d1, 0, d0, 0.0, d1, 0.0);
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

}

