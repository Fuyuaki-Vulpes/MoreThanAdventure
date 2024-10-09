package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.world.entity.WitherJuggernaut;
import com.fuyuaki.morethanadventure.world.entity.YukiOnna;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class WitherJuggernautModel <T extends WitherJuggernaut> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart hips;
    private final ModelPart spine_low;
    private final ModelPart spine_top;
    private final ModelPart chest;
    private final ModelPart head;
    private final ModelPart jaw;
    private final ModelPart helmet;
    private final ModelPart left_arm;
    private final ModelPart left_armor;
    private final ModelPart left_armplate;
    private final ModelPart left_hand;
    private final ModelPart right_arm;
    private final ModelPart right_armor;
    private final ModelPart right_armplate;
    private final ModelPart right_hand;
    private final ModelPart left_leg;
    private final ModelPart left_leg_bottom;
    private final ModelPart left_boot;
    private final ModelPart right_leg;
    private final ModelPart right_leg_bottom;
    private final ModelPart right_boot;

    public WitherJuggernautModel(ModelPart main) {
        this.root = main.getChild("root");
        this.hips = this.root.getChild("hips");
        this.spine_low = this.hips.getChild("spine_low");
        this.spine_top = this.spine_low.getChild("spine_top");
        this.chest = this.spine_top.getChild("chest");
        this.head = this.chest.getChild("head");
        this.jaw = this.head.getChild("jaw");
        this.helmet = this.head.getChild("helmet");
        this.left_arm = this.chest.getChild("left_arm");
        this.left_armor = this.left_arm.getChild("left_armor");
        this.left_armplate =this.left_armor.getChild("left_armplate");
        this.left_hand = this.left_arm.getChild("left_hand");
        this.right_arm = this.chest.getChild("right_arm");
        this.right_armor = this.right_arm.getChild("right_armor");
        this.right_armplate = this.right_armor.getChild("right_armplate");
        this.right_hand = this.right_arm.getChild("right_hand");
        this.left_leg = this.root.getChild("left_leg");
        this.left_leg_bottom = this.left_leg.getChild("left_leg_bottom");
        this.left_boot = this.left_leg_bottom.getChild("left_boot");
        this.right_leg = this.root.getChild("right_leg");
        this.right_leg_bottom = this.right_leg.getChild("right_leg_bottom");
        this.right_boot = this.right_leg_bottom.getChild("right_boot");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition hips = root.addOrReplaceChild("hips", CubeListBuilder.create().texOffs(62, 37).addBox(-5.0F, -3.0F, -3.0F, 10.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(36, 32).addBox(-5.0F, -2.0F, -3.0F, 10.0F, 5.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -23.0F, 0.0F));

        PartDefinition cube_r1 = hips.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(24, 34).mirror().addBox(-1.0F, -2.0F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 1.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r2 = hips.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(24, 34).addBox(-1.0F, -2.0F, -2.0F, 2.0F, 7.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

        PartDefinition spine_low = hips.addOrReplaceChild("spine_low", CubeListBuilder.create().texOffs(36, 26).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 1.0F));

        PartDefinition spine_top = spine_low.addOrReplaceChild("spine_top", CubeListBuilder.create().texOffs(44, 26).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

        PartDefinition chest = spine_top.addOrReplaceChild("chest", CubeListBuilder.create().texOffs(58, 17).addBox(-5.0F, -9.0F, 2.0F, 10.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(36, 19).addBox(-5.0F, -10.0F, -5.0F, 10.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-6.0F, -11.0F, -4.0F, 12.0F, 11.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 0.0F));

        PartDefinition cube_r3 = chest.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(64, 26).addBox(-3.0F, -2.0F, -2.0F, 6.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.6F, -2.6F, 0.1745F, 0.0F, 0.0F));

        PartDefinition head = chest.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -11.0F, -1.0F));

        PartDefinition jaw = head.addOrReplaceChild("jaw", CubeListBuilder.create().texOffs(32, 0).addBox(-4.0F, 0.0F, -6.0F, 8.0F, 2.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, 2.0F));

        PartDefinition helmet = head.addOrReplaceChild("helmet", CubeListBuilder.create().texOffs(54, 0).addBox(-5.0F, -1.0F, -5.0F, 10.0F, 6.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.0F, 0.0F));

        PartDefinition cube_r4 = helmet.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(102, 0).addBox(-2.0F, -3.0F, 0.0F, 4.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 6.0F, 4.0F, -0.1745F, 0.0F, 0.0F));

        PartDefinition cube_r5 = helmet.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(84, 0).mirror().addBox(-5.0F, -3.0F, -3.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(84, 0).addBox(3.4F, -3.0F, -3.0F, 2.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.2F, 7.0F, -2.75F, -0.5672F, 0.0F, 0.0F));

        PartDefinition cube_r6 = helmet.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(88, 30).mirror().addBox(0.0F, 0.0F, -3.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-6.0F, 3.0F, 0.0F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r7 = helmet.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(88, 30).addBox(-2.0F, 0.0F, -3.0F, 2.0F, 3.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(6.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.3927F));

        PartDefinition cube_r8 = helmet.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(94, 0).addBox(-1.0F, -3.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, -3.75F, 0.1745F, 0.0F, 0.0F));

        PartDefinition left_arm = chest.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(112, 6).addBox(-4.0F, 12.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(120, 28).addBox(-3.0F, 5.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.0F, -9.0F, -1.0F));

        PartDefinition left_armor = left_arm.addOrReplaceChild("left_armor", CubeListBuilder.create().texOffs(80, 16).addBox(-3.0F, -1.0F, -3.0F, 5.0F, 8.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(96, 11).addBox(-4.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -1.0F, 0.0F));

        PartDefinition left_armplate = left_armor.addOrReplaceChild("left_armplate", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition cube_r9 = left_armplate.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(114, 0).addBox(-4.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 2.0F, 0.0F, 0.0F, 0.0F, 1.9635F));

        PartDefinition cube_r10 = left_armplate.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(114, 0).addBox(-4.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.9635F));

        PartDefinition cube_r11 = left_armplate.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(114, 0).addBox(-4.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.9635F));

        PartDefinition cube_r12 = left_armplate.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(102, 14).addBox(-2.0F, -2.0F, -4.0F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.1781F));

        PartDefinition left_hand = left_arm.addOrReplaceChild("left_hand", CubeListBuilder.create(), PartPose.offset(-2.0F, 17.0F, -1.0F));

        PartDefinition right_arm = chest.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(112, 6).mirror().addBox(0.0F, 12.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(120, 28).mirror().addBox(1.0F, 5.0F, -1.0F, 2.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(6.0F, -9.0F, -1.0F));

        PartDefinition right_armor = right_arm.addOrReplaceChild("right_armor", CubeListBuilder.create().texOffs(80, 16).mirror().addBox(-2.0F, -1.0F, -3.0F, 5.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(96, 11).mirror().addBox(3.0F, 0.0F, -2.0F, 1.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -1.0F, 0.0F));

        PartDefinition right_armplate = right_armor.addOrReplaceChild("right_armplate", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition cube_r13 = right_armplate.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(114, 0).mirror().addBox(1.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 2.0F, 0.0F, 0.0F, 0.0F, -1.9635F));

        PartDefinition cube_r14 = right_armplate.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(114, 0).mirror().addBox(1.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(2.0F, 1.0F, 0.0F, 0.0F, 0.0F, -1.9635F));

        PartDefinition cube_r15 = right_armplate.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(114, 0).mirror().addBox(1.0F, -1.0F, -2.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.9635F));

        PartDefinition cube_r16 = right_armplate.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(102, 14).mirror().addBox(0.0F, -2.0F, -4.0F, 2.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.1781F));

        PartDefinition right_hand = right_arm.addOrReplaceChild("right_hand", CubeListBuilder.create(), PartPose.offset(2.0F, 17.0F, -1.0F));

        PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(0, 31).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -20.0F, 0.0F));

        PartDefinition cube_r17 = left_leg.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(24, 49).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 9.0F, -4.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition left_leg_bottom = left_leg.addOrReplaceChild("left_leg_bottom", CubeListBuilder.create().texOffs(0, 45).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

        PartDefinition left_boot = left_leg_bottom.addOrReplaceChild("left_boot", CubeListBuilder.create().texOffs(30, 51).addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 6.0F, 0.0F));

        PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(0, 31).mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, -20.0F, 0.0F));

        PartDefinition cube_r18 = right_leg.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(24, 49).mirror().addBox(-2.0F, -2.0F, 0.0F, 4.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 9.0F, -4.0F, 0.3927F, 0.0F, 0.0F));

        PartDefinition right_leg_bottom = right_leg.addOrReplaceChild("right_leg_bottom", CubeListBuilder.create().texOffs(0, 45).mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.0F, 0.0F));

        PartDefinition right_boot = right_leg_bottom.addOrReplaceChild("right_boot", CubeListBuilder.create().texOffs(30, 51).mirror().addBox(-3.0F, 0.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 6.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(WitherJuggernaut entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

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
