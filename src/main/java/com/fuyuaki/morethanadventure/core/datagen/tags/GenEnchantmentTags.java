package com.fuyuaki.morethanadventure.core.datagen.tags;

import com.fuyuaki.morethanadventure.core.mod.MTAMod;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.world.item.enchantment.Enchantments;

import java.util.concurrent.CompletableFuture;

public class GenEnchantmentTags extends EnchantmentTagsProvider {
    public GenEnchantmentTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MTAMod.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(MtaTags.Enchantments.FLAMING).add(
                Enchantments.FLAME
        );
    }
}
