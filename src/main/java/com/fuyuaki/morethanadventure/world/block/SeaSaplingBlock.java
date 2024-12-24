package com.fuyuaki.morethanadventure.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

import javax.annotation.Nullable;

public class SeaSaplingBlock extends SaplingBlock implements SimpleWaterloggedBlock {
    private static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public SeaSaplingBlock(TreeGrower treeGrower, Properties properties) {
        super(treeGrower, properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(STAGE, Integer.valueOf(0))
                .setValue(WATERLOGGED, Boolean.valueOf(false))
        );
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STAGE).add(WATERLOGGED);
    }


    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return super.mayPlaceOn(state, level, pos) || state.is(Blocks.CLAY) || state.is(Blocks.SAND) || state.is(Blocks.GRAVEL) ;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        FluidState fluidstate = context.getLevel().getFluidState(context.getClickedPos());
        boolean flag = fluidstate.getType() == Fluids.WATER;
        return super.getStateForPlacement(context).setValue(WATERLOGGED, Boolean.valueOf(flag));
    }

    @Override
    protected BlockState updateShape(
            BlockState p_221477_,
            LevelReader p_374145_,
            ScheduledTickAccess p_374362_,
            BlockPos p_221481_,
            Direction p_221478_,
            BlockPos p_221482_,
            BlockState p_221479_,
            RandomSource p_374203_) {


        if (p_221477_.getValue(WATERLOGGED)) {
            p_374362_.scheduleTick(p_221481_, Fluids.WATER, Fluids.WATER.getTickDelay(p_374145_));
        }

        return p_221478_ == Direction.UP && !p_221477_.canSurvive(p_374145_, p_221481_)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(p_221477_, p_374145_, p_374362_, p_221481_, p_221478_, p_221482_, p_221479_, p_374203_);
    }



    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }



}
