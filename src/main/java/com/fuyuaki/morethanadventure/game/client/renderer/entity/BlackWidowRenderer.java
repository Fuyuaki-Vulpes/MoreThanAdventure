package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.BlackWidowModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.BlackWidow;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.renderer.entity.CaveSpiderRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.entity.monster.Spider;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class BlackWidowRenderer extends MobRenderer<BlackWidow, BlackWidowModel<BlackWidow>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/black_widow.png");


    public BlackWidowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new BlackWidowModel<>(pContext.bakeLayer(MTAModelLayers.BLACK_WIDOW)), .5F);
    }

    @Override
    public ResourceLocation getTextureLocation(BlackWidow entity) {
        return TEXTURE;
    }
}
