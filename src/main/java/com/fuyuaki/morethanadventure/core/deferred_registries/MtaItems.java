package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.core.registry.MTAArmorMats;
import com.fuyuaki.morethanadventure.world.item.*;
import com.fuyuaki.morethanadventure.world.item.MTAArmorItem;
import com.fuyuaki.morethanadventure.world.item.accessories.talisman.PistonBootsItem;
import com.fuyuaki.morethanadventure.world.item.accessories.talisman.ScubaGearTalisman;
import com.fuyuaki.morethanadventure.world.item.accessories.TalismanItem;
import com.fuyuaki.morethanadventure.world.item.weaponry.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MtaItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    //ITEMS


    public static final DeferredItem<Item> BIG_BOWL = ITEMS.registerSimpleItem("big_bowl");

    public static final DeferredItem<Item> CLEAR_QUARTZ = ITEMS.registerSimpleItem("clear_quartz");
    public static final DeferredItem<Item> NETHERSTEEL_INGOT = ITEMS.registerSimpleItem("nethersteel_ingot");
    public static final DeferredItem<Item> NETHERITE_FRACTURE = ITEMS.registerSimpleItem("netherite_fracture", new Item.Properties()
            .fireResistant());

    public static final DeferredItem<Item> HOST_HUSK = ITEMS.registerSimpleItem("host_husk");
    public static final DeferredItem<Item> SAMURAI_CLOTH = ITEMS.registerSimpleItem("samurai_cloth");
    public static final DeferredItem<Item> SIREN_SCALE = ITEMS.registerSimpleItem("siren_scale");
    public static final DeferredItem<Item> BLACK_WIDOW_VENOM = ITEMS.registerSimpleItem("black_widow_venom");
    //public static final DeferredItem<Item> FLYING_WING = ITEMS.registerSimpleItem("netherite_fracture");
    public static final DeferredItem<Item> SPIRIT_DUST = ITEMS.registerSimpleItem("spirit_dust");
    public static final DeferredItem<Item> CHARRED_BONE = ITEMS.registerSimpleItem("charred_bone");
    //public static final DeferredItem<Item> SPEEDY_BOI = ITEMS.registerSimpleItem("netherite_fracture");


    //TALISMANS

    public static final DeferredItem<Item> SCUBA_GEAR = ITEMS.registerItem("scuba_gear", ScubaGearTalisman::new);

    public static final DeferredItem<Item> WEIGHTED_DICE = ITEMS.registerItem("weighted_dice", TalismanItem::new);
    public static final DeferredItem<Item> CAT_MASK = ITEMS.registerItem("cat_mask", TalismanItem::new);
    public static final DeferredItem<Item> CLIMBING_CLAWS = ITEMS.registerItem("climbing_claws", TalismanItem::new);
    public static final DeferredItem<Item> PISTON_BOOTS = ITEMS.registerItem("piston_boots", PistonBootsItem::new);
    public static final DeferredItem<Item> REGENERATIVE_TALISMAN = ITEMS.registerItem("regenerative_talisman", TalismanItem::new);
    public static final DeferredItem<Item> SLEEPING_KIT = ITEMS.registerItem("sleeping_kit", TalismanItem::new);
    public static final DeferredItem<Item> STRIDER_BOOTS = ITEMS.registerItem("strider_boots", TalismanItem::new);
    public static final DeferredItem<Item> QUIVER = ITEMS.registerItem("quiver", TalismanItem::new);


    //GEMS

    public static final DeferredItem<Item> AGATE = ITEMS.registerSimpleItem("agate");
    public static final DeferredItem<Item> ALEXANDRITE = ITEMS.registerSimpleItem("alexandrite");
    public static final DeferredItem<Item> AQUAMARINE = ITEMS.registerSimpleItem("aquamarine");
    public static final DeferredItem<Item> BLOODSTONE = ITEMS.registerSimpleItem("bloodstone");
    public static final DeferredItem<Item> CELESTITE = ITEMS.registerSimpleItem("celestite");
    public static final DeferredItem<Item> CRYOLITE = ITEMS.registerSimpleItem("cryolite");
    public static final DeferredItem<Item> GARNET = ITEMS.registerSimpleItem("garnet");
    public static final DeferredItem<Item> MOONSTONE = ITEMS.registerSimpleItem("moonstone");

    //AWAKENED GEMS

    public static final DeferredItem<Item> AWAKENED_AGATE = ITEMS.registerSimpleItem("awakened_agate", new Item.Properties()
            .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final DeferredItem<Item> AWAKENED_ALEXANDRITE = ITEMS.registerSimpleItem("awakened_alexandrite", new Item.Properties()
            .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final DeferredItem<Item> AWAKENED_AQUAMARINE = ITEMS.registerSimpleItem("awakened_aquamarine", new Item.Properties()
            .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final DeferredItem<Item> AWAKENED_BLOODSTONE = ITEMS.registerSimpleItem("awakened_bloodstone", new Item.Properties()
            .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final DeferredItem<Item> AWAKENED_CELESTITE = ITEMS.registerSimpleItem("awakened_celestite", new Item.Properties()
            .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final DeferredItem<Item> AWAKENED_CRYOLITE = ITEMS.registerSimpleItem("awakened_cryolite", new Item.Properties()
            .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final DeferredItem<Item> AWAKENED_GARNET = ITEMS.registerSimpleItem("awakened_garnet", new Item.Properties()
            .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
    public static final DeferredItem<Item> AWAKENED_MOONSTONE = ITEMS.registerSimpleItem("awakened_moonstone", new Item.Properties()
            .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));

    //UPGRADES
    public static final DeferredItem<Item> ARMAMENT_UPGRADE = ITEMS.registerSimpleItem("armament_upgrade");
    public static final DeferredItem<Item> ROYAL_UPGRADE = ITEMS.registerSimpleItem("royal_upgrade");
    public static final DeferredItem<Item> AQUATIC_UPGRADE = ITEMS.registerSimpleItem("aquatic_upgrade");
    public static final DeferredItem<Item> DEATHLY_UPGRADE = ITEMS.registerSimpleItem("deathly_upgrade");
    public static final DeferredItem<Item> ANGELIC_UPGRADE = ITEMS.registerSimpleItem("angelic_upgrade");
    public static final DeferredItem<Item> FREEZING_UPGRADE = ITEMS.registerSimpleItem("freezing_upgrade");
    public static final DeferredItem<Item> BERSERK_UPGRADE = ITEMS.registerSimpleItem("berserk_upgrade");
    public static final DeferredItem<Item> FEATHERWEIGHT_UPGRADE = ITEMS.registerSimpleItem("featherweight_upgrade");

    //ARMOR
    public static final DeferredItem<Item> GREAT_SENTINELS_HELMET = ITEMS.registerItem("great_sentinel_helmet", properties -> new MTAArmorItem(MTAArmorMats.GREAT_SENTINEL, ArmorType.HELMET, properties
            .fireResistant()));
    public static final DeferredItem<Item> GREAT_SENTINELS_CHESTPLATE = ITEMS.registerItem("great_sentinel_chestplate", properties -> new MTAArmorItem(MTAArmorMats.GREAT_SENTINEL, ArmorType.CHESTPLATE, properties
            .fireResistant()));
    public static final DeferredItem<Item> GREAT_SENTINELS_LEGGINGS = ITEMS.registerItem("great_sentinel_leggings", properties -> new MTAArmorItem(MTAArmorMats.GREAT_SENTINEL, ArmorType.LEGGINGS, properties
            .fireResistant()));
    public static final DeferredItem<Item> GREAT_SENTINELS_BOOTS = ITEMS.registerItem("great_sentinel_boots", properties -> new MTAArmorItem(MTAArmorMats.GREAT_SENTINEL, ArmorType.BOOTS, properties
            .fireResistant()));

    public static final DeferredItem<Item> HOLY_KNIGHTS_HELMET = ITEMS.registerItem("holy_knights_helmet", properties -> new MTAArmorItem(MTAArmorMats.HOLY_KNIGHT, ArmorType.HELMET, properties
            .fireResistant()));
    public static final DeferredItem<Item> HOLY_KNIGHTS_CHESTPLATE = ITEMS.registerItem("holy_knights_chestplate", properties -> new MTAArmorItem(MTAArmorMats.HOLY_KNIGHT, ArmorType.CHESTPLATE, properties
            .fireResistant()));
    public static final DeferredItem<Item> HOLY_KNIGHTS_LEGGINGS = ITEMS.registerItem("holy_knights_leggings", properties -> new MTAArmorItem(MTAArmorMats.HOLY_KNIGHT, ArmorType.LEGGINGS, properties
            .fireResistant()));
    public static final DeferredItem<Item> HOLY_KNIGHTS_BOOTS = ITEMS.registerItem("holy_knights_boots", properties -> new MTAArmorItem(MTAArmorMats.HOLY_KNIGHT, ArmorType.BOOTS, properties
            .fireResistant()));

    public static final DeferredItem<Item> MYSTIC_MERMAIDS_HELMET = ITEMS.registerItem("mystic_mermaids_helmet", properties -> new MTAArmorItem(MTAArmorMats.MYSTIC_MERMAID, ArmorType.HELMET, properties
            .fireResistant()));
    public static final DeferredItem<Item> MYSTIC_MERMAIDS_CHESTPLATE = ITEMS.registerItem("mystic_mermaids_chestplate", properties -> new MTAArmorItem(MTAArmorMats.MYSTIC_MERMAID, ArmorType.CHESTPLATE, properties
            .fireResistant()));
    public static final DeferredItem<Item> MYSTIC_MERMAIDS_LEGGINGS = ITEMS.registerItem("mystic_mermaids_leggings", properties -> new MTAArmorItem(MTAArmorMats.MYSTIC_MERMAID, ArmorType.LEGGINGS, properties
            .fireResistant()));
    public static final DeferredItem<Item> MYSTIC_MERMAIDS_BOOTS = ITEMS.registerItem("mystic_mermaids_boots", properties -> new MTAArmorItem(MTAArmorMats.MYSTIC_MERMAID, ArmorType.BOOTS, properties
            .fireResistant()));

    public static final DeferredItem<Item> SILENT_REAPERS_HELMET = ITEMS.registerItem("silent_reapers_helmet", properties -> new MTAArmorItem(MTAArmorMats.SILENT_REAPER, ArmorType.HELMET, properties
            .fireResistant()));
    public static final DeferredItem<Item> SILENT_REAPERS_CHESTPLATE = ITEMS.registerItem("silent_reapers_chestplate", properties -> new MTAArmorItem(MTAArmorMats.SILENT_REAPER, ArmorType.CHESTPLATE, properties
            .fireResistant()));
    public static final DeferredItem<Item> SILENT_REAPERS_LEGGINGS = ITEMS.registerItem("silent_reapers_leggings", properties -> new MTAArmorItem(MTAArmorMats.SILENT_REAPER,ArmorType.LEGGINGS, properties
            .fireResistant()));
    public static final DeferredItem<Item> SILENT_REAPERS_BOOTS = ITEMS.registerItem("silent_reapers_boots", properties -> new MTAArmorItem(MTAArmorMats.SILENT_REAPER, ArmorType.BOOTS, properties
            .fireResistant()));

    public static final DeferredItem<Item> TEMPLE_ANGELS_HELMET = ITEMS.registerItem("temple_angels_helmet", properties -> new MTAArmorItem(MTAArmorMats.TEMPLE_ANGEL, ArmorType.HELMET, properties
            .fireResistant()));
    public static final DeferredItem<Item> TEMPLE_ANGELS_CHESTPLATE = ITEMS.registerItem("temple_angels_chestplate", properties -> new MTAArmorItem(MTAArmorMats.TEMPLE_ANGEL, ArmorType.CHESTPLATE, properties
            .fireResistant()));
    public static final DeferredItem<Item> TEMPLE_ANGELS_LEGGINGS = ITEMS.registerItem("temple_angels_leggings", properties -> new MTAArmorItem(MTAArmorMats.TEMPLE_ANGEL, ArmorType.LEGGINGS, properties
            .fireResistant()));
    public static final DeferredItem<Item> TEMPLE_ANGELS_BOOTS = ITEMS.registerItem("temple_angels_boots", properties -> new MTAArmorItem(MTAArmorMats.TEMPLE_ANGEL, ArmorType.BOOTS, properties
            .fireResistant()));

    public static final DeferredItem<Item> FREEZING_ICICLE_HELMET = ITEMS.registerItem("freezing_icicle_helmet", properties -> new MTAArmorItem(MTAArmorMats.FREEZING_ICICLE, ArmorType.HELMET, properties
            .fireResistant()));
    public static final DeferredItem<Item> FREEZING_ICICLE_CHESTPLATE = ITEMS.registerItem("freezing_icicle_chestplate", properties -> new MTAArmorItem(MTAArmorMats.FREEZING_ICICLE, ArmorType.CHESTPLATE, properties
            .fireResistant()));
    public static final DeferredItem<Item> FREEZING_ICICLE_LEGGINGS = ITEMS.registerItem("freezing_icicle_leggings", properties -> new MTAArmorItem(MTAArmorMats.FREEZING_ICICLE, ArmorType.LEGGINGS, properties
            .fireResistant()));
    public static final DeferredItem<Item> FREEZING_ICICLE_BOOTS = ITEMS.registerItem("freezing_icicle_boots", properties -> new MTAArmorItem(MTAArmorMats.FREEZING_ICICLE, ArmorType.BOOTS, properties
            .fireResistant()));

    public static final DeferredItem<Item> WRATHFUL_BERSERKERS_HELMET = ITEMS.registerItem("wrathful_berserkers_helmet", properties -> new MTAArmorItem(MTAArmorMats.WRATHFUL_BERSERKER, ArmorType.HELMET, properties
            .fireResistant()));
    public static final DeferredItem<Item> WRATHFUL_BERSERKERS_CHESTPLATE = ITEMS.registerItem("wrathful_berserkers_chestplate", properties -> new MTAArmorItem(MTAArmorMats.WRATHFUL_BERSERKER, ArmorType.CHESTPLATE, properties
            .fireResistant()));
    public static final DeferredItem<Item> WRATHFUL_BERSERKERS_LEGGINGS = ITEMS.registerItem("wrathful_berserkers_leggings", properties -> new MTAArmorItem(MTAArmorMats.WRATHFUL_BERSERKER, ArmorType.LEGGINGS, properties
            .fireResistant()));
    public static final DeferredItem<Item> WRATHFUL_BERSERKERS_BOOTS = ITEMS.registerItem("wrathful_berserkers_boots", properties -> new MTAArmorItem(MTAArmorMats.WRATHFUL_BERSERKER, ArmorType.BOOTS, properties
            .fireResistant()));

    public static final DeferredItem<Item> SHADOW_ROGUES_HELMET = ITEMS.registerItem("shadow_rogues_helmet", properties -> new MTAArmorItem(MTAArmorMats.SHADOW_ROGUE, ArmorType.HELMET, properties
            .fireResistant()));
    public static final DeferredItem<Item> SHADOW_ROGUES_CHESTPLATE = ITEMS.registerItem("shadow_rogues_chestplate", properties -> new MTAArmorItem(MTAArmorMats.SHADOW_ROGUE,ArmorType.CHESTPLATE, properties
            .fireResistant()));
    public static final DeferredItem<Item> SHADOW_ROGUES_LEGGINGS = ITEMS.registerItem("shadow_rogues_leggings", properties -> new MTAArmorItem(MTAArmorMats.SHADOW_ROGUE, ArmorType.LEGGINGS, properties.fireResistant()));
    public static final DeferredItem<Item> SHADOW_ROGUES_BOOTS = ITEMS.registerItem("shadow_rogues_boots", properties -> new MTAArmorItem(MTAArmorMats.SHADOW_ROGUE, ArmorType.BOOTS, properties
            .fireResistant()));


    public static final DeferredItem<PickaxeItem> COPPER_PICKAXE = ITEMS.registerItem("copper_pickaxe", properties -> new PickaxeItem(MTAToolMaterials.COPPER, 1.0F, -2.8F, properties
    ));
    public static final DeferredItem<AxeItem> COPPER_AXE = ITEMS.registerItem("copper_axe", properties -> new AxeItem(MTAToolMaterials.COPPER, 1.0F, -2.8F, properties
    ));
    public static final DeferredItem<ShovelItem> COPPER_SHOVEL = ITEMS.registerItem("copper_shovel", properties -> new ShovelItem(MTAToolMaterials.COPPER, 1.5F, -3F, properties
    ));
    public static final DeferredItem<HoeItem> COPPER_HOE = ITEMS.registerItem("copper_hoe", properties -> new HoeItem(MTAToolMaterials.COPPER, 1.5F, -3F, properties
    ));


    public static final DeferredItem<Item> NETHERSTEEL_PICKAXE = ITEMS.registerItem("nethersteel_pickaxe", properties -> new PickaxeItem(MTAToolMaterials.NETHERSTEEL,1.0F, -2.8F, properties
    ));
    public static final DeferredItem<AxeItem> NETHERSTEEL_AXE = ITEMS.registerItem("nethersteel_axe", properties -> new AxeItem(MTAToolMaterials.NETHERSTEEL, 1.5F, -2.8F, properties
    ));
    public static final DeferredItem<ShovelItem> NETHERSTEEL_SHOVEL = ITEMS.registerItem("nethersteel_shovel", properties -> new ShovelItem(MTAToolMaterials.NETHERSTEEL, 1.5F, -3F, properties
    ));
    public static final DeferredItem<HoeItem> NETHERSTEEL_HOE = ITEMS.registerItem("nethersteel_hoe", properties -> new HoeItem(MTAToolMaterials.NETHERSTEEL, 1.5F, -3F, properties
    ));



    //WEAPONS
    public static final DeferredItem<WeaponItem> POLEARM = ITEMS.registerItem("polearm",
            properties -> new WeaponItem(ToolMaterial.WOOD, 2F, -2.5F, 3.5F,
                    properties

            ));

    public static final DeferredItem<ClawItem> WOOD_CLAW = ITEMS.registerItem("wood_claw",
            properties -> new ClawItem(ToolMaterial.WOOD,
                    properties

            ));
    public static final DeferredItem<ClaymoreItem> WOOD_CLAYMORE = ITEMS.registerItem("wood_claymore",
            properties -> new ClaymoreItem(ToolMaterial.WOOD,
                    properties

            ));
    public static final DeferredItem<CutlassItem> WOOD_CUTLASS = ITEMS.registerItem("wood_cutlass",
            properties -> new CutlassItem(ToolMaterial.WOOD,
                    properties

            ));
    public static final DeferredItem<DaggerItem> WOOD_DAGGER = ITEMS.registerItem("wood_dagger",
            properties -> new DaggerItem(ToolMaterial.WOOD,
                    properties

            ));
    public static final DeferredItem<DoubleAxeItem> WOOD_DOUBLE_AXE = ITEMS.registerItem("wood_double_axe",
            properties -> new DoubleAxeItem(ToolMaterial.WOOD,
                    properties

            ));
    public static final DeferredItem<FlailItem> WOOD_FLAIL = ITEMS.registerItem("wood_flail",
            properties -> new FlailItem(ToolMaterial.WOOD,
                    properties

            ));
    public static final DeferredItem<GlaiveItem> WOOD_GLAIVE = ITEMS.registerItem("wood_glaive",
            properties -> new GlaiveItem(ToolMaterial.WOOD,
                    properties

            ));
    public static final DeferredItem<HalberdItem> WOOD_HALBERD = ITEMS.registerItem("wood_halberd",
            properties -> new HalberdItem(ToolMaterial.WOOD,
                    properties

            ));
    public static final DeferredItem<KatanaItem> WOOD_KATANA = ITEMS.registerItem("wood_katana",
            properties -> new KatanaItem(ToolMaterial.WOOD,
                    properties

            ));
    public static final DeferredItem<RapierItem> WOOD_RAPIER = ITEMS.registerItem("wood_rapier",
            properties -> new RapierItem(ToolMaterial.WOOD,
                    properties

            ));
    public static final DeferredItem<ScytheItem> WOOD_SCYTHE = ITEMS.registerItem("wood_scythe",
            properties -> new ScytheItem(ToolMaterial.WOOD,
                    properties

            ));
    public static final DeferredItem<SickleItem> WOOD_SICKLE = ITEMS.registerItem("wood_sickle",
            properties -> new SickleItem(ToolMaterial.WOOD,
                    properties

            ));
    public static final DeferredItem<SpearItem> WOOD_SPEAR = ITEMS.registerItem("wood_spear",
            properties -> new SpearItem(ToolMaterial.WOOD,
                    properties

            ));
    public static final DeferredItem<TwinbladeItem> WOOD_TWINBLADE = ITEMS.registerItem("wood_twinblade",
            properties -> new TwinbladeItem(ToolMaterial.WOOD,
                    properties

            ));
    public static final DeferredItem<WhipSwordItem> WOOD_WHIP_SWORD = ITEMS.registerItem("wood_whip_sword",
            properties -> new WhipSwordItem(ToolMaterial.WOOD,
                    properties

            ));
    public static final DeferredItem<AnchorItem>STONE_ANCHOR = ITEMS.registerItem("stone_anchor",
            properties -> new AnchorItem(ToolMaterial.STONE,
                    properties

            ));
    public static final DeferredItem<ClawItem> STONE_CLAW = ITEMS.registerItem("stone_claw",
            properties -> new ClawItem(ToolMaterial.STONE,
                    properties

            ));
    public static final DeferredItem<ClaymoreItem> STONE_CLAYMORE = ITEMS.registerItem("stone_claymore",
            properties -> new ClaymoreItem(ToolMaterial.STONE,
                    properties

            ));
    public static final DeferredItem<CutlassItem> STONE_CUTLASS = ITEMS.registerItem("stone_cutlass",
            properties -> new CutlassItem(ToolMaterial.STONE,
                    properties

            ));
    public static final DeferredItem<DaggerItem> STONE_DAGGER = ITEMS.registerItem("stone_dagger",
            properties -> new DaggerItem(ToolMaterial.STONE,
                    properties

            ));
    public static final DeferredItem<DoubleAxeItem> STONE_DOUBLE_AXE = ITEMS.registerItem("stone_double_axe",
            properties -> new DoubleAxeItem(ToolMaterial.STONE,
                    properties

            ));
    public static final DeferredItem<FlailItem> STONE_FLAIL = ITEMS.registerItem("stone_flail",
            properties -> new FlailItem(ToolMaterial.STONE,
                    properties

            ));
    public static final DeferredItem<GlaiveItem> STONE_GLAIVE = ITEMS.registerItem("stone_glaive",
            properties -> new GlaiveItem(ToolMaterial.STONE,
                    properties

            ));
    public static final DeferredItem<HalberdItem> STONE_HALBERD = ITEMS.registerItem("stone_halberd",
            properties -> new HalberdItem(ToolMaterial.STONE,
                    properties

            ));
    public static final DeferredItem<KatanaItem> STONE_KATANA = ITEMS.registerItem("stone_katana",
            properties -> new KatanaItem(ToolMaterial.STONE,
                    properties

            ));
    public static final DeferredItem<RapierItem> STONE_RAPIER = ITEMS.registerItem("stone_rapier",
            properties -> new RapierItem(ToolMaterial.STONE,
                    properties

            ));
    public static final DeferredItem<ScytheItem> STONE_SCYTHE = ITEMS.registerItem("stone_scythe",
            properties -> new ScytheItem(ToolMaterial.STONE,
                    properties

            ));
    public static final DeferredItem<SickleItem> STONE_SICKLE = ITEMS.registerItem("stone_sickle",
            properties -> new SickleItem(ToolMaterial.STONE,
                    properties

            ));
    public static final DeferredItem<SpearItem> STONE_SPEAR = ITEMS.registerItem("stone_spear",
            properties -> new SpearItem(ToolMaterial.STONE,
                    properties

            ));
    public static final DeferredItem<TwinbladeItem> STONE_TWINBLADE = ITEMS.registerItem("stone_twinblade",
            properties -> new TwinbladeItem(ToolMaterial.STONE,
                    properties

            ));
    public static final DeferredItem<WhipSwordItem> STONE_WHIP_SWORD = ITEMS.registerItem("stone_whip_sword",
            properties -> new WhipSwordItem(ToolMaterial.STONE,
                    properties

            ));
    public static final DeferredItem<AnchorItem> COPPER_ANCHOR = ITEMS.registerItem("copper_anchor",
            properties -> new AnchorItem(MTAToolMaterials.COPPER,
                    properties

            ));
    public static final DeferredItem<SwordItem> COPPER_SWORD = ITEMS.registerItem("copper_sword",
            properties -> new SwordItem(MTAToolMaterials.COPPER, 3.0F, -2.4F,
                    properties
            ));

    public static final DeferredItem<ClawItem> COPPER_CLAW = ITEMS.registerItem("copper_claw",
            properties -> new ClawItem(MTAToolMaterials.COPPER,
                    properties

            ));
    public static final DeferredItem<ClaymoreItem> COPPER_CLAYMORE = ITEMS.registerItem("copper_claymore",
            properties -> new ClaymoreItem(MTAToolMaterials.COPPER,
                    properties

            ));
    public static final DeferredItem<CutlassItem> COPPER_CUTLASS = ITEMS.registerItem("copper_cutlass",
            properties -> new CutlassItem(MTAToolMaterials.COPPER,
                    properties

            ));
    public static final DeferredItem<DaggerItem> COPPER_DAGGER = ITEMS.registerItem("copper_dagger",
            properties -> new DaggerItem(MTAToolMaterials.COPPER,
                    properties

            ));
    public static final DeferredItem<DoubleAxeItem> COPPER_DOUBLE_AXE = ITEMS.registerItem("copper_double_axe",
            properties -> new DoubleAxeItem(MTAToolMaterials.COPPER,
                    properties

            ));
    public static final DeferredItem<FlailItem> COPPER_FLAIL = ITEMS.registerItem("copper_flail",
            properties -> new FlailItem(MTAToolMaterials.COPPER,
                    properties

            ));
    public static final DeferredItem<GlaiveItem> COPPER_GLAIVE = ITEMS.registerItem("copper_glaive",
            properties -> new GlaiveItem(MTAToolMaterials.COPPER,
                    properties

            ));
    public static final DeferredItem<HalberdItem> COPPER_HALBERD = ITEMS.registerItem("copper_halberd",
            properties -> new HalberdItem(MTAToolMaterials.COPPER,
                    properties

            ));
    public static final DeferredItem<KatanaItem> COPPER_KATANA = ITEMS.registerItem("copper_katana",
            properties -> new KatanaItem(MTAToolMaterials.COPPER,
                    properties

            ));
    public static final DeferredItem<RapierItem> COPPER_RAPIER = ITEMS.registerItem("copper_rapier",
            properties -> new RapierItem(MTAToolMaterials.COPPER,
                    properties

            ));
    public static final DeferredItem<ScytheItem> COPPER_SCYTHE = ITEMS.registerItem("copper_scythe",
            properties -> new ScytheItem(MTAToolMaterials.COPPER,
                    properties

            ));
    public static final DeferredItem<SickleItem> COPPER_SICKLE = ITEMS.registerItem("copper_sickle",
            properties -> new SickleItem(MTAToolMaterials.COPPER,
                    properties

            ));
    public static final DeferredItem<SpearItem> COPPER_SPEAR = ITEMS.registerItem("copper_spear",
            properties -> new SpearItem(MTAToolMaterials.COPPER,
                    properties

            ));
    public static final DeferredItem<TwinbladeItem> COPPER_TWINBLADE = ITEMS.registerItem("copper_twinblade",
            properties -> new TwinbladeItem(MTAToolMaterials.COPPER,
                    properties

            ));
    public static final DeferredItem<WhipSwordItem> COPPER_WHIP_SWORD = ITEMS.registerItem("copper_whip_sword",
            properties -> new WhipSwordItem(MTAToolMaterials.COPPER,
                    properties

            ));
    public static final DeferredItem<AnchorItem> IRON_ANCHOR = ITEMS.registerItem("iron_anchor",
            properties -> new AnchorItem(ToolMaterial.IRON,
                    properties

            ));
    public static final DeferredItem<ClawItem> IRON_CLAW = ITEMS.registerItem("iron_claw",
            properties -> new ClawItem(ToolMaterial.IRON,
                properties

            ));
    public static final DeferredItem<ClaymoreItem> IRON_CLAYMORE = ITEMS.registerItem("iron_claymore",
            properties -> new ClaymoreItem(ToolMaterial.IRON,
                    properties

            ));
    public static final DeferredItem<CutlassItem> IRON_CUTLASS = ITEMS.registerItem("iron_cutlass",
            properties -> new CutlassItem(ToolMaterial.IRON,
                    properties

            ));
    public static final DeferredItem<DaggerItem> IRON_DAGGER = ITEMS.registerItem("iron_dagger",
            properties -> new DaggerItem(ToolMaterial.IRON,
                    properties

            ));
    public static final DeferredItem<DoubleAxeItem> IRON_DOUBLE_AXE = ITEMS.registerItem("iron_double_axe",
            properties -> new DoubleAxeItem(ToolMaterial.IRON,
                    properties

            ));
    public static final DeferredItem<FlailItem> IRON_FLAIL = ITEMS.registerItem("iron_flail",
            properties -> new FlailItem(ToolMaterial.IRON,
                    properties

            ));
    public static final DeferredItem<GlaiveItem> IRON_GLAIVE = ITEMS.registerItem("iron_glaive",
            properties -> new GlaiveItem(ToolMaterial.IRON,
                    properties

            ));
    public static final DeferredItem<HalberdItem> IRON_HALBERD = ITEMS.registerItem("iron_halberd",
            properties -> new HalberdItem(ToolMaterial.IRON,
                    properties

            ));
    public static final DeferredItem<KatanaItem> IRON_KATANA = ITEMS.registerItem("iron_katana",
            properties -> new KatanaItem(ToolMaterial.IRON,
                    properties

            ));
    public static final DeferredItem<RapierItem> IRON_RAPIER = ITEMS.registerItem("iron_rapier",
            properties -> new RapierItem(ToolMaterial.IRON,
                    properties

            ));
    public static final DeferredItem<ScytheItem> IRON_SCYTHE = ITEMS.registerItem("iron_scythe",
            properties -> new ScytheItem(ToolMaterial.IRON,
                    properties

            ));
    public static final DeferredItem<SickleItem> IRON_SICKLE = ITEMS.registerItem("iron_sickle",
            properties -> new SickleItem(ToolMaterial.IRON,
                    properties

            ));
    public static final DeferredItem<SpearItem> IRON_SPEAR = ITEMS.registerItem("iron_spear",
            properties -> new SpearItem(ToolMaterial.IRON,
                    properties

            ));
    public static final DeferredItem<TwinbladeItem> IRON_TWINBLADE = ITEMS.registerItem("iron_twinblade",
            properties -> new TwinbladeItem(ToolMaterial.IRON,
                    properties

            ));
    public static final DeferredItem<WhipSwordItem> IRON_WHIP_SWORD = ITEMS.registerItem("iron_whip_sword",
            properties -> new WhipSwordItem(ToolMaterial.IRON,
                    properties

            ));
    public static final DeferredItem<AnchorItem> GOLD_ANCHOR = ITEMS.registerItem("gold_anchor",
            properties -> new AnchorItem(ToolMaterial.GOLD,
                    properties

            ));
    public static final DeferredItem<ClawItem> GOLD_CLAW = ITEMS.registerItem("gold_claw",
            properties -> new ClawItem(ToolMaterial.GOLD,
                    properties

            ));
    public static final DeferredItem<ClaymoreItem> GOLD_CLAYMORE = ITEMS.registerItem("gold_claymore",
            properties -> new ClaymoreItem(ToolMaterial.GOLD,
                    properties

            ));
    public static final DeferredItem<CutlassItem> GOLD_CUTLASS = ITEMS.registerItem("gold_cutlass",
            properties -> new CutlassItem(ToolMaterial.GOLD,
                    properties

            ));
    public static final DeferredItem<DaggerItem> GOLD_DAGGER = ITEMS.registerItem("gold_dagger",
            properties -> new DaggerItem(ToolMaterial.GOLD,
                    properties

            ));
    public static final DeferredItem<DoubleAxeItem> GOLD_DOUBLE_AXE = ITEMS.registerItem("gold_double_axe",
            properties -> new DoubleAxeItem(ToolMaterial.GOLD,
                    properties

            ));
    public static final DeferredItem<FlailItem> GOLD_FLAIL = ITEMS.registerItem("gold_flail",
            properties -> new FlailItem(ToolMaterial.GOLD,
                    properties

            ));
    public static final DeferredItem<GlaiveItem> GOLD_GLAIVE = ITEMS.registerItem("gold_glaive",
            properties -> new GlaiveItem(ToolMaterial.GOLD,
                    properties

            ));
    public static final DeferredItem<HalberdItem> GOLD_HALBERD = ITEMS.registerItem("gold_halberd",
            properties -> new HalberdItem(ToolMaterial.GOLD,
                    properties

            ));
    public static final DeferredItem<KatanaItem> GOLD_KATANA = ITEMS.registerItem("gold_katana",
            properties -> new KatanaItem(ToolMaterial.GOLD,
                    properties

            ));
    public static final DeferredItem<RapierItem> GOLD_RAPIER = ITEMS.registerItem("gold_rapier",
            properties -> new RapierItem(ToolMaterial.GOLD,
                    properties

            ));
    public static final DeferredItem<ScytheItem> GOLD_SCYTHE = ITEMS.registerItem("gold_scythe",
            properties -> new ScytheItem(ToolMaterial.GOLD,
                    properties

            ));
    public static final DeferredItem<SickleItem> GOLD_SICKLE = ITEMS.registerItem("gold_sickle",
            properties -> new SickleItem(ToolMaterial.GOLD,
                    properties

            ));
    public static final DeferredItem<SpearItem> GOLD_SPEAR = ITEMS.registerItem("gold_spear",
            properties -> new SpearItem(ToolMaterial.GOLD,
                    properties

            ));
    public static final DeferredItem<TwinbladeItem> GOLD_TWINBLADE = ITEMS.registerItem("gold_twinblade",
            properties -> new TwinbladeItem(ToolMaterial.GOLD,
                    properties

            ));
    public static final DeferredItem<WhipSwordItem> GOLD_WHIP_SWORD = ITEMS.registerItem("gold_whip_sword",
            properties -> new WhipSwordItem(ToolMaterial.GOLD,
                    properties

            ));
    public static final DeferredItem<SwordItem> NETHERSTEEL_SWORD = ITEMS.registerItem("nethersteel_sword",
            properties -> new SwordItem(MTAToolMaterials.NETHERSTEEL, 3.0F, -2.4F,
                    properties
            ));
    public static final DeferredItem<AnchorItem> NETHERSTEEL_ANCHOR = ITEMS.registerItem("nethersteel_anchor",
            properties -> new AnchorItem(MTAToolMaterials.NETHERSTEEL,
                    properties

            ));

    public static final DeferredItem<ClawItem> NETHERSTEEL_CLAW = ITEMS.registerItem("nethersteel_claw",
            properties -> new ClawItem(MTAToolMaterials.NETHERSTEEL,
                    properties

            ));
    public static final DeferredItem<ClaymoreItem> NETHERSTEEL_CLAYMORE = ITEMS.registerItem("nethersteel_claymore",
            properties -> new ClaymoreItem(MTAToolMaterials.NETHERSTEEL,
                    properties

            ));
    public static final DeferredItem<CutlassItem> NETHERSTEEL_CUTLASS = ITEMS.registerItem("nethersteel_cutlass",
            properties -> new CutlassItem(MTAToolMaterials.NETHERSTEEL,
                    properties

            ));
    public static final DeferredItem<DaggerItem> NETHERSTEEL_DAGGER = ITEMS.registerItem("nethersteel_dagger",
            properties -> new DaggerItem(MTAToolMaterials.NETHERSTEEL,
                    properties

            ));
    public static final DeferredItem<DoubleAxeItem> NETHERSTEEL_DOUBLE_AXE = ITEMS.registerItem("nethersteel_double_axe",
            properties -> new DoubleAxeItem(MTAToolMaterials.NETHERSTEEL,
                    properties

            ));
    public static final DeferredItem<FlailItem> NETHERSTEEL_FLAIL = ITEMS.registerItem("nethersteel_flail",
            properties -> new FlailItem(MTAToolMaterials.NETHERSTEEL,
                    properties

            ));
    public static final DeferredItem<GlaiveItem> NETHERSTEEL_GLAIVE = ITEMS.registerItem("nethersteel_glaive",
            properties -> new GlaiveItem(MTAToolMaterials.NETHERSTEEL,
                    properties

            ));
    public static final DeferredItem<HalberdItem> NETHERSTEEL_HALBERD = ITEMS.registerItem("nethersteel_halberd",
            properties -> new HalberdItem(MTAToolMaterials.NETHERSTEEL,
                    properties

            ));
    public static final DeferredItem<KatanaItem> NETHERSTEEL_KATANA = ITEMS.registerItem("nethersteel_katana",
            properties -> new KatanaItem(MTAToolMaterials.NETHERSTEEL,
                    properties

            ));
    public static final DeferredItem<RapierItem> NETHERSTEEL_RAPIER = ITEMS.registerItem("nethersteel_rapier",
            properties -> new RapierItem(MTAToolMaterials.NETHERSTEEL,
                    properties

            ));
    public static final DeferredItem<ScytheItem> NETHERSTEEL_SCYTHE = ITEMS.registerItem("nethersteel_scythe",
            properties -> new ScytheItem(MTAToolMaterials.NETHERSTEEL,
                    properties

            ));
    public static final DeferredItem<SickleItem> NETHERSTEEL_SICKLE = ITEMS.registerItem("nethersteel_sickle",
            properties -> new SickleItem(MTAToolMaterials.NETHERSTEEL,
                    properties

            ));
    public static final DeferredItem<SpearItem> NETHERSTEEL_SPEAR = ITEMS.registerItem("nethersteel_spear",
            properties -> new SpearItem(MTAToolMaterials.NETHERSTEEL,
                    properties

            ));
    public static final DeferredItem<TwinbladeItem> NETHERSTEEL_TWINBLADE = ITEMS.registerItem("nethersteel_twinblade",
            properties -> new TwinbladeItem(MTAToolMaterials.NETHERSTEEL,
                    properties

            ));
    public static final DeferredItem<WhipSwordItem> NETHERSTEEL_WHIP_SWORD = ITEMS.registerItem("nethersteel_whip_sword",
            properties -> new WhipSwordItem(MTAToolMaterials.NETHERSTEEL,
                    properties

            ));
    public static final DeferredItem<AnchorItem> DIAMOND_ANCHOR = ITEMS.registerItem("diamond_anchor",
            properties -> new AnchorItem(ToolMaterial.DIAMOND,
                    properties

            ));
    public static final DeferredItem<ClawItem> DIAMOND_CLAW = ITEMS.registerItem("diamond_claw",
            properties -> new ClawItem(ToolMaterial.DIAMOND,
                    properties

            ));
    public static final DeferredItem<ClaymoreItem> DIAMOND_CLAYMORE = ITEMS.registerItem("diamond_claymore",
            properties -> new ClaymoreItem(ToolMaterial.DIAMOND,
                    properties

            ));
    public static final DeferredItem<CutlassItem> DIAMOND_CUTLASS = ITEMS.registerItem("diamond_cutlass",
            properties -> new CutlassItem(ToolMaterial.DIAMOND,
                    properties

            ));
    public static final DeferredItem<DaggerItem> DIAMOND_DAGGER = ITEMS.registerItem("diamond_dagger",
            properties -> new DaggerItem(ToolMaterial.DIAMOND,
                    properties

            ));
    public static final DeferredItem<DoubleAxeItem> DIAMOND_DOUBLE_AXE = ITEMS.registerItem("diamond_double_axe",
            properties -> new DoubleAxeItem(ToolMaterial.DIAMOND,
                    properties

            ));
    public static final DeferredItem<FlailItem> DIAMOND_FLAIL = ITEMS.registerItem("diamond_flail",
            properties -> new FlailItem(ToolMaterial.WOOD,
                    properties

            ));
    public static final DeferredItem<GlaiveItem> DIAMOND_GLAIVE = ITEMS.registerItem("diamond_glaive",
            properties -> new GlaiveItem(ToolMaterial.DIAMOND,
                    properties

            ));
    public static final DeferredItem<HalberdItem> DIAMOND_HALBERD = ITEMS.registerItem("diamond_halberd",
            properties -> new HalberdItem(ToolMaterial.DIAMOND,
                    properties

            ));
    public static final DeferredItem<KatanaItem> DIAMOND_KATANA = ITEMS.registerItem("diamond_katana",
            properties -> new KatanaItem(ToolMaterial.DIAMOND,
                    properties

            ));
    public static final DeferredItem<RapierItem> DIAMOND_RAPIER = ITEMS.registerItem("diamond_rapier",
            properties -> new RapierItem(ToolMaterial.DIAMOND,
                    properties

            ));
    public static final DeferredItem<ScytheItem> DIAMOND_SCYTHE = ITEMS.registerItem("diamond_scythe",
            properties -> new ScytheItem(ToolMaterial.DIAMOND,
                    properties

            ));
    public static final DeferredItem<SickleItem> DIAMOND_SICKLE = ITEMS.registerItem("diamond_sickle",
            properties -> new SickleItem(ToolMaterial.DIAMOND,
                    properties

            ));
    public static final DeferredItem<SpearItem> DIAMOND_SPEAR = ITEMS.registerItem("diamond_spear",
            properties -> new SpearItem(ToolMaterial.DIAMOND,
                    properties

            ));
    public static final DeferredItem<TwinbladeItem> DIAMOND_TWINBLADE = ITEMS.registerItem("diamond_twinblade",
            properties -> new TwinbladeItem(ToolMaterial.DIAMOND,
                    properties

            ));
    public static final DeferredItem<WhipSwordItem> DIAMOND_WHIP_SWORD = ITEMS.registerItem("diamond_whip_sword",
            properties -> new WhipSwordItem(ToolMaterial.DIAMOND,
                    properties

            ));
    public static final DeferredItem<NetheriteTridentItem> NETHERITE_TRIDENT = ITEMS.registerItem("netherite_trident",
            properties -> new NetheriteTridentItem(
                    properties
                            .attributes(TridentItem.createAttributes())
                            .durability(2031).component(DataComponents.TOOL, NetheriteTridentItem.createToolProperties())));
    public static final DeferredItem<NetheriteBowItem> NETHERITE_BOW = ITEMS.registerItem("netherite_bow",
            properties -> new NetheriteBowItem(
                    properties
                            .durability(2031)));
    public static final DeferredItem<MaceItem> NETHERITE_MACE = ITEMS.registerItem("netherite_mace",
            properties -> new MaceItem(
                    properties
                            .durability(2031).fireResistant()));

    public static final DeferredItem<AnchorItem> NETHERITE_ANCHOR = ITEMS.registerItem("netherite_anchor",
            properties -> new AnchorItem(ToolMaterial.NETHERITE,
                    properties.fireResistant()

            ));
    public static final DeferredItem<ClawItem> NETHERITE_CLAW = ITEMS.registerItem("netherite_claw",
            properties -> new ClawItem(ToolMaterial.NETHERITE,
                    properties.fireResistant()

            ));
    public static final DeferredItem<ClaymoreItem> NETHERITE_CLAYMORE = ITEMS.registerItem("netherite_claymore",
            properties -> new ClaymoreItem(ToolMaterial.NETHERITE,
                    properties.fireResistant()

            ));
    public static final DeferredItem<CutlassItem> NETHERITE_CUTLASS = ITEMS.registerItem("netherite_cutlass",
            properties -> new CutlassItem(ToolMaterial.NETHERITE,
                    properties.fireResistant()

            ));
    public static final DeferredItem<DaggerItem> NETHERITE_DAGGER = ITEMS.registerItem("netherite_dagger",
            properties -> new DaggerItem(ToolMaterial.NETHERITE,
                    properties.fireResistant()

            ));
    public static final DeferredItem<DoubleAxeItem> NETHERITE_DOUBLE_AXE = ITEMS.registerItem("netherite_double_axe",
            properties -> new DoubleAxeItem(ToolMaterial.NETHERITE,
                    properties.fireResistant()

            ));
    public static final DeferredItem<FlailItem> NETHERITE_FLAIL = ITEMS.registerItem("netherite_flail",
            properties -> new FlailItem(ToolMaterial.NETHERITE,
                    properties.fireResistant()

            ));
    public static final DeferredItem<GlaiveItem> NETHERITE_GLAIVE = ITEMS.registerItem("netherite_glaive",
            properties -> new GlaiveItem(ToolMaterial.NETHERITE,
                    properties.fireResistant()

            ));
    public static final DeferredItem<HalberdItem> NETHERITE_HALBERD = ITEMS.registerItem("netherite_halberd",
            properties -> new HalberdItem(ToolMaterial.NETHERITE,
                    properties.fireResistant()

            ));
    public static final DeferredItem<KatanaItem> NETHERITE_KATANA = ITEMS.registerItem("netherite_katana",
            properties -> new KatanaItem(ToolMaterial.NETHERITE,
                    properties.fireResistant()

            ));
    public static final DeferredItem<RapierItem> NETHERITE_RAPIER = ITEMS.registerItem("netherite_rapier",
            properties -> new RapierItem(ToolMaterial.NETHERITE,
                    properties.fireResistant()

            ));
    public static final DeferredItem<ScytheItem> NETHERITE_SCYTHE = ITEMS.registerItem("netherite_scythe",
            properties -> new ScytheItem(ToolMaterial.NETHERITE,
                    properties.fireResistant()

            ));
    public static final DeferredItem<SickleItem> NETHERITE_SICKLE = ITEMS.registerItem("netherite_sickle",
            properties -> new SickleItem(ToolMaterial.NETHERITE,
                    properties.fireResistant()

            ));
    public static final DeferredItem<SpearItem> NETHERITE_SPEAR = ITEMS.registerItem("netherite_spear",
            properties -> new SpearItem(ToolMaterial.NETHERITE,
                    properties.fireResistant()

            ));
    public static final DeferredItem<TwinbladeItem> NETHERITE_TWINBLADE = ITEMS.registerItem("netherite_twinblade",
            properties -> new TwinbladeItem(ToolMaterial.NETHERITE,
                    properties.fireResistant()

            ));
    public static final DeferredItem<WhipSwordItem> NETHERITE_WHIP_SWORD = ITEMS.registerItem("netherite_whip_sword",
            properties -> new WhipSwordItem(ToolMaterial.NETHERITE,
                    properties.fireResistant()

            ));

    public static final DeferredItem<ArcheryItem> LONG_BOW = ITEMS.registerItem("long_bow",
            properties -> new ArcheryItem(
                    properties
                            .durability(528), 10F, false, 10F, 2F));

    public static final DeferredItem<ArcheryItem> REINFORCED_LONG_BOW = ITEMS.registerItem("reinforced_long_bow",
            properties -> new ArcheryItem(
                    properties
                            .durability(528), 10F, true, 10F, 2F));

    public static final DeferredItem<ArcheryItem> SHORT_BOW = ITEMS.registerItem("short_bow",
            properties -> new ArcheryItem(
                    properties
                            .durability(528), 5F, false, 5F, 20F));

    public static final DeferredItem<ArcheryItem> REINFORCED_SHORT_BOW = ITEMS.registerItem("reinforced_short_bow",
            properties -> new ArcheryItem(
                    properties
                            .durability(528), 5F, true, 5F, 20F));

    public static final DeferredItem<ArcheryItem> TWIN_BOW = ITEMS.registerItem("twin_bow",
            properties -> new ArcheryItem(
                    properties
                            .durability(528), 15F, false, 7F, 5F));

    public static final DeferredItem<ArcheryItem> REINFORCED_TWIN_BOW = ITEMS.registerItem("reinforced_twin_bow",
            properties -> new ArcheryItem(
                    properties
                            .durability(528), 15F, true, 7F, 5F));

    public static final DeferredItem<WhipItem> LEATHER_WHIP = ITEMS.registerItem("leather_whip",
            properties -> new WhipItem(ToolMaterial.WOOD,
                    properties
            ));

    public static final DeferredItem<WhipItem> CHAIN_WHIP = ITEMS.registerItem("chain_whip",
            properties -> new WhipItem(ToolMaterial.IRON,
                    properties
            ));

    public static final DeferredItem<WhipItem> NETHERITE_WHIP = ITEMS.registerItem("netherite_whip",
            properties -> new WhipItem(ToolMaterial.NETHERITE,
                    properties.fireResistant()
            ));

    //SPECIAL WEAPONS
    public static final DeferredItem<SentinelsWarHammerItem> GREAT_SENTINELS_WAR_HAMMER = ITEMS.registerItem("great_sentinels_war_hammer",
            properties -> new SentinelsWarHammerItem(
                    properties

                            .durability(8192)
                            .component(DataComponents.TOOL, SentinelsWarHammerItem.createToolProperties())
            ));

    public static final DeferredItem<KnightGreatswordItem> HOLY_KNIGHTS_GREATSWORD = ITEMS.registerItem("holy_knights_greatsword",
            properties -> new KnightGreatswordItem(MTAToolMaterials.ALEXANDRITE,
                    properties

            ));
    public static final DeferredItem<MermaidTridentItem> MYSTIC_MERMAIDS_TRIDENT = ITEMS.registerItem("mystic_mermaids_trident",
            properties -> new MermaidTridentItem(
                    properties

                            .durability(7108)
            ));
    public static final DeferredItem<ReaperScytheItem> SILENT_REAPERS_SCYTHE = ITEMS.registerItem("silent_reaper_scythe",
            properties -> new ReaperScytheItem(MTAToolMaterials.BLOODSTONE,
                    properties

            ));
    public static final DeferredItem<AngelBowItem> TEMPLE_ANGELS_BOW = ITEMS.registerItem("temple_angels_bow",
            properties -> new AngelBowItem(
                    properties

                            .durability(6760)
            ));
    public static final DeferredItem<WeaponItem> FREEZING_ICICLE_SPEAR = ITEMS.registerItem("freezing_icicle_spear",
            properties -> new FreezingIcicleSpearItem(MTAToolMaterials.CRYOLITE,
                    properties

                            .durability(6760)
            ));
    public static final DeferredItem<BerserkerBattleAxeItem> WRATHFUL_BERSERKERS_BATTLEAXE = ITEMS.registerItem("wrathful_berserkers_battleaxe",
            properties -> new BerserkerBattleAxeItem(MTAToolMaterials.GARNET,
                    properties

            ));
    public static final DeferredItem<RogueDaggerItem> SHADOW_ROGUES_DAGGER = ITEMS.registerItem("shadow_rogues_dagger",
            properties -> new RogueDaggerItem(MTAToolMaterials.MOONSTONE,
                    properties

            ));
    public static final DeferredItem<AnchorItem> WOOD_ANCHOR = ITEMS.registerItem("wood_anchor",
            properties -> new AnchorItem(ToolMaterial.WOOD,
                    properties

            ));

    //FOODS
    public static final DeferredItem<Item> ONION = ITEMS.registerItem("onion", properties -> new BlockItem(MtaBlocks.ONION_CROP.get(), properties
            .food(MtaFoods.ONION)));
    public static final DeferredItem<Item> SHRIMP = ITEMS.registerSimpleItem("shrimp", new Item.Properties()
            .food(MtaFoods.SHRIMP));
    public static final DeferredItem<Item> COOKED_SHRIMP = ITEMS.registerSimpleItem("cooked_shrimp", new Item.Properties()
            .food(MtaFoods.COOKED_SHRIMP));
    public static final DeferredItem<Item> TOMATO = ITEMS.registerSimpleItem("tomato", new Item.Properties()
            .food(MtaFoods.TOMATO));
    public static final DeferredItem<Item> TOMATO_SEEDS = ITEMS.registerItem("tomato_seeds", properties -> new BlockItem(MtaBlocks.TOMATO_CROP.get(), properties
    ));
    public static final DeferredItem<Item> BELL_PEPPER = ITEMS.registerSimpleItem("bell_pepper", new Item.Properties()
            .food(MtaFoods.BELL_PEPPER));
    public static final DeferredItem<Item> BELL_PEPPER_SEEDS = ITEMS.registerItem("bell_pepper_seeds", properties -> new BlockItem(MtaBlocks.BELL_PEPPER_CROP.get(), properties
    ));
    public static final DeferredItem<Item> CHILI_PEPPER = ITEMS.registerSimpleItem("chili_pepper", new Item.Properties()
            .food(MtaFoods.CHILI_PEPPER));
    public static final DeferredItem<Item> CHILI_PEPPER_SEEDS = ITEMS.registerItem("chili_pepper_seeds", properties -> new BlockItem(MtaBlocks.CHILI_PEPPER_CROP.get(), properties
    ));
    public static final DeferredItem<Item> RICE = ITEMS.registerSimpleItem("rice", new Item.Properties()
    );
    public static final DeferredItem<Item> ONIGIRI = ITEMS.registerSimpleItem("onigiri", new Item.Properties()
            .food(MtaFoods.ONIGIRI));
    public static final DeferredItem<Item> COCONUT = ITEMS.registerItem("coconut", properties -> new BlockItem(MtaBlocks.PALM_SAPLING.get(), properties
    ));
    public static final DeferredItem<Item> COCONUT_MILK = ITEMS.registerItem("coconut_milk", CoconutMilkItem::new, new Item.Properties()
            .food(MtaFoods.COCONUT_MILK));
    public static final DeferredItem<Item> COCONUT_SLICE = ITEMS.registerSimpleItem("coconut_slice", new Item.Properties()
            .food(MtaFoods.COCONUT_SLICE));
    public static final DeferredItem<Item> SPICE_MIX = ITEMS.registerSimpleItem("spice_mix", new Item.Properties()
    );
    public static final DeferredItem<Item> SWEET_BEEF_CURRY = ITEMS.registerSimpleItem("sweet_beef_curry", new Item.Properties()
            .food(MtaFoods.BEEF_CURRY, MTAConsumables.SWEET_CURRY).stacksTo(1));
    public static final DeferredItem<Item> SWEET_PORK_CURRY = ITEMS.registerSimpleItem("sweet_pork_curry", new Item.Properties()
            .food(MtaFoods.PORK_CURRY, MTAConsumables.SWEET_CURRY).stacksTo(1));
    public static final DeferredItem<Item> SWEET_CHICKEN_CURRY = ITEMS.registerSimpleItem("sweet_chicken_curry", new Item.Properties()
            .food(MtaFoods.CHICKEN_CURRY, MTAConsumables.SWEET_CURRY).stacksTo(1));
    public static final DeferredItem<Item> SWEET_SHRIMP_CURRY = ITEMS.registerSimpleItem("sweet_shrimp_curry", new Item.Properties()
            .food(MtaFoods.SHRIMP_CURRY, MTAConsumables.SWEET_CURRY).stacksTo(1));
    public static final DeferredItem<Item> MILD_BEEF_CURRY = ITEMS.registerSimpleItem("mild_beef_curry", new Item.Properties()
            .food(MtaFoods.BEEF_CURRY, MTAConsumables.MILD_CURRY).stacksTo(1));
    public static final DeferredItem<Item> MILD_PORK_CURRY = ITEMS.registerSimpleItem("mild_pork_curry", new Item.Properties()
            .food(MtaFoods.PORK_CURRY, MTAConsumables.MILD_CURRY).stacksTo(1));
    public static final DeferredItem<Item> MILD_CHICKEN_CURRY = ITEMS.registerSimpleItem("mild_chicken_curry", new Item.Properties()
            .food(MtaFoods.CHICKEN_CURRY, MTAConsumables.MILD_CURRY).stacksTo(1));
    public static final DeferredItem<Item> MILD_SHRIMP_CURRY = ITEMS.registerSimpleItem("mild_shrimp_curry", new Item.Properties()
            .food(MtaFoods.SHRIMP_CURRY, MTAConsumables.MILD_CURRY).stacksTo(1));
    public static final DeferredItem<Item> SPICY_BEEF_CURRY = ITEMS.registerSimpleItem("spicy_beef_curry", new Item.Properties()
            .food(MtaFoods.BEEF_CURRY, MTAConsumables.SPICY_CURRY).stacksTo(1));
    public static final DeferredItem<Item> SPICY_PORK_CURRY = ITEMS.registerSimpleItem("spicy_pork_curry", new Item.Properties()
            .food(MtaFoods.PORK_CURRY, MTAConsumables.SPICY_CURRY).stacksTo(1));
    public static final DeferredItem<Item> SPICY_CHICKEN_CURRY = ITEMS.registerSimpleItem("spicy_chicken_curry", new Item.Properties()
            .food(MtaFoods.CHICKEN_CURRY, MTAConsumables.SPICY_CURRY).stacksTo(1));
    public static final DeferredItem<Item> SPICY_SHRIMP_CURRY = ITEMS.registerSimpleItem("spicy_shrimp_curry", new Item.Properties()
            .food(MtaFoods.SHRIMP_CURRY, MTAConsumables.SPICY_CURRY).stacksTo(1));
    public static final DeferredItem<Item> APPLE_SLICE = ITEMS.registerSimpleItem("apple_slice", new Item.Properties()
            .food(MtaFoods.APPLE_SLICE));
    public static final DeferredItem<Item> AVOCADO = ITEMS.registerSimpleItem("avocado", new Item.Properties()
            .food(MtaFoods.AVOCADO));
    public static final DeferredItem<Item> AVOCADO_SLICE = ITEMS.registerSimpleItem("avocado_slice", new Item.Properties()
            .food(MtaFoods.AVOCADO_SLICE));
    public static final DeferredItem<Item> BANANA = ITEMS.registerSimpleItem("banana", new Item.Properties()
            .food(MtaFoods.BANANA));
    public static final DeferredItem<Item> CABBAGE = ITEMS.registerSimpleItem("cabbage", new Item.Properties()
            .food(MtaFoods.CABBAGE));
    public static final DeferredItem<Item> COFFEE_BEANS = ITEMS.registerSimpleItem("coffee_beans", new Item.Properties()
            .food(MtaFoods.COFFEE_BEANS));
    public static final DeferredItem<Item> COFFEE = ITEMS.registerSimpleItem("coffee", new Item.Properties()
            .food(MtaFoods.COFFEE).stacksTo(1));
    public static final DeferredItem<Item> GRAPES = ITEMS.registerSimpleItem("grapes", new Item.Properties()
            .food(MtaFoods.GRAPES));
    public static final DeferredItem<Item> MANGO = ITEMS.registerSimpleItem("mango", new Item.Properties()
            .food(MtaFoods.MANGO));
    public static final DeferredItem<Item> MANGO_SLICE = ITEMS.registerSimpleItem("mango_slice", new Item.Properties()
            .food(MtaFoods.MANGO_SLICE));
    public static final DeferredItem<Item> STRAWBERRY = ITEMS.registerSimpleItem("strawberry", new Item.Properties()
            .food(MtaFoods.STRAWBERRY));
    public static final DeferredItem<Item> TEA_LEAVES = ITEMS.registerSimpleItem("tea_leaves", new Item.Properties());
    public static final DeferredItem<Item> TEA = ITEMS.registerSimpleItem("tea", new Item.Properties()
            .food(MtaFoods.TEA).stacksTo(1));
    public static final DeferredItem<Item> ICE_CUBES = ITEMS.registerSimpleItem("ice_cubes", new Item.Properties());

    public static final DeferredItem<Item> SMOOTHIE = ITEMS.registerSimpleItem("smoothie", new Item.Properties()
            .food(MtaFoods.APPLE_SMOOTHIE).stacksTo(1));

    public static final DeferredItem<Item> JUICE = ITEMS.registerSimpleItem("juice", new Item.Properties().stacksTo(1));






    // SPAWN EGGS


    //TAMABLE


    public static final DeferredItem<Item> BEARDED_DRAGON_SPAWN_EGG =  ITEMS.registerItem("bearded_dragon_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.BEARDED_DRAGON.get(), properties
            ));

    public static final DeferredItem<Item> CAPYBARA_SPAWN_EGG =  ITEMS.registerItem("capybara_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.CAPIBARA.get(), properties
            ));

    public static final DeferredItem<Item> DUCK_SPAWN_EGG =  ITEMS.registerItem("duck_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.DUCK.get(), properties
            ));

    public static final DeferredItem<Item> FERRET_SPAWN_EGG =  ITEMS.registerItem("ferret_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.FERRET.get(), properties
            ));

    public static final DeferredItem<Item> HORSESHOE_CRAB_SPAWN_EGG =  ITEMS.registerItem("horseshoe_crab_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.HORSESHOE_CRAB.get(), properties
            ));

    public static final DeferredItem<Item> OCTOPUS_SPAWN_EGG =  ITEMS.registerItem("octopus_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.OCTOPUS.get(), properties
            ));

    public static final DeferredItem<Item> OWL_SPAWN_EGG =  ITEMS.registerItem("owl_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.OWL.get(), properties
            ));

    public static final DeferredItem<Item> PENGUIN_SPAWN_EGG =  ITEMS.registerItem("penguin_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.PENGUIN.get(), properties
            ));

    public static final DeferredItem<Item> RACCOON_SPAWN_EGG =  ITEMS.registerItem("raccoon_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.RACCOON.get(), properties
            ));

    public static final DeferredItem<Item> TOUCAN_SPAWN_EGG =  ITEMS.registerItem("toucan_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.TOUCAN.get(), properties
            ));

    public static final DeferredItem<Item> WISPFLY_SPAWN_EGG =  ITEMS.registerItem("wispfly_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.WISPFLY.get(), properties
            ));


    //PASSIVE


    public static final DeferredItem<Item> BUTTERFLY_SPAWN_EGG =  ITEMS.registerItem("butterfly_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.BUTTERFLY.get(), properties
            ));

    public static final DeferredItem<Item> DEER_SPAWN_EGG =  ITEMS.registerItem("deer_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.DEER.get(), properties
            ));

    public static final DeferredItem<Item> JELLYFISH_SPAWN_EGG =  ITEMS.registerItem("jellyfish_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.JELLYFISH.get(), properties
            ));

    public static final DeferredItem<Item> SHRIMP_SPAWN_EGG =  ITEMS.registerItem("shrimp_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.SHRIMP.get(), properties
            ));

    //NEUTRAL


    public static final DeferredItem<Item> GREAT_WHITE_SHARK_SPAWN_EGG =  ITEMS.registerItem("great_white_shark_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.GREAT_WHITE_SHARK.get(), properties
            ));

    public static final DeferredItem<Item> TURKEY_SPAWN_EGG =  ITEMS.registerItem("turkey_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.TURKEY.get(), properties
            ));


    //HOSTILE


    public static final DeferredItem<Item> YUKI_ONNA_SPAWN_EGG =  ITEMS.registerItem("yuki_onna_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.YUKI_ONNA.get(), properties
            ));

    public static final DeferredItem<Item> FALLEN_SAMURAI_SPAWN_EGG =  ITEMS.registerItem("fallen_samurai_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.FALLEN_SAMURAI.get(), properties
            ));

    public static final DeferredItem<Item> ICICLE_CREEPER_SPAWN_EGG =  ITEMS.registerItem("icicle_creeper_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.ICICLE_CREEPER.get(), properties
            ));












    public static final DeferredItem<Item> ARMORED_SKELETON_SPAWN_EGG =  ITEMS.registerItem("armored_skeleton_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.ARMORED_SKELETON.get(), properties
            ));

    public static final DeferredItem<Item> BLACK_WIDOW_SPAWN_EGG =  ITEMS.registerItem("black_widow_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.BLACK_WIDOW.get(), properties
            ));

    public static final DeferredItem<Item> CHARRED_SKELETON_SPAWN_EGG =  ITEMS.registerItem("charred_skeleton_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.CHARRED_SKELETON.get(), properties
            ));

    public static final DeferredItem<Item> CORROSIVE_CUBE_SPAWN_EGG =  ITEMS.registerItem("corrosive_cube_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.CORROSIVE_CUBE.get(), properties
            ));

    public static final DeferredItem<Item> FROSTED_SLIME_SPAWN_EGG =  ITEMS.registerItem("frosted_slime_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.FROSTED_SLIME.get(), properties
            ));

    public static final DeferredItem<Item> GLOW_SPIDER_SPAWN_EGG =  ITEMS.registerItem("glow_spider_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.GLOW_SPIDER.get(), properties
            ));

    public static final DeferredItem<Item> HOST_SPAWN_EGG =  ITEMS.registerItem("host_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.HOST.get(), properties
            ));

    public static final DeferredItem<Item> MOSSY_ZOMBIE_SPAWN_EGG =  ITEMS.registerItem("mossy_zombie_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.MOSSY_ZOMBIE.get(), properties
            ));

    public static final DeferredItem<Item> SKELETON_FIGHTER_SPAWN_EGG =  ITEMS.registerItem("skeleton_fighter_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.SKELETON_FIGHTER.get(), properties
            ));

    public static final DeferredItem<Item> TOXIC_ZOMBIE_SPAWN_EGG =  ITEMS.registerItem("toxic_zombie_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.TOXIC_ZOMBIE.get(), properties
            ));

    public static final DeferredItem<Item> WITHER_SOLDIER_SPAWN_EGG =  ITEMS.registerItem("wither_soldier_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.WITHER_SOLDIER.get(), properties
            ));

    public static final DeferredItem<Item> ZOMBIFIED_MINER_SPAWN_EGG =  ITEMS.registerItem("zombified_miner_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.ZOMBIFIED_MINER.get(), properties
            ));

    public static final DeferredItem<Item> SIREN_SPAWN_EGG =  ITEMS.registerItem("siren_spawn_egg",
            properties -> new SpawnEggItem(MtaEntityTypes.SIREN.get(), properties
            ));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }





    /*
    >>>>TEMPLATES<<<<

    // PLACEHOLDER GEAR
    public static final DeferredItem<MTAArmor> PLACEHOLDER_HELMET = ITEMS.registerItem("placeholder_helmet", properties -> new MTAArmor(MTAArmorMats.PLACEHOLDER, ArmorItem.Type.HELMET, properties
    .durability(ArmorItem.Type.HELMET.getDurability(DURABILITY))));
    public static final DeferredItem<MTAArmor> PLACEHOLDER_CHESTPLATE = ITEMS.registerItem("placeholder_chestplate", properties -> new MTAArmor(MTAArmorMats.PLACEHOLDER, ArmorItem.Type.CHESTPLATE, properties
    .durability(ArmorItem.Type.CHESTPLATE.getDurability(DURABILITY))));
    public static final DeferredItem<MTAArmor> PLACEHOLDER_LEGGINGS = ITEMS.registerItem("placeholder_leggings", properties -> new MTAArmor(MTAArmorMats.PLACEHOLDER, ArmorItem.Type.LEGGINGS, properties
    .durability(ArmorItem.Type.LEGGINGS.getDurability(DURABILITY))));
    public static final DeferredItem<MTAArmor> PLACEHOLDER_BOOTS = ITEMS.registerItem("placeholder_boots", properties -> new MTAArmor(MTAArmorMats.PLACEHOLDER, ArmorItem.Type.BOOTS, properties
    .durability(ArmorItem.Type.BOOTS.getDurability(DURABILITY))));

    public static final DeferredItem<PickaxeItem> PLACEHOLDER_PICKAXE = ITEMS.registerItem("placeholder_pickaxe", properties -> new PickaxeItem(MTAToolTiers.PLACEHOLDER, properties
    ));
    public static final DeferredItem<AxeItem> PLACEHOLDER_AXE = ITEMS.registerItem("placeholder_axe", properties -> new AxeItem(MTAToolTiers.PLACEHOLDER, properties
    .fireResistant().rarity(Rarity.EPIC)));
    public static final DeferredItem<ShovelItem> PLACEHOLDER_SHOVEL = ITEMS.registerItem("placeholder_shovel", properties -> new ShovelItem(MTAToolTiers.PLACEHOLDER, properties
    ));
    public static final DeferredItem<HoeItem> PLACEHOLDER_HOE = ITEMS.registerItem("placeholder_hoe", properties -> new HoeItem(MTAToolTiers.PLACEHOLDER, properties
    ));

    public static final DeferredItem<SwordItem> PLACEHOLDER_SWORD = ITEMS.registerItem("placeholder_sword", properties -> new SwordItem(MTAToolTiers.PLACEHOLDER, properties
    ));

    public static final DeferredItem<Item> PLACEHOLDER_INGOT = ITEMS.registerSimpleItem("placeholder_ingot");
    public static final DeferredItem<Item> RAW_PLACEHOLDER = ITEMS.registerSimpleItem("raw_placeholder");
    public static final DeferredItem<Item> PLACEHOLDER_NUGGET = ITEMS.registerSimpleItem("placeholder_nugget");
    public static final DeferredItem<Item> PLACEHOLDER = ITEMS.registerSimpleItem("placeholder");

     */
}
