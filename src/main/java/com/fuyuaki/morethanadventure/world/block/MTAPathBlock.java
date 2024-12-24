package com.fuyuaki.morethanadventure.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class MTAPathBlock extends Block {
    protected static final VoxelShape SHAPE = Block.box(0.0, 0.0, 0.0, 16.0, 15.0, 16.0);
    protected final Block replacementBlock;

    public MTAPathBlock(Properties p_49795_, Block block) {
        super(p_49795_);
        this.replacementBlock = block;
    }

    @Override
    protected boolean useShapeForLightOcclusion(BlockState p_153159_) {
        return true;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext p_153131_) {
        return !this.defaultBlockState().canSurvive(p_153131_.getLevel(), p_153131_.getClickedPos())
                ? Block.pushEntitiesUp(this.defaultBlockState(), this.replacementBlock.defaultBlockState(), p_153131_.getLevel(), p_153131_.getClickedPos())
                : super.getStateForPlacement(p_153131_);
    }

    @Override
    protected BlockState updateShape(
            BlockState p_153152_,
            LevelReader p_374225_,
            ScheduledTickAccess p_374127_,
            BlockPos p_153156_,
            Direction p_153153_,
            BlockPos p_153157_,
            BlockState p_153154_,
            RandomSource p_374236_
    ) {
        if (p_153153_ == Direction.UP && !p_153152_.canSurvive(p_374225_, p_153156_)) {
            p_374127_.scheduleTick(p_153156_, this, 1);
        }

        return super.updateShape(p_153152_, p_374225_, p_374127_, p_153156_, p_153153_, p_153157_, p_153154_, p_374236_);
    }
    @Override
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!pState.canSurvive(pLevel, pPos)) {
            turnToReplacementBlock(null, pState, pLevel, pPos);
        }
    }

    public void turnToReplacementBlock(@Nullable Entity pEntity, BlockState pState, Level pLevel, BlockPos pPos) {
        BlockState blockstate = pushEntitiesUp(pState, this.replacementBlock.defaultBlockState(), pLevel, pPos);
        pLevel.setBlockAndUpdate(pPos, blockstate);
        pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pEntity, blockstate));
    }

    @Override
    protected boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        BlockState blockstate = pLevel.getBlockState(pPos.above());
        return !blockstate.isSolid() || blockstate.getBlock() instanceof FenceGateBlock;
    }

    @Override
    protected VoxelShape getShape(BlockState p_153143_, BlockGetter p_153144_, BlockPos p_153145_, CollisionContext p_153146_) {
        return SHAPE;
    }

    @Override
    protected boolean isPathfindable(BlockState p_153138_, PathComputationType p_153141_) {
        return true;
    }
}
