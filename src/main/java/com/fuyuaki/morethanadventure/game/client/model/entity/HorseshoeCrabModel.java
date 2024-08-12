package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.world.entity.HorseshoeCrab;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class HorseshoeCrabModel extends DefaultedEntityGeoModel<HorseshoeCrab> {

    public HorseshoeCrabModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "horseshoe_crab"),true);
    }

    @Override
    public RenderType getRenderType(HorseshoeCrab animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }


}
