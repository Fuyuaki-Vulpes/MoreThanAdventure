package com.fuyuaki.morethanadventure.game.client.renderer.entity.layers;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.WispflyModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.WispflyRenderer;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.WispflyRenderState;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;

public class WispflyOuterLayer<T extends WispflyRenderState> extends RenderLayer<T, WispflyModel<T>> {
    private final EntityModel<T> model;

    public WispflyOuterLayer(RenderLayerParent<T, WispflyModel<T>> renderer, EntityModelSet modelSet) {
        super(renderer);
        this.model = new WispflyModel<>(modelSet.bakeLayer(MTAModelLayers.WISPFLY_OUTER_LAYER));

    }


    @Override
    public void render(PoseStack p_117349_, MultiBufferSource p_117350_, int p_117351_, T p_361554_, float p_117353_, float p_117354_) {
        boolean flag = p_361554_.appearsGlowing && p_361554_.isInvisible;
        if (!p_361554_.isInvisible || flag) {
            VertexConsumer vertexconsumer;
            if (flag) {
                vertexconsumer = p_117350_.getBuffer(RenderType.outline(WispflyRenderer.TEXTURE));
            } else {
                vertexconsumer = p_117350_.getBuffer(RenderType.entityTranslucentEmissive(WispflyRenderer.TEXTURE));
            }

            this.model.setupAnim(p_361554_);
            this.model.renderToBuffer(p_117349_, vertexconsumer, p_117351_, LivingEntityRenderer.getOverlayCoords(p_361554_, 0.0F));
        }
    }
}
