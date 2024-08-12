package com.fuyuaki.morethanadventure.datagen.generators;

import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.item.armortrim.TrimMaterials;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class GenItemModels extends ItemModelProvider {
    public GenItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MODID, existingFileHelper);
    }
    private static LinkedHashMap<ResourceKey<TrimMaterial>, Float> trimMaterials = new LinkedHashMap<>();
    static {
        trimMaterials.put(TrimMaterials.QUARTZ, 0.1F);
        trimMaterials.put(TrimMaterials.IRON, 0.2F);
        trimMaterials.put(TrimMaterials.NETHERITE, 0.3F);
        trimMaterials.put(TrimMaterials.REDSTONE, 0.4F);
        trimMaterials.put(TrimMaterials.COPPER, 0.5F);
        trimMaterials.put(TrimMaterials.GOLD, 0.6F);
        trimMaterials.put(TrimMaterials.EMERALD, 0.7F);
        trimMaterials.put(TrimMaterials.DIAMOND, 0.8F);
        trimMaterials.put(TrimMaterials.LAPIS, 0.9F);
        trimMaterials.put(TrimMaterials.AMETHYST, 1.0F);
    }


    @Override
    protected void registerModels() {
        simpleItem(MtaItems.BIG_BOWL);

        simpleItem(MtaItems.CLEAR_QUARTZ);
        simpleItem(MtaItems.NETHERITE_FRACTURE);

        simpleItem(MtaItems.AGATE);
        simpleItem(MtaItems.ALEXANDRITE);
        simpleItem(MtaItems.AQUAMARINE);
        simpleItem(MtaItems.CELESTITE);
        simpleItem(MtaItems.GARNET);
        simpleItem(MtaItems.MOONSTONE);

        simpleItem(MtaItems.ARMAMENT_UPGRADE);
        simpleItem(MtaItems.ROYAL_UPGRADE);
        simpleItem(MtaItems.AQUATIC_UPGRADE);
        simpleItem(MtaItems.ANGELIC_UPGRADE);
        simpleItem(MtaItems.BERSERK_UPGRADE);
        simpleItem(MtaItems.FEATHERWEIGHT_UPGRADE);


        simpleItem(MtaItems.COPPER_SWORD);
        simpleItem(MtaItems.COPPER_PICKAXE);
        simpleItem(MtaItems.COPPER_AXE);
        simpleItem(MtaItems.COPPER_SHOVEL);
        simpleItem(MtaItems.COPPER_HOE);

        //ARMOR

        simpleItem(MtaItems.GREAT_SENTINELS_WAR_HAMMER);
        simpleItem(MtaItems.GREAT_SENTINELS_HELMET);
        simpleItem(MtaItems.GREAT_SENTINELS_CHESTPLATE);
        simpleItem(MtaItems.GREAT_SENTINELS_LEGGINGS);
        simpleItem(MtaItems.GREAT_SENTINELS_BOOTS);

        simpleItem(MtaItems.HOLY_KNIGHTS_GREATSWORD);
        //simpleItem(MtaItems.HOLY_KNIGHTS_HELMET);
        //simpleItem(MtaItems.HOLY_KNIGHTS_CHESTPLATE);
        //simpleItem(MtaItems.HOLY_KNIGHTS_LEGGINGS);
        //simpleItem(MtaItems.HOLY_KNIGHTS_BOOTS);

        handheldItem(MtaItems.MYSTIC_MERMAIDS_TRIDENT);
        //simpleItem(MtaItems.MYSTIC_MERMAIDS_HELMET);
        //simpleItem(MtaItems.MYSTIC_MERMAIDS_CHESTPLATE);
        //simpleItem(MtaItems.MYSTIC_MERMAIDS_LEGGINGS);
        //simpleItem(MtaItems.MYSTIC_MERMAIDS_BOOTS);

        simpleItem(MtaItems.TEMPLE_ANGELS_BOW);
        simpleItem(MtaItems.TEMPLE_ANGELS_HELMET);
        simpleItem(MtaItems.TEMPLE_ANGELS_CHESTPLATE);
        simpleItem(MtaItems.TEMPLE_ANGELS_LEGGINGS);
        simpleItem(MtaItems.TEMPLE_ANGELS_BOOTS);

        simpleItem(MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE);
        simpleItem(MtaItems.WRATHFUL_BERSERKERS_HELMET);
        simpleItem(MtaItems.WRATHFUL_BERSERKERS_CHESTPLATE);
        simpleItem(MtaItems.WRATHFUL_BERSERKERS_LEGGINGS);
        simpleItem(MtaItems.WRATHFUL_BERSERKERS_BOOTS);

        handheldItem(MtaItems.SHADOW_ROGUES_DAGGER);
        simpleItem(MtaItems.SHADOW_ROGUES_HELMET);
        simpleItem(MtaItems.SHADOW_ROGUES_CHESTPLATE);
        simpleItem(MtaItems.SHADOW_ROGUES_LEGGINGS);
        simpleItem(MtaItems.SHADOW_ROGUES_BOOTS);

        //TOOLS
        handheldItem(MtaItems.ARMAMENT_PICKAXE);
        handheldItem(MtaItems.ARMAMENT_AXE);
        handheldItem(MtaItems.ARMAMENT_SHOVEL);

        handheldItem(MtaItems.ROYAL_PICKAXE);
        handheldItem(MtaItems.ROYAL_AXE);
        handheldItem(MtaItems.ROYAL_SHOVEL);

        handheldItem(MtaItems.AQUATIC_PICKAXE);
        handheldItem(MtaItems.AQUATIC_AXE);
        handheldItem(MtaItems.AQUATIC_SHOVEL);

        handheldItem(MtaItems.ANGELIC_PICKAXE);
        handheldItem(MtaItems.ANGELIC_AXE);
        handheldItem(MtaItems.ANGELIC_SHOVEL);

        handheldItem(MtaItems.BERSERK_PICKAXE);
        handheldItem(MtaItems.BERSERK_AXE);
        handheldItem(MtaItems.BERSERK_SHOVEL);

        handheldItem(MtaItems.FEATHERWEIGHT_PICKAXE);
        handheldItem(MtaItems.FEATHERWEIGHT_AXE);
        handheldItem(MtaItems.FEATHERWEIGHT_SHOVEL);

        //FOODS

        simpleItem(MtaItems.ONION);
        simpleItem(MtaItems.SHRIMP);
        simpleItem(MtaItems.COOKED_SHRIMP);
        simpleItem(MtaItems.TOMATO);
        //simpleItem(MtaItems.TOMATO_SEEDS);
        simpleItem(MtaItems.RED_PEPPER);
        //simpleItem(MtaItems.RED_PEPPER_SEEDS);
        simpleItem(MtaItems.CHILI_PEPPER);
        //simpleItem(MtaItems.CHILI_PEPPER_SEEDS);
        simpleItem(MtaItems.RICE);
        simpleItem(MtaItems.ONIGIRI);
        simpleItem(MtaItems.COCONUT);
        simpleItem(MtaItems.COCONUT_MILK);
        simpleItem(MtaItems.COCONUT_SLICE);
        simpleItem(MtaItems.SPICE_MIX);
        simpleItem(MtaItems.SWEET_BEEF_CURRY);
        simpleItem(MtaItems.SWEET_PORK_CURRY);
        simpleItem(MtaItems.SWEET_CHICKEN_CURRY);
        simpleItem(MtaItems.SWEET_SHRIMP_CURRY);
        simpleItem(MtaItems.MILD_BEEF_CURRY);
        simpleItem(MtaItems.MILD_PORK_CURRY);
        simpleItem(MtaItems.MILD_CHICKEN_CURRY);
        simpleItem(MtaItems.MILD_SHRIMP_CURRY);
        simpleItem(MtaItems.SPICY_BEEF_CURRY);
        simpleItem(MtaItems.SPICY_PORK_CURRY);
        simpleItem(MtaItems.SPICY_CHICKEN_CURRY);
        simpleItem(MtaItems.SPICY_SHRIMP_CURRY);

        //SPAWN EGGS
        simpleItem(MtaItems.YUKI_ONNA_SPAWN_EGG);
        simpleItem(MtaItems.FALLEN_SAMURAI_SPAWN_EGG);
        simpleItem(MtaItems.BUTTERFLY_SPAWN_EGG);
        simpleItem(MtaItems.BEARDED_DRAGON_SPAWN_EGG);
        simpleItem(MtaItems.CAPYBARA_SPAWN_EGG);
        simpleItem(MtaItems.DUCK_SPAWN_EGG);
        simpleItem(MtaItems.FERRET_SPAWN_EGG);
        simpleItem(MtaItems.GREAT_WHITE_SHARK_SPAWN_EGG);
        simpleItem(MtaItems.HORSESHOE_CRAB_SPAWN_EGG);
        simpleItem(MtaItems.JELLYFISH_SPAWN_EGG);
        simpleItem(MtaItems.OCTOPUS_SPAWN_EGG);
        simpleItem(MtaItems.OWL_SPAWN_EGG);
        simpleItem(MtaItems.PENGUIN_SPAWN_EGG);
        simpleItem(MtaItems.RACCOON_SPAWN_EGG);
        simpleItem(MtaItems.SHRIMP_SPAWN_EGG);
        simpleItem(MtaItems.TOUCAN_SPAWN_EGG);
    }

    private ItemModelBuilder simpleItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(MODID,"item/" + item.getId().getPath()));
    }


    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldBigItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.fromNamespaceAndPath(MODID,"item/handheld_big")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(DeferredBlock<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(MODID,"item/" + item.getId().getPath()));
    }
    private ItemModelBuilder wallItem(DeferredBlock<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("block/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(MODID,"block/" + item.getId().getPath()));
    }

    private ItemModelBuilder slabItem(DeferredBlock<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("block/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(MODID,"block/" + item.getId().getPath()));
    }
}
