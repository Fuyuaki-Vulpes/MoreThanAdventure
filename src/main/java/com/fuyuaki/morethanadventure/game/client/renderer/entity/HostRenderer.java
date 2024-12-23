package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.HostModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.HostRenderState;
import com.fuyuaki.morethanadventure.world.entity.Host;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class HostRenderer extends MobRenderer<Host, HostRenderState, HostModel<HostRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/host.png");

    public HostRenderer(EntityRendererProvider.Context context) {
        super(context, new HostModel<>(context.bakeLayer(MTAModelLayers.HOST)), 1F);
    }

    @Override
    public HostRenderState createRenderState() {
        return null;
    }

    @Override
    public ResourceLocation getTextureLocation(HostRenderState renderState) {
        return TEXTURE;
    }
}