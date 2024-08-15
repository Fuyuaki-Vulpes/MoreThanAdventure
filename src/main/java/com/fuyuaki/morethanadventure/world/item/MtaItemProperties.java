package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class MtaItemProperties {
    public static void addCustomItemProperties() {

        makeCustomBow(MtaItems.NETHERITE_BOW.get());
        makeCustomBow(MtaItems.TEMPLE_ANGELS_BOW.get());
        makeCustomTrident(MtaItems.NETHERITE_TRIDENT.get());
        makeCustomTrident(MtaItems.MYSTIC_MERMAIDS_TRIDENT.get());
    }

    public static void makeCustomBow(Item item) {
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pull"), (p_344163_, p_344164_, p_344165_, p_344166_) -> {
            if (p_344165_ == null) {
                return 0.0F;
            } else {
                return p_344165_.getUseItem() != p_344163_ ? 0.0F : (float)(p_344163_.getUseDuration(p_344165_) - p_344165_.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(
                item,
                ResourceLocation.withDefaultNamespace("pulling"),
                (p_174630_, p_174631_, p_174632_, p_174633_) -> p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F
        );
    }

    public static void makeCustomTrident(Item item){
        ItemProperties.register(
                item,
                ResourceLocation.withDefaultNamespace("throwing"),
                (stack, level, entity, p_234999_) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F
        );
    }
}
