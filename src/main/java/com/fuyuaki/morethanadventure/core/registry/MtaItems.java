package com.fuyuaki.morethanadventure.core.registry;

import com.fuyuaki.morethanadventure.world.item.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

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
    public static final DeferredItem<Item> BLOODSTONE = ITEMS.registerSimpleItem("bloodstone", new Item.Properties());
    public static final DeferredItem<Item> CELESTITE = ITEMS.registerSimpleItem("celestite", new Item.Properties());
    public static final DeferredItem<Item> CRYOLITE = ITEMS.registerSimpleItem("cryolite", new Item.Properties());
    public static final DeferredItem<Item> GARNET = ITEMS.registerSimpleItem("garnet", new Item.Properties());
    public static final DeferredItem<Item> MOONSTONE = ITEMS.registerSimpleItem("moonstone", new Item.Properties());

    //AWAKENED GEMS

    public static final DeferredItem<Item> AWAKENED_AGATE = ITEMS.registerSimpleItem("awakened_agate", new Item.Properties());
    public static final DeferredItem<Item> AWAKENED_ALEXANDRITE = ITEMS.registerSimpleItem("awakened_alexandrite", new Item.Properties());
    public static final DeferredItem<Item> AWAKENED_AQUAMARINE = ITEMS.registerSimpleItem("awakened_aquamarine", new Item.Properties());
    public static final DeferredItem<Item> AWAKENED_BLOODSTONE = ITEMS.registerSimpleItem("awakened_bloodstone", new Item.Properties());
    public static final DeferredItem<Item> AWAKENED_CELESTITE = ITEMS.registerSimpleItem("awakened_celestite", new Item.Properties());
    public static final DeferredItem<Item> AWAKENED_CRYOLITE = ITEMS.registerSimpleItem("awakened_cryolite", new Item.Properties());
    public static final DeferredItem<Item> AWAKENED_GARNET = ITEMS.registerSimpleItem("awakened_garnet", new Item.Properties());
    public static final DeferredItem<Item> AWAKENED_MOONSTONE = ITEMS.registerSimpleItem("awakened_moonstone", new Item.Properties());

    //UPGRADES
    public static final DeferredItem<Item> ARMAMENT_UPGRADE = ITEMS.registerSimpleItem("armament_upgrade", new Item.Properties());
    public static final DeferredItem<Item> ROYAL_UPGRADE = ITEMS.registerSimpleItem("royal_upgrade", new Item.Properties());
    public static final DeferredItem<Item> AQUATIC_UPGRADE = ITEMS.registerSimpleItem("aquatic_upgrade", new Item.Properties());
    public static final DeferredItem<Item> DEATHLY_UPGRADE = ITEMS.registerSimpleItem("deathly_upgrade", new Item.Properties());
    public static final DeferredItem<Item> ANGELIC_UPGRADE = ITEMS.registerSimpleItem("angelic_upgrade", new Item.Properties());
    public static final DeferredItem<Item> FREEZING_UPGRADE = ITEMS.registerSimpleItem("freezing_upgrade", new Item.Properties());
    public static final DeferredItem<Item> BERSERK_UPGRADE = ITEMS.registerSimpleItem("berserk_upgrade", new Item.Properties());
    public static final DeferredItem<Item> FEATHERWEIGHT_UPGRADE = ITEMS.registerSimpleItem("featherweight_upgrade", new Item.Properties());

    //ARMOR
    public static final DeferredItem<MTAArmor> GREAT_SENTINELS_HELMET = ITEMS.register("great_sentinel_helmet", () -> new MTAArmor(MtaArmorMats.GREAT_SENTINEL, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(59))));
    public static final DeferredItem<MTAArmor> GREAT_SENTINELS_CHESTPLATE = ITEMS.register("great_sentinel_chestplate", () -> new MTAArmor(MtaArmorMats.GREAT_SENTINEL, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(59))));
    public static final DeferredItem<MTAArmor> GREAT_SENTINELS_LEGGINGS = ITEMS.register("great_sentinel_leggings", () -> new MTAArmor(MtaArmorMats.GREAT_SENTINEL, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(59))));
    public static final DeferredItem<MTAArmor> GREAT_SENTINELS_BOOTS = ITEMS.register("great_sentinel_boots", () -> new MTAArmor(MtaArmorMats.GREAT_SENTINEL, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(59))));

    public static final DeferredItem<MTAArmor> HOLY_KNIGHTS_HELMET = ITEMS.register("holy_knights_helmet", () -> new MTAArmor(MtaArmorMats.HOLY_KNIGHT, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(52))));
    public static final DeferredItem<MTAArmor> HOLY_KNIGHTS_CHESTPLATE = ITEMS.register("holy_knights_chestplate", () -> new MTAArmor(MtaArmorMats.HOLY_KNIGHT, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(52))));
    public static final DeferredItem<MTAArmor> HOLY_KNIGHTS_LEGGINGS = ITEMS.register("holy_knights_leggings", () -> new MTAArmor(MtaArmorMats.HOLY_KNIGHT, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(52))));
    public static final DeferredItem<MTAArmor> HOLY_KNIGHTS_BOOTS = ITEMS.register("holy_knights_boots", () -> new MTAArmor(MtaArmorMats.HOLY_KNIGHT, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(52))));

    public static final DeferredItem<MTAArmor> MYSTIC_MERMAIDS_HELMET = ITEMS.register("mystic_mermaids_helmet", () -> new MTAArmor(MtaArmorMats.MYSTIC_MERMAID, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(49))));
    public static final DeferredItem<MTAArmor> MYSTIC_MERMAIDS_CHESTPLATE = ITEMS.register("mystic_mermaids_chestplate", () -> new MTAArmor(MtaArmorMats.MYSTIC_MERMAID, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(49))));
    public static final DeferredItem<MTAArmor> MYSTIC_MERMAIDS_LEGGINGS = ITEMS.register("mystic_mermaids_leggings", () -> new MTAArmor(MtaArmorMats.MYSTIC_MERMAID, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(49))));
    public static final DeferredItem<MTAArmor> MYSTIC_MERMAIDS_BOOTS = ITEMS.register("mystic_mermaids_boots", () -> new MTAArmor(MtaArmorMats.MYSTIC_MERMAID, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(49))));

    public static final DeferredItem<MTAArmor> SILENT_REAPERS_HELMET = ITEMS.register("silent_reapers_helmet", () -> new MTAArmor(MtaArmorMats.SILENT_REAPER, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(41))));
    public static final DeferredItem<MTAArmor> SILENT_REAPERS_CHESTPLATE = ITEMS.register("silent_reapers_chestplate", () -> new MTAArmor(MtaArmorMats.SILENT_REAPER, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(41))));
    public static final DeferredItem<MTAArmor> SILENT_REAPERS_LEGGINGS = ITEMS.register("silent_reapers_leggings", () -> new MTAArmor(MtaArmorMats.SILENT_REAPER, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(41))));
    public static final DeferredItem<MTAArmor> SILENT_REAPERS_BOOTS = ITEMS.register("silent_reapers_boots", () -> new MTAArmor(MtaArmorMats.SILENT_REAPER, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(41))));

    public static final DeferredItem<MTAArmor> TEMPLE_ANGELS_HELMET = ITEMS.register("temple_angels_helmet", () -> new MTAArmor(MtaArmorMats.TEMPLE_ANGEL, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(45))));
    public static final DeferredItem<MTAArmor> TEMPLE_ANGELS_CHESTPLATE = ITEMS.register("temple_angels_chestplate", () -> new MTAArmor(MtaArmorMats.TEMPLE_ANGEL, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(45))));
    public static final DeferredItem<MTAArmor> TEMPLE_ANGELS_LEGGINGS = ITEMS.register("temple_angels_leggings", () -> new MTAArmor(MtaArmorMats.TEMPLE_ANGEL, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(45))));
    public static final DeferredItem<MTAArmor> TEMPLE_ANGELS_BOOTS = ITEMS.register("temple_angels_boots", () -> new MTAArmor(MtaArmorMats.TEMPLE_ANGEL, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(45))));

    public static final DeferredItem<MTAArmor> COLD_SET_HELMET = ITEMS.register("cold_set_helmet", () -> new MTAArmor(MtaArmorMats.COLD_SET, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(45))));
    public static final DeferredItem<MTAArmor> COLD_SET_CHESTPLATE = ITEMS.register("cold_set_chestplate", () -> new MTAArmor(MtaArmorMats.COLD_SET, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(45))));
    public static final DeferredItem<MTAArmor> COLD_SET_LEGGINGS = ITEMS.register("cold_set_leggings", () -> new MTAArmor(MtaArmorMats.COLD_SET, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(45))));
    public static final DeferredItem<MTAArmor> COLD_SET_BOOTS = ITEMS.register("cold_set_boots", () -> new MTAArmor(MtaArmorMats.COLD_SET, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(45))));

    public static final DeferredItem<MTAArmor> WRATHFUL_BERSERKERS_HELMET = ITEMS.register("wrathful_berserkers_helmet", () -> new MTAArmor(MtaArmorMats.WRATHFUL_BERSERKER, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(43))));
    public static final DeferredItem<MTAArmor> WRATHFUL_BERSERKERS_CHESTPLATE = ITEMS.register("wrathful_berserkers_chestplate", () -> new MTAArmor(MtaArmorMats.WRATHFUL_BERSERKER, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(43))));
    public static final DeferredItem<MTAArmor> WRATHFUL_BERSERKERS_LEGGINGS = ITEMS.register("wrathful_berserkers_leggings", () -> new MTAArmor(MtaArmorMats.WRATHFUL_BERSERKER, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(43))));
    public static final DeferredItem<MTAArmor> WRATHFUL_BERSERKERS_BOOTS = ITEMS.register("wrathful_berserkers_boots", () -> new MTAArmor(MtaArmorMats.WRATHFUL_BERSERKER, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant().durability(ArmorItem.Type.BOOTS.getDurability(43))));

    public static final DeferredItem<MTAArmor> SHADOW_ROGUES_HELMET = ITEMS.register("shadow_rogues_helmet", () -> new MTAArmor(MtaArmorMats.SHADOW_ROGUE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant().durability(ArmorItem.Type.HELMET.getDurability(39))));
    public static final DeferredItem<MTAArmor> SHADOW_ROGUES_CHESTPLATE = ITEMS.register("shadow_rogues_chestplate", () -> new MTAArmor(MtaArmorMats.SHADOW_ROGUE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorItem.Type.CHESTPLATE.getDurability(39))));
    public static final DeferredItem<MTAArmor> SHADOW_ROGUES_LEGGINGS = ITEMS.register("shadow_rogues_leggings", () -> new MTAArmor(MtaArmorMats.SHADOW_ROGUE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorItem.Type.LEGGINGS.getDurability(39))));
    public static final DeferredItem<MTAArmor> SHADOW_ROGUES_BOOTS = ITEMS.register("shadow_rogues_boots", () -> new MTAArmor(MtaArmorMats.SHADOW_ROGUE, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(39))));


    public static final DeferredItem<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(MTAToolTiers.COPPER, new Item.Properties().attributes(PickaxeItem.createAttributes(MTAToolTiers.COPPER, 1.0F, -2.8F))));
    public static final DeferredItem<AxeItem> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(MTAToolTiers.COPPER, new Item.Properties().attributes(AxeItem.createAttributes(MTAToolTiers.COPPER, 1.0F, -2.8F))));
    public static final DeferredItem<ShovelItem> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(MTAToolTiers.COPPER, new Item.Properties().attributes(ShovelItem.createAttributes(MTAToolTiers.COPPER, 1.5F, -3F))));
    public static final DeferredItem<HoeItem> COPPER_HOE = ITEMS.register("copper_hoe", () -> new HoeItem(MTAToolTiers.COPPER, new Item.Properties().attributes(HoeItem.createAttributes(MTAToolTiers.COPPER, 1.5F, -3F))));


    public static final DeferredItem<PickaxeItem> NETHERSTEEL_PICKAXE = ITEMS.register("nethersteel_pickaxe", () -> new PickaxeItem(MTAToolTiers.NETHERSTEEL, new Item.Properties().attributes(PickaxeItem.createAttributes(MTAToolTiers.NETHERSTEEL, 1.0F, -2.8F))));
    public static final DeferredItem<AxeItem> NETHERSTEEL_AXE = ITEMS.register("nethersteel_axe", () -> new AxeItem(MTAToolTiers.NETHERSTEEL, new Item.Properties().attributes(AxeItem.createAttributes(MTAToolTiers.NETHERSTEEL, 1.5F, -2.8F))));
    public static final DeferredItem<ShovelItem> NETHERSTEEL_SHOVEL = ITEMS.register("nethersteel_shovel", () -> new ShovelItem(MTAToolTiers.NETHERSTEEL, new Item.Properties().attributes(ShovelItem.createAttributes(MTAToolTiers.NETHERSTEEL, 1.5F, -3F))));
    public static final DeferredItem<HoeItem> NETHERSTEEL_HOE = ITEMS.register("nethersteel_hoe", () -> new HoeItem(MTAToolTiers.NETHERSTEEL, new Item.Properties().attributes(HoeItem.createAttributes(MTAToolTiers.NETHERSTEEL, 1.5F, -3F))));



    //WEAPONS
    public static final DeferredItem<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword", () -> new SwordItem(MTAToolTiers.COPPER, new Item.Properties().attributes(SwordItem.createAttributes(MTAToolTiers.COPPER, 3.0F, -2.4F))));
    public static final DeferredItem<SwordItem> NETHERSTEEL_SWORD = ITEMS.register("nethersteel_sword", () -> new SwordItem(MTAToolTiers.NETHERSTEEL, new Item.Properties().attributes(SwordItem.createAttributes(MTAToolTiers.NETHERSTEEL, 3.0F, -2.4F))));
    public static final DeferredItem<NetheriteTridentItem> NETHERITE_TRIDENT = ITEMS.register("netherite_trident", () -> new NetheriteTridentItem( new Item.Properties().durability(2031).attributes(NetheriteTridentItem.createAttributes()).component(DataComponents.TOOL, NetheriteTridentItem.createToolProperties())));
    public static final DeferredItem<NetheriteBowItem> NETHERITE_BOW = ITEMS.register("netherite_bow", () -> new NetheriteBowItem( new Item.Properties().durability(2031)));

    //SPECIAL WEAPONS
    public static final DeferredItem<SentinelsWarHammerItem> GREAT_SENTINELS_WAR_HAMMER = ITEMS.register("great_sentinels_war_hammer",
            () -> new SentinelsWarHammerItem(
                    new Item.Properties()
                            .durability(8192)
                            .component(DataComponents.TOOL, SentinelsWarHammerItem.createToolProperties())
            ));

    public static final DeferredItem<KnightGreatswordItem> HOLY_KNIGHTS_GREATSWORD = ITEMS.register("holy_knights_greatsword",
            () -> new KnightGreatswordItem(MTAToolTiers.ALEXANDRITE,
                    new Item.Properties()
            ));
    public static final DeferredItem<MermaidTridentItem> MYSTIC_MERMAIDS_TRIDENT = ITEMS.register("mystic_mermaids_trident",
            () -> new MermaidTridentItem(
                    new Item.Properties()
                            .durability(7108)
                            .attributes(MermaidTridentItem.createAttributes())
            ));
    public static final DeferredItem<ReaperScytheItem> SILENT_REAPERS_SCYTHE = ITEMS.register("silent_reaper_scythe",
            () -> new ReaperScytheItem(MTAToolTiers.BLOODSTONE,
                    new Item.Properties()
            ));
    public static final DeferredItem<AngelBowItem> TEMPLE_ANGELS_BOW = ITEMS.register("temple_angels_bow",
            () -> new AngelBowItem(
                    new Item.Properties()
                            .durability(6760)
            ));
    public static final DeferredItem<SwordItem> COLD_SET_WEAPON = ITEMS.register("cold_set_weapon",
            () -> new SwordItem(MTAToolTiers.CRYOLITE,
                    new Item.Properties()
                            .durability(6760)
            ));
    public static final DeferredItem<BerserkerBattleAxeItem> WRATHFUL_BERSERKERS_BATTLEAXE = ITEMS.register("wrathful_berserkers_battleaxe",
            () -> new BerserkerBattleAxeItem(MTAToolTiers.GARNET,
                    new Item.Properties()
            ));
    public static final DeferredItem<RogueDaggerItem> SHADOW_ROGUES_DAGGER = ITEMS.register("shadow_rogues_dagger",
            () -> new RogueDaggerItem(MTAToolTiers.MOONSTONE,
                    new Item.Properties()
            ));



    //FOODS
    public static final DeferredItem<Item> ONION = ITEMS.register("onion", () -> new ItemNameBlockItem(MtaBlocks.ONION_CROP.get(), new Item.Properties().food(MtaFoods.ONION)));
    public static final DeferredItem<Item> SHRIMP = ITEMS.registerSimpleItem("shrimp", new Item.Properties().food(MtaFoods.SHRIMP));
    public static final DeferredItem<Item> COOKED_SHRIMP = ITEMS.registerSimpleItem("cooked_shrimp", new Item.Properties().food(MtaFoods.COOKED_SHRIMP));
    public static final DeferredItem<Item> TOMATO = ITEMS.registerSimpleItem("tomato", new Item.Properties().food(MtaFoods.TOMATO));
    public static final DeferredItem<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds", () -> new ItemNameBlockItem(MtaBlocks.TOMATO_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> BELL_PEPPER = ITEMS.registerSimpleItem("bell_pepper", new Item.Properties().food(MtaFoods.BELL_PEPPER));
    public static final DeferredItem<Item> BELL_PEPPER_SEEDS = ITEMS.register("bell_pepper_seeds", () -> new ItemNameBlockItem(MtaBlocks.BELL_PEPPER_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> CHILI_PEPPER = ITEMS.registerSimpleItem("chili_pepper", new Item.Properties().food(MtaFoods.CHILI_PEPPER));
    public static final DeferredItem<Item> CHILI_PEPPER_SEEDS = ITEMS.register("chili_pepper_seeds", () -> new ItemNameBlockItem(MtaBlocks.CHILI_PEPPER_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> RICE = ITEMS.registerSimpleItem("rice", new Item.Properties());
    public static final DeferredItem<Item> ONIGIRI = ITEMS.registerSimpleItem("onigiri", new Item.Properties().food(MtaFoods.ONIGIRI));
    public static final DeferredItem<Item> COCONUT = ITEMS.register("coconut", () -> new ItemNameBlockItem(MtaBlocks.PALM_SAPLING.get(), new Item.Properties()));
    public static final DeferredItem<Item> COCONUT_MILK = ITEMS.registerItem("coconut_milk", CoconutMilkItem::new, new Item.Properties().food(MtaFoods.COCONUT_MILK));
    public static final DeferredItem<Item> COCONUT_SLICE = ITEMS.registerSimpleItem("coconut_slice", new Item.Properties().food(MtaFoods.COCONUT_SLICE));
    public static final DeferredItem<Item> SPICE_MIX = ITEMS.registerSimpleItem("spice_mix", new Item.Properties());
    public static final DeferredItem<Item> SWEET_BEEF_CURRY = ITEMS.registerSimpleItem("sweet_beef_curry", new Item.Properties().food(MtaFoods.SWEET_BEEF_CURRY).stacksTo(1));
    public static final DeferredItem<Item> SWEET_PORK_CURRY = ITEMS.registerSimpleItem("sweet_pork_curry", new Item.Properties().food(MtaFoods.SWEET_PORK_CURRY).stacksTo(1));
    public static final DeferredItem<Item> SWEET_CHICKEN_CURRY = ITEMS.registerSimpleItem("sweet_chicken_curry", new Item.Properties().food(MtaFoods.SWEET_CHICKEN_CURRY).stacksTo(1));
    public static final DeferredItem<Item> SWEET_SHRIMP_CURRY = ITEMS.registerSimpleItem("sweet_shrimp_curry", new Item.Properties().food(MtaFoods.SWEET_SHRIMP_CURRY).stacksTo(1));
    public static final DeferredItem<Item> MILD_BEEF_CURRY = ITEMS.registerSimpleItem("mild_beef_curry", new Item.Properties().food(MtaFoods.MILD_BEEF_CURRY).stacksTo(1));
    public static final DeferredItem<Item> MILD_PORK_CURRY = ITEMS.registerSimpleItem("mild_pork_curry", new Item.Properties().food(MtaFoods.MILD_PORK_CURRY).stacksTo(1));
    public static final DeferredItem<Item> MILD_CHICKEN_CURRY = ITEMS.registerSimpleItem("mild_chicken_curry", new Item.Properties().food(MtaFoods.MILD_CHICKEN_CURRY).stacksTo(1));
    public static final DeferredItem<Item> MILD_SHRIMP_CURRY = ITEMS.registerSimpleItem("mild_shrimp_curry", new Item.Properties().food(MtaFoods.MILD_SHRIMP_CURRY).stacksTo(1));
    public static final DeferredItem<Item> SPICY_BEEF_CURRY = ITEMS.registerSimpleItem("spicy_beef_curry", new Item.Properties().food(MtaFoods.SPICY_BEEF_CURRY).stacksTo(1));
    public static final DeferredItem<Item> SPICY_PORK_CURRY = ITEMS.registerSimpleItem("spicy_pork_curry", new Item.Properties().food(MtaFoods.SPICY_PORK_CURRY).stacksTo(1));
    public static final DeferredItem<Item> SPICY_CHICKEN_CURRY = ITEMS.registerSimpleItem("spicy_chicken_curry", new Item.Properties().food(MtaFoods.SPICY_CHICKEN_CURRY).stacksTo(1));
    public static final DeferredItem<Item> SPICY_SHRIMP_CURRY = ITEMS.registerSimpleItem("spicy_shrimp_curry", new Item.Properties().food(MtaFoods.SPICY_SHRIMP_CURRY).stacksTo(1));




    // SPAWN EGGS
    public static final DeferredItem<Item> YUKI_ONNA_SPAWN_EGG =  ITEMS.register("yuki_onna_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.YUKI_ONNA::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> FALLEN_SAMURAI_SPAWN_EGG =  ITEMS.register("fallen_samurai_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.FALLEN_SAMURAI::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> ICICLE_CREEPER_SPAWN_EGG =  ITEMS.register("icicle_creeper_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.ICICLE_CREEPER::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

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

    public static final DeferredItem<Item> WITHER_JUGGERNAUT_SPAWN_EGG =  ITEMS.register("wither_juggernaut_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.WITHER_JUGGERNAUT::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> ARMORED_SKELETON_SPAWN_EGG =  ITEMS.register("armored_skeleton_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.ARMORED_SKELETON::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> BLACK_WIDOW_SPAWN_EGG =  ITEMS.register("black_widow_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.BLACK_WIDOW::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> CHARRED_SKELETON_SPAWN_EGG =  ITEMS.register("charred_skeleton_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.CHARRED_SKELETON::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> CORROSIVE_CUBE_SPAWN_EGG =  ITEMS.register("corrosive_cube_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.CORROSIVE_CUBE::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> FROZEN_SLIME_SPAWN_EGG =  ITEMS.register("frozen_slime_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.FROZEN_SLIME::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> GLOW_SPIDER_SPAWN_EGG =  ITEMS.register("glow_spider_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.GLOW_SPIDER::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> HOST_SPAWN_EGG =  ITEMS.register("host_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.HOST::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> MOSSY_ZOMBIE_SPAWN_EGG =  ITEMS.register("mossy_zombie_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.MOSSY_ZOMBIE::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> SKELETON_FIGHTER_SPAWN_EGG =  ITEMS.register("skeleton_fighter_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.SKELETON_FIGHTER::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> TOXIC_ZOMBIE_SPAWN_EGG =  ITEMS.register("toxic_zombie_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.TOXIC_ZOMBIE::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> ZOMBIFIED_MINER_SPAWN_EGG =  ITEMS.register("zombified_miner_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.ZOMBIFIED_MINER::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }



    /*
    >>>>TEMPLATES<<<<

    // PLACEHOLDER GEAR
    public static final DeferredItem<MTAArmor> PLACEHOLDER_HELMET = ITEMS.register("placeholder_helmet", () -> new MTAArmor(MtaArmorMats.PLACEHOLDER, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(DURABILITY))));
    public static final DeferredItem<MTAArmor> PLACEHOLDER_CHESTPLATE = ITEMS.register("placeholder_chestplate", () -> new MTAArmor(MtaArmorMats.PLACEHOLDER, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(DURABILITY))));
    public static final DeferredItem<MTAArmor> PLACEHOLDER_LEGGINGS = ITEMS.register("placeholder_leggings", () -> new MTAArmor(MtaArmorMats.PLACEHOLDER, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(DURABILITY))));
    public static final DeferredItem<MTAArmor> PLACEHOLDER_BOOTS = ITEMS.register("placeholder_boots", () -> new MTAArmor(MtaArmorMats.PLACEHOLDER, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(DURABILITY))));

    public static final DeferredItem<PickaxeItem> PLACEHOLDER_PICKAXE = ITEMS.register("placeholder_pickaxe", () -> new PickaxeItem(MTAToolTiers.PLACEHOLDER, new Item.Properties().attributes(PickaxeItem.createAttributes(MTAToolTiers.PLACEHOLDER, 1.0F, -2.8F))));
    public static final DeferredItem<AxeItem> PLACEHOLDER_AXE = ITEMS.register("placeholder_axe", () -> new AxeItem(MTAToolTiers.PLACEHOLDER, new Item.Properties().fireResistant().rarity(Rarity.EPIC).attributes(AxeItem.createAttributes(MTAToolTiers.PLACEHOLDER, 1.0F, -2.8F))));
    public static final DeferredItem<ShovelItem> PLACEHOLDER_SHOVEL = ITEMS.register("placeholder_shovel", () -> new ShovelItem(MTAToolTiers.PLACEHOLDER, new Item.Properties().attributes(ShovelItem.createAttributes(MTAToolTiers.PLACEHOLDER, 1.5F, -3F))));
    public static final DeferredItem<HoeItem> PLACEHOLDER_HOE = ITEMS.register("placeholder_hoe", () -> new HoeItem(MTAToolTiers.PLACEHOLDER, new Item.Properties().attributes(HoeItem.createAttributes(MTAToolTiers.PLACEHOLDER, 1.5F, -3F))));

    public static final DeferredItem<SwordItem> PLACEHOLDER_SWORD = ITEMS.register("placeholder_sword", () -> new SwordItem(MTAToolTiers.PLACEHOLDER, new Item.Properties().attributes(SwordItem.createAttributes(MTAToolTiers.PLACEHOLDER, 3.0F, -2.4F))));

    public static final DeferredItem<Item> PLACEHOLDER_INGOT = ITEMS.registerSimpleItem("placeholder_ingot");
    public static final DeferredItem<Item> RAW_PLACEHOLDER = ITEMS.registerSimpleItem("raw_placeholder");
    public static final DeferredItem<Item> PLACEHOLDER_NUGGET = ITEMS.registerSimpleItem("placeholder_nugget");
    public static final DeferredItem<Item> PLACEHOLDER = ITEMS.registerSimpleItem("placeholder");

     */
}
