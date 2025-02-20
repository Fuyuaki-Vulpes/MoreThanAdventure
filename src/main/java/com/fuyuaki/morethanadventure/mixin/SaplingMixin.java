package com.fuyuaki.morethanadventure.mixin;

import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaBiomes;
import com.fuyuaki.morethanadventure.game.worldgen.tree.MtaTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SaplingBlock.class)
public abstract class SaplingMixin extends BushBlock implements BonemealableBlock {
    public SaplingMixin(Properties p_51021_) {
        super(p_51021_);
    }

    @Inject(method = "advanceTree",at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/grower/TreeGrower;growTree(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/level/chunk/ChunkGenerator;Lnet/minecraft/core/BlockPos;Lnet/minecraft/world/level/block/state/BlockState;Lnet/minecraft/util/RandomSource;)Z"), cancellable = true)
    private void treeGrowthMixin(ServerLevel level, BlockPos pos, BlockState state, RandomSource random, CallbackInfo ci){
        if (level.getBiome(pos).is(MtaBiomes.BOG)){
            MtaTreeGrower.BOGGED_OAK_TREE.growTree(level,level.getChunkSource().getGenerator(), pos, state, random);
            ci.cancel();
        }
    }
}
