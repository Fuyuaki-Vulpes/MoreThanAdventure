package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.core.registry.MtaEffects;
import com.google.common.base.Suppliers;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Supplier;

public class KnightGreatswordItem extends SwordItem {

    private final Supplier<ItemAttributeModifiers> attributeModifiers;


    public KnightGreatswordItem(Tier pTier, Properties pProperties) {
        super(pTier, pProperties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));
        this.attributeModifiers = Suppliers.memoize(
                () -> {
                    ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
                    ResourceLocation location = ResourceLocation.withDefaultNamespace("greatsword");

                    return createAttributeModifiers(pTier,builder).build();
                }
        );
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
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        if (usedHand.equals(InteractionHand.OFF_HAND)) return InteractionResultHolder.fail(itemstack);

        player.startUsingItem(usedHand);
        return InteractionResultHolder.consume(itemstack);
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
    public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeCharged) {
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

    }

    protected ItemAttributeModifiers.Builder createAttributeModifiers(Tier pTier, ItemAttributeModifiers.Builder builder){
        ResourceLocation location = ResourceLocation.withDefaultNamespace("greatsword");


        builder.add(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(location, 5 + pTier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
                );
        builder.add(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(location, -2.9F, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
                );
               return builder;
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return this.attributeModifiers.get();
    }

    @Override
    public int getEnchantmentValue() {
        return 28;
    }
}
