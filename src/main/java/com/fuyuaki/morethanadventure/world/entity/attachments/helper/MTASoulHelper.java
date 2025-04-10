package com.fuyuaki.morethanadventure.world.entity.attachments.helper;

import com.fuyuaki.morethanadventure.core.deferred_registries.MTAAttachments;
import com.fuyuaki.morethanadventure.network.MTANetwork;
import com.fuyuaki.morethanadventure.network.packet.SyncPlayerSoulPacket;
import com.fuyuaki.morethanadventure.world.entity.attachments.SoulCharge;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.Map;

public class MTASoulHelper {

    private static final Map<EntityType<?>, Integer> ENTITY_REWARD_MAP = Map.of(
            EntityType.WARDEN,30,
            EntityType.WITHER, 15,
            EntityType.WITHER_SKELETON, 5
    );



    public static void playerTickSoul(Player player){
        SoulCharge attachment = getPlayerSoulCharge(player);
        attachment.tick();
        player.setData(MTAAttachments.SOUL_CHARGE.get(), attachment);
        sync(player);
    }

    public static void playerAddSoul(float count, Player player){
        SoulCharge attachment = getPlayerSoulCharge(player);
        attachment.addCharge(count,player);
        player.setData(MTAAttachments.SOUL_CHARGE.get(), attachment);
        sync(player);
    }


    public static boolean playerDrainSoul(float count, Player player){
        SoulCharge attachment = getPlayerSoulCharge(player);
        if (!attachment.drainCharge(count)) return false;
        player.setData(MTAAttachments.SOUL_CHARGE.get(), attachment);
        sync(player);
        return true;
    }

    public static void playerAddMaxSoul(int count, Player player){
        SoulCharge attachment = getPlayerSoulCharge(player);
        attachment.addToMaxCharge(count);
        player.setData(MTAAttachments.SOUL_CHARGE.get(), attachment);
        sync(player);
    }
    public static void playerRemoveMaxSoul(int count, Player player){
        SoulCharge attachment = getPlayerSoulCharge(player);
        attachment.removeFromMaxCharge(count);
        player.setData(MTAAttachments.SOUL_CHARGE.get(), attachment);
        sync(player);
    }

    public static void playerSetMaxSoul(int count, Player player){
        SoulCharge attachment = getPlayerSoulCharge(player);
        attachment.setMaxCharge(count);
        attachment.clampCharge(count,player);
        player.setData(MTAAttachments.SOUL_CHARGE.get(), attachment);
        sync(player);
    }

    public static SoulCharge getPlayerSoulCharge(Player player){
        return player.getData(MTAAttachments.SOUL_CHARGE);
    }

    public static void sync(Player player){
        MTANetwork.sendToPlayer((ServerPlayer) player,new SyncPlayerSoulPacket(player.getData(MTAAttachments.SOUL_CHARGE.get())));
    }


    public static int getSoulValueForEntity(LivingEntity entity){
        int reward = Mth.clamp((int) (entity.getMaxHealth() / 2), 1, 50);
        if (ENTITY_REWARD_MAP.containsKey(entity.getType())){
            reward = reward + ENTITY_REWARD_MAP.get(entity.getType());
        }
        return Math.max(reward,1);
    }
}
