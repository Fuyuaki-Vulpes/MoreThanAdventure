package com.fuyuaki.morethanadventure.world.event;


import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class MTACommonEvents {

    @SubscribeEvent
    public static void onRightClickEvent(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getEntity();
        BlockPos pos = event.getPos();
        Level level = event.getLevel();
        BlockState block = level.getBlockState(pos);
        if (event.getItemStack().canPerformAction(ItemAbilities.SHOVEL_FLATTEN)) {

            if (!event.getHitVec().getDirection().equals(Direction.DOWN)) {
                if (block.is(Blocks.SAND) && level.getBlockState(pos.above()).isAir()) {
                    level.setBlockAndUpdate(pos, MtaBlocks.SAND_PATH.get().defaultBlockState());
                    event.getItemStack().hurtAndBreak(1, player, LivingEntity.getSlotForHand(event.getHand()));
                    level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, MtaBlocks.SAND_PATH.get().defaultBlockState()));
                    player.swing(event.getHand());
                }
            }

        }
    }
}
