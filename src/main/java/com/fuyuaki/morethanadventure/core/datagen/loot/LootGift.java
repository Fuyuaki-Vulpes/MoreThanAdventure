package com.fuyuaki.morethanadventure.core.datagen.loot;

import com.fuyuaki.morethanadventure.core.registry.MTALootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.functions.SetPotionFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.BiConsumer;

public record LootGift(HolderLookup.Provider registries) implements LootTableSubProvider {
    @Override
    public void generate(BiConsumer<ResourceKey<LootTable>, LootTable.Builder> output) {
        output.accept(MTALootTables.ARROW_QUIVER_BONUS,
                LootTable.lootTable().withPool(
                        LootPool.lootPool().setRolls(UniformGenerator.between(3.0F,6.0F))
                                .add(LootItem.lootTableItem(Items.ARROW).setWeight(20)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F,2.0F))))
                                .add(LootItem.lootTableItem(Items.SPECTRAL_ARROW).setWeight(10)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F,1.0F))))
                                .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(5)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F,1.0F))))
                                        .apply(SetPotionFunction.setPotion(Potions.LONG_WEAKNESS))
                                .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(5)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F,1.0F))))
                                        .apply(SetPotionFunction.setPotion(Potions.HARMING))
                                .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(5)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F,1.0F))))
                                        .apply(SetPotionFunction.setPotion(Potions.LONG_POISON))
                                .add(LootItem.lootTableItem(Items.TIPPED_ARROW).setWeight(5)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(0.0F,1.0F))))
                                        .apply(SetPotionFunction.setPotion(Potions.LONG_SLOWNESS))

                )
                );

    }
}
