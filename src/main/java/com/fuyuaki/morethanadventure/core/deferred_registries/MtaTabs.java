package com.fuyuaki.morethanadventure.core.deferred_registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MtaTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    private static final ResourceLocation TAB_TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/gui/container/creative_inventory/tab_mta.png");


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> WORLD_GEN = TABS.register("mtaworldgen", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.mtagenblocks"))
            .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
            .icon(MtaBlocks.PALM_SAPLING.get().asItem()::getDefaultInstance)
            .backgroundTexture(TAB_TEXTURE).withLabelColor(0xb0fbf0)
            .displayItems((parameters, output) -> {

                output.accept(MtaBlocks.ALPINE_LOG.get());
                output.accept(MtaBlocks.ALPINE_WOOD.get());
                //output.accept(MtaBlocks.ALPINE_LEAVES.get());

                output.accept(MtaBlocks.AVOCADO_LOG.get());
                output.accept(MtaBlocks.AVOCADO_WOOD.get());
                output.accept(MtaBlocks.AVOCADO_LEAVES.get());

                output.accept(MtaBlocks.BOGGED_OAK_LOG.get());
                output.accept(MtaBlocks.BOGGED_OAK_WOOD.get());
                //output.accept(MtaBlocks.BOGGED_OAK_LEAVES.get());

                output.accept(MtaBlocks.MANGO_LOG.get());
                output.accept(MtaBlocks.MANGO_WOOD.get());
                output.accept(MtaBlocks.MANGO_LEAVES.get());

                output.accept(MtaBlocks.MAPLE_LOG.get());
                output.accept(MtaBlocks.MAPLE_WOOD.get());
                //output.accept(MtaBlocks.MAPLE_LEAVES.get());

                output.accept(MtaBlocks.PALM_LOG.get());
                output.accept(MtaBlocks.PALM_SAPLING.get());
                output.accept(MtaBlocks.PALM_LEAVES.get());

                output.accept(MtaBlocks.SCATTERED_LEAVES.get());
                output.accept(MtaBlocks.CATTAIL.get());
                output.accept(MtaBlocks.CORPSE_FLOWER.get());
                output.accept(MtaBlocks.PITCHER_PLANT.get());
                output.accept(MtaBlocks.VENUS_FLYTRAP.get());


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
                output.accept(MtaBlocks.BLOODSTONE_ORE.get());
                output.accept(MtaBlocks.DEEPSLATE_BLOODSTONE_ORE.get());
                output.accept(MtaBlocks.CELESTITE_ORE.get());
                output.accept(MtaBlocks.CRYOLITE_ORE.get());
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
            .backgroundTexture(TAB_TEXTURE).withLabelColor(0xb0fbf0)
            .displayItems((parameters, output) -> {

                output.accept(MtaBlocks.ALPINE_LOG.get());
                output.accept(MtaBlocks.STRIPPED_ALPINE_LOG.get());
                output.accept(MtaBlocks.ALPINE_WOOD.get());
                output.accept(MtaBlocks.STRIPPED_ALPINE_WOOD.get());
                output.accept(MtaBlocks.ALPINE_PLANKS.get());
                //output.accept(MtaBlocks.ALPINE_SAPLING.get());
                output.accept(MtaBlocks.ALPINE_STAIRS.get());
                output.accept(MtaBlocks.ALPINE_SLAB.get());
                output.accept(MtaBlocks.ALPINE_PRESSURE_PLATE.get());
                output.accept(MtaBlocks.ALPINE_BUTTON.get());
                output.accept(MtaBlocks.ALPINE_FENCE.get());
                output.accept(MtaBlocks.ALPINE_FENCE_GATE.get());
                output.accept(MtaBlocks.ALPINE_DOOR.get());
                output.accept(MtaBlocks.ALPINE_TRAPDOOR.get());

                output.accept(MtaBlocks.AVOCADO_LOG.get());
                output.accept(MtaBlocks.STRIPPED_AVOCADO_LOG.get());
                output.accept(MtaBlocks.AVOCADO_WOOD.get());
                output.accept(MtaBlocks.STRIPPED_AVOCADO_WOOD.get());
                output.accept(MtaBlocks.AVOCADO_PLANKS.get());
                //output.accept(MtaBlocks.AVOCADO_SAPLING.get());
                output.accept(MtaBlocks.AVOCADO_STAIRS.get());
                output.accept(MtaBlocks.AVOCADO_SLAB.get());
                output.accept(MtaBlocks.AVOCADO_PRESSURE_PLATE.get());
                output.accept(MtaBlocks.AVOCADO_BUTTON.get());
                output.accept(MtaBlocks.AVOCADO_FENCE.get());
                output.accept(MtaBlocks.AVOCADO_FENCE_GATE.get());
                output.accept(MtaBlocks.AVOCADO_DOOR.get());
                output.accept(MtaBlocks.AVOCADO_TRAPDOOR.get());

                output.accept(MtaBlocks.BOGGED_OAK_LOG.get());
                output.accept(MtaBlocks.STRIPPED_BOGGED_OAK_LOG.get());
                output.accept(MtaBlocks.BOGGED_OAK_WOOD.get());
                output.accept(MtaBlocks.STRIPPED_BOGGED_OAK_WOOD.get());
                output.accept(MtaBlocks.BOGGED_OAK_PLANKS.get());
                //output.accept(MtaBlocks.BOGGED_OAK_SAPLING.get());
                output.accept(MtaBlocks.BOGGED_OAK_STAIRS.get());
                output.accept(MtaBlocks.BOGGED_OAK_SLAB.get());
                output.accept(MtaBlocks.BOGGED_OAK_PRESSURE_PLATE.get());
                output.accept(MtaBlocks.BOGGED_OAK_BUTTON.get());
                output.accept(MtaBlocks.BOGGED_OAK_FENCE.get());
                output.accept(MtaBlocks.BOGGED_OAK_FENCE_GATE.get());
                output.accept(MtaBlocks.BOGGED_OAK_DOOR.get());
                output.accept(MtaBlocks.BOGGED_OAK_TRAPDOOR.get());

                output.accept(MtaBlocks.MANGO_LOG.get());
                output.accept(MtaBlocks.STRIPPED_MANGO_LOG.get());
                output.accept(MtaBlocks.MANGO_WOOD.get());
                output.accept(MtaBlocks.STRIPPED_MANGO_WOOD.get());
                output.accept(MtaBlocks.MANGO_PLANKS.get());
                //output.accept(MtaBlocks.MANGO_SAPLING.get());
                output.accept(MtaBlocks.MANGO_STAIRS.get());
                output.accept(MtaBlocks.MANGO_SLAB.get());
                output.accept(MtaBlocks.MANGO_PRESSURE_PLATE.get());
                output.accept(MtaBlocks.MANGO_BUTTON.get());
                output.accept(MtaBlocks.MANGO_FENCE.get());
                output.accept(MtaBlocks.MANGO_FENCE_GATE.get());
                output.accept(MtaBlocks.MANGO_DOOR.get());
                output.accept(MtaBlocks.MANGO_TRAPDOOR.get());

                output.accept(MtaBlocks.MAPLE_LOG.get());
                output.accept(MtaBlocks.STRIPPED_MAPLE_LOG.get());
                output.accept(MtaBlocks.MAPLE_WOOD.get());
                output.accept(MtaBlocks.STRIPPED_MAPLE_WOOD.get());
                output.accept(MtaBlocks.MAPLE_PLANKS.get());
                //output.accept(MtaBlocks.MAPLE_SAPLING.get());
                output.accept(MtaBlocks.MAPLE_STAIRS.get());
                output.accept(MtaBlocks.MAPLE_SLAB.get());
                output.accept(MtaBlocks.MAPLE_PRESSURE_PLATE.get());
                output.accept(MtaBlocks.MAPLE_BUTTON.get());
                output.accept(MtaBlocks.MAPLE_FENCE.get());
                output.accept(MtaBlocks.MAPLE_FENCE_GATE.get());
                output.accept(MtaBlocks.MAPLE_DOOR.get());
                output.accept(MtaBlocks.MAPLE_TRAPDOOR.get());

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

                output.accept(MtaBlocks.SEALOG.get());
                output.accept(MtaBlocks.SEAWOOD.get());
                output.accept(MtaBlocks.SEAWOOD_PLANKS.get());
                output.accept(MtaBlocks.SEAWOOD_SAPLING.get());
                output.accept(MtaBlocks.SEAWOOD_STAIRS.get());
                output.accept(MtaBlocks.SEAWOOD_SLAB.get());
                output.accept(MtaBlocks.SEAWOOD_PRESSURE_PLATE.get());
                output.accept(MtaBlocks.SEAWOOD_BUTTON.get());
                output.accept(MtaBlocks.SEAWOOD_FENCE.get());
                output.accept(MtaBlocks.SEAWOOD_FENCE_GATE.get());
                output.accept(MtaBlocks.SEAWOOD_DOOR.get());
                output.accept(MtaBlocks.SEAWOOD_TRAPDOOR.get());

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
            .backgroundTexture(TAB_TEXTURE).withLabelColor(0xb0fbf0)
            .displayItems((parameters, output) -> {


                output.accept(MtaItems.WEIGHTED_DICE);
                output.accept(MtaItems.CAT_MASK);
                output.accept(MtaItems.CLIMBING_CLAWS);
                output.accept(MtaItems.PISTON_BOOTS);
                output.accept(MtaItems.REGENERATIVE_TALISMAN);
                output.accept(MtaItems.SLEEPING_KIT);
                output.accept(MtaItems.STRIDER_BOOTS);

                output.accept(MtaItems.TOTEM_OF_COMBATING);



                output.accept(MtaItems.POLEARM);

                output.accept(MtaItems.WOOD_ANCHOR);
                output.accept(MtaItems.WOOD_CLAW);
                output.accept(MtaItems.WOOD_CLAYMORE);
                output.accept(MtaItems.WOOD_CUTLASS);
                output.accept(MtaItems.WOOD_DAGGER);
                output.accept(MtaItems.WOOD_DOUBLE_AXE);
                output.accept(MtaItems.WOOD_FLAIL);
                output.accept(MtaItems.WOOD_GLAIVE);
                output.accept(MtaItems.WOOD_HALBERD);
                output.accept(MtaItems.WOOD_KATANA);
                output.accept(MtaItems.WOOD_RAPIER);
                output.accept(MtaItems.WOOD_SCYTHE);
                output.accept(MtaItems.WOOD_SICKLE);
                output.accept(MtaItems.WOOD_SPEAR);
                output.accept(MtaItems.WOOD_TWINBLADE);
                output.accept(MtaItems.WOOD_WHIP_SWORD);

                output.accept(MtaItems.STONE_ANCHOR);
                output.accept(MtaItems.STONE_CLAW);
                output.accept(MtaItems.STONE_CLAYMORE);
                output.accept(MtaItems.STONE_CUTLASS);
                output.accept(MtaItems.STONE_DAGGER);
                output.accept(MtaItems.STONE_DOUBLE_AXE);
                output.accept(MtaItems.STONE_FLAIL);
                output.accept(MtaItems.STONE_GLAIVE);
                output.accept(MtaItems.STONE_HALBERD);
                output.accept(MtaItems.STONE_KATANA);
                output.accept(MtaItems.STONE_RAPIER);
                output.accept(MtaItems.STONE_SCYTHE);
                output.accept(MtaItems.STONE_SICKLE);
                output.accept(MtaItems.STONE_SPEAR);
                output.accept(MtaItems.STONE_TWINBLADE);
                output.accept(MtaItems.STONE_WHIP_SWORD);

                output.accept(MtaItems.COPPER_SWORD);
                output.accept(MtaItems.COPPER_PICKAXE);
                output.accept(MtaItems.COPPER_AXE);
                output.accept(MtaItems.COPPER_SHOVEL);
                output.accept(MtaItems.COPPER_HOE);
                output.accept(MtaItems.COPPER_ANCHOR);
                output.accept(MtaItems.COPPER_CLAW);
                output.accept(MtaItems.COPPER_CLAYMORE);
                output.accept(MtaItems.COPPER_CUTLASS);
                output.accept(MtaItems.COPPER_DAGGER);
                output.accept(MtaItems.COPPER_DOUBLE_AXE);
                output.accept(MtaItems.COPPER_FLAIL);
                output.accept(MtaItems.COPPER_GLAIVE);
                output.accept(MtaItems.COPPER_HALBERD);
                output.accept(MtaItems.COPPER_KATANA);
                output.accept(MtaItems.COPPER_RAPIER);
                output.accept(MtaItems.COPPER_SCYTHE);
                output.accept(MtaItems.COPPER_SICKLE);
                output.accept(MtaItems.COPPER_SPEAR);
                output.accept(MtaItems.COPPER_TWINBLADE);
                output.accept(MtaItems.COPPER_WHIP_SWORD);

                output.accept(MtaItems.IRON_ANCHOR);
                output.accept(MtaItems.IRON_CLAW);
                output.accept(MtaItems.IRON_CLAYMORE);
                output.accept(MtaItems.IRON_CUTLASS);
                output.accept(MtaItems.IRON_DAGGER);
                output.accept(MtaItems.IRON_DOUBLE_AXE);
                output.accept(MtaItems.IRON_FLAIL);
                output.accept(MtaItems.IRON_GLAIVE);
                output.accept(MtaItems.IRON_HALBERD);
                output.accept(MtaItems.IRON_KATANA);
                output.accept(MtaItems.IRON_RAPIER);
                output.accept(MtaItems.IRON_SCYTHE);
                output.accept(MtaItems.IRON_SICKLE);
                output.accept(MtaItems.IRON_SPEAR);
                output.accept(MtaItems.IRON_TWINBLADE);
                output.accept(MtaItems.IRON_WHIP_SWORD);

                output.accept(MtaItems.GOLD_ANCHOR);
                output.accept(MtaItems.GOLD_CLAW);
                output.accept(MtaItems.GOLD_CLAYMORE);
                output.accept(MtaItems.GOLD_CUTLASS);
                output.accept(MtaItems.GOLD_DAGGER);
                output.accept(MtaItems.GOLD_DOUBLE_AXE);
                output.accept(MtaItems.GOLD_FLAIL);
                output.accept(MtaItems.GOLD_GLAIVE);
                output.accept(MtaItems.GOLD_HALBERD);
                output.accept(MtaItems.GOLD_KATANA);
                output.accept(MtaItems.GOLD_RAPIER);
                output.accept(MtaItems.GOLD_SCYTHE);
                output.accept(MtaItems.GOLD_SICKLE);
                output.accept(MtaItems.GOLD_SPEAR);
                output.accept(MtaItems.GOLD_TWINBLADE);
                output.accept(MtaItems.GOLD_WHIP_SWORD);

                output.accept(MtaItems.NETHERSTEEL_SWORD);
                output.accept(MtaItems.NETHERSTEEL_PICKAXE);
                output.accept(MtaItems.NETHERSTEEL_AXE);
                output.accept(MtaItems.NETHERSTEEL_SHOVEL);
                output.accept(MtaItems.NETHERSTEEL_HOE);
                output.accept(MtaItems.NETHERSTEEL_ANCHOR);
                output.accept(MtaItems.NETHERSTEEL_CLAW);
                output.accept(MtaItems.NETHERSTEEL_CLAYMORE);
                output.accept(MtaItems.NETHERSTEEL_CUTLASS);
                output.accept(MtaItems.NETHERSTEEL_DAGGER);
                output.accept(MtaItems.NETHERSTEEL_DOUBLE_AXE);
                output.accept(MtaItems.NETHERSTEEL_FLAIL);
                output.accept(MtaItems.NETHERSTEEL_GLAIVE);
                output.accept(MtaItems.NETHERSTEEL_HALBERD);
                output.accept(MtaItems.NETHERSTEEL_KATANA);
                output.accept(MtaItems.NETHERSTEEL_RAPIER);
                output.accept(MtaItems.NETHERSTEEL_SCYTHE);
                output.accept(MtaItems.NETHERSTEEL_SICKLE);
                output.accept(MtaItems.NETHERSTEEL_SPEAR);
                output.accept(MtaItems.NETHERSTEEL_TWINBLADE);
                output.accept(MtaItems.NETHERSTEEL_WHIP_SWORD);

                output.accept(MtaItems.DIAMOND_ANCHOR);
                output.accept(MtaItems.DIAMOND_CLAW);
                output.accept(MtaItems.DIAMOND_CLAYMORE);
                output.accept(MtaItems.DIAMOND_CUTLASS);
                output.accept(MtaItems.DIAMOND_DAGGER);
                output.accept(MtaItems.DIAMOND_DOUBLE_AXE);
                output.accept(MtaItems.DIAMOND_FLAIL);
                output.accept(MtaItems.DIAMOND_GLAIVE);
                output.accept(MtaItems.DIAMOND_HALBERD);
                output.accept(MtaItems.DIAMOND_KATANA);
                output.accept(MtaItems.DIAMOND_RAPIER);
                output.accept(MtaItems.DIAMOND_SCYTHE);
                output.accept(MtaItems.DIAMOND_SICKLE);
                output.accept(MtaItems.DIAMOND_SPEAR);
                output.accept(MtaItems.DIAMOND_TWINBLADE);
                output.accept(MtaItems.DIAMOND_WHIP_SWORD);

                output.accept(MtaItems.NETHERITE_TRIDENT);
                output.accept(MtaItems.NETHERITE_BOW);
                output.accept(MtaItems.NETHERITE_MACE);
                output.accept(MtaItems.NETHERITE_ANCHOR);
                output.accept(MtaItems.NETHERITE_CLAW);
                output.accept(MtaItems.NETHERITE_CLAYMORE);
                output.accept(MtaItems.NETHERITE_CUTLASS);
                output.accept(MtaItems.NETHERITE_DAGGER);
                output.accept(MtaItems.NETHERITE_DOUBLE_AXE);
                output.accept(MtaItems.NETHERITE_FLAIL);
                output.accept(MtaItems.NETHERITE_GLAIVE);
                output.accept(MtaItems.NETHERITE_HALBERD);
                output.accept(MtaItems.NETHERITE_KATANA);
                output.accept(MtaItems.NETHERITE_RAPIER);
                output.accept(MtaItems.NETHERITE_SCYTHE);
                output.accept(MtaItems.NETHERITE_SICKLE);
                output.accept(MtaItems.NETHERITE_SPEAR);
                output.accept(MtaItems.NETHERITE_TWINBLADE);
                output.accept(MtaItems.NETHERITE_WHIP_SWORD);

                output.accept(MtaItems.LONG_BOW);
                output.accept(MtaItems.REINFORCED_LONG_BOW);
                output.accept(MtaItems.SHORT_BOW);
                output.accept(MtaItems.REINFORCED_SHORT_BOW);
                output.accept(MtaItems.TWIN_BOW);
                output.accept(MtaItems.REINFORCED_TWIN_BOW);

                output.accept(MtaItems.LEATHER_WHIP);
                output.accept(MtaItems.CHAIN_WHIP);
                output.accept(MtaItems.NETHERITE_WHIP);

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
                output.accept(MtaItems.FREEZING_ICICLE_SPEAR);
                output.accept(MtaItems.FREEZING_ICICLE_HELMET);
                output.accept(MtaItems.FREEZING_ICICLE_CHESTPLATE);
                output.accept(MtaItems.FREEZING_ICICLE_LEGGINGS);
                output.accept(MtaItems.FREEZING_ICICLE_BOOTS);
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


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ITEMS_UTILITIES = TABS.register("mtautil", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.mtautil"))
            .withTabsBefore(MtaTabs.EQUIPMENTS.getId())
            .icon(MtaBlocks.SPRINKLER.get().asItem()::getDefaultInstance)
            .backgroundTexture(TAB_TEXTURE).withLabelColor(0xb0fbf0)
            .displayItems((parameters, output) -> {




                output.accept(MtaBlocks.SPRINKLER.get());
                output.accept(MtaBlocks.QUARTZ_LAMP.get());


                output.accept(MtaItems.CLEAR_QUARTZ);
                output.accept(MtaItems.NETHERITE_FRACTURE);
                output.accept(MtaItems.HOST_HUSK);
                output.accept(MtaItems.SAMURAI_CLOTH);
                output.accept(MtaItems.SIREN_SCALE);
                output.accept(MtaItems.BLACK_WIDOW_VENOM);
                //output.accept(MtaItems.NETHERITE_FRACTURE);
                output.accept(MtaItems.SPIRIT_DUST);
                output.accept(MtaItems.CHARRED_BONE);
                //output.accept(MtaItems.NETHERITE_FRACTURE);

                output.accept(MtaItems.AGATE);
                output.accept(MtaItems.ALEXANDRITE);
                output.accept(MtaItems.AQUAMARINE);
                output.accept(MtaItems.BLOODSTONE);
                output.accept(MtaItems.CELESTITE);
                output.accept(MtaItems.CRYOLITE);
                output.accept(MtaItems.GARNET);
                output.accept(MtaItems.MOONSTONE);
                output.accept(MtaItems.AWAKENED_AGATE);
                output.accept(MtaItems.AWAKENED_ALEXANDRITE);
                output.accept(MtaItems.AWAKENED_AQUAMARINE);
                output.accept(MtaItems.AWAKENED_BLOODSTONE);
                output.accept(MtaItems.AWAKENED_CELESTITE);
                output.accept(MtaItems.AWAKENED_CRYOLITE);
                output.accept(MtaItems.AWAKENED_GARNET);
                output.accept(MtaItems.AWAKENED_MOONSTONE);
                output.accept(MtaItems.ROYAL_UPGRADE);
                output.accept(MtaItems.AQUATIC_UPGRADE);
                output.accept(MtaItems.DEATHLY_UPGRADE);
                output.accept(MtaItems.ANGELIC_UPGRADE);
                output.accept(MtaItems.FREEZING_UPGRADE);
                output.accept(MtaItems.BERSERK_UPGRADE);
                output.accept(MtaItems.FEATHERWEIGHT_UPGRADE);

            }).build());


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> FOODS = TABS.register("mtafoods", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.mtafoods"))
            .withTabsBefore(MtaTabs.ITEMS_UTILITIES.getId())
            .icon(MtaItems.MILD_BEEF_CURRY.get().asItem()::getDefaultInstance)
            .backgroundTexture(TAB_TEXTURE).withLabelColor(0xb0fbf0)
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

                output.accept(MtaItems.APPLE_SLICE);
                output.accept(MtaItems.AVOCADO);
                output.accept(MtaItems.AVOCADO_SLICE);
                output.accept(MtaItems.BANANA);
                output.accept(MtaItems.CABBAGE);
                output.accept(MtaItems.COFFEE_BEANS);
                output.accept(MtaItems.COFFEE);
                output.accept(MtaItems.GRAPES);
                output.accept(MtaItems.MANGO);
                output.accept(MtaItems.MANGO_SLICE);
                output.accept(MtaItems.STRAWBERRY);
                output.accept(MtaItems.TEA_LEAVES);
                output.accept(MtaItems.TEA);
                output.accept(MtaItems.ICE_CUBES);
                output.accept(MtaItems.SMOOTHIE);
                output.accept(MtaItems.JUICE);

            }).build());



    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> SPAWNS = TABS.register("mtaspawn", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.mtaspawn"))
            .withTabsBefore(MtaTabs.FOODS.getId())
            .icon(MtaItems.YUKI_ONNA_SPAWN_EGG.get().asItem()::getDefaultInstance)
            .backgroundTexture(TAB_TEXTURE).withLabelColor(0xb0fbf0)
            .displayItems((parameters, output) -> {



                //SPAWNS

                //TAMABLE

                output.accept(MtaItems.BEARDED_DRAGON_SPAWN_EGG);
                output.accept(MtaItems.CAPYBARA_SPAWN_EGG);
                output.accept(MtaItems.DUCK_SPAWN_EGG);
                output.accept(MtaItems.FERRET_SPAWN_EGG);
                output.accept(MtaItems.HORSESHOE_CRAB_SPAWN_EGG);
                output.accept(MtaItems.OCTOPUS_SPAWN_EGG);
                output.accept(MtaItems.OWL_SPAWN_EGG);
                output.accept(MtaItems.PENGUIN_SPAWN_EGG);
                output.accept(MtaItems.RACCOON_SPAWN_EGG);
                output.accept(MtaItems.TOUCAN_SPAWN_EGG);

                //PASSIVE

                output.accept(MtaItems.BUTTERFLY_SPAWN_EGG);
                output.accept(MtaItems.DEER_SPAWN_EGG);
                output.accept(MtaItems.JELLYFISH_SPAWN_EGG);
                output.accept(MtaItems.SHRIMP_SPAWN_EGG);

                //NEUTRAL

                output.accept(MtaItems.GREAT_WHITE_SHARK_SPAWN_EGG);
                output.accept(MtaItems.TURKEY_SPAWN_EGG);

                //HOSTILE

                output.accept(MtaItems.YUKI_ONNA_SPAWN_EGG);
                output.accept(MtaItems.FALLEN_SAMURAI_SPAWN_EGG);
                output.accept(MtaItems.ICICLE_CREEPER_SPAWN_EGG);
                output.accept(MtaItems.ARMORED_SKELETON_SPAWN_EGG);
                output.accept(MtaItems.BLACK_WIDOW_SPAWN_EGG);
                output.accept(MtaItems.CHARRED_SKELETON_SPAWN_EGG);
                output.accept(MtaItems.CORROSIVE_CUBE_SPAWN_EGG);
                output.accept(MtaItems.FROSTED_SLIME_SPAWN_EGG);
                output.accept(MtaItems.GLOW_SPIDER_SPAWN_EGG);
                output.accept(MtaItems.HOST_SPAWN_EGG);
                output.accept(MtaItems.MOSSY_ZOMBIE_SPAWN_EGG);
                output.accept(MtaItems.SKELETON_FIGHTER_SPAWN_EGG);
                output.accept(MtaItems.TOXIC_ZOMBIE_SPAWN_EGG);
                output.accept(MtaItems.ZOMBIFIED_MINER_SPAWN_EGG);
                //output.accept(MtaItems.SIREN_SPAWN_EGG);
                output.accept(MtaItems.WISPFLY_SPAWN_EGG);

            }).build());



    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }

}
