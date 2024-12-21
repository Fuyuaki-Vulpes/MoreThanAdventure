package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.registry.MtaParticles;
import com.fuyuaki.morethanadventure.core.registry.MtaSounds;
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

public class ScytheItem extends WeaponItem {

    protected static final float attackSpeed = -2.6F;
    protected static final int attackDamage = 5;
// RANGE = 4.0

    public ScytheItem(ToolMaterial tier, Properties properties) {
        super(tier, properties,createToolProperties());
    }


    public static Tool createToolProperties() {
        return new Tool(List.of(Tool.Rule.minesAndDrops(List.of(Blocks.COBWEB), 15.0F), Tool.Rule.overrideSpeed(BlockTags.SWORD_EFFICIENT, 1.5F)), 1.0F, 2);
    }

    public static ItemAttributeModifiers createAttributes(ToolMaterial p_330371_) {
        return createAttributes(p_330371_,5.0F,-2.6F,4.0F);
    }

    @Override
    public ParticleOptions getWeaponHitParticles() {
        return MtaParticles.SLASH_ATTACK.get();

    }

    @Override
    public SoundEvent getWeaponHitSound() {
        return MtaSounds.WEAPON_TEAR.get();
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return WeaponAbilities.DEFAULT_SCYTHE_ACTIONS.contains(itemAbility);
    }

}
