package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.NetheriteTridentModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.ThrownMysticMermaidsTridentRenderState;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.ThrownNetheriteTridentRenderState;
import com.fuyuaki.morethanadventure.world.entity.ThrownMysticMermaidsTrident;
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

public class ThrownNetheriteTridentRenderer extends EntityRenderer<ThrownNetheriteTrident, ThrownNetheriteTridentRenderState> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/netherite_trident.png");
    private final NetheriteTridentModel model;

    public ThrownNetheriteTridentRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new NetheriteTridentModel(pContext.bakeLayer(MTAModelLayers.NETHERITE_TRIDENT));
    }

    @Override
    public ThrownNetheriteTridentRenderState createRenderState() {
        return new ThrownNetheriteTridentRenderState();
    }

    @Override
    public void render(ThrownNetheriteTridentRenderState p_361109_, PoseStack p_116114_, MultiBufferSource p_116115_, int p_116116_) {
        p_116114_.pushPose();
        p_116114_.mulPose(Axis.YP.rotationDegrees(p_361109_.yRot - 90.0F));
        p_116114_.mulPose(Axis.ZP.rotationDegrees(p_361109_.xRot + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBuffer(p_116115_, this.model.renderType(TEXTURE), false, p_361109_.isFoil);
        this.model.renderToBuffer(p_116114_, vertexconsumer, p_116116_, OverlayTexture.NO_OVERLAY);
        p_116114_.popPose();
        super.render(p_361109_, p_116114_, p_116115_, p_116116_);
    }

    @Override
    public void extractRenderState(ThrownNetheriteTrident p_362162_, ThrownNetheriteTridentRenderState p_360843_, float p_361066_) {
        super.extractRenderState(p_362162_, p_360843_, p_361066_);
        p_360843_.yRot = p_362162_.getYRot(p_361066_);
        p_360843_.xRot = p_362162_.getXRot(p_361066_);
        p_360843_.isFoil = p_362162_.isFoil();
    }
}
