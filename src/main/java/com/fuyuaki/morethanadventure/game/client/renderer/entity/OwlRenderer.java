package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.OwlModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.OwlRenderState;
import com.fuyuaki.morethanadventure.world.entity.Owl;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class OwlRenderer extends MobRenderer<Owl, OwlRenderState, OwlModel<OwlRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/owl.png");

    public OwlRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new OwlModel<>(pContext.bakeLayer(MTAModelLayers.OWL)), .5F);
    }


    @Override
    public ResourceLocation getTextureLocation(OwlRenderState renderState) {
        return TEXTURE;
    }


    @Override
    public void render(OwlRenderState renderState, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(renderState.isBaby) {
            poseStack.scale(0.45f,0.45f,0.45f);
        }
        super.render(renderState, poseStack, bufferSource, packedLight);
    }

    @Override
    public void extractRenderState(Owl owl, OwlRenderState state, float v) {
        super.extractRenderState(owl, state, v);
        float f = Mth.lerp(v, owl.oFlap, owl.flap);
        float f1 = Mth.lerp(v, owl.oFlapSpeed, owl.flapSpeed);
        state.flapAngle = (Mth.sin(f) + 1.0F) * f1;
        state.isFlying = owl.isFlying();
    }

    @Override
    public OwlRenderState createRenderState() {
        return new OwlRenderState();
    }
}
