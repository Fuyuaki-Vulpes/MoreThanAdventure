package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.registry.MtaSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class Jellyfish extends WaterAnimal {


    public Jellyfish(EntityType<? extends WaterAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new SmoothSwimmingMoveControl(this, 90, 90, 1.2F, 0.1F, false);
        this.lookControl = new SmoothSwimmingLookControl(this, 90);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(0, new RandomSwimmingGoal(this, 1.0, 5));
    }
    @Override
    protected PathNavigation createNavigation(Level pLevel) {
        return new WaterBoundPathNavigation(this, pLevel);
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0)
                .add(Attributes.MOVEMENT_SPEED, 0.1)
                .add(Attributes.WATER_MOVEMENT_EFFICIENCY, 3.2F)
                .add(Attributes.OXYGEN_BONUS, 10.0);
    }




    protected SoundEvent getSquirtSound() {
        return null;
    }

    @Override
    public boolean canBeLeashed() {
        return true;
    }

    @Override
    protected double getDefaultGravity() {
        return 0.08;
    }



}
