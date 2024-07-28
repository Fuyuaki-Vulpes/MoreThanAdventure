package com.fuyuvulpes.morethanadventure.game.client.renderer.entity.layers;

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

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class ButterflyWingsPattern extends GeoRenderLayer<Butterfly> {

    private static final ResourceLocation PATTERN_A = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/butterfly/pattern_a.png");
    private static final ResourceLocation PATTERN_B = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/butterfly/pattern_b.png");
    private static final ResourceLocation PATTERN_C = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/butterfly/pattern_c.png");

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
                animatable.getColor().getTextureDiffuseColor());
    }

    @Override
    protected ResourceLocation getTextureResource(Butterfly animatable) {


        return switch (animatable.getPattern()) {
            case 0 -> PATTERN_A;
            case 1 -> PATTERN_B;
            case 2 -> PATTERN_C;
            default -> throw new IllegalStateException("Unexpected value: " + animatable.getOverlay());
        };
    }

}