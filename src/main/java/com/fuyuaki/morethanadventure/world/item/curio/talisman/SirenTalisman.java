package com.fuyuaki.morethanadventure.world.item.curio.talisman;

import com.google.common.collect.Multimap;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.common.NeoForgeMod;

public class SirenTalisman extends AttributeModifierTalismanItem {
    public SirenTalisman(Properties properties) {
        super(properties.rarity(Rarity.EPIC), "siren");
    }

    @Override
    protected Multimap<Holder<Attribute>, AttributeModifier> talismanModifiers(Multimap<Holder<Attribute>, AttributeModifier> map) {
        map.put(NeoForgeMod.SWIM_SPEED, new AttributeModifier(location, 2.5, AttributeModifier.Operation.ADD_VALUE));
        map.put(Attributes.SUBMERGED_MINING_SPEED, new AttributeModifier(location, 0.7, AttributeModifier.Operation.ADD_VALUE));
        map.put(Attributes.BURNING_TIME, new AttributeModifier(location, 1.7, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));


        return super.talismanModifiers(map);
    }
}
