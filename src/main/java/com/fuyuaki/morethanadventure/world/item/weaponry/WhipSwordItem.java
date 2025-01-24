package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.neoforge.common.ItemAbility;

public class WhipSwordItem extends WeaponItem{


    protected static final float attackSpeed = -2.6F;
    protected static final int attackDamage = 3;
    protected static final float range = 3.7F;

    public WhipSwordItem(ToolMaterial p_tier, Properties p_properties) {
        super(p_tier, attackDamage, attackSpeed, 3.7F, p_properties);
    }

    @Override
    public ParticleOptions getWeaponHitParticles() {
        return ParticleTypes.SWEEP_ATTACK;
    }

    @Override
    public SoundEvent getWeaponHitSound() {
        return MtaSounds.WEAPON_TEAR.get();
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return WeaponAbilities.DEFAULT_WHIP_SWORD_ACTIONS.contains(itemAbility);
    }
}
