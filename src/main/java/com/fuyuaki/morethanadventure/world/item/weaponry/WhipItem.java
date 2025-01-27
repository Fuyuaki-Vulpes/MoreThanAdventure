package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaParticles;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.neoforge.common.ItemAbility;

public class WhipItem extends WeaponItem{

    protected static final float attackSpeed = -2.3F;
    protected static final float attackDamage = 1;
    protected static final float range = 15.0F;


    public WhipItem(ToolMaterial p_tier, Properties p_properties) {
        super(p_tier, attackDamage, attackSpeed, range, p_properties);
    }

    @Override
    public ParticleOptions getWeaponHitParticles() {
        return MtaParticles.WHIP_ATTACK.get();
    }

    @Override
    public SoundEvent getWeaponHitSound() {
        return MtaSounds.WEAPON_WHIP.get();
    }

    @Override
    public SoundEvent getSwingSound() {
        return MtaSounds.WHIP_SWING.get();
    }

    @Override
    public boolean spawnsParticleOnTarget() {
        return true;
    }


    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return WeaponAbilities.DEFAULT_WHIP_ACTIONS.contains(itemAbility);
    }
}
