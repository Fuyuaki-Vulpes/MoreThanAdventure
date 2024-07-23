package com.fuyuvulpes.morethanadventure.mixin;

import com.fuyuvulpes.morethanadventure.core.MTAServerConfig;
import com.fuyuvulpes.morethanadventure.core.registry.MtaBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FarmBlock.class)
public class FarmBlockMixin extends Block {
    private static final int range = MTAServerConfig.sprinklerRange > 1 ? MTAServerConfig.sprinklerRange : 8;
    public FarmBlockMixin(Properties properties) {
        super(properties);
    }

    @Inject(method= "isNearWater(Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/core/BlockPos;)Z", at=@At(value="TAIL"), cancellable = true)
    private static void isNearWater(LevelReader pLevel, BlockPos pPos, CallbackInfoReturnable<Boolean> cir){
        for (BlockPos blockpos : BlockPos.betweenClosed(pPos.offset(-range, -1, -range), pPos.offset(range, 2, range))) {
            BlockState blockState = pLevel.getBlockState(blockpos);

            if (blockState.is(MtaBlocks.SPRINKLER.get())) {
                cir.setReturnValue(true);
            }
        }
    }
}
