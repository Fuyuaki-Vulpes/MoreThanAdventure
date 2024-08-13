package com.fuyuaki.morethanadventure.datagen.generators.loot;

import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.fuyuaki.morethanadventure.core.registry.MtaItems;
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
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LootBlocks extends BlockLootSubProvider {
    List<Block> excludedBlocks = List.of();
    List<Block> knownBlocks = MtaBlocks.BLOCKS.getEntries().stream().map(Holder::value).collect(Collectors.toList());
    protected static final float[] PALM_LEAVES_SAPLING_CHANCES = new float[]{0.33F, 0.50F, 0.83F, 1F};


    public LootBlocks(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(),provider);
    }

    @Override
    protected void generate() {
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
