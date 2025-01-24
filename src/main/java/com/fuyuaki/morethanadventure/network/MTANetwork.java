package com.fuyuaki.morethanadventure.network;

import com.fuyuaki.morethanadventure.network.packets.StCClimateSync;
import io.wispforest.owo.network.ClientAccess;
import io.wispforest.owo.network.OwoNetChannel;
import io.wispforest.owo.network.ServerAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTANetwork {
    public static final OwoNetChannel CHANNEL = OwoNetChannel.create(ResourceLocation.fromNamespaceAndPath(MODID, "main"));


    public static void init(){
        CHANNEL.registerClientboundDeferred(StCClimateSync.class, StCClimateSync.ENDEC);

    }


    @OnlyIn(Dist.CLIENT)
    public static void initClient(){
        CHANNEL.registerClientbound(StCClimateSync.class,StCClimateSync.ENDEC,clientHandler(StCClimateSync::handlePacket));
    }



    @OnlyIn(Dist.CLIENT)
    public static <R extends Record> OwoNetChannel.ChannelHandler<R, ClientAccess> clientHandler(BiConsumer<R, Player> consumer) {
        return (r, access) -> consumer.accept(r, access.player());
    }
    @OnlyIn(Dist.CLIENT)
    public static <R extends Record> OwoNetChannel.ChannelHandler<R, ClientAccess> clientHandler(Consumer<R> consumer) {
        return (r, access) -> consumer.accept(r);
    }

    public static <R extends Record> OwoNetChannel.ChannelHandler<R, ServerAccess> serverHandler(BiConsumer<R, Player> consumer) {
        return (r, access) -> consumer.accept(r, access.player());
    }

    @OnlyIn(Dist.CLIENT)
    public static <R extends Record> void sendToServer(R packet) {
        CHANNEL.clientHandle().send(packet);
    }

    public static <R extends Record> void sendToPlayer(ServerPlayer player, R packet) {
        CHANNEL.serverHandle(player).send(packet);
    }

    public static <R extends Record> void sendToAllPlayers(MinecraftServer server, R packet){
        for (var player : server.getPlayerList().getPlayers()) sendToPlayer(player, packet);
    }


}
