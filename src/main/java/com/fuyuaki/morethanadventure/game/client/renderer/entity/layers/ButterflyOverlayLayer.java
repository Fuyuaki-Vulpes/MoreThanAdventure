package com.fuyuaki.morethanadventure.game.client.renderer.entity.layers;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.ButterflyModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.ButterflyRenderState;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;


public class ButterflyOverlayLayer extends RenderLayer<ButterflyRenderState,ButterflyModel<ButterflyRenderState>> {

    private static final ResourceLocation OVERLAY_A = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/butterfly/overlay_a.png");
    private static final ResourceLocation OVERLAY_B = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/butterfly/overlay_b.png");
    private static final ResourceLocation OVERLAY_C = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/butterfly/overlay_c.png");
    private static final ResourceLocation OVERLAY_D = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/butterfly/overlay_d.png");
    private final ButterflyModel<ButterflyRenderState> modelLayer;

    public ButterflyOverlayLayer(RenderLayerParent<ButterflyRenderState,ButterflyModel<ButterflyRenderState>> renderer, EntityModelSet modelSet) {
        super(renderer);
        this.modelLayer = new ButterflyModel<>(modelSet.bakeLayer(MTAModelLayers.BUTTERFLY_OVERLAY));

    }

    protected ResourceLocation getOverlay(int overlay) {


        return switch (overlay) {
            case 0 -> OVERLAY_A;
            case 1 -> OVERLAY_B;
            case 2 -> OVERLAY_C;
            case 3 -> OVERLAY_D;
            default -> throw new IllegalStateException("Unexpected value: " + overlay);
        };
    }


    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, ButterflyRenderState p_361554_, float p_117353_, float p_117354_) {
        int i = p_361554_.overlayColor.getTextureDiffuseColor();
        coloredCutoutModelCopyLayerRender(
                this.getParentModel(),
                this.getOverlay(p_361554_.overlayId),
                poseStack,
                bufferSource,
                packedLight,
                p_361554_,
                i);
    }
}
