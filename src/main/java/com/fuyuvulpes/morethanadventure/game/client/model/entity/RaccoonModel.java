package com.fuyuvulpes.morethanadventure.game.client.model.entity;

import com.fuyuvulpes.morethanadventure.core.MTAMod;
import com.fuyuvulpes.morethanadventure.world.entity.Raccoon;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class RaccoonModel extends DefaultedEntityGeoModel<Raccoon> {

    public RaccoonModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "raccoon"),true);
    }

    @Override
    public RenderType getRenderType(Raccoon animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }


}