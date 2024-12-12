package com.fuyuaki.morethanadventure.mixin;

import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import com.fuyuaki.morethanadventure.world.item.curio.talisman.AttributeModifierTalismanItem;
import com.fuyuaki.morethanadventure.world.item.weaponry.WeaponItem;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForgeMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity{

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


}
