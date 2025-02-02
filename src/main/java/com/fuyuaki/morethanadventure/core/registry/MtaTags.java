package com.fuyuaki.morethanadventure.core.registry;

import io.wispforest.accessories.Accessories;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;


public class MtaTags {
    @SuppressWarnings("unused")

    public static class Common {
        // Blocks that are efficiently mined with a Knife.
        public static final TagKey<Block> MINEABLE_WITH_KNIFE = commonBlockTag("mineable/knife");

        // Tags under the "crops" subgroup.
        public static final TagKey<Item> CROPS_CABBAGE = commonItemTag("crops/cabbage");
        public static final TagKey<Item> CROPS_TOMATO = commonItemTag("crops/tomato");
        public static final TagKey<Item> CROPS_ONION = commonItemTag("crops/onion");
        public static final TagKey<Item> CROPS_RICE = commonItemTag("crops/rice");
        public static final TagKey<Item> CROPS_GRAIN = commonItemTag("crops/grain");

        // Tags under the "foods" subgroup.
        public static final TagKey<Item> FOODS_CABBAGE = commonItemTag("foods/cabbage");
        public static final TagKey<Item> FOODS_TOMATO = commonItemTag("foods/tomato");
        public static final TagKey<Item> FOODS_ONION = commonItemTag("foods/onion");

        public static final TagKey<Item> FOODS_LEAFY_GREEN = commonItemTag("foods/leafy_green");
        public static final TagKey<Item> FOODS_DOUGH = commonItemTag("foods/dough");
        public static final TagKey<Item> FOODS_PASTA = commonItemTag("foods/pasta");
        public static final TagKey<Item> FOODS_MILK = commonItemTag("foods/milk");

        public static final TagKey<Item> FOODS_RAW_BACON = commonItemTag("foods/raw_bacon");
        public static final TagKey<Item> FOODS_RAW_BEEF = commonItemTag("foods/raw_beef");
        public static final TagKey<Item> FOODS_RAW_CHICKEN = commonItemTag("foods/raw_chicken");
        public static final TagKey<Item> FOODS_RAW_PORK = commonItemTag("foods/raw_pork");
        public static final TagKey<Item> FOODS_RAW_MUTTON = commonItemTag("foods/raw_mutton");
        public static final TagKey<Item> FOODS_SAFE_RAW_FISH = commonItemTag("foods/safe_raw_fish");
        public static final TagKey<Item> FOODS_RAW_COD = commonItemTag("foods/raw_cod");
        public static final TagKey<Item> FOODS_RAW_SALMON = commonItemTag("foods/raw_salmon");

        public static final TagKey<Item> FOODS_COOKED_BACON = commonItemTag("foods/cooked_bacon");
        public static final TagKey<Item> FOODS_COOKED_BEEF = commonItemTag("foods/cooked_beef");
        public static final TagKey<Item> FOODS_COOKED_CHICKEN = commonItemTag("foods/cooked_chicken");
        public static final TagKey<Item> FOODS_COOKED_PORK = commonItemTag("foods/cooked_pork");
        public static final TagKey<Item> FOODS_COOKED_MUTTON = commonItemTag("foods/cooked_mutton");
        public static final TagKey<Item> FOODS_COOKED_EGG = commonItemTag("foods/cooked_egg");
        public static final TagKey<Item> FOODS_COOKED_COD = commonItemTag("foods/cooked_cod");
        public static final TagKey<Item> FOODS_COOKED_SALMON = commonItemTag("foods/cooked_salmon");

        // Tags under the "tools" subgroup.
        public static final TagKey<Item> TOOLS_KNIFE = commonItemTag("tools/knife");


        private static TagKey<Block> commonBlockTag(String path) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
        }

