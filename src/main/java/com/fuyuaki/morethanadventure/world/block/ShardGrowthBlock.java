package com.fuyuaki.morethanadventure.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class ShardGrowthBlock extends Block {
    private final Block replacement;
    private final ShardClusterBlock shardClusterBlock;

    public ShardGrowthBlock(Block replacement, ShardClusterBlock shardClusterBlock, Properties p_49795_) {
        super(p_49795_);
        this.replacement = replacement;
        this.shardClusterBlock = shardClusterBlock;
    }

    @Override
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pRandom.nextBoolean()){
            List<BlockPos> posList = List.of(pPos.above(),pPos.below(),pPos.east(),pPos.north(),pPos.west(),pPos.south());
            for (BlockPos pos : posList){
                if (pRandom.nextFloat() < 0.4F && (pLevel.getBlockState(pos).is(Blocks.WATER) || pLevel.getBlockState(pos).isAir())){
                    pLevel.setBlock(pos,shardClusterBlock.defaultBlockState()
                            .setValue(BlockStateProperties.WATERLOGGED, pLevel.getBlockState(pos).is(Blocks.WATER))
                                    .setValue(BlockStateProperties.FACING,
                                            Direction.getNearest(
                                                    new Vec3(
                                                            pos.getCenter().subtract(pPos.getCenter()).toVector3f()
                                                    ))),

                            3);
                }
            }
        }
        if (pRandom.nextFloat() < 0.05F){
            pLevel.setBlock(pPos,replacement.defaultBlockState(),3);
        }
    }
}
