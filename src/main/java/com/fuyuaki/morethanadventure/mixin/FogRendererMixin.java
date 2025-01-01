package com.fuyuaki.morethanadventure.mixin;

import com.fuyuaki.morethanadventure.world.item.accessories.talisman.AttributeModifierTalismanItem;
import com.mojang.blaze3d.shaders.FogShape;
import net.minecraft.client.Camera;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.FogParameters;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.material.FogType;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FogRenderer.class)
public class FogRendererMixin {

    @Inject(method = "setupFog", at = @At(value = "TAIL"))
    private static void onGetNightVisionScale(Camera camera, FogRenderer.FogMode fogMode, Vector4f p_365467_, float farPlaneDistance, boolean p_234176_, float p_234177_, CallbackInfoReturnable<FogParameters> cir) {
        FogType fogtype = camera.getFluidInCamera();
        Entity entity = camera.getEntity();
        FogRenderer.FogData fogrenderer$fogdata = new FogRenderer.FogData(fogMode);

        if (fogtype == FogType.WATER) {
            if (entity instanceof Player player && AttributeModifierTalismanItem.enableScubaGearEffects(player)) {

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
