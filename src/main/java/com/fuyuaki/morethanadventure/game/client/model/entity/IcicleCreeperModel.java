package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.game.client.model.animation.AnimUtils;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.IcicleCreeperRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class IcicleCreeperModel <T extends IcicleCreeperRenderState> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart leg1;
    private final ModelPart leg2;
    private final ModelPart leg3;
    private final ModelPart leg4;

    public IcicleCreeperModel(ModelPart main) {
        super(main);
        this.root = main.getChild("root");
        this.body = this.root.getChild("body");
        this.head = this.body.getChild("head");
        this.leg1 = this.root.getChild("leg1");
        this.leg2 = this.root.getChild("leg2");
        this.leg3 = this.root.getChild("leg3");
        this.leg4 = this.root.getChild("leg4");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(16, 16).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -18.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition leg1 = root.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -6.0F, 4.0F));

        PartDefinition leg2 = root.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -6.0F, 4.0F));

        PartDefinition leg3 = root.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.0F, -6.0F, -4.0F));

        PartDefinition leg4 = root.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, -6.0F, -4.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(T state) {
        super.setupAnim(state);
        AnimUtils.adjustHead(this.head,state.yRot,state.xRot);

        AnimUtils.animateWalkRot(this.leg1,state.walkAnimationPos, state.walkAnimationSpeed,0.8F,false);
        AnimUtils.animateWalkRot(this.leg2,state.walkAnimationPos, state.walkAnimationSpeed,0.8F,true);
        AnimUtils.animateWalkRot(this.leg3,state.walkAnimationPos, state.walkAnimationSpeed,0.8F,true);
        AnimUtils.animateWalkRot(this.leg4,state.walkAnimationPos, state.walkAnimationSpeed,0.8F,false);

    }
}