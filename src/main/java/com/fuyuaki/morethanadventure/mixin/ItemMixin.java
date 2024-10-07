package com.fuyuaki.morethanadventure.mixin;


import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {

    @Unique
    private final Item thisItem = (Item)(Object)this;

    @Inject(method = "getUseDuration",at = @At("HEAD"), cancellable = true)
    private void useDurationMixin(ItemStack stack, LivingEntity entity, CallbackInfoReturnable<Integer> cir){
        FoodProperties foodproperties = stack.getFoodProperties(null);
        if (foodproperties != null){
            float eatTime;


            if (foodproperties == null) cir.setReturnValue(0);

            double mul =  foodproperties.eatSeconds() / 1.2;

            float satRatio = foodproperties.saturation() / foodproperties.nutrition();

            float mulNutrition = (float) foodproperties.nutrition() / 13;

            eatTime = (float)(foodproperties.eatSeconds() * mul * mulNutrition * satRatio);

            if (stack.is(Tags.Items.FOODS_SOUP)) eatTime *= 1.2F;
            if (stack.is(Tags.Items.FOODS_COOKED_MEAT)) eatTime *= 1.2F;
            if (stack.is(Tags.Items.FOODS_RAW_MEAT)) eatTime *= 4.9F;
            if (stack.is(Tags.Items.FOODS_FOOD_POISONING)) eatTime *= 1.3F;
            if (stack.is(Tags.Items.FOODS_GOLDEN)) eatTime *= 0.5F;

            if (eatTime < 0.8 && !(stack.is(Tags.Items.FOODS_BERRY) || stack.is(Tags.Items.FOODS_GOLDEN))) eatTime = 0.8F;
            else if (eatTime < 0.5) eatTime = 0.5F;

            if (stack.is(Items.POTION)) eatTime = 0.5F;

            cir.setReturnValue((int) (eatTime * 20));
        }
    }


}
