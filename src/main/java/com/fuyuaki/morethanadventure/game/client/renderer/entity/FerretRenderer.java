package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.FerretModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.DuckRenderState;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.FerretRenderState;
import com.fuyuaki.morethanadventure.world.entity.Ferret;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class FerretRenderer extends MobRenderer<Ferret, FerretRenderState, FerretModel<FerretRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/ferret.png");

    public FerretRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new FerretModel<>(pContext.bakeLayer(MTAModelLayers.FERRET)), .5F);
    }


    @Override
    public ResourceLocation getTextureLocation(FerretRenderState renderState) {
        return TEXTURE;
    }

    @Override
    public void render(FerretRenderState renderState, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(renderState.isBaby) {
            poseStack.scale(0.45f,0.45f,0.45f);
        }
        super.render(renderState, poseStack, bufferSource, packedLight);
    }

    @Override
    public FerretRenderState createRenderState() {
        return new FerretRenderState();
    }
}
