package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.game.client.model.animation.AnimUtils;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.DeerRenderState;
import com.fuyuaki.morethanadventure.world.entity.Deer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class DeerModel <T extends DeerRenderState> extends EntityModel<T> {
    private final ModelPart root;
    private final ModelPart torso;
    private final ModelPart head;
    private final ModelPart left_ear;
    private final ModelPart right_ear;
    private final ModelPart left_front_leg;
    private final ModelPart right_front_leg;
    private final ModelPart left_back_leg;
    private final ModelPart right_back_leg;


    public DeerModel(ModelPart main) {
        super(main);
        this.root = main.getChild("root");
        this.torso = this.root.getChild("torso");
        this.head = this.torso.getChild("head");
        this.left_ear = this.head.getChild("left_ear");
        this.right_ear = this.head.getChild("right_ear");
        this.left_front_leg = this.root.getChild("left_front_leg");
        this.right_front_leg = this.root.getChild("right_front_leg");
        this.left_back_leg = this.root.getChild("left_back_leg");
        this.right_back_leg = this.root.getChild("right_back_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition torso = root.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 38).addBox(-5.0F, -5.0F, -7.0F, 10.0F, 10.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -14.0F, 0.0F));

        PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -10.0F, -3.0F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(24, 0).addBox(1.0F, -15.0F, 0.0F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F))
                .texOffs(24, 0).mirror().addBox(-8.0F, -15.0F, 0.0F, 7.0F, 5.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(48, 8).addBox(-2.0F, -7.0F, -7.0F, 4.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -2.0F, -7.0F));

        PartDefinition left_ear = head.addOrReplaceChild("left_ear", CubeListBuilder.create().texOffs(56, 0).addBox(0.0F, -1.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -7.0F, 1.0F));

        PartDefinition right_ear = head.addOrReplaceChild("right_ear", CubeListBuilder.create().texOffs(56, 0).mirror().addBox(-3.0F, -1.0F, 0.0F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -7.0F, 1.0F));

        PartDefinition left_front_leg = root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 18).addBox(-3.0F, -2.0F, -2.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -11.0F, -4.0F));

        PartDefinition right_front_leg = root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 18).mirror().addBox(-1.0F, -2.0F, -2.0F, 4.0F, 13.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -11.0F, -4.0F));

        PartDefinition left_back_leg = root.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(16, 18).addBox(-2.0F, -2.0F, -2.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(4.0F, -13.0F, 5.0F));

        PartDefinition right_back_leg = root.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(16, 18).mirror().addBox(-2.0F, -2.0F, -2.0F, 4.0F, 15.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-4.0F, -13.0F, 5.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T state) {
        super.setupAnim(state);
        AnimUtils.adjustHead(this.head,state.yRot,state.xRot);
        AnimUtils.animateWalkRot(this.left_front_leg,state.walkAnimationPos, state.walkAnimationSpeed,1.5F,false);
        AnimUtils.animateWalkRot(this.right_front_leg,state.walkAnimationPos, state.walkAnimationSpeed,1.5F,true);
        AnimUtils.animateWalkRot(this.left_back_leg,state.walkAnimationPos, state.walkAnimationSpeed,1.5F,true);
        AnimUtils.animateWalkRot(this.right_back_leg,state.walkAnimationPos, state.walkAnimationSpeed,1.5F,false);

    }
}
