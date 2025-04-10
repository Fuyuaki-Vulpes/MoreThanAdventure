package com.fuyuaki.morethanadventure.game.server.commands.arguments;

import com.fuyuaki.morethanadventure.core.registry.MTARegistries;
import com.fuyuaki.morethanadventure.game.species.Species;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;

import java.util.Optional;

public class MTAResourceKeyArgument {

    private static final DynamicCommandExceptionType ERROR_INVALID_SPECIES = new DynamicCommandExceptionType(
            p_378835_ -> Component.translatableEscape("mta.species.speciesNotFound", p_378835_)
    );

    private static <T> ResourceKey<T> getRegistryKey(
            CommandContext<CommandSourceStack> context, String argument, ResourceKey<Registry<T>> registryKey, DynamicCommandExceptionType exception
    ) throws CommandSyntaxException {
        ResourceKey<?> resourcekey = context.getArgument(argument, ResourceKey.class);
        Optional<ResourceKey<T>> optional = resourcekey.cast(registryKey);
        return optional.orElseThrow(() -> exception.create(resourcekey.location()));
    }

    public static ResourceKey<Species> getSpecies(CommandContext<CommandSourceStack> context, String argument) throws CommandSyntaxException {
        ResourceKey<Species> resourcekey = getRegistryKey(context, argument, MTARegistries.Keys.SPECIES, ERROR_INVALID_SPECIES);

        if (resourcekey == null) {
            throw ERROR_INVALID_SPECIES.create(resourcekey);
        } else {
            return resourcekey;
        }
    }


}
