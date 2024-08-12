package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.ShrimpModel;
import com.fuyuaki.morethanadventure.world.entity.Shrimp;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ShrimpRenderer extends GeoEntityRenderer<Shrimp> {
    public ShrimpRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ShrimpModel());
    }
}
