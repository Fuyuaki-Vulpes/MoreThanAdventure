package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.BlackWidowModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.MossyZombieModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.MossyZombie;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MossyZombieRenderer extends HumanoidMobRenderer<MossyZombie, MossyZombieModel<MossyZombie>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/mossy_zombie.png");

    public MossyZombieRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new MossyZombieModel<>(pContext.bakeLayer(MTAModelLayers.MOSSY_ZOMBIE)), .5F);

    }

    @Override
    public ResourceLocation getTextureLocation(MossyZombie entity) {
        return TEXTURE;
    }
}
