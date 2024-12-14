package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.FrostedSlimeModel;
import com.fuyuaki.morethanadventure.world.entity.FrostedSlime;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.monster.MagmaCube;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class FrostedSlimeRenderer extends MobRenderer<FrostedSlime, FrostedSlimeModel<FrostedSlime>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/slime/frozen_slime.png");

    public FrostedSlimeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new FrostedSlimeModel<>(pContext.bakeLayer(MTAModelLayers.FROSTED_SLIME)), 0.25F);
    }

    protected int getBlockLightLevel(MagmaCube entity, BlockPos pos) {
        return 15;
    }

    @Override
    public void render(FrostedSlime entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        this.shadowRadius = 0.25F * (float)entity.getSize();
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    protected void scale(FrostedSlime livingEntity, PoseStack poseStack, float partialTickTime) {
        int i = livingEntity.getSize();
        float f = Mth.lerp(partialTickTime, livingEntity.oSquish, livingEntity.squish) / ((float)i * 0.5F + 1.0F);
        float f1 = 1.0F / (f + 1.0F);
        poseStack.scale(f1 * (float)i, 1.0F / f1 * (float)i, f1 * (float)i);
    }

    @Override
    public ResourceLocation getTextureLocation(FrostedSlime entity) {
        return TEXTURE;
    }
}
