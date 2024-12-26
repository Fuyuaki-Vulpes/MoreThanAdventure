package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.neoforge.common.ItemAbility;

public class CutlassItem extends WeaponItem {

    protected static final float attackSpeed = -2.6F;
    protected static final int attackDamage = 4;
    protected static final float range = 2.5F;

// RANGE = 2.5

    public CutlassItem(ToolMaterial tier, Properties properties) {
        super(tier,attackDamage,attackSpeed,range, properties);
    }




    @Override
    public ParticleOptions getWeaponHitParticles() {
        return ParticleTypes.SWEEP_ATTACK;
    }

    @Override
    public SoundEvent getWeaponHitSound() {
        return MtaSounds.WEAPON_SWING.get();
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return WeaponAbilities.DEFAULT_CUTLASS_ACTIONS.contains(itemAbility);
    }

}
