package com.fuyuaki.morethanadventure.world.item;

import com.google.common.base.Suppliers;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.function.Supplier;

public class RogueDaggerItem extends SwordItem {
    private final Supplier<ItemAttributeModifiers> attributeModifiers;


    public RogueDaggerItem(Tier pTier, Properties pProperties) {
        super(pTier, pProperties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));
        this.attributeModifiers = Suppliers.memoize(
                () -> {
                    ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
                    ResourceLocation location = ResourceLocation.withDefaultNamespace("dagger");

                    return createAttributeModifiers(pTier,builder).build();
                }
        );
    }

    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 72000;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        player.startUsingItem(usedHand);
        return InteractionResultHolder.consume(itemstack);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity livingEntity, int timeCharged) {
        if (livingEntity instanceof Player player){
        int i = this.getUseDuration(stack, livingEntity) - timeCharged;
        if (i > 10) i = 10;
        float p = ((float) i )/ 10;
        Vec3 pushVec = livingEntity.getViewVector(1).scale(3.0);
        livingEntity.push(pushVec.scale(p));
        player.getCooldowns().addCooldown(stack.getItem(),100);
        player.playSound(SoundEvents.BREEZE_WIND_CHARGE_BURST.value(),0.5F,1.5F);
        player.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY,10));
        level.addParticle(ParticleTypes.GUST,player.getX(),player.getY(),player.getZ(),0,0,0);
        player.setIgnoreFallDamageFromCurrentImpulse(true);
        }

        super.releaseUsing(stack, level, livingEntity, timeCharged);
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

    protected ItemAttributeModifiers.Builder createAttributeModifiers(Tier pTier, ItemAttributeModifiers.Builder builder){
        ResourceLocation location = ResourceLocation.withDefaultNamespace("dagger");


        builder.add(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(location, 3 + pTier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(location, -0.9F, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                Attributes.ENTITY_INTERACTION_RANGE,
                new AttributeModifier(location, -0.5F, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                ALObjects.Attributes.ARMOR_PIERCE,
                new AttributeModifier(location, 3, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                ALObjects.Attributes.CRIT_CHANCE,
                new AttributeModifier(location, 0.1F, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                ALObjects.Attributes.CRIT_DAMAGE,
                new AttributeModifier(location, 2, AttributeModifier.Operation.ADD_VALUE),
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
        return 25;
    }
}

