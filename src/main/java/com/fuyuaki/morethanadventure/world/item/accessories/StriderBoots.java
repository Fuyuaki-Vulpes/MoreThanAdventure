package com.fuyuaki.morethanadventure.world.item.accessories;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.Tags;

public class StriderBoots extends TalismanItem{
    public StriderBoots(Properties properties) {
        super(properties);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if ((level.getFluidState(entity.getOnPos()).is(Tags.Fluids.LAVA) || level.getFluidState(entity.getOnPos().below()).is(Tags.Fluids.LAVA)) && entity instanceof LivingEntity living){
            living.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE,20));
        }
        super.inventoryTick(stack, level, entity, slotId, isSelected);
    }
}
