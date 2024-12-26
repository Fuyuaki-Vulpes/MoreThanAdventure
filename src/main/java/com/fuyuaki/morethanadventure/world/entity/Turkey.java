package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEntityTypes;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.Nullable;

public class Turkey extends Animal {
    private static final EntityDataAccessor<Integer> GOBBLE = SynchedEntityData.defineId(Turkey.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Boolean> LEADER = SynchedEntityData.defineId(Turkey.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> GOBBLING = SynchedEntityData.defineId(Turkey.class, EntityDataSerializers.BOOLEAN);

    public Turkey(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.4));
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1.0, p_335679_ -> p_335679_.is(Tags.Items.SEEDS), false));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.1));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(GOBBLE, 0).define(GOBBLING,false).define(LEADER,false);
    }



    public void setGobble(int count) {
            this.entityData.set(GOBBLE, count);

    }


    public void setLeader(boolean value) {
            this.entityData.set(LEADER, value);
    }
    public boolean getLeader() {
        return this.entityData.get(LEADER);
    }

    public void setGobbling(boolean value) {
            this.entityData.set(GOBBLING, value);
    }
    public boolean getGobbling() {
        return this.entityData.get(GOBBLING);
    }


    public void subGobble(int count){
        setGobble(this.entityData.get(GOBBLE) - count);
        if (this.entityData.get(GOBBLE) < 0){
            setGobble(0);
        }
    }
    public int getGobble(){
        return this.entityData.get(GOBBLE);
    }
    public void tickGobble(){
        if (getGobble() > 0){
            subGobble(1);
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level().isClientSide){
            tickGobble();
            if (getGobbling() && this.random.nextFloat() < 0.1F){
                if (getLeader()){
                    this.level().getEntitiesOfClass(Turkey.class,this.getBoundingBox().inflate(20,5,20)).forEach(
                            turkey -> turkey.setGobbling(true)
                    );
                    setLeader(false);
                }
                setGobbling(false);
                this.playAmbientSound();
                setGobble(this.random.nextIntBetweenInclusive(400,900));
            }
            if (this.random.nextDouble() < 0.001 && getGobble() <= 0){
                setGobbling(true);
                setLeader(true);
            }
        }
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 9.0F)
                .add(Attributes.FOLLOW_RANGE, 7.0)
                .add(Attributes.ATTACK_DAMAGE, 6.0)
                .add(Attributes.MOVEMENT_SPEED, 0.2F);
    }

    @Override
    public int getAmbientSoundInterval() {
        return 700;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return MtaSounds.TURKEY_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return MtaSounds.TURKEY_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return MtaSounds.TURKEY_DEATH.get();
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Tags.Items.SEEDS);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        Turkey turkey = MtaEntityTypes.TURKEY.get().create(level, EntitySpawnReason.BREEDING);
        turkey.setAge(-24000);
        return turkey;
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        compound.putInt("Gobble", this.getGobble());
        compound.putBoolean("Gobbling", this.getGobbling());
        compound.putBoolean("Leader", this.getLeader());

    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        this.setGobble(compound.getInt("Gobble"));
        this.setGobbling(compound.getBoolean("Gobbling"));
        this.setLeader(compound.getBoolean("Leader"));

    }
}
