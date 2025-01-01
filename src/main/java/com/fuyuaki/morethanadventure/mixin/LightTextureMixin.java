package com.fuyuaki.morethanadventure.mixin;

import com.fuyuaki.morethanadventure.world.item.accessories.talisman.AttributeModifierTalismanItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LightTexture.class)
public class LightTextureMixin {


    @ModifyVariable(method = "updateLightTexture",at = @At("STORE"),ordinal = 7)
    private float f5Change(float x){
        Player player = Minecraft.getInstance().player;
        if (player == null)return x;
        if (AttributeModifierTalismanItem.enableScubaGearEffects(player)){
            return 1.0F;
        }
        return x;

    }

}
