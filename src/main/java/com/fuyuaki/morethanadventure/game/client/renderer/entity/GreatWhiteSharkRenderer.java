package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.GreatWhiteSharkModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.GreatWhiteSharkRenderState;
import com.fuyuaki.morethanadventure.world.entity.GreatWhiteShark;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.DolphinRenderState;
import net.minecraft.client.renderer.entity.state.HoldingEntityRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Dolphin;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class GreatWhiteSharkRenderer extends MobRenderer<GreatWhiteShark, GreatWhiteSharkRenderState, GreatWhiteSharkModel<GreatWhiteSharkRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/great_white_shark.png");

    public GreatWhiteSharkRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new GreatWhiteSharkModel<>(pContext.bakeLayer(MTAModelLayers.GREAT_WHITE_SHARK)), .5F);
    }

    @Override
    public GreatWhiteSharkRenderState createRenderState() {
        return new GreatWhiteSharkRenderState();
    }

    public void extractRenderState(GreatWhiteShark entity, GreatWhiteSharkRenderState renderState, float p_361483_) {
        super.extractRenderState(entity, renderState, p_361483_);
        renderState.isMoving = entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-7;
    }


    @Override
    public ResourceLocation getTextureLocation(GreatWhiteSharkRenderState renderState) {
        return TEXTURE;
    }
}
