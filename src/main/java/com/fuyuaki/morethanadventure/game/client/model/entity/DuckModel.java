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

    private static final ResourceLocation MALLARD = ResourceLocation.withDefaultNamespace("textures/entity/duck/mallard.png");
    private static final ResourceLocation MARBLED = ResourceLocation.withDefaultNamespace("textures/entity/duck/marbled.png");
    private static final ResourceLocation WHITE = ResourceLocation.withDefaultNamespace("textures/entity/duck/white.png");


    public static ResourceLocation getVariantTexture(Duck.Variant pVariant) {
        return switch (pVariant) {
            case MALLARD -> MALLARD;
            case MARBLED -> MARBLED;
            case WHITE -> WHITE;
        };
    }

    @Override
    public RenderType getRenderType(Duck animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }


}
