package com.fuyuaki.morethanadventure.game.client.renderer.special;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.SignRenderer;
import net.minecraft.client.renderer.special.NoDataSpecialModelRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.Optional;

public class MTAStandingSignSpecialRenderer implements NoDataSpecialModelRenderer {
    private final Model model;
    private final Material material;

    public MTAStandingSignSpecialRenderer(Model model, Material material) {
        this.model = model;
        this.material = material;
    }
    @Override
    public void render(ItemDisplayContext context, PoseStack poseStack, MultiBufferSource bufferSource, int p_389471_, int p_389604_, boolean p_389437_) {
        SignRenderer.renderInHand(poseStack, bufferSource, p_389471_, p_389604_, this.model, this.material);
    }

    @OnlyIn(Dist.CLIENT)
    public static record Unbaked(WoodType woodType, Optional<ResourceLocation> texture) implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<MTAStandingSignSpecialRenderer.Unbaked> MAP_CODEC = RecordCodecBuilder.mapCodec((instance) -> {
            return instance.group(WoodType.CODEC.fieldOf("wood_type").forGetter(MTAStandingSignSpecialRenderer.Unbaked::woodType), ResourceLocation.CODEC.optionalFieldOf("texture").forGetter(MTAStandingSignSpecialRenderer.Unbaked::texture)).apply(instance, MTAStandingSignSpecialRenderer.Unbaked::new);
        });

        public Unbaked(WoodType woodType) {
            this(woodType, Optional.empty());
        }

        public Unbaked(WoodType woodType, Optional<ResourceLocation> texture) {
            this.woodType = woodType;
            this.texture = texture;
        }

        public MapCodec<MTAStandingSignSpecialRenderer.Unbaked> type() {
            return MAP_CODEC;
        }

        public SpecialModelRenderer<?> bake(EntityModelSet entityModelSet) {
            Model model = SignRenderer.createSignModel(entityModelSet, this.woodType, true);
            Material material = (Material)this.texture.map(Sheets::createSignMaterial).orElseGet(() -> {
                return Sheets.getSignMaterial(this.woodType);
            });
            return new MTAStandingSignSpecialRenderer(model, material);
        }

        public WoodType woodType() {
            return this.woodType;
        }

        public Optional<ResourceLocation> texture() {
            return this.texture;
        }
    }
}

