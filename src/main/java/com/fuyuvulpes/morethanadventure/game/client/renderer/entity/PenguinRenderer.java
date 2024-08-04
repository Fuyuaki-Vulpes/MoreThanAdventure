package com.fuyuvulpes.morethanadventure.game.client.renderer.entity;

import com.fuyuvulpes.morethanadventure.game.client.model.entity.PenguinModel;
import com.fuyuvulpes.morethanadventure.world.entity.Penguin;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PenguinRenderer extends GeoEntityRenderer<Penguin> {
    public PenguinRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PenguinModel());
    }
}
