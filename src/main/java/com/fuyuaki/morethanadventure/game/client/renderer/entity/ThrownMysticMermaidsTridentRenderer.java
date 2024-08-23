package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.MysticMermaidsTridentModel;
import com.fuyuaki.morethanadventure.world.entity.ThrownMysticMermaidsTrident;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ThrownMysticMermaidsTridentRenderer extends GeoEntityRenderer<ThrownMysticMermaidsTrident> {
    public ThrownMysticMermaidsTridentRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new MysticMermaidsTridentModel());
    }
}
