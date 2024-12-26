package com.fuyuaki.morethanadventure.world.item.curio.talisman;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class AttributeModifierTalismanItem extends TalismanItem{
    public final ResourceLocation location;

    public AttributeModifierTalismanItem(Properties properties, String id) {
        super(properties
                .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));
        this.location = ResourceLocation.fromNamespaceAndPath(MODID,id);

    }

//
//    @Override
//    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
//        Multimap<Holder<Attribute>, AttributeModifier> map = LinkedHashMultimap.create();
//        return this.talismanModifiers(map);
//    }

    protected Multimap<Holder<Attribute>, AttributeModifier> talismanModifiers(Multimap<Holder<Attribute>, AttributeModifier> map) {


        return map;
    }


    public static boolean enableScubaGearEffects(LivingEntity player) {
//        if (CuriosApi.getCuriosInventory(player).isEmpty())
//            return false;
//        ICuriosItemHandler handler = CuriosApi.getCuriosInventory(player).get();
//
//        return handler.isEquipped(MtaItems.SIREN_TALISMAN.get()) &&  player.isInWater();
        return false;
    }
}
