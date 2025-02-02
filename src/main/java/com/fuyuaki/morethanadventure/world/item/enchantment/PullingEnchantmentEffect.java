package com.fuyuaki.morethanadventure.world.item.enchantment;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public record PullingEnchantmentEffect(
        ResourceLocation id,
        float modPercent,
        LevelBasedValue level,
        Holder<Attribute> attribute,
        AttributeModifier.Operation operation
) implements EnchantmentEntityEffect {


    public static final MapCodec<PullingEnchantmentEffect> MAP_CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(ResourceLocation.CODEC.fieldOf("id").forGetter(PullingEnchantmentEffect::id),
                            Codec.FLOAT.fieldOf("modPercent").forGetter(PullingEnchantmentEffect::modPercent),
                            LevelBasedValue.CODEC.fieldOf("level").forGetter(PullingEnchantmentEffect::level),
                            Attribute.CODEC.fieldOf("attribute").forGetter(PullingEnchantmentEffect::attribute),
                            AttributeModifier.Operation.CODEC.fieldOf("operation").forGetter(PullingEnchantmentEffect::operation))
                    .apply(instance, PullingEnchantmentEffect::new));

    @Override
    public void apply(ServerLevel serverLevel, int enchantmentLevel, EnchantedItemInUse enchantedItemInUse, Entity entity, Vec3 vec3) {
        if (entity instanceof LivingEntity livingEntity) {

            ItemStack itemstack = livingEntity.getUseItem();
            if (itemstack.equals(enchantedItemInUse.itemStack()) && livingEntity.isUsingItem()) {
                AttributeModifier modifier = new AttributeModifier(id, enchantmentLevel * modPercent, operation);
                Stream<ResourceLocation> modifiers = Objects.requireNonNull(livingEntity.getAttribute(attribute)).getModifiers()
                        .stream().map(AttributeModifier::id);
                if (modifiers.noneMatch((resourceLocation) -> resourceLocation == id)) {
                    livingEntity.getAttribute(attribute).addOrUpdateTransientModifier(modifier);

                }
            }
            else if (!itemstack.equals(enchantedItemInUse.itemStack()) || !livingEntity.isUsingItem()) {
                livingEntity.getAttribute(attribute).removeModifier(id);
            }
        }
    }

    @Override
    public MapCodec<? extends PullingEnchantmentEffect> codec() {
        return MAP_CODEC;
    }
}