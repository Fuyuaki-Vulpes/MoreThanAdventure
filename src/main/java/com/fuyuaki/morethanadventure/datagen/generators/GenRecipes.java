package com.fuyuaki.morethanadventure.datagen.generators;

import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

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

        agateSmithing(output, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MtaItems.GREAT_SENTINELS_HELMET.get());
        agateSmithing(output, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MtaItems.GREAT_SENTINELS_CHESTPLATE.get());
        agateSmithing(output, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MtaItems.GREAT_SENTINELS_LEGGINGS.get());
        agateSmithing(output, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MtaItems.GREAT_SENTINELS_BOOTS.get());
        agateSmithing(output, Items.MACE, RecipeCategory.COMBAT, MtaItems.GREAT_SENTINELS_WAR_HAMMER.get());
        agateSmithing(output, Items.NETHERITE_PICKAXE, RecipeCategory.COMBAT, MtaItems.ARMAMENT_PICKAXE.get());
        agateSmithing(output, Items.NETHERITE_AXE, RecipeCategory.COMBAT, MtaItems.ARMAMENT_AXE.get());
        agateSmithing(output, Items.NETHERITE_SHOVEL, RecipeCategory.COMBAT, MtaItems.ARMAMENT_SHOVEL.get());

        //alexandriteSmithing(output, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MtaItems.HOLY_KNIGHTS_HELMET.get());
        //alexandriteSmithing(output, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MtaItems.HOLY_KNIGHTS_CHESTPLATE.get());
        //alexandriteSmithing(output, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MtaItems.HOLY_KNIGHTS_LEGGINGS.get());
        //alexandriteSmithing(output, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MtaItems.HOLY_KNIGHTS_BOOTS.get());
        alexandriteSmithing(output, Items.NETHERITE_SWORD, RecipeCategory.COMBAT, MtaItems.HOLY_KNIGHTS_GREATSWORD.get());
        alexandriteSmithing(output, Items.NETHERITE_PICKAXE, RecipeCategory.COMBAT, MtaItems.ROYAL_PICKAXE.get());
        alexandriteSmithing(output, Items.NETHERITE_AXE, RecipeCategory.COMBAT, MtaItems.ROYAL_AXE.get());
        alexandriteSmithing(output, Items.NETHERITE_SHOVEL, RecipeCategory.COMBAT, MtaItems.ROYAL_SHOVEL.get());

        //aquamarineSmithing(output, Items.NETHERITE_HELMET, RecipeCategory.COMBAT, MtaItems.MYSTIC_MERMAIDS_HELMET.get());
        //aquamarineSmithing(output, Items.NETHERITE_CHESTPLATE, RecipeCategory.COMBAT, MtaItems.MYSTIC_MERMAIDS_CHESTPLATE.get());
        //aquamarineSmithing(output, Items.NETHERITE_LEGGINGS, RecipeCategory.COMBAT, MtaItems.MYSTIC_MERMAIDS_LEGGINGS.get());
        //aquamarineSmithing(output, Items.NETHERITE_BOOTS, RecipeCategory.COMBAT, MtaItems.MYSTIC_MERMAIDS_BOOTS.get());
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
                .save(output, "morethanadventure:coconut_milk_stones");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC,MtaItems.SPICE_MIX)
                .requires(MtaItems.CHILI_PEPPER)
                .requires(MtaItems.BELL_PEPPER)
                .requires(MtaItems.ONION)
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
}
