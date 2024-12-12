package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.world.item.weaponry.ScytheItem;
import com.google.common.base.Suppliers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.function.Supplier;

public class ReaperScytheItem extends ScytheItem {



    public ReaperScytheItem(Tier pTier, Properties pProperties) {
        super(pTier, pProperties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));

    }

    protected ItemAttributeModifiers.Builder createAttributeModifiers(Tier pTier, ItemAttributeModifiers.Builder builder){
        ResourceLocation location = ResourceLocation.withDefaultNamespace("scythe");


        builder.add(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(location, 5 + pTier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(location, -2.5F, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        return builder;
    }

    public static ItemAttributeModifiers createAttributes(Tier p_330371_) {
        return createAttributes(p_330371_, 5.0F, -2.4F, 4.7F);
    }




    @Override
    public int getEnchantmentValue() {
        return 21;
    }
}
