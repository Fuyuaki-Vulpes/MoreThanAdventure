package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.ArmoredSkeletonModel;
import com.fuyuaki.morethanadventure.world.entity.ArmoredSkeleton;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Skeleton;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class ArmoredSkeletonRenderer extends MobRenderer<ArmoredSkeleton, ArmoredSkeletonModel<ArmoredSkeleton>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/armored_skeleton.png");

    public ArmoredSkeletonRenderer(EntityRendererProvider.Context context, ArmoredSkeletonModel model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Override
    public ResourceLocation getTextureLocation(ArmoredSkeleton entity) {
        return null;
    }
}
