package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.YukiOnnaModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.YukiOnnaRenderState;
import com.fuyuaki.morethanadventure.world.entity.YukiOnna;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class YukiOnnaRenderer extends MobRenderer<YukiOnna, YukiOnnaRenderState, YukiOnnaModel<YukiOnnaRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/yuki_onna.png");

    public YukiOnnaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new YukiOnnaModel<>(pContext.bakeLayer(MTAModelLayers.YUKI_ONNA)), .5F);
    }

    @Override
    public YukiOnnaRenderState createRenderState() {
        return new YukiOnnaRenderState();
    }


    @Override
    public ResourceLocation getTextureLocation(YukiOnnaRenderState renderState) {
        return TEXTURE;
    }

    @Override
    public void extractRenderState(YukiOnna onna, YukiOnnaRenderState state, float p_361157_) {
        state.isAggressive = onna.isAggressive();
        super.extractRenderState(onna, state, p_361157_);
    }
}
