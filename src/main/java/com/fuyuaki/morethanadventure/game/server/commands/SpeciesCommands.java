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
    private static final Dynamic3CommandExceptionType ERROR_PLAYER_LEVEL_TOO_HIGH = new Dynamic3CommandExceptionType(
            (o1,o2,o3) -> Component.translatableEscape("mta.commands.species.error.level_too_high", o1,o2,o3));

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(
                Commands.literal("species")
                        .requires(p_136318_ -> p_136318_.hasPermission(PERMISSION_LEVEL))
                        .then(Commands.literal("get")
                                .then(
                                        Commands.argument("targets", EntityArgument.players())
                                                .then(Commands.literal("species")
                                                        .executes(context ->
                                                                getSpecies(context.getSource(),
                                                                        EntityArgument.getPlayers(context, "targets")
                                                                        )
                                                                ))
                                                .then(Commands.literal("level")
                                                        .executes(context -> getLevel(context.getSource(),
                                                                        EntityArgument.getPlayers(context, "targets")
                                                                )
                                                                ))
                                                .then(Commands.literal("exp")
                                                        .executes(context -> getExperience(context.getSource(),
                                                                        EntityArgument.getPlayers(context, "targets")
                                                                )
                                                                ))
                                )
                        ).then(Commands.literal("set")
                                .then(Commands.argument("targets", EntityArgument.players())
                                        .then(Commands.literal("species")
                                                .then(Commands.argument("species", ResourceKeyArgument.key(MTARegistries.Keys.SPECIES))
                                                        .then(Commands.argument("reset_level", BoolArgumentType.bool())
                                                                .executes(context ->
                                                                        setSpecies(context.getSource(),
                                                                                EntityArgument.getPlayers(context, "targets"),
                                                                                MTAResourceKeyArgument.getSpecies(context, "species"),
                                                                                BoolArgumentType.getBool(context, "reset_level")
                                                                        )
                                                                )))))
                                .then(Commands.literal("level")
                                        .then(Commands.argument("count", IntegerArgumentType.integer(0, 5))
                                                .executes(context ->
                                                        setLevel(context.getSource(),
                                                                EntityArgument.getPlayers(context, "targets"),
                                                                IntegerArgumentType.getInteger(context, "count")
                                                        )))
                                )

                        ).then(Commands.literal("add")
                                .then(Commands.argument("count", IntegerArgumentType.integer(0))
                                        .then(Commands.literal("level")
                                                .then(Commands.argument("count", IntegerArgumentType.integer(0, 5))
                                                        .executes(context ->
                                                                addLevel(context.getSource(),
                                                                        EntityArgument.getPlayers(context, "targets"),
                                                                        IntegerArgumentType.getInteger(context, "count")
                                                                )))
                                                .then(Commands.literal("experience")
                                                        .then(Commands.argument("count", IntegerArgumentType.integer(0))
                                                                .executes(context ->
                                                                        addExp(context.getSource(),
                                                                                EntityArgument.getPlayers(context, "targets"),
                                                                                IntegerArgumentType.getInteger(context, "count")
                                                                        )))
                                                )

                                        )
                                )
                        )
        );

    }

    private static int getExperience(CommandSourceStack source, Collection<ServerPlayer> players) throws CommandSyntaxException {
        players.forEach(player -> {
                    if (player.hasData(MTAAttachments.SPECIES.get())) {
                        source.sendSuccess(() -> Component.translatable("mta.commands.species.get.experience", player, Species.get(player).getExperience()), true);
                    } else {
                        try {
                            throw ERROR_PLAYER_HAS_NO_DATA.create(player);
                        } catch (CommandSyntaxException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        return players.size();
    }

    private static int getLevel(CommandSourceStack source, Collection<ServerPlayer> players) throws CommandSyntaxException {
        players.forEach(player -> {
                    if (player.hasData(MTAAttachments.SPECIES.get())) {
                        source.sendSuccess(() -> Component.translatable("mta.commands.species.get.level", player, Species.get(player).getLevel()), true);
                    } else {
                        try {
                            throw ERROR_PLAYER_HAS_NO_DATA.create(player);
                        } catch (CommandSyntaxException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        return players.size();
    }

    private static int getSpecies(CommandSourceStack source, Collection<ServerPlayer> players) throws CommandSyntaxException {
        players.forEach(player -> {
                    if (player.hasData(MTAAttachments.SPECIES.get())) {
                        source.sendSuccess(() -> Component.translatable("mta.commands.species.get.species", player, Species.getSpeciesFromKey(Species.get(player).getSpeciesKey()).getNameKey()), true);
                    } else {
                        try {
                            throw ERROR_PLAYER_HAS_NO_DATA.create(player);
                        } catch (CommandSyntaxException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        return players.size();
    }


    private static int setLevel(CommandSourceStack source, Collection<ServerPlayer> players, int count) throws CommandSyntaxException {
        players.forEach(player -> {
                    if (player.hasData(MTAAttachments.SPECIES.get())) {
                        int level = Species.get(player).getLevel();

                        Species.set(player, Species.get(player).withLevel(level + count));

                        source.sendSuccess(() -> Component.translatable("mta.commands.species.set.level", player, Species.get(player).getLevel()), true);
                    } else {
                        try {
                            throw ERROR_PLAYER_HAS_NO_DATA.create(player);
                        } catch (CommandSyntaxException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        return players.size();
    }

    private static int setSpecies(CommandSourceStack source, Collection<ServerPlayer> players, ResourceKey<Species> key, boolean reset) throws CommandSyntaxException {
        if (Species.getAllSpeciesKeys().anyMatch(key1 -> key1 == key))

            players.forEach(player -> {
                        if (player.hasData(MTAAttachments.SPECIES.get())) {

                            if (reset) {
                                Species.set(player, new SpeciesAttachment(key, 0, 0));
                            } else {
                                Species.set(player, Species.get(player).withSpeciesKey(key));

                            }
                            source.sendSuccess(() -> Component.translatable("mta.commands.species.set.species", player, Species.getSpeciesFromKey(Species.get(player).getSpeciesKey()).getNameKey()), true);
                        } else {
                            try {
                                throw ERROR_PLAYER_HAS_NO_DATA.create(player);
                            } catch (CommandSyntaxException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
            );
        return players.size();
    }


    private static int addLevel(CommandSourceStack source, Collection<ServerPlayer> players, int count) throws CommandSyntaxException {
        players.forEach(player -> {
                    if (player.hasData(MTAAttachments.SPECIES.get())) {
                        int level = Species.get(player).getLevel();
                        if (level + count > 5) {
                            try {
                                throw ERROR_PLAYER_LEVEL_TOO_HIGH.create(player, level, count);
                            } catch (CommandSyntaxException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        Species.set(player, Species.get(player).withLevel(level + count));
                        source.sendSuccess(() -> Component.translatable("mta.commands.species.add.level", player, level), true);
                    } else {
                        try {
                            throw ERROR_PLAYER_HAS_NO_DATA.create(player);
                        } catch (CommandSyntaxException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        return players.size();
    }

    private static int addExp(CommandSourceStack source, Collection<ServerPlayer> players, int count) throws CommandSyntaxException {
        players.forEach(player -> {
                    if (player.hasData(MTAAttachments.SPECIES.get())) {
                        int exp = Species.get(player).getExperience();
                        Species.set(player, Species.get(player).withExperience(exp + count));

                        source.sendSuccess(() -> Component.translatable("mta.commands.species.add.experience", player, exp), true);
                    } else {
                        try {
                            throw ERROR_PLAYER_HAS_NO_DATA.create(player);
                        } catch (CommandSyntaxException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
        );
        return players.size();
    }




}

