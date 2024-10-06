package com.fuyuaki.morethanadventure.mixin;

import com.fuyuaki.morethanadventure.core.registry.MtaEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Snowball.class)
public abstract class SnowballMixin extends ThrowableItemProjectile {
    public SnowballMixin(EntityType<? extends ThrowableItemProjectile> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "onHitEntity", at = @At("RETURN"))
    private void hitEntity(EntityHitResult result, CallbackInfo ci) {
        Entity entity = result.getEntity();
        if (entity instanceof LivingEntity living && ((Snowball)(Object)this).getOwner() instanceof SnowGolem){
            living.addEffect(new MobEffectInstance(MtaEffects.FREEZING,60));
        }

    }
}
