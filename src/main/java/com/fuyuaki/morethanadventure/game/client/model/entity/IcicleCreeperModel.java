package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.world.entity.IcicleCreeper;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class IcicleCreeperModel extends DefaultedEntityGeoModel<IcicleCreeper> {
    public IcicleCreeperModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "icicle_creeper"), true);
    }

    @Override
    public RenderType getRenderType(IcicleCreeper animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }

}