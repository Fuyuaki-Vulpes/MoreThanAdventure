package com.fuyuvulpes.morethanadventure.mixin;

import com.fuyuvulpes.morethanadventure.core.Config;
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
public class FarmBlockMixin extends Block {
    private static final int range = Config.sprinklerRange;
    public FarmBlockMixin(Properties properties) {
        super(properties);
    }
    //Replace the Blocks.OBSIDIAN with SPRINKLER!!
    @Inject(method= "isNearWater(Lnet/minecraft/world/level/LevelReader;Lnet/minecraft/core/BlockPos;)Z", at=@At(value="TAIL"), cancellable = true)
    private static void isNearWater(LevelReader pLevel, BlockPos pPos, CallbackInfoReturnable<Boolean> cir){
        for (BlockPos blockpos : BlockPos.betweenClosed(pPos.offset(-range, 0, -range), pPos.offset(range, 2, range))) {
            BlockState blockState = pLevel.getBlockState(blockpos);

            if (blockState.is(Blocks.OBSIDIAN)) {
                cir.setReturnValue(true);
            }
        }
    }
}
