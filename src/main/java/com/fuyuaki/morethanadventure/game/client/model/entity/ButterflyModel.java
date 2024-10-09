package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.world.entity.Butterfly;
import com.fuyuaki.morethanadventure.world.entity.YukiOnna;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

public class ButterflyModel <T extends Butterfly> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart left_wing;
    private final ModelPart right_wing;

    public ButterflyModel(ModelPart main) {
        this.root = main.getChild("root");
        this.left_wing = this.root.getChild("left_wing");
        this.right_wing = this.root.getChild("right_wing");
    }


    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 0).addBox(-1.5F, -0.75F, -7.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 23.75F, 5.0F));

        PartDefinition cube_r1 = root.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(6, -3).mirror().addBox(0.0F, -1.0F, -3.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.75F, 0.0F, -7.0F, -0.2182F, -0.2618F, 0.0F));

        PartDefinition cube_r2 = root.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(6, -3).addBox(0.0F, -1.0F, -3.0F, 0.0F, 1.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.25F, 0.0F, -7.0F, -0.2182F, 0.2618F, 0.0F));

        PartDefinition left_wing = root.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(9, 0).addBox(1.0F, 0.25F, 5.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, -0.5F, -5.0F));

        PartDefinition cube_r3 = left_wing.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(-5, 11).addBox(-1.0F, 0.0F, -5.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.25F, 5.0F, 0.0F, -0.1047F, 0.0F));

        PartDefinition cube_r4 = left_wing.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(-6, 5).addBox(-1.0F, 0.0F, -5.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.4F, 0.0F, 0.0F, 0.0F, 0.1745F, 0.0F));

        PartDefinition right_wing = root.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(9, 0).mirror().addBox(-3.0F, 0.25F, 5.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.0F, -0.5F, -5.0F));

        PartDefinition cube_r5 = right_wing.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(-5, 11).mirror().addBox(-4.0F, 0.0F, -5.0F, 5.0F, 0.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.0F, 0.25F, 5.0F, 0.0F, 0.1047F, 0.0F));

        PartDefinition cube_r6 = right_wing.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(-6, 5).mirror().addBox(-6.0F, 0.0F, -5.0F, 7.0F, 0.0F, 6.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.4F, 0.0F, 0.0F, 0.0F, -0.1745F, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }


    @Override
    public void setupAnim(Butterfly entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public ModelPart root() {
        return this.root;
    }
}
