package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaParticles;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.neoforge.common.ItemAbility;

public class ClawItem extends WeaponItem {

    protected static final float attackSpeed = -2.5F;
    protected static final int attackDamage = 6;
    protected static final float range = 2.0F;

    public ClawItem(ToolMaterial tier, Properties properties) {
        super(tier, attackDamage, attackSpeed,2.0F ,properties);
    }



    public static ItemAttributeModifiers createAttributes(ToolMaterial tier) {
        return createAttributes(tier,6.0F,-2.5F,2.0F);
    }

    @Override
    public ParticleOptions getWeaponHitParticles() {
        return MtaParticles.TEAR_ATTACK.get();
    }

    @Override
    public SoundEvent getWeaponHitSound() {
        return MtaSounds.WEAPON_SCRAPE.get();
    }



    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.setPos(target.position());
        target.setDeltaMovement(0,0,0);
        return super.hurtEnemy(stack,target,attacker);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return WeaponAbilities.DEFAULT_CLAW_ACTIONS.contains(itemAbility);
    }
}
