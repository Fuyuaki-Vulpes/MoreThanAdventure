package com.fuyuaki.morethanadventure.datagen.loot;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import com.fuyuaki.morethanadventure.world.loot.MtaAddItemModifier;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class GlobalLootModifiers extends GlobalLootModifierProvider {
    public GlobalLootModifiers(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, MTAMod.MODID);
    }

    @Override
    protected void start() {
        this.add("onion_from_grass", new MtaAddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.0125f).build(),
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
                new InvertedLootItemCondition(
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(registries.lookupOrThrow(Registries.ITEM),Tags.Items.TOOLS_SHEAR)).build()
                )
        }, MtaItems.ONION.get(), 1));

        this.add("onion_from_tall_grass", new MtaAddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.0125f).build(),
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS).build(),
                new InvertedLootItemCondition(
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(registries.lookupOrThrow(Registries.ITEM),Tags.Items.TOOLS_SHEAR)).build()
                )
        }, MtaItems.ONION.get(), 1));

        this.add("tomato_seeds_from_grass", new MtaAddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.0125f).build(),
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
                new InvertedLootItemCondition(
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(registries.lookupOrThrow(Registries.ITEM),Tags.Items.TOOLS_SHEAR)).build()
                )
        }, MtaItems.TOMATO_SEEDS.get(), 1));

        this.add("tomato_seeds_from_tall_grass", new MtaAddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.0125f).build(),
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS).build(),
                new InvertedLootItemCondition(
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(registries.lookupOrThrow(Registries.ITEM),Tags.Items.TOOLS_SHEAR)).build()
                )
        }, MtaItems.TOMATO_SEEDS.get(), 1));

        this.add("bell_pepper_seeds_from_grass", new MtaAddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.0125f).build(),
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
                new InvertedLootItemCondition(
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(registries.lookupOrThrow(Registries.ITEM),Tags.Items.TOOLS_SHEAR)).build()
                )
        }, MtaItems.BELL_PEPPER_SEEDS.get(), 1));

        this.add("bell_pepper_seeds_from_tall_grass", new MtaAddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.0125f).build(),
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS).build(),
                new InvertedLootItemCondition(
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(registries.lookupOrThrow(Registries.ITEM),Tags.Items.TOOLS_SHEAR)).build()
                )
        }, MtaItems.BELL_PEPPER_SEEDS.get(), 1));

        this.add("chili_pepper_seeds_from_grass", new MtaAddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.0125f).build(),
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
                new InvertedLootItemCondition(
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(registries.lookupOrThrow(Registries.ITEM),Tags.Items.TOOLS_SHEAR)).build()
                )
        }, MtaItems.CHILI_PEPPER_SEEDS.get(), 1));

        this.add("chili_pepper_seeds_from_tall_grass", new MtaAddItemModifier(new LootItemCondition[]{
                LootItemRandomChanceCondition.randomChance(0.0125f).build(),
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS).build(),
                new InvertedLootItemCondition(
                        MatchTool.toolMatches(ItemPredicate.Builder.item().of(registries.lookupOrThrow(Registries.ITEM),Tags.Items.TOOLS_SHEAR)).build()
                )
        }, MtaItems.CHILI_PEPPER_SEEDS.get(), 1));
    }
}
