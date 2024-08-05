package com.fuyuvulpes.morethanadventure.game.worldgen;

import com.fuyuvulpes.morethanadventure.core.registry.MtaBlocks;
import com.fuyuvulpes.morethanadventure.core.registry.MtaFeatures;
import com.fuyuvulpes.morethanadventure.core.registry.MtaTags;
import com.fuyuvulpes.morethanadventure.world.level.feature.configuration.OreClusterConfiguration;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class MtaConfigFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> FREQUENT_CLAY = registerKey("frequent_clay");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DISK_MOSS = registerKey("disk_moss");
    public static final ResourceKey<ConfiguredFeature<?,?>> DIAMOND_CLUSTER = registerKey("diamond_cluster");
    public static final ResourceKey<ConfiguredFeature<?,?>> DEBRIS_CLUSTER = registerKey("debris_cluster");
    public static final ResourceKey<ConfiguredFeature<?,?>> STONY_ROCKS = registerKey("stony_rocks");
    public static final ResourceKey<ConfiguredFeature<?,?>> MOSSY_ROCKS = registerKey("mossy_rocks");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest clusterOresOverworld = new TagMatchTest(MtaTags.Blocks.ORE_CLUSTER_REPLACEABLE);
        RuleTest clusterOresNether = new TagMatchTest(MtaTags.Blocks.NETHER_CLUSTER_CLUSTER_REPLACEABLE);

        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(
                context,
                FREQUENT_CLAY,
                Feature.DISK,
                new DiskConfiguration(
                        RuleBasedBlockStateProvider.simple(Blocks.CLAY), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.CLAY)), UniformInt.of(4, 8), 2
                )
        );

        register(
                context,
                DISK_MOSS,
                Feature.DISK,
                new DiskConfiguration(
                        RuleBasedBlockStateProvider.simple(Blocks.MOSS_BLOCK), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.GRASS_BLOCK)), UniformInt.of(2, 6), 1
                )
        );

        register(context,
                DIAMOND_CLUSTER,
                MtaFeatures.CLUSTER_VEIN.get(),
                new OreClusterConfiguration(clusterOresOverworld,
                        64,
                        2,
                        4,
                        1,
                        0.2F,
                        Blocks.DIAMOND_ORE.defaultBlockState(),
                        Blocks.CALCITE.defaultBlockState()
                        )
        );
        register(context,
                DEBRIS_CLUSTER,
                MtaFeatures.CLUSTER_VEIN.get(),
                new OreClusterConfiguration(clusterOresOverworld,
                        32,
                        2,
                        3,
                        4,
                        0.1F,
                        Blocks.ANCIENT_DEBRIS.defaultBlockState(),
                        Blocks.BASALT.defaultBlockState()
                        )
        );
        register(context,
                STONY_ROCKS,
                Feature.FOREST_ROCK,
                new BlockStateConfiguration(Blocks.ANDESITE.defaultBlockState())
        );
        register(context,
                MOSSY_ROCKS,
                Feature.FOREST_ROCK,
                new BlockStateConfiguration(MtaBlocks.MOSSY_ANDESITE.get().defaultBlockState())
        );



    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MODID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
