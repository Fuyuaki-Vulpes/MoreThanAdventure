package com.fuyuaki.morethanadventure.world.block;

import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.SnowyDirtBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;

public class PermafrostDirtBlock extends Block {
    public static final MapCodec<PermafrostDirtBlock> CODEC = simpleCodec(PermafrostDirtBlock::new);

    public PermafrostDirtBlock(Properties properties) {
        super(properties);
    }

    private static boolean canBeGrass(BlockState state, LevelReader levelReader, BlockPos pos) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = levelReader.getBlockState(blockpos);
        if (blockstate.is(Blocks.SNOW) && blockstate.getValue(SnowLayerBlock.LAYERS) == 1) {
            return true;
        } else if (blockstate.getFluidState().getAmount() == 8) {
            return false;
        } else {
            int i = LightEngine.getLightBlockInto(
                    levelReader, state, pos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(levelReader, blockpos)
            );
            return i < levelReader.getMaxLightLevel();
        }
    }
    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!canBeGrass(state, level, pos)) {
            if (!level.isAreaLoaded(pos, 1)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            level.setBlockAndUpdate(pos, MtaBlocks.PERMAFROST_DIRT.get().defaultBlockState());
        }
    }


}
