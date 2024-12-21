package com.fuyuaki.morethanadventure.core.registry;


import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.TriState;
import org.spongepowered.asm.mixin.Shadow;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;
import static net.minecraft.client.renderer.RenderStateShard.NAUSEA_OVERLAY_TRANSPARENCY;
import static net.minecraft.client.renderer.RenderStateShard.POSITION_TEXTURE_COLOR_SHADER;

public abstract class MTARenderTypes extends RenderType {

    private static final ResourceLocation STUN_LOCATION = ResourceLocation.fromNamespaceAndPath(MODID,"textures/misc/stun.png");




    public static final RenderStateShard.TransparencyStateShard STUN_OVERLAY_TRANSPARENCY = new RenderStateShard.TransparencyStateShard(
            "nausea_overlay_transparency",
            () -> {
                RenderSystem.enableBlend();
                RenderSystem.blendFuncSeparate(
                        GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE
                );
            },
            () -> {
                RenderSystem.disableBlend();
                RenderSystem.defaultBlendFunc();
            }
    );




    public static final RenderType.CompositeRenderType GUI_STUN_OVERLAY = RenderType.create(
            "gui_nausea_overlay",
            DefaultVertexFormat.POSITION_TEX_COLOR,
            VertexFormat.Mode.QUADS,
            1536,
            RenderType.CompositeState.builder()
                    .setTextureState(new RenderStateShard.TextureStateShard(STUN_LOCATION, TriState.DEFAULT, false))
                    .setShaderState(POSITION_TEXTURE_COLOR_SHADER)
                    .setTransparencyState(STUN_OVERLAY_TRANSPARENCY)
                    .setDepthTestState(NO_DEPTH_TEST)
                    .setWriteMaskState(COLOR_WRITE)
                    .createCompositeState(false)
    );



    public static RenderType getStunOverlay() {
        return GUI_STUN_OVERLAY;
    }

    public MTARenderTypes(String name, VertexFormat format, VertexFormat.Mode mode, int bufferSize, boolean affectsCrumbling, boolean sortOnUpload, Runnable setupState, Runnable clearState) {
        super(name, format, mode, bufferSize, affectsCrumbling, sortOnUpload, setupState, clearState);
    }
}
