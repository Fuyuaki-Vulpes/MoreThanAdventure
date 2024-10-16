package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class BeardedDragonRenderer extends MobRenderer<BeardedDragon, BeardedDragonModel<BeardedDragon>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/bearded_dragon.png");

    public BeardedDragonRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new BeardedDragonModel<>(pContext.bakeLayer(MTAModelLayers.BEARDED_DRAGON)), .5F);
    }


    @Override
    public ResourceLocation getTextureLocation(BeardedDragon pEntity) {
        return TEXTURE;
    }


    @Override
    public void render(BeardedDragon entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()) {
            poseStack.scale(0.45f,0.45f,0.45f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
