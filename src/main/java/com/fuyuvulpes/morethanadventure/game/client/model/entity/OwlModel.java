package com.fuyuvulpes.morethanadventure.game.client.model.entity;

import com.fuyuvulpes.morethanadventure.core.MTAMod;
import com.fuyuvulpes.morethanadventure.world.entity.Owl;
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
