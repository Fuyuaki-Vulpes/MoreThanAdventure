package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.SkeletonFighterModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.SkeletonFighter;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.client.renderer.entity.WitherSkeletonRenderer;
import net.minecraft.resources.ResourceLocation;

public class SkeletonFighterRenderer extends MobRenderer<SkeletonFighter, SkeletonFighterModel<SkeletonFighter>> {
    public SkeletonFighterRenderer(EntityRendererProvider.Context context, SkeletonFighterModel<SkeletonFighter> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Override
    public ResourceLocation getTextureLocation(SkeletonFighter entity) {
        return null;
    }
}
