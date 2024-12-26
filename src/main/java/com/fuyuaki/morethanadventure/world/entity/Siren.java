package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

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

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return MtaSounds.SIREN_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return MtaSounds.SIREN_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return MtaSounds.SIREN_DEATH.get();
    }
}
