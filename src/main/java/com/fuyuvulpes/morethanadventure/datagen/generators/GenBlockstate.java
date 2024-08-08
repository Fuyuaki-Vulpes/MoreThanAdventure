package com.fuyuvulpes.morethanadventure.datagen.generators;

import com.fuyuvulpes.morethanadventure.core.registry.MtaBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.model.ModelTemplates;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class GenBlockstate extends BlockStateProvider {
    public GenBlockstate(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
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



}
