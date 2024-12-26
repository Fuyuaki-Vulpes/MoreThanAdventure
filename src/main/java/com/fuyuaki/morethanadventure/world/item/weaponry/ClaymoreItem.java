package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.neoforge.common.ItemAbility;

public class ClaymoreItem extends WeaponItem {

    protected static final float attackSpeed = -2.9F;
    protected static final int attackDamage = 5;
    protected static final float range = 3.5F;


    public ClaymoreItem(ToolMaterial tier, Properties properties) {
        super(tier, attackDamage, attackSpeed, range, properties);
    }



    public static ItemAttributeModifiers createAttributes(ToolMaterial p_330371_) {
        return createAttributes(p_330371_,5.0F,-2.9F,3.5F);
    }

    @Override
    public ParticleOptions getWeaponHitParticles() {
        return ParticleTypes.SWEEP_ATTACK;
    }

    @Override
    public SoundEvent getWeaponHitSound() {
        return MtaSounds.WEAPON_DEEP_SWING.get();
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return WeaponAbilities.DEFAULT_CLAYMORE_ACTIONS.contains(itemAbility);
    }

}
