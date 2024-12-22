package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.world.entity.ArmoredSkeleton;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.geom.ModelPart;

public class ArmoredSkeletonModel<T extends ArmoredSkeleton> extends SkeletonModel<T> {
    //private final ModelPart root;

    public ArmoredSkeletonModel(ModelPart root) {
        super(root);
    }

}
