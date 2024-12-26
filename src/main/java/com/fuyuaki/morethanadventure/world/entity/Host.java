package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

public class Host extends Zombie {
    public Host(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 50.0)
                .add(Attributes.MOVEMENT_SPEED, 0.15F)
                .add(Attributes.ATTACK_DAMAGE, 1.0)
                .add(Attributes.ARMOR, 3.0)
                .add(Attributes.MAX_HEALTH, 34F)
                .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 0F);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return MtaSounds.HOST_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return MtaSounds.HOST_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return MtaSounds.HOST_DEATH.get();
    }

    @Override
    public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
        if (this.level().getDifficulty() == Difficulty.EASY) {
            if (this.getRandom().nextFloat() <= 0.20) {
                int i = 1;

                for (int j = 0; j < i; j++) {
                    this.spawnSilverfish(this.level(), this, this.getX(), this.getY() + (double) this.getBbHeight() / 2.0, this.getZ());
                }
            }
        } else if (this.level().getDifficulty() == Difficulty.NORMAL) {
            if (this.getRandom().nextFloat() <= 0.45) {
                int i = 1;

                for (int j = 0; j < i; j++) {
                    this.spawnSilverfish(this.level(), this, this.getX(), this.getY() + (double) this.getBbHeight() / 2.0, this.getZ());
                }
            }
        } else if (this.level().getDifficulty() == Difficulty.HARD) {
            if (this.getRandom().nextFloat() <= 0.75) {
                int i = 1;

                for (int j = 0; j < i; j++) {
                    this.spawnSilverfish(this.level(), this, this.getX(), this.getY() + (double) this.getBbHeight() / 2.0, this.getZ());
                }
            }
        }
        return super.hurtServer(level,source, amount);
    }

    @Override
    public void die (DamageSource damageSource){
        if (this.level().getDifficulty() == Difficulty.EASY) {
                int i = 1;

                for (int j = 0; j < i; j++) {
                    this.spawnSilverfish(this.level(), this, this.getX(), this.getY() + (double) this.getBbHeight() / 2.0, this.getZ());
                }
        } else if (this.level().getDifficulty() == Difficulty.NORMAL) {
                int i = this.random.nextIntBetweenInclusive(2, 3);

                for (int j = 0; j < i; j++) {
                    this.spawnSilverfish(this.level(), this, this.getX(), this.getY() + (double) this.getBbHeight() / 2.0, this.getZ());
                }

        } else if (this.level().getDifficulty() == Difficulty.HARD) {
                int i = this.random.nextIntBetweenInclusive(3, 4);

                for (int j = 0; j < i; j++) {
                    this.spawnSilverfish(this.level(), this, this.getX(), this.getY() + (double) this.getBbHeight() / 2.0, this.getZ());
                }
        }

        super.die(damageSource);
    }

    private void spawnSilverfish (Level level, LivingEntity entity,double x, double y, double z){
        Silverfish silverfish = EntityType.SILVERFISH.create(level, EntitySpawnReason.BREEDING);
        if (silverfish != null) {
            RandomSource randomsource = entity.getRandom();
            float f = (float) (Math.PI / 2);
            float f1 = Mth.randomBetween(randomsource, (float) (-Math.PI / 2), (float) (Math.PI / 2));
            Vector3f vector3f = entity.getLookAngle().toVector3f().mul(0.3F).mul(1.0F, 1.5F, 1.0F).rotateY(f1);
            silverfish.moveTo(x, y, z, level.getRandom().nextFloat() * 360.0F, 0.0F);
            silverfish.setDeltaMovement(new Vec3(vector3f));
            level.addFreshEntity(silverfish);
            silverfish.playSound(SoundEvents.SILVERFISH_HURT);
        }
    }

    @Override
    protected boolean convertsInWater () {
        return false;
    }
}