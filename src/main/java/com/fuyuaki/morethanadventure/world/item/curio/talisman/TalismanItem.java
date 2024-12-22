package com.fuyuaki.morethanadventure.world.item.curio.talisman;

import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class TalismanItem extends Item implements ICurioItem {

    public TalismanItem(Properties properties) {
        super(properties.stacksTo(1).fireResistant());
    }


    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return true;
    }

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
