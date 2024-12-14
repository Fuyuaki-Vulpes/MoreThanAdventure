package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.world.entity.SkeletonFighter;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class SkeletonFighterRenderer extends SkeletonRenderer<SkeletonFighter> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/skeleton/skeleton_fighter.png");

    public SkeletonFighterRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,MTAModelLayers.SKELETON_FIGHTER, MTAModelLayers.SKELETON_FIGHTER_INNER_ARMOR, MTAModelLayers.SKELETON_FIGHTER_OUTER_ARMOR);
    }

    @Override
    public ResourceLocation getTextureLocation(SkeletonFighter entity) {
        return TEXTURE;
    }
}
