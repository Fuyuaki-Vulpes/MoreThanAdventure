package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.registry.MtaSounds;
import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.neoforge.common.ItemAbility;

public class DoubleAxeItem extends WeaponItem {

    protected static final float attackSpeed = -2.6F;
    protected static final int attackDamage = 4;
    protected static final float range = 3.0F;
// RANGE = 3.0

    public DoubleAxeItem(ToolMaterial tier, Properties properties) {
        super(tier, attackDamage, attackSpeed,range,properties);
    }



    @Override
    public ParticleOptions getWeaponHitParticles() {
        return ParticleTypes.SWEEP_ATTACK;
    }

    @Override
    public SoundEvent getWeaponHitSound() {
        return MtaSounds.WEAPON_DEEP_SWING.get();
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return WeaponAbilities.DEFAULT_DOUBLE_AXE_ACTIONS.contains(itemAbility);
    }

}
