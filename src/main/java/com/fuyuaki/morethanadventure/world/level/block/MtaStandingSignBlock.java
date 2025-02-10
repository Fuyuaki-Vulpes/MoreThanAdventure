package com.fuyuaki.morethanadventure.world.level.block;

import com.fuyuaki.morethanadventure.world.block.entity.MtaSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.StandingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class MtaStandingSignBlock extends StandingSignBlock {
    public MtaStandingSignBlock(WoodType type, Properties properties) {

        super(type, properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {

        return new MtaSignBlockEntity(pos, state);
    }
}
