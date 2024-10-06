package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.CorrosiveCubeModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.CorrosiveCube;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MagmaCubeRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.resources.ResourceLocation;

public class CorrosiveCubeRenderer extends MobRenderer<CorrosiveCube, CorrosiveCubeModel<CorrosiveCube>> {
    public CorrosiveCubeRenderer(EntityRendererProvider.Context context, CorrosiveCubeModel<CorrosiveCube> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Override
    public ResourceLocation getTextureLocation(CorrosiveCube entity) {
        return null;
    }
}
