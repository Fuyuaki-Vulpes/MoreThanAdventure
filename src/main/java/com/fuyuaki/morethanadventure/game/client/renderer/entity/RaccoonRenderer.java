package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.RaccoonModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.RaccoonRenderState;
import com.fuyuaki.morethanadventure.world.entity.Raccoon;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class RaccoonRenderer extends MobRenderer<Raccoon, RaccoonRenderState, RaccoonModel<RaccoonRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/raccoon.png");

    public RaccoonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new RaccoonModel<>(pContext.bakeLayer(MTAModelLayers.RACCOON)), .5F);
    }


    @Override
    public ResourceLocation getTextureLocation(RaccoonRenderState renderState) {
        return TEXTURE;
    }


    @Override
    public void render(RaccoonRenderState renderState, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(renderState.isBaby) {
            poseStack.scale(0.45f,0.45f,0.45f);
        }
        super.render(renderState, poseStack, bufferSource, packedLight);
    }

    @Override
    public RaccoonRenderState createRenderState() {
        return new RaccoonRenderState();
    }
}
