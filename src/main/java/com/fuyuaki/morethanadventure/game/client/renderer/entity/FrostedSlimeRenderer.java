package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.FrostedSlimeModel;
import com.fuyuaki.morethanadventure.world.entity.FrostedSlime;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class FrostedSlimeRenderer extends MobRenderer<FrostedSlime, FrostedSlimeModel<FrostedSlime>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/frozen_slime.png");

    public FrostedSlimeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new FrostedSlimeModel<>(pContext.bakeLayer(MTAModelLayers.FROZEN_SLIME)), .5F);
    }

    protected void scale(FrostedSlime livingEntity, PoseStack poseStack, float partialTickTime) {
        float f = 0.999F;
        poseStack.scale(0.999F, 0.999F, 0.999F);
        poseStack.translate(0.0F, 0.001F, 0.0F);
        float f1 = (float)livingEntity.getSize();
        float f2 = Mth.lerp(partialTickTime, livingEntity.oSquish, livingEntity.squish) / (f1 * 0.5F + 1.0F);
        float f3 = 1.0F / (f2 + 1.0F);
        poseStack.scale(f3 * f1, 1.0F / f3 * f1, f3 * f1);
    }

    @Override
    public ResourceLocation getTextureLocation(FrostedSlime entity) {
        return TEXTURE;
    }
}
