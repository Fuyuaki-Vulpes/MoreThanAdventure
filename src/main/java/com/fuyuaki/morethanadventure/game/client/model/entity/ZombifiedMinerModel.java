package com.fuyuaki.morethanadventure.game.client.model.entity;

import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.monster.Zombie;

public class ZombifiedMinerModel<T extends Zombie> extends ZombieModel<T> {
    public ZombifiedMinerModel(ModelPart root) {
        super(root);
    }
}
