package com.fuyuaki.morethanadventure.datagen.generators.loot;

import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import com.fuyuaki.morethanadventure.world.block.OnionCropBlock;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolSingletonContainer;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LootBlocks extends BlockLootSubProvider {
    List<Block> excludedBlocks = List.of();
    List<Block> knownBlocks = MtaBlocks.BLOCKS.getEntries().stream().map(Holder::value).collect(Collectors.toList());
    protected static final float[] PALM_LEAVES_SAPLING_CHANCES = new float[]{0.1F, 0.2F, 0.4F, 0.6F};


    public LootBlocks(HolderLookup.Provider provider) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(),provider);
    }

    @Override
    protected void generate() {
        dropSelf(MtaBlocks.PALM_LOG.get());
        dropSelf(MtaBlocks.PALM_WOOD.get());
        dropSelf(MtaBlocks.STRIPPED_PALM_LOG.get());
        dropSelf(MtaBlocks.STRIPPED_PALM_WOOD.get());
        dropSelf(MtaBlocks.PALM_PLANKS.get());
        this.add(MtaBlocks.PALM_LEAVES.get(), block -> createPalmLeavesDrops(block, MtaItems.COCONUT.get(), PALM_LEAVES_SAPLING_CHANCES));
        dropSelf(MtaBlocks.PALM_SAPLING.get());
        dropSelf(MtaBlocks.PALM_STAIRS.get());
        this.add(MtaBlocks.PALM_SLAB.get(), block -> createSlabItemTable(MtaBlocks.PALM_SLAB.get()));
        dropSelf(MtaBlocks.PALM_PRESSURE_PLATE.get());
        dropSelf(MtaBlocks.PALM_BUTTON.get());
        dropSelf(MtaBlocks.PALM_FENCE.get());
        dropSelf(MtaBlocks.PALM_FENCE_GATE.get());
        this.add(MtaBlocks.PALM_DOOR.get(), block -> createDoorTable(MtaBlocks.PALM_DOOR.get()));
        dropSelf(MtaBlocks.PALM_TRAPDOOR.get());
        dropSelf(MtaBlocks.SPRINKLER.get());
        dropSelf(MtaBlocks.MOSSY_ANDESITE.get());
        this.add(MtaBlocks.STONE_GEYSER.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.COBBLESTONE));
        this.add(MtaBlocks.TERRACOTTA_GEYSER.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.TERRACOTTA));
        this.add(MtaBlocks.NETHERRACK_GEYSER.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.NETHERRACK));
        this.add(MtaBlocks.BASALT_GEYSER.get(), block -> this.createSingleItemTableWithSilkTouch(block, Blocks.BASALT));
        this.add(MtaBlocks.NETHER_IRON_ORE.get(), block -> this.createOreDrop(block, Items.RAW_IRON));
        this.add(MtaBlocks.NETHER_DIAMOND_ORE.get(), block -> this.createOreDrop(block, Items.DIAMOND));
        this.add(MtaBlocks.END_EMERALD_ORE.get(), block -> this.createOreDrop(block, Items.EMERALD_BLOCK));
        this.add(MtaBlocks.END_LAPIS_ORE.get(), this::createLapisOreDrops);
        this.add(MtaBlocks.CLEAR_QUARTZ_ORE.get(), block -> this.createOreDrop(block, MtaItems.CLEAR_QUARTZ.get()));
        this.add(MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_ORE.get(), block -> this.createOreDrop(block, MtaItems.CLEAR_QUARTZ.get()));
        this.add(MtaBlocks.CLEAR_QUARTZ_CLUSTER.get(), block -> this.createOreDrop(block, MtaItems.CLEAR_QUARTZ.get()));
        this.add(MtaBlocks.CLEAR_QUARTZ_GROWTH.get(), block -> this.createSingleItemTable(Blocks.STONE));
        this.add(MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_GROWTH.get(), block -> this.createSingleItemTable(Blocks.DEEPSLATE));
        this.add(MtaBlocks.CALCITE_CLEAR_QUARTZ_GROWTH.get(), block -> this.createSingleItemTable(Blocks.CALCITE));
        dropSelf(MtaBlocks.QUARTZ_LAMP.get());
        this.add(MtaBlocks.NETHERITIC_CRYSTAL.get(), block -> this.createOreDrop(block, MtaItems.NETHERITE_FRACTURE.get()));

        this.add(MtaBlocks.AGATE_ORE.get(), block -> this.createOreDrop(block, MtaItems.AGATE.get()));
        this.add(MtaBlocks.DEEPSLATE_AGATE_ORE.get(), block -> this.createOreDrop(block, MtaItems.AGATE.get()));
        this.add(MtaBlocks.ALEXANDRITE_ORE.get(), block -> this.createOreDrop(block, MtaItems.ALEXANDRITE.get()));
        this.add(MtaBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(), block -> this.createOreDrop(block, MtaItems.ALEXANDRITE.get()));
        this.add(MtaBlocks.AQUAMARINE_ORE.get(), block -> this.createOreDrop(block, MtaItems.AQUAMARINE.get()));
        this.add(MtaBlocks.DEEPSLATE_AQUAMARINE_ORE.get(), block -> this.createOreDrop(block, MtaItems.AQUAMARINE.get()));
        this.add(MtaBlocks.CELESTITE_ORE.get(), block -> this.createOreDrop(block, MtaItems.CELESTITE.get()));
        this.add(MtaBlocks.DEEPSLATE_CELESTITE_ORE.get(), block -> this.createOreDrop(block, MtaItems.CELESTITE.get()));
        this.add(MtaBlocks.GARNET_ORE.get(), block -> this.createOreDrop(block, MtaItems.GARNET.get()));
        this.add(MtaBlocks.DEEPSLATE_GARNET_ORE.get(), block -> this.createOreDrop(block, MtaItems.GARNET.get()));
        this.add(MtaBlocks.MOONSTONE_ORE.get(), block -> this.createOreDrop(block, MtaItems.MOONSTONE.get()));
        this.add(MtaBlocks.DEEPSLATE_MOONSTONE_ORE.get(), block -> this.createOreDrop(block, MtaItems.MOONSTONE.get()));


        LootItemCondition.Builder onionCrop = LootItemBlockStatePropertyCondition.hasBlockStateProperties(MtaBlocks.ONION_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OnionCropBlock.AGE, 7));
        this.add(MtaBlocks.ONION_CROP.get(), this.createCropDrops(MtaBlocks.ONION_CROP.get(),
                MtaItems.ONION.get(), MtaItems.ONION.asItem(), onionCrop));

        LootItemCondition.Builder tomatoCrop = LootItemBlockStatePropertyCondition.hasBlockStateProperties(MtaBlocks.TOMATO_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OnionCropBlock.AGE, 7));
        this.add(MtaBlocks.TOMATO_CROP.get(), this.createCropDrops(MtaBlocks.ONION_CROP.get(),
                MtaItems.TOMATO.get(), MtaItems.TOMATO_SEEDS.asItem(), tomatoCrop));

        LootItemCondition.Builder bellPepperCrop = LootItemBlockStatePropertyCondition.hasBlockStateProperties(MtaBlocks.BELL_PEPPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OnionCropBlock.AGE, 7));
        this.add(MtaBlocks.BELL_PEPPER_CROP.get(), this.createCropDrops(MtaBlocks.BELL_PEPPER_CROP.get(),
                MtaItems.BELL_PEPPER.get(), MtaItems.BELL_PEPPER_SEEDS.asItem(), bellPepperCrop));

        LootItemCondition.Builder chillPepperCrop = LootItemBlockStatePropertyCondition.hasBlockStateProperties(MtaBlocks.CHILI_PEPPER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(OnionCropBlock.AGE, 7));
        this.add(MtaBlocks.CHILI_PEPPER_CROP.get(), this.createCropDrops(MtaBlocks.CHILI_PEPPER_CROP.get(),
                MtaItems.CHILI_PEPPER.get(), MtaItems.CHILI_PEPPER_SEEDS.asItem(), chillPepperCrop));

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> list = knownBlocks;
        list.remove(excludedBlocks);
        return list;
    }

    protected LootTable.Builder createPalmLeavesDrops(Block pLeavesBlock, Item pCoconut, float... pChances) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchOrShearsDispatchTable(
                        pLeavesBlock,
                        ((LootPoolSingletonContainer.Builder)this.applyExplosionCondition(pLeavesBlock, LootItem.lootTableItem(pCoconut)))
                                .when(BonusLevelTableCondition.bonusLevelFlatChance(registrylookup.getOrThrow(Enchantments.FORTUNE), pChances))
                );
    }

}
