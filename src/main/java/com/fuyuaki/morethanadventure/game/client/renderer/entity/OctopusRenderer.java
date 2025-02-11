package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.OctopusModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.JellyfishRenderState;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.OctopusRenderState;
import com.fuyuaki.morethanadventure.world.entity.Octopus;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class OctopusRenderer extends MobRenderer<Octopus, OctopusRenderState, OctopusModel<OctopusRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/octopus.png");

    public OctopusRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new OctopusModel<>(pContext.bakeLayer(MTAModelLayers.OCTOPUS)), .5F);
    }

    @Override
    public OctopusRenderState createRenderState() {
        return new OctopusRenderState();
    }

    @Override
    public void extractRenderState(Octopus octopus, OctopusRenderState state, float v) {
        super.extractRenderState(octopus,state,v);
        state.tentacleAngle = Mth.lerp(v, octopus.oldTentacleAngle, octopus.tentacleAngle);
        state.xBodyRot = Mth.lerp(v, octopus.xBodyRotO, octopus.xBodyRot);
    }

    @Override
    protected void setupRotations(OctopusRenderState renderState, PoseStack poseStack, float bodyRot, float scale) {
        poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - bodyRot));
        poseStack.mulPose(Axis.XP.rotationDegrees(renderState.xBodyRot));
    }

    @Override
    public ResourceLocation getTextureLocation(OctopusRenderState renderState) {
        return TEXTURE;
    }
}
