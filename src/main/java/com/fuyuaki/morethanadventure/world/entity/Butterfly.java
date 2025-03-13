package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEntityTypes;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.FlyingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.FlyingPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.util.HoverRandomPos;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class Butterfly extends Animal implements FlyingAnimal {
    public int pattern = 0;
    public int overlay = 0;
    private static final int TICKS_PER_FLAP = Mth.ceil(1.4959966F);




    private static final EntityDataAccessor<Integer> DATA_ID_PATTERN = SynchedEntityData.defineId(Butterfly.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> DATA_ID_OVERLAY = SynchedEntityData.defineId(Butterfly.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Byte> DATA_ID_COLOR = SynchedEntityData.defineId(Butterfly.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Byte> DATA_ID_COLOR_OVERLAY = SynchedEntityData.defineId(Butterfly.class, EntityDataSerializers.BYTE);


    public Butterfly(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.moveControl = new FlyingMoveControl(this, 60, false);
        this.setPathfindingMalus(PathType.LEAVES, 0.0F);

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(2, new Butterfly.ButterflyWanderGoal(this, 1.0F));
        this.goalSelector.addGoal(3, new FollowMobGoal(this, 1.0, 1.0F, 7.0F));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.25, p_335831_ -> p_335831_.is(ItemTags.SMALL_FLOWERS), false));
        this.goalSelector.addGoal(4, new BreedGoal(this, 1.25));
        this.goalSelector.addGoal(9, new FloatGoal(this));


    }

    @Override
    public void checkDespawn() {
        super.checkDespawn();
    }

    @Override
    protected void checkFallDamage(double pY, boolean pOnGround, BlockState pState, BlockPos pPos) {

    }



    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(ItemTags.SMALL_FLOWERS);
    }


    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        Butterfly otherParent = (Butterfly) pOtherParent;
        Butterfly baby = MtaEntityTypes.BUTTERFLY.get().create(pLevel, EntitySpawnReason.BREEDING);
        if (baby == null) return null;
        int pattern = pLevel.getRandom().nextBoolean() ? this.getPattern() : otherParent.getPattern();
        int overlay = pLevel.getRandom().nextBoolean() ? this.getOverlay() : otherParent.getOverlay();
        DyeColor patColor = pLevel.getRandom().nextBoolean() ? this.getColor() : otherParent.getColor();
        DyeColor overlayColor = pLevel.getRandom().nextBoolean() ? this.getOverlayColor() : otherParent.getOverlayColor();
        baby.setPatternAndColor(pattern,patColor);
        baby.setOverlayAndColor(overlay,overlayColor);
        return baby;
    }


    @Override
    public boolean isFlying() {
        return !this.onGround();
    }

    @Override
    protected PathNavigation createNavigation(Level pLevel) {
        FlyingPathNavigation flyingpathnavigation = new FlyingPathNavigation(this, pLevel);

        flyingpathnavigation.setCanOpenDoors(false);
        flyingpathnavigation.setCanFloat(false);
        return flyingpathnavigation;
    }


    @Override
    public boolean isFlapping() {
        return this.isFlying() && this.tickCount % TICKS_PER_FLAP == 0;
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createAnimalAttributes()
                .add(Attributes.MAX_HEALTH, 4.0F)
                .add(Attributes.FOLLOW_RANGE, 7.0)
                .add(Attributes.FLYING_SPEED,0.5)
                .add(Attributes.MOVEMENT_SPEED, 0.1F)
                ;
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
        super.defineSynchedData(pBuilder);
        pBuilder.define(DATA_ID_PATTERN, 0);
        pBuilder.define(DATA_ID_OVERLAY, 1);
        pBuilder.define(DATA_ID_COLOR, (byte) 1);
        pBuilder.define(DATA_ID_COLOR_OVERLAY, (byte) 1);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        this.setPatternAndColor(pCompound.getInt("Pattern"), DyeColor.byId(pCompound.getByte("Color")));
        this.setOverlayAndColor(pCompound.getInt("Overlay"), DyeColor.byId(pCompound.getByte("OverlayColor")));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("Pattern", this.getPattern());
        pCompound.putInt("Overlay", this.getOverlay());
        pCompound.putByte("Color", (byte) this.getColor().getId());
        pCompound.putByte("OverlayColor", (byte) this.getOverlayColor().getId());
    }



    public DyeColor getColor() {
        return DyeColor.byId(this.entityData.get(DATA_ID_COLOR));
    }
    public DyeColor getOverlayColor() {
        return DyeColor.byId(this.entityData.get(DATA_ID_COLOR_OVERLAY));
    }


    public void setPatternAndColor(int id, DyeColor pDyeColor) {
        byte b0 = this.entityData.get(DATA_ID_COLOR);
        this.entityData.set(DATA_ID_COLOR, (byte)(b0 & 240 | pDyeColor.getId() & 15));
        this.entityData.set(DATA_ID_PATTERN,id);
        this.pattern = id;
    }
    public void setOverlayAndColor(int id, DyeColor pDyeColor) {
        byte b0 = this.entityData.get(DATA_ID_COLOR_OVERLAY);
        this.entityData.set(DATA_ID_COLOR_OVERLAY, (byte)(b0 & 240 | pDyeColor.getId() & 15));
        this.entityData.set(DATA_ID_OVERLAY,id);
        this.overlay = id;

    }
    public int getPattern(){
        return this.entityData.get(DATA_ID_PATTERN);
    }
    public int getOverlay(){
        return this.entityData.get(DATA_ID_OVERLAY);
    }

    @javax.annotation.Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor pLevel, DifficultyInstance pDifficulty, EntitySpawnReason pSpawnType, @javax.annotation.Nullable SpawnGroupData pSpawnGroupData) {
        RandomSource randomsource = pLevel.getRandom();
        DyeColor[] adyecolor = DyeColor.values();
        DyeColor dyecolor = Util.getRandom(adyecolor, randomsource);
        DyeColor dyecolorb = Util.getRandom(adyecolor, randomsource);
        int pattern = pLevel.getRandom().nextInt(2);
        int overlay = pLevel.getRandom().nextInt(3);
        this.overlay = overlay;
        this.pattern = pattern;
        this.setPatternAndColor(pattern, dyecolor);
        this.setOverlayAndColor(overlay, dyecolorb);


        return super.finalizeSpawn(pLevel, pDifficulty, pSpawnType, pSpawnGroupData);
    }


    static class ButterflyWanderGoal extends WaterAvoidingRandomFlyingGoal {
        public ButterflyWanderGoal(PathfinderMob p_186224_, double p_186225_) {
            super(p_186224_, p_186225_);
        }

        @javax.annotation.Nullable
        @Override
        protected Vec3 getPosition() {
            Vec3 vec3 = null;
            if (this.mob.isInWater()) {
                vec3 = this.mob.getViewVector(0.0F);
                vec3 = HoverRandomPos.getPos(this.mob, 12, 9, vec3.x, vec3.z, (float) (Math.PI / 2), 3, 1);
            }
            if (this.mob.getRandom().nextFloat() >= 0.8F){
                vec3 = LandRandomPos.getPos(this.mob,12,7);
            }

            if (this.mob.getRandom().nextFloat() <= this.probability) {
                vec3 = this.getFlowerPos();
            }

            return vec3 == null ? super.getPosition() : vec3;
        }

        @javax.annotation.Nullable
        private Vec3 getFlowerPos() {
            BlockPos blockpos = this.mob.blockPosition();
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
            BlockPos.MutableBlockPos blockpos$mutableblockpos1 = new BlockPos.MutableBlockPos();

            for (BlockPos blockpos1 : BlockPos.betweenClosed(
                    Mth.floor(this.mob.getX() - 3.0),
                    Mth.floor(this.mob.getY() - 6.0),
                    Mth.floor(this.mob.getZ() - 3.0),
                    Mth.floor(this.mob.getX() + 3.0),
                    Mth.floor(this.mob.getY() + 6.0),
                    Mth.floor(this.mob.getZ() + 3.0)
            )) {
                if (!blockpos.equals(blockpos1)) {
                    BlockState blockstate = this.mob.level().getBlockState(blockpos$mutableblockpos1.setWithOffset(blockpos1, Direction.DOWN));
                    boolean flag = blockstate.getBlock() instanceof FlowerBlock || blockstate.is(BlockTags.FLOWERS);
                    if (flag
                            && this.mob.level().isEmptyBlock(blockpos1)
                            && this.mob.level().isEmptyBlock(blockpos$mutableblockpos.setWithOffset(blockpos1, Direction.UP))) {
                        return Vec3.atBottomCenterOf(blockpos1);
                    }
                }
            }

            return null;
        }
    }

}
