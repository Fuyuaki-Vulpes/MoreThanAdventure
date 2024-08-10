package com.fuyuvulpes.morethanadventure.datagen.generators;

import com.fuyuvulpes.morethanadventure.core.registry.MtaItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
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


        this.tag(Tags.Items.MINING_TOOL_TOOLS)
                .add(
                        MtaItems.COPPER_PICKAXE.get(),
                        MtaItems.COPPER_AXE.get(),
                        MtaItems.COPPER_SHOVEL.get(),
                        MtaItems.COPPER_HOE.get()
                );
        this.tag(ItemTags.SWORDS)
                .add(
                        MtaItems.COPPER_SWORD.get()
                );
        this.tag(ItemTags.PICKAXES)
                .add(
                        MtaItems.COPPER_PICKAXE.get()
                );
        this.tag(ItemTags.AXES)
                .add(
                        MtaItems.COPPER_AXE.get()
                );
        this.tag(ItemTags.SHOVELS)
                .add(
                        MtaItems.COPPER_SHOVEL.get()
                );
        this.tag(ItemTags.HOES)
                .add(
                        MtaItems.COPPER_HOE.get()
                );
        this.tag(ItemTags.HEAD_ARMOR)
                .add(
                        MtaItems.GREAT_SENTINELS_HELMET.get()
                );
        this.tag(ItemTags.CHEST_ARMOR)
                .add(
                        MtaItems.GREAT_SENTINELS_CHESTPLATE.get()
                );
        this.tag(ItemTags.LEG_ARMOR)
                .add(
                        MtaItems.GREAT_SENTINELS_LEGGINGS.get()
                );
        this.tag(ItemTags.FOOT_ARMOR)
                .add(
                        MtaItems.GREAT_SENTINELS_BOOTS.get()
                );/*
        this.tag(ItemTags.TRIDENT_ENCHANTABLE)
                .add(
                        MtaItems.GREAT_SENTINELS_BOOTS.get()
                );
        this.tag(ItemTags.BOW_ENCHANTABLE)
                .add(

                );
        this.tag(ItemTags.SWORD_ENCHANTABLE)
                .add(

                );
        this.tag(Tags.Items.TOOLS_BOW)
                .add(

                );
        this.tag(Tags.Items.TOOLS_SHIELD)
                .add(

                );
        this.tag(Tags.Items.TOOLS_SPEAR)
                .add(

                );

        this.tag(Tags.Items.TOOLS_CROSSBOW)
                .add(

                );

*/
    }
}
