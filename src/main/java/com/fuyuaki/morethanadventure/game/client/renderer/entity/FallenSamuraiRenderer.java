package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.FallenSamuraiModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.FallenSamurai;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class FallenSamuraiRenderer extends MobRenderer<FallenSamurai, FallenSamuraiModel> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/fallen_samurai.png");

    public FallenSamuraiRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new FallenSamuraiModel(pContext.bakeLayer(MTAModelLayers.FALLEN_SAMURAI)), .5F);
    }


    @Override
    public ResourceLocation getTextureLocation(FallenSamurai pEntity) {
        return TEXTURE;
    }

}
