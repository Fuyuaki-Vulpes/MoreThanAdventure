package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.layers.GlowSpiderLayer;
import com.fuyuaki.morethanadventure.world.entity.GlowSpider;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class GlowSpiderRenderer extends SpiderRenderer<GlowSpider> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/spider/glow_spider.png");


    protected int getBlockLightLevel(GlowSpider entity, BlockPos pos) {
        return 15;
    }

    public GlowSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,MTAModelLayers.GLOW_SPIDER);
        this.shadowRadius *= 0.4F;

        this.addLayer(new GlowSpiderLayer<>(this, new SpiderModel(pContext.bakeLayer(MTAModelLayers.GLOW_SPIDER_GLOW))));

    }

    @Override
    public ResourceLocation getTextureLocation(LivingEntityRenderState entity) {
        return TEXTURE;
    }
}
