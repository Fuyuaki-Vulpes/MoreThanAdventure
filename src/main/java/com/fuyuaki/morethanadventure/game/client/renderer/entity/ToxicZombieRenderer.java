package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.BlackWidowModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.ToxicZombieModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.ToxicZombie;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.renderer.entity.DrownedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class ToxicZombieRenderer extends MobRenderer<ToxicZombie, ToxicZombieModel<ToxicZombie>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/toxic_zombie.png");

    public ToxicZombieRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new ToxicZombieModel(pContext.bakeLayer(MTAModelLayers.TOXIC_ZOMBIE)), .5F);
    }

    @Override
    public ResourceLocation getTextureLocation(ToxicZombie entity) {
        return TEXTURE;
    }
}
