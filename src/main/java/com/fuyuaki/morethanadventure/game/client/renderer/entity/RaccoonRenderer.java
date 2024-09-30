package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.RaccoonModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.Penguin;
import com.fuyuaki.morethanadventure.world.entity.Raccoon;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class RaccoonRenderer extends MobRenderer<Raccoon, RaccoonModel> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/raccoon.png");

    public RaccoonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new RaccoonModel(pContext.bakeLayer(MTAModelLayers.RACCOON)), .5F);
    }


    @Override
    public ResourceLocation getTextureLocation(Raccoon pEntity) {
        return TEXTURE;
    }


    @Override
    public void render(Raccoon entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()) {
            poseStack.scale(0.45f,0.45f,0.45f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
