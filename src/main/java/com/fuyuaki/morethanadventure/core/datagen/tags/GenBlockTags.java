package com.fuyuaki.morethanadventure.core.datagen.tags;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlocks;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class GenBlockTags extends IntrinsicHolderTagsProvider<Block> {

    public GenBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Registries.BLOCK, lookupProvider, block -> block.builtInRegistryHolder().key(),MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(MtaTags.Blocks.ALPINE_LOGS).add(
                MtaBlocks.ALPINE_LOG.get(),
                MtaBlocks.ALPINE_WOOD.get()
        );
        this.tag(MtaTags.Blocks.AVOCADO_LOGS).add(
                MtaBlocks.AVOCADO_LOG.get(),
                MtaBlocks.AVOCADO_WOOD.get()
        );
        this.tag(MtaTags.Blocks.BOGGED_OAK_LOGS).add(
                MtaBlocks.BOGGED_OAK_LOG.get(),
                MtaBlocks.BOGGED_OAK_WOOD.get()
        );
        this.tag(MtaTags.Blocks.IPE_LOGS).add(
                MtaBlocks.IPE_LOG.get(),
                MtaBlocks.IPE_WOOD.get()
        );
        this.tag(MtaTags.Blocks.MANGO_LOGS).add(
                MtaBlocks.MANGO_LOG.get(),
                MtaBlocks.MANGO_WOOD.get()
        );
        this.tag(MtaTags.Blocks.MAPLE_LOGS).add(
                MtaBlocks.MAPLE_LOG.get(),
                MtaBlocks.MAPLE_WOOD.get()
        );
        this.tag(MtaTags.Blocks.PALM_LOGS).add(
                MtaBlocks.PALM_LOG.get(),
                MtaBlocks.PALM_WOOD.get()
        );
        this.tag(MtaTags.Blocks.SEAWOOD).add(
                MtaBlocks.SEALOG.get(),
                MtaBlocks.SEAWOOD.get()
        );
        this.tag(BlockTags.INSIDE_STEP_SOUND_BLOCKS)
                .add(
                        MtaBlocks.SCATTERED_LEAVES.get()
                );

        this.tag(BlockTags.SWORD_EFFICIENT)
                .add(
                        MtaBlocks.SCATTERED_LEAVES.get()
                );

        this.tag(BlockTags.LOGS_THAT_BURN).add(
                MtaBlocks.ALPINE_LOG.get(),
                MtaBlocks.STRIPPED_ALPINE_LOG.get(),
                MtaBlocks.ALPINE_WOOD.get(),
                MtaBlocks.STRIPPED_ALPINE_WOOD.get(),
                MtaBlocks.AVOCADO_LOG.get(),
                MtaBlocks.STRIPPED_AVOCADO_LOG.get(),
                MtaBlocks.AVOCADO_WOOD.get(),
                MtaBlocks.STRIPPED_AVOCADO_WOOD.get(),
                MtaBlocks.IPE_LOG.get(),
                MtaBlocks.STRIPPED_IPE_LOG.get(),
                MtaBlocks.IPE_WOOD.get(),
                MtaBlocks.STRIPPED_IPE_WOOD.get(),
                MtaBlocks.MANGO_LOG.get(),
                MtaBlocks.STRIPPED_MANGO_LOG.get(),
                MtaBlocks.MANGO_WOOD.get(),
                MtaBlocks.STRIPPED_MANGO_WOOD.get(),
                MtaBlocks.MAPLE_LOG.get(),
                MtaBlocks.STRIPPED_MAPLE_LOG.get(),
                MtaBlocks.MAPLE_WOOD.get(),
                MtaBlocks.STRIPPED_MAPLE_WOOD.get(),
                MtaBlocks.PALM_LOG.get(),
                MtaBlocks.STRIPPED_PALM_LOG.get(),
                MtaBlocks.PALM_WOOD.get(),
                MtaBlocks.STRIPPED_PALM_WOOD.get(),
                MtaBlocks.SEALOG.get(),
                MtaBlocks.SEAWOOD.get()
        );

        this.tag(BlockTags.SLABS).add(MtaBlocks.BOGGED_OAK_SLAB.get());
        this.tag(BlockTags.STAIRS).add(MtaBlocks.BOGGED_OAK_STAIRS.get());
        this.tag(BlockTags.FENCES).add(MtaBlocks.BOGGED_OAK_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(MtaBlocks.BOGGED_OAK_FENCE_GATE.get());
        this.tag(BlockTags.DOORS).add(MtaBlocks.BOGGED_OAK_DOOR.get());
        this.tag(BlockTags.TRAPDOORS).add(MtaBlocks.BOGGED_OAK_TRAPDOOR.get());


        this.tag(BlockTags.PLANKS).add(
                MtaBlocks.ALPINE_PLANKS.get(),
                MtaBlocks.AVOCADO_PLANKS.get(),
                MtaBlocks.BOGGED_OAK_PLANKS.get(),
                MtaBlocks.IPE_PLANKS.get(),
                MtaBlocks.MANGO_PLANKS.get(),
                MtaBlocks.MAPLE_PLANKS.get(),
                MtaBlocks.PALM_PLANKS.get(),
                MtaBlocks.SEAWOOD_PLANKS.get()

        );

        this.tag(BlockTags.LEAVES).add(

                MtaBlocks.ALPINE_LEAVES.get(),
                MtaBlocks.AVOCADO_LEAVES.get(),
                MtaBlocks.PINK_IPE_LEAVES.get(),
                MtaBlocks.PURPLE_IPE_LEAVES.get(),
                MtaBlocks.WHITE_IPE_LEAVES.get(),
                MtaBlocks.YELLOW_IPE_LEAVES.get(),
                MtaBlocks.MANGO_LEAVES.get(),
                MtaBlocks.MAPLE_LEAVES.get(),
                MtaBlocks.PALM_LEAVES.get(),
                MtaBlocks.SEAWOOD_LEAVES.get()
        );
        this.tag(BlockTags.WOODEN_STAIRS).add(
                MtaBlocks.ALPINE_STAIRS.get(),
                MtaBlocks.AVOCADO_STAIRS.get(),
                MtaBlocks.IPE_STAIRS.get(),
                MtaBlocks.MANGO_STAIRS.get(),
                MtaBlocks.MAPLE_STAIRS.get(),
                MtaBlocks.PALM_STAIRS.get(),
                MtaBlocks.SEAWOOD_STAIRS.get()
        );
        this.tag(BlockTags.WOODEN_SLABS).add(
                MtaBlocks.ALPINE_SLAB.get(),
                MtaBlocks.AVOCADO_SLAB.get(),
                MtaBlocks.IPE_SLAB.get(),
                MtaBlocks.MANGO_SLAB.get(),
                MtaBlocks.MAPLE_SLAB.get(),
                MtaBlocks.PALM_SLAB.get(),
                MtaBlocks.SEAWOOD_SLAB.get()
        );
        this.tag(BlockTags.WOODEN_BUTTONS).add(
                MtaBlocks.ALPINE_BUTTON.get(),
                MtaBlocks.AVOCADO_BUTTON.get(),
                MtaBlocks.IPE_BUTTON.get(),
                MtaBlocks.MANGO_BUTTON.get(),
                MtaBlocks.MAPLE_BUTTON.get(),
                MtaBlocks.PALM_BUTTON.get(),
                MtaBlocks.SEAWOOD_BUTTON.get()
        );
        this.tag(BlockTags.WOODEN_FENCES).add(
                MtaBlocks.ALPINE_FENCE.get(),
                MtaBlocks.AVOCADO_FENCE.get(),
                MtaBlocks.IPE_FENCE.get(),
                MtaBlocks.MANGO_FENCE.get(),
                MtaBlocks.MAPLE_FENCE.get(),
                MtaBlocks.PALM_FENCE.get(),
                MtaBlocks.SEAWOOD_FENCE.get()
        );
        this.tag(BlockTags.WOODEN_DOORS).add(
                MtaBlocks.ALPINE_DOOR.get(),
                MtaBlocks.AVOCADO_DOOR.get(),
                MtaBlocks.IPE_DOOR.get(),
                MtaBlocks.MANGO_DOOR.get(),
                MtaBlocks.MAPLE_DOOR.get(),
                MtaBlocks.PALM_DOOR.get(),
                MtaBlocks.SEAWOOD_DOOR.get()
        );
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(
                MtaBlocks.ALPINE_TRAPDOOR.get(),
                MtaBlocks.AVOCADO_TRAPDOOR.get(),
                MtaBlocks.IPE_TRAPDOOR.get(),
                MtaBlocks.MANGO_TRAPDOOR.get(),
                MtaBlocks.MAPLE_TRAPDOOR.get(),
                MtaBlocks.PALM_TRAPDOOR.get(),
                MtaBlocks.SEAWOOD_TRAPDOOR.get()
        );
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(
                MtaBlocks.ALPINE_PRESSURE_PLATE.get(),
                MtaBlocks.AVOCADO_PRESSURE_PLATE.get(),
                MtaBlocks.IPE_PRESSURE_PLATE.get(),
                MtaBlocks.MANGO_PRESSURE_PLATE.get(),
                MtaBlocks.MAPLE_PRESSURE_PLATE.get(),
                MtaBlocks.PALM_PRESSURE_PLATE.get(),
                MtaBlocks.SEAWOOD_PRESSURE_PLATE.get()
        );
        this.tag(BlockTags.STANDING_SIGNS).add(
                MtaBlocks.ALPINE_SIGN.get(),
                MtaBlocks.AVOCADO_SIGN.get(),
                MtaBlocks.BOGGED_OAK_SIGN.get(),
                MtaBlocks.IPE_SIGN.get(),
                MtaBlocks.MANGO_SIGN.get(),
                MtaBlocks.MAPLE_SIGN.get(),
                MtaBlocks.PALM_SIGN.get(),
                MtaBlocks.SEAWOOD_SIGN.get()
        );
        this.tag(BlockTags.WALL_SIGNS).add(
                MtaBlocks.ALPINE_WALL_SIGN.get(),
                MtaBlocks.AVOCADO_WALL_SIGN.get(),
                MtaBlocks.BOGGED_OAK_WALL_SIGN.get(),
                MtaBlocks.IPE_WALL_SIGN.get(),
                MtaBlocks.MANGO_WALL_SIGN.get(),
                MtaBlocks.MAPLE_WALL_SIGN.get(),
                MtaBlocks.PALM_WALL_SIGN.get(),
                MtaBlocks.SEAWOOD_WALL_SIGN.get()
        );
        this.tag(BlockTags.CEILING_HANGING_SIGNS).add(
                MtaBlocks.ALPINE_HANGING_SIGN.get(),
                MtaBlocks.AVOCADO_HANGING_SIGN.get(),
                MtaBlocks.BOGGED_OAK_HANGING_SIGN.get(),
                MtaBlocks.IPE_HANGING_SIGN.get(),
                MtaBlocks.MANGO_HANGING_SIGN.get(),
                MtaBlocks.MAPLE_HANGING_SIGN.get(),
                MtaBlocks.PALM_HANGING_SIGN.get(),
                MtaBlocks.SEAWOOD_HANGING_SIGN.get()
        );
        this.tag(BlockTags.WALL_HANGING_SIGNS).add(
                MtaBlocks.ALPINE_HANGING_WALL_SIGN.get(),
                MtaBlocks.AVOCADO_HANGING_WALL_SIGN.get(),
                MtaBlocks.BOGGED_OAK_HANGING_WALL_SIGN.get(),
                MtaBlocks.IPE_HANGING_WALL_SIGN.get(),
                MtaBlocks.MANGO_HANGING_WALL_SIGN.get(),
                MtaBlocks.MAPLE_HANGING_WALL_SIGN.get(),
                MtaBlocks.PALM_HANGING_WALL_SIGN.get(),
                MtaBlocks.SEAWOOD_HANGING_WALL_SIGN.get()
        );
        this.tag(BlockTags.STONE_BUTTONS).add(
                MtaBlocks.BOGGED_OAK_BUTTON.get()
        );
        this.tag(BlockTags.STONE_PRESSURE_PLATES).add(
                MtaBlocks.BOGGED_OAK_PRESSURE_PLATE.get()
        );
        this.tag(BlockTags.SAPLINGS).add(
                MtaBlocks.ALPINE_SAPLING.get(),
                MtaBlocks.AVOCADO_SAPLING.get(),
                MtaBlocks.PINK_IPE_SAPLING.get(),
                MtaBlocks.PURPLE_IPE_SAPLING.get(),
                MtaBlocks.WHITE_IPE_SAPLING.get(),
                MtaBlocks.YELLOW_IPE_SAPLING.get(),
                MtaBlocks.MANGO_SAPLING.get(),
                MtaBlocks.MAPLE_SAPLING.get(),
                MtaBlocks.PALM_SAPLING.get(),
                MtaBlocks.SEAWOOD_SAPLING.get()
        );

        this.tag(MtaTags.Blocks.NEEDS_COPPER_TOOL).add(
                Blocks.GOLD_BLOCK,
                Blocks.GOLD_ORE,
                Blocks.RAW_GOLD_BLOCK,
                Blocks.DEEPSLATE_GOLD_ORE,
                Blocks.REDSTONE_ORE,
                Blocks.DEEPSLATE_REDSTONE_ORE
        );
        this.tag(MtaTags.Blocks.NEEDS_NETHERSTEEL_TOOL).add(
                MtaBlocks.NETHERITIC_CRYSTAL.get(),
                Blocks.OBSIDIAN
        );

        this.tag(MtaTags.Blocks.NEEDS_GEM_TOOL);


        this.tag(MtaTags.Blocks.INCORRECT_FOR_GEM_TOOL).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL).remove(MtaTags.Blocks.NEEDS_GEM_TOOL);
        this.tag(MtaTags.Blocks.INCORRECT_FOR_COPPER_TOOL).addTag(BlockTags.INCORRECT_FOR_STONE_TOOL).remove(MtaTags.Blocks.NEEDS_COPPER_TOOL);
        this.tag(MtaTags.Blocks.INCORRECT_FOR_NETHERSTEEL_TOOL).addTag(BlockTags.INCORRECT_FOR_IRON_TOOL).remove(MtaTags.Blocks.NEEDS_NETHERSTEEL_TOOL);

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).addTag(MtaTags.Blocks.NEEDS_NETHERSTEEL_TOOL).add(
                MtaBlocks.AGATE_ORE.get(),
                MtaBlocks.DEEPSLATE_AGATE_ORE.get(),
                MtaBlocks.ALEXANDRITE_ORE.get(),
                MtaBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
                MtaBlocks.AQUAMARINE_ORE.get(),
                MtaBlocks.DEEPSLATE_AQUAMARINE_ORE.get(),
                MtaBlocks.BLOODSTONE_ORE.get(),
                MtaBlocks.DEEPSLATE_BLOODSTONE_ORE.get(),
                MtaBlocks.CELESTITE_ORE.get(),
                MtaBlocks.CRYOLITE_ORE.get(),
                MtaBlocks.DEEPSLATE_CELESTITE_ORE.get(),
                MtaBlocks.GARNET_ORE.get(),
                MtaBlocks.DEEPSLATE_GARNET_ORE.get(),
                MtaBlocks.MOONSTONE_ORE.get(),
                MtaBlocks.DEEPSLATE_MOONSTONE_ORE.get()
        );
        this.tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL).remove(MtaTags.Blocks.NEEDS_NETHERSTEEL_TOOL);


        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                MtaBlocks.NETHER_DIAMOND_ORE.get(),
                MtaBlocks.END_EMERALD_ORE.get(),
                MtaBlocks.END_LAPIS_ORE.get(),
                MtaBlocks.WISESTONE.get(),
                MtaBlocks.END_WISESTONE.get(),
                MtaBlocks.DEEPSLATE_WISESTONE.get()

        ).remove(MtaTags.Blocks.NEEDS_NETHERSTEEL_TOOL).remove(MtaTags.Blocks.NEEDS_COPPER_TOOL);

        this.tag(BlockTags.NEEDS_STONE_TOOL).add(
                MtaBlocks.NETHER_IRON_ORE.get(),
                MtaBlocks.CLEAR_QUARTZ_ORE.get(),
                MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_ORE.get()
        );
        this.tag(BlockTags.MINEABLE_WITH_HOE).add(
                MtaBlocks.ALPINE_LEAVES.get(),
                MtaBlocks.AVOCADO_LEAVES.get(),
                MtaBlocks.PINK_IPE_LEAVES.get(),
                MtaBlocks.PURPLE_IPE_LEAVES.get(),
                MtaBlocks.WHITE_IPE_LEAVES.get(),
                MtaBlocks.YELLOW_IPE_LEAVES.get(),
                MtaBlocks.MANGO_LEAVES.get(),
                MtaBlocks.MAPLE_LEAVES.get(),
                MtaBlocks.PALM_LEAVES.get(),
                MtaBlocks.SCATTERED_LEAVES.get()
        );
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(
                MtaBlocks.DEATH_CAP_BLOCK.get(),
                MtaBlocks.DEATH_ANGEL_BLOCK.get(),
                MtaBlocks.FLY_AGARIC_BLOCK.get(),
                MtaBlocks.KING_BOLETE_BLOCK.get(),
                MtaBlocks.MAITAKE_BLOCK.get(),
                MtaBlocks.MOREL_BLOCK.get()
        );
        this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(
                        MtaBlocks.SAND_PATH.get(),
                        MtaBlocks.GRASSY_DIRT.get(),
                        MtaBlocks.GRASSY_SAND.get(),
                        MtaBlocks.PERMAFROST_GRASS.get(),
                        MtaBlocks.PERMAFROST_DIRT.get(),
                        MtaBlocks.TUNDRA_GRASS.get(),
                        MtaBlocks.COARSE_DIRT_PATH.get(),
                        MtaBlocks.COBBLED_DIRT.get()
                );

        this.tag(BlockTags.DIRT)
                .add(
                        MtaBlocks.GRASSY_DIRT.get(),
                        MtaBlocks.COARSE_DIRT_PATH.get(),
                        MtaBlocks.COBBLED_DIRT.get(),
                        MtaBlocks.PEAT.get(),
                        MtaBlocks.PERMAFROST_GRASS.get(),
                        MtaBlocks.PERMAFROST_DIRT.get(),
                        MtaBlocks.TUNDRA_GRASS.get()
                );
        this.tag(MtaTags.Blocks.DIRTIES_STONE_TILES)
                .add(
                        Blocks.GRASS_BLOCK,
                        MtaBlocks.DIRTY_STONE_TILES.get(),
                        MtaBlocks.VERY_DIRTY_STONE_TILES.get()
                )
                .addTag(BlockTags.DIRT);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                MtaBlocks.BOGGED_OAK_LOG.get(),
                MtaBlocks.STRIPPED_BOGGED_OAK_LOG.get(),
                MtaBlocks.BOGGED_OAK_WOOD.get(),
                MtaBlocks.STRIPPED_BOGGED_OAK_WOOD.get(),
                MtaBlocks.BOGGED_OAK_PLANKS.get(),
                MtaBlocks.BOGGED_OAK_STAIRS.get(),
                MtaBlocks.BOGGED_OAK_SLAB.get(),
                MtaBlocks.BOGGED_OAK_PRESSURE_PLATE.get(),
                MtaBlocks.BOGGED_OAK_BUTTON.get(),
                MtaBlocks.BOGGED_OAK_FENCE.get(),
                MtaBlocks.BOGGED_OAK_FENCE_GATE.get(),
                MtaBlocks.BOGGED_OAK_DOOR.get(),
                MtaBlocks.BOGGED_OAK_TRAPDOOR.get(),

                MtaBlocks.NETHER_IRON_ORE.get(),
                MtaBlocks.NETHER_DIAMOND_ORE.get(),
                MtaBlocks.END_EMERALD_ORE.get(),
                MtaBlocks.END_LAPIS_ORE.get(),
                MtaBlocks.CLEAR_QUARTZ_ORE.get(),
                MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_ORE.get(),
                MtaBlocks.CLEAR_QUARTZ_GROWTH.get(),
                MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_GROWTH.get(),
                MtaBlocks.CALCITE_CLEAR_QUARTZ_GROWTH.get(),
                MtaBlocks.NETHERITIC_CRYSTAL.get(),
                MtaBlocks.QUARTZ_LAMP.get(),
                MtaBlocks.COBBLED_DIRT.get(),
                MtaBlocks.PERMAFROST_STONE.get(),

                MtaBlocks.STONE_TILES.get(),
                MtaBlocks.STONE_TILES_SLAB.get(),
                MtaBlocks.STONE_TILES_STAIRS.get(),
                MtaBlocks.STONE_TILES_WALL.get(),
                MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES.get(),
                MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_SLAB.get(),
                MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_STAIRS.get(),
                MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_WALL.get(),
                MtaBlocks.DIRTY_STONE_TILES.get(),
                MtaBlocks.DIRTY_STONE_TILES_SLAB.get(),
                MtaBlocks.DIRTY_STONE_TILES_STAIRS.get(),
                MtaBlocks.DIRTY_STONE_TILES_WALL.get(),
                MtaBlocks.VERY_DIRTY_STONE_TILES.get(),
                MtaBlocks.VERY_DIRTY_STONE_TILES_SLAB.get(),
                MtaBlocks.VERY_DIRTY_STONE_TILES_STAIRS.get(),
                MtaBlocks.VERY_DIRTY_STONE_TILES_WALL.get(),

                MtaBlocks.TERRACOTTA_TILES.get(),
                MtaBlocks.TERRACOTTA_SLAB.get(),
                MtaBlocks.TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.TERRACOTTA_STAIRS.get(),
                MtaBlocks.TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.TERRACOTTA_WALL.get(),
                MtaBlocks.TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.WHITE_TERRACOTTA_TILES.get(),
                MtaBlocks.WHITE_TERRACOTTA_SLAB.get(),
                MtaBlocks.WHITE_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.WHITE_TERRACOTTA_STAIRS.get(),
                MtaBlocks.WHITE_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.WHITE_TERRACOTTA_WALL.get(),
                MtaBlocks.WHITE_TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES.get(),
                MtaBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get(),
                MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get(),
                MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get(),
                MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.GRAY_TERRACOTTA_TILES.get(),
                MtaBlocks.GRAY_TERRACOTTA_SLAB.get(),
                MtaBlocks.GRAY_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.GRAY_TERRACOTTA_STAIRS.get(),
                MtaBlocks.GRAY_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.GRAY_TERRACOTTA_WALL.get(),
                MtaBlocks.GRAY_TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.BLACK_TERRACOTTA_TILES.get(),
                MtaBlocks.BLACK_TERRACOTTA_SLAB.get(),
                MtaBlocks.BLACK_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.BLACK_TERRACOTTA_STAIRS.get(),
                MtaBlocks.BLACK_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.BLACK_TERRACOTTA_WALL.get(),
                MtaBlocks.BLACK_TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.BROWN_TERRACOTTA_TILES.get(),
                MtaBlocks.BROWN_TERRACOTTA_SLAB.get(),
                MtaBlocks.BROWN_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.BROWN_TERRACOTTA_STAIRS.get(),
                MtaBlocks.BROWN_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.BROWN_TERRACOTTA_WALL.get(),
                MtaBlocks.BROWN_TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.RED_TERRACOTTA_TILES.get(),
                MtaBlocks.RED_TERRACOTTA_SLAB.get(),
                MtaBlocks.RED_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.RED_TERRACOTTA_STAIRS.get(),
                MtaBlocks.RED_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.RED_TERRACOTTA_WALL.get(),
                MtaBlocks.RED_TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.ORANGE_TERRACOTTA_TILES.get(),
                MtaBlocks.ORANGE_TERRACOTTA_SLAB.get(),
                MtaBlocks.ORANGE_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.ORANGE_TERRACOTTA_STAIRS.get(),
                MtaBlocks.ORANGE_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.ORANGE_TERRACOTTA_WALL.get(),
                MtaBlocks.ORANGE_TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.YELLOW_TERRACOTTA_TILES.get(),
                MtaBlocks.YELLOW_TERRACOTTA_SLAB.get(),
                MtaBlocks.YELLOW_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.YELLOW_TERRACOTTA_STAIRS.get(),
                MtaBlocks.YELLOW_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.YELLOW_TERRACOTTA_WALL.get(),
                MtaBlocks.YELLOW_TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.LIME_TERRACOTTA_TILES.get(),
                MtaBlocks.LIME_TERRACOTTA_SLAB.get(),
                MtaBlocks.LIME_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.LIME_TERRACOTTA_STAIRS.get(),
                MtaBlocks.LIME_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.LIME_TERRACOTTA_WALL.get(),
                MtaBlocks.LIME_TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.GREEN_TERRACOTTA_TILES.get(),
                MtaBlocks.GREEN_TERRACOTTA_SLAB.get(),
                MtaBlocks.GREEN_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.GREEN_TERRACOTTA_STAIRS.get(),
                MtaBlocks.GREEN_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.GREEN_TERRACOTTA_WALL.get(),
                MtaBlocks.GREEN_TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.CYAN_TERRACOTTA_TILES.get(),
                MtaBlocks.CYAN_TERRACOTTA_SLAB.get(),
                MtaBlocks.CYAN_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.CYAN_TERRACOTTA_STAIRS.get(),
                MtaBlocks.CYAN_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.CYAN_TERRACOTTA_WALL.get(),
                MtaBlocks.CYAN_TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES.get(),
                MtaBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get(),
                MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get(),
                MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get(),
                MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.BLUE_TERRACOTTA_TILES.get(),
                MtaBlocks.BLUE_TERRACOTTA_SLAB.get(),
                MtaBlocks.BLUE_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.BLUE_TERRACOTTA_STAIRS.get(),
                MtaBlocks.BLUE_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.BLUE_TERRACOTTA_WALL.get(),
                MtaBlocks.BLUE_TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.PURPLE_TERRACOTTA_TILES.get(),
                MtaBlocks.PURPLE_TERRACOTTA_SLAB.get(),
                MtaBlocks.PURPLE_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.PURPLE_TERRACOTTA_STAIRS.get(),
                MtaBlocks.PURPLE_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.PURPLE_TERRACOTTA_WALL.get(),
                MtaBlocks.PURPLE_TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.MAGENTA_TERRACOTTA_TILES.get(),
                MtaBlocks.MAGENTA_TERRACOTTA_SLAB.get(),
                MtaBlocks.MAGENTA_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.MAGENTA_TERRACOTTA_STAIRS.get(),
                MtaBlocks.MAGENTA_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.MAGENTA_TERRACOTTA_WALL.get(),
                MtaBlocks.MAGENTA_TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.PINK_TERRACOTTA_TILES.get(),
                MtaBlocks.PINK_TERRACOTTA_SLAB.get(),
                MtaBlocks.PINK_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.PINK_TERRACOTTA_STAIRS.get(),
                MtaBlocks.PINK_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.PINK_TERRACOTTA_WALL.get(),
                MtaBlocks.PINK_TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.WHITE_CONCRETE_SLAB.get(),
                MtaBlocks.WHITE_CONCRETE_STAIRS.get(),
                MtaBlocks.WHITE_CONCRETE_WALL.get(),
                MtaBlocks.LIGHT_GRAY_CONCRETE_SLAB.get(),
                MtaBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get(),
                MtaBlocks.LIGHT_GRAY_CONCRETE_WALL.get(),
                MtaBlocks.GRAY_CONCRETE_SLAB.get(),
                MtaBlocks.GRAY_CONCRETE_STAIRS.get(),
                MtaBlocks.GRAY_CONCRETE_WALL.get(),
                MtaBlocks.BLACK_CONCRETE_SLAB.get(),
                MtaBlocks.BLACK_CONCRETE_STAIRS.get(),
                MtaBlocks.BLACK_CONCRETE_WALL.get(),
                MtaBlocks.BROWN_CONCRETE_SLAB.get(),
                MtaBlocks.BROWN_CONCRETE_STAIRS.get(),
                MtaBlocks.BROWN_CONCRETE_WALL.get(),
                MtaBlocks.RED_CONCRETE_SLAB.get(),
                MtaBlocks.RED_CONCRETE_STAIRS.get(),
                MtaBlocks.RED_CONCRETE_WALL.get(),
                MtaBlocks.ORANGE_CONCRETE_SLAB.get(),
                MtaBlocks.ORANGE_CONCRETE_STAIRS.get(),
                MtaBlocks.ORANGE_CONCRETE_WALL.get(),
                MtaBlocks.YELLOW_CONCRETE_SLAB.get(),
                MtaBlocks.YELLOW_CONCRETE_STAIRS.get(),
                MtaBlocks.YELLOW_CONCRETE_WALL.get(),
                MtaBlocks.LIME_CONCRETE_SLAB.get(),
                MtaBlocks.LIME_CONCRETE_STAIRS.get(),
                MtaBlocks.LIME_CONCRETE_WALL.get(),
                MtaBlocks.GREEN_CONCRETE_SLAB.get(),
                MtaBlocks.GREEN_CONCRETE_STAIRS.get(),
                MtaBlocks.GREEN_CONCRETE_WALL.get(),
                MtaBlocks.CYAN_CONCRETE_SLAB.get(),
                MtaBlocks.CYAN_CONCRETE_STAIRS.get(),
                MtaBlocks.CYAN_CONCRETE_WALL.get(),
                MtaBlocks.LIGHT_BLUE_CONCRETE_SLAB.get(),
                MtaBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get(),
                MtaBlocks.LIGHT_BLUE_CONCRETE_WALL.get(),
                MtaBlocks.BLUE_CONCRETE_SLAB.get(),
                MtaBlocks.BLUE_CONCRETE_STAIRS.get(),
                MtaBlocks.BLUE_CONCRETE_WALL.get(),
                MtaBlocks.PURPLE_CONCRETE_SLAB.get(),
                MtaBlocks.PURPLE_CONCRETE_STAIRS.get(),
                MtaBlocks.PURPLE_CONCRETE_WALL.get(),
                MtaBlocks.MAGENTA_CONCRETE_SLAB.get(),
                MtaBlocks.MAGENTA_CONCRETE_STAIRS.get(),
                MtaBlocks.MAGENTA_CONCRETE_WALL.get(),
                MtaBlocks.PINK_CONCRETE_SLAB.get(),
                MtaBlocks.PINK_CONCRETE_STAIRS.get(),
                MtaBlocks.PINK_CONCRETE_WALL.get(),
                MtaBlocks.AGATE_ORE.get(),
                MtaBlocks.DEEPSLATE_AGATE_ORE.get(),
                MtaBlocks.ALEXANDRITE_ORE.get(),
                MtaBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
                MtaBlocks.AQUAMARINE_ORE.get(),
                MtaBlocks.DEEPSLATE_AQUAMARINE_ORE.get(),
                MtaBlocks.BLOODSTONE_ORE.get(),
                MtaBlocks.DEEPSLATE_BLOODSTONE_ORE.get(),
                MtaBlocks.CELESTITE_ORE.get(),
                MtaBlocks.CRYOLITE_ORE.get(),
                MtaBlocks.DEEPSLATE_CELESTITE_ORE.get(),
                MtaBlocks.GARNET_ORE.get(),
                MtaBlocks.DEEPSLATE_GARNET_ORE.get(),
                MtaBlocks.MOONSTONE_ORE.get(),
                MtaBlocks.DEEPSLATE_MOONSTONE_ORE.get(),
                MtaBlocks.WISESTONE.get(),
                MtaBlocks.END_WISESTONE.get(),
                MtaBlocks.DEEPSLATE_WISESTONE.get()
                );
        this.tag(BlockTags.SLABS).add(
                MtaBlocks.STONE_TILES_SLAB.get(),
                MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_SLAB.get(),
                MtaBlocks.DIRTY_STONE_TILES_STAIRS.get(),
                MtaBlocks.VERY_DIRTY_STONE_TILES_STAIRS.get(),
                MtaBlocks.TERRACOTTA_SLAB.get(),
                MtaBlocks.TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.WHITE_TERRACOTTA_SLAB.get(),
                MtaBlocks.WHITE_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get(),
                MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.GRAY_TERRACOTTA_SLAB.get(),
                MtaBlocks.GRAY_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.BLACK_TERRACOTTA_SLAB.get(),
                MtaBlocks.BLACK_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.BROWN_TERRACOTTA_SLAB.get(),
                MtaBlocks.BROWN_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.RED_TERRACOTTA_SLAB.get(),
                MtaBlocks.RED_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.ORANGE_TERRACOTTA_SLAB.get(),
                MtaBlocks.ORANGE_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.YELLOW_TERRACOTTA_SLAB.get(),
                MtaBlocks.YELLOW_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.LIME_TERRACOTTA_SLAB.get(),
                MtaBlocks.LIME_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.GREEN_TERRACOTTA_SLAB.get(),
                MtaBlocks.GREEN_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.CYAN_TERRACOTTA_SLAB.get(),
                MtaBlocks.CYAN_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get(),
                MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.BLUE_TERRACOTTA_SLAB.get(),
                MtaBlocks.BLUE_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.PURPLE_TERRACOTTA_SLAB.get(),
                MtaBlocks.PURPLE_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.MAGENTA_TERRACOTTA_SLAB.get(),
                MtaBlocks.MAGENTA_TERRACOTTA_TILES_SLAB.get(),
                MtaBlocks.PINK_TERRACOTTA_SLAB.get(),
                MtaBlocks.PINK_TERRACOTTA_TILES_SLAB.get(),

                MtaBlocks.WHITE_CONCRETE_SLAB.get(),
                MtaBlocks.LIGHT_GRAY_CONCRETE_SLAB.get(),
                MtaBlocks.GRAY_CONCRETE_SLAB.get(),
                MtaBlocks.BLACK_CONCRETE_SLAB.get(),
                MtaBlocks.BROWN_CONCRETE_SLAB.get(),
                MtaBlocks.RED_CONCRETE_SLAB.get(),
                MtaBlocks.ORANGE_CONCRETE_SLAB.get(),
                MtaBlocks.YELLOW_CONCRETE_SLAB.get(),
                MtaBlocks.LIME_CONCRETE_SLAB.get(),
                MtaBlocks.GREEN_CONCRETE_SLAB.get(),
                MtaBlocks.CYAN_CONCRETE_SLAB.get(),
                MtaBlocks.LIGHT_BLUE_CONCRETE_SLAB.get(),
                MtaBlocks.BLUE_CONCRETE_SLAB.get(),
                MtaBlocks.PURPLE_CONCRETE_SLAB.get(),
                MtaBlocks.MAGENTA_CONCRETE_SLAB.get(),
                MtaBlocks.PINK_CONCRETE_SLAB.get()
        );

        this.tag(BlockTags.STAIRS).add(
                MtaBlocks.STONE_TILES_STAIRS.get(),
                MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_STAIRS.get(),
                MtaBlocks.DIRTY_STONE_TILES_STAIRS.get(),
                MtaBlocks.VERY_DIRTY_STONE_TILES_STAIRS.get(),
                MtaBlocks.TERRACOTTA_STAIRS.get(),
                MtaBlocks.TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.WHITE_TERRACOTTA_STAIRS.get(),
                MtaBlocks.WHITE_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get(),
                MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.GRAY_TERRACOTTA_STAIRS.get(),
                MtaBlocks.GRAY_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.BLACK_TERRACOTTA_STAIRS.get(),
                MtaBlocks.BLACK_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.BROWN_TERRACOTTA_STAIRS.get(),
                MtaBlocks.BROWN_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.RED_TERRACOTTA_STAIRS.get(),
                MtaBlocks.RED_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.ORANGE_TERRACOTTA_STAIRS.get(),
                MtaBlocks.ORANGE_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.YELLOW_TERRACOTTA_STAIRS.get(),
                MtaBlocks.YELLOW_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.LIME_TERRACOTTA_STAIRS.get(),
                MtaBlocks.LIME_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.GREEN_TERRACOTTA_STAIRS.get(),
                MtaBlocks.GREEN_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.CYAN_TERRACOTTA_STAIRS.get(),
                MtaBlocks.CYAN_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get(),
                MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.BLUE_TERRACOTTA_STAIRS.get(),
                MtaBlocks.BLUE_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.PURPLE_TERRACOTTA_STAIRS.get(),
                MtaBlocks.PURPLE_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.MAGENTA_TERRACOTTA_STAIRS.get(),
                MtaBlocks.MAGENTA_TERRACOTTA_TILES_STAIRS.get(),
                MtaBlocks.PINK_TERRACOTTA_STAIRS.get(),
                MtaBlocks.PINK_TERRACOTTA_TILES_STAIRS.get(),

                MtaBlocks.WHITE_CONCRETE_STAIRS.get(),
                MtaBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get(),
                MtaBlocks.GRAY_CONCRETE_STAIRS.get(),
                MtaBlocks.BLACK_CONCRETE_STAIRS.get(),
                MtaBlocks.BROWN_CONCRETE_STAIRS.get(),
                MtaBlocks.RED_CONCRETE_STAIRS.get(),
                MtaBlocks.ORANGE_CONCRETE_STAIRS.get(),
                MtaBlocks.YELLOW_CONCRETE_STAIRS.get(),
                MtaBlocks.LIME_CONCRETE_STAIRS.get(),
                MtaBlocks.GREEN_CONCRETE_STAIRS.get(),
                MtaBlocks.CYAN_CONCRETE_STAIRS.get(),
                MtaBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get(),
                MtaBlocks.BLUE_CONCRETE_STAIRS.get(),
                MtaBlocks.PURPLE_CONCRETE_STAIRS.get(),
                MtaBlocks.MAGENTA_CONCRETE_STAIRS.get(),
                MtaBlocks.PINK_CONCRETE_STAIRS.get()
        );

        this.tag(BlockTags.WALLS).add(
                MtaBlocks.STONE_TILES_WALL.get(),
                MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_WALL.get(),
                MtaBlocks.DIRTY_STONE_TILES_WALL.get(),
                MtaBlocks.VERY_DIRTY_STONE_TILES_WALL.get(),
                MtaBlocks.TERRACOTTA_WALL.get(),
                MtaBlocks.TERRACOTTA_TILES_WALL.get(),
                MtaBlocks.WHITE_TERRACOTTA_WALL.get(),
                MtaBlocks.WHITE_TERRACOTTA_TILES_WALL.get(),
                MtaBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get(),
                MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_WALL.get(),
                MtaBlocks.GRAY_TERRACOTTA_WALL.get(),
                MtaBlocks.GRAY_TERRACOTTA_TILES_WALL.get(),
                MtaBlocks.BLACK_TERRACOTTA_WALL.get(),
                MtaBlocks.BLACK_TERRACOTTA_TILES_WALL.get(),
                MtaBlocks.BROWN_TERRACOTTA_WALL.get(),
                MtaBlocks.BROWN_TERRACOTTA_TILES_WALL.get(),
                MtaBlocks.RED_TERRACOTTA_WALL.get(),
                MtaBlocks.RED_TERRACOTTA_TILES_WALL.get(),
                MtaBlocks.ORANGE_TERRACOTTA_WALL.get(),
                MtaBlocks.ORANGE_TERRACOTTA_TILES_WALL.get(),
                MtaBlocks.YELLOW_TERRACOTTA_WALL.get(),
                MtaBlocks.YELLOW_TERRACOTTA_TILES_WALL.get(),
                MtaBlocks.LIME_TERRACOTTA_WALL.get(),
                MtaBlocks.LIME_TERRACOTTA_TILES_WALL.get(),
                MtaBlocks.GREEN_TERRACOTTA_WALL.get(),
                MtaBlocks.GREEN_TERRACOTTA_TILES_WALL.get(),
                MtaBlocks.CYAN_TERRACOTTA_WALL.get(),
                MtaBlocks.CYAN_TERRACOTTA_TILES_WALL.get(),
                MtaBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get(),
                MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_WALL.get(),
                MtaBlocks.BLUE_TERRACOTTA_WALL.get(),
                MtaBlocks.BLUE_TERRACOTTA_WALL.get(),
                MtaBlocks.PURPLE_TERRACOTTA_WALL.get(),
                MtaBlocks.PURPLE_TERRACOTTA_TILES_WALL.get(),
                MtaBlocks.MAGENTA_TERRACOTTA_WALL.get(),
                MtaBlocks.MAGENTA_TERRACOTTA_TILES_WALL.get(),
                MtaBlocks.PINK_TERRACOTTA_WALL.get(),
                MtaBlocks.PINK_TERRACOTTA_TILES_WALL.get(),

                MtaBlocks.WHITE_CONCRETE_WALL.get(),
                MtaBlocks.LIGHT_GRAY_CONCRETE_WALL.get(),
                MtaBlocks.GRAY_CONCRETE_WALL.get(),
                MtaBlocks.BLACK_CONCRETE_WALL.get(),
                MtaBlocks.BROWN_CONCRETE_WALL.get(),
                MtaBlocks.RED_CONCRETE_WALL.get(),
                MtaBlocks.ORANGE_CONCRETE_WALL.get(),
                MtaBlocks.YELLOW_CONCRETE_WALL.get(),
                MtaBlocks.LIME_CONCRETE_WALL.get(),
                MtaBlocks.GREEN_CONCRETE_WALL.get(),
                MtaBlocks.CYAN_CONCRETE_WALL.get(),
                MtaBlocks.LIGHT_BLUE_CONCRETE_WALL.get(),
                MtaBlocks.BLUE_CONCRETE_WALL.get(),
                MtaBlocks.PURPLE_CONCRETE_WALL.get(),
                MtaBlocks.MAGENTA_CONCRETE_WALL.get(),
                MtaBlocks.PINK_CONCRETE_WALL.get()
        );

        this.tag(BlockTags.BASE_STONE_OVERWORLD).add(
                MtaBlocks.PERMAFROST_STONE.get()
        );

        this.tag(BlockTags.IRON_ORES).add(
                MtaBlocks.NETHER_IRON_ORE.get()
        );
        this.tag(BlockTags.DIAMOND_ORES).add(
                MtaBlocks.NETHER_DIAMOND_ORE.get()
        );
        this.tag(BlockTags.LAPIS_ORES).add(
                MtaBlocks.END_LAPIS_ORE.get()
        );
        this.tag(BlockTags.EMERALD_ORES).add(
                MtaBlocks.END_EMERALD_ORE.get()
        );
        this.tag(Tags.Blocks.ORES_QUARTZ).add(
                MtaBlocks.CLEAR_QUARTZ_ORE.get(),
                MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_ORE.get()
        );


        this.tag(MtaTags.Blocks.ORE_CLUSTER_REPLACEABLE)
                .addTag(BlockTags.STONE_ORE_REPLACEABLES)
                .addTag(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
                .addTag(BlockTags.BASE_STONE_OVERWORLD
                );


        this.tag(MtaTags.Blocks.NETHER_CLUSTER_CLUSTER_REPLACEABLE)
                .addTag(Tags.Blocks.NETHERRACKS)
                .addTag(BlockTags.BASE_STONE_NETHER)
                .addTag(BlockTags.NETHER_CARVER_REPLACEABLES
                );

//        this.tag(BlockTags.FLOWERS).add(
//                MtaBlocks.PITCHER_PLANT.get(),
//                MtaBlocks.CORPSE_FLOWER.get()
//        );
        this.tag(BlockTags.SNOW).add(
                MtaBlocks.POLAR_SAND.get(),
                MtaBlocks.GRASSY_SAND.get()
        );

//        this.tag(BlockTags.REPLACEABLE_BY_TREES).add(
//
//        );


        this.tag(MtaTags.Blocks.FLOWER_PLACEABLE)
                .addTag(Tags.Blocks.SANDS).add(
                        Blocks.GRAVEL
                );


        this.tag(MtaTags.Blocks.SAND_VEGETATION_MAY_PLACE_ON).addTag(BlockTags.SAND).addTag(BlockTags.TERRACOTTA).addTag(BlockTags.DIRT);

        this.tag(BlockTags.ANIMALS_SPAWNABLE_ON)
                .add(
                        MtaBlocks.GRASSY_DIRT.get(),
                        MtaBlocks.GRASSY_SAND.get(),
                        Blocks.COARSE_DIRT,
                        Blocks.PODZOL
                );
        this.tag(MtaTags.Blocks.SEA_ANIMAL_SPAWNABLE_ON)
                .addTag(BlockTags.ANIMALS_SPAWNABLE_ON)
                .addTag(BlockTags.CORALS)
                .add(

                        Blocks.STONE,
                        Blocks.WATER,
                        Blocks.GRAVEL,
                        Blocks.WATER,
                        Blocks.SAND,
                        Blocks.DIRT
                );

        this.tag(MtaTags.Blocks.DESERT_ANIMAL_SPAWNABLE_ON)
                .addTag(BlockTags.ANIMALS_SPAWNABLE_ON)
                .addTag(BlockTags.BADLANDS_TERRACOTTA)
                .add(
                        Blocks.RED_SAND,
                        Blocks.COARSE_DIRT,
                        Blocks.DIRT,
                        Blocks.SAND
                );

        this.tag(MtaTags.Blocks.LAND_SWIMMER_SPAWNABLE_ON)
                .addTag(BlockTags.ANIMALS_SPAWNABLE_ON)
                .add(
                        Blocks.STONE,
                        Blocks.WATER,
                        Blocks.GRAVEL,
                        Blocks.WATER,
                        Blocks.SAND,
                        Blocks.DIRT
                );

        this.tag(MtaTags.Blocks.BIRD_SPAWNABLE_ON)
                .addTag(BlockTags.ANIMALS_SPAWNABLE_ON)
                .addTag(BlockTags.LEAVES)
                .add(
                        Blocks.STONE,
                        Blocks.GRAVEL,
                        Blocks.SAND,
                        Blocks.DIRT
                );
        this.tag(MtaTags.Blocks.SNOW_ANIMAL_SPAWNABLE_ON)
                .addTag(BlockTags.ANIMALS_SPAWNABLE_ON)
                .add(
                        Blocks.STONE,
                        Blocks.SNOW,
                        Blocks.SNOW_BLOCK,
                        Blocks.PACKED_ICE,
                        Blocks.ICE,
                        Blocks.GRAVEL);
    }
}
