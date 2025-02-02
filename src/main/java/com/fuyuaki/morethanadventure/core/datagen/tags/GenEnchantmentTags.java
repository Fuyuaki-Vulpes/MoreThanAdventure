package com.fuyuaki.morethanadventure.core.datagen.tags;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEnchantments;
import com.fuyuaki.morethanadventure.core.mod.MTAMod;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EnchantmentTagsProvider;
import net.minecraft.tags.EnchantmentTags;
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
        this.tag(MtaTags.Enchantments.WHIP).add(
                Enchantments.FIRE_ASPECT,
                Enchantments.LOOTING,
                Enchantments.KNOCKBACK,
                Enchantments.MENDING,
                Enchantments.SWEEPING_EDGE,
                Enchantments.UNBREAKING
        );
        this.tag(EnchantmentTags.IN_ENCHANTING_TABLE).add(
                MtaEnchantments.DISARM,
                MtaEnchantments.SNAG,
                //MtaEnchantments.STRAFING,
                MtaEnchantments.HIT_AND_RUN
        );
        this.tag(MtaTags.Enchantments.HIT_BUFF_EXCLUSIVE).add(
                MtaEnchantments.HIT_AND_RUN
        );
    }
}
