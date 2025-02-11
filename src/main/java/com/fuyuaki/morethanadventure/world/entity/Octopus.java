package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.AgeableWaterCreature;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Squid;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class Octopus extends AgeableWaterCreature {
    public float xBodyRot;
    public float xBodyRotO;
    public float tentacleMovement;
    public float oldTentacleMovement;
    public float tentacleAngle;
    public float oldTentacleAngle;
    private float speed;
    protected float tentacleSpeed;
    private float rotateSpeed;
    Vec3 movementVector = Vec3.ZERO;

    public Octopus(EntityType<? extends AgeableWaterCreature> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0F);
        this.random.setSeed((long)this.getId());
        this.tentacleSpeed = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
    }


    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(0, new OctopusRandomMovementGoal(this));
        this.goalSelector.addGoal(1, new OctopusFleeGoal()); ;
    }

    @Override
    public int getMaxAirSupply() {
        return 148000;
    }


    @Override
    protected int decreaseAirSupply(int pCurrentAir) {
        return pCurrentAir;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createAnimalAttributes()
                .add(Attributes.MAX_HEALTH, 9.0F)
                .add(Attributes.FOLLOW_RANGE, 7.0)
                .add(Attributes.MOVEMENT_SPEED, 0.15F)
                .add(Attributes.WATER_MOVEMENT_EFFICIENCY, 2.2F);
    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return MtaEntityTypes.OCTOPUS.get().create(pLevel, EntitySpawnReason.BREEDING);
    }


    @Override
    protected double getDefaultGravity() {
        return 0.08;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        this.xBodyRotO = this.xBodyRot;
        this.oldTentacleMovement = this.tentacleMovement;
        this.oldTentacleAngle = this.tentacleAngle;
        this.tentacleMovement = this.tentacleMovement + this.tentacleSpeed;
        if ((double)this.tentacleMovement > Math.PI * 2) {
            if (this.level().isClientSide) {
                this.tentacleMovement = (float) (Math.PI * 2);
            } else {
                this.tentacleMovement -= (float) (Math.PI * 2);
                if (this.random.nextInt(10) == 0) {
                    this.tentacleSpeed = 1.0F / (this.random.nextFloat() + 1.0F) * 0.2F;
                }

                this.level().broadcastEntityEvent(this, (byte)19);
            }
        }

        if (this.isInWaterOrBubble()) {
            if (this.tentacleMovement < (float) Math.PI) {
                float f = this.tentacleMovement / (float) Math.PI;
                this.tentacleAngle = Mth.sin(f * f * (float) Math.PI) * (float) Math.PI * 0.25F;
                if ((double)f > 0.75) {
                    if (this.isControlledByLocalInstance()) {
                        this.setDeltaMovement(this.movementVector);
                    }

                    this.rotateSpeed = 1.0F;
                } else {
                    this.rotateSpeed *= 0.8F;
                }
            } else {
                this.tentacleAngle = 0.0F;
                if (this.isControlledByLocalInstance()) {
                    this.setDeltaMovement(this.getDeltaMovement().scale(0.9));
                }

                this.rotateSpeed *= 0.99F;
            }

            Vec3 vec3 = this.getDeltaMovement();
            double d0 = vec3.horizontalDistance();
            this.yBodyRot = this.yBodyRot + (-((float)Mth.atan2(vec3.x, vec3.z)) * (180.0F / (float)Math.PI) - this.yBodyRot) * 0.1F;
            this.setYRot(this.yBodyRot);
            this.xBodyRot = this.xBodyRot + (-((float)Mth.atan2(d0, vec3.y)) * (180.0F / (float)Math.PI) - this.xBodyRot) * 0.1F;
        } else {
            this.tentacleAngle = Mth.abs(Mth.sin(this.tentacleMovement)) * (float) Math.PI * 0.25F;
            if (!this.level().isClientSide) {
                double d1 = this.getDeltaMovement().y;
                if (this.hasEffect(MobEffects.LEVITATION)) {
                    d1 = 0.05 * (double)(this.getEffect(MobEffects.LEVITATION).getAmplifier() + 1);
                } else {
                    d1 -= this.getGravity();
                }

                this.setDeltaMovement(0.0, d1 * 0.98F, 0.0);
            }

            this.xBodyRot = this.xBodyRot + (-90.0F - this.xBodyRot) * 0.02F;
        }
    }


    private Vec3 rotateVector(Vec3 vector) {
        Vec3 vec3 = vector.xRot(this.xBodyRotO * (float) (Math.PI / 180.0));
        return vec3.yRot(-this.yBodyRotO * (float) (Math.PI / 180.0));
    }
    @Override
    public void travel(Vec3 travelVector) {
        if (this.isControlledByLocalInstance()) {
            this.move(MoverType.SELF, this.getDeltaMovement());
        }
    }

    @Override
    public void handleEntityEvent(byte p_29957_) {
        if (p_29957_ == 19) {
            this.tentacleMovement = 0.0F;
        } else {
            super.handleEntityEvent(p_29957_);
        }
    }

    public boolean hasMovementVector() {
        return this.movementVector.lengthSqr() > 1.0E-5F;
    }

    @Override
    public void baseTick() {
        int i = this.getAirSupply();
        super.baseTick();
        this.handleAirSupply(i);
    }
    class OctopusFleeGoal extends Goal {
        private static final float Octopus_FLEE_SPEED = 3.0F;
        private static final float Octopus_FLEE_MIN_DISTANCE = 5.0F;
        private static final float Octopus_FLEE_MAX_DISTANCE = 10.0F;
        private int fleeTicks;

        @Override
        public boolean canUse() {
            LivingEntity livingentity = Octopus.this.getLastHurtByMob();
            return Octopus.this.isInWater() && livingentity != null ? Octopus.this.distanceToSqr(livingentity) < 100.0 : false;
        }

        @Override
        public void start() {
            this.fleeTicks = 0;
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }

        @Override
        public void tick() {
            this.fleeTicks++;
            LivingEntity livingentity = Octopus.this.getLastHurtByMob();
            if (livingentity != null) {
                Vec3 vec3 = new Vec3(Octopus.this.getX() - livingentity.getX(), Octopus.this.getY() - livingentity.getY(), Octopus.this.getZ() - livingentity.getZ());
                BlockState blockstate = Octopus.this.level()
                        .getBlockState(BlockPos.containing(Octopus.this.getX() + vec3.x, Octopus.this.getY() + vec3.y, Octopus.this.getZ() + vec3.z));
                FluidState fluidstate = Octopus.this.level()
                        .getFluidState(BlockPos.containing(Octopus.this.getX() + vec3.x, Octopus.this.getY() + vec3.y, Octopus.this.getZ() + vec3.z));
                if (fluidstate.is(FluidTags.WATER) || blockstate.isAir()) {
                    double d0 = vec3.length();
                    if (d0 > 0.0) {
                        vec3.normalize();
                        double d1 = 3.0;
                        if (d0 > 5.0) {
                            d1 -= (d0 - 5.0) / 5.0;
                        }

                        if (d1 > 0.0) {
                            vec3 = vec3.scale(d1);
                        }
                    }

                    if (blockstate.isAir()) {
                        vec3 = vec3.subtract(0.0, vec3.y, 0.0);
                    }

                    Octopus.this.movementVector = new Vec3(vec3.x / 20.0, vec3.y / 20.0, vec3.z / 20.0);
                }

                if (this.fleeTicks % 10 == 5) {
                    Octopus.this.level().addParticle(ParticleTypes.BUBBLE, Octopus.this.getX(), Octopus.this.getY(), Octopus.this.getZ(), 0.0, 0.0, 0.0);
                }
            }
        }
    }

    static class OctopusRandomMovementGoal extends Goal {
        private final Octopus octopus;

        public OctopusRandomMovementGoal(Octopus p_30003_) {
            this.octopus = p_30003_;
        }

        @Override
        public boolean canUse() {
            return true;
        }

        @Override
        public void tick() {
            int i = this.octopus.getNoActionTime();
            if (i > 100) {
                this.octopus.movementVector = Vec3.ZERO;
            } else if (this.octopus.getRandom().nextInt(reducedTickDelay(50)) == 0 || !this.octopus.wasTouchingWater || !this.octopus.hasMovementVector()) {
                float f = this.octopus.getRandom().nextFloat() * (float) (Math.PI * 2);
                this.octopus.movementVector = new Vec3(
                        (double)(Mth.cos(f) * 0.2F), (double)(-0.1F + this.octopus.getRandom().nextFloat() * 0.2F), (double)(Mth.sin(f) * 0.2F)
                );
            }
        }
    }
}
