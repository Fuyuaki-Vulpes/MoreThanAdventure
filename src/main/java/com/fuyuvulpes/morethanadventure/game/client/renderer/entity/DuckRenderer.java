package com.fuyuvulpes.morethanadventure.game.client.renderer.entity;

import com.fuyuvulpes.morethanadventure.game.client.model.entity.DuckModel;
import com.fuyuvulpes.morethanadventure.world.entity.Duck;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class DuckRenderer extends GeoEntityRenderer<Duck> {
    public DuckRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new DuckModel());
    }
}
