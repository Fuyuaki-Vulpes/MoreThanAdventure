package com.fuyuvulpes.morethanadventure.game.client.renderer.entity;

import com.fuyuvulpes.morethanadventure.game.client.model.entity.YukiOnnaModel;
import com.fuyuvulpes.morethanadventure.world.entity.YukiOnna;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class YukiOnnaRenderer extends GeoEntityRenderer<YukiOnna> {
    public YukiOnnaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new YukiOnnaModel());
    }
}
