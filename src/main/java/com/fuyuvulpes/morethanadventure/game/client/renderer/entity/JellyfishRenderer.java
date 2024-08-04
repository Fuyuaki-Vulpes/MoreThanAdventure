package com.fuyuvulpes.morethanadventure.game.client.renderer.entity;

import com.fuyuvulpes.morethanadventure.game.client.model.entity.JellyfishModel;
import com.fuyuvulpes.morethanadventure.world.entity.Jellyfish;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class JellyfishRenderer extends GeoEntityRenderer<Jellyfish> {
    public JellyfishRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new JellyfishModel());
    }
}
