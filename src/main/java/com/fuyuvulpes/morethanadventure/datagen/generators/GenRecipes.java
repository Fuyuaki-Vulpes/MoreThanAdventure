package com.fuyuvulpes.morethanadventure.datagen.generators;

import com.fuyuvulpes.morethanadventure.core.registry.MtaItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
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


    }
}
