package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.ToxicZombieModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.ToxicZombie;
import net.minecraft.client.renderer.entity.DrownedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;

public class ToxicZombieRenderer extends MobRenderer<ToxicZombie, ToxicZombieModel<ToxicZombie>> {
    public ToxicZombieRenderer(EntityRendererProvider.Context context, ToxicZombieModel<ToxicZombie> model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Override
    public ResourceLocation getTextureLocation(ToxicZombie entity) {
        return null;
    }
}
