package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.registry.MtaParticles;
import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.neoforge.common.ItemAbility;

public class GlaiveItem extends WeaponItem {

    protected static final float attackSpeed = -2.8F;
    protected static final int attackDamage = 3;
// RANGE = 4.5

    public GlaiveItem(ToolMaterial tier, Properties properties) {
        super(tier, attackDamage,attackSpeed, properties);
    }


    public static ItemAttributeModifiers createAttributes(ToolMaterial p_330371_) {
        return createAttributes(p_330371_,3.0F,-2.8F,4.5F);
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
