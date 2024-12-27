package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.world.item.weaponry.SpearItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class FreezingIcicleSpearItem extends SpearItem {

    public FreezingIcicleSpearItem(ToolMaterial tier, Properties properties) {
        super(tier, properties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));

    }


}
