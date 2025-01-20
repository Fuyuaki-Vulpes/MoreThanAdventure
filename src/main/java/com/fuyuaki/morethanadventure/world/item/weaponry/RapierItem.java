package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaParticles;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.neoforge.common.ItemAbility;

public class RapierItem extends WeaponItem{

    protected static final float attackSpeed = -2.0F;
    protected static final int attackDamage = 1;
    protected static final float range = 3.0F;

    public RapierItem(ToolMaterial tier, Properties properties) {
        super(tier, attackDamage, attackSpeed,3.0F ,properties);
    }
    @Override
    public ParticleOptions getWeaponHitParticles() {
        return MtaParticles.STAB_ATTACK.get();

    }
    @Override
    public SoundEvent getWeaponHitSound() {
        return MtaSounds.WEAPON_STAB_SHARP.get();
    }
    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return WeaponAbilities.DEFAULT_RAPIER_ACTIONS.contains(itemAbility);
    }
}
