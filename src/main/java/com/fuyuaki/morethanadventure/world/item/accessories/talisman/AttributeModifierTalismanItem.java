package com.fuyuaki.morethanadventure.world.item.accessories.talisman;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import com.fuyuaki.morethanadventure.world.item.accessories.TalismanItem;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import io.wispforest.accessories.api.AccessoriesCapability;
import io.wispforest.accessories.api.attributes.AccessoryAttributeBuilder;
import io.wispforest.accessories.api.components.AccessoryItemAttributeModifiers;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.Optional;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public abstract class AttributeModifierTalismanItem extends TalismanItem {
    public final ResourceLocation location;

    public AttributeModifierTalismanItem(Properties properties, String id) {
        super(properties);
        this.location = ResourceLocation.fromNamespaceAndPath(MODID,id);


    }

    @Override
    public void getStaticModifiers(Item item, AccessoryItemAttributeModifiers.Builder builder) {
        Multimap<Holder<Attribute>, AttributeModifier> map = talismanStaticModifiers(LinkedHashMultimap.create());
        if (map.isEmpty()) {
            map.forEach((attributeHolder, attributeModifier) -> builder.addForAny(attributeHolder, attributeModifier, false));
        }

        super.getStaticModifiers(item, builder);
    }

    @Override
    public void getDynamicModifiers(ItemStack stack, SlotReference reference, AccessoryAttributeBuilder builder) {
        Multimap<Holder<Attribute>, AttributeModifier> map = talismanDynamicModifiers(LinkedHashMultimap.create());
        if (map.isEmpty()) {
            map.forEach(builder::addExclusive);
        }


    }
    protected abstract Multimap<Holder<Attribute>, AttributeModifier> talismanStaticModifiers(Multimap<Holder<Attribute>, AttributeModifier> map);
    protected abstract Multimap<Holder<Attribute>, AttributeModifier> talismanDynamicModifiers(Multimap<Holder<Attribute>, AttributeModifier> map);


    public static boolean enableScubaGearEffects(LivingEntity player) {
        Optional<AccessoriesCapability> capability = AccessoriesCapability.getOptionally(player);
        return capability.filter(accessoriesCapability -> accessoriesCapability.isEquipped(MtaItems.SCUBA_GEAR.get()) && player.isInWater()).isPresent();

    }
}
