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
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pull"), (stack, level, entity, p_344166_) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration(entity) - entity.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(
                item,
                ResourceLocation.withDefaultNamespace("pulling"),
                (stack, level, entity, p_174633_) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0F : 0.0F
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
