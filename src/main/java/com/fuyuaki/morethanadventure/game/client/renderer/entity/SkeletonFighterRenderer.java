package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.SkeletonFighterRenderState;
import com.fuyuaki.morethanadventure.world.entity.SkeletonFighter;
import net.minecraft.client.renderer.entity.AbstractSkeletonRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

<<<<<<< Updated upstream
public class SkeletonFighterRenderer extends AbstractSkeletonRenderer<SkeletonFighter, SkeletonFighterRenderState> {
=======
<<<<<<< HEAD
public class SkeletonFighterRenderer extends SkeletonRenderer<SkeletonFighter, SkeletonFighterRenderState> {
=======
public class SkeletonFighterRenderer extends AbstractSkeletonRenderer<SkeletonFighter, SkeletonFighterRenderState> {
>>>>>>> c9d8bd9ff694e0cb5b641aa7a884f988e45fa373
>>>>>>> Stashed changes
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/skeleton/skeleton_fighter.png");

    public SkeletonFighterRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,MTAModelLayers.SKELETON_FIGHTER, MTAModelLayers.SKELETON_FIGHTER_INNER_ARMOR, MTAModelLayers.SKELETON_FIGHTER_OUTER_ARMOR);
    }

    @Override
<<<<<<< Updated upstream
=======
<<<<<<< HEAD
    public ResourceLocation getTextureLocation(SkeletonFighterRenderState renderState) {
=======
>>>>>>> Stashed changes
    public SkeletonFighterRenderState createRenderState() {
        return new SkeletonFighterRenderState();
    }


    @Override
    public ResourceLocation getTextureLocation(SkeletonFighterRenderState p_368654_) {
<<<<<<< Updated upstream
=======
>>>>>>> c9d8bd9ff694e0cb5b641aa7a884f988e45fa373
>>>>>>> Stashed changes
        return TEXTURE;
    }
}
