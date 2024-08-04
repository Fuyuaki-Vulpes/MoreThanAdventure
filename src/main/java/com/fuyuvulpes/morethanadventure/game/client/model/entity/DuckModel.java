package com.fuyuvulpes.morethanadventure.game.client.model.entity;

import com.fuyuvulpes.morethanadventure.core.MTAMod;
import com.fuyuvulpes.morethanadventure.world.entity.Duck;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class DuckModel extends DefaultedEntityGeoModel<Duck> {

    public DuckModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "duck"),true);
    }

    @Override
    public RenderType getRenderType(Duck animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }


}
