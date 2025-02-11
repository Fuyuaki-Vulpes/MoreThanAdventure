package com.fuyuaki.morethanadventure.game.client.renderer.block;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.block.SprinklerModel;
import com.fuyuaki.morethanadventure.world.block.entity.SprinklerEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;

public class SprinklerRenderer<T extends SprinklerEntity> implements BlockEntityRenderer<T> {
    private static final Material MATERIAL = new Material(TextureAtlas.LOCATION_BLOCKS, ResourceLocation.withDefaultNamespace("sprinkler/sprinkler"));


    private final SprinklerModel sprinklerModel;

    public SprinklerRenderer(BlockEntityRendererProvider.Context context) {
        this.sprinklerModel = new SprinklerModel(context.bakeLayer(MTAModelLayers.SPRINKLER));
    }



    @Override
    public void render(T blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        VertexConsumer vertexconsumer = MATERIAL.buffer(bufferSource, RenderType::entityCutout);
        poseStack.translate(0.5F, -0.5F, 0.5F);
        poseStack.rotateAround(Axis.XP.rotation(3.145F), 0.0F, 1.0F, 0.0F);
        this.sprinklerModel.setupAnim(blockEntity.getOn(), partialTick);
        this.sprinklerModel.renderToBuffer(poseStack, vertexconsumer, packedLight, packedOverlay);
    }


}