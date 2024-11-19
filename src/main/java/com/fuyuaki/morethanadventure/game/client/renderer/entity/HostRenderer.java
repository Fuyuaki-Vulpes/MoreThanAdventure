package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.BlackWidowModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.HostModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.MossyZombieModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.Host;
import com.fuyuaki.morethanadventure.world.entity.MossyZombie;
import net.minecraft.client.model.AbstractZombieModel;
import net.minecraft.client.model.DrownedModel;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.layers.DrownedOuterLayer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class HostRenderer extends AbstractZombieRenderer<Host, HostModel<Host>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/host.png");

    public HostRenderer(EntityRendererProvider.Context context) {
        super(
                context,
                new HostModel<>(context.bakeLayer(MTAModelLayers.HOST)),
                new HostModel<>(context.bakeLayer(MTAModelLayers.HOST_INNER_ARMOR)),
                new HostModel<>(context.bakeLayer(MTAModelLayers.HOST_OUTER_ARMOR))
        );
    }

    @Override
    public ResourceLocation getTextureLocation(Host entity) {
        return TEXTURE;
    }
}