package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.CorrosiveCubeModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.layers.CorrosiveCubeOuterLayer;
import com.fuyuaki.morethanadventure.world.entity.CorrosiveCube;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class CorrosiveCubeRenderer extends MobRenderer<CorrosiveCube, CorrosiveCubeModel<CorrosiveCube>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/slime/corrosive_cube.png");

    public CorrosiveCubeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new CorrosiveCubeModel<>(pContext.bakeLayer(MTAModelLayers.CORROSIVE_CUBE)), .5F);
        this.addLayer(new CorrosiveCubeOuterLayer<>(this, pContext.getModelSet()));

    }

    @Override
    public void render(CorrosiveCube entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        this.shadowRadius = 0.25F * (float)entity.getSize();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    protected void scale(CorrosiveCube livingEntity, PoseStack poseStack, float partialTickTime) {
        float f = 0.999F;
        poseStack.scale(0.999F, 0.999F, 0.999F);
        poseStack.translate(0.0F, 0.001F, 0.0F);
        float f1 = (float)livingEntity.getSize();
        float f2 = Mth.lerp(partialTickTime, livingEntity.oSquish, livingEntity.squish) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        poseStack.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);

    }

    @Override
    public ResourceLocation getTextureLocation(CorrosiveCube entity) {
        return TEXTURE;
    }
}
