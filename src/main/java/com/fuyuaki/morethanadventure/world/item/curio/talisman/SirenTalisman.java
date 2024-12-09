package com.fuyuaki.morethanadventure.world.item.curio.talisman;

import com.fuyuaki.morethanadventure.world.item.TalismanItem;
import com.google.common.collect.Multimap;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.neoforge.common.NeoForgeMod;

public class SirenTalisman extends TalismanItem {
    public SirenTalisman(Properties properties) {
        super(properties, "siren");
    }

    @Override
    protected Multimap<Holder<Attribute>, AttributeModifier> talismanModifiers(Multimap<Holder<Attribute>, AttributeModifier> map) {
        map.put(NeoForgeMod.SWIM_SPEED, new AttributeModifier(location, 2.5, AttributeModifier.Operation.ADD_VALUE));
        map.put(Attributes.SUBMERGED_MINING_SPEED, new AttributeModifier(location, 0.7, AttributeModifier.Operation.ADD_VALUE));
        map.put(Attributes.BURNING_TIME, new AttributeModifier(location, 1.7, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));


        return super.talismanModifiers(map);
    }
}
