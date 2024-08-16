package com.fuyuaki.morethanadventure.datagen.generators;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.fuyuaki.morethanadventure.world.block.MtaCrops;
import com.fuyuaki.morethanadventure.world.block.TomatoCropBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
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
        logBlock(((RotatedPillarBlock) MtaBlocks.PALM_LOG.get()));
        //logBlock(((RotatedPillarBlock) MtaBlocks.STRIPPED_PALM_LOG.get()));
        axisBlock(((RotatedPillarBlock) MtaBlocks.PALM_WOOD.get()), blockTexture(MtaBlocks.PALM_LOG.get()), blockTexture(MtaBlocks.PALM_LOG.get()));
        //axisBlock(((RotatedPillarBlock) MtaBlocks.STRIPPED_PALM_WOOD.get()), blockTexture(MtaBlocks.STRIPPED_PALM_LOG.get()), blockTexture(MtaBlocks.STRIPPED_PALM_LOG.get()));
        blockItem(MtaBlocks.PALM_LOG);
        //blockItem(MtaBlocks.STRIPPED_PALM_LOG);
        blockItem(MtaBlocks.PALM_WOOD);
        //blockItem(MtaBlocks.STRIPPED_PALM_WOOD);
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

        verticalBlock(MtaBlocks.STONE_GEYSER.get(), Blocks.STONE,Blocks.STONE);
        verticalBlock(MtaBlocks.TERRACOTTA_GEYSER.get(), Blocks.TERRACOTTA,Blocks.TERRACOTTA);
        verticalBlock(MtaBlocks.NETHERRACK_GEYSER.get(), Blocks.NETHERRACK,Blocks.NETHERRACK);
        verticalBlock(MtaBlocks.BASALT_GEYSER.get(), ResourceLocation.withDefaultNamespace("block/basalt_top"),ResourceLocation.withDefaultNamespace("block/basalt_side"));
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

        makeCrop((MtaCrops) MtaBlocks.ONION_CROP.get(), "onion_stage", "onion_stage");
        makeCrop((MtaCrops) MtaBlocks.TOMATO_CROP.get(), "tomato_stage", "tomato_stage");
        makeCrop((MtaCrops) MtaBlocks.BELL_PEPPER_CROP.get(), "bell_pepper_stage", "bell_pepper_stage");
        makeCrop((MtaCrops) MtaBlocks.CHILI_PEPPER_CROP.get(), "chili_stage", "chili_stage");



    }

    private void blockWithItem(DeferredBlock<? extends Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));

    }


    private <T extends Block>void makeStoneSet(DeferredBlock<T> texture,DeferredBlock<T> sideTexture, DeferredBlock<T> stairs, DeferredBlock<T> wall, DeferredBlock<T> slab){
        makeStairs(stairs,texture);
        makeSlab(slab,sideTexture,texture);
        makeWall(wall,texture);
    }

    private <T extends Block>void makeStairs(DeferredBlock<T> deferredBlock,DeferredBlock<T> texture){
        stairsBlock(((StairBlock) deferredBlock.get()), blockTexture(texture.get()));
        simpleBlockItem(deferredBlock.get(), models().stairs(name(deferredBlock.get()), blockTexture(texture.get()), blockTexture(texture.get()), blockTexture(texture.get())));

    }

    private <T extends Block>void makeSlab(DeferredBlock<T> deferredBlock, DeferredBlock<T> doubleSlab, DeferredBlock<T> halfSlab){
        slabBlock(((SlabBlock) deferredBlock.get()), blockTexture(doubleSlab.get()), blockTexture(halfSlab.get()));
        simpleBlockItem(deferredBlock.get(), models().slab(name(deferredBlock.get()), blockTexture(doubleSlab.get()), blockTexture(halfSlab.get()), blockTexture(halfSlab.get())));

    }
    private <T extends Block>void makeWall(DeferredBlock<T> deferredBlock, DeferredBlock<T> texture){
        wallBlock(((WallBlock) deferredBlock.get()), blockTexture(texture.get()));
        simpleBlockItem(deferredBlock.get(), models().wallInventory(name(deferredBlock.get()) + "_inventory", blockTexture(texture.get())));

    }
    private <T extends Block>void makeFence(DeferredBlock<? extends FenceBlock> deferredBlock, DeferredBlock<T> texture){
        fenceBlock(((FenceBlock) deferredBlock.get()), blockTexture(texture.get()));

    }

    private<T extends Block> void blockItem(DeferredBlock<T> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(MODID,name(deferredBlock.get()))));

    }

    private<T extends Block> void blockItem(DeferredBlock<T> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("mccourse:block/" + deferredBlock.getId().getPath() + appendix));
    }

private void leavesBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(deferredBlock.get())).renderType(("cutout")));
}

private void saplingBlock(DeferredBlock<Block> deferredBlock) {
        simpleBlock(deferredBlock.get(), models().cross(BuiltInRegistries.BLOCK.getKey(deferredBlock.get()).getPath(), blockTexture(deferredBlock.get())).renderType("cutout"));
}

    public <T extends Block>void plantBlock(T block,T potBLock, ResourceLocation texture) {
        ModelFile sign = models().cross(name(block), texture);
        models().getBuilder(key(potBLock).getPath()).texture("plant",texture).parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/flower_pot_cross")));
        cross(block, sign);
    }

    public <T extends Block>void cross(T block, ResourceLocation texture) {
        ModelFile blockModel = models().cross(name(block), texture);
        cross(block, blockModel);

    }

    public <T extends Block>void cross(T block, ModelFile blockModel) {
        simpleBlock(block, blockModel);
    }



    private <T extends Block>String name(T block) {
        return key(block).getPath();
    }


    private <T extends Block>ResourceLocation key(T block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }


    public <T extends Block>void verticalBlock(T block,ResourceLocation side_texture,ResourceLocation bottom_texture) {
        ModelFile blockModel = models().cube(name(block),bottom_texture,blockTexture(block),side_texture,side_texture,side_texture,side_texture)
                .texture("particle",blockTexture(block));;
        simpleBlock(block, blockModel);
        simpleBlockItem(block,blockModel);
    }
    public <T extends Block>void verticalBlock(T block,T side_texture,T bottom_texture) {
        ModelFile blockModel = models().cube(name(block),
                blockTexture(bottom_texture),
                blockTexture(block),
                blockTexture(side_texture),
                blockTexture(side_texture),
                blockTexture(side_texture),
                blockTexture(side_texture))
                .texture("particle",blockTexture(block));
        simpleBlock(block, blockModel);
        simpleBlockItem(block,blockModel);
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((MtaCrops) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(MODID, "block/" + textureName +
                        state.getValue(((MtaCrops) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }



}
