package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.world.entity.Capybara;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class CapybaraModel extends DefaultedEntityGeoModel<Capybara> {

    public CapybaraModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "capybara"),true);
    }

    @Override
    public RenderType getRenderType(Capybara animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }


}
