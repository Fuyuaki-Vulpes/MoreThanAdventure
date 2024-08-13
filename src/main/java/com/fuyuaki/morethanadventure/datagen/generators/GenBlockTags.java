package com.fuyuaki.morethanadventure.datagen.generators;

import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class GenBlockTags extends BlockTagsProvider {
    public GenBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(MtaTags.Blocks.PALM_LOGS).add(
          MtaBlocks.PALM_LOG.get(),
          MtaBlocks.PALM_WOOD.get()
        );

        this.tag(BlockTags.LOGS_THAT_BURN).add(
                MtaBlocks.PALM_LOG.get(),
                MtaBlocks.STRIPPED_PALM_LOG.get(),
                MtaBlocks.PALM_WOOD.get(),
                MtaBlocks.STRIPPED_PALM_WOOD.get()
        );

        this.tag(BlockTags.PLANKS).add(
          MtaBlocks.PALM_PLANKS.get()
        );

        this.tag(MtaTags.Blocks.NEEDS_COPPER_TOOL).add(
                Blocks.GOLD_BLOCK,
                Blocks.GOLD_ORE,
                Blocks.RAW_GOLD_BLOCK,
                Blocks.DEEPSLATE_GOLD_ORE,
                Blocks.REDSTONE_ORE,
                Blocks.DEEPSLATE_REDSTONE_ORE
        );

        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                MtaBlocks.NETHER_DIAMOND_ORE.get(),
                MtaBlocks.END_EMERALD_ORE.get(),
                MtaBlocks.END_LAPIS_ORE.get()
                );
        this.tag(BlockTags.NEEDS_STONE_TOOL).add(
                MtaBlocks.NETHER_IRON_ORE.get(),
                MtaBlocks.CLEAR_QUARTZ_ORE.get(),
                MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_ORE.get()
                );

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(
                MtaBlocks.NETHER_IRON_ORE.get(),
                MtaBlocks.NETHER_DIAMOND_ORE.get(),
                MtaBlocks.END_EMERALD_ORE.get(),
                MtaBlocks.END_LAPIS_ORE.get(),
                MtaBlocks.CLEAR_QUARTZ_ORE.get(),
                MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_ORE.get(),
                MtaBlocks.CLEAR_QUARTZ_GROWTH.get(),
                MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_GROWTH.get(),
                MtaBlocks.CALCITE_CLEAR_QUARTZ_GROWTH.get(),
                MtaBlocks.QUARTZ_LAMP.get()
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

    }
}
