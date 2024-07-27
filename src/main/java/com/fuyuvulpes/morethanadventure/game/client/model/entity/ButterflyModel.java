package com.fuyuvulpes.morethanadventure.game.client.model.entity;

import com.fuyuvulpes.morethanadventure.world.entity.Butterfly;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class ButterflyModel extends DefaultedEntityGeoModel<Butterfly> {
    public ButterflyModel() {
        super(ResourceLocation.fromNamespaceAndPath(MODID, "butterfly"));
    }

    @Override
    public ResourceLocation getTextureResource(Butterfly animatable) {
        return ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/butterfly/body.png");
    }


    @Override
    public @Nullable RenderType getRenderType(Butterfly animatable, ResourceLocation texture) {
        return RenderType.entityCutout(getTextureResource(animatable));
    }
}
