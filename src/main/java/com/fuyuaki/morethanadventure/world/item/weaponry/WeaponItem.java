package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEffects;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class WeaponItem extends Item {

    public static final ResourceLocation BASE_RANGE_ID = ResourceLocation.fromNamespaceAndPath(MODID, "base_range_speed");



    public WeaponItem(ToolMaterial p_tier,float attack, float speed, float range, Properties p_properties) {
        super(p_properties.attributes(createAttributes(p_tier,attack,speed,range))
                .durability(p_tier.durability())
                .repairable(p_tier.repairItems())
                .enchantable(p_tier.enchantmentValue())
                .component(
                        DataComponents.TOOL,
                        new Tool(
                                List.of(
                                        Tool.Rule.minesAndDrops(HolderSet.direct(Blocks.COBWEB.builtInRegistryHolder()), 15.0F),
                                        Tool.Rule.overrideSpeed(BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK).getOrThrow(BlockTags.SWORD_EFFICIENT), 1.5F)
                                ),
                                1.0F,
                                2
                        )
                ));

    }


    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity, InteractionHand hand) {
        if (this.getSwingSound()!= null) {
            entity.playSound(this.getSwingSound(), entity.getRandom().nextFloat() * 0.4F + 0.8F, entity.getRandom().nextFloat() + 0.5F);
        }
        return super.onEntitySwing(stack, entity, hand);
    }


    public SoundEvent getSwingSound() {
        return null;
    }

    public static ItemAttributeModifiers createAttributes(ToolMaterial tier, float attackDamage, float attackSpeed, float range) {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(
                                BASE_ATTACK_DAMAGE_ID, (double) ((float) attackDamage + tier.attackDamageBonus()), AttributeModifier.Operation.ADD_VALUE
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

    public boolean spawnsParticleOnTarget(){ return false;}

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (stack.is(MtaTags.Items.TWO_HANDED) && !attacker.getItemInHand(InteractionHand.OFF_HAND).isEmpty()){
            return false;
        }
        attacker.level()
                .playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), this.getWeaponHitSound(), attacker.getSoundSource(), 0.8F, 1.0F);

        double d0 = (double) (-Mth.sin(attacker.getYRot() * (float) (Math.PI / 180.0)));
        double d1 = (double) Mth.cos(attacker.getYRot() * (float) (Math.PI / 180.0));
        if (attacker.level() instanceof ServerLevel) {
            if (spawnsParticleOnTarget()){
                ((ServerLevel) attacker.level()).sendParticles(this.getWeaponHitParticles(),
                        target.getX() - d0,
                        target.getY(0.80),
                        target.getZ() - d1,
                        0,
                        d0,
                        0.0,
                        d1,
                        0.0);

            }
            else {
            ((ServerLevel) attacker.level()).sendParticles(this.getWeaponHitParticles(), attacker.getX() + d0, attacker.getY(0.80), attacker.getZ() + d1, 0, d0, 0.0, d1, 0.0);
            }
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
