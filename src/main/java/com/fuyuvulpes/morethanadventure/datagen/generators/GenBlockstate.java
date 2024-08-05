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

    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));

    }


    private void makeStoneSet(DeferredBlock<Block> texture,DeferredBlock<Block> sideTexture, DeferredBlock<Block> stairs, DeferredBlock<Block> wall, DeferredBlock<Block> slab){
        makeStairs(stairs,texture);
        makeSlab(slab,sideTexture,texture);
        makeWall(wall,texture);
    }

    private void makeStairs(DeferredBlock<Block> deferredBlock,DeferredBlock<Block> texture){
        stairsBlock(((StairBlock) deferredBlock.get()), blockTexture(texture.get()));
        simpleBlockItem(deferredBlock.get(), models().stairs(name(deferredBlock.get()), blockTexture(texture.get()), blockTexture(texture.get()), blockTexture(texture.get())));

    }

    private void makeSlab(DeferredBlock<Block> deferredBlock, DeferredBlock<Block> doubleSlab, DeferredBlock<Block> halfSlab){
        slabBlock(((SlabBlock) deferredBlock.get()), blockTexture(doubleSlab.get()), blockTexture(halfSlab.get()));
        simpleBlockItem(deferredBlock.get(), models().slab(name(deferredBlock.get()), blockTexture(doubleSlab.get()), blockTexture(halfSlab.get()), blockTexture(halfSlab.get())));

    }
    private void makeWall(DeferredBlock<Block> deferredBlock, DeferredBlock<Block> texture){
        wallBlock(((WallBlock) deferredBlock.get()), blockTexture(texture.get()));
        simpleBlockItem(deferredBlock.get(), models().wallInventory(name(deferredBlock.get()) + "_inventory", blockTexture(texture.get())));

    }
    private void makeFence(DeferredBlock<FenceBlock> deferredBlock, DeferredBlock<Block> texture){
        fenceBlock(((FenceBlock) deferredBlock.get()), blockTexture(texture.get()));

    }

    private<T extends Block> void blockItem(DeferredBlock<T> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), models().getExistingFile(ResourceLocation.fromNamespaceAndPath(MODID,name(deferredBlock.get()))));

    }


    public void plantBlock(Block block,Block potBLock, ResourceLocation texture) {
        ModelFile sign = models().cross(name(block), texture);
        models().getBuilder(key(potBLock).getPath()).texture("plant",texture).parent(models().getExistingFile(ResourceLocation.withDefaultNamespace("block/flower_pot_cross")));
        cross(block, sign);
    }

    public void cross(Block block, ResourceLocation texture) {
        ModelFile blockModel = models().cross(name(block), texture);
        cross(block, blockModel);

    }

    public void cross(Block block, ModelFile blockModel) {
        simpleBlock(block, blockModel);
    }



    private String name(Block block) {
        return key(block).getPath();
    }


    private ResourceLocation key(Block block) {
        return BuiltInRegistries.BLOCK.getKey(block);
    }


    public void verticalBlock(Block block,ResourceLocation side_texture,ResourceLocation bottom_texture) {
        ModelFile blockModel = models().cube(name(block),bottom_texture,blockTexture(block),side_texture,side_texture,side_texture,side_texture)
                .texture("particle",blockTexture(block));;
        simpleBlock(block, blockModel);
        simpleBlockItem(block,blockModel);
    }
    public void verticalBlock(Block block,Block side_texture,Block bottom_texture) {
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
