package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.world.item.weaponry.SpearItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;

public class FreezingIcicleSpearItem extends SpearItem {

    public FreezingIcicleSpearItem(ToolMaterial tier, Properties properties) {
        super(tier, properties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));

    }


    public static ItemAttributeModifiers createAttributes(ToolMaterial p_330371_) {
        return createAttributes(p_330371_, 5.0F, -2.6F, 5.2F);
    }

}
