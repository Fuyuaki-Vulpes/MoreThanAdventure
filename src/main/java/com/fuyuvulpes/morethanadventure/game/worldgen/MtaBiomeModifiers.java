package com.fuyuvulpes.morethanadventure.game.worldgen;

import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class MtaBiomeModifiers {

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MODID, name));
    }
}
