package com.fuyuaki.morethanadventure.world.entity;

import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class MTATameableAnimal extends TamableAnimal {
    private static final int MAX_STATES = 1;
    public final float health;
    private static final EntityDataAccessor<Integer> COMMANDED_STATE = SynchedEntityData.defineId(MTATameableAnimal.class, EntityDataSerializers.INT);

    protected MTATameableAnimal(float tameableHP,EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.health = tameableHP;

    }


    @Override
    public InteractionResult mobInteract(Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (this.isTame()) {
            if (this.isOwnedBy(pPlayer)) {
                if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
                    if (!this.level().isClientSide()) {
                        FoodProperties foodproperties = itemstack.get(DataComponents.FOOD);
                        this.heal(foodproperties != null ? (float)foodproperties.nutrition() : 1.0F);
                        this.usePlayerItem(pPlayer, pHand, itemstack);
                    }

                    return InteractionResult.SUCCESS;
                }

                InteractionResult interactionresult = super.mobInteract(pPlayer, pHand);
                if (!interactionresult.consumesAction()) {
                    this.setOrderedToSit(getCommandedState() == 1);
                    cycleState();
                    this.jumping = false;
                    this.navigation.stop();
                    this.setTarget((LivingEntity)null);
                    pPlayer.swing(pHand, true);
                    return InteractionResult.SUCCESS;
                }

                return interactionresult;
            }
        } else if (this.isFood(itemstack)) {
            if (!this.level().isClientSide()) {
                this.usePlayerItem(pPlayer, pHand, itemstack);
                this.tryToTame(pPlayer);
                this.setPersistenceRequired();
            }

            return InteractionResult.SUCCESS;
        }

        InteractionResult interactionresult1 = super.mobInteract(pPlayer, pHand);
        if (interactionresult1.consumesAction()) {
            this.setPersistenceRequired();
        }

        return interactionresult1;
    }

    private void tryToTame(Player pPlayer) {
        if (this.random.nextInt(3) == 0 && !net.neoforged.neoforge.event.EventHooks.onAnimalTame(this, pPlayer)) {
            this.tame(pPlayer);
            this.setOrderedToSit(true);
            setCommandedState(1);
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(health);
            this.level().broadcastEntityEvent(this, (byte)7);
        } else {
            this.level().broadcastEntityEvent(this, (byte)6);
        }
    }


    public int getCommandedState(){
        return this.entityData.get(COMMANDED_STATE);
    }

    public void setCommandedState(int state){
         this.entityData.set(COMMANDED_STATE, state);

    }


    public void cycleState(){
        int state = getCommandedState() +1;
        if (state > MAX_STATES) state = 0;
        this.entityData.set(COMMANDED_STATE, state);

    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(COMMANDED_STATE,0);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        compound.putInt("commandState",getCommandedState());
        super.readAdditionalSaveData(compound);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        setCommandedState(compound.getInt("commandState"));
        super.addAdditionalSaveData(compound);
    }
}
