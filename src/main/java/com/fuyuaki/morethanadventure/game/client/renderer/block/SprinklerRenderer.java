package com.fuyuaki.morethanadventure.game.client.renderer.block;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlocks;
import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.block.SprinklerModel;
import com.fuyuaki.morethanadventure.game.client.renderer.MTASheets;
import com.fuyuaki.morethanadventure.world.block.Sprinkler;
import com.fuyuaki.morethanadventure.world.block.entity.SprinklerEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class SprinklerRenderer<T extends SprinklerEntity> implements BlockEntityRenderer<T> {


    private final SprinklerModel sprinklerModel;

    public SprinklerRenderer(BlockEntityRendererProvider.Context context) {
        this.sprinklerModel = new SprinklerModel(context.bakeLayer(MTAModelLayers.SPRINKLER));
    }



    @Override
    public void render(T blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Level level = blockEntity.getLevel();
        boolean flag = level != null;
        BlockState blockstate = flag ? blockEntity.getBlockState() : MtaBlocks.SPRINKLER.get().defaultBlockState();
        VertexConsumer vertexconsumer = MTASheets.createSprinklerMaterial().buffer(bufferSource, RenderType::entityCutout);
        //poseStack.translate(0.5F, -0.5F, 0.5F);
        this.sprinklerModel.setupAnim(blockstate.getValue(Sprinkler.ON));
        this.sprinklerModel.renderToBuffer(poseStack, vertexconsumer, packedLight, packedOverlay);
    }
}