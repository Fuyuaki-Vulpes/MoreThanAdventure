package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.world.entity.BlackWidow;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class BlackWidowRenderer extends SpiderRenderer<BlackWidow> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/black_widow.png");


    public BlackWidowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, MTAModelLayers.BLACK_WIDOW);
    }



    protected void scale(BlackWidow livingEntity, PoseStack poseStack, float partialTickTime) {
        poseStack.scale(0.8F, 0.8F, 0.8F);
    }


    @Override
    public ResourceLocation getTextureLocation(BlackWidow entity) {
        return TEXTURE;
    }
}