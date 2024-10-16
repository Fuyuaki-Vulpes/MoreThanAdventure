package com.fuyuaki.morethanadventure.game.client.model.animation;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

public class AnimUtils {

    public static void animateWalkRot(ModelPart limb, float limbSwing, float limbSwingAmount, float strength, boolean inverse){
        float invr = inverse ? (float) Math.PI : 0;

        limb.xRot = Mth.cos(limbSwing * 0.6662F + invr) * 1.4F * limbSwingAmount * strength;
    }

    public static void animateWalkPos(ModelPart limb, float limbSwing, float limbSwingAmount, float strength, boolean inverse){
        float invr = inverse ? (float) Math.PI : 0;
        float defaultX = limb.x;
        limb.x = defaultX + (Mth.cos(limbSwing * 0.6662F + invr) * 1.4F * limbSwingAmount * strength);
    }

    public static void adjustHead(ModelPart head,float netHeadYaw, float headPitch){

        head.yRot = netHeadYaw * (float) (Math.PI / 180.0);
        head.xRot = headPitch * (float) (Math.PI / 180.0);
    }

}
