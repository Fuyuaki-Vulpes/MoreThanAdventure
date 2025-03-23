package com.fuyuaki.morethanadventure.core.datagen.other;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlocks;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import com.fuyuaki.morethanadventure.core.registry.MTAFamilies;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class GenRecipes  extends RecipeProvider {


    public GenRecipes(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {
        this.generateForEnabledBlockFamilies(FeatureFlagSet.of(FeatureFlags.VANILLA));

        woodFromLogs(MtaBlocks.ALPINE_WOOD, MtaBlocks.ALPINE_LOG);
        woodFromLogs(MtaBlocks.STRIPPED_ALPINE_WOOD, MtaBlocks.STRIPPED_ALPINE_LOG);
        planksFromLogs(MtaBlocks.ALPINE_PLANKS, MtaTags.Items.ALPINE_LOGS, 4);

        woodFromLogs(MtaBlocks.AVOCADO_WOOD, MtaBlocks.AVOCADO_LOG);
        woodFromLogs(MtaBlocks.STRIPPED_AVOCADO_WOOD, MtaBlocks.STRIPPED_AVOCADO_LOG);
        planksFromLogs(MtaBlocks.AVOCADO_PLANKS, MtaTags.Items.AVOCADO_LOGS, 4);

        woodFromLogs(MtaBlocks.BOGGED_OAK_WOOD, MtaBlocks.BOGGED_OAK_LOG);
        woodFromLogs(MtaBlocks.STRIPPED_BOGGED_OAK_WOOD, MtaBlocks.STRIPPED_BOGGED_OAK_LOG);
        planksFromLogs(MtaBlocks.BOGGED_OAK_PLANKS, MtaTags.Items.BOGGED_OAK_LOGS, 4);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MtaBlocks.BOGGED_OAK_LOG.get()), RecipeCategory.BUILDING_BLOCKS, MtaBlocks.STRIPPED_BOGGED_OAK_LOG);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MtaBlocks.BOGGED_OAK_WOOD.get()), RecipeCategory.BUILDING_BLOCKS, MtaBlocks.STRIPPED_BOGGED_OAK_WOOD);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MtaBlocks.BOGGED_OAK_PLANKS.get()), RecipeCategory.BUILDING_BLOCKS, MtaBlocks.BOGGED_OAK_STAIRS);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MtaBlocks.BOGGED_OAK_PLANKS.get()), RecipeCategory.BUILDING_BLOCKS, MtaBlocks.BOGGED_OAK_SLAB, 2);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MtaBlocks.BOGGED_OAK_PLANKS.get()), RecipeCategory.BUILDING_BLOCKS, MtaBlocks.BOGGED_OAK_BUTTON);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MtaBlocks.BOGGED_OAK_PLANKS.get()), RecipeCategory.BUILDING_BLOCKS, MtaBlocks.BOGGED_OAK_FENCE);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MtaBlocks.BOGGED_OAK_PLANKS.get()), RecipeCategory.BUILDING_BLOCKS, MtaBlocks.BOGGED_OAK_FENCE_GATE);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MtaBlocks.BOGGED_OAK_PLANKS.get()), RecipeCategory.BUILDING_BLOCKS, MtaBlocks.BOGGED_OAK_DOOR);
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(MtaBlocks.BOGGED_OAK_PLANKS.get()), RecipeCategory.BUILDING_BLOCKS, MtaBlocks.BOGGED_OAK_TRAPDOOR);

        woodFromLogs(MtaBlocks.MANGO_WOOD, MtaBlocks.MANGO_LOG);
        woodFromLogs(MtaBlocks.STRIPPED_MANGO_WOOD, MtaBlocks.STRIPPED_MANGO_LOG);
        planksFromLogs(MtaBlocks.MANGO_PLANKS, MtaTags.Items.MANGO_LOGS, 4);

        woodFromLogs(MtaBlocks.MAPLE_WOOD, MtaBlocks.MAPLE_LOG);
        woodFromLogs(MtaBlocks.STRIPPED_MAPLE_WOOD, MtaBlocks.STRIPPED_MAPLE_LOG);
        planksFromLogs(MtaBlocks.MAPLE_PLANKS, MtaTags.Items.MAPLE_LOGS, 4);

        woodFromLogs(MtaBlocks.PALM_WOOD, MtaBlocks.PALM_LOG);
        woodFromLogs(MtaBlocks.STRIPPED_PALM_WOOD, MtaBlocks.STRIPPED_PALM_LOG);
        planksFromLogs(MtaBlocks.PALM_PLANKS, MtaTags.Items.PALM_LOGS, 4);

        woodFromLogs(MtaBlocks.SEAWOOD, MtaBlocks.SEALOG);
        planksFromLogs(MtaBlocks.SEAWOOD_PLANKS, MtaTags.Items.SEAWOOD, 4);

        shapeless(RecipeCategory.BUILDING_BLOCKS, MtaBlocks.GRASSY_DIRT.get(), 4)
                .requires(Blocks.DIRT, 2)
                .requires(Blocks.GRASS_BLOCK, 2)
                .unlockedBy("has_dirt", has(Blocks.DIRT)).save(this.output);
        shapeless(RecipeCategory.BUILDING_BLOCKS, MtaBlocks.GRASSY_DIRT, 2)
                .requires(Blocks.DIRT, 2)
                .requires(Blocks.SHORT_GRASS, 2)
                .unlockedBy("has_dirt", has(Blocks.SHORT_GRASS)).save(this.output,getItemName(MtaBlocks.GRASSY_DIRT.get()) + "_from_short_grass");
        shapeless(RecipeCategory.BUILDING_BLOCKS, MtaBlocks.GRASSY_SAND.get(), 4)
                .requires(Blocks.SAND, 2)
                .requires(Blocks.GRASS_BLOCK, 2)
                .unlockedBy("has_sand", has(Blocks.SAND)).save(this.output);
        shapeless(RecipeCategory.BUILDING_BLOCKS, MtaBlocks.GRASSY_SAND, 2)
                .requires(Blocks.SAND, 2)
                .requires(Blocks.SHORT_GRASS, 2)
                .unlockedBy("has_sand", has(Blocks.SAND)).save(this.output,getItemName(MtaBlocks.GRASSY_SAND.get()) + "_from_short_grass");
        shapeless(RecipeCategory.BUILDING_BLOCKS, MtaBlocks.COBBLED_DIRT, 4)
                .requires(Blocks.DIRT, 2)
                .requires(Blocks.COBBLESTONE, 2)
                .unlockedBy("has_dirt", has(Blocks.DIRT)).save(this.output)
                ;

        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, MtaBlocks.STONE_TILES, Blocks.STONE);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, MtaBlocks.STONE_TILES_SLAB, Blocks.STONE, 2);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, MtaBlocks.STONE_TILES_STAIRS, Blocks.STONE);
        stonecutterResultFromBase( RecipeCategory.BUILDING_BLOCKS, MtaBlocks.STONE_TILES_WALL, Blocks.STONE);
        cuttingStoneSetRecipe(MtaBlocks.STONE_TILES.get(), MtaBlocks.STONE_TILES_SLAB.get(), MtaBlocks.STONE_TILES_STAIRS.get(), MtaBlocks.STONE_TILES_WALL.get());
        cuttingStoneSetRecipe(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES.get(), MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_SLAB.get(), MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_STAIRS.get(), MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_WALL.get());
        cuttingStoneSetRecipe(MtaBlocks.DIRTY_STONE_TILES.get(), MtaBlocks.DIRTY_STONE_TILES_SLAB.get(), MtaBlocks.DIRTY_STONE_TILES_STAIRS.get(), MtaBlocks.DIRTY_STONE_TILES_WALL.get());
        cuttingStoneSetRecipe(MtaBlocks.VERY_DIRTY_STONE_TILES.get(), MtaBlocks.VERY_DIRTY_STONE_TILES_SLAB.get(), MtaBlocks.VERY_DIRTY_STONE_TILES_STAIRS.get(), MtaBlocks.VERY_DIRTY_STONE_TILES_WALL.get());
        shapeless(RecipeCategory.BUILDING_BLOCKS, MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES, 3)
                .requires(Blocks.DIRT)
                .requires(MtaBlocks.STONE_TILES, 3)
                .unlockedBy("has_stone_tiles", has(MtaBlocks.STONE_TILES)).save(this.output)
                ;
        shapeless(RecipeCategory.BUILDING_BLOCKS, MtaBlocks.DIRTY_STONE_TILES, 3)
                .requires(Blocks.DIRT)
                .requires(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES, 3)
                .unlockedBy("has_slight_dirty_stone_tiles", has(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES)).save(this.output)
                ;
        shapeless(RecipeCategory.BUILDING_BLOCKS, MtaBlocks.VERY_DIRTY_STONE_TILES, 3)
                .requires(Blocks.DIRT)
                .requires(MtaBlocks.DIRTY_STONE_TILES, 3)
                .unlockedBy("has_dirty_stone_tiles", has(MtaBlocks.DIRTY_STONE_TILES)).save(this.output)
                ;


        cuttingTerracottaSetRecipe(Blocks.TERRACOTTA, MtaBlocks.TERRACOTTA_TILES.get(), MtaBlocks.TERRACOTTA_SLAB.get(), MtaBlocks.TERRACOTTA_TILES_SLAB.get(), MtaBlocks.TERRACOTTA_STAIRS.get(), MtaBlocks.TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.TERRACOTTA_WALL.get(), MtaBlocks.TERRACOTTA_TILES_WALL.get());
        cuttingTerracottaSetRecipe(Blocks.WHITE_TERRACOTTA, MtaBlocks.WHITE_TERRACOTTA_TILES.get(), MtaBlocks.WHITE_TERRACOTTA_SLAB.get(), MtaBlocks.WHITE_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.WHITE_TERRACOTTA_STAIRS.get(), MtaBlocks.WHITE_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.WHITE_TERRACOTTA_WALL.get(), MtaBlocks.WHITE_TERRACOTTA_TILES_WALL.get());
        cuttingTerracottaSetRecipe(Blocks.LIGHT_GRAY_TERRACOTTA, MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES.get(), MtaBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get(), MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get(), MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get(), MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_WALL.get());
        cuttingTerracottaSetRecipe(Blocks.GRAY_TERRACOTTA, MtaBlocks.GRAY_TERRACOTTA_TILES.get(), MtaBlocks.GRAY_TERRACOTTA_SLAB.get(), MtaBlocks.GRAY_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.GRAY_TERRACOTTA_STAIRS.get(), MtaBlocks.GRAY_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.GRAY_TERRACOTTA_WALL.get(), MtaBlocks.GRAY_TERRACOTTA_TILES_WALL.get());
        cuttingTerracottaSetRecipe(Blocks.BLACK_TERRACOTTA, MtaBlocks.BLACK_TERRACOTTA_TILES.get(), MtaBlocks.BLACK_TERRACOTTA_SLAB.get(), MtaBlocks.BLACK_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.BLACK_TERRACOTTA_STAIRS.get(), MtaBlocks.BLACK_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.BLACK_TERRACOTTA_WALL.get(), MtaBlocks.BLACK_TERRACOTTA_TILES_WALL.get());
        cuttingTerracottaSetRecipe(Blocks.BROWN_TERRACOTTA, MtaBlocks.BROWN_TERRACOTTA_TILES.get(), MtaBlocks.BROWN_TERRACOTTA_SLAB.get(), MtaBlocks.BROWN_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.BROWN_TERRACOTTA_STAIRS.get(), MtaBlocks.BROWN_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.BROWN_TERRACOTTA_WALL.get(), MtaBlocks.BROWN_TERRACOTTA_TILES_WALL.get());
        cuttingTerracottaSetRecipe(Blocks.RED_TERRACOTTA, MtaBlocks.RED_TERRACOTTA_TILES.get(), MtaBlocks.RED_TERRACOTTA_SLAB.get(), MtaBlocks.RED_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.RED_TERRACOTTA_STAIRS.get(), MtaBlocks.RED_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.RED_TERRACOTTA_WALL.get(), MtaBlocks.RED_TERRACOTTA_TILES_WALL.get());
        cuttingTerracottaSetRecipe(Blocks.ORANGE_TERRACOTTA, MtaBlocks.ORANGE_TERRACOTTA_TILES.get(), MtaBlocks.ORANGE_TERRACOTTA_SLAB.get(), MtaBlocks.ORANGE_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.ORANGE_TERRACOTTA_STAIRS.get(), MtaBlocks.ORANGE_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.ORANGE_TERRACOTTA_WALL.get(), MtaBlocks.ORANGE_TERRACOTTA_TILES_WALL.get());
        cuttingTerracottaSetRecipe(Blocks.YELLOW_TERRACOTTA, MtaBlocks.YELLOW_TERRACOTTA_TILES.get(), MtaBlocks.YELLOW_TERRACOTTA_SLAB.get(), MtaBlocks.YELLOW_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.YELLOW_TERRACOTTA_STAIRS.get(), MtaBlocks.YELLOW_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.YELLOW_TERRACOTTA_WALL.get(), MtaBlocks.YELLOW_TERRACOTTA_TILES_WALL.get());
        cuttingTerracottaSetRecipe(Blocks.LIME_TERRACOTTA, MtaBlocks.LIME_TERRACOTTA_TILES.get(), MtaBlocks.LIME_TERRACOTTA_SLAB.get(), MtaBlocks.LIME_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.LIME_TERRACOTTA_STAIRS.get(), MtaBlocks.LIME_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.LIME_TERRACOTTA_WALL.get(), MtaBlocks.LIME_TERRACOTTA_TILES_WALL.get());
        cuttingTerracottaSetRecipe(Blocks.GREEN_TERRACOTTA, MtaBlocks.GREEN_TERRACOTTA_TILES.get(), MtaBlocks.GREEN_TERRACOTTA_SLAB.get(), MtaBlocks.GREEN_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.GREEN_TERRACOTTA_STAIRS.get(), MtaBlocks.GREEN_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.GREEN_TERRACOTTA_WALL.get(), MtaBlocks.GREEN_TERRACOTTA_TILES_WALL.get());
        cuttingTerracottaSetRecipe(Blocks.CYAN_TERRACOTTA, MtaBlocks.CYAN_TERRACOTTA_TILES.get(), MtaBlocks.CYAN_TERRACOTTA_SLAB.get(), MtaBlocks.CYAN_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.CYAN_TERRACOTTA_STAIRS.get(), MtaBlocks.CYAN_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.CYAN_TERRACOTTA_WALL.get(), MtaBlocks.CYAN_TERRACOTTA_TILES_WALL.get());
        cuttingTerracottaSetRecipe(Blocks.LIGHT_BLUE_TERRACOTTA, MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES.get(), MtaBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get(), MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get(), MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get(), MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_WALL.get());
        cuttingTerracottaSetRecipe(Blocks.BLUE_TERRACOTTA, MtaBlocks.BLUE_TERRACOTTA_TILES.get(), MtaBlocks.BLUE_TERRACOTTA_SLAB.get(), MtaBlocks.BLUE_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.BLUE_TERRACOTTA_STAIRS.get(), MtaBlocks.BLUE_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.BLUE_TERRACOTTA_WALL.get(), MtaBlocks.BLUE_TERRACOTTA_TILES_WALL.get());
        cuttingTerracottaSetRecipe(Blocks.PURPLE_TERRACOTTA, MtaBlocks.PURPLE_TERRACOTTA_TILES.get(), MtaBlocks.PURPLE_TERRACOTTA_SLAB.get(), MtaBlocks.PURPLE_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.PURPLE_TERRACOTTA_STAIRS.get(), MtaBlocks.PURPLE_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.PURPLE_TERRACOTTA_WALL.get(), MtaBlocks.PURPLE_TERRACOTTA_TILES_WALL.get());
        cuttingTerracottaSetRecipe(Blocks.MAGENTA_TERRACOTTA, MtaBlocks.MAGENTA_TERRACOTTA_TILES.get(), MtaBlocks.MAGENTA_TERRACOTTA_SLAB.get(), MtaBlocks.MAGENTA_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.MAGENTA_TERRACOTTA_STAIRS.get(), MtaBlocks.MAGENTA_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.MAGENTA_TERRACOTTA_WALL.get(), MtaBlocks.MAGENTA_TERRACOTTA_TILES_WALL.get());
        cuttingTerracottaSetRecipe(Blocks.PINK_TERRACOTTA, MtaBlocks.PINK_TERRACOTTA_TILES.get(), MtaBlocks.PINK_TERRACOTTA_SLAB.get(), MtaBlocks.PINK_TERRACOTTA_TILES_SLAB.get(), MtaBlocks.PINK_TERRACOTTA_STAIRS.get(), MtaBlocks.PINK_TERRACOTTA_TILES_STAIRS.get(), MtaBlocks.PINK_TERRACOTTA_WALL.get(), MtaBlocks.PINK_TERRACOTTA_TILES_WALL.get());

        cuttingStoneSetRecipe(Blocks.WHITE_CONCRETE, MtaBlocks.WHITE_CONCRETE_SLAB.get(), MtaBlocks.WHITE_CONCRETE_STAIRS.get(), MtaBlocks.WHITE_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(Blocks.LIGHT_GRAY_CONCRETE, MtaBlocks.LIGHT_GRAY_CONCRETE_SLAB.get(), MtaBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get(), MtaBlocks.LIGHT_GRAY_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(Blocks.GRAY_CONCRETE, MtaBlocks.GRAY_CONCRETE_SLAB.get(), MtaBlocks.GRAY_CONCRETE_STAIRS.get(), MtaBlocks.GRAY_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(Blocks.BLACK_CONCRETE, MtaBlocks.BLACK_CONCRETE_SLAB.get(), MtaBlocks.BLACK_CONCRETE_STAIRS.get(), MtaBlocks.BLACK_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(Blocks.BROWN_CONCRETE, MtaBlocks.BROWN_CONCRETE_SLAB.get(), MtaBlocks.BROWN_CONCRETE_STAIRS.get(), MtaBlocks.BROWN_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(Blocks.RED_CONCRETE, MtaBlocks.RED_CONCRETE_SLAB.get(), MtaBlocks.RED_CONCRETE_STAIRS.get(), MtaBlocks.RED_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(Blocks.ORANGE_CONCRETE, MtaBlocks.ORANGE_CONCRETE_SLAB.get(), MtaBlocks.ORANGE_CONCRETE_STAIRS.get(), MtaBlocks.ORANGE_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(Blocks.YELLOW_CONCRETE, MtaBlocks.YELLOW_CONCRETE_SLAB.get(), MtaBlocks.YELLOW_CONCRETE_STAIRS.get(), MtaBlocks.YELLOW_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(Blocks.LIME_CONCRETE, MtaBlocks.LIME_CONCRETE_SLAB.get(), MtaBlocks.LIME_CONCRETE_STAIRS.get(), MtaBlocks.LIME_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(Blocks.GREEN_CONCRETE, MtaBlocks.GREEN_CONCRETE_SLAB.get(), MtaBlocks.GREEN_CONCRETE_STAIRS.get(), MtaBlocks.GREEN_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(Blocks.CYAN_CONCRETE, MtaBlocks.CYAN_CONCRETE_SLAB.get(), MtaBlocks.CYAN_CONCRETE_STAIRS.get(), MtaBlocks.CYAN_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(Blocks.LIGHT_BLUE_CONCRETE, MtaBlocks.LIGHT_BLUE_CONCRETE_SLAB.get(), MtaBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get(), MtaBlocks.LIGHT_BLUE_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(Blocks.BLUE_CONCRETE, MtaBlocks.BLUE_CONCRETE_SLAB.get(), MtaBlocks.BLUE_CONCRETE_STAIRS.get(), MtaBlocks.BLUE_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(Blocks.PURPLE_CONCRETE, MtaBlocks.PURPLE_CONCRETE_SLAB.get(), MtaBlocks.PURPLE_CONCRETE_STAIRS.get(), MtaBlocks.PURPLE_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(Blocks.MAGENTA_CONCRETE, MtaBlocks.MAGENTA_CONCRETE_SLAB.get(), MtaBlocks.MAGENTA_CONCRETE_STAIRS.get(), MtaBlocks.MAGENTA_CONCRETE_WALL.get());
        cuttingStoneSetRecipe(Blocks.PINK_CONCRETE, MtaBlocks.PINK_CONCRETE_SLAB.get(), MtaBlocks.PINK_CONCRETE_STAIRS.get(), MtaBlocks.PINK_CONCRETE_WALL.get());


        shaped(RecipeCategory.TOOLS, MtaItems.COPPER_AXE)
                .define('#', Items.STICK)
                .define('X', Tags.Items.INGOTS_COPPER)
                .pattern("XX")
                .pattern("X#")
                .pattern(" #")
                .unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER)).save(this.output)
                ;
        shaped(RecipeCategory.TOOLS, MtaItems.COPPER_HOE)
                .define('#', Items.STICK)
                .define('X', Tags.Items.INGOTS_COPPER)
                .pattern("XX")
                .pattern(" #")
                .pattern(" #")
                .unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER)).save(this.output)
                ;
        shaped(RecipeCategory.TOOLS, MtaItems.COPPER_PICKAXE)
                .define('#', Items.STICK)
                .define('X', Tags.Items.INGOTS_COPPER)
                .pattern("XXX")
                .pattern(" # ")
                .pattern(" # ")
                .unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER)).save(this.output)
                ;
        shaped(RecipeCategory.TOOLS, MtaItems.COPPER_SHOVEL)
                .define('#', Items.STICK)
                .define('X', Tags.Items.INGOTS_COPPER)
                .pattern("X")
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER)).save(this.output)
                ;
        shaped(RecipeCategory.COMBAT, MtaItems.COPPER_SWORD)
                .define('#', Items.STICK)
                .define('X', Tags.Items.INGOTS_COPPER)
                .pattern("X")
                .pattern("X")
                .pattern("#")
                .unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER)).save(this.output)
                ;


        shaped(RecipeCategory.MISC, Items.NETHERITE_SCRAP)
                .define('#', MtaItems.NETHERITE_FRACTURE.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_scrap_facture", has(MtaItems.NETHERITE_FRACTURE.get())).save(this.output);

        shaped(RecipeCategory.COMBAT, MtaItems.POLEARM)
                .define('s', Items.STICK)
                .pattern("  s")
                .pattern(" s ")
                .pattern("s  ")
                .unlockedBy("has_stick", has(Items.STICK)).save(this.output);

        newWeaponsTags(ItemTags.PLANKS, MtaItems.WOOD_ANCHOR.get(), MtaItems.WOOD_CLAW.get(), MtaItems.WOOD_CLAYMORE.get(),
                MtaItems.WOOD_CUTLASS.get(), MtaItems.WOOD_DAGGER.get(), MtaItems.WOOD_DOUBLE_AXE.get(), MtaItems.WOOD_FLAIL.get(),
                MtaItems.WOOD_GLAIVE.get(), MtaItems.WOOD_HALBERD.get(), MtaItems.WOOD_KATANA.get(), MtaItems.WOOD_RAPIER.get(),
                MtaItems.WOOD_SCYTHE.get(), MtaItems.WOOD_SICKLE.get(), MtaItems.WOOD_SPEAR.get(), MtaItems.WOOD_TWINBLADE.get(),
                //MtaItems.WOOD_WHIP_SWORD.get(),
                "planks");
        newWeaponsTags(ItemTags.STONE_TOOL_MATERIALS, MtaItems.STONE_ANCHOR.get(), MtaItems.STONE_CLAW.get(), MtaItems.STONE_CLAYMORE.get(),
                MtaItems.STONE_CUTLASS.get(), MtaItems.STONE_DAGGER.get(), MtaItems.STONE_DOUBLE_AXE.get(), MtaItems.STONE_FLAIL.get(),
                MtaItems.STONE_GLAIVE.get(), MtaItems.STONE_HALBERD.get(), MtaItems.STONE_KATANA.get(), MtaItems.STONE_RAPIER.get(),
                MtaItems.STONE_SCYTHE.get(), MtaItems.STONE_SICKLE.get(), MtaItems.STONE_SPEAR.get(), MtaItems.STONE_TWINBLADE.get(),
                //MtaItems.STONE_WHIP_SWORD.get(),
                "cobblestone");
        newWeapons(Items.COPPER_INGOT, MtaItems.COPPER_ANCHOR.get(), MtaItems.COPPER_CLAW.get(), MtaItems.COPPER_CLAYMORE.get(),
                MtaItems.COPPER_CUTLASS.get(), MtaItems.COPPER_DAGGER.get(), MtaItems.COPPER_DOUBLE_AXE.get(), MtaItems.COPPER_FLAIL.get(),
                MtaItems.COPPER_GLAIVE.get(), MtaItems.COPPER_HALBERD.get(), MtaItems.COPPER_KATANA.get(), MtaItems.COPPER_RAPIER.get(),
                MtaItems.COPPER_SCYTHE.get(), MtaItems.COPPER_SICKLE.get(), MtaItems.COPPER_SPEAR.get(), MtaItems.COPPER_TWINBLADE.get(),
                //MtaItems.COPPER_WHIP_SWORD.get(),
                "copper_ingot");
        newWeapons(Items.IRON_INGOT, MtaItems.IRON_ANCHOR.get(), MtaItems.IRON_CLAW.get(), MtaItems.IRON_CLAYMORE.get(),
                MtaItems.IRON_CUTLASS.get(), MtaItems.IRON_DAGGER.get(), MtaItems.IRON_DOUBLE_AXE.get(), MtaItems.IRON_FLAIL.get(),
                MtaItems.IRON_GLAIVE.get(), MtaItems.IRON_HALBERD.get(), MtaItems.IRON_KATANA.get(), MtaItems.IRON_RAPIER.get(),
                MtaItems.IRON_SCYTHE.get(), MtaItems.IRON_SICKLE.get(), MtaItems.IRON_SPEAR.get(), MtaItems.IRON_TWINBLADE.get(),
               // MtaItems.IRON_WHIP_SWORD.get(),
                "iron_ingot");
        newWeapons(Items.GOLD_INGOT, MtaItems.GOLD_ANCHOR.get(), MtaItems.GOLD_CLAW.get(), MtaItems.GOLD_CLAYMORE.get(),
                MtaItems.GOLD_CUTLASS.get(), MtaItems.GOLD_DAGGER.get(), MtaItems.GOLD_DOUBLE_AXE.get(), MtaItems.GOLD_FLAIL.get(),
                MtaItems.GOLD_GLAIVE.get(), MtaItems.GOLD_HALBERD.get(), MtaItems.GOLD_KATANA.get(), MtaItems.GOLD_RAPIER.get(),
                MtaItems.GOLD_SCYTHE.get(), MtaItems.GOLD_SICKLE.get(), MtaItems.GOLD_SPEAR.get(), MtaItems.GOLD_TWINBLADE.get(),
                //MtaItems.GOLD_WHIP_SWORD.get(),
                "gold_ingot");
        newWeapons(MtaItems.NETHERSTEEL_INGOT.get(), MtaItems.NETHERSTEEL_ANCHOR.get(), MtaItems.NETHERSTEEL_CLAW.get(), MtaItems.NETHERSTEEL_CLAYMORE.get(),
                MtaItems.NETHERSTEEL_CUTLASS.get(), MtaItems.NETHERSTEEL_DAGGER.get(), MtaItems.NETHERSTEEL_DOUBLE_AXE.get(), MtaItems.NETHERSTEEL_FLAIL.get(),
                MtaItems.NETHERSTEEL_GLAIVE.get(), MtaItems.NETHERSTEEL_HALBERD.get(),MtaItems.NETHERSTEEL_KATANA.get(), MtaItems.NETHERSTEEL_RAPIER.get(),
                MtaItems.NETHERSTEEL_SCYTHE.get(), MtaItems.NETHERSTEEL_SICKLE.get(), MtaItems.NETHERSTEEL_SPEAR.get(), MtaItems.NETHERSTEEL_TWINBLADE.get(),
                //MtaItems.NETHERSTEEL_WHIP_SWORD.get(),
                "nethersteel_ingot");
        newWeapons(Items.DIAMOND, MtaItems.DIAMOND_ANCHOR.get(), MtaItems.DIAMOND_CLAW.get(), MtaItems.DIAMOND_CLAYMORE.get(),
                MtaItems.DIAMOND_CUTLASS.get(), MtaItems.DIAMOND_DAGGER.get(), MtaItems.DIAMOND_DOUBLE_AXE.get(), MtaItems.DIAMOND_FLAIL.get(),
                MtaItems.DIAMOND_GLAIVE.get(), MtaItems.DIAMOND_HALBERD.get(), MtaItems.DIAMOND_KATANA.get(), MtaItems.DIAMOND_RAPIER.get(),
                MtaItems.DIAMOND_SCYTHE.get(), MtaItems.DIAMOND_SICKLE.get(), MtaItems.DIAMOND_SPEAR.get(), MtaItems.DIAMOND_TWINBLADE.get(),
                //MtaItems.DIAMOND_WHIP_SWORD.get(),
                "diamond");

        shaped(RecipeCategory.COMBAT, MtaItems.LONG_BOW)
                .define('w', Items.STICK)
                .define('s', Items.STRING)
                .pattern("wws")
                .pattern("w s")
                .pattern("wws")
                .unlockedBy("has_string", has(Items.STRING)).save(this.output);
        shaped(RecipeCategory.COMBAT, MtaItems.SHORT_BOW)
                .define('w', Items.STICK)
                .define('s', Items.STRING)
                .pattern(" w")
                .pattern("ws")
                .pattern(" w")
                .unlockedBy("has_string", has(Items.STRING)).save(this.output);
        shaped(RecipeCategory.COMBAT, MtaItems.TWIN_BOW)
                .define('w', Items.STICK)
                .define('s', Items.STRING)
                .pattern(" ws")
                .pattern("wss")
                .pattern(" ws")
                .unlockedBy("has_string", has(Items.STRING)).save(this.output);

        whipRecipe(Items.LEATHER, MtaItems.LEATHER_WHIP.get(), "has_leather");
        whipRecipe(Items.CHAIN, MtaItems.CHAIN_WHIP.get(), "has_chain");
        netheriteSmithing(MtaItems.CHAIN_WHIP.get(), RecipeCategory.COMBAT, MtaItems.NETHERITE_WHIP.get());

        smeltingResultFromBase(Items.LEATHER, Items.ROTTEN_FLESH);

        shapeless(RecipeCategory.MISC, MtaItems.BIG_BOWL)
                .requires(Items.BOWL, 2)
                .unlockedBy("has_bowl", has(Items.BOWL));

        shapeless(RecipeCategory.MISC, Items.BLACK_DYE, 2)
                .requires(Tags.Items.ORES_COAL)
                .unlockedBy("has_coal", has(Tags.Items.ORES_COAL)).save(this.output,"black_dye_from_coal");

        shapeless(RecipeCategory.MISC, MtaBlocks.MOSSY_ANDESITE.get(), 2)
                .requires(Blocks.ANDESITE, 2)
                .requires(Blocks.VINE, 2)
                .unlockedBy("has_andesite", has(Blocks.ANDESITE)).save(this.output,getItemName(MtaBlocks.MOSSY_ANDESITE.get()) + "_vines");

        shapeless(RecipeCategory.MISC, MtaBlocks.MOSSY_ANDESITE.get(), 4)
                .requires(Blocks.ANDESITE, 2)
                .requires(Blocks.MOSS_BLOCK, 2)
                .unlockedBy("has_andesite", has(Blocks.ANDESITE)).save(this.output,getItemName(MtaBlocks.MOSSY_ANDESITE.get()) + "_moss");

        twoByTwoPacker(RecipeCategory.BUILDING_BLOCKS, Blocks.QUARTZ_BLOCK, MtaItems.CLEAR_QUARTZ);
        shaped(RecipeCategory.BUILDING_BLOCKS, Blocks.DIORITE, 2)
                .define('Q', MtaItems.CLEAR_QUARTZ)
                .define('C', Blocks.COBBLESTONE)
                .pattern("CQ")
                .pattern("QC")
                .unlockedBy("has_quartz", has(MtaItems.CLEAR_QUARTZ)).save(this.output, getItemName(Blocks.DIORITE) + "_clear_quartz")
                ;
        shapeless(RecipeCategory.BUILDING_BLOCKS, Blocks.GRANITE)
                .requires(Blocks.DIORITE)
                .requires(MtaItems.CLEAR_QUARTZ)
                .unlockedBy("has_quartz", has(MtaItems.CLEAR_QUARTZ)).save(this.output, getItemName(Blocks.GRANITE) + "_clear_quartz")
                ;
        shaped(RecipeCategory.REDSTONE, Blocks.COMPARATOR)
                .define('#', Blocks.REDSTONE_TORCH)
                .define('X', MtaItems.CLEAR_QUARTZ)
                .define('I', Blocks.STONE)
                .pattern(" # ")
                .pattern("#X#")
                .pattern("III")
                .unlockedBy("has_quartz", has(MtaItems.CLEAR_QUARTZ)).save(this.output, getItemName(Blocks.COMPARATOR) + "_clear_quartz")
                ;
        shaped(RecipeCategory.REDSTONE, Blocks.DAYLIGHT_DETECTOR)
                .define('Q', MtaItems.CLEAR_QUARTZ)
                .define('G', Blocks.GLASS)
                .define('W', ItemTags.WOODEN_SLABS)
                .pattern("GGG")
                .pattern("QQQ")
                .pattern("WWW")
                .unlockedBy("has_quartz", has(MtaItems.CLEAR_QUARTZ)).save(this.output, getItemName(Blocks.DAYLIGHT_DETECTOR) + "_clear_quartz")
                ;
        shaped(RecipeCategory.REDSTONE, Blocks.OBSERVER)
                .define('Q', MtaItems.CLEAR_QUARTZ)
                .define('R', Items.REDSTONE)
                .define('#', Blocks.COBBLESTONE)
                .pattern("###")
                .pattern("RRQ")
                .pattern("###")
                .unlockedBy("has_quartz", has(MtaItems.CLEAR_QUARTZ)).save(this.output, getItemName(Blocks.OBSERVER) + "_clear_quartz")
                ;


        shaped(RecipeCategory.REDSTONE, MtaBlocks.SPRINKLER.get())
                .define('C', Tags.Items.INGOTS_COPPER)
                .define('N', Tags.Items.NUGGETS_IRON)
                .define('#', ItemTags.PLANKS)
                .pattern(" N ")
                .pattern("NCN")
                .pattern("C#C")
                .unlockedBy("has_copper", has(Tags.Items.INGOTS_COPPER)).save(this.output)
                ;
        shaped(RecipeCategory.DECORATIONS, MtaBlocks.QUARTZ_LAMP.get(), 2)
                .define('Q', MtaItems.CLEAR_QUARTZ)
                .define('#', Tags.Items.DUSTS_GLOWSTONE)
                .pattern("Q#")
                .pattern("#Q")
                .unlockedBy("has_quartz", has(MtaItems.CLEAR_QUARTZ)).save(this.output)
                ;

        upgradeTemplate(MtaItems.ARMAMENT_UPGRADE.get(), Blocks.RED_TERRACOTTA, "has_armament_upgrade");
        upgradeTemplate(MtaItems.ROYAL_UPGRADE.get(), Blocks.PINK_TERRACOTTA, "has_royal_upgrade");
        upgradeTemplate(MtaItems.AQUATIC_UPGRADE.get(), Blocks.CYAN_TERRACOTTA, "has_aquatic_upgrade");
        upgradeTemplate(MtaItems.DEATHLY_UPGRADE.get(), Blocks.BROWN_TERRACOTTA, "has_deathly_upgrade");
        upgradeTemplate(MtaItems.ANGELIC_UPGRADE.get(), Blocks.LIGHT_GRAY_TERRACOTTA, "has_angelic_upgrade");
        upgradeTemplate(MtaItems.FREEZING_UPGRADE.get(), Blocks.WHITE_TERRACOTTA, "has_freezing_upgrade");
        upgradeTemplate(MtaItems.BERSERK_UPGRADE.get(), Blocks.ORANGE_TERRACOTTA, "has_berserk_upgrade");
        upgradeTemplate(MtaItems.FEATHERWEIGHT_UPGRADE.get(), Blocks.BLUE_TERRACOTTA, "has_featherweight_upgrade");

        gemAwakening(MtaItems.AGATE.get(), MtaItems.HOST_HUSK.get(), MtaItems.AWAKENED_AGATE.get(), "has_agate");
        gemAwakening(MtaItems.ALEXANDRITE.get(), MtaItems.SAMURAI_CLOTH.get(), MtaItems.AWAKENED_ALEXANDRITE.get(), "has_alexandrite");
        gemAwakening(MtaItems.AQUAMARINE.get(), Items.PRISMARINE, MtaItems.AWAKENED_AQUAMARINE.get(), "has_aquamarine");
        gemAwakening(MtaItems.BLOODSTONE.get(), MtaItems.BLACK_WIDOW_VENOM.get(), MtaItems.AWAKENED_BLOODSTONE.get(), "has_bloodstone");
        gemAwakening(MtaItems.CELESTITE.get(), Items.PHANTOM_MEMBRANE, MtaItems.AWAKENED_CELESTITE.get(), "has_celestite");
        gemAwakening(MtaItems.CRYOLITE.get(), MtaItems.SPIRIT_DUST.get(), MtaItems.AWAKENED_CRYOLITE.get(), "has_cryolite");
        gemAwakening(MtaItems.GARNET.get(), MtaItems.CHARRED_BONE.get(), MtaItems.AWAKENED_GARNET.get(), "has_garnet");
        gemAwakening(MtaItems.MOONSTONE.get(), Items.GHAST_TEAR, MtaItems.AWAKENED_MOONSTONE.get(), "has_moonstone");

        agateSmithing(Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MtaItems.GREAT_SENTINELS_HELMET.get());
        agateSmithing(Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MtaItems.GREAT_SENTINELS_CHESTPLATE.get());
        agateSmithing(Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MtaItems.GREAT_SENTINELS_LEGGINGS.get());
        agateSmithing(Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MtaItems.GREAT_SENTINELS_BOOTS.get());
        agateSmithing(MtaItems.NETHERITE_MACE.get(), RecipeCategory.COMBAT, MtaItems.GREAT_SENTINELS_WAR_HAMMER.get());

        alexandriteSmithing(Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MtaItems.HOLY_KNIGHTS_HELMET.get());
        alexandriteSmithing(Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MtaItems.HOLY_KNIGHTS_CHESTPLATE.get());
        alexandriteSmithing(Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MtaItems.HOLY_KNIGHTS_LEGGINGS.get());
        alexandriteSmithing(Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MtaItems.HOLY_KNIGHTS_BOOTS.get());
        alexandriteSmithing(MtaItems.NETHERITE_CLAYMORE.get(), RecipeCategory.COMBAT, MtaItems.HOLY_KNIGHTS_GREATSWORD.get());

        aquamarineSmithing(Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MtaItems.MYSTIC_MERMAIDS_HELMET.get());
        aquamarineSmithing(Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MtaItems.MYSTIC_MERMAIDS_CHESTPLATE.get());
        aquamarineSmithing(Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MtaItems.MYSTIC_MERMAIDS_LEGGINGS.get());
        aquamarineSmithing(Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MtaItems.MYSTIC_MERMAIDS_BOOTS.get());
        aquamarineSmithing(MtaItems.NETHERITE_TRIDENT.get(), RecipeCategory.COMBAT, MtaItems.MYSTIC_MERMAIDS_TRIDENT.get());

        bloodstoneSmithing(Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MtaItems.SILENT_REAPERS_HELMET.get());
        bloodstoneSmithing(Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MtaItems.SILENT_REAPERS_CHESTPLATE.get());
        bloodstoneSmithing(Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MtaItems.SILENT_REAPERS_LEGGINGS.get());
        bloodstoneSmithing(Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MtaItems.SILENT_REAPERS_BOOTS.get());
        bloodstoneSmithing(MtaItems.NETHERITE_SCYTHE.get(), RecipeCategory.COMBAT, MtaItems.SILENT_REAPERS_SCYTHE.get());

        celestiteSmithing(Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MtaItems.TEMPLE_ANGELS_HELMET.get());
        celestiteSmithing(Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MtaItems.TEMPLE_ANGELS_CHESTPLATE.get());
        celestiteSmithing(Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MtaItems.TEMPLE_ANGELS_LEGGINGS.get());
        celestiteSmithing(Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MtaItems.TEMPLE_ANGELS_BOOTS.get());
        celestiteSmithing(MtaItems.NETHERITE_BOW.get(), RecipeCategory.COMBAT, MtaItems.TEMPLE_ANGELS_BOW.get());

        cryoliteSmithing(Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MtaItems.FREEZING_ICICLE_HELMET.get());
        cryoliteSmithing(Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MtaItems.FREEZING_ICICLE_CHESTPLATE.get());
        cryoliteSmithing(Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MtaItems.FREEZING_ICICLE_LEGGINGS.get());
        cryoliteSmithing(Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MtaItems.FREEZING_ICICLE_BOOTS.get());
        cryoliteSmithing(MtaItems.NETHERITE_SPEAR.get(), RecipeCategory.COMBAT, MtaItems.FREEZING_ICICLE_SPEAR.get());

        garnetSmithing(Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MtaItems.WRATHFUL_BERSERKERS_HELMET.get());
        garnetSmithing(Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MtaItems.WRATHFUL_BERSERKERS_CHESTPLATE.get());
        garnetSmithing(Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MtaItems.WRATHFUL_BERSERKERS_LEGGINGS.get());
        garnetSmithing(Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MtaItems.WRATHFUL_BERSERKERS_BOOTS.get());
        garnetSmithing(MtaItems.NETHERITE_DOUBLE_AXE.get(), RecipeCategory.COMBAT, MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE.get());

        moonstoneSmithing(Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MtaItems.SHADOW_ROGUES_HELMET.get());
        moonstoneSmithing(Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MtaItems.SHADOW_ROGUES_CHESTPLATE.get());
        moonstoneSmithing(Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MtaItems.SHADOW_ROGUES_LEGGINGS.get());
        moonstoneSmithing(Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MtaItems.SHADOW_ROGUES_BOOTS.get());
        moonstoneSmithing(MtaItems.NETHERITE_DAGGER.get(), RecipeCategory.COMBAT, MtaItems.SHADOW_ROGUES_DAGGER.get());

        netheriteSmithing(Items.TRIDENT, RecipeCategory.COMBAT, MtaItems.NETHERITE_TRIDENT.get());
        netheriteSmithing(Items.BOW, RecipeCategory.COMBAT, MtaItems.NETHERITE_BOW.get());
        netheriteSmithing(MtaItems.DIAMOND_ANCHOR.get(), RecipeCategory.COMBAT, MtaItems.NETHERITE_ANCHOR.get());
        netheriteSmithing(MtaItems.DIAMOND_CLAW.get(), RecipeCategory.COMBAT, MtaItems.NETHERITE_CLAW.get());
        netheriteSmithing(MtaItems.DIAMOND_CLAYMORE.get(), RecipeCategory.COMBAT, MtaItems.NETHERITE_CLAYMORE.get());
        netheriteSmithing(MtaItems.DIAMOND_CUTLASS.get(), RecipeCategory.COMBAT, MtaItems.NETHERITE_CUTLASS.get());
        netheriteSmithing(MtaItems.DIAMOND_DAGGER.get(), RecipeCategory.COMBAT, MtaItems.NETHERITE_DAGGER.get());
        netheriteSmithing(MtaItems.DIAMOND_DOUBLE_AXE.get(), RecipeCategory.COMBAT, MtaItems.NETHERITE_DOUBLE_AXE.get());
        netheriteSmithing(MtaItems.DIAMOND_FLAIL.get(), RecipeCategory.COMBAT, MtaItems.NETHERITE_FLAIL.get());
        netheriteSmithing(MtaItems.DIAMOND_GLAIVE.get(), RecipeCategory.COMBAT, MtaItems.NETHERITE_GLAIVE.get());
        netheriteSmithing(MtaItems.DIAMOND_HALBERD.get(), RecipeCategory.COMBAT, MtaItems.NETHERITE_HALBERD.get());
        netheriteSmithing(MtaItems.DIAMOND_KATANA.get(), RecipeCategory.COMBAT, MtaItems.NETHERITE_KATANA.get());
        netheriteSmithing(MtaItems.DIAMOND_RAPIER.get(), RecipeCategory.COMBAT, MtaItems.NETHERITE_RAPIER.get());
        netheriteSmithing(MtaItems.DIAMOND_SCYTHE.get(), RecipeCategory.COMBAT, MtaItems.NETHERITE_SCYTHE.get());
        netheriteSmithing(MtaItems.DIAMOND_SICKLE.get(), RecipeCategory.COMBAT, MtaItems.NETHERITE_SICKLE.get());
        netheriteSmithing(MtaItems.DIAMOND_SPEAR.get(), RecipeCategory.COMBAT, MtaItems.NETHERITE_SPEAR.get());
        netheriteSmithing(MtaItems.DIAMOND_TWINBLADE.get(), RecipeCategory.COMBAT, MtaItems.NETHERITE_TWINBLADE.get());
        //netheriteSmithing(MtaItems.DIAMOND_WHIP_SWORD.get(), RecipeCategory.COMBAT, MtaItems.NETHERITE_WHIP_SWORD.get());

        shapeless(RecipeCategory.MISC, MtaItems.TOMATO_SEEDS)
                .requires(MtaItems.TOMATO)
                .unlockedBy("has_tomato", has(MtaItems.TOMATO)).save(this.output);
        shapeless(RecipeCategory.MISC, MtaItems.BELL_PEPPER_SEEDS)
                .requires(MtaItems.BELL_PEPPER)
                .unlockedBy("has_red_pepper", has(MtaItems.BELL_PEPPER)).save(this.output);
        shapeless(RecipeCategory.MISC, MtaItems.CHILI_PEPPER_SEEDS)
                .requires(MtaItems.CHILI_PEPPER)
                .unlockedBy("has_chili_pepper", has(MtaItems.CHILI_PEPPER)).save(this.output);
        shapeless(RecipeCategory.FOOD, MtaItems.COCONUT_SLICE, 2)
                .requires(MtaItems.COCONUT)
                .unlockedBy("has_coconut", has(MtaItems.COCONUT)).save(this.output);
        shapeless(RecipeCategory.FOOD, MtaItems.COCONUT_MILK)
                .requires(MtaItems.COCONUT)
                .requires(Tags.Items.COBBLESTONES)
                .unlockedBy("has_coconut", has(MtaItems.COCONUT)).save(this.output, getItemName(MtaItems.COCONUT_MILK) + "_2");
        shapeless(RecipeCategory.FOOD, MtaItems.COCONUT_MILK)
                .requires(MtaItems.COCONUT)
                .requires(Tags.Items.STONES)
                .unlockedBy("has_coconut", has(MtaItems.COCONUT)).save(this.output);
        shapeless(RecipeCategory.MISC, MtaItems.SPICE_MIX)
                .requires(MtaItems.CHILI_PEPPER)
                .requires(MtaItems.BELL_PEPPER)
                .requires(MtaTags.Common.FOODS_ONION)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_glass_bottle", has(Items.GLASS_BOTTLE)).save(this.output);
        shapeless(RecipeCategory.FOOD, MtaItems.ONIGIRI)
                .requires(MtaTags.Common.CROPS_RICE)
                .requires(Items.DRIED_KELP)
                .unlockedBy("has_rice", has(MtaItems.RICE)).save(this.output);


        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MtaItems.RAW_HORSE), RecipeCategory.FOOD, MtaItems.COOKED_HORSE, 0.35F, 200)
                .unlockedBy("has_food", has(MtaItems.RAW_HORSE)).save(this.output,getSmeltingRecipeName(MtaItems.COOKED_HORSE));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MtaItems.RAW_DUCK), RecipeCategory.FOOD, MtaItems.COOKED_DUCK, 0.35F, 200)
                .unlockedBy("has_food", has(MtaItems.RAW_DUCK)).save(this.output,getSmeltingRecipeName(MtaItems.COOKED_DUCK));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MtaItems.RAW_GOAT), RecipeCategory.FOOD, MtaItems.COOKED_GOAT, 0.35F, 200)
                .unlockedBy("has_food", has(MtaItems.RAW_GOAT)).save(this.output,getSmeltingRecipeName(MtaItems.COOKED_GOAT));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MtaItems.RAW_DEER), RecipeCategory.FOOD, MtaItems.COOKED_DEER, 0.35F, 200)
                .unlockedBy("has_food", has(MtaItems.RAW_DEER)).save(this.output,getSmeltingRecipeName(MtaItems.COOKED_DEER));
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(MtaItems.RAW_TURKEY), RecipeCategory.FOOD, MtaItems.COOKED_TURKEY, 0.35F, 200)
                .unlockedBy("has_food", has(MtaItems.RAW_TURKEY)).save(this.output,getSmeltingRecipeName(MtaItems.COOKED_TURKEY));


        SimpleCookingRecipeBuilder.smoking(Ingredient.of(MtaItems.SHRIMP), RecipeCategory.FOOD, MtaItems.COOKED_SHRIMP, 0.35F, 200)
                .unlockedBy("has_shrimp", has(MtaItems.SHRIMP)).save(this.output,getItemName(MtaItems.COOKED_SHRIMP) +"_smoking");
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(MtaItems.RAW_HORSE), RecipeCategory.FOOD, MtaItems.COOKED_HORSE, 0.35F, 200)
                .unlockedBy("has_food", has(MtaItems.RAW_HORSE)).save(this.output,getItemName(MtaItems.COOKED_HORSE) +"_smoking");
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(MtaItems.RAW_DUCK), RecipeCategory.FOOD, MtaItems.COOKED_DUCK, 0.35F, 200)
                .unlockedBy("has_food", has(MtaItems.RAW_DUCK)).save(this.output,getItemName(MtaItems.COOKED_DUCK) +"_smoking");
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(MtaItems.RAW_GOAT), RecipeCategory.FOOD, MtaItems.COOKED_GOAT, 0.35F, 200)
                .unlockedBy("has_food", has(MtaItems.RAW_GOAT)).save(this.output,getItemName(MtaItems.COOKED_GOAT) +"_smoking");
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(MtaItems.RAW_DEER), RecipeCategory.FOOD, MtaItems.COOKED_DEER, 0.35F, 200)
                .unlockedBy("has_food", has(MtaItems.RAW_DEER)).save(this.output,getItemName(MtaItems.COOKED_DEER) +"_smoking");
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(MtaItems.RAW_TURKEY), RecipeCategory.FOOD, MtaItems.COOKED_TURKEY, 0.35F, 200)
                .unlockedBy("has_food", has(MtaItems.RAW_TURKEY)).save(this.output,getItemName(MtaItems.COOKED_TURKEY) +"_smoking");

        //Farmer's Delight

