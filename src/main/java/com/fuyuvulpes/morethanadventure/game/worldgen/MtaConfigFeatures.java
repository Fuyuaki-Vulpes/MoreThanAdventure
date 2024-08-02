package com.fuyuvulpes.morethanadventure.game.worldgen;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.AquaticFeatures;
import net.minecraft.data.worldgen.features.CaveFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.util.valueproviders.WeightedListInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SmallDripleafBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class MtaConfigFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> FREQUENT_CLAY = registerKey("frequent_clay");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LUSH_VEGETATION_POOL = registerKey("lush_vegetation_pool");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LUSH_WATER_VEGETATION = registerKey("lush_water_vegetation");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DRIPLEAF = registerKey("dripleaf");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(
                context,
                FREQUENT_CLAY,
                Feature.DISK,
                new DiskConfiguration(
                        RuleBasedBlockStateProvider.simple(Blocks.CLAY), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.CLAY)), UniformInt.of(4, 8), 2
                )
        );

        register(context,
                DRIPLEAF,
                Feature.WATERLOGGED_VEGETATION_PATCH,
                new VegetationPatchConfiguration(
                        BlockTags.LUSH_GROUND_REPLACEABLE,
                        BlockStateProvider.simple(Blocks.CLAY),
                        PlacementUtils.inlinePlaced(holdergetter.getOrThrow(CaveFeatures.DRIPLEAF)),
                        CaveSurface.FLOOR,
                        ConstantInt.of(3),
                        0.4F,
                        5,
                        0.3F,
                        UniformInt.of(4, 7),
                        0.7F
                ));


        register(context,
                LUSH_VEGETATION_POOL,Feature.VEGETATION_PATCH,
                new VegetationPatchConfiguration(
                        BlockTags.LUSH_GROUND_REPLACEABLE,
                        BlockStateProvider.simple(Blocks.SAND),
                        PlacementUtils.inlinePlaced(holdergetter.getOrThrow(LUSH_WATER_VEGETATION)),
                        CaveSurface.FLOOR,
                        ConstantInt.of(1),
                        0.0F,
                        5,
                        0.8F,
                        UniformInt.of(4, 7),
                        0.3F
                )
        );

        register(context,
                LUSH_WATER_VEGETATION,
                Feature.SIMPLE_RANDOM_SELECTOR,
                new SimpleRandomFeatureConfiguration(
                        HolderSet.direct(
                                PlacementUtils.inlinePlaced(holdergetter.getOrThrow(AquaticFeatures.SEAGRASS_TALL)),
                                PlacementUtils.inlinePlaced(holdergetter.getOrThrow(AquaticFeatures.SEA_PICKLE)),
                                PlacementUtils.inlinePlaced(holdergetter.getOrThrow(AquaticFeatures.SEAGRASS_SIMPLE)),
                                PlacementUtils.inlinePlaced(holdergetter.getOrThrow(AquaticFeatures.KELP)),
                                PlacementUtils.inlinePlaced(holdergetter.getOrThrow(MtaConfigFeatures.DRIPLEAF)
                                )
                        )
                )
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
