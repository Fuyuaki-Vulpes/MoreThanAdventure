package com.fuyuaki.morethanadventure.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.MagmaCube;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;

public class FrozenSlime extends MagmaCube {
    public FrozenSlime(EntityType<? extends MagmaCube> entityType, Level level) {
        super(entityType, level);
    }
}
