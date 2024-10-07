package com.fuyuaki.morethanadventure.mixin;


import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Unique
    private final LivingEntity thisLiving = (LivingEntity)(Object)this;

    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "hurt",at = @At("HEAD"))
    private void hurtMixin(DamageSource source, float amount, CallbackInfoReturnable<Boolean> cir){
        if (amount > thisLiving.getMaxHealth() * 1.5F){
            thisLiving.deathTime = 19;

            for (int n = 0; n < 50; n++) {
                    thisLiving.level().addParticle(
                            ParticleTypes.RAID_OMEN,
                            thisLiving.getRandomX(1.5),
                            thisLiving.getRandomY() + (thisLiving.getRandom().nextDouble() * 0.5),
                            thisLiving.getRandomZ(1.5),
                            0, 0, 0);

            }
        }
    }
/*
    @Inject(method = "tickDeath",at = @At("HEAD"))
    private void tickDeathMixin(CallbackInfo ci){

    }

 */
}
