package com.fuyuaki.morethanadventure.world.entity.brain.behavior;

import com.google.common.collect.ImmutableMap;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.behavior.Behavior;
import net.minecraft.world.entity.ai.behavior.BehaviorUtils;
import net.minecraft.world.entity.ai.behavior.EntityTracker;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;

public class RangedAttack<E extends Mob & RangedAttackMob, T extends LivingEntity> extends Behavior<E> {

    public RangedAttack() {
        super(
                ImmutableMap.of(MemoryModuleType.LOOK_TARGET,
                        MemoryStatus.REGISTERED,
                        MemoryModuleType.ATTACK_TARGET,
                        MemoryStatus.VALUE_PRESENT),
                1200);
    }

    protected boolean checkExtraStartConditions(ServerLevel level, E owner) {
        LivingEntity livingentity = getAttackTarget(owner);
        return owner.isHolding(is -> is.getItem() instanceof CrossbowItem)
                && BehaviorUtils.canSee(owner, livingentity)
                && BehaviorUtils.isWithinAttackRange(owner, livingentity, 0);
    }

    protected boolean canStillUse(ServerLevel level, E entity, long gameTime) {
        return entity.getBrain().hasMemoryValue(MemoryModuleType.ATTACK_TARGET) && this.checkExtraStartConditions(level, entity);
    }

    @Override
    protected void tick(ServerLevel level, E owner, long gameTime) {
        LivingEntity livingentity = getAttackTarget(owner);
        this.lookAtTarget(owner, livingentity);

        if (owner.getItemInHand(InteractionHand.MAIN_HAND).getItem() instanceof BowItem
                &&
                BowItem.getPowerForTime(owner.getItemInHand(InteractionHand.MAIN_HAND).getUseDuration(owner) - owner.getUseItemRemainingTicks()) >= 1.0F
        ){
            owner.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
            owner.performRangedAttack(livingentity, 1.0F);

        }
    }

    protected void stop(ServerLevel level, E entity, long gameTime) {
        if (entity.isUsingItem()) {
            entity.stopUsingItem();
        }
    }


    private void lookAtTarget(Mob shooter, LivingEntity target) {
        shooter.getBrain().setMemory(MemoryModuleType.LOOK_TARGET, new EntityTracker(target, true));
    }

    private static LivingEntity getAttackTarget(LivingEntity shooter) {
        return shooter.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).get();
    }


}
