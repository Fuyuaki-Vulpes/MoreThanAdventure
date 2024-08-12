package com.fuyuaki.morethanadventure.game.client.renderer.entity.layers;

import com.fuyuaki.morethanadventure.world.entity.Butterfly;
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

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class ButterflyWingsOverlay extends GeoRenderLayer<Butterfly> {
    private static final ResourceLocation OVERLAY_A = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/butterfly/overlay_a.png");
    private static final ResourceLocation OVERLAY_B = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/butterfly/overlay_b.png");
    private static final ResourceLocation OVERLAY_C = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/butterfly/overlay_c.png");
    private static final ResourceLocation OVERLAY_D = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/butterfly/overlay_d.png");


    public ButterflyWingsOverlay(GeoRenderer<Butterfly> entityRendererIn) {
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


        return switch (animatable.getOverlay()) {
            case 0 -> OVERLAY_A;
            case 1 -> OVERLAY_B;
            case 2 -> OVERLAY_C;
            case 3 -> OVERLAY_D;
            default -> throw new IllegalStateException("Unexpected value: " + animatable.getOverlay());
        };
    }
}
