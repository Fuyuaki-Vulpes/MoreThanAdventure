package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.BlackWidowModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.HostModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.MossyZombieModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.Host;
import com.fuyuaki.morethanadventure.world.entity.MossyZombie;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.renderer.entity.DrownedRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class HostRenderer extends MobRenderer<Host, HostModel<Host>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/host.png");

    public HostRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new HostModel<>(pContext.bakeLayer(MTAModelLayers.MOSSY_ZOMBIE)), .5F);

    }

    @Override
    public ResourceLocation getTextureLocation(Host entity) {
        return TEXTURE;
    }
}