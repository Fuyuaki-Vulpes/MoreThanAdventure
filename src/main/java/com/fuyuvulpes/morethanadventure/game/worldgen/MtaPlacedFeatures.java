package com.fuyuvulpes.morethanadventure.game.worldgen;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;

import java.util.List;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class MtaPlacedFeatures {

    public static final ResourceKey<PlacedFeature> FREQUENT_CLAY = registerKey("frequent_clay");
    public static final ResourceKey<PlacedFeature> LUSH_VEGETATION = registerKey("lush_vegetation");


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
                LUSH_VEGETATION,
                holder(context,MtaConfigFeatures.LUSH_VEGETATION_POOL),
                CountPlacement.of(32),
                InSquarePlacement.spread(),
                PlacementUtils.RANGE_BOTTOM_TO_MAX_TERRAIN_HEIGHT,
                EnvironmentScanPlacement.scanningFor(Direction.DOWN, BlockPredicate.solid(),
                        BlockPredicate.allOf(
                        BlockPredicate.matchesBlocks(BlockPos.ZERO, Blocks.WATER),
                        BlockPredicate.matchesBlocks(Direction.UP.getNormal(), Blocks.WATER)
                ), 12),
                RandomOffsetPlacement.vertical(ConstantInt.of(1)),
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
