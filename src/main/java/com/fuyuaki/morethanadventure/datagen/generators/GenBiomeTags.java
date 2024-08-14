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
    }
}
