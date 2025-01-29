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





    public static final ResourceKey<LootTable> CASTLE_RUINS_REWARD = chest("castle_ruins/reward");
    public static final ResourceKey<LootTable> CASTLE_RUINS_REWARD_COMMON = chest("castle_ruins/reward_common");
    public static final ResourceKey<LootTable> CASTLE_RUINS_REWARD_RARE = chest("castle_ruins/reward_rare");
    public static final ResourceKey<LootTable> CASTLE_RUINS_REWARD_UNIQUE = chest("castle_ruins/reward_unique");
    public static final ResourceKey<LootTable> CASTLE_RUINS_REWARD_OMINOUS = chest("castle_ruins/reward_ominous");
    public static final ResourceKey<LootTable> CASTLE_RUINS_REWARD_OMINOUS_COMMON = chest("castle_ruins/reward_ominous_common");
    public static final ResourceKey<LootTable> CASTLE_RUINS_REWARD_OMINOUS_RARE = chest("castle_ruins/reward_ominous_rare");
    public static final ResourceKey<LootTable> CASTLE_RUINS_REWARD_OMINOUS_UNIQUE = chest("castle_ruins/reward_ominous_ominous");


    public static final ResourceKey<LootTable> CASTLE_RUINS_EQUIPMENT = equipment("castle_ruins");
    public static final ResourceKey<LootTable> CASTLE_RUINS_EQUIPMENT_RANGED = equipment("castle_ruins_ranged");
    public static final ResourceKey<LootTable> CASTLE_RUINS_EQUIPMENT_MELEE = equipment("castle_ruins_melee");


    public static final ResourceKey<LootTable> CASTLE_RUINS_POT = pot("castle_ruins_common");
    public static final ResourceKey<LootTable> CASTLE_RUINS_POT_SPECIAL = pot("castle_ruins_special");






    private static ResourceKey<LootTable> chest(String name){
        return register("chests/" + name);
    }
    private static ResourceKey<LootTable> pot(String name){
        return register("pots/" + name);
    }
    private static ResourceKey<LootTable> dispenser(String name){
        return register("dispensers/" + name);
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