        private static TagKey<Item> commonItemTag(String path) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
        }
    }

    public static class Blocks {

        public static final TagKey<Block> SEA_ANIMAL_SPAWNABLE_ON = tag("sea_animal_spawnable_on");
        public static final TagKey<Block> DESERT_ANIMAL_SPAWNABLE_ON = tag("desert_animal_spawnable_on");
        public static final TagKey<Block> LAND_SWIMMER_SPAWNABLE_ON = tag("land_swimmer_spawnable_on");
        public static final TagKey<Block> BIRD_SPAWNABLE_ON = tag("bird_spawnable_on");
        public static final TagKey<Block> SNOW_ANIMAL_SPAWNABLE_ON = tag("mountain_animal_spawnable_on");

        public static final TagKey<Block> DIRTIES_STONE_TILES = tag("dirties_stone_tiles");


        public static final TagKey<Block> ALPINE_LOGS = tag("alpine_logs");
        public static final TagKey<Block> AVOCADO_LOGS = tag("avocado_logs");
        public static final TagKey<Block> BOGGED_OAK_LOGS = tag("bogged_oak_logs");
        public static final TagKey<Block> MANGO_LOGS = tag("mango_logs");
        public static final TagKey<Block> MAPLE_LOGS = tag("maple_logs");
        public static final TagKey<Block> PALM_LOGS = tag("palm_logs");
        public static final TagKey<Block> SEAWOOD = tag("seawood");
        public static final TagKey<Block> NEEDS_COPPER_TOOL = tag("needs_copper_tool");
        public static final TagKey<Block> NEEDS_GEM_TOOL = tag("needs_gem_tool");


        public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = tag("incorrect_for_copper_tool");
        public static final TagKey<Block> INCORRECT_FOR_GEM_TOOL = tag("incorrect_for_gem_tool");

        public static final TagKey<Block> NEEDS_NETHERSTEEL_TOOL = tag("needs_nethersteel_tool");
        public static final TagKey<Block> INCORRECT_FOR_NETHERSTEEL_TOOL = tag("incorrect_for_nethersteel_tool");


        public static final TagKey<Block> ORE_CLUSTER_REPLACEABLE = tag("ore_vein_replaceable");
        public static final TagKey<Block> NETHER_CLUSTER_CLUSTER_REPLACEABLE = tag("nether_ore_vein_replaceable");
        public static final TagKey<Block> FLOWER_PLACEABLE = tag("flower_placeable");
        public static final TagKey<Block> SAND_VEGETATION_MAY_PLACE_ON = tag("sand_vegetation_may_place_on");

        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, name));
        }

    }

    public static class Items {

        public static final TagKey<Item> ALPINE_LOGS = tag("alpine_logs");
        public static final TagKey<Item> AVOCADO_LOGS = tag("avocado_logs");
        public static final TagKey<Item> BOGGED_OAK_LOGS = tag("bogged_oak_logs");
        public static final TagKey<Item> MANGO_LOGS = tag("mango_logs");
        public static final TagKey<Item> MAPLE_LOGS = tag("maple_logs");
        public static final TagKey<Item> PALM_LOGS = tag("palm_logs");
        public static final TagKey<Item> SEAWOOD = tag("sealogs");

        public static final TagKey<Item> AGATE_TOOL_MATERIALS = tag("agate_tool_materials");
        public static final TagKey<Item> ALEXANDRITE_TOOL_MATERIALS = tag("alexandrite_tool_materials");
        public static final TagKey<Item> AQUAMARINE_TOOL_MATERIALS = tag("aquamarine_tool_materials");
        public static final TagKey<Item> BLOODSTONE_TOOL_MATERIALS = tag("bloodstone_tool_materials");
        public static final TagKey<Item> CELESTITE_TOOL_MATERIALS = tag("celestite_tool_materials");
        public static final TagKey<Item> CRYOLITE_TOOL_MATERIALS = tag("cryolite_tool_materials");
        public static final TagKey<Item> GARNET_TOOL_MATERIALS = tag("garnet_tool_materials");
        public static final TagKey<Item> MOONSTONE_TOOL_MATERIALS = tag("moonstone_tool_materials");
        public static final TagKey<Item> NETHERSTEEL_TOOL_MATERIALS = tag("nethersteel_tool_materials");
        public static final TagKey<Item> COPPER_TOOL_MATERIALS = tag("copper_tool_materials");


        public static final TagKey<Item> THROWABLE = tag("weapon/throwable");
        public static final TagKey<Item> TWO_HANDED = tag("weapon/two_handed");
        public static final TagKey<Item> CAUSES_BLEEDING = tag("weapon/causes_bleeding");
        public static final TagKey<Item> STUN = tag("weapon/stun");

        public static final TagKey<Item> WHIP_ENCHANTMENTS = tag("whip_enchantments");
        public static final TagKey<Item> ANCHOR_ENCHANTMENTS = tag("anchor_enchantments");
        public static final TagKey<Item> LOOTING_ENCHANTMENTS = tag("looting_enchantments");


        public static final TagKey<Item> MTA_WEAPONRY = tag("mta_mod_weapons");


        public static final TagKey<Item> MTA_ACCESSORIES = tag("accessories");


        private static TagKey<Item> tag(String name) {
            return TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(MODID, name));
        }

    }

    public static class Accessory {
        public static final TagKey<Item> TALISMAN_TAG = tag("talisman");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(BuiltInRegistries.ITEM.key(), ResourceLocation.fromNamespaceAndPath(Accessories.MODID, name));
        }
    }
    public static class Enchantments {
        public static final TagKey<Enchantment> FLAMING = tag("flaming_bow");
        public static final TagKey<Enchantment> WHIP = tag("whip");
        public static final TagKey<Enchantment> HIT_BUFF_EXCLUSIVE = tag("hit_buff_exclusive");
        private static TagKey<Enchantment> tag(String name) {
            return TagKey.create(Registries.ENCHANTMENT, ResourceLocation.fromNamespaceAndPath(MODID, name));
        }
    }

    public static class EntityTypes {
        public static final TagKey<EntityType<?>> WITHER_SOLDIER_DISLIKED = tag("wither_soldier_disliked");
        private static TagKey<EntityType<?>> tag(String name) {
            return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MODID, name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> OVERWORLD_GEYSERS = tag("overworld_geysers");
        public static final TagKey<Biome> NETHER_GEYSERS = tag("nether_geysers");


        public static final TagKey<Biome> AGATE = tag("agate");
        public static final TagKey<Biome> ALEXANDRITE = tag("alexandrite");
        public static final TagKey<Biome> AQUAMARINE = tag("aquamarine");
        public static final TagKey<Biome> BLOODSTONE = tag("bloodstone");
        public static final TagKey<Biome> CELESTITE = tag("celestite");
        public static final TagKey<Biome> CRYOLITE = tag("cryolite");
        public static final TagKey<Biome> GARNET = tag("garnet");
        public static final TagKey<Biome> MOONSTONE = tag("moonstone");


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
        public static final TagKey<Biome> HAS_BUTTERFLY = tag("has_butterfly");
        public static final TagKey<Biome> HAS_CAPYBARA = tag("has_capybara");
        public static final TagKey<Biome> HAS_DUCK = tag("has_duck");
        public static final TagKey<Biome> HAS_FERRET = tag("has_ferret");
        public static final TagKey<Biome> HAS_GREAT_WHITE_SHARK = tag("has_great_white_shark");
        public static final TagKey<Biome> HAS_HORSESHOE_CRAB = tag("has_horseshoe_crab");
        public static final TagKey<Biome> HAS_JELLYFISH = tag("has_jellyfish");
        public static final TagKey<Biome> HAS_OCTOPUS = tag("has_octopus");
        public static final TagKey<Biome> HAS_DEER = tag("has_deer");
        public static final TagKey<Biome> HAS_OWL = tag("has_owl");
        public static final TagKey<Biome> HAS_PENGUIN = tag("has_penguin");
        public static final TagKey<Biome> HAS_RACCOON = tag("has_raccoon");
        public static final TagKey<Biome> HAS_SHRIMP = tag("has_shrimp");
        public static final TagKey<Biome> HAS_TOUCAN = tag("has_toucan");
        public static final TagKey<Biome> HAS_WISP_RARE = tag("has_wisp_rare");
        public static final TagKey<Biome> HAS_WISP = tag("has_wisp");
        public static final TagKey<Biome> HAS_TURKEY = tag("has_turkey");


        public static final TagKey<Biome> HAS_BLACK_WIDOW = tag("has_black_widow");
        public static final TagKey<Biome> HAS_YUKI_ONNA = tag("has_yuki_onna");
        public static final TagKey<Biome> HAS_CHARRED_SKELETON = tag("has_charred_skeleton");
        public static final TagKey<Biome> HAS_GLOW_SPIDER = tag("has_glow_spider");
        public static final TagKey<Biome> HAS_HOST = tag("has_host");
        public static final TagKey<Biome> HAS_SIREN = tag("has_siren");


        public static final TagKey<Biome> GRASSY_DIRT_SHOULD_GENERATE = tag("grassy_dirt_should_generate");

        public static final TagKey<Biome> HAS_CATTAIL = tag("has_cattail");


        private static TagKey<Biome> tag(String name) {
            return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(MODID, name));
        }

        private static TagKey<Biome> tagC(String name) {
            return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("c", name));
        }

    }


}
