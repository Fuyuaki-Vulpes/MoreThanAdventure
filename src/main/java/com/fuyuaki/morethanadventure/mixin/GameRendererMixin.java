package com.fuyuaki.morethanadventure.mixin;


import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import com.fuyuaki.morethanadventure.game.client.PlayerModelOverlayUtil;
import com.fuyuaki.morethanadventure.world.item.curio.talisman.AttributeModifierTalismanItem;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {

    @Inject(method = "getNightVisionScale", at = @At("HEAD"), cancellable = true)
    private static void onGetNightVisionScale(LivingEntity entity, float f, CallbackInfoReturnable<Float> info) {
        if(PlayerModelOverlayUtil.shouldRenderSirenParts(entity) && AttributeModifierTalismanItem.shouldRenderParts( MtaItems.SIREN_TALISMAN.get(),entity)) {
            info.setReturnValue(1.0F);
        }
    }
}
