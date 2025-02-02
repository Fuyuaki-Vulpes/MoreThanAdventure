package com.fuyuaki.morethanadventure.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WildCropBlock extends CropBlock {
    public WildCropBlock(Properties p_52247_) {
        super(p_52247_);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(BlockTags.DIRT);
    }


    @Override
    protected ItemStack getCloneItemStack(LevelReader p_304482_, BlockPos p_52255_, BlockState p_52256_, boolean p_387989_) {
        return new ItemStack(this.asItem());
    }


}
