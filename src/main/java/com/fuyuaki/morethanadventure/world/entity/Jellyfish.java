package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEntityTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.TryFindWaterGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class Jellyfish extends Squid {


    public Jellyfish(EntityType<? extends Squid> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }



    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.0)
                .add(Attributes.MOVEMENT_SPEED, 0.1)
                .add(Attributes.WATER_MOVEMENT_EFFICIENCY, 3.2F)
                .add(Attributes.OXYGEN_BONUS, 10.0);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_364995_, AgeableMob p_364552_) {
        return MtaEntityTypes.JELLYFISH.get().create(p_364995_, EntitySpawnReason.BREEDING);

    }

    @Override
    protected void spawnInk() {
    }

    @Override
    public boolean canBeLeashed() {
        return true;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return null;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    protected double getDefaultGravity() {
        return 0.08;
    }



}
