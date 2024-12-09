package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.common.NeoForgeMod;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.SlotResult;
import top.theillusivec4.curios.api.type.capability.ICurioItem;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;
import top.theillusivec4.curios.common.CuriosHelper;

import java.util.Collections;
import java.util.List;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class TalismanItem extends Item implements ICurioItem{
    public final ResourceLocation location;

    public TalismanItem(Properties properties, String id) {
        super(properties.stacksTo(1).fireResistant().rarity(Rarity.EPIC)
                .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true));

        this.location = ResourceLocation.fromNamespaceAndPath(MODID,"id");
    }


    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return true;
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> map = LinkedHashMultimap.create();
        return this.talismanModifiers(map);
    }

    protected Multimap<Holder<Attribute>, AttributeModifier> talismanModifiers(Multimap<Holder<Attribute>, AttributeModifier> map) {


        return map;
    }


    public static boolean shouldRenderParts(TalismanItem item, LivingEntity player) {
        if (CuriosApi.getCuriosInventory(player).isEmpty())
            return false;
        ICuriosItemHandler handler = CuriosApi.getCuriosInventory(player).get();

        List<SlotResult> slotResults = handler.findCurios("talisman");

        return slotResults.stream().anyMatch(slot -> slot.stack().is(item));
    }
}
