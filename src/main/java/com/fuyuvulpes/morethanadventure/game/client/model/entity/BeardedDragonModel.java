package com.fuyuvulpes.morethanadventure.game.client.model.entity;

import com.fuyuvulpes.morethanadventure.core.MTAMod;
import com.fuyuvulpes.morethanadventure.world.entity.BeardedDragon;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class BeardedDragonModel extends DefaultedEntityGeoModel<BeardedDragon> {

    public BeardedDragonModel() {
        super(ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, "bearded_dragon"),true);
    }

    @Override
    public RenderType getRenderType(BeardedDragon animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }


}
