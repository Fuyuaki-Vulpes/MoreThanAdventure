package com.fuyuaki.morethanadventure.game.client;

import net.minecraft.world.entity.LivingEntity;

public class PlayerModelOverlayUtil {


    public static boolean shouldRenderSirenParts(LivingEntity entity){
        return entity.isInWater() && !entity.isInvisible();
    }
    public static boolean shouldRenderSirenOutWaterParts(LivingEntity entity){
        return !entity.isInvisible();
    }
}
