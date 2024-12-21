package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.neoforge.common.ItemAbility;

public class TwinbladeItem extends WeaponItem {

    protected static final float attackSpeed = -2.0F;
    protected static final int attackDamage = 2;
// RANGE = 3.0

    public TwinbladeItem(ToolMaterial tier, Properties properties) {
        super(tier,attackDamage,attackSpeed, properties);
    }



    public static ItemAttributeModifiers createAttributes(ToolMaterial tier) {
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
