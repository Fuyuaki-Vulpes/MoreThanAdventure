package com.fuyuaki.morethanadventure.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;

public class CorrosiveCube extends MagmaCube {
    public CorrosiveCube(EntityType<? extends MagmaCube> entityType, Level level) {
        super(entityType, level);
    }
}
