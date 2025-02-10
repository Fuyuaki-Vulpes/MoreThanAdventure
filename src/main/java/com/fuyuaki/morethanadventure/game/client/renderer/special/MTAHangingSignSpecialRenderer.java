package com.fuyuaki.morethanadventure.game.client.renderer.special;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.HangingSignRenderer;
import net.minecraft.client.renderer.special.NoDataSpecialModelRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.Optional;

public class MTAHangingSignSpecialRenderer implements NoDataSpecialModelRenderer {
    private final Model model;
    private final Material material;

    public MTAHangingSignSpecialRenderer(Model model, Material material) {
        this.model = model;
        this.material = material;
    }

    public void render(ItemDisplayContext context, PoseStack poseStack, MultiBufferSource bufferSource, int p_389663_, int p_389449_, boolean p_389652_) {
        HangingSignRenderer.renderInHand(poseStack, bufferSource, p_389663_, p_389449_, this.model, this.material);
    }

    @OnlyIn(Dist.CLIENT)
    public static record Unbaked(WoodType woodType, Optional<ResourceLocation> texture) implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<MTAHangingSignSpecialRenderer.Unbaked> MAP_CODEC = RecordCodecBuilder.mapCodec((instance) -> {
            return instance.group(WoodType.CODEC.fieldOf("wood_type").forGetter(MTAHangingSignSpecialRenderer.Unbaked::woodType), ResourceLocation.CODEC.optionalFieldOf("texture").forGetter(MTAHangingSignSpecialRenderer.Unbaked::texture)).apply(instance, MTAHangingSignSpecialRenderer.Unbaked::new);
        });

        public Unbaked(WoodType woodType) {
            this(woodType, Optional.empty());
        }

        public Unbaked(WoodType woodType, Optional<ResourceLocation> texture) {
            this.woodType = woodType;
            this.texture = texture;
        }

        public MapCodec<MTAHangingSignSpecialRenderer.Unbaked> type() {
            return MAP_CODEC;
        }

        public SpecialModelRenderer<?> bake(EntityModelSet p_389408_) {
            Model model = HangingSignRenderer.createSignModel(p_389408_, this.woodType, HangingSignRenderer.AttachmentType.CEILING_MIDDLE);
            Material material = (Material)this.texture.map(Sheets::createHangingSignMaterial).orElseGet(() -> {
                return Sheets.getHangingSignMaterial(this.woodType);
            });
            return new MTAHangingSignSpecialRenderer(model, material);
        }

        public WoodType woodType() {
            return this.woodType;
        }

        public Optional<ResourceLocation> texture() {
            return this.texture;
        }
    }
}
