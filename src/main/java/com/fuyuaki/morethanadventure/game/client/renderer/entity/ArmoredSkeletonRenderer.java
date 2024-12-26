package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.layers.FakeArmorLayer;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.ArmoredSkeletonRenderState;
import com.fuyuaki.morethanadventure.world.entity.ArmoredSkeleton;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class ArmoredSkeletonRenderer extends AbstractSkeletonRenderer<ArmoredSkeleton, ArmoredSkeletonRenderState> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/skeleton/armored_skeleton.png");
    public static final ResourceLocation ARMOR_TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/skeleton/armored_skeleton_overlay.png");

    public ArmoredSkeletonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,MTAModelLayers.ARMORED_SKELETON, MTAModelLayers.ARMORED_SKELETON_INNER_ARMOR, MTAModelLayers.ARMORED_SKELETON_OUTER_ARMOR);
        this.addLayer(new FakeArmorLayer<>(this, pContext.getModelSet(), MTAModelLayers.ARMORED_SKELETON_ARMOR, ARMOR_TEXTURE));
    }

    @Override
    public ArmoredSkeletonRenderState createRenderState() {
        return new ArmoredSkeletonRenderState();
    }

    @Override
    public ResourceLocation getTextureLocation(ArmoredSkeletonRenderState p_368654_) {
        return TEXTURE;
    }
}
