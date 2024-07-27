package com.fuyuvulpes.morethanadventure.game.client.renderer.entity;

import com.fuyuvulpes.morethanadventure.game.client.model.entity.FallenSamuraiModel;
import com.fuyuvulpes.morethanadventure.world.entity.FallenSamurai;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FallenSamuraiRenderer  extends GeoEntityRenderer<FallenSamurai> {
    public FallenSamuraiRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FallenSamuraiModel());
    }
}
