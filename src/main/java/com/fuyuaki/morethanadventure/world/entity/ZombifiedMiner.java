package com.fuyuaki.morethanadventure.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class ZombifiedMiner extends Zombie {
    public ZombifiedMiner(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
    }
}
