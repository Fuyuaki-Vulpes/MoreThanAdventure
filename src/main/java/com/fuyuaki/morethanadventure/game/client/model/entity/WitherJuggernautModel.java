package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.world.entity.WitherJuggernaut;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class WitherJuggernautModel extends DefaultedEntityGeoModel<WitherJuggernaut> {
    public WitherJuggernautModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "wither_juggernaut"), true);
    }

    @Override
    public RenderType getRenderType(WitherJuggernaut animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }


}
