package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaParticles;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.neoforge.common.ItemAbility;

public class SickleItem extends WeaponItem{

    protected static final float attackSpeed = -2.5F;
    protected static final int attackDamage = 3;
    protected static final float range = 2.0F;

    public SickleItem(ToolMaterial tier, Properties properties) {
        super(tier, attackDamage, attackSpeed,2.0F ,properties);
    }
    @Override
    public ParticleOptions getWeaponHitParticles() {
        return MtaParticles.SLASH_ATTACK.get();

    }

    @Override
    public float getAttackDamageBonus(Entity target, float damage, DamageSource damageSource) {
        if (damageSource.getEntity() instanceof LivingEntity living){
            if (living.getItemInHand(InteractionHand.OFF_HAND).getItem() instanceof SickleItem){
                return damage * 1.8F;
            }
        }
        return super.getAttackDamageBonus(target, damage, damageSource);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (attacker.getItemInHand(InteractionHand.OFF_HAND).getItem() instanceof SickleItem){

            double d0 = (double) (-Mth.sin(attacker.getYRot() * (float) (Math.PI / 180.0))) + (attacker.getRandom().nextFloat() * 0.3F - 0.15F);
            double d1 = (double) Mth.cos(attacker.getYRot() * (float) (Math.PI / 180.0)) + (attacker.getRandom().nextFloat() * 0.3F - 0.15F);
            if (attacker.level() instanceof ServerLevel) {
                if (spawnsParticleOnTarget()){
                    ((ServerLevel) attacker.level()).sendParticles(this.getWeaponHitParticles(),
                            target.getX() - d0,
                            target.getY(0.80),
                            target.getZ() - d1,
                            0,
                            d0,
                            0.0,
                            d1,
                            0.0);

                }
                else {
                    ((ServerLevel) attacker.level()).sendParticles(this.getWeaponHitParticles(), attacker.getX() + d0, attacker.getY(0.80), attacker.getZ() + d1, 0, d0, 0.0, d1, 0.0);
                }
            }
        }

        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public SoundEvent getWeaponHitSound() {
        return MtaSounds.WEAPON_TEAR.get();
    }
    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return WeaponAbilities.DEFAULT_SICKLE_ACTIONS.contains(itemAbility);
    }
}
