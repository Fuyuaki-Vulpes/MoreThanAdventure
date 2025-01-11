package com.fuyuaki.morethanadventure.game.client.renderer.special;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.block.SprinklerModel;
import com.fuyuaki.morethanadventure.game.client.renderer.MTASheets;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
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

    public static final ResourceLocation LOCATION = ResourceLocation.fromNamespaceAndPath(MODID, "entity/sprinkler");


    private final SprinklerModel model;
    private final boolean turnedOn;

    public SprinklerSpecialRenderer(SprinklerModel model, boolean turnedOn) {
        this.model = model;
        this.turnedOn = turnedOn;
    }


    @Override
    public void render(ItemDisplayContext displayContext, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay, boolean hasFoilType) {
        VertexConsumer vertexconsumer = MTASheets.createSprinklerMaterial().buffer(bufferSource,RenderType::entityCutout);
        poseStack.pushPose();
        this.model.setupAnim(this.turnedOn);
        this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, packedOverlay);
        poseStack.popPose();
    }

    public static record Unbaked(boolean on) implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<SprinklerSpecialRenderer.Unbaked> MAP_CODEC = RecordCodecBuilder.mapCodec(
                p_388545_ -> p_388545_.group(
                                Codec.BOOL.optionalFieldOf("on", Boolean.FALSE).forGetter(SprinklerSpecialRenderer.Unbaked::on)
                        )
                        .apply(p_388545_, SprinklerSpecialRenderer.Unbaked::new)
        );

        public Unbaked() {
            this(true);
        }

        @Override
        public @NotNull MapCodec<SprinklerSpecialRenderer.Unbaked> type() {
            return MAP_CODEC;
        }

        @Override
        public SpecialModelRenderer<?> bake(EntityModelSet p_387681_) {
            SprinklerModel model = new SprinklerModel(p_387681_.bakeLayer(MTAModelLayers.SPRINKLER));
            return new SprinklerSpecialRenderer(model, this.on);
        }
    }
}
