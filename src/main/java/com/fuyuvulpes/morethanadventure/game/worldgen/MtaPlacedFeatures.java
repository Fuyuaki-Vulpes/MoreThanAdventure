package com.fuyuvulpes.morethanadventure.game.worldgen;

import com.fuyuvulpes.morethanadventure.game.worldgen.util.MtaOrePlacements;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.features.VegetationFeatures;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class MtaPlacedFeatures {

    public static final ResourceKey<PlacedFeature> FREQUENT_CLAY = registerKey("frequent_clay");
    public static final ResourceKey<PlacedFeature> DISK_MOSS = registerKey("disk_moss");
    public static final ResourceKey<PlacedFeature> DISK_MOSS_RARE = registerKey("disk_moss_rare");
    public static final ResourceKey<PlacedFeature> DIAMOND_CLUSTER = registerKey("diamond_cluster");
    public static final ResourceKey<PlacedFeature> DEBRIS_CLUSTER = registerKey("debris_cluster");
    public static final ResourceKey<PlacedFeature> SPARSE_CHERRY_TREE = registerKey("sparse_cherry");
    public static final ResourceKey<PlacedFeature> SPARSE_SPRUCE_TREE = registerKey("sparse_taiga");
    public static final ResourceKey<PlacedFeature> SPARSE_MANGROVE = registerKey("sparse_mangrove");
    public static final ResourceKey<PlacedFeature> STONY_ROCK = registerKey("stony_rocks");
    public static final ResourceKey<PlacedFeature> MOSSY_ROCKS = registerKey("mossy_rocks");
    public static final ResourceKey<PlacedFeature> GEYSER_OVERWORLD = registerKey("geyser_overworld");
    public static final ResourceKey<PlacedFeature> GEYSER_NETHER = registerKey("geyser_nether");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {

        register(
                context,
                FREQUENT_CLAY,
                holder(context,MtaConfigFeatures.FREQUENT_CLAY),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BlockPredicateFilter.forPredicate(BlockPredicate.matchesFluids(Fluids.WATER)),
                BiomeFilter.biome()
        );
        register(
                context,
                DISK_MOSS,
                holder(context,MtaConfigFeatures.DISK_MOSS),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE),
                BiomeFilter.biome()
        );

        register(
                context,
                DIAMOND_CLUSTER,
                holder(context, MtaConfigFeatures.DIAMOND_CLUSTER),
                MtaOrePlacements.rareOrePlacement(
                        12,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.aboveBottom(-20),
                                VerticalAnchor.aboveBottom(40))
                )
        );
        register(
                context,
                DEBRIS_CLUSTER,
                holder(context, MtaConfigFeatures.DEBRIS_CLUSTER),
                MtaOrePlacements.rareOrePlacement(
                        12,
                        HeightRangePlacement.of(
                                UniformHeight.of(
                                        VerticalAnchor.bottom(),
                                        VerticalAnchor.top()))
                )
        );

        register(
                context,
                SPARSE_MANGROVE,
                holder(context, VegetationFeatures.MANGROVE_VEGETATION),
                CountPlacement.of(6),
                InSquarePlacement.spread(),
                SurfaceWaterDepthFilter.forMaxDepth(5),
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                BiomeFilter.biome(),
                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(Blocks.MANGROVE_PROPAGULE.defaultBlockState(), BlockPos.ZERO))
        );

        register(
                context,
                SPARSE_CHERRY_TREE,
                holder(context, TreeFeatures.CHERRY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1F, 1),Blocks.CHERRY_SAPLING)
        );

        register(
                context,
                SPARSE_SPRUCE_TREE,
                holder(context, TreeFeatures.SPRUCE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1F, 1),Blocks.SPRUCE_SAPLING)
        );

        register(
                context,
                STONY_ROCK,
                holder(context, MtaConfigFeatures.STONY_ROCKS),
                CountPlacement.of(3),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome()
        );

        register(
                context,
                MOSSY_ROCKS,
                holder(context, MtaConfigFeatures.MOSSY_ROCKS),
                CountPlacement.of(3),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome()
        );

        register(context,
                GEYSER_OVERWORLD,
                holder(context,MtaConfigFeatures.GEYSER_OVERWORLD),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.UP.getNormal(), Blocks.AIR)),
                RarityFilter.onAverageOnceEvery(16),
                BiomeFilter.biome(),
                InSquarePlacement.spread()
                );
        register(context,
                GEYSER_NETHER,
                holder(context,MtaConfigFeatures.GEYSER_NETHER),
                PlacementUtils.FULL_RANGE,
                CountPlacement.of(8),
                BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.UP.getNormal(), Blocks.AIR)),
                BiomeFilter.biome(),
                InSquarePlacement.spread()
                );

        register(
                context,
                DISK_MOSS_RARE,
                holder(context,MtaConfigFeatures.DISK_MOSS),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                RarityFilter.onAverageOnceEvery(2),
                BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE),
                BiomeFilter.biome()
        );


    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MODID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {
        context.register(key, new PlacedFeature(configuration, List.of(modifiers)));
    }

    private static Holder<ConfiguredFeature<?,?>> holder(BootstrapContext<PlacedFeature> context, ResourceKey<ConfiguredFeature<?,?>> feature){
        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);
        return holdergetter.getOrThrow(feature);
    }

}
