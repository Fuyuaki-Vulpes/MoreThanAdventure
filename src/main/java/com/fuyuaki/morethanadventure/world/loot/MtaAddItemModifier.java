package com.fuyuaki.morethanadventure.world.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

import java.util.function.Supplier;

public class MtaAddItemModifier extends LootModifier {
    public static final Supplier<MapCodec<MtaAddItemModifier>> CODEC = Suppliers.memoize(() ->
            RecordCodecBuilder.mapCodec(instance ->
                    instance.group(
                                    LOOT_CONDITIONS_CODEC.fieldOf("conditions").forGetter(lm -> lm.conditions),
                                    BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(lm -> lm.addedItem),
                                    Codec.intRange(0, Integer.MAX_VALUE).fieldOf("count").forGetter((lm) -> lm.count)
                            )

                            .apply(instance, MtaAddItemModifier::new)));

    private final Item addedItem;
    private final int count;

    public MtaAddItemModifier(LootItemCondition[] conditionsIn, Item addedItemIn, int count) {
        super(conditionsIn);
        this.addedItem = addedItemIn;
        this.count = count;
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        generatedLoot.add(new ItemStack(this.addedItem, this.count));
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC.get();
    }
}
