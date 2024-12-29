package com.fuyuaki.morethanadventure.world.block;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlockEntities;
import com.fuyuaki.morethanadventure.world.block.entity.SprinklerEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class Sprinkler extends BaseEntityBlock {

    public static final MapCodec<Sprinkler> CODEC = simpleCodec(Sprinkler::new);
    public static final BooleanProperty ON = BooleanProperty.create("enabled");
    private static final VoxelShape SHAPE =  Shapes.join(Block.box(0, 0, 0, 16, 12, 16), Block.box(4, 12, 4, 12, 17, 12), BooleanOp.OR);



    public Sprinkler(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(ON, Boolean.valueOf(false)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(ON);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return defaultBlockState().setValue(ON,Boolean.valueOf(false));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if (pLevel.isClientSide) {
            if ( pPlayer.isCrouching()){
            pLevel.playLocalSound(pPos, SoundEvents.WOODEN_BUTTON_CLICK_OFF, SoundSource.BLOCKS,1.0F,1.0F,false);
            }

            return InteractionResult.SUCCESS;
        }

        BlockState state = pLevel.getBlockState(pPos);
        if (state.getValue(ON) && pPlayer.isCrouching()){
            pLevel.setBlock(pPos, state.setValue(ON, Boolean.valueOf(false)), 3);

        } else if (!state.getValue(ON) && pPlayer.isCrouching()){
            pLevel.setBlock(pPos, state.setValue(ON, Boolean.valueOf(true)), 3);

        }

        return InteractionResult.CONSUME;

    }

    @Override
    protected void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        super.tick(pState, pLevel, pPos, pRandom);

    }


    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        if (pLevel.isClientSide) {
            return pState.getValue(ON) ? createTickerHelper(pBlockEntityType, MtaBlockEntities.SPRINKLER.get(), SprinklerEntity::particleTick) : null;
        }
         return pState.getValue(ON) ? createTickerHelper(pBlockEntityType, MtaBlockEntities.SPRINKLER.get(), SprinklerEntity::growthTick) : null;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return MtaBlockEntities.SPRINKLER.get().create(pos, state);
    }

}
