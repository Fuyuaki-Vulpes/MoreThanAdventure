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

        public static final TagKey<Block> NEEDS_NETHERSTEEL_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(MODID, "needs_copper_tool"));
        public static final TagKey<Block> INCORRECT_FOR_NETHERSTEEL_TOOL = TagKey.create(BuiltInRegistries.BLOCK.key(), ResourceLocation.fromNamespaceAndPath(MODID, "incorrect_for_cooper_tool"));


    }
}
