package com.fuyuaki.morethanadventure.mixin;

import com.fuyuaki.morethanadventure.core.registry.MtaEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Blocks.class)
public class BlocksMixin {

    @Inject(method = "ocelotOrParrot", at = @At("RETURN"), cancellable = true)
    private static void addSpawnsLeaves(BlockState state, BlockGetter getter, BlockPos pos, EntityType<?> type, CallbackInfoReturnable<Boolean> cir) {
        if(type == MtaEntityTypes.OWL.get() || type == MtaEntityTypes.TOUCAN.get() || type == MtaEntityTypes.BUTTERFLY.get()){
            cir.setReturnValue(true);
        }

    }

}
