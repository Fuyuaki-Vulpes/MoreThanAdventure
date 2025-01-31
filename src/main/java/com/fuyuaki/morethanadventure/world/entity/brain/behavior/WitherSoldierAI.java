package com.fuyuaki.morethanadventure.world.entity.brain.behavior;

import com.fuyuaki.morethanadventure.world.entity.WitherSoldierEntity;
import com.fuyuaki.morethanadventure.world.entity.brain.behavior.wither_soldier.BlockProjectile;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.datafixers.util.Pair;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.behavior.*;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.MemoryStatus;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.schedule.Activity;
import net.neoforged.neoforge.common.Tags;

import java.util.List;
import java.util.Set;

public class WitherSoldierAI {
    public static final List<SensorType<? extends Sensor<? super WitherSoldierEntity>>> SENSOR_TYPES = ImmutableList.of(
            SensorType.NEAREST_LIVING_ENTITIES, SensorType.HURT_BY, SensorType.NEAREST_PLAYERS, SensorType.IS_IN_WATER
    );
    public static final List<MemoryModuleType<?>> MEMORY_TYPES = ImmutableList.of(
            MemoryModuleType.NEAREST_LIVING_ENTITIES,
            MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES,
            MemoryModuleType.NEAREST_VISIBLE_PLAYER,
            MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER,
            MemoryModuleType.NEAREST_VISIBLE_NEMESIS,
            MemoryModuleType.LOOK_TARGET,
            MemoryModuleType.WALK_TARGET,
            MemoryModuleType.CANT_REACH_WALK_TARGET_SINCE,
            MemoryModuleType.PATH,
            MemoryModuleType.ATTACK_TARGET,
            MemoryModuleType.ATTACK_COOLING_DOWN,
            MemoryModuleType.NEAREST_ATTACKABLE,
            MemoryModuleType.HURT_BY,
            MemoryModuleType.HURT_BY_ENTITY,
            MemoryModuleType.PATH
    );

    public static Brain<WitherSoldierEntity> makeBrain(WitherSoldierEntity soldier, Brain<WitherSoldierEntity> brain) {
        initCoreActivity(brain);
        initIdleActivity(brain);
        initFightActivity(soldier, brain);
        brain.setCoreActivities(Set.of(Activity.CORE));
        brain.setDefaultActivity(Activity.FIGHT);
        brain.useDefaultActivity();
        return brain;
    }
    private static void initCoreActivity(Brain<WitherSoldierEntity> brain) {
        brain.addActivity(Activity.CORE, 0, ImmutableList.of(new Swim<>(0.8F), new LookAtTargetSink(45, 90)));
    }

    private static void initIdleActivity(Brain<WitherSoldierEntity> brain) {
        brain.addActivity(
                Activity.IDLE,
                ImmutableList.of(
                        Pair.of(0, StartAttacking.create((level, soldier) -> soldier.getBrain().getMemory(MemoryModuleType.NEAREST_VISIBLE_ATTACKABLE_PLAYER))),
                        Pair.of(1, StartAttacking.create((level, soldier) -> soldier.getHurtBy())),
                        Pair.of(2, new MoveToTargetSink()),
                        Pair.of(3, new RunOne<>(ImmutableList.of(Pair.of(new DoNothing(10, 100), 1), Pair.of(RandomStroll.stroll(0.8F), 2))))
                )
        );
    }

    private static void initFightActivity(WitherSoldierEntity soldier, Brain<WitherSoldierEntity> brain) {
        brain.addActivityAndRemoveMemoryWhenStopped(
                Activity.FIGHT,
                10,
                ImmutableList.of(
                        StopAttackingIfTargetInvalid.create(Sensor.wasEntityAttackableLastNTicks(soldier, 100).negate()::test),
                        MeleeAttack.create(mob -> !mob.getItemInHand(InteractionHand.MAIN_HAND).is(Tags.Items.RANGED_WEAPON_TOOLS),18),
                        new RangedAttack<>(),
                        new BlockProjectile()
                        ),
                MemoryModuleType.ATTACK_TARGET

        );
    }

    public static void updateActivity(WitherSoldierEntity soldier) {
        soldier.getBrain().setActiveActivityToFirstValid(ImmutableList.of(Activity.FIGHT, Activity.IDLE));
    }

}
