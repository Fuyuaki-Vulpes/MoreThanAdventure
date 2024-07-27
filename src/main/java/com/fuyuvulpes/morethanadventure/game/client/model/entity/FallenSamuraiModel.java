package com.fuyuvulpes.morethanadventure.game.client.model.entity;

import com.fuyuvulpes.morethanadventure.core.MTAMod;
import com.fuyuvulpes.morethanadventure.world.entity.FallenSamurai;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class FallenSamuraiModel extends DefaultedEntityGeoModel<FallenSamurai> {
    public FallenSamuraiModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "fallen_samurai"), true);
    }

    @Override
    public RenderType getRenderType(FallenSamurai animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }
    @Override
    public void setCustomAnimations(FallenSamurai animatable, long instanceId, AnimationState<FallenSamurai> animationState) {

        GeoBone rightArm = getAnimationProcessor().getBone("right_arm");
        GeoBone leftArm = getAnimationProcessor().getBone("left_arm");
        if (leftArm == null || rightArm == null) return;

        float attackTime = animatable.getAttackAnim(1);
        float f = Mth.sin(attackTime * (float) Math.PI);
        float f1 = Mth.sin((1.0F - (1.0F - attackTime) * (1.0F - attackTime)) * (float) Math.PI);


        rightArm.setRotX(rightArm.getRotX() + (f * 1.2F - f1 * 0.4F));
        leftArm.setRotX(leftArm.getRotX() + (f * 1.2F - f1 * 0.4F));

    }

}
