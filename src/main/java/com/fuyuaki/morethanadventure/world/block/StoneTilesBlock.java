package com.fuyuaki.morethanadventure.world.block;

import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.common.ItemAbilities;

public class StoneTilesBlock extends Block {
    protected final int dirtiness;
    public StoneTilesBlock(Properties p_49795_, int dirtiness) {
        super(p_49795_);
        this.dirtiness = dirtiness;
    }

    @Override
    protected boolean isRandomlyTicking(BlockState pState) {
        return this.dirtiness < 3;
    }

    @Override
    protected void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        super.randomTick(pState, pLevel, pPos, pRandom);
        if (pRandom.nextFloat() < 0.25 && pLevel.getBlockStates(new AABB(pPos).inflate(2)).anyMatch(state -> state.is(MtaTags.Blocks.DIRTIES_STONE_TILES))){
            pLevel.setBlockAndUpdate(pPos, getStoneTilesByDirtiness(this.dirtiness + 1));
        }


    }

    @Override
    protected InteractionResult useItemOn(ItemStack pStack, BlockState p_316362_, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand p_316595_, BlockHitResult p_316140_) {
        if (pStack.canPerformAction(ItemAbilities.SHOVEL_FLATTEN) && this.dirtiness > 0){

            pLevel.playSound(pPlayer, pPos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 0.3F);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, MtaBlocks.SAND_PATH.get().defaultBlockState()));
            pLevel.setBlockAndUpdate(pPos, getStoneTilesByDirtiness(this.dirtiness - 1));
        }
        return super.useItemOn(pStack, p_316362_, pLevel, pPos, pPlayer, p_316595_, p_316140_);
    }

    /*
    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        if (pStack.canPerformAction(ItemAbilities.SHOVEL_FLATTEN) && this.dirtiness > 0){

            pLevel.playSound(pPlayer, pPos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 0.3F);
            pLevel.gameEvent(GameEvent.BLOCK_CHANGE, pPos, GameEvent.Context.of(pPlayer, MtaBlocks.SAND_PATH.get().defaultBlockState()));
            pLevel.setBlockAndUpdate(pPos, getStoneTilesByDirtiness(this.dirtiness - 1));
        }
        return super.useItemOn(pStack, pState, pLevel, pPos, pPlayer, pHand, pHitResult);
    }*/

    private BlockState getStoneTilesByDirtiness(int dirtiness) {
        return switch (dirtiness){
            case 1 -> MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES.get().defaultBlockState();
            case 2 ->MtaBlocks.DIRTY_STONE_TILES.get().defaultBlockState();
            case 3 -> MtaBlocks.VERY_DIRTY_STONE_TILES.get().defaultBlockState();
            default -> MtaBlocks.STONE_TILES.get().defaultBlockState();
        };
    }

}
