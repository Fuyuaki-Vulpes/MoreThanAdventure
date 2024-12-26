package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class CharredSkeleton extends AbstractSkeleton {
    private float fireDamage;

    public CharredSkeleton(EntityType<? extends AbstractSkeleton> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.31F)
                .add(Attributes.MAX_HEALTH, 14F);
    }

    @Override
    protected boolean isSunBurnTick() {
        return false;
    }

    @Override
    protected SoundEvent getStepSound() {
        return MtaSounds.CHARRED_SKELETON_STEP.get();
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource random, DifficultyInstance difficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return MtaSounds.CHARRED_SKELETON_AMBIENT.get();
    }


    @Override
    public boolean doHurtTarget(ServerLevel level, Entity entity) {
        if (entity instanceof LivingEntity living){
            living.setRemainingFireTicks(this.getRandom().nextIntBetweenInclusive(10,50));
        }
        return super.doHurtTarget(level, entity);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return MtaSounds.CHARRED_SKELETON_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return MtaSounds.CHARRED_SKELETON_DEATH.get();
    }

    @Override
    public boolean isOnFire() {
        return false;
    }
}
