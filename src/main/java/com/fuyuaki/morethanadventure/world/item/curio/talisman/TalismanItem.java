package com.fuyuaki.morethanadventure.world.item.curio.talisman;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class TalismanItem extends Item {

    public TalismanItem(Properties properties) {
        super(properties.stacksTo(1).fireResistant());
    }


//    @Override
//    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
//        return true;
//    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (tooltipFlag.hasShiftDown()){
            tooltipComponents.add(Component.translatable("mta.talisman.description." + BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath()));
        }else{
            tooltipComponents.add(Component.translatable("mta.talisman.description.hint").withStyle(ChatFormatting.GOLD).withStyle(ChatFormatting.BOLD));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
