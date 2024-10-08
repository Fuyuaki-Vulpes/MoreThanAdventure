package com.fuyuaki.morethanadventure.core.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.Collection;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MtaTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = TABS.register("mtatab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.morethanadventure")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .icon(MtaItems.NETHERITE_FRACTURE.get()::getDefaultInstance)
            .displayItems((parameters, output) -> {
                Collection<ItemStack> wgItems = MtaTabs.WORLD_GEN.get().getDisplayItems();
                wgItems.removeIf(stack -> MtaTabs.BUILDING.get().getDisplayItems().contains(stack));
                Collection<ItemStack> building = MtaTabs.BUILDING.get().getDisplayItems();
                building.removeIf(stack -> MtaTabs.MISC.get().getDisplayItems().contains(stack));

                output.acceptAll(wgItems);
                output.acceptAll(building);
                output.acceptAll(MtaTabs.EQUIPMENTS.get().getDisplayItems());
                output.acceptAll(MtaTabs.MISC.get().getDisplayItems());
            }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WORLD_GEN = TABS.register("mtaworldgen", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.mtagenblocks"))
            .withTabsBefore(MtaTabs.MAIN.getId())
            .icon(MtaBlocks.SWEET_BERRY_LEAVES.get().asItem()::getDefaultInstance)
            .displayItems((parameters, output) -> {
                output.accept(MtaBlocks.PALM_LOG.get());
                output.accept(MtaBlocks.PALM_SAPLING.get());
                output.accept(MtaBlocks.PALM_LEAVES.get());
                output.accept(MtaBlocks.SWEET_BERRY_LEAVES.get());
                output.accept(MtaBlocks.SCATTERED_LEAVES.get());


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


                output.accept(MtaBlocks.GRASSY_DIRT.get());
                output.accept(MtaBlocks.PERMAFROST_GRASS.get());
                output.accept(MtaBlocks.PERMAFROST_DIRT.get());
                output.accept(MtaBlocks.PERMAFROST_STONE.get());
                output.accept(MtaBlocks.TUNDRA_GRASS.get());
                output.accept(MtaBlocks.SHALLOW_GRASS.get());

            }).build());

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BUILDING = TABS.register("mtabuilding", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.mtabuilding"))
            .withTabsBefore(MtaTabs.WORLD_GEN.getId())
            .icon(MtaBlocks.STONE_TILES.get().asItem()::getDefaultInstance)
            .displayItems((parameters, output) -> {

                output.accept(MtaBlocks.PALM_LOG.get());
                output.accept(MtaBlocks.STRIPPED_PALM_LOG.get());
                output.accept(MtaBlocks.PALM_WOOD.get());
                output.accept(MtaBlocks.STRIPPED_PALM_WOOD.get());
                output.accept(MtaBlocks.PALM_PLANKS.get());
                output.accept(MtaBlocks.PALM_SAPLING.get());
                output.accept(MtaBlocks.PALM_STAIRS.get());
                output.accept(MtaBlocks.PALM_SLAB.get());
                output.accept(MtaBlocks.PALM_PRESSURE_PLATE.get());
                output.accept(MtaBlocks.PALM_BUTTON.get());
                output.accept(MtaBlocks.PALM_FENCE.get());
                output.accept(MtaBlocks.PALM_FENCE_GATE.get());
                output.accept(MtaBlocks.PALM_DOOR.get());
                output.accept(MtaBlocks.PALM_TRAPDOOR.get());

                output.accept(MtaBlocks.STONE_TILES.get());
                output.accept(MtaBlocks.STONE_TILES_SLAB.get());
                output.accept(MtaBlocks.STONE_TILES_STAIRS.get());
                output.accept(MtaBlocks.STONE_TILES_WALL.get());
                output.accept(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES.get());
                output.accept(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_SLAB.get());
                output.accept(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_STAIRS.get());
                output.accept(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_WALL.get());
                output.accept(MtaBlocks.DIRTY_STONE_TILES.get());
                output.accept(MtaBlocks.DIRTY_STONE_TILES_SLAB.get());
                output.accept(MtaBlocks.DIRTY_STONE_TILES_STAIRS.get());
                output.accept(MtaBlocks.DIRTY_STONE_TILES_WALL.get());
                output.accept(MtaBlocks.VERY_DIRTY_STONE_TILES.get());
                output.accept(MtaBlocks.VERY_DIRTY_STONE_TILES_SLAB.get());
                output.accept(MtaBlocks.VERY_DIRTY_STONE_TILES_STAIRS.get());
                output.accept(MtaBlocks.VERY_DIRTY_STONE_TILES_WALL.get());

                output.accept(MtaBlocks.TERRACOTTA_TILES.get());
                output.accept(MtaBlocks.TERRACOTTA_SLAB.get());
                output.accept(MtaBlocks.TERRACOTTA_TILES_SLAB.get());
                output.accept(MtaBlocks.TERRACOTTA_STAIRS.get());
                output.accept(MtaBlocks.TERRACOTTA_TILES_STAIRS.get());
                output.accept(MtaBlocks.TERRACOTTA_WALL.get());
                output.accept(MtaBlocks.TERRACOTTA_TILES_WALL.get());

                output.accept(MtaBlocks.WHITE_TERRACOTTA_TILES.get());
                output.accept(MtaBlocks.WHITE_TERRACOTTA_SLAB.get());
                output.accept(MtaBlocks.WHITE_TERRACOTTA_TILES_SLAB.get());
                output.accept(MtaBlocks.WHITE_TERRACOTTA_STAIRS.get());
                output.accept(MtaBlocks.WHITE_TERRACOTTA_TILES_STAIRS.get());
                output.accept(MtaBlocks.WHITE_TERRACOTTA_WALL.get());
                output.accept(MtaBlocks.WHITE_TERRACOTTA_TILES_WALL.get());

                output.accept(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES.get());
                output.accept(MtaBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get());
                output.accept(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_SLAB.get());
                output.accept(MtaBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get());
                output.accept(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_STAIRS.get());
                output.accept(MtaBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get());
                output.accept(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_WALL.get());

                output.accept(MtaBlocks.GRAY_TERRACOTTA_TILES.get());
                output.accept(MtaBlocks.GRAY_TERRACOTTA_SLAB.get());
                output.accept(MtaBlocks.GRAY_TERRACOTTA_TILES_SLAB.get());
                output.accept(MtaBlocks.GRAY_TERRACOTTA_STAIRS.get());
                output.accept(MtaBlocks.GRAY_TERRACOTTA_TILES_STAIRS.get());
                output.accept(MtaBlocks.GRAY_TERRACOTTA_WALL.get());
                output.accept(MtaBlocks.GRAY_TERRACOTTA_TILES_WALL.get());

                output.accept(MtaBlocks.BLACK_TERRACOTTA_TILES.get());
                output.accept(MtaBlocks.BLACK_TERRACOTTA_SLAB.get());
                output.accept(MtaBlocks.BLACK_TERRACOTTA_TILES_SLAB.get());
                output.accept(MtaBlocks.BLACK_TERRACOTTA_STAIRS.get());
                output.accept(MtaBlocks.BLACK_TERRACOTTA_TILES_STAIRS.get());
                output.accept(MtaBlocks.BLACK_TERRACOTTA_WALL.get());
                output.accept(MtaBlocks.BLACK_TERRACOTTA_TILES_WALL.get());

                output.accept(MtaBlocks.BROWN_TERRACOTTA_TILES.get());
                output.accept(MtaBlocks.BROWN_TERRACOTTA_SLAB.get());
                output.accept(MtaBlocks.BROWN_TERRACOTTA_TILES_SLAB.get());
                output.accept(MtaBlocks.BROWN_TERRACOTTA_STAIRS.get());
                output.accept(MtaBlocks.BROWN_TERRACOTTA_TILES_STAIRS.get());
                output.accept(MtaBlocks.BROWN_TERRACOTTA_WALL.get());
                output.accept(MtaBlocks.BROWN_TERRACOTTA_TILES_WALL.get());

                output.accept(MtaBlocks.RED_TERRACOTTA_TILES.get());
                output.accept(MtaBlocks.RED_TERRACOTTA_SLAB.get());
                output.accept(MtaBlocks.RED_TERRACOTTA_TILES_SLAB.get());
                output.accept(MtaBlocks.RED_TERRACOTTA_STAIRS.get());
                output.accept(MtaBlocks.RED_TERRACOTTA_TILES_STAIRS.get());
                output.accept(MtaBlocks.RED_TERRACOTTA_WALL.get());
                output.accept(MtaBlocks.RED_TERRACOTTA_TILES_WALL.get());

                output.accept(MtaBlocks.ORANGE_TERRACOTTA_TILES.get());
                output.accept(MtaBlocks.ORANGE_TERRACOTTA_SLAB.get());
                output.accept(MtaBlocks.ORANGE_TERRACOTTA_TILES_SLAB.get());
                output.accept(MtaBlocks.ORANGE_TERRACOTTA_STAIRS.get());
                output.accept(MtaBlocks.ORANGE_TERRACOTTA_TILES_STAIRS.get());
                output.accept(MtaBlocks.ORANGE_TERRACOTTA_WALL.get());
                output.accept(MtaBlocks.ORANGE_TERRACOTTA_TILES_WALL.get());

                output.accept(MtaBlocks.YELLOW_TERRACOTTA_TILES.get());
                output.accept(MtaBlocks.YELLOW_TERRACOTTA_SLAB.get());
                output.accept(MtaBlocks.YELLOW_TERRACOTTA_TILES_SLAB.get());
                output.accept(MtaBlocks.YELLOW_TERRACOTTA_STAIRS.get());
                output.accept(MtaBlocks.YELLOW_TERRACOTTA_TILES_STAIRS.get());
                output.accept(MtaBlocks.YELLOW_TERRACOTTA_WALL.get());
                output.accept(MtaBlocks.YELLOW_TERRACOTTA_TILES_WALL.get());

                output.accept(MtaBlocks.LIME_TERRACOTTA_TILES.get());
                output.accept(MtaBlocks.LIME_TERRACOTTA_SLAB.get());
                output.accept(MtaBlocks.LIME_TERRACOTTA_TILES_SLAB.get());
                output.accept(MtaBlocks.LIME_TERRACOTTA_STAIRS.get());
                output.accept(MtaBlocks.LIME_TERRACOTTA_TILES_STAIRS.get());
                output.accept(MtaBlocks.LIME_TERRACOTTA_WALL.get());
                output.accept(MtaBlocks.LIME_TERRACOTTA_TILES_WALL.get());

                output.accept(MtaBlocks.GREEN_TERRACOTTA_TILES.get());
                output.accept(MtaBlocks.GREEN_TERRACOTTA_SLAB.get());
                output.accept(MtaBlocks.GREEN_TERRACOTTA_TILES_SLAB.get());
                output.accept(MtaBlocks.GREEN_TERRACOTTA_STAIRS.get());
                output.accept(MtaBlocks.GREEN_TERRACOTTA_TILES_STAIRS.get());
                output.accept(MtaBlocks.GREEN_TERRACOTTA_WALL.get());
                output.accept(MtaBlocks.GREEN_TERRACOTTA_TILES_WALL.get());

                output.accept(MtaBlocks.CYAN_TERRACOTTA_TILES.get());
                output.accept(MtaBlocks.CYAN_TERRACOTTA_SLAB.get());
                output.accept(MtaBlocks.CYAN_TERRACOTTA_TILES_SLAB.get());
                output.accept(MtaBlocks.CYAN_TERRACOTTA_STAIRS.get());
                output.accept(MtaBlocks.CYAN_TERRACOTTA_TILES_STAIRS.get());
                output.accept(MtaBlocks.CYAN_TERRACOTTA_WALL.get());
                output.accept(MtaBlocks.CYAN_TERRACOTTA_TILES_WALL.get());

                output.accept(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES.get());
                output.accept(MtaBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get());
                output.accept(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_SLAB.get());
                output.accept(MtaBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get());
                output.accept(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_STAIRS.get());
                output.accept(MtaBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get());
                output.accept(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_WALL.get());

                output.accept(MtaBlocks.BLUE_TERRACOTTA_TILES.get());
                output.accept(MtaBlocks.BLUE_TERRACOTTA_SLAB.get());
                output.accept(MtaBlocks.BLUE_TERRACOTTA_TILES_SLAB.get());
                output.accept(MtaBlocks.BLUE_TERRACOTTA_STAIRS.get());
                output.accept(MtaBlocks.BLUE_TERRACOTTA_TILES_STAIRS.get());
                output.accept(MtaBlocks.BLUE_TERRACOTTA_WALL.get());
                output.accept(MtaBlocks.BLUE_TERRACOTTA_TILES_WALL.get());

                output.accept(MtaBlocks.PURPLE_TERRACOTTA_TILES.get());
                output.accept(MtaBlocks.PURPLE_TERRACOTTA_SLAB.get());
                output.accept(MtaBlocks.PURPLE_TERRACOTTA_TILES_SLAB.get());
                output.accept(MtaBlocks.PURPLE_TERRACOTTA_STAIRS.get());
                output.accept(MtaBlocks.PURPLE_TERRACOTTA_TILES_STAIRS.get());
                output.accept(MtaBlocks.PURPLE_TERRACOTTA_WALL.get());
                output.accept(MtaBlocks.PURPLE_TERRACOTTA_TILES_WALL.get());

                output.accept(MtaBlocks.MAGENTA_TERRACOTTA_TILES.get());
                output.accept(MtaBlocks.MAGENTA_TERRACOTTA_SLAB.get());
                output.accept(MtaBlocks.MAGENTA_TERRACOTTA_TILES_SLAB.get());
                output.accept(MtaBlocks.MAGENTA_TERRACOTTA_STAIRS.get());
                output.accept(MtaBlocks.MAGENTA_TERRACOTTA_TILES_STAIRS.get());
                output.accept(MtaBlocks.MAGENTA_TERRACOTTA_WALL.get());
                output.accept(MtaBlocks.MAGENTA_TERRACOTTA_TILES_WALL.get());

                output.accept(MtaBlocks.PINK_TERRACOTTA_TILES.get());
                output.accept(MtaBlocks.PINK_TERRACOTTA_SLAB.get());
                output.accept(MtaBlocks.PINK_TERRACOTTA_TILES_SLAB.get());
                output.accept(MtaBlocks.PINK_TERRACOTTA_STAIRS.get());
                output.accept(MtaBlocks.PINK_TERRACOTTA_TILES_STAIRS.get());
                output.accept(MtaBlocks.PINK_TERRACOTTA_WALL.get());
                output.accept(MtaBlocks.PINK_TERRACOTTA_TILES_WALL.get());


                output.accept(MtaBlocks.WHITE_CONCRETE_SLAB.get());
                output.accept(MtaBlocks.WHITE_CONCRETE_STAIRS.get());
                output.accept(MtaBlocks.WHITE_CONCRETE_WALL.get());

                output.accept(MtaBlocks.LIGHT_GRAY_CONCRETE_SLAB.get());
                output.accept(MtaBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get());
                output.accept(MtaBlocks.LIGHT_GRAY_CONCRETE_WALL.get());

                output.accept(MtaBlocks.GRAY_CONCRETE_SLAB.get());
                output.accept(MtaBlocks.GRAY_CONCRETE_STAIRS.get());
                output.accept(MtaBlocks.GRAY_CONCRETE_WALL.get());

                output.accept(MtaBlocks.BLACK_CONCRETE_SLAB.get());
                output.accept(MtaBlocks.BLACK_CONCRETE_STAIRS.get());
                output.accept(MtaBlocks.BLACK_CONCRETE_WALL.get());

                output.accept(MtaBlocks.BROWN_CONCRETE_SLAB.get());
                output.accept(MtaBlocks.BROWN_CONCRETE_STAIRS.get());
                output.accept(MtaBlocks.BROWN_CONCRETE_WALL.get());

                output.accept(MtaBlocks.RED_CONCRETE_SLAB.get());
                output.accept(MtaBlocks.RED_CONCRETE_STAIRS.get());
                output.accept(MtaBlocks.RED_CONCRETE_WALL.get());

                output.accept(MtaBlocks.ORANGE_CONCRETE_SLAB.get());
                output.accept(MtaBlocks.ORANGE_CONCRETE_STAIRS.get());
                output.accept(MtaBlocks.ORANGE_CONCRETE_WALL.get());

                output.accept(MtaBlocks.YELLOW_CONCRETE_SLAB.get());
                output.accept(MtaBlocks.YELLOW_CONCRETE_STAIRS.get());
                output.accept(MtaBlocks.YELLOW_CONCRETE_WALL.get());

                output.accept(MtaBlocks.LIME_CONCRETE_SLAB.get());
                output.accept(MtaBlocks.LIME_CONCRETE_STAIRS.get());
                output.accept(MtaBlocks.LIME_CONCRETE_WALL.get());

                output.accept(MtaBlocks.GREEN_CONCRETE_SLAB.get());
                output.accept(MtaBlocks.GREEN_CONCRETE_STAIRS.get());
                output.accept(MtaBlocks.GREEN_CONCRETE_WALL.get());

                output.accept(MtaBlocks.CYAN_CONCRETE_SLAB.get());
                output.accept(MtaBlocks.CYAN_CONCRETE_STAIRS.get());
                output.accept(MtaBlocks.CYAN_CONCRETE_WALL.get());

                output.accept(MtaBlocks.LIGHT_BLUE_CONCRETE_SLAB.get());
                output.accept(MtaBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get());
                output.accept(MtaBlocks.LIGHT_BLUE_CONCRETE_WALL.get());

                output.accept(MtaBlocks.BLUE_CONCRETE_SLAB.get());
                output.accept(MtaBlocks.BLUE_CONCRETE_STAIRS.get());
                output.accept(MtaBlocks.BLUE_CONCRETE_WALL.get());

                output.accept(MtaBlocks.PURPLE_CONCRETE_SLAB.get());
                output.accept(MtaBlocks.PURPLE_CONCRETE_STAIRS.get());
                output.accept(MtaBlocks.PURPLE_CONCRETE_WALL.get());

                output.accept(MtaBlocks.MAGENTA_CONCRETE_SLAB.get());
                output.accept(MtaBlocks.MAGENTA_CONCRETE_STAIRS.get());
                output.accept(MtaBlocks.MAGENTA_CONCRETE_WALL.get());

                output.accept(MtaBlocks.PINK_CONCRETE_SLAB.get());
                output.accept(MtaBlocks.PINK_CONCRETE_STAIRS.get());
                output.accept(MtaBlocks.PINK_CONCRETE_WALL.get());

                output.accept(MtaBlocks.COARSE_DIRT_PATH.get());
                output.accept(MtaBlocks.COBBLED_DIRT.get());
                output.accept(MtaBlocks.SAND_PATH.get());

            }).build());



    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EQUIPMENTS = TABS.register("mtaequip", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.mtaequip"))
            .withTabsBefore(MtaTabs.BUILDING.getId())
            .icon(MtaItems.NETHERSTEEL_PICKAXE.get()::getDefaultInstance)
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
                output.accept(MtaItems.HOLY_KNIGHTS_HELMET);
                output.accept(MtaItems.HOLY_KNIGHTS_CHESTPLATE);
                output.accept(MtaItems.HOLY_KNIGHTS_LEGGINGS);
                output.accept(MtaItems.HOLY_KNIGHTS_BOOTS);
                output.accept(MtaItems.MYSTIC_MERMAIDS_TRIDENT);
                output.accept(MtaItems.MYSTIC_MERMAIDS_HELMET);
                output.accept(MtaItems.MYSTIC_MERMAIDS_CHESTPLATE);
                output.accept(MtaItems.MYSTIC_MERMAIDS_LEGGINGS);
                output.accept(MtaItems.MYSTIC_MERMAIDS_BOOTS);
                output.accept(MtaItems.SILENT_REAPERS_SCYTHE);
                output.accept(MtaItems.SILENT_REAPERS_HELMET);
                output.accept(MtaItems.SILENT_REAPERS_CHESTPLATE);
                output.accept(MtaItems.SILENT_REAPERS_LEGGINGS);
                output.accept(MtaItems.SILENT_REAPERS_BOOTS);
                output.accept(MtaItems.TEMPLE_ANGELS_BOW);
                output.accept(MtaItems.TEMPLE_ANGELS_HELMET);
                output.accept(MtaItems.TEMPLE_ANGELS_CHESTPLATE);
                output.accept(MtaItems.TEMPLE_ANGELS_LEGGINGS);
                output.accept(MtaItems.TEMPLE_ANGELS_BOOTS);
                output.accept(MtaItems.COLD_SET_WEAPON);
                output.accept(MtaItems.COLD_SET_HELMET);
                output.accept(MtaItems.COLD_SET_CHESTPLATE);
                output.accept(MtaItems.COLD_SET_LEGGINGS);
                output.accept(MtaItems.COLD_SET_BOOTS);
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

            }).build());


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MISC = TABS.register("mtamisc", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.mtamisc"))
            .withTabsBefore(MtaTabs.EQUIPMENTS.getId())
            .icon(MtaBlocks.SPRINKLER.get().asItem()::getDefaultInstance)
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

                output.accept(MtaBlocks.SPRINKLER.get());
                output.accept(MtaBlocks.QUARTZ_LAMP.get());


                output.accept(MtaItems.CLEAR_QUARTZ);
                output.accept(MtaItems.NETHERITE_FRACTURE);
                output.accept(MtaItems.AGATE);
                output.accept(MtaItems.ALEXANDRITE);
                output.accept(MtaItems.AQUAMARINE);
                output.accept(MtaItems.BLOODSTONE);
                output.accept(MtaItems.CELESTITE);
                output.accept(MtaItems.CRYOLITE);
                output.accept(MtaItems.GARNET);
                output.accept(MtaItems.MOONSTONE);
                output.accept(MtaItems.ARMAMENT_UPGRADE);
                output.accept(MtaItems.ROYAL_UPGRADE);
                output.accept(MtaItems.AQUATIC_UPGRADE);
                output.accept(MtaItems.DEATHLY_UPGRADE);
                output.accept(MtaItems.ANGELIC_UPGRADE);
                output.accept(MtaItems.FREEZING_UPGRADE);
                output.accept(MtaItems.BERSERK_UPGRADE);
                output.accept(MtaItems.FEATHERWEIGHT_UPGRADE);


                //SPAWNS

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

                //HOSTILE

                output.accept(MtaItems.YUKI_ONNA_SPAWN_EGG);
                output.accept(MtaItems.FALLEN_SAMURAI_SPAWN_EGG);
                output.accept(MtaItems.ICICLE_CREEPER_SPAWN_EGG);
                output.accept(MtaItems.ARMORED_SKELETON_SPAWN_EGG);
                output.accept(MtaItems.BLACK_WIDOW_SPAWN_EGG);
                output.accept(MtaItems.CHARRED_SKELETON_SPAWN_EGG);
                output.accept(MtaItems.CORROSIVE_CUBE_SPAWN_EGG);
                output.accept(MtaItems.FROZEN_SLIME_SPAWN_EGG);
                output.accept(MtaItems.GLOW_SPIDER_SPAWN_EGG);
                output.accept(MtaItems.HOST_SPAWN_EGG);
                output.accept(MtaItems.MOSSY_ZOMBIE_SPAWN_EGG);
                output.accept(MtaItems.SKELETON_FIGHTER_SPAWN_EGG);
                output.accept(MtaItems.TOXIC_ZOMBIE_SPAWN_EGG);
                output.accept(MtaItems.ZOMBIFIED_MINER_SPAWN_EGG);

                //BOSS SPAWNS
                if (parameters.hasPermissions()){
                output.accept(MtaItems.WITHER_JUGGERNAUT_SPAWN_EGG);
                }
            }).build());



    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }

}
