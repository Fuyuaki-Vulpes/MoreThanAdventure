package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.SkeletonFighterRenderState;
import com.fuyuaki.morethanadventure.world.entity.SkeletonFighter;
import net.minecraft.client.renderer.entity.AbstractSkeletonRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class SkeletonFighterRenderer extends AbstractSkeletonRenderer<SkeletonFighter, SkeletonFighterRenderState> {

    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/skeleton/skeleton_fighter.png");

    public SkeletonFighterRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, MTAModelLayers.SKELETON_FIGHTER, MTAModelLayers.SKELETON_FIGHTER_INNER_ARMOR, MTAModelLayers.SKELETON_FIGHTER_OUTER_ARMOR);
    }

    @Override
    public SkeletonFighterRenderState createRenderState() {
        return new SkeletonFighterRenderState();
    }


    public ResourceLocation getTextureLocation(SkeletonFighterRenderState renderState) {
        return TEXTURE;
    }
}
