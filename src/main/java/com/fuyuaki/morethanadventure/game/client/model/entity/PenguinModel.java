package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.game.client.model.animation.AnimUtils;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.PenguinRenderState;
import com.fuyuaki.morethanadventure.world.entity.Penguin;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class PenguinModel <T extends PenguinRenderState> extends EntityModel<T> {
    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart left_wing;
    private final ModelPart right_wing;
    private final ModelPart left_foot;
    private final ModelPart right_foot;

    public PenguinModel(ModelPart main) {
        super(main);
        this.root = main.getChild("root");
        this.body = this.root.getChild("body");
        this.head = this.body.getChild("head");
        this.left_wing = this.body.getChild("left_wing");
        this.right_wing = this.body.getChild("right_wing");
        this.left_foot = this.root.getChild("left_foot");
        this.right_foot = this.root.getChild("right_foot");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 11).addBox(-3.0F, -10.0F, -3.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.0F, 0.0F));

        PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(24, 5).addBox(-4.0F, -5.0F, -5.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(24, 5).mirror().addBox(1.0F, -5.0F, -5.0F, 3.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0).addBox(-3.0F, -5.0F, -4.0F, 6.0F, 5.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(38, 7).addBox(-1.0F, -2.0F, -6.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, -1.0F));

        PartDefinition left_wing = body.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(24, 11).addBox(0.0F, 0.0F, -5.0F, 1.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -10.0F, 2.0F));

        PartDefinition right_wing = body.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(24, 11).mirror().addBox(-1.0F, 0.0F, -5.0F, 1.0F, 9.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, -10.0F, 2.0F));

        PartDefinition left_foot = root.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(40, 22).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.5F, 0.0F, 0.0F));

        PartDefinition right_foot = root.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(40, 22).addBox(-1.5F, -1.0F, -3.0F, 3.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(T state) {
        super.setupAnim(state);
        AnimUtils.adjustHead(this.head,state.yRot,headPitch);

        AnimUtils.animateWalkRot(this.left_foot,limbSwing,limbSwingAmount,0.8F,false);
        AnimUtils.animateWalkRot(this.right_foot,limbSwing,limbSwingAmount,0.8F,true);
    }
}