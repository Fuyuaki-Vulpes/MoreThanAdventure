package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.world.entity.Shrimp;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class ShrimpModel extends DefaultedEntityGeoModel<Shrimp> {

    public ShrimpModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "shrimp"),true);
    }

    @Override
    public RenderType getRenderType(Shrimp animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }


}
