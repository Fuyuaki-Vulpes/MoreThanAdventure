package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.DuckModel;
import com.fuyuaki.morethanadventure.world.entity.Duck;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class DuckRenderer extends MobRenderer<Duck, DuckModel> {

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
        super(pContext,new DuckModel(pContext.bakeLayer(MTAModelLayers.DUCK)), .5F);
    }


    @Override
    public ResourceLocation getTextureLocation(Duck pEntity) {
        return LOCATION_BY_VARIANT.get(pEntity.getVariant());
    }


    @Override
    public void render(Duck entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()) {
            poseStack.scale(0.45f,0.45f,0.45f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

}
