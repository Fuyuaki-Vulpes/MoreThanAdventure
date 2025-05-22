package com.fuyuaki.morethanadventure.core.mod;

import com.fuyuaki.morethanadventure.core.registry.MTARegistries;
import com.fuyuaki.morethanadventure.game.species.Species;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTAUtils {
    public static final ResourceKey<Species> HUMAN_SPECIES = ResourceKey.create(MTARegistries.Keys.SPECIES, ResourceLocation.fromNamespaceAndPath(MODID,"human"));


    public static ResourceLocation locationMTA(String path){
        return ResourceLocation.fromNamespaceAndPath(MODID,path);
    }
}
