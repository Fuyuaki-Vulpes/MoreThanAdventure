package com.fuyuaki.morethanadventure.mixin;


import com.fuyuaki.morethanadventure.core.registry.MtaEffects;
import com.fuyuaki.morethanadventure.world.mob_effect.renderer.StunRenderer;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Gui.class)
public class GUIMixin {


    @Shadow @Final private Minecraft minecraft;

    @Inject(method = "renderCameraOverlays", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Options;screenEffectScale()Lnet/minecraft/client/OptionInstance;"), cancellable = true)
    private void renderEffects(GuiGraphics guiGraphics, DeltaTracker deltaTracker, CallbackInfo ci) {

        assert this.minecraft.player != null;

        if (this.minecraft.player.hasEffect(MtaEffects.STUN)) {
            StunRenderer.render(this.minecraft, guiGraphics, deltaTracker.getGameTimeDeltaPartialTick(false));
        }

    }
}
