package com.fuyuaki.morethanadventure.game.server.commands;

import com.fuyuaki.morethanadventure.core.datagen.model.MTAModelTemplates;
import com.fuyuaki.morethanadventure.core.deferred_registries.MTAAttachments;
import com.fuyuaki.morethanadventure.core.registry.MTARegistries;
import com.fuyuaki.morethanadventure.game.server.commands.arguments.MTAResourceKeyArgument;
import com.fuyuaki.morethanadventure.game.species.Species;
import com.fuyuaki.morethanadventure.world.entity.attachments.SpeciesAttachment;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.Dynamic2CommandExceptionType;
import com.mojang.brigadier.exceptions.Dynamic3CommandExceptionType;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.arguments.ResourceKeyArgument;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.status.ServerStatus;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.commands.AdvancementCommands;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import java.util.Collection;

public class SpeciesCommands {
    private static final DynamicCommandExceptionType ERROR_PLAYER_HAS_NO_DATA = new DynamicCommandExceptionType(
            (o) -> Component.translatableEscape("mta.commands.species.error.data", o)
    );
    public static final int PERMISSION_LEVEL = 2;
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("species")
                        .requires(p_136318_ -> p_136318_.hasPermission(PERMISSION_LEVEL))
                        .then(Commands.literal("list")
                                .executes(context -> getAllSpecies(context.getSource()))
                        ).then(Commands.literal("keys")
                                .executes(context -> getAllSpeciesKeys(context.getSource()))
                        )
                        .then(Commands.literal("get")
                                .then(
                                        Commands.argument("targets", EntityArgument.players())
                                                .executes(context ->
                                                        getSpecies(context.getSource(),
                                                                EntityArgument.getPlayers(context, "targets")
                                                        )
                                                )
                                )
                        ).then(Commands.literal("set")
                                .then(Commands.argument("targets", EntityArgument.players())

                                        .then(Commands.argument("species", ResourceKeyArgument.key(MTARegistries.Keys.SPECIES))
                                                .executes(context ->
                                                        setSpecies(context.getSource(),
                                                                EntityArgument.getPlayers(context, "targets"),
                                                                MTAResourceKeyArgument.getSpecies(context, "species")
                                                        )
                                                )
                                        )
                                )


                        )
        );

    }

    private static int getAllSpecies(CommandSourceStack source) {
        source.getLevel().registryAccess().lookup(MTARegistries.Keys.SPECIES).get().listElementIds().forEach(key ->
                source.sendSuccess(() -> Component.translatable(Species.getSpeciesFromKey(key, source.getLevel()).getNameKey()),true)
        );
        return 0;
    }


    private static int getAllSpeciesKeys(CommandSourceStack source) {
        source.getLevel().registryAccess().lookup(MTARegistries.Keys.SPECIES).get().listElementIds().forEach(key ->
                source.sendSuccess(() -> Component.literal(key.toString()),true)
        );
        return 0;
    }



    private static int getSpecies(CommandSourceStack source, Collection<ServerPlayer> players) throws CommandSyntaxException {
        players.forEach(player -> {
                    if (player.hasData(MTAAttachments.SPECIES.get())) {
                        source.sendSuccess(() -> Component.translatable("mta.commands.species.get", player.getDisplayName(), Component.translatable(Species.getSpeciesFromKey(Species.get(player).getSpeciesKey(), source.getLevel()).getNameKey())), true);
                    } else {
                        try {
                            throw ERROR_PLAYER_HAS_NO_DATA.create(player.getDisplayName());
                        } catch (CommandSyntaxException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        return players.size();
    }

    private static int setSpecies(CommandSourceStack source, Collection<ServerPlayer> players, ResourceKey<Species> key) throws CommandSyntaxException {
        if (Species.getAllSpeciesKeys(source.getLevel()).anyMatch(key1 -> key1 == key))

            players.forEach(player -> {
                        if (player.hasData(MTAAttachments.SPECIES.get())) {

                            Species.set(player, Species.get(player).withSpeciesKey(key));


                            source.sendSuccess(() -> Component.translatable("mta.commands.species.set", player.getDisplayName(), Component.translatable(Species.getSpeciesFromKey(Species.get(player).getSpeciesKey(), source.getLevel()).getNameKey())), true);
                        } else {
                            try {
                                throw ERROR_PLAYER_HAS_NO_DATA.create(player.getDisplayName());
                            } catch (CommandSyntaxException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
            );
        return players.size();
    }





}

