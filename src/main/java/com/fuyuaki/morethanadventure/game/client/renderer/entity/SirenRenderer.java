package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.SirenModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.SirenRenderState;
import com.fuyuaki.morethanadventure.world.entity.Siren;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class SirenRenderer extends MobRenderer<Siren, SirenRenderState, SirenModel<SirenRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/siren.png");

    public SirenRenderer(EntityRendererProvider.Context context) {
        super(context, new SirenModel<>(context.bakeLayer(MTAModelLayers.SIREN)), .5F);
    }

    @Override
    public SirenRenderState createRenderState() {
        return null;
    }

    @Override
    public ResourceLocation getTextureLocation(SirenRenderState renderState) {
        return TEXTURE;
    }
}
