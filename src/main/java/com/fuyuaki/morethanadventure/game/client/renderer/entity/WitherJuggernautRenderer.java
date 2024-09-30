package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.FallenSamuraiModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.WitherJuggernautModel;
import com.fuyuaki.morethanadventure.world.entity.FallenSamurai;
import com.fuyuaki.morethanadventure.world.entity.WitherJuggernaut;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class WitherJuggernautRenderer extends MobRenderer<WitherJuggernaut, WitherJuggernautModel> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/wither_juggernaut.png");

    public WitherJuggernautRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new WitherJuggernautModel(pContext.bakeLayer(MTAModelLayers.WITHER_JUGGERNAUT)), 1F);
    }


    @Override
    public ResourceLocation getTextureLocation(WitherJuggernaut pEntity) {
        return TEXTURE;
    }

}