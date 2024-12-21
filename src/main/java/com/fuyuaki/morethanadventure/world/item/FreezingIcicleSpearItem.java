package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.world.item.weaponry.SpearItem;
import com.google.common.base.Suppliers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.function.Supplier;

public class FreezingIcicleSpearItem extends SpearItem {

    public FreezingIcicleSpearItem(ToolMaterial tier, Properties properties) {
        super(tier, properties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));

    }


    public static ItemAttributeModifiers createAttributes(ToolMaterial p_330371_) {
        return createAttributes(p_330371_, 5.0F, -2.6F, 5.2F);
    }


    @Override
    public int getEnchantmentValue() {
        return 21;
    }
}
