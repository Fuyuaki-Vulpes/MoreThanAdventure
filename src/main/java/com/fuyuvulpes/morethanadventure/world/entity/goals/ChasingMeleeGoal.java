package com.fuyuvulpes.morethanadventure.world.entity.goals;

import com.fuyuvulpes.morethanadventure.world.entity.ChasingMonster;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;

public class ChasingMeleeGoal extends MeleeAttackGoal {
    protected final ChasingMonster mob;

    public ChasingMeleeGoal(ChasingMonster pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
        super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
        this.mob = pMob;
    }

    @Override
    public void start() {
        this.mob.setChasing(true);
        super.start();
    }

    @Override
    public void stop() {
        this.mob.setChasing(false);
        super.stop();

    }
}
