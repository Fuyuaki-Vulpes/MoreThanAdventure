package com.fuyuvulpes.morethanadventure.game.client.renderer.entity;

import com.fuyuvulpes.morethanadventure.game.client.model.entity.HorseshoeCrabModel;
import com.fuyuvulpes.morethanadventure.world.entity.HorseshoeCrab;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class HorseshoeCrabRenderer extends GeoEntityRenderer<HorseshoeCrab> {
    public HorseshoeCrabRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HorseshoeCrabModel());
    }
}
