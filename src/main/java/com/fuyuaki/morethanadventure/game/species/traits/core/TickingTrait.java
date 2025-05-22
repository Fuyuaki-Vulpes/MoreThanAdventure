package com.fuyuaki.morethanadventure.game.species.traits.core;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public abstract class TickingTrait extends Trait{
    public final int tickRate;

    public TickingTrait(int rate, boolean hidden){
        super(hidden);
        this.tickRate = Math.max(1, rate);
    }

    @Override
    public boolean active(Player player) {
        return player.tickCount % this.tickRate == 0;
    }

    public abstract void tick(Player player);

    public boolean shouldTick(Player player){
        return this.active(player);
    }
}
