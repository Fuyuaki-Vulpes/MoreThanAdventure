package com.fuyuaki.morethanadventure.world.block;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ItemAbility;
import org.jetbrains.annotations.Nullable;

public class MtaFlammableRotatedPillarBlock extends RotatedPillarBlock {
    public MtaFlammableRotatedPillarBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ItemAbility itemAbility, boolean simulate) {
        if(context.getItemInHand().getItem() instanceof AxeItem){
            if(state.is(MtaBlocks.ALPINE_LOG.get())) {
                return MtaBlocks.STRIPPED_ALPINE_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if(state.is(MtaBlocks.ALPINE_WOOD.get())) {
                return MtaBlocks.STRIPPED_AVOCADO_WOOD.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if(state.is(MtaBlocks.AVOCADO_LOG.get())) {
                return MtaBlocks.STRIPPED_AVOCADO_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if(state.is(MtaBlocks.AVOCADO_WOOD.get())) {
                return MtaBlocks.STRIPPED_AVOCADO_WOOD.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if(state.is(MtaBlocks.IPE_LOG.get())) {
                return MtaBlocks.STRIPPED_IPE_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if(state.is(MtaBlocks.IPE_WOOD.get())) {
                return MtaBlocks.STRIPPED_IPE_WOOD.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if(state.is(MtaBlocks.MANGO_LOG.get())) {
                return MtaBlocks.STRIPPED_MANGO_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if(state.is(MtaBlocks.MANGO_WOOD.get())) {
                return MtaBlocks.STRIPPED_MANGO_WOOD.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if(state.is(MtaBlocks.MAPLE_LOG.get())) {
                return MtaBlocks.STRIPPED_MAPLE_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if(state.is(MtaBlocks.MAPLE_WOOD.get())) {
                return MtaBlocks.STRIPPED_MAPLE_WOOD.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if(state.is(MtaBlocks.PALM_LOG.get())) {
                return MtaBlocks.STRIPPED_PALM_LOG.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
            if(state.is(MtaBlocks.PALM_WOOD.get())) {
                return MtaBlocks.STRIPPED_PALM_WOOD.get().defaultBlockState().setValue(AXIS,state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, itemAbility, simulate);
    }
}
