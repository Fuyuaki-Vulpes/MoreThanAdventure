package com.fuyuaki.morethanadventure.mixin;

import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import com.fuyuaki.morethanadventure.game.player.IMTAPlayer;
import com.fuyuaki.morethanadventure.world.item.TalismanItem;
import com.mojang.authlib.GameProfile;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
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
        if (thisPlayer.isEyeInFluidType(NeoForgeMod.WATER_TYPE.value()) && TalismanItem.shouldRenderParts(MtaItems.SIREN_TALISMAN.get(), thisPlayer)) {
            cir.setReturnValue(1.0F);
        }
    }


}
