package com.fuyuvulpes.morethanadventure.world.item;

import com.fuyuvulpes.morethanadventure.core.registry.MtaTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;

public class MTAToolTiers {
    public static final Tier COPPER = new SimpleTier(
            MtaTags.Blocks.INCORRECT_FOR_COPPER_TOOL,
            470,
            8f,
            1.5f,
            20,
            () -> Ingredient.of(Tags.Items.INGOTS_COPPER)
    );
    public static final Tier NETHERSTEEL = new SimpleTier(
            MtaTags.Blocks.INCORRECT_FOR_NETHERSTEEL_TOOL,
            870,
            7f,
            2.5f,
            16,
            () -> Ingredient.of(Tags.Items.INGOTS_COPPER)
    );




}
