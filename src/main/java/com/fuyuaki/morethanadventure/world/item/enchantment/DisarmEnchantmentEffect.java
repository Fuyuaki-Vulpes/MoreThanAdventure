package com.fuyuaki.morethanadventure.world.item.enchantment;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record DisarmEnchantmentEffect(LevelBasedValue level) implements EnchantmentEntityEffect {
    public static final MapCodec<DisarmEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(LevelBasedValue.CODEC.fieldOf("level").forGetter(DisarmEnchantmentEffect::level))
                    .apply(instance, DisarmEnchantmentEffect::new));



    @Override
    public void apply(ServerLevel level, int enchantmentLevel, EnchantedItemInUse item, Entity entity, Vec3 origin) {
        if (entity instanceof LivingEntity livingEntity) {
            ItemStack itemstack = livingEntity.getItemBySlot(EquipmentSlot.MAINHAND);
            ItemStack itemstack1 = livingEntity.getItemBySlot(EquipmentSlot.OFFHAND);
            if (!itemstack.isEmpty()) {
                if(enchantmentLevel == 1 && livingEntity.getRandom().nextFloat() <= 0.20F) {
                    item.owner().spawnAtLocation(level, itemstack);
                    livingEntity.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                }
                else if(enchantmentLevel == 1 && livingEntity.getRandom().nextFloat() <= 0.10F) {
                    item.owner().spawnAtLocation(level, itemstack1);
                    livingEntity.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
                }
                if(enchantmentLevel == 2 && livingEntity.getRandom().nextFloat() <= 0.40F) {
                    item.owner().spawnAtLocation(level, itemstack);
                    livingEntity.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                }
                else if(enchantmentLevel == 2 && livingEntity.getRandom().nextFloat() <= 0.20F) {
                    item.owner().spawnAtLocation(level, itemstack1);
                    livingEntity.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
                }
                if(enchantmentLevel == 3 && livingEntity.getRandom().nextFloat() <= 0.60F) {
                    item.owner().spawnAtLocation(level, itemstack);
                    livingEntity.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                }
                else if(enchantmentLevel == 3 && livingEntity.getRandom().nextFloat() <= 0.30F) {
                    item.owner().spawnAtLocation(level, itemstack1);
                    livingEntity.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                }
                if(enchantmentLevel == 4 && livingEntity.getRandom().nextFloat() <= 0.80F) {
                    livingEntity.spawnAtLocation(level, itemstack);
                    livingEntity.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                }
                else if(enchantmentLevel == 4 && livingEntity.getRandom().nextFloat() <= 0.80F) {
                    livingEntity.spawnAtLocation(level, itemstack1);
                    livingEntity.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                }
                if(enchantmentLevel == 5 && livingEntity.getRandom().nextFloat() <= 1.0F) {
                    item.owner().spawnAtLocation(level, itemstack);
                    livingEntity.setItemSlot(EquipmentSlot.MAINHAND, ItemStack.EMPTY);
                }
                else if(enchantmentLevel == 5 && livingEntity.getRandom().nextFloat() <= 0.9F) {
                    item.owner().spawnAtLocation(level, itemstack1);
                    livingEntity.setItemSlot(EquipmentSlot.OFFHAND, ItemStack.EMPTY);
                }

            }
        }


    }

        @Override
        public MapCodec<? extends EnchantmentEntityEffect> codec () {
            return CODEC;
        }
    }




















