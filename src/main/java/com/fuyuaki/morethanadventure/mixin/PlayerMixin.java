package com.fuyuaki.morethanadventure.mixin;

import com.fuyuaki.morethanadventure.core.deferred_registries.MTAAttachments;
import com.fuyuaki.morethanadventure.world.entity.attachments.RespawnablePetsAttachment;
import com.fuyuaki.morethanadventure.world.item.weaponry.WeaponItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity{

    @Shadow public abstract boolean shouldBeSaved();

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
            RespawnablePetsAttachment attachment = thisPlayer.getData(MTAAttachments.PETS_TO_RESPAWN.get());
            attachment.respawnPets(this.level(),thisPlayer);
            this.setData(MTAAttachments.PETS_TO_RESPAWN, attachment);
        }
    }


}
