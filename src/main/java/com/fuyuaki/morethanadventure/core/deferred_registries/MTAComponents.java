package com.fuyuaki.morethanadventure.core.deferred_registries;

import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTAComponents {
    public static final DeferredRegister.DataComponents COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE,MODID);



    public static void register(IEventBus eventBus){
        COMPONENTS.register(eventBus);
    }


}
