package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.ShrimpModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.ShrimpRenderState;
import com.fuyuaki.morethanadventure.world.entity.Shrimp;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class ShrimpRenderer extends MobRenderer<Shrimp, ShrimpRenderState, ShrimpModel<ShrimpRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/shrimp.png");

    public ShrimpRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new ShrimpModel<>(pContext.bakeLayer(MTAModelLayers.SHRIMP)), .5F);
    }

    @Override
    public ShrimpRenderState createRenderState() {
        return new ShrimpRenderState();
    }


    @Override
    public ResourceLocation getTextureLocation(ShrimpRenderState renderState) {
        return TEXTURE;
    }

}
