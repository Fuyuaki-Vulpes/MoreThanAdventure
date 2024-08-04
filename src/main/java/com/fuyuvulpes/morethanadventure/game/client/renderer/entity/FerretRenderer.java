package com.fuyuvulpes.morethanadventure.game.client.renderer.entity;

import com.fuyuvulpes.morethanadventure.game.client.model.entity.FerretModel;
import com.fuyuvulpes.morethanadventure.world.entity.Ferret;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FerretRenderer extends GeoEntityRenderer<Ferret> {
    public FerretRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FerretModel());
    }
}
