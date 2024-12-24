package com.fuyuaki.morethanadventure.core.registry;

import com.google.common.collect.Maps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;
import java.util.stream.Stream;

public class MTAFamilies {
    private static final Map<Block, BlockFamily> MAP = Maps.newHashMap();
    private static final String RECIPE_GROUP_PREFIX_WOODEN = "wooden";
    private static final String RECIPE_UNLOCKED_BY_HAS_PLANKS = "has_planks";

    public static final BlockFamily PALM_PLANKS = familyBuilder(MtaBlocks.PALM_PLANKS.get())
            .button(MtaBlocks.PALM_BUTTON.get())
            .fence(MtaBlocks.PALM_FENCE.get())
            .fenceGate(MtaBlocks.PALM_FENCE_GATE.get())
            .pressurePlate(MtaBlocks.PALM_PRESSURE_PLATE.get())
            //.sign(MtaBlocks.PALM_SIGN.get(), Blocks.PALM_WALL_SIGN.get())
            .slab(MtaBlocks.PALM_SLAB.get())
            .stairs(MtaBlocks.PALM_STAIRS.get())
            .door(MtaBlocks.PALM_DOOR.get())
            .trapdoor(MtaBlocks.PALM_TRAPDOOR.get())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();

    public static final BlockFamily SEAWOOD_PLANKS = familyBuilder(MtaBlocks.SEAWOOD_PLANKS.get())
            .button(MtaBlocks.SEAWOOD_BUTTON.get())
            .fence(MtaBlocks.SEAWOOD_FENCE.get())
            .fenceGate(MtaBlocks.SEAWOOD_FENCE_GATE.get())
            .pressurePlate(MtaBlocks.SEAWOOD_PRESSURE_PLATE.get())
            //.sign(MtaBlocks.PALM_SIGN.get(), Blocks.PALM_WALL_SIGN.get())
            .slab(MtaBlocks.SEAWOOD_SLAB.get())
            .stairs(MtaBlocks.SEAWOOD_STAIRS.get())
            .door(MtaBlocks.SEAWOOD_DOOR.get())
            .trapdoor(MtaBlocks.SEAWOOD_TRAPDOOR.get())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();


    private static BlockFamily.Builder familyBuilder(Block baseBlock) {
        BlockFamily.Builder blockfamily$builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockfamily = MAP.put(baseBlock, blockfamily$builder.getFamily());
        if (blockfamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + BuiltInRegistries.BLOCK.getKey(baseBlock));
        } else {
            return blockfamily$builder;
        }
    }

    public static Stream<BlockFamily> getAllFamilies() {
        return MAP.values().stream();
    }




}
