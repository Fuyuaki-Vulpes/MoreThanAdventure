package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.MossyZombieModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.MossyZombieRenderState;
import com.fuyuaki.morethanadventure.world.entity.MossyZombie;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MossyZombieRenderer extends AbstractZombieRenderer<MossyZombie, MossyZombieRenderState, MossyZombieModel<MossyZombieRenderState>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/zombie/mossy_zombie.png");

    public MossyZombieRenderer(EntityRendererProvider.Context context) {
        super(
            context,
            new MossyZombieModel<>(context.bakeLayer(MTAModelLayers.MOSSY_ZOMBIE)),
            new MossyZombieModel<>(context.bakeLayer(MTAModelLayers.MOSSY_ZOMBIE_BABY)),
            new MossyZombieModel<>(context.bakeLayer(MTAModelLayers.MOSSY_ZOMBIE_INNER_ARMOR)),
            new MossyZombieModel<>(context.bakeLayer(MTAModelLayers.MOSSY_ZOMBIE_OUTER_ARMOR)),
            new MossyZombieModel<>(context.bakeLayer(MTAModelLayers.MOSSY_ZOMBIE_BABY_INNER_ARMOR)),
            new MossyZombieModel<>(context.bakeLayer(MTAModelLayers.MOSSY_ZOMBIE_BABY_OUTER_ARMOR))
    );

    }

    @Override
    public MossyZombieRenderState createRenderState() {
        return new MossyZombieRenderState();
    }


    @Override
    public ResourceLocation getTextureLocation(MossyZombieRenderState renderState) {
        return TEXTURE;
    }
}
