package com.fuyuaki.morethanadventure.game.client.model.block;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.world.block.entity.SprinklerEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

public class SprinklerModel extends DefaultedBlockGeoModel<SprinklerEntity> {

    public SprinklerModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "sprinkler"));
    }

    @Override
    public RenderType getRenderType(SprinklerEntity animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }




}
