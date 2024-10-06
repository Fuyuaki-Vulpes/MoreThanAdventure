package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.BlackWidowModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.BlackWidow;
import net.minecraft.client.renderer.entity.CaveSpiderRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class BlackWidowRenderer extends MobRenderer<BlackWidow, BlackWidowModel<BlackWidow>> {

    public BlackWidowRenderer(EntityRendererProvider.Context context, BlackWidowModel<BlackWidow> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Override
    public ResourceLocation getTextureLocation(BlackWidow entity) {
        return null;
    }
}
