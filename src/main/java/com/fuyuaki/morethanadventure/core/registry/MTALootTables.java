package com.fuyuaki.morethanadventure.core.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTALootTables {
    private static final Set<ResourceKey<LootTable>> LOCATIONS = new HashSet<>();
    private static final Set<ResourceKey<LootTable>> IMMUTABLE_LOCATIONS = Collections.unmodifiableSet(LOCATIONS);





    public static final ResourceKey<LootTable> OCEAN_RUIN_COLD_ARCHAEOLOGY = register("archaeology/ocean_ruin_cold");



    private static ResourceKey<LootTable> chest(String name){
        return register("chests/" + name);
    }


    private static ResourceKey<LootTable> archaeology(String name){
        return register("archaeology/" + name);
    }

    private static ResourceKey<LootTable> gameplay(String name){
        return register("gameplay/" + name);
    }


    private static ResourceKey<LootTable> equipment(String name){
        return register("equipment/" + name);
    }

    private static ResourceKey<LootTable> spawners(String name){
        return register("spawners/" + name);
    }


    private static ResourceKey<LootTable> register(String name) {
        return register(ResourceKey.create(Registries.LOOT_TABLE, ResourceLocation.fromNamespaceAndPath(MODID,name)));
    }
    
    
    private static ResourceKey<LootTable> register(ResourceKey<LootTable> name) {
        if (LOCATIONS.add(name)) {
            return name;
        } else {
            throw new IllegalArgumentException(name.location() + " is already a registered built-in loot table");
        }
    }


    public static Set<ResourceKey<LootTable>> all() {
        return IMMUTABLE_LOCATIONS;
    }
    
    


}
