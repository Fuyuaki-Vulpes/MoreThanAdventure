package com.fuyuaki.morethanadventure.core.registry;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MtaArmorMats {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MAT = DeferredRegister.create(Registries.ARMOR_MATERIAL, MODID);

    public static final Holder<ArmorMaterial> GREAT_SENTINEL = ARMOR_MAT.register("great_sentinel", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                        map.put(ArmorItem.Type.BOOTS, 4);
                        map.put(ArmorItem.Type.LEGGINGS, 7);
                        map.put(ArmorItem.Type.CHESTPLATE, 10);
                        map.put(ArmorItem.Type.HELMET, 4);
                        map.put(ArmorItem.Type.BODY, 13);
                    }),
                    10, SoundEvents.ARMOR_EQUIP_NETHERITE, () -> Ingredient.of(MtaItems.AGATE),
                    List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MODID, "great_sentinel"))),
                    5F, 0.25F
            ));

    public static final Holder<ArmorMaterial> HOLY_KNIGHT = ARMOR_MAT.register("holy_knight", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 7);
                map.put(ArmorItem.Type.CHESTPLATE, 9);
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.BODY, 12);
            }),
            32, SoundEvents.ARMOR_EQUIP_IRON, () -> Ingredient.of(MtaItems.ALEXANDRITE),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MODID, "holy_knight"))),
            3F, 0.11F
    ));

    public static final Holder<ArmorMaterial> MYSTIC_MERMAID = ARMOR_MAT.register("mystic_mermaid", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 11);
            }),
            18, SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.of(MtaItems.AQUAMARINE),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MODID, "mystic_mermaid"))),
            3F, 0.1F
    ));

    public static final Holder<ArmorMaterial> TEMPLE_ANGEL = ARMOR_MAT.register("temple_angel", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 8);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 10);
            }),
            25, SoundEvents.ARMOR_EQUIP_CHAIN, () -> Ingredient.of(MtaItems.CELESTITE),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MODID, "temple_angel"))),
            2F, 0.0F
    ));

    public static final Holder<ArmorMaterial> WRATHFUL_BERSERKER =
            ARMOR_MAT.register("wrathful_berserker", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 9);
            }),
            15, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(MtaItems.GARNET.get()),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MODID, "wrathful_berserker"))),
            1F, 0.05F
    ));

    public static final Holder<ArmorMaterial> SHADOW_ROGUE = ARMOR_MAT.register("shadow_rogue", () -> new ArmorMaterial(
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 2);
                map.put(ArmorItem.Type.BODY, 11);
            }),
            25, SoundEvents.ARMOR_EQUIP_LEATHER, () -> Ingredient.of(MtaItems.MOONSTONE),
            List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MODID, "shadow_rogue"))),
            2F, 0.025F
    ));

    public static void register(IEventBus eventBus){
        ARMOR_MAT.register(eventBus);
    }

}
