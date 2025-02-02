package com.fuyuaki.morethanadventure.game.client.gui;

import com.fuyuaki.morethanadventure.world.entity.attachments.SoulCharge;
import com.fuyuaki.morethanadventure.world.entity.attachments.helper.MTASoulHelper;
import com.fuyuaki.morethanadventure.world.item.weaponry.ArcheryItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

@OnlyIn(Dist.CLIENT)

public class MTAGui {
    private static final ResourceLocation SOUL_EMPTY = getHudSprite("soul_0");
    private static final ResourceLocation SOUL_1 = getHudSprite("soul_1");
    private static final ResourceLocation SOUL_2 = getHudSprite("soul_2");
    private static final ResourceLocation SOUL_3 = getHudSprite("soul_3");
    private static final ResourceLocation SOUL_4 = getHudSprite("soul_4");
    private static final ResourceLocation SOUL_5 = getHudSprite("soul_5");
    private static final ResourceLocation SOUL_6 = getHudSprite("soul_6");
    private static final ResourceLocation SOUL_7 = getHudSprite("soul_7");
    private static final ResourceLocation SOUL_8 = getHudSprite("soul_8");
    private static final ResourceLocation SOUL_9 = getHudSprite("soul_9");
    private static final ResourceLocation SOUL_10 = getHudSprite("soul_10");
    private static final ResourceLocation SOUL_11 = getHudSprite("soul_11");
    private static final ResourceLocation SOUL_12 = getHudSprite("soul_12");
    private static final ResourceLocation SOUL_13 = getHudSprite("soul_13");
    private static final ResourceLocation SOUL_14 = getHudSprite("soul_14");
    private static final ResourceLocation SOUL_OVERLAY = getHudSprite("soul_wheel");
    private static final List<ResourceLocation> soulOverlays = List.of( SOUL_EMPTY,
            SOUL_1,SOUL_2,SOUL_3,SOUL_4,SOUL_5,SOUL_6,SOUL_7,SOUL_8,SOUL_9,SOUL_10,
            SOUL_11,SOUL_12,SOUL_13,SOUL_14

    );

    private static final ResourceLocation ARROW_CHARGE_BACKGROUND = getHudSprite("arrow_charge_background");
    private static final ResourceLocation ARROW_CHARGE_PROGRESS = getHudSprite("arrow_charge_progress");
    private static final ResourceLocation ARROW_CHARGE_FULL = getHudSprite("arrow_charge_full");


    public static void renderGui(Player player, GuiGraphics guiGraphics){
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.options.hideGui){
            return;
        }
        int width = guiGraphics.guiWidth();
        int halfWidth = width / 2;
        int height = guiGraphics.guiHeight();
        int halfHeight = height / 2;

        int soulX = halfWidth + 98;
        int soulY = height - 20;


        SoulCharge soulCharge = MTASoulHelper.getPlayerSoulCharge(player);
        int soulChargeFraction = soulCharge.getMaxCharge() / 14;
        int soulChargeBit = (int) (soulCharge.getCharge() / soulChargeFraction);
        if (soulCharge.getIncomingChargeAdditive() > 0){
            String s = soulCharge.getIncomingChargeAdditive() + "+";
            guiGraphics.drawString(Minecraft.getInstance().font, s,soulX + 8,soulY - 12, 0x92fbde);
        }
        guiGraphics.blitSprite(RenderType::guiTextured, SOUL_EMPTY, soulX, soulY,16,16);

        if (soulChargeBit > 0){
            ResourceLocation location = soulOverlays.get(soulChargeBit);
            guiGraphics.blitSprite(RenderType::guiTextured, location, soulX, soulY,16,16);
        }
        guiGraphics.blitSprite(RenderType::guiTextured, SOUL_OVERLAY, soulX, soulY,16,16);


//        String s = soulCharge.getCharge() + "";
//        guiGraphics.drawCenteredString(Minecraft.getInstance().font,s,soulX + 16 + 1,soulY + 8,0xffffff);

        if (player.isUsingItem()){
            ItemStack stack = player.getItemInHand(InteractionHand.MAIN_HAND);
            if (stack.getItem() instanceof BowItem bowItem){
                int i = bowItem.getUseDuration(stack, player) - player.getUseItemRemainingTicks();


                int bowY = guiGraphics.guiHeight() / 2 - 7 + 16;
                int bowX = guiGraphics.guiWidth() / 2 - 8;

                guiGraphics.blitSprite(RenderType::crosshair,ARROW_CHARGE_BACKGROUND,bowX, bowY,18,5);
                float charge = BowItem.getPowerForTime(i);
                if (charge >= 1.0F){
                    guiGraphics.blitSprite(RenderType::crosshair,ARROW_CHARGE_FULL,bowX, bowY,18,5);

                }else {
                    int l = (int)(charge * 19.0F);
                    guiGraphics.blitSprite(RenderType::crosshair, ARROW_CHARGE_PROGRESS, 18, 5, 0, 0, bowX, bowY, l, 5);

                }
            }else if (stack.getItem() instanceof ArcheryItem bowItem){
                int i = bowItem.getUseDuration(stack, player) - player.getUseItemRemainingTicks();


                int bowY = guiGraphics.guiHeight() / 2 - 7 + 16;
                int bowX = guiGraphics.guiWidth() / 2 - 8;

                guiGraphics.blitSprite(RenderType::crosshair,ARROW_CHARGE_BACKGROUND,bowX, bowY,18,5);
                float charge = BowItem.getPowerForTime(i);
                if (charge >= 1.0F){
                    guiGraphics.blitSprite(RenderType::crosshair,ARROW_CHARGE_FULL,bowX, bowY,18,5);

                }else {
                    int l = (int)(charge * 19.0F);
                    guiGraphics.blitSprite(RenderType::crosshair, ARROW_CHARGE_PROGRESS, 18, 5, 0, 0, bowX, bowY, l, 5);

                }
            }
        }
    }

    public static ResourceLocation getHudSprite(String sprite){
        return ResourceLocation.fromNamespaceAndPath(MODID,"hud/" + sprite);
    }


}
