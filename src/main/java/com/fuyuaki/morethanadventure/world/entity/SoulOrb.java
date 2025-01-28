package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEntityTypes;
import com.fuyuaki.morethanadventure.world.entity.attachments.helper.MTASoulHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForgeMod;

public class SoulOrb extends Entity {
    private static final int LIFETIME = 600;
    private static final int ENTITY_SCAN_PERIOD = 20;
    private static final int MAX_FOLLOW_DIST = 8;
    private static final int ORB_GROUPS_PER_AREA = 40;
    private static final double ORB_MERGE_DISTANCE = 0.5;
    private int age;
    private int health = 5;
    public int value;
    private Player followingPlayer;

    public SoulOrb(Level level, double x, double y, double z, int value) {
        this(MtaEntityTypes.SOUL_ORB.get(), level);
        this.setPos(
                x + level.random.nextFloat() - 0.5F,
                y + level.random.nextFloat() - 0.5F,
                z + level.random.nextFloat() - 0.5F
        );
        this.setYRot((float) (this.random.nextDouble() * 360.0));
        float lengthMovement = 0.2F;
        this.setDeltaMovement(
                (this.random.nextDouble() * 0.2F - 0.1F) * lengthMovement,
                this.random.nextDouble() * 0.2 * lengthMovement,
                (this.random.nextDouble() * 0.2F - 0.1F) * lengthMovement
        );
        this.value = value;
    }

    public SoulOrb(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

    }


    @Override
    public boolean hurtClient(DamageSource damageSource) {
        return super.hurtClient(damageSource);
    }

    @Override
    public boolean hurtServer(ServerLevel level, DamageSource damageSource, float amount) {
        if (this.isInvulnerableToBase(damageSource)) {
            return false;
        } else {
            this.markHurt();
            this.health = (int) ((float) this.health - amount);
            if (this.health <= 0) {
                this.discard();
            }

            return true;
        }
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {
        tag.putShort("Health", (short) this.health);
        tag.putShort("Age", (short) this.age);
        tag.putShort("Value", (short) this.value);
    }


    @Override
    protected Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.NONE;
    }


    @Override
    protected double getDefaultGravity() {
        return 0.02;
    }

    @Override
    public void tick() {
        super.tick();
        this.xo = this.getX();
        this.yo = this.getY();
        this.zo = this.getZ();
        if (this.isEyeInFluidType(NeoForgeMod.WATER_TYPE.value())) {
            this.setUnderwaterMovement();
        } else {
            this.applyGravity();
        }

        if (this.level().getFluidState(this.blockPosition()).is(FluidTags.LAVA)) {
            this.setDeltaMovement(
                    (double) ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F),
                    0.2F,
                    (double) ((this.random.nextFloat() - this.random.nextFloat()) * 0.2F)
            );
        }

        if (!this.level().noCollision(this.getBoundingBox())) {
            this.moveTowardsClosestSpace(this.getX(), (this.getBoundingBox().minY + this.getBoundingBox().maxY) / 2.0, this.getZ());
        }

        if (this.tickCount % 20 == 1) {
            this.scanForEntities();
        }

        if (this.followingPlayer != null && (this.followingPlayer.isSpectator() || this.followingPlayer.isDeadOrDying())) {
            this.followingPlayer = null;
        }

        if (this.followingPlayer != null) {
            Vec3 vec3 = new Vec3(
                    this.followingPlayer.getX() - this.getX(),
                    this.followingPlayer.getY() + (double) this.followingPlayer.getEyeHeight() / 2.0 - this.getY(),
                    this.followingPlayer.getZ() - this.getZ()
            );
            double d0 = vec3.lengthSqr();
            if (d0 < 64.0) {
                double d1 = 1.0 - Math.sqrt(d0) / 8.0;
                this.setDeltaMovement(this.getDeltaMovement().add(vec3.normalize().scale(d1 * d1 * 0.05)));
            }
        }

        double d2 = this.getDeltaMovement().y;
        this.move(MoverType.SELF, this.getDeltaMovement());
        this.applyEffectsFromBlocks();
        float f = 0.98F;
        if (this.onGround()) {
            BlockPos pos = getBlockPosBelowThatAffectsMyMovement();
            f = this.level().getBlockState(pos).getFriction(this.level(), pos, this) * 0.98F;
        }

        this.setDeltaMovement(this.getDeltaMovement().multiply((double) f, 0.98, (double) f));


        this.age++;
        if (this.age >= LIFETIME) {
            this.discard();
        }
        Vec3i posV = new Vec3i((int) this.position().x, (int) (this.position().y - 0.5), (int) this.position().z);
        if (!this.level().getBlockState(new BlockPos(posV)).isAir()){
            this.setDeltaMovement(this.getDeltaMovement().add(0.0, this.getGravity(), 0.0));
        }
    }


    @Override
    public BlockPos getBlockPosBelowThatAffectsMyMovement() {
        return this.getOnPos(0.999999F);
    }

    private void scanForEntities() {
        if (this.followingPlayer == null || this.followingPlayer.distanceToSqr(this) > 64.0) {
            this.followingPlayer = this.level().getNearestPlayer(this, 8.0F);
        }
    }


    private void setUnderwaterMovement() {
        Vec3 vec3 = this.getDeltaMovement();
        this.setDeltaMovement(vec3.x * 0.99F, Math.min(vec3.y + 5.0E-4F, 0.06F), vec3.z * 0.99F);
    }

    @Override
    protected void doWaterSplashEffect() {
    }

    @Override
    protected void applyGravity() {
        Vec3i posV = new Vec3i((int) this.position().x, (int) (this.position().y - 1.0), (int) this.position().z);
        if (this.level().getBlockState(new BlockPos(posV)).isAir()){
            super.applyGravity();
        }
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {
        this.health = tag.getShort("Health");
        this.age = tag.getShort("Age");
        this.value = tag.getShort("Value");
    }

    @Override
    public boolean isAttackable() {
        return false;
    }

    @Override
    public void playerTouch(Player entity) {
        if (entity instanceof ServerPlayer serverplayer) {

            entity.take(this, 1);
            if (this.value > 0) {
                MTASoulHelper.playerAddSoul(this.value, entity);
                Vec3 pos = serverplayer.position();
                entity.level().playSound(null, pos.x,pos.y,pos.z,SoundEvents.SCULK_CATALYST_BLOOM, SoundSource.PLAYERS,0.5F,0.5F + this.level().getRandom().nextFloat());
            }

            this.discard();

        }
    }


}

