package com.fuyuaki.morethanadventure.world.level;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerBossEvent;

public class MTABossEvent extends ServerBossEvent {
    public MTABossEvent(Component pName, BossBarColor pColor, BossBarOverlay pOverlay) {
        super(pName, pColor, pOverlay);
    }
}
