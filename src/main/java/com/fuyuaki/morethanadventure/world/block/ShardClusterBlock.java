package com.fuyuaki.morethanadventure.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class ShardClusterBlock extends DropExperienceBlock implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final EnumProperty<Direction> FACING = BlockStateProperties.FACING;

    protected final VoxelShape northAabb = Block.box(3, 3, 4, 13, 13, 16);
    protected final VoxelShape southAabb = Block.box(3, 3, 0, 13, 13, 12);
    protected final VoxelShape eastAabb = Block.box(0, 3, 3, 12, 13, 13);
    protected final VoxelShape westAabb = Block.box(4, 3, 3, 16, 13, 13);
    protected final VoxelShape upAabb = Block.box(3, 0, 3, 13, 12, 13);
    protected final VoxelShape downAabb = Block.box(3, 4, 3, 13, 16, 13);

    public ShardClusterBlock(Properties p_151999_) {
        super(UniformInt.of(1, 2), p_151999_);

    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Direction direction = pState.getValue(FACING);
        switch (direction) {
            case NORTH:
                return this.northAabb;
            case SOUTH:
                return this.southAabb;
            case EAST:
                return this.eastAabb;
            case WEST:
                return this.westAabb;
            case DOWN:
                return this.downAabb;
            case UP:
            default:
                return this.upAabb;
        }
    }

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        Direction direction = pState.getValue(FACING);
        BlockPos blockpos = pPos.relative(direction.getOpposite());
        return pLevel.getBlockState(blockpos).isFaceSturdy(pLevel, blockpos, direction);
    }
    @Override
    protected BlockState updateShape(
            BlockState p_152036_,
            LevelReader p_374202_,
            ScheduledTickAccess p_374490_,
            BlockPos p_152040_,
            Direction p_152037_,
            BlockPos p_152041_,
            BlockState p_152038_,
            RandomSource p_374353_
    ) {
        if (p_152036_.getValue(WATERLOGGED)) {
            p_374490_.scheduleTick(p_152040_, Fluids.WATER, Fluids.WATER.getTickDelay(p_374202_));
        }

        return p_152037_ == p_152036_.getValue(FACING).getOpposite() && !p_152036_.canSurvive(p_374202_, p_152040_)
                ? Blocks.AIR.defaultBlockState()
                : super.updateShape(p_152036_, p_374202_, p_374490_, p_152040_, p_152037_, p_152041_, p_152038_, p_374353_);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        LevelAccessor levelaccessor = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        return this.defaultBlockState()
                .setValue(WATERLOGGED, Boolean.valueOf(levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER))
                .setValue(FACING, pContext.getClickedFace());
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
        return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
    }

    @Override
    protected BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));

    }

    @Override
    protected FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(WATERLOGGED, FACING);
    }


}
