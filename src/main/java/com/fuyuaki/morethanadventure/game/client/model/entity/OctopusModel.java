package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.game.client.model.animation.AnimUtils;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.OctopusRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

import java.util.Arrays;

public class OctopusModel <T extends OctopusRenderState> extends EntityModel<T> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart mantle;
    private final ModelPart beak_right;
    private final ModelPart beak_left;
    private final ModelPart legs;
    private final ModelPart[] leg = new ModelPart[8];

    public OctopusModel(ModelPart main) {
        super(main);
        this.root = main.getChild("root");
        this.head = this.root.getChild("head");
        this.mantle = this.head.getChild("mantle");
        this.beak_right = this.head.getChild("beak_right");
        this.beak_left = this.head.getChild("beak_left");
        this.legs = this.root.getChild("legs");
        Arrays.setAll(this.leg, i -> legs.getChild(createLegName(i)));

    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(28, 5).addBox(-2.5F, -5.0F, -2.0F, 5.0F, 5.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(54, 10).addBox(-3.5F, -4.5F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(54, 10).mirror().addBox(1.5F, -4.5F, -1.5F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = head.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(46, 8).mirror().addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(3.0F, 1.0F, 2.75F, 0.2618F, 0.0F, -0.3491F));

        PartDefinition cube_r2 = head.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(46, 8).addBox(-1.0F, -4.0F, -1.0F, 2.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-3.0F, 1.0F, 2.75F, 0.2618F, 0.0F, 0.3491F));

        PartDefinition mantle = head.addOrReplaceChild("mantle", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -4.0F, 0.0F, 6.0F, 6.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 2.0F));

        PartDefinition beak_right = head.addOrReplaceChild("beak_right", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition beak_left = head.addOrReplaceChild("beak_left", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition legs = root.addOrReplaceChild("legs", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        CubeListBuilder cubelistbuilder = CubeListBuilder.create().texOffs(0, 14).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 19.0F, new CubeDeformation(0.0F));

        for (int k = 0; k < 8; k++) {
            double d0 = (double)k * Math.PI * 2.0 / 8.0;
            float f = (float)Math.cos(d0) * 2.0F;
            float f2 = (float)Math.sin(d0) * 2.0F;
            d0 = (double)k * Math.PI * -2.0 / 8.0 + (Math.PI / 2);
            float f3 = (float)d0;

            legs.addOrReplaceChild(createLegName(k), cubelistbuilder, PartPose.offsetAndRotation(f, 0.0F, f2, 0.0F, f3, 0.0F));
        }
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    private static String createLegName(int index) {
        return "leg_" + index;
    }
    @Override
    public void setupAnim(T state) {
        super.setupAnim(state);
        this.root().y = state.tentacleAngle * 3;
        AnimUtils.adjustHead(this.head,state.yRot,state.xRot);
        AnimUtils.adjustHeadDivided(5,this.legs,state.yRot,state.xRot);
        for (ModelPart modelpart : this.leg) {
            modelpart.xRot = state.tentacleAngle * 1.6F - Mth.HALF_PI + 0.2F;
        }
    }
}