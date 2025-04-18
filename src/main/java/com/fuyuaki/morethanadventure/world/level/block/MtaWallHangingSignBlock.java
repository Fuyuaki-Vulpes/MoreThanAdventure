package com.fuyuaki.morethanadventure.world.level.block;

import com.fuyuaki.morethanadventure.world.block.entity.MtaHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class MtaWallHangingSignBlock extends WallHangingSignBlock {
    public MtaWallHangingSignBlock(WoodType type, Properties properties) {

        super(type, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new MtaHangingSignBlockEntity(pos, state);
    }
}
