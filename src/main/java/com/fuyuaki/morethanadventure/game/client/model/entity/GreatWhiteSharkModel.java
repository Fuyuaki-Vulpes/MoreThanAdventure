package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.world.entity.GreatWhiteShark;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GreatWhiteSharkModel extends DefaultedEntityGeoModel<GreatWhiteShark> {

    public GreatWhiteSharkModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "great_white_shark"),true);
    }

    @Override
    public RenderType getRenderType(GreatWhiteShark animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }


}
