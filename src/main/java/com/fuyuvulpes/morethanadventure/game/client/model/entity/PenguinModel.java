package com.fuyuvulpes.morethanadventure.game.client.model.entity;

import com.fuyuvulpes.morethanadventure.core.MTAMod;
import com.fuyuvulpes.morethanadventure.world.entity.Penguin;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class PenguinModel extends DefaultedEntityGeoModel<Penguin> {

    public PenguinModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "penguin"),true);
    }

    @Override
    public RenderType getRenderType(Penguin animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }


}
