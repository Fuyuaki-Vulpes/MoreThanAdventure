package com.fuyuaki.morethanadventure.datagen.generators;

import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class GenItemTags extends ItemTagsProvider {
    public GenItemTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, MODID, existingFileHelper);
    }

    private void commonTags() {
        this.tag(Tags.Items.FOODS_VEGETABLE)
                .add(
                        MtaItems.ONION.get()
                );


        this.tag(MtaTags.Common.CROPS_ONION).add(MtaItems.ONION.get());
        this.tag(MtaTags.Common.CROPS_RICE).add(MtaItems.RICE.get());
        this.tag(MtaTags.Common.CROPS_TOMATO).add(MtaItems.TOMATO_SEEDS.get());

        this.tag(MtaTags.Common.FOODS_ONION).add(MtaItems.ONION.get());
        this.tag(MtaTags.Common.FOODS_TOMATO).add(MtaItems.TOMATO.get());


        this.tag(Tags.Items.GEMS_QUARTZ).add(MtaItems.CLEAR_QUARTZ.get());

    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.copy(MtaTags.Blocks.PALM_LOGS, MtaTags.Items.PALM_LOGS);

        //this.tag(MtaTags.Items.COSMETIC_CORE_STONES).add();
        //this.tag(MtaTags.Items.EFFECTIVE_CORE_STONES).add();

        this.copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
        this.copy(BlockTags.PLANKS, ItemTags.PLANKS);


        this.tag(Tags.Items.MINING_TOOL_TOOLS)
                .add(
                        MtaItems.COPPER_PICKAXE.get(),
                        MtaItems.COPPER_AXE.get(),
                        MtaItems.COPPER_SHOVEL.get(),
                        MtaItems.COPPER_HOE.get(),
                        MtaItems.NETHERSTEEL_PICKAXE.get(),
                        MtaItems.NETHERSTEEL_AXE.get(),
                        MtaItems.NETHERSTEEL_SHOVEL.get(),
                        MtaItems.NETHERSTEEL_HOE.get(),
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
                        MtaItems.NETHERSTEEL_SWORD.get(),
                        MtaItems.HOLY_KNIGHTS_GREATSWORD.get(),
                        MtaItems.SHADOW_ROGUES_DAGGER.get()
                );

        this.tag(ItemTags.PICKAXES)
                .add(
                        MtaItems.COPPER_PICKAXE.get(),
                        MtaItems.NETHERSTEEL_PICKAXE.get(),
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
                        MtaItems.NETHERSTEEL_AXE.get(),
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
                        MtaItems.NETHERSTEEL_SHOVEL.get(),
                        MtaItems.ARMAMENT_SHOVEL.get(),
                        MtaItems.ROYAL_SHOVEL.get(),
                        MtaItems.AQUATIC_SHOVEL.get(),
                        MtaItems.ANGELIC_SHOVEL.get(),
                        MtaItems.BERSERK_SHOVEL.get(),
                        MtaItems.FEATHERWEIGHT_SHOVEL.get()
                );
        this.tag(ItemTags.HOES)
                .add(
                        MtaItems.COPPER_HOE.get(),
                        MtaItems.NETHERSTEEL_HOE.get()
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
                );
        //this.tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE.get());
        this.tag(ItemTags.WEAPON_ENCHANTABLE)
                .add(
                        MtaItems.GREAT_SENTINELS_WAR_HAMMER.get(),
                        MtaItems.MYSTIC_MERMAIDS_TRIDENT.get()

                );
        this.tag(ItemTags.TRIDENT_ENCHANTABLE)
                .add(
                        MtaItems.MYSTIC_MERMAIDS_TRIDENT.get(),
                        MtaItems.NETHERITE_TRIDENT.get()
                );
        this.tag(ItemTags.BOW_ENCHANTABLE)
                .add(
                        MtaItems.TEMPLE_ANGELS_BOW.get(),
                        MtaItems.NETHERITE_BOW.get()
                );
        this.tag(ItemTags.SWORD_ENCHANTABLE)
                .add(
                        MtaItems.COPPER_SWORD.get(),
                        MtaItems.NETHERSTEEL_SWORD.get(),
                        MtaItems.HOLY_KNIGHTS_GREATSWORD.get(),
                        MtaItems.SHADOW_ROGUES_DAGGER.get(),
                        MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE.get()
                );
        this.tag(ItemTags.MACE_ENCHANTABLE)
                .add(
                        MtaItems.GREAT_SENTINELS_WAR_HAMMER.get()
                );
        this.tag(Tags.Items.TOOLS_BOW)
                .add(
                        MtaItems.TEMPLE_ANGELS_BOW.get(),
                        MtaItems.NETHERITE_BOW.get()
                );
        /*this.tag(Tags.Items.TOOLS_SHIELD)
                .add(

               );*/
        this.tag(Tags.Items.TOOLS_SPEAR)
                .add(
                        MtaItems.MYSTIC_MERMAIDS_TRIDENT.get(),
                        MtaItems.NETHERITE_TRIDENT.get()

                );

       /* this.tag(Tags.Items.TOOLS_CROSSBOW)
               .add(

        );*/


        this.tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(
                        MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE.get(),
                        MtaItems.MYSTIC_MERMAIDS_TRIDENT.get(),
                        MtaItems.GREAT_SENTINELS_WAR_HAMMER.get(),
                        MtaItems.NETHERITE_TRIDENT.get()

                );

        this.tag(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(
                        MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE.get(),
                        MtaItems.GREAT_SENTINELS_WAR_HAMMER.get()

                );
        //this.tag(MtaTags.Items.CORE_STONES).addTag(MtaTags.Items.COSMETIC_CORE_STONES).addTag(MtaTags.Items.EFFECTIVE_CORE_STONES);


        commonTags();
    }

}
