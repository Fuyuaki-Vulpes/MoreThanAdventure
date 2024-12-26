package com.fuyuaki.morethanadventure.mixin;


import net.minecraft.world.entity.player.Inventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Inventory.class)
public abstract class InventoryMixin {

//    @Inject(method = "dropAll",at = @At("HEAD"))
//    private void dropAllMixin(CallbackInfo ci){
//
//    }

}
