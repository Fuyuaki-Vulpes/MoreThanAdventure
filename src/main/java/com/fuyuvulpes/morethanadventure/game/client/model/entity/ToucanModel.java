package com.fuyuvulpes.morethanadventure.game.client.model.entity;

import com.fuyuvulpes.morethanadventure.core.MTAMod;
import com.fuyuvulpes.morethanadventure.world.entity.Toucan;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class ToucanModel extends DefaultedEntityGeoModel<Toucan> {

    public ToucanModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "toucan"),true);
    }

    @Override
    public RenderType getRenderType(Toucan animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }


}
