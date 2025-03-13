package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.world.level.feature.configuration.OreClusterConfiguration;
import com.fuyuaki.morethanadventure.world.level.feature.feature.OreClusterFeature;
import com.fuyuaki.morethanadventure.world.level.feature.placers.MTABlockBlobFeature;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.BlockBlobFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MtaFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(Registries.FEATURE, MODID);

    public static final DeferredHolder<Feature<?>,Feature<OreClusterConfiguration>> CLUSTER_VEIN = FEATURES.register("ore_clusters", () ->
            new OreClusterFeature(OreClusterConfiguration.CODEC));

    public static final DeferredHolder<Feature<?>,Feature<BlockStateConfiguration>> ROCK_BLOBS = FEATURES.register("rock_blobs", () ->
            new MTABlockBlobFeature(BlockStateConfiguration.CODEC));


    public static void register(IEventBus eventBus){
        FEATURES.register(eventBus);
    }
}
