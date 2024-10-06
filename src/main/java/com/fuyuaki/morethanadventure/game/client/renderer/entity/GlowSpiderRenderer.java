package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.GlowSpiderModel;
import com.fuyuaki.morethanadventure.world.entity.GlowSpider;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.resources.ResourceLocation;

public class GlowSpiderRenderer extends MobRenderer<GlowSpider, GlowSpiderModel<GlowSpider>> {
    public GlowSpiderRenderer(EntityRendererProvider.Context context, GlowSpiderModel<GlowSpider> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Override
    public ResourceLocation getTextureLocation(GlowSpider entity) {
        return null;
    }
}
