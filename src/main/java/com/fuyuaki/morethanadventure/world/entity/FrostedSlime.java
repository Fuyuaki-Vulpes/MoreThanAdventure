package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.registry.MtaSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.gameevent.GameEvent;
import org.jetbrains.annotations.Nullable;

public class FrostedSlime extends Slime {
    public FrostedSlime(EntityType<? extends Slime> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.35F);
    }

    @Override
    protected ParticleOptions getParticleType() {
        return ParticleTypes.SNOWFLAKE;
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (!this.level().isClientSide) {

            if (this.level().getBiome(this.blockPosition()).is(BiomeTags.SNOW_GOLEM_MELTS)) {
                this.hurt(this.damageSources().onFire(), 1.0F);
            }

            if (!net.neoforged.neoforge.event.EventHooks.canEntityGrief((ServerLevel) this.level(), this)) {
                return;
            }

            BlockState blockstate1 = Blocks.SNOW.defaultBlockState();
            BlockState blockstate2 = Blocks.ICE.defaultBlockState();

            for (int i = 0; i < 4; i++) {
                int j = Mth.floor(this.getX() + (double)((float)(i % 2 * 2 - 1) * 0.25F));
                int k = Mth.floor(this.getY());
                int l = Mth.floor(this.getZ() + (double)((float)(i / 2 % 2 * 2 - 1) * 0.25F));
                BlockPos blockpos = new BlockPos(j, k, l);
                if (this.level().getBlockState(blockpos).isAir() && blockstate1.canSurvive(this.level(), blockpos)) {
                    this.level().setBlockAndUpdate(blockpos, blockstate1);
                    this.level().gameEvent(GameEvent.BLOCK_PLACE, blockpos, GameEvent.Context.of(this, blockstate1));
                }
                else if (this.level().getBlockState(blockpos).is(Blocks.WATER) && blockstate2.canSurvive(this.level(), blockpos)) {
                    this.level().setBlockAndUpdate(blockpos, blockstate2);
                    this.level().gameEvent(GameEvent.BLOCK_PLACE, blockpos, GameEvent.Context.of(this, blockstate2));
                }
            }
        }
    }


    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return MtaSounds.FROSTED_SLIME_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return MtaSounds.FROSTED_SLIME_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return MtaSounds.FROSTED_SLIME_DEATH.get();
    }

    public static boolean checkSpawnRules(
            EntityType<? extends Slime> type, ServerLevelAccessor level, EntitySpawnReason spawnType, BlockPos pos, RandomSource random
    ) {
        return level.getDifficulty() != Difficulty.PEACEFUL
                && (EntitySpawnReason.ignoresLightRequirements(spawnType) || isDarkEnoughToSpawn(level, pos, random));
    }

    public static boolean isDarkEnoughToSpawn(ServerLevelAccessor level, BlockPos pos, RandomSource random) {
        if (level.getBrightness(LightLayer.SKY, pos) > random.nextInt(32)) {
            return false;
        } else {
            DimensionType dimensiontype = level.dimensionType();
            int i = dimensiontype.monsterSpawnBlockLightLimit();
            if (i < 15 && level.getBrightness(LightLayer.BLOCK, pos) > i) {
                return false;
            } else {
                int j = level.getLevel().isThundering() ? level.getMaxLocalRawBrightness(pos, 10) : level.getMaxLocalRawBrightness(pos);
                return j <= dimensiontype.monsterSpawnLightTest().sample(random);
            }
        }
    }
}
