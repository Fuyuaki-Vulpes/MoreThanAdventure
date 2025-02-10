package com.fuyuaki.morethanadventure.world.block.entity;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MtaHangingSignBlockEntity extends SignBlockEntity {
    public MtaHangingSignBlockEntity(BlockPos pos, BlockState state) {
        super(MtaBlockEntities.HANGING_SIGN.get(), pos, state);
    }
    @Override
    public boolean isValidBlockState(BlockState blockState) {
        return this.getType().isValid(blockState);
    }

    @Override
    public BlockEntityType<?> getType()
    {
        return MtaBlockEntities.HANGING_SIGN.get();
    }
}
