package com.fuyuaki.morethanadventure.datagen.model;

import com.fuyuaki.morethanadventure.core.registry.MTAFamilies;
import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.fuyuaki.morethanadventure.world.block.MtaCrops;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.blockstates.BlockStateGenerator;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class GenBlockModels extends BlockModelGenerators {

    final Consumer<BlockStateGenerator> blockStateOutput;
    final BiConsumer<ResourceLocation, ModelInstance> modelOutput;

    public GenBlockModels(Consumer<BlockStateGenerator> blockStateOutput, ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
        super(blockStateOutput, itemModelOutput, modelOutput);
        this.blockStateOutput = blockStateOutput;
        this.modelOutput = modelOutput;
    }

    @Override
    public void run() {
        MTAFamilies.getAllFamilies()
                .filter(BlockFamily::shouldGenerateModel)
                .forEach(p_386718_ -> this.family(p_386718_.getBaseBlock()).generateFor(p_386718_));

        this.createDoublePlantWithDefaultItem(MtaBlocks.CATTAIL.get(),PlantType.NOT_TINTED);
        //simpleBlock(MtaBlocks.CORPSE_LILY.get(), models().cross(blockTexture(MtaBlocks.CORPSE_LILY.get()).getPath(), blockTexture(MtaBlocks.CORPSE_LILY.get())).renderType("cutout"));
        //simpleBlock(MtaBlocks.POTTED_CORPSE_LILY.get(), models().singleTexture("potted_corpse_lily", ResourceLocation.parse("flower_pot_cross"), "plant", blockTexture(MtaBlocks.CORPSE_LILY.get())).renderType("cutout"));
        //simpleBlock(MtaBlocks.PITCHER_PLANT.get(), models().cross(blockTexture(MtaBlocks.PITCHER_PLANT.get()).getPath(), blockTexture(MtaBlocks.PITCHER_PLANT.get())).renderType("cutout"));
        //simpleBlock(MtaBlocks.POTTED_PITCHER_PLANT.get(), models().singleTexture("potted_pitcher_plant", ResourceLocation.parse("flower_pot_cross"), "plant", blockTexture(MtaBlocks.PITCHER_PLANT.get())).renderType("cutout"));
        //blockItem(MtaBlocks.VENUS_FLYTRAP);
        this.woodProvider(MtaBlocks.PALM_LOG.get()).logWithHorizontal(MtaBlocks.PALM_LOG.get()).wood(MtaBlocks.PALM_WOOD.get());
        this.woodProvider(MtaBlocks.STRIPPED_PALM_LOG.get()).logWithHorizontal(MtaBlocks.STRIPPED_PALM_LOG.get()).wood(MtaBlocks.STRIPPED_PALM_WOOD.get());

        blockWithItem(MtaBlocks.PERMAFROST_DIRT);

        blockWithItem(MtaBlocks.PERMAFROST_STONE);

        blockWithItem(MtaBlocks.PALM_PLANKS);

        createTintedLeaves(MtaBlocks.PALM_LEAVES.get(), TexturedModel.LEAVES,FoliageColor.FOLIAGE_DEFAULT);
        //MAKE POTTED VERSIONS
        this.createPlantWithDefaultItem(MtaBlocks.PALM_SAPLING.get(),MtaBlocks.PALM_SAPLING.get(),PlantType.NOT_TINTED);
        this.woodProvider(MtaBlocks.SEALOG.get()).logWithHorizontal(MtaBlocks.SEALOG.get()).wood(MtaBlocks.SEAWOOD.get());

        blockItem(MtaBlocks.SEALOG);
        blockItem(MtaBlocks.SEAWOOD);
        blockWithItem(MtaBlocks.SEAWOOD_PLANKS);
        createTintedLeaves(MtaBlocks.SEAWOOD_LEAVES.get(), TexturedModel.LEAVES,FoliageColor.FOLIAGE_EVERGREEN);
        saplingBlock(MtaBlocks.SEAWOOD_SAPLING);


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


        this.createCropBlock(MtaBlocks.ONION_CROP.get(), BlockStateProperties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);
        this.createCropBlock(MtaBlocks.TOMATO_CROP.get(), BlockStateProperties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);
        this.createCropBlock(MtaBlocks.BELL_PEPPER_CROP.get(), BlockStateProperties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);
        this.createCropBlock(MtaBlocks.CHILI_PEPPER_CROP.get(), BlockStateProperties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);

    }


}
