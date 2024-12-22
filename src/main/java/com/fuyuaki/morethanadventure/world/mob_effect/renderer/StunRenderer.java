package com.fuyuaki.morethanadventure.world.mob_effect.renderer;

import com.fuyuaki.morethanadventure.core.registry.MTARenderTypes;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderBuffers;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.ARGB;
import net.minecraft.util.Mth;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class StunRenderer {
    private static final ResourceLocation STUN_LOCATION = ResourceLocation.fromNamespaceAndPath(MODID,"textures/misc/stun.png");

    public static void render(Minecraft minecraft, GuiGraphics guiGraphics, float partialTick) {
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

        guiGraphics.blit(renderType -> MTARenderTypes.getStunOverlay() ,STUN_LOCATION, 0, 0, 0.0F, 0.0F, i, j, i, j, ARGB.colorFromFloat(1.0F, f1 / 3, f2 / 3, f3 / 3));

        guiGraphics.pose().popPose();
    }
}
