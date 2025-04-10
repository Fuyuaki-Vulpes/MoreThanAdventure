package com.fuyuaki.morethanadventure.core.registry;

import com.fuyuaki.morethanadventure.game.species.Species;
import com.fuyuaki.morethanadventure.game.species.traits.Trait;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.RegistryBuilder;

public class MTARegistries {

    private static <T> ResourceKey<Registry<T>> createRegistryKey(String name) {
        return ResourceKey.createRegistryKey(ResourceLocation.withDefaultNamespace(name));
    }


    public class Keys{
        public static final ResourceKey<Registry<Species>> SPECIES = createRegistryKey("species");
        public static final ResourceKey<Registry<Trait>> TRAITS = createRegistryKey("trait");


    }
    public class Registries{
        public static final Registry<Trait> TRAITS = new RegistryBuilder<>(Keys.TRAITS)
                .defaultKey(ResourceLocation.withDefaultNamespace("trait"))
                .create();

        public static final Registry<Species> SPECIES = new RegistryBuilder<>(Keys.SPECIES)
                .defaultKey(ResourceLocation.withDefaultNamespace("species"))
                .create();


    }


}
