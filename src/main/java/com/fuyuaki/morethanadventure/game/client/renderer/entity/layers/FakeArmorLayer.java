package com.fuyuaki.morethanadventure.game.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.RangedAttackMob;

public class FakeArmorLayer <T extends Mob, M extends EntityModel<T>> extends RenderLayer<T, M> {
    private final HumanoidModel<T> layerModel;
    private final ResourceLocation clothesLocation;

    public FakeArmorLayer(RenderLayerParent<T, M> renderer, EntityModelSet models, ModelLayerLocation modelLayerLocation, ResourceLocation clothesLocation) {
        super(renderer);
        this.clothesLocation = clothesLocation;
        this.layerModel = new HumanoidModel<>(models.bakeLayer(modelLayerLocation));
    }

    public void render(
            PoseStack poseStack,
            MultiBufferSource bufferSource,
            int packedLight,
            T livingEntity,
            float limbSwing,
            float limbSwingAmount,
            float partialTick,
            float ageInTicks,
            float netHeadYaw,
            float headPitch
    ) {
        coloredCutoutModelCopyLayerRender(
                this.getParentModel(),
                this.layerModel,
                this.clothesLocation,
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
                -1
        );
    }
}
