package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.world.entity.GreatWhiteShark;
import com.fuyuaki.morethanadventure.world.entity.YukiOnna;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class GreatWhiteSharkModel <T extends GreatWhiteShark> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    private final ModelPart root;
    private final ModelPart torso;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart left_fin;
    private final ModelPart right_fin;
    private final ModelPart torso_back;
    private final ModelPart tail;
    private final ModelPart fin;

    public GreatWhiteSharkModel(ModelPart main) {
        this.root = main.getChild("root");
        this.torso = this.root.getChild("torso");
        this.head = this.torso.getChild("head");
        this.jaw = this.head.getChild("jaw");
        this.left_fin = this.torso.getChild("left_fin");
        this.right_fin = this.torso.getChild("right_fin");
        this.torso_back = this.root.getChild("torso_back");
        this.tail = this.torso_back.getChild("tail");
        this.fin = this.tail.getChild("fin");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 16.0F, 0.0F));

        PartDefinition torso = root.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 41).addBox(-9.0F, -9.0F, -29.0F, 18.0F, 16.0F, 29.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 8.0F));

        PartDefinition cube_r1 = torso.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(1, 44).addBox(-1.0F, -14.0F, -2.0F, 2.0F, 14.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -9.0F, -20.0F, -0.48F, 0.0F, 0.0F));

        PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -6.0F, -17.0F, 12.0F, 8.0F, 17.0F, new CubeDeformation(0.0F))
                .texOffs(47, 0).addBox(-4.0F, 2.0F, -11.9F, 8.0F, 1.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(36, 25).addBox(-3.5F, 2.0F, -11.0F, 7.0F, 1.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -29.0F));

        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(0, 25).addBox(-6.0F, -1.0F, -12.0F, 12.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(0, 102).addBox(-5.0F, -2.0F, -11.0F, 10.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(0, 114).addBox(-4.5F, -2.0F, -10.0F, 9.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 3.0F, 0.0F));

        PartDefinition left_fin = torso.addOrReplaceChild("left_fin", CubeListBuilder.create().texOffs(0, 86).addBox(0.0F, -1.0F, -5.0F, 18.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(9.0F, 5.0F, -17.0F));

        PartDefinition right_fin = torso.addOrReplaceChild("right_fin", CubeListBuilder.create().texOffs(0, 86).mirror().addBox(-18.0F, -1.0F, -5.0F, 18.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-9.0F, 5.0F, -17.0F));

        PartDefinition torso_back = root.addOrReplaceChild("torso_back", CubeListBuilder.create().texOffs(66, 96).addBox(-6.0F, -6.5F, 0.0F, 12.0F, 14.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 8.0F));

        PartDefinition cube_r2 = torso_back.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(65, 64).addBox(-0.5F, -3.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, -5.0F, 19.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition cube_r3 = torso_back.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(94, 73).mirror().addBox(-0.5F, 0.0F, -1.0F, 1.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.5F, 7.0F, 6.0F, 0.829F, 0.2182F, 0.4363F));

        PartDefinition cube_r4 = torso_back.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(94, 73).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 7.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.5F, 7.0F, 6.0F, 0.829F, -0.2182F, -0.4363F));

        PartDefinition tail = torso_back.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(80, 44).addBox(-4.0F, -4.0F, 0.0F, 8.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 19.0F));

        PartDefinition cube_r5 = tail.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(120, 53).addBox(-0.5F, 0.0F, -1.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 5.0F, 3.0F, 0.7854F, 0.0F, 0.0F));

        PartDefinition fin = tail.addOrReplaceChild("fin", CubeListBuilder.create(), PartPose.offset(0.0F, 1.0F, 13.0F));

        PartDefinition cube_r6 = fin.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(106, 4).addBox(-1.0F, 0.0F, -4.0F, 2.0F, 17.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, 1.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition cube_r7 = fin.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(74, 0).addBox(-2.0F, -24.0F, -6.0F, 3.0F, 24.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.25F, -1.0F, 1.0F, -0.3927F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 129);
    }

    @Override
    public void setupAnim(GreatWhiteShark entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

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