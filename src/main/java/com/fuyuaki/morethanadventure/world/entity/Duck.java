package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.registry.MtaEntityTypes;
import com.fuyuaki.morethanadventure.core.registry.MtaSounds;
import com.mojang.serialization.Codec;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntFunction;

public class Duck extends MTATameableAnimal implements GeoEntity, VariantHolder<Duck.Variant> {
    private static final EntityDataAccessor<Integer> VARIANT =
            SynchedEntityData.defineId(Duck.class, EntityDataSerializers.INT);

    protected static final RawAnimation IDLE = RawAnimation.begin().thenLoop("animation.duck.idle");
    protected static final RawAnimation WALK = RawAnimation.begin().thenLoop("animation.duck.walk");
    protected static final RawAnimation SWIM = RawAnimation.begin().thenLoop("animation.duck.swim");
    protected static final RawAnimation IN_WATER = RawAnimation.begin().thenLoop("animation.duck.in_water");
    protected static final RawAnimation SIT = RawAnimation.begin().thenPlayAndHold("animation.duck.sit");


    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);


    public Duck(EntityType<? extends MTATameableAnimal> pEntityType, Level pLevel) {
        super(50.0F,pEntityType, pLevel);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new TamableAnimal.TamableAnimalPanicGoal(1.5, DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.25, p_335831_ -> p_335831_.is(Items.BREAD), false));
        this.goalSelector.addGoal(4, new BreedGoal(this, 1.25));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.25));
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(5, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(5, new RandomSwimmingGoal(this, 1.0,20));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }



    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 6.0F)
                .add(Attributes.FOLLOW_RANGE, 7.0)
                .add(Attributes.MOVEMENT_SPEED, 0.2F);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {


        return MtaSounds.DUCK_AMBIENT.get();
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(Items.BREAD);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        Duck duck = MtaEntityTypes.DUCK.get().create(pLevel);
        return duck;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
                new AnimationController<>(this, 10, (state) -> {
                if(isOrderedToSit()){
                        return state.setAndContinue(SIT);
                    }
                else if (state.isMoving() && isInWater()){
                    return state.setAndContinue(SWIM);
                }
                else if(state.isMoving() && !isInWater()) {
                        return state.setAndContinue(WALK);
                    }
                else if(isInWater()){
                    return  state.setAndContinue(IN_WATER);
                }
                    return state.setAndContinue(DefaultAnimations.IDLE);
                })
        );
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    public Duck.Variant getVariant() {
        return Duck.Variant.byId(this.entityData.get(VARIANT));
    }

    public void setVariant(Duck.Variant pVariant) {
        this.entityData.set(VARIANT, pVariant.id);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(VARIANT, 0);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Variant", this.getVariant().id);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setVariant(Duck.Variant.byId(pCompound.getInt("Variant")));
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, MobSpawnType pSpawnType, @Nullable SpawnGroupData pSpawnGroupData) {
        Variant varient = Util.getRandom(Variant.values(), this.random);
        this.setVariant(varient);
        return super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, pSpawnGroupData);
    }

    public static enum Variant implements StringRepresentable {
        MALLARD(0, "mallard"),
        MARBLED(1, "marbled"),
        WHITE(2, "white");

        public static final Codec<Duck.Variant> CODEC = StringRepresentable.fromEnum(Duck.Variant::values);
        private static final IntFunction<Duck.Variant> BY_ID = ByIdMap.continuous(Duck.Variant::getId, values(), ByIdMap.OutOfBoundsStrategy.CLAMP);
        final int id;
        private final String name;

        private Variant(int pId, String pName) {
            this.id = pId;
            this.name = pName;
        }

        public int getId() {
            return this.id;
        }

        public static Duck.Variant byId(int pId) {
            return BY_ID.apply(pId);
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }

}
