package com.fuyuaki.morethanadventure.game.client.renderer.special;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.block.SprinklerModel;
import com.fuyuaki.morethanadventure.game.client.renderer.MTASheets;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.special.NoDataSpecialModelRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import org.jetbrains.annotations.NotNull;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class SprinklerSpecialRenderer implements NoDataSpecialModelRenderer {


    private final SprinklerModel model;

    public SprinklerSpecialRenderer(SprinklerModel model) {
        this.model = model;
    }


    @Override
    public void render(ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, boolean hasFoilType) {
        VertexConsumer vertexconsumer = MTASheets.createSprinklerMaterial().buffer(bufferSource,RenderType::entityCutout);
        poseStack.pushPose();
        this.model.setupAnim(false);
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, packedOverlay);
        poseStack.popPose();
    }

    public static record Unbaked() implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<SprinklerSpecialRenderer.Unbaked> MAP_CODEC = MapCodec.unit(new SprinklerSpecialRenderer.Unbaked());

        @Override
        public @NotNull MapCodec<SprinklerSpecialRenderer.Unbaked> type() {
            return MAP_CODEC;
        }

        @Override
        public SpecialModelRenderer<?> bake(EntityModelSet modelSet) {
            SprinklerModel model = new SprinklerModel(modelSet.bakeLayer(MTAModelLayers.SPRINKLER));
            return new SprinklerSpecialRenderer(model);
        }
    }
}
