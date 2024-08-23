package com.fuyuaki.morethanadventure.mixin;

import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.world.entity.MobCategory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobCategory.class)
public class MixinMobCategory {

    @Unique
    private final MobCategory moreThanAdventure$category = (MobCategory)(Object)this;

    @Inject(method = "getMaxInstancesPerChunk", at = @At("RETURN"), cancellable = true)
    public void getMinDelay(CallbackInfoReturnable<Integer> cir) {
        if (moreThanAdventure$category == MobCategory.CREATURE) {
            cir.setReturnValue(30);
        }
    }


}
