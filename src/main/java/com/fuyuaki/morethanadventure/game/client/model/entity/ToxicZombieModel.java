package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.ToxicZombieRenderState;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.ModelPart;

public class ToxicZombieModel <T extends ToxicZombieRenderState> extends ZombieModel<T> {

    public ToxicZombieModel(ModelPart root) {
        super(root);
        //this.root = root.getChild("root");
    }



}
