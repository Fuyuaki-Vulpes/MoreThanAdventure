package com.fuyuaki.morethanadventure.core.registry;

import com.fuyuaki.morethanadventure.world.item.*;
import com.fuyuaki.morethanadventure.world.item.curio.talisman.AttributeModifierTalismanItem;
import com.fuyuaki.morethanadventure.world.item.curio.talisman.SirenTalisman;
import com.fuyuaki.morethanadventure.world.item.curio.talisman.TalismanItem;
import com.fuyuaki.morethanadventure.world.item.weaponry.*;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MtaItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    //ITEMS


    public static final DeferredItem<Item> BIG_BOWL = ITEMS.registerSimpleItem("big_bowl");

    public static final DeferredItem<Item> CLEAR_QUARTZ = ITEMS.registerSimpleItem("clear_quartz");
    public static final DeferredItem<Item> NETHERITE_FRACTURE = ITEMS.registerSimpleItem("netherite_fracture", new Item.Properties().fireResistant());

    public static final DeferredItem<Item> HOST_HUSK = ITEMS.registerSimpleItem("host_husk", new Item.Properties());
    public static final DeferredItem<Item> SAMURAI_CLOTH = ITEMS.registerSimpleItem("samurai_cloth", new Item.Properties());
    public static final DeferredItem<Item> SIREN_SCALE = ITEMS.registerSimpleItem("siren_scale", new Item.Properties());
    public static final DeferredItem<Item> BLACK_WIDOW_VENOM = ITEMS.registerSimpleItem("black_widow_venom", new Item.Properties());
    //public static final DeferredItem<Item> FLYING_WING = ITEMS.registerSimpleItem("netherite_fracture", new Item.Properties());
    public static final DeferredItem<Item> SPIRIT_DUST = ITEMS.registerSimpleItem("spirit_dust", new Item.Properties());
    public static final DeferredItem<Item> CHARRED_BONE = ITEMS.registerSimpleItem("charred_bone", new Item.Properties());
    //public static final DeferredItem<Item> SPEEDY_BOI = ITEMS.registerSimpleItem("netherite_fracture", new Item.Properties());


    //TALISMANS

    public static final DeferredItem<AttributeModifierTalismanItem> SIREN_TALISMAN = ITEMS.register("siren_talisman", () -> new SirenTalisman(
            new Item.Properties()
    ));

    public static final DeferredItem<TalismanItem> WEIGHTED_DICE = ITEMS.register("weighted_dice", () -> new TalismanItem(new Item.Properties()));

    //TOTEMS
    public static final DeferredItem<Item> TOTEM_OF_COMBATING = ITEMS.registerSimpleItem("totem_of_combating",new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));



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
    public static final DeferredItem<MTAArmor> GREAT_SENTINELS_HELMET = ITEMS.register("great_sentinel_helmet", () -> new MTAArmor(MtaArmorMats.GREAT_SENTINEL, ArmorType.HELMET, new Item.Properties().fireResistant().durability(ArmorType.HELMET.getDurability(59))));
    public static final DeferredItem<MTAArmor> GREAT_SENTINELS_CHESTPLATE = ITEMS.register("great_sentinel_chestplate", () -> new MTAArmor(MtaArmorMats.GREAT_SENTINEL, ArmorType.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorType.CHESTPLATE.getDurability(59))));
    public static final DeferredItem<MTAArmor> GREAT_SENTINELS_LEGGINGS = ITEMS.register("great_sentinel_leggings", () -> new MTAArmor(MtaArmorMats.GREAT_SENTINEL, ArmorType.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorType.LEGGINGS.getDurability(59))));
    public static final DeferredItem<MTAArmor> GREAT_SENTINELS_BOOTS = ITEMS.register("great_sentinel_boots", () -> new MTAArmor(MtaArmorMats.GREAT_SENTINEL, ArmorType.BOOTS, new Item.Properties().fireResistant().durability(ArmorType.BOOTS.getDurability(59))));

    public static final DeferredItem<MTAArmor> HOLY_KNIGHTS_HELMET = ITEMS.register("holy_knights_helmet", () -> new MTAArmor(MtaArmorMats.HOLY_KNIGHT, ArmorType.HELMET, new Item.Properties().fireResistant().durability(ArmorType.HELMET.getDurability(52))));
    public static final DeferredItem<MTAArmor> HOLY_KNIGHTS_CHESTPLATE = ITEMS.register("holy_knights_chestplate", () -> new MTAArmor(MtaArmorMats.HOLY_KNIGHT, ArmorType.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorType.CHESTPLATE.getDurability(52))));
    public static final DeferredItem<MTAArmor> HOLY_KNIGHTS_LEGGINGS = ITEMS.register("holy_knights_leggings", () -> new MTAArmor(MtaArmorMats.HOLY_KNIGHT, ArmorType.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorType.LEGGINGS.getDurability(52))));
    public static final DeferredItem<MTAArmor> HOLY_KNIGHTS_BOOTS = ITEMS.register("holy_knights_boots", () -> new MTAArmor(MtaArmorMats.HOLY_KNIGHT, ArmorType.BOOTS, new Item.Properties().fireResistant().durability(ArmorType.BOOTS.getDurability(52))));

    public static final DeferredItem<MTAArmor> MYSTIC_MERMAIDS_HELMET = ITEMS.register("mystic_mermaids_helmet", () -> new MTAArmor(MtaArmorMats.MYSTIC_MERMAID, ArmorType.HELMET, new Item.Properties().fireResistant().durability(ArmorType.HELMET.getDurability(49))));
    public static final DeferredItem<MTAArmor> MYSTIC_MERMAIDS_CHESTPLATE = ITEMS.register("mystic_mermaids_chestplate", () -> new MTAArmor(MtaArmorMats.MYSTIC_MERMAID, ArmorType.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorType.CHESTPLATE.getDurability(49))));
    public static final DeferredItem<MTAArmor> MYSTIC_MERMAIDS_LEGGINGS = ITEMS.register("mystic_mermaids_leggings", () -> new MTAArmor(MtaArmorMats.MYSTIC_MERMAID, ArmorType.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorType.LEGGINGS.getDurability(49))));
    public static final DeferredItem<MTAArmor> MYSTIC_MERMAIDS_BOOTS = ITEMS.register("mystic_mermaids_boots", () -> new MTAArmor(MtaArmorMats.MYSTIC_MERMAID, ArmorType.BOOTS, new Item.Properties().fireResistant().durability(ArmorType.BOOTS.getDurability(49))));

    public static final DeferredItem<MTAArmor> SILENT_REAPERS_HELMET = ITEMS.register("silent_reapers_helmet", () -> new MTAArmor(MtaArmorMats.SILENT_REAPER, ArmorType.HELMET, new Item.Properties().fireResistant().durability(ArmorType.HELMET.getDurability(41))));
    public static final DeferredItem<MTAArmor> SILENT_REAPERS_CHESTPLATE = ITEMS.register("silent_reapers_chestplate", () -> new MTAArmor(MtaArmorMats.SILENT_REAPER, ArmorType.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorType.CHESTPLATE.getDurability(41))));
    public static final DeferredItem<MTAArmor> SILENT_REAPERS_LEGGINGS = ITEMS.register("silent_reapers_leggings", () -> new MTAArmor(MtaArmorMats.SILENT_REAPER,ArmorType.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorType.LEGGINGS.getDurability(41))));
    public static final DeferredItem<MTAArmor> SILENT_REAPERS_BOOTS = ITEMS.register("silent_reapers_boots", () -> new MTAArmor(MtaArmorMats.SILENT_REAPER, ArmorType.BOOTS, new Item.Properties().fireResistant().durability(ArmorType.BOOTS.getDurability(41))));

    public static final DeferredItem<MTAArmor> TEMPLE_ANGELS_HELMET = ITEMS.register("temple_angels_helmet", () -> new MTAArmor(MtaArmorMats.TEMPLE_ANGEL, ArmorType.HELMET, new Item.Properties().fireResistant().durability(ArmorType.HELMET.getDurability(45))));
    public static final DeferredItem<MTAArmor> TEMPLE_ANGELS_CHESTPLATE = ITEMS.register("temple_angels_chestplate", () -> new MTAArmor(MtaArmorMats.TEMPLE_ANGEL, ArmorType.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorType.CHESTPLATE.getDurability(45))));
    public static final DeferredItem<MTAArmor> TEMPLE_ANGELS_LEGGINGS = ITEMS.register("temple_angels_leggings", () -> new MTAArmor(MtaArmorMats.TEMPLE_ANGEL, ArmorType.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorType.LEGGINGS.getDurability(45))));
    public static final DeferredItem<MTAArmor> TEMPLE_ANGELS_BOOTS = ITEMS.register("temple_angels_boots", () -> new MTAArmor(MtaArmorMats.TEMPLE_ANGEL, ArmorType.BOOTS, new Item.Properties().fireResistant().durability(ArmorType.BOOTS.getDurability(45))));

    public static final DeferredItem<MTAArmor> FREEZING_ICICLE_HELMET = ITEMS.register("freezing_icicle_helmet", () -> new MTAArmor(MtaArmorMats.FREEZING_ICICLE, ArmorType.HELMET, new Item.Properties().fireResistant().durability(ArmorType.HELMET.getDurability(45))));
    public static final DeferredItem<MTAArmor> FREEZING_ICICLE_CHESTPLATE = ITEMS.register("freezing_icicle_chestplate", () -> new MTAArmor(MtaArmorMats.FREEZING_ICICLE, ArmorType.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorType.CHESTPLATE.getDurability(45))));
    public static final DeferredItem<MTAArmor> FREEZING_ICICLE_LEGGINGS = ITEMS.register("freezing_icicle_leggings", () -> new MTAArmor(MtaArmorMats.FREEZING_ICICLE, ArmorType.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorType.LEGGINGS.getDurability(45))));
    public static final DeferredItem<MTAArmor> FREEZING_ICICLE_BOOTS = ITEMS.register("freezing_icicle_boots", () -> new MTAArmor(MtaArmorMats.FREEZING_ICICLE, ArmorType.BOOTS, new Item.Properties().fireResistant().durability(ArmorType.BOOTS.getDurability(45))));

    public static final DeferredItem<MTAArmor> WRATHFUL_BERSERKERS_HELMET = ITEMS.register("wrathful_berserkers_helmet", () -> new MTAArmor(MtaArmorMats.WRATHFUL_BERSERKER, ArmorType.HELMET, new Item.Properties().fireResistant().durability(ArmorType.HELMET.getDurability(43))));
    public static final DeferredItem<MTAArmor> WRATHFUL_BERSERKERS_CHESTPLATE = ITEMS.register("wrathful_berserkers_chestplate", () -> new MTAArmor(MtaArmorMats.WRATHFUL_BERSERKER, ArmorType.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorType.CHESTPLATE.getDurability(43))));
    public static final DeferredItem<MTAArmor> WRATHFUL_BERSERKERS_LEGGINGS = ITEMS.register("wrathful_berserkers_leggings", () -> new MTAArmor(MtaArmorMats.WRATHFUL_BERSERKER, ArmorType.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorType.LEGGINGS.getDurability(43))));
    public static final DeferredItem<MTAArmor> WRATHFUL_BERSERKERS_BOOTS = ITEMS.register("wrathful_berserkers_boots", () -> new MTAArmor(MtaArmorMats.WRATHFUL_BERSERKER, ArmorType.BOOTS, new Item.Properties().fireResistant().durability(ArmorType.BOOTS.getDurability(43))));

    public static final DeferredItem<MTAArmor> SHADOW_ROGUES_HELMET = ITEMS.register("shadow_rogues_helmet", () -> new MTAArmor(MtaArmorMats.SHADOW_ROGUE, ArmorType.HELMET, new Item.Properties().fireResistant().durability(ArmorType.HELMET.getDurability(39))));
    public static final DeferredItem<MTAArmor> SHADOW_ROGUES_CHESTPLATE = ITEMS.register("shadow_rogues_chestplate", () -> new MTAArmor(MtaArmorMats.SHADOW_ROGUE,ArmorType.CHESTPLATE, new Item.Properties().fireResistant().durability(ArmorType.CHESTPLATE.getDurability(39))));
    public static final DeferredItem<MTAArmor> SHADOW_ROGUES_LEGGINGS = ITEMS.register("shadow_rogues_leggings", () -> new MTAArmor(MtaArmorMats.SHADOW_ROGUE, ArmorType.LEGGINGS, new Item.Properties().fireResistant().durability(ArmorType.LEGGINGS.getDurability(39))));
    public static final DeferredItem<MTAArmor> SHADOW_ROGUES_BOOTS = ITEMS.register("shadow_rogues_boots", () -> new MTAArmor(MtaArmorMats.SHADOW_ROGUE, ArmorType.BOOTS, new Item.Properties().durability(ArmorType.BOOTS.getDurability(39))));


    public static final DeferredItem<PickaxeItem> COPPER_PICKAXE = ITEMS.register("copper_pickaxe", () -> new PickaxeItem(MTAToolMaterials.COPPER, 1.0F, -2.8F, new Item.Properties()));
    public static final DeferredItem<AxeItem> COPPER_AXE = ITEMS.register("copper_axe", () -> new AxeItem(MTAToolMaterials.COPPER, 1.0F, -2.8F, new Item.Properties()));
    public static final DeferredItem<ShovelItem> COPPER_SHOVEL = ITEMS.register("copper_shovel", () -> new ShovelItem(MTAToolMaterials.COPPER, 1.5F, -3F, new Item.Properties()));
    public static final DeferredItem<HoeItem> COPPER_HOE = ITEMS.register("copper_hoe", () -> new HoeItem(MTAToolMaterials.COPPER, 1.5F, -3F, new Item.Properties()));


    public static final DeferredItem<PickaxeItem> NETHERSTEEL_PICKAXE = ITEMS.register("nethersteel_pickaxe", () -> new PickaxeItem(MTAToolMaterials.NETHERSTEEL,1.0F, -2.8F, new Item.Properties()));
    public static final DeferredItem<AxeItem> NETHERSTEEL_AXE = ITEMS.register("nethersteel_axe", () -> new AxeItem(MTAToolMaterials.NETHERSTEEL, 1.5F, -2.8F, new Item.Properties()));
    public static final DeferredItem<ShovelItem> NETHERSTEEL_SHOVEL = ITEMS.register("nethersteel_shovel", () -> new ShovelItem(MTAToolMaterials.NETHERSTEEL, 1.5F, -3F, new Item.Properties()));
    public static final DeferredItem<HoeItem> NETHERSTEEL_HOE = ITEMS.register("nethersteel_hoe", () -> new HoeItem(MTAToolMaterials.NETHERSTEEL, 1.5F, -3F, new Item.Properties()));



    //WEAPONS

    //SPECIAL WEAPONS
    public static final DeferredItem<SentinelsWarHammerItem> GREAT_SENTINELS_WAR_HAMMER = ITEMS.register("great_sentinels_war_hammer",
            () -> new SentinelsWarHammerItem(
                    new Item.Properties()
                            .durability(8192)
                            .component(DataComponents.TOOL, SentinelsWarHammerItem.createToolProperties())
            ));

    public static final DeferredItem<KnightGreatswordItem> HOLY_KNIGHTS_GREATSWORD = ITEMS.register("holy_knights_greatsword",
            () -> new KnightGreatswordItem(MTAToolMaterials.ALEXANDRITE,
                    new Item.Properties()
            ));
    public static final DeferredItem<MermaidTridentItem> MYSTIC_MERMAIDS_TRIDENT = ITEMS.register("mystic_mermaids_trident",
            () -> new MermaidTridentItem(
                    new Item.Properties()
                            .durability(7108)
                            .attributes(MermaidTridentItem.createAttributes())
            ));
    public static final DeferredItem<ReaperScytheItem> SILENT_REAPERS_SCYTHE = ITEMS.register("silent_reaper_scythe",
            () -> new ReaperScytheItem(MTAToolMaterials.BLOODSTONE,
                    new Item.Properties()
            ));
    public static final DeferredItem<AngelBowItem> TEMPLE_ANGELS_BOW = ITEMS.register("temple_angels_bow",
            () -> new AngelBowItem(
                    new Item.Properties()
                            .durability(6760)
            ));
    public static final DeferredItem<SwordItem> FREEZING_ICICLE_SPEAR = ITEMS.register("freezing_icicle_spear",
            () -> new FreezingIcicleSpearItem(MTAToolMaterials.CRYOLITE,
                    new Item.Properties()
                            .durability(6760)
            ));
    public static final DeferredItem<BerserkerBattleAxeItem> WRATHFUL_BERSERKERS_BATTLEAXE = ITEMS.register("wrathful_berserkers_battleaxe",
            () -> new BerserkerBattleAxeItem(MTAToolMaterials.GARNET,
                    new Item.Properties()
            ));
    public static final DeferredItem<RogueDaggerItem> SHADOW_ROGUES_DAGGER = ITEMS.register("shadow_rogues_dagger",
            () -> new RogueDaggerItem(MTAToolMaterials.MOONSTONE,
                    new Item.Properties()
            ));
    public static final DeferredItem<ClawItem> WOOD_CLAW = ITEMS.register("wood_claw",
            () -> new ClawItem(ToolMaterial.WOOD,
                    new Item.Properties().attributes(ClawItem.createAttributes(ToolMaterial.WOOD))
            ));
    public static final DeferredItem<ClaymoreItem> WOOD_CLAYMORE = ITEMS.register("wood_claymore",
            () -> new ClaymoreItem(ToolMaterial.WOOD,
                    new Item.Properties().attributes(ClaymoreItem.createAttributes(ToolMaterial.WOOD))
            ));
    public static final DeferredItem<CutlassItem> WOOD_CUTLASS = ITEMS.register("wood_cutlass",
            () -> new CutlassItem(ToolMaterial.WOOD,
                    new Item.Properties().attributes(CutlassItem.createAttributes(ToolMaterial.WOOD))
            ));
    public static final DeferredItem<DaggerItem> WOOD_DAGGER = ITEMS.register("wood_dagger",
            () -> new DaggerItem(ToolMaterial.WOOD,
                    new Item.Properties().attributes(DaggerItem.createAttributes(ToolMaterial.WOOD))
            ));
    public static final DeferredItem<DoubleAxeItem> WOOD_DOUBLE_AXE = ITEMS.register("wood_double_axe",
            () -> new DoubleAxeItem(ToolMaterial.WOOD,
                    new Item.Properties().attributes(DoubleAxeItem.createAttributes(ToolMaterial.WOOD))
            ));
    public static final DeferredItem<GlaiveItem> WOOD_GLAIVE = ITEMS.register("wood_glaive",
            () -> new GlaiveItem(ToolMaterial.WOOD,
                    new Item.Properties().attributes(GlaiveItem.createAttributes(ToolMaterial.WOOD))
            ));
    public static final DeferredItem<HalberdItem> WOOD_HALBERD = ITEMS.register("wood_halberd",
            () -> new HalberdItem(ToolMaterial.WOOD,
                    new Item.Properties().attributes(HalberdItem.createAttributes(ToolMaterial.WOOD))
            ));
    public static final DeferredItem<KatanaItem> WOOD_KATANA = ITEMS.register("wood_katana",
            () -> new KatanaItem(ToolMaterial.WOOD,
                    new Item.Properties().attributes(KatanaItem.createAttributes(ToolMaterial.WOOD))
            ));
    public static final DeferredItem<ScytheItem> WOOD_SCYTHE = ITEMS.register("wood_scythe",
            () -> new ScytheItem(ToolMaterial.WOOD,
                    new Item.Properties().attributes(ScytheItem.createAttributes(ToolMaterial.WOOD))
            ));
    public static final DeferredItem<SpearItem> WOOD_SPEAR = ITEMS.register("wood_spear",
            () -> new SpearItem(ToolMaterial.WOOD,
                    new Item.Properties().attributes(SpearItem.createAttributes(ToolMaterial.WOOD))
            ));
    public static final DeferredItem<TwinbladeItem> WOOD_TWINBLADE = ITEMS.register("wood_twinblade",
            () -> new TwinbladeItem(ToolMaterial.WOOD,
                    new Item.Properties().attributes(TwinbladeItem.createAttributes(ToolMaterial.WOOD))
            ));
    public static final DeferredItem<ClawItem> STONE_CLAW = ITEMS.register("stone_claw",
            () -> new ClawItem(ToolMaterial.STONE,
                    new Item.Properties().attributes(ClawItem.createAttributes(ToolMaterial.STONE))
            ));
    public static final DeferredItem<ClaymoreItem> STONE_CLAYMORE = ITEMS.register("stone_claymore",
            () -> new ClaymoreItem(ToolMaterial.STONE,
                    new Item.Properties().attributes(ClaymoreItem.createAttributes(ToolMaterial.STONE))
            ));
    public static final DeferredItem<CutlassItem> STONE_CUTLASS = ITEMS.register("stone_cutlass",
            () -> new CutlassItem(ToolMaterial.STONE,
                    new Item.Properties().attributes(CutlassItem.createAttributes(ToolMaterial.STONE))
            ));
    public static final DeferredItem<DaggerItem> STONE_DAGGER = ITEMS.register("stone_dagger",
            () -> new DaggerItem(ToolMaterial.STONE,
                    new Item.Properties().attributes(DaggerItem.createAttributes(ToolMaterial.STONE))
            ));
    public static final DeferredItem<DoubleAxeItem> STONE_DOUBLE_AXE = ITEMS.register("stone_double_axe",
            () -> new DoubleAxeItem(ToolMaterial.STONE,
                    new Item.Properties().attributes(DoubleAxeItem.createAttributes(ToolMaterial.STONE))
            ));
    public static final DeferredItem<GlaiveItem> STONE_GLAIVE = ITEMS.register("stone_glaive",
            () -> new GlaiveItem(ToolMaterial.STONE,
                    new Item.Properties().attributes(GlaiveItem.createAttributes(ToolMaterial.STONE))
            ));
    public static final DeferredItem<HalberdItem> STONE_HALBERD = ITEMS.register("stone_halberd",
            () -> new HalberdItem(ToolMaterial.STONE,
                    new Item.Properties().attributes(HalberdItem.createAttributes(ToolMaterial.STONE))
            ));
    public static final DeferredItem<KatanaItem> STONE_KATANA = ITEMS.register("stone_katana",
            () -> new KatanaItem(ToolMaterial.STONE,
                    new Item.Properties().attributes(KatanaItem.createAttributes(ToolMaterial.STONE))
            ));
    public static final DeferredItem<ScytheItem> STONE_SCYTHE = ITEMS.register("stone_scythe",
            () -> new ScytheItem(ToolMaterial.STONE,
                    new Item.Properties().attributes(ScytheItem.createAttributes(ToolMaterial.STONE))
            ));
    public static final DeferredItem<SpearItem> STONE_SPEAR = ITEMS.register("stone_spear",
            () -> new SpearItem(ToolMaterial.STONE,
                    new Item.Properties().attributes(SpearItem.createAttributes(ToolMaterial.STONE))
            ));
    public static final DeferredItem<TwinbladeItem> STONE_TWINBLADE = ITEMS.register("stone_twinblade",
            () -> new TwinbladeItem(ToolMaterial.STONE,
                    new Item.Properties().attributes(TwinbladeItem.createAttributes(ToolMaterial.STONE))
            ));
    public static final DeferredItem<SwordItem> COPPER_SWORD = ITEMS.register("copper_sword",
            () -> new SwordItem(MTAToolMaterials.COPPER, 3.0F, -2.4F,
                    new Item.Properties()));

    public static final DeferredItem<ClawItem> COPPER_CLAW = ITEMS.register("copper_claw",
            () -> new ClawItem(MTAToolMaterials.COPPER,
                    new Item.Properties().attributes(ClawItem.createAttributes(MTAToolMaterials.COPPER))
            ));
    public static final DeferredItem<ClaymoreItem> COPPER_CLAYMORE = ITEMS.register("copper_claymore",
            () -> new ClaymoreItem(MTAToolMaterials.COPPER,
                    new Item.Properties().attributes(ClaymoreItem.createAttributes(MTAToolMaterials.COPPER))
            ));
    public static final DeferredItem<CutlassItem> COPPER_CUTLASS = ITEMS.register("copper_cutlass",
            () -> new CutlassItem(MTAToolMaterials.COPPER,
                    new Item.Properties().attributes(CutlassItem.createAttributes(MTAToolMaterials.COPPER))
            ));
    public static final DeferredItem<DaggerItem> COPPER_DAGGER = ITEMS.register("copper_dagger",
            () -> new DaggerItem(MTAToolMaterials.COPPER,
                    new Item.Properties().attributes(DaggerItem.createAttributes(MTAToolMaterials.COPPER))
            ));
    public static final DeferredItem<DoubleAxeItem> COPPER_DOUBLE_AXE = ITEMS.register("copper_double_axe",
            () -> new DoubleAxeItem(MTAToolMaterials.COPPER,
                    new Item.Properties().attributes(DoubleAxeItem.createAttributes(MTAToolMaterials.COPPER))
            ));
    public static final DeferredItem<GlaiveItem> COPPER_GLAIVE = ITEMS.register("copper_glaive",
            () -> new GlaiveItem(MTAToolMaterials.COPPER,
                    new Item.Properties().attributes(GlaiveItem.createAttributes(MTAToolMaterials.COPPER))
            ));
    public static final DeferredItem<HalberdItem> COPPER_HALBERD = ITEMS.register("copper_halberd",
            () -> new HalberdItem(MTAToolMaterials.COPPER,
                    new Item.Properties().attributes(HalberdItem.createAttributes(MTAToolMaterials.COPPER))
            ));
    public static final DeferredItem<KatanaItem> COPPER_KATANA = ITEMS.register("copper_katana",
            () -> new KatanaItem(MTAToolMaterials.COPPER,
                    new Item.Properties().attributes(KatanaItem.createAttributes(MTAToolMaterials.COPPER))
            ));
    public static final DeferredItem<ScytheItem> COPPER_SCYTHE = ITEMS.register("copper_scythe",
            () -> new ScytheItem(MTAToolMaterials.COPPER,
                    new Item.Properties().attributes(ScytheItem.createAttributes(MTAToolMaterials.COPPER))
            ));
    public static final DeferredItem<SpearItem> COPPER_SPEAR = ITEMS.register("copper_spear",
            () -> new SpearItem(MTAToolMaterials.COPPER,
                    new Item.Properties().attributes(SpearItem.createAttributes(MTAToolMaterials.COPPER))
            ));
    public static final DeferredItem<TwinbladeItem> COPPER_TWINBLADE = ITEMS.register("copper_twinblade",
            () -> new TwinbladeItem(MTAToolMaterials.COPPER,
                    new Item.Properties().attributes(TwinbladeItem.createAttributes(MTAToolMaterials.COPPER))
            ));
    public static final DeferredItem<ClawItem> IRON_CLAW = ITEMS.register("iron_claw",
            () -> new ClawItem(ToolMaterial.IRON,
                new Item.Properties().attributes(ClawItem.createAttributes(ToolMaterial.IRON))
            ));
    public static final DeferredItem<ClaymoreItem> IRON_CLAYMORE = ITEMS.register("iron_claymore",
            () -> new ClaymoreItem(ToolMaterial.IRON,
                    new Item.Properties().attributes(ClaymoreItem.createAttributes(ToolMaterial.IRON))
            ));
    public static final DeferredItem<CutlassItem> IRON_CUTLASS = ITEMS.register("iron_cutlass",
            () -> new CutlassItem(ToolMaterial.IRON,
                    new Item.Properties().attributes(CutlassItem.createAttributes(ToolMaterial.IRON))
            ));
    public static final DeferredItem<DaggerItem> IRON_DAGGER = ITEMS.register("iron_dagger",
            () -> new DaggerItem(ToolMaterial.IRON,
                    new Item.Properties().attributes(DaggerItem.createAttributes(ToolMaterial.IRON))
            ));
    public static final DeferredItem<DoubleAxeItem> IRON_DOUBLE_AXE = ITEMS.register("iron_double_axe",
            () -> new DoubleAxeItem(ToolMaterial.IRON,
                    new Item.Properties().attributes(DoubleAxeItem.createAttributes(ToolMaterial.IRON))
            ));
    public static final DeferredItem<GlaiveItem> IRON_GLAIVE = ITEMS.register("iron_glaive",
            () -> new GlaiveItem(ToolMaterial.IRON,
                    new Item.Properties().attributes(GlaiveItem.createAttributes(ToolMaterial.IRON))
            ));
    public static final DeferredItem<HalberdItem> IRON_HALBERD = ITEMS.register("iron_halberd",
            () -> new HalberdItem(ToolMaterial.IRON,
                    new Item.Properties().attributes(HalberdItem.createAttributes(ToolMaterial.IRON))
            ));
    public static final DeferredItem<KatanaItem> IRON_KATANA = ITEMS.register("iron_katana",
            () -> new KatanaItem(ToolMaterial.IRON,
                    new Item.Properties().attributes(KatanaItem.createAttributes(ToolMaterial.IRON))
            ));
    public static final DeferredItem<ScytheItem> IRON_SCYTHE = ITEMS.register("iron_scythe",
            () -> new ScytheItem(ToolMaterial.IRON,
                    new Item.Properties().attributes(ScytheItem.createAttributes(ToolMaterial.IRON))
            ));
    public static final DeferredItem<SpearItem> IRON_SPEAR = ITEMS.register("iron_spear",
            () -> new SpearItem(ToolMaterial.IRON,
                    new Item.Properties().attributes(SpearItem.createAttributes(ToolMaterial.IRON))
            ));
    public static final DeferredItem<TwinbladeItem> IRON_TWINBLADE = ITEMS.register("iron_twinblade",
            () -> new TwinbladeItem(ToolMaterial.IRON,
                    new Item.Properties().attributes(TwinbladeItem.createAttributes(ToolMaterial.IRON))
            ));
    public static final DeferredItem<ClawItem> GOLD_CLAW = ITEMS.register("gold_claw",
            () -> new ClawItem(ToolMaterial.GOLD,
                    new Item.Properties().attributes(ClawItem.createAttributes(ToolMaterial.GOLD))
            ));
    public static final DeferredItem<ClaymoreItem> GOLD_CLAYMORE = ITEMS.register("gold_claymore",
            () -> new ClaymoreItem(ToolMaterial.GOLD,
                    new Item.Properties().attributes(ClaymoreItem.createAttributes(ToolMaterial.GOLD))
            ));
    public static final DeferredItem<CutlassItem> GOLD_CUTLASS = ITEMS.register("gold_cutlass",
            () -> new CutlassItem(ToolMaterial.GOLD,
                    new Item.Properties().attributes(CutlassItem.createAttributes(ToolMaterial.GOLD))
            ));
    public static final DeferredItem<DaggerItem> GOLD_DAGGER = ITEMS.register("gold_dagger",
            () -> new DaggerItem(ToolMaterial.GOLD,
                    new Item.Properties().attributes(DaggerItem.createAttributes(ToolMaterial.GOLD))
            ));
    public static final DeferredItem<DoubleAxeItem> GOLD_DOUBLE_AXE = ITEMS.register("gold_double_axe",
            () -> new DoubleAxeItem(ToolMaterial.GOLD,
                    new Item.Properties().attributes(DoubleAxeItem.createAttributes(ToolMaterial.GOLD))
            ));
    public static final DeferredItem<GlaiveItem> GOLD_GLAIVE = ITEMS.register("gold_glaive",
            () -> new GlaiveItem(ToolMaterial.GOLD,
                    new Item.Properties().attributes(GlaiveItem.createAttributes(ToolMaterial.GOLD))
            ));
    public static final DeferredItem<HalberdItem> GOLD_HALBERD = ITEMS.register("gold_halberd",
            () -> new HalberdItem(ToolMaterial.GOLD,
                    new Item.Properties().attributes(HalberdItem.createAttributes(ToolMaterial.GOLD))
            ));
    public static final DeferredItem<KatanaItem> GOLD_KATANA = ITEMS.register("gold_katana",
            () -> new KatanaItem(ToolMaterial.GOLD,
                    new Item.Properties().attributes(KatanaItem.createAttributes(ToolMaterial.GOLD))
            ));
    public static final DeferredItem<ScytheItem> GOLD_SCYTHE = ITEMS.register("gold_scythe",
            () -> new ScytheItem(ToolMaterial.GOLD,
                    new Item.Properties().attributes(ScytheItem.createAttributes(ToolMaterial.GOLD))
            ));
    public static final DeferredItem<SpearItem> GOLD_SPEAR = ITEMS.register("gold_spear",
            () -> new SpearItem(ToolMaterial.GOLD,
                    new Item.Properties().attributes(SpearItem.createAttributes(ToolMaterial.GOLD))
            ));
    public static final DeferredItem<TwinbladeItem> GOLD_TWINBLADE = ITEMS.register("gold_twinblade",
            () -> new TwinbladeItem(ToolMaterial.GOLD,
                    new Item.Properties().attributes(TwinbladeItem.createAttributes(ToolMaterial.GOLD))
            ));
    public static final DeferredItem<SwordItem> NETHERSTEEL_SWORD = ITEMS.register("nethersteel_sword",
            () -> new SwordItem(MTAToolMaterials.NETHERSTEEL, 3.0F, -2.4F,
                    new Item.Properties()));

    public static final DeferredItem<ClawItem> NETHERSTEEL_CLAW = ITEMS.register("nethersteel_claw",
            () -> new ClawItem(MTAToolMaterials.NETHERSTEEL,
                    new Item.Properties().attributes(ClawItem.createAttributes(MTAToolMaterials.NETHERSTEEL))
            ));
    public static final DeferredItem<ClaymoreItem> NETHERSTEEL_CLAYMORE = ITEMS.register("nethersteel_claymore",
            () -> new ClaymoreItem(MTAToolMaterials.NETHERSTEEL,
                    new Item.Properties().attributes(ClaymoreItem.createAttributes(MTAToolMaterials.NETHERSTEEL))
            ));
    public static final DeferredItem<CutlassItem> NETHERSTEEL_CUTLASS = ITEMS.register("nethersteel_cutlass",
            () -> new CutlassItem(MTAToolMaterials.NETHERSTEEL,
                    new Item.Properties().attributes(CutlassItem.createAttributes(MTAToolMaterials.NETHERSTEEL))
            ));
    public static final DeferredItem<DaggerItem> NETHERSTEEL_DAGGER = ITEMS.register("nethersteel_dagger",
            () -> new DaggerItem(MTAToolMaterials.NETHERSTEEL,
                    new Item.Properties().attributes(DaggerItem.createAttributes(MTAToolMaterials.NETHERSTEEL))
            ));
    public static final DeferredItem<DoubleAxeItem> NETHERSTEEL_DOUBLE_AXE = ITEMS.register("nethersteel_double_axe",
            () -> new DoubleAxeItem(MTAToolMaterials.NETHERSTEEL,
                    new Item.Properties().attributes(DoubleAxeItem.createAttributes(MTAToolMaterials.NETHERSTEEL))
            ));
    public static final DeferredItem<GlaiveItem> NETHERSTEEL_GLAIVE = ITEMS.register("nethersteel_glaive",
            () -> new GlaiveItem(MTAToolMaterials.NETHERSTEEL,
                    new Item.Properties().attributes(GlaiveItem.createAttributes(MTAToolMaterials.NETHERSTEEL))
            ));
    public static final DeferredItem<HalberdItem> NETHERSTEEL_HALBERD = ITEMS.register("nethersteel_halberd",
            () -> new HalberdItem(MTAToolMaterials.NETHERSTEEL,
                    new Item.Properties().attributes(HalberdItem.createAttributes(MTAToolMaterials.NETHERSTEEL))
            ));
    public static final DeferredItem<KatanaItem> NETHERSTEEL_KATANA = ITEMS.register("nethersteel_katana",
            () -> new KatanaItem(MTAToolMaterials.NETHERSTEEL,
                    new Item.Properties().attributes(KatanaItem.createAttributes(MTAToolMaterials.NETHERSTEEL))
            ));
    public static final DeferredItem<ScytheItem> NETHERSTEEL_SCYTHE = ITEMS.register("nethersteel_scythe",
            () -> new ScytheItem(MTAToolMaterials.NETHERSTEEL,
                    new Item.Properties().attributes(ScytheItem.createAttributes(MTAToolMaterials.NETHERSTEEL))
            ));
    public static final DeferredItem<SpearItem> NETHERSTEEL_SPEAR = ITEMS.register("nethersteel_spear",
            () -> new SpearItem(MTAToolMaterials.NETHERSTEEL,
                    new Item.Properties().attributes(SpearItem.createAttributes(MTAToolMaterials.NETHERSTEEL))
            ));
    public static final DeferredItem<TwinbladeItem> NETHERSTEEL_TWINBLADE = ITEMS.register("nethersteel_twinblade",
            () -> new TwinbladeItem(MTAToolMaterials.NETHERSTEEL,
                    new Item.Properties().attributes(TwinbladeItem.createAttributes(MTAToolMaterials.NETHERSTEEL))
            ));
    public static final DeferredItem<ClawItem> DIAMOND_CLAW = ITEMS.register("diamond_claw",
            () -> new ClawItem(ToolMaterial.DIAMOND,
                    new Item.Properties().attributes(ClawItem.createAttributes(ToolMaterial.DIAMOND))
            ));
    public static final DeferredItem<ClaymoreItem> DIAMOND_CLAYMORE = ITEMS.register("diamond_claymore",
            () -> new ClaymoreItem(ToolMaterial.DIAMOND,
                    new Item.Properties().attributes(ClaymoreItem.createAttributes(ToolMaterial.DIAMOND))
            ));
    public static final DeferredItem<CutlassItem> DIAMOND_CUTLASS = ITEMS.register("diamond_cutlass",
            () -> new CutlassItem(ToolMaterial.DIAMOND,
                    new Item.Properties().attributes(CutlassItem.createAttributes(ToolMaterial.DIAMOND))
            ));
    public static final DeferredItem<DaggerItem> DIAMOND_DAGGER = ITEMS.register("diamond_dagger",
            () -> new DaggerItem(ToolMaterial.DIAMOND,
                    new Item.Properties().attributes(DaggerItem.createAttributes(ToolMaterial.DIAMOND))
            ));
    public static final DeferredItem<DoubleAxeItem> DIAMOND_DOUBLE_AXE = ITEMS.register("diamond_double_axe",
            () -> new DoubleAxeItem(ToolMaterial.DIAMOND,
                    new Item.Properties().attributes(DoubleAxeItem.createAttributes(ToolMaterial.DIAMOND))
            ));
    public static final DeferredItem<GlaiveItem> DIAMOND_GLAIVE = ITEMS.register("diamond_glaive",
            () -> new GlaiveItem(ToolMaterial.DIAMOND,
                    new Item.Properties().attributes(GlaiveItem.createAttributes(ToolMaterial.DIAMOND))
            ));
    public static final DeferredItem<HalberdItem> DIAMOND_HALBERD = ITEMS.register("diamond_halberd",
            () -> new HalberdItem(ToolMaterial.DIAMOND,
                    new Item.Properties().attributes(HalberdItem.createAttributes(ToolMaterial.DIAMOND))
            ));
    public static final DeferredItem<KatanaItem> DIAMOND_KATANA = ITEMS.register("diamond_katana",
            () -> new KatanaItem(ToolMaterial.DIAMOND,
                    new Item.Properties().attributes(KatanaItem.createAttributes(ToolMaterial.DIAMOND))
            ));
    public static final DeferredItem<ScytheItem> DIAMOND_SCYTHE = ITEMS.register("diamond_scythe",
            () -> new ScytheItem(ToolMaterial.DIAMOND,
                    new Item.Properties().attributes(ScytheItem.createAttributes(ToolMaterial.DIAMOND))
            ));
    public static final DeferredItem<SpearItem> DIAMOND_SPEAR = ITEMS.register("diamond_spear",
            () -> new SpearItem(ToolMaterial.DIAMOND,
                    new Item.Properties().attributes(SpearItem.createAttributes(ToolMaterial.DIAMOND))
            ));
    public static final DeferredItem<TwinbladeItem> DIAMOND_TWINBLADE = ITEMS.register("diamond_twinblade",
            () -> new TwinbladeItem(ToolMaterial.DIAMOND,
                    new Item.Properties().attributes(TwinbladeItem.createAttributes(ToolMaterial.DIAMOND))
            ));
    public static final DeferredItem<NetheriteTridentItem> NETHERITE_TRIDENT = ITEMS.register("netherite_trident",
            () -> new NetheriteTridentItem(
                    new Item.Properties().durability(2031).attributes(NetheriteTridentItem.createAttributes()).component(DataComponents.TOOL, NetheriteTridentItem.createToolProperties())));
    public static final DeferredItem<NetheriteBowItem> NETHERITE_BOW = ITEMS.register("netherite_bow",
            () -> new NetheriteBowItem(
                    new Item.Properties().durability(2031)));

    public static final DeferredItem<ClawItem> NETHERITE_CLAW = ITEMS.register("netherite_claw",
            () -> new ClawItem(ToolMaterial.NETHERITE,
                    new Item.Properties().attributes(ClawItem.createAttributes(ToolMaterial.NETHERITE))
            ));
    public static final DeferredItem<ClaymoreItem> NETHERITE_CLAYMORE = ITEMS.register("netherite_claymore",
            () -> new ClaymoreItem(ToolMaterial.NETHERITE,
                    new Item.Properties().attributes(ClaymoreItem.createAttributes(ToolMaterial.NETHERITE))
            ));
    public static final DeferredItem<CutlassItem> NETHERITE_CUTLASS = ITEMS.register("netherite_cutlass",
            () -> new CutlassItem(ToolMaterial.NETHERITE,
                    new Item.Properties().attributes(CutlassItem.createAttributes(ToolMaterial.NETHERITE))
            ));
    public static final DeferredItem<DaggerItem> NETHERITE_DAGGER = ITEMS.register("netherite_dagger",
            () -> new DaggerItem(ToolMaterial.NETHERITE,
                    new Item.Properties().attributes(DaggerItem.createAttributes(ToolMaterial.NETHERITE))
            ));
    public static final DeferredItem<DoubleAxeItem> NETHERITE_DOUBLE_AXE = ITEMS.register("netherite_double_axe",
            () -> new DoubleAxeItem(ToolMaterial.NETHERITE,
                    new Item.Properties().attributes(DoubleAxeItem.createAttributes(ToolMaterial.NETHERITE))
            ));
    public static final DeferredItem<GlaiveItem> NETHERITE_GLAIVE = ITEMS.register("netherite_glaive",
            () -> new GlaiveItem(ToolMaterial.NETHERITE,
                    new Item.Properties().attributes(GlaiveItem.createAttributes(ToolMaterial.NETHERITE))
            ));
    public static final DeferredItem<HalberdItem> NETHERITE_HALBERD = ITEMS.register("netherite_halberd",
            () -> new HalberdItem(ToolMaterial.NETHERITE,
                    new Item.Properties().attributes(HalberdItem.createAttributes(ToolMaterial.NETHERITE))
            ));
    public static final DeferredItem<KatanaItem> NETHERITE_KATANA = ITEMS.register("netherite_katana",
            () -> new KatanaItem(ToolMaterial.NETHERITE,
                    new Item.Properties().attributes(KatanaItem.createAttributes(ToolMaterial.NETHERITE))
            ));
    public static final DeferredItem<ScytheItem> NETHERITE_SCYTHE = ITEMS.register("netherite_scythe",
            () -> new ScytheItem(ToolMaterial.NETHERITE,
                    new Item.Properties().attributes(ScytheItem.createAttributes(ToolMaterial.NETHERITE))
            ));
    public static final DeferredItem<SpearItem> NETHERITE_SPEAR = ITEMS.register("netherite_spear",
            () -> new SpearItem(ToolMaterial.NETHERITE,
                    new Item.Properties().attributes(SpearItem.createAttributes(ToolMaterial.NETHERITE))
            ));
    public static final DeferredItem<TwinbladeItem> NETHERITE_TWINBLADE = ITEMS.register("netherite_twinblade",
            () -> new TwinbladeItem(ToolMaterial.NETHERITE,
                    new Item.Properties().attributes(TwinbladeItem.createAttributes(ToolMaterial.NETHERITE))
            ));



    //FOODS
    public static final DeferredItem<Item> ONION = ITEMS.register("onion", () -> new BlockItem(MtaBlocks.ONION_CROP.get(), new Item.Properties().food(MtaFoods.ONION)));
    public static final DeferredItem<Item> SHRIMP = ITEMS.registerSimpleItem("shrimp", new Item.Properties().food(MtaFoods.SHRIMP));
    public static final DeferredItem<Item> COOKED_SHRIMP = ITEMS.registerSimpleItem("cooked_shrimp", new Item.Properties().food(MtaFoods.COOKED_SHRIMP));
    public static final DeferredItem<Item> TOMATO = ITEMS.registerSimpleItem("tomato", new Item.Properties().food(MtaFoods.TOMATO));
    public static final DeferredItem<Item> TOMATO_SEEDS = ITEMS.register("tomato_seeds", () -> new BlockItem(MtaBlocks.TOMATO_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> BELL_PEPPER = ITEMS.registerSimpleItem("bell_pepper", new Item.Properties().food(MtaFoods.BELL_PEPPER));
    public static final DeferredItem<Item> BELL_PEPPER_SEEDS = ITEMS.register("bell_pepper_seeds", () -> new BlockItem(MtaBlocks.BELL_PEPPER_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> CHILI_PEPPER = ITEMS.registerSimpleItem("chili_pepper", new Item.Properties().food(MtaFoods.CHILI_PEPPER));
    public static final DeferredItem<Item> CHILI_PEPPER_SEEDS = ITEMS.register("chili_pepper_seeds", () -> new BlockItem(MtaBlocks.CHILI_PEPPER_CROP.get(), new Item.Properties()));
    public static final DeferredItem<Item> RICE = ITEMS.registerSimpleItem("rice", new Item.Properties());
    public static final DeferredItem<Item> ONIGIRI = ITEMS.registerSimpleItem("onigiri", new Item.Properties().food(MtaFoods.ONIGIRI));
    public static final DeferredItem<Item> COCONUT = ITEMS.register("coconut", () -> new BlockItem(MtaBlocks.PALM_SAPLING.get(), new Item.Properties()));
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
            () -> new SpawnEggItem(MtaEntityTypes.YUKI_ONNA.get(), new Item.Properties()));

    public static final DeferredItem<Item> FALLEN_SAMURAI_SPAWN_EGG =  ITEMS.register("fallen_samurai_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.FALLEN_SAMURAI.get(), new Item.Properties()));

    public static final DeferredItem<Item> ICICLE_CREEPER_SPAWN_EGG =  ITEMS.register("icicle_creeper_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.ICICLE_CREEPER.get(), new Item.Properties()));

    public static final DeferredItem<Item> BUTTERFLY_SPAWN_EGG =  ITEMS.register("butterfly_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.BUTTERFLY.get(), new Item.Properties()));

    public static final DeferredItem<Item> BEARDED_DRAGON_SPAWN_EGG =  ITEMS.register("bearded_dragon_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.BEARDED_DRAGON.get(), new Item.Properties()));

    public static final DeferredItem<Item> CAPYBARA_SPAWN_EGG =  ITEMS.register("capybara_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.CAPIBARA.get(), new Item.Properties()));

    public static final DeferredItem<Item> DEER_SPAWN_EGG =  ITEMS.register("deer_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.DEER.get(), new Item.Properties()));

    public static final DeferredItem<Item> DUCK_SPAWN_EGG =  ITEMS.register("duck_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.DUCK.get(), new Item.Properties()));

    public static final DeferredItem<Item> FERRET_SPAWN_EGG =  ITEMS.register("ferret_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.FERRET.get(), new Item.Properties()));

    public static final DeferredItem<Item> GREAT_WHITE_SHARK_SPAWN_EGG =  ITEMS.register("great_white_shark_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.GREAT_WHITE_SHARK.get(), new Item.Properties()));

    public static final DeferredItem<Item> HORSESHOE_CRAB_SPAWN_EGG =  ITEMS.register("horseshoe_crab_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.HORSESHOE_CRAB.get(), new Item.Properties()));

    public static final DeferredItem<Item> JELLYFISH_SPAWN_EGG =  ITEMS.register("jellyfish_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.JELLYFISH.get(), new Item.Properties()));

    public static final DeferredItem<Item> OCTOPUS_SPAWN_EGG =  ITEMS.register("octopus_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.OCTOPUS.get(), new Item.Properties()));

    public static final DeferredItem<Item> OWL_SPAWN_EGG =  ITEMS.register("owl_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.OWL.get(), new Item.Properties()));

    public static final DeferredItem<Item> PENGUIN_SPAWN_EGG =  ITEMS.register("penguin_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.PENGUIN.get(), new Item.Properties()));

    public static final DeferredItem<Item> RACCOON_SPAWN_EGG =  ITEMS.register("raccoon_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.RACCOON.get(), new Item.Properties()));

    public static final DeferredItem<Item> SHRIMP_SPAWN_EGG =  ITEMS.register("shrimp_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.SHRIMP.get(), new Item.Properties()));

    public static final DeferredItem<Item> TOUCAN_SPAWN_EGG =  ITEMS.register("toucan_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.TOUCAN.get(), new Item.Properties()));

    public static final DeferredItem<Item> TURKEY_SPAWN_EGG =  ITEMS.register("turkey_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.TURKEY.get(), new Item.Properties()));

    public static final DeferredItem<Item> ARMORED_SKELETON_SPAWN_EGG =  ITEMS.register("armored_skeleton_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.ARMORED_SKELETON.get(), new Item.Properties()));

    public static final DeferredItem<Item> BLACK_WIDOW_SPAWN_EGG =  ITEMS.register("black_widow_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.BLACK_WIDOW.get(), new Item.Properties()));

    public static final DeferredItem<Item> CHARRED_SKELETON_SPAWN_EGG =  ITEMS.register("charred_skeleton_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.CHARRED_SKELETON.get(), new Item.Properties()));

    public static final DeferredItem<Item> CORROSIVE_CUBE_SPAWN_EGG =  ITEMS.register("corrosive_cube_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.CORROSIVE_CUBE.get(), new Item.Properties()));

    public static final DeferredItem<Item> FROSTED_SLIME_SPAWN_EGG =  ITEMS.register("frosted_slime_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.FROSTED_SLIME.get(), new Item.Properties()));

    public static final DeferredItem<Item> GLOW_SPIDER_SPAWN_EGG =  ITEMS.register("glow_spider_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.GLOW_SPIDER.get(), new Item.Properties()));

    public static final DeferredItem<Item> HOST_SPAWN_EGG =  ITEMS.register("host_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.HOST.get(), new Item.Properties()));

    public static final DeferredItem<Item> MOSSY_ZOMBIE_SPAWN_EGG =  ITEMS.register("mossy_zombie_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.MOSSY_ZOMBIE.get(), new Item.Properties()));

    public static final DeferredItem<Item> SKELETON_FIGHTER_SPAWN_EGG =  ITEMS.register("skeleton_fighter_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.SKELETON_FIGHTER.get(), new Item.Properties()));

    public static final DeferredItem<Item> TOXIC_ZOMBIE_SPAWN_EGG =  ITEMS.register("toxic_zombie_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.TOXIC_ZOMBIE.get(), new Item.Properties()));

    public static final DeferredItem<Item> ZOMBIFIED_MINER_SPAWN_EGG =  ITEMS.register("zombified_miner_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.ZOMBIFIED_MINER.get(), new Item.Properties()));

    public static final DeferredItem<Item> SIREN_SPAWN_EGG =  ITEMS.register("siren_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.SIREN.get(), new Item.Properties()));

    public static final DeferredItem<Item> WISPFLY_SPAWN_EGG =  ITEMS.register("wispfly_spawn_egg",
            () -> new SpawnEggItem(MtaEntityTypes.WISPFLY.get(), new Item.Properties()));

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
