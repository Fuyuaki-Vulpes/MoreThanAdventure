package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.SirenModel;
import com.fuyuaki.morethanadventure.world.entity.Siren;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class SirenRenderer extends MobRenderer<Siren, SirenModel<Siren>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/siren.png");

    public SirenRenderer(EntityRendererProvider.Context context) {
        super(context, new SirenModel<>(context.bakeLayer(MTAModelLayers.SIREN)), .5F);
    }

    @Override
    public ResourceLocation getTextureLocation(Siren entity) {
        return TEXTURE;
    }
}
