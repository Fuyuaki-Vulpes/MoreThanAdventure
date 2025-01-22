package com.fuyuaki.morethanadventure.mixin;


import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.WeatherEffectRenderer;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(WeatherEffectRenderer.class)
public abstract class WeatherEffectRendererMixin {


    @Inject(method = "render(Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/world/phys/Vec3;IFLjava/util/List;Ljava/util/List;)V", at =@At("HEAD"), cancellable = true)
    private void render(MultiBufferSource bufferSource, Vec3 cameraPosition, int radius, float rainLevel, List<WeatherEffectRenderer.ColumnInstance> rainColumnInstances, List<WeatherEffectRenderer.ColumnInstance> snowColumnInstances, CallbackInfo ci){
        ci.cancel();

    }
}
