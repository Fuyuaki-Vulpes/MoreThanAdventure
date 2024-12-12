package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.List;

public class TwinbladeItem extends WeaponItem {

    protected static final float attackSpeed = -2.0F;
    protected static final int attackDamage = 2;
// RANGE = 3.0

    public TwinbladeItem(Tier tier, Properties properties) {
        super(tier, properties,createToolProperties());
    }


    public static Tool createToolProperties() {
        return new Tool(List.of(Tool.Rule.minesAndDrops(List.of(Blocks.COBWEB), 15.0F), Tool.Rule.overrideSpeed(BlockTags.SWORD_EFFICIENT, 1.5F)), 1.0F, 2);
    }

    public static ItemAttributeModifiers createAttributes(Tier tier) {
        return createAttributes(tier,2.0F,-2.0F,3.0F);
    }

    @Override
    public ParticleOptions getWeaponHitParticles() {
        return ParticleTypes.SWEEP_ATTACK;
    }

    @Override
    public SoundEvent getWeaponHitSound() {
        return SoundEvents.PLAYER_ATTACK_SWEEP;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return WeaponAbilities.DEFAULT_TWINBLADE_ACTIONS.contains(itemAbility);
    }

}
