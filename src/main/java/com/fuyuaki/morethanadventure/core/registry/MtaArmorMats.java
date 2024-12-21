package com.fuyuaki.morethanadventure.core.registry;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MtaArmorMats {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MAT = DeferredRegister.create(Registries.ARMOR_MATERIAL, MODID);

    public static final Holder<ArmorMaterial> GREAT_SENTINEL = ARMOR_MAT.register("great_sentinel", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                        map.put(ArmorType.BOOTS, 4);
                        map.put(ArmorType.LEGGINGS, 7);
                        map.put(ArmorType.CHESTPLATE, 10);
                        map.put(ArmorType.HELMET, 4);
                        map.put(ArmorType.BODY, 13);
                    }),
                    10, SoundEvents.ARMOR_EQUIP_NETHERITE,
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MODID, "great_sentinel"))),
                    5F, 0.25F, Ingredient.of(MtaItems.AGATE)
            ));

    public static final Holder<ArmorMaterial> HOLY_KNIGHT = ARMOR_MAT.register("holy_knight", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 3);
                map.put(ArmorType.LEGGINGS, 7);
                map.put(ArmorType.CHESTPLATE, 9);
                map.put(ArmorType.HELMET, 4);
                map.put(ArmorType.BODY, 12);
            }),
            28, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(MtaItems.ALEXANDRITE),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MODID, "holy_knight"))),
            3F, 0.11F
    ));

    public static final Holder<ArmorMaterial> MYSTIC_MERMAID = ARMOR_MAT.register("mystic_mermaid", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 3);
                map.put(ArmorType.LEGGINGS, 6);
                map.put(ArmorType.CHESTPLATE, 8);
                map.put(ArmorType.HELMET, 3);
                map.put(ArmorType.BODY, 11);
            }),
            19, SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.of(MtaItems.AQUAMARINE),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MODID, "mystic_mermaid"))),
            3F, 0.1F
    ));

    public static final Holder<ArmorMaterial> SILENT_REAPER = ARMOR_MAT.register("silent_reaper", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 3);
                map.put(ArmorType.LEGGINGS, 6);
                map.put(ArmorType.CHESTPLATE, 8);
                map.put(ArmorType.HELMET, 3);
                map.put(ArmorType.BODY, 11);
            }),
            23, SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.of(MtaItems.BLOODSTONE),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MODID, "silent_reaper"))),
            1.5F, 0.01F
    ));

    public static final Holder<ArmorMaterial> TEMPLE_ANGEL = ARMOR_MAT.register("temple_angel", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 3);
                map.put(ArmorType.LEGGINGS, 6);
                map.put(ArmorType.CHESTPLATE, 8);
                map.put(ArmorType.HELMET, 3);
                map.put(ArmorType.BODY, 10);
            }),
            19, SoundEvents.ARMOR_EQUIP_CHAIN, () -> Ingredient.of(MtaItems.CELESTITE),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MODID, "temple_angel"))),
            2F, 0.0F
    ));

    public static final Holder<ArmorMaterial> FREEZING_ICICLE = ARMOR_MAT.register("freezing_icicle", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 3);
                map.put(ArmorType.LEGGINGS, 6);
                map.put(ArmorType.CHESTPLATE, 8);
                map.put(ArmorType.HELMET, 3);
                map.put(ArmorType.BODY, 10);
            }),
            19, SoundEvents.ARMOR_EQUIP_DIAMOND, () -> Ingredient.of(MtaItems.CRYOLITE),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MODID, "freezing_icicle"))),
            2F, 0.0F
    ));

    public static final Holder<ArmorMaterial> WRATHFUL_BERSERKER =
            ARMOR_MAT.register("wrathful_berserker", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 4);
                map.put(ArmorType.CHESTPLATE, 6);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 9);
            }),
            17, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(MtaItems.GARNET.get()),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MODID, "wrathful_berserker"))),
            1F, 0.05F
    ));

    public static final Holder<ArmorMaterial> SHADOW_ROGUE = ARMOR_MAT.register("shadow_rogue", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorType.class), map -> {
                map.put(ArmorType.BOOTS, 2);
                map.put(ArmorType.LEGGINGS, 5);
                map.put(ArmorType.CHESTPLATE, 7);
                map.put(ArmorType.HELMET, 2);
                map.put(ArmorType.BODY, 11);
            }),
            25, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(MtaItems.MOONSTONE),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MODID, "shadow_rogue"))),
            2F, 0.025F
    ));

    public static void register(IEventBus eventBus){
        ARMOR_MAT.register(eventBus);
    }

}
