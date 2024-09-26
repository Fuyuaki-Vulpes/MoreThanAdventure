package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.IcicleCreeperModel;
import com.fuyuaki.morethanadventure.world.entity.IcicleCreeper;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class IcicleCreeperRenderer extends GeoEntityRenderer<IcicleCreeper> {
    public IcicleCreeperRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new IcicleCreeperModel());
    }
}
