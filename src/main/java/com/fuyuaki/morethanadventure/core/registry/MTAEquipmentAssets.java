package com.fuyuaki.morethanadventure.core.registry;

import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.Map;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public interface MTAEquipmentAssets {
    ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID = ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(MODID,"textures/models/armor"));
    ResourceKey<EquipmentAsset> GREAT_SENTINEL = createId("great_sentinel");
    ResourceKey<EquipmentAsset> HOLY_KNIGHT = createId("holy_knight");
    ResourceKey<EquipmentAsset> MYSTIC_MERMAID = createId("mystic_mermaid");
    ResourceKey<EquipmentAsset> SILENT_REAPER = createId("silent_reaper");
    ResourceKey<EquipmentAsset> TEMPLE_ANGEL = createId("temple_angel");
    ResourceKey<EquipmentAsset> FREEZING_ICICLE = createId("freezing_icicle");
    ResourceKey<EquipmentAsset> WRATHFUL_BERSERKER = createId("wrathful_berserker");
    ResourceKey<EquipmentAsset> SHADOW_ROGUE = createId("shadow_rogue");

    static ResourceKey<EquipmentAsset> createId(String name) {
        return ResourceKey.create(ROOT_ID, ResourceLocation.fromNamespaceAndPath(MODID, name));
    }
}
