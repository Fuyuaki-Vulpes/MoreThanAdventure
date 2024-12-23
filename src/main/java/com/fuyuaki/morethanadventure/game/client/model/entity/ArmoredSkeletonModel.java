package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.ArmoredSkeletonRenderState;
import com.fuyuaki.morethanadventure.world.entity.ArmoredSkeleton;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.geom.ModelPart;

public class ArmoredSkeletonModel<T extends ArmoredSkeletonRenderState> extends SkeletonModel<T> {
    //private final ModelPart root;

    public ArmoredSkeletonModel(ModelPart root) {
        super(root);
    }

}
