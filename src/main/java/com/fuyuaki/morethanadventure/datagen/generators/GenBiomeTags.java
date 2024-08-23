package com.fuyuaki.morethanadventure.datagen.generators;

import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class GenBiomeTags  extends BiomeTagsProvider {


    public GenBiomeTags(PackOutput p_255800_, CompletableFuture<HolderLookup.Provider> p_256205_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_255800_, p_256205_, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(MtaTags.Biomes.GRASSY_DIRT_SHOULD_GENERATE)
                .addTag(Tags.Biomes.IS_DENSE_VEGETATION)
                .addTag(Tags.Biomes.IS_FOREST)
                ;

        this.tag(Tags.Biomes.IS_LUSH)
                .add(MtaBiomes.LUSH_RIVER)
                .add(MtaBiomes.LUSH_MEADOW)
                ;

        this.tag(Tags.Biomes.IS_RIVER).add(MtaBiomes.LUSH_RIVER);

        this.tag(Tags.Biomes.IS_SPARSE_VEGETATION)
                .add(MtaBiomes.SPARSE_TAIGA,
                        MtaBiomes.SPARSE_CHERRY_GROVE);




        this.tag(BiomeTags.HAS_VILLAGE_DESERT).add(MtaBiomes.OASIS);
        this.tag(Tags.Biomes.IS_DESERT).add(MtaBiomes.OASIS);





        this.tag(MtaTags.Biomes.OVERWORLD_GEYSERS)
                .add(   Biomes.STONY_PEAKS
                )
                .addTag(Tags.Biomes.IS_STONY_SHORES)
                .addTag(Tags.Biomes.IS_WINDSWEPT)
                .addTag(BiomeTags.IS_BADLANDS);

        this.tag(MtaTags.Biomes.NETHER_GEYSERS)
                .add(   Biomes.NETHER_WASTES,
                        Biomes.BASALT_DELTAS

                );

        this.tag(MtaTags.Biomes.HAS_PALE_WOLF)
                .add(MtaBiomes.SPARSE_TAIGA);

        this.tag(MtaTags.Biomes.HAS_SPOTTED_WOLF)
                .add(MtaBiomes.OASIS);

        this.tag(MtaTags.Biomes.HAS_BEARDED_DRAGON)
                .addTag(Tags.Biomes.IS_SAVANNA)
                .addTag(Tags.Biomes.IS_DESERT);
        this.tag(MtaTags.Biomes.HAS_CAPYBARA)
                .add(MtaBiomes.LUSH_RIVER)
                .addTag(Tags.Biomes.IS_SWAMP)
                .addTag(Tags.Biomes.IS_RIVER);
        this.tag(MtaTags.Biomes.HAS_DUCK)
                .addTag(Tags.Biomes.IS_RIVER);
        this.tag(MtaTags.Biomes.HAS_FERRET)
                .addTag(Tags.Biomes.IS_PLAINS);
        this.tag(MtaTags.Biomes.HAS_GREAT_WHITE_SHARK)
                .addTag(Tags.Biomes.IS_OCEAN);
        this.tag(MtaTags.Biomes.HAS_HORSESHOE_CRAB)
                .add(Biomes.BEACH);
        this.tag(MtaTags.Biomes.HAS_JELLYFISH)
                .add(Biomes.OCEAN)
                .add(Biomes.COLD_OCEAN)
                .add(Biomes.LUKEWARM_OCEAN)
                .add(Biomes.DEEP_OCEAN)
                .add(Biomes.DEEP_COLD_OCEAN)
                .add(Biomes.DEEP_LUKEWARM_OCEAN);
        this.tag(MtaTags.Biomes.HAS_OCTOPUS)
                .add(Biomes.BEACH)
                .add(Biomes.OCEAN)
                .add(Biomes.LUKEWARM_OCEAN);
        this.tag(MtaTags.Biomes.HAS_OWL)
                .addTag(Tags.Biomes.IS_FOREST);
        this.tag(MtaTags.Biomes.HAS_PENGUIN)
                .add(Biomes.FROZEN_OCEAN)
                .add(Biomes.ICE_SPIKES)
                .add(Biomes.SNOWY_PLAINS);
        this.tag(MtaTags.Biomes.HAS_RACCOON)
                .addTag(Tags.Biomes.IS_FOREST);
        this.tag(MtaTags.Biomes.HAS_SHRIMP)
                .add(Biomes.OCEAN)
                .add(Biomes.COLD_OCEAN)
                .add(Biomes.LUKEWARM_OCEAN);
        this.tag(MtaTags.Biomes.HAS_TOUCAN)
                .addTag(Tags.Biomes.IS_JUNGLE);
    }
}
