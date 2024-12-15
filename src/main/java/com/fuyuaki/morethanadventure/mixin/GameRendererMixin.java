package com.fuyuaki.morethanadventure.mixin;


import com.fuyuaki.morethanadventure.core.registry.MtaEffects;
import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import com.fuyuaki.morethanadventure.game.client.PlayerModelOverlayUtil;
import com.fuyuaki.morethanadventure.world.item.curio.talisman.AttributeModifierTalismanItem;
import com.fuyuaki.morethanadventure.world.mob_effect.renderer.StunRenderer;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {
    private static final ResourceLocation STUN_LOCATION = ResourceLocation.fromNamespaceAndPath(MODID,"textures/misc/stun.png");

    @Shadow @Final
    Minecraft minecraft;

    @Shadow @Final private RenderBuffers renderBuffers;

    @Inject(method = "getNightVisionScale", at = @At("HEAD"), cancellable = true)
    private static void onGetNightVisionScale(LivingEntity entity, float f, CallbackInfoReturnable<Float> info) {
        if(PlayerModelOverlayUtil.shouldRenderSirenParts(entity) && AttributeModifierTalismanItem.shouldRenderParts( MtaItems.SIREN_TALISMAN.get(),entity)) {
            info.setReturnValue(1.0F);
        }
    }

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Options;screenEffectScale()Lnet/minecraft/client/OptionInstance;"), cancellable = true)
    private void renderEffects(DeltaTracker deltaTracker, boolean renderLevel, CallbackInfo ci) {
        GuiGraphics guigraphics = new GuiGraphics(this.minecraft, this.renderBuffers.bufferSource());

        assert this.minecraft.player != null;

        if (this.minecraft.player.hasEffect(MtaEffects.STUN)) {
            StunRenderer.render(this.minecraft,this.renderBuffers,guigraphics, deltaTracker.getGameTimeDeltaPartialTick(false));
        }

    }

}
