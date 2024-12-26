package com.fuyuaki.morethanadventure.core.datagen.model;

import com.fuyuaki.morethanadventure.core.registry.MTAFamilies;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlocks;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.blockstates.BlockStateGenerator;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

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




        createTintedLeaves(MtaBlocks.PALM_LEAVES.get(), TexturedModel.LEAVES,FoliageColor.FOLIAGE_DEFAULT);
        //MAKE POTTED VERSIONS
        this.createPlantWithDefaultItem(MtaBlocks.PALM_SAPLING.get(),MtaBlocks.PALM_SAPLING.get(),PlantType.NOT_TINTED);
        this.woodProvider(MtaBlocks.SEALOG.get()).logWithHorizontal(MtaBlocks.SEALOG.get()).wood(MtaBlocks.SEAWOOD.get());
//
//        blockItem(MtaBlocks.SEALOG);
//        blockItem(MtaBlocks.SEAWOOD);
//        blockWithItem(MtaBlocks.SEAWOOD_PLANKS);
        createTintedLeaves(MtaBlocks.SEAWOOD_LEAVES.get(), TexturedModel.LEAVES,FoliageColor.FOLIAGE_EVERGREEN);
       /*
        saplingBlock(MtaBlocks.SEAWOOD_SAPLING);
        blockWithItem(MtaBlocks.PERMAFROST_DIRT);

        blockWithItem(MtaBlocks.PERMAFROST_STONE);

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
        blockItem(MtaBlocks.SAND_PATH);
        blockItem(MtaBlocks.GRASSY_DIRT);
        blockItem(MtaBlocks.PERMAFROST_GRASS);
        blockItem(MtaBlocks.TUNDRA_GRASS);
        blockItem(MtaBlocks.COARSE_DIRT_PATH);

*/
        this.createCropBlock(MtaBlocks.ONION_CROP.get(), BlockStateProperties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);
        this.createCropBlock(MtaBlocks.TOMATO_CROP.get(), BlockStateProperties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);
        this.createCropBlock(MtaBlocks.BELL_PEPPER_CROP.get(), BlockStateProperties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);
        this.createCropBlock(MtaBlocks.CHILI_PEPPER_CROP.get(), BlockStateProperties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);

    }


}
