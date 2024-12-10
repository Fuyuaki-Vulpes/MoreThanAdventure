package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.world.entity.CharredSkeleton;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class CharredSkeletonRenderer extends SkeletonRenderer<CharredSkeleton> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/charred_skeleton.png");

    public CharredSkeletonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,MTAModelLayers.CHARRED_SKELETON, MTAModelLayers.CHARRED_SKELETON_INNER_ARMOR, MTAModelLayers.CHARRED_SKELETON_OUTER_ARMOR);
    }
    @Override
    public ResourceLocation getTextureLocation(CharredSkeleton entity) {
        return TEXTURE;
    }
}
