package com.fuyuaki.morethanadventure.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class MossyZombie extends Zombie {
    public MossyZombie(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
    }
}
