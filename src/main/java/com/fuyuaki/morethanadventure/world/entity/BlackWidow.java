package com.fuyuaki.morethanadventure.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;

public class BlackWidow extends CaveSpider {
    public BlackWidow(EntityType<? extends CaveSpider> entityType, Level level) {
        super(entityType, level);
    }
}
