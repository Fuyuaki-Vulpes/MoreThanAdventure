package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.BlackWidowModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.ZombifiedMinerModel;
import com.fuyuaki.morethanadventure.world.entity.ZombifiedMiner;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class ZombifiedMinerRenderer extends MobRenderer<ZombifiedMiner, ZombifiedMinerModel<ZombifiedMiner>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/zombified_miner.png");

    public ZombifiedMinerRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new ZombifiedMinerModel<>(pContext.bakeLayer(MTAModelLayers.ZOMBIFIED_MINER)), .5F);
    }

    @Override
    public ResourceLocation getTextureLocation(ZombifiedMiner entity) {
        return TEXTURE;
    }
}
