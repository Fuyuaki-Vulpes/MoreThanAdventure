package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.OwlModel;
import com.fuyuaki.morethanadventure.world.entity.Owl;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class OwlRenderer extends GeoEntityRenderer<Owl> {
    public OwlRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OwlModel());
    }
}
