package com.fuyuaki.morethanadventure.game.client.model.animation;

import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

public class AnimUtils {

    public static void animateWalkRot(ModelPart limb, float walkPos, float walkSpeed, float strength, boolean inverse){
        float invr = inverse ? (float) Math.PI : 0;

        limb.xRot = Mth.cos(walkPos * 0.6662F + invr) * 1.4F * walkSpeed * strength;
    }
    public static void animateWalkZRot(ModelPart limb, float walkPos, float walkSpeed, float strength, boolean inverse){
        float invr = inverse ? (float) Math.PI : 0;

        limb.zRot = Mth.cos(walkPos * 0.6662F + invr) * 1.4F * walkSpeed * strength;
    }
    public static void animateWalkYRot(ModelPart limb, float walkPos, float walkSpeed, float strength, boolean inverse){
        float invr = inverse ? (float) Math.PI : 0;

        limb.yRot += Mth.cos(walkPos * 0.6662F + invr) * 1.4F * walkSpeed * strength;
    }

    public static void animateWalkRotAdditive(ModelPart limb, float walkPos, float walkSpeed, float strength, boolean inverse){
        float invr = inverse ? (float) Math.PI : 0;

        limb.xRot = Mth.cos(walkPos * 0.6662F + invr) * 1.4F * walkSpeed * strength;
    }
    public static void animateWalkZRotAdditive(ModelPart limb, float walkPos, float walkSpeed, float strength, boolean inverse){
        float invr = inverse ? (float) Math.PI : 0;

        limb.zRot += Mth.cos(walkPos * 0.6662F + invr) * 1.4F * walkSpeed * strength;
    }
    public static void animateWalkYRotAdditive(ModelPart limb, float walkPos, float walkSpeed, float strength, boolean inverse){
        float invr = inverse ? (float) Math.PI : 0;

        limb.yRot += Mth.cos(walkPos * 0.6662F + invr) * 1.4F * walkSpeed * strength;
    }

    public static void animateWalkPos(ModelPart limb, float walkPos, float walkSpeed, float strength, boolean inverse){
        float invr = inverse ? (float) Math.PI : 0;
        float defaultX = limb.x;
        limb.x = defaultX + (Mth.cos(walkPos * 0.6662F + invr) * 1.4F * walkSpeed * strength);
    }

    public static void adjustHead(ModelPart head,float yRot, float xRot){

        head.yRot = yRot * (float) (Math.PI / 180.0);
        head.xRot = xRot * (float) (Math.PI / 180.0);
    }
    public static void adjustHeadDivided(int divider, ModelPart head, float yRot, float xRot){

        head.yRot = (yRot / divider) * (float) (Math.PI / 180.0);
        head.xRot = (xRot / divider) * (float) (Math.PI / 180.0);
    }

}
