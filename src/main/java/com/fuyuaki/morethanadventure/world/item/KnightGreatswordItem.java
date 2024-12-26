package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEffects;
import com.fuyuaki.morethanadventure.world.item.weaponry.ClaymoreItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;

import java.util.List;

public class KnightGreatswordItem extends ClaymoreItem {



    public KnightGreatswordItem(ToolMaterial pTier, Properties pProperties) {
        super(pTier, pProperties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));

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

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 72000;
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        if (usedHand.equals(InteractionHand.OFF_HAND)) return InteractionResult.FAIL;

        player.startUsingItem(usedHand);
        return InteractionResult.SUCCESS;
    }

    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack stack, int remainingUseDuration) {
        if (remainingUseDuration % 20 == 0) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN,40,10));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,40,10));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,30,5));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,30));
            livingEntity.addEffect(new MobEffectInstance(MtaEffects.CHARGING,30));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING,30));
            livingEntity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING,40,2));
            stack.hurtAndBreak(1,livingEntity, EquipmentSlot.MAINHAND);

        }if (remainingUseDuration % 80L == 0) {
            livingEntity.playSound(SoundEvents.BEACON_AMBIENT,0.5F,2.0F);

        }
        if (!level.getBlockState(livingEntity.getOnPos().below()).isAir()){
            livingEntity.addEffect(new MobEffectInstance(MobEffects.LEVITATION,10));
        }
        super.onUseTick(level, livingEntity, stack, remainingUseDuration);
    }

    @Override
    public boolean releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeCharged) {
        livingEntity.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP);
        livingEntity.playSound(SoundEvents.WARDEN_SONIC_BOOM);
        List<LivingEntity> list = level.getEntitiesOfClass(LivingEntity.class,livingEntity.getBoundingBox().inflate(3,2,3));
        list.removeIf(livingEntity::isAlliedTo);
        list.removeIf(living -> living.is(livingEntity));
        list.forEach(entity -> {
                    entity.hurt(livingEntity.damageSources().magic(), 50F * (float) (Math.min(timeCharged, 200) / 200));
                    entity.push(entity.getEyePosition().subtract(livingEntity.position()).scale(2.0F).add(0,1.0F,0));
                    entity.addEffect(new MobEffectInstance(MobEffects.GLOWING,1000));
                    stack.hurtAndBreak(-1,livingEntity,EquipmentSlot.MAINHAND);
                }
        );
        if (livingEntity.hasEffect(MobEffects.LEVITATION)){
            livingEntity.removeEffect(MobEffects.LEVITATION);
        }
        return true;

    }

    public static ItemAttributeModifiers createAttributes(ToolMaterial p_330371_) {
        return createAttributes(p_330371_, 5.0F, -2.8F, 4.0F);
    }

}
