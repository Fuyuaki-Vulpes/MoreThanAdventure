package com.fuyuaki.morethanadventure.core.registry;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlocks;
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



    public static final BlockFamily ALPINE_PLANKS = familyBuilder(MtaBlocks.ALPINE_PLANKS.get())
            .button(MtaBlocks.ALPINE_BUTTON.get())
            .fence(MtaBlocks.ALPINE_FENCE.get())
            .fenceGate(MtaBlocks.ALPINE_FENCE_GATE.get())
            .pressurePlate(MtaBlocks.ALPINE_PRESSURE_PLATE.get())
            .sign(MtaBlocks.ALPINE_SIGN.get(), MtaBlocks.ALPINE_WALL_SIGN.get())
            .slab(MtaBlocks.ALPINE_SLAB.get())
            .stairs(MtaBlocks.ALPINE_STAIRS.get())
            .door(MtaBlocks.ALPINE_DOOR.get())
            .trapdoor(MtaBlocks.ALPINE_TRAPDOOR.get())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();

    public static final BlockFamily AVOCADO_PLANKS = familyBuilder(MtaBlocks.AVOCADO_PLANKS.get())
            .button(MtaBlocks.AVOCADO_BUTTON.get())
            .fence(MtaBlocks.AVOCADO_FENCE.get())
            .fenceGate(MtaBlocks.AVOCADO_FENCE_GATE.get())
            .pressurePlate(MtaBlocks.AVOCADO_PRESSURE_PLATE.get())
            .sign(MtaBlocks.AVOCADO_SIGN.get(), MtaBlocks.AVOCADO_WALL_SIGN.get())
            .slab(MtaBlocks.AVOCADO_SLAB.get())
            .stairs(MtaBlocks.AVOCADO_STAIRS.get())
            .door(MtaBlocks.AVOCADO_DOOR.get())
            .trapdoor(MtaBlocks.AVOCADO_TRAPDOOR.get())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();

    public static final BlockFamily BOGGED_OAK_PLANKS = familyBuilder(MtaBlocks.BOGGED_OAK_PLANKS.get())
            .button(MtaBlocks.BOGGED_OAK_BUTTON.get())
            .fence(MtaBlocks.BOGGED_OAK_FENCE.get())
            .fenceGate(MtaBlocks.BOGGED_OAK_FENCE_GATE.get())
            .pressurePlate(MtaBlocks.BOGGED_OAK_PRESSURE_PLATE.get())
            .sign(MtaBlocks.BOGGED_OAK_SIGN.get(), MtaBlocks.BOGGED_OAK_WALL_SIGN.get())
            .slab(MtaBlocks.BOGGED_OAK_SLAB.get())
            .stairs(MtaBlocks.BOGGED_OAK_STAIRS.get())
            .door(MtaBlocks.BOGGED_OAK_DOOR.get())
            .trapdoor(MtaBlocks.BOGGED_OAK_TRAPDOOR.get())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();

    public static final BlockFamily IPE_PLANKS = familyBuilder(MtaBlocks.IPE_PLANKS.get())
            .button(MtaBlocks.IPE_BUTTON.get())
            .fence(MtaBlocks.IPE_FENCE.get())
            .fenceGate(MtaBlocks.IPE_FENCE_GATE.get())
            .pressurePlate(MtaBlocks.IPE_PRESSURE_PLATE.get())
            .sign(MtaBlocks.IPE_SIGN.get(), MtaBlocks.IPE_WALL_SIGN.get())
            .slab(MtaBlocks.IPE_SLAB.get())
            .stairs(MtaBlocks.IPE_STAIRS.get())
            .door(MtaBlocks.IPE_DOOR.get())
            .trapdoor(MtaBlocks.IPE_TRAPDOOR.get())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();
    public static final BlockFamily MANGO_PLANKS = familyBuilder(MtaBlocks.MANGO_PLANKS.get())
            .button(MtaBlocks.MANGO_BUTTON.get())
            .fence(MtaBlocks.MANGO_FENCE.get())
            .fenceGate(MtaBlocks.MANGO_FENCE_GATE.get())
            .pressurePlate(MtaBlocks.MANGO_PRESSURE_PLATE.get())
            .sign(MtaBlocks.MANGO_SIGN.get(), MtaBlocks.MANGO_WALL_SIGN.get())
            .slab(MtaBlocks.MANGO_SLAB.get())
            .stairs(MtaBlocks.MANGO_STAIRS.get())
            .door(MtaBlocks.MANGO_DOOR.get())
            .trapdoor(MtaBlocks.MANGO_TRAPDOOR.get())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();

    public static final BlockFamily MAPLE_PLANKS = familyBuilder(MtaBlocks.MAPLE_PLANKS.get())
            .button(MtaBlocks.MAPLE_BUTTON.get())
            .fence(MtaBlocks.MAPLE_FENCE.get())
            .fenceGate(MtaBlocks.MAPLE_FENCE_GATE.get())
            .pressurePlate(MtaBlocks.MAPLE_PRESSURE_PLATE.get())
            .sign(MtaBlocks.MAPLE_SIGN.get(), MtaBlocks.MAPLE_WALL_SIGN.get())
            .slab(MtaBlocks.MAPLE_SLAB.get())
            .stairs(MtaBlocks.MAPLE_STAIRS.get())
            .door(MtaBlocks.MAPLE_DOOR.get())
            .trapdoor(MtaBlocks.MAPLE_TRAPDOOR.get())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();

    public static final BlockFamily PALM_PLANKS = familyBuilder(MtaBlocks.PALM_PLANKS.get())
            .button(MtaBlocks.PALM_BUTTON.get())
            .fence(MtaBlocks.PALM_FENCE.get())
            .fenceGate(MtaBlocks.PALM_FENCE_GATE.get())
            .pressurePlate(MtaBlocks.PALM_PRESSURE_PLATE.get())
            .sign(MtaBlocks.PALM_SIGN.get(), MtaBlocks.PALM_WALL_SIGN.get())
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
            .sign(MtaBlocks.SEAWOOD_SIGN.get(), MtaBlocks.SEAWOOD_WALL_SIGN.get())
            .slab(MtaBlocks.SEAWOOD_SLAB.get())
            .stairs(MtaBlocks.SEAWOOD_STAIRS.get())
            .door(MtaBlocks.SEAWOOD_DOOR.get())
            .trapdoor(MtaBlocks.SEAWOOD_TRAPDOOR.get())
            .recipeGroupPrefix("wooden")
            .recipeUnlockedBy("has_planks")
            .getFamily();

    public static final BlockFamily STONE_TILES = familyBuilder(MtaBlocks.STONE_TILES.get())
            .slab(MtaBlocks.STONE_TILES_SLAB.get())
            .stairs(MtaBlocks.STONE_TILES_STAIRS.get())
            .wall(MtaBlocks.STONE_TILES_WALL.get())
            .recipeGroupPrefix("stone")
            .recipeUnlockedBy("has_stone_tiles")
            .getFamily();

    public static final BlockFamily SLIGHTLY_DIRTY_STONE_TILES = familyBuilder(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES.get())
            .slab(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_SLAB.get())
            .stairs(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_STAIRS.get())
            .wall(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_WALL.get())
            .recipeUnlockedBy("has_slightly_dirty_stone_tiles")
            .getFamily();

    public static final BlockFamily DIRTY_STONE_TILES = familyBuilder(MtaBlocks.DIRTY_STONE_TILES.get())
            .slab(MtaBlocks.DIRTY_STONE_TILES_SLAB.get())
            .stairs(MtaBlocks.DIRTY_STONE_TILES_STAIRS.get())
            .wall(MtaBlocks.DIRTY_STONE_TILES_WALL.get())
            .recipeUnlockedBy("has_dirty_stone_tiles")
            .getFamily();

    public static final BlockFamily VERY_DIRTY_STONE_TILES = familyBuilder(MtaBlocks.VERY_DIRTY_STONE_TILES.get())
            .slab(MtaBlocks.VERY_DIRTY_STONE_TILES_SLAB.get())
            .stairs(MtaBlocks.VERY_DIRTY_STONE_TILES_STAIRS.get())
            .wall(MtaBlocks.VERY_DIRTY_STONE_TILES_WALL.get())
            .recipeUnlockedBy("has_very_dirty_stone_tiles")
            .getFamily();

    public static final BlockFamily TERRACOTTA = familyBuilder(Blocks.TERRACOTTA)
            .slab(MtaBlocks.TERRACOTTA_SLAB.get())
            .stairs(MtaBlocks.TERRACOTTA_STAIRS.get())
            .wall(MtaBlocks.TERRACOTTA_WALL.get())
            .recipeUnlockedBy("has_terracotta")
            .getFamily();

    public static final BlockFamily TERRACOTTA_TILES = familyBuilder(MtaBlocks.TERRACOTTA_TILES.get())
            .slab(MtaBlocks.TERRACOTTA_TILES_SLAB.get())
            .stairs(MtaBlocks.TERRACOTTA_TILES_STAIRS.get())
            .wall(MtaBlocks.TERRACOTTA_TILES_WALL.get())
            .recipeUnlockedBy("has_terracotta_tiles")
            .getFamily();

    public static final BlockFamily WHITE_TERRACOTTA = familyBuilder(Blocks.WHITE_TERRACOTTA)
            .slab(MtaBlocks.WHITE_TERRACOTTA_SLAB.get())
            .stairs(MtaBlocks.WHITE_TERRACOTTA_STAIRS.get())
            .wall(MtaBlocks.WHITE_TERRACOTTA_WALL.get())
            .recipeUnlockedBy("has_white_terracotta")
            .getFamily();

    public static final BlockFamily WHITE_TERRACOTTA_TILES = familyBuilder(MtaBlocks.WHITE_TERRACOTTA_TILES.get())
            .slab(MtaBlocks.WHITE_TERRACOTTA_TILES_SLAB.get())
            .stairs(MtaBlocks.WHITE_TERRACOTTA_TILES_STAIRS.get())
            .wall(MtaBlocks.WHITE_TERRACOTTA_TILES_WALL.get())
            .recipeUnlockedBy("has_white_terracotta_tiles")
            .getFamily();

    public static final BlockFamily LIGHT_GRAY_TERRACOTTA = familyBuilder(Blocks.LIGHT_GRAY_TERRACOTTA)
            .slab(MtaBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get())
            .stairs(MtaBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get())
            .wall(MtaBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get())
            .recipeUnlockedBy("has_light_gray_terracotta")
            .getFamily();

    public static final BlockFamily LIGHT_GRAY_TERRACOTTA_TILES = familyBuilder(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES.get())
            .slab(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_SLAB.get())
            .stairs(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_STAIRS.get())
            .wall(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_WALL.get())
            .recipeUnlockedBy("has_light_gray_terracotta_tiles")
            .getFamily();

    public static final BlockFamily GRAY_TERRACOTTA = familyBuilder(Blocks.GRAY_TERRACOTTA)
            .slab(MtaBlocks.GRAY_TERRACOTTA_SLAB.get())
            .stairs(MtaBlocks.GRAY_TERRACOTTA_STAIRS.get())
            .wall(MtaBlocks.GRAY_TERRACOTTA_WALL.get())
            .recipeUnlockedBy("has_gray_terracotta")
            .getFamily();

    public static final BlockFamily GRAY_TERRACOTTA_TILES = familyBuilder(MtaBlocks.GRAY_TERRACOTTA_TILES.get())
            .slab(MtaBlocks.GRAY_TERRACOTTA_TILES_SLAB.get())
            .stairs(MtaBlocks.GRAY_TERRACOTTA_TILES_STAIRS.get())
            .wall(MtaBlocks.GRAY_TERRACOTTA_TILES_WALL.get())
            .recipeUnlockedBy("has_gray_terracotta_tiles")
            .getFamily();

    public static final BlockFamily BLACK_TERRACOTTA = familyBuilder(Blocks.BLACK_TERRACOTTA)
            .slab(MtaBlocks.BLACK_TERRACOTTA_SLAB.get())
            .stairs(MtaBlocks.BLACK_TERRACOTTA_STAIRS.get())
            .wall(MtaBlocks.BLACK_TERRACOTTA_WALL.get())
            .recipeUnlockedBy("has_black_terracotta")
            .getFamily();

    public static final BlockFamily BLACK_TERRACOTTA_TILES = familyBuilder(MtaBlocks.BLACK_TERRACOTTA_TILES.get())
            .slab(MtaBlocks.BLACK_TERRACOTTA_TILES_SLAB.get())
            .stairs(MtaBlocks.BLACK_TERRACOTTA_TILES_STAIRS.get())
            .wall(MtaBlocks.BLACK_TERRACOTTA_TILES_WALL.get())
            .recipeUnlockedBy("has_black_terracotta_tiles")
            .getFamily();

    public static final BlockFamily BROWN_TERRACOTTA = familyBuilder(Blocks.BROWN_TERRACOTTA)
            .slab(MtaBlocks.BROWN_TERRACOTTA_SLAB.get())
            .stairs(MtaBlocks.BROWN_TERRACOTTA_STAIRS.get())
            .wall(MtaBlocks.BROWN_TERRACOTTA_WALL.get())
            .recipeUnlockedBy("has_brown_terracotta")
            .getFamily();

    public static final BlockFamily BROWN_TERRACOTTA_TILES = familyBuilder(MtaBlocks.BROWN_TERRACOTTA_TILES.get())
            .slab(MtaBlocks.BROWN_TERRACOTTA_TILES_SLAB.get())
            .stairs(MtaBlocks.BROWN_TERRACOTTA_TILES_STAIRS.get())
            .wall(MtaBlocks.BROWN_TERRACOTTA_TILES_WALL.get())
            .recipeUnlockedBy("has_brown_terracotta_tiles")
            .getFamily();

    public static final BlockFamily RED_TERRACOTTA = familyBuilder(Blocks.RED_TERRACOTTA)
            .slab(MtaBlocks.RED_TERRACOTTA_SLAB.get())
            .stairs(MtaBlocks.RED_TERRACOTTA_STAIRS.get())
            .wall(MtaBlocks.RED_TERRACOTTA_WALL.get())
            .recipeUnlockedBy("has_red_terracotta")
            .getFamily();

    public static final BlockFamily RED_TERRACOTTA_TILES = familyBuilder(MtaBlocks.RED_TERRACOTTA_TILES.get())
            .slab(MtaBlocks.RED_TERRACOTTA_TILES_SLAB.get())
            .stairs(MtaBlocks.RED_TERRACOTTA_TILES_STAIRS.get())
            .wall(MtaBlocks.RED_TERRACOTTA_TILES_WALL.get())
            .recipeUnlockedBy("has_red_terracotta_tiles")
            .getFamily();

    public static final BlockFamily ORANGE_TERRACOTTA = familyBuilder(Blocks.ORANGE_TERRACOTTA)
            .slab(MtaBlocks.ORANGE_TERRACOTTA_SLAB.get())
            .stairs(MtaBlocks.ORANGE_TERRACOTTA_STAIRS.get())
            .wall(MtaBlocks.ORANGE_TERRACOTTA_WALL.get())
            .recipeUnlockedBy("has_orange_terracotta")
            .getFamily();

    public static final BlockFamily ORANGE_TERRACOTTA_TILES = familyBuilder(MtaBlocks.ORANGE_TERRACOTTA_TILES.get())
            .slab(MtaBlocks.ORANGE_TERRACOTTA_TILES_SLAB.get())
            .stairs(MtaBlocks.ORANGE_TERRACOTTA_TILES_STAIRS.get())
            .wall(MtaBlocks.ORANGE_TERRACOTTA_TILES_WALL.get())
            .recipeUnlockedBy("has_orange_terracotta_tiles")
            .getFamily();

    public static final BlockFamily YELLOW_TERRACOTTA = familyBuilder(Blocks.YELLOW_TERRACOTTA)
            .slab(MtaBlocks.YELLOW_TERRACOTTA_SLAB.get())
            .stairs(MtaBlocks.YELLOW_TERRACOTTA_STAIRS.get())
            .wall(MtaBlocks.YELLOW_TERRACOTTA_WALL.get())
            .recipeUnlockedBy("has_yellow_terracotta")
            .getFamily();

    public static final BlockFamily YELLOW_TERRACOTTA_TILES = familyBuilder(MtaBlocks.YELLOW_TERRACOTTA_TILES.get())
            .slab(MtaBlocks.YELLOW_TERRACOTTA_TILES_SLAB.get())
            .stairs(MtaBlocks.YELLOW_TERRACOTTA_TILES_STAIRS.get())
            .wall(MtaBlocks.YELLOW_TERRACOTTA_TILES_WALL.get())
            .recipeUnlockedBy("has_yellow_terracotta_tiles")
            .getFamily();

    public static final BlockFamily LIME_TERRACOTTA = familyBuilder(Blocks.LIME_TERRACOTTA)
            .slab(MtaBlocks.LIME_TERRACOTTA_SLAB.get())
            .stairs(MtaBlocks.LIME_TERRACOTTA_STAIRS.get())
            .wall(MtaBlocks.LIME_TERRACOTTA_WALL.get())
            .recipeUnlockedBy("has_lime_terracotta")
            .getFamily();

    public static final BlockFamily LIME_TERRACOTTA_TILES = familyBuilder(MtaBlocks.LIME_TERRACOTTA_TILES.get())
            .slab(MtaBlocks.LIME_TERRACOTTA_TILES_SLAB.get())
            .stairs(MtaBlocks.LIME_TERRACOTTA_TILES_STAIRS.get())
            .wall(MtaBlocks.LIME_TERRACOTTA_TILES_WALL.get())
            .recipeUnlockedBy("has_lime_terracotta_tiles")
            .getFamily();

    public static final BlockFamily GREEN_TERRACOTTA = familyBuilder(Blocks.GREEN_TERRACOTTA)
            .slab(MtaBlocks.GREEN_TERRACOTTA_SLAB.get())
            .stairs(MtaBlocks.GREEN_TERRACOTTA_STAIRS.get())
            .wall(MtaBlocks.GREEN_TERRACOTTA_WALL.get())
            .recipeUnlockedBy("has_green_terracotta")
            .getFamily();

    public static final BlockFamily GREEN_TERRACOTTA_TILES = familyBuilder(MtaBlocks.GREEN_TERRACOTTA_TILES.get())
            .slab(MtaBlocks.GREEN_TERRACOTTA_TILES_SLAB.get())
            .stairs(MtaBlocks.GREEN_TERRACOTTA_TILES_STAIRS.get())
            .wall(MtaBlocks.GREEN_TERRACOTTA_TILES_WALL.get())
            .recipeUnlockedBy("has_green_terracotta_tiles")
            .getFamily();

    public static final BlockFamily CYAN_TERRACOTTA = familyBuilder(Blocks.CYAN_TERRACOTTA)
            .slab(MtaBlocks.CYAN_TERRACOTTA_SLAB.get())
            .stairs(MtaBlocks.CYAN_TERRACOTTA_STAIRS.get())
            .wall(MtaBlocks.CYAN_TERRACOTTA_WALL.get())
            .recipeUnlockedBy("has_cyan_terracotta")
            .getFamily();

    public static final BlockFamily CYAN_TERRACOTTA_TILES = familyBuilder(MtaBlocks.CYAN_TERRACOTTA_TILES.get())
            .slab(MtaBlocks.CYAN_TERRACOTTA_TILES_SLAB.get())
            .stairs(MtaBlocks.CYAN_TERRACOTTA_TILES_STAIRS.get())
            .wall(MtaBlocks.CYAN_TERRACOTTA_TILES_WALL.get())
            .recipeUnlockedBy("has_cyan_terracotta_tiles")
            .getFamily();

    public static final BlockFamily LIGHT_BLUE_TERRACOTTA = familyBuilder(Blocks.LIGHT_BLUE_TERRACOTTA)
            .slab(MtaBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get())
            .stairs(MtaBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get())
            .wall(MtaBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get())
            .recipeUnlockedBy("has_light_blue_terracotta")
            .getFamily();

    public static final BlockFamily LIGHT_BLUE_TERRACOTTA_TILES = familyBuilder(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES.get())
            .slab(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_SLAB.get())
            .stairs(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_STAIRS.get())
            .wall(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_WALL.get())
            .recipeUnlockedBy("has_light_blue_terracotta_tiles")
            .getFamily();

    public static final BlockFamily BLUE_TERRACOTTA = familyBuilder(Blocks.BLUE_TERRACOTTA)
            .slab(MtaBlocks.BLUE_TERRACOTTA_SLAB.get())
            .stairs(MtaBlocks.BLUE_TERRACOTTA_STAIRS.get())
            .wall(MtaBlocks.BLUE_TERRACOTTA_WALL.get())
            .recipeUnlockedBy("has_blue_terracotta")
            .getFamily();

    public static final BlockFamily BLUE_TERRACOTTA_TILES = familyBuilder(MtaBlocks.BLUE_TERRACOTTA_TILES.get())
            .slab(MtaBlocks.BLUE_TERRACOTTA_TILES_SLAB.get())
            .stairs(MtaBlocks.BLUE_TERRACOTTA_TILES_STAIRS.get())
            .wall(MtaBlocks.BLUE_TERRACOTTA_TILES_WALL.get())
            .recipeUnlockedBy("has_blue_terracotta_tiles")
            .getFamily();

    public static final BlockFamily PURPLE_TERRACOTTA = familyBuilder(Blocks.PURPLE_TERRACOTTA)
            .slab(MtaBlocks.PURPLE_TERRACOTTA_SLAB.get())
            .stairs(MtaBlocks.PURPLE_TERRACOTTA_STAIRS.get())
            .wall(MtaBlocks.PURPLE_TERRACOTTA_WALL.get())
            .recipeUnlockedBy("has_purple_terracotta")
            .getFamily();

    public static final BlockFamily PURPLE_TERRACOTTA_TILES = familyBuilder(MtaBlocks.PURPLE_TERRACOTTA_TILES.get())
            .slab(MtaBlocks.PURPLE_TERRACOTTA_TILES_SLAB.get())
            .stairs(MtaBlocks.PURPLE_TERRACOTTA_TILES_STAIRS.get())
            .wall(MtaBlocks.PURPLE_TERRACOTTA_TILES_WALL.get())
            .recipeUnlockedBy("has_purple_terracotta_tiles")
            .getFamily();

    public static final BlockFamily MAGENTA_TERRACOTTA = familyBuilder(Blocks.MAGENTA_TERRACOTTA)
            .slab(MtaBlocks.MAGENTA_TERRACOTTA_SLAB.get())
            .stairs(MtaBlocks.MAGENTA_TERRACOTTA_STAIRS.get())
            .wall(MtaBlocks.MAGENTA_TERRACOTTA_WALL.get())
            .recipeUnlockedBy("has_magenta_terracotta")
            .getFamily();

    public static final BlockFamily MAGENTA_TERRACOTTA_TILES = familyBuilder(MtaBlocks.MAGENTA_TERRACOTTA_TILES.get())
            .slab(MtaBlocks.MAGENTA_TERRACOTTA_TILES_SLAB.get())
            .stairs(MtaBlocks.MAGENTA_TERRACOTTA_TILES_STAIRS.get())
            .wall(MtaBlocks.MAGENTA_TERRACOTTA_TILES_WALL.get())
            .recipeUnlockedBy("has_magenta_terracotta_tiles")
            .getFamily();

    public static final BlockFamily PINK_TERRACOTTA = familyBuilder(Blocks.PINK_TERRACOTTA)
            .slab(MtaBlocks.PINK_TERRACOTTA_SLAB.get())
            .stairs(MtaBlocks.PINK_TERRACOTTA_STAIRS.get())
            .wall(MtaBlocks.PINK_TERRACOTTA_WALL.get())
            .recipeUnlockedBy("has_pink_terracotta")
            .getFamily();

    public static final BlockFamily PINK_TERRACOTTA_TILES = familyBuilder(MtaBlocks.PINK_TERRACOTTA_TILES.get())
            .slab(MtaBlocks.PINK_TERRACOTTA_TILES_SLAB.get())
            .stairs(MtaBlocks.PINK_TERRACOTTA_TILES_STAIRS.get())
            .wall(MtaBlocks.PINK_TERRACOTTA_TILES_WALL.get())
            .recipeUnlockedBy("has_pink_terracotta_tiles")
            .getFamily();

    public static final BlockFamily WHITE_CONCRETE = familyBuilder(Blocks.WHITE_CONCRETE)
            .slab(MtaBlocks.WHITE_CONCRETE_SLAB.get())
            .stairs(MtaBlocks.WHITE_CONCRETE_STAIRS.get())
            .wall(MtaBlocks.WHITE_CONCRETE_WALL.get())
            .recipeUnlockedBy("has_white_concrete")
            .getFamily();

    public static final BlockFamily LIGHT_GRAY_CONCRETE = familyBuilder(Blocks.LIGHT_GRAY_CONCRETE)
            .slab(MtaBlocks.LIGHT_GRAY_CONCRETE_SLAB.get())
            .stairs(MtaBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get())
            .wall(MtaBlocks.LIGHT_GRAY_CONCRETE_WALL.get())
            .recipeUnlockedBy("has_light_gray_concrete")
            .getFamily();

    public static final BlockFamily GRAY_CONCRETE = familyBuilder(Blocks.GRAY_CONCRETE)
            .slab(MtaBlocks.GRAY_CONCRETE_SLAB.get())
            .stairs(MtaBlocks.GRAY_CONCRETE_STAIRS.get())
            .wall(MtaBlocks.GRAY_CONCRETE_WALL.get())
            .recipeUnlockedBy("has_gray_concrete")
            .getFamily();

    public static final BlockFamily BLACK_CONCRETE = familyBuilder(Blocks.BLACK_CONCRETE)
            .slab(MtaBlocks.BLACK_CONCRETE_SLAB.get())
            .stairs(MtaBlocks.BLACK_CONCRETE_STAIRS.get())
            .wall(MtaBlocks.BLACK_CONCRETE_WALL.get())
            .recipeUnlockedBy("has_black_concrete")
            .getFamily();

    public static final BlockFamily BROWN_CONCRETE = familyBuilder(Blocks.BROWN_CONCRETE)
            .slab(MtaBlocks.BROWN_CONCRETE_SLAB.get())
            .stairs(MtaBlocks.BROWN_CONCRETE_STAIRS.get())
            .wall(MtaBlocks.BROWN_CONCRETE_WALL.get())
            .recipeUnlockedBy("has_brown_concrete")
            .getFamily();

    public static final BlockFamily RED_CONCRETE = familyBuilder(Blocks.RED_CONCRETE)
            .slab(MtaBlocks.RED_CONCRETE_SLAB.get())
            .stairs(MtaBlocks.RED_CONCRETE_STAIRS.get())
            .wall(MtaBlocks.RED_CONCRETE_WALL.get())
            .recipeUnlockedBy("has_red_concrete")
            .getFamily();

    public static final BlockFamily ORANGE_CONCRETE = familyBuilder(Blocks.ORANGE_CONCRETE)
            .slab(MtaBlocks.ORANGE_CONCRETE_SLAB.get())
            .stairs(MtaBlocks.ORANGE_CONCRETE_STAIRS.get())
            .wall(MtaBlocks.ORANGE_CONCRETE_WALL.get())
            .recipeUnlockedBy("has_orange_concrete")
            .getFamily();

    public static final BlockFamily YELLOW_CONCRETE = familyBuilder(Blocks.YELLOW_CONCRETE)
            .slab(MtaBlocks.YELLOW_CONCRETE_SLAB.get())
            .stairs(MtaBlocks.YELLOW_CONCRETE_STAIRS.get())
            .wall(MtaBlocks.YELLOW_CONCRETE_WALL.get())
            .recipeUnlockedBy("has_yellow_concrete")
            .getFamily();

    public static final BlockFamily LIME_CONCRETE = familyBuilder(Blocks.LIME_CONCRETE)
            .slab(MtaBlocks.LIME_CONCRETE_SLAB.get())
            .stairs(MtaBlocks.LIME_CONCRETE_STAIRS.get())
            .wall(MtaBlocks.LIME_CONCRETE_WALL.get())
            .recipeUnlockedBy("has_lime_concrete")
            .getFamily();

    public static final BlockFamily GREEN_CONCRETE = familyBuilder(Blocks.GREEN_CONCRETE)
            .slab(MtaBlocks.GREEN_CONCRETE_SLAB.get())
            .stairs(MtaBlocks.GREEN_CONCRETE_STAIRS.get())
            .wall(MtaBlocks.GREEN_CONCRETE_WALL.get())
            .recipeUnlockedBy("has_green_concrete")
            .getFamily();

    public static final BlockFamily CYAN_CONCRETE = familyBuilder(Blocks.CYAN_CONCRETE)
            .slab(MtaBlocks.CYAN_CONCRETE_SLAB.get())
            .stairs(MtaBlocks.CYAN_CONCRETE_STAIRS.get())
            .wall(MtaBlocks.CYAN_CONCRETE_WALL.get())
            .recipeUnlockedBy("has_cyan_concrete")
            .getFamily();

    public static final BlockFamily LIGHT_BLUE_CONCRETE = familyBuilder(Blocks.LIGHT_BLUE_CONCRETE)
            .slab(MtaBlocks.LIGHT_BLUE_CONCRETE_SLAB.get())
            .stairs(MtaBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get())
            .wall(MtaBlocks.LIGHT_BLUE_CONCRETE_WALL.get())
            .recipeUnlockedBy("has_light_blue_concrete")
            .getFamily();

    public static final BlockFamily BLUE_CONCRETE = familyBuilder(Blocks.BLUE_CONCRETE)
            .slab(MtaBlocks.BLUE_CONCRETE_SLAB.get())
            .stairs(MtaBlocks.BLUE_CONCRETE_STAIRS.get())
            .wall(MtaBlocks.BLUE_CONCRETE_WALL.get())
            .recipeUnlockedBy("has_blue_concrete")
            .getFamily();

    public static final BlockFamily PURPLE_CONCRETE = familyBuilder(Blocks.PURPLE_CONCRETE)
            .slab(MtaBlocks.PURPLE_CONCRETE_SLAB.get())
            .stairs(MtaBlocks.PURPLE_CONCRETE_STAIRS.get())
            .wall(MtaBlocks.PURPLE_CONCRETE_WALL.get())
            .recipeUnlockedBy("has_purple_concrete")
            .getFamily();

    public static final BlockFamily MAGENTA_CONCRETE = familyBuilder(Blocks.MAGENTA_CONCRETE)
            .slab(MtaBlocks.MAGENTA_CONCRETE_SLAB.get())
            .stairs(MtaBlocks.MAGENTA_CONCRETE_STAIRS.get())
            .wall(MtaBlocks.MAGENTA_CONCRETE_WALL.get())
            .recipeUnlockedBy("has_magenta_concrete")
            .getFamily();

    public static final BlockFamily PINK_CONCRETE = familyBuilder(Blocks.PINK_CONCRETE)
            .slab(MtaBlocks.PINK_CONCRETE_SLAB.get())
            .stairs(MtaBlocks.PINK_CONCRETE_STAIRS.get())
            .wall(MtaBlocks.PINK_CONCRETE_WALL.get())
            .recipeUnlockedBy("has_pink_concrete")
            .getFamily();




    private static BlockFamily.Builder familyBuilder(Block baseBlock) {
        BlockFamily.Builder blockfamily$builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockfamily = MAP.put(baseBlock, blockfamily$builder.getFamily());
        if (blockfamily != null) {
            throw new IllegalStateException("Duplicate family value for " + BuiltInRegistries.BLOCK.getKey(baseBlock));
        } else {
            return blockfamily$builder;
        }
    }

    public static Stream<BlockFamily> getAllFamilies() {
        return MAP.values().stream();
    }




}
