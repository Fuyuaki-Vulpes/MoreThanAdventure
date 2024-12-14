package com.fuyuaki.morethanadventure.world.item.weaponry;

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
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (stack.is(MtaTags.Items.TWO_HANDED) && !attacker.getItemInHand(InteractionHand.OFF_HAND).equals(ItemStack.EMPTY)){
            System.out.println("TWOHANDED BKEH");
            return false;
        }
        attacker.level()
                .playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), this.getWeaponHitSound(), attacker.getSoundSource(), 0.8F, 1.0F);

        double d0 = (double) (-Mth.sin(attacker.getYRot() * (float) (Math.PI / 180.0)));
        double d1 = (double) Mth.cos(attacker.getYRot() * (float) (Math.PI / 180.0));
        if (attacker.level() instanceof ServerLevel) {
            ((ServerLevel) attacker.level()).sendParticles(this.getWeaponHitParticles(), attacker.getX() + d0, attacker.getY(0.5), attacker.getZ() + d1, 0, d0, 0.0, d1, 0.0);
        }

        return true;
    }

    @Override
    public void postHurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);

    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (stack.is(MtaTags.Items.THROWABLE)) {
            tooltipComponents.add(Component.translatable("items.morethanadventure.weapons.tag.throwable").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.YELLOW));
        }
        if (stack.is(MtaTags.Items.TWO_HANDED)) {
            tooltipComponents.add(Component.translatable("items.morethanadventure.weapons.tag.two_handed").withStyle(ChatFormatting.UNDERLINE).withStyle(ChatFormatting.YELLOW));
        }
        if (stack.is(MtaTags.Items.CAUSES_BLEEDING)) {
            tooltipComponents.add(Component.translatable("items.morethanadventure.weapons.tag.causes_bleeding").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.RED));
        }
        if (stack.is(MtaTags.Items.STUN)) {
            tooltipComponents.add(Component.translatable("items.morethanadventure.weapons.tag.stun").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.RED));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
