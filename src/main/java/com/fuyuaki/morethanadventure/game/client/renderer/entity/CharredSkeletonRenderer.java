package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.layers.SkeletonGlowLayer;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.CharredSkeletonRenderState;
import com.fuyuaki.morethanadventure.world.entity.CharredSkeleton;
import net.minecraft.client.model.SkeletonModel;
import net.minecraft.client.renderer.entity.AbstractSkeletonRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.state.SkeletonRenderState;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class CharredSkeletonRenderer extends AbstractSkeletonRenderer<CharredSkeleton,CharredSkeletonRenderState> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/skeleton/charred_skeleton.png");
    public static final ResourceLocation O_TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/skeleton/charred_skeleton_overlay.png");

    public CharredSkeletonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,MTAModelLayers.CHARRED_SKELETON, MTAModelLayers.CHARRED_SKELETON_INNER_ARMOR, MTAModelLayers.CHARRED_SKELETON_OUTER_ARMOR);
        this.addLayer(new SkeletonGlowLayer<>(this, pContext.getModelSet(), MTAModelLayers.CHARRED_SKELETON_OVERLAY, O_TEXTURE));

    }

    @Override
    public CharredSkeletonRenderState createRenderState() {
        return  new CharredSkeletonRenderState();
    }

    @Override
    public ResourceLocation getTextureLocation(CharredSkeletonRenderState p_368654_) {
        return TEXTURE;
    }
}
