package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.world.entity.Octopus;
import com.fuyuaki.morethanadventure.world.entity.YukiOnna;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class OctopusModel <T extends Octopus> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart mantle;
    private final ModelPart beak_right;
    private final ModelPart beak_left;
    private final ModelPart legs;
    private final ModelPart leg_1;
    private final ModelPart leg_2;
    private final ModelPart leg_3;
    private final ModelPart leg_4;
    private final ModelPart leg_5;
    private final ModelPart leg_6;
    private final ModelPart leg_7;
    private final ModelPart leg_8;

    public OctopusModel(ModelPart root) {
        this.root = root.getChild("root");
        this.head = root.getChild("head");
        this.mantle = root.getChild("mantle");
        this.beak_right = root.getChild("beak_right");
        this.beak_left = root.getChild("beak_left");
        this.legs = root.getChild("legs");
        this.leg_1 = root.getChild("leg_1");
        this.leg_2 = root.getChild("leg_2");
        this.leg_3 = root.getChild("leg_3");
        this.leg_4 = root.getChild("leg_4");
        this.leg_5 = root.getChild("leg_5");
        this.leg_6 = root.getChild("leg_6");
        this.leg_7 = root.getChild("leg_7");
        this.leg_8 = root.getChild("leg_8");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(28, 5).addBox(-2.5F, -5.0F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(54, 10).addBox(-3.5F, -4.5F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(54, 10).mirror().addBox(1.5F, -4.5F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(46, 8).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 1.0F, 2.75F, 0.2618F, 0.0F, -0.3491F));

        PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(46, 8).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.0F, 2.75F, 0.2618F, 0.0F, 0.3491F));

        PartDefinition mantle = head.addOrReplaceChild("mantle", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, 0.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 2.0F));

        PartDefinition beak_right = head.addOrReplaceChild("beak_right", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition beak_left = head.addOrReplaceChild("beak_left", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition legs = root.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leg_1 = legs.addOrReplaceChild("leg_1", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, -1.0F, -18.0F, 3.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -2.0F));

        PartDefinition leg_2 = legs.addOrReplaceChild("leg_2", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, -1.0F, -18.0F, 3.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 0.0F, -2.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition leg_3 = legs.addOrReplaceChild("leg_3", CubeListBuilder.create().texOffs(0, 35).addBox(-18.0F, -1.0F, -1.5F, 19.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.5F, 0.0F, 0.0F));

        PartDefinition leg_4 = legs.addOrReplaceChild("leg_4", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, 0.0F, 2.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition leg_5 = legs.addOrReplaceChild("leg_5", CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 2.0F));

        PartDefinition leg_6 = legs.addOrReplaceChild("leg_6", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-1.5F, -1.0F, -18.0F, 3.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 0.0F, -2.0F, 0.0F, -0.7854F, 0.0F));

        PartDefinition leg_7 = legs.addOrReplaceChild("leg_7", CubeListBuilder.create().texOffs(0, 35).mirror().addBox(-1.0F, -1.0F, -1.5F, 19.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.5F, 0.0F, 0.0F));

        PartDefinition leg_8 = legs.addOrReplaceChild("leg_8", CubeListBuilder.create().texOffs(0, 14).mirror().addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 19.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.5F, 0.0F, 2.0F, 0.0F, 0.7854F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(Octopus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

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