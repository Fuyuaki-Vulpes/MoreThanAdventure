package com.fuyuaki.morethanadventure.game.client.renderer.entity.layers;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.ButterflyModel;
import com.fuyuaki.morethanadventure.world.entity.Butterfly;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;


public class ButterflyWingLayer extends RenderLayer<Butterfly,ButterflyModel<Butterfly>> {

    private static final ResourceLocation PATTERN_A = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/butterfly/pattern_a.png");
    private static final ResourceLocation PATTERN_B = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/butterfly/pattern_b.png");
    private static final ResourceLocation PATTERN_C = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/butterfly/pattern_c.png");
    private final ButterflyModel<Butterfly> modelLayer;

    public ButterflyWingLayer(RenderLayerParent<Butterfly,ButterflyModel<Butterfly>> renderer, EntityModelSet modelSet) {
        super(renderer);
        this.modelLayer = new ButterflyModel<>(modelSet.bakeLayer(MTAModelLayers.BUTTERFLY_PATTERN));

    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, Butterfly livingEntity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        int i = livingEntity.getColor().getTextureDiffuseColor();
        coloredCutoutModelCopyLayerRender(
                this.getParentModel(),
                this.modelLayer,
                this.getPattern(livingEntity),
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

    protected ResourceLocation getPattern(Butterfly animatable) {


        return switch (animatable.getPattern()) {
            case 0 -> PATTERN_A;
            case 1 -> PATTERN_B;
            case 2 -> PATTERN_C;
            default -> throw new IllegalStateException("Unexpected value: " + animatable.getOverlay());
        };
    }

}
