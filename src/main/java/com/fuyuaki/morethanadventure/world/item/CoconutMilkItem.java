package com.fuyuaki.morethanadventure.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;

public class CoconutMilkItem extends Item {
    public CoconutMilkItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack p_41452_) {
        return ItemUseAnimation.DRINK;
    }
}