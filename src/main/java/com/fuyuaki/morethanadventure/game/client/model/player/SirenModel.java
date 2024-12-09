package com.fuyuaki.morethanadventure.game.client.model.player;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.AnimationUtils;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.ListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class SirenModel extends ListModel<Player> {


    private final ModelPart main;
    private final ModelPart waist;
    private final ModelPart tail1;
    private final ModelPart tail2;
    private final ModelPart tail3;
    private final ModelPart tail4;
    private final ModelPart tail5;
    private final ModelPart tail6;
    private final ModelPart head_fin;
    public float swimAmount;

    public SirenModel(ModelPart root) {
        this.main = root.getChild("main");
        this.waist = this.main.getChild("waist");
        this.tail1 = this.waist.getChild("tail1");
        this.tail2 = this.tail1.getChild("tail2");
        this.tail3 = this.tail2.getChild("tail3");
        this.tail4 = this.tail3.getChild("tail4");
        this.tail5 = this.tail4.getChild("tail5");
        this.tail6 = this.tail5.getChild("tail6");
        this.head_fin = this.main.getChild("head_fin");
    }



    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition main = partdefinition.addOrReplaceChild("main", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition waist = main.addOrReplaceChild("waist", CubeListBuilder.create().texOffs(0, 0).addBox(-4.5F, 8.0F, -2.5F, 9.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = waist.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(58, 0).addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-5.0F, 13.0F, -0.5F, 0.0F, 0.0F, 0.3927F));

        PartDefinition cube_r2 = waist.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(58, 0).mirror().addBox(-1.0F, -2.0F, 0.0F, 2.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(5.0F, 13.0F, -0.5F, 0.0F, 0.0F, -0.3927F));

        PartDefinition cube_r3 = waist.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(54, 2).addBox(0.5F, -5.0F, -1.0F, 0.0F, 7.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 7.0F, 5.0F, 0.48F, 0.0F, 0.0F));

        PartDefinition cube_r4 = waist.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(50, 0).addBox(0.0F, -2.0F, -1.0F, 1.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 4.0F, 3.0F, 0.48F, 0.0F, 0.0F));

        PartDefinition tail1 = waist.addOrReplaceChild("tail1", CubeListBuilder.create().texOffs(0, 10).addBox(-4.0F, 0.0F, -2.0F, 8.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 0.0F));

        PartDefinition tail2 = tail1.addOrReplaceChild("tail2", CubeListBuilder.create().texOffs(0, 22).addBox(-3.5F, 0.0F, -2.0F, 7.0F, 5.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition tail3 = tail2.addOrReplaceChild("tail3", CubeListBuilder.create().texOffs(28, 0).addBox(-3.5F, 0.0F, -1.5F, 7.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition tail4 = tail3.addOrReplaceChild("tail4", CubeListBuilder.create().texOffs(24, 14).addBox(-3.0F, 0.0F, -1.0F, 6.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 5.0F, 0.0F));

        PartDefinition tail5 = tail4.addOrReplaceChild("tail5", CubeListBuilder.create().texOffs(18, 20).addBox(-2.0F, 0.0F, -1.0F, 4.0F, 4.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

        PartDefinition tail6 = tail5.addOrReplaceChild("tail6", CubeListBuilder.create().texOffs(22, 26).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(40, 18).addBox(-6.0F, 0.0F, 0.0F, 12.0F, 14.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 4.0F, 0.0F));

        PartDefinition head_fin = main.addOrReplaceChild("head_fin", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 1.0F));

        PartDefinition cube_r5 = head_fin.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(41, 3).mirror().addBox(1.0F, -4.0F, -1.0F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.75F, -3.0F, -2.0F, -0.3054F, -0.1745F, 0.0F));

        PartDefinition cube_r6 = head_fin.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(41, 3).addBox(-1.0F, -4.0F, -1.0F, 0.0F, 6.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.75F, -3.0F, -2.0F, -0.3054F, 0.1745F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 32);
    }


    @Override
    public void renderToBuffer (PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
                                int color){
        main.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }


    public static float getAngle ( float x, float speed, float scale){
        return Mth.sin(Mth.TWO_PI * x * speed) * scale;
    }


    public static float getAngleWithOffset ( float x, float offset, float speed, float scale){
        return Mth.sin(Mth.TWO_PI * (x + offset * (1 / speed)) * speed) * scale;
    }


    @Override
    public Iterable<ModelPart> parts() {
        return null;
    }

    public void copyFrom(HumanoidModel<?> model) {
        main.copyFrom(model.body);
    }


    public void prepareMobModel(Player entity, float limbSwing, float limbSwingAmount, float partialTick) {
        this.swimAmount = entity.getSwimAmount(partialTick);
        super.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTick);
    }

    @Override
    public void setupAnim(Player player, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        boolean flag = player.getFallFlyingTicks() > 4;
        boolean flag1 = player.isVisuallySwimming();
        this.head_fin.yRot = netHeadYaw * (float) (Math.PI / 180.0);
        if (flag) {
            this.head_fin.xRot = (float) (-Math.PI / 4);
        } else if (this.swimAmount > 0.0F) {
            if (flag1) {
                this.head_fin.xRot = this.rotlerpRad(this.swimAmount, this.head_fin.xRot, (float) (-Math.PI / 4));
            } else {
                this.head_fin.xRot = this.rotlerpRad(this.swimAmount, this.head_fin.xRot, headPitch * (float) (Math.PI / 180.0));
            }
        } else {
            this.head_fin.xRot = headPitch * (float) (Math.PI / 180.0);
        }

        boolean crouching = player.isCrouching();
        boolean swimming = player.isSwimming() || (player.isInWater() && !player.onGround() && !crouching);

        if (player.getVehicle() != null) {
            tail1.xRot = -Mth.PI / 2;
            tail2.xRot = 0;
            float x = Mth.PI / 150 * (Mth.sin(ageInTicks / 12) + 3);
            tail3.xRot = tail4.xRot = tail5.xRot = x;
            tail6.xRot = x * 2;
        } else if (swimming) {
            float speed = 0.035F;
            float scale = Mth.PI / 12;
            tail1.xRot = getAngle(ageInTicks, speed, scale);
            tail2.xRot = getAngleWithOffset(ageInTicks, -0.1F, speed, scale);
            tail3.xRot = getAngleWithOffset(ageInTicks, -0.2F, speed, scale);
            tail4.xRot = getAngleWithOffset(ageInTicks, -0.3F, speed, scale);
            tail5.xRot = getAngleWithOffset(ageInTicks, -0.4F, speed, scale);
            tail6.xRot = tail5.xRot * 2;
        } else if (player.isVisuallySwimming()) {
            tail1.xRot = tail2.xRot = tail3.xRot = tail4.xRot = tail5.xRot = tail6.xRot = 0;
        } else {
            float angle = crouching ? Mth.PI / 16 : Mth.PI / 14;
            tail1.xRot = tail2.xRot = tail3.xRot = tail4.xRot = tail5.xRot = tail6.xRot = angle;
        }


    }


    protected float rotlerpRad(float angle, float maxAngle, float mul) {
        float f = (mul - maxAngle) % (float) (Math.PI * 2);
        if (f < (float) -Math.PI) {
            f += (float) (Math.PI * 2);
        }

        if (f >= (float) Math.PI) {
            f -= (float) (Math.PI * 2);
        }

        return maxAngle + angle * f;


    }






}






