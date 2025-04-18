package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.HorseshoeCrabModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.HorseshoeCrabRenderState;
import com.fuyuaki.morethanadventure.world.entity.HorseshoeCrab;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class HorseshoeCrabRenderer extends MobRenderer<HorseshoeCrab, HorseshoeCrabRenderState, HorseshoeCrabModel<HorseshoeCrabRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/horseshoe_crab.png");

    public HorseshoeCrabRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new HorseshoeCrabModel<>(pContext.bakeLayer(MTAModelLayers.HORSESHOE_CRAB)), .5F);
    }

    @Override
    public HorseshoeCrabRenderState createRenderState() {
        return new HorseshoeCrabRenderState();
    }


    @Override
    public ResourceLocation getTextureLocation(HorseshoeCrabRenderState renderState) {
        return TEXTURE;
    }
}
