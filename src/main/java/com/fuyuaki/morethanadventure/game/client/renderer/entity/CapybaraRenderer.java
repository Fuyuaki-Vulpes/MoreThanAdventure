package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.CapybaraModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.CapybaraRenderState;
import com.fuyuaki.morethanadventure.world.entity.Capybara;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class CapybaraRenderer extends MobRenderer<Capybara, CapybaraRenderState, CapybaraModel<CapybaraRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/capybara.png");

    public CapybaraRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new CapybaraModel<>(pContext.bakeLayer(MTAModelLayers.CAPYBARA)), 0.5F);
    }

    @Override
    public CapybaraRenderState createRenderState() {
        return new CapybaraRenderState();
    }
    @Override
    public void render(CapybaraRenderState renderState, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(renderState.isBaby) {
            poseStack.scale(0.45f,0.45f,0.45f);
        }
        super.render(renderState, poseStack, bufferSource, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(CapybaraRenderState renderState) {
        return TEXTURE;
    }
}
