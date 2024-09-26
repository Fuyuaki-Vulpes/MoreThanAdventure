package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import com.google.common.base.Suppliers;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.function.Supplier;

public class SentinelsWarHammerItem extends MaceItem {

    private static final int DEFAULT_ATTACK_DAMAGE = 10;
    private static final float DEFAULT_ATTACK_SPEED = -3.4F;
    public static final float SMASH_ATTACK_FALL_THRESHOLD = 1.5F;
    private static final float SMASH_ATTACK_HEAVY_THRESHOLD = 5.0F;
    public static final float SMASH_ATTACK_KNOCKBACK_RADIUS = 3.5F;
    private static final float SMASH_ATTACK_KNOCKBACK_POWER = 0.7F;
    private final Supplier<ItemAttributeModifiers> attributeModifiers;


    public SentinelsWarHammerItem(Properties pProperties) {
        super(pProperties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));
        this.attributeModifiers = Suppliers.memoize(
                () -> {
                    ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
                    ResourceLocation location = ResourceLocation.withDefaultNamespace("warhammer");

                    return createAttributeModifiers(builder).build();
                }
        );
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {

        double d0 = (double)(-Mth.sin(pAttacker.getYRot() * (float) (Math.PI / 180.0)));
        double d1 = (double)Mth.cos(pAttacker.getYRot() * (float) (Math.PI / 180.0));
        if (pAttacker.level() instanceof ServerLevel) {
            ((ServerLevel)pAttacker.level()).sendParticles(ParticleTypes.GUST, pAttacker.getX() + d0, pAttacker.getY(0.5), pAttacker.getZ() + d1, 0, d0, 0.0, d1, 0.0);
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    protected ItemAttributeModifiers.Builder createAttributeModifiers(ItemAttributeModifiers.Builder builder){
        ResourceLocation location = ResourceLocation.withDefaultNamespace("warhammer");


        builder.add(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(location, 6, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(location, -3.3, AttributeModifier.Operation.ADD_VALUE),
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
                Attributes.ATTACK_KNOCKBACK,
                new AttributeModifier(location, 3F, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        return builder;
    }

    @Override
    public boolean isPrimaryItemFor(ItemStack stack, Holder<Enchantment> enchantment) {
        return stack.getItem() == MtaItems.GREAT_SENTINELS_WAR_HAMMER.get() && enchantment.is(Enchantments.FIRE_ASPECT) ||
                enchantment.is(Enchantments.SMITE) ||
                enchantment.is(Enchantments.DENSITY) ||
                enchantment.is(Enchantments.BANE_OF_ARTHROPODS) ||
                enchantment.is(Enchantments.BREACH) ||
                enchantment.is(Enchantments.UNBREAKING);
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return this.attributeModifiers.get();
    }

    @Override
    public int getEnchantmentValue() {
        return 10;
    }
}