package com.fuyuvulpes.morethanadventure.game.client.renderer.block;

import com.fuyuvulpes.morethanadventure.game.client.model.block.SprinklerModel;
import com.fuyuvulpes.morethanadventure.world.block.entity.SprinklerEntity;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class SprinklerRenderer extends GeoBlockRenderer<SprinklerEntity> {
    public SprinklerRenderer() {
        super(new SprinklerModel());
    }
}
