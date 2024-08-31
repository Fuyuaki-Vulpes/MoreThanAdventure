package com.fuyuaki.morethanadventure.world.block;

import com.fuyuaki.morethanadventure.core.registry.MtaParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;

public class GeyserBlock extends Block {
    public static final BooleanProperty ERUPTING =  BooleanProperty.create("erupting");

    private final boolean nether;
    private static final int maxHeight = 16;


    public GeyserBlock(Properties p_49795_, boolean isNether) {
        super(p_49795_.randomTicks());
        this.nether = isNether;
        this.registerDefaultState(this.defaultBlockState().setValue(ERUPTING, Boolean.FALSE));


    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(ERUPTING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(ERUPTING, Boolean.FALSE);
    }


    public boolean isErupting(BlockState state) {
        return state.getValue(ERUPTING);
    }


    private void setEruptingAtHeight(Boolean bool, BlockState state, Level level, BlockPos pos) {
        level.setBlock(pos, state.setValue(ERUPTING,bool), 3);

    }





    @Override
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        super.randomTick(pState, pLevel, pPos, pRandom);

        if (isErupting(pState)){
            setEruptingAtHeight(Boolean.FALSE, pState, pLevel, pPos);
            return;
        }
        if (pRandom.nextFloat() > 0.4F) return;

        ((ServerLevel)pLevel).playSound(null,pPos, SoundEvents.GENERIC_EXPLODE.value(), SoundSource.BLOCKS,1.2F,0.1F);
        setEruptingAtHeight(Boolean.TRUE, pState, pLevel, pPos);
        AABB aabb = new AABB(pPos).expandTowards(pPos.above(maxHeight).getCenter());
        

    }


    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        super.animateTick(pState, pLevel, pPos, pRandom);
        if (isErupting(pState)){

            AABB aabb = new AABB(pPos.below()).expandTowards(pPos.above(maxHeight).getCenter()).inflate(0.5F);

            pLevel.getEntitiesOfClass(LivingEntity.class, aabb,livingEntity -> livingEntity.hurt(livingEntity.damageSources().hotFloor(),2.0F));




            for (int a = 0; this.nether ? a  < 20 : a < 60; a ++)
            {

                pLevel.addAlwaysVisibleParticle(this.nether ? MtaParticles.GEYSER_LAVA.get() : MtaParticles.GEYSER_WATER.get(),
                        true,
                        pPos.getX() + 0.5 + pRandom.triangle(-0.1,0.1),
                        pPos.getY() + 1.2,
                        pPos.getZ() + 0.5 + pRandom.triangle(-0.1,0.1),
                        0,
                        0,
                        0);


            }
        }

    }
}
