package com.fuyuaki.morethanadventure.world.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;

public class WallMushroomBlock extends MultifaceSpreadeableBlock implements SimpleWaterloggedBlock, BonemealableBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private final boolean canWaterlog;
    public static final MapCodec<WallMushroomBlock> CODEC = simpleCodec(WallMushroomBlock::new);
    private final MultifaceSpreader spreader = new MultifaceSpreader(this);

    public WallMushroomBlock(Properties properties) {
        this(properties,false);

    }

    public WallMushroomBlock(Properties properties, boolean survivesUnderwater) {
        super(properties);
        this.canWaterlog = survivesUnderwater;
        if (survivesUnderwater) {
            this.registerDefaultState(this.defaultBlockState().setValue(WATERLOGGED, Boolean.valueOf(false)));
        }
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return super.canSurvive(state, level, pos);
    }


    @Override
    protected BlockState updateShape(BlockState p_153904_, LevelReader p_374463_, ScheduledTickAccess p_374073_, BlockPos p_153908_, Direction p_153905_, BlockPos p_153909_, BlockState p_153906_, RandomSource p_374390_) {
        if (p_153904_.getValue(WATERLOGGED)) {
            p_374073_.scheduleTick(p_153908_, Fluids.WATER, Fluids.WATER.getTickDelay(p_374463_));
        }
        return super.updateShape(p_153904_, p_374463_, p_374073_, p_153908_, p_153905_, p_153909_, p_153906_, p_374390_);
    }

    @Override
    protected boolean canBeReplaced(BlockState state, BlockPlaceContext useContext) {
        return !useContext.getItemInHand().is(this.asItem()) || super.canBeReplaced(state, useContext);
    }
    @Override
    protected boolean isFaceSupported(Direction face) {
        return face.getAxis().isHorizontal();
    }

    @Override
    protected FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public MapCodec<? extends MultifaceSpreadeableBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        if (this.canWaterlog){
            builder.add(WATERLOGGED);
        }
    }

    @Override
    public MultifaceSpreader getSpreader() {
        return this.spreader;
    }


    @Override
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        popResource(level,pos, new ItemStack(this));
    }


    @Override
    protected boolean propagatesSkylightDown(BlockState p_320652_) {
        return p_320652_.getFluidState().isEmpty();
    }




}
