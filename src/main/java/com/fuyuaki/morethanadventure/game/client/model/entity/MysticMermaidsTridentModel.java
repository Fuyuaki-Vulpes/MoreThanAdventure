package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.world.entity.ThrownMysticMermaidsTrident;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class MysticMermaidsTridentModel extends DefaultedEntityGeoModel<ThrownMysticMermaidsTrident> {

    public MysticMermaidsTridentModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "mystic_mermaids_trident"),true);
    }

    @Override
    public RenderType getRenderType(ThrownMysticMermaidsTrident animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }


}
