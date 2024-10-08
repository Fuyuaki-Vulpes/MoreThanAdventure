package com.fuyuaki.morethanadventure.game.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.synth.NormalNoise;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MTANoises {

    public static final ResourceKey<NormalNoise.NoiseParameters> CALCITE_3D = createKey("calcite_3d");
    public static final ResourceKey<NormalNoise.NoiseParameters> OASIS_GRASS = createKey("oasis_grass");
    public static final ResourceKey<NormalNoise.NoiseParameters> TUNDRA_VEGETATION = createKey("tundra_vegetation");

    public static void bootstrap(BootstrapContext<NormalNoise.NoiseParameters> context) {
        register(context, CALCITE_3D, -6, 0.3D,1,-1);
        register(context, OASIS_GRASS, -5, 1.0D, -1.0D, 3.0D);
        register(context, TUNDRA_VEGETATION, -7, 2.0D, -2.0D, -3.0D);
    }


    private static ResourceKey<NormalNoise.NoiseParameters> createKey(String key) {
        return ResourceKey.create(Registries.NOISE, ResourceLocation.fromNamespaceAndPath(MODID,key));
    }
    private static void register(BootstrapContext<NormalNoise.NoiseParameters> context, ResourceKey<NormalNoise.NoiseParameters> key,
                                 int firstOctave,
                                 double amplitude,
                                 double... otherAmplitudes) {
        context.register(key, new NormalNoise.NoiseParameters(firstOctave, amplitude, otherAmplitudes));
    }
}


