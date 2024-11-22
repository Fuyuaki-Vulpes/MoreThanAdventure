package com.fuyuaki.morethanadventure.world.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.tags.BiomeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

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

            if (!net.neoforged.neoforge.event.EventHooks.canEntityGrief(this.level(), this)) {
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


}
