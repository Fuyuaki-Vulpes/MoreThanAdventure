package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.world.entity.BlackWidow;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class BlackWidowRenderer extends SpiderRenderer<BlackWidow> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/spider/black_widow.png");


    public BlackWidowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, MTAModelLayers.BLACK_WIDOW);
    }


    @Override
    public ResourceLocation getTextureLocation(LivingEntityRenderState renderState) {
        return TEXTURE;
    }
}