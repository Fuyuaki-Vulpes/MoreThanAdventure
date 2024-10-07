package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.BeardedDragonModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.BlackWidowModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.FrozenSlimeModel;
import com.fuyuaki.morethanadventure.world.entity.BeardedDragon;
import com.fuyuaki.morethanadventure.world.entity.FrozenSlime;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MagmaCubeRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.SlimeRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Slime;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class FrozenSlimeRenderer extends MobRenderer<FrozenSlime, FrozenSlimeModel<FrozenSlime>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/frozen_slime.png");

    public FrozenSlimeRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new FrozenSlimeModel(pContext.bakeLayer(MTAModelLayers.FROZEN_SLIME)), .5F);
    }

    @Override
    public ResourceLocation getTextureLocation(FrozenSlime entity) {
        return TEXTURE;
    }
}
