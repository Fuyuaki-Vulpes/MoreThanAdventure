package com.fuyuaki.morethanadventure.game.worldgen;

import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.fuyuaki.morethanadventure.core.registry.MtaFeatures;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import com.fuyuaki.morethanadventure.world.block.SweetBerryLeavesBlock;
import com.fuyuaki.morethanadventure.world.level.feature.configuration.OreClusterConfiguration;
import com.fuyuaki.morethanadventure.world.level.feature.placers.PalmFoliagePlacer;
import com.fuyuaki.morethanadventure.world.level.feature.placers.PalmTrunkPlacer;
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
import net.minecraft.world.level.block.PinkPetalsBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BushFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.neoforged.neoforge.common.Tags;

import java.util.List;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MtaConfigFeatures {

    public static final ResourceKey<ConfiguredFeature<?,?>> PALM_TREE = registerKey("palm_tree");
    public static final ResourceKey<ConfiguredFeature<?,?>> FREQUENT_CLAY = registerKey("frequent_clay");
    public static final ResourceKey<ConfiguredFeature<?,?>> DISK_MOSS = registerKey("disk_moss");
    public static final ResourceKey<ConfiguredFeature<?,?>> DIAMOND_CLUSTER = registerKey("diamond_cluster");
    public static final ResourceKey<ConfiguredFeature<?,?>> DEBRIS_CLUSTER = registerKey("debris_cluster");
    public static final ResourceKey<ConfiguredFeature<?,?>> STONY_ROCKS = registerKey("stony_rocks");
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
    public static final ResourceKey<ConfiguredFeature<?,?>> CELESTITE_ORE = registerKey("celestite_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> GARNET_ORE = registerKey("garnet_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> MOONSTONE_ORE = registerKey("moonstone_ore");
    public static final ResourceKey<ConfiguredFeature<?,?>> SWEET_BERRY_LEAVES = registerKey("sweet_berry_leaves");
    public static final ResourceKey<ConfiguredFeature<?,?>> GRASSY_DIRT_PATCH = registerKey("grassy_dirt_patch");
    public static final ResourceKey<ConfiguredFeature<?,?>> SCATTERED_LEAVES = registerKey("scattered_leaves");
    public static final ResourceKey<ConfiguredFeature<?,?>> PATCH_TUNDRA_GRASS = registerKey("patch_tundra_grass");
    public static final ResourceKey<ConfiguredFeature<?,?>> SHALLOW_GRASS_SPARSE = registerKey("shallow_grass_sparse");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

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
                PALM_TREE,
                Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(MtaBlocks.PALM_LOG.get()),
                        new PalmTrunkPlacer(4, 5, 3),
                        BlockStateProvider.simple(MtaBlocks.PALM_LEAVES.get()),
                        new PalmFoliagePlacer(ConstantInt.of(4), ConstantInt.of(1)),
                        new TwoLayersFeatureSize(1, 0, 2)).build()
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
                STONY_ROCKS,
                Feature.FOREST_ROCK,
                new BlockStateConfiguration(Blocks.ANDESITE.defaultBlockState())
        );
        register(context,
                MOSSY_ROCKS,
                Feature.FOREST_ROCK,
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
                        blockTest(oresNetherrack,MtaBlocks.NETHER_IRON_ORE.get()),
                        9

                    )
        );
        register(context,
                NETHER_DIAMOND,
                Feature.ORE,
                new OreConfiguration(blockTest(oresNetherrack,MtaBlocks.NETHER_DIAMOND_ORE.get()),
                        14,
                        0.7F

                    )
        );
        register(context,
                END_LAPIS,
                Feature.ORE,
                new OreConfiguration(
                        blockTest(oresEndstone,MtaBlocks.END_LAPIS_ORE.get()),
                        9

                    )
        );
        register(context,
                END_EMERALD,
                Feature.ORE,
                new OreConfiguration(blockTest(oresEndstone,MtaBlocks.END_EMERALD_ORE.get()),
                        5
                    )
        );
        register(context,
                CLEAR_QUARTZ_ORE,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone,MtaBlocks.CLEAR_QUARTZ_ORE.get(), oresDeepslate,MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_ORE.get()),
                        3
                    )
        );
        register(context,
                LARGE_CLEAR_QUARTZ_VEIN,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone,MtaBlocks.CLEAR_QUARTZ_ORE.get(), oresDeepslate,MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_ORE.get()),
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
                new OreConfiguration(blockTest(oresNetherrack,MtaBlocks.NETHERITIC_CRYSTAL.get()),
                        7,
                        0.8F

                )
        );

        register(context,
                AGATE_ORE,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone,MtaBlocks.AGATE_ORE.get(), oresDeepslate,MtaBlocks.DEEPSLATE_AGATE_ORE.get()),
                        1,
                        0.5F
                )
        );
        register(context,
                ALEXANDRITE_ORE,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone,MtaBlocks.ALEXANDRITE_ORE.get(), oresDeepslate,MtaBlocks.DEEPSLATE_ALEXANDRITE_ORE.get()),
                        1,
                        0.5F
                )
        );
        register(context,
                AQUAMARINE_ORE,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone,MtaBlocks.AQUAMARINE_ORE.get(), oresDeepslate,MtaBlocks.DEEPSLATE_AQUAMARINE_ORE.get()),
                        1,
                        0.5F
                )
        );
        register(context,
                CELESTITE_ORE,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone,MtaBlocks.CELESTITE_ORE.get(), oresDeepslate,MtaBlocks.DEEPSLATE_CELESTITE_ORE.get()),
                        1,
                        0.5F
                )
        );
        register(context,
                GARNET_ORE,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone,MtaBlocks.GARNET_ORE.get(), oresDeepslate,MtaBlocks.DEEPSLATE_GARNET_ORE.get()),
                        1,
                        0.5F
                )
        );
        register(context,
                MOONSTONE_ORE,
                Feature.ORE,
                new OreConfiguration(blockTest(oresStone,MtaBlocks.MOONSTONE_ORE.get(), oresDeepslate,MtaBlocks.DEEPSLATE_MOONSTONE_ORE.get()),
                        1,
                        0.5F
                )
        );
        register(context,
                SWEET_BERRY_LEAVES,Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(Blocks.SPRUCE_LOG),
                        new StraightTrunkPlacer(1, 0, 0),
                        BlockStateProvider.simple(MtaBlocks.SWEET_BERRY_LEAVES.get().defaultBlockState().setValue(SweetBerryLeavesBlock.AGE, Integer.valueOf(2))),
                        new BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
                        new TwoLayersFeatureSize(0, 0, 0)
                )
                        .build()
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
                                        BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.not(BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.PODZOL))
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
