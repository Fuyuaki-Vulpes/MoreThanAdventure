package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import com.google.common.base.Suppliers;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.function.Supplier;

public class BerserkerBattleAxeItem extends SwordItem {
    private final Supplier<ItemAttributeModifiers> attributeModifiers;


    public BerserkerBattleAxeItem(Tier pTier, Properties pProperties) {
        super(pTier, pProperties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));
        this.attributeModifiers = Suppliers.memoize(
                () -> {
                    ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
                    ResourceLocation location = ResourceLocation.withDefaultNamespace("battleaxe");

                    return createAttributeModifiers(pTier,builder).build();
                }
        );
    }

    protected ItemAttributeModifiers.Builder createAttributeModifiers(Tier pTier, ItemAttributeModifiers.Builder builder){
        ResourceLocation location = ResourceLocation.withDefaultNamespace("battleaxe");


        builder.add(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(location, 8 + pTier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(location, -2.7F, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                Attributes.ENTITY_INTERACTION_RANGE,
                new AttributeModifier(location, 0.5F, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                Attributes.BLOCK_INTERACTION_RANGE,
                new AttributeModifier(location, 0.5F, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                ALObjects.Attributes.ARMOR_SHRED,
                new AttributeModifier(location, 0.2F, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                ALObjects.Attributes.CRIT_CHANCE,
                new AttributeModifier(location, 0.2F, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                ALObjects.Attributes.CRIT_DAMAGE,
                new AttributeModifier(location, 1.2F, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        return builder;
    }


    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return this.attributeModifiers.get();
    }

    @Override
    public int getEnchantmentValue() {
        return 17;

    }
}
