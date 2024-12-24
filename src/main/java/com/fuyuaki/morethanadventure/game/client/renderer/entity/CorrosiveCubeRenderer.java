package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.CorrosiveCubeModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.layers.CorrosiveCubeOuterLayer;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.CorrosiveCubeRenderState;
import com.fuyuaki.morethanadventure.world.entity.CorrosiveCube;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.SlimeRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class CorrosiveCubeRenderer extends MobRenderer<CorrosiveCube, CorrosiveCubeRenderState, CorrosiveCubeModel<CorrosiveCubeRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/slime/corrosive_cube.png");

    public CorrosiveCubeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new CorrosiveCubeModel<>(pContext.bakeLayer(MTAModelLayers.CORROSIVE_CUBE)), .5F);
        this.addLayer(new CorrosiveCubeOuterLayer<>(this, pContext.getModelSet()));

    }

    @Override
    public CorrosiveCubeRenderState createRenderState() {
        return new CorrosiveCubeRenderState();
    }

    @Override
    protected float getShadowRadius(CorrosiveCubeRenderState p_365066_) {return (float)p_365066_.size * 0.25F;}

    @Override
    protected void scale(CorrosiveCubeRenderState p_362272_, PoseStack p_115315_) {

        float f = 0.999F;
        p_115315_.scale(0.999F, 0.999F, 0.999F);
        p_115315_.translate(0.0F, 0.001F, 0.0F);
        float f1 = (float)p_362272_.size;
        float f2 = p_362272_.squish / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        p_115315_.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }


    public ResourceLocation getTextureLocation(CorrosiveCubeRenderState p_368654_) {
        return TEXTURE;
    }
}
