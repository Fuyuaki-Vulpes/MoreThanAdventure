package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.registry.MtaEntityTypes;
import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.PathType;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.EnumSet;

public class Octopus extends MTATameableAnimal implements GeoEntity {
    protected static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.octopus.walk");
    protected static final RawAnimation SWIM = RawAnimation.begin().thenLoop("animation.octopus.swim");


    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);


    public Octopus(EntityType<? extends MTATameableAnimal> pEntityType, Level pLevel) {
        super(40.0F,pEntityType, pLevel);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
        this.setPathfindingMalus(PathType.WATER_BORDER, 0.0F);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new TamableAnimal.TamableAnimalPanicGoal(1.5, DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
        this.goalSelector.addGoal(2, new OctopusSitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.25, stack -> stack.is(ItemTags.FISHES), false));
        this.goalSelector.addGoal(4, new BreedGoal(this, 1.25));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25));
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new RandomSwimmingGoal(this, 1.0,20));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
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
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 9.0F)
                .add(Attributes.FOLLOW_RANGE, 7.0)
                .add(Attributes.MOVEMENT_SPEED, 0.15F)
                .add(Attributes.WATER_MOVEMENT_EFFICIENCY, 2.2F);
    }


    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(ItemTags.FISHES);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        Octopus octopus = MtaEntityTypes.OCTOPUS.get().create(pLevel);
        return octopus;
    }

    @Override
    public boolean onClimbable() {
        return this.isClimbing();
    }

    public boolean isClimbing() {
        return (this.entityData.get(DATA_FLAGS_ID) & 1) != 0;
    }

    /**
     * Updates the WatchableObject (Byte) created in entityInit(), setting it to 0x01 if par1 is true or 0x00 if it is false.
     */
    public void setClimbing(boolean pClimbing) {
        byte b0 = this.entityData.get(DATA_FLAGS_ID);
        if (pClimbing) {
            b0 = (byte)(b0 | 1);
        } else {
            b0 = (byte)(b0 & -2);
        }

        this.entityData.set(DATA_FLAGS_ID, b0);
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide) {
            this.setClimbing(this.horizontalCollision);
        }
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
                new AnimationController<>(this, 10, (state) -> {
                    if (state.isMoving() && onGround()) {
                        return state.setAndContinue(WALK);
                    } else if(isInWater() && !onGround()) {
                        return state.setAndContinue(SWIM);
                    }
                    return state.setAndContinue(DefaultAnimations.IDLE);
                })
        );
    }

    @Override
    public boolean checkSpawnObstruction(LevelReader pLevel) {
        return pLevel.isUnobstructed(this);
    }

    @Override
    public int getAmbientSoundInterval() {
        return 120;
    }

    @Override
    protected int getBaseExperienceReward() {
        return 1 + this.level().random.nextInt(3);
    }

    protected void handleAirSupply(int pAirSupply) {
        if (this.isAlive() && !this.isInWaterOrBubble()) {
            this.setAirSupply(pAirSupply - 1);
            if (this.getAirSupply() == -20) {
                this.setAirSupply(0);
                this.hurt(this.damageSources().drown(), 2.0F);
            }
        } else {
            this.setAirSupply(300);
        }
    }

    @Override
    public void baseTick() {
        int i = this.getAirSupply();
        super.baseTick();
        this.handleAirSupply(i);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    public class OctopusSitWhenOrderedToGoal extends Goal {
        private final TamableAnimal mob;

        public OctopusSitWhenOrderedToGoal(TamableAnimal pMob) {
            this.mob = pMob;
            this.setFlags(EnumSet.of(Goal.Flag.JUMP, Goal.Flag.MOVE));
        }

        @Override
        public boolean canContinueToUse() {
            return this.mob.isOrderedToSit();
        }

        @Override
        public boolean canUse() {
            if (!this.mob.isTame()) {
                return false;
            } else if (!this.mob.isInWaterOrBubble()) {
                return false;
            } else {
                LivingEntity livingentity = this.mob.getOwner();
                if (livingentity == null) {
                    return true;
                } else {
                    return this.mob.distanceToSqr(livingentity) < 144.0 && livingentity.getLastHurtByMob() != null ? false : this.mob.isOrderedToSit();
                }
            }
        }

        @Override
        public void start() {
            this.mob.getNavigation().stop();
            this.mob.setInSittingPose(true);
        }

        @Override
        public void stop() {
            this.mob.setInSittingPose(false);
        }
    }

}
