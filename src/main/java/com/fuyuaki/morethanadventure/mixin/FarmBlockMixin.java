package com.fuyuaki.morethanadventure.mixin;

import com.fuyuaki.morethanadventure.core.MTACommonConfig;
import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.fuyuaki.morethanadventure.world.block.Sprinkler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FarmBlock.class)
public abstract class FarmBlockMixin extends Block {
    private static final int range = MTACommonConfig.sprinklerRange > 1 ? MTACommonConfig.sprinklerRange : 8;
    public FarmBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method= "isNearWater(Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/core/BlockPos;)Z", at=@At(value="TAIL"), cancellable = true)
    private static void isNearWater(LevelReader pLevel, BlockPos pPos, CallbackInfoReturnable<Boolean> cir){
        for (BlockPos blockpos : BlockPos.betweenClosed(pPos.offset(-range, -1, -range), pPos.offset(range, 2, range))) {
            BlockState blockState = pLevel.getBlockState(blockpos);

            if (blockState.is(MtaBlocks.SPRINKLER.get()) && blockState.getValue(Sprinkler.ON)) {
                cir.setReturnValue(true);
            }
        }
    }
}
