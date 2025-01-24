package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.neoforge.common.ItemAbility;

public class WhipItem extends WeaponItem{
    public WhipItem(ToolMaterial p_tier, Properties p_properties) {
        super(p_tier, 1F, -2.3F, 4F, p_properties);
    }

    @Override
    public ParticleOptions getWeaponHitParticles() {
        return ParticleTypes.SWEEP_ATTACK;
    }

    @Override
    public SoundEvent getWeaponHitSound() {
        return MtaSounds.WEAPON_PUNCH.get();
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return WeaponAbilities.DEFAULT_WHIP_ACTIONS.contains(itemAbility);
    }
}
