package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.world.entity.ArmoredSkeleton;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.monster.Skeleton;

public class ArmoredSkeletonModel<T extends ArmoredSkeleton> extends SkeletonModel<T> {
    //private final ModelPart root;

    public ArmoredSkeletonModel(ModelPart root) {
        super(root);
    }

}
