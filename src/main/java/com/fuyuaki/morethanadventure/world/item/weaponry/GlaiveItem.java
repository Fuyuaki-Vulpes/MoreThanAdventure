package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaParticles;
import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.neoforge.common.ItemAbility;

public class GlaiveItem extends WeaponItem {

    protected static final float attackSpeed = -2.8F;
    protected static final int attackDamage = 3;
    protected static final float range = 4.5F;
    public GlaiveItem(ToolMaterial tier, Properties properties) {
        super(tier, attackDamage,attackSpeed,range, properties);
    }



    @Override
    public ParticleOptions getWeaponHitParticles() {
        return MtaParticles.STAB_ATTACK.get();

    }

    @Override
    public SoundEvent getWeaponHitSound() {
        return SoundEvents.PLAYER_ATTACK_SWEEP;
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return WeaponAbilities.DEFAULT_GLAIVE_ACTIONS.contains(itemAbility);
    }

}
