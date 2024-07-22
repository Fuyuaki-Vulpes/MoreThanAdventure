package com.fuyuvulpes.morethanadventure.core.registries;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class MtaItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
