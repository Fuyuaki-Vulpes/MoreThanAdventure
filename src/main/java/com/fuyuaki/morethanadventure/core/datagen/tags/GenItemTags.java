package com.fuyuaki.morethanadventure.core.datagen.tags;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class GenItemTags extends IntrinsicHolderTagsProvider<Item> {

    private final CompletableFuture<TagsProvider.TagLookup<Block>> blockTags;
    private final Map<TagKey<Block>, TagKey<Item>> tagsToCopy = new HashMap<>();


    public GenItemTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(pOutput, Registries.ITEM, pLookupProvider, item -> item.builtInRegistryHolder().key(),MODID);
        this.blockTags = blockTags;
    }

    private void commonTags() {
        this.tag(Tags.Items.FOODS_VEGETABLE)
                .add(
                        MtaItems.ONION.get()
                );

        weaponTags();
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
        this.copy(MtaTags.Blocks.SEAWOOD, MtaTags.Items.SEAWOOD);

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
                        MtaItems.NETHERSTEEL_HOE.get()
                );
        this.tag(ItemTags.SWORDS)
                .add(
                        MtaItems.COPPER_SWORD.get(),
                        MtaItems.NETHERSTEEL_SWORD.get(),
                        MtaItems.HOLY_KNIGHTS_GREATSWORD.get(),
                        MtaItems.SHADOW_ROGUES_DAGGER.get(),

                        MtaItems.WOOD_ANCHOR.get(),
                        MtaItems.WOOD_CLAW.get(),
                        MtaItems.WOOD_CLAYMORE.get(),
                        MtaItems.WOOD_CUTLASS.get(),
                        MtaItems.WOOD_DAGGER.get(),
                        MtaItems.WOOD_DOUBLE_AXE.get(),
                        MtaItems.WOOD_FLAIL.get(),
                        MtaItems.WOOD_GLAIVE.get(),
                        MtaItems.WOOD_HALBERD.get(),
                        MtaItems.WOOD_KATANA.get(),
                        MtaItems.WOOD_RAPIER.get(),
                        MtaItems.WOOD_SCYTHE.get(),
                        MtaItems.WOOD_SICKLE.get(),
                        MtaItems.WOOD_SPEAR.get(),
                        MtaItems.WOOD_WHIP_SWORD.get(),

                        MtaItems.STONE_CLAW.get(),
                        MtaItems.STONE_ANCHOR.get(),
                        MtaItems.STONE_CLAYMORE.get(),
                        MtaItems.STONE_CUTLASS.get(),
                        MtaItems.STONE_DAGGER.get(),
                        MtaItems.STONE_DOUBLE_AXE.get(),
                        MtaItems.STONE_FLAIL.get(),
                        MtaItems.STONE_GLAIVE.get(),
                        MtaItems.STONE_HALBERD.get(),
                        MtaItems.STONE_KATANA.get(),
                        MtaItems.STONE_RAPIER.get(),
                        MtaItems.STONE_SCYTHE.get(),
                        MtaItems.STONE_SICKLE.get(),
                        MtaItems.STONE_SPEAR.get(),
                        MtaItems.STONE_WHIP_SWORD.get(),

                        MtaItems.COPPER_ANCHOR.get(),
                        MtaItems.COPPER_CLAW.get(),
                        MtaItems.COPPER_CLAYMORE.get(),
                        MtaItems.COPPER_CUTLASS.get(),
                        MtaItems.COPPER_DAGGER.get(),
                        MtaItems.COPPER_DOUBLE_AXE.get(),
                        MtaItems.COPPER_FLAIL.get(),
                        MtaItems.COPPER_GLAIVE.get(),
                        MtaItems.COPPER_HALBERD.get(),
                        MtaItems.COPPER_KATANA.get(),
                        MtaItems.COPPER_RAPIER.get(),
                        MtaItems.COPPER_SCYTHE.get(),
                        MtaItems.COPPER_SICKLE.get(),
                        MtaItems.COPPER_SPEAR.get(),
                        MtaItems.COPPER_TWINBLADE.get(),
                        MtaItems.COPPER_WHIP_SWORD.get(),

                        MtaItems.IRON_ANCHOR.get(),
                        MtaItems.IRON_CLAW.get(),
                        MtaItems.IRON_CLAYMORE.get(),
                        MtaItems.IRON_CUTLASS.get(),
                        MtaItems.IRON_DAGGER.get(),
                        MtaItems.IRON_DOUBLE_AXE.get(),
                        MtaItems.IRON_FLAIL.get(),
                        MtaItems.IRON_GLAIVE.get(),
                        MtaItems.IRON_HALBERD.get(),
                        MtaItems.IRON_KATANA.get(),
                        MtaItems.IRON_RAPIER.get(),
                        MtaItems.IRON_SCYTHE.get(),
                        MtaItems.IRON_SICKLE.get(),
                        MtaItems.IRON_SPEAR.get(),
                        MtaItems.IRON_TWINBLADE.get(),
                        MtaItems.IRON_WHIP_SWORD.get(),

                        MtaItems.GOLD_ANCHOR.get(),
                        MtaItems.GOLD_CLAW.get(),
                        MtaItems.GOLD_CLAYMORE.get(),
                        MtaItems.GOLD_CUTLASS.get(),
                        MtaItems.GOLD_DAGGER.get(),
                        MtaItems.GOLD_DOUBLE_AXE.get(),
                        MtaItems.GOLD_FLAIL.get(),
                        MtaItems.GOLD_GLAIVE.get(),
                        MtaItems.GOLD_HALBERD.get(),
                        MtaItems.GOLD_KATANA.get(),
                        MtaItems.GOLD_RAPIER.get(),
                        MtaItems.GOLD_SCYTHE.get(),
                        MtaItems.GOLD_SICKLE.get(),
                        MtaItems.GOLD_SPEAR.get(),
                        MtaItems.GOLD_TWINBLADE.get(),
                        MtaItems.GOLD_WHIP_SWORD.get(),

                        MtaItems.NETHERSTEEL_CLAW.get(),
                        MtaItems.NETHERSTEEL_ANCHOR.get(),
                        MtaItems.NETHERSTEEL_CLAYMORE.get(),
                        MtaItems.NETHERSTEEL_CUTLASS.get(),
                        MtaItems.NETHERSTEEL_DAGGER.get(),
                        MtaItems.NETHERSTEEL_DOUBLE_AXE.get(),
                        MtaItems.NETHERSTEEL_FLAIL.get(),
                        MtaItems.NETHERSTEEL_GLAIVE.get(),
                        MtaItems.NETHERSTEEL_HALBERD.get(),
                        MtaItems.NETHERSTEEL_KATANA.get(),
                        MtaItems.NETHERSTEEL_RAPIER.get(),
                        MtaItems.NETHERSTEEL_SCYTHE.get(),
                        MtaItems.NETHERSTEEL_SICKLE.get(),
                        MtaItems.NETHERSTEEL_SPEAR.get(),
                        MtaItems.NETHERSTEEL_TWINBLADE.get(),
                        MtaItems.NETHERSTEEL_WHIP_SWORD.get(),

                        MtaItems.DIAMOND_ANCHOR.get(),
                        MtaItems.DIAMOND_CLAW.get(),
                        MtaItems.DIAMOND_CLAYMORE.get(),
                        MtaItems.DIAMOND_CUTLASS.get(),
                        MtaItems.DIAMOND_DAGGER.get(),
                        MtaItems.DIAMOND_DOUBLE_AXE.get(),
                        MtaItems.DIAMOND_FLAIL.get(),
                        MtaItems.DIAMOND_GLAIVE.get(),
                        MtaItems.DIAMOND_HALBERD.get(),
                        MtaItems.DIAMOND_KATANA.get(),
                        MtaItems.DIAMOND_RAPIER.get(),
                        MtaItems.DIAMOND_SCYTHE.get(),
                        MtaItems.DIAMOND_SICKLE.get(),
                        MtaItems.DIAMOND_SPEAR.get(),
                        MtaItems.DIAMOND_TWINBLADE.get(),
                        MtaItems.DIAMOND_WHIP_SWORD.get(),

                        MtaItems.NETHERITE_ANCHOR.get(),
                        MtaItems.NETHERITE_CLAW.get(),
                        MtaItems.NETHERITE_CLAYMORE.get(),
                        MtaItems.NETHERITE_CUTLASS.get(),
                        MtaItems.NETHERITE_DAGGER.get(),
                        MtaItems.NETHERITE_DOUBLE_AXE.get(),
                        MtaItems.NETHERITE_FLAIL.get(),
                        MtaItems.NETHERITE_GLAIVE.get(),
                        MtaItems.NETHERITE_HALBERD.get(),
                        MtaItems.NETHERITE_KATANA.get(),
                        MtaItems.NETHERITE_RAPIER.get(),
                        MtaItems.NETHERITE_SCYTHE.get(),
                        MtaItems.NETHERITE_SICKLE.get(),
                        MtaItems.NETHERITE_SPEAR.get(),
                        MtaItems.NETHERITE_TWINBLADE.get(),
                        MtaItems.NETHERITE_WHIP_SWORD.get()
                );

        this.tag(ItemTags.PICKAXES)
                .add(
                        MtaItems.COPPER_PICKAXE.get(),
                        MtaItems.NETHERSTEEL_PICKAXE.get()
                );
        this.tag(ItemTags.AXES)
                .add(
                        MtaItems.COPPER_AXE.get(),
                        MtaItems.NETHERSTEEL_AXE.get()
                );
        this.tag(ItemTags.SHOVELS)
                .add(
                        MtaItems.COPPER_SHOVEL.get(),
                        MtaItems.NETHERSTEEL_SHOVEL.get()
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
                        MtaItems.SILENT_REAPERS_HELMET.get(),
                        MtaItems.TEMPLE_ANGELS_HELMET.get(),
                        MtaItems.FREEZING_ICICLE_HELMET.get(),
                        MtaItems.WRATHFUL_BERSERKERS_HELMET.get(),
                        MtaItems.SHADOW_ROGUES_HELMET.get()
                );
        this.tag(ItemTags.CHEST_ARMOR)
                .add(
                        MtaItems.GREAT_SENTINELS_CHESTPLATE.get(),
                        MtaItems.HOLY_KNIGHTS_CHESTPLATE.get(),
                        MtaItems.MYSTIC_MERMAIDS_CHESTPLATE.get(),
                        MtaItems.SILENT_REAPERS_CHESTPLATE.get(),
                        MtaItems.TEMPLE_ANGELS_CHESTPLATE.get(),
                        MtaItems.FREEZING_ICICLE_CHESTPLATE.get(),
                        MtaItems.WRATHFUL_BERSERKERS_CHESTPLATE.get(),
                        MtaItems.SHADOW_ROGUES_CHESTPLATE.get()
                );
        this.tag(ItemTags.LEG_ARMOR)
                .add(
                        MtaItems.GREAT_SENTINELS_LEGGINGS.get(),
                        MtaItems.HOLY_KNIGHTS_LEGGINGS.get(),
                        MtaItems.MYSTIC_MERMAIDS_LEGGINGS.get(),
                        MtaItems.SILENT_REAPERS_LEGGINGS.get(),
                        MtaItems.TEMPLE_ANGELS_LEGGINGS.get(),
                        MtaItems.FREEZING_ICICLE_LEGGINGS.get(),
                        MtaItems.WRATHFUL_BERSERKERS_LEGGINGS.get(),
                        MtaItems.SHADOW_ROGUES_LEGGINGS.get()
                );
        this.tag(ItemTags.FOOT_ARMOR)
                .add(
                        MtaItems.GREAT_SENTINELS_BOOTS.get(),
                        MtaItems.HOLY_KNIGHTS_BOOTS.get(),
                        MtaItems.MYSTIC_MERMAIDS_BOOTS.get(),
                        MtaItems.SILENT_REAPERS_BOOTS.get(),
                        MtaItems.TEMPLE_ANGELS_BOOTS.get(),
                        MtaItems.FREEZING_ICICLE_BOOTS.get(),
                        MtaItems.WRATHFUL_BERSERKERS_BOOTS.get(),
                        MtaItems.SHADOW_ROGUES_BOOTS.get()
                );
        this.tag(ItemTags.SHARP_WEAPON_ENCHANTABLE)
                .add(
                        MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE.get()
                );
        this.tag(ItemTags.WEAPON_ENCHANTABLE)
                .add(
                        MtaItems.GREAT_SENTINELS_WAR_HAMMER.get(),
                        MtaItems.MYSTIC_MERMAIDS_TRIDENT.get(),
                        MtaItems.SILENT_REAPERS_SCYTHE.get(),
                        MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE.get()

                );
        this.tag(ItemTags.TRIDENT_ENCHANTABLE)
                .add(
                        MtaItems.MYSTIC_MERMAIDS_TRIDENT.get(),
                        MtaItems.NETHERITE_TRIDENT.get()
                );
        this.tag(ItemTags.BOW_ENCHANTABLE)
                .add(
                        MtaItems.TEMPLE_ANGELS_BOW.get(),
                        MtaItems.NETHERITE_BOW.get(),
                        MtaItems.LONG_BOW.get(),
                        MtaItems.REINFORCED_LONG_BOW.get(),
                        MtaItems.SHORT_BOW.get(),
                        MtaItems.REINFORCED_SHORT_BOW.get(),
                        MtaItems.TWIN_BOW.get(),
                        MtaItems.REINFORCED_TWIN_BOW.get()
                );
        this.tag(ItemTags.SWORD_ENCHANTABLE)
                .add(
                        MtaItems.COPPER_SWORD.get(),
                        MtaItems.NETHERSTEEL_SWORD.get(),
                        MtaItems.HOLY_KNIGHTS_GREATSWORD.get(),
                        MtaItems.SILENT_REAPERS_SCYTHE.get(),
                        MtaItems.SHADOW_ROGUES_DAGGER.get(),
                        MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE.get()
                );
        this.tag(ItemTags.MACE_ENCHANTABLE)
                .add(
                        MtaItems.GREAT_SENTINELS_WAR_HAMMER.get(),
                        MtaItems.NETHERITE_MACE.get()
                );
        this.tag(Tags.Items.TOOLS_BOW)
                .add(
                        MtaItems.TEMPLE_ANGELS_BOW.get(),
                        MtaItems.NETHERITE_BOW.get(),
                        MtaItems.LONG_BOW.get(),
                        MtaItems.REINFORCED_LONG_BOW.get(),
                        MtaItems.SHORT_BOW.get(),
                        MtaItems.REINFORCED_SHORT_BOW.get(),
                        MtaItems.TWIN_BOW.get(),
                        MtaItems.REINFORCED_TWIN_BOW.get()
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
                        MtaItems.NETHERITE_TRIDENT.get(),
                        MtaItems.NETHERITE_MACE.get()
                );

        this.tag(ItemTags.FIRE_ASPECT_ENCHANTABLE)
                .add(
                        MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE.get(),
                        MtaItems.GREAT_SENTINELS_WAR_HAMMER.get()

                );

        this.tag(MtaTags.Items.LOOTING_ENCHANTMENTS)
                .add(
                        MtaItems.LEATHER_WHIP.get(),
                        MtaItems.CHAIN_WHIP.get(),
                        MtaItems.NETHERITE_WHIP.get()
                );

        this.tag(MtaTags.Items.WHIP_ENCHANTMENTS)
                .add(
                        MtaItems.LEATHER_WHIP.get(),
                        MtaItems.CHAIN_WHIP.get(),
                        MtaItems.NETHERITE_WHIP.get()
                );
        //this.tag(MtaTags.Items.CORE_STONES).addTag(MtaTags.Items.COSMETIC_CORE_STONES).addTag(MtaTags.Items.EFFECTIVE_CORE_STONES);


        commonTags();
    }




    private void weaponTags() {
        this.tag(MtaTags.Items.THROWABLE).add(
                MtaItems.WOOD_DAGGER.get(),
                MtaItems.STONE_DAGGER.get(),
                MtaItems.COPPER_DAGGER.get(),
                MtaItems.IRON_DAGGER.get(),
                MtaItems.GOLD_DAGGER.get(),
                MtaItems.NETHERSTEEL_DAGGER.get(),
                MtaItems.DIAMOND_DAGGER.get(),
                MtaItems.NETHERITE_DAGGER.get()
        );
        this.tag(MtaTags.Items.TWO_HANDED).add(
                MtaItems.GREAT_SENTINELS_WAR_HAMMER.get(),
                MtaItems.HOLY_KNIGHTS_GREATSWORD.get(),
                MtaItems.SILENT_REAPERS_SCYTHE.get(),
                MtaItems.FREEZING_ICICLE_SPEAR.get(),

                MtaItems.WOOD_ANCHOR.get(),
                MtaItems.STONE_ANCHOR.get(),
                MtaItems.COPPER_ANCHOR.get(),
                MtaItems.IRON_ANCHOR.get(),
                MtaItems.GOLD_ANCHOR.get(),
                MtaItems.NETHERSTEEL_ANCHOR.get(),
                MtaItems.DIAMOND_ANCHOR.get(),
                MtaItems.NETHERITE_ANCHOR.get(),

                MtaItems.WOOD_HALBERD.get(),
                MtaItems.STONE_HALBERD.get(),
                MtaItems.COPPER_HALBERD.get(),
                MtaItems.IRON_HALBERD.get(),
                MtaItems.GOLD_HALBERD.get(),
                MtaItems.NETHERSTEEL_HALBERD.get(),
                MtaItems.DIAMOND_HALBERD.get(),
                MtaItems.NETHERITE_HALBERD.get(),

                MtaItems.WOOD_CLAYMORE.get(),
                MtaItems.STONE_CLAYMORE.get(),
                MtaItems.COPPER_CLAYMORE.get(),
                MtaItems.IRON_CLAYMORE.get(),
                MtaItems.GOLD_CLAYMORE.get(),
                MtaItems.NETHERSTEEL_CLAYMORE.get(),
                MtaItems.DIAMOND_CLAYMORE.get(),
                MtaItems.NETHERITE_CLAYMORE.get(),

                MtaItems.WOOD_SCYTHE.get(),
                MtaItems.STONE_SCYTHE.get(),
                MtaItems.COPPER_SCYTHE.get(),
                MtaItems.IRON_SCYTHE.get(),
                MtaItems.GOLD_SCYTHE.get(),
                MtaItems.NETHERSTEEL_SCYTHE.get(),
                MtaItems.DIAMOND_SCYTHE.get(),
                MtaItems.NETHERITE_SCYTHE.get(),

                MtaItems.WOOD_GLAIVE.get(),
                MtaItems.STONE_GLAIVE.get(),
                MtaItems.COPPER_GLAIVE.get(),
                MtaItems.IRON_GLAIVE.get(),
                MtaItems.GOLD_GLAIVE.get(),
                MtaItems.NETHERSTEEL_GLAIVE.get(),
                MtaItems.DIAMOND_GLAIVE.get(),
                MtaItems.NETHERITE_GLAIVE.get()

        );
        this.tag(MtaTags.Items.CAUSES_BLEEDING).add(
                MtaItems.SILENT_REAPERS_SCYTHE.get(),

                MtaItems.WOOD_SCYTHE.get(),
                MtaItems.STONE_SCYTHE.get(),
                MtaItems.COPPER_SCYTHE.get(),
                MtaItems.IRON_SCYTHE.get(),
                MtaItems.GOLD_SCYTHE.get(),
                MtaItems.NETHERSTEEL_SCYTHE.get(),
                MtaItems.DIAMOND_SCYTHE.get(),
                MtaItems.NETHERITE_SCYTHE.get(),

                MtaItems.WOOD_CUTLASS.get(),
                MtaItems.STONE_CUTLASS.get(),
                MtaItems.COPPER_CUTLASS.get(),
                MtaItems.IRON_CUTLASS.get(),
                MtaItems.GOLD_CUTLASS.get(),
                MtaItems.NETHERSTEEL_CUTLASS.get(),
                MtaItems.DIAMOND_CUTLASS.get(),
                MtaItems.NETHERITE_CUTLASS.get(),

                MtaItems.WOOD_CLAW.get(),
                MtaItems.STONE_CLAW.get(),
                MtaItems.COPPER_CLAW.get(),
                MtaItems.IRON_CLAW.get(),
                MtaItems.GOLD_CLAW.get(),
                MtaItems.NETHERSTEEL_CLAW.get(),
                MtaItems.DIAMOND_CLAW.get(),
                MtaItems.NETHERITE_CLAW.get(),

                MtaItems.WOOD_RAPIER.get(),
                MtaItems.STONE_RAPIER.get(),
                MtaItems.COPPER_RAPIER.get(),
                MtaItems.IRON_RAPIER.get(),
                MtaItems.GOLD_RAPIER.get(),
                MtaItems.NETHERSTEEL_RAPIER.get(),
                MtaItems.DIAMOND_RAPIER.get(),
                MtaItems.NETHERITE_RAPIER.get(),

                MtaItems.WOOD_SICKLE.get(),
                MtaItems.STONE_SICKLE.get(),
                MtaItems.COPPER_SICKLE.get(),
                MtaItems.IRON_SICKLE.get(),
                MtaItems.GOLD_SICKLE.get(),
                MtaItems.NETHERSTEEL_SICKLE.get(),
                MtaItems.DIAMOND_SICKLE.get(),
                MtaItems.NETHERITE_SICKLE.get()

        );
        this.tag(MtaTags.Items.STUN).add(
                MtaItems.GREAT_SENTINELS_WAR_HAMMER.get(),
                MtaItems.HOLY_KNIGHTS_GREATSWORD.get(),
                MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE.get(),
                MtaItems.FREEZING_ICICLE_SPEAR.get(),

                MtaItems.WOOD_ANCHOR.get(),
                MtaItems.STONE_ANCHOR.get(),
                MtaItems.COPPER_ANCHOR.get(),
                MtaItems.IRON_ANCHOR.get(),
                MtaItems.GOLD_ANCHOR.get(),
                MtaItems.NETHERSTEEL_ANCHOR.get(),
                MtaItems.DIAMOND_ANCHOR.get(),
                MtaItems.NETHERITE_ANCHOR.get(),

                MtaItems.WOOD_DOUBLE_AXE.get(),
                MtaItems.STONE_DOUBLE_AXE.get(),
                MtaItems.COPPER_DOUBLE_AXE.get(),
                MtaItems.IRON_DOUBLE_AXE.get(),
                MtaItems.GOLD_DOUBLE_AXE.get(),
                MtaItems.NETHERSTEEL_DOUBLE_AXE.get(),
                MtaItems.DIAMOND_DOUBLE_AXE.get(),
                MtaItems.NETHERITE_DOUBLE_AXE.get(),

                MtaItems.WOOD_CLAYMORE.get(),
                MtaItems.STONE_CLAYMORE.get(),
                MtaItems.COPPER_CLAYMORE.get(),
                MtaItems.IRON_CLAYMORE.get(),
                MtaItems.GOLD_CLAYMORE.get(),
                MtaItems.NETHERSTEEL_CLAYMORE.get(),
                MtaItems.DIAMOND_CLAYMORE.get(),
                MtaItems.NETHERITE_CLAYMORE.get(),

                MtaItems.WOOD_SPEAR.get(),
                MtaItems.STONE_SPEAR.get(),
                MtaItems.COPPER_SPEAR.get(),
                MtaItems.IRON_SPEAR.get(),
                MtaItems.GOLD_SPEAR.get(),
                MtaItems.NETHERSTEEL_SPEAR.get(),
                MtaItems.DIAMOND_SPEAR.get(),
                MtaItems.NETHERITE_SPEAR.get()

        );

    }
    protected void copy(TagKey<Block> blockTag, TagKey<Item> itemTag) {
        this.tagsToCopy.put(blockTag, itemTag);
    }

    @Override
    protected CompletableFuture<HolderLookup.Provider> createContentsProvider() {
        return super.createContentsProvider().thenCombine(this.blockTags, (p_274766_, p_274767_) -> {
            this.tagsToCopy.forEach((p_274763_, p_274764_) -> {
                TagBuilder tagbuilder = this.getOrCreateRawBuilder((TagKey<Item>)p_274764_);
                Optional<TagBuilder> optional = p_274767_.apply(p_274763_);
                optional.orElseThrow(() -> new IllegalStateException("Missing block tag " + p_274764_.location())).build().forEach(tagbuilder::add);
            });
            return (HolderLookup.Provider)p_274766_;
        });
    }


}
