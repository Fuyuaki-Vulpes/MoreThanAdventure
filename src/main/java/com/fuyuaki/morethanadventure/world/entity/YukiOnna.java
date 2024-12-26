package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEffects;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.Nullable;

import java.util.EnumSet;

public class YukiOnna extends Monster implements FlyingAnimal {
    private static final EntityDataAccessor<Boolean> DATA_IS_BLOWING = SynchedEntityData.defineId(YukiOnna.class, EntityDataSerializers.BOOLEAN);


    public YukiOnna(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.xpReward = 5;
        this.moveControl = new FlyingMoveControl(this, 20, true);

        this.setPathfindingMalus(PathType.DANGER_FIRE, -1.0F);
    }


    @Override
    protected PathNavigation createNavigation(Level pLevel) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, pLevel);
        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(true);
        return flyingpathnavigation;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(DATA_IS_BLOWING, false);
    }

    public boolean isBlowing() {
        return this.entityData.get(DATA_IS_BLOWING);
    }

    public void setBlowing(boolean blowing) {
        this.entityData.set(DATA_IS_BLOWING, blowing);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new YukiOnna.FreezingBlowGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.5f, true));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomFlyingGoal(this,1.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 16.0F));



        this.addTargetGoals();
    }

    private void addTargetGoals() {
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Villager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));


    }



    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 18.0F)
                .add(Attributes.FOLLOW_RANGE, 12.0)
                .add(Attributes.ATTACK_DAMAGE, 3.0)
                .add(Attributes.FLYING_SPEED, 0.4F)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                ;
    }

    public boolean isFlying() {
        return !this.onGround();
    }


    @Override
    public boolean doHurtTarget(ServerLevel level, Entity pEntity) {
        pEntity.setTicksFrozen(pEntity.getTicksFrozen() + 100);
        if (pEntity instanceof LivingEntity living) {
            living.addEffect(new MobEffectInstance(MtaEffects.FREEZING, 40));
        }

        return super.doHurtTarget(level,pEntity);
    }

    @Override
    public void tick() {
        if (this.level().isRaining() && this.level().getBiome(this.blockPosition()).is(Tags.Biomes.IS_COLD)) {
            this.addEffect(new MobEffectInstance(MobEffects.REGENERATION));
        }
        super.tick();
    }



    @Override
    public boolean isFreezing() {
        return false;
    }

    @Override
    protected void checkFallDamage(double pY, boolean pOnGround, BlockState pState, BlockPos pPos) {
    }

    @Override
    public boolean causeFallDamage(float pFallDistance, float pMultiplier, DamageSource pSource) {
        return false;
    }


    @Override
    public boolean hurtServer(ServerLevel p_376221_, DamageSource source, float amount) {

        if (source.is(DamageTypeTags.IS_FIRE)) {
            amount = amount * 2;
        }

        return super.hurtServer(p_376221_, source, amount);
    }

    @Override
    public void aiStep() {
        if (this.isAlive() && this.isSunBurnTick()) {
            this.igniteForSeconds(8.0F);
        }

        super.aiStep();
    }

    @Override
    public boolean shouldRenderAtSqrDistance(double pDistance) {
        return true;
    }

    @Override
    public SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return MtaSounds.YUKI_ONNA_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return MtaSounds.YUKI_ONNA_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return MtaSounds.YUKI_ONNA_DEATH.get();
    }

    @Override
    protected float getSoundVolume() {
        return 1.0F;
    }

    @Override
    public boolean addEffect(MobEffectInstance pEffectInstance, @Nullable Entity pEntity) {
        if (pEffectInstance.is(MtaEffects.FREEZING)){
            return false;
        }
        return super.addEffect(pEffectInstance, pEntity);
    }

    @Override
    public boolean canAttackType(EntityType<?> pType) {
        return true;
    }


    public static boolean canSpawn(EntityType<YukiOnna> pType, ServerLevelAccessor pLevel, EntitySpawnReason pSpawnType, BlockPos pPos, RandomSource pRandom) {
        return checkMobSpawnRules(pType,pLevel,pSpawnType,pPos,pRandom)
                && pLevel.canSeeSky(pPos.above().above())
                && pLevel.getBiome(pPos).is(Tags.Biomes.IS_SNOWY)
                ;
    }

    protected class FreezingBlowGoal extends Goal {

        private YukiOnna mob;
        private long lastCanUseCheck;
        private static final long COOLDOWN = 460L;
        private int ticksUntilDamage;


        public FreezingBlowGoal(YukiOnna pMob) {
            this.mob = pMob;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            long i = this.mob.level().getGameTime();
            if (i - this.lastCanUseCheck < COOLDOWN) {
                return false;
            } else {
                this.lastCanUseCheck = i;
                LivingEntity livingentity = this.mob.getTarget();
                if (livingentity == null) {
                    return false;
                } else if (!livingentity.isAlive()) {
                    return false;
                } else {

                    return this.mob.distanceTo(livingentity) < 32 && this.mob.distanceTo(livingentity) > 4;

                }
            }
        }

        @Override
        public void start() {
            this.mob.setAggressive(true);
            this.ticksUntilDamage = 40;
            this.mob.setBlowing(true);
        }

        @Override
        public void stop() {
            LivingEntity livingentity = this.mob.getTarget();
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) {
                this.mob.setTarget(null);
            }
            this.mob.setBlowing(false);

        }

        @Override
        public void tick() {
            LivingEntity livingentity = this.mob.getTarget();
            if (livingentity != null) {
                this.ticksUntilDamage--;
                Level level = this.mob.level();
                this.mob.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
                if (this.ticksUntilDamage > 0){
                    for (int a = 1; a <= 10; a++) {
                        Vec3 distb = this.mob.getEyePosition().lerp(livingentity.getEyePosition(), (double) a / 10);

                        createParticles(this.mob.level(),distb.x,distb.y,distb.z);
                    }
                }
                else {
                    livingentity.hurt(new DamageSource(this.mob.damageSources().freeze().typeHolder(), this.mob),4.0F);
                    livingentity.addEffect(new MobEffectInstance(MtaEffects.FREEZING,120,4));
                    level.playSound(null,livingentity.blockPosition(),SoundEvents.GLASS_BREAK,SoundSource.HOSTILE,0.6F,2.0F);
                    level.playSound(null,livingentity.blockPosition(),SoundEvents.PLAYER_HURT_FREEZE,SoundSource.HOSTILE);
                    livingentity.setTicksFrozen(500);
                    stop();
                }

            }



        }

        @Override
        public boolean canContinueToUse() {
            LivingEntity livingentity = this.mob.getTarget();
            if (livingentity == null) {
                return false;
            } else if (!livingentity.isAlive()) {
                return false;
            } else if (this.ticksUntilDamage < -1) {
                return false;
            } else {
                return !this.mob.isWithinRestriction(livingentity.blockPosition())
                        ? false
                        : !(livingentity instanceof Player) || !livingentity.isSpectator() && !((Player)livingentity).isCreative();
            }
        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }


    }

    private void createParticles(Level level,double pX, double pY, double pZ) {
        if (!level.isClientSide()){
            ((ServerLevel)level).sendParticles(ParticleTypes.SNOWFLAKE,pX,pY,pZ,0,0.0D,0.0D,0.0D,0.0D);
        }
    }


}
