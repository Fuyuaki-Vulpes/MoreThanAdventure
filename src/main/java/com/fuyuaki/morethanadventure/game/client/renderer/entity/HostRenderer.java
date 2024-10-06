package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.HostModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.Host;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HuskRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HostRenderer extends MobRenderer<Host, HostModel<Host>> {
    public HostRenderer(EntityRendererProvider.Context context, HostModel<Host> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Override
    public ResourceLocation getTextureLocation(Host entity) {
        return null;
    }
}
