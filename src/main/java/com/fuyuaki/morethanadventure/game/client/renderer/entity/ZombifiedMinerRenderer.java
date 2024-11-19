package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.ZombifiedMinerModel;
import com.fuyuaki.morethanadventure.world.entity.ZombifiedMiner;
import net.minecraft.client.renderer.entity.AbstractZombieRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class ZombifiedMinerRenderer extends AbstractZombieRenderer<ZombifiedMiner, ZombifiedMinerModel<ZombifiedMiner>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/zombified_miner.png");

    public ZombifiedMinerRenderer(EntityRendererProvider.Context context) {
        super(
                context,
                new ZombifiedMinerModel<>(context.bakeLayer(MTAModelLayers.ZOMBIFIED_MINER)),
                new ZombifiedMinerModel<>(context.bakeLayer(MTAModelLayers.ZOMBIFIED_MINER_INNER_ARMOR)),
                new ZombifiedMinerModel<>(context.bakeLayer(MTAModelLayers.ZOMBIFIED_MINER_OUTER_ARMOR))
        );
    }

    @Override
    public ResourceLocation getTextureLocation(ZombifiedMiner entity) {
        return TEXTURE;
    }
}
