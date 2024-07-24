package com.fuyuvulpes.morethanadventure.game.client.model.entity;

import com.fuyuvulpes.morethanadventure.core.MTAMod;
import com.fuyuvulpes.morethanadventure.world.entity.YukiOnna;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class YukiOnnaModel extends DefaultedEntityGeoModel<YukiOnna> {

    public YukiOnnaModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "yuki_onna"));
    }

    @Override
    public RenderType getRenderType(YukiOnna animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }

    @Override
    public void setCustomAnimations(YukiOnna animatable, long instanceId, AnimationState<YukiOnna> animationState) {

        GeoBone head = getAnimationProcessor().getBone("head");
        if (head == null) return;
        if (head.getChildBones().isEmpty()) return;
        GeoBone headRotation = head.getChildBones().getFirst();
        if (headRotation == null) return;

        EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        headRotation.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
        headRotation.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
    }

}
