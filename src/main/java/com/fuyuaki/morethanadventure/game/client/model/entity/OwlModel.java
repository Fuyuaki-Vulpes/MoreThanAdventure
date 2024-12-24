package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.game.client.model.animation.AnimUtils;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.OwlRenderState;
import com.fuyuaki.morethanadventure.world.entity.Owl;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class OwlModel <T extends OwlRenderState> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart left_feather;
    private final ModelPart right_feather;
    private final ModelPart body;
    private final ModelPart left_wing;
    private final ModelPart right_wing;
    private final ModelPart left_foot;
    private final ModelPart right_foot;
    private final ModelPart tail;

    public OwlModel(ModelPart main) {
        super(main);
        this.root = main.getChild("root");
        this.head = this.root.getChild("head");
        this.left_feather = this.head.getChild("left_feather");
        this.right_feather = this.head.getChild("right_feather");
        this.body = this.root.getChild("body");
        this.left_wing = this.body.getChild("left_wing");
        this.right_wing = this.body.getChild("right_wing");
        this.left_foot = this.body.getChild("left_foot");
        this.right_foot = this.body.getChild("right_foot");
        this.tail = this.body.getChild("tail");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.5F, -4.0F, -3.5F, 5.0F, 4.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(23, 0).addBox(-0.5F, -2.0F, -4.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.5F, -2.0F));

        PartDefinition left_feather = head.addOrReplaceChild("left_feather", CubeListBuilder.create().texOffs(15, 0).addBox(0.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, -4.0F, -2.0F));

        PartDefinition right_feather = head.addOrReplaceChild("right_feather", CubeListBuilder.create().texOffs(15, 0).mirror().addBox(-2.0F, -1.0F, -1.0F, 2.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.5F, -4.0F, -2.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 9).addBox(-2.5F, -4.0F, -2.5F, 5.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -4.5F, 0.0F, 0.6109F, 0.0F, 0.0F));

        PartDefinition left_wing = body.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(20, 9).addBox(0.0F, 0.0F, -3.0F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -4.0F, 0.5F));

        PartDefinition right_wing = body.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(20, 9).mirror().addBox(-1.0F, 0.0F, -3.0F, 1.0F, 8.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5F, -4.0F, 0.5F));

        PartDefinition left_foot = body.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(0, 22).addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, 2.5F, -2.5F, 0.9599F, 0.0F, 0.0F));

        PartDefinition right_foot = body.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(0, 22).mirror().addBox(-0.5F, -0.5F, -1.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, 2.5F, -2.5F, 0.9599F, 0.0F, 0.0F));

        PartDefinition tail = body.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(32, 14).addBox(-3.5F, -0.5F, 0.0F, 7.0F, 7.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.0F, 2.5F, 0.48F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(T state) {
        super.setupAnim(state);
        AnimUtils.adjustHead(this.head,state.yRot,state.xRot);

        AnimUtils.animateWalkRot(this.left_foot,state.walkAnimationPos, state.walkAnimationSpeed,0.8F,false);
        AnimUtils.animateWalkRot(this.right_foot,state.walkAnimationPos, state.walkAnimationSpeed,0.8F,true);
    }
}