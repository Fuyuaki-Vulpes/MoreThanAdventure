package com.fuyuaki.morethanadventure.mixin;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CactusBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.Tags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.regex.Pattern;

@Mixin(CactusBlock.class)
public abstract class CactusBlockMixin extends Block {

    public CactusBlockMixin(Properties p_49795_) {
        super(p_49795_);
    }

    @Inject(method = "canSurvive", at = @At("RETURN"), cancellable = true)
    private void canSurviveMixin(BlockState state, LevelReader level, BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        BlockState state1 = level.getBlockState(pos.below());
        if(state1.is(Blocks.COARSE_DIRT)){
            cir.setReturnValue(true);
        }

    }

}
