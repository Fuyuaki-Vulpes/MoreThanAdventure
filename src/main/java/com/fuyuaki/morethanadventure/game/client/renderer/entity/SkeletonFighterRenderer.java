package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.BlackWidowModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.SkeletonFighterModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.SkeletonFighter;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class SkeletonFighterRenderer extends HumanoidMobRenderer<SkeletonFighter, SkeletonFighterModel<SkeletonFighter>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/skeleton_fighter.png");

    public SkeletonFighterRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new SkeletonFighterModel<>(pContext.bakeLayer(MTAModelLayers.SKELETON_FIGHTER)), .5F);
    }

    @Override
    public ResourceLocation getTextureLocation(SkeletonFighter entity) {
        return TEXTURE;
    }
}
