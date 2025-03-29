package com.fuyuaki.morethanadventure.game.worldgen;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlocks;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaFeatures;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import com.fuyuaki.morethanadventure.world.level.feature.configuration.OreClusterConfiguration;
import com.fuyuaki.morethanadventure.world.level.feature.feature.GentleForkingTrunkPlacer;
import com.fuyuaki.morethanadventure.world.level.feature.placers.PalmFoliagePlacer;
import com.fuyuaki.morethanadventure.world.level.feature.placers.PalmTrunkPlacer;
import com.fuyuaki.morethanadventure.world.level.feature.placers.SeawoodTrunkPlacer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.PinkPetalsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.BeehiveDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.neoforged.neoforge.common.Tags;

import java.util.List;
import java.util.OptionalInt;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MtaConfigFeatures {

    public static final ResourceKey<ConfiguredFeature<?,?>> ALPINE_TREE = registerKey("alpine_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> AVOCADO_TREE = registerKey("avocado_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> BOGGED_OAK_TREE = registerKey("bogged_oak_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> PINK_IPE_TREE = registerKey("pink_ipe_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> PURPLE_IPE_TREE = registerKey("purple_ipe_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> WHITE_IPE_TREE = registerKey("white_ipe_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> YELLOW_IPE_TREE = registerKey("yellow_ipe_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> MANGO_TREE = registerKey("mango_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> MAPLE_TREE = registerKey("maple_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> PALM_TREE = registerKey("palm_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> ACACIA_BUSH = registerKey("acacia_bush");
    public static final ResourceKey<ConfiguredFeature<?,?>> BIRCH_BUSH = registerKey("birch_bush");
    public static final ResourceKey<ConfiguredFeature<?,?>> OAK_BUSH = registerKey("oak_bush");
    public static final ResourceKey<ConfiguredFeature<?,?>> DARK_OAK_BUSH = registerKey("dark_oak_bush");
    public static final ResourceKey<ConfiguredFeature<?,?>> SPRUCE_BUSH = registerKey("spruce_bush");
    public static final ResourceKey<ConfiguredFeature<?,?>> SEAWOOD_TREE = registerKey("seawood_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> FREQUENT_CLAY = registerKey("frequent_clay");
    public static final ResourceKey<ConfiguredFeature<?,?>> DISK_MOSS = registerKey("disk_moss");
    public static final ResourceKey<ConfiguredFeature<?,?>> DIAMOND_CLUSTER = registerKey("diamond_cluster");
    public static final ResourceKey<ConfiguredFeature<?,?>> DEBRIS_CLUSTER = registerKey("debris_cluster");
    public static final ResourceKey<ConfiguredFeature<?,?>> SANDSTONE_ROCKS = registerKey("sandstone_rocks");
    public static final ResourceKey<ConfiguredFeature<?,?>> STONY_ROCKS = registerKey("stony_rocks");
    public static final ResourceKey<ConfiguredFeature<?,?>> PERMAFROST_ROCKS = registerKey("permafrost_rocks");
    public static final ResourceKey<ConfiguredFeature<?,?>> MOSSY_ROCKS = registerKey("mossy_rocks");
    public static final ResourceKey<ConfiguredFeature<?,?>> GEYSER_OVERWORLD = registerKey("geyser_overworld");
    public static final ResourceKey<ConfiguredFeature<?,?>> GEYSER_NETHER = registerKey("geyser_nether");
    public static final ResourceKey<ConfiguredFeature<?,?>> NETHER_IRON = registerKey("nether_iron");
    public static final ResourceKey<ConfiguredFeature<?,?>> NETHER_DIAMOND = registerKey("nether_diamond");
    public static final ResourceKey<ConfiguredFeature<?,?>> END_LAPIS = registerKey("nether_lapis");
    public static final ResourceKey<ConfiguredFeature<?,?>> END_EMERALD = registerKey("nether_emerald");
    public static final ResourceKey<ConfiguredFeature<?,?>> CLEAR_QUARTZ_ORE = registerKey("clear_quartz_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> LARGE_CLEAR_QUARTZ_VEIN = registerKey("large_clear_quartz_vein");
    public static final ResourceKey<ConfiguredFeature<?,?>> CLEAR_QUARTZ_SHARD = registerKey("clear_quartz_shard");
    public static final ResourceKey<ConfiguredFeature<?,?>> NETHERITIC_CRYSTAL_ORE = registerKey("netheritic_crystal_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> AGATE_ORE = registerKey("agate_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> ALEXANDRITE_ORE = registerKey("alexandrite_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> AQUAMARINE_ORE = registerKey("aquamarine_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> BLOODSTONE_ORE = registerKey("bloodstone_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> CELESTITE_ORE = registerKey("celestite_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> CRYOLITE_ORE = registerKey("cryolite_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> GARNET_ORE = registerKey("garnet_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> MOONSTONE_ORE = registerKey("moonstone_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> GRASSY_DIRT_PATCH = registerKey("grassy_dirt_patch");
    public static final ResourceKey<ConfiguredFeature<?,?>> SCATTERED_LEAVES = registerKey("scattered_leaves");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_TUNDRA_GRASS = registerKey("patch_tundra_grass");
    public static final ResourceKey<ConfiguredFeature<?,?>> SHALLOW_GRASS_SPARSE = registerKey("shallow_grass_sparse");
    public static final ResourceKey<ConfiguredFeature<?,?>> PRICKLY_PEAR = registerKey("prickly_pear");
    public static final ResourceKey<ConfiguredFeature<?,?>> PRICKLY_PEAR_SPARSE = registerKey("prickly_pear_sparse");
    public static final ResourceKey<ConfiguredFeature<?,?>> SAND_GRASS = registerKey("sand_grass");
    public static final ResourceKey<ConfiguredFeature<?,?>> BEACHGRASS = registerKey("beachgrass");


    public static final ResourceKey<ConfiguredFeature<?,?>> HUGE_DEATH_CAP = registerKey("huge_death_cap");
    public static final ResourceKey<ConfiguredFeature<?,?>> HUGE_DEATH_ANGEL = registerKey("huge_death_angel");
    public static final ResourceKey<ConfiguredFeature<?,?>> HUGE_FLY_AGARIC = registerKey("huge_fly_agaric");
    public static final ResourceKey<ConfiguredFeature<?,?>> HUGE_KING_BOLETE = registerKey("huge_king_bolete");
    public static final ResourceKey<ConfiguredFeature<?,?>> HUGE_MAITAKE = registerKey("huge_maitake");
    public static final ResourceKey<ConfiguredFeature<?,?>> HUGE_MOREL = registerKey("huge_morel");

    public static final ResourceKey<ConfiguredFeature<?,?>> CATTAIL_VEGETATION = registerKey("cattail_vegetation");
    public static final ResourceKey<ConfiguredFeature<?,?>> CATTAIL_VEGETATION_WATERLOGGED = registerKey("cattail_vegetation_waterlogged");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        BeehiveDecorator beehiveVeryRare = new BeehiveDecorator(0.002F);
        BeehiveDecorator beehiveRare = new BeehiveDecorator(0.01F);
        BeehiveDecorator beehiveSlightlyRare = new BeehiveDecorator(0.02F);
        BeehiveDecorator beehiveCommon = new BeehiveDecorator(0.05F);
        BeehiveDecorator beehiveAlways = new BeehiveDecorator(1.0F);
        SimpleWeightedRandomList.Builder<BlockState> leavesBuilder = SimpleWeightedRandomList.builder();

        for (int i = 1; i <= 4; i++) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                leavesBuilder.add(
                        MtaBlocks.SCATTERED_LEAVES.get().defaultBlockState().setValue(PinkPetalsBlock.AMOUNT, Integer.valueOf(i)).setValue(PinkPetalsBlock.FACING, direction), 1
                );
            }
        }


        RuleTest clusterOresOverworld = new TagMatchTest(MtaTags.Blocks.ORE_CLUSTER_REPLACEABLE);
        RuleTest clusterOresNether = new TagMatchTest(MtaTags.Blocks.NETHER_CLUSTER_CLUSTER_REPLACEABLE);
        RuleTest oresStone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest oresDeepslate = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest oresNetherrack = new TagMatchTest(Tags.Blocks.NETHERRACKS);
        RuleTest oresEndstone = new TagMatchTest(Tags.Blocks.END_STONES);

        HolderGetter<ConfiguredFeature<?, ?>> holdergetter = context.lookup(Registries.CONFIGURED_FEATURE);

        register(
                context,
                ALPINE_TREE,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(MtaBlocks.ALPINE_LOG.get()),
                        new StraightTrunkPlacer(6, 4, 0),
                        BlockStateProvider.simple(MtaBlocks.ALPINE_LEAVES.get()),
                        new PineFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), UniformInt.of(3, 4)),
                        new TwoLayersFeatureSize(2, 0, 2)
                )
                        .ignoreVines()
                        .build()
        );
        register(
                context,
                AVOCADO_TREE,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(MtaBlocks.AVOCADO_LOG.get()),
                        new GentleForkingTrunkPlacer(3, 3, 1),
                        BlockStateProvider.simple(MtaBlocks.AVOCADO_LEAVES.get()),
                        new CherryFoliagePlacer(ConstantInt.of(5), ConstantInt.of(0), ConstantInt.of(4), 0.65F, 0.3F, 0.05F, 0.2F),
                        new TwoLayersFeatureSize(3, 0, 4)).decorators(List.of(beehiveRare)).build()
        );
        register(
                context,
                BOGGED_OAK_TREE,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(MtaBlocks.BOGGED_OAK_LOG.get()),
                        new PalmTrunkPlacer(4, 5, 3),
                        BlockStateProvider.simple(Blocks.OAK_LEAVES),
                        new PalmFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
                        new TwoLayersFeatureSize(0, 0, 0)).build()
        );
        register(
                context,
                PINK_IPE_TREE,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(MtaBlocks.IPE_LOG.get()),
                        new GentleForkingTrunkPlacer(4, 0, 2),
                        BlockStateProvider.simple(MtaBlocks.PINK_IPE_LEAVES.get()),
                        new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F),
                        new TwoLayersFeatureSize(1, 0, 2)).build()
        );
        register(
                context,
                PURPLE_IPE_TREE,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(MtaBlocks.IPE_LOG.get()),
                        new GentleForkingTrunkPlacer(4, 0, 2),
                        BlockStateProvider.simple(MtaBlocks.PURPLE_IPE_LEAVES.get()),
                        new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F),
                        new TwoLayersFeatureSize(1, 0, 2)).build()
        );
        register(
                context,
                WHITE_IPE_TREE,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(MtaBlocks.IPE_LOG.get()),
                        new GentleForkingTrunkPlacer(4, 0, 2),
                        BlockStateProvider.simple(MtaBlocks.WHITE_IPE_LEAVES.get()),
                        new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F),
                        new TwoLayersFeatureSize(1, 0, 2)).build()
        );
        register(
                context,
                YELLOW_IPE_TREE,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(MtaBlocks.IPE_LOG.get()),
                        new GentleForkingTrunkPlacer(4, 0, 2),
                        BlockStateProvider.simple(MtaBlocks.YELLOW_IPE_LEAVES.get()),
                        new CherryFoliagePlacer(ConstantInt.of(4), ConstantInt.of(0), ConstantInt.of(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F),
                        new TwoLayersFeatureSize(1, 0, 2)).build()
        );
        register(
                context,
                MANGO_TREE,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(MtaBlocks.MANGO_LOG.get()),
                        new FancyTrunkPlacer(7, 5, 0),
                        BlockStateProvider.simple(MtaBlocks.MANGO_LEAVES.get()),
                        new FancyFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
                        new TwoLayersFeatureSize(0, 0, 0,OptionalInt.of(4))).build()
        );
        register(
                context,
                MAPLE_TREE,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(MtaBlocks.MAPLE_LOG.get()),
                        new StraightTrunkPlacer(6, 2, 0),
                        BlockStateProvider.simple(MtaBlocks.MAPLE_LEAVES.get()),
                        new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                        new TwoLayersFeatureSize(1, 0, 1)).build()
        );
        register(
                context,
                PALM_TREE,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(MtaBlocks.PALM_LOG.get()),
                        new PalmTrunkPlacer(4, 5, 3),
                        BlockStateProvider.simple(MtaBlocks.PALM_LEAVES.get()),
                        new PalmFoliagePlacer(ConstantInt.of(4), ConstantInt.of(1)),
                        new TwoLayersFeatureSize(1, 0, 2)).build()
        );

        FeatureUtils.register(
                context,
                ACACIA_BUSH,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(Blocks.ACACIA_LOG),
                        new StraightTrunkPlacer(1, 0, 0),
                        BlockStateProvider.simple(Blocks.ACACIA_LEAVES),
                        new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
                        new TwoLayersFeatureSize(0, 0, 0)
                )
                        .build()
        );

        FeatureUtils.register(
                context,
                BIRCH_BUSH,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(Blocks.BIRCH_LOG),
                        new StraightTrunkPlacer(1, 0, 0),
                        BlockStateProvider.simple(Blocks.BIRCH_LEAVES),
                        new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
                        new TwoLayersFeatureSize(0, 0, 0)
                )
                        .build()
        );

        FeatureUtils.register(
                context,
                OAK_BUSH,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(Blocks.OAK_LOG),
                        new StraightTrunkPlacer(1, 0, 0),
                        BlockStateProvider.simple(Blocks.OAK_LEAVES),
                        new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
                        new TwoLayersFeatureSize(0, 0, 0)
                )
                        .build()
        );

        FeatureUtils.register(
                context,
                DARK_OAK_BUSH,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(Blocks.DARK_OAK_LOG),
                        new StraightTrunkPlacer(1, 0, 0),
                        BlockStateProvider.simple(Blocks.DARK_OAK_LEAVES),
                        new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
                        new TwoLayersFeatureSize(0, 0, 0)
                )
                        .build()
        );

        FeatureUtils.register(
                context,
                SPRUCE_BUSH,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(Blocks.SPRUCE_LOG),
                        new StraightTrunkPlacer(1, 0, 0),
                        BlockStateProvider.simple(Blocks.SPRUCE_LEAVES),
                        new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
                        new TwoLayersFeatureSize(0, 0, 0)
                )
                        .build()
        );

        register(
                context,
                SEAWOOD_TREE,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(MtaBlocks.SEALOG.get()),
                        new SeawoodTrunkPlacer(7, 4, 3),
                        BlockStateProvider.simple(MtaBlocks.SEAWOOD_LEAVES.get()),
                        new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
                        new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())
                )
                        .build()
        );

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
                        RuleBasedBlockStateProvider.simple(Blocks.MOSS_BLOCK), BlockPredicate.matchesBlocks(List.of(Blocks.DIRT, Blocks.GRASS_BLOCK, Blocks.SAND)), UniformInt.of(2, 6), 1
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
                SANDSTONE_ROCKS,
                MtaFeatures.ROCK_BLOBS.get(),
                new BlockStateConfiguration(Blocks.SANDSTONE.defaultBlockState())
        );
        register(context,
                STONY_ROCKS,
                MtaFeatures.ROCK_BLOBS.get(),
                new BlockStateConfiguration(Blocks.ANDESITE.defaultBlockState())
        );
        register(context,
                PERMAFROST_ROCKS,
                MtaFeatures.ROCK_BLOBS.get(),
                new BlockStateConfiguration(MtaBlocks.PERMAFROST_STONE.get().defaultBlockState())
        );
        register(context,
                MOSSY_ROCKS,
                MtaFeatures.ROCK_BLOBS.get(),
                new BlockStateConfiguration(MtaBlocks.MOSSY_ANDESITE.get().defaultBlockState())
        );

        List<OreConfiguration.TargetBlockState> geyserOverworld = List.of(
                OreConfiguration.target(new BlockMatchTest(Blocks.STONE), MtaBlocks.STONE_GEYSER.get().defaultBlockState()),
                OreConfiguration.target(new BlockMatchTest(Blocks.GRAVEL), MtaBlocks.STONE_GEYSER.get().defaultBlockState()),
                OreConfiguration.target(new TagMatchTest(BlockTags.TERRACOTTA), MtaBlocks.TERRACOTTA_GEYSER.get().defaultBlockState()),
                OreConfiguration.target(new BlockMatchTest(Blocks.RED_SAND), MtaBlocks.TERRACOTTA_GEYSER.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> geyserNether = List.of(
                OreConfiguration.target(new BlockMatchTest(Blocks.NETHERRACK), MtaBlocks.NETHERRACK_GEYSER.get().defaultBlockState()),
                OreConfiguration.target(new BlockMatchTest(Blocks.BASALT), MtaBlocks.BASALT_GEYSER.get().defaultBlockState())
        );

        register(context,
                GEYSER_OVERWORLD,
                Feature.REPLACE_SINGLE_BLOCK,
                new ReplaceBlockConfiguration(geyserOverworld));
        register(context,
                GEYSER_NETHER,
                Feature.REPLACE_SINGLE_BLOCK,
                new ReplaceBlockConfiguration(geyserNether));

        register(context,
                NETHER_IRON,
                Feature.ORE,
                new OreConfiguration(
                        blockTest(oresNetherrack, MtaBlocks.NETHER_IRON_ORE.get()),
                        9

                )
        );
        register(context,
                NETHER_DIAMOND,
                Feature.ORE,
                new OreConfiguration(blockTest(oresNetherrack, MtaBlocks.NETHER_DIAMOND_ORE.get()),
                        14,
                        0.7F

                )
        );
        register(context,
                END_LAPIS,
                Feature.ORE,
                new OreConfiguration(
                        blockTest(oresEndstone, MtaBlocks.END_LAPIS_ORE.get()),
                        9

                )
        );
        register(context,
                END_EMERALD,
                Feature.ORE,
                new OreConfiguration(blockTest(oresEndstone, MtaBlocks.END_EMERALD_ORE.get()),
                        5
                )
        );
        register(context,
                CLEAR_QUARTZ_ORE,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone, MtaBlocks.CLEAR_QUARTZ_ORE.get(), oresDeepslate, MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_ORE.get()),
                        3
                )
        );
        register(context,
                LARGE_CLEAR_QUARTZ_VEIN,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone, MtaBlocks.CLEAR_QUARTZ_ORE.get(), oresDeepslate, MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_ORE.get()),
                        10
                )
        );
        register(context,
                CLEAR_QUARTZ_SHARD,
                Feature.REPLACE_SINGLE_BLOCK,
                new ReplaceBlockConfiguration(List.of(
                        OreConfiguration.target(new BlockMatchTest(Blocks.CALCITE), MtaBlocks.CALCITE_CLEAR_QUARTZ_GROWTH.get().defaultBlockState()),
                        OreConfiguration.target(new BlockMatchTest(Blocks.DEEPSLATE), MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_GROWTH.get().defaultBlockState()),
                        OreConfiguration.target(new BlockMatchTest(Blocks.STONE), MtaBlocks.CLEAR_QUARTZ_GROWTH.get().defaultBlockState())

                )
                )
        );

        register(context,
                NETHERITIC_CRYSTAL_ORE,
                Feature.ORE,
                new OreConfiguration(blockTest(oresNetherrack, MtaBlocks.NETHERITIC_CRYSTAL.get()),
                        7,
                        0.8F

                )
        );

        register(context,
                AGATE_ORE,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone, MtaBlocks.AGATE_ORE.get(), oresDeepslate, MtaBlocks.DEEPSLATE_AGATE_ORE.get()),
                        8,
                        0.2F
                )
        );
        register(context,
                ALEXANDRITE_ORE,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone, MtaBlocks.ALEXANDRITE_ORE.get(), oresDeepslate, MtaBlocks.DEEPSLATE_ALEXANDRITE_ORE.get()),
                        4,
                        0.2F
                )
        );
        register(context,
                AQUAMARINE_ORE,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone, MtaBlocks.AQUAMARINE_ORE.get(), oresDeepslate, MtaBlocks.DEEPSLATE_AQUAMARINE_ORE.get()),
                        7,
                        0.2F
                )
        );
        register(context,
                BLOODSTONE_ORE,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone, MtaBlocks.BLOODSTONE_ORE.get(), oresDeepslate, MtaBlocks.DEEPSLATE_BLOODSTONE_ORE.get()),
                        6,
                        0.2F
                )
        );
        register(context,
                CELESTITE_ORE,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone, MtaBlocks.CELESTITE_ORE.get(), oresDeepslate, MtaBlocks.DEEPSLATE_CELESTITE_ORE.get()),
                        8,
                        0.2F
                )
        );
        register(context,
                CRYOLITE_ORE,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone, MtaBlocks.CRYOLITE_ORE.get(), oresDeepslate, MtaBlocks.CRYOLITE_ORE.get()),
                        6)
        );
        register(context,
                GARNET_ORE,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone, MtaBlocks.GARNET_ORE.get(), oresDeepslate, MtaBlocks.DEEPSLATE_GARNET_ORE.get()),
                        7,
                        0.2F
                )
        );
        register(context,
                MOONSTONE_ORE,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone, MtaBlocks.MOONSTONE_ORE.get(), oresDeepslate, MtaBlocks.DEEPSLATE_MOONSTONE_ORE.get()),
                        6,
                        0.2F
                )
        );


        register(
                context,
                GRASSY_DIRT_PATCH,
                Feature.DISK,
                new DiskConfiguration(
                        RuleBasedBlockStateProvider.simple(MtaBlocks.GRASSY_DIRT.get()), BlockPredicate.matchesBlocks(List.of(Blocks.GRASS_BLOCK)), UniformInt.of(2, 6), 1
                )
        );
        register(
                context,
                SCATTERED_LEAVES,
                Feature.FLOWER,
                new RandomPatchConfiguration(
                        56, 4, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(leavesBuilder)))
                )
        );
        register(
                context,
                PATCH_TUNDRA_GRASS,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(
                        54,
                        9,
                        3,
                        PlacementUtils.filtered(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(
                                        new WeightedStateProvider(
                                                SimpleWeightedRandomList.<BlockState>builder()
                                                        .add(Blocks.SHORT_GRASS.defaultBlockState(), 6)
                                                        .add(Blocks.FERN.defaultBlockState(), 1)
                                                        .add(Blocks.TALL_GRASS.defaultBlockState(), 3)
                                                        .add(MtaBlocks.SHALLOW_GRASS.get().defaultBlockState(), 24)
                                        )
                                ),
                                BlockPredicate.allOf(
                                        BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.not(BlockPredicate.matchesBlocks(Direction.DOWN.getUnitVec3i(), Blocks.PODZOL))
                                )
                        )
                )
        );
        register(
                context,
                SHALLOW_GRASS_SPARSE,
                Feature.RANDOM_PATCH,
                grassPatch(
                        BlockStateProvider.simple(
                                MtaBlocks.SHALLOW_GRASS.get()
                        ),
                        12
                )
        );
        register(
                context,
                HUGE_DEATH_CAP,
                Feature.HUGE_RED_MUSHROOM,
                new HugeMushroomFeatureConfiguration(
                        BlockStateProvider.simple(Blocks.RED_MUSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)),
                        BlockStateProvider.simple(
                                Blocks.MUSHROOM_STEM
                                        .defaultBlockState()
                                        .setValue(HugeMushroomBlock.UP, Boolean.FALSE)
                                        .setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)
                        ),
                        2
                )
        );
        register(
                context,
                HUGE_DEATH_ANGEL,
                Feature.HUGE_RED_MUSHROOM,
                new HugeMushroomFeatureConfiguration(
                        BlockStateProvider.simple(Blocks.RED_MUSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)),
                        BlockStateProvider.simple(
                                Blocks.MUSHROOM_STEM
                                        .defaultBlockState()
                                        .setValue(HugeMushroomBlock.UP, Boolean.FALSE)
                                        .setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)
                        ),
                        2
                )
        );
        register(
                context,
                HUGE_FLY_AGARIC,
                Feature.HUGE_RED_MUSHROOM,
                new HugeMushroomFeatureConfiguration(
                        BlockStateProvider.simple(Blocks.RED_MUSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)),
                        BlockStateProvider.simple(
                                Blocks.MUSHROOM_STEM
                                        .defaultBlockState()
                                        .setValue(HugeMushroomBlock.UP, Boolean.FALSE)
                                        .setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)
                        ),
                        2
                )
        );
        register(
                context,
                HUGE_KING_BOLETE,
                Feature.HUGE_RED_MUSHROOM,
                new HugeMushroomFeatureConfiguration(
                        BlockStateProvider.simple(Blocks.RED_MUSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)),
                        BlockStateProvider.simple(
                                Blocks.MUSHROOM_STEM
                                        .defaultBlockState()
                                        .setValue(HugeMushroomBlock.UP, Boolean.FALSE)
                                        .setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)
                        ),
                        2
                )
        );
        register(
                context,
                HUGE_MAITAKE,
                Feature.HUGE_RED_MUSHROOM,
                new HugeMushroomFeatureConfiguration(
                        BlockStateProvider.simple(Blocks.RED_MUSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)),
                        BlockStateProvider.simple(
                                Blocks.MUSHROOM_STEM
                                        .defaultBlockState()
                                        .setValue(HugeMushroomBlock.UP, Boolean.FALSE)
                                        .setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)
                        ),
                        2
                )
        );
        register(
                context,
                HUGE_MOREL,
                Feature.HUGE_RED_MUSHROOM,
                new HugeMushroomFeatureConfiguration(
                        BlockStateProvider.simple(Blocks.RED_MUSHROOM_BLOCK.defaultBlockState().setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)),
                        BlockStateProvider.simple(
                                Blocks.MUSHROOM_STEM
                                        .defaultBlockState()
                                        .setValue(HugeMushroomBlock.UP, Boolean.FALSE)
                                        .setValue(HugeMushroomBlock.DOWN, Boolean.FALSE)
                        ),
                        2
                )
        );

        register(
                context,
                CATTAIL_VEGETATION,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(6, 3, 2, PlacementUtils.filtered(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(MtaBlocks.CATTAIL.get())),
                        BlockPredicate.allOf(BlockPredicate.wouldSurvive(MtaBlocks.CATTAIL.get().defaultBlockState(), BlockPos.ZERO),BlockPredicate.ONLY_IN_AIR_PREDICATE)
                )
                ));
        register(
                context,
                CATTAIL_VEGETATION_WATERLOGGED,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(16, 8, 2, PlacementUtils.filtered(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(MtaBlocks.CATTAIL.get()
                                .defaultBlockState().setValue(BlockStateProperties.WATERLOGGED,true))),
                        BlockPredicate.allOf(
                                BlockPredicate.wouldSurvive(MtaBlocks.CATTAIL.get().defaultBlockState(), BlockPos.ZERO),
                                BlockPredicate.matchesBlocks(Blocks.WATER)
                        )
                )
                ));

        register(
                context,
                PRICKLY_PEAR,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(7, 3, 3, PlacementUtils.filtered(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(MtaBlocks.PRICKLY_PEAR.get())),
                        BlockPredicate.allOf(BlockPredicate.wouldSurvive(MtaBlocks.PRICKLY_PEAR.get().defaultBlockState(), BlockPos.ZERO),BlockPredicate.ONLY_IN_AIR_PREDICATE)
                )
                ));
        register(
                context,
                PRICKLY_PEAR_SPARSE,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(5, 8, 2, PlacementUtils.filtered(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(MtaBlocks.PRICKLY_PEAR.get())),
                        BlockPredicate.allOf(BlockPredicate.wouldSurvive(MtaBlocks.PRICKLY_PEAR.get().defaultBlockState(), BlockPos.ZERO),BlockPredicate.ONLY_IN_AIR_PREDICATE)
                )
                ));

        register(
                context,
                SAND_GRASS,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(22, 6, 3, PlacementUtils.filtered(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(MtaBlocks.SAND_GRASS.get())),
                        BlockPredicate.allOf(BlockPredicate.wouldSurvive(MtaBlocks.SAND_GRASS.get().defaultBlockState(), BlockPos.ZERO),BlockPredicate.ONLY_IN_AIR_PREDICATE)
                )
                ));
        register(
                context,
                BEACHGRASS,
                Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(17, 10, 6, PlacementUtils.filtered(
                        Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(MtaBlocks.BEACHGRASS.get())),
                        BlockPredicate.allOf(BlockPredicate.wouldSurvive(MtaBlocks.BEACHGRASS.get().defaultBlockState(), BlockPos.ZERO),BlockPredicate.ONLY_IN_AIR_PREDICATE)
                )
                ));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MODID, name));
    }

    private static List<OreConfiguration.TargetBlockState> blockTest(Block target, Block replacement){
        return List.of(
                OreConfiguration.target(new BlockMatchTest(target), replacement.defaultBlockState())
        );
    }
    private static List<OreConfiguration.TargetBlockState> blockTest(TagKey<Block> target, Block replacement){
        return List.of(
                OreConfiguration.target(new TagMatchTest(target), replacement.defaultBlockState())
        );
    }
    private static List<OreConfiguration.TargetBlockState> blockTest(RuleTest target, Block replacement){
        return List.of(
                OreConfiguration.target(target, replacement.defaultBlockState())
        );
    }
    private static List<OreConfiguration.TargetBlockState> blockTest(RuleTest target, Block replacement, RuleTest target2, Block replacement2){
        return List.of(
                OreConfiguration.target(target, replacement.defaultBlockState()),
                OreConfiguration.target(target2, replacement2.defaultBlockState())
        );
    }
    private static RandomPatchConfiguration grassPatch(BlockStateProvider stateProvider, int tries) {
        return FeatureUtils.simpleRandomPatchConfiguration(
                tries, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(stateProvider))
        );
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
