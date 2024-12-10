package com.fuyuaki.morethanadventure.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathType;

public class Siren extends Monster{
    public Siren(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
//        this.moveControl = new Drowned.DrownedMoveControl(this);
//        this.setPathfindingMalus(PathType.WATER, 0.0F);
//        this.waterNavigation = new WaterBoundPathNavigation(this, level);
//        this.groundNavigation = new GroundPathNavigation(this, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0)
                .add(Attributes.MOVEMENT_SPEED, 0.1)
                .add(Attributes.WATER_MOVEMENT_EFFICIENCY, 3.2F)
                .add(Attributes.OXYGEN_BONUS, 10.0);
    }
}
