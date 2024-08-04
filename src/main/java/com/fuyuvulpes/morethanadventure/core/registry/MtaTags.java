package com.fuyuvulpes.morethanadventure.core.registry;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class MtaTags {

    public static class Blocks {
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
}
