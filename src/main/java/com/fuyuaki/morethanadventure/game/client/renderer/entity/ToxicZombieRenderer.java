package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.ToxicZombieModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.ToxicZombieRenderState;
import com.fuyuaki.morethanadventure.world.entity.ToxicZombie;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class ToxicZombieRenderer extends AbstractZombieRenderer<ToxicZombie, ToxicZombieRenderState, ToxicZombieModel<ToxicZombieRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/zombie/toxic_zombie.png");

    public ToxicZombieRenderer(EntityRendererProvider.Context context) {
        super(
            context,
            new ToxicZombieModel<>(context.bakeLayer(MTAModelLayers.TOXIC_ZOMBIE)),
            new ToxicZombieModel<>(context.bakeLayer(MTAModelLayers.TOXIC_ZOMBIE_BABY)),
            new ToxicZombieModel<>(context.bakeLayer(MTAModelLayers.TOXIC_ZOMBIE_INNER_ARMOR)),
            new ToxicZombieModel<>(context.bakeLayer(MTAModelLayers.TOXIC_ZOMBIE_OUTER_ARMOR)),
            new ToxicZombieModel<>(context.bakeLayer(MTAModelLayers.TOXIC_ZOMBIE_BABY_INNER_ARMOR)),
            new ToxicZombieModel<>(context.bakeLayer(MTAModelLayers.TOXIC_ZOMBIE_BABY_OUTER_ARMOR))
    );
    }

    @Override
    public ToxicZombieRenderState createRenderState() {
        return new ToxicZombieRenderState();
    }

    @Override
    public ResourceLocation getTextureLocation(ToxicZombieRenderState entity) {
        return TEXTURE;
    }
}
