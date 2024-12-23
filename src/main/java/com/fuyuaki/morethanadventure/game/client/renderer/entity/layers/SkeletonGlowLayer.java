package com.fuyuaki.morethanadventure.game.client.renderer.entity.layers;

import com.fuyuaki.morethanadventure.game.client.renderer.entity.CorrosiveCubeRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;

public class SkeletonGlowLayer <T extends SkeletonRenderState, M extends SkeletonModel<T>> extends RenderLayer<T, M> {
    private final EntityModel<T> model;
    private final ResourceLocation textureLocation;

    public SkeletonGlowLayer(RenderLayerParent<T, M> renderer, EntityModelSet modelSet, ModelLayerLocation layer, ResourceLocation texture) {
        super(renderer);
        this.textureLocation = texture;
        this.model = new SkeletonModel<>(modelSet.bakeLayer(layer));

    }

    @Override
    public void render(PoseStack p_117349_, MultiBufferSource p_117350_, int p_117351_, T p_361554_, float p_117353_, float p_117354_) {
        boolean flag = p_361554_.appearsGlowing && p_361554_.isInvisible;
        if (!p_361554_.isInvisible || flag) {
            VertexConsumer vertexconsumer;
            if (flag) {
                vertexconsumer = p_117350_.getBuffer(RenderType.outline(textureLocation));
            } else {
                vertexconsumer = p_117350_.getBuffer(RenderType.entityTranslucentEmissive(textureLocation));
            }

            this.model.setupAnim(p_361554_);
            this.model.renderToBuffer(p_117349_, vertexconsumer, p_117351_, LivingEntityRenderer.getOverlayCoords(p_361554_, 0.0F));
        }
    }
}
