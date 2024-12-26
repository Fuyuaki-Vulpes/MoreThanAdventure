package com.fuyuaki.morethanadventure.core.registry;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;

public class MTAArmorMats {

    public static final ArmorMaterial GREAT_SENTINEL = new ArmorMaterial(59,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                        map.put(ArmorType.BOOTS, 4);
                        map.put(ArmorType.LEGGINGS, 7);
                        map.put(ArmorType.CHESTPLATE, 10);
                        map.put(ArmorType.HELMET, 4);
                        map.put(ArmorType.BODY, 13);
                    }),
            10, SoundEvents.ARMOR_EQUIP_NETHERITE,
            5F, 0.25F,
            MtaTags.Items.AGATE_TOOL_MATERIALS,
            MTAEquipmentAssets.GREAT_SENTINEL
    );

    public static final ArmorMaterial HOLY_KNIGHT = new ArmorMaterial(52,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 3);
                map.put(ArmorType.LEGGINGS, 7);
                map.put(ArmorType.CHESTPLATE, 9);
                map.put(ArmorType.HELMET, 4);
                map.put(ArmorType.BODY, 12);
            }),
            28, SoundEvents.ARMOR_EQUIP_IRON,
            3F, 0.11F,
            MtaTags.Items.ALEXANDRITE_TOOL_MATERIALS,
            MTAEquipmentAssets.HOLY_KNIGHT
    );

    public static final ArmorMaterial MYSTIC_MERMAID = new ArmorMaterial(49,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 3);
                map.put(ArmorType.LEGGINGS, 6);
                map.put(ArmorType.CHESTPLATE, 8);
                map.put(ArmorType.HELMET, 3);
                map.put(ArmorType.BODY, 11);
            }),
            19, SoundEvents.ARMOR_EQUIP_GENERIC,
            3F, 0.1F,
            MtaTags.Items.AQUAMARINE_TOOL_MATERIALS,
            MTAEquipmentAssets.MYSTIC_MERMAID
    );

    public static final ArmorMaterial SILENT_REAPER = new ArmorMaterial(41,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 3);
                map.put(ArmorType.LEGGINGS, 6);
                map.put(ArmorType.CHESTPLATE, 8);
                map.put(ArmorType.HELMET, 3);
                map.put(ArmorType.BODY, 11);
            }),
            23, SoundEvents.ARMOR_EQUIP_GENERIC,
            1.5F, 0.01F,
            MtaTags.Items.BLOODSTONE_TOOL_MATERIALS,
            MTAEquipmentAssets.SILENT_REAPER

    );

    public static final ArmorMaterial TEMPLE_ANGEL = new ArmorMaterial(45,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 3);
                map.put(ArmorType.LEGGINGS, 6);
                map.put(ArmorType.CHESTPLATE, 8);
                map.put(ArmorType.HELMET, 3);
                map.put(ArmorType.BODY, 10);
            }),
            19, SoundEvents.ARMOR_EQUIP_CHAIN,2F, 0.0F,
            MtaTags.Items.CELESTITE_TOOL_MATERIALS,
            MTAEquipmentAssets.TEMPLE_ANGEL

    );

    public static final ArmorMaterial FREEZING_ICICLE = new ArmorMaterial(45,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 3);
                map.put(ArmorType.LEGGINGS, 6);
                map.put(ArmorType.CHESTPLATE, 8);
                map.put(ArmorType.HELMET, 3);
                map.put(ArmorType.BODY, 10);
            }),
            19, SoundEvents.ARMOR_EQUIP_DIAMOND,
            2F, 0.0F,
            MtaTags.Items.CRYOLITE_TOOL_MATERIALS,
            MTAEquipmentAssets.FREEZING_ICICLE
    );

    public static final ArmorMaterial WRATHFUL_BERSERKER = new ArmorMaterial(43,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 4);
                map.put(ArmorType.CHESTPLATE, 6);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 9);
            }),
            17, SoundEvents.ARMOR_EQUIP_LEATHER,
            1F, 0.05F,
            MtaTags.Items.GARNET_TOOL_MATERIALS,
            MTAEquipmentAssets.WRATHFUL_BERSERKER

    );

    public static final ArmorMaterial SHADOW_ROGUE = new ArmorMaterial(39,
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 5);
                map.put(ArmorType.CHESTPLATE, 7);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 11);
            }),
            25, SoundEvents.ARMOR_EQUIP_LEATHER,
            2F, 0.025F,
            MtaTags.Items.MOONSTONE_TOOL_MATERIALS,
            MTAEquipmentAssets.SHADOW_ROGUE

    );


}
