package com.fuyuvulpes.morethanadventure.datagen.generators.loot;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;

import java.util.Set;

public class LootBlocks extends BlockLootSubProvider {
    //private List<Block> knownBlocks = YoaBlocks.BLOCKS.getEntries().stream().map(Holder::value).collect(Collectors.toList());
    public LootBlocks(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(),provider);
    }

    @Override
    protected void generate() {

    }
}
