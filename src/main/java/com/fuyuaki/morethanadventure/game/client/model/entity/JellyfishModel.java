package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.JellyfishRenderState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.util.Mth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JellyfishModel <T extends JellyfishRenderState> extends EntityModel<T> {
    // This layer id should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart head_b;
    private final ModelPart oral_arm;
    private final ModelPart oral_arm_b;

    private final ModelPart[] tentacleList1 = new ModelPart[8];
    private final ModelPart[] tentacleList2 = new ModelPart[8];
    private final ModelPart[] tentacleList3 = new ModelPart[8];
    private final ModelPart tentacles;

    public JellyfishModel(ModelPart main) {
        super(main);
        this.root = main.getChild("root");
        this.head = this.root.getChild("head");
        this.head_b = this.head.getChild("head_b");
        this.oral_arm = this.root.getChild("oral_arm");
        this.oral_arm_b = this.oral_arm.getChild("oral_arm_b");
        this.tentacles = this.root.getChild("tentacles");
        Arrays.setAll(this.tentacleList1, i -> tentacles.getChild(createTentacleName(i, 1)));
        Arrays.setAll(this.tentacleList2, i -> tentacleList1[i].getChild(createTentacleName(i, 2)));
        Arrays.setAll(this.tentacleList3, i -> tentacleList2[i].getChild(createTentacleName(i, 3)));

    }

    private static String createTentacleName(int tentacle, int index) {
        List<String> set = List.of("a","b","c","d","e","f","g","h");
        if (index < 2){
            return "tentacle_" + set.get(tentacle);
        }else {
            return "tentacle_" + set.get(tentacle) + index;
        }
    }


    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 12).addBox(-6.0F, -3.0F, -6.0F, 12.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head_b = head.addOrReplaceChild("head_b", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -4.0F, -4.0F, 8.0F, 4.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -3.0F, 0.0F));

        PartDefinition oral_arm = root.addOrReplaceChild("oral_arm", CubeListBuilder.create().texOffs(36, 14).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 10.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(36, 8).addBox(0.0F, 0.0F, -3.0F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)).mirror(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition oral_arm_b = oral_arm.addOrReplaceChild("oral_arm_b", CubeListBuilder.create().texOffs(48, 14).addBox(-3.0F, 0.0F, 0.0F, 6.0F, 10.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(48, 8).addBox(0.0F, 0.0F, -3.0F, 0.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 10.0F, 0.0F));

        PartDefinition tentacles = root.addOrReplaceChild("tentacles", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        CubeListBuilder cubelistbuilder = CubeListBuilder.create().texOffs(46, -2).addBox(0.0F, 0.0F, -1.0F, 0.0F, 13.0F, 2.0F, new CubeDeformation(0.0F)).mirror();

        CubeListBuilder cubelistbuilder2 = CubeListBuilder.create().texOffs(41, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 0.0F, new CubeDeformation(0.0F));

        CubeListBuilder cubelistbuilder3 = CubeListBuilder.create().texOffs(46, 0).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 13.0F, 0.0F, new CubeDeformation(0.0F));

        for (int k = 0; k < 8; k++) {
            double d0 = (double)k * Math.PI * 2.0 / 8.0;
            float f = (float)Math.cos(d0) * 5.0F;
            float f2 = (float)Math.sin(d0) * 5.0F;
            d0 = (double)k * Math.PI * -2.0 / 8.0 + (Math.PI / 2);
            float f3 = (float)d0;

            tentacles.
                    addOrReplaceChild(createTentacleName(k,1), cubelistbuilder, PartPose.offsetAndRotation(f, 0.0F, f2, 0.0F, f3, 0.0F))
                    .addOrReplaceChild(createTentacleName(k,2), cubelistbuilder2, PartPose.offsetAndRotation(0.0F, 13.0F, 0.0F, 0.0F, f3, 0.0F))
                    .addOrReplaceChild(createTentacleName(k,3), cubelistbuilder3, PartPose.offsetAndRotation(0.0F, 13.0F, 0.0F, 0.0F, f3, 0.0F));
        }
        return LayerDefinition.create(meshdefinition, 64, 32);
    }



    @Override
    public void setupAnim(T state) {
        super.setupAnim(state);
        this.root.y = 5.0F;
        this.oral_arm.yScale = state.tentacleAngle + 0.6F;
        this.oral_arm_b.yScale = state.tentacleAngle + 0.6F;

        for (ModelPart modelpart : this.tentacleList1) {
            modelpart.xRot = state.tentacleAngle * 0.9F;
            modelpart.xRot += Mth.sin(state.ageInTicks * 0.1F) * 0.1F;
            modelpart.zRot += Mth.sin(state.ageInTicks * 0.1F) * 0.1F;
        }
        for (ModelPart modelpart : this.tentacleList2) {
            modelpart.zRot = state.tentacleAngle * 0.6F;
            modelpart.zRot += Mth.sin(state.ageInTicks * 0.1F + 1.5F) * 0.1F;
            modelpart.xRot += Mth.sin(state.ageInTicks * 0.1F + 1.5F) * 0.1F;

        }
        for (ModelPart modelpart : this.tentacleList3) {
            modelpart.zRot = state.tentacleAngle * 0.3F;
            modelpart.zRot += Mth.sin(state.ageInTicks * 0.1F + 3.0F) * 0.1F;
            modelpart.xRot += Mth.sin(state.ageInTicks * 0.1F + 3.0F) * 0.1F;
        }

    }

}
