package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.ToucanModel;
import com.fuyuaki.morethanadventure.world.entity.Penguin;
import com.fuyuaki.morethanadventure.world.entity.Toucan;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ToucanRenderer extends GeoEntityRenderer<Toucan> {
    public ToucanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ToucanModel());
    }

    @Override
    public void render(Toucan entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()) {
            poseStack.scale(0.45f,0.45f,0.45f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
