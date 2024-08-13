package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.ToucanModel;
import com.fuyuaki.morethanadventure.world.entity.Toucan;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ToucanRenderer extends GeoEntityRenderer<Toucan> {
    public ToucanRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ToucanModel());
    }
}