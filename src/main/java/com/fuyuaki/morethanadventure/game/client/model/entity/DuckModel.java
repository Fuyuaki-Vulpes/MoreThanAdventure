package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.world.entity.Duck;
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
