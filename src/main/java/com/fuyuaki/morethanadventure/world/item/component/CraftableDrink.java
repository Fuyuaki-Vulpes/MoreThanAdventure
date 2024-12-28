package com.fuyuaki.morethanadventure.world.item.component;

import com.fuyuaki.morethanadventure.world.item.FruitItem;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraft.ChatFormatting;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ARGB;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.BundleContents;
import net.minecraft.world.item.component.FireworkExplosion;
import net.minecraft.world.item.component.TooltipProvider;
import org.apache.commons.lang3.math.Fraction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public record CraftableDrink(List<ItemStack> fruits) implements TooltipProvider {
    public static final CraftableDrink EMPTY = new CraftableDrink(List.of());


    public static final Codec<CraftableDrink> CODEC = ItemStack.CODEC
            .listOf().comapFlatMap(CraftableDrink::checkAndCreate,craftableDrink -> DataResult.success(craftableDrink.fruits).getOrThrow());


    public static final StreamCodec<RegistryFriendlyByteBuf, CraftableDrink> STREAM_CODEC = ItemStack.STREAM_CODEC
            .apply(ByteBufCodecs.list())
            .map(CraftableDrink::new, craftableDrink -> craftableDrink.fruits);

    private static DataResult<CraftableDrink> checkAndCreate(List<ItemStack> fruits) {
            try {
                return DataResult.success(new CraftableDrink(fruits));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

    }
    @Override
    public int hashCode() {
        return ItemStack.hashStackList(this.fruits);
    }

    @Override
    public String toString() {
        return "Drink" + this.fruits;
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else {
            return other instanceof CraftableDrink craftableDrink && ItemStack.listMatches(this.fruits, craftableDrink.fruits);
        }
    }

    public int getColor(){
        int r = 0;
        int g = 0;
        int b = 0;
        int t = 0;

        for (ItemStack stack : this.fruits()){
            int c = 0;
            if (stack.getItem() instanceof FruitItem fruit){
                c = fruit.getColor();
            }
            else if (FruitItem.validVegetable(stack)){
                c = FruitItem.getColorByItem(stack);
            }
            if (c != 0){
                r += ARGB.red(c);
                r += ARGB.green(c);
                r += ARGB.blue(c);
                t++;
            }
        }

        return t == 0 ? 0xffffff : ARGB.color(r / t, g / t, b / t);
    }

    @Override
    public void addToTooltip(Item.TooltipContext context, Consumer<Component> tooltipAdder, TooltipFlag tooltipFlag) {
        for (ItemStack stack : this.fruits){
            if (FruitItem.validVegetable(stack)){
                tooltipAdder.accept(stack.getDisplayName().copy().withColor(FruitItem.getColorByItem(stack)));
            }
        }
    }
}
