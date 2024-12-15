package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.registry.MtaEffects;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

import java.util.List;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class WeaponItem extends SwordItem {

    public static final ResourceLocation BASE_RANGE_ID = ResourceLocation.fromNamespaceAndPath(MODID, "base_range_speed");



    public WeaponItem(Tier p_tier, Properties p_properties, Tool toolComponentData) {
        super(p_tier, p_properties, toolComponentData);

    }


    public static ItemAttributeModifiers createAttributes(Tier tier, float attackDamage, float attackSpeed, float range) {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(
                                BASE_ATTACK_DAMAGE_ID, (double) ((float) attackDamage + tier.getAttackDamageBonus()), AttributeModifier.Operation.ADD_VALUE
                        ),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(BASE_ATTACK_SPEED_ID, (double) attackSpeed, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ENTITY_INTERACTION_RANGE,
                        new AttributeModifier(BASE_RANGE_ID, (double) range - 2.5F, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .build();
    }

    public ParticleOptions getWeaponHitParticles() {
        return ParticleTypes.SWEEP_ATTACK;
    }

    public SoundEvent getWeaponHitSound() {
        return SoundEvents.PLAYER_ATTACK_SWEEP;
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof LivingEntity living) {
            if (isSelected && living.getItemInHand(InteractionHand.MAIN_HAND).is(stack.getItem()) && !living.getItemInHand(InteractionHand.OFF_HAND).isEmpty() && stack.is(MtaTags.Items.TWO_HANDED)){
                living.addEffect(new MobEffectInstance(MtaEffects.TWO_HANDED_BLOCK,5));
            }
        }
        super.inventoryTick(stack, level, entity, slotId, isSelected);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (stack.is(MtaTags.Items.TWO_HANDED) && !attacker.getItemInHand(InteractionHand.OFF_HAND).equals(ItemStack.EMPTY)){
            return false;
        }
        attacker.level()
                .playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), this.getWeaponHitSound(), attacker.getSoundSource(), 0.8F, 1.0F);

        double d0 = (double) (-Mth.sin(attacker.getYRot() * (float) (Math.PI / 180.0)));
        double d1 = (double) Mth.cos(attacker.getYRot() * (float) (Math.PI / 180.0));
        if (attacker.level() instanceof ServerLevel) {
            ((ServerLevel) attacker.level()).sendParticles(this.getWeaponHitParticles(), attacker.getX() + d0, attacker.getY(0.5) + (attacker.getEyeHeight()/2 - attacker.getBbHeight()/2), attacker.getZ() + d1, 0, d0, 0.0, d1, 0.0);
        }
        if (stack.is(MtaTags.Items.CAUSES_BLEEDING)){

            if (attacker.getRandom().nextDouble() < getWeaponBleedChance()){
                target.addEffect(new MobEffectInstance(MtaEffects.BLEEDING,target.getRandom().nextIntBetweenInclusive(20,90)),attacker);
            }
        }
        if (stack.is(MtaTags.Items.STUN)){
            if (attacker.getRandom().nextDouble() < getWeaponStunChance()){
                target.addEffect(new MobEffectInstance(MtaEffects.STUN,target.getRandom().nextIntBetweenInclusive(10,40)),attacker);

            }
        }

        return true;
    }

    public static double getWeaponBleedChance() {
        return 0.35F;
    }

    public static double getWeaponStunChance() {
        return 0.12F;
    }

    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);

    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        boolean shiftDown = tooltipFlag.hasShiftDown();
        if (stack.is(MtaTags.Items.THROWABLE)) {
            tooltipComponents.add(Component.translatable("items.morethanadventure.weapons.tag.throwable").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BLUE));
        }
        if (stack.is(MtaTags.Items.TWO_HANDED)) {
            tooltipComponents.add(Component.translatable("items.morethanadventure.weapons.tag.two_handed").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.BLUE));
        }
        if (stack.is(MtaTags.Items.CAUSES_BLEEDING)) {
            tooltipComponents.add(Component.translatable("items.morethanadventure.weapons.tag.causes_bleeding").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.RED));
            if (shiftDown) tooltipComponents.add(Component.literal((getWeaponBleedChance() * 100) + "%").withStyle(ChatFormatting.GOLD));
        }
        if (stack.is(MtaTags.Items.STUN)) {
            tooltipComponents.add(Component.translatable("items.morethanadventure.weapons.tag.stun").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.RED));
            if (shiftDown) tooltipComponents.add(Component.literal(getWeaponStunChance() * 100 + "%").withStyle(ChatFormatting.GOLD));
        }
        if (!shiftDown && (stack.is(MtaTags.Items.STUN) || stack.is(MtaTags.Items.CAUSES_BLEEDING))){
            tooltipComponents.add(Component.translatable("items.morethanadventure.weapons.info.shift").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.GREEN));

        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
