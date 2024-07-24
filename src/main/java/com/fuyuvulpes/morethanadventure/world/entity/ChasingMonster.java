package com.fuyuvulpes.morethanadventure.world.entity;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public abstract class ChasingMonster extends Monster {
    private static final EntityDataAccessor<Boolean> DATA_IS_CHASING = SynchedEntityData.defineId(ChasingMonster.class, EntityDataSerializers.BOOLEAN);

    protected ChasingMonster(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public boolean isChasing(){
        return false;
    }


    public boolean setChasing(boolean chase) {
        return this.entityData.get(DATA_IS_CHASING);
    }
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(DATA_IS_CHASING, false);
    }

}
