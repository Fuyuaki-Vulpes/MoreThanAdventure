package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.ButterflyModel;
import com.fuyuaki.morethanadventure.world.entity.Butterfly;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ButterflyRender extends MobRenderer<Butterfly,ButterflyModel> {

    public ButterflyRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ButterflyModel(renderManager.bakeLayer(MTAModelLayers.BUTTERFLY)), 0.5F);
        //        this.addRenderLayer(new ButterflyWingsPattern(this));
        //        this.addRenderLayer(new ButterflyWingsOverlay(this));
    }

    @Override
    public ResourceLocation getTextureLocation(Butterfly entity) {
        return null;
    }



    @Override
    public void render(Butterfly entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()) {
            poseStack.scale(0.45f,0.45f,0.45f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

}
