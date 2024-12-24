package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.game.client.model.animation.AnimUtils;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.RaccoonRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class RaccoonModel <T extends RaccoonRenderState> extends EntityModel<T> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart left_front_leg;
    private final ModelPart right_front_leg;
    private final ModelPart left_back_leg;
    private final ModelPart right_back_leg;
    private final ModelPart tail;

    public RaccoonModel(ModelPart main) {
        super(main);
        this.root = main.getChild("root");
        this.head = this.root.getChild("head");
        this.body = this.root.getChild("body");
        this.left_front_leg = this.root.getChild("left_front_leg");
        this.right_front_leg = this.root.getChild("right_front_leg");
        this.left_back_leg = this.root.getChild("left_back_leg");
        this.right_back_leg = this.root.getChild("right_back_leg");
        this.tail = this.root.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -5.0F, 6.0F, 5.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).addBox(-3.0F, -5.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 10).mirror().addBox(1.0F, -5.0F, -3.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 14).addBox(-2.0F, 0.0F, -7.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, -6.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 14).addBox(-3.0F, -3.0F, -6.0F, 6.0F, 6.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -6.0F, 0.0F));

        PartDefinition left_front_leg = root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(46, 24).mirror().addBox(0.0F, -1.5F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.0F, -4.5F, -4.0F));

        PartDefinition right_front_leg = root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(46, 24).addBox(-2.0F, -1.5F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -4.5F, -4.0F));

        PartDefinition left_back_leg = root.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(54, 23).mirror().addBox(-1.0F, -2.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, -4.0F, 3.5F));

        PartDefinition right_back_leg = root.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(54, 23).addBox(-1.0F, -2.0F, -1.5F, 2.0F, 6.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -4.0F, 3.5F));

        PartDefinition tail = root.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(32, 0).addBox(-2.0F, -2.0F, 0.0F, 4.0F, 4.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -5.0F, 6.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(T state) {
        super.setupAnim(state);
        AnimUtils.adjustHead(this.head,state.yRot,state.xRot);
        AnimUtils.animateWalkRot(this.left_front_leg,state.walkAnimationPos, state.walkAnimationSpeed,0.8F,false);
        AnimUtils.animateWalkRot(this.right_front_leg,state.walkAnimationPos, state.walkAnimationSpeed,0.8F,true);
        AnimUtils.animateWalkRot(this.left_back_leg,state.walkAnimationPos, state.walkAnimationSpeed,0.8F,true);
        AnimUtils.animateWalkRot(this.right_back_leg,state.walkAnimationPos, state.walkAnimationSpeed,0.8F,false);
    }
}