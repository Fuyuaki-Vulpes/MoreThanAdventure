package com.fuyuvulpes.morethanadventure.game.client.renderer.entity;

import com.fuyuvulpes.morethanadventure.game.client.model.entity.GreatWhiteSharkModel;
import com.fuyuvulpes.morethanadventure.world.entity.GreatWhiteShark;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GreatWhiteSharkRenderer extends GeoEntityRenderer<GreatWhiteShark> {
    public GreatWhiteSharkRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GreatWhiteSharkModel());
    }
}
