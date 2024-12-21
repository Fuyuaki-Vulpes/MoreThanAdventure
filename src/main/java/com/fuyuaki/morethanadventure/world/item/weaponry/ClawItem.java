package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.registry.MtaParticles;
import com.fuyuaki.morethanadventure.core.registry.MtaSounds;
import com.fuyuaki.morethanadventure.world.item.ItemVariables;
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
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.List;

public class ClawItem extends WeaponItem {

    protected static final float attackSpeed = -2.5F;
    protected static final int attackDamage = 6;
// RANGE = 2.0

    public ClawItem(ToolMaterial tier, Properties properties) {
        super(tier, properties,createToolProperties());
    }


    public static Tool createToolProperties() {
        return new Tool(List.of(Tool.Rule.minesAndDrops(List.of(Blocks.COBWEB), 15.0F), Tool.Rule.overrideSpeed(BlockTags.SWORD_EFFICIENT, 1.5F)), 1.0F, 2);
    }

    public static ItemAttributeModifiers createAttributes(ToolMaterial tier) {
        return createAttributes(tier,6.0F,-2.5F,2.0F);
    }

    @Override
    public ParticleOptions getWeaponHitParticles() {
        return MtaParticles.TEAR_ATTACK.get();
    }

    @Override
    public SoundEvent getWeaponHitSound() {
        return MtaSounds.WEAPON_SCRAPE.get();
    }



    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setPos(target.position());
        target.setDeltaMovement(0,0,0);
        return super.hurtEnemy(stack,target,attacker);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return WeaponAbilities.DEFAULT_CLAW_ACTIONS.contains(itemAbility);
    }
}
