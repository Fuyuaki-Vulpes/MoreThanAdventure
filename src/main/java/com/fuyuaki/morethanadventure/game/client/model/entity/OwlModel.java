package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.world.entity.Owl;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class OwlModel extends DefaultedEntityGeoModel<Owl> {

    public OwlModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "owl"),true);
    }

    @Override
    public RenderType getRenderType(Owl animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }


}
