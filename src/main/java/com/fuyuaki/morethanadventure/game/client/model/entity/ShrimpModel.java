package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.ShrimpRenderState;
import com.fuyuaki.morethanadventure.world.entity.Shrimp;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class ShrimpModel<T extends ShrimpRenderState> extends EntityModel<T> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart tail;
    private final ModelPart head;
    private final ModelPart left_claw;
    private final ModelPart right_claw;

    public ShrimpModel(ModelPart main) {
        this.root = main.getChild("root");
        this.body = this.root.getChild("body");
        this.tail = this.body.getChild("tail");
        this.head = this.root.getChild("head");
        this.left_claw = this.head.getChild("left_claw");
        this.right_claw = this.head.getChild("right_claw");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 5).addBox(-1.0F, -1.0F, 0.0F, 2.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, -1).addBox(1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, -1).mirror().addBox(-1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(10, 6).addBox(-0.5F, -0.5F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(6, 14).addBox(-1.5F, 0.0F, 1.5F, 3.0F, 0.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -0.5F, 4.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -3.0F, 2.0F, 2.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).addBox(0.75F, -4.0F, -5.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 8).mirror().addBox(-0.75F, -4.0F, -5.0F, 0.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, -1).addBox(1.0F, 1.0F, -1.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, -1).mirror().addBox(-1.0F, 1.0F, -1.5F, 0.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition left_claw = head.addOrReplaceChild("left_claw", CubeListBuilder.create().texOffs(8, 2).addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 1.0F, -1.0F));

        PartDefinition right_claw = head.addOrReplaceChild("right_claw", CubeListBuilder.create().texOffs(8, 2).mirror().addBox(-0.5F, -0.5F, -3.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, 1.0F, -1.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(Shrimp entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

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
