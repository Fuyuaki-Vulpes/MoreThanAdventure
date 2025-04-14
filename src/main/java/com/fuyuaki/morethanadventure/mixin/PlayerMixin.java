package com.fuyuaki.morethanadventure.mixin;

import com.fuyuaki.morethanadventure.core.deferred_registries.MTAAttachments;
import com.fuyuaki.morethanadventure.core.registry.MTASpecies;
import com.fuyuaki.morethanadventure.game.species.Species;
import com.fuyuaki.morethanadventure.world.entity.attachments.RespawnablePetsAttachment;
import com.fuyuaki.morethanadventure.world.entity.attachments.SoulCharge;
import com.fuyuaki.morethanadventure.world.entity.attachments.SpeciesAttachment;
import com.fuyuaki.morethanadventure.world.entity.attachments.helper.MTASoulHelper;
import com.fuyuaki.morethanadventure.world.item.weaponry.WeaponItem;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Predicate;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity{


    @Shadow public abstract boolean shouldBeSaved();

    @Shadow protected abstract float getEnchantedDamage(Entity entity, float damage, DamageSource damageSource);

    @Shadow public abstract float getAttackStrengthScale(float adjustTicks);

    @Shadow public abstract double entityInteractionRange();

    @Shadow public abstract void sweepAttack();

    @Shadow public abstract void crit(Entity entityHit);

    @Shadow public abstract void magicCrit(Entity entityHit);

    @Shadow public abstract void awardStat(ResourceLocation stat, int increment);

    @Shadow public abstract void causeFoodExhaustion(float exhaustion);

    @Shadow public abstract void resetAttackStrengthTicker();

    @Shadow @Final private Inventory inventory;

    @Shadow public abstract void tick();

    @Unique
    private final Player thisPlayer = (Player)(Object)this;

    protected PlayerMixin(EntityType<? extends LivingEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "sweepAttack",at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerLevel;sendParticles(Lnet/minecraft/core/particles/ParticleOptions;DDDIDDDD)I"), cancellable = true)
    protected void sweepAttackMixin(CallbackInfo cir){
        ItemStack itemstack1 = thisPlayer.getItemInHand(InteractionHand.MAIN_HAND);

        if (itemstack1.getItem() instanceof WeaponItem) {
            cir.cancel();
        }
    }

    @Inject(method = "tick",at = @At(value = "HEAD"))
    protected void tick(CallbackInfo ci){

        if (thisPlayer.level().getDayTime() % 24000L == 1000 && !this.level().isClientSide()) {
            RespawnablePetsAttachment attachment = thisPlayer.getData(MTAAttachments.PETS_TO_RESPAWN);
            attachment.respawnPets(this.level(),thisPlayer);
            this.setData(MTAAttachments.PETS_TO_RESPAWN, attachment);
        }
        if (!this.level().isClientSide()) {
            if (thisPlayer.hasData(MTAAttachments.SPECIES.get())) {
                SpeciesAttachment speciesAttachment = thisPlayer.getData(MTAAttachments.SPECIES.get());
                speciesAttachment.tick(thisPlayer);
                thisPlayer.setData(MTAAttachments.SPECIES.get(),speciesAttachment);
            }else{

                thisPlayer.setData(MTAAttachments.SPECIES.get(), new SpeciesAttachment(MTASpecies.HUMAN));
            }
            MTASoulHelper.playerTickSoul(thisPlayer);

        }
    }

}
