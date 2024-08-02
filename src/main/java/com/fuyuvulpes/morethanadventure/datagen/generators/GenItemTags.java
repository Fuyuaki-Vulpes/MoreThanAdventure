package com.fuyuvulpes.morethanadventure.datagen.generators;

import com.fuyuvulpes.morethanadventure.core.registry.MtaItems;
import com.fuyuvulpes.morethanadventure.core.registry.MtaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class GenItemTags extends ItemTagsProvider {
    public GenItemTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(Tags.Items.GEMS_QUARTZ).add(MtaItems.CLEAR_QUARTZ.get());
        //this.tag(Tags.Items.ORES_NETHERITE_SCRAP)
    }
}
