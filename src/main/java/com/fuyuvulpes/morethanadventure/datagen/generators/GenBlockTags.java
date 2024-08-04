package com.fuyuvulpes.morethanadventure.datagen.generators;

import com.fuyuvulpes.morethanadventure.core.registry.MtaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class GenBlockTags extends BlockTagsProvider {
    public GenBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(MtaTags.Blocks.NEEDS_COPPER_TOOL).add(Blocks.GOLD_BLOCK);
        this.tag(MtaTags.Blocks.NEEDS_COPPER_TOOL).add(Blocks.GOLD_ORE);
        this.tag(MtaTags.Blocks.NEEDS_COPPER_TOOL).add(Blocks.RAW_GOLD_BLOCK);
        this.tag(MtaTags.Blocks.NEEDS_COPPER_TOOL).add(Blocks.DEEPSLATE_GOLD_ORE);
        this.tag(MtaTags.Blocks.NEEDS_COPPER_TOOL).add(Blocks.REDSTONE_ORE);
        this.tag(MtaTags.Blocks.NEEDS_COPPER_TOOL).add(Blocks.DEEPSLATE_REDSTONE_ORE);

        this.tag(MtaTags.Blocks.ORE_CLUSTER_REPLACEABLE)
                .addTag(BlockTags.STONE_ORE_REPLACEABLES)
                .addTag(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
                .addTag(BlockTags.BASE_STONE_OVERWORLD)
        ;


        this.tag(MtaTags.Blocks.NETHER_CLUSTER_CLUSTER_REPLACEABLE)
                .addTag(Tags.Blocks.NETHERRACKS)
                .addTag(BlockTags.BASE_STONE_NETHER)
                .addTag(BlockTags.NETHER_CARVER_REPLACEABLES)
        ;

    }
}
