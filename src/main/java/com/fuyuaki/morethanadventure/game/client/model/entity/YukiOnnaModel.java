package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.game.client.model.animation.AnimUtils;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.YukiOnnaRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class YukiOnnaModel<T extends YukiOnnaRenderState> extends EntityModel<T> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart right_bang;
    private final ModelPart left_bang;
    private final ModelPart back_hair;
    private final ModelPart right_arm;
    private final ModelPart left_arm;
    private final ModelPart torso;
    private final ModelPart fabric_a;
    private final ModelPart fabric_b;
    private final ModelPart robe_bottom;

    public YukiOnnaModel(ModelPart main) {
        super(main);
        this.root = main.getChild("root");
        this.head = this.root.getChild("head");
        this.right_bang = this.head.getChild("right_bang");
        this.left_bang = this.head.getChild("left_bang");
        this.back_hair = this.head.getChild("back_hair");
        this.right_arm = this.root.getChild("right_arm");
        this.left_arm = this.root.getChild("left_arm");
        this.torso = this.root.getChild("torso");
        this.fabric_a = this.root.getChild("fabric_a");
        this.fabric_b = this.root.getChild("fabric_b");
        this.robe_bottom = this.root.getChild("robe_bottom");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(32, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, -24.0F, 0.0F));

        PartDefinition right_bang = head.addOrReplaceChild("right_bang", CubeListBuilder.create().texOffs(64, 0).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.25F)), PartPose.offset(-3.0F, -5.0F, -3.0F));

        PartDefinition left_bang = head.addOrReplaceChild("left_bang", CubeListBuilder.create().texOffs(64, 0).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.25F)).mirror(false), PartPose.offset(3.0F, -5.0F, -3.0F));

        PartDefinition back_hair = head.addOrReplaceChild("back_hair", CubeListBuilder.create().texOffs(72, 0).addBox(-4.0F, 0.5F, -1.0F, 8.0F, 15.0F, 3.0F, new CubeDeformation(0.5F)), PartPose.offset(0.0F, 0.5F, 2.0F));

        PartDefinition right_arm = root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(40, 32).addBox(-3.0F, 10.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(24, 28).addBox(-4.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -23.0F, 0.0F));

        PartDefinition left_arm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(40, 32).mirror().addBox(0.0F, 10.0F, -1.5F, 3.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(24, 28).mirror().addBox(0.0F, -1.0F, -2.0F, 4.0F, 11.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, -23.0F, 0.0F));

        PartDefinition torso = root.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(58, 16).addBox(2.0F, -3.5F, -3.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-3.5F, -11.5F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(52, 21).addBox(0.0F, -9.5F, -2.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(52, 26).addBox(0.0F, -1.5F, -2.5F, 1.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 16).addBox(-4.0F, -6.5F, -2.5F, 9.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(24, 22).addBox(-4.0F, -2.5F, -2.5F, 9.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.5F, -12.5F, 0.0F));

        PartDefinition cube_r1 = torso.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(52, 16).mirror().addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.0F, -10.0F, -2.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r2 = torso.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(52, 16).addBox(-0.5F, -2.5F, -0.5F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -10.0F, -2.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition fabric_a = root.addOrReplaceChild("fabric_a", CubeListBuilder.create().texOffs(101, 0).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.25F, -14.0F, -2.0F));

        PartDefinition fabric_b = root.addOrReplaceChild("fabric_b", CubeListBuilder.create().texOffs(94, 0).addBox(-1.0F, 0.0F, -0.5F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.75F, -14.0F, -2.5F));

        PartDefinition robe_bottom = root.addOrReplaceChild("robe_bottom", CubeListBuilder.create().texOffs(0, 33).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(T state) {
        super.setupAnim(state);
        //AnimUtils.adjustHead(this.head,netHeadYaw,headPitch);
        AnimUtils.adjustHead(this.head,state.yRot,state.xRot);
        //AnimUtils.animateWalkRot(this.left_arm,limbSwing,limbSwingAmount,0.7F,false);
        AnimUtils.animateWalkRot(this.left_arm,state.walkAnimationPos, state.walkAnimationSpeed,0.7F,false);
        AnimUtils.animateWalkRot(this.right_arm,state.walkAnimationPos, state.walkAnimationSpeed, 0.7F,true);
    }
}