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
                        MtaItems.COPPER_HOE.get(),
                        MtaItems.ARMAMENT_PICKAXE.get(),
                        MtaItems.ARMAMENT_AXE.get(),
                        MtaItems.ARMAMENT_SHOVEL.get(),
                        MtaItems.ROYAL_PICKAXE.get(),
                        MtaItems.ROYAL_AXE.get(),
                        MtaItems.ROYAL_SHOVEL.get(),
                        MtaItems.AQUATIC_PICKAXE.get(),
                        MtaItems.AQUATIC_AXE.get(),
                        MtaItems.AQUATIC_SHOVEL.get(),
                        MtaItems.ANGELIC_PICKAXE.get(),
                        MtaItems.ANGELIC_AXE.get(),
                        MtaItems.ANGELIC_SHOVEL.get(),
                        MtaItems.BERSERK_PICKAXE.get(),
                        MtaItems.BERSERK_AXE.get(),
                        MtaItems.BERSERK_SHOVEL.get(),
                        MtaItems.FEATHERWEIGHT_PICKAXE.get(),
                        MtaItems.FEATHERWEIGHT_AXE.get(),
                        MtaItems.FEATHERWEIGHT_SHOVEL.get()
                );
        this.tag(ItemTags.SWORDS)
                .add(
                        MtaItems.COPPER_SWORD.get(),
                        MtaItems.HOLY_KNIGHTS_GREATSWORD.get(),
                        MtaItems.SHADOW_ROGUES_DAGGER.get()
                );
        this.tag(ItemTags.PICKAXES)
                .add(
                        MtaItems.COPPER_PICKAXE.get(),
                        MtaItems.ARMAMENT_PICKAXE.get(),
                        MtaItems.ROYAL_PICKAXE.get(),
                        MtaItems.AQUATIC_PICKAXE.get(),
                        MtaItems.ANGELIC_PICKAXE.get(),
                        MtaItems.BERSERK_PICKAXE.get(),
                        MtaItems.FEATHERWEIGHT_PICKAXE.get()
                );
        this.tag(ItemTags.AXES)
                .add(
                        MtaItems.COPPER_AXE.get(),
                        MtaItems.ARMAMENT_AXE.get(),
                        MtaItems.ROYAL_AXE.get(),
                        MtaItems.AQUATIC_AXE.get(),
                        MtaItems.ANGELIC_AXE.get(),
                        MtaItems.BERSERK_AXE.get(),
                        MtaItems.FEATHERWEIGHT_AXE.get()
                );
        this.tag(ItemTags.SHOVELS)
                .add(
                        MtaItems.COPPER_SHOVEL.get(),
                        MtaItems.ARMAMENT_SHOVEL.get(),
                        MtaItems.ROYAL_SHOVEL.get(),
                        MtaItems.AQUATIC_SHOVEL.get(),
                        MtaItems.ANGELIC_SHOVEL.get(),
                        MtaItems.BERSERK_SHOVEL.get(),
                        MtaItems.FEATHERWEIGHT_SHOVEL.get()
                );
        this.tag(ItemTags.HOES)
                .add(
                        MtaItems.COPPER_HOE.get()
                );
        this.tag(ItemTags.HEAD_ARMOR)
                .add(
                        MtaItems.GREAT_SENTINELS_HELMET.get(),
                        MtaItems.HOLY_KNIGHTS_HELMET.get(),
                        MtaItems.MYSTIC_MERMAIDS_HELMET.get(),
                        MtaItems.TEMPLE_ANGELS_HELMET.get(),
                        MtaItems.WRATHFUL_BERSERKERS_HELMET.get(),
                        MtaItems.SHADOW_ROGUES_HELMET.get()
                );
        this.tag(ItemTags.CHEST_ARMOR)
                .add(
                        MtaItems.GREAT_SENTINELS_CHESTPLATE.get(),
                        MtaItems.HOLY_KNIGHTS_CHESTPLATE.get(),
                        MtaItems.MYSTIC_MERMAIDS_CHESTPLATE.get(),
                        MtaItems.TEMPLE_ANGELS_CHESTPLATE.get(),
                        MtaItems.WRATHFUL_BERSERKERS_CHESTPLATE.get(),
                        MtaItems.SHADOW_ROGUES_CHESTPLATE.get()
                );
        this.tag(ItemTags.LEG_ARMOR)
                .add(
                        MtaItems.GREAT_SENTINELS_LEGGINGS.get(),
                        MtaItems.HOLY_KNIGHTS_LEGGINGS.get(),
                        MtaItems.MYSTIC_MERMAIDS_LEGGINGS.get(),
                        MtaItems.TEMPLE_ANGELS_LEGGINGS.get(),
                        MtaItems.WRATHFUL_BERSERKERS_LEGGINGS.get(),
                        MtaItems.SHADOW_ROGUES_LEGGINGS.get()
                );
        this.tag(ItemTags.FOOT_ARMOR)
                .add(
                        MtaItems.GREAT_SENTINELS_BOOTS.get(),
                        MtaItems.HOLY_KNIGHTS_BOOTS.get(),
                        MtaItems.MYSTIC_MERMAIDS_BOOTS.get(),
                        MtaItems.TEMPLE_ANGELS_BOOTS.get(),
                        MtaItems.WRATHFUL_BERSERKERS_BOOTS.get(),
                        MtaItems.SHADOW_ROGUES_BOOTS.get()
                );/*
        this.tag(ItemTags.TRIDENT_ENCHANTABLE)
                .add(
                        MtaItems.MYSTIC_MERMAIDS_TRIDENT.get()
                );
        this.tag(ItemTags.BOW_ENCHANTABLE)
                .add(
                        MtaItems.TEMPLE_ANGELS_BOW.get()
                );
        this.tag(ItemTags.SWORD_ENCHANTABLE)
                .add(
                        MtaItems.COPPER_SWORD.get(),
                        MtaItems.HOLY_KNIGHTS_GREAT_SWORD.get(),
                        MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE.get(),
                        MtaItems.SHADOW_ROGUES_DAGGER.get()
                );
        this.tag(ItemTags.Items.MACE_ENCHANTABLE)
                .add(
                        MtaItems.GREAT_SENTINELS_HAMMER.get()
                );
        this.tag(Tags.Items.TOOLS_BOW)
                .add(
                        MtaItems.TEMPLE_ANGELS_BOW.get();
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
