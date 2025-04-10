package com.fuyuaki.morethanadventure.core.registry;

import com.fuyuaki.morethanadventure.game.species.Species;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.FrogVariant;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTASpecies {

    public static final ResourceKey<Species> HUMAN = createKey("human");
    public static final ResourceKey<Species> GIANT = createKey("giant");

    private static ResourceKey<Species> createKey(String name) {
        return ResourceKey.create(MTARegistries.Keys.SPECIES, ResourceLocation.fromNamespaceAndPath(MODID,name));
    }


}
