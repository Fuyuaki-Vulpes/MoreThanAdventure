package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.world.entity.Ferret;
import com.fuyuaki.morethanadventure.world.entity.YukiOnna;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class FerretModel<T extends Ferret> extends HierarchicalModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    private final ModelPart root;
    private final ModelPart body_front;
    private final ModelPart head;
    private final ModelPart left_front_leg;
    private final ModelPart right_front_leg;
    private final ModelPart body_back;
    private final ModelPart left_back_leg;
    private final ModelPart right_back_leg;
    private final ModelPart tail;

    public FerretModel(ModelPart root) {
        this.root = root.getChild("root");
        this.body_front = root.getChild("body_front");
        this.head = root.getChild("head");
        this.left_front_leg = root.getChild("left_front_leg");
        this.right_front_leg = root.getChild("right_front_leg");
        this.body_back = root.getChild("body_back");
        this.left_back_leg = root.getChild("left_back_leg");
        this.right_back_leg = root.getChild("right_back_leg");
        this.tail = root.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body_front = root.addOrReplaceChild("body_front", CubeListBuilder.create().texOffs(0, 6).addBox(-2.0F, -1.5F, -5.0F, 4.0F, 3.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 1.0F));

        PartDefinition head = body_front.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -2.0F, -2.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(12, 0).addBox(-1.0F, -1.1F, -4.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(20, 0).addBox(0.9F, -2.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 0).addBox(-0.6F, -1.2F, -4.2F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 0).mirror().addBox(-1.9F, -2.5F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -0.5F, -5.0F));

        PartDefinition left_front_leg = body_front.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(18, 11).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.5F, -3.5F));

        PartDefinition right_front_leg = body_front.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(18, 11).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.5F, -3.5F));

        PartDefinition body_back = root.addOrReplaceChild("body_back", CubeListBuilder.create().texOffs(0, 14).addBox(-2.0F, -1.5F, 0.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.5F, 1.0F));

        PartDefinition left_back_leg = body_back.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(22, 11).addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.5F, 2.5F));

        PartDefinition right_back_leg = body_back.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(22, 11).mirror().addBox(-0.5F, 0.0F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.5F, 2.5F));

        PartDefinition tail = body_back.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 21).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.5F, 4.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(Ferret entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

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