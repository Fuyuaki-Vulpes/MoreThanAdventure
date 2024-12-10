package com.fuyuaki.morethanadventure.game.client.renderer.player;

import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import com.fuyuaki.morethanadventure.game.client.PlayerModelOverlayUtil;
import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.player.SirenModel;
import com.fuyuaki.morethanadventure.world.item.curio.talisman.AttributeModifierTalismanItem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class SirenRenderLayer<T extends Player, M extends HumanoidModel<T>> extends RenderLayer<T, M> {
    protected final SirenModel model;
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/player_overlays/siren.png");
    public static final ResourceLocation TEXTURE_HIDDEN = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/player_overlays/siren_b.png");


    public SirenRenderLayer(RenderLayerParent<T, M> renderer, EntityRendererProvider.Context pContext) {
        super(renderer);
        this.model = new SirenModel(pContext.bakeLayer(MTAModelLayers.SIREN_LAYER));


    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, T livingEntity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        if (!AttributeModifierTalismanItem.shouldRenderParts( MtaItems.SIREN_TALISMAN.get(),livingEntity)) return;
        if (PlayerModelOverlayUtil.shouldRenderSirenParts(livingEntity)) {
            poseStack.pushPose();
            VertexConsumer consumer = ItemRenderer.getFoilBufferDirect(bufferSource, RenderType.entityTranslucentCull(TEXTURE), false, false);
            this.model.copyFrom(this.getParentModel());
            this.model.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            this.model.renderToBuffer(poseStack, consumer, packedLight, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }else if (PlayerModelOverlayUtil.shouldRenderSirenOutWaterParts(livingEntity)){
            poseStack.pushPose();
            VertexConsumer consumer = ItemRenderer.getFoilBufferDirect(bufferSource, RenderType.entityTranslucentCull(TEXTURE_HIDDEN), false, false);
            this.model.copyFrom(this.getParentModel());
            this.model.setupAnim(livingEntity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            this.model.renderToBuffer(poseStack, consumer, packedLight, OverlayTexture.NO_OVERLAY);
            poseStack.popPose();
        }
    }
}
