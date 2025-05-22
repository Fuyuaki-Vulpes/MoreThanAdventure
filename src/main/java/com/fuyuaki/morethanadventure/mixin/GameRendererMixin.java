package com.fuyuaki.morethanadventure.mixin;


import com.fuyuaki.morethanadventure.core.deferred_registries.MTAAttachments;
import com.fuyuaki.morethanadventure.world.entity.util.MTAPlayer;
import com.fuyuaki.morethanadventure.world.item.accessories.talisman.AttributeModifierTalismanItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {
    @Shadow @Final private Minecraft minecraft;
    private static final ResourceLocation STUN_LOCATION = ResourceLocation.fromNamespaceAndPath(MODID,"textures/misc/stun.png");



    @Inject(method = "getNightVisionScale", at = @At("HEAD"), cancellable = true)
    private static void onGetNightVisionScale(LivingEntity entity, float f, CallbackInfoReturnable<Float> info) {
        if(AttributeModifierTalismanItem.enableScubaGearEffects(entity)) {
            info.setReturnValue(1.0F);
        }
    }



}
