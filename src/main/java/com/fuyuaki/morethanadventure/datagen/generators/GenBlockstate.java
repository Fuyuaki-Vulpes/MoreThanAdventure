package com.fuyuaki.morethanadventure.datagen.generators;

import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.fuyuaki.morethanadventure.world.block.MtaCrops;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.client.model.generators.*;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class GenBlockstate extends BlockStateProvider {
    public GenBlockstate(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.createDoublePlant(MtaBlocks.CATTAIL.get());
        //simpleBlock(MtaBlocks.CORPSE_LILY.get(), models().cross(blockTexture(MtaBlocks.CORPSE_LILY.get()).getPath(), blockTexture(MtaBlocks.CORPSE_LILY.get())).renderType("cutout"));
        //simpleBlock(MtaBlocks.POTTED_CORPSE_LILY.get(), models().singleTexture("potted_corpse_lily", ResourceLocation.parse("flower_pot_cross"), "plant", blockTexture(MtaBlocks.CORPSE_LILY.get())).renderType("cutout"));
        //simpleBlock(MtaBlocks.PITCHER_PLANT.get(), models().cross(blockTexture(MtaBlocks.PITCHER_PLANT.get()).getPath(), blockTexture(MtaBlocks.PITCHER_PLANT.get())).renderType("cutout"));
        //simpleBlock(MtaBlocks.POTTED_PITCHER_PLANT.get(), models().singleTexture("potted_pitcher_plant", ResourceLocation.parse("flower_pot_cross"), "plant", blockTexture(MtaBlocks.PITCHER_PLANT.get())).renderType("cutout"));
        //blockItem(MtaBlocks.VENUS_FLYTRAP);


        logBlock(((RotatedPillarBlock) MtaBlocks.PALM_LOG.get()));
        logBlock(((RotatedPillarBlock) MtaBlocks.STRIPPED_PALM_LOG.get()));
        axisBlock(((RotatedPillarBlock) MtaBlocks.PALM_WOOD.get()), blockTexture(MtaBlocks.PALM_LOG.get()), blockTexture(MtaBlocks.PALM_LOG.get()));
        axisBlock(((RotatedPillarBlock) MtaBlocks.STRIPPED_PALM_WOOD.get()), blockTexture(MtaBlocks.STRIPPED_PALM_LOG.get()), blockTexture(MtaBlocks.STRIPPED_PALM_LOG.get()));
        blockItem(MtaBlocks.PALM_LOG);
        blockWithItem(MtaBlocks.PERMAFROST_DIRT);

        blockWithItem(MtaBlocks.PERMAFROST_STONE);
        blockItem(MtaBlocks.STRIPPED_PALM_LOG);
        blockItem(MtaBlocks.PALM_WOOD);
        blockItem(MtaBlocks.STRIPPED_PALM_WOOD);
        blockWithItem(MtaBlocks.PALM_PLANKS);
        leavesBlock(MtaBlocks.PALM_LEAVES);
        saplingBlock(MtaBlocks.PALM_SAPLING);
        stairsBlock(((StairBlock) MtaBlocks.PALM_STAIRS.get()), blockTexture(MtaBlocks.PALM_PLANKS.get()));
        slabBlock(((SlabBlock) MtaBlocks.PALM_SLAB.get()), blockTexture(MtaBlocks.PALM_PLANKS.get()), blockTexture(MtaBlocks.PALM_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) MtaBlocks.PALM_PRESSURE_PLATE.get()), blockTexture(MtaBlocks.PALM_PLANKS.get()));
        buttonBlock(((ButtonBlock) MtaBlocks.PALM_BUTTON.get()), blockTexture(MtaBlocks.PALM_PLANKS.get()));
        fenceBlock(((FenceBlock) MtaBlocks.PALM_FENCE.get()), blockTexture(MtaBlocks.PALM_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) MtaBlocks.PALM_FENCE_GATE.get()), blockTexture(MtaBlocks.PALM_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) MtaBlocks.PALM_DOOR.get()), modLoc("block/palm_door_bottom"), modLoc("block/palm_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) MtaBlocks.PALM_TRAPDOOR.get()), modLoc("block/palm_trapdoor"), true, "cutout");
        blockItem(MtaBlocks.PALM_STAIRS);
        blockItem(MtaBlocks.PALM_SLAB);
        blockItem(MtaBlocks.PALM_PRESSURE_PLATE);
        blockItem(MtaBlocks.PALM_FENCE_GATE);
        blockItem(MtaBlocks.PALM_TRAPDOOR, "_bottom");

        logBlock(((RotatedPillarBlock) MtaBlocks.SEALOG.get()));
        axisBlock(((RotatedPillarBlock) MtaBlocks.SEAWOOD.get()), blockTexture(MtaBlocks.SEALOG.get()), blockTexture(MtaBlocks.SEALOG.get()));
        blockItem(MtaBlocks.SEALOG);
        blockItem(MtaBlocks.SEAWOOD);
        blockWithItem(MtaBlocks.SEAWOOD_PLANKS);
        leavesBlock(MtaBlocks.SEAWOOD_LEAVES);
        saplingBlock(MtaBlocks.SEAWOOD_SAPLING);
        stairsBlock(((StairBlock) MtaBlocks.SEAWOOD_STAIRS.get()), blockTexture(MtaBlocks.SEAWOOD_PLANKS.get()));
        slabBlock(((SlabBlock) MtaBlocks.SEAWOOD_SLAB.get()), blockTexture(MtaBlocks.SEAWOOD_PLANKS.get()), blockTexture(MtaBlocks.SEAWOOD_PLANKS.get()));
        pressurePlateBlock(((PressurePlateBlock) MtaBlocks.SEAWOOD_PRESSURE_PLATE.get()), blockTexture(MtaBlocks.SEAWOOD_PLANKS.get()));
        buttonBlock(((ButtonBlock) MtaBlocks.SEAWOOD_BUTTON.get()), blockTexture(MtaBlocks.SEAWOOD_PLANKS.get()));
        fenceBlock(((FenceBlock) MtaBlocks.SEAWOOD_FENCE.get()), blockTexture(MtaBlocks.SEAWOOD_PLANKS.get()));
        fenceGateBlock(((FenceGateBlock) MtaBlocks.SEAWOOD_FENCE_GATE.get()), blockTexture(MtaBlocks.SEAWOOD_PLANKS.get()));
        doorBlockWithRenderType(((DoorBlock) MtaBlocks.SEAWOOD_DOOR.get()), modLoc("block/seawood_door_bottom"), modLoc("block/seawood_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) MtaBlocks.SEAWOOD_TRAPDOOR.get()), modLoc("block/seawood_trapdoor"), true, "cutout");
        blockItem(MtaBlocks.SEAWOOD_STAIRS);
        blockItem(MtaBlocks.SEAWOOD_SLAB);
        blockItem(MtaBlocks.SEAWOOD_PRESSURE_PLATE);
        blockItem(MtaBlocks.SEAWOOD_FENCE_GATE);
        blockItem(MtaBlocks.SEAWOOD_TRAPDOOR, "_bottom");

        verticalBlock(MtaBlocks.STONE_GEYSER.get(), Blocks.STONE, Blocks.STONE);
        verticalBlock(MtaBlocks.TERRACOTTA_GEYSER.get(), Blocks.TERRACOTTA, Blocks.TERRACOTTA);
        verticalBlock(MtaBlocks.NETHERRACK_GEYSER.get(), Blocks.NETHERRACK, Blocks.NETHERRACK);
        verticalBlock(MtaBlocks.BASALT_GEYSER.get(), ResourceLocation.withDefaultNamespace("block/basalt_top"), ResourceLocation.withDefaultNamespace("block/basalt_side"));
        blockWithItem(MtaBlocks.MOSSY_ANDESITE);
        blockWithItem(MtaBlocks.NETHER_IRON_ORE);
        blockWithItem(MtaBlocks.NETHER_DIAMOND_ORE);
        blockWithItem(MtaBlocks.END_LAPIS_ORE);
        blockWithItem(MtaBlocks.END_EMERALD_ORE);
        blockWithItem(MtaBlocks.CLEAR_QUARTZ_ORE);
        blockWithItem(MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_ORE);
        blockWithItem(MtaBlocks.CLEAR_QUARTZ_GROWTH);
        blockWithItem(MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_GROWTH);
        blockWithItem(MtaBlocks.CALCITE_CLEAR_QUARTZ_GROWTH);
        blockWithItem(MtaBlocks.QUARTZ_LAMP);
        blockWithItem(MtaBlocks.NETHERITIC_CRYSTAL);

        blockWithItem(MtaBlocks.AGATE_ORE);
        blockWithItem(MtaBlocks.DEEPSLATE_AGATE_ORE);
        blockWithItem(MtaBlocks.ALEXANDRITE_ORE);
        blockWithItem(MtaBlocks.DEEPSLATE_ALEXANDRITE_ORE);
        blockWithItem(MtaBlocks.AQUAMARINE_ORE);
        blockWithItem(MtaBlocks.DEEPSLATE_AQUAMARINE_ORE);
        blockWithItem(MtaBlocks.BLOODSTONE_ORE);
        blockWithItem(MtaBlocks.DEEPSLATE_BLOODSTONE_ORE);
        blockWithItem(MtaBlocks.CELESTITE_ORE);
        blockWithItem(MtaBlocks.DEEPSLATE_CELESTITE_ORE);
        blockWithItem(MtaBlocks.CRYOLITE_ORE);
        blockWithItem(MtaBlocks.GARNET_ORE);
        blockWithItem(MtaBlocks.DEEPSLATE_GARNET_ORE);
        blockWithItem(MtaBlocks.MOONSTONE_ORE);
        blockWithItem(MtaBlocks.DEEPSLATE_MOONSTONE_ORE);
        blockWithItem(MtaBlocks.COBBLED_DIRT);
        blockWithItem(MtaBlocks.STONE_TILES);
        makeStoneSet(MtaBlocks.STONE_TILES, MtaBlocks.STONE_TILES_STAIRS, MtaBlocks.STONE_TILES_WALL, MtaBlocks.STONE_TILES_SLAB);
        blockWithItem(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES);
        makeStoneSet(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES, MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_STAIRS, MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_WALL, MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_SLAB);
        blockWithItem(MtaBlocks.DIRTY_STONE_TILES);
        makeStoneSet(MtaBlocks.DIRTY_STONE_TILES, MtaBlocks.DIRTY_STONE_TILES_STAIRS, MtaBlocks.DIRTY_STONE_TILES_WALL, MtaBlocks.DIRTY_STONE_TILES_SLAB);
        blockWithItem(MtaBlocks.VERY_DIRTY_STONE_TILES);
        makeStoneSet(MtaBlocks.VERY_DIRTY_STONE_TILES, MtaBlocks.VERY_DIRTY_STONE_TILES_STAIRS, MtaBlocks.VERY_DIRTY_STONE_TILES_WALL, MtaBlocks.VERY_DIRTY_STONE_TILES_SLAB);
        blockItem(MtaBlocks.SAND_PATH);
        blockItem(MtaBlocks.GRASSY_DIRT);
        blockItem(MtaBlocks.PERMAFROST_GRASS);
        blockItem(MtaBlocks.TUNDRA_GRASS);
        blockItem(MtaBlocks.COARSE_DIRT_PATH);

        blockWithItem(MtaBlocks.TERRACOTTA_TILES);
        makeStoneSet(Blocks.TERRACOTTA, MtaBlocks.TERRACOTTA_STAIRS, MtaBlocks.TERRACOTTA_WALL, MtaBlocks.TERRACOTTA_SLAB);
        makeStoneSet(MtaBlocks.TERRACOTTA_TILES, MtaBlocks.TERRACOTTA_TILES_STAIRS, MtaBlocks.TERRACOTTA_TILES_WALL, MtaBlocks.TERRACOTTA_TILES_SLAB);
        blockWithItem(MtaBlocks.WHITE_TERRACOTTA_TILES);
        makeStoneSet(Blocks.WHITE_TERRACOTTA, MtaBlocks.WHITE_TERRACOTTA_STAIRS, MtaBlocks.WHITE_TERRACOTTA_WALL, MtaBlocks.WHITE_TERRACOTTA_SLAB);
        makeStoneSet(MtaBlocks.WHITE_TERRACOTTA_TILES, MtaBlocks.WHITE_TERRACOTTA_TILES_STAIRS, MtaBlocks.WHITE_TERRACOTTA_TILES_WALL, MtaBlocks.WHITE_TERRACOTTA_TILES_SLAB);
        blockWithItem(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES);
        makeStoneSet(Blocks.LIGHT_GRAY_TERRACOTTA, MtaBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS, MtaBlocks.LIGHT_GRAY_TERRACOTTA_WALL, MtaBlocks.LIGHT_GRAY_TERRACOTTA_SLAB);
        makeStoneSet(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES, MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_STAIRS, MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_WALL, MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_SLAB);
        blockWithItem(MtaBlocks.GRAY_TERRACOTTA_TILES);
        makeStoneSet(Blocks.GRAY_TERRACOTTA, MtaBlocks.GRAY_TERRACOTTA_STAIRS, MtaBlocks.GRAY_TERRACOTTA_WALL, MtaBlocks.GRAY_TERRACOTTA_SLAB);
        makeStoneSet(MtaBlocks.GRAY_TERRACOTTA_TILES, MtaBlocks.GRAY_TERRACOTTA_TILES_STAIRS, MtaBlocks.GRAY_TERRACOTTA_TILES_WALL, MtaBlocks.GRAY_TERRACOTTA_TILES_SLAB);
        blockWithItem(MtaBlocks.BLACK_TERRACOTTA_TILES);
        makeStoneSet(Blocks.BLACK_TERRACOTTA, MtaBlocks.BLACK_TERRACOTTA_STAIRS, MtaBlocks.BLACK_TERRACOTTA_WALL, MtaBlocks.BLACK_TERRACOTTA_SLAB);
        makeStoneSet(MtaBlocks.BLACK_TERRACOTTA_TILES, MtaBlocks.BLACK_TERRACOTTA_TILES_STAIRS, MtaBlocks.BLACK_TERRACOTTA_TILES_WALL, MtaBlocks.BLACK_TERRACOTTA_TILES_SLAB);
        blockWithItem(MtaBlocks.BROWN_TERRACOTTA_TILES);
        makeStoneSet(Blocks.BROWN_TERRACOTTA, MtaBlocks.BROWN_TERRACOTTA_STAIRS, MtaBlocks.BROWN_TERRACOTTA_WALL, MtaBlocks.BROWN_TERRACOTTA_SLAB);
        makeStoneSet(MtaBlocks.BROWN_TERRACOTTA_TILES, MtaBlocks.BROWN_TERRACOTTA_TILES_STAIRS, MtaBlocks.BROWN_TERRACOTTA_TILES_WALL, MtaBlocks.BROWN_TERRACOTTA_TILES_SLAB);
        blockWithItem(MtaBlocks.RED_TERRACOTTA_TILES);
        makeStoneSet(Blocks.RED_TERRACOTTA, MtaBlocks.RED_TERRACOTTA_STAIRS, MtaBlocks.RED_TERRACOTTA_WALL, MtaBlocks.RED_TERRACOTTA_SLAB);
        makeStoneSet(MtaBlocks.RED_TERRACOTTA_TILES, MtaBlocks.RED_TERRACOTTA_TILES_STAIRS, MtaBlocks.RED_TERRACOTTA_TILES_WALL, MtaBlocks.RED_TERRACOTTA_TILES_SLAB);
        blockWithItem(MtaBlocks.ORANGE_TERRACOTTA_TILES);
        makeStoneSet(Blocks.ORANGE_TERRACOTTA, MtaBlocks.ORANGE_TERRACOTTA_STAIRS, MtaBlocks.ORANGE_TERRACOTTA_WALL, MtaBlocks.ORANGE_TERRACOTTA_SLAB);
        makeStoneSet(MtaBlocks.ORANGE_TERRACOTTA_TILES, MtaBlocks.ORANGE_TERRACOTTA_TILES_STAIRS, MtaBlocks.ORANGE_TERRACOTTA_TILES_WALL, MtaBlocks.ORANGE_TERRACOTTA_TILES_SLAB);
        blockWithItem(MtaBlocks.YELLOW_TERRACOTTA_TILES);
        makeStoneSet(Blocks.YELLOW_TERRACOTTA, MtaBlocks.YELLOW_TERRACOTTA_STAIRS, MtaBlocks.YELLOW_TERRACOTTA_WALL, MtaBlocks.YELLOW_TERRACOTTA_SLAB);
        makeStoneSet(MtaBlocks.YELLOW_TERRACOTTA_TILES, MtaBlocks.YELLOW_TERRACOTTA_TILES_STAIRS, MtaBlocks.YELLOW_TERRACOTTA_TILES_WALL, MtaBlocks.YELLOW_TERRACOTTA_TILES_SLAB);
        blockWithItem(MtaBlocks.LIME_TERRACOTTA_TILES);
        makeStoneSet(Blocks.LIME_TERRACOTTA, MtaBlocks.LIME_TERRACOTTA_STAIRS, MtaBlocks.LIME_TERRACOTTA_WALL, MtaBlocks.LIME_TERRACOTTA_SLAB);
        makeStoneSet(MtaBlocks.LIME_TERRACOTTA_TILES, MtaBlocks.LIME_TERRACOTTA_TILES_STAIRS, MtaBlocks.LIME_TERRACOTTA_TILES_WALL, MtaBlocks.LIME_TERRACOTTA_TILES_SLAB);
        blockWithItem(MtaBlocks.GREEN_TERRACOTTA_TILES);
        makeStoneSet(Blocks.GREEN_TERRACOTTA, MtaBlocks.GREEN_TERRACOTTA_STAIRS, MtaBlocks.GREEN_TERRACOTTA_WALL, MtaBlocks.GREEN_TERRACOTTA_SLAB);
        makeStoneSet(MtaBlocks.GREEN_TERRACOTTA_TILES, MtaBlocks.GREEN_TERRACOTTA_TILES_STAIRS, MtaBlocks.GREEN_TERRACOTTA_TILES_WALL, MtaBlocks.GREEN_TERRACOTTA_TILES_SLAB);
        blockWithItem(MtaBlocks.CYAN_TERRACOTTA_TILES);
        makeStoneSet(Blocks.CYAN_TERRACOTTA, MtaBlocks.CYAN_TERRACOTTA_STAIRS, MtaBlocks.CYAN_TERRACOTTA_WALL, MtaBlocks.CYAN_TERRACOTTA_SLAB);
        makeStoneSet(MtaBlocks.CYAN_TERRACOTTA_TILES, MtaBlocks.CYAN_TERRACOTTA_TILES_STAIRS, MtaBlocks.CYAN_TERRACOTTA_TILES_WALL, MtaBlocks.CYAN_TERRACOTTA_TILES_SLAB);
        blockWithItem(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES);
        makeStoneSet(Blocks.LIGHT_BLUE_TERRACOTTA, MtaBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS, MtaBlocks.LIGHT_BLUE_TERRACOTTA_WALL, MtaBlocks.LIGHT_BLUE_TERRACOTTA_SLAB);
        makeStoneSet(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES, MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_STAIRS, MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_WALL, MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_SLAB);
        blockWithItem(MtaBlocks.BLUE_TERRACOTTA_TILES);
        makeStoneSet(Blocks.BLUE_TERRACOTTA, MtaBlocks.BLUE_TERRACOTTA_STAIRS, MtaBlocks.BLUE_TERRACOTTA_WALL, MtaBlocks.BLUE_TERRACOTTA_SLAB);
        makeStoneSet(MtaBlocks.BLUE_TERRACOTTA_TILES, MtaBlocks.BLUE_TERRACOTTA_TILES_STAIRS, MtaBlocks.BLUE_TERRACOTTA_TILES_WALL, MtaBlocks.BLUE_TERRACOTTA_TILES_SLAB);
        blockWithItem(MtaBlocks.PURPLE_TERRACOTTA_TILES);
        makeStoneSet(Blocks.PURPLE_TERRACOTTA, MtaBlocks.PURPLE_TERRACOTTA_STAIRS, MtaBlocks.PURPLE_TERRACOTTA_WALL, MtaBlocks.PURPLE_TERRACOTTA_SLAB);
        makeStoneSet(MtaBlocks.PURPLE_TERRACOTTA_TILES, MtaBlocks.PURPLE_TERRACOTTA_TILES_STAIRS, MtaBlocks.PURPLE_TERRACOTTA_TILES_WALL, MtaBlocks.PURPLE_TERRACOTTA_TILES_SLAB);
        blockWithItem(MtaBlocks.MAGENTA_TERRACOTTA_TILES);
        makeStoneSet(Blocks.MAGENTA_TERRACOTTA, MtaBlocks.MAGENTA_TERRACOTTA_STAIRS, MtaBlocks.MAGENTA_TERRACOTTA_WALL, MtaBlocks.MAGENTA_TERRACOTTA_SLAB);
        makeStoneSet(MtaBlocks.MAGENTA_TERRACOTTA_TILES, MtaBlocks.MAGENTA_TERRACOTTA_TILES_STAIRS, MtaBlocks.MAGENTA_TERRACOTTA_TILES_WALL, MtaBlocks.MAGENTA_TERRACOTTA_TILES_SLAB);
        blockWithItem(MtaBlocks.PINK_TERRACOTTA_TILES);
        makeStoneSet(Blocks.PINK_TERRACOTTA, MtaBlocks.PINK_TERRACOTTA_STAIRS, MtaBlocks.PINK_TERRACOTTA_WALL, MtaBlocks.PINK_TERRACOTTA_SLAB);
        makeStoneSet(MtaBlocks.PINK_TERRACOTTA_TILES, MtaBlocks.PINK_TERRACOTTA_TILES_STAIRS, MtaBlocks.PINK_TERRACOTTA_TILES_WALL, MtaBlocks.PINK_TERRACOTTA_TILES_SLAB);


        makeStoneSet(Blocks.WHITE_CONCRETE, MtaBlocks.WHITE_CONCRETE_STAIRS, MtaBlocks.WHITE_CONCRETE_WALL, MtaBlocks.WHITE_CONCRETE_SLAB);
        makeStoneSet(Blocks.LIGHT_GRAY_CONCRETE, MtaBlocks.LIGHT_GRAY_CONCRETE_STAIRS, MtaBlocks.LIGHT_GRAY_CONCRETE_WALL, MtaBlocks.LIGHT_GRAY_CONCRETE_SLAB);
        makeStoneSet(Blocks.GRAY_CONCRETE, MtaBlocks.GRAY_CONCRETE_STAIRS, MtaBlocks.GRAY_CONCRETE_WALL, MtaBlocks.GRAY_CONCRETE_SLAB);
        makeStoneSet(Blocks.BLACK_CONCRETE, MtaBlocks.BLACK_CONCRETE_STAIRS, MtaBlocks.BLACK_CONCRETE_WALL, MtaBlocks.BLACK_CONCRETE_SLAB);
        makeStoneSet(Blocks.BROWN_CONCRETE, MtaBlocks.BROWN_CONCRETE_STAIRS, MtaBlocks.BROWN_CONCRETE_WALL, MtaBlocks.BROWN_CONCRETE_SLAB);
        makeStoneSet(Blocks.RED_CONCRETE, MtaBlocks.RED_CONCRETE_STAIRS, MtaBlocks.RED_CONCRETE_WALL, MtaBlocks.RED_CONCRETE_SLAB);
        makeStoneSet(Blocks.ORANGE_CONCRETE, MtaBlocks.ORANGE_CONCRETE_STAIRS, MtaBlocks.ORANGE_CONCRETE_WALL, MtaBlocks.ORANGE_CONCRETE_SLAB);
        makeStoneSet(Blocks.YELLOW_CONCRETE, MtaBlocks.YELLOW_CONCRETE_STAIRS, MtaBlocks.YELLOW_CONCRETE_WALL, MtaBlocks.YELLOW_CONCRETE_SLAB);
        makeStoneSet(Blocks.LIME_CONCRETE, MtaBlocks.LIME_CONCRETE_STAIRS, MtaBlocks.LIME_CONCRETE_WALL, MtaBlocks.LIME_CONCRETE_SLAB);
        makeStoneSet(Blocks.GREEN_CONCRETE, MtaBlocks.GREEN_CONCRETE_STAIRS, MtaBlocks.GREEN_CONCRETE_WALL, MtaBlocks.GREEN_CONCRETE_SLAB);
        makeStoneSet(Blocks.CYAN_CONCRETE, MtaBlocks.CYAN_CONCRETE_STAIRS, MtaBlocks.CYAN_CONCRETE_WALL, MtaBlocks.CYAN_CONCRETE_SLAB);
        makeStoneSet(Blocks.LIGHT_BLUE_CONCRETE, MtaBlocks.LIGHT_BLUE_CONCRETE_STAIRS, MtaBlocks.LIGHT_BLUE_CONCRETE_WALL, MtaBlocks.LIGHT_BLUE_CONCRETE_SLAB);
        makeStoneSet(Blocks.BLUE_CONCRETE, MtaBlocks.BLUE_CONCRETE_STAIRS, MtaBlocks.BLUE_CONCRETE_WALL, MtaBlocks.BLUE_CONCRETE_SLAB);
        makeStoneSet(Blocks.PURPLE_CONCRETE, MtaBlocks.PURPLE_CONCRETE_STAIRS, MtaBlocks.PURPLE_CONCRETE_WALL, MtaBlocks.PURPLE_CONCRETE_SLAB);
        makeStoneSet(Blocks.MAGENTA_CONCRETE, MtaBlocks.MAGENTA_CONCRETE_STAIRS, MtaBlocks.MAGENTA_CONCRETE_WALL, MtaBlocks.MAGENTA_CONCRETE_SLAB);
        makeStoneSet(Blocks.PINK_CONCRETE, MtaBlocks.PINK_CONCRETE_STAIRS, MtaBlocks.PINK_CONCRETE_WALL, MtaBlocks.PINK_CONCRETE_SLAB);



        makeCrop((MtaCrops) MtaBlocks.ONION_CROP.get(), "onion_stage", "onion_stage");
        makeCrop((MtaCrops) MtaBlocks.TOMATO_CROP.get(), "tomato_stage", "tomato_stage");
        makeCrop((MtaCrops) MtaBlocks.BELL_PEPPER_CROP.get(), "bell_pepper_stage", "bell_pepper_stage");
        makeCrop((MtaCrops) MtaBlocks.CHILI_PEPPER_CROP.get(), "chili_stage", "chili_stage");


    }

    private void blockWithItem(DeferredBlock<? extends Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));

    }


    private <T extends Block> void makeStoneSet(DeferredBlock<T> texture, DeferredBlock<T> stairs, DeferredBlock<T> wall, DeferredBlock<T> slab) {
        makeStairs(stairs, texture);
        makeSlab(slab, texture, texture);
        makeWall(wall, texture);
    }

    private <T extends Block> void makeStoneSet(Block texture, DeferredBlock<T> stairs, DeferredBlock<T> wall, DeferredBlock<T> slab) {
        makeStairs(stairs, texture);
        makeSlab(slab, texture, texture);
        makeWall(wall, texture);
    }

    private <T extends Block> void makeStairs(DeferredBlock<T> deferredBlock, DeferredBlock<T> texture) {
        stairsBlock(((StairBlock) deferredBlock.get()), blockTexture(texture.get()));
        simpleBlockItem(deferredBlock.get(), models().stairs(name(deferredBlock.get()), blockTexture(texture.get()), blockTexture(texture.get()), blockTexture(texture.get())));

    }

    private <T extends Block> void makeStairs(DeferredBlock<T> deferredBlock, Block texture) {
        stairsBlock(((StairBlock) deferredBlock.get()), blockTexture(texture));
        simpleBlockItem(deferredBlock.get(), models().stairs(name(deferredBlock.get()), blockTexture(texture), blockTexture(texture), blockTexture(texture)));

    }

    private <T extends Block> void makeSlab(DeferredBlock<T> deferredBlock, DeferredBlock<T> doubleSlab, DeferredBlock<T> halfSlab) {
        slabBlock(((SlabBlock) deferredBlock.get()), blockTexture(doubleSlab.get()), blockTexture(halfSlab.get()));
        simpleBlockItem(deferredBlock.get(), models().slab(name(deferredBlock.get()), blockTexture(doubleSlab.get()), blockTexture(halfSlab.get()), blockTexture(halfSlab.get())));

    }

    private <T extends Block> void makeSlab(DeferredBlock<T> deferredBlock, Block doubleSlab, Block halfSlab) {
        slabBlock(((SlabBlock) deferredBlock.get()), blockTexture(doubleSlab), blockTexture(halfSlab));
        simpleBlockItem(deferredBlock.get(), models().slab(name(deferredBlock.get()), blockTexture(doubleSlab), blockTexture(halfSlab), blockTexture(halfSlab)));

    }

    private <T extends Block> void makeWall(DeferredBlock<T> deferredBlock, DeferredBlock<T> texture) {
        wallBlock(((WallBlock) deferredBlock.get()), blockTexture(texture.get()));
        simpleBlockItem(deferredBlock.get(), models().wallInventory(name(deferredBlock.get()) + "_inventory", blockTexture(texture.get())));

    }

    private <T extends Block> void makeWall(DeferredBlock<T> deferredBlock, Block texture) {
        wallBlock(((WallBlock) deferredBlock.get()), blockTexture(texture));
        simpleBlockItem(deferredBlock.get(), models().wallInventory(name(deferredBlock.get()) + "_inventory", blockTexture(texture)));

    }

    private <T extends Block> void makeFence(DeferredBlock<? extends FenceBlock> deferredBlock, DeferredBlock<T> texture) {
        fenceBlock(((FenceBlock) deferredBlock.get()), blockTexture(texture.get()));

    }

    private <T extends Block> void blockItem(DeferredBlock<T> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(MODID, name(deferredBlock.get()))));

    }

    private <T extends Block> void blockItem(DeferredBlock<T> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("morethanadventure:block/" + deferredBlock.getId().getPath() + appendix));
    }

    private void leavesBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(deferredBlock.get())).renderType(("cutout")));
    }

    private void saplingBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlock(deferredBlock.get(), models().cross(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), blockTexture(deferredBlock.get())).renderType("cutout"));
    }

    public <T extends Block> void plantBlock(T block, T potBLock, ResourceLocation texture) {
        ModelFile sign = models().cross(name(block), texture);
        models().getBuilder(key(potBLock).getPath()).texture("plant", texture).parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/flower_pot_cross")));
        cross(block, sign);
    }

    public <T extends Block> void cross(T block, ResourceLocation texture) {
        ModelFile blockModel = models().cross(name(block), texture);
        cross(block, blockModel);

    }

    private void createDoublePlant(Block block) {
        ResourceLocation topTexture = blockTexture(block).withSuffix("_top");
        ResourceLocation bottomTexture = blockTexture(block).withSuffix("_bottom");
        ModelFile modelTop = models().cross(key(block).getPath() + "_top", topTexture);
        ModelFile modelBottom = models().cross(key(block).getPath() + "_bottom", bottomTexture);
        VariantBlockStateBuilder builder = getVariantBuilder(block);

        itemModels().getBuilder(key(block).getPath()).texture("layer0",topTexture).parent(new ModelFile.UncheckedModelFile("item/generated"));

        VariantBlockStateBuilder.PartialBlockstate partialState = builder.partialState();

        builder.addModels(partialState.with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER),
                partialState.modelForState().modelFile(modelTop).build());

        builder.addModels(partialState.with(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER),
                partialState.modelForState().modelFile(modelBottom).build());


    }


    public <T extends Block> void cross(T block, ModelFile blockModel) {
        simpleBlock(block, blockModel);
    }


    private <T extends Block> String name(T block) {
        return key(block).getPath();
    }


    private <T extends Block> ResourceLocation key(T block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }


    public <T extends Block> void verticalBlock(T block, ResourceLocation side_texture, ResourceLocation bottom_texture) {
        ModelFile blockModel = models().cube(name(block), bottom_texture, blockTexture(block), side_texture, side_texture, side_texture, side_texture)
                .texture("particle", blockTexture(block));
        ;
        simpleBlock(block, blockModel);
        simpleBlockItem(block, blockModel);
    }

    public <T extends Block> void verticalBlock(T block, T side_texture, T bottom_texture) {
        ModelFile blockModel = models().cube(name(block),
                        blockTexture(bottom_texture),
                        blockTexture(block),
                        blockTexture(side_texture),
                        blockTexture(side_texture),
                        blockTexture(side_texture),
                        blockTexture(side_texture))
                .texture("particle", blockTexture(block));
        simpleBlock(block, blockModel);
        simpleBlockItem(block, blockModel);
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> statesForCrop(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] statesForCrop(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((MtaCrops) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(MODID, "block/" + textureName +
                        state.getValue(((MtaCrops) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void createVineFlowerBlock(Block block, String name) {

        ConfiguredModel model = new ConfiguredModel(models()
                .withExistingParent(name, ResourceLocation.fromNamespaceAndPath(MODID, "block/vine_flower"))
                .texture("vine", blockTexture(block) + "_vines")
                .texture("flowerbed", blockTexture(block) + "_flowerbed")
                .texture("flower2", blockTexture(block) + "_side_flowers")
                .texture("flower", blockTexture(block))
                .renderType("cutout")
        );



        MultiPartBlockStateBuilder builder = getMultipartBuilder(block);

        PipeBlock.PROPERTY_BY_DIRECTION.entrySet().forEach(entry -> {
                    Direction direction = entry.getKey();
            if (direction.getAxis().isHorizontal()) {
                builder.part().modelFile(model.model).rotationY((((int) direction.toYRot()) + 180) % 360).uvLock(true).addModel()
                        .condition(entry.getValue(), true);
            } else if (direction.equals(Direction.UP)) {
                builder.part().modelFile(model.model).rotationX(270).uvLock(true).addModel()
                        .condition(entry.getValue(), true);
            } else if (direction.equals(Direction.DOWN)) {
                builder.part().modelFile(model.model).rotationX(90).uvLock(true).addModel()
                        .condition(entry.getValue(), true);
            }

                }

        );

    }
    private void createWallShroomBlock(Block block, String name) {

        ConfiguredModel model = new ConfiguredModel(models()
                .withExistingParent(name, ResourceLocation.fromNamespaceAndPath(MODID, "block/template_wall_mushroom"))
                .texture("layer0", blockTexture(block) + "_0")
                .texture("layer1", blockTexture(block) + "_1")
                .texture("layer2", blockTexture(block) + "_2")
                .texture("layer3", blockTexture(block) + "_3")
                .texture("layer4", blockTexture(block) + "_4")
                .texture("layer5", blockTexture(block) + "_5")
                .renderType("cutout")
        );



        MultiPartBlockStateBuilder builder = getMultipartBuilder(block);

        PipeBlock.PROPERTY_BY_DIRECTION.entrySet().forEach(entry -> {
                    Direction direction = entry.getKey();
            if (direction.getAxis().isHorizontal()) {
                builder.part().modelFile(model.model).rotationY((((int) direction.toYRot()) + 180) % 360).uvLock(true).addModel()
                        .condition(entry.getValue(), true);
            } else if (direction.equals(Direction.UP)) {
                builder.part().modelFile(model.model).rotationX(270).uvLock(true).addModel()
                        .condition(entry.getValue(), true);
            } else if (direction.equals(Direction.DOWN)) {
                builder.part().modelFile(model.model).rotationX(90).uvLock(true).addModel()
                        .condition(entry.getValue(), true);
            }

                }

        );

    }


}
