package com.fuyuvulpes.morethanadventure.world.entity;

import com.fuyuvulpes.morethanadventure.world.entity.goals.ChasingMeleeGoal;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.Tags;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;

public class YukiOnna extends ChasingMonster implements GeoEntity, FlyingAnimal {
    private static final EntityDataAccessor<Boolean> DATA_IS_BLOWING = SynchedEntityData.defineId(YukiOnna.class, EntityDataSerializers.BOOLEAN);
    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.yukionna.idle");
    protected static final RawAnimation CHASE = RawAnimation.begin().thenLoop("animation.yukionna.chase");
    protected static final RawAnimation BLOW = RawAnimation.begin().thenPlay("animation.yukionna.blow").thenLoop("animation.yukionna.idle");

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);


    public YukiOnna(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.xpReward = 5;
        this.moveControl = new FlyingMoveControl(this, 20, true);
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
    protected float getFlyingSpeed() {
        return 1.0F;
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(3, new YukiOnna.FreezingBlowGoal(this));
        this.goalSelector.addGoal(2, new ChasingMeleeGoal(this, 1.5f, true));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 16.0F));
        this.goalSelector.addGoal(6, new WaterAvoidingRandomFlyingGoal(this,0.5F));


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
                .add(Attributes.FOLLOW_RANGE, 22.0)
                .add(ALObjects.Attributes.ARMOR_SHRED, 1.0F)
                .add(ALObjects.Attributes.COLD_DAMAGE, 2.0F)
                .add(Attributes.ATTACK_DAMAGE, 3.0)
                .add(Attributes.FLYING_SPEED, 0.5)
                ;
    }

    public boolean isFlying() {
        return !this.onGround();
    }


    @Override
    public boolean doHurtTarget(Entity pEntity) {
        pEntity.setTicksFrozen(pEntity.getTicksFrozen() + 20);

        return super.doHurtTarget(pEntity);
    }

    @Override
    public void tick() {
        if (this.level().isRaining() && this.level().getBiome(this.blockPosition()).is(Tags.Biomes.IS_COLD)) {
            this.addEffect(new MobEffectInstance(ALObjects.MobEffects.REGENERATION));
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
    public boolean hurt(DamageSource pSource, float pAmount) {
        if (pSource.is(DamageTypeTags.IS_FIRE)) {
            pAmount = pAmount * 2;
        }
        return super.hurt(pSource, pAmount);
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

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.PHANTOM_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.PHANTOM_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.PHANTOM_DEATH;
    }

    @Override
    protected float getSoundVolume() {
        return 1.0F;
    }

    @Override
    public boolean canAttackType(EntityType<?> pType) {
        return true;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
                new AnimationController<>(this, 10, (state) -> {
                    if (state.getAnimatable().isBlowing()) {
                        return state.setAndContinue(BLOW);
                    } else if (state.getAnimatable().getTarget() != null && state.getAnimatable().isChasing()) {
                        return state.setAndContinue(CHASE);
                    } else return state.setAndContinue(IDLE);
                })
        );
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    public static boolean canSpawn(EntityType<YukiOnna> pType, ServerLevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom) {
        return checkMonsterSpawnRules(pType,pLevel,pSpawnType,pPos,pRandom)
                && pLevel.canSeeSky(pPos)
                && pLevel.getBiome(pPos).is(Tags.Biomes.IS_SNOWY)
                ;
    }

    protected static class FreezingBlowGoal extends Goal {

        private YukiOnna mob;
        private long lastCanUseCheck;
        private static final long COOLDOWN_BETWEEN_CAN_USE_CHECKS = 200L;
        private int ticksUntilDamage;


        public FreezingBlowGoal(YukiOnna pMob) {
            this.mob = pMob;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            long i = this.mob.level().getGameTime();
            if (i - this.lastCanUseCheck < 200L) {
                return false;
            } else {
                this.lastCanUseCheck = i;
                LivingEntity livingentity = this.mob.getTarget();
                if (livingentity == null) {
                    return false;
                } else if (!livingentity.isAlive()) {
                    return false;
                } else {

                    return this.mob.distanceTo(livingentity) < 16 && this.mob.distanceTo(livingentity) > 5;

                }
            }
        }

        @Override
        public void start() {
            this.mob.setAggressive(true);
            this.ticksUntilDamage = 40;
            this.mob.getNavigation().stop();
            this.mob.setBlowing(true);
        }

        @Override
        public void stop() {
            LivingEntity livingentity = this.mob.getTarget();
            if (!EntitySelector.NO_CREATIVE_OR_SPECTATOR.test(livingentity)) {
                this.mob.setTarget(null);
            }
            this.mob.setBlowing(false);
            this.mob.setAggressive(false);

        }

        @Override
        public void tick() {
            LivingEntity livingentity = this.mob.getTarget();
            if (livingentity != null) {
                Level level = this.mob.level();
                this.mob.getLookControl().setLookAt(livingentity, 30.0F, 30.0F);
                if (this.ticksUntilDamage > 0){
                    this.ticksUntilDamage--;

                    Vec3 dist = this.mob.getEyePosition().subtract(livingentity.getEyePosition());
                    for (int a = 1; a <= (20 - ticksUntilDamage); a++){
                        Vec3 distb = dist.multiply((double) 1 /a, (double) 1 /a, (double) 1 /a);
                        level.addParticle(ParticleTypes.SNOWFLAKE,true,distb.x,distb.y,distb.z,0,0,0);
                    }
                }
                else {
                    livingentity.hurt(this.mob.damageSources().freeze(),10.0F);
                    level.playSound(null,livingentity.blockPosition(),SoundEvents.GLASS_BREAK,SoundSource.HOSTILE,0.6F,2.0F);
                    level.playSound(null,livingentity.blockPosition(),SoundEvents.PLAYER_HURT_FREEZE,SoundSource.HOSTILE);
                    stop();
                }

            }

        }

        @Override
        public boolean requiresUpdateEveryTick() {
            return true;
        }


    }
}