/*
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(MtaItems.COCONUT), Ingredient.of(CommonTags.TOOLS_KNIFE), MtaItems.COCONUT_SLICE, 3).build();
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.SWEET_BEEF_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(CommonTags.FOODS_TOMATO).addIngredient(Items.BEEF).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build();
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.SWEET_PORK_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(CommonTags.FOODS_TOMATO).addIngredient(Items.PORKCHOP).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build();
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.SWEET_CHICKEN_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(CommonTags.FOODS_TOMATO).addIngredient(Items.CHICKEN).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build();
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.SWEET_SHRIMP_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(CommonTags.FOODS_TOMATO).addIngredient(MtaItems.SHRIMP).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build();
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.MILD_BEEF_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(MtaItems.BELL_PEPPER).addIngredient(Items.BEEF).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build();
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.MILD_PORK_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(MtaItems.BELL_PEPPER).addIngredient(Items.PORKCHOP).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build();
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.MILD_CHICKEN_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(MtaItems.BELL_PEPPER).addIngredient(Items.CHICKEN).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build();
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.MILD_SHRIMP_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(MtaItems.BELL_PEPPER).addIngredient(MtaItems.SHRIMP).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build();
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.SPICY_BEEF_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(MtaItems.CHILI_PEPPER).addIngredient(Items.BEEF).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build();
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.SPICY_PORK_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(MtaItems.CHILI_PEPPER).addIngredient(Items.PORKCHOP).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build();
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.SPICY_CHICKEN_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(MtaItems.CHILI_PEPPER).addIngredient(Items.CHICKEN).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build();
        CookingPotRecipeBuilder.cookingPotRecipe(MtaItems.SPICY_SHRIMP_CURRY, 1, 200, 2.0F, MtaItems.BIG_BOWL).addIngredient(Tags.Items.FOODS_VEGETABLE).addIngredient(MtaItems.SPICE_MIX).addIngredient(MtaItems.COCONUT_MILK).addIngredient(MtaItems.CHILI_PEPPER).addIngredient(MtaItems.SHRIMP).unlockedByAnyIngredient().setRecipeBookTab(CookingPotRecipeBookTab.MEALS).build();
*/
    }


    protected void agateSmithing(Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(MtaItems.ARMAMENT_UPGRADE), Ingredient.of(pIngredientItem), Ingredient.of(MtaItems.AWAKENED_AGATE), pCategory, pResultItem).unlocks("has_awakened_agate", has(MtaItems.AWAKENED_AGATE)).save(this.output,getItemName(pResultItem) + "_smithing");
    }

    protected void alexandriteSmithing(Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(MtaItems.ROYAL_UPGRADE), Ingredient.of(pIngredientItem), Ingredient.of(MtaItems.AWAKENED_ALEXANDRITE), pCategory, pResultItem).unlocks("has_awakened_alexandrite", has(MtaItems.AWAKENED_ALEXANDRITE)).save(this.output,getItemName(pResultItem) + "_smithing");
    }

    protected void aquamarineSmithing(Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(MtaItems.AQUATIC_UPGRADE), Ingredient.of(pIngredientItem), Ingredient.of(MtaItems.AWAKENED_AQUAMARINE), pCategory, pResultItem).unlocks("has_awakened_aquamarine", has(MtaItems.AWAKENED_AQUAMARINE)).save(this.output,getItemName(pResultItem) + "_smithing");
    }

    protected void bloodstoneSmithing(Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(MtaItems.DEATHLY_UPGRADE), Ingredient.of(pIngredientItem), Ingredient.of(MtaItems.AWAKENED_BLOODSTONE), pCategory, pResultItem).unlocks("has_awakened_bloodstone", has(MtaItems.AWAKENED_BLOODSTONE)).save(this.output,getItemName(pResultItem) + "_smithing");
    }

    protected void celestiteSmithing(Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(MtaItems.ANGELIC_UPGRADE), Ingredient.of(pIngredientItem), Ingredient.of(MtaItems.AWAKENED_CELESTITE), pCategory, pResultItem).unlocks("has_awakened_celestite", has(MtaItems.AWAKENED_CELESTITE)).save(this.output,getItemName(pResultItem) + "_smithing");
    }

    protected void cryoliteSmithing(Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(MtaItems.FREEZING_UPGRADE), Ingredient.of(pIngredientItem), Ingredient.of(MtaItems.AWAKENED_CRYOLITE), pCategory, pResultItem).unlocks("has_awakened_cryolite", has(MtaItems.AWAKENED_CRYOLITE)).save(this.output,getItemName(pResultItem) + "_smithing");
    }

    protected void garnetSmithing(Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(MtaItems.BERSERK_UPGRADE), Ingredient.of(pIngredientItem), Ingredient.of(MtaItems.AWAKENED_GARNET), pCategory, pResultItem).unlocks("has_awakened_garnet", has(MtaItems.AWAKENED_GARNET)).save(this.output,getItemName(pResultItem) + "_smithing");
    }

    protected void moonstoneSmithing(Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(MtaItems.FEATHERWEIGHT_UPGRADE), Ingredient.of(pIngredientItem), Ingredient.of(MtaItems.AWAKENED_MOONSTONE), pCategory, pResultItem).unlocks("has_awakened_moonstone", has(MtaItems.AWAKENED_MOONSTONE)).save(this.output,getItemName(pResultItem) + "_smithing");
    }

    protected void cuttingStoneSetRecipe(Block ing, Block slab, Block stair, Block wall) {
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ing), RecipeCategory.BUILDING_BLOCKS, slab, 2)
                .unlockedBy(getHasName(ing), has(ing)).save(this.output,getConversionRecipeName(ing,slab) + "_stonecutter");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ing), RecipeCategory.BUILDING_BLOCKS, stair)
                .unlockedBy(getHasName(ing), has(ing)).save(this.output,getConversionRecipeName(ing,stair) + "_stonecutter");
        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ing), RecipeCategory.BUILDING_BLOCKS, wall)
                .unlockedBy(getHasName(ing), has(ing)).save(this.output,getConversionRecipeName(ing,wall) + "_stonecutter");
    }

    protected void cuttingTerracottaSetRecipe(Block ing, Block tiles, Block slab, Block tSlab, Block stair, Block tStair, Block wall, Block tWall) {
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, tiles, ing);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, slab, ing, 2);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, tSlab, ing, 2);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, stair, ing);
        stonecutterResultFromBase(RecipeCategory.BUILDING_BLOCKS, tStair, ing);
        stonecutterResultFromBase(RecipeCategory.DECORATIONS, wall, ing);
        stonecutterResultFromBase(RecipeCategory.DECORATIONS, tWall, ing);
    }

    public void upgradeTemplate(Item template, Block frame, String unlock) {
        shaped(RecipeCategory.MISC, template, 2)
                .define('X', template)
                .define('O', frame)
                .define('D', Items.DIAMOND)
                .pattern("DOD")
                .pattern("DXD")
                .pattern("DDD")
                .unlockedBy(unlock, has(template)).save(this.output,getItemName(frame) + "_duplication");
    }

    public void gemAwakening(Item gem, Item key, Item result, String unlock) {
        shaped(RecipeCategory.MISC, result)
                .define('g', gem)
                .define('k', key)
                .define('n', Items.NETHERITE_SCRAP)
                .define('l', Items.LAPIS_LAZULI)
                .pattern("klk")
                .pattern("ngn")
                .pattern("klk")
                .unlockedBy(unlock, has(gem))
                .save(this.output,getItemName(gem) + "_awakening_to_" + getItemName(result));
    }

    public void newWeapons(ItemLike ore, Item rAnc, Item rClaw, Item rClay, Item rCut, Item rDag, Item rDou, Item rFla, Item rGla, Item rHal, Item rKat, Item rRap, Item rScy, Item rSic, Item rSpe, Item rTwi,/* Item rWhi*/ String unlock) {
        shaped(RecipeCategory.COMBAT, rAnc)
                .define('o', ore)
                .pattern(" o ")
                .pattern(" o ")
                .pattern("ooo")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rClaw)
                .define('o', ore)
                .define('s', Items.LEATHER)
                .pattern("ooo")
                .pattern(" s ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rClay)
                .define('o', ore)
                .define('s', Items.STICK)
                .pattern("o  ")
                .pattern(" o ")
                .pattern("  s")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rCut)
                .define('o', ore)
                .define('s', Items.STICK)
                .pattern(" o")
                .pattern(" o")
                .pattern("s ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rDag)
                .define('o', ore)
                .define('s', Items.STICK)
                .pattern(" o")
                .pattern("s ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rDou)
                .define('o', ore)
                .define('s', Items.STICK)
                .pattern("o o")
                .pattern("oso")
                .pattern(" s ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rFla)
                .define('o', ore)
                .define('c', Items.CHAIN)
                .define('s', Items.STICK)
                .pattern("  o")
                .pattern(" c ")
                .pattern("s  ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rGla)
                .define('o', ore)
                .define('s', MtaItems.POLEARM)
                .pattern("  o")
                .pattern(" oo")
                .pattern("s  ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rHal)
                .define('o', ore)
                .define('s', MtaItems.POLEARM)
                .pattern(" oo")
                .pattern(" o ")
                .pattern("s  ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rKat)
                .define('o', ore)
                .define('s', Items.STICK)
                .pattern("  o")
                .pattern(" o ")
                .pattern("s  ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rRap)
                .define('o', ore)
                .define('s', Items.STICK)
                .pattern("  o")
                .pattern(" o ")
                .pattern("ss ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rScy)
                .define('o', ore)
                .define('s', MtaItems.POLEARM)
                .pattern("ooo")
                .pattern(" o ")
                .pattern("s  ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rSic)
                .define('o', ore)
                .define('s', Items.STICK)
                .pattern("ooo")
                .pattern(" s ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rSpe)
                .define('o', ore)
                .define('s', MtaItems.POLEARM)
                .pattern("  o")
                .pattern(" s ")
                .pattern("s  ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rTwi)
                .define('o', ore)
                .define('s', Items.STICK)
                .pattern("  o")
                .pattern(" s ")
                .pattern("o  ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
//        shaped(RecipeCategory.COMBAT, rWhi)
//                .define('o', ore)
//                .define('c', Items.CHAIN)
//                .define('S', Items.STICK)
//                .pattern("  o")
//                .pattern(" oc")
//                .pattern("s  ")
//                .unlockedBy("has_" + unlock, has(ore))
//                .save(this.output);

    }

    public void newWeaponsTags(TagKey<Item> ore, Item rAnc, Item rClaw, Item rClay, Item rCut, Item rDag, Item rDou, Item rFla, Item rGla, Item rHal, Item rKat, Item rRap, Item rScy, Item rSic, Item rSpe, Item rTwi, /*Item rWhi*/ String unlock) {
        shaped(RecipeCategory.COMBAT, rAnc)
                .define('o', ore)
                .pattern(" o ")
                .pattern(" o ")
                .pattern("ooo")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rClaw)
                .define('o', ore)
                .define('s', Items.LEATHER)
                .pattern("ooo")
                .pattern(" s ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rClay)
                .define('o', ore)
                .define('s', Items.STICK)
                .pattern("o  ")
                .pattern(" o ")
                .pattern("  s")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rCut)
                .define('o', ore)
                .define('s', Items.STICK)
                .pattern(" o")
                .pattern(" o")
                .pattern("s ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rDag)
                .define('o', ore)
                .define('s', Items.STICK)
                .pattern(" o")
                .pattern("s ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rDou)
                .define('o', ore)
                .define('s', Items.STICK)
                .pattern("o o")
                .pattern("oso")
                .pattern(" s ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rFla)
                .define('o', ore)
                .define('c', Items.CHAIN)
                .define('s', Items.STICK)
                .pattern("  o")
                .pattern(" c ")
                .pattern("s  ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rGla)
                .define('o', ore)
                .define('s', MtaItems.POLEARM)
                .pattern("  o")
                .pattern(" oo")
                .pattern("s  ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rHal)
                .define('o', ore)
                .define('s', MtaItems.POLEARM)
                .pattern(" oo")
                .pattern(" o ")
                .pattern("s  ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rKat)
                .define('o', ore)
                .define('s', Items.STICK)
                .pattern("  o")
                .pattern(" o ")
                .pattern("s  ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rRap)
                .define('o', ore)
                .define('s', Items.STICK)
                .pattern("  o")
                .pattern(" o ")
                .pattern("ss ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rScy)
                .define('o', ore)
                .define('s', MtaItems.POLEARM)
                .pattern("ooo")
                .pattern(" o ")
                .pattern("s  ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rSic)
                .define('o', ore)
                .define('s', Items.STICK)
                .pattern("ooo")
                .pattern(" s ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rSpe)
                .define('o', ore)
                .define('s', MtaItems.POLEARM)
                .pattern("  o")
                .pattern(" s ")
                .pattern("s  ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
        shaped(RecipeCategory.COMBAT, rTwi)
                .define('o', ore)
                .define('s', Items.STICK)
                .pattern("  o")
                .pattern(" s ")
                .pattern("o  ")
                .unlockedBy("has_" + unlock, has(ore))
                .save(this.output);
//        shaped(RecipeCategory.COMBAT, rWhi)
//                .define('o', ore)
//                .define('c', Items.CHAIN)
//                .define('S', Items.STICK)
//                .pattern("  o")
//                .pattern(" oc")
//                .pattern("s  ")
//                .unlockedBy("has_" + unlock, has(ore));
//
    }
    public void whipRecipe(Item mat, Item result, String unlock) {
        shaped(RecipeCategory.MISC, result)
                .define('m', mat)
                .define('s', Items.STICK)
                .pattern("  m")
                .pattern(" m ")
                .pattern("s  ")
                .unlockedBy(unlock, has(mat)).save(this.output);
        ;
    }


    @Override
    protected void generateForEnabledBlockFamilies(FeatureFlagSet enabledFeatures) {
        MTAFamilies.getAllFamilies().filter(BlockFamily::shouldGenerateRecipe).forEach(p_359455_ -> this.generateRecipes(p_359455_, enabledFeatures));
    }


    public static final class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider lookupProvider, RecipeOutput output) {
            return new GenRecipes(lookupProvider, output);
        }

        @Override
        public String getName() {
            return "More Than Adventure recipes";
        }
    }
}
