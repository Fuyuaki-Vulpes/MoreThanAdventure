package com.fuyuaki.morethanadventure.game.client.renderer.entity.layers;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.CorrosiveCubeModel;
import com.fuyuaki.morethanadventure.world.entity.CorrosiveCube;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.entity.LivingEntity;

public class CorrosiveCubeOuterLayer<T extends CorrosiveCube> extends RenderLayer<T, CorrosiveCubeModel<T>> {
    private final EntityModel<T> model;

    public CorrosiveCubeOuterLayer(RenderLayerParent<T, CorrosiveCubeModel<T>> renderer, EntityModelSet modelSet) {
        super(renderer);
        this.model = new CorrosiveCubeModel<>(modelSet.bakeLayer(MTAModelLayers.CORROSIVE_CUBE_OUTER));
    }

    public void render(
            PoseStack poseStack,
            MultiBufferSource buffer,
            int packedLight,
            T livingEntity,
            float limbSwing,
            float limbSwingAmount,
            float partialTicks,
            float ageInTicks,
            float netHeadYaw,
            float headPitch
    ) {
        Minecraft minecraft = Minecraft.getInstance();
        boolean flag = minecraft.shouldEntityAppearGlowing(livingEntity) && livingEntity.isInvisible();
        if (!livingEntity.isInvisible() || flag) {
            VertexConsumer vertexconsumer;
            if (flag) {
                vertexconsumer = buffer.getBuffer(RenderType.outline(this.getTextureLocation(livingEntity)));
            } else {
                vertexconsumer = buffer.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(livingEntity)));
            }

            this.getParentModel().copyPropertiesTo(this.model);
            this.model.prepareMobModel(livingEntity, limbSwing, limbSwingAmount, partialTicks);
            this.model.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, LivingEntityRenderer.getOverlayCoords(livingEntity, 0.0F));
        }
    }
}
