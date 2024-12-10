package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.MossyZombieModel;
import com.fuyuaki.morethanadventure.world.entity.MossyZombie;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MossyZombieRenderer extends AbstractZombieRenderer<MossyZombie, MossyZombieModel<MossyZombie>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/mossy_zombie.png");

    public MossyZombieRenderer(EntityRendererProvider.Context context) {
        super(
            context,
            new MossyZombieModel<>(context.bakeLayer(MTAModelLayers.MOSSY_ZOMBIE)),
            new MossyZombieModel<>(context.bakeLayer(MTAModelLayers.MOSSY_ZOMBIE_INNER_ARMOR)),
            new MossyZombieModel<>(context.bakeLayer(MTAModelLayers.MOSSY_ZOMBIE_OUTER_ARMOR))
    );

    }

    @Override
    public ResourceLocation getTextureLocation(MossyZombie entity) {
        return TEXTURE;
    }
}
