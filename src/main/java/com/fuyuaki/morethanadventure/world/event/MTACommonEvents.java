package com.fuyuaki.morethanadventure.world.event;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlocks;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import com.fuyuaki.morethanadventure.core.registry.MTALootTables;
import com.fuyuaki.morethanadventure.world.entity.SoulOrb;
import com.fuyuaki.morethanadventure.world.entity.attachments.helper.MTASoulHelper;
import com.fuyuaki.morethanadventure.world.item.accessories.TalismanItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME)
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
                if (block.is(Blocks.DIRT_PATH) && level.getBlockState(pos.above()).isAir()) {
                    level.setBlockAndUpdate(pos, MtaBlocks.COARSE_DIRT_PATH.get().defaultBlockState());
                    event.getItemStack().hurtAndBreak(1, player, LivingEntity.getSlotForHand(event.getHand()));
                    level.playSound(player, pos, SoundEvents.SHOVEL_FLATTEN, SoundSource.BLOCKS, 1.0F, 1.0F);
                    level.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, MtaBlocks.COARSE_DIRT_PATH.get().defaultBlockState()));
                    player.swing(event.getHand());
                }
            }

        }
    }

    @SubscribeEvent
    public static void entityOnDeath(LivingDeathEvent event) {
        Level level = event.getEntity().level();
        Vec3 pos = event.getEntity().position();
        LivingEntity attacker = event.getEntity().getLastHurtByMob();
        if (attacker instanceof Player){
            int count = event.getEntity().getRandom().nextIntBetweenInclusive(1, 3);
            for (int n = 0; n < count; n++) {
                level.addFreshEntity(new SoulOrb(level, pos.x(), event.getEntity().getEyeY(), pos.z(), Math.max(MTASoulHelper.getSoulValueForEntity(event.getEntity()) / count, 1)));

            }
        }

    }
    @SubscribeEvent
    public static void entityOnDrop(LivingDropsEvent event) {
        if (event.isRecentlyHit() && event.getSource().is(DamageTypes.ARROW)) {
            Entity n = event.getSource().getEntity();
            if (n instanceof LivingEntity living) {
                LootTable lootTable = living.level().getServer().reloadableRegistries().getLootTable(MTALootTables.ARROW_QUIVER_BONUS);
                LootParams.Builder lootparams$builder = new LootParams.Builder((ServerLevel) living.level());

                LootParams lootparams = lootparams$builder.withParameter(LootContextParams.ORIGIN, event.getEntity().position())
                        .withParameter(LootContextParams.THIS_ENTITY, living)
                        .create(LootContextParamSets.GIFT);

                lootTable.getRandomItems(lootparams, living.getLootTableSeed(), p_375574_ -> living.spawnAtLocation((ServerLevel) living.level(), p_375574_));


            }

        }
    }


}
