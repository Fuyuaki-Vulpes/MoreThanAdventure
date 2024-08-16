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

        this.tag(BlockTags.LEAVES).add(
          MtaBlocks.PALM_LEAVES.get()
        );
        this.tag(BlockTags.WOODEN_STAIRS).add(
          MtaBlocks.PALM_STAIRS.get()
        );
        this.tag(BlockTags.WOODEN_BUTTONS).add(
          MtaBlocks.PALM_BUTTON.get()
        );
        this.tag(BlockTags.WOODEN_FENCES).add(
          MtaBlocks.PALM_FENCE.get()
        );
        this.tag(BlockTags.WOODEN_DOORS).add(
          MtaBlocks.PALM_DOOR.get()
        );
        this.tag(BlockTags.WOODEN_TRAPDOORS).add(
          MtaBlocks.PALM_TRAPDOOR.get()
        );
        this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(
          MtaBlocks.PALM_PRESSURE_PLATE.get()
        );
        this.tag(BlockTags.SAPLINGS).add(
          MtaBlocks.PALM_SAPLING.get()
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

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).addTag(MtaTags.Blocks.NEEDS_NETHERSTEEL_TOOL);
        this.tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL).remove(MtaTags.Blocks.NEEDS_NETHERSTEEL_TOOL);



        this.tag(BlockTags.NEEDS_IRON_TOOL).add(
                MtaBlocks.NETHER_DIAMOND_ORE.get(),
                MtaBlocks.END_EMERALD_ORE.get(),
                MtaBlocks.END_LAPIS_ORE.get()
                ).remove(MtaTags.Blocks.NEEDS_NETHERSTEEL_TOOL).remove(MtaTags.Blocks.NEEDS_COPPER_TOOL);
        
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
                MtaBlocks.NETHERITIC_CRYSTAL.get(),
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

        this.tag(MtaTags.Blocks.SEA_ANIMAL_SPAWNABLE_ON)
                .addTag(BlockTags.ANIMALS_SPAWNABLE_ON)
                .add(

                        Blocks.STONE,
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
                        Blocks.DIRT
                );

        this.tag(MtaTags.Blocks.LAND_SWIMMER_SPAWNABLE_ON)
                .addTag(BlockTags.ANIMALS_SPAWNABLE_ON)
                .add(
                        Blocks.STONE,
                        Blocks.GRAVEL,
                        Blocks.WATER,
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
                        Blocks.GRAVEL);
    }
}
