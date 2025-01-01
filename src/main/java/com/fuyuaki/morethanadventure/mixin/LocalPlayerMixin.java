package com.fuyuaki.morethanadventure.mixin;

import com.fuyuaki.morethanadventure.world.item.accessories.talisman.AttributeModifierTalismanItem;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.neoforged.neoforge.common.NeoForgeMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LocalPlayer.class)
public abstract class LocalPlayerMixin extends AbstractClientPlayer{

    @Unique
    private final LocalPlayer thisPlayer = (LocalPlayer)(Object)this;

    public LocalPlayerMixin(ClientLevel clientLevel, GameProfile gameProfile) {
        super(clientLevel, gameProfile);
    }
    @Inject(method = "getWaterVision",at = @At("HEAD"), cancellable = true)
    protected void waterVisionMixin(CallbackInfoReturnable<Float> cir){
        if (thisPlayer.isEyeInFluidType(NeoForgeMod.WATER_TYPE.value()) && AttributeModifierTalismanItem.enableScubaGearEffects(thisPlayer)) {
            cir.setReturnValue(1.0F);
        }
    }


}
