package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.world.entity.Arrows.MTAArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

@OnlyIn(Dist.CLIENT)
public class MTAArrowRenderer extends ArrowRenderer<MTAArrowEntity> {
    public static final ResourceLocation RESOURCE_LOCATION = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/projectiles/special_arrow.png");

    public MTAArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    /**
     * Returns the location of an entity's texture.
     */
    public ResourceLocation getTextureLocation(MTAArrowEntity pEntity) {
        return RESOURCE_LOCATION;
    }
}
