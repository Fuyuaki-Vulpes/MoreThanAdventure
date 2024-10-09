package com.fuyuaki.morethanadventure.world.entity;

import net.minecraft.tags.FluidTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class Host extends Zombie {
    public Host(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 42.0)
                .add(Attributes.MOVEMENT_SPEED, 0.18F)
                .add(Attributes.ATTACK_DAMAGE, 2.0)
                .add(Attributes.ARMOR, 3.0)
                .add(Attributes.MAX_HEALTH, 34F)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 0F);
    }

    @Override
    public void tick() {
        if (!this.level().isClientSide && !this.hasEffect(MobEffects.INFESTED)){

        }

        super.tick();
    }


    @Override
    protected boolean convertsInWater() {
        return false;
    }
}
