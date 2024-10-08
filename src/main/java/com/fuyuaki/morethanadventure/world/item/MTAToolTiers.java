package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.Tags;

public class MTAToolTiers {
    public static final Tier AGATE = new SimpleTier(
            MtaTags.Blocks.INCORRECT_FOR_GEM_TOOL,
            12288,
            8f,
            3.5f,
            10,
            () -> Ingredient.of(MtaItems.AGATE)
    );

    public static final Tier ALEXANDRITE = new SimpleTier(
            MtaTags.Blocks.INCORRECT_FOR_GEM_TOOL,
            8192,
            13f,
            4.5f, 28,
            () -> Ingredient.of(MtaItems.ALEXANDRITE)
    );

    public static final Tier AQUAMARINE = new SimpleTier(
            MtaTags.Blocks.INCORRECT_FOR_GEM_TOOL,
            7108,
            14f,
            4f,
            19,
            () -> Ingredient.of(MtaItems.AQUAMARINE)
    );

    public static final Tier BLOODSTONE = new SimpleTier(
            MtaTags.Blocks.INCORRECT_FOR_GEM_TOOL,
            6446,
            17f,
            5f,
            19,
            () -> Ingredient.of(MtaItems.BLOODSTONE)
    );

    public static final Tier CELESTITE = new SimpleTier(
            MtaTags.Blocks.INCORRECT_FOR_GEM_TOOL,
            6760,
            15f,
            3.5f,
            20,
            () -> Ingredient.of(MtaItems.CELESTITE)
    );

    public static final Tier CRYOLITE = new SimpleTier(
            MtaTags.Blocks.INCORRECT_FOR_GEM_TOOL,
            6760,
            15f,
            3.5f,
            20,
            () -> Ingredient.of(MtaItems.CRYOLITE)
    );

    public static final Tier GARNET = new SimpleTier(
            MtaTags.Blocks.INCORRECT_FOR_GEM_TOOL,
            5736,
            19f,
            6f,
            17,
            () -> Ingredient.of(MtaItems.GARNET)
    );

    public static final Tier MOONSTONE = new SimpleTier(
            MtaTags.Blocks.INCORRECT_FOR_GEM_TOOL,
            5144,
            24f,
            1.5f,
            25,
            () -> Ingredient.of(MtaItems.MOONSTONE)
    );
    public static final Tier NETHERSTEEL = new SimpleTier(
            MtaTags.Blocks.INCORRECT_FOR_NETHERSTEEL_TOOL,
            870,
            7.5f,
            2.5f,
            16,
            () -> Ingredient.of(Tags.Items.INGOTS_COPPER)
    );

    public static final Tier COPPER = new SimpleTier(
            MtaTags.Blocks.INCORRECT_FOR_COPPER_TOOL,
            140,
            7.5f,
            1.0f,
            22,
            () -> Ingredient.of(Tags.Items.INGOTS_COPPER)
    );




}
