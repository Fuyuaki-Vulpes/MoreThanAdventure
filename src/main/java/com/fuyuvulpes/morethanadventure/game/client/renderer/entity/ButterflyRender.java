package com.fuyuvulpes.morethanadventure.game.client.renderer.entity;

import com.fuyuvulpes.morethanadventure.game.client.model.entity.ButterflyModel;
import com.fuyuvulpes.morethanadventure.game.client.model.entity.layers.ButterflyWingsOverlay;
import com.fuyuvulpes.morethanadventure.game.client.model.entity.layers.ButterflyWingsPattern;
import com.fuyuvulpes.morethanadventure.world.entity.Butterfly;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ButterflyRender extends GeoEntityRenderer<Butterfly> {
    public ButterflyRender(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ButterflyModel());
        addRenderLayer(new ButterflyWingsPattern(this));
        addRenderLayer(new ButterflyWingsOverlay(this));
    }


    @Override
    public void scaleModelForRender(float widthScale, float heightScale, PoseStack poseStack, Butterfly animatable, BakedGeoModel model, boolean isReRender, float partialTick, int packedLight, int packedOverlay) {
        if (animatable.isBaby()){
            widthScale = 0.5F;
            heightScale = 0.5F;
        }
        super.scaleModelForRender(widthScale, heightScale, poseStack, animatable, model, isReRender, partialTick, packedLight, packedOverlay);
    }
}
