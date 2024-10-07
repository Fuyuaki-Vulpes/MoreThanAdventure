package com.fuyuaki.morethanadventure.game.client.renderer.entity.layers;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.ButterflyModel;
import com.fuyuaki.morethanadventure.world.entity.Butterfly;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.CatModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cat;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;


public class ButterflyOverlayLayer extends RenderLayer<Butterfly,ButterflyModel<Butterfly>> {

    private static final ResourceLocation OVERLAY_A = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/butterfly/overlay_a.png");
    private static final ResourceLocation OVERLAY_B = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/butterfly/overlay_b.png");
    private static final ResourceLocation OVERLAY_C = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/butterfly/overlay_c.png");
    private static final ResourceLocation OVERLAY_D = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/butterfly/overlay_d.png");
    private final ButterflyModel<Butterfly> modelLayer;

    public ButterflyOverlayLayer(RenderLayerParent<Butterfly,ButterflyModel<Butterfly>> renderer, EntityModelSet modelSet) {
        super(renderer);
        this.modelLayer = new ButterflyModel<>(modelSet.bakeLayer(MTAModelLayers.BUTTERFLY_OVERLAY));

    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, Butterfly livingEntity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        int i = livingEntity.getOverlayColor().getTextureDiffuseColor();
        coloredCutoutModelCopyLayerRender(
                this.getParentModel(),
                this.modelLayer,
                this.getOverlay(livingEntity),
                poseStack,
                bufferSource,
                packedLight,
                livingEntity,
                limbSwing,
                limbSwingAmount,
                ageInTicks,
                netHeadYaw,
                headPitch,
                partialTick,
                i);
    }


    protected ResourceLocation getOverlay(Butterfly animatable) {


        return switch (animatable.getOverlay()) {
            case 0 -> OVERLAY_A;
            case 1 -> OVERLAY_B;
            case 2 -> OVERLAY_C;
            case 3 -> OVERLAY_D;
            default -> throw new IllegalStateException("Unexpected value: " + animatable.getOverlay());
        };
    }


}
