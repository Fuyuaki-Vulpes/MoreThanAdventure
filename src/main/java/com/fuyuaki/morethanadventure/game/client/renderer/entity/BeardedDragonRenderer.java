package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class BeardedDragonRenderer extends GeoEntityRenderer<BeardedDragon> {
    public BeardedDragonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new BeardedDragonModel());
    }
}
