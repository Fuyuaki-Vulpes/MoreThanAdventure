package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.ArmoredSkeletonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.world.entity.ArmoredSkeleton;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Skeleton;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class ArmoredSkeletonRenderer extends HumanoidMobRenderer<ArmoredSkeleton, ArmoredSkeletonModel<ArmoredSkeleton>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/armored_skeleton.png");

    public ArmoredSkeletonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new ArmoredSkeletonModel<>(pContext.bakeLayer(MTAModelLayers.ARMORED_SKELETON)), .5F);
    }

    @Override
    public ResourceLocation getTextureLocation(ArmoredSkeleton entity) {
        return TEXTURE;
    }


}
