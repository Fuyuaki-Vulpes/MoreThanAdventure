package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.game.client.model.animation.AnimUtils;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.FallenSamuraiRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class FallenSamuraiModel <T extends FallenSamuraiRenderState> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart hat;
    private final ModelPart scarf_tail_back;
    private final ModelPart scarf_tail_front;
    private final ModelPart torso;
    private final ModelPart left_arm;
    private final ModelPart right_arm;
    private final ModelPart skirt;
    private final ModelPart left_leg;
    private final ModelPart right_leg;

    public FallenSamuraiModel(ModelPart main) {
        super (main);
        this.root = main.getChild("root");
        this.head = this.root.getChild("head");
        this.hat = this.head.getChild("hat");
        this.scarf_tail_back = this.head.getChild("scarf_tail_back");
        this.scarf_tail_front = this.head.getChild("scarf_tail_front");
        this.torso = this.root.getChild("torso");
        this.left_arm =this. root.getChild("left_arm");
        this.right_arm = this.root.getChild("right_arm");
        this.skirt = this.root.getChild("skirt");
        this.left_leg = this.root.getChild("left_leg");
        this.right_leg = this.root.getChild("right_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 0).addBox(-6.0F, -2.0F, -5.0F, 12.0F, 3.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-4.0F, -6.0F, -4.0F, 8.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

        PartDefinition hat = head.addOrReplaceChild("hat", CubeListBuilder.create().texOffs(48, 42).addBox(-10.0F, -1.0F, -10.0F, 20.0F, 2.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(88, 30).addBox(-5.0F, -3.0F, -5.0F, 10.0F, 2.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(108, 56).addBox(-2.0F, -5.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -6.0F, 0.0F, 0.1309F, -0.0873F, 0.1309F));

        PartDefinition scarf_tail_back = head.addOrReplaceChild("scarf_tail_back", CubeListBuilder.create().texOffs(76, 0).addBox(-1.5F, 0.0F, -0.5F, 3.0F, 17.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -1.0F, 5.5F));

        PartDefinition scarf_tail_front = head.addOrReplaceChild("scarf_tail_front", CubeListBuilder.create().texOffs(66, 0).addBox(-1.5F, 0.0F, -0.5F, 3.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 0.0F, -4.0F));

        PartDefinition torso = root.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 24).addBox(-4.5F, -11.0F, -3.0F, 13.0F, 7.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(-4.0F, -11.0F, -2.0F, 8.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(36, 52).addBox(-1.0F, -11.0F, 0.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(28, 37).addBox(-4.0F, -1.0F, -2.0F, 8.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -13.0F, 0.0F));

        PartDefinition left_arm = root.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(62, 24).mirror().addBox(0.0F, -0.5F, -1.0F, 2.0F, 11.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(5.0F, -22.5F, 0.0F));

        PartDefinition right_arm = root.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(46, 23).addBox(-4.0F, -1.5F, -2.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(38, 33).addBox(-3.0F, 8.5F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, -22.5F, 0.0F));

        PartDefinition skirt = root.addOrReplaceChild("skirt", CubeListBuilder.create().texOffs(0, 37).addBox(-4.5F, -1.0F, -2.5F, 9.0F, 13.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, 0.0F));

        PartDefinition left_leg = root.addOrReplaceChild("left_leg", CubeListBuilder.create().texOffs(28, 50).mirror().addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -12.0F, 0.0F));

        PartDefinition right_leg = root.addOrReplaceChild("right_leg", CubeListBuilder.create().texOffs(28, 50).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -12.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 64);
    }

    @Override
    public void setupAnim(T state) {
        super.setupAnim(state);
        AnimUtils.adjustHead(this.head,state.yRot,state.xRot);

        AnimUtils.animateWalkRot(this.left_arm,state.walkAnimationPos, state.walkAnimationSpeed,1.0F,false);
        AnimUtils.animateWalkRot(this.left_leg,state.walkAnimationPos, state.walkAnimationSpeed,1.0F,true);
        AnimUtils.animateWalkRot(this.right_arm,state.walkAnimationPos, state.walkAnimationSpeed,1.0F,true);
        AnimUtils.animateWalkRot(this.right_leg,state.walkAnimationPos, state.walkAnimationSpeed,1.0F,false);
    }
}