package com.fuyuaki.morethanadventure.world.item;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

import java.util.ArrayList;
import java.util.List;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class CoreStoneItem extends Item {
    private static final List<CoreStoneItem> CORE_STONES = new ArrayList<>();

    protected final Rarity rarity;
    private final String key;
    private final int color1;
    private final int color2;
    private final int color3;
    private final int color4;

    //Core Stone Colors are Hex Colors without the '#' or '0x'
    public CoreStoneItem(Rarity rarity, boolean cosmetic, String key, int color1, int color2, int color3, int color4) {
        super(new Properties().rarity(rarity).fireResistant().stacksTo(1)
                .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, !cosmetic)
        );
        CORE_STONES.add(this);

        this.rarity = rarity;
        this.key = key;
        this.color1 = color1;
        this.color2 = color2;
        this.color3 = color3;
        this.color4 = color4;
    }


    public int getColor(int pTintIndex) {
        return switch (pTintIndex){
            case 1 -> this.color2;
            case 2 -> this.color3;
            case 3 -> this.color4;
            default -> this.color1;
        };
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if (!pTooltipFlag.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("mtadesc.corestone.hover").withStyle(ChatFormatting.ITALIC).withStyle(ChatFormatting.DARK_GRAY));
        }
        else if (pTooltipFlag.hasShiftDown()){
            pTooltipComponents.add(Component.translatable("mtadesc.corestone." + this.key)
                    .withStyle(this.rarity.getStyleModifier()));
        }
    }

    @EventBusSubscriber(value = Dist.CLIENT, modid = MODID, bus = EventBusSubscriber.Bus.MOD)
    private static class ColorRegisterHandler {
        @SubscribeEvent(priority = EventPriority.HIGHEST)
        public static void registerSpawnEggColors(RegisterColorHandlersEvent.Item event) {
            CORE_STONES.forEach(gem -> event.register((stack, layer) -> FastColor.ARGB32.opaque(gem.getColor(layer)), gem));
        }
    }

}
