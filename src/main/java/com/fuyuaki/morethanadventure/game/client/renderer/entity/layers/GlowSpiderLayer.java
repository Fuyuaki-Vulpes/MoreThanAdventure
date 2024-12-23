package com.fuyuaki.morethanadventure.game.client.renderer.entity.layers;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.CorrosiveCubeRenderer;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.GlowSpiderRenderer;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.GlowSpiderRenderState;
import com.fuyuaki.morethanadventure.world.entity.GlowSpider;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class GlowSpiderLayer <T extends LivingEntityRenderState, M extends SpiderModel> extends RenderLayer<T, M> {
    private M model;

    public GlowSpiderLayer(RenderLayerParent<T, M> renderer, M model) {
        super(renderer);
        this.model = model;

    }

    @Override
    public void render(PoseStack p_117349_, MultiBufferSource p_117350_, int p_117351_, T p_361554_, float p_117353_, float p_117354_) {
        boolean flag = p_361554_.appearsGlowing && p_361554_.isInvisible;
        if (!p_361554_.isInvisible || flag) {
            VertexConsumer vertexconsumer;
            if (flag) {
                vertexconsumer = p_117350_.getBuffer(RenderType.outline(GlowSpiderRenderer.TEXTURE));
            } else {
                vertexconsumer = p_117350_.getBuffer(RenderType.entityTranslucentEmissive(GlowSpiderRenderer.TEXTURE));
            }

            this.model.setupAnim(p_361554_);
            this.model.renderToBuffer(p_117349_, vertexconsumer, p_117351_, LivingEntityRenderer.getOverlayCoords(p_361554_, 0.0F));
        }
    }

}
