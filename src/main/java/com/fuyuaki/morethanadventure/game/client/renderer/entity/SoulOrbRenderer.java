package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.SoulOrbRenderState;
import com.fuyuaki.morethanadventure.world.entity.SoulOrb;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class SoulOrbRenderer extends EntityRenderer<SoulOrb, SoulOrbRenderState> {
    private static final ResourceLocation SOUL_LOCATION = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/soul_orb.png");
    private static final RenderType RENDER_TYPE = RenderType.itemEntityTranslucentCull(SOUL_LOCATION);

    public SoulOrbRenderer(EntityRendererProvider.Context context) {
        super(context);

        this.shadowRadius = 0.15F;
        this.shadowStrength = 0.75F;
    }



    protected int getBlockLightLevel(SoulOrb entity, BlockPos pos) {
        return Mth.clamp(super.getBlockLightLevel(entity, pos) + 7, 0, 15);
    }

    @Override
    public void render(SoulOrbRenderState renderState, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        float f4 = 1.0F;
        float f5 = 0.5F;
        float f6 = 0.25F;
        float f7 = 255.0F;
        float f8 = renderState.ageInTicks / 16.0F;

        int red = (int)((Mth.sin(f8 + (float) (Math.PI * 4.0 / 3.0)) + 1.0F) * 0.1F * f7);
        int green = (int) Math.max((Mth.sin(f8) + 1.0F) * 0.5F * 255.0F,60.0F);
        poseStack.translate(0.0F, 0.5F, 0.0F);
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        float scale = 0.3F;
        poseStack.scale(scale, scale, scale);
        VertexConsumer vertexconsumer = bufferSource.getBuffer(RENDER_TYPE);
        PoseStack.Pose posestack$pose = poseStack.last();

        float size = (Mth.sin(f8 * 2) +  1.0F) * 0.4F + 0.8F;
        float xOf = -0.5F;
        float yOf = -0.25F;

        float n = -1.0F;
        float m = 0.0F;
        vertex(vertexconsumer, posestack$pose, xOf, yOf, red, green, 255,
                n, m, packedLight);
        vertex(vertexconsumer, posestack$pose, xOf + size, yOf, red, green, 255,
                n, n, packedLight);
        vertex(vertexconsumer, posestack$pose, xOf + size, yOf + size, red, green,255,
                m, n, packedLight);
        vertex(vertexconsumer, posestack$pose, xOf, yOf + size, red, green, 255,
                m, m, packedLight);
        poseStack.popPose();
        super.render(renderState, poseStack, bufferSource, packedLight);
    }


    private static void vertex(
            VertexConsumer consumer,
            PoseStack.Pose pose,
            float x,
            float y,
            int red,
            int green,
            int blue,
            float u,
            float v,
            int packedLight
    ) {
        consumer.addVertex(pose, x, y, 0.0F)
                .setColor(red, green, blue, 200)
                .setUv(u, v)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(packedLight)
                .setNormal(pose, 0.0F, 1.0F, 0.0F);
    }

    @Override
    public SoulOrbRenderState createRenderState() {
        return new SoulOrbRenderState();
    }

    @Override
    public void extractRenderState(SoulOrb p_entity, SoulOrbRenderState reusedState, float partialTick) {
        super.extractRenderState(p_entity, reusedState, partialTick);
        reusedState.value = p_entity.value;
    }
}
