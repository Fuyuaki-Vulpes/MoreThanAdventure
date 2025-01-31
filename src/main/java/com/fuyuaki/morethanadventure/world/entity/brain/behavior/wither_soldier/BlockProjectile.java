package com.fuyuaki.morethanadventure.world.entity.brain.behavior.wither_soldier;

import com.google.common.collect.ImmutableMap;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.Behavior;
import com.fuyuaki.morethanadventure.world.entity.WitherSoldierEntity;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.neoforged.neoforge.common.Tags;

public class BlockProjectile extends Behavior<WitherSoldierEntity> {
    private static final int MAX_BLOCK_TIME = Math.round(40.0F);
    private static final int MIN_BLOCK_TIME = Math.round(10.0F);;

    public BlockProjectile() {
        super(ImmutableMap.of(
                        MemoryModuleType.ATTACK_TARGET,
                        MemoryStatus.VALUE_PRESENT,
                        MemoryModuleType.WALK_TARGET,
                        MemoryStatus.VALUE_ABSENT
                ),
                MIN_BLOCK_TIME, MAX_BLOCK_TIME);
    }

    @Override
    protected void start(ServerLevel level, WitherSoldierEntity entity, long gameTime) {
        entity.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).ifPresent(living -> living.setPose(Pose.CROUCHING));
        entity.startUsingItem(InteractionHand.OFF_HAND);
        super.start(level, entity, gameTime);
    }

    @Override
    protected boolean checkExtraStartConditions(ServerLevel level, WitherSoldierEntity owner) {
        LivingEntity target = owner.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).orElse(null);
        if (target != null){
            double d = owner.position().distanceToSqr(target.position());
            if (d < 7.0F){
                return true;
            }else if (target.isUsingItem() && target.getUseItem().is(Tags.Items.RANGED_WEAPON_TOOLS)){
                return true;
            }

        }
        return super.checkExtraStartConditions(level, owner);
    }

    @Override
    protected void stop(ServerLevel level, WitherSoldierEntity entity, long gameTime) {
        entity.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).ifPresent(living -> living.setPose(Pose.STANDING));
    }

    @Override
    protected boolean canStillUse(ServerLevel level, WitherSoldierEntity entity, long gameTime) {
        LivingEntity target = entity.getBrain().getMemory(MemoryModuleType.ATTACK_TARGET).orElse(null);
        return entity.getBrain().hasMemoryValue(MemoryModuleType.ATTACK_TARGET)
                && entity.getItemInHand(InteractionHand.OFF_HAND).is(Tags.Items.TOOLS_SHIELD)
                &&
                (target != null &&
                        (target.isUsingItem() && target.getUseItem().is(Tags.Items.RANGED_WEAPON_TOOLS) ||
                entity.position().distanceToSqr(target.position()) < 10.0F)
                );
    }

    @Override
    protected void tick(ServerLevel level, WitherSoldierEntity owner, long gameTime) {
        Brain<WitherSoldierEntity> brain = owner.getBrain();
        brain.getMemory(MemoryModuleType.ATTACK_TARGET).ifPresent(livingentity -> owner.lookAt(EntityAnchorArgument.Anchor.EYES, livingentity.position()));
    }
}
