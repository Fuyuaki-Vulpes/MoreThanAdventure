package com.fuyuaki.morethanadventure.mixin;


import com.fuyuaki.morethanadventure.world.item.curio.talisman.AttributeModifierTalismanItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
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

    @Inject(method = "checkTotemDeathProtection", at = @At("HEAD"), cancellable = true)
    public void totemCheck(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        if (damageSource != null && damageSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
            cir.setReturnValue(false);
        }/* else {
            ItemStack itemstack = null;
            if (CuriosApi.getCuriosInventory(thisLiving).isEmpty()) {

            } else {
                ICuriosItemHandler handler = CuriosApi.getCuriosInventory(thisLiving).get();

                List<SlotResult> slotResults = handler.findCurios("talisman");

                for (SlotResult result : slotResults) {
                    ItemStack itemstack1 = result.stack();
                    if (itemstack1.is(Items.TOTEM_OF_UNDYING) && net.neoforged.neoforge.common.CommonHooks.onLivingUseTotem(thisLiving, damageSource, itemstack1, InteractionHand.OFF_HAND)) {
                        itemstack = itemstack1.copy();
                        itemstack1.shrink(1);
                        break;
                    }
                }
                if (itemstack != null) {
                    cir.setReturnValue(itemstack != null);
                }
            }

        }*/
    }

}
