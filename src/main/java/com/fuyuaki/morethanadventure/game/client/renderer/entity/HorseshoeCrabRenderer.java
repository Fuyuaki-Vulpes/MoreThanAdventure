package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.HorseshoeCrabModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.HorseshoeCrab;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class HorseshoeCrabRenderer extends MobRenderer<HorseshoeCrab, HorseshoeCrabModel> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/horseshoe_crab.png");

    public HorseshoeCrabRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new HorseshoeCrabModel(pContext.bakeLayer(MTAModelLayers.HORSESHOE_CRAB)), .5F);
    }


    @Override
    public ResourceLocation getTextureLocation(HorseshoeCrab pEntity) {
        return TEXTURE;
    }
}
