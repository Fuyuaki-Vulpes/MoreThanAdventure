package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.fuyuaki.morethanadventure.world.entity.brain.behavior.WitherSoldierAI;
import com.mojang.serialization.Dynamic;
import net.minecraft.network.protocol.game.DebugPackets;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.util.profiling.Profiler;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.Brain;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class WitherSoldierEntity extends AbstractSkeleton {
    public WitherSoldierEntity(EntityType<? extends AbstractSkeleton> p_32133_, Level p_32134_) {
        super(p_32133_, p_32134_);
        this.xpReward = 10;


    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.35F)
                .add(Attributes.MAX_HEALTH, 50.0)
                .add(Attributes.FOLLOW_RANGE, 24.0)
                .add(Attributes.ATTACK_DAMAGE, 2.0);
    }

    @Override
    protected void sendDebugPackets() {
        super.sendDebugPackets();
        DebugPackets.sendEntityBrain(this);
    }

    @Override
    public boolean canAttackType(EntityType<?> p_312806_) {
        return p_312806_ == EntityType.PLAYER || p_312806_ == EntityType.IRON_GOLEM;
    }


    @javax.annotation.Nullable
    @Override
    public LivingEntity getTarget() {
        return this.getTargetFromBrain();
    }


    @Override
    protected void registerGoals() {
    }

    @Override
    protected Brain.Provider<WitherSoldierEntity> brainProvider() {
        return Brain.provider(WitherSoldierAI.MEMORY_TYPES, WitherSoldierAI.SENSOR_TYPES);

    }

    @Override
    public Brain<WitherSoldierEntity> getBrain() {
        return (Brain<WitherSoldierEntity>) super.getBrain();
    }

    @Override
    protected Brain<WitherSoldierEntity> makeBrain(Dynamic<?> dynamic) {
        return WitherSoldierAI.makeBrain(this, this.brainProvider().makeBrain(dynamic));
    }

    @Override
    protected void customServerAiStep(ServerLevel p_376422_) {
        ProfilerFiller profilerfiller = Profiler.get();
        profilerfiller.push("witherSoldierBrain");
        this.getBrain().tick(p_376422_, this);
        profilerfiller.popPush("witherSoldierActivityUpdate");
        WitherSoldierAI.updateActivity(this);
        profilerfiller.pop();
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource randomSource, DifficultyInstance difficultyInstance) {
        if (randomSource.nextFloat() < 0.1F) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
        } else if (randomSource.nextFloat() < 0.1F){
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.STONE_GLAIVE.get()));
        } else if (randomSource.nextFloat() < 0.1F){
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.STONE_RAPIER.get()));
        } else if (randomSource.nextFloat() < 0.1F){
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.IRON_HALBERD.get()));
        } else if (randomSource.nextFloat() < 0.1F){
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.IRON_SICKLE.get()));
            this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(MtaItems.IRON_SICKLE.get()));
        } else if (randomSource.nextFloat() < 0.1F){
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.IRON_GLAIVE.get()));
        } else if (randomSource.nextFloat() < 0.1F){
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.IRON_HALBERD.get()));
        } else if (randomSource.nextFloat() < 0.1F) {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.NETHERITE_BOW.get()));
        } else if (randomSource.nextFloat() < 0.1F){
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
        } else {
            this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.DIAMOND_HALBERD.get()));
        }

        if (randomSource.nextFloat() < 0.2F * difficultyInstance.getEffectiveDifficulty()){
            this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));

        }
    }



    public Optional<LivingEntity> getHurtBy() {
        return this.getBrain()
                .getMemory(MemoryModuleType.HURT_BY)
                .map(DamageSource::getEntity)
                .filter(p_321467_ -> p_321467_ instanceof LivingEntity)
                .map(p_321468_ -> (LivingEntity)p_321468_);
    }


    @Override
    protected boolean isSunBurnTick() {
        return false;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return MtaSounds.ARMORED_SKELETON_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return MtaSounds.ARMORED_SKELETON_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return MtaSounds.ARMORED_SKELETON_DEATH.get();
    }

    @Override
    protected SoundEvent getStepSound() {
        return MtaSounds.ARMORED_SKELETON_STEP.get();
    }
}
