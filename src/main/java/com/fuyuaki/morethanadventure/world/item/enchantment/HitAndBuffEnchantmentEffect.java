package com.fuyuaki.morethanadventure.world.item.enchantment;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record HitAndBuffEnchantmentEffect(LevelBasedValue amount, Holder<Attribute> attribute, float modPercent, AttributeModifier.Operation operation, int tickAmount, ResourceLocation id) implements EnchantmentEntityEffect {
    public static final MapCodec<HitAndBuffEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(LevelBasedValue.CODEC.fieldOf("level").forGetter(HitAndBuffEnchantmentEffect::amount),
                            Attribute.CODEC.fieldOf("attribute").forGetter(HitAndBuffEnchantmentEffect::attribute),
                            Codec.FLOAT.fieldOf("modPercent").forGetter(HitAndBuffEnchantmentEffect::modPercent),
                            AttributeModifier.Operation.CODEC.fieldOf("operation").forGetter(HitAndBuffEnchantmentEffect::operation),
                            Codec.INT.fieldOf("tickAmount").forGetter(HitAndBuffEnchantmentEffect::tickAmount),
                            ResourceLocation.CODEC.fieldOf("id").forGetter(HitAndBuffEnchantmentEffect::id))
                    .apply(instance, HitAndBuffEnchantmentEffect::new));

    @Override
    public void apply(ServerLevel serverLevel, int enchantmentLevel, EnchantedItemInUse enchantedItemInUse, Entity entity, Vec3 vec3) {
        /*if (entity instanceof LivingEntity livingEntity) {
            ItemStack itemstack = livingEntity.getItemBySlot(EquipmentSlot.MAINHAND);
            AttributeModifier modifier = new AttributeModifier(id, enchantmentLevel * modPercent, operation);
            if (!itemstack.isEmpty() && itemstack.is(enchantedItemInUse.itemStack().getItem())) {
                livingEntity.getAttribute(attribute).addTransientModifier(modifier);
                tick(livingEntity);
            }
        }
    }*/

    /*public void tick (LivingEntity entity) {
        int ticks = this.tickAmount;
        while (ticks > 0){
            ticks--;
        }
        if (ticks == 0)
            entity.getAttribute(attribute).removeModifier(id);
        }
*/
    }
    @Override
    public MapCodec<? extends EnchantmentEntityEffect> codec () {
        return CODEC;
    }

}