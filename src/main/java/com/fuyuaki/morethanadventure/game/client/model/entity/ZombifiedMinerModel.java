package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.ZombifiedMinerRenderState;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.ModelPart;

public class ZombifiedMinerModel<T extends ZombifiedMinerRenderState> extends ZombieModel<T> {

    public ZombifiedMinerModel(ModelPart root) {
        super(root);
    }



}
