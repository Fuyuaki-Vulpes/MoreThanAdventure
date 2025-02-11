package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.ToucanModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.ToucanRenderState;
import com.fuyuaki.morethanadventure.world.entity.Toucan;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class ToucanRenderer extends MobRenderer<Toucan, ToucanRenderState, ToucanModel<ToucanRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/toucan.png");

    public ToucanRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new ToucanModel<>(pContext.bakeLayer(MTAModelLayers.TOUCAN)), .5F);
    }


    @Override
    public ResourceLocation getTextureLocation(ToucanRenderState renderState) {
        return TEXTURE;
    }

    @Override
    public void render(ToucanRenderState renderState, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(renderState.isBaby) {
            poseStack.scale(0.45f,0.45f,0.45f);
        }
        super.render(renderState, poseStack, bufferSource, packedLight);
    }

    @Override
    public void extractRenderState(Toucan toucan, ToucanRenderState state, float v) {
        super.extractRenderState(toucan, state, v);
        float f = Mth.lerp(v, toucan.oFlap, toucan.flap);
        float f1 = Mth.lerp(v, toucan.oFlapSpeed, toucan.flapSpeed);
        state.flapAngle = (Mth.sin(f) + 1.0F) * f1;
        state.isFlying = toucan.isFlying();
    }

    @Override
    public ToucanRenderState createRenderState() {
        return new ToucanRenderState();
    }
}
