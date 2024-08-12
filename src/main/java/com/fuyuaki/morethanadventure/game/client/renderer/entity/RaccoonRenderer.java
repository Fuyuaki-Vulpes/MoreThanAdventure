package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.RaccoonModel;
import com.fuyuaki.morethanadventure.world.entity.Raccoon;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RaccoonRenderer extends GeoEntityRenderer<Raccoon> {
    public RaccoonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RaccoonModel());
    }
}
