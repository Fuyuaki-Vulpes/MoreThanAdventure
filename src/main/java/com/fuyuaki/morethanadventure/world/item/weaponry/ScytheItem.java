package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.registry.MtaParticles;
import com.fuyuaki.morethanadventure.core.registry.MtaSounds;
import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.neoforge.common.ItemAbility;

public class ScytheItem extends WeaponItem {

    protected static final float attackSpeed = -2.6F;
    protected static final int attackDamage = 5;
// RANGE = 4.0

    public ScytheItem(ToolMaterial tier, Properties properties) {
        super(tier, attackDamage,attackSpeed, properties);
    }


    public static ItemAttributeModifiers createAttributes(ToolMaterial p_330371_) {
        return createAttributes(p_330371_,5.0F,-2.6F,4.0F);
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
