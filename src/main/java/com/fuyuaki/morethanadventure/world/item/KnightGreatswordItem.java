package com.fuyuaki.morethanadventure.world.item;

import com.google.common.base.Suppliers;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.function.Supplier;

public class KnightGreatswordItem extends SwordItem {

    private final Supplier<ItemAttributeModifiers> attributeModifiers;


    public KnightGreatswordItem(Tier pTier, Properties pProperties) {
        super(pTier, pProperties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));
        this.attributeModifiers = Suppliers.memoize(
                () -> {
                    ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
                    ResourceLocation location = ResourceLocation.withDefaultNamespace("greatsword");

                    return createAttributeModifiers(pTier,builder).build();
                }
        );
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {

        double d0 = (double)(-Mth.sin(pAttacker.getYRot() * (float) (Math.PI / 180.0)));
        double d1 = (double)Mth.cos(pAttacker.getYRot() * (float) (Math.PI / 180.0));
        if (pAttacker.level() instanceof ServerLevel) {
            ((ServerLevel)pAttacker.level()).sendParticles(ParticleTypes.SWEEP_ATTACK, pAttacker.getX() + d0, pAttacker.getY(0.5), pAttacker.getZ() + d1, 0, d0, 0.0, d1, 0.0);
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    protected ItemAttributeModifiers.Builder createAttributeModifiers(Tier pTier, ItemAttributeModifiers.Builder builder){
        ResourceLocation location = ResourceLocation.withDefaultNamespace("greatsword");


        builder.add(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(location, 5 + pTier.getAttackDamageBonus(), AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
                );
        builder.add(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(location, -2.9F, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
                );
        builder.add(
                Attributes.ENTITY_INTERACTION_RANGE,
                new AttributeModifier(location, 2, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
                );
        builder.add(
                Attributes.BLOCK_INTERACTION_RANGE,
                new AttributeModifier(location, 2, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                ALObjects.Attributes.EXPERIENCE_GAINED,
                new AttributeModifier(location, 1, AttributeModifier.Operation.ADD_VALUE),
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
        return 28;
    }
}
