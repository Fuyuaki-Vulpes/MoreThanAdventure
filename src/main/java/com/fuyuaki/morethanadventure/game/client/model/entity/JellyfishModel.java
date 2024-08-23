package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.world.entity.Jellyfish;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class JellyfishModel extends DefaultedEntityGeoModel<Jellyfish> {

    public JellyfishModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "jellyfish"),false);
    }

    @Override
    public RenderType getRenderType(Jellyfish animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }


}
