package com.fuyuaki.morethanadventure.mixin;

import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Music.class)
public class MusicMixin {
    @Unique
    private final Music moreThanAdventure$music = (Music)(Object)this;


    @Inject(method = "getMinDelay", at = @At("RETURN"), cancellable = true)
    public void getMinDelay(CallbackInfoReturnable<Integer> cir) {
        if (moreThanAdventure$music == Musics.CREATIVE ||moreThanAdventure$music == Musics.GAME ||moreThanAdventure$music == Musics.UNDER_WATER ) {
            cir.setReturnValue(200);
        } else if (moreThanAdventure$music == Musics.END) {
            cir.setReturnValue(100);
        }
    }


    @Inject(method = "getMaxDelay", at = @At("RETURN"), cancellable = true)
    public void getMaxDelay(CallbackInfoReturnable<Integer> cir) {
        if (moreThanAdventure$music == Musics.CREATIVE ||moreThanAdventure$music == Musics.GAME ||moreThanAdventure$music == Musics.UNDER_WATER || moreThanAdventure$music == Musics.END) {
            cir.setReturnValue(6000);
        }
    }


}
