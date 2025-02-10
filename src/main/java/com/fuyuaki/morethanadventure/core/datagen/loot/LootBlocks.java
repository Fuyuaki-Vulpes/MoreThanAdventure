package com.fuyuaki.morethanadventure.core.datagen.loot;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlocks;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import com.fuyuaki.morethanadventure.world.block.OnionCropBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LootBlocks extends BlockLootSubProvider {
    List<Block> excludedBlocks = List.of();
    List<Block> knownBlocks = MtaBlocks.BLOCKS.getEntries().stream().map(Holder::value).collect(Collectors.toList());
    protected static final float[] PALM_LEAVES_SAPLING_CHANCES = new float[]{0.1F, 0.2F, 0.4F, 0.6F};

    protected static final float[] NORMAL_LEAVES_SAPLING_CHANCES = new float[]{0.05F, 0.0625F, 0.083333336F, 0.1F};
    private static final float[] NORMAL_LEAVES_STICK_CHANCES = new float[]{0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F};
    public LootBlocks(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(),provider);
    }

    @Override
    protected void generate() {

        add(MtaBlocks.SCATTERED_LEAVES.get(), this.createPetalsDrops(MtaBlocks.SCATTERED_LEAVES.get()));
        add(MtaBlocks.CATTAIL.get(), block ->   this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        dropSelf(MtaBlocks.CORPSE_FLOWER.get());
        dropSelf(MtaBlocks.PITCHER_PLANT.get());
        this.add(MtaBlocks.POTTED_PITCHER_PLANT.get(), createPotFlowerItemTable(MtaBlocks.PITCHER_PLANT));
        dropSelf(MtaBlocks.VENUS_FLYTRAP.get());
        dropSelf(MtaBlocks.STOVE.get());

        dropSelf(MtaBlocks.ALPINE_LOG.get());
        dropSelf(MtaBlocks.STRIPPED_ALPINE_LOG.get());
        dropSelf(MtaBlocks.ALPINE_WOOD.get());
        dropSelf(MtaBlocks.STRIPPED_ALPINE_WOOD.get());
        dropSelf(MtaBlocks.ALPINE_PLANKS.get());
        this.add(MtaBlocks.ALPINE_LEAVES.get(), block -> createLeavesDrops(block, MtaBlocks.ALPINE_SAPLING.get(),NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(MtaBlocks.ALPINE_SAPLING.get());
        dropSelf(MtaBlocks.ALPINE_STAIRS.get());
        this.add(MtaBlocks.ALPINE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.ALPINE_SLAB.get()));
        dropSelf(MtaBlocks.ALPINE_PRESSURE_PLATE.get());
        dropSelf(MtaBlocks.ALPINE_BUTTON.get());
        dropSelf(MtaBlocks.ALPINE_FENCE.get());
        dropSelf(MtaBlocks.ALPINE_FENCE_GATE.get());
        this.add(MtaBlocks.ALPINE_DOOR.get(), block -> createDoorTable(MtaBlocks.ALPINE_DOOR.get()));
        dropSelf(MtaBlocks.ALPINE_TRAPDOOR.get());
        dropSelf(MtaBlocks.ALPINE_SIGN.get());
        dropOther(MtaBlocks.ALPINE_WALL_SIGN.get(), MtaBlocks.ALPINE_SIGN);
        dropSelf(MtaBlocks.ALPINE_HANGING_SIGN.get());
        dropOther(MtaBlocks.ALPINE_HANGING_WALL_SIGN.get(), MtaBlocks.ALPINE_HANGING_SIGN);
        dropPottedContents(MtaBlocks.POTTED_ALPINE_SAPLING.get());


        dropSelf(MtaBlocks.AVOCADO_LOG.get());
        dropSelf(MtaBlocks.STRIPPED_AVOCADO_LOG.get());
        dropSelf(MtaBlocks.AVOCADO_WOOD.get());
        dropSelf(MtaBlocks.STRIPPED_AVOCADO_WOOD.get());
        dropSelf(MtaBlocks.AVOCADO_PLANKS.get());
        this.add(MtaBlocks.AVOCADO_LEAVES.get(), block -> createLeavesDrops(block, MtaBlocks.AVOCADO_SAPLING.get(),NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(MtaBlocks.AVOCADO_SAPLING.get());
        dropSelf(MtaBlocks.AVOCADO_STAIRS.get());
        this.add(MtaBlocks.AVOCADO_SLAB.get(), block -> createSlabItemTable(MtaBlocks.AVOCADO_SLAB.get()));
        dropSelf(MtaBlocks.AVOCADO_PRESSURE_PLATE.get());
        dropSelf(MtaBlocks.AVOCADO_BUTTON.get());
        dropSelf(MtaBlocks.AVOCADO_FENCE.get());
        dropSelf(MtaBlocks.AVOCADO_FENCE_GATE.get());
        this.add(MtaBlocks.AVOCADO_DOOR.get(), block -> createDoorTable(MtaBlocks.AVOCADO_DOOR.get()));
        dropSelf(MtaBlocks.AVOCADO_TRAPDOOR.get());
        dropSelf(MtaBlocks.AVOCADO_SIGN.get());
        dropOther(MtaBlocks.AVOCADO_WALL_SIGN.get(), MtaBlocks.AVOCADO_SIGN);
        dropSelf(MtaBlocks.AVOCADO_HANGING_SIGN.get());
        dropOther(MtaBlocks.AVOCADO_HANGING_WALL_SIGN.get(), MtaBlocks.AVOCADO_HANGING_SIGN);
        dropPottedContents(MtaBlocks.POTTED_AVOCADO_SAPLING.get());


        dropSelf(MtaBlocks.BOGGED_OAK_LOG.get());
        dropSelf(MtaBlocks.STRIPPED_BOGGED_OAK_LOG.get());
        dropSelf(MtaBlocks.BOGGED_OAK_WOOD.get());
        dropSelf(MtaBlocks.STRIPPED_BOGGED_OAK_WOOD.get());
        dropSelf(MtaBlocks.BOGGED_OAK_PLANKS.get());
        dropSelf(MtaBlocks.BOGGED_OAK_STAIRS.get());
        this.add(MtaBlocks.BOGGED_OAK_SLAB.get(), block -> createSlabItemTable(MtaBlocks.BOGGED_OAK_SLAB.get()));
        dropSelf(MtaBlocks.BOGGED_OAK_PRESSURE_PLATE.get());
        dropSelf(MtaBlocks.BOGGED_OAK_BUTTON.get());
        dropSelf(MtaBlocks.BOGGED_OAK_FENCE.get());
        dropSelf(MtaBlocks.BOGGED_OAK_FENCE_GATE.get());
        this.add(MtaBlocks.BOGGED_OAK_DOOR.get(), block -> createDoorTable(MtaBlocks.AVOCADO_DOOR.get()));
        dropSelf(MtaBlocks.BOGGED_OAK_TRAPDOOR.get());
        dropSelf(MtaBlocks.BOGGED_OAK_SIGN.get());
        dropOther(MtaBlocks.BOGGED_OAK_WALL_SIGN.get(), MtaBlocks.BOGGED_OAK_SIGN);
        dropSelf(MtaBlocks.BOGGED_OAK_HANGING_SIGN.get());
        dropOther(MtaBlocks.BOGGED_OAK_HANGING_WALL_SIGN.get(), MtaBlocks.BOGGED_OAK_HANGING_SIGN);

        dropSelf(MtaBlocks.IPE_LOG.get());
        dropSelf(MtaBlocks.STRIPPED_IPE_LOG.get());
        dropSelf(MtaBlocks.IPE_WOOD.get());
        dropSelf(MtaBlocks.STRIPPED_IPE_WOOD.get());
        dropSelf(MtaBlocks.IPE_PLANKS.get());
        this.add(MtaBlocks.PINK_IPE_LEAVES.get(), block -> createLeavesDrops(block, MtaBlocks.PINK_IPE_SAPLING.get(),NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(MtaBlocks.PURPLE_IPE_LEAVES.get(), block -> createLeavesDrops(block, MtaBlocks.PURPLE_IPE_SAPLING.get(),NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(MtaBlocks.WHITE_IPE_LEAVES.get(), block -> createLeavesDrops(block, MtaBlocks.WHITE_IPE_SAPLING.get(),NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(MtaBlocks.YELLOW_IPE_LEAVES.get(), block -> createLeavesDrops(block, MtaBlocks.YELLOW_IPE_SAPLING.get(),NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(MtaBlocks.PINK_IPE_SAPLING.get());
        dropSelf(MtaBlocks.PURPLE_IPE_SAPLING.get());
        dropSelf(MtaBlocks.WHITE_IPE_SAPLING.get());
        dropSelf(MtaBlocks.YELLOW_IPE_SAPLING.get());
        dropSelf(MtaBlocks.IPE_STAIRS.get());
        this.add(MtaBlocks.IPE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.ALPINE_SLAB.get()));
        dropSelf(MtaBlocks.IPE_PRESSURE_PLATE.get());
        dropSelf(MtaBlocks.IPE_BUTTON.get());
        dropSelf(MtaBlocks.IPE_FENCE.get());
        dropSelf(MtaBlocks.IPE_FENCE_GATE.get());
        this.add(MtaBlocks.IPE_DOOR.get(), block -> createDoorTable(MtaBlocks.ALPINE_DOOR.get()));
        dropSelf(MtaBlocks.IPE_TRAPDOOR.get());
        dropSelf(MtaBlocks.IPE_SIGN.get());
        dropOther(MtaBlocks.IPE_WALL_SIGN.get(), MtaBlocks.IPE_SIGN);
        dropSelf(MtaBlocks.IPE_HANGING_SIGN.get());
        dropOther(MtaBlocks.IPE_HANGING_WALL_SIGN.get(), MtaBlocks.IPE_HANGING_SIGN);
        dropPottedContents(MtaBlocks.POTTED_PINK_IPE_SAPLING.get());
        dropPottedContents(MtaBlocks.POTTED_PURPLE_IPE_SAPLING.get());
        dropPottedContents(MtaBlocks.POTTED_WHITE_IPE_SAPLING.get());
        dropPottedContents(MtaBlocks.POTTED_YELLOW_IPE_SAPLING.get());

        dropSelf(MtaBlocks.MANGO_LOG.get());
        dropSelf(MtaBlocks.STRIPPED_MANGO_LOG.get());
        dropSelf(MtaBlocks.MANGO_WOOD.get());
        dropSelf(MtaBlocks.STRIPPED_MANGO_WOOD.get());
        dropSelf(MtaBlocks.MANGO_PLANKS.get());
        this.add(MtaBlocks.MANGO_LEAVES.get(), block -> createLeavesDrops(block, MtaBlocks.MANGO_SAPLING.get(),NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(MtaBlocks.MANGO_SAPLING.get());
        dropSelf(MtaBlocks.MANGO_STAIRS.get());
        this.add(MtaBlocks.MANGO_SLAB.get(), block -> createSlabItemTable(MtaBlocks.MANGO_SLAB.get()));
        dropSelf(MtaBlocks.MANGO_PRESSURE_PLATE.get());
        dropSelf(MtaBlocks.MANGO_BUTTON.get());
        dropSelf(MtaBlocks.MANGO_FENCE.get());
        dropSelf(MtaBlocks.MANGO_FENCE_GATE.get());
        this.add(MtaBlocks.MANGO_DOOR.get(), block -> createDoorTable(MtaBlocks.MANGO_DOOR.get()));
        dropSelf(MtaBlocks.MANGO_TRAPDOOR.get());
        dropSelf(MtaBlocks.MANGO_SIGN.get());
        dropOther(MtaBlocks.MANGO_WALL_SIGN.get(), MtaBlocks.MANGO_SIGN);
        dropSelf(MtaBlocks.MANGO_HANGING_SIGN.get());
        dropOther(MtaBlocks.MANGO_HANGING_WALL_SIGN.get(), MtaBlocks.MANGO_HANGING_SIGN);
        dropPottedContents(MtaBlocks.POTTED_MANGO_SAPLING.get());


        dropSelf(MtaBlocks.MAPLE_LOG.get());
        dropSelf(MtaBlocks.STRIPPED_MAPLE_LOG.get());
        dropSelf(MtaBlocks.MAPLE_WOOD.get());
        dropSelf(MtaBlocks.STRIPPED_MAPLE_WOOD.get());
        dropSelf(MtaBlocks.MAPLE_PLANKS.get());
        this.add(MtaBlocks.MAPLE_LEAVES.get(), block -> createLeavesDrops(block, MtaBlocks.MAPLE_SAPLING.get(),NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(MtaBlocks.MAPLE_SAPLING.get());
        dropSelf(MtaBlocks.MAPLE_STAIRS.get());
        this.add(MtaBlocks.MAPLE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.MAPLE_SLAB.get()));
        dropSelf(MtaBlocks.MAPLE_PRESSURE_PLATE.get());
        dropSelf(MtaBlocks.MAPLE_BUTTON.get());
        dropSelf(MtaBlocks.MAPLE_FENCE.get());
        dropSelf(MtaBlocks.MAPLE_FENCE_GATE.get());
        this.add(MtaBlocks.MAPLE_DOOR.get(), block -> createDoorTable(MtaBlocks.MAPLE_DOOR.get()));
        dropSelf(MtaBlocks.MAPLE_TRAPDOOR.get());
        dropSelf(MtaBlocks.MAPLE_SIGN.get());
        dropOther(MtaBlocks.MAPLE_WALL_SIGN.get(), MtaBlocks.MAPLE_SIGN);
        dropSelf(MtaBlocks.MAPLE_HANGING_SIGN.get());
        dropOther(MtaBlocks.MAPLE_HANGING_WALL_SIGN.get(), MtaBlocks.MAPLE_HANGING_SIGN);
        dropPottedContents(MtaBlocks.POTTED_MAPLE_SAPLING.get());


        dropSelf(MtaBlocks.PALM_LOG.get());
        dropSelf(MtaBlocks.PALM_WOOD.get());
        dropSelf(MtaBlocks.STRIPPED_PALM_LOG.get());
        dropSelf(MtaBlocks.STRIPPED_PALM_WOOD.get());
        dropSelf(MtaBlocks.PALM_PLANKS.get());
        this.add(MtaBlocks.PALM_LEAVES.get(), block -> createPalmLeavesDrops(block, MtaItems.COCONUT.get(), PALM_LEAVES_SAPLING_CHANCES));
        dropSelf(MtaBlocks.PALM_SAPLING.get());
        dropSelf(MtaBlocks.PALM_STAIRS.get());
        this.add(MtaBlocks.PALM_SLAB.get(), block -> createSlabItemTable(MtaBlocks.PALM_SLAB.get()));
        dropSelf(MtaBlocks.PALM_PRESSURE_PLATE.get());
        dropSelf(MtaBlocks.PALM_BUTTON.get());
        dropSelf(MtaBlocks.PALM_FENCE.get());
        dropSelf(MtaBlocks.PALM_FENCE_GATE.get());
        this.add(MtaBlocks.PALM_DOOR.get(), block -> createDoorTable(MtaBlocks.PALM_DOOR.get()));
        dropSelf(MtaBlocks.PALM_TRAPDOOR.get());
        dropSelf(MtaBlocks.PALM_SIGN.get());
        dropOther(MtaBlocks.PALM_WALL_SIGN.get(), MtaBlocks.PALM_SIGN);
        dropSelf(MtaBlocks.PALM_HANGING_SIGN.get());
        dropOther(MtaBlocks.PALM_HANGING_WALL_SIGN.get(), MtaBlocks.PALM_HANGING_SIGN);
        dropPottedContents(MtaBlocks.POTTED_PALM_SAPLING.get());


        dropSelf(MtaBlocks.SEALOG.get());
        dropSelf(MtaBlocks.SEAWOOD.get());
        dropSelf(MtaBlocks.SEAWOOD_PLANKS.get());
        this.add(MtaBlocks.SEAWOOD_LEAVES.get(), block -> createLeavesDrops(block, MtaBlocks.SEAWOOD_SAPLING.get(),NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(MtaBlocks.SEAWOOD_SAPLING.get());
        dropSelf(MtaBlocks.SEAWOOD_STAIRS.get());
        this.add(MtaBlocks.SEAWOOD_SLAB.get(), block -> createSlabItemTable(MtaBlocks.SEAWOOD_SLAB.get()));
        dropSelf(MtaBlocks.SEAWOOD_PRESSURE_PLATE.get());
        dropSelf(MtaBlocks.SEAWOOD_BUTTON.get());
        dropSelf(MtaBlocks.SEAWOOD_FENCE.get());
        dropSelf(MtaBlocks.SEAWOOD_FENCE_GATE.get());
        this.add(MtaBlocks.SEAWOOD_DOOR.get(), block -> createDoorTable(MtaBlocks.SEAWOOD_DOOR.get()));
        dropSelf(MtaBlocks.SEAWOOD_TRAPDOOR.get());
        dropSelf(MtaBlocks.SEAWOOD_SIGN.get());
        dropOther(MtaBlocks.SEAWOOD_WALL_SIGN.get(), MtaBlocks.SEAWOOD_SIGN);
        dropSelf(MtaBlocks.SEAWOOD_HANGING_SIGN.get());
        dropOther(MtaBlocks.SEAWOOD_HANGING_WALL_SIGN.get(), MtaBlocks.SEAWOOD_HANGING_SIGN);
        dropPottedContents(MtaBlocks.POTTED_SEAWOOD_SAPLING.get());


        dropSelf(MtaBlocks.SPRINKLER.get());
        dropSelf(MtaBlocks.MOSSY_ANDESITE.get());
        this.add(MtaBlocks.STONE_GEYSER.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
        this.add(MtaBlocks.TERRACOTTA_GEYSER.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.TERRACOTTA));
        this.add(MtaBlocks.NETHERRACK_GEYSER.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
        this.add(MtaBlocks.BASALT_GEYSER.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.BASALT));
        this.add(MtaBlocks.NETHER_IRON_ORE.get(), block -> this.createOreDrop(block, Items.RAW_IRON));
        this.add(MtaBlocks.NETHER_DIAMOND_ORE.get(), block -> this.createOreDrop(block, Items.DIAMOND));
        this.add(MtaBlocks.END_EMERALD_ORE.get(), block -> this.createOreDrop(block, Items.EMERALD_BLOCK));
        this.add(MtaBlocks.END_LAPIS_ORE.get(), this::createLapisOreDrops);
        this.add(MtaBlocks.CLEAR_QUARTZ_ORE.get(), block -> this.createOreDrop(block, MtaItems.CLEAR_QUARTZ.get()));
        this.add(MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_ORE.get(), block -> this.createOreDrop(block, MtaItems.CLEAR_QUARTZ.get()));
        this.add(MtaBlocks.CLEAR_QUARTZ_CLUSTER.get(), block -> this.createOreDrop(block, MtaItems.CLEAR_QUARTZ.get()));
        this.add(MtaBlocks.CLEAR_QUARTZ_GROWTH.get(), block -> this.createSingleItemTable(Blocks.STONE));
        this.add(MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_GROWTH.get(), block -> this.createSingleItemTable(Blocks.DEEPSLATE));
        this.add(MtaBlocks.CALCITE_CLEAR_QUARTZ_GROWTH.get(), block -> this.createSingleItemTable(Blocks.CALCITE));
        dropSelf(MtaBlocks.QUARTZ_LAMP.get());
        dropSelf(MtaBlocks.COBBLED_DIRT.get());
        dropSelf(MtaBlocks.POLAR_SAND.get());
        dropSelf(MtaBlocks.STONE_TILES.get());
        this.add(MtaBlocks.STONE_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.STONE_TILES_SLAB.get()));
        dropSelf(MtaBlocks.STONE_TILES_STAIRS.get());
        dropSelf(MtaBlocks.STONE_TILES_WALL.get());
        dropSelf(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES.get());
        this.add(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_SLAB.get()));
        dropSelf(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_STAIRS.get());
        dropSelf(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_WALL.get());
        dropSelf(MtaBlocks.DIRTY_STONE_TILES.get());
        this.add(MtaBlocks.DIRTY_STONE_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.DIRTY_STONE_TILES_SLAB.get()));
        dropSelf(MtaBlocks.DIRTY_STONE_TILES_STAIRS.get());
        dropSelf(MtaBlocks.DIRTY_STONE_TILES_WALL.get());
        dropSelf(MtaBlocks.VERY_DIRTY_STONE_TILES.get());
        this.add(MtaBlocks.VERY_DIRTY_STONE_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.VERY_DIRTY_STONE_TILES_SLAB.get()));
        dropSelf(MtaBlocks.VERY_DIRTY_STONE_TILES_STAIRS.get());
        dropSelf(MtaBlocks.VERY_DIRTY_STONE_TILES_WALL.get());
        this.add(MtaBlocks.NETHERITIC_CRYSTAL.get(), block -> this.createOreDrop(block, MtaItems.NETHERITE_FRACTURE.get()));
        this.add(MtaBlocks.SAND_PATH.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.SAND));
        this.add(MtaBlocks.GRASSY_DIRT.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.DIRT));
        dropSelf(MtaBlocks.PERMAFROST_DIRT.get());
        this.add(MtaBlocks.PERMAFROST_GRASS.get(), block -> this.createSingleItemTableWithSilkTouch(block, MtaBlocks.PERMAFROST_DIRT.get()));
        this.add(MtaBlocks.PERMAFROST_STONE.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
        this.add(MtaBlocks.TUNDRA_GRASS.get(), block -> this.createSingleItemTableWithSilkTouch(block, MtaBlocks.PERMAFROST_DIRT.get()));
        this.add(MtaBlocks.COARSE_DIRT_PATH.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.DIRT));
        this.add(MtaBlocks.SHALLOW_GRASS.get(), this.createShearsOnlyDrop(MtaBlocks.SHALLOW_GRASS));
        this.add(MtaBlocks.SAND_GRASS.get(), this.createShearsOnlyDrop(MtaBlocks.SHALLOW_GRASS));
        this.add(MtaBlocks.BEACHGRASS.get(), this.createShearsOnlyDrop(MtaBlocks.SHALLOW_GRASS));

        dropSelf(MtaBlocks.TERRACOTTA_TILES.get());
        this.add(MtaBlocks.TERRACOTTA_SLAB.get(), block -> createSlabItemTable(MtaBlocks.TERRACOTTA_SLAB.get()));
        this.add(MtaBlocks.TERRACOTTA_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.TERRACOTTA_TILES_SLAB.get()));
        dropSelf(MtaBlocks.TERRACOTTA_STAIRS.get());
        dropSelf(MtaBlocks.TERRACOTTA_TILES_STAIRS.get());
        dropSelf(MtaBlocks.TERRACOTTA_WALL.get());
        dropSelf(MtaBlocks.TERRACOTTA_TILES_WALL.get());

        dropSelf(MtaBlocks.WHITE_TERRACOTTA_TILES.get());
        this.add(MtaBlocks.WHITE_TERRACOTTA_SLAB.get(), block -> createSlabItemTable(MtaBlocks.WHITE_TERRACOTTA_SLAB.get()));
        this.add(MtaBlocks.WHITE_TERRACOTTA_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.WHITE_TERRACOTTA_TILES_SLAB.get()));
        dropSelf(MtaBlocks.WHITE_TERRACOTTA_STAIRS.get());
        dropSelf(MtaBlocks.WHITE_TERRACOTTA_TILES_STAIRS.get());
        dropSelf(MtaBlocks.WHITE_TERRACOTTA_WALL.get());
        dropSelf(MtaBlocks.WHITE_TERRACOTTA_TILES_WALL.get());

        dropSelf(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES.get());
        this.add(MtaBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get(), block -> createSlabItemTable(MtaBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get()));
        this.add(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_SLAB.get()));
        dropSelf(MtaBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get());
        dropSelf(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_STAIRS.get());
        dropSelf(MtaBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get());
        dropSelf(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_WALL.get());

        dropSelf(MtaBlocks.GRAY_TERRACOTTA_TILES.get());
        this.add(MtaBlocks.GRAY_TERRACOTTA_SLAB.get(), block -> createSlabItemTable(MtaBlocks.GRAY_TERRACOTTA_SLAB.get()));
        this.add(MtaBlocks.GRAY_TERRACOTTA_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.GRAY_TERRACOTTA_TILES_SLAB.get()));
        dropSelf(MtaBlocks.GRAY_TERRACOTTA_STAIRS.get());
        dropSelf(MtaBlocks.GRAY_TERRACOTTA_TILES_STAIRS.get());
        dropSelf(MtaBlocks.GRAY_TERRACOTTA_WALL.get());
        dropSelf(MtaBlocks.GRAY_TERRACOTTA_TILES_WALL.get());

        dropSelf(MtaBlocks.BLACK_TERRACOTTA_TILES.get());
        this.add(MtaBlocks.BLACK_TERRACOTTA_SLAB.get(), block -> createSlabItemTable(MtaBlocks.BLACK_TERRACOTTA_SLAB.get()));
        this.add(MtaBlocks.BLACK_TERRACOTTA_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.BLACK_TERRACOTTA_TILES_SLAB.get()));
        dropSelf(MtaBlocks.BLACK_TERRACOTTA_STAIRS.get());
        dropSelf(MtaBlocks.BLACK_TERRACOTTA_TILES_STAIRS.get());
        dropSelf(MtaBlocks.BLACK_TERRACOTTA_WALL.get());
        dropSelf(MtaBlocks.BLACK_TERRACOTTA_TILES_WALL.get());

        dropSelf(MtaBlocks.BROWN_TERRACOTTA_TILES.get());
        this.add(MtaBlocks.BROWN_TERRACOTTA_SLAB.get(), block -> createSlabItemTable(MtaBlocks.BROWN_TERRACOTTA_SLAB.get()));
        this.add(MtaBlocks.BROWN_TERRACOTTA_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.BROWN_TERRACOTTA_TILES_SLAB.get()));
        dropSelf(MtaBlocks.BROWN_TERRACOTTA_STAIRS.get());
        dropSelf(MtaBlocks.BROWN_TERRACOTTA_TILES_STAIRS.get());
        dropSelf(MtaBlocks.BROWN_TERRACOTTA_WALL.get());
        dropSelf(MtaBlocks.BROWN_TERRACOTTA_TILES_WALL.get());

        dropSelf(MtaBlocks.RED_TERRACOTTA_TILES.get());
        this.add(MtaBlocks.RED_TERRACOTTA_SLAB.get(), block -> createSlabItemTable(MtaBlocks.RED_TERRACOTTA_SLAB.get()));
        this.add(MtaBlocks.RED_TERRACOTTA_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.RED_TERRACOTTA_TILES_SLAB.get()));
        dropSelf(MtaBlocks.RED_TERRACOTTA_STAIRS.get());
        dropSelf(MtaBlocks.RED_TERRACOTTA_TILES_STAIRS.get());
        dropSelf(MtaBlocks.RED_TERRACOTTA_WALL.get());
        dropSelf(MtaBlocks.RED_TERRACOTTA_TILES_WALL.get());

        dropSelf(MtaBlocks.ORANGE_TERRACOTTA_TILES.get());
        this.add(MtaBlocks.ORANGE_TERRACOTTA_SLAB.get(), block -> createSlabItemTable(MtaBlocks.ORANGE_TERRACOTTA_SLAB.get()));
        this.add(MtaBlocks.ORANGE_TERRACOTTA_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.ORANGE_TERRACOTTA_TILES_SLAB.get()));
        dropSelf(MtaBlocks.ORANGE_TERRACOTTA_STAIRS.get());
        dropSelf(MtaBlocks.ORANGE_TERRACOTTA_TILES_STAIRS.get());
        dropSelf(MtaBlocks.ORANGE_TERRACOTTA_WALL.get());
        dropSelf(MtaBlocks.ORANGE_TERRACOTTA_TILES_WALL.get());

        dropSelf(MtaBlocks.YELLOW_TERRACOTTA_TILES.get());
        this.add(MtaBlocks.YELLOW_TERRACOTTA_SLAB.get(), block -> createSlabItemTable(MtaBlocks.YELLOW_TERRACOTTA_SLAB.get()));
        this.add(MtaBlocks.YELLOW_TERRACOTTA_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.YELLOW_TERRACOTTA_TILES_SLAB.get()));
        dropSelf(MtaBlocks.YELLOW_TERRACOTTA_STAIRS.get());
        dropSelf(MtaBlocks.YELLOW_TERRACOTTA_TILES_STAIRS.get());
        dropSelf(MtaBlocks.YELLOW_TERRACOTTA_WALL.get());
        dropSelf(MtaBlocks.YELLOW_TERRACOTTA_TILES_WALL.get());

        dropSelf(MtaBlocks.LIME_TERRACOTTA_TILES.get());
        this.add(MtaBlocks.LIME_TERRACOTTA_SLAB.get(), block -> createSlabItemTable(MtaBlocks.LIME_TERRACOTTA_SLAB.get()));
        this.add(MtaBlocks.LIME_TERRACOTTA_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.LIME_TERRACOTTA_TILES_SLAB.get()));
        dropSelf(MtaBlocks.LIME_TERRACOTTA_STAIRS.get());
        dropSelf(MtaBlocks.LIME_TERRACOTTA_TILES_STAIRS.get());
        dropSelf(MtaBlocks.LIME_TERRACOTTA_WALL.get());
        dropSelf(MtaBlocks.LIME_TERRACOTTA_TILES_WALL.get());

        dropSelf(MtaBlocks.GREEN_TERRACOTTA_TILES.get());
        this.add(MtaBlocks.GREEN_TERRACOTTA_SLAB.get(), block -> createSlabItemTable(MtaBlocks.GREEN_TERRACOTTA_SLAB.get()));
        this.add(MtaBlocks.GREEN_TERRACOTTA_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.GREEN_TERRACOTTA_TILES_SLAB.get()));
        dropSelf(MtaBlocks.GREEN_TERRACOTTA_STAIRS.get());
        dropSelf(MtaBlocks.GREEN_TERRACOTTA_TILES_STAIRS.get());
        dropSelf(MtaBlocks.GREEN_TERRACOTTA_WALL.get());
        dropSelf(MtaBlocks.GREEN_TERRACOTTA_TILES_WALL.get());

        dropSelf(MtaBlocks.CYAN_TERRACOTTA_TILES.get());
        this.add(MtaBlocks.CYAN_TERRACOTTA_SLAB.get(), block -> createSlabItemTable(MtaBlocks.CYAN_TERRACOTTA_SLAB.get()));
        this.add(MtaBlocks.CYAN_TERRACOTTA_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.CYAN_TERRACOTTA_TILES_SLAB.get()));
        dropSelf(MtaBlocks.CYAN_TERRACOTTA_STAIRS.get());
        dropSelf(MtaBlocks.CYAN_TERRACOTTA_TILES_STAIRS.get());
        dropSelf(MtaBlocks.CYAN_TERRACOTTA_WALL.get());
        dropSelf(MtaBlocks.CYAN_TERRACOTTA_TILES_WALL.get());

        dropSelf(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES.get());
        this.add(MtaBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get(), block -> createSlabItemTable(MtaBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get()));
        this.add(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_SLAB.get()));
        dropSelf(MtaBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get());
        dropSelf(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_STAIRS.get());
        dropSelf(MtaBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get());
        dropSelf(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_WALL.get());

        dropSelf(MtaBlocks.BLUE_TERRACOTTA_TILES.get());
        this.add(MtaBlocks.BLUE_TERRACOTTA_SLAB.get(), block -> createSlabItemTable(MtaBlocks.BLUE_TERRACOTTA_SLAB.get()));
        this.add(MtaBlocks.BLUE_TERRACOTTA_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.BLUE_TERRACOTTA_TILES_SLAB.get()));
        dropSelf(MtaBlocks.BLUE_TERRACOTTA_STAIRS.get());
        dropSelf(MtaBlocks.BLUE_TERRACOTTA_TILES_STAIRS.get());
        dropSelf(MtaBlocks.BLUE_TERRACOTTA_WALL.get());
        dropSelf(MtaBlocks.BLUE_TERRACOTTA_TILES_WALL.get());

        dropSelf(MtaBlocks.PURPLE_TERRACOTTA_TILES.get());
        this.add(MtaBlocks.PURPLE_TERRACOTTA_SLAB.get(), block -> createSlabItemTable(MtaBlocks.PURPLE_TERRACOTTA_SLAB.get()));
        this.add(MtaBlocks.PURPLE_TERRACOTTA_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.PURPLE_TERRACOTTA_TILES_SLAB.get()));
        dropSelf(MtaBlocks.PURPLE_TERRACOTTA_STAIRS.get());
        dropSelf(MtaBlocks.PURPLE_TERRACOTTA_TILES_STAIRS.get());
        dropSelf(MtaBlocks.PURPLE_TERRACOTTA_WALL.get());
        dropSelf(MtaBlocks.PURPLE_TERRACOTTA_TILES_WALL.get());

        dropSelf(MtaBlocks.MAGENTA_TERRACOTTA_TILES.get());
        this.add(MtaBlocks.MAGENTA_TERRACOTTA_SLAB.get(), block -> createSlabItemTable(MtaBlocks.MAGENTA_TERRACOTTA_SLAB.get()));
        this.add(MtaBlocks.MAGENTA_TERRACOTTA_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.MAGENTA_TERRACOTTA_TILES_SLAB.get()));
        dropSelf(MtaBlocks.MAGENTA_TERRACOTTA_STAIRS.get());
        dropSelf(MtaBlocks.MAGENTA_TERRACOTTA_TILES_STAIRS.get());
        dropSelf(MtaBlocks.MAGENTA_TERRACOTTA_WALL.get());
        dropSelf(MtaBlocks.MAGENTA_TERRACOTTA_TILES_WALL.get());

        dropSelf(MtaBlocks.PINK_TERRACOTTA_TILES.get());
        this.add(MtaBlocks.PINK_TERRACOTTA_SLAB.get(), block -> createSlabItemTable(MtaBlocks.PINK_TERRACOTTA_SLAB.get()));
        this.add(MtaBlocks.PINK_TERRACOTTA_TILES_SLAB.get(), block -> createSlabItemTable(MtaBlocks.PINK_TERRACOTTA_TILES_SLAB.get()));
        dropSelf(MtaBlocks.PINK_TERRACOTTA_STAIRS.get());
        dropSelf(MtaBlocks.PINK_TERRACOTTA_TILES_STAIRS.get());
        dropSelf(MtaBlocks.PINK_TERRACOTTA_WALL.get());
        dropSelf(MtaBlocks.PINK_TERRACOTTA_TILES_WALL.get());

        this.add(MtaBlocks.WHITE_CONCRETE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.WHITE_CONCRETE_SLAB.get()));
        dropSelf(MtaBlocks.WHITE_CONCRETE_STAIRS.get());
        dropSelf(MtaBlocks.WHITE_CONCRETE_WALL.get());

        this.add(MtaBlocks.LIGHT_GRAY_CONCRETE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.LIGHT_GRAY_CONCRETE_SLAB.get()));
        dropSelf(MtaBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get());
        dropSelf(MtaBlocks.LIGHT_GRAY_CONCRETE_WALL.get());

        this.add(MtaBlocks.GRAY_CONCRETE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.GRAY_CONCRETE_SLAB.get()));
        dropSelf(MtaBlocks.GRAY_CONCRETE_STAIRS.get());
        dropSelf(MtaBlocks.GRAY_CONCRETE_WALL.get());

        this.add(MtaBlocks.BLACK_CONCRETE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.BLACK_CONCRETE_SLAB.get()));
        dropSelf(MtaBlocks.BLACK_CONCRETE_STAIRS.get());
        dropSelf(MtaBlocks.BLACK_CONCRETE_WALL.get());

        this.add(MtaBlocks.BROWN_CONCRETE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.BROWN_CONCRETE_SLAB.get()));
        dropSelf(MtaBlocks.BROWN_CONCRETE_STAIRS.get());
        dropSelf(MtaBlocks.BROWN_CONCRETE_WALL.get());

        this.add(MtaBlocks.RED_CONCRETE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.RED_CONCRETE_SLAB.get()));
        dropSelf(MtaBlocks.RED_CONCRETE_STAIRS.get());
        dropSelf(MtaBlocks.RED_CONCRETE_WALL.get());

        this.add(MtaBlocks.ORANGE_CONCRETE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.ORANGE_CONCRETE_SLAB.get()));
        dropSelf(MtaBlocks.ORANGE_CONCRETE_STAIRS.get());
        dropSelf(MtaBlocks.ORANGE_CONCRETE_WALL.get());

        this.add(MtaBlocks.YELLOW_CONCRETE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.YELLOW_CONCRETE_SLAB.get()));
        dropSelf(MtaBlocks.YELLOW_CONCRETE_STAIRS.get());
        dropSelf(MtaBlocks.YELLOW_CONCRETE_WALL.get());

        this.add(MtaBlocks.LIME_CONCRETE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.LIME_CONCRETE_SLAB.get()));
        dropSelf(MtaBlocks.LIME_CONCRETE_STAIRS.get());
        dropSelf(MtaBlocks.LIME_CONCRETE_WALL.get());

        this.add(MtaBlocks.GREEN_CONCRETE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.GREEN_CONCRETE_SLAB.get()));
        dropSelf(MtaBlocks.GREEN_CONCRETE_STAIRS.get());
        dropSelf(MtaBlocks.GREEN_CONCRETE_WALL.get());

        this.add(MtaBlocks.CYAN_CONCRETE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.CYAN_CONCRETE_SLAB.get()));
        dropSelf(MtaBlocks.CYAN_CONCRETE_STAIRS.get());
        dropSelf(MtaBlocks.CYAN_CONCRETE_WALL.get());

        this.add(MtaBlocks.LIGHT_BLUE_CONCRETE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.LIGHT_BLUE_CONCRETE_SLAB.get()));
        dropSelf(MtaBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get());
        dropSelf(MtaBlocks.LIGHT_BLUE_CONCRETE_WALL.get());

        this.add(MtaBlocks.BLUE_CONCRETE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.BLUE_CONCRETE_SLAB.get()));
        dropSelf(MtaBlocks.BLUE_CONCRETE_STAIRS.get());
        dropSelf(MtaBlocks.BLUE_CONCRETE_WALL.get());

        this.add(MtaBlocks.PURPLE_CONCRETE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.PURPLE_CONCRETE_SLAB.get()));
        dropSelf(MtaBlocks.PURPLE_CONCRETE_STAIRS.get());
        dropSelf(MtaBlocks.PURPLE_CONCRETE_WALL.get());

        this.add(MtaBlocks.MAGENTA_CONCRETE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.MAGENTA_CONCRETE_SLAB.get()));
        dropSelf(MtaBlocks.MAGENTA_CONCRETE_STAIRS.get());
        dropSelf(MtaBlocks.MAGENTA_CONCRETE_WALL.get());

        this.add(MtaBlocks.PINK_CONCRETE_SLAB.get(), block -> createSlabItemTable(MtaBlocks.PINK_CONCRETE_SLAB.get()));
        dropSelf(MtaBlocks.PINK_CONCRETE_STAIRS.get());
        dropSelf(MtaBlocks.PINK_CONCRETE_WALL.get());


        this.add(MtaBlocks.AGATE_ORE.get(), block -> this.createOreDrop(block, MtaItems.AGATE.get()));
        this.add(MtaBlocks.DEEPSLATE_AGATE_ORE.get(), block -> this.createOreDrop(block, MtaItems.AGATE.get()));
        this.add(MtaBlocks.ALEXANDRITE_ORE.get(), block -> this.createOreDrop(block, MtaItems.ALEXANDRITE.get()));
        this.add(MtaBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(), block -> this.createOreDrop(block, MtaItems.ALEXANDRITE.get()));
        this.add(MtaBlocks.AQUAMARINE_ORE.get(), block -> this.createOreDrop(block, MtaItems.AQUAMARINE.get()));
        this.add(MtaBlocks.DEEPSLATE_AQUAMARINE_ORE.get(), block -> this.createOreDrop(block, MtaItems.AQUAMARINE.get()));
        this.add(MtaBlocks.BLOODSTONE_ORE.get(), block -> this.createOreDrop(block, MtaItems.BLOODSTONE.get()));
        this.add(MtaBlocks.DEEPSLATE_BLOODSTONE_ORE.get(), block -> this.createOreDrop(block, MtaItems.BLOODSTONE.get()));
        this.add(MtaBlocks.CELESTITE_ORE.get(), block -> this.createOreDrop(block, MtaItems.CELESTITE.get()));
        this.add(MtaBlocks.DEEPSLATE_CELESTITE_ORE.get(), block -> this.createOreDrop(block, MtaItems.CELESTITE.get()));
        this.add(MtaBlocks.CRYOLITE_ORE.get(), block -> this.createOreDrop(block, MtaItems.CRYOLITE.get()));
        this.add(MtaBlocks.GARNET_ORE.get(), block -> this.createOreDrop(block, MtaItems.GARNET.get()));
        this.add(MtaBlocks.DEEPSLATE_GARNET_ORE.get(), block -> this.createOreDrop(block, MtaItems.GARNET.get()));
        this.add(MtaBlocks.MOONSTONE_ORE.get(), block -> this.createOreDrop(block, MtaItems.MOONSTONE.get()));
        this.add(MtaBlocks.DEEPSLATE_MOONSTONE_ORE.get(), block -> this.createOreDrop(block, MtaItems.MOONSTONE.get()));


        LootItemCondition.Builder onionCrop = LootItemBlockStatePropertyCondition.hasBlockStateProperties(MtaBlocks.ONION_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OnionCropBlock.AGE, 7));
        this.add(MtaBlocks.ONION_CROP.get(), this.createCropDrops(MtaBlocks.ONION_CROP.get(),
                MtaItems.ONION.get(), MtaItems.ONION.asItem(), onionCrop));

        LootItemCondition.Builder tomatoCrop = LootItemBlockStatePropertyCondition.hasBlockStateProperties(MtaBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OnionCropBlock.AGE, 7));
        this.add(MtaBlocks.TOMATO_CROP.get(), this.createCropDrops(MtaBlocks.ONION_CROP.get(),
                MtaItems.TOMATO.get(), MtaItems.TOMATO_SEEDS.asItem(), tomatoCrop));

        LootItemCondition.Builder bellPepperCrop = LootItemBlockStatePropertyCondition.hasBlockStateProperties(MtaBlocks.BELL_PEPPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OnionCropBlock.AGE, 7));
        this.add(MtaBlocks.BELL_PEPPER_CROP.get(), this.createCropDrops(MtaBlocks.BELL_PEPPER_CROP.get(),
                MtaItems.BELL_PEPPER.get(), MtaItems.BELL_PEPPER_SEEDS.asItem(), bellPepperCrop));

        LootItemCondition.Builder chillPepperCrop = LootItemBlockStatePropertyCondition.hasBlockStateProperties(MtaBlocks.CHILI_PEPPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OnionCropBlock.AGE, 7));
        this.add(MtaBlocks.CHILI_PEPPER_CROP.get(), this.createCropDrops(MtaBlocks.CHILI_PEPPER_CROP.get(),
                MtaItems.CHILI_PEPPER.get(), MtaItems.CHILI_PEPPER_SEEDS.asItem(), chillPepperCrop));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> list = knownBlocks;
        list.remove(excludedBlocks);
        return list;
    }

    protected LootTable.Builder createPalmLeavesDrops(Block pLeavesBlock, Item pCoconut, float... pChances) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchOrShearsDispatchTable(
                        pLeavesBlock,
                        ((LootPoolSingletonContainer.Builder)this.applyExplosionCondition(pLeavesBlock, LootItem.lootTableItem(pCoconut)))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), pChances))
                );
    }

    protected LootTable.Builder createLeavesDrops(Block leavesBlock, Item saplingBlock, float... chances) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchOrShearsDispatchTable(
                        leavesBlock,
                        ((LootPoolSingletonContainer.Builder)this.applyExplosionCondition(leavesBlock, LootItem.lootTableItem(saplingBlock)))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), chances))
                )
                .withPool(
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .when(this.doesNotHaveShearsOrSilkTouch())
                                .add(
                                        ((LootPoolSingletonContainer.Builder)this.applyExplosionDecay(
                                                leavesBlock, LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                        ))
                                                .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), NORMAL_LEAVES_STICK_CHANCES))
                                )
                );
    }

    private LootItemCondition.Builder hasShearsOrSilkTouch() {
        return this.hasShears().or(this.hasSilkTouch());
    }

    private LootItemCondition.Builder doesNotHaveShearsOrSilkTouch() {
        return this.hasShearsOrSilkTouch().invert();
    }

}
