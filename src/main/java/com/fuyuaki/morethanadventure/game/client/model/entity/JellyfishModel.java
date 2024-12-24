package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.JellyfishRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class JellyfishModel <T extends JellyfishRenderState> extends EntityModel<T> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart head_b;
    private final ModelPart oral_arm;
    private final ModelPart oral_arm_b;
    private final ModelPart tentacles;
    private final ModelPart tentacle_a;
    private final ModelPart tentacle_a2;
    private final ModelPart tentacle_a3;
    private final ModelPart tentacle_b;
    private final ModelPart tentacle_b2;
    private final ModelPart tentacle_b3;
    private final ModelPart tentacle_c;
    private final ModelPart tentacle_c2;
    private final ModelPart tentacle_c3;
    private final ModelPart tentacle_d;
    private final ModelPart tentacle_d2;
    private final ModelPart tentacle_d3;
    private final ModelPart tentacle_e;
    private final ModelPart tentacle_e2;
    private final ModelPart tentacle_e3;
    private final ModelPart tentacle_f;
    private final ModelPart tentacle_f2;
    private final ModelPart tentacle_f3;
    private final ModelPart tentacle_g;
    private final ModelPart tentacle_g2;
    private final ModelPart tentacle_g3;
    private final ModelPart tentacle_h;
    private final ModelPart tentacle_h2;
    private final ModelPart tentacle_h3;

    public JellyfishModel(ModelPart main) {
        super(main);
        this.root = main.getChild("root");
        this.head = this.root.getChild("head");
        this.head_b = this.head.getChild("head_b");
        this.oral_arm = this.root.getChild("oral_arm");
        this.oral_arm_b = this.oral_arm.getChild("oral_arm_b");
        this.tentacles = this.root.getChild("tentacles");
        this.tentacle_a = this.tentacles.getChild("tentacle_a");
        this.tentacle_a2 = this.tentacle_a.getChild("tentacle_a2");
        this.tentacle_a3 = this.tentacle_a2.getChild("tentacle_a3");
        this.tentacle_b = this.tentacles.getChild("tentacle_b");
        this.tentacle_b2 = this.tentacle_b.getChild("tentacle_b2");
        this.tentacle_b3 = this.tentacle_b2.getChild("tentacle_b3");
        this.tentacle_c = this.tentacles.getChild("tentacle_c");
        this.tentacle_c2 = this.tentacle_c.getChild("tentacle_c2");
        this.tentacle_c3 = this.tentacle_c2.getChild("tentacle_c3");
        this.tentacle_d = this.tentacles.getChild("tentacle_d");
        this.tentacle_d2 = this.tentacle_d.getChild("tentacle_d2");
        this.tentacle_d3 = this.tentacle_d2.getChild("tentacle_d3");
        this.tentacle_e = this.tentacles.getChild("tentacle_e");
        this.tentacle_e2 = this.tentacle_e.getChild("tentacle_e2");
        this.tentacle_e3 = this.tentacle_e2.getChild("tentacle_e3");
        this.tentacle_f = this.tentacles.getChild("tentacle_f");
        this.tentacle_f2 = this.tentacle_f.getChild("tentacle_f2");
        this.tentacle_f3 = this.tentacle_f2.getChild("tentacle_f3");
        this.tentacle_g = this.tentacles.getChild("tentacle_g");
        this.tentacle_g2 = this.tentacle_g.getChild("tentacle_g2");
        this.tentacle_g3 = this.tentacle_g2.getChild("tentacle_g3");
        this.tentacle_h = this.tentacles.getChild("tentacle_h");
        this.tentacle_h2 = this.tentacle_h.getChild("tentacle_h2");
        this.tentacle_h3 = this.tentacle_h2.getChild("tentacle_h3");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 12).addBox(-6.0F, -3.0F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head_b = head.addOrReplaceChild("head_b", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

        PartDefinition oral_arm = root.addOrReplaceChild("oral_arm", CubeListBuilder.create().texOffs(36, 14).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 10.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 8).addBox(0.0F, 0.0F, -3.0F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition oral_arm_b = oral_arm.addOrReplaceChild("oral_arm_b", CubeListBuilder.create().texOffs(48, 14).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 10.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(48, 8).addBox(0.0F, 0.0F, -3.0F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.0F));

        PartDefinition tentacles = root.addOrReplaceChild("tentacles", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition tentacle_a = tentacles.addOrReplaceChild("tentacle_a", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 4.0F));

        PartDefinition tentacle_a2 = tentacle_a.addOrReplaceChild("tentacle_a2", CubeListBuilder.create().texOffs(41, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition tentacle_a3 = tentacle_a2.addOrReplaceChild("tentacle_a3", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition tentacle_b = tentacles.addOrReplaceChild("tentacle_b", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 0.0F, 3.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition tentacle_b2 = tentacle_b.addOrReplaceChild("tentacle_b2", CubeListBuilder.create().texOffs(41, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition tentacle_b3 = tentacle_b2.addOrReplaceChild("tentacle_b3", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition tentacle_c = tentacles.addOrReplaceChild("tentacle_c", CubeListBuilder.create().texOffs(36, -2).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(4.0F, 0.0F, 0.0F));

        PartDefinition tentacle_c2 = tentacle_c.addOrReplaceChild("tentacle_c2", CubeListBuilder.create().texOffs(41, -2).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition tentacle_c3 = tentacle_c2.addOrReplaceChild("tentacle_c3", CubeListBuilder.create().texOffs(46, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition tentacle_d = tentacles.addOrReplaceChild("tentacle_d", CubeListBuilder.create().texOffs(36, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, 0.0F, -3.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition tentacle_d2 = tentacle_d.addOrReplaceChild("tentacle_d2", CubeListBuilder.create().texOffs(41, -2).mirror().addBox(0.0F, 0.0F, -1.0F, 0.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition tentacle_d3 = tentacle_d2.addOrReplaceChild("tentacle_d3", CubeListBuilder.create().texOffs(46, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition tentacle_e = tentacles.addOrReplaceChild("tentacle_e", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -4.0F));

        PartDefinition tentacle_e2 = tentacle_e.addOrReplaceChild("tentacle_e2", CubeListBuilder.create().texOffs(41, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition tentacle_e3 = tentacle_e2.addOrReplaceChild("tentacle_e3", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition tentacle_f = tentacles.addOrReplaceChild("tentacle_f", CubeListBuilder.create().texOffs(36, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, 0.0F, -3.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition tentacle_f2 = tentacle_f.addOrReplaceChild("tentacle_f2", CubeListBuilder.create().texOffs(41, 0).mirror().addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition tentacle_f3 = tentacle_f2.addOrReplaceChild("tentacle_f3", CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition tentacle_g = tentacles.addOrReplaceChild("tentacle_g", CubeListBuilder.create().texOffs(36, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.0F, 0.0F, 0.0F));

        PartDefinition tentacle_g2 = tentacle_g.addOrReplaceChild("tentacle_g2", CubeListBuilder.create().texOffs(41, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition tentacle_g3 = tentacle_g2.addOrReplaceChild("tentacle_g3", CubeListBuilder.create().texOffs(46, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition tentacle_h = tentacles.addOrReplaceChild("tentacle_h", CubeListBuilder.create().texOffs(36, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 0.0F, 3.0F, 0.0F, 0.7854F, 0.0F));

        PartDefinition tentacle_h2 = tentacle_h.addOrReplaceChild("tentacle_h2", CubeListBuilder.create().texOffs(41, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition tentacle_h3 = tentacle_h2.addOrReplaceChild("tentacle_h3", CubeListBuilder.create().texOffs(46, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public void setupAnim(JellyfishRenderState renderState, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

}
