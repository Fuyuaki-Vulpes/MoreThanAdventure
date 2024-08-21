package com.fuyuaki.morethanadventure.core.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MtaTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = TABS.register("mtatab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.morethanadventure")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(MtaItems.NETHERITE_FRACTURE.get()::getDefaultInstance)
            .displayItems((parameters, output) -> {
                output.acceptAll(MtaTabs.BLOCK_ITEM.get().getDisplayItems());
                output.acceptAll(MtaTabs.EQUIPMENTS.get().getDisplayItems());
                output.acceptAll(MtaTabs.MISC.get().getDisplayItems());
            }).build());



    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BLOCK_ITEM = TABS.register("mtaitemblock", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.mtaitemblock"))
            .withTabsBefore(MtaTabs.MAIN.getId())
            .icon(MtaItems.GARNET.get()::getDefaultInstance)
            .displayItems((parameters, output) -> {

                output.accept(MtaBlocks.PALM_LOG.get());
                output.accept(MtaBlocks.STRIPPED_PALM_LOG.get());
                output.accept(MtaBlocks.PALM_WOOD.get());
                output.accept(MtaBlocks.STRIPPED_PALM_WOOD.get());
                output.accept(MtaBlocks.PALM_PLANKS.get());
                output.accept(MtaBlocks.PALM_LEAVES.get());
                output.accept(MtaBlocks.PALM_SAPLING.get());
                output.accept(MtaBlocks.PALM_STAIRS.get());
                output.accept(MtaBlocks.PALM_SLAB.get());
                output.accept(MtaBlocks.PALM_PRESSURE_PLATE.get());
                output.accept(MtaBlocks.PALM_BUTTON.get());
                output.accept(MtaBlocks.PALM_FENCE.get());
                output.accept(MtaBlocks.PALM_FENCE_GATE.get());
                output.accept(MtaBlocks.PALM_DOOR.get());
                output.accept(MtaBlocks.PALM_TRAPDOOR.get());
                output.accept(MtaBlocks.SPRINKLER.get());
                output.accept(MtaBlocks.STONE_GEYSER.get());
                output.accept(MtaBlocks.TERRACOTTA_GEYSER.get());
                output.accept(MtaBlocks.NETHERRACK_GEYSER.get());
                output.accept(MtaBlocks.BASALT_GEYSER.get());
                output.accept(MtaBlocks.MOSSY_ANDESITE.get());
                output.accept(MtaBlocks.CLEAR_QUARTZ_GROWTH.get());
                output.accept(MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_GROWTH.get());
                output.accept(MtaBlocks.CALCITE_CLEAR_QUARTZ_GROWTH.get());
                output.accept(MtaBlocks.CLEAR_QUARTZ_CLUSTER.get());
                output.accept(MtaBlocks.CLEAR_QUARTZ_ORE.get());
                output.accept(MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_ORE.get());
                output.accept(MtaBlocks.NETHER_IRON_ORE.get());
                output.accept(MtaBlocks.NETHER_DIAMOND_ORE.get());
                output.accept(MtaBlocks.END_LAPIS_ORE.get());
                output.accept(MtaBlocks.END_EMERALD_ORE.get());

                output.accept(MtaBlocks.AGATE_ORE.get());
                output.accept(MtaBlocks.DEEPSLATE_AGATE_ORE.get());
                output.accept(MtaBlocks.ALEXANDRITE_ORE.get());
                output.accept(MtaBlocks.DEEPSLATE_ALEXANDRITE_ORE.get());
                output.accept(MtaBlocks.AQUAMARINE_ORE.get());
                output.accept(MtaBlocks.DEEPSLATE_AQUAMARINE_ORE.get());
                output.accept(MtaBlocks.CELESTITE_ORE.get());
                output.accept(MtaBlocks.DEEPSLATE_CELESTITE_ORE.get());
                output.accept(MtaBlocks.GARNET_ORE.get());
                output.accept(MtaBlocks.DEEPSLATE_GARNET_ORE.get());
                output.accept(MtaBlocks.MOONSTONE_ORE.get());
                output.accept(MtaBlocks.DEEPSLATE_MOONSTONE_ORE.get());

                output.accept(MtaBlocks.QUARTZ_LAMP.get());
                output.accept(MtaBlocks.SAND_PATH.get());

                output.accept(MtaItems.CLEAR_QUARTZ);
                output.accept(MtaItems.NETHERITE_FRACTURE);
                output.accept(MtaItems.AGATE);
                output.accept(MtaItems.ALEXANDRITE);
                output.accept(MtaItems.AQUAMARINE);
                output.accept(MtaItems.CELESTITE);
                output.accept(MtaItems.GARNET);
                output.accept(MtaItems.MOONSTONE);
                output.accept(MtaItems.ARMAMENT_UPGRADE);
                output.accept(MtaItems.ROYAL_UPGRADE);
                output.accept(MtaItems.AQUATIC_UPGRADE);
                output.accept(MtaItems.ANGELIC_UPGRADE);
                output.accept(MtaItems.BERSERK_UPGRADE);
                output.accept(MtaItems.FEATHERWEIGHT_UPGRADE);

            }).build());


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EQUIPMENTS = TABS.register("mtaequip", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.mtaequip"))
            .withTabsBefore(MtaTabs.BLOCK_ITEM.getId())
            .icon(MtaItems.GREAT_SENTINELS_CHESTPLATE.get()::getDefaultInstance)
            .displayItems((parameters, output) -> {

                output.accept(MtaItems.COPPER_SWORD);
                output.accept(MtaItems.COPPER_PICKAXE);
                output.accept(MtaItems.COPPER_AXE);
                output.accept(MtaItems.COPPER_SHOVEL);
                output.accept(MtaItems.COPPER_HOE);
                output.accept(MtaItems.NETHERSTEEL_SWORD);
                output.accept(MtaItems.NETHERSTEEL_PICKAXE);
                output.accept(MtaItems.NETHERSTEEL_AXE);
                output.accept(MtaItems.NETHERSTEEL_SHOVEL);
                output.accept(MtaItems.NETHERSTEEL_HOE);
                output.accept(MtaItems.NETHERITE_TRIDENT);
                output.accept(MtaItems.NETHERITE_BOW);



                output.accept(MtaItems.GREAT_SENTINELS_WAR_HAMMER);
                output.accept(MtaItems.GREAT_SENTINELS_HELMET);
                output.accept(MtaItems.GREAT_SENTINELS_CHESTPLATE);
                output.accept(MtaItems.GREAT_SENTINELS_LEGGINGS);
                output.accept(MtaItems.GREAT_SENTINELS_BOOTS);
                output.accept(MtaItems.HOLY_KNIGHTS_GREATSWORD);
                //output.accept(MtaItems.HOLY_KNIGHTS_HELMET);
                //output.accept(MtaItems.HOLY_KNIGHTS_CHESTPLATE);
                //output.accept(MtaItems.HOLY_KNIGHTS_LEGGINGS);
                //output.accept(MtaItems.HOLY_KNIGHTS_BOOTS);
                output.accept(MtaItems.MYSTIC_MERMAIDS_TRIDENT);
                //output.accept(MtaItems.MYSTIC_MERMAIDS_HELMET);
                //output.accept(MtaItems.MYSTIC_MERMAIDS_CHESTPLATE);
                //output.accept(MtaItems.MYSTIC_MERMAIDS_LEGGINGS);
                //output.accept(MtaItems.MYSTIC_MERMAIDS_BOOTS);
                output.accept(MtaItems.TEMPLE_ANGELS_BOW);
                output.accept(MtaItems.TEMPLE_ANGELS_HELMET);
                output.accept(MtaItems.TEMPLE_ANGELS_CHESTPLATE);
                output.accept(MtaItems.TEMPLE_ANGELS_LEGGINGS);
                output.accept(MtaItems.TEMPLE_ANGELS_BOOTS);
                output.accept(MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE);
                output.accept(MtaItems.WRATHFUL_BERSERKERS_HELMET);
                output.accept(MtaItems.WRATHFUL_BERSERKERS_CHESTPLATE);
                output.accept(MtaItems.WRATHFUL_BERSERKERS_LEGGINGS);
                output.accept(MtaItems.WRATHFUL_BERSERKERS_BOOTS);
                output.accept(MtaItems.SHADOW_ROGUES_DAGGER);
                output.accept(MtaItems.SHADOW_ROGUES_HELMET);
                output.accept(MtaItems.SHADOW_ROGUES_CHESTPLATE);
                output.accept(MtaItems.SHADOW_ROGUES_LEGGINGS);
                output.accept(MtaItems.SHADOW_ROGUES_BOOTS);


                //TOOLS
                output.accept(MtaItems.ARMAMENT_PICKAXE);
                output.accept(MtaItems.ARMAMENT_AXE);
                output.accept(MtaItems.ARMAMENT_SHOVEL);

                output.accept(MtaItems.ROYAL_PICKAXE);
                output.accept(MtaItems.ROYAL_AXE);
                output.accept(MtaItems.ROYAL_SHOVEL);

                output.accept(MtaItems.AQUATIC_PICKAXE);
                output.accept(MtaItems.AQUATIC_AXE);
                output.accept(MtaItems.AQUATIC_SHOVEL);

                output.accept(MtaItems.ANGELIC_PICKAXE);
                output.accept(MtaItems.ANGELIC_AXE);
                output.accept(MtaItems.ANGELIC_SHOVEL);

                output.accept(MtaItems.BERSERK_PICKAXE);
                output.accept(MtaItems.BERSERK_AXE);
                output.accept(MtaItems.BERSERK_SHOVEL);

                output.accept(MtaItems.FEATHERWEIGHT_PICKAXE);
                output.accept(MtaItems.FEATHERWEIGHT_AXE);
                output.accept(MtaItems.FEATHERWEIGHT_SHOVEL);

            }).build());


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MISC = TABS.register("mtamisc", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.mtamisc"))
            .withTabsBefore(MtaTabs.EQUIPMENTS.getId())
            .icon(MtaItems.COCONUT_MILK.get()::getDefaultInstance)
            .displayItems((parameters, output) -> {



                //FOOD TOOLS

                output.accept(MtaItems.BIG_BOWL);

                //FOOD
                output.accept(MtaItems.ONION);
                output.accept(MtaItems.SHRIMP);
                output.accept(MtaItems.COOKED_SHRIMP);
                output.accept(MtaItems.TOMATO);
                output.accept(MtaItems.TOMATO_SEEDS);
                output.accept(MtaItems.BELL_PEPPER);
                output.accept(MtaItems.BELL_PEPPER_SEEDS);
                output.accept(MtaItems.CHILI_PEPPER);
                output.accept(MtaItems.CHILI_PEPPER_SEEDS);
                output.accept(MtaItems.RICE);
                output.accept(MtaItems.ONIGIRI);
                output.accept(MtaItems.COCONUT);
                output.accept(MtaItems.COCONUT_MILK);
                output.accept(MtaItems.COCONUT_SLICE);
                output.accept(MtaItems.SPICE_MIX);
                output.accept(MtaItems.SWEET_BEEF_CURRY);
                output.accept(MtaItems.SWEET_PORK_CURRY);
                output.accept(MtaItems.SWEET_CHICKEN_CURRY);
                output.accept(MtaItems.SWEET_SHRIMP_CURRY);
                output.accept(MtaItems.MILD_BEEF_CURRY);
                output.accept(MtaItems.MILD_PORK_CURRY);
                output.accept(MtaItems.MILD_CHICKEN_CURRY);
                output.accept(MtaItems.MILD_SHRIMP_CURRY);
                output.accept(MtaItems.SPICY_BEEF_CURRY);
                output.accept(MtaItems.SPICY_PORK_CURRY);
                output.accept(MtaItems.SPICY_CHICKEN_CURRY);
                output.accept(MtaItems.SPICY_SHRIMP_CURRY);


                //SPAWNS

                output.accept(MtaItems.YUKI_ONNA_SPAWN_EGG);
                output.accept(MtaItems.FALLEN_SAMURAI_SPAWN_EGG);
                output.accept(MtaItems.BUTTERFLY_SPAWN_EGG);
                output.accept(MtaItems.BEARDED_DRAGON_SPAWN_EGG);
                output.accept(MtaItems.CAPYBARA_SPAWN_EGG);
                output.accept(MtaItems.DUCK_SPAWN_EGG);
                output.accept(MtaItems.FERRET_SPAWN_EGG);
                output.accept(MtaItems.GREAT_WHITE_SHARK_SPAWN_EGG);
                output.accept(MtaItems.HORSESHOE_CRAB_SPAWN_EGG);
                output.accept(MtaItems.JELLYFISH_SPAWN_EGG);
                output.accept(MtaItems.OCTOPUS_SPAWN_EGG);
                output.accept(MtaItems.OWL_SPAWN_EGG);
                output.accept(MtaItems.PENGUIN_SPAWN_EGG);
                output.accept(MtaItems.RACCOON_SPAWN_EGG);
                output.accept(MtaItems.SHRIMP_SPAWN_EGG);
                output.accept(MtaItems.TOUCAN_SPAWN_EGG);
                //BOSS SPAWNS
                if (parameters.hasPermissions()){
                output.accept(MtaItems.WITHER_JUGGERNAUT_SPAWN_EGG);
                }
            }).build());



    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }

}
