package com.fuyuaki.morethanadventure.game.client.renderer.entity.layers;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.ButterflyModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.ButterflyRenderState;
import com.fuyuaki.morethanadventure.world.entity.Butterfly;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;


public class ButterflyWingLayer extends RenderLayer<ButterflyRenderState,ButterflyModel<ButterflyRenderState>> {

    private static final ResourceLocation PATTERN_A = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/butterfly/pattern_a.png");
    private static final ResourceLocation PATTERN_B = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/butterfly/pattern_b.png");
    private static final ResourceLocation PATTERN_C = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/butterfly/pattern_c.png");
    private final ButterflyModel<ButterflyRenderState> modelLayer;

    public ButterflyWingLayer(RenderLayerParent<ButterflyRenderState,ButterflyModel<ButterflyRenderState>> renderer, EntityModelSet modelSet) {
        super(renderer);
        this.modelLayer = new ButterflyModel<>(modelSet.bakeLayer(MTAModelLayers.BUTTERFLY_PATTERN));

    }



    protected ResourceLocation getPattern(int pattern) {


        return switch (pattern) {
            case 0 -> PATTERN_A;
            case 1 -> PATTERN_B;
            case 2 -> PATTERN_C;
            default -> throw new IllegalStateException("Unexpected value: " + pattern);
        };
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, ButterflyRenderState p_361554_, float p_117353_, float p_117354_) {
        int i = p_361554_.patternColor.getTextureDiffuseColor();
        coloredCutoutModelCopyLayerRender(
                this.getParentModel(),
                this.getPattern(p_361554_.patternId),
                poseStack,
                bufferSource,
                packedLight,
                p_361554_,
                i);
    }
}
