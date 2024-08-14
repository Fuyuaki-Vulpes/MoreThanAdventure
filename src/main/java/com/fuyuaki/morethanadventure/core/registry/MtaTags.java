package com.fuyuaki.morethanadventure.core.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MtaTags {

    public static class Blocks {
        public static final TagKey<Block> PALM_LOGS = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(MODID, "palm_logs"));
        public static final TagKey<Block> NEEDS_COPPER_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(MODID, "needs_copper_tool"));
        public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(MODID, "incorrect_for_cooper_tool"));
        public static final TagKey<Block> INCORRECT_FOR_AGATE_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(MODID, "incorrect_for_agate_tool"));
        public static final TagKey<Block> INCORRECT_FOR_ALEXANDRITE_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(MODID, "incorrect_for_alexandrite_tool"));
        public static final TagKey<Block> INCORRECT_FOR_AQUAMARINE_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(MODID, "incorrect_for_aquamarine_tool"));
        public static final TagKey<Block> INCORRECT_FOR_CELESTITE_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(MODID, "incorrect_for_celestite_tool"));
        public static final TagKey<Block> INCORRECT_FOR_GARNET_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(MODID, "incorrect_for_garnet_tool"));
        public static final TagKey<Block> INCORRECT_FOR_MOONSTONE_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(MODID, "incorrect_for_moonstone_tool"));

        public static final TagKey<Block> NEEDS_NETHERSTEEL_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(MODID, "needs_copper_tool"));
        public static final TagKey<Block> INCORRECT_FOR_NETHERSTEEL_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(MODID, "incorrect_for_cooper_tool"));


        public static final TagKey<Block> ORE_CLUSTER_REPLACEABLE = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(MODID, "ore_vein_replaceable"));
        public static final TagKey<Block> NETHER_CLUSTER_CLUSTER_REPLACEABLE = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(MODID, "nether_ore_vein_replaceable"));


    }

    public static class Items{
        public static final TagKey<Item> PALM_LOGS = TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(MODID, "palm_logs"));


    }

    public static class Biomes {


        public static final TagKey<Biome> OVERWORLD_GEYSERS = tag("overworld_geysers");
        public static final TagKey<Biome> NETHER_GEYSERS = tag("nether_geysers");

        public static final TagKey<Biome> HAS_PALE_WOLF = tag("has_pale_wolf");
        public static final TagKey<Biome> HAS_SPOTTED_WOLF = tag("has_spotted_wolf");
        public static final TagKey<Biome> HAS_SNOWY_WOLF = tag("has_snowy_wolf");
        public static final TagKey<Biome> HAS_BLACK_WOLF = tag("has_black_wolf");
        public static final TagKey<Biome> HAS_ASHEN_WOLF = tag("has_ashen_wolf");
        public static final TagKey<Biome> HAS_RUSTY_WOLF = tag("has_rusty_wolf");
        public static final TagKey<Biome> HAS_WOODS_WOLF = tag("has_woods_wolf");
        public static final TagKey<Biome> HAS_CHESTNUT_WOLF = tag("has_chestnut_wolf");
        public static final TagKey<Biome> HAS_STRIPED_WOLF = tag("has_striped_wolf");

        public static final TagKey<Biome> HAS_BEARDED_DRAGON = tag("has_bearded_dragon");
        public static final TagKey<Biome> HAS_CAPYBARA = tag("has_capybara");
        public static final TagKey<Biome> HAS_DUCK = tag("has_duck");
        public static final TagKey<Biome> HAS_FERRET = tag("has_ferret");
        public static final TagKey<Biome> HAS_GREAT_WHITE_SHARK = tag("has_great_white_shark");
        public static final TagKey<Biome> HAS_HORSESHOE_CRAB = tag("has_horseshoe_crab");
        public static final TagKey<Biome> HAS_JELLYFISH = tag("has_jellyfish");
        public static final TagKey<Biome> HAS_OCTOPUS = tag("has_octopus");
        public static final TagKey<Biome> HAS_OWL = tag("has_owl");
        public static final TagKey<Biome> HAS_PENGUIN = tag("has_penguin");
        public static final TagKey<Biome> HAS_RACCOON = tag("has_raccoon");
        public static final TagKey<Biome> HAS_SHRIMP = tag("has_shrimp");
        public static final TagKey<Biome> HAS_TOUCAN = tag("has_toucan");
    }


        private static TagKey<Biome> tag(String name) {
            return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(MODID, name));
        }
    }
