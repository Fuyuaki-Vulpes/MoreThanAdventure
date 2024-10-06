package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.CapybaraModel;
import com.fuyuaki.morethanadventure.world.entity.Capybara;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class CapybaraRenderer extends MobRenderer<Capybara, CapybaraModel> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/capybara.png");

    public CapybaraRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new CapybaraModel(pContext.bakeLayer(MTAModelLayers.CAPYBARA)), 0.5F);
    }


    @Override
    public ResourceLocation getTextureLocation(Capybara pEntity) {
        return TEXTURE;
    }


    @Override
    public void render(Capybara entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()) {
            poseStack.scale(0.45f,0.45f,0.45f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
