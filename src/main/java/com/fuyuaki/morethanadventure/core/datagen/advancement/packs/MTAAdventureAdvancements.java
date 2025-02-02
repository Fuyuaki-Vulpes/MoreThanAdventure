package com.fuyuaki.morethanadventure.core.datagen.advancement.packs;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlocks;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaBiomes;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.*;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.function.Consumer;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTAAdventureAdvancements implements AdvancementSubProvider {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> writer) {

        HolderGetter<EntityType<?>> entityRegistry = registries.lookupOrThrow(Registries.ENTITY_TYPE);
        HolderGetter<Item> itemRegistry = registries.lookupOrThrow(Registries.ITEM);
        HolderGetter<Block> blockRegistry = registries.lookupOrThrow(Registries.BLOCK);
        HolderGetter<Biome> biomeRegistry = registries.lookupOrThrow(Registries.BIOME);
        AdvancementRequirements.Strategy needAny = AdvancementRequirements.Strategy.OR;
        AdvancementRequirements.Strategy needAll = AdvancementRequirements.Strategy.AND;
        AdvancementHolder root = Advancement.Builder.advancement()
                .display(
                        MtaItems.AWAKENED_AGATE,
                        Component.translatable("advancements.mta.adventure.root.title"),
                        Component.translatable("advancements.mta.adventure.root.description"),
                        ResourceLocation.fromNamespaceAndPath(MODID,"textures/gui/advancements/backgrounds/adventure.png"),
                        AdvancementType.TASK,
                        false,
                        false,
                        false
                )
                .addCriterion("beginnings", PlayerTrigger.TriggerInstance.tick())
                .save(writer, "mta_adventure/root");

        AdvancementHolder biomeAdvancement = addBiomes(Advancement.Builder.advancement().requirements(needAny),registries,MtaBiomes.BIOMES)
                .parent(root)
                .display(MtaBlocks.PALM_SAPLING.get(),
                        Component.translatable(nameKey("biomes")),
                        Component.translatable(descKey("biomes")),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .save(writer,"mta_adventure/biome");

        AdvancementHolder allBiomesAdvancement = addBiomes(Advancement.Builder.advancement().requirements(needAll),registries,MtaBiomes.BIOMES)
                .parent(biomeAdvancement)
                .display(MtaBlocks.TUNDRA_GRASS.get(),
                        Component.translatable(nameKey("biomes_all")),
                        Component.translatable(descKey("biomes_all")),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .save(writer,"mta_adventure/biomes");

        AdvancementHolder weapons = Advancement.Builder.advancement()
                .display(MtaItems.IRON_HALBERD.get(),
                        Component.translatable(nameKey("weapon")),
                        Component.translatable(descKey("weapon")),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .parent(root)
                .addCriterion("craft", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(itemRegistry, MtaTags.Items.MTA_WEAPONRY)))
                .save(writer,id("weaponry"));

    }

    private String nameKey(String name){
        return "advancements.mta.adventure." + name + ".title";
    }


    private String descKey(String name){
        return "advancements.mta.adventure." + name + ".description";
    }
    private String id(String name){
        return "mta_adventure/" + name ;
    }


    protected static Advancement.Builder addBiomes(Advancement.Builder builder, HolderLookup.Provider levelRegistry, List<ResourceKey<Biome>> biomes) {
        HolderGetter<Biome> holdergetter = levelRegistry.lookupOrThrow(Registries.BIOME);

        for (ResourceKey<Biome> resourcekey : biomes) {
            builder.addCriterion(
                    resourcekey.location().toString(),
                    PlayerTrigger.TriggerInstance.located(LocationPredicate.Builder.inBiome(holdergetter.getOrThrow(resourcekey)))
            );
        }

        return builder;
    }


}
