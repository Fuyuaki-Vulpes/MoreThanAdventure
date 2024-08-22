package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.NetheriteTridentModel;
import com.fuyuaki.morethanadventure.world.entity.ThrownNetheriteTrident;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class ThrownNetheriteTridentRenderer extends EntityRenderer<ThrownNetheriteTrident> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/netherite_trident.png");
    private final NetheriteTridentModel model;

    public ThrownNetheriteTridentRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new NetheriteTridentModel(pContext.bakeLayer(MTAModelLayers.NETHERITE_TRIDENT));
    }



    public void render(ThrownNetheriteTrident pEntity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        pPoseStack.pushPose();
        pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTicks, pEntity.xRotO, pEntity.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(
                pBuffer, this.model.renderType(this.getTextureLocation(pEntity)), false, pEntity.isFoil()
        );
        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY);
        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(ThrownNetheriteTrident pEntity) {
        return TEXTURE;
    }
}
