package com.fuyuaki.morethanadventure.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.awt.*;
import java.util.Map;

public class FruitItem extends Item {
    private final int color;
    private static Map<Item,Integer> VANILLA_ITEMS = Map.of(Items.BEETROOT,0xcc4045,Items.SWEET_BERRIES,0xc9011d ,Items.CARROT,0xfcac5c);

    public FruitItem(Properties properties, int color) {
        super(properties);
        this.color = color;
    }

    public int getColor() {
        return color;
    }


    public static int getColorByItem(ItemStack itemStack){
        if (itemStack.getItem() instanceof FruitItem fruitItem){
            return fruitItem.getColor();
        }
        else return VANILLA_ITEMS.get(itemStack.getItem());
    }

    public static boolean validVegetable(ItemStack stack){
        return stack.getItem() instanceof FruitItem || VANILLA_ITEMS.containsKey(stack.getItem());
    }

}
