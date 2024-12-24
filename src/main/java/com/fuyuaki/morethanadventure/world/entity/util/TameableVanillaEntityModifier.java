package com.fuyuaki.morethanadventure.world.entity.util;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;
import java.util.UUID;

public interface TameableVanillaEntityModifier extends OwnableEntity {
    boolean isTame();

    void setTame(boolean value);

    @Nullable
    UUID getTameOwnerUUID();

    void setTameOwnerUUID(@Nullable UUID uuid);

    @Nullable
    LivingEntity getTameOwner();

    boolean isStayingStill();

    boolean isFollowingOwner();

    boolean isValidAttackTarget(LivingEntity target);

    @Nullable
    default UUID getOwnerUUID() {
        return getTameOwnerUUID();


    }
    int getCommand();

    void setCommand(int command);

    default InteractionResult playerSetCommand(Player owner, Animal tameable) {
        if (!owner.level().isClientSide) {
            int command = (getCommand() + 1) % 3;
            this.setCommand(command);
            this.sendCommandMessage(owner, command, tameable.getName());

            if(tameable instanceof TamableAnimal){
                ((TamableAnimal)(tameable)).setOrderedToSit(command == 1);
            }
        }
        return InteractionResult.PASS;
    }

    default void sendCommandMessage(Player owner, int command, Component name){

    }
}
