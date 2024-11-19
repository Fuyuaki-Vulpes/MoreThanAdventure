package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.BlackWidowModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.CharredSkeletonModel;
import com.fuyuaki.morethanadventure.world.entity.ArmoredSkeleton;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.CharredSkeleton;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Skeleton;

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
