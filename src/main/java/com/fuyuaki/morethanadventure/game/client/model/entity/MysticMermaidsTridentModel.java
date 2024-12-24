package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MysticMermaidsTridentModel extends Model {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/mystic_mermaids_trident.png");
    private final ModelPart root;

    public MysticMermaidsTridentModel(ModelPart pRoot) {
        super(RenderType::entitySolid);
        this.root = pRoot;
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition bone = partdefinition.addOrReplaceChild("bone", CubeListBuilder.create().texOffs(1, 5).mirror().addBox(-0.5F, -25.0F, -0.5F, 1.0F, 25.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(2, 1).mirror().addBox(-2.5F, -27.0F, -0.5F, 5.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(11, 26).mirror().addBox(2.5F, -29.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(13, 23).mirror().addBox(2.05F, -29.8F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)).mirror(false)
                .texOffs(6, 26).mirror().addBox(-0.5F, -31.0F, -0.5F, 1.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(11, 26).mirror().addBox(-3.5F, -29.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(13, 23).mirror().addBox(-3.25F, -29.8F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.01F)).mirror(false), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition left_wing_tip_r1 = bone.addOrReplaceChild("left_wing_tip_r1", CubeListBuilder.create().texOffs(6, 14).mirror().addBox(-0.3093F, -0.7614F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.009F)).mirror(false), PartPose.offsetAndRotation(1.9036F, -22.9768F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition left_wing_base_r1 = bone.addOrReplaceChild("left_wing_base_r1", CubeListBuilder.create().texOffs(7, 17).mirror().addBox(-0.4925F, -0.9726F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.5425F, -22.4274F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition right_wing_tip_r1 = bone.addOrReplaceChild("right_wing_tip_r1", CubeListBuilder.create().texOffs(6, 14).mirror().addBox(-1.6907F, -0.7614F, -0.5F, 2.0F, 1.0F, 1.0F, new CubeDeformation(-0.009F)).mirror(false), PartPose.offsetAndRotation(-1.9036F, -22.9768F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition right_wing_base_r1 = bone.addOrReplaceChild("right_wing_base_r1", CubeListBuilder.create().texOffs(7, 17).mirror().addBox(-0.5075F, -0.9726F, -0.5F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5425F, -22.4274F, 0.0F, 0.0F, 0.0F, 0.7854F));

        PartDefinition gem_frame_r1 = bone.addOrReplaceChild("gem_frame_r1", CubeListBuilder.create().texOffs(7, 9).mirror().addBox(-1.0F, -1.0F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(0.0F, -23.55F, 0.0F, 0.0F, 0.0F, -0.7854F));

        PartDefinition gem_r1 = bone.addOrReplaceChild("gem_r1", CubeListBuilder.create().texOffs(7, 5).mirror().addBox(-1.0F, -1.0F, -0.55F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.23F)).mirror(false)
                .texOffs(7, 5).mirror().addBox(-1.0F, -1.0F, -1.05F, 2.0F, 2.0F, 1.0F, new CubeDeformation(-0.23F)).mirror(false), PartPose.offsetAndRotation(0.0F, -23.6F, 0.3F, 0.0F, 0.0F, -0.7854F));

        PartDefinition middle_spike_end_r1 = bone.addOrReplaceChild("middle_spike_end_r1", CubeListBuilder.create().texOffs(6, 21).mirror().addBox(-1.125F, -0.875F, -0.5F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.01F)).mirror(false), PartPose.offsetAndRotation(0.0F, -30.4697F, 0.0F, 0.0F, 0.0F, -0.7854F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }


}
