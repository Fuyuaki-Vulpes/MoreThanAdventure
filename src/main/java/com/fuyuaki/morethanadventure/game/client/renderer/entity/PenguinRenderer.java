package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.PenguinModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.PenguinRenderState;
import com.fuyuaki.morethanadventure.world.entity.Penguin;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class PenguinRenderer extends MobRenderer<Penguin, PenguinRenderState, PenguinModel<PenguinRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/penguin.png");

    public PenguinRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new PenguinModel<>(pContext.bakeLayer(MTAModelLayers.PENGUIN)), .5F);
    }


    @Override
    public ResourceLocation getTextureLocation(PenguinRenderState renderState) {
        return TEXTURE;
    }


    @Override
    public void render(PenguinRenderState renderState, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(renderState.isBaby) {
            poseStack.scale(0.45f,0.45f,0.45f);
        }
        super.render(renderState, poseStack, bufferSource, packedLight);
    }

    @Override
    public PenguinRenderState createRenderState() {
        return new PenguinRenderState();
    }
}
