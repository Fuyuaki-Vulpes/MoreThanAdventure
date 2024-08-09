package com.fuyuvulpes.morethanadventure.mixin;


import net.neoforged.neoforge.data.loading.DatagenModLoader;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vectorwing.farmersdelight.common.event.CommonModBusEvents;


@Mixin(CommonModBusEvents.class)
public class TemporaryFix {

    @Inject(method = "onModifyDefaultComponents(Lnet/neoforged/neoforge/event/ModifyDefaultComponentsEvent;)V", at = @At("HEAD"), cancellable = true)
    private static void fixRunData(ModifyDefaultComponentsEvent event, CallbackInfo ci) {
        if (DatagenModLoader.isRunningDataGen()) {
            ci.cancel();
        }
    }


}
