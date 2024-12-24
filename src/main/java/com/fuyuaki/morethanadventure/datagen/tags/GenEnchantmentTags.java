package com.fuyuaki.morethanadventure.datagen.tags;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.world.item.enchantment.Enchantments;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class GenEnchantmentTags extends EnchantmentTagsProvider {
    public GenEnchantmentTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MTAMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(MtaTags.Enchantments.FLAMING).add(
                Enchantments.FLAME
        );
    }
}
