package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.world.entity.HorseshoeCrab;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class HorseshoeCrabModel extends HierarchicalModel<HorseshoeCrab> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    private final ModelPart root;

    public HorseshoeCrabModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition front = root.addOrReplaceChild("front", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -2.0F, -6.0F, 6.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 1.0F));

        PartDefinition cube_r1 = front.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(22, -1).mirror().addBox(0.0F, -2.0F, -2.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, -1.35F, -2.7F, -0.1745F, -0.2182F, -0.4363F));

        PartDefinition cube_r2 = front.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(22, -1).addBox(0.0F, -2.0F, -2.0F, 0.0F, 2.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -1.35F, -2.7F, -0.1745F, 0.2182F, 0.4363F));

        PartDefinition back = root.addOrReplaceChild("back", CubeListBuilder.create().texOffs(0, 9).addBox(-2.0F, -1.0F, 0.0F, 4.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 1.0F));

        PartDefinition cube_r3 = back.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(14, 9).mirror().addBox(-1.0F, -2.0F, -2.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, -0.6F, 2.3F, -0.2182F, 0.0F, -0.3927F));

        PartDefinition cube_r4 = back.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(14, 9).addBox(1.0F, -2.0F, -2.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -0.6F, 2.3F, -0.2182F, 0.0F, 0.3927F));

        PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 14).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 4.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(HorseshoeCrab entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return root;
    }
}
