package com.fuyuaki.morethanadventure.world.entity;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.AbstractSchoolingFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Shrimp extends AbstractSchoolingFish {

    public Shrimp(EntityType<? extends AbstractSchoolingFish> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.TADPOLE_FLOP;
    }


    @Override
    public ItemStack getBucketItemStack() {
        return null;
    }
}
