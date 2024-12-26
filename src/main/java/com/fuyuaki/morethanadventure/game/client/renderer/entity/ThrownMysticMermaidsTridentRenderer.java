package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.MysticMermaidsTridentModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.ThrownMysticMermaidsTridentRenderState;
import com.fuyuaki.morethanadventure.world.entity.ThrownMysticMermaidsTrident;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class ThrownMysticMermaidsTridentRenderer extends EntityRenderer<ThrownMysticMermaidsTrident, ThrownMysticMermaidsTridentRenderState> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/mystic_mermaids_trident.png");
    private final MysticMermaidsTridentModel model;


    public ThrownMysticMermaidsTridentRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
        this.model = new MysticMermaidsTridentModel(pContext.bakeLayer(MTAModelLayers.MYSTIC_MERMAIDS_TRIDENT));
    }

    @Override
    public ThrownMysticMermaidsTridentRenderState createRenderState() {
        return new ThrownMysticMermaidsTridentRenderState();
    }

    @Override
    public void render(ThrownMysticMermaidsTridentRenderState p_361109_, PoseStack p_116114_, MultiBufferSource p_116115_, int p_116116_) {
        p_116114_.pushPose();
        p_116114_.mulPose(Axis.YP.rotationDegrees(p_361109_.yRot - 90.0F));
        p_116114_.mulPose(Axis.ZP.rotationDegrees(p_361109_.xRot + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBuffer(p_116115_, this.model.renderType(TEXTURE), false, p_361109_.isFoil);
        this.model.renderToBuffer(p_116114_, vertexconsumer, p_116116_, OverlayTexture.NO_OVERLAY);
        p_116114_.popPose();
        super.render(p_361109_, p_116114_, p_116115_, p_116116_);
    }

    @Override
    public void extractRenderState(ThrownMysticMermaidsTrident p_362162_, ThrownMysticMermaidsTridentRenderState p_360843_, float p_361066_) {
        super.extractRenderState(p_362162_, p_360843_, p_361066_);
        p_360843_.yRot = p_362162_.getYRot(p_361066_);
        p_360843_.xRot = p_362162_.getXRot(p_361066_);
        p_360843_.isFoil = p_362162_.isFoil();
    }

}
