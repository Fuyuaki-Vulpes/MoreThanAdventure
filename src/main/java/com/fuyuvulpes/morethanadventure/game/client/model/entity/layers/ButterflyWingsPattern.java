package com.fuyuvulpes.morethanadventure.game.client.model.entity.layers;

import com.fuyuvulpes.morethanadventure.world.entity.Butterfly;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoRenderer;
import software.bernie.geckolib.renderer.layer.GeoRenderLayer;
import software.bernie.geckolib.util.Color;

public class ButterflyWingsPattern extends GeoRenderLayer<Butterfly> {
    public ButterflyWingsPattern(GeoRenderer<Butterfly> entityRendererIn) {
        super(entityRendererIn);
    }


    @Override
    public void render(PoseStack poseStack, Butterfly animatable, BakedGeoModel bakedModel, @Nullable RenderType renderType, MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay) {
        RenderType renderType1 = RenderType.entityCutoutNoCull(getTextureResource(animatable));

        getRenderer().reRender(bakedModel,
                poseStack,
                bufferSource,
                animatable,
                renderType1,
                bufferSource.getBuffer(renderType1),
                partialTick,
                packedLight,
                packedOverlay,
                animatable.getOverlayColor().getTextureDiffuseColor());
    }



    @Override
    protected ResourceLocation getTextureResource(Butterfly animatable) {
        return animatable.getPatternFile();
    }
}
