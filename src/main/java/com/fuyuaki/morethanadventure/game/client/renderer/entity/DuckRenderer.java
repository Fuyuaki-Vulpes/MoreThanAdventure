package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.DuckModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.DuckRenderState;
import com.fuyuaki.morethanadventure.world.entity.Duck;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class DuckRenderer extends MobRenderer<Duck, DuckRenderState, DuckModel<DuckRenderState>> {

    private static final Map<Duck.Variant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(Duck.Variant.class), map -> {
                map.put(Duck.Variant.MALLARD,
                        ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/duck/mallard.png"));
                map.put(Duck.Variant.MARBLED,
                        ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/duck/marbled.png"));
                map.put(Duck.Variant.WHITE,
                        ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/duck/white.png"));
            });

    public DuckRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new DuckModel<>(pContext.bakeLayer(MTAModelLayers.DUCK)), .5F);
    }

    @Override
    public DuckRenderState createRenderState() {
        return new DuckRenderState();
    }

    @Override
    public void render(DuckRenderState renderState, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(renderState.isBaby) {
            poseStack.scale(0.45f,0.45f,0.45f);
        }
        super.render(renderState, poseStack, bufferSource, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(DuckRenderState renderState) {
        return LOCATION_BY_VARIANT.get(renderState);
    }
}
