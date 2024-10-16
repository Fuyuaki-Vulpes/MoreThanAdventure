package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.WitherJuggernautModel;
import com.fuyuaki.morethanadventure.world.entity.WitherJuggernaut;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class WitherJuggernautRenderer extends MobRenderer<WitherJuggernaut, WitherJuggernautModel<WitherJuggernaut>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/wither_juggernaut.png");

    public WitherJuggernautRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new WitherJuggernautModel<>(pContext.bakeLayer(MTAModelLayers.WITHER_JUGGERNAUT)), 1F);
    }


    @Override
    public ResourceLocation getTextureLocation(WitherJuggernaut pEntity) {
        return TEXTURE;
    }

}