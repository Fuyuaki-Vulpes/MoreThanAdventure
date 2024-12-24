package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.DeerModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.DeerRenderState;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.Deer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class DeerRenderer extends MobRenderer<Deer, DeerRenderState, DeerModel<DeerRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/deer.png");

    public DeerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new DeerModel<>(pContext.bakeLayer(MTAModelLayers.DEER)), .5F);
    }

    @Override
    public DeerRenderState createRenderState() {
        return null;
        return new DeerRenderState();
    }

    @Override
    public void render(DeerRenderState renderState, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(renderState.isBaby) {
            poseStack.scale(0.45f,0.45f,0.45f);
        }

        super.render(renderState, poseStack, bufferSource, packedLight);
    }


    @Override
    public ResourceLocation getTextureLocation(DeerRenderState p_368654_) {
        return null;
    }
}
