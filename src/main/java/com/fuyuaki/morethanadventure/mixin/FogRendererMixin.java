package com.fuyuaki.morethanadventure.mixin;

import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import com.fuyuaki.morethanadventure.game.client.PlayerModelOverlayUtil;
import com.fuyuaki.morethanadventure.world.item.curio.talisman.AttributeModifierTalismanItem;
import com.mojang.blaze3d.shaders.FogShape;
import net.minecraft.client.Camera;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.material.FogType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FogRenderer.class)
public class FogRendererMixin {

    @Inject(method = "setupFog", at = @At(value = "INVOKE", target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderFogStart(F)V"))
    private static void onGetNightVisionScale(Camera camera, FogRenderer.FogMode fogMode, float farPlaneDistance, boolean shouldCreateFog, float partialTick, CallbackInfo ci) {
        FogType fogtype = camera.getFluidInCamera();
        Entity entity = camera.getEntity();
        FogRenderer.FogData fogrenderer$fogdata = new FogRenderer.FogData(fogMode);

        if (fogtype == FogType.WATER) {
            if (entity instanceof Player player && PlayerModelOverlayUtil.shouldRenderSirenParts(player) && AttributeModifierTalismanItem.shouldRenderParts(MtaItems.SIREN_TALISMAN.get(), player)) {

                float f = Mth.clamp(farPlaneDistance / 10.0F, 4.0F, 64.0F);
                fogrenderer$fogdata.start = farPlaneDistance - f;
                fogrenderer$fogdata.end = farPlaneDistance;
                fogrenderer$fogdata.shape = FogShape.CYLINDER;

                if (entity instanceof LocalPlayer localplayer) {
                    fogrenderer$fogdata.end = fogrenderer$fogdata.end * Math.max(0.25F, localplayer.getWaterVision());
                    Holder<Biome> holder = localplayer.level().getBiome(localplayer.blockPosition());
                    if (holder.is(BiomeTags.HAS_CLOSER_WATER_FOG)) {
                        fogrenderer$fogdata.end *= 0.85F;
                    }
                }

            }
        }
    }
}
