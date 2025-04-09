package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.game.client.model.animation.AnimUtils;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.CapybaraRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class CapybaraModel <T extends CapybaraRenderState> extends EntityModel<T> {
    // This layer id should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart right_front_leg;
    private final ModelPart left_front_leg;
    private final ModelPart right_hind_leg;
    private final ModelPart left_hind_leg;

    public CapybaraModel(ModelPart main) {
        super (main);
        this.root = main.getChild("root");
        this.head = this.root.getChild("head");
        this.right_front_leg = this.root.getChild("right_front_leg");
        this.left_front_leg = this.root.getChild("left_front_leg");
        this.right_hind_leg = this.root.getChild("right_hind_leg");
        this.left_hind_leg = this.root.getChild("left_hind_leg");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 10).addBox(-3.0F, -8.0F, -5.0F, 6.0F, 6.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 15).addBox(-2.0F, -6.0F, 5.0F, 4.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -5.5F, 4.0F, 4.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 3).addBox(-2.0F, -3.0F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 3).mirror().addBox(1.0F, -3.0F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).addBox(-4.0F, -1.0F, -4.5F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).mirror().addBox(2.0F, -1.0F, -4.5F, 2.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -7.0F, -4.5F));

        PartDefinition right_front_leg = root.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(20, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -3.0F, -3.0F));

        PartDefinition left_front_leg = root.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(20, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, -3.0F, -3.0F));

        PartDefinition right_hind_leg = root.addOrReplaceChild("right_hind_leg", CubeListBuilder.create().texOffs(22, 12).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, -4.0F, 3.0F));

        PartDefinition left_hind_leg = root.addOrReplaceChild("left_hind_leg", CubeListBuilder.create().texOffs(22, 12).mirror().addBox(-1.0F, -2.0F, -1.0F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(3.0F, -4.0F, 3.0F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(T state) {
        super.setupAnim(state);
        AnimUtils.adjustHead(this.head,state.yRot,state.xRot);

        AnimUtils.animateWalkRot(this.left_front_leg,state.walkAnimationPos, state.walkAnimationSpeed,0.8F,false);
        AnimUtils.animateWalkRot(this.right_front_leg,state.walkAnimationPos, state.walkAnimationSpeed,0.8F,true);
        AnimUtils.animateWalkRot(this.left_hind_leg,state.walkAnimationPos, state.walkAnimationSpeed,0.8F,true);
        AnimUtils.animateWalkRot(this.right_hind_leg,state.walkAnimationPos, state.walkAnimationSpeed,0.8F,false);
    }
}
