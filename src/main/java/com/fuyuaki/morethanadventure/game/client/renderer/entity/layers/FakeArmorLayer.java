package com.fuyuaki.morethanadventure.game.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.ResourceLocation;

public class FakeArmorLayer <T extends HumanoidRenderState, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private final HumanoidModel<T> layerModel;
    private final ResourceLocation clothesLocation;

    public FakeArmorLayer(RenderLayerParent<T, M> renderer, EntityModelSet models, ModelLayerLocation modelLayerLocation, ResourceLocation clothesLocation) {
        super(renderer);
        this.clothesLocation = clothesLocation;
        this.layerModel = new HumanoidModel<>(models.bakeLayer(modelLayerLocation));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, T p_361554_, float p_117353_, float p_117354_) {

        renderColoredCutoutModel(layerModel, clothesLocation, poseStack, bufferSource, packedLight, p_361554_, -1);

    }
}
