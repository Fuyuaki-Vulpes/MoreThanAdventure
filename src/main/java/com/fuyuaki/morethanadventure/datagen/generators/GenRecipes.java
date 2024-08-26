package com.fuyuaki.morethanadventure.datagen.generators;

import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.crafting.ingredient.ItemAbilityIngredient;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

import java.util.concurrent.CompletableFuture;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class GenRecipes  extends RecipeProvider implements IConditionBuilder {
    public GenRecipes(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {

        woodFromLogs(output,MtaBlocks.PALM_WOOD, MtaBlocks.PALM_LOG);
        planksFromLogs(output, MtaBlocks.PALM_PLANKS, MtaTags.Items.PALM_LOGS, 4);

        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, MtaBlocks.STONE_TILES, Blocks.STONE);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, MtaBlocks.STONE_TILES_SLAB, Blocks.STONE, 2);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, MtaBlocks.STONE_TILES_STAIRS, Blocks.STONE);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, MtaBlocks.STONE_TILES_WALL, Blocks.STONE);
        basicStoneSetRecipe(output, MtaBlocks.STONE_TILES.get(), MtaBlocks.STONE_TILES_SLAB.get(), MtaBlocks.STONE_TILES_STAIRS.get(), MtaBlocks.STONE_TILES_WALL.get(), "has_stone_tiles", "stone_tiles");
        cuttingStoneSetRecipe(output, MtaBlocks.STONE_TILES.get(), MtaBlocks.STONE_TILES_SLAB.get(), MtaBlocks.STONE_TILES_STAIRS.get(), MtaBlocks.STONE_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES.get(), MtaBlocks.STONE_TILES_SLAB.get(), MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_STAIRS.get(), MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_WALL.get(), "has_slightly_dirty_stone_tiles", "slightly_dirty_stone_tiles");
        cuttingStoneSetRecipe(output, MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES.get(), MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_SLAB.get(), MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_STAIRS.get(), MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.DIRTY_STONE_TILES.get(), MtaBlocks.DIRTY_STONE_TILES_SLAB.get(), MtaBlocks.DIRTY_STONE_TILES_STAIRS.get(), MtaBlocks.DIRTY_STONE_TILES_WALL.get(), "has_dirty_stone_tiles", "dirty_stone_tiles");
        cuttingStoneSetRecipe(output, MtaBlocks.DIRTY_STONE_TILES.get(), MtaBlocks.DIRTY_STONE_TILES_SLAB.get(), MtaBlocks.DIRTY_STONE_TILES_STAIRS.get(), MtaBlocks.DIRTY_STONE_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.VERY_DIRTY_STONE_TILES.get(), MtaBlocks.VERY_DIRTY_STONE_TILES_SLAB.get(), MtaBlocks.VERY_DIRTY_STONE_TILES_STAIRS.get(), MtaBlocks.VERY_DIRTY_STONE_TILES_WALL.get(), "has_very_dirty_stone_tiles", "very_dirty_stone_tiles");
        cuttingStoneSetRecipe(output, MtaBlocks.VERY_DIRTY_STONE_TILES.get(), MtaBlocks.VERY_DIRTY_STONE_TILES_SLAB.get(), MtaBlocks.VERY_DIRTY_STONE_TILES_STAIRS.get(), MtaBlocks.VERY_DIRTY_STONE_TILES_WALL.get());
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES,3)
                .requires(Blocks.DIRT)
                .requires(MtaBlocks.STONE_TILES,3)
                .unlockedBy("has_stone_tiles",has(MtaBlocks.STONE_TILES))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,MtaBlocks.DIRTY_STONE_TILES,3)
                .requires(Blocks.DIRT)
                .requires(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES,3)
                .unlockedBy("has_slight_dirty_stone_tiles",has(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS,MtaBlocks.VERY_DIRTY_STONE_TILES,3)
                .requires(Blocks.DIRT)
                .requires(MtaBlocks.DIRTY_STONE_TILES,3)
                .unlockedBy("has_dirty_stone_tiles",has(MtaBlocks.DIRTY_STONE_TILES))
                .save(output);

        basicStoneSetRecipe(output, Blocks.WHITE_TERRACOTTA, MtaBlocks.WHITE_TERRACOTTA_SLAB.get(), MtaBlocks.WHITE_TERRACOTTA_STAIRS.get(), MtaBlocks.WHITE_TERRACOTTA_WALL.get(), "has_white_terracotta", "white_terracotta");
        basicStoneSetRecipe(output, Blocks.LIGHT_GRAY_TERRACOTTA, MtaBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get(), MtaBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get(), MtaBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get(), "has_light_gray_terracotta", "light_gray_terracotta");
        basicStoneSetRecipe(output, Blocks.GRAY_TERRACOTTA, MtaBlocks.GRAY_TERRACOTTA_SLAB.get(), MtaBlocks.GRAY_TERRACOTTA_STAIRS.get(), MtaBlocks.GRAY_TERRACOTTA_WALL.get(), "has_gray_terracotta", "gray_terracotta");
        basicStoneSetRecipe(output, Blocks.BLACK_TERRACOTTA, MtaBlocks.BLACK_TERRACOTTA_SLAB.get(), MtaBlocks.BLACK_TERRACOTTA_STAIRS.get(), MtaBlocks.BLACK_TERRACOTTA_WALL.get(), "has_black_terracotta", "black_terracotta");
        basicStoneSetRecipe(output, Blocks.BROWN_TERRACOTTA, MtaBlocks.BROWN_TERRACOTTA_SLAB.get(), MtaBlocks.BROWN_TERRACOTTA_STAIRS.get(), MtaBlocks.BROWN_TERRACOTTA_WALL.get(), "has_brown_terracotta", "brown_terracotta");
        basicStoneSetRecipe(output, Blocks.RED_TERRACOTTA, MtaBlocks.RED_TERRACOTTA_SLAB.get(), MtaBlocks.RED_TERRACOTTA_STAIRS.get(), MtaBlocks.RED_TERRACOTTA_WALL.get(), "has_red_terracotta", "red_terracotta");
        basicStoneSetRecipe(output, Blocks.ORANGE_TERRACOTTA, MtaBlocks.ORANGE_TERRACOTTA_SLAB.get(), MtaBlocks.ORANGE_TERRACOTTA_STAIRS.get(), MtaBlocks.ORANGE_TERRACOTTA_WALL.get(), "has_orange_terracotta", "orange_terracotta");
        basicStoneSetRecipe(output, Blocks.YELLOW_TERRACOTTA, MtaBlocks.YELLOW_TERRACOTTA_SLAB.get(), MtaBlocks.YELLOW_TERRACOTTA_STAIRS.get(), MtaBlocks.YELLOW_TERRACOTTA_WALL.get(), "has_yellow_terracotta", "yellow_terracotta");
        basicStoneSetRecipe(output, Blocks.LIME_TERRACOTTA, MtaBlocks.LIME_TERRACOTTA_SLAB.get(), MtaBlocks.LIME_TERRACOTTA_STAIRS.get(), MtaBlocks.LIME_TERRACOTTA_WALL.get(), "has_lime_terracotta", "lime_terracotta");
        basicStoneSetRecipe(output, Blocks.GREEN_TERRACOTTA, MtaBlocks.GREEN_TERRACOTTA_SLAB.get(), MtaBlocks.GREEN_TERRACOTTA_STAIRS.get(), MtaBlocks.GREEN_TERRACOTTA_WALL.get(), "has_green_terracotta", "green_terracotta");
        basicStoneSetRecipe(output, Blocks.CYAN_TERRACOTTA, MtaBlocks.CYAN_TERRACOTTA_SLAB.get(), MtaBlocks.CYAN_TERRACOTTA_STAIRS.get(), MtaBlocks.CYAN_TERRACOTTA_WALL.get(), "has_cyan_terracotta", "cyan_terracotta");
        basicStoneSetRecipe(output, Blocks.LIGHT_BLUE_TERRACOTTA, MtaBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get(), MtaBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get(), MtaBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get(), "has_light_blue_terracotta", "light_blue_terracotta");
        basicStoneSetRecipe(output, Blocks.BLUE_TERRACOTTA, MtaBlocks.BLUE_TERRACOTTA_SLAB.get(), MtaBlocks.BLUE_TERRACOTTA_STAIRS.get(), MtaBlocks.BLUE_TERRACOTTA_WALL.get(), "has_blue_terracotta", "blue_terracotta");
        basicStoneSetRecipe(output, Blocks.PURPLE_TERRACOTTA, MtaBlocks.PURPLE_TERRACOTTA_SLAB.get(), MtaBlocks.PURPLE_TERRACOTTA_STAIRS.get(), MtaBlocks.PURPLE_TERRACOTTA_WALL.get(), "has_purple_terracotta", "purple_terracotta");
        basicStoneSetRecipe(output, Blocks.MAGENTA_TERRACOTTA, MtaBlocks.MAGENTA_TERRACOTTA_SLAB.get(), MtaBlocks.MAGENTA_TERRACOTTA_STAIRS.get(), MtaBlocks.MAGENTA_TERRACOTTA_WALL.get(), "has_magenta_terracotta", "magenta_terracotta");
        basicStoneSetRecipe(output, Blocks.PINK_TERRACOTTA, MtaBlocks.PINK_TERRACOTTA_SLAB.get(), MtaBlocks.PINK_TERRACOTTA_STAIRS.get(), MtaBlocks.PINK_TERRACOTTA_WALL.get(), "has_pink_terracotta", "pink_terracotta");

        basicStoneSetRecipe(output, MtaBlocks.TERRACOTTA_TILES.get(), MtaBlocks.TERRACOTTA_TILES_SLAB.get(), MtaBlocks.TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.TERRACOTTA_TILES_WALL.get(), "has_terracotta_tiles", "terracotta_tiles");
        cuttingTerracottaSetRecipe(output, Blocks.TERRACOTTA, MtaBlocks.TERRACOTTA_TILES.get(), MtaBlocks.TERRACOTTA_SLAB.get(), MtaBlocks.TERRACOTTA_TILES_SLAB.get(), MtaBlocks.TERRACOTTA_STAIRS.get(), MtaBlocks.TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.TERRACOTTA_WALL.get(), MtaBlocks.TERRACOTTA_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.WHITE_TERRACOTTA_TILES.get(), MtaBlocks.WHITE_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.WHITE_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.WHITE_TERRACOTTA_TILES_WALL.get(), "has_white_terracotta_tiles", "white_terracotta_tiles");
        cuttingTerracottaSetRecipe(output, Blocks.WHITE_TERRACOTTA, MtaBlocks.WHITE_TERRACOTTA_TILES.get(), MtaBlocks.WHITE_TERRACOTTA_SLAB.get(), MtaBlocks.WHITE_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.WHITE_TERRACOTTA_STAIRS.get(), MtaBlocks.WHITE_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.WHITE_TERRACOTTA_WALL.get(), MtaBlocks.WHITE_TERRACOTTA_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES.get(), MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_WALL.get(), "has_light_gray_terracotta_tiles", "light_gray_terracotta_tiles");
        cuttingTerracottaSetRecipe(output, Blocks.LIGHT_GRAY_TERRACOTTA, MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES.get(), MtaBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get(), MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get(), MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get(), MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.GRAY_TERRACOTTA_TILES.get(), MtaBlocks.GRAY_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.GRAY_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.GRAY_TERRACOTTA_TILES_WALL.get(), "has_gray_terracotta_tiles", "gray_terracotta_tiles");
        cuttingTerracottaSetRecipe(output, Blocks.GRAY_TERRACOTTA, MtaBlocks.GRAY_TERRACOTTA_TILES.get(), MtaBlocks.GRAY_TERRACOTTA_SLAB.get(), MtaBlocks.GRAY_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.GRAY_TERRACOTTA_STAIRS.get(), MtaBlocks.GRAY_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.GRAY_TERRACOTTA_WALL.get(), MtaBlocks.GRAY_TERRACOTTA_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.BLACK_TERRACOTTA_TILES.get(), MtaBlocks.BLACK_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.BLACK_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.BLACK_TERRACOTTA_TILES_WALL.get(), "has_black_terracotta_tiles", "black_terracotta_tiles");
        cuttingTerracottaSetRecipe(output, Blocks.BLACK_TERRACOTTA, MtaBlocks.BLACK_TERRACOTTA_TILES.get(), MtaBlocks.BLACK_TERRACOTTA_SLAB.get(), MtaBlocks.BLACK_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.BLACK_TERRACOTTA_STAIRS.get(), MtaBlocks.BLACK_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.BLACK_TERRACOTTA_WALL.get(), MtaBlocks.BLACK_TERRACOTTA_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.BROWN_TERRACOTTA_TILES.get(), MtaBlocks.BROWN_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.BROWN_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.BROWN_TERRACOTTA_TILES_WALL.get(), "has_brown_terracotta_tiles", "brown_terracotta_tiles");
        cuttingTerracottaSetRecipe(output, Blocks.BROWN_TERRACOTTA, MtaBlocks.BROWN_TERRACOTTA_TILES.get(), MtaBlocks.BROWN_TERRACOTTA_SLAB.get(), MtaBlocks.BROWN_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.BROWN_TERRACOTTA_STAIRS.get(), MtaBlocks.BROWN_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.BROWN_TERRACOTTA_WALL.get(), MtaBlocks.BROWN_TERRACOTTA_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.RED_TERRACOTTA_TILES.get(), MtaBlocks.RED_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.RED_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.RED_TERRACOTTA_TILES_WALL.get(), "has_red_terracotta_tiles", "red_terracotta_tiles");
        cuttingTerracottaSetRecipe(output, Blocks.RED_TERRACOTTA, MtaBlocks.RED_TERRACOTTA_TILES.get(), MtaBlocks.RED_TERRACOTTA_SLAB.get(), MtaBlocks.RED_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.RED_TERRACOTTA_STAIRS.get(), MtaBlocks.RED_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.RED_TERRACOTTA_WALL.get(), MtaBlocks.RED_TERRACOTTA_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.ORANGE_TERRACOTTA_TILES.get(), MtaBlocks.ORANGE_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.ORANGE_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.ORANGE_TERRACOTTA_TILES_WALL.get(), "has_orange_terracotta_tiles", "orange_terracotta_tiles");
        cuttingTerracottaSetRecipe(output, Blocks.ORANGE_TERRACOTTA, MtaBlocks.ORANGE_TERRACOTTA_TILES.get(), MtaBlocks.ORANGE_TERRACOTTA_SLAB.get(), MtaBlocks.ORANGE_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.ORANGE_TERRACOTTA_STAIRS.get(), MtaBlocks.ORANGE_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.ORANGE_TERRACOTTA_WALL.get(), MtaBlocks.ORANGE_TERRACOTTA_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.YELLOW_TERRACOTTA_TILES.get(), MtaBlocks.YELLOW_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.YELLOW_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.YELLOW_TERRACOTTA_TILES_WALL.get(), "has_yellow_terracotta_tiles", "yellow_terracotta_tiles");
        cuttingTerracottaSetRecipe(output, Blocks.YELLOW_TERRACOTTA, MtaBlocks.YELLOW_TERRACOTTA_TILES.get(), MtaBlocks.YELLOW_TERRACOTTA_SLAB.get(), MtaBlocks.YELLOW_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.YELLOW_TERRACOTTA_STAIRS.get(), MtaBlocks.YELLOW_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.YELLOW_TERRACOTTA_WALL.get(), MtaBlocks.YELLOW_TERRACOTTA_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.LIME_TERRACOTTA_TILES.get(), MtaBlocks.LIME_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.LIME_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.LIME_TERRACOTTA_TILES_WALL.get(), "has_lime_terracotta_tiles", "lime_terracotta_tiles");
        cuttingTerracottaSetRecipe(output, Blocks.LIME_TERRACOTTA, MtaBlocks.LIME_TERRACOTTA_TILES.get(), MtaBlocks.LIME_TERRACOTTA_SLAB.get(), MtaBlocks.LIME_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.LIME_TERRACOTTA_STAIRS.get(), MtaBlocks.LIME_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.LIME_TERRACOTTA_WALL.get(), MtaBlocks.LIME_TERRACOTTA_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.GREEN_TERRACOTTA_TILES.get(), MtaBlocks.GREEN_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.GREEN_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.GREEN_TERRACOTTA_TILES_WALL.get(), "has_green_terracotta_tiles", "green_terracotta_tiles");
        cuttingTerracottaSetRecipe(output, Blocks.GREEN_TERRACOTTA, MtaBlocks.GREEN_TERRACOTTA_TILES.get(), MtaBlocks.GREEN_TERRACOTTA_SLAB.get(), MtaBlocks.GREEN_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.GREEN_TERRACOTTA_STAIRS.get(), MtaBlocks.GREEN_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.GREEN_TERRACOTTA_WALL.get(), MtaBlocks.GREEN_TERRACOTTA_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.CYAN_TERRACOTTA_TILES.get(), MtaBlocks.CYAN_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.CYAN_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.CYAN_TERRACOTTA_TILES_WALL.get(), "has_cyan_terracotta_tiles", "cyan_terracotta_tiles");
        cuttingTerracottaSetRecipe(output, Blocks.CYAN_TERRACOTTA, MtaBlocks.CYAN_TERRACOTTA_TILES.get(), MtaBlocks.CYAN_TERRACOTTA_SLAB.get(), MtaBlocks.CYAN_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.CYAN_TERRACOTTA_STAIRS.get(), MtaBlocks.CYAN_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.CYAN_TERRACOTTA_WALL.get(), MtaBlocks.CYAN_TERRACOTTA_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES.get(), MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_WALL.get(), "has_light_blue_terracotta_tiles", "light_blue_terracotta_tiles");
        cuttingTerracottaSetRecipe(output, Blocks.LIGHT_BLUE_TERRACOTTA, MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES.get(), MtaBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get(), MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get(), MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get(), MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.BLUE_TERRACOTTA_TILES.get(), MtaBlocks.BLUE_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.BLUE_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.BLUE_TERRACOTTA_TILES_WALL.get(), "has_blue_terracotta_tiles", "blue_terracotta_tiles");
        cuttingTerracottaSetRecipe(output, Blocks.BLUE_TERRACOTTA, MtaBlocks.BLUE_TERRACOTTA_TILES.get(), MtaBlocks.BLUE_TERRACOTTA_SLAB.get(), MtaBlocks.BLUE_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.BLUE_TERRACOTTA_STAIRS.get(), MtaBlocks.BLUE_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.BLUE_TERRACOTTA_WALL.get(), MtaBlocks.BLUE_TERRACOTTA_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.PURPLE_TERRACOTTA_TILES.get(), MtaBlocks.PURPLE_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.PURPLE_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.PURPLE_TERRACOTTA_TILES_WALL.get(), "has_purple_terracotta_tiles", "purple_terracotta_tiles");
        cuttingTerracottaSetRecipe(output, Blocks.PURPLE_TERRACOTTA, MtaBlocks.PURPLE_TERRACOTTA_TILES.get(), MtaBlocks.PURPLE_TERRACOTTA_SLAB.get(), MtaBlocks.PURPLE_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.PURPLE_TERRACOTTA_STAIRS.get(), MtaBlocks.PURPLE_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.PURPLE_TERRACOTTA_WALL.get(), MtaBlocks.PURPLE_TERRACOTTA_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.MAGENTA_TERRACOTTA_TILES.get(), MtaBlocks.MAGENTA_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.MAGENTA_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.MAGENTA_TERRACOTTA_TILES_WALL.get(), "has_magenta_terracotta_tiles", "magenta_terracotta_tiles");
        cuttingTerracottaSetRecipe(output, Blocks.MAGENTA_TERRACOTTA, MtaBlocks.MAGENTA_TERRACOTTA_TILES.get(), MtaBlocks.MAGENTA_TERRACOTTA_SLAB.get(), MtaBlocks.MAGENTA_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.MAGENTA_TERRACOTTA_STAIRS.get(), MtaBlocks.MAGENTA_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.MAGENTA_TERRACOTTA_WALL.get(), MtaBlocks.MAGENTA_TERRACOTTA_TILES_WALL.get());
        basicStoneSetRecipe(output, MtaBlocks.PINK_TERRACOTTA_TILES.get(), MtaBlocks.PINK_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.PINK_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.PINK_TERRACOTTA_TILES_WALL.get(), "has_pink_terracotta_tiles", "pink_terracotta_tiles");
        cuttingTerracottaSetRecipe(output, Blocks.PINK_TERRACOTTA, MtaBlocks.PINK_TERRACOTTA_TILES.get(), MtaBlocks.PINK_TERRACOTTA_SLAB.get(), MtaBlocks.PINK_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.PINK_TERRACOTTA_STAIRS.get(), MtaBlocks.PINK_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.PINK_TERRACOTTA_WALL.get(), MtaBlocks.PINK_TERRACOTTA_TILES_WALL.get());

        basicStoneSetRecipe(output, Blocks.WHITE_CONCRETE, MtaBlocks.WHITE_CONCRETE_SLAB.get(), MtaBlocks.WHITE_CONCRETE_STAIRS.get(), MtaBlocks.WHITE_CONCRETE_WALL.get(), "has_white_concrete", "white_concrete");
        basicStoneSetRecipe(output, Blocks.LIGHT_GRAY_CONCRETE, MtaBlocks.LIGHT_GRAY_CONCRETE_SLAB.get(), MtaBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get(), MtaBlocks.LIGHT_GRAY_CONCRETE_WALL.get(), "has_light_gray_concrete", "light_gray_concrete");
        basicStoneSetRecipe(output, Blocks.GRAY_CONCRETE, MtaBlocks.GRAY_CONCRETE_SLAB.get(), MtaBlocks.GRAY_CONCRETE_STAIRS.get(), MtaBlocks.GRAY_CONCRETE_WALL.get(), "has_gray_concrete", "gray_concrete");
        basicStoneSetRecipe(output, Blocks.BLACK_CONCRETE, MtaBlocks.BLACK_CONCRETE_SLAB.get(), MtaBlocks.BLACK_CONCRETE_STAIRS.get(), MtaBlocks.BLACK_CONCRETE_WALL.get(), "has_black_concrete", "black_concrete");
        basicStoneSetRecipe(output, Blocks.BROWN_CONCRETE, MtaBlocks.BROWN_CONCRETE_SLAB.get(), MtaBlocks.BROWN_CONCRETE_STAIRS.get(), MtaBlocks.BROWN_CONCRETE_WALL.get(), "has_brown_concrete", "brown_concrete");
        basicStoneSetRecipe(output, Blocks.RED_CONCRETE, MtaBlocks.RED_CONCRETE_SLAB.get(), MtaBlocks.RED_CONCRETE_STAIRS.get(), MtaBlocks.RED_CONCRETE_WALL.get(), "has_red_concrete", "red_concrete");
        basicStoneSetRecipe(output, Blocks.ORANGE_CONCRETE, MtaBlocks.ORANGE_CONCRETE_SLAB.get(), MtaBlocks.ORANGE_CONCRETE_STAIRS.get(), MtaBlocks.ORANGE_CONCRETE_WALL.get(), "has_orange_concrete", "orange_concrete");
        basicStoneSetRecipe(output, Blocks.YELLOW_CONCRETE, MtaBlocks.YELLOW_CONCRETE_SLAB.get(), MtaBlocks.YELLOW_CONCRETE_STAIRS.get(), MtaBlocks.YELLOW_CONCRETE_WALL.get(), "has_yellow_concrete", "yellow_concrete");
        basicStoneSetRecipe(output, Blocks.LIME_CONCRETE, MtaBlocks.LIME_CONCRETE_SLAB.get(), MtaBlocks.LIME_CONCRETE_STAIRS.get(), MtaBlocks.LIME_CONCRETE_WALL.get(), "has_lime_concrete", "lime_concrete");
        basicStoneSetRecipe(output, Blocks.GREEN_CONCRETE, MtaBlocks.GREEN_CONCRETE_SLAB.get(), MtaBlocks.GREEN_CONCRETE_STAIRS.get(), MtaBlocks.GREEN_CONCRETE_WALL.get(), "has_green_concrete", "green_concrete");
        basicStoneSetRecipe(output, Blocks.CYAN_CONCRETE, MtaBlocks.CYAN_CONCRETE_SLAB.get(), MtaBlocks.CYAN_CONCRETE_STAIRS.get(), MtaBlocks.CYAN_CONCRETE_WALL.get(), "has_cyan_concrete", "cyan_concrete");
        basicStoneSetRecipe(output, Blocks.LIGHT_BLUE_CONCRETE, MtaBlocks.LIGHT_BLUE_CONCRETE_SLAB.get(), MtaBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get(), MtaBlocks.LIGHT_BLUE_CONCRETE_WALL.get(), "has_light_blue_concrete", "light_blue_concrete");
        basicStoneSetRecipe(output, Blocks.BLUE_CONCRETE, MtaBlocks.BLUE_CONCRETE_SLAB.get(), MtaBlocks.BLUE_CONCRETE_STAIRS.get(), MtaBlocks.BLUE_CONCRETE_WALL.get(), "has_blue_concrete", "blue_concrete");
        basicStoneSetRecipe(output, Blocks.PURPLE_CONCRETE, MtaBlocks.PURPLE_CONCRETE_SLAB.get(), MtaBlocks.PURPLE_CONCRETE_STAIRS.get(), MtaBlocks.PURPLE_CONCRETE_WALL.get(), "has_purple_concrete", "purple_concrete");
        basicStoneSetRecipe(output, Blocks.MAGENTA_CONCRETE, MtaBlocks.MAGENTA_CONCRETE_SLAB.get(), MtaBlocks.MAGENTA_CONCRETE_STAIRS.get(), MtaBlocks.MAGENTA_CONCRETE_WALL.get(), "has_magenta_concrete", "magenta_concrete");
        basicStoneSetRecipe(output, Blocks.PINK_CONCRETE, MtaBlocks.PINK_CONCRETE_SLAB.get(), MtaBlocks.PINK_CONCRETE_STAIRS.get(), MtaBlocks.PINK_CONCRETE_WALL.get(), "has_pink_concrete", "pink_concrete");

        cuttingStoneSetRecipe(output, Blocks.WHITE_CONCRETE, MtaBlocks.WHITE_CONCRETE_SLAB.get(), MtaBlocks.WHITE_CONCRETE_STAIRS.get(), MtaBlocks.WHITE_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(output, Blocks.LIGHT_GRAY_CONCRETE, MtaBlocks.LIGHT_GRAY_CONCRETE_SLAB.get(), MtaBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get(), MtaBlocks.LIGHT_GRAY_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(output, Blocks.GRAY_CONCRETE, MtaBlocks.GRAY_CONCRETE_SLAB.get(), MtaBlocks.GRAY_CONCRETE_STAIRS.get(), MtaBlocks.GRAY_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(output, Blocks.BLACK_CONCRETE, MtaBlocks.BLACK_CONCRETE_SLAB.get(), MtaBlocks.BLACK_CONCRETE_STAIRS.get(), MtaBlocks.BLACK_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(output, Blocks.BROWN_CONCRETE, MtaBlocks.BROWN_CONCRETE_SLAB.get(), MtaBlocks.BROWN_CONCRETE_STAIRS.get(), MtaBlocks.BROWN_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(output, Blocks.RED_CONCRETE, MtaBlocks.RED_CONCRETE_SLAB.get(), MtaBlocks.RED_CONCRETE_STAIRS.get(), MtaBlocks.RED_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(output, Blocks.ORANGE_CONCRETE, MtaBlocks.ORANGE_CONCRETE_SLAB.get(), MtaBlocks.ORANGE_CONCRETE_STAIRS.get(), MtaBlocks.ORANGE_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(output, Blocks.YELLOW_CONCRETE, MtaBlocks.YELLOW_CONCRETE_SLAB.get(), MtaBlocks.YELLOW_CONCRETE_STAIRS.get(), MtaBlocks.YELLOW_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(output, Blocks.LIME_CONCRETE, MtaBlocks.LIME_CONCRETE_SLAB.get(), MtaBlocks.LIME_CONCRETE_STAIRS.get(), MtaBlocks.LIME_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(output, Blocks.GREEN_CONCRETE, MtaBlocks.GREEN_CONCRETE_SLAB.get(), MtaBlocks.GREEN_CONCRETE_STAIRS.get(), MtaBlocks.GREEN_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(output, Blocks.CYAN_CONCRETE, MtaBlocks.CYAN_CONCRETE_SLAB.get(), MtaBlocks.CYAN_CONCRETE_STAIRS.get(), MtaBlocks.CYAN_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(output, Blocks.LIGHT_BLUE_CONCRETE, MtaBlocks.LIGHT_BLUE_CONCRETE_SLAB.get(), MtaBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get(), MtaBlocks.LIGHT_BLUE_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(output, Blocks.BLUE_CONCRETE, MtaBlocks.BLUE_CONCRETE_SLAB.get(), MtaBlocks.BLUE_CONCRETE_STAIRS.get(), MtaBlocks.BLUE_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(output, Blocks.PURPLE_CONCRETE, MtaBlocks.PURPLE_CONCRETE_SLAB.get(), MtaBlocks.PURPLE_CONCRETE_STAIRS.get(), MtaBlocks.PURPLE_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(output, Blocks.MAGENTA_CONCRETE, MtaBlocks.MAGENTA_CONCRETE_SLAB.get(), MtaBlocks.MAGENTA_CONCRETE_STAIRS.get(), MtaBlocks.MAGENTA_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(output, Blocks.PINK_CONCRETE, MtaBlocks.PINK_CONCRETE_SLAB.get(), MtaBlocks.PINK_CONCRETE_STAIRS.get(), MtaBlocks.PINK_CONCRETE_WALL.get());


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MtaItems.COPPER_AXE)
                .define('#', Items.STICK)
                .define('X', Tags.Items.INGOTS_COPPER)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MtaItems.COPPER_HOE)
                .define('#', Items.STICK)
                .define('X', Tags.Items.INGOTS_COPPER)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MtaItems.COPPER_PICKAXE)
                .define('#', Items.STICK)
                .define('X', Tags.Items.INGOTS_COPPER)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MtaItems.COPPER_SHOVEL)
                .define('#', Items.STICK)
                .define('X', Tags.Items.INGOTS_COPPER)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MtaItems.COPPER_SWORD)
                .define('#', Items.STICK)
                .define('X', Tags.Items.INGOTS_COPPER)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER))
                .save(output);



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,Items.NETHERITE_SCRAP)
                .define('#', MtaItems.NETHERITE_FRACTURE.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_scrap_facture", has(MtaItems.NETHERITE_FRACTURE.get()))
                .save(output, MODID);

        smeltingResultFromBase(output, Items.LEATHER,Items.ROTTEN_FLESH);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,MtaItems.BIG_BOWL)
                .requires(Items.BOWL, 2)
                .unlockedBy("has_bowl",has(Items.BOWL))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,Items.BLACK_DYE,2)
                .requires(Tags.Items.ORES_COAL)
                .unlockedBy("has_coal",has(Tags.Items.ORES_COAL))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MtaBlocks.MOSSY_ANDESITE.get(),2)
                .requires(Blocks.ANDESITE,2)
                .requires(Blocks.VINE,2)
                .unlockedBy("has_andesite",has(Blocks.ANDESITE))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MtaBlocks.MOSSY_ANDESITE.get(),4)
                .requires(Blocks.ANDESITE,2)
                .requires(Blocks.MOSS_BLOCK,2)
                .unlockedBy("has_andesite",has(Blocks.ANDESITE))
                .save(output,"mossy_andesite_from_moss");

        twoByTwoPacker(output, RecipeCategory.BUILDING_BLOCKS, Blocks.QUARTZ_BLOCK, MtaItems.CLEAR_QUARTZ);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.DIORITE, 2)
                .define('Q', MtaItems.CLEAR_QUARTZ)
                .define('C', Blocks.COBBLESTONE)
                .pattern("CQ")
                .pattern("QC")
                .unlockedBy("has_quartz", has(MtaItems.CLEAR_QUARTZ))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.GRANITE)
                .requires(Blocks.DIORITE)
                .requires(MtaItems.CLEAR_QUARTZ)
                .unlockedBy("has_quartz", has(MtaItems.CLEAR_QUARTZ))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, Blocks.COMPARATOR)
                .define('#', Blocks.REDSTONE_TORCH)
                .define('X', MtaItems.CLEAR_QUARTZ)
                .define('I', Blocks.STONE)
                .pattern(" # ")
                .pattern("#X#")
                .pattern("III")
                .unlockedBy("has_quartz", has(MtaItems.CLEAR_QUARTZ))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, Blocks.DAYLIGHT_DETECTOR)
                .define('Q', MtaItems.CLEAR_QUARTZ)
                .define('G', Blocks.GLASS)
                .define('W', Ingredient.of(ItemTags.WOODEN_SLABS))
                .pattern("GGG")
                .pattern("QQQ")
                .pattern("WWW")
                .unlockedBy("has_quartz", has(MtaItems.CLEAR_QUARTZ))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, Blocks.OBSERVER)
                .define('Q', MtaItems.CLEAR_QUARTZ)
                .define('R', Items.REDSTONE)
                .define('#', Blocks.COBBLESTONE)
                .pattern("###")
                .pattern("RRQ")
                .pattern("###")
                .unlockedBy("has_quartz", has(MtaItems.CLEAR_QUARTZ))
                .save(output);


        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, MtaBlocks.SPRINKLER.get())
                .define('C', Tags.Items.INGOTS_COPPER)
                .define('N', Tags.Items.NUGGETS_IRON)
                .define('#', ItemTags.PLANKS)
                .pattern(" N ")
                .pattern("NCN")
                .pattern("C#C")
                .unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, MtaBlocks.QUARTZ_LAMP.get(),2)
                .define('Q', MtaItems.CLEAR_QUARTZ)
                .define('#', Tags.Items.DUSTS_GLOWSTONE)
                .pattern("Q#")
                .pattern("#Q")
                .unlockedBy("has_quartz", has(MtaItems.CLEAR_QUARTZ))
                .save(output);

        upgradeTemplate(output, MtaItems.ARMAMENT_UPGRADE.get(), Blocks.RED_TERRACOTTA, "has_armament_upgrade");
        upgradeTemplate(output, MtaItems.ROYAL_UPGRADE.get(), Blocks.PINK_TERRACOTTA, "has_royal_upgrade");
        upgradeTemplate(output, MtaItems.AQUATIC_UPGRADE.get(), Blocks.CYAN_TERRACOTTA, "has_aquatic_upgrade");
        upgradeTemplate(output, MtaItems.ANGELIC_UPGRADE.get(), Blocks.WHITE_TERRACOTTA, "has_angelic_upgrade");
        upgradeTemplate(output, MtaItems.BERSERK_UPGRADE.get(), Blocks.ORANGE_TERRACOTTA, "has_berserk_upgrade");
        upgradeTemplate(output, MtaItems.FEATHERWEIGHT_UPGRADE.get(), Blocks.BLUE_TERRACOTTA, "has_featherweight_upgrade");

        agateSmithing(output, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MtaItems.GREAT_SENTINELS_HELMET.get());
        agateSmithing(output, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MtaItems.GREAT_SENTINELS_CHESTPLATE.get());
        agateSmithing(output, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MtaItems.GREAT_SENTINELS_LEGGINGS.get());
        agateSmithing(output, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MtaItems.GREAT_SENTINELS_BOOTS.get());
        agateSmithing(output, Items.MACE, RecipeCategory.COMBAT, MtaItems.GREAT_SENTINELS_WAR_HAMMER.get());
        agateSmithing(output, Items.NETHERITE_PICKAXE, RecipeCategory.COMBAT, MtaItems.ARMAMENT_PICKAXE.get());
        agateSmithing(output, Items.NETHERITE_AXE, RecipeCategory.COMBAT, MtaItems.ARMAMENT_AXE.get());
        agateSmithing(output, Items.NETHERITE_SHOVEL, RecipeCategory.COMBAT, MtaItems.ARMAMENT_SHOVEL.get());

        alexandriteSmithing(output, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MtaItems.HOLY_KNIGHTS_HELMET.get());
        alexandriteSmithing(output, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MtaItems.HOLY_KNIGHTS_CHESTPLATE.get());
        alexandriteSmithing(output, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MtaItems.HOLY_KNIGHTS_LEGGINGS.get());
        alexandriteSmithing(output, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MtaItems.HOLY_KNIGHTS_BOOTS.get());
        alexandriteSmithing(output, Items.NETHERITE_SWORD, RecipeCategory.COMBAT, MtaItems.HOLY_KNIGHTS_GREATSWORD.get());
        alexandriteSmithing(output, Items.NETHERITE_PICKAXE, RecipeCategory.COMBAT, MtaItems.ROYAL_PICKAXE.get());
        alexandriteSmithing(output, Items.NETHERITE_AXE, RecipeCategory.COMBAT, MtaItems.ROYAL_AXE.get());
        alexandriteSmithing(output, Items.NETHERITE_SHOVEL, RecipeCategory.COMBAT, MtaItems.ROYAL_SHOVEL.get());

        aquamarineSmithing(output, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MtaItems.MYSTIC_MERMAIDS_HELMET.get());
        aquamarineSmithing(output, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MtaItems.MYSTIC_MERMAIDS_CHESTPLATE.get());
        aquamarineSmithing(output, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MtaItems.MYSTIC_MERMAIDS_LEGGINGS.get());
        aquamarineSmithing(output, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MtaItems.MYSTIC_MERMAIDS_BOOTS.get());
        aquamarineSmithing(output, MtaItems.NETHERITE_TRIDENT.get(), RecipeCategory.COMBAT, MtaItems.MYSTIC_MERMAIDS_TRIDENT.get());
        aquamarineSmithing(output, Items.NETHERITE_PICKAXE, RecipeCategory.COMBAT, MtaItems.AQUATIC_PICKAXE.get());
        aquamarineSmithing(output, Items.NETHERITE_AXE, RecipeCategory.COMBAT, MtaItems.AQUATIC_AXE.get());
        aquamarineSmithing(output, Items.NETHERITE_SHOVEL, RecipeCategory.COMBAT, MtaItems.AQUATIC_SHOVEL.get());

        celestiteSmithing(output, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MtaItems.TEMPLE_ANGELS_HELMET.get());
        celestiteSmithing(output, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MtaItems.TEMPLE_ANGELS_CHESTPLATE.get());
        celestiteSmithing(output, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MtaItems.TEMPLE_ANGELS_LEGGINGS.get());
        celestiteSmithing(output, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MtaItems.TEMPLE_ANGELS_BOOTS.get());
        celestiteSmithing(output, MtaItems.NETHERITE_BOW.get(), RecipeCategory.COMBAT, MtaItems.TEMPLE_ANGELS_BOW.get());
        celestiteSmithing(output, Items.NETHERITE_PICKAXE, RecipeCategory.COMBAT, MtaItems.ANGELIC_PICKAXE.get());
        celestiteSmithing(output, Items.NETHERITE_AXE, RecipeCategory.COMBAT, MtaItems.ANGELIC_AXE.get());
        celestiteSmithing(output, Items.NETHERITE_SHOVEL, RecipeCategory.COMBAT, MtaItems.ANGELIC_SHOVEL.get());

        garnetSmithing(output, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MtaItems.WRATHFUL_BERSERKERS_HELMET.get());
        garnetSmithing(output, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MtaItems.WRATHFUL_BERSERKERS_CHESTPLATE.get());
        garnetSmithing(output, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MtaItems.WRATHFUL_BERSERKERS_LEGGINGS.get());
        garnetSmithing(output, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MtaItems.WRATHFUL_BERSERKERS_BOOTS.get());
        garnetSmithing(output, Items.NETHERITE_SWORD, RecipeCategory.COMBAT, MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE.get());
        garnetSmithing(output, Items.NETHERITE_PICKAXE, RecipeCategory.COMBAT, MtaItems.BERSERK_PICKAXE.get());
        garnetSmithing(output, Items.NETHERITE_AXE, RecipeCategory.COMBAT, MtaItems.BERSERK_AXE.get());
        garnetSmithing(output, Items.NETHERITE_SHOVEL, RecipeCategory.COMBAT, MtaItems.BERSERK_SHOVEL.get());

        moonstoneSmithing(output, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MtaItems.SHADOW_ROGUES_HELMET.get());
        moonstoneSmithing(output, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MtaItems.SHADOW_ROGUES_CHESTPLATE.get());
        moonstoneSmithing(output, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MtaItems.SHADOW_ROGUES_LEGGINGS.get());
        moonstoneSmithing(output, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MtaItems.SHADOW_ROGUES_BOOTS.get());
        moonstoneSmithing(output, Items.NETHERITE_SWORD, RecipeCategory.COMBAT, MtaItems.SHADOW_ROGUES_DAGGER.get());
        moonstoneSmithing(output, Items.NETHERITE_PICKAXE, RecipeCategory.COMBAT, MtaItems.FEATHERWEIGHT_PICKAXE.get());
        moonstoneSmithing(output, Items.NETHERITE_AXE, RecipeCategory.COMBAT, MtaItems.FEATHERWEIGHT_AXE.get());
        moonstoneSmithing(output, Items.NETHERITE_SHOVEL, RecipeCategory.COMBAT, MtaItems.FEATHERWEIGHT_SHOVEL.get());

        netheriteSmithing(output, Items.TRIDENT, RecipeCategory.COMBAT, MtaItems.NETHERITE_TRIDENT.get());
        netheriteSmithing(output, Items.BOW, RecipeCategory.COMBAT, MtaItems.NETHERITE_BOW.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,MtaItems.TOMATO_SEEDS)
                .requires(MtaItems.TOMATO)
                .unlockedBy("has_tomato",has(MtaItems.TOMATO))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,MtaItems.BELL_PEPPER_SEEDS)
                .requires(MtaItems.BELL_PEPPER)
                .unlockedBy("has_red_pepper",has(MtaItems.BELL_PEPPER))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,MtaItems.CHILI_PEPPER_SEEDS)
                .requires(MtaItems.CHILI_PEPPER)
                .unlockedBy("has_chili_pepper",has(MtaItems.CHILI_PEPPER))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,MtaItems.COCONUT_SLICE, 2)
                .requires(MtaItems.COCONUT)
                .unlockedBy("has_coconut",has(MtaItems.COCONUT))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,MtaItems.COCONUT_MILK)
                .requires(MtaItems.COCONUT)
                .requires(Tags.Items.COBBLESTONES)
                .unlockedBy("has_coconut",has(MtaItems.COCONUT))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,MtaItems.COCONUT_MILK)
                .requires(MtaItems.COCONUT)
                .requires(Tags.Items.STONES)
                .unlockedBy("has_coconut",has(MtaItems.COCONUT))
                .save(output, "_stones");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,MtaItems.SPICE_MIX)
                .requires(MtaItems.CHILI_PEPPER)
                .requires(MtaItems.BELL_PEPPER)
                .requires(CommonTags.FOODS_ONION)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_glass_bottle",has(Items.GLASS_BOTTLE))
                .save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD,MtaItems.ONIGIRI)
                .requires(MtaItems.RICE)
                .requires(Items.DRIED_KELP)
                .unlockedBy("has_rice",has(MtaItems.RICE))
                .save(output);
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MtaItems.SHRIMP), RecipeCategory.FOOD, MtaItems.COOKED_SHRIMP, 0.35F, 200)
                .unlockedBy("has_shrimp", has(MtaItems.SHRIMP))
                .save(output);

        //Farmer's Delight

        stripLogForBark(output, MtaBlocks.PALM_LOG, MtaBlocks.STRIPPED_PALM_LOG);
        stripLogForBark(output, MtaBlocks.PALM_WOOD, MtaBlocks.STRIPPED_PALM_WOOD);

        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MtaItems.COCONUT), Ingredient.of(CommonTags.TOOLS_KNIFE), MtaItems.COCONUT_SLICE, 3).build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.SWEET_BEEF_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(CommonTags.FOODS_TOMATO).addIngredient(Items.BEEF).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.SWEET_PORK_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(CommonTags.FOODS_TOMATO).addIngredient(Items.PORKCHOP).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.SWEET_CHICKEN_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(CommonTags.FOODS_TOMATO).addIngredient(Items.CHICKEN).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.SWEET_SHRIMP_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(CommonTags.FOODS_TOMATO).addIngredient(MtaItems.SHRIMP).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.MILD_BEEF_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(MtaItems.BELL_PEPPER).addIngredient(Items.BEEF).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.MILD_PORK_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(MtaItems.BELL_PEPPER).addIngredient(Items.PORKCHOP).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.MILD_CHICKEN_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(MtaItems.BELL_PEPPER).addIngredient(Items.CHICKEN).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.MILD_SHRIMP_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(MtaItems.BELL_PEPPER).addIngredient(MtaItems.SHRIMP).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.SPICY_BEEF_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(MtaItems.CHILI_PEPPER).addIngredient(Items.BEEF).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.SPICY_PORK_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(MtaItems.CHILI_PEPPER).addIngredient(Items.PORKCHOP).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.SPICY_CHICKEN_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(MtaItems.CHILI_PEPPER).addIngredient(Items.CHICKEN).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build(output);
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.SPICY_SHRIMP_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(MtaItems.CHILI_PEPPER).addIngredient(MtaItems.SHRIMP).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build(output);

    }



    protected static void agateSmithing(RecipeOutput pRecipeOutput, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(MtaItems.ARMAMENT_UPGRADE), Ingredient.of(pIngredientItem), Ingredient.of(MtaItems.AGATE), pCategory, pResultItem).unlocks("has_agate", has(MtaItems.AGATE)).save(pRecipeOutput, getItemName(pResultItem) + "_smithing");
    }

    protected static void alexandriteSmithing(RecipeOutput pRecipeOutput, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(MtaItems.ROYAL_UPGRADE), Ingredient.of(pIngredientItem), Ingredient.of(MtaItems.ALEXANDRITE), pCategory, pResultItem).unlocks("has_alexandrite", has(MtaItems.ALEXANDRITE)).save(pRecipeOutput, getItemName(pResultItem) + "_smithing");
    }

    protected static void aquamarineSmithing(RecipeOutput pRecipeOutput, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(MtaItems.AQUAMARINE), Ingredient.of(pIngredientItem), Ingredient.of(MtaItems.AQUAMARINE), pCategory, pResultItem).unlocks("has_aquamarine", has(MtaItems.AQUAMARINE)).save(pRecipeOutput, getItemName(pResultItem) + "_smithing");
    }

    protected static void celestiteSmithing(RecipeOutput pRecipeOutput, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(MtaItems.ANGELIC_UPGRADE), Ingredient.of(pIngredientItem), Ingredient.of(MtaItems.CELESTITE), pCategory, pResultItem).unlocks("has_celestite", has(MtaItems.CELESTITE)).save(pRecipeOutput, getItemName(pResultItem) + "_smithing");
    }

    protected static void garnetSmithing(RecipeOutput pRecipeOutput, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(MtaItems.BERSERK_UPGRADE), Ingredient.of(pIngredientItem), Ingredient.of(MtaItems.GARNET), pCategory, pResultItem).unlocks("has_garnet", has(MtaItems.GARNET)).save(pRecipeOutput, getItemName(pResultItem) + "_smithing");
    }

    protected static void moonstoneSmithing(RecipeOutput pRecipeOutput, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(MtaItems.FEATHERWEIGHT_UPGRADE), Ingredient.of(pIngredientItem), Ingredient.of(MtaItems.MOONSTONE), pCategory, pResultItem).unlocks("has_moonstone", has(MtaItems.MOONSTONE)).save(pRecipeOutput, getItemName(pResultItem) + "_smithing");
    }

    protected static void basicStoneSetRecipe(RecipeOutput output, Block ing, Block resultSlab, Block resultStair, Block resultWall, String unlock, String save) {
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultSlab, 6)
                .define('X', ing)
                .pattern("XXX")
                .unlockedBy(unlock, has(ing))
                .save(output, "shaped_" + save + "_slab");
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, resultStair, 4)
                .define('X', ing)
                .pattern("X  ")
                .pattern("XX ")
                .pattern("XXX")
                .unlockedBy(unlock, has(ing))
                .save(output, "shaped_" + save + "_stair");
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, resultWall, 6)
                .define('X', ing)
                .pattern("XXX")
                .pattern("XXX")
                .unlockedBy(unlock, has(ing))
                .save(output, "shaped_" + save + "_wall");
    }

    protected static void cuttingStoneSetRecipe(RecipeOutput output, Block ing, Block slab, Block stair, Block wall) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ing), RecipeCategory.BUILDING_BLOCKS, slab, 2)
                .unlockedBy(getHasName(ing), has(ing))
                .save(output, getConversionRecipeName(slab, ing) + "_base_stonecutting_slab");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ing), RecipeCategory.BUILDING_BLOCKS, stair)
                .unlockedBy(getHasName(ing), has(ing))
                .save(output, getConversionRecipeName(stair, ing) + "_base_stonecutting_stairs");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ing), RecipeCategory.BUILDING_BLOCKS, wall)
                .unlockedBy(getHasName(ing), has(ing))
                .save(output, getConversionRecipeName(wall, ing) + "_base_stonecutting_wall");
    }

    protected static void cuttingTerracottaSetRecipe(RecipeOutput output, Block ing, Block tiles, Block slab, Block tSlab , Block stair, Block tStair, Block wall, Block tWall){
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, tiles, ing);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, slab, ing, 2);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, tSlab, ing, 2);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, stair, ing);
        stonecutterResultFromBase(output, RecipeCategory.BUILDING_BLOCKS, tStair, ing);
        stonecutterResultFromBase(output, RecipeCategory.DECORATIONS, wall, ing);
        stonecutterResultFromBase(output, RecipeCategory.DECORATIONS, tWall, ing);
    }

    public static void upgradeTemplate(RecipeOutput output, Item template, Block frame, String unlock) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, template, 2)
                .define('X', template)
                .define('O', frame)
                .pattern("OOO")
                .pattern("OXO")
                .pattern("OOO")
                .unlockedBy(unlock, has(template))
                .save(output);
    }

    private static void stripLogForBark(RecipeOutput output, ItemLike log, ItemLike strippedLog) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(new ItemLike[]{log}), (new ItemAbilityIngredient(ItemAbilities.AXE_STRIP)).toVanilla(), strippedLog).addResult((ItemLike) ModItems.TREE_BARK.get()).addSound(SoundEvents.AXE_STRIP).build(output);
    }
}
