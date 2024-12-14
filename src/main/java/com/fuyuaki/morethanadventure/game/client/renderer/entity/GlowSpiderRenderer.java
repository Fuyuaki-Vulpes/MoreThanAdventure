package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.layers.GlowSpiderLayer;
import com.fuyuaki.morethanadventure.world.entity.GlowSpider;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.client.renderer.entity.layers.SpiderEyesLayer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.CaveSpider;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class GlowSpiderRenderer extends SpiderRenderer<GlowSpider> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/spider/glow_spider.png");


    protected int getBlockLightLevel(GlowSpider entity, BlockPos pos) {
        return 15;
    }

    public GlowSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,MTAModelLayers.GLOW_SPIDER);
        this.shadowRadius *= 0.4F;

        this.addLayer(new GlowSpiderLayer<>(this,pContext.getModelSet()));

    }

    protected void scale(GlowSpider livingEntity, PoseStack poseStack, float partialTickTime) {
        poseStack.scale(0.4F, 0.4F, 0.4F);
    }

    @Override
    public ResourceLocation getTextureLocation(GlowSpider entity) {
        return TEXTURE;
    }
}
