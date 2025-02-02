package com.fuyuaki.morethanadventure.world.inventory.screens;

import com.fuyuaki.morethanadventure.world.inventory.StoveMenu;
import io.wispforest.accessories.menu.variants.AccessoriesMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class StoveScreen extends AbstractContainerScreen<StoveMenu> {

    private static final ResourceLocation LOCATION = ResourceLocation.fromNamespaceAndPath(MODID,"textures/gui/container/stove.png");
    private static final ResourceLocation LIT_PROGRESS_SPRITE = ResourceLocation.fromNamespaceAndPath(MODID,"container/stove/lit_progress");



    public StoveScreen(StoveMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageHeight = 133;
        this.inventoryLabelY = this.imageHeight - 94;

    }


    @Override
    public void render(GuiGraphics p_282918_, int p_282102_, int p_282423_, float p_282621_) {
        super.render(p_282918_, p_282102_, p_282423_, p_282621_);
        //this.renderTooltip(p_282918_, p_282102_, p_282423_);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(RenderType::guiTextured, LOCATION, i, j, 0.0F, 0.0F, this.imageWidth, this.imageHeight, 256, 256);
        if (this.menu.isLit()) {
            int l = Mth.ceil(this.menu.getLitProgress() * 13.0F) + 1;
            guiGraphics.blitSprite(RenderType::guiTextured, LIT_PROGRESS_SPRITE, 14, 14, 0, 14 - l, i + 81, j + 3 + 14 - l, 14, l);
        }
    }
}
