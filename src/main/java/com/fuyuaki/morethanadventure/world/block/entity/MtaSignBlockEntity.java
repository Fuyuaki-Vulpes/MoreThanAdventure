package com.fuyuaki.morethanadventure.world.block.entity;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class MtaSignBlockEntity extends SignBlockEntity {
    public MtaSignBlockEntity(BlockPos pos, BlockState blockState) {

        super(MtaBlockEntities.SIGN.get(), pos, blockState);
    }
}
