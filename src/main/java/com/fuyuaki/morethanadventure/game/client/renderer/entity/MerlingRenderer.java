package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.JellyfishModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.MerlingModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.YukiOnnaModel;
import com.fuyuaki.morethanadventure.world.entity.Merling;
import com.fuyuaki.morethanadventure.world.entity.YukiOnna;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MerlingRenderer extends MobRenderer<Merling, MerlingModel<Merling>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/merling.png");

    public MerlingRenderer(EntityRendererProvider.Context context) {
        super(context, new MerlingModel<>(context.bakeLayer(MTAModelLayers.MERLING)), .5F);
    }

    @Override
    public ResourceLocation getTextureLocation(Merling entity) {
        return TEXTURE;
    }
}
