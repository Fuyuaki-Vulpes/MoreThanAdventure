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

    public static final DeferredItem<Item> AWAKENED_AGATE = ITEMS.registerSimpleItem("awakened_agate", new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final DeferredItem<Item> AWAKENED_ALEXANDRITE = ITEMS.registerSimpleItem("awakened_alexandrite", new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final DeferredItem<Item> AWAKENED_AQUAMARINE = ITEMS.registerSimpleItem("awakened_aquamarine", new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final DeferredItem<Item> AWAKENED_BLOODSTONE = ITEMS.registerSimpleItem("awakened_bloodstone", new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final DeferredItem<Item> AWAKENED_CELESTITE = ITEMS.registerSimpleItem("awakened_celestite", new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final DeferredItem<Item> AWAKENED_CRYOLITE = ITEMS.registerSimpleItem("awakened_cryolite", new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final DeferredItem<Item> AWAKENED_GARNET = ITEMS.registerSimpleItem("awakened_garnet", new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final DeferredItem<Item> AWAKENED_MOONSTONE = ITEMS.registerSimpleItem("awakened_moonstone", new Item.Properties().component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));

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
    public static final DeferredItem<SwordItem> FREEZING_ICICLE_SPEAR = ITEMS.register("freezing_icicle_spear",
            () -> new FreezingIcicleSpearItem(MTAToolTiers.CRYOLITE,
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
    public static final DeferredItem<SwordItem> WOOD_CLAW = ITEMS.register("wood_claw",
            () -> new SwordItem(Tiers.WOOD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> WOOD_CLAYMORE = ITEMS.register("wood_claymore",
            () -> new SwordItem(Tiers.WOOD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> WOOD_CUTLASS = ITEMS.register("wood_cutlass",
            () -> new SwordItem(Tiers.WOOD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> WOOD_DAGGER = ITEMS.register("wood_dagger",
            () -> new SwordItem(Tiers.WOOD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> WOOD_DOUBLE_AXE = ITEMS.register("wood_double_axe",
            () -> new SwordItem(Tiers.WOOD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> WOOD_GLAIVE = ITEMS.register("wood_glaive",
            () -> new SwordItem(Tiers.WOOD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> WOOD_HALBERD = ITEMS.register("wood_halberd",
            () -> new SwordItem(Tiers.WOOD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> WOOD_KATANA = ITEMS.register("wood_katana",
            () -> new SwordItem(Tiers.WOOD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> WOOD_SCYTHE = ITEMS.register("wood_scythe",
            () -> new SwordItem(Tiers.WOOD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> WOOD_SPEAR = ITEMS.register("wood_spear",
            () -> new SwordItem(Tiers.WOOD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> WOOD_TWINBLADE = ITEMS.register("wood_twinblade",
            () -> new SwordItem(Tiers.WOOD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> STONE_CLAW = ITEMS.register("stone_claw",
            () -> new SwordItem(Tiers.STONE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> STONE_CLAYMORE = ITEMS.register("stone_claymore",
            () -> new SwordItem(Tiers.STONE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> STONE_CUTLASS = ITEMS.register("stone_cutlass",
            () -> new SwordItem(Tiers.STONE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> STONE_DAGGER = ITEMS.register("stone_dagger",
            () -> new SwordItem(Tiers.STONE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> STONE_DOUBLE_AXE = ITEMS.register("stone_double_axe",
            () -> new SwordItem(Tiers.STONE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> STONE_GLAIVE = ITEMS.register("stone_glaive",
            () -> new SwordItem(Tiers.STONE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> STONE_HALBERD = ITEMS.register("stone_halberd",
            () -> new SwordItem(Tiers.STONE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> STONE_KATANA = ITEMS.register("stone_katana",
            () -> new SwordItem(Tiers.STONE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> STONE_SCYTHE = ITEMS.register("stone_scythe",
            () -> new SwordItem(Tiers.STONE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> STONE_SPEAR = ITEMS.register("stone_spear",
            () -> new SwordItem(Tiers.STONE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> STONE_TWINBLADE = ITEMS.register("stone_twinblade",
            () -> new SwordItem(Tiers.STONE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(MTAToolTiers.COPPER,
                    new Item.Properties().attributes(SwordItem.createAttributes(MTAToolTiers.COPPER, 3.0F, -2.4F))));

    public static final DeferredItem<SwordItem> COPPER_CLAW = ITEMS.register("copper_claw",
            () -> new SwordItem(MTAToolTiers.COPPER,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> COPPER_CLAYMORE = ITEMS.register("copper_claymore",
            () -> new SwordItem(MTAToolTiers.COPPER,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> COPPER_CUTLASS = ITEMS.register("copper_cutlass",
            () -> new SwordItem(MTAToolTiers.COPPER,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> COPPER_DAGGER = ITEMS.register("copper_dagger",
            () -> new SwordItem(MTAToolTiers.COPPER,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> COPPER_DOUBLE_AXE = ITEMS.register("copper_double_axe",
            () -> new SwordItem(MTAToolTiers.COPPER,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> COPPER_GLAIVE = ITEMS.register("copper_glaive",
            () -> new SwordItem(MTAToolTiers.COPPER,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> COPPER_HALBERD = ITEMS.register("copper_halberd",
            () -> new SwordItem(MTAToolTiers.COPPER,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> COPPER_KATANA = ITEMS.register("copper_katana",
            () -> new SwordItem(MTAToolTiers.COPPER,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> COPPER_SCYTHE = ITEMS.register("copper_scythe",
            () -> new SwordItem(MTAToolTiers.COPPER,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> COPPER_SPEAR = ITEMS.register("copper_spear",
            () -> new SwordItem(MTAToolTiers.COPPER,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> COPPER_TWINBLADE = ITEMS.register("copper_twinblade",
            () -> new SwordItem(MTAToolTiers.COPPER,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> IRON_CLAW = ITEMS.register("iron_claw",
            () -> new SwordItem(Tiers.IRON,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> IRON_CLAYMORE = ITEMS.register("iron_claymore",
            () -> new SwordItem(Tiers.IRON,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> IRON_CUTLASS = ITEMS.register("iron_cutlass",
            () -> new SwordItem(Tiers.IRON,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> IRON_DAGGER = ITEMS.register("iron_dagger",
            () -> new SwordItem(Tiers.IRON,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> IRON_DOUBLE_AXE = ITEMS.register("iron_double_axe",
            () -> new SwordItem(Tiers.IRON,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> IRON_GLAIVE = ITEMS.register("iron_glaive",
            () -> new SwordItem(Tiers.IRON,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> IRON_HALBERD = ITEMS.register("iron_halberd",
            () -> new SwordItem(Tiers.IRON,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> IRON_KATANA = ITEMS.register("iron_katana",
            () -> new SwordItem(Tiers.IRON,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> IRON_SCYTHE = ITEMS.register("iron_scythe",
            () -> new SwordItem(Tiers.IRON,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> IRON_SPEAR = ITEMS.register("iron_spear",
            () -> new SwordItem(Tiers.IRON,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> IRON_TWINBLADE = ITEMS.register("iron_twinblade",
            () -> new SwordItem(Tiers.IRON,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> GOLD_CLAW = ITEMS.register("gold_claw",
            () -> new SwordItem(Tiers.GOLD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> GOLD_CLAYMORE = ITEMS.register("gold_claymore",
            () -> new SwordItem(Tiers.GOLD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> GOLD_CUTLASS = ITEMS.register("gold_cutlass",
            () -> new SwordItem(Tiers.GOLD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> GOLD_DAGGER = ITEMS.register("gold_dagger",
            () -> new SwordItem(Tiers.GOLD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> GOLD_DOUBLE_AXE = ITEMS.register("gold_double_axe",
            () -> new SwordItem(Tiers.GOLD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> GOLD_GLAIVE = ITEMS.register("gold_glaive",
            () -> new SwordItem(Tiers.GOLD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> GOLD_HALBERD = ITEMS.register("gold_halberd",
            () -> new SwordItem(Tiers.GOLD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> GOLD_KATANA = ITEMS.register("gold_katana",
            () -> new SwordItem(Tiers.GOLD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> GOLD_SCYTHE = ITEMS.register("gold_scythe",
            () -> new SwordItem(Tiers.GOLD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> GOLD_SPEAR = ITEMS.register("gold_spear",
            () -> new SwordItem(Tiers.GOLD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> GOLD_TWINBLADE = ITEMS.register("gold_twinblade",
            () -> new SwordItem(Tiers.GOLD,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERSTEEL_SWORD = ITEMS.register("nethersteel_sword",
            () -> new SwordItem(MTAToolTiers.NETHERSTEEL,
                    new Item.Properties().attributes(SwordItem.createAttributes(MTAToolTiers.NETHERSTEEL, 3.0F, -2.4F))));

    public static final DeferredItem<SwordItem> NETHERSTEEL_CLAW = ITEMS.register("nethersteel_claw",
            () -> new SwordItem(MTAToolTiers.NETHERSTEEL,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERSTEEL_CLAYMORE = ITEMS.register("nethersteel_claymore",
            () -> new SwordItem(MTAToolTiers.NETHERSTEEL,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERSTEEL_CUTLASS = ITEMS.register("nethersteel_cutlass",
            () -> new SwordItem(MTAToolTiers.NETHERSTEEL,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERSTEEL_DAGGER = ITEMS.register("nethersteel_dagger",
            () -> new SwordItem(MTAToolTiers.NETHERSTEEL,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERSTEEL_DOUBLE_AXE = ITEMS.register("nethersteel_double_axe",
            () -> new SwordItem(MTAToolTiers.NETHERSTEEL,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERSTEEL_GLAIVE = ITEMS.register("nethersteel_glaive",
            () -> new SwordItem(MTAToolTiers.NETHERSTEEL,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERSTEEL_HALBERD = ITEMS.register("nethersteel_halberd",
            () -> new SwordItem(MTAToolTiers.NETHERSTEEL,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERSTEEL_KATANA = ITEMS.register("nethersteel_katana",
            () -> new SwordItem(MTAToolTiers.NETHERSTEEL,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERSTEEL_SCYTHE = ITEMS.register("nethersteel_scythe",
            () -> new SwordItem(MTAToolTiers.NETHERSTEEL,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERSTEEL_SPEAR = ITEMS.register("nethersteel_spear",
            () -> new SwordItem(MTAToolTiers.NETHERSTEEL,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERSTEEL_TWINBLADE = ITEMS.register("nethersteel_twinblade",
            () -> new SwordItem(MTAToolTiers.NETHERSTEEL,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> DIAMOND_CLAW = ITEMS.register("diamond_claw",
            () -> new SwordItem(Tiers.DIAMOND,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> DIAMOND_CLAYMORE = ITEMS.register("diamond_claymore",
            () -> new SwordItem(Tiers.DIAMOND,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> DIAMOND_CUTLASS = ITEMS.register("diamond_cutlass",
            () -> new SwordItem(Tiers.DIAMOND,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> DIAMOND_DAGGER = ITEMS.register("diamond_dagger",
            () -> new SwordItem(Tiers.DIAMOND,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> DIAMOND_DOUBLE_AXE = ITEMS.register("diamond_double_axe",
            () -> new SwordItem(Tiers.DIAMOND,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> DIAMOND_GLAIVE = ITEMS.register("diamond_glaive",
            () -> new SwordItem(Tiers.DIAMOND,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> DIAMOND_HALBERD = ITEMS.register("diamond_halberd",
            () -> new SwordItem(Tiers.DIAMOND,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> DIAMOND_KATANA = ITEMS.register("diamond_katana",
            () -> new SwordItem(Tiers.DIAMOND,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> DIAMOND_SCYTHE = ITEMS.register("diamond_scythe",
            () -> new SwordItem(Tiers.DIAMOND,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> DIAMOND_SPEAR = ITEMS.register("diamond_spear",
            () -> new SwordItem(Tiers.DIAMOND,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> DIAMOND_TWINBLADE = ITEMS.register("diamond_twinblade",
            () -> new SwordItem(Tiers.DIAMOND,
                    new Item.Properties()
            ));
    public static final DeferredItem<NetheriteTridentItem> NETHERITE_TRIDENT = ITEMS.register("netherite_trident",
            () -> new NetheriteTridentItem(
                    new Item.Properties().durability(2031).attributes(NetheriteTridentItem.createAttributes()).component(DataComponents.TOOL, NetheriteTridentItem.createToolProperties())));
    public static final DeferredItem<NetheriteBowItem> NETHERITE_BOW = ITEMS.register("netherite_bow",
            () -> new NetheriteBowItem(
                    new Item.Properties().durability(2031)));

    public static final DeferredItem<SwordItem> NETHERITE_CLAW = ITEMS.register("netherite_claw",
            () -> new SwordItem(Tiers.NETHERITE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERITE_CLAYMORE = ITEMS.register("netherite_claymore",
            () -> new SwordItem(Tiers.NETHERITE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERITE_CUTLASS = ITEMS.register("netherite_cutlass",
            () -> new SwordItem(Tiers.NETHERITE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERITE_DAGGER = ITEMS.register("netherite_dagger",
            () -> new SwordItem(Tiers.NETHERITE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERITE_DOUBLE_AXE = ITEMS.register("netherite_double_axe",
            () -> new SwordItem(Tiers.NETHERITE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERITE_GLAIVE = ITEMS.register("netherite_glaive",
            () -> new SwordItem(Tiers.NETHERITE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERITE_HALBERD = ITEMS.register("netherite_halberd",
            () -> new SwordItem(Tiers.NETHERITE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERITE_KATANA = ITEMS.register("netherite_katana",
            () -> new SwordItem(Tiers.NETHERITE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERITE_SCYTHE = ITEMS.register("netherite_scythe",
            () -> new SwordItem(Tiers.NETHERITE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERITE_SPEAR = ITEMS.register("netherite_spear",
            () -> new SwordItem(Tiers.NETHERITE,
                    new Item.Properties()
            ));
    public static final DeferredItem<SwordItem> NETHERITE_TWINBLADE = ITEMS.register("netherite_twinblade",
            () -> new SwordItem(Tiers.NETHERITE,
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
            () -> new DeferredSpawnEggItem(MtaEntityTypes.YUKI_ONNA::get,0xfbeeee,0xd2fcff,new Item.Properties()));

    public static final DeferredItem<Item> FALLEN_SAMURAI_SPAWN_EGG =  ITEMS.register("fallen_samurai_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.FALLEN_SAMURAI::get,0xc3c0bc,0x3d3532,new Item.Properties()));

    public static final DeferredItem<Item> ICICLE_CREEPER_SPAWN_EGG =  ITEMS.register("icicle_creeper_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.ICICLE_CREEPER::get,0xe2f0f3,0xb5d6e2,new Item.Properties()));

    public static final DeferredItem<Item> BUTTERFLY_SPAWN_EGG =  ITEMS.register("butterfly_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.BUTTERFLY::get,0xe5c8d1,0x362f33,new Item.Properties()));

    public static final DeferredItem<Item> BEARDED_DRAGON_SPAWN_EGG =  ITEMS.register("bearded_dragon_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.BEARDED_DRAGON::get,0xe5c6af,0xb28375,new Item.Properties()));

    public static final DeferredItem<Item> CAPYBARA_SPAWN_EGG =  ITEMS.register("capybara_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.CAPIBARA::get,0x9a7666,0x896558,new Item.Properties()));

    public static final DeferredItem<Item> DUCK_SPAWN_EGG =  ITEMS.register("duck_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.DUCK::get,0x37a73f,0xef9466,new Item.Properties()));

    public static final DeferredItem<Item> FERRET_SPAWN_EGG =  ITEMS.register("ferret_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.FERRET::get,0xc6a69e,0x634b45,new Item.Properties()));

    public static final DeferredItem<Item> GREAT_WHITE_SHARK_SPAWN_EGG =  ITEMS.register("great_white_shark_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.GREAT_WHITE_SHARK::get,0xa7adb6,0x868e9b,new Item.Properties()));

    public static final DeferredItem<Item> HORSESHOE_CRAB_SPAWN_EGG =  ITEMS.register("horseshoe_crab_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.HORSESHOE_CRAB::get,0xa07962,0x41322c,new Item.Properties()));

    public static final DeferredItem<Item> JELLYFISH_SPAWN_EGG =  ITEMS.register("jellyfish_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.JELLYFISH::get,0xa986c2,0x779fc1,new Item.Properties()));

    public static final DeferredItem<Item> OCTOPUS_SPAWN_EGG =  ITEMS.register("octopus_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.OCTOPUS::get,0xf1936a,0xf7c1aa,new Item.Properties()));

    public static final DeferredItem<Item> OWL_SPAWN_EGG =  ITEMS.register("owl_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.OWL::get,0x715e53,0xc46e1d,new Item.Properties()));

    public static final DeferredItem<Item> PENGUIN_SPAWN_EGG =  ITEMS.register("penguin_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.PENGUIN::get,0x616274,0xdf9f54,new Item.Properties()));

    public static final DeferredItem<Item> RACCOON_SPAWN_EGG =  ITEMS.register("raccoon_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.RACCOON::get,0xb6a09b,0x685655,new Item.Properties()));

    public static final DeferredItem<Item> SHRIMP_SPAWN_EGG =  ITEMS.register("shrimp_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.SHRIMP::get,0xf17f5b,0xf65641,new Item.Properties()));

    public static final DeferredItem<Item> TOUCAN_SPAWN_EGG =  ITEMS.register("toucan_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.TOUCAN::get,0x292731,0xe78a43,new Item.Properties()));

    public static final DeferredItem<Item> WITHER_JUGGERNAUT_SPAWN_EGG =  ITEMS.register("wither_juggernaut_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.WITHER_JUGGERNAUT::get,0x222222,0x51444e,new Item.Properties()));

    public static final DeferredItem<Item> ARMORED_SKELETON_SPAWN_EGG =  ITEMS.register("armored_skeleton_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.ARMORED_SKELETON::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> BLACK_WIDOW_SPAWN_EGG =  ITEMS.register("black_widow_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.BLACK_WIDOW::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> CHARRED_SKELETON_SPAWN_EGG =  ITEMS.register("charred_skeleton_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.CHARRED_SKELETON::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> CORROSIVE_CUBE_SPAWN_EGG =  ITEMS.register("corrosive_cube_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.CORROSIVE_CUBE::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> FROSTED_SLIME_SPAWN_EGG =  ITEMS.register("frosted_slime_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.FROSTED_SLIME::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> GLOW_SPIDER_SPAWN_EGG =  ITEMS.register("glow_spider_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.GLOW_SPIDER::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> HOST_SPAWN_EGG =  ITEMS.register("host_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.HOST::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> MOSSY_ZOMBIE_SPAWN_EGG =  ITEMS.register("mossy_zombie_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.MOSSY_ZOMBIE::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> SKELETON_FIGHTER_SPAWN_EGG =  ITEMS.register("skeleton_fighter_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.SKELETON_FIGHTER::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> TOXIC_ZOMBIE_SPAWN_EGG =  ITEMS.register("toxic_zombie_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.TOXIC_ZOMBIE::get,44975,0x47a80a,new Item.Properties()));

    public static final DeferredItem<Item> ZOMBIFIED_MINER_SPAWN_EGG =  ITEMS.register("zombified_miner_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.ZOMBIFIED_MINER::get,44975,0x24201d,new Item.Properties()));

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
