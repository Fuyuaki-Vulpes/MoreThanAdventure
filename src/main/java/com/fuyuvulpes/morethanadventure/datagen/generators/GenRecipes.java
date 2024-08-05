package com.fuyuvulpes.morethanadventure.datagen.generators;

import com.fuyuvulpes.morethanadventure.core.registry.MtaBlocks;
import com.fuyuvulpes.morethanadventure.core.registry.MtaItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class GenRecipes  extends RecipeProvider implements IConditionBuilder {
    public GenRecipes(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC,Items.NETHERITE_SCRAP)
                .define('#', MtaItems.NETHERITE_FRACTURE.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_scrap_facture", has(MtaItems.NETHERITE_FRACTURE.get()))
                .save(output, MODID);

        smeltingResultFromBase(output, Items.LEATHER,Items.ROTTEN_FLESH);

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


    }
}
