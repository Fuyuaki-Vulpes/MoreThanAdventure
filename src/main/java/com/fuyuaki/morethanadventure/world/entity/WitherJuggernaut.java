package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import com.fuyuaki.morethanadventure.world.item.MTAEnchantmentProvider;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import net.minecraft.network.chat.Component;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerBossEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.BossEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.providers.VanillaEnchantmentProviders;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.pathfinder.PathType;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Objects;

public class WitherJuggernaut extends Monster implements GeoEntity {
    private static final EntityDataAccessor<Boolean> STUNNED = SynchedEntityData.defineId(WitherJuggernaut.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> STUN_TIME = SynchedEntityData.defineId(WitherJuggernaut.class, EntityDataSerializers.INT);

    protected static final RawAnimation MOVE = RawAnimation.begin().thenLoop("animation.wither_juggernaut.walk");
    protected static final RawAnimation SWING = RawAnimation.begin().thenPlay("animation.wither_juggernaut.swing");
    protected static final RawAnimation STUN = RawAnimation.begin().then("animation.wither_juggernaut.enter_stun", Animation.LoopType.PLAY_ONCE).thenLoop("animation.wither_juggernaut.stun");
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final ServerBossEvent bossEvent = (ServerBossEvent)new ServerBossEvent(
            this.getDisplayName(), BossEvent.BossBarColor.RED, BossEvent.BossBarOverlay.PROGRESS
    ).setDarkenScreen(true);

    private static final int stunTimeMax = 200;
    public WitherJuggernaut(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.xpReward = 200;
        this.setPersistenceRequired();
        this.setPathfindingMalus(PathType.LAVA, 8.0F);
    }
    @Override
    protected void populateDefaultEquipmentSlots(RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE.get()));
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pSpawnType, @Nullable SpawnGroupData pSpawnGroupData) {
        RandomSource randomsource = pLevel.getRandom();

        this.populateDefaultEquipmentSlots(randomsource, pDifficulty);
        this.populateDefaultEquipmentEnchantments(pLevel, randomsource, pDifficulty);


        return super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, pSpawnGroupData);

    }

    @Override
    public boolean isWithinMeleeAttackRange(LivingEntity pEntity) {
        return this.getAttackBoundingBox().inflate(1.5F).intersects(pEntity.getHitbox());

    }

    @Override
    protected void enchantSpawnedWeapon(ServerLevelAccessor pLevel, RandomSource pRandom, DifficultyInstance pDifficulty) {
        this.enchantSpawnedEquipment(pLevel, EquipmentSlot.MAINHAND, pRandom, 1.0F, pDifficulty);
    }

    private void enchantSpawnedEquipment(
            ServerLevelAccessor pLevel, EquipmentSlot pSlot, RandomSource pRandom, float pEnchantChance, DifficultyInstance pDifficulty
    ) {
        ItemStack itemstack = this.getItemBySlot(pSlot);
        if (!itemstack.isEmpty() && pRandom.nextFloat() < pEnchantChance) {
            EnchantmentHelper.enchantItemFromProvider(
                    itemstack, pLevel.registryAccess(), MTAEnchantmentProvider.WITHER_JUGGERNAUT, pDifficulty, pRandom
            );
            this.setItemSlot(pSlot, itemstack);
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(STUNNED, false);
        pBuilder.define(STUN_TIME, 0);
    }

    public boolean isStunned() {
        return this.entityData.get(STUNNED);
    }

    public void setStunned(boolean stunned) {
        this.entityData.set(STUNNED, stunned);
        this.setStunTime(0);

    }

    public int getStunTime() {
        return this.entityData.get(STUN_TIME);
    }

    public void setStunTime(int stunTime) {
        this.entityData.set(STUN_TIME, stunTime);
    }



    @Override
    public void onExplosionHit(@Nullable Entity pEntity) {
        this.setStunned(true);
        super.onExplosionHit(pEntity);
    }

    @Override
    protected void customServerAiStep() {
        if (!this.level().isClientSide){
            if (this.isStunned()){
                if (this.getStunTime() < 0){
                    this.setStunTime(0);
                }
                this.setStunTime(this.getStunTime() + 1);
                this.setNoActionTime(5);

                if (this.getStunTime() >= stunTimeMax){
                    this.setStunned(false);
                }


            }
        }
        super.customServerAiStep();
        this.bossEvent.setProgress(this.getHealth() / this.getMaxHealth());
    }



    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new WitherJuggernaut.CustomMeleeAttackGoal(this, 1.0f, true));
        this.goalSelector.addGoal(3, new WitherJuggernaut.CustomRandomStrollGoal(this,1.0F));
        this.goalSelector.addGoal(6, new WitherJuggernaut.CustomRandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new WitherJuggernaut.CustomLookAtPlayerGoal(this, Player.class, 16.0F));



        this.addTargetGoals();
    }
    @Override
    protected void dropCustomDeathLoot(ServerLevel pLevel, DamageSource pDamageSource, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pLevel, pDamageSource, pRecentlyHit);
        ItemEntity itementity = this.spawnAtLocation(Items.WITHER_SKELETON_SKULL);
        if (itementity != null) {
            itementity.setExtendedLifetime();
        }
    }



    @Override
    public boolean addEffect(MobEffectInstance pEffectInstance, @javax.annotation.Nullable Entity pEntity) {
        return false;
    }



    private void addTargetGoals() {
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Villager.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Pillager.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Piglin.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, PiglinBrute.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Hoglin.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Zoglin.class, true));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, Skeleton.class, true));


    }

    @Override
    public void setCustomName(@javax.annotation.Nullable Component pName) {
        super.setCustomName(pName);
        this.bossEvent.setName(this.getDisplayName());
    }
    @Override
    public void startSeenByPlayer(ServerPlayer pPlayer) {
        super.startSeenByPlayer(pPlayer);
        this.bossEvent.addPlayer(pPlayer);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayer pPlayer) {
        super.stopSeenByPlayer(pPlayer);
        this.bossEvent.removePlayer(pPlayer);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MAX_HEALTH, 200.0F)
                .add(Attributes.FOLLOW_RANGE, 32.0)
                .add(Attributes.ATTACK_DAMAGE, 2.0F)
                .add(Attributes.MOVEMENT_SPEED, 0.25F)
                .add(Attributes.ARMOR,20.0F)
                .add(Attributes.ARMOR_TOUGHNESS,2.0F)
                .add(Attributes.KNOCKBACK_RESISTANCE,1.0F)
                .add(Attributes.STEP_HEIGHT,2.0F)
                .add(Attributes.SAFE_FALL_DISTANCE,6.0F)
                .add(Attributes.ENTITY_INTERACTION_RANGE,5.0F)
                .add(ALObjects.Attributes.LIFE_STEAL,0.3F)
                ;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    public SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.WITHER_SKELETON_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return SoundEvents.WITHER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WITHER_SKELETON_DEATH;
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
                new AnimationController<>(this, 0, (state) -> {
                    if (state.getAnimatable().isStunned()) {
                        return state.setAndContinue(STUN);
                    }else
                    if (state.isMoving()) {
                        return state.setAndContinue(MOVE);
                    }
                    else return state.setAndContinue(DefaultAnimations.IDLE);
                })
        , new AnimationController<>(this, "attack_controller", state -> PlayState.STOP)
                        .triggerableAnim("attack_animation",SWING).transitionLength(5).setAnimationSpeed(2.0F));
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    public class CustomMeleeAttackGoal extends MeleeAttackGoal {
        protected final WitherJuggernaut mob;
        private int attackAnimSync = -1;

        public CustomMeleeAttackGoal(WitherJuggernaut pMob, double pSpeedModifier, boolean pFollowingTargetEvenIfNotSeen) {
            super(pMob, pSpeedModifier, pFollowingTargetEvenIfNotSeen);
            this.mob = pMob;
        }

        @Override
        public boolean canUse() {
            if (this.mob.isStunned()){
                return false;
            }
            return super.canUse();
        }

        @Override
        public void tick() {
            super.tick();
            LivingEntity livingentity = this.mob.getTarget();

            if (this.attackAnimSync > 0){
                this.attackAnimSync--;
            }

            if (this.attackAnimSync == 0){
                if(livingentity != null) this.mob.doHurtTarget(livingentity);
                this.attackAnimSync = -1;
            }
        }

        @Override
        protected void checkAndPerformAttack(LivingEntity pTarget) {
            if (super.canPerformAttack(pTarget)) {
                this.resetAttackCooldown();
                triggerAnimation();
                this.mob.swing(InteractionHand.MAIN_HAND);
                this.attackAnimSync = this.adjustedTickDelay(5);
            }
        }

        protected void triggerAnimation() {
            mob.triggerAnim("attack_controller", "attack_animation");
        }

        @Override
        public boolean canContinueToUse() {
            if (this.mob.isStunned()){
                return false;
            }
            return super.canContinueToUse();

        }
    }


    public class CustomRandomStrollGoal extends RandomStrollGoal {
        protected final WitherJuggernaut mob;

        public CustomRandomStrollGoal(WitherJuggernaut pMob, double pSpeedModifier) {
            super(pMob, pSpeedModifier);
            this.mob = pMob;
        }


        @Override
        public boolean canUse() {
            if (this.mob.isStunned()){
                return false;
            }
            return super.canUse();
        }

        @Override
        public void tick() {
            super.tick();
            if (this.mob.isStunned()){
                this.stop();
            }
        }

        @Override
        public boolean canContinueToUse() {
            if (this.mob.isStunned()){
                return false;
            }
            return super.canContinueToUse();

        }
    }

    public class CustomRandomLookAroundGoal extends RandomLookAroundGoal {
        protected final WitherJuggernaut mob;

        public CustomRandomLookAroundGoal(WitherJuggernaut pMob) {
            super(pMob);
            this.mob = pMob;
        }


        @Override
        public boolean canUse() {
            if (this.mob.isStunned()){
                return false;
            }
            return super.canUse();
        }

        @Override
        public boolean canContinueToUse() {
            if (this.mob.isStunned()){
                return false;
            }
            return super.canContinueToUse();

        }
    }

    public class CustomLookAtPlayerGoal extends LookAtPlayerGoal {
        protected final WitherJuggernaut mob;

        public CustomLookAtPlayerGoal(WitherJuggernaut pMob, Class<? extends LivingEntity> pLookAtType, float pLookDistance) {
            super(pMob, pLookAtType, pLookDistance);
            this.mob = pMob;
        }


        @Override
        public boolean canUse() {
            if (this.mob.isStunned()){
                return false;
            }
            return super.canUse();
        }

        @Override
        public boolean canContinueToUse() {
            if (this.mob.isStunned()){
                return false;
            }
            return super.canContinueToUse();

        }
    }

}
