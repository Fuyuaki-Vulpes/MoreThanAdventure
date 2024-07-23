package com.fuyuvulpes.morethanadventure.core.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class MtaFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, MODID);

    public static void register(IEventBus eventBus){
        FEATURES.register(eventBus);
    }
}
