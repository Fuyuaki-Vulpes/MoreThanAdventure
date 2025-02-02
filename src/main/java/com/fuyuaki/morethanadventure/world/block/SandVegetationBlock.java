package com.fuyuaki.morethanadventure.world.block;

import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class SandVegetationBlock extends BushBlock {
    public static final MapCodec<SandVegetationBlock> CODEC = simpleCodec(SandVegetationBlock::new);
    protected static final float AABB_OFFSET = 6.0F;
    protected static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);

    public SandVegetationBlock(Properties p_57318_) {
        super(p_57318_);
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(MtaTags.Blocks.SAND_VEGETATION_MAY_PLACE_ON);
    }

}
