package com.fuyuaki.morethanadventure.game.worldgen;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlocks;
import com.fuyuaki.morethanadventure.game.worldgen.util.MTAOreUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.CaveFeatures;
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

import java.util.ArrayList;
import java.util.List;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MtaPlacedFeatures {

    public static final ResourceKey<PlacedFeature> ALPINE_TREE = registerKey("alpine_tree");
    public static final ResourceKey<PlacedFeature> AVOCADO_TREE = registerKey("avocado_tree");
    public static final ResourceKey<PlacedFeature> BOGGED_OAK_TREE = registerKey("bogged_oak_tree");
    public static final ResourceKey<PlacedFeature> PINK_IPE_TREE = registerKey("pink_ipe_tree");
    public static final ResourceKey<PlacedFeature> PURPLE_IPE_TREE = registerKey("purple_ipe_tree");
    public static final ResourceKey<PlacedFeature> WHITE_IPE_TREE = registerKey("white_ipe_tree");
    public static final ResourceKey<PlacedFeature> YELLOW_IPE_TREE = registerKey("yellow_ipe_tree");
    public static final ResourceKey<PlacedFeature> MANGO_TREE = registerKey("mango_tree");
    public static final ResourceKey<PlacedFeature> MAPLE_TREE = registerKey("maple_tree");
    public static final ResourceKey<PlacedFeature> ACACIA_BUSH = registerKey("acacia_bush");
    public static final ResourceKey<PlacedFeature> BIRCH_BUSH = registerKey("birch_bush");
    public static final ResourceKey<PlacedFeature> SPRUCE_BUSH = registerKey("spruce_bush");
    public static final ResourceKey<PlacedFeature> OAK_BUSH = registerKey("oak_bush");
    public static final ResourceKey<PlacedFeature> DARK_OAK_BUSH = registerKey("dark_oak_bush");
    public static final ResourceKey<PlacedFeature> PALM_TREE = registerKey("palm_tree");
    public static final ResourceKey<PlacedFeature> PALM_TREE_RARE = registerKey("palm_tree_rare");
    public static final ResourceKey<PlacedFeature> SEAWOOD_TREE = registerKey("seawood_tree");
    public static final ResourceKey<PlacedFeature> FREQUENT_CLAY = registerKey("frequent_clay");
    public static final ResourceKey<PlacedFeature> DISK_MOSS = registerKey("disk_moss");
    public static final ResourceKey<PlacedFeature> DISK_MOSS_RARE = registerKey("disk_moss_rare");
    public static final ResourceKey<PlacedFeature> LUSH_VEGETATION = registerKey("lush_vegetation");
    public static final ResourceKey<PlacedFeature> DIAMOND_CLUSTER = registerKey("diamond_cluster");
    public static final ResourceKey<PlacedFeature> DEBRIS_CLUSTER = registerKey("debris_cluster");
    public static final ResourceKey<PlacedFeature> SPARSE_CHERRY_TREE = registerKey("sparse_cherry");
    public static final ResourceKey<PlacedFeature> SPARSE_OAK_TREE = registerKey("sparse_oak");
    public static final ResourceKey<PlacedFeature> SPARSE_SPRUCE_TREE = registerKey("sparse_taiga");
    public static final ResourceKey<PlacedFeature> SPARSE_MANGROVE = registerKey("sparse_mangrove");
    public static final ResourceKey<PlacedFeature> SANDSTONE_ROCK = registerKey("sandstone_rocks");
    public static final ResourceKey<PlacedFeature> STONY_ROCK = registerKey("stony_rocks");
    public static final ResourceKey<PlacedFeature> PERMAFROST_ROCK = registerKey("permafrost_rocks");
    public static final ResourceKey<PlacedFeature> MOSSY_ROCKS = registerKey("mossy_rocks");
    public static final ResourceKey<PlacedFeature> GEYSER_OVERWORLD = registerKey("geyser_overworld");
    public static final ResourceKey<PlacedFeature> GEYSER_NETHER = registerKey("geyser_nether");
    public static final ResourceKey<PlacedFeature> NETHER_IRON = registerKey("nether_iron");
    public static final ResourceKey<PlacedFeature> NETHER_DIAMOND = registerKey("nether_diamond");
    public static final ResourceKey<PlacedFeature> END_LAPIS = registerKey("nether_lapis");
    public static final ResourceKey<PlacedFeature> END_EMERALD = registerKey("nether_emerald");
    public static final ResourceKey<PlacedFeature> CLEAR_QUARTZ_ORE = registerKey("clear_quartz_ore");
    public static final ResourceKey<PlacedFeature> LARGE_CLEAR_QUARTZ_VEIN = registerKey("large_clear_quartz_vein");
    public static final ResourceKey<PlacedFeature> CLEAR_QUARTZ_SHARD = registerKey("clear_quartz_shard");
    public static final ResourceKey<PlacedFeature> NETHERITIC_CRYSTAL_ORE = registerKey("netheritic_crystal_ore");
    public static final ResourceKey<PlacedFeature> AGATE_ORE = registerKey("agate_ore");
    public static final ResourceKey<PlacedFeature> ALEXANDRITE_ORE = registerKey("alexandrite_ore");
    public static final ResourceKey<PlacedFeature> AQUAMARINE_ORE = registerKey("aquamarine_ore");
    public static final ResourceKey<PlacedFeature> BLOODSTONE_ORE = registerKey("bloodstone_ore");
    public static final ResourceKey<PlacedFeature> CELESTITE_ORE = registerKey("celestite_ore");
    public static final ResourceKey<PlacedFeature> CRYOLITE_ORE = registerKey("cryolite_ore");
    public static final ResourceKey<PlacedFeature> GARNET_ORE = registerKey("garnet_ore");
    public static final ResourceKey<PlacedFeature> MOONSTONE_ORE = registerKey("moonstone_ore");
    public static final ResourceKey<PlacedFeature> GRASSY_DIRT_PATCH = registerKey("grassy_dirt_patch");
    public static final ResourceKey<PlacedFeature> SCATTERED_LEAVES = registerKey("scattered_leaves");

    public static final ResourceKey<PlacedFeature> PATCH_TUNDRA_GRASS = registerKey("patch_tundra_grass");
    public static final ResourceKey<PlacedFeature> SHALLOW_GRASS_SPARSE = registerKey("shallow_grass_sparse");

    public static final ResourceKey<PlacedFeature> HUGE_DEATH_CAP = registerKey("huge_death_cap");
    public static final ResourceKey<PlacedFeature> HUGE_DEATH_ANGEL = registerKey("huge_death_angel");
    public static final ResourceKey<PlacedFeature> HUGE_FLY_AGARIC = registerKey("huge_fly_agaric");
    public static final ResourceKey<PlacedFeature> HUGE_KING_BOLETE = registerKey("huge_king_bolete");
    public static final ResourceKey<PlacedFeature> HUGE_MAITAKE = registerKey("huge_maitake");
    public static final ResourceKey<PlacedFeature> HUGE_MOREL = registerKey("huge_morel");

    public static final ResourceKey<PlacedFeature> CATTAIL_VEGETATION = registerKey("cattail_vegetation");
    public static final ResourceKey<PlacedFeature> CATTAIL_VEGETATION_WATERLOGGED = registerKey("cattail_vegetation_waterlogged");

    public static final ResourceKey<PlacedFeature> PRICKLY_PEAR = registerKey("prickly_pear");
    public static final ResourceKey<PlacedFeature> PRICKLY_PEAR_SPARSE = registerKey("prickly_pear_sparse");

    public static final ResourceKey<PlacedFeature> SAND_GRASS = registerKey("sand_grass");
    public static final ResourceKey<PlacedFeature> SAND_GRASS_SPARSE = registerKey("sand_grass_sparse");
    public static final ResourceKey<PlacedFeature> BEACHGRASS = registerKey("beachgrass");
    public static final ResourceKey<PlacedFeature> DENSE_SAVANNA_TREES = registerKey("dense_savanna_trees");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {

        register(
                context,
                DENSE_SAVANNA_TREES,
                holder(context,VegetationFeatures.TREES_SAVANNA),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(6, 0.25F, 1))
        );

        register(
                context,
                ALPINE_TREE,
                holder(context,MtaConfigFeatures.ALPINE_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.5F, 1),
                        MtaBlocks.ALPINE_SAPLING.get())
        );

        register(
                context,
                AVOCADO_TREE,
                holder(context,MtaConfigFeatures.AVOCADO_TREE),
                VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(160),
                        MtaBlocks.AVOCADO_SAPLING.get())
        );

        register(
                context,
                BOGGED_OAK_TREE,
                holder(context,MtaConfigFeatures.BOGGED_OAK_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.2F, 1)
        ));

        register(
                context,
                PINK_IPE_TREE,
                holder(context,MtaConfigFeatures.PINK_IPE_TREE),
                VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(150),
                        MtaBlocks.PINK_IPE_SAPLING.get()
                ));

        register(
                context,
                PURPLE_IPE_TREE,
                holder(context,MtaConfigFeatures.PURPLE_IPE_TREE),
                VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(150),
                        MtaBlocks.PURPLE_IPE_SAPLING.get()
                ));

        register(
                context,
                WHITE_IPE_TREE,
                holder(context,MtaConfigFeatures.WHITE_IPE_TREE),
                VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(150),
                        MtaBlocks.WHITE_IPE_SAPLING.get()
                ));

        register(
                context,
                YELLOW_IPE_TREE,
                holder(context,MtaConfigFeatures.YELLOW_IPE_TREE),
                VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(150),
                        MtaBlocks.YELLOW_IPE_SAPLING.get()
        ));

        register(
                context,
                MANGO_TREE,
                holder(context,MtaConfigFeatures.MANGO_TREE),
                VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(210),
                        MtaBlocks.MANGO_SAPLING.get())
        );

        register(
                context,
                MAPLE_TREE,
                holder(context,MtaConfigFeatures.MAPLE_TREE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.2F, 1),
                        MtaBlocks.MAPLE_SAPLING.get())
        );

        register(
                context,
                ACACIA_BUSH,
                holder(context,MtaConfigFeatures.ACACIA_BUSH),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.5F, 1),
                        Blocks.ACACIA_SAPLING)
        );

        register(
                context,
                BIRCH_BUSH,
                holder(context,MtaConfigFeatures.BIRCH_BUSH),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.5F, 1),
                        Blocks.BIRCH_SAPLING)
        );

        register(
                context,
                OAK_BUSH,
                holder(context,MtaConfigFeatures.OAK_BUSH),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.5F, 1),
                        Blocks.OAK_SAPLING)
        );

        register(
                context,
                DARK_OAK_BUSH,
                holder(context,MtaConfigFeatures.DARK_OAK_BUSH),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.5F, 1),
                        Blocks.DARK_OAK_SAPLING)
        );

        register(
                context,
                SPRUCE_BUSH,
                holder(context,MtaConfigFeatures.SPRUCE_BUSH),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.5F, 1),
                        Blocks.SPRUCE_SAPLING)
        );

        register(
                context,
                PALM_TREE,
                holder(context,MtaConfigFeatures.PALM_TREE),
                VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(6),
                        MtaBlocks.PALM_SAPLING.get())
        );
        register(
                context,
                PALM_TREE_RARE,
                holder(context,MtaConfigFeatures.PALM_TREE),
                VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(20),
                        MtaBlocks.PALM_SAPLING.get())

        );

        register(
                context,
                SEAWOOD_TREE,
                holder(context,MtaConfigFeatures.SEAWOOD_TREE),
                CountPlacement.of(4),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_OCEAN_FLOOR,
                BiomeFilter.biome(),
                BlockPredicateFilter.forPredicate(BlockPredicate.wouldSurvive(MtaBlocks.SEAWOOD_SAPLING.get().defaultBlockState(), BlockPos.ZERO))
        );


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
                MTAOreUtils.rareOrePlacement(
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
                MTAOreUtils.rareOrePlacement(
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
                CountPlacement.of(4),
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
                SPARSE_OAK_TREE,
                holder(context, TreeFeatures.OAK),
                VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(6),Blocks.OAK_SAPLING)
        );

        register(
                context,
                SPARSE_SPRUCE_TREE,
                holder(context, TreeFeatures.SPRUCE),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1F, 1),Blocks.SPRUCE_SAPLING)

        );

        register(
                context,
                SANDSTONE_ROCK,
                holder(context, MtaConfigFeatures.SANDSTONE_ROCKS),
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome()
        );
        register(
                context,
                STONY_ROCK,
                holder(context, MtaConfigFeatures.STONY_ROCKS),
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome()
        );
        register(
                context,
                PERMAFROST_ROCK,
                holder(context, MtaConfigFeatures.PERMAFROST_ROCKS),
                CountPlacement.of(2),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome()
        );

        register(
                context,
                MOSSY_ROCKS,
                holder(context, MtaConfigFeatures.MOSSY_ROCKS),
                CountPlacement.of(1),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome()
        );

        register(context,
                GEYSER_OVERWORLD,
                holder(context,MtaConfigFeatures.GEYSER_OVERWORLD),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.UP.getUnitVec3i(), Blocks.AIR)),
                RarityFilter.onAverageOnceEvery(16),
                BiomeFilter.biome(),
                InSquarePlacement.spread()
                );
        register(context,
                GEYSER_NETHER,
                holder(context,MtaConfigFeatures.GEYSER_NETHER),
                PlacementUtils.FULL_RANGE,
                CountPlacement.of(8),
                BlockPredicateFilter.forPredicate(BlockPredicate.matchesBlocks(Direction.UP.getUnitVec3i(), Blocks.AIR)),
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
        register(
                context,
                LUSH_VEGETATION,
                holder(context, CaveFeatures.MOSS_PATCH),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP_TOP_SOLID,
                CountPlacement.of(24),
                BlockPredicateFilter.forPredicate(BlockPredicate.ONLY_IN_AIR_OR_WATER_PREDICATE),
                BiomeFilter.biome()
        );
        register(
                context,
                NETHER_IRON,
                holder(context,MtaConfigFeatures.NETHER_IRON),
                MTAOreUtils.commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(128)))
        );
        register(
                context,
                NETHER_DIAMOND,
                holder(context,MtaConfigFeatures.NETHER_DIAMOND),
                MTAOreUtils.commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(96)))
        );
        register(
                context,
                END_LAPIS,
                holder(context,MtaConfigFeatures.END_LAPIS),
                MTAOreUtils.commonOrePlacement(10, PlacementUtils.FULL_RANGE)
        );
        register(
                context,
                END_EMERALD,
                holder(context,MtaConfigFeatures.END_EMERALD),
                MTAOreUtils.commonOrePlacement(28, PlacementUtils.FULL_RANGE)
        );
        register(
                context,
                CLEAR_QUARTZ_ORE,
                holder(context,MtaConfigFeatures.CLEAR_QUARTZ_ORE),
                MTAOreUtils.commonOrePlacement(5, HeightRangePlacement.triangle(VerticalAnchor.absolute(-96),VerticalAnchor.absolute(32)))
        );
        register(
                context,
                LARGE_CLEAR_QUARTZ_VEIN,
                holder(context,MtaConfigFeatures.LARGE_CLEAR_QUARTZ_VEIN),
                MTAOreUtils.commonOrePlacement(62, PlacementUtils.FULL_RANGE)
        );
        register(
                context,
                CLEAR_QUARTZ_SHARD,
                holder(context,MtaConfigFeatures.CLEAR_QUARTZ_SHARD),
                CountPlacement.of(256),
                PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                InSquarePlacement.spread(),
                BiomeFilter.biome()
        );
        register(
                context,
                NETHERITIC_CRYSTAL_ORE,
                holder(context,MtaConfigFeatures.NETHERITIC_CRYSTAL_ORE),
                MTAOreUtils.commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(64)))
        );


        register(
                context,
                AGATE_ORE,
                holder(context,MtaConfigFeatures.AGATE_ORE),
                MTAOreUtils.commonOrePlacement(20, PlacementUtils.FULL_RANGE)
        );
        register(
                context,
                ALEXANDRITE_ORE,
                holder(context,MtaConfigFeatures.ALEXANDRITE_ORE),
                MTAOreUtils.commonOrePlacement(15,
                        HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(-8)))
        );
        register(
                context,
                AQUAMARINE_ORE,
                holder(context,MtaConfigFeatures.AQUAMARINE_ORE),
                MTAOreUtils.commonOrePlacement(17,
                        HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(16)))
        );
        register(
                context,
                BLOODSTONE_ORE,
                holder(context,MtaConfigFeatures.BLOODSTONE_ORE),
                MTAOreUtils.commonOrePlacement(25,
                        HeightRangePlacement.triangle(VerticalAnchor.bottom(), VerticalAnchor.absolute(48)))
        );
        register(
                context,
                CELESTITE_ORE,
                holder(context,MtaConfigFeatures.CELESTITE_ORE),
                MTAOreUtils.commonOrePlacement(26,
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(60), VerticalAnchor.top()))
        );
        register(
                context,
                CRYOLITE_ORE,
                holder(context,MtaConfigFeatures.CRYOLITE_ORE),
                MTAOreUtils.commonOrePlacement(32, PlacementUtils.FULL_RANGE)
        );
        register(
                context,
                GARNET_ORE,
                holder(context,MtaConfigFeatures.GARNET_ORE),
                MTAOreUtils.commonOrePlacement(32,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(32)))
        );
        register(
                context,
                MOONSTONE_ORE,
                holder(context,MtaConfigFeatures.MOONSTONE_ORE),
                MTAOreUtils.commonOrePlacement(28,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(12), VerticalAnchor.top()))

        );

        register(
                context,
                GRASSY_DIRT_PATCH,
                holder(context,MtaConfigFeatures.GRASSY_DIRT_PATCH),
                InSquarePlacement.spread(),
                CountPlacement.of(7),
                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                BiomeFilter.biome()
        );

        PlacementUtils.register(
                context,
                SCATTERED_LEAVES,
                holder(context,MtaConfigFeatures.SCATTERED_LEAVES),
                NoiseThresholdCountPlacement.of(-0.8, 2, 6),
                InSquarePlacement.spread(),
                PlacementUtils.HEIGHTMAP,
                BiomeFilter.biome()
        );

        PlacementUtils.register(
                context,
                PATCH_TUNDRA_GRASS,
                holder(context,MtaConfigFeatures.PATCH_TUNDRA_GRASS),VegetationPlacements.worldSurfaceSquaredWithCount(32)
        );
        PlacementUtils.register(
                context,
                SHALLOW_GRASS_SPARSE,
                holder(context,MtaConfigFeatures.SHALLOW_GRASS_SPARSE),VegetationPlacements.worldSurfaceSquaredWithCount(3)
        );
        PlacementUtils.register(
                context,
                CATTAIL_VEGETATION,
                holder(context,MtaConfigFeatures.CATTAIL_VEGETATION),
                VegetationPlacements.worldSurfaceSquaredWithCount(3)

        );
        PlacementUtils.register(
                context,
                CATTAIL_VEGETATION_WATERLOGGED,
                holder(context,MtaConfigFeatures.CATTAIL_VEGETATION_WATERLOGGED),
                VegetationPlacements.worldSurfaceSquaredWithCount(6)

        );

        PlacementUtils.register(
                context,
                PRICKLY_PEAR,
                holder(context,MtaConfigFeatures.PRICKLY_PEAR),
                VegetationPlacements.worldSurfaceSquaredWithCount(4)

        );
        PlacementUtils.register(
                context,
                PRICKLY_PEAR_SPARSE,
                holder(context,MtaConfigFeatures.PRICKLY_PEAR_SPARSE),
                List.of(
                        RarityFilter.onAverageOnceEvery(12),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome())

        );


        PlacementUtils.register(
                context,
                SAND_GRASS,
                holder(context,MtaConfigFeatures.SAND_GRASS),
                VegetationPlacements.worldSurfaceSquaredWithCount(7)

        );
        PlacementUtils.register(
                context,
                SAND_GRASS_SPARSE,
                holder(context,MtaConfigFeatures.SAND_GRASS),
                VegetationPlacements.worldSurfaceSquaredWithCount(2)


        );
        PlacementUtils.register(
                context,
                BEACHGRASS,
                holder(context,MtaConfigFeatures.BEACHGRASS),
                VegetationPlacements.worldSurfaceSquaredWithCount(5)

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

    private static List<PlacementModifier> listAdd(List<PlacementModifier> list, PlacementModifier... modifiers){
        List<PlacementModifier> newList = new ArrayList<>(List.copyOf(list));
        newList.addAll(List.of(modifiers));
        return newList;
    }
}
