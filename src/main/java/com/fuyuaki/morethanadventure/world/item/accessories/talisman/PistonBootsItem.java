package com.fuyuaki.morethanadventure.world.item.accessories.talisman;

import com.google.common.collect.Multimap;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Rarity;

public class PistonBootsItem extends AttributeModifierTalismanItem{
    public PistonBootsItem(Properties properties) {
        super(properties.rarity(Rarity.RARE), "piston_boots");
    }

    @Override
    protected Multimap<Holder<Attribute>, AttributeModifier> talismanStaticModifiers(Multimap<Holder<Attribute>, AttributeModifier> map) {
        return map;
    }

    @Override
    protected Multimap<Holder<Attribute>, AttributeModifier> talismanDynamicModifiers(Multimap<Holder<Attribute>, AttributeModifier> map) {
        map.put(Attributes.STEP_HEIGHT, new AttributeModifier(location, 0.75, AttributeModifier.Operation.ADD_VALUE));
        map.put(Attributes.JUMP_STRENGTH, new AttributeModifier(location, 1.7, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        map.put(Attributes.SAFE_FALL_DISTANCE, new AttributeModifier(location, 20.0, AttributeModifier.Operation.ADD_VALUE));
        return map;
    }
}
