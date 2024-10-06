package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.OctopusModel;
import com.fuyuaki.morethanadventure.world.entity.Octopus;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class OctopusRenderer extends MobRenderer<Octopus, OctopusModel> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/octopus.png");

    public OctopusRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new OctopusModel(pContext.bakeLayer(MTAModelLayers.OCTOPUS)), .5F);
    }


    @Override
    public ResourceLocation getTextureLocation(Octopus pEntity) {
        return TEXTURE;
    }
}
