package com.fuyuaki.morethanadventure.game.client.renderer.item.properties.conditional;


import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.conditional.ConditionalItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

public record IsAttacking() implements ConditionalItemModelProperty {
    public static final MapCodec<IsAttacking> MAP_CODEC = MapCodec.unit(new IsAttacking());

    @Override
    public boolean get(ItemStack stack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed, ItemDisplayContext context) {
        return entity != null && entity.swinging && entity.getMainHandItem() == stack;
    }

    @Override
    public MapCodec<IsAttacking> type() {
        return MAP_CODEC;
    }
}
