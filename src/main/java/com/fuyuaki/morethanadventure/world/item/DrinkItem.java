package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.core.deferred_registries.MTAComponents;
import com.fuyuaki.morethanadventure.world.item.component.CraftableDrink;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.FireworkExplosion;

import java.util.List;

public class DrinkItem extends Item {
    private int color = 0xffffff;
    public DrinkItem(Properties properties) {
        super(properties);
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        CraftableDrink craftableDrink = stack.get(MTAComponents.CRAFTABLE_DRINK);
        craftableDrink.addToTooltip(context,tooltipComponents::add,tooltipFlag);
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
