package com.fuyuaki.morethanadventure.game.client.model.entity;

import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;

public class CharredSkeletonModel <T extends SkeletonRenderState> extends SkeletonModel<T> {

    public CharredSkeletonModel(ModelPart root) {
        super(root);
    }

}
