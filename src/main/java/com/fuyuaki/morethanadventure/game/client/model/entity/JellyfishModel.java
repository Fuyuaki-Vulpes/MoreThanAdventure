package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.world.entity.Jellyfish;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class JellyfishModel extends DefaultedEntityGeoModel<Jellyfish> {

    public JellyfishModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "jellyfish"),false);
    }

    @Override
    public RenderType getRenderType(Jellyfish animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }

    @Override
    public void setCustomAnimations(Jellyfish animatable, long instanceId, AnimationState<Jellyfish> animationState) {
        EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

        GeoBone body = getAnimationProcessor().getBone("root");

        if (body != null) {
            body.setRotX((entityData.headPitch() - 90) * (float) (Math.PI / 180.0));
            body.setRotY(entityData.netHeadYaw() * (float) (Math.PI / 180.0));
        }
    }
}
