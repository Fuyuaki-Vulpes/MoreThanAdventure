package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.world.entity.Octopus;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class OctopusModel extends DefaultedEntityGeoModel<Octopus> {

    public OctopusModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "octopus"),true);
    }

    @Override
    public RenderType getRenderType(Octopus animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }


}
