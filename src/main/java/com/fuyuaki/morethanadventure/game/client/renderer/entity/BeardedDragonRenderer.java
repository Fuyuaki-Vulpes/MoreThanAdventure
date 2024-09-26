package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BeardedDragonRenderer extends GeoEntityRenderer<BeardedDragon> {
    public BeardedDragonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BeardedDragonModel());
    }

    @Override
    public void render(BeardedDragon entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()) {
            poseStack.scale(0.45f,0.45f,0.45f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
