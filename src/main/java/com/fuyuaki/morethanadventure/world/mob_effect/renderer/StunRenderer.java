package com.fuyuaki.morethanadventure.world.mob_effect.renderer;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class StunRenderer {
    private static final ResourceLocation STUN_LOCATION = ResourceLocation.fromNamespaceAndPath(MODID,"textures/misc/stun.png");

    public static void render(Minecraft minecraft, RenderBuffers renderBuffers, GuiGraphics guiGraphics, float partialTick) {
        assert minecraft.player != null;

        float p = (minecraft.player.tickCount + partialTick) / 300;
        int i = guiGraphics.guiWidth();
        int j = guiGraphics.guiHeight();
        guiGraphics.pose().pushPose();
        float f = 1.0F;
        guiGraphics.pose().translate((float)i / 2.0F, (float)j / 2.0F, 0.0F);
        guiGraphics.pose().scale(f, f, f);
        guiGraphics.pose().translate((float)(-i) / 2.0F, (float)(-j) / 2.0F, 0.0F);
        float f1 = Mth.abs(Mth.cos(p));
        float f2 = Mth.abs(Mth.sin(p * 2 - 2));
        float f3 = Mth.abs(Mth.sin(p * 2 - 4));
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.blendFuncSeparate(
                GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE
        );
        guiGraphics.setColor(f1 / 3, f2 / 3, f3 / 3, 0.8F);
        guiGraphics.blit(STUN_LOCATION, 0, 0, -90, 0.0F, 0.0F, i, j, i, j);
        guiGraphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.defaultBlendFunc();
        RenderSystem.disableBlend();
        RenderSystem.depthMask(true);
        RenderSystem.enableDepthTest();
        guiGraphics.pose().popPose();
    }
}
