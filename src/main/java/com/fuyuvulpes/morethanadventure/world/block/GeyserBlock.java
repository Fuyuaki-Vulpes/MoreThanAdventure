package com.fuyuvulpes.morethanadventure.world.block;

import com.fuyuvulpes.morethanadventure.core.registry.MtaParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.entity.EntityTypeTest;
import net.minecraft.world.phys.AABB;
import net.neoforged.neoforge.common.Tags;

import java.util.List;

public class GeyserBlock extends Block {
    private final boolean nether;
    private boolean erupting;
    private int currentHeight;
    private final int maxHheight = 16;


    public GeyserBlock(Properties p_49795_, boolean isNether) {
        super(p_49795_.randomTicks());
        this.nether = isNether;
    }

    public void setErupting(boolean erupting) {
        this.erupting = erupting;
    }

    public boolean isErupting() {
        return erupting;
    }

    public void setCurrentHeight(int currentHeight) {
        this.currentHeight = currentHeight;
    }

    public int getCurrentHeight() {
        return this.currentHeight;
    }

    public int getMaxHheight() {
        return maxHheight;
    }

    @Override
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        super.randomTick(pState, pLevel, pPos, pRandom);
        ((ServerLevel)pLevel).playSound(null,pPos, SoundEvents.GENERIC_EXPLODE.value(), SoundSource.BLOCKS,0.3F,10.0F);

        setErupting(true);

        AABB aabb = new AABB(pPos).expandTowards(pPos.above(getMaxHheight()).getCenter());

        pLevel.getEntitiesOfClass(LivingEntity.class, aabb,livingEntity -> livingEntity.hurt(livingEntity.damageSources().hotFloor(),3.0F));


    }



    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        super.animateTick(pState, pLevel, pPos, pRandom);
        if (isErupting()) {


            float height = getCurrentHeight();
            if (getCurrentHeight() < 0) {
                setCurrentHeight(0);
            }
            this.setCurrentHeight(getCurrentHeight() + 2);

            if (getCurrentHeight() > getMaxHheight()) {
                setCurrentHeight(0);
                setErupting(false);
            }



            AABB aabb = new AABB(pPos.below()).expandTowards(pPos.above(getMaxHheight()).getCenter()).inflate(0.5F);

            pLevel.getEntitiesOfClass(LivingEntity.class, aabb,livingEntity -> livingEntity.hurt(livingEntity.damageSources().hotFloor(),3.0F));




            for (float a = 0; this.nether ? a  < 10 : a < 20; a += 0.5F)
            {

            pLevel.addParticle(this.nether ? MtaParticles.GEYSER_LAVA.get() : MtaParticles.GEYSER_WATER.get(), true, pPos.getCenter().x, pPos.getY() + 1.2, pPos.getCenter().z, 0,0,0);


            }

        }
    }


}
