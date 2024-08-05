package com.fuyuvulpes.morethanadventure.datagen.generators;

import com.fuyuvulpes.morethanadventure.game.worldgen.biomes.MtaBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.tags.BiomeTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class GenBiomeTags  extends BiomeTagsProvider {


    public GenBiomeTags(PackOutput p_255800_, CompletableFuture<HolderLookup.Provider> p_256205_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_255800_, p_256205_, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        /*this.tag(Tags.Biomes.IS_LUSH)
                .add(MtaBiomes.LUSH_RIVER)
                ;

        this.tag(Tags.Biomes.IS_RIVER).add(MtaBiomes.LUSH_RIVER);

        this.tag(Tags.Biomes.IS_SPARSE_VEGETATION)
                .add(MtaBiomes.SPARSE_TAIGA,
                        MtaBiomes.SPARSE_CHERRY_GROVE);

        this.tag(BiomeTags.IS_TAIGA).add(MtaBiomes.SPARSE_TAIGA);


        */
    }
}
