package com.fuyuaki.morethanadventure.datagen.generators.lang;

import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.fuyuaki.morethanadventure.core.registry.MtaEntityTypes;
import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class EN_US_LangProvider extends LanguageProvider {
    public EN_US_LangProvider(PackOutput output) {
        super(output, MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        //BLOCKS
        add(MtaBlocks.PALM_LOG.get(),"Palm Log");
        add(MtaBlocks.STRIPPED_PALM_LOG.get(),"Stripped Palm Log");
        add(MtaBlocks.PALM_WOOD.get(),"Palm Wood");
        add(MtaBlocks.STRIPPED_PALM_WOOD.get(),"Stripped Palm Wood");
        add(MtaBlocks.PALM_PLANKS.get(),"Palm Planks");
        add(MtaBlocks.PALM_LEAVES.get(),"Palm Leaves");
        add(MtaBlocks.PALM_SAPLING.get(),"Palm Sapling");
        add(MtaBlocks.PALM_STAIRS.get(),"Palm Stairs");
        add(MtaBlocks.PALM_SLAB.get(),"Palm Slab");
        add(MtaBlocks.PALM_PRESSURE_PLATE.get(),"Palm Pressure Plate");
        add(MtaBlocks.PALM_BUTTON.get(),"Palm Button");
        add(MtaBlocks.PALM_FENCE.get(),"Palm Fence");
        add(MtaBlocks.PALM_FENCE_GATE.get(),"Palm Fence Gate");
        add(MtaBlocks.PALM_DOOR.get(),"Palm Fence Gate");
        add(MtaBlocks.PALM_TRAPDOOR.get(),"Palm Trapdoor");
        add(MtaBlocks.SPRINKLER.get(),"Sprinkler");
        add(MtaBlocks.STONE_GEYSER.get(),"Stone Geyser");
        add(MtaBlocks.TERRACOTTA_GEYSER.get(),"Terracotta Geyser");
        add(MtaBlocks.NETHERRACK_GEYSER.get(),"Netherrack Geyser");
        add(MtaBlocks.BASALT_GEYSER.get(),"Basalt Geyser");
        add(MtaBlocks.MOSSY_ANDESITE.get(),"Mossy Andesite");
        add(MtaBlocks.NETHER_IRON_ORE.get(),"Nether Iron Ore");
        add(MtaBlocks.NETHER_DIAMOND_ORE.get(),"Nether Diamond Ore");
        add(MtaBlocks.END_LAPIS_ORE.get(),"End Lapis Ore");
        add(MtaBlocks.END_EMERALD_ORE.get(),"End Emerald Ore");
        add(MtaBlocks.CLEAR_QUARTZ_CLUSTER.get(),"Clear Quartz Cluster");
        add(MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_ORE.get(),"Deepslate Clear Quartz  Ore");
        add(MtaBlocks.CLEAR_QUARTZ_ORE.get(),"Clear Quartz Ore");
        add(MtaBlocks.CLEAR_QUARTZ_GROWTH.get(),"Clear Quartz Growth");
        add(MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_GROWTH.get(),"Deepslate Clear Quartz Growth");
        add(MtaBlocks.CALCITE_CLEAR_QUARTZ_GROWTH.get(),"Calcite Clear Quartz Growth");
        add(MtaBlocks.QUARTZ_LAMP.get(),"Quartz Lamp");


        //ITEM
        add(MtaItems.BIG_BOWL.get(),"Big Bowl");

        add(MtaItems.CLEAR_QUARTZ.get(),"Clear Quartz");
        add(MtaItems.NETHERITE_FRACTURE.get(),"Netherite Scrap Facture");

        add(MtaItems.AGATE.get(),"Agate");
        add(MtaItems.ALEXANDRITE.get(),"Alexandrite");
        add(MtaItems.AQUAMARINE.get(),"Aquamarine");
        add(MtaItems.CELESTITE.get(),"Celestite");
        add(MtaItems.GARNET.get(),"Garnet");
        add(MtaItems.MOONSTONE.get(),"Moonstone");

        add(MtaItems.ARMAMENT_UPGRADE.get(),"Armament Upgrade");
        add(MtaItems.ROYAL_UPGRADE.get(),"Royal Upgrade");
        add(MtaItems.AQUATIC_UPGRADE.get(),"Aquatic Upgrade");
        add(MtaItems.ANGELIC_UPGRADE.get(),"Angelic Upgrade");
        add(MtaItems.BERSERK_UPGRADE.get(),"Berserk Upgrade");
        add(MtaItems.FEATHERWEIGHT_UPGRADE.get(),"Featherweight Upgrade");

        //ARMOR
        add(MtaItems.GREAT_SENTINELS_HELMET.get(), "Great Sentinel's Helmet");
        add(MtaItems.GREAT_SENTINELS_CHESTPLATE.get(), "Great Sentinel's Chestplate");
        add(MtaItems.GREAT_SENTINELS_LEGGINGS.get(), "Great Sentinel's Leggings");
        add(MtaItems.GREAT_SENTINELS_BOOTS.get(), "Great Sentinel's Boots");
        add(MtaItems.HOLY_KNIGHTS_HELMET.get(), "Holy Knight's Helmet");
        add(MtaItems.HOLY_KNIGHTS_CHESTPLATE.get(), "Holy Knight's Chestplate");
        add(MtaItems.HOLY_KNIGHTS_LEGGINGS.get(), "Holy Knight's Leggings");
        add(MtaItems.HOLY_KNIGHTS_BOOTS.get(), "Holy Knight's Boots");
        add(MtaItems.MYSTIC_MERMAIDS_HELMET.get(), "Mystic Mermaid's Helmet");
        add(MtaItems.MYSTIC_MERMAIDS_CHESTPLATE.get(), "Mystic Mermaid's Chestplate");
        add(MtaItems.MYSTIC_MERMAIDS_LEGGINGS.get(), "Mystic Mermaid's Leggings");
        add(MtaItems.MYSTIC_MERMAIDS_BOOTS.get(), "Mystic Mermaid's Boots");
        add(MtaItems.TEMPLE_ANGELS_HELMET.get(), "Temple Angel's Helmet");
        add(MtaItems.TEMPLE_ANGELS_CHESTPLATE.get(), "Temple Angel's Chestplate");
        add(MtaItems.TEMPLE_ANGELS_LEGGINGS.get(), "Temple Angel's Leggings");
        add(MtaItems.TEMPLE_ANGELS_BOOTS.get(), "Temple Angel's Boots");
        add(MtaItems.WRATHFUL_BERSERKERS_HELMET.get(), "Wrathful Berserker's Helmet");
        add(MtaItems.WRATHFUL_BERSERKERS_CHESTPLATE.get(), "Wrathful Berserker's Chestplate");
        add(MtaItems.WRATHFUL_BERSERKERS_LEGGINGS.get(), "Wrathful Berserker's Leggings");
        add(MtaItems.WRATHFUL_BERSERKERS_BOOTS.get(), "Wrathful Berserker's Boots");
        add(MtaItems.SHADOW_ROGUES_HELMET.get(), "Shadow Rogue's Helmet");
        add(MtaItems.SHADOW_ROGUES_CHESTPLATE.get(), "Shadow Rogue's Chestplate");
        add(MtaItems.SHADOW_ROGUES_LEGGINGS.get(), "Shadow Rogue's Leggings");
        add(MtaItems.SHADOW_ROGUES_BOOTS.get(), "Shadow Rogue's Boots");

        //TOOLS
        add(MtaItems.ARMAMENT_PICKAXE.get(), "Armament Pickaxe");
        add(MtaItems.ARMAMENT_AXE.get(), "Armament Axe");
        add(MtaItems.ARMAMENT_SHOVEL.get(), "Armament Shovel");
        add(MtaItems.ROYAL_PICKAXE.get(), "Loyal Pickaxe");
        add(MtaItems.ROYAL_AXE.get(), "Loyal Axe");
        add(MtaItems.ROYAL_SHOVEL.get(), "Loyal Shovel");
        add(MtaItems.AQUATIC_PICKAXE.get(), "Aquatic Pickaxe");
        add(MtaItems.AQUATIC_AXE.get(), "Aquatic Axe");
        add(MtaItems.AQUATIC_SHOVEL.get(), "Aquatic Shovel");
        add(MtaItems.ANGELIC_PICKAXE.get(), "Angelic Pickaxe");
        add(MtaItems.ANGELIC_AXE.get(), "Angelic Axe");
        add(MtaItems.ANGELIC_SHOVEL.get(), "Angelic Shovel");
        add(MtaItems.BERSERK_PICKAXE.get(), "Berserk Pickaxe");
        add(MtaItems.BERSERK_AXE.get(), "Berserk Axe");
        add(MtaItems.BERSERK_SHOVEL.get(), "Berserk Shovel");
        add(MtaItems.FEATHERWEIGHT_PICKAXE.get(), "Featherweight Pickaxe");
        add(MtaItems.FEATHERWEIGHT_AXE.get(), "Featherweight Axe");
        add(MtaItems.FEATHERWEIGHT_SHOVEL.get(), "Featherweight Shovel");

        add(MtaItems.COPPER_PICKAXE.get(), "Copper Pickaxe");
        add(MtaItems.COPPER_AXE.get(), "Copper Axe");
        add(MtaItems.COPPER_SHOVEL.get(), "Copper Shovel");
        add(MtaItems.COPPER_HOE.get(), "Copper Hoe");

        //WEAPONS
        add(MtaItems.COPPER_SWORD.get(), "Copper Sword");
        add(MtaItems.NETHERITE_TRIDENT.get(), "Netherite Trident");
        add(MtaItems.NETHERITE_BOW.get(), "Netherite Bow");
        add(MtaItems.GREAT_SENTINELS_WAR_HAMMER.get(), "Great Sentinel's War Hammer");
        add(MtaItems.HOLY_KNIGHTS_GREATSWORD.get(), "Holy Knight's Greatsword");
        add(MtaItems.MYSTIC_MERMAIDS_TRIDENT.get(), "Mystic Mermaid's Trident");
        add(MtaItems.TEMPLE_ANGELS_BOW.get(), "Temple Angel's Bow");
        add(MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE.get(), "Wrathful Berserker's Battleaxe");
        add(MtaItems.SHADOW_ROGUES_DAGGER.get(), "Shadow Rogue's Dagger");



        //FOODS
        add(MtaItems.ONION.get(),"Onion");
        add(MtaItems.SHRIMP.get(),"Shrimp");
        add(MtaItems.COOKED_SHRIMP.get(),"Cooked Shrimp");
        add(MtaItems.TOMATO.get(),"Tomato");
        add(MtaItems.TOMATO_SEEDS.get(),"Tomato Seeds");
        add(MtaItems.RED_PEPPER.get(),"Red Pepper");
        add(MtaItems.RED_PEPPER_SEEDS.get(),"Red Pepper Seeds");
        add(MtaItems.CHILI_PEPPER.get(),"Chili Pepper");
        add(MtaItems.CHILI_PEPPER_SEEDS.get(),"Chili Pepper Seeds");
        add(MtaItems.RICE.get(),"Rice");
        add(MtaItems.ONIGIRI.get(),"Onigiri");
        add(MtaItems.COCONUT.get(),"Coconut");
        add(MtaItems.COCONUT_MILK.get(),"Coconut Milk");
        add(MtaItems.COCONUT_SLICE.get(),"Coconut Slice");
        add(MtaItems.SPICE_MIX.get(),"Spice Mix");
        add(MtaItems.SWEET_BEEF_CURRY.get(),"Sweet Beef Curry");
        add(MtaItems.SWEET_PORK_CURRY.get(),"Sweet Pork Curry");
        add(MtaItems.SWEET_CHICKEN_CURRY.get(),"Sweet Chicken Curry");
        add(MtaItems.SWEET_SHRIMP_CURRY.get(),"Sweet Shrimp Curry");
        add(MtaItems.MILD_BEEF_CURRY.get(),"Mild Beef Curry");
        add(MtaItems.MILD_PORK_CURRY.get(),"Mild Pork Curry");
        add(MtaItems.MILD_CHICKEN_CURRY.get(),"Mild Chicken Curry");
        add(MtaItems.MILD_SHRIMP_CURRY.get(),"Mild Shrimp Curry");
        add(MtaItems.SPICY_BEEF_CURRY.get(),"Spicy Beef Curry");
        add(MtaItems.SPICY_PORK_CURRY.get(),"Spicy Pork Curry");
        add(MtaItems.SPICY_CHICKEN_CURRY.get(),"Spicy Chicken Curry");
        add(MtaItems.SPICY_SHRIMP_CURRY.get(),"Spicy Shrimp Curry");

        //SPAWN EGGS

        add(MtaItems.YUKI_ONNA_SPAWN_EGG.get(),"Yuki Onna Spawn Egg");
        add(MtaItems.FALLEN_SAMURAI_SPAWN_EGG.get(),"Fallen Samurai Spawn Egg");
        add(MtaItems.BUTTERFLY_SPAWN_EGG.get(),"Butterfly Spawn Egg");
        add(MtaItems.BEARDED_DRAGON_SPAWN_EGG.get(),"Bearded Dragon Spawn Egg");
        add(MtaItems.CAPYBARA_SPAWN_EGG.get(),"Capybara Spawn Egg");
        add(MtaItems.DUCK_SPAWN_EGG.get(),"Duck Spawn Egg");
        add(MtaItems.FERRET_SPAWN_EGG.get(),"Ferret Spawn Egg");
        add(MtaItems.GREAT_WHITE_SHARK_SPAWN_EGG.get(),"Great White Shark Spawn Egg");
        add(MtaItems.HORSESHOE_CRAB_SPAWN_EGG.get(),"Horseshoe Crab Spawn Egg");
        add(MtaItems.JELLYFISH_SPAWN_EGG.get(),"Jellyfish Spawn Egg");
        add(MtaItems.OCTOPUS_SPAWN_EGG.get(),"Octopus Spawn Egg");
        add(MtaItems.OWL_SPAWN_EGG.get(),"Owl Spawn Egg");
        add(MtaItems.PENGUIN_SPAWN_EGG.get(),"Penguin Spawn Egg");
        add(MtaItems.RACCOON_SPAWN_EGG.get(),"Raccoon Spawn Egg");
        add(MtaItems.SHRIMP_SPAWN_EGG.get(),"Shrimp Spawn Egg");
        add(MtaItems.TOUCAN_SPAWN_EGG.get(),"Toucan Spawn Egg");


        //ENTITIES
        add(MtaEntityTypes.YUKI_ONNA.get(),"Yuki Onna");
        add(MtaEntityTypes.FALLEN_SAMURAI.get(),"Fallen Samurai");
        add(MtaEntityTypes.BEARDED_DRAGON.get(),"Bearded Dragon");
        add(MtaEntityTypes.CAPIBARA.get(),"Capybara");
        add(MtaEntityTypes.DUCK.get(),"Duck");
        add(MtaEntityTypes.FERRET.get(),"Ferret");
        add(MtaEntityTypes.GREAT_WHITE_SHARK.get(),"Great White Shark");
        add(MtaEntityTypes.HORSESHOE_CRAB.get(),"Horseshoe Crab");
        add(MtaEntityTypes.JELLYFISH.get(),"Jellyfish");
        add(MtaEntityTypes.OCTOPUS.get(),"Octopus");
        add(MtaEntityTypes.OWL.get(),"Owl");
        add(MtaEntityTypes.PENGUIN.get(),"Penguin");
        add(MtaEntityTypes.RACCOON.get(),"Raccoon");
        add(MtaEntityTypes.SHRIMP.get(),"Shrimp");
        add(MtaEntityTypes.TOUCAN.get(),"Toucan");

        //OTHER

        add("itemGroup.morethanadventure","More Than Adventure ALL");
        add("itemGroup.mtaitemblock","MTA: Blocks & Items");
        add("itemGroup.mtaequip","MTA: Equipments");
        add("itemGroup.mtamisc","MTA: Foods, Spawns & Miscellaneous");

    }
}
