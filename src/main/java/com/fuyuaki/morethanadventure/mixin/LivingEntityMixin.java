package com.fuyuaki.morethanadventure.mixin;


import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import com.fuyuaki.morethanadventure.world.item.accessories.TalismanItem;
import com.fuyuaki.morethanadventure.world.item.accessories.talisman.AttributeModifierTalismanItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.FluidState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    @Unique
    private final LivingEntity thisLiving = (LivingEntity) (Object) this;

    public LivingEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "hurtServer", at = @At("HEAD"))
    private void hurtMixin(ServerLevel p_376221_, DamageSource p_376460_, float v, CallbackInfoReturnable<Boolean> cir) {
        if (v > thisLiving.getMaxHealth() * 1.5F) {
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

    @Inject(method = "isAffectedByFluids", at = @At("HEAD"), cancellable = true)
    public void isPushedByFluid(CallbackInfoReturnable<Boolean> cir) {
        if (AttributeModifierTalismanItem.enableScubaGearEffects(thisLiving)) {
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "canBreatheUnderwater", at = @At("HEAD"), cancellable = true)
    public void canBreatheUnderwater(CallbackInfoReturnable<Boolean> cir) {
        if (AttributeModifierTalismanItem.enableScubaGearEffects(thisLiving)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "canStandOnFluid",at = @At(value = "HEAD"), cancellable = true)
    protected void canStandOnFluid(FluidState fluidState, CallbackInfoReturnable<Boolean> cir){
        if (fluidState.is(FluidTags.LAVA) && TalismanItem.isEquipped(thisLiving, MtaItems.STRIDER_BOOTS.get())) {
            cir.setReturnValue(true);
        }
    }

    @Inject(method = "onClimbable",at = @At(value = "HEAD"), cancellable = true)
    protected void onClimbable(CallbackInfoReturnable<Boolean> cir){
        if (this.horizontalCollision && TalismanItem.isEquipped(thisLiving, MtaItems.CLIMBING_CLAWS.get())) {
            cir.setReturnValue(true);
        }
    }
    @Inject(method = "jumpFromGround",at = @At(value = "HEAD"), cancellable = true)
    protected void jump(CallbackInfo ci){
        if (TalismanItem.isEquipped(thisLiving, MtaItems.PISTON_BOOTS.get())) {
            this.level().playSound(null,this.blockPosition(), SoundEvents.PISTON_EXTEND, SoundSource.PLAYERS,0.3F,this.level().random.nextFloat() * 0.25F + 0.6F);
        }
    }


}
