package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.CharredSkeletonModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.CharredSkeleton;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;

public class CharredSkeletonRenderer extends MobRenderer<CharredSkeleton, CharredSkeletonModel<CharredSkeleton>> {
    public CharredSkeletonRenderer(EntityRendererProvider.Context context, CharredSkeletonModel<CharredSkeleton> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Override
    public ResourceLocation getTextureLocation(CharredSkeleton entity) {
        return null;
    }
}
