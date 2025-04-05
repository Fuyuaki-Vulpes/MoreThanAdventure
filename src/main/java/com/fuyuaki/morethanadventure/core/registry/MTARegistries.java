package com.fuyuaki.morethanadventure.core.registry;

import com.fuyuaki.morethanadventure.game.species.Species;
import com.fuyuaki.morethanadventure.game.species.trait.Trait;
import com.fuyuaki.morethanadventure.game.species.trait.type.TraitType;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.registries.RegistryBuilder;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTARegistries {

    private static <T> ResourceKey<Registry<T>> createRegistryKey(String name) {
        return ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(MODID,name));
    }


    public class Keys{
        public static final ResourceKey<Registry<Species>> SPECIES = createRegistryKey("species");
        public static final ResourceKey<Registry<Trait>> TRAITS = createRegistryKey("trait");
        public static final ResourceKey<Registry<TraitType>> TRAIT_TYPES = createRegistryKey("trait_type");


    }
    public class Registries{
        public static final Registry<TraitType> TRAIT_TYPE = new RegistryBuilder<>(Keys.TRAIT_TYPES)
                .defaultKey(ResourceLocation.withDefaultNamespace("none"))
                .create();


    }


}
