package com.fuyuaki.morethanadventure.world.entity.attachments.helper;

import com.fuyuaki.morethanadventure.game.species.traits.core.AbilityTrait;

public record AbilityTraitCooldown(AbilityTrait.AbilitySlot slot, int time) {
    public AbilityTraitCooldown runTick() {
        return new AbilityTraitCooldown(slot,time-1);
    }
}
