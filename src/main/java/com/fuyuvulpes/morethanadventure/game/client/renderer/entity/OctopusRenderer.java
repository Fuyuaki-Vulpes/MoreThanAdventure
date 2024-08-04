package com.fuyuvulpes.morethanadventure.game.client.renderer.entity;

import com.fuyuvulpes.morethanadventure.game.client.model.entity.OctopusModel;
import com.fuyuvulpes.morethanadventure.world.entity.Octopus;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class OctopusRenderer extends GeoEntityRenderer<Octopus> {
    public OctopusRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new OctopusModel());
    }
}
