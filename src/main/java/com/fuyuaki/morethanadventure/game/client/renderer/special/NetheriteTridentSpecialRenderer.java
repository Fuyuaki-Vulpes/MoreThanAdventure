package com.fuyuaki.morethanadventure.game.client.renderer.special;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.NetheriteTridentModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.model.TridentModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.special.NoDataSpecialModelRenderer;
import net.minecraft.client.renderer.special.SpecialModelRenderer;
import net.minecraft.client.renderer.special.TridentSpecialRenderer;
import net.minecraft.world.item.ItemDisplayContext;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)

public class NetheriteTridentSpecialRenderer implements NoDataSpecialModelRenderer {
    private final NetheriteTridentModel model;

    public NetheriteTridentSpecialRenderer(NetheriteTridentModel model) {
        this.model = model;
    }
    @Override
    public void render(ItemDisplayContext p_387547_, PoseStack p_386661_, MultiBufferSource p_386541_, int p_387525_, int p_388595_, boolean p_388045_) {
        p_386661_.pushPose();
        p_386661_.scale(1.0F, -1.0F, -1.0F);
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBuffer(p_386541_, this.model.renderType(NetheriteTridentModel.TEXTURE), false, p_388045_);
        this.model.renderToBuffer(p_386661_, vertexconsumer, p_387525_, p_388595_);
        p_386661_.popPose();
    }



    @OnlyIn(Dist.CLIENT)
    public static record Unbaked() implements SpecialModelRenderer.Unbaked {
        public static final MapCodec<NetheriteTridentSpecialRenderer.Unbaked> MAP_CODEC = MapCodec.unit(new NetheriteTridentSpecialRenderer.Unbaked());

        @Override
        public MapCodec<NetheriteTridentSpecialRenderer.Unbaked> type() {
            return MAP_CODEC;
        }

        @Override
        public SpecialModelRenderer<?> bake(EntityModelSet p_386553_) {
            return new NetheriteTridentSpecialRenderer(new NetheriteTridentModel(p_386553_.bakeLayer(MTAModelLayers.NETHERITE_TRIDENT)));
        }
    }
}
