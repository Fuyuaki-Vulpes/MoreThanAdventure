package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.world.level.feature.configuration.OreClusterConfiguration;
import com.fuyuaki.morethanadventure.world.level.feature.feature.OreClusterFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MtaFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, MODID);

    public static final DeferredHolder<Feature<?>,Feature<OreClusterConfiguration>> CLUSTER_VEIN = FEATURES.register("ore_clusters", () ->
            new OreClusterFeature(OreClusterConfiguration.CODEC));


    public static void register(IEventBus eventBus){
        FEATURES.register(eventBus);
    }
}
