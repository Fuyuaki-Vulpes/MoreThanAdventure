package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaParticles;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.neoforge.common.ItemAbility;

public class HalberdItem extends WeaponItem {

    protected static final float attackSpeed = -2.9F;
    protected static final int attackDamage = 4;
    protected static final float range = 4.0F;

    public HalberdItem(ToolMaterial tier, Properties properties) {
        super(tier, attackDamage, attackSpeed, range, properties);
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
        return WeaponAbilities.DEFAULT_HALBERD_ACTIONS.contains(itemAbility);
    }

}
