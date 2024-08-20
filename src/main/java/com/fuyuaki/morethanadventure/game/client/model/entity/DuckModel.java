package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.world.entity.Duck;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class DuckModel extends DefaultedEntityGeoModel<Duck> {

    public DuckModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "duck"),true);
    }

    @Override
    public ResourceLocation getTextureResource(Duck animatable) {
        return getVariantTexture(animatable.getVariant());
    }

    private static final ResourceLocation MALLARD = ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "textures/entity/duck/mallard.png");
    private static final ResourceLocation MARBLED = ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "textures/entity/duck/marbled.png");
    private static final ResourceLocation WHITE = ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "textures/entity/duck/white.png");


    public static ResourceLocation getVariantTexture(Duck.Variant pVariant) {
        if (pVariant.equals(Duck.Variant.MALLARD)) {
            return MALLARD;
        }
        else if (pVariant.equals(Duck.Variant.MARBLED)) {
            return MARBLED;
        }
        else {
            return WHITE;
        }
    }

    @Override
    public RenderType getRenderType(Duck animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }


}
