package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.WispflyModel;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.layers.WispflyOuterLayer;
import com.fuyuaki.morethanadventure.world.entity.Wispfly;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class WispflyRenderer<T extends Wispfly> extends MobRenderer<T, WispflyModel<T>> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/wispfly.png");

    public WispflyRenderer(EntityRendererProvider.Context context) {
        super(context,new WispflyModel<>(context.bakeLayer(MTAModelLayers.WISPFLY)), .1F);
        this.addLayer(new WispflyOuterLayer<>(this, context.getModelSet()));
    }



    @Nullable
    @Override
    protected RenderType getRenderType(T livingEntity, boolean bodyVisible, boolean translucent, boolean glowing) {
        return RenderType.entityCutout(TEXTURE);
    }

    @Override
    public ResourceLocation getTextureLocation(T entity) {
        return TEXTURE;
    }
}
