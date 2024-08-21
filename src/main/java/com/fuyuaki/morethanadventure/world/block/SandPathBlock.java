package com.fuyuaki.morethanadventure.world.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class SandPathBlock extends ColoredFallingBlock {
    protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 15.0, 16.0);

    public SandPathBlock(Properties p_49795_) {
        super(new ColorRGBA(14406560),p_49795_);
    }

    @Override
    protected boolean useShapeForLightOcclusion(BlockState p_153159_) {
        return true;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_153131_) {
        return !this.defaultBlockState().canSurvive(p_153131_.getLevel(), p_153131_.getClickedPos())
                ? Block.pushEntitiesUp(this.defaultBlockState(), Blocks.SAND.defaultBlockState(), p_153131_.getLevel(), p_153131_.getClickedPos())
                : super.getStateForPlacement(p_153131_);
    }


    @Override
    protected BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pPos, BlockPos pNeighborPos) {

        if (pDirection == Direction.UP && !pState.canSurvive(pLevel, pPos)) {
            pLevel.scheduleTick(pPos, this, 1);
        }

        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pPos, pNeighborPos);
    }

    @Override
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        turnToSand(null, pState, pLevel, pPos);
        super.tick(pState,pLevel,pPos,pRandom);
    }

    public static void turnToSand(@Nullable Entity pEntity, BlockState pState, Level pLevel, BlockPos pPos) {
        BlockState blockstate = pushEntitiesUp(pState, Blocks.SAND.defaultBlockState(), pLevel, pPos);
        pLevel.setBlockAndUpdate(pPos, blockstate);
        pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pEntity, blockstate));
    }

    @Override
    protected boolean canSurvive(BlockState p_153148_, LevelReader p_153149_, BlockPos p_153150_) {
        BlockState blockstate = p_153149_.getBlockState(p_153150_.above());
        return !blockstate.isSolid() || blockstate.getBlock() instanceof FenceGateBlock;
    }

    @Override
    protected VoxelShape getShape(BlockState p_153143_, BlockGetter p_153144_, BlockPos p_153145_, CollisionContext p_153146_) {
        return SHAPE;
    }

    @Override
    protected boolean isPathfindable(BlockState p_153138_, PathComputationType p_153141_) {
        return false;
    }
}
