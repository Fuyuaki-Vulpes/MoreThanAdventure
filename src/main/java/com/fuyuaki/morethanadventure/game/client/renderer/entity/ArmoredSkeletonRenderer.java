package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.ArmoredSkeletonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.world.entity.ArmoredSkeleton;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Skeleton;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class ArmoredSkeletonRenderer extends SkeletonRenderer<ArmoredSkeleton> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/armored_skeleton.png");

    public ArmoredSkeletonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,MTAModelLayers.ARMORED_SKELETON, MTAModelLayers.ARMORED_SKELETON_INNER_ARMOR, MTAModelLayers.ARMORED_SKELETON_OUTER_ARMOR);
    }

    @Override
    public ResourceLocation getTextureLocation(ArmoredSkeleton entity) {
        return TEXTURE;
    }


}
