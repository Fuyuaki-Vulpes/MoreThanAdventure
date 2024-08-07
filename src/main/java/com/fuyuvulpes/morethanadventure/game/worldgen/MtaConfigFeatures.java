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
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedBlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.neoforged.neoforge.common.Tags;

import java.util.List;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class MtaConfigFeatures {

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

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest clusterOresOverworld = new TagMatchTest(MtaTags.Blocks.ORE_CLUSTER_REPLACEABLE);
        RuleTest clusterOresNether = new TagMatchTest(MtaTags.Blocks.NETHER_CLUSTER_CLUSTER_REPLACEABLE);
        RuleTest oresStone = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest oresDeepslate = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest oresNetherrack = new TagMatchTest(Tags.Blocks.NETHERRACKS);
        RuleTest oresEndstone = new TagMatchTest(Tags.Blocks.END_STONES);

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
                new OreConfiguration(List.of(
                        OreConfiguration.target(oresNetherrack, MtaBlocks.NETHER_IRON_ORE.get().defaultBlockState())
                        ),
                        9

                    )
        );
        register(context,
                NETHER_DIAMOND,
                Feature.ORE,
                new OreConfiguration(List.of(
                        OreConfiguration.target(oresNetherrack, MtaBlocks.NETHER_DIAMOND_ORE.get().defaultBlockState())
                        ),
                        14,
                        0.7F

                    )
        );
        register(context,
                END_LAPIS,
                Feature.ORE,
                new OreConfiguration(List.of(
                        OreConfiguration.target(oresEndstone, MtaBlocks.END_LAPIS_ORE.get().defaultBlockState())
                        ),
                        9

                    )
        );
        register(context,
                END_EMERALD,
                Feature.ORE,
                new OreConfiguration(List.of(
                        OreConfiguration.target(oresEndstone, MtaBlocks.END_EMERALD_ORE.get().defaultBlockState())
                        ),
                        5

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
