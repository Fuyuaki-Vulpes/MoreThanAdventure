package com.fuyuaki.morethanadventure.game.species.traits;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

public abstract class TickingTrait extends Trait{
    public final int tickRate;

    public TickingTrait(int rate, Component description, boolean hidden){
        super(description,hidden);
        this.tickRate = Math.max(1, rate);
    }

    public abstract void tick();

    public boolean shouldTick(Player player){
        return this.active(player);
    }
}
