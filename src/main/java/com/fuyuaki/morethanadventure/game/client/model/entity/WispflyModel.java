package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.world.entity.Wispfly;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class WispflyModel<T extends Wispfly> extends HierarchicalModel<T> {
    private final ModelPart root;
    private final ModelPart left_wing;
    private final ModelPart right_wing;
    private final ModelPart body;

    public WispflyModel(ModelPart root) {
        this.root = root.getChild("root");
        this.left_wing = this.root.getChild("left_wing");
        this.right_wing = this.root.getChild("right_wing");
        this.body = this.root.getChild("body");
    }
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition left_wing = root.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(0, 13).addBox(0.0F, -1.5F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.5F, 1.0F, 0.0F, -0.3927F, -0.3927F));

        PartDefinition right_wing = root.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-5.0F, -1.5F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -1.5F, 1.0F, 0.0F, 0.3927F, 0.3927F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -2.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }

    @Override
    public void setupAnim(Wispfly entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float flySpeed = 0.8F;
        float offset = 1.2F;
        this.left_wing.yRot = Mth.cos(ageInTicks * flySpeed + offset);
        this.right_wing.yRot = - Mth.cos(ageInTicks * flySpeed + offset);
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
        root.render(poseStack, buffer, packedLight, packedOverlay, color);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    public static LayerDefinition createOuterLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition left_wing = root.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(0, 13).addBox(0.0F, -1.5F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, -1.5F, 1.0F, 0.0F, -0.3927F, -0.3927F));

        PartDefinition right_wing = root.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(0, 13).mirror().addBox(-5.0F, -1.5F, 0.0F, 5.0F, 3.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-0.5F, -1.5F, 1.0F, 0.0F, 0.3927F, 0.3927F));

        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 4).addBox(-1.5F, -2.5F, -1.5F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }




}
