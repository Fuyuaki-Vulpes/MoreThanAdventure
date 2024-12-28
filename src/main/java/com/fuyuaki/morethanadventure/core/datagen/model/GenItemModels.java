package com.fuyuaki.morethanadventure.core.datagen.model;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;
import net.neoforged.neoforge.registries.DeferredItem;

import java.util.LinkedHashMap;
import java.util.function.BiConsumer;

public class GenItemModels extends ItemModelGenerators {

    private final ItemModelOutput itemModelOutput;
    private final BiConsumer<ResourceLocation, ModelInstance> modelOutput;


    public GenItemModels(ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
        super(itemModelOutput, modelOutput);
        this.itemModelOutput = itemModelOutput;
        this.modelOutput = modelOutput;
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
    public void run() {

        simpleItem(MtaItems.BIG_BOWL);

        simpleItem(MtaItems.CLEAR_QUARTZ);
        simpleItem(MtaItems.NETHERITE_FRACTURE);

        simpleItem(MtaItems.HOST_HUSK);
        //simpleItem(MtaItems.SAMURAI_CLOTH);
        simpleItem(MtaItems.SIREN_SCALE);
        //simpleItem(MtaItems.BLACK_WIDOW_VENOM);
        //simpleItem(MtaItems.HOST_HUSK);
        //simpleItem(MtaItems.SPIRIT_DUST);
        //simpleItem(MtaItems.CHARRED_BONE);
        //simpleItem(MtaItems.HOST_HUSK);

        simpleItem(MtaItems.APPLE_SLICE);
        simpleItem(MtaItems.AVOCADO);
        simpleItem(MtaItems.AVOCADO_SLICE);
        simpleItem(MtaItems.BANANA);
        simpleItem(MtaItems.CABBAGE);
        simpleItem(MtaItems.COFFEE);
        simpleItem(MtaItems.COFFEE_BEANS);
        simpleItem(MtaItems.GRAPES);
        simpleItem(MtaItems.MANGO);
        simpleItem(MtaItems.MANGO_SLICE);
        simpleItem(MtaItems.STRAWBERRY);
        simpleItem(MtaItems.TEA_LEAVES);
        simpleItem(MtaItems.TEA);
        simpleItem(MtaItems.ICE_CUBES);


        simpleItem(MtaItems.WEIGHTED_DICE);
        simpleItem(MtaItems.TOTEM_OF_COMBATING);

        simpleItem(MtaItems.AGATE);
        simpleItem(MtaItems.ALEXANDRITE);
        simpleItem(MtaItems.AQUAMARINE);
        simpleItem(MtaItems.BLOODSTONE);
        simpleItem(MtaItems.CELESTITE);
        simpleItem(MtaItems.CRYOLITE);
        simpleItem(MtaItems.GARNET);
        simpleItem(MtaItems.MOONSTONE);

        simpleItem(MtaItems.AWAKENED_AGATE);
        simpleItem(MtaItems.AWAKENED_ALEXANDRITE);
        simpleItem(MtaItems.AWAKENED_AQUAMARINE);
        simpleItem(MtaItems.AWAKENED_BLOODSTONE);
        simpleItem(MtaItems.AWAKENED_CELESTITE);
        simpleItem(MtaItems.AWAKENED_CRYOLITE);
        simpleItem(MtaItems.AWAKENED_GARNET);
        simpleItem(MtaItems.AWAKENED_MOONSTONE);

        simpleItem(MtaItems.ARMAMENT_UPGRADE);
        simpleItem(MtaItems.ROYAL_UPGRADE);
        simpleItem(MtaItems.AQUATIC_UPGRADE);
        simpleItem(MtaItems.DEATHLY_UPGRADE);
        simpleItem(MtaItems.ANGELIC_UPGRADE);
        simpleItem(MtaItems.FREEZING_UPGRADE);
        simpleItem(MtaItems.BERSERK_UPGRADE);
        simpleItem(MtaItems.FEATHERWEIGHT_UPGRADE);




        //ARMOR

        simpleItem(MtaItems.GREAT_SENTINELS_HELMET);
        simpleItem(MtaItems.GREAT_SENTINELS_CHESTPLATE);
        simpleItem(MtaItems.GREAT_SENTINELS_LEGGINGS);
        simpleItem(MtaItems.GREAT_SENTINELS_BOOTS);

        simpleItem(MtaItems.HOLY_KNIGHTS_HELMET);
        simpleItem(MtaItems.HOLY_KNIGHTS_CHESTPLATE);
        simpleItem(MtaItems.HOLY_KNIGHTS_LEGGINGS);
        simpleItem(MtaItems.HOLY_KNIGHTS_BOOTS);

        simpleItem(MtaItems.MYSTIC_MERMAIDS_HELMET);
        simpleItem(MtaItems.MYSTIC_MERMAIDS_CHESTPLATE);
        simpleItem(MtaItems.MYSTIC_MERMAIDS_LEGGINGS);
        simpleItem(MtaItems.MYSTIC_MERMAIDS_BOOTS);

        simpleItem(MtaItems.SILENT_REAPERS_HELMET);
        simpleItem(MtaItems.SILENT_REAPERS_CHESTPLATE);
        simpleItem(MtaItems.SILENT_REAPERS_LEGGINGS);
        simpleItem(MtaItems.SILENT_REAPERS_BOOTS);

        simpleItem(MtaItems.TEMPLE_ANGELS_HELMET);
        simpleItem(MtaItems.TEMPLE_ANGELS_CHESTPLATE);
        simpleItem(MtaItems.TEMPLE_ANGELS_LEGGINGS);
        simpleItem(MtaItems.TEMPLE_ANGELS_BOOTS);

        //simpleItem(MtaItems.COLD_SET_HELMET);
        //simpleItem(MtaItems.COLD_SET_CHESTPLATE);
        //simpleItem(MtaItems.COLD_SET_LEGGINGS);
        //simpleItem(MtaItems.COLD_SET_BOOTS);

        simpleItem(MtaItems.WRATHFUL_BERSERKERS_HELMET);
        simpleItem(MtaItems.WRATHFUL_BERSERKERS_CHESTPLATE);
        simpleItem(MtaItems.WRATHFUL_BERSERKERS_LEGGINGS);
        simpleItem(MtaItems.WRATHFUL_BERSERKERS_BOOTS);

        simpleItem(MtaItems.SHADOW_ROGUES_HELMET);
        simpleItem(MtaItems.SHADOW_ROGUES_CHESTPLATE);
        simpleItem(MtaItems.SHADOW_ROGUES_LEGGINGS);
        simpleItem(MtaItems.SHADOW_ROGUES_BOOTS);

        //WEAPONS

        handheldItem(MtaItems.COPPER_SWORD);
        handheldItem(MtaItems.NETHERSTEEL_SWORD);

        handheldClaw(MtaItems.WOOD_CLAW);
        handheldBigItem(MtaItems.WOOD_CLAYMORE);
        handheldItem(MtaItems.WOOD_CUTLASS);
        handheldItem(MtaItems.WOOD_DAGGER);
        handheldBigItem(MtaItems.WOOD_DOUBLE_AXE);
        handheldItem(MtaItems.WOOD_GLAIVE);
        handheldBigItem(MtaItems.WOOD_HALBERD);
        handheldItem(MtaItems.WOOD_KATANA);
        handheldBigItem(MtaItems.WOOD_SCYTHE);
        handheldBigItem(MtaItems.WOOD_SPEAR);
        handheldBigItemMiddleHilt(MtaItems.WOOD_TWINBLADE);

        handheldClaw(MtaItems.STONE_CLAW);
        handheldBigItem(MtaItems.STONE_CLAYMORE);
        handheldItem(MtaItems.STONE_CUTLASS);
        handheldItem(MtaItems.STONE_DAGGER);
        handheldBigItem(MtaItems.STONE_DOUBLE_AXE);
        handheldItem(MtaItems.STONE_GLAIVE);
        handheldBigItem(MtaItems.STONE_HALBERD);
        handheldItem(MtaItems.STONE_KATANA);
        handheldBigItem(MtaItems.STONE_SCYTHE);
        handheldBigItem(MtaItems.STONE_SPEAR);
        handheldBigItemMiddleHilt(MtaItems.STONE_TWINBLADE);

        handheldClaw(MtaItems.COPPER_CLAW);
        handheldBigItem(MtaItems.COPPER_CLAYMORE);
        handheldItem(MtaItems.COPPER_CUTLASS);
        handheldItem(MtaItems.COPPER_DAGGER);
        handheldBigItem(MtaItems.COPPER_DOUBLE_AXE);
        handheldItem(MtaItems.COPPER_GLAIVE);
        handheldBigItem(MtaItems.COPPER_HALBERD);
        handheldItem(MtaItems.COPPER_KATANA);
        handheldBigItem(MtaItems.COPPER_SCYTHE);
        handheldBigItem(MtaItems.COPPER_SPEAR);
        handheldBigItemMiddleHilt(MtaItems.COPPER_TWINBLADE);

        handheldClaw(MtaItems.IRON_CLAW);
        handheldBigItem(MtaItems.IRON_CLAYMORE);
        handheldItem(MtaItems.IRON_CUTLASS);
        handheldItem(MtaItems.IRON_DAGGER);
        handheldBigItem(MtaItems.IRON_DOUBLE_AXE);
        handheldItem(MtaItems.IRON_GLAIVE);
        handheldBigItem(MtaItems.IRON_HALBERD);
        handheldItem(MtaItems.IRON_KATANA);
        handheldBigItem(MtaItems.IRON_SCYTHE);
        handheldBigItem(MtaItems.IRON_SPEAR);
        handheldBigItemMiddleHilt(MtaItems.IRON_TWINBLADE);

        handheldClaw(MtaItems.GOLD_CLAW);
        handheldBigItem(MtaItems.GOLD_CLAYMORE);
        handheldItem(MtaItems.GOLD_CUTLASS);
        handheldItem(MtaItems.GOLD_DAGGER);
        handheldBigItem(MtaItems.GOLD_DOUBLE_AXE);
        handheldItem(MtaItems.GOLD_GLAIVE);
        handheldBigItem(MtaItems.GOLD_HALBERD);
        handheldItem(MtaItems.GOLD_KATANA);
        handheldBigItem(MtaItems.GOLD_SCYTHE);
        handheldBigItem(MtaItems.GOLD_SPEAR);
        handheldBigItemMiddleHilt(MtaItems.GOLD_TWINBLADE);

        handheldClaw(MtaItems.NETHERSTEEL_CLAW);
        handheldBigItem(MtaItems.NETHERSTEEL_CLAYMORE);
        handheldItem(MtaItems.NETHERSTEEL_CUTLASS);
        handheldItem(MtaItems.NETHERSTEEL_DAGGER);
        handheldBigItem(MtaItems.NETHERSTEEL_DOUBLE_AXE);
        handheldItem(MtaItems.NETHERSTEEL_GLAIVE);
        handheldBigItem(MtaItems.NETHERSTEEL_HALBERD);
        handheldItem(MtaItems.NETHERSTEEL_KATANA);
        handheldBigItem(MtaItems.NETHERSTEEL_SCYTHE);
        handheldBigItem(MtaItems.NETHERSTEEL_SPEAR);
        handheldBigItemMiddleHilt(MtaItems.NETHERSTEEL_TWINBLADE);

        handheldClaw(MtaItems.DIAMOND_CLAW);
        handheldBigItem(MtaItems.DIAMOND_CLAYMORE);
        handheldItem(MtaItems.DIAMOND_CUTLASS);
        handheldItem(MtaItems.DIAMOND_DAGGER);
        handheldBigItem(MtaItems.DIAMOND_DOUBLE_AXE);
        handheldItem(MtaItems.DIAMOND_GLAIVE);
        handheldBigItem(MtaItems.DIAMOND_HALBERD);
        handheldItem(MtaItems.DIAMOND_KATANA);
        handheldBigItem(MtaItems.DIAMOND_SCYTHE);
        handheldBigItem(MtaItems.DIAMOND_SPEAR);
        handheldBigItemMiddleHilt(MtaItems.DIAMOND_TWINBLADE);

        handheldClaw(MtaItems.NETHERITE_CLAW);
        handheldBigItem(MtaItems.NETHERITE_CLAYMORE);
        handheldItem(MtaItems.NETHERITE_CUTLASS);
        handheldItem(MtaItems.NETHERITE_DAGGER);
        handheldBigItem(MtaItems.NETHERITE_DOUBLE_AXE);
        handheldItem(MtaItems.NETHERITE_GLAIVE);
        handheldBigItem(MtaItems.NETHERITE_HALBERD);
        handheldItem(MtaItems.NETHERITE_KATANA);
        handheldBigItem(MtaItems.NETHERITE_SCYTHE);
        handheldBigItem(MtaItems.NETHERITE_SPEAR);
        handheldBigItemMiddleHilt(MtaItems.NETHERITE_TWINBLADE);
        this.generateTrident(MtaItems.NETHERITE_TRIDENT.get());
        this.generateBow(MtaItems.NETHERITE_BOW.get());

        handheldBigItem(MtaItems.GREAT_SENTINELS_WAR_HAMMER);
        handheldBigItem(MtaItems.HOLY_KNIGHTS_GREATSWORD);
        this.generateTrident(MtaItems.MYSTIC_MERMAIDS_TRIDENT.get());
        handheldBigItemMediumHilt(MtaItems.SILENT_REAPERS_SCYTHE);
        this.generateBow(MtaItems.TEMPLE_ANGELS_BOW.get());
        handheldBigItem(MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE);
        handheldBigItemMediumHilt(MtaItems.FREEZING_ICICLE_SPEAR);
        handheldItem(MtaItems.SHADOW_ROGUES_DAGGER);

        //TOOLS

        handheldItem(MtaItems.COPPER_PICKAXE);
        handheldItem(MtaItems.COPPER_AXE);
        handheldItem(MtaItems.COPPER_SHOVEL);
        handheldItem(MtaItems.COPPER_HOE);

        handheldItem(MtaItems.NETHERSTEEL_PICKAXE);
        handheldItem(MtaItems.NETHERSTEEL_AXE);
        handheldItem(MtaItems.NETHERSTEEL_SHOVEL);
        handheldItem(MtaItems.NETHERSTEEL_HOE);


        //FOODS

        //simpleItem(MtaItems.ONION);
        simpleItem(MtaItems.SHRIMP);
        simpleItem(MtaItems.COOKED_SHRIMP);
        simpleItem(MtaItems.TOMATO);
        //simpleItem(MtaItems.TOMATO_SEEDS);
        simpleItem(MtaItems.BELL_PEPPER);
        //simpleItem(MtaItems.BELL_PEPPER_SEEDS);
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
        this.generateSpawnEgg(MtaItems.YUKI_ONNA_SPAWN_EGG.get(),0xfbeeee,0xd2fcff);
        this.generateSpawnEgg(MtaItems.FALLEN_SAMURAI_SPAWN_EGG.get(),0xc3c0bc,0x3d3532);
        this.generateSpawnEgg(MtaItems.ICICLE_CREEPER_SPAWN_EGG.get(),0xe2f0f3,0xb5d6e2);
        this.generateSpawnEgg(MtaItems.BUTTERFLY_SPAWN_EGG.get(),0xe5c8d1,0x362f33);
        this.generateSpawnEgg(MtaItems.BEARDED_DRAGON_SPAWN_EGG.get(),0xe5c6af,0xb28375);
        this.generateSpawnEgg(MtaItems.CAPYBARA_SPAWN_EGG.get(),0x9a7666,0x896558);
        this.generateSpawnEgg(MtaItems.DEER_SPAWN_EGG.get(),0x9a7666,0x896558);
        this.generateSpawnEgg(MtaItems.DUCK_SPAWN_EGG.get(),0x37a73f,0xef9466);
        this.generateSpawnEgg(MtaItems.FERRET_SPAWN_EGG.get(),0xc6a69e,0x634b45);
        this.generateSpawnEgg(MtaItems.GREAT_WHITE_SHARK_SPAWN_EGG.get(),0xa7adb6,0x868e9b);
        this.generateSpawnEgg(MtaItems.HORSESHOE_CRAB_SPAWN_EGG.get(),0xa07962,0x41322c);
        this.generateSpawnEgg(MtaItems.JELLYFISH_SPAWN_EGG.get(),0xa986c2,0x779fc1);
        this.generateSpawnEgg(MtaItems.OCTOPUS_SPAWN_EGG.get(),0xf1936a,0xf7c1aa);
        this.generateSpawnEgg(MtaItems.OWL_SPAWN_EGG.get(),0x715e53,0xc46e1d);
        this.generateSpawnEgg(MtaItems.PENGUIN_SPAWN_EGG.get(),0x616274,0xdf9f54);
        this.generateSpawnEgg(MtaItems.RACCOON_SPAWN_EGG.get(),0xb6a09b,0x685655);
        this.generateSpawnEgg(MtaItems.SHRIMP_SPAWN_EGG.get(),0xf17f5b,0xf65641);
        this.generateSpawnEgg(MtaItems.TOUCAN_SPAWN_EGG.get(),0x292731,0xe78a43);
        this.generateSpawnEgg(MtaItems.TURKEY_SPAWN_EGG.get(),0x292731,0xe78a43);
        this.generateSpawnEgg(MtaItems.ARMORED_SKELETON_SPAWN_EGG.get(),0x1a222f,0x989fa1);
        this.generateSpawnEgg(MtaItems.BLACK_WIDOW_SPAWN_EGG.get(),0x080609,0x650618);
        this.generateSpawnEgg(MtaItems.CHARRED_SKELETON_SPAWN_EGG.get(),0x2f1c1c,0xf5870b);
        this.generateSpawnEgg(MtaItems.CORROSIVE_CUBE_SPAWN_EGG.get(),0x239a0e,0xddf549);
        this.generateSpawnEgg(MtaItems.FROSTED_SLIME_SPAWN_EGG.get(),0x96D9FF,0xC6EDFF);
        this.generateSpawnEgg(MtaItems.GLOW_SPIDER_SPAWN_EGG.get(),0xffdca4,0xd5692f);
        this.generateSpawnEgg(MtaItems.HOST_SPAWN_EGG.get(),0x8E9B78,0x93A28B);
        this.generateSpawnEgg(MtaItems.MOSSY_ZOMBIE_SPAWN_EGG.get(),0x3D7C52,0x87B05F);
        this.generateSpawnEgg(MtaItems.SKELETON_FIGHTER_SPAWN_EGG.get(),0x8e8d8e,0x761b23);
        this.generateSpawnEgg(MtaItems.TOXIC_ZOMBIE_SPAWN_EGG.get(),44975,0x47a80a);
        this.generateSpawnEgg(MtaItems.ZOMBIFIED_MINER_SPAWN_EGG.get(),0x385226,0xae5845);
        this.generateSpawnEgg(MtaItems.SIREN_SPAWN_EGG.get(),44975,0x24201d);
        this.generateSpawnEgg(MtaItems.WISPFLY_SPAWN_EGG.get(),0x385226,0x50ff1d);


    }


    private void handheldItem(DeferredItem<?> item) {
        this.itemModelOutput.accept(item.get(), ItemModelUtils.plainModel(this.createFlatItemModel(item.get(), ModelTemplates.FLAT_HANDHELD_ITEM)));

    }

    private void handheldClaw(DeferredItem<?> item) {
        this.itemModelOutput.accept(item.get(), ItemModelUtils.plainModel(this.createFlatItemModel(item.get(), MTAModelTemplates.CLAW)));

    }

    private void handheldBigItem(DeferredItem<?> item) {
        this.itemModelOutput.accept(item.get(), ItemModelUtils.plainModel(this.createFlatItemModel(item.get(), MTAModelTemplates.BIG_HANDHELD_LOW_HILT)));

    }
    private void handheldBigItemMediumHilt(DeferredItem<?> item) {
        this.itemModelOutput.accept(item.get(), ItemModelUtils.plainModel(this.createFlatItemModel(item.get(), MTAModelTemplates.BIG_HANDHELD_MEDIUM_HILT)));
    }
    private void handheldBigItemMiddleHilt(DeferredItem<?> item) {
        this.itemModelOutput.accept(item.get(), ItemModelUtils.plainModel(this.createFlatItemModel(item.get(), MTAModelTemplates.BIG_HANDHELD_MIDDLE_HILT)));
    }


    public void simpleItem(DeferredItem<?> item) {
        this.itemModelOutput.accept(item.get(), ItemModelUtils.plainModel(this.createFlatItemModel(item.get(), ModelTemplates.FLAT_ITEM)));
    }
}
