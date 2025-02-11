package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.JellyfishModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.JellyfishRenderState;
import com.fuyuaki.morethanadventure.world.entity.Jellyfish;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class JellyfishRenderer extends MobRenderer<Jellyfish, JellyfishRenderState, JellyfishModel<JellyfishRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/jellyfish.png");

    public JellyfishRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new JellyfishModel<>(pContext.bakeLayer(MTAModelLayers.JELLYFISH)), .5F);
    }


    @Override
    public JellyfishRenderState createRenderState() {
        return new JellyfishRenderState();
    }

    @Override
    public void extractRenderState(Jellyfish jellyfish, JellyfishRenderState state, float v) {
        super.extractRenderState(jellyfish, state, v);

        state.tentacleAngle = Mth.lerp(v, jellyfish.oldTentacleAngle, jellyfish.tentacleAngle);
        state.xBodyRot = Mth.lerp(v, jellyfish.xBodyRotO, jellyfish.xBodyRot);
        state.zBodyRot = Mth.lerp(v, jellyfish.zBodyRotO, jellyfish.zBodyRot);
    }

    @Override
    protected void setupRotations(JellyfishRenderState renderState, PoseStack poseStack, float bodyRot, float scale) {
        poseStack.translate(0.0F, renderState.isBaby ? 0.25F : 0.5F, 0.0F);
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - bodyRot));
        poseStack.mulPose(Axis.XP.rotationDegrees(renderState.xBodyRot));
        poseStack.mulPose(Axis.YP.rotationDegrees(renderState.zBodyRot));
        poseStack.translate(0.0F, renderState.isBaby ? -0.6F : -1.2F, 0.0F);
    }

    @Override
    public ResourceLocation getTextureLocation(JellyfishRenderState renderState) {
        return TEXTURE;
    }
}
