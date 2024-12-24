package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.MossyZombieRenderState;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.ModelPart;

public class MossyZombieModel <T extends MossyZombieRenderState> extends ZombieModel<T> {

    public MossyZombieModel(ModelPart root) {
        super(root);
    }


}
