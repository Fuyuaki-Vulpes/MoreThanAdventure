package com.fuyuaki.morethanadventure.datagen.generators.loot;

import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.fuyuaki.morethanadventure.core.registry.MtaItems;
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


    public LootBlocks(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(),provider);
    }

    @Override
    protected void generate() {
        this.add(MtaBlocks.SCATTERED_LEAVES.get(), this.createPetalsDrops(MtaBlocks.SCATTERED_LEAVES.get()));
        this.add(MtaBlocks.CATTAIL.get(), block ->   this.createSinglePropConditionTable(block, DoublePlantBlock.HALF, DoubleBlockHalf.LOWER));
        dropSelf(MtaBlocks.CORPSE_LILY.get());
        dropSelf(MtaBlocks.PITCHER_PLANT.get());
        this.add(MtaBlocks.POTTED_PITCHER_PLANT.get(), createPotFlowerItemTable(MtaBlocks.PITCHER_PLANT));
        dropSelf(MtaBlocks.VENUS_FLYTRAP.get());
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

        dropSelf(MtaBlocks.PALM_TRAPDOOR.get());
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
        this.add(MtaBlocks.SWEET_BERRY_LEAVES.get(), block -> createLeavesDrops(block, Blocks.SPRUCE_SAPLING, 0.1F));
        this.add(MtaBlocks.SHALLOW_GRASS.get(), BlockLootSubProvider::createShearsOnlyDrop);

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

}
