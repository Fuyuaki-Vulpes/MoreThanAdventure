package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.TurkeyModel;
import com.fuyuaki.morethanadventure.world.entity.Deer;
import com.fuyuaki.morethanadventure.world.entity.Turkey;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class TurkeyRenderer extends MobRenderer<Turkey, TurkeyModel<Turkey>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/turkey.png");

    public TurkeyRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new TurkeyModel<>(pContext.bakeLayer(MTAModelLayers.TURKEY)), .5F);
    }


    @Override
    public ResourceLocation getTextureLocation(Turkey pEntity) {
        return TEXTURE;
    }


    @Override
    public void render(Turkey entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()) {
            poseStack.scale(0.45f,0.45f,0.45f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}