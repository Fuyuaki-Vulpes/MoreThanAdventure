package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.IcicleCreeperModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.IcicleCreeperRenderState;
import com.fuyuaki.morethanadventure.world.entity.IcicleCreeper;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class IcicleCreeperRenderer extends MobRenderer<IcicleCreeper, IcicleCreeperRenderState, IcicleCreeperModel<IcicleCreeperRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/icicle_creeper.png");

    public IcicleCreeperRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new IcicleCreeperModel<>(pContext.bakeLayer(MTAModelLayers.ICICLE_CREEPER)), 0.5F);
        //this.addLayer(new CreeperPowerLayer(this, pContext.getModelSet()));

    }

    @Override
    public IcicleCreeperRenderState createRenderState() {
        return new IcicleCreeperRenderState();
    }


    @Override
    public ResourceLocation getTextureLocation(IcicleCreeperRenderState renderState) {
        return TEXTURE;
    }




    /*@Override
    public void scaleModelForRender(float widthScale, float heightScale, PoseStack poseStack, IcicleCreeper animatable, BakedGeoModel model, boolean isReRender, float partialTick, int packedLight, int packedOverlay) {
        float f = animatable.getSwelling(partialTick);
        float f1 = 1.0F + Mth.sin(f * 100.0F) * f * 0.01F;
        f = Mth.clamp(f, 0.0F, 1.0F);
        f *= f;
        f *= f;
        float f2 = (1.0F + f * 0.4F) * f1;
        float f3 = (1.0F + f * 0.1F) / f1;
        poseStack.scale(f2, f3, f2);

        super.scaleModelForRender(widthScale, heightScale, poseStack, animatable, model, isReRender, partialTick, packedLight, packedOverlay);
    }*/

}
