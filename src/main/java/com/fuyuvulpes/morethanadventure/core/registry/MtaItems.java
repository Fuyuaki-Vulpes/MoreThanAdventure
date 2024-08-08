package com.fuyuvulpes.morethanadventure.core.registry;

import com.fuyuvulpes.morethanadventure.world.item.MTAToolTiers;
import com.fuyuvulpes.morethanadventure.world.item.MtaFoods;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class MtaItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    //ITEMS


    public static final DeferredItem<Item> BIG_BOWL = ITEMS.registerSimpleItem("big_bowl");

    public static final DeferredItem<Item> CLEAR_QUARTZ = ITEMS.registerSimpleItem("clear_quartz");
    public static final DeferredItem<Item> NETHERITE_FRACTURE = ITEMS.registerSimpleItem("netherite_fracture", new Item.Properties().fireResistant());


    //GEMS

    public static final DeferredItem<Item> AGATE = ITEMS.registerSimpleItem("agate", new Item.Properties());
    public static final DeferredItem<Item> ALEXANDRITE = ITEMS.registerSimpleItem("alexandrite", new Item.Properties());
    public static final DeferredItem<Item> AQUAMARINE = ITEMS.registerSimpleItem("aquamarine", new Item.Properties());
    public static final DeferredItem<Item> CELESTITE = ITEMS.registerSimpleItem("celestite", new Item.Properties());
    public static final DeferredItem<Item> GARNET = ITEMS.registerSimpleItem("garnet", new Item.Properties());
    public static final DeferredItem<Item> MOONSTONE = ITEMS.registerSimpleItem("moonstone", new Item.Properties());

    //UPGRADES
    public static final DeferredItem<Item> ARMAMENT_UPGRADE = ITEMS.registerSimpleItem("armament_upgrade", new Item.Properties());
    public static final DeferredItem<Item> ROYAL_UPGRADE = ITEMS.registerSimpleItem("royal_upgrade", new Item.Properties());
    public static final DeferredItem<Item> AQUATIC_UPGRADE = ITEMS.registerSimpleItem("aquatic_upgrade", new Item.Properties());
    public static final DeferredItem<Item> ANGELIC_UPGRADE = ITEMS.registerSimpleItem("angelic_upgrade", new Item.Properties());
    public static final DeferredItem<Item> BERSERK_UPGRADE = ITEMS.registerSimpleItem("berserk_upgrade", new Item.Properties());
    public static final DeferredItem<Item> FEATHERWEIGHT_UPGRADE = ITEMS.registerSimpleItem("featherweight_upgrade", new Item.Properties());

    //ARMOR

    public static final DeferredItem<ArmorItem> GREAT_SENTINELS_HELMET = ITEMS.register("great_sentinel_helmet", () -> new ArmorItem(MtaArmorMats.GREAT_SENTINEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<ArmorItem> GREAT_SENTINELS_CHESTPLATE = ITEMS.register("great_sentinel_chestplate", () -> new ArmorItem(MtaArmorMats.GREAT_SENTINEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<ArmorItem> GREAT_SENTINELS_LEGGINGS = ITEMS.register("great_sentinel_leggings", () -> new ArmorItem(MtaArmorMats.GREAT_SENTINEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<ArmorItem> GREAT_SENTINELS_BOOTS = ITEMS.register("great_sentinel_boots", () -> new ArmorItem(MtaArmorMats.GREAT_SENTINEL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<ArmorItem> HOLY_KNIGHTS_HELMET = ITEMS.register("holy_knights_helmet", () -> new ArmorItem(MtaArmorMats.HOLY_KNIGHT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<ArmorItem> HOLY_KNIGHTS_CHESTPLATE = ITEMS.register("holy_knights_chestplate", () -> new ArmorItem(MtaArmorMats.HOLY_KNIGHT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<ArmorItem> HOLY_KNIGHTS_LEGGINGS = ITEMS.register("holy_knights_leggings", () -> new ArmorItem(MtaArmorMats.HOLY_KNIGHT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<ArmorItem> HOLY_KNIGHTS_BOOTS = ITEMS.register("holy_knights_boots", () -> new ArmorItem(MtaArmorMats.HOLY_KNIGHT, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<ArmorItem> MYSTIC_MERMAIDS_HELMET = ITEMS.register("mystic_mermaids_helmet", () -> new ArmorItem(MtaArmorMats.MYSTIC_MERMAID, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<ArmorItem> MYSTIC_MERMAIDS_CHESTPLATE = ITEMS.register("mystic_mermaids_chestplate", () -> new ArmorItem(MtaArmorMats.MYSTIC_MERMAID, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<ArmorItem> MYSTIC_MERMAIDS_LEGGINGS = ITEMS.register("mystic_mermaids_leggings", () -> new ArmorItem(MtaArmorMats.MYSTIC_MERMAID, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<ArmorItem> MYSTIC_MERMAIDS_BOOTS = ITEMS.register("mystic_mermaids_boots", () -> new ArmorItem(MtaArmorMats.MYSTIC_MERMAID, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<ArmorItem> TEMPLE_ANGELS_HELMET = ITEMS.register("temple_angels_helmet", () -> new ArmorItem(MtaArmorMats.TEMPLE_ANGEL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<ArmorItem> TEMPLE_ANGELS_CHESTPLATE = ITEMS.register("temple_angels_chestplate", () -> new ArmorItem(MtaArmorMats.TEMPLE_ANGEL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<ArmorItem> TEMPLE_ANGELS_LEGGINGS = ITEMS.register("temple_angels_leggings", () -> new ArmorItem(MtaArmorMats.TEMPLE_ANGEL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<ArmorItem> TEMPLE_ANGELS_BOOTS = ITEMS.register("temple_angels_boots", () -> new ArmorItem(MtaArmorMats.TEMPLE_ANGEL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<ArmorItem> WRATHFUL_BERSERKERS_HELMET = ITEMS.register("wrathful_berserkers_helmet", () -> new ArmorItem(MtaArmorMats.WRATHFUL_BERSERKER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<ArmorItem> WRATHFUL_BERSERKERS_CHESTPLATE = ITEMS.register("wrathful_berserkers_chestplate", () -> new ArmorItem(MtaArmorMats.WRATHFUL_BERSERKER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<ArmorItem> WRATHFUL_BERSERKERS_LEGGINGS = ITEMS.register("wrathful_berserkers_leggings", () -> new ArmorItem(MtaArmorMats.WRATHFUL_BERSERKER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<ArmorItem> WRATHFUL_BERSERKERS_BOOTS = ITEMS.register("wrathful_berserkers_boots", () -> new ArmorItem(MtaArmorMats.WRATHFUL_BERSERKER, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final DeferredItem<ArmorItem> SHADOW_ROGUES_HELMET = ITEMS.register("shadow_rogues_helmet", () -> new ArmorItem(MtaArmorMats.SHADOW_ROGUE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<ArmorItem> SHADOW_ROGUES_CHESTPLATE = ITEMS.register("shadow_rogues_chestplate", () -> new ArmorItem(MtaArmorMats.SHADOW_ROGUE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<ArmorItem> SHADOW_ROGUES_LEGGINGS = ITEMS.register("shadow_rogues_leggings", () -> new ArmorItem(MtaArmorMats.SHADOW_ROGUE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<ArmorItem> SHADOW_ROGUES_BOOTS = ITEMS.register("shadow_rogues_boots", () -> new ArmorItem(MtaArmorMats.SHADOW_ROGUE, ArmorItem.Type.BOOTS, new Item.Properties()));


    //TOOLS

    public static final DeferredItem<PickaxeItem> ARMAMENT_PICKAXE = ITEMS.register("armament_pickaxe", () -> new PickaxeItem(MTAToolTiers.AGATE, new Item.Properties().attributes(PickaxeItem.createAttributes(MTAToolTiers.AGATE, 1, -2.8f))));
    public static final DeferredItem<AxeItem> ARMAMENT_AXE = ITEMS.register("armament_axe", () -> new AxeItem(MTAToolTiers.AGATE, new Item.Properties().attributes(AxeItem.createAttributes(MTAToolTiers.AGATE, 1.0F, -2.8F))));
    public static final DeferredItem<ShovelItem> ARMAMENT_SHOVEL = ITEMS.register("armament_shovel", () -> new ShovelItem(MTAToolTiers.AGATE, new Item.Properties().attributes(ShovelItem.createAttributes(MTAToolTiers.AGATE, 1.5F, -3F))));

    public static final DeferredItem<PickaxeItem> ROYAL_PICKAXE = ITEMS.register("royal_pickaxe", () -> new PickaxeItem(MTAToolTiers.ALEXANDRITE, new Item.Properties().attributes(PickaxeItem.createAttributes(MTAToolTiers.ALEXANDRITE, 1.0F, -2.8F))));
    public static final DeferredItem<AxeItem> ROYAL_AXE = ITEMS.register("royal_axe", () -> new AxeItem(MTAToolTiers.ALEXANDRITE, new Item.Properties().attributes(AxeItem.createAttributes(MTAToolTiers.ALEXANDRITE, 1.0F, -2.8F))));
    public static final DeferredItem<ShovelItem> ROYAL_SHOVEL = ITEMS.register("royal_shovel", () -> new ShovelItem(MTAToolTiers.ALEXANDRITE, new Item.Properties().attributes(ShovelItem.createAttributes(MTAToolTiers.ALEXANDRITE, 1.5F, -3F))));

    public static final DeferredItem<PickaxeItem> AQUATIC_PICKAXE = ITEMS.register("aquatic_pickaxe", () -> new PickaxeItem(MTAToolTiers.AQUAMARINE, new Item.Properties().attributes(PickaxeItem.createAttributes(MTAToolTiers.AQUAMARINE, 1.0F, -2.8F))));
    public static final DeferredItem<AxeItem> AQUATIC_AXE = ITEMS.register("aquatic_axe", () -> new AxeItem(MTAToolTiers.AQUAMARINE, new Item.Properties().attributes(AxeItem.createAttributes(MTAToolTiers.AQUAMARINE, 1.0F, -2.8F))));
    public static final DeferredItem<ShovelItem> AQUATIC_SHOVEL = ITEMS.register("aquatic_shovel", () -> new ShovelItem(MTAToolTiers.AQUAMARINE, new Item.Properties().attributes(ShovelItem.createAttributes(MTAToolTiers.AQUAMARINE, 1.5F, -3F))));

    public static final DeferredItem<PickaxeItem> ANGELIC_PICKAXE = ITEMS.register("angelic_pickaxe", () -> new PickaxeItem(MTAToolTiers.CELESTITE, new Item.Properties().attributes(PickaxeItem.createAttributes(MTAToolTiers.CELESTITE, 1.0F, -2.8F))));
    public static final DeferredItem<AxeItem> ANGELIC_AXE = ITEMS.register("angelic_axe", () -> new AxeItem(MTAToolTiers.CELESTITE, new Item.Properties().attributes(AxeItem.createAttributes(MTAToolTiers.CELESTITE, 1.0F, -2.8F))));
    public static final DeferredItem<ShovelItem> ANGELIC_SHOVEL = ITEMS.register("angelic_shovel", () -> new ShovelItem(MTAToolTiers.CELESTITE, new Item.Properties().attributes(ShovelItem.createAttributes(MTAToolTiers.CELESTITE, 1.5F, -3F))));

    public static final DeferredItem<PickaxeItem> BERSERK_PICKAXE = ITEMS.register("berserk_pickaxe", () -> new PickaxeItem(MTAToolTiers.GARNET, new Item.Properties().attributes(PickaxeItem.createAttributes(MTAToolTiers.GARNET, 1.0F, -2.8F))));
    public static final DeferredItem<AxeItem> BERSERK_AXE = ITEMS.register("berserk_axe", () -> new AxeItem(MTAToolTiers.GARNET, new Item.Properties().attributes(AxeItem.createAttributes(MTAToolTiers.GARNET, 1.0F, -2.8F))));
    public static final DeferredItem<ShovelItem> BERSERK_SHOVEL = ITEMS.register("berserk_shovel", () -> new ShovelItem(MTAToolTiers.GARNET, new Item.Properties().attributes(ShovelItem.createAttributes(MTAToolTiers.GARNET, 1.5F, -3F))));

    public static final DeferredItem<PickaxeItem> FEATHERWEIGHT_PICKAXE = ITEMS.register("featherweight_pickaxe", () -> new PickaxeItem(MTAToolTiers.MOONSTONE, new Item.Properties().attributes(PickaxeItem.createAttributes(MTAToolTiers.MOONSTONE, 1.0F, -2.8F))));
    public static final DeferredItem<AxeItem> FEATHERWEIGHT_AXE = ITEMS.register("featherweight_axe", () -> new AxeItem(MTAToolTiers.MOONSTONE, new Item.Properties().attributes(AxeItem.createAttributes(MTAToolTiers.MOONSTONE, 1.0F, -2.8F))));
    public static final DeferredItem<ShovelItem> FEATHERWEIGHT_SHOVEL = ITEMS.register("featherweight_shovel", () -> new ShovelItem(MTAToolTiers.MOONSTONE, new Item.Properties().attributes(ShovelItem.createAttributes(MTAToolTiers.MOONSTONE, 1.5F, -3F))));



    //WEAPONS

    //FOODS
    public static final DeferredItem<Item> ONION = ITEMS.registerSimpleItem("onion", new Item.Properties().food(MtaFoods.ONION));
    public static final DeferredItem<Item> SHRIMP = ITEMS.registerSimpleItem("shrimp", new Item.Properties().food(MtaFoods.SHRIMP));
    public static final DeferredItem<Item> COOKED_SHRIMP = ITEMS.registerSimpleItem("cooked_shrimp", new Item.Properties().food(MtaFoods.COOKED_SHRIMP));
    public static final DeferredItem<Item> TOMATO = ITEMS.registerSimpleItem("tomato", new Item.Properties().food(MtaFoods.TOMATO));
    public static final DeferredItem<Item> TOMATO_SEEDS = ITEMS.registerSimpleItem("tomato_seeds");
    public static final DeferredItem<Item> RED_PEPPER = ITEMS.registerSimpleItem("red_pepper", new Item.Properties().food(MtaFoods.RED_PEPPER));
    public static final DeferredItem<Item> RED_PEPPER_SEEDS = ITEMS.registerSimpleItem("red_pepper_seeds");
    public static final DeferredItem<Item> CHILI_PEPPER = ITEMS.registerSimpleItem("chilli_pepper", new Item.Properties().food(MtaFoods.CHILI_PEPPER));
    public static final DeferredItem<Item> CHILI_PEPPER_SEEDS = ITEMS.registerSimpleItem("chilli_pepper_seeds");
    public static final DeferredItem<Item> RICE = ITEMS.registerSimpleItem("rice", new Item.Properties());
    public static final DeferredItem<Item> ONIGIRI = ITEMS.registerSimpleItem("onigiri", new Item.Properties().food(MtaFoods.ONIGIRI));
    public static final DeferredItem<Item> COCONUT = ITEMS.registerSimpleItem("coconut", new Item.Properties());
    public static final DeferredItem<Item> COCONUT_MILK = ITEMS.registerSimpleItem("coconut_milk", new Item.Properties());
    public static final DeferredItem<Item> COCONUT_SLICE = ITEMS.registerSimpleItem("coconut_slice", new Item.Properties().food(MtaFoods.COCONUT_SLICE));
    public static final DeferredItem<Item> SPICE_MIX = ITEMS.registerSimpleItem("spice_mix", new Item.Properties());
    public static final DeferredItem<Item> SWEET_BEEF_CURRY = ITEMS.registerSimpleItem("sweet_beef_curry", new Item.Properties().food(MtaFoods.SWEET_BEEF_CURRY));
    public static final DeferredItem<Item> SWEET_PORK_CURRY = ITEMS.registerSimpleItem("sweet_pork_curry", new Item.Properties().food(MtaFoods.SWEET_PORK_CURRY));
    public static final DeferredItem<Item> SWEET_CHICKEN_CURRY = ITEMS.registerSimpleItem("sweet_chicken_curry", new Item.Properties().food(MtaFoods.SWEET_CHICKEN_CURRY));
    public static final DeferredItem<Item> SWEET_SHRIMP_CURRY = ITEMS.registerSimpleItem("sweet_shrimp_curry", new Item.Properties().food(MtaFoods.SWEET_SHRIMP_CURRY));
    public static final DeferredItem<Item> MILD_BEEF_CURRY = ITEMS.registerSimpleItem("mild_beef_curry", new Item.Properties().food(MtaFoods.MILD_BEEF_CURRY));
    public static final DeferredItem<Item> MILD_PORK_CURRY = ITEMS.registerSimpleItem("mild_pork_curry", new Item.Properties().food(MtaFoods.MILD_PORK_CURRY));
    public static final DeferredItem<Item> MILD_CHICKEN_CURRY = ITEMS.registerSimpleItem("mild_chicken_curry", new Item.Properties().food(MtaFoods.MILD_CHICKEN_CURRY));
    public static final DeferredItem<Item> MILD_SHRIMP_CURRY = ITEMS.registerSimpleItem("mild_shrimp_curry", new Item.Properties().food(MtaFoods.MILD_SHRIMP_CURRY));
    public static final DeferredItem<Item> SPICY_BEEF_CURRY = ITEMS.registerSimpleItem("spicy_beef_curry", new Item.Properties().food(MtaFoods.SPICY_BEEF_CURRY));
    public static final DeferredItem<Item> SPICY_PORK_CURRY = ITEMS.registerSimpleItem("spicy_pork_curry", new Item.Properties().food(MtaFoods.SPICY_PORK_CURRY));
    public static final DeferredItem<Item> SPICY_CHICKEN_CURRY = ITEMS.registerSimpleItem("spicy_chicken_curry", new Item.Properties().food(MtaFoods.SPICY_CHICKEN_CURRY));
    public static final DeferredItem<Item> SPICY_SHRIMP_CURRY = ITEMS.registerSimpleItem("spicy_shrimp_curry", new Item.Properties().food(MtaFoods.SPICY_SHRIMP_CURRY));




    // SPAWN EGGS
    public static final DeferredItem<Item> YUKI_ONNA_SPAWN_EGG =  ITEMS.register("yuki_onna_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.YUKI_ONNA::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> FALLEN_SAMURAI_SPAWN_EGG =  ITEMS.register("fallen_samurai_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.FALLEN_SAMURAI::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> BUTTERFLY_SPAWN_EGG =  ITEMS.register("butterfly_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.BUTTERFLY::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> BEARDED_DRAGON_SPAWN_EGG =  ITEMS.register("bearded_dragon_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.BEARDED_DRAGON::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> CAPYBARA_SPAWN_EGG =  ITEMS.register("capybara_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.CAPIBARA::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> DUCK_SPAWN_EGG =  ITEMS.register("duck_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.DUCK::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> FERRET_SPAWN_EGG =  ITEMS.register("ferret_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.FERRET::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> GREAT_WHITE_SHARK_SPAWN_EGG =  ITEMS.register("great_white_shark_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.GREAT_WHITE_SHARK::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> HORSESHOE_CRAB_SPAWN_EGG =  ITEMS.register("horseshoe_crab_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.HORSESHOE_CRAB::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> JELLYFISH_SPAWN_EGG =  ITEMS.register("jellyfish_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.JELLYFISH::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> OCTOPUS_SPAWN_EGG =  ITEMS.register("octopus_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.OCTOPUS::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> OWL_SPAWN_EGG =  ITEMS.register("owl_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.OWL::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> PENGUIN_SPAWN_EGG =  ITEMS.register("penguin_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.PENGUIN::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> RACCOON_SPAWN_EGG =  ITEMS.register("raccoon_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.RACCOON::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> SHRIMP_SPAWN_EGG =  ITEMS.register("shrimp_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.SHRIMP::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> TOUCAN_SPAWN_EGG =  ITEMS.register("toucan_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.TOUCAN::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
