package com.fuyuvulpes.morethanadventure.game.client.model.entity;

import com.fuyuvulpes.morethanadventure.core.MTAMod;
import com.fuyuvulpes.morethanadventure.world.entity.Ferret;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class FerretModel extends DefaultedEntityGeoModel<Ferret> {

    public FerretModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "ferret"),true);
    }

    @Override
    public RenderType getRenderType(Ferret animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }


}
