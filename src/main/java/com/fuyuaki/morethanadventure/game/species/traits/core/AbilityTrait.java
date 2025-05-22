package com.fuyuaki.morethanadventure.game.species.traits.core;

import net.minecraft.network.chat.Component;

public class AbilityTrait extends Trait{
    private final AbilitySlot abilitySlot;
    private final int cooldown;

    public AbilityTrait(AbilitySlot abilitySlot, int cooldown, boolean hidden) {
        super(hidden);
        this.abilitySlot = abilitySlot;
        this.cooldown = cooldown;
    }


    public int getCooldown() {
        return cooldown;
    }

    public AbilitySlot getAbilitySlot() {
        return abilitySlot;
    }



    public enum AbilitySlot {
        PRIMARY("primary"),
        SECONDARY("secondary")
        ;

        private final String id;

        AbilitySlot(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

    }
}
