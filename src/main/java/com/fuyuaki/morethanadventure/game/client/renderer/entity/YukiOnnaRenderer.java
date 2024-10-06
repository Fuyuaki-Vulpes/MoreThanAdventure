package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.YukiOnnaModel;
import com.fuyuaki.morethanadventure.world.entity.YukiOnna;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class YukiOnnaRenderer extends MobRenderer<YukiOnna, YukiOnnaModel<YukiOnna>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/yuki_onna.png");

    public YukiOnnaRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new YukiOnnaModel(pContext.bakeLayer(MTAModelLayers.YUKI_ONNA)), .5F);
    }


    @Override
    public ResourceLocation getTextureLocation(YukiOnna pEntity) {
        return TEXTURE;
    }


}
