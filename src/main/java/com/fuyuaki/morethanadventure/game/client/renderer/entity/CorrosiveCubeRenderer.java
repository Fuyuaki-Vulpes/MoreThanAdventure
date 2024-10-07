package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.BlackWidowModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.CorrosiveCubeModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.CorrosiveCube;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MagmaCubeRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Slime;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class CorrosiveCubeRenderer extends MobRenderer<CorrosiveCube, CorrosiveCubeModel<CorrosiveCube>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/corrosive_cube.png");

    public CorrosiveCubeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new CorrosiveCubeModel(pContext.bakeLayer(MTAModelLayers.CORROSIVE_CUBE)), .5F);
    }

    @Override
    public ResourceLocation getTextureLocation(CorrosiveCube entity) {
        return TEXTURE;
    }
}
