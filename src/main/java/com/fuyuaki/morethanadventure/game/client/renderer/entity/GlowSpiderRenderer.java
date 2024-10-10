package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.BlackWidowModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.GlowSpiderModel;
import com.fuyuaki.morethanadventure.world.entity.GlowSpider;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.MagmaCube;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class GlowSpiderRenderer extends MobRenderer<GlowSpider,GlowSpiderModel<GlowSpider>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/glow_spider.png");


    protected int getBlockLightLevel(GlowSpider entity, BlockPos pos) {
        return 15;
    }

    public GlowSpiderRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new GlowSpiderModel(pContext.bakeLayer(MTAModelLayers.GLOW_SPIDER)), .5F);
    }

    @Override
    public ResourceLocation getTextureLocation(GlowSpider entity) {
        return TEXTURE;
    }
}
