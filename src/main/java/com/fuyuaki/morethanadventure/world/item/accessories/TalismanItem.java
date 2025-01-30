package com.fuyuaki.morethanadventure.world.item.accessories;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import io.wispforest.accessories.api.AccessoriesCapability;
import io.wispforest.accessories.api.AccessoryItem;
import io.wispforest.accessories.api.client.AccessoriesRendererRegistry;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;
import java.util.Optional;

public class TalismanItem extends AccessoryItem {

    public TalismanItem(Properties properties) {
        super(properties.stacksTo(1).fireResistant());
        AccessoriesRendererRegistry.registerNoRenderer(this);

    }



    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if (tooltipFlag.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("mta.talisman.description." + BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath()).withStyle(ChatFormatting.GOLD));
        } else {
            tooltipComponents.add(Component.translatable("mta.talisman.description.hint").withStyle(ChatFormatting.GOLD).withStyle(ChatFormatting.BOLD));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    public static boolean isEquipped(LivingEntity living, Item item) {
        Optional<AccessoriesCapability> capability = AccessoriesCapability.getOptionally(living);
        return capability.map(accessoriesCapability -> accessoriesCapability.isEquipped(item)).orElse(false);
    }


}
