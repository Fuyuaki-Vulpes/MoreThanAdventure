package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaParticles;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.neoforge.common.ItemAbility;

public class ScytheItem extends WeaponItem {

    protected static final float attackSpeed = -2.6F;
    protected static final int attackDamage = 5;
    protected static final float range = 4.0F;

    public ScytheItem(ToolMaterial tier, Properties properties) {
        super(tier, attackDamage,attackSpeed,range, properties);
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
