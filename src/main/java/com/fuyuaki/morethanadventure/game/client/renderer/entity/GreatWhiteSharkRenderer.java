package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.GreatWhiteSharkModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.GreatWhiteShark;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class GreatWhiteSharkRenderer extends MobRenderer<GreatWhiteShark, GreatWhiteSharkModel> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/great_white_shark.png");

    public GreatWhiteSharkRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new GreatWhiteSharkModel(pContext.bakeLayer(MTAModelLayers.GREAT_WHITE_SHARK)), .5F);
    }


    @Override
    public ResourceLocation getTextureLocation(GreatWhiteShark pEntity) {
        return TEXTURE;
    }
}
