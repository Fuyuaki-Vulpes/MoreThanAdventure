package com.fuyuaki.morethanadventure.datagen.generators.loot;

import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LootBlocks extends BlockLootSubProvider {
    List<Block> excludedBlocks = List.of();
    List<Block> knownBlocks = MtaBlocks.BLOCKS.getEntries().stream().map(Holder::value).collect(Collectors.toList());

    public LootBlocks(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(),provider);
    }

    @Override
    protected void generate() {
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
}
