package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.JellyfishModel;
import com.fuyuaki.morethanadventure.world.entity.Jellyfish;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class JellyfishRenderer extends MobRenderer<Jellyfish, JellyfishModel<Jellyfish>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/jellyfish.png");

    public JellyfishRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new JellyfishModel(pContext.bakeLayer(MTAModelLayers.JELLYFISH)), .5F);
    }


    @Override
    public ResourceLocation getTextureLocation(Jellyfish pEntity) {
        return TEXTURE;
    }
}
