package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.world.entity.GreatWhiteShark;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class GreatWhiteSharkModel extends DefaultedEntityGeoModel<GreatWhiteShark> {

    public GreatWhiteSharkModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "great_white_shark"),false);
    }

    @Override
    public RenderType getRenderType(GreatWhiteShark animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }

    @Override
    public void setCustomAnimations(GreatWhiteShark animatable, long instanceId, AnimationState<GreatWhiteShark> animationState) {
        EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

        GeoBone body = getAnimationProcessor().getBone("root");

        if (body != null) {
            body.setRotX(entityData.headPitch() * (float) (Math.PI / 180.0));
            body.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
        }
    }
}
