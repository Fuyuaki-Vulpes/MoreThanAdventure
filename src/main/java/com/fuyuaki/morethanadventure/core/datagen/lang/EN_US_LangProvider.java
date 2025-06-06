package com.fuyuaki.morethanadventure.core.datagen.lang;

import com.fuyuaki.morethanadventure.core.deferred_registries.*;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.neoforged.neoforge.registries.DeferredItem;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class EN_US_LangProvider extends LanguageProvider {
    public EN_US_LangProvider(PackOutput output) {
        super(output, MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        //BLOCKS


        add(MtaItems.PRICKLY_PEAR_PAD.get(),"Prickly Pear Pad");
        add(MtaBlocks.PRICKLY_PEAR.get(),"Prickly Pear");
        add(MtaBlocks.POTTED_PRICKLY_PEAR.get(),"Potted Prickly Pear");

        add(MtaBlocks.ALPINE_LOG.get(),"Alpine Log");
        add(MtaBlocks.STRIPPED_ALPINE_LOG.get(),"Stripped Alpine Log");
        add(MtaBlocks.ALPINE_WOOD.get(),"Alpine Wood");
        add(MtaBlocks.STRIPPED_ALPINE_WOOD.get(),"Stripped Alpine Wood");
        add(MtaBlocks.ALPINE_PLANKS.get(),"Alpine Planks");
        add(MtaBlocks.ALPINE_LEAVES.get(),"Alpine Leaves");
        add(MtaBlocks.ALPINE_SAPLING.get(),"Alpine Sapling");
        add(MtaBlocks.ALPINE_STAIRS.get(),"Alpine Stairs");
        add(MtaBlocks.ALPINE_SLAB.get(),"Alpine Slab");
        add(MtaBlocks.ALPINE_PRESSURE_PLATE.get(),"Alpine Pressure Plate");
        add(MtaBlocks.ALPINE_BUTTON.get(),"Alpine Button");
        add(MtaBlocks.ALPINE_FENCE.get(),"Alpine Fence");
        add(MtaBlocks.ALPINE_FENCE_GATE.get(),"Alpine Fence Gate");
        add(MtaBlocks.ALPINE_DOOR.get(),"Alpine Door");
        add(MtaBlocks.ALPINE_TRAPDOOR.get(),"Alpine Trapdoor");
        add(MtaBlocks.ALPINE_SIGN.get(),"Alpine Sign");
        add(MtaBlocks.ALPINE_WALL_SIGN.get(),"Alpine Wall Sign");
        add(MtaBlocks.ALPINE_HANGING_SIGN.get(), "Alpine Hanging Sign");
        add(MtaBlocks.ALPINE_HANGING_WALL_SIGN.get(), "Alpine Hanging Wall Sign");
        add(MtaBlocks.POTTED_ALPINE_SAPLING.get(),"Potted Alpine Sapling");


        add(MtaBlocks.AVOCADO_LOG.get(),"Avocado Log");
        add(MtaBlocks.STRIPPED_AVOCADO_LOG.get(),"Stripped Avocado Log");
        add(MtaBlocks.AVOCADO_WOOD.get(),"Avocado Wood");
        add(MtaBlocks.STRIPPED_AVOCADO_WOOD.get(),"Stripped Avocado Wood");
        add(MtaBlocks.AVOCADO_PLANKS.get(),"Avocado Planks");
        add(MtaBlocks.AVOCADO_LEAVES.get(),"Avocado Leaves");
        add(MtaBlocks.AVOCADO_SAPLING.get(),"Avocado Sapling");
        add(MtaBlocks.AVOCADO_STAIRS.get(),"Avocado Stairs");
        add(MtaBlocks.AVOCADO_SLAB.get(),"Avocado Slab");
        add(MtaBlocks.AVOCADO_PRESSURE_PLATE.get(),"Avocado Pressure Plate");
        add(MtaBlocks.AVOCADO_BUTTON.get(),"Avocado Button");
        add(MtaBlocks.AVOCADO_FENCE.get(),"Avocado Fence");
        add(MtaBlocks.AVOCADO_FENCE_GATE.get(),"Avocado Fence Gate");
        add(MtaBlocks.AVOCADO_DOOR.get(),"Avocado Door");
        add(MtaBlocks.AVOCADO_TRAPDOOR.get(),"Avocado Trapdoor");
        add(MtaBlocks.AVOCADO_SIGN.get(),"Avocado Sign");
        add(MtaBlocks.AVOCADO_WALL_SIGN.get(),"Avocado Wall Sign");
        add(MtaBlocks.AVOCADO_HANGING_SIGN.get(), "Avocado Hanging Sign");
        add(MtaBlocks.AVOCADO_HANGING_WALL_SIGN.get(), "Avocado Hanging Wall Sign");
        add(MtaBlocks.POTTED_AVOCADO_SAPLING.get(),"Potted Avocado Sapling");


        add(MtaBlocks.BOGGED_OAK_LOG.get(),"Bogged Oak Log");
        add(MtaBlocks.STRIPPED_BOGGED_OAK_LOG.get(),"Stripped Bogged Oak Log");
        add(MtaBlocks.BOGGED_OAK_WOOD.get(),"Bogged Oak Wood");
        add(MtaBlocks.STRIPPED_BOGGED_OAK_WOOD.get(),"Stripped Bogged Oak Wood");
        add(MtaBlocks.BOGGED_OAK_PLANKS.get(),"Bogged Oak Planks");
        add(MtaBlocks.BOGGED_OAK_STAIRS.get(),"Bogged Oak Stairs");
        add(MtaBlocks.BOGGED_OAK_SLAB.get(),"Bogged Oak Slab");
        add(MtaBlocks.BOGGED_OAK_PRESSURE_PLATE.get(),"Bogged Oak Pressure Plate");
        add(MtaBlocks.BOGGED_OAK_BUTTON.get(),"Bogged Oak Button");
        add(MtaBlocks.BOGGED_OAK_FENCE.get(),"Bogged Oak Fence");
        add(MtaBlocks.BOGGED_OAK_FENCE_GATE.get(),"Bogged Oak Fence Gate");
        add(MtaBlocks.BOGGED_OAK_DOOR.get(),"Bogged Oak Door");
        add(MtaBlocks.BOGGED_OAK_TRAPDOOR.get(),"Bogged Oak Trapdoor");
        add(MtaBlocks.BOGGED_OAK_SIGN.get(),"Bogged Oak Sign");
        add(MtaBlocks.BOGGED_OAK_WALL_SIGN.get(),"Bogged Oak Wall Sign");
        add(MtaBlocks.BOGGED_OAK_HANGING_SIGN.get(), "Bogged Oak Hanging Sign");
        add(MtaBlocks.BOGGED_OAK_HANGING_WALL_SIGN.get(), "Bogged Oak Hanging Wall Sign");


        add(MtaBlocks.IPE_LOG.get(),"Ipe Log");
        add(MtaBlocks.STRIPPED_IPE_LOG.get(),"Stripped Ipe Log");
        add(MtaBlocks.IPE_WOOD.get(),"Ipe Wood");
        add(MtaBlocks.STRIPPED_IPE_WOOD.get(),"Stripped Ipe Wood");
        add(MtaBlocks.IPE_PLANKS.get(),"Ipe Planks");
        add(MtaBlocks.PINK_IPE_LEAVES.get(),"Pink Ipe Leaves");
        add(MtaBlocks.PURPLE_IPE_LEAVES.get(),"Purple Ipe Leaves");
        add(MtaBlocks.WHITE_IPE_LEAVES.get(),"White Ipe Leaves");
        add(MtaBlocks.YELLOW_IPE_LEAVES.get(),"Yellow Ipe Leaves");
        add(MtaBlocks.PINK_IPE_SAPLING.get(),"Pink Ipe Sapling");
        add(MtaBlocks.PURPLE_IPE_SAPLING.get(),"Purple Ipe Sapling");
        add(MtaBlocks.WHITE_IPE_SAPLING.get(),"White Ipe Sapling");
        add(MtaBlocks.YELLOW_IPE_SAPLING.get(),"Yellow Ipe Sapling");
        add(MtaBlocks.IPE_STAIRS.get(),"Ipe Stairs");
        add(MtaBlocks.IPE_SLAB.get(),"Ipe Slab");
        add(MtaBlocks.IPE_PRESSURE_PLATE.get(),"Ipe Pressure Plate");
        add(MtaBlocks.IPE_BUTTON.get(),"Ipe Button");
        add(MtaBlocks.IPE_FENCE.get(),"Ipe Fence");
        add(MtaBlocks.IPE_FENCE_GATE.get(),"Ipe Fence Gate");
        add(MtaBlocks.IPE_DOOR.get(),"Ipe Door");
        add(MtaBlocks.IPE_TRAPDOOR.get(),"Ipe Trapdoor");
        add(MtaBlocks.IPE_SIGN.get(),"Ipe Sign");
        add(MtaBlocks.IPE_WALL_SIGN.get(),"Ipe Wall Sign");
        add(MtaBlocks.IPE_HANGING_SIGN.get(), "Ipe Hanging Sign");
        add(MtaBlocks.IPE_HANGING_WALL_SIGN.get(), "Ipe Hanging Wall Sign");
        add(MtaBlocks.POTTED_PINK_IPE_SAPLING.get(),"Pink Ipe Sapling");
        add(MtaBlocks.POTTED_PURPLE_IPE_SAPLING.get(),"Purple Ipe Sapling");
        add(MtaBlocks.POTTED_WHITE_IPE_SAPLING.get(),"White Ipe Sapling");
        add(MtaBlocks.POTTED_YELLOW_IPE_SAPLING.get(),"Yellow Ipe Sapling");


        add(MtaBlocks.MANGO_LOG.get(),"Mango Log");
        add(MtaBlocks.STRIPPED_MANGO_LOG.get(),"Stripped Mango Log");
        add(MtaBlocks.MANGO_WOOD.get(),"Mango Wood");
        add(MtaBlocks.STRIPPED_MANGO_WOOD.get(),"Stripped Mango Wood");
        add(MtaBlocks.MANGO_PLANKS.get(),"Mango Planks");
        add(MtaBlocks.MANGO_LEAVES.get(),"Mango Leaves");
        add(MtaBlocks.MANGO_SAPLING.get(),"Mango Sapling");
        add(MtaBlocks.MANGO_STAIRS.get(),"Mango Stairs");
        add(MtaBlocks.MANGO_SLAB.get(),"Mango Slab");
        add(MtaBlocks.MANGO_PRESSURE_PLATE.get(),"Mango Pressure Plate");
        add(MtaBlocks.MANGO_BUTTON.get(),"Mango Button");
        add(MtaBlocks.MANGO_FENCE.get(),"Mango Fence");
        add(MtaBlocks.MANGO_FENCE_GATE.get(),"Mango Fence Gate");
        add(MtaBlocks.MANGO_DOOR.get(),"Mango Door");
        add(MtaBlocks.MANGO_TRAPDOOR.get(),"Mango Trapdoor");
        add(MtaBlocks.MANGO_SIGN.get(),"Mango Sign");
        add(MtaBlocks.MANGO_WALL_SIGN.get(),"Mango Wall Sign");
        add(MtaBlocks.MANGO_HANGING_SIGN.get(), "Mango Hanging Sign");
        add(MtaBlocks.MANGO_HANGING_WALL_SIGN.get(), "Mango Hanging Wall Sign");
        add(MtaBlocks.POTTED_MANGO_SAPLING.get(),"Potted Mango Sapling");


        add(MtaBlocks.MAPLE_LOG.get(),"Maple Log");
        add(MtaBlocks.STRIPPED_MAPLE_LOG.get(),"Stripped Maple Log");
        add(MtaBlocks.MAPLE_WOOD.get(),"Maple Wood");
        add(MtaBlocks.STRIPPED_MAPLE_WOOD.get(),"Stripped Maple Wood");
        add(MtaBlocks.MAPLE_PLANKS.get(),"Maple Planks");
        add(MtaBlocks.MAPLE_LEAVES.get(),"Maple Leaves");
        add(MtaBlocks.MAPLE_SAPLING.get(),"Maple Sapling");
        add(MtaBlocks.MAPLE_STAIRS.get(),"Maple Stairs");
        add(MtaBlocks.MAPLE_SLAB.get(),"Maple Slab");
        add(MtaBlocks.MAPLE_PRESSURE_PLATE.get(),"Maple Pressure Plate");
        add(MtaBlocks.MAPLE_BUTTON.get(),"Maple Button");
        add(MtaBlocks.MAPLE_FENCE.get(),"Maple Fence");
        add(MtaBlocks.MAPLE_FENCE_GATE.get(),"Maple Fence Gate");
        add(MtaBlocks.MAPLE_DOOR.get(),"Maple Door");
        add(MtaBlocks.MAPLE_TRAPDOOR.get(),"Maple Trapdoor");
        add(MtaBlocks.MAPLE_SIGN.get(),"Maple Sign");
        add(MtaBlocks.MAPLE_WALL_SIGN.get(),"Maple Wall Sign");
        add(MtaBlocks.MAPLE_HANGING_SIGN.get(), "Maple Hanging Sign");
        add(MtaBlocks.MAPLE_HANGING_WALL_SIGN.get(), "Maple Hanging Wall Sign");
        add(MtaBlocks.POTTED_MAPLE_SAPLING.get(),"Potted Maple Sapling");


        add(MtaBlocks.PALM_LOG.get(),"Palm Log");
        add(MtaBlocks.STRIPPED_PALM_LOG.get(),"Stripped Palm Log");
        add(MtaBlocks.PALM_WOOD.get(),"Palm Wood");
        add(MtaBlocks.STRIPPED_PALM_WOOD.get(),"Stripped Palm Wood");
        add(MtaBlocks.PALM_PLANKS.get(),"Palm Planks");
        add(MtaBlocks.PALM_LEAVES.get(),"Palm Leaves");
        add(MtaBlocks.PALM_SAPLING.get(),"Palm Sapling");
        add(MtaBlocks.PALM_STAIRS.get(),"Palm Stairs");
        add(MtaBlocks.PALM_SLAB.get(),"Palm Slab");
        add(MtaBlocks.PALM_PRESSURE_PLATE.get(),"Palm Pressure Plate");
        add(MtaBlocks.PALM_BUTTON.get(),"Palm Button");
        add(MtaBlocks.PALM_FENCE.get(),"Palm Fence");
        add(MtaBlocks.PALM_FENCE_GATE.get(),"Palm Fence Gate");
        add(MtaBlocks.PALM_DOOR.get(),"Palm Door");
        add(MtaBlocks.PALM_TRAPDOOR.get(),"Palm Trapdoor");
        add(MtaBlocks.PALM_SIGN.get(),"Palm Sign");
        add(MtaBlocks.PALM_WALL_SIGN.get(),"Palm Wall Sign");
        add(MtaBlocks.PALM_HANGING_SIGN.get(), "Palm Hanging Sign");
        add(MtaBlocks.PALM_HANGING_WALL_SIGN.get(), "Palm Hanging Wall Sign");
        add(MtaBlocks.POTTED_PALM_SAPLING.get(),"Potted Palm Sapling");


        add(MtaBlocks.SEALOG.get(),"SeaLog");
        add(MtaBlocks.SEAWOOD.get(),"Seawood");
        add(MtaBlocks.SEAWOOD_PLANKS.get(),"Seawood Planks");
        add(MtaBlocks.SEAWOOD_LEAVES.get(),"Seawood Leaves");
        add(MtaBlocks.SEAWOOD_SAPLING.get(),"Seawood Sapling");
        add(MtaBlocks.SEAWOOD_STAIRS.get(),"Seawood Stairs");
        add(MtaBlocks.SEAWOOD_SLAB.get(),"Seawood Slab");
        add(MtaBlocks.SEAWOOD_PRESSURE_PLATE.get(),"Seawood Pressure Plate");
        add(MtaBlocks.SEAWOOD_BUTTON.get(),"Seawood Button");
        add(MtaBlocks.SEAWOOD_FENCE.get(),"Seawood Fence");
        add(MtaBlocks.SEAWOOD_FENCE_GATE.get(),"Seawood Fence Gate");
        add(MtaBlocks.SEAWOOD_DOOR.get(),"Seawood Door");
        add(MtaBlocks.SEAWOOD_TRAPDOOR.get(),"Seawood Trapdoor");
        add(MtaBlocks.SEAWOOD_SIGN.get(),"Seawood Sign");
        add(MtaBlocks.SEAWOOD_WALL_SIGN.get(),"Seawood Wall Sign");
        add(MtaBlocks.SEAWOOD_HANGING_SIGN.get(), "Seawood Hanging Sign");
        add(MtaBlocks.SEAWOOD_HANGING_WALL_SIGN.get(), "Seawood Hanging Wall Sign");
        add(MtaBlocks.POTTED_SEAWOOD_SAPLING.get(),"Potted Seawood Sapling");


        add(MtaBlocks.SPRINKLER.get(),"Sprinkler");
        add(MtaBlocks.SPRINKLER.asItem(),"Sprinkler");
        add(MtaBlocks.STOVE.get(),"Stove");
        add(MtaBlocks.STONE_GEYSER.get(),"Stone Geyser");
        add(MtaBlocks.TERRACOTTA_GEYSER.get(),"Terracotta Geyser");
        add(MtaBlocks.NETHERRACK_GEYSER.get(),"Netherrack Geyser");
        add(MtaBlocks.BASALT_GEYSER.get(),"Basalt Geyser");
        add(MtaBlocks.MOSSY_ANDESITE.get(),"Mossy Andesite");
        add(MtaBlocks.SAND_PATH.get(),"Sand Path");
        add(MtaBlocks.GRASSY_DIRT.get(),"Grassy Dirt");
        add(MtaBlocks.GRASSY_SAND.get(),"Grassy Sand");
        add(MtaBlocks.PERMAFROST_DIRT.get(),"Permafrost Dirt");
        add(MtaBlocks.SHALLOW_GRASS.get(),"Shallow Grass");
        add(MtaBlocks.SAND_GRASS.get(),"Sand Grass");
        add(MtaBlocks.BEACHGRASS.get(),"Beach-grass");
        add(MtaBlocks.PERMAFROST_STONE.get(),"Permafrost Stone");
        add(MtaBlocks.POLAR_SAND.get(),"Polar Sand");
        add(MtaBlocks.PERMAFROST_GRASS.get(),"Permafrost Grass");
        add(MtaBlocks.TUNDRA_GRASS.get(),"Tundra Grass");
        add(MtaBlocks.COBBLED_DIRT.get(),"Cobbled Dirt");
        add(MtaBlocks.STONE_TILES.get(), "Stone Tiles");
        add(MtaBlocks.STONE_TILES_SLAB.get(),"Stone Tiles Slab");
        add(MtaBlocks.STONE_TILES_STAIRS.get(),"Stone Tiles Stairs");
        add(MtaBlocks.STONE_TILES_WALL.get(),"Stone Tiles Wall");
        add(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES.get(),"Slightly Dirty Stone Tiles");
        add(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_SLAB.get(),"Slightly Dirty Stone Tiles Slab");
        add(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_STAIRS.get(),"Slightly Dirty Stone Tiles Stairs");
        add(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_WALL.get(),"Slightly Dirty Stone Tiles Wall");
        add(MtaBlocks.DIRTY_STONE_TILES.get(),"Dirty Stone Tiles");
        add(MtaBlocks.DIRTY_STONE_TILES_SLAB.get(),"Dirty Stone Tiles Slab");
        add(MtaBlocks.DIRTY_STONE_TILES_STAIRS.get(),"Dirty Stone Tiles Stairs");
        add(MtaBlocks.DIRTY_STONE_TILES_WALL.get(),"Dirty Stone Tiles wall");
        add(MtaBlocks.VERY_DIRTY_STONE_TILES.get(),"Very Dirty Stone Tiles");
        add(MtaBlocks.VERY_DIRTY_STONE_TILES_SLAB.get(),"Very Dirty Stone Tiles Slab");
        add(MtaBlocks.VERY_DIRTY_STONE_TILES_STAIRS.get(),"Very Dirty Stone Tiles Stairs");
        add(MtaBlocks.VERY_DIRTY_STONE_TILES_WALL.get(),"Very Dirty Stone Tiles Wall");

        add(MtaBlocks.SCATTERED_LEAVES.get(),"Scattered Leaves");
        add(MtaBlocks.CATTAIL.get(),"Cattail");
//        add(MtaBlocks.CORPSE_FLOWER.get(),"Corpse Lily");
//        add(MtaBlocks.PITCHER_PLANT.get(),"Pitcher Plant");
//        add(MtaBlocks.POTTED_PITCHER_PLANT.get(),"Potted Pitcher Plant");
//        add(MtaBlocks.VENUS_FLYTRAP.get(),"Venus Flytrap");

        add(MtaBlocks.TERRACOTTA_TILES.get(),"Terracotta Tiles");
        add(MtaBlocks.TERRACOTTA_SLAB.get(),"Terracotta Slab");
        add(MtaBlocks.TERRACOTTA_TILES_SLAB.get(),"Terracotta Tiles Slab");
        add(MtaBlocks.TERRACOTTA_STAIRS.get(),"Terracotta Stairs");
        add(MtaBlocks.TERRACOTTA_TILES_STAIRS.get(),"Terracotta Tiles Stairs");
        add(MtaBlocks.TERRACOTTA_WALL.get(),"Terracotta Wall");
        add(MtaBlocks.TERRACOTTA_TILES_WALL.get(),"Terracotta Tiles Wall");

        add(MtaBlocks.WHITE_TERRACOTTA_TILES.get(),"White Terracotta Tiles");
        add(MtaBlocks.WHITE_TERRACOTTA_SLAB.get(),"White Terracotta Slab");
        add(MtaBlocks.WHITE_TERRACOTTA_TILES_SLAB.get(),"White Terracotta Tiles Slab");
        add(MtaBlocks.WHITE_TERRACOTTA_STAIRS.get(),"White Terracotta Stairs");
        add(MtaBlocks.WHITE_TERRACOTTA_TILES_STAIRS.get(),"White Terracotta Tiles Stairs");
        add(MtaBlocks.WHITE_TERRACOTTA_WALL.get(),"White Terracotta Wall");
        add(MtaBlocks.WHITE_TERRACOTTA_TILES_WALL.get(),"White Terracotta Tiles Wall");

        add(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES.get(),"Light Gray Terracotta Tiles");
        add(MtaBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get(),"Light Gray Terracotta Slab");
        add(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_SLAB.get(),"Light Gray Terracotta Tiles Slab");
        add(MtaBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get(),"Light Gray Terracotta Stairs");
        add(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_STAIRS.get(),"Light Gray Terracotta Tiles Stairs");
        add(MtaBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get(),"Light Gray Terracotta Wall");
        add(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES_WALL.get(),"Light Gray Terracotta Tiles Wall");

        add(MtaBlocks.GRAY_TERRACOTTA_TILES.get(),"Gray Terracotta Tiles");
        add(MtaBlocks.GRAY_TERRACOTTA_SLAB.get(),"Gray Terracotta Slab");
        add(MtaBlocks.GRAY_TERRACOTTA_TILES_SLAB.get(),"Gray Terracotta Tiles Slab");
        add(MtaBlocks.GRAY_TERRACOTTA_STAIRS.get(),"Gray Terracotta Stairs");
        add(MtaBlocks.GRAY_TERRACOTTA_TILES_STAIRS.get(),"Gray Terracotta Tiles Stairs");
        add(MtaBlocks.GRAY_TERRACOTTA_WALL.get(),"Gray Terracotta Wall");
        add(MtaBlocks.GRAY_TERRACOTTA_TILES_WALL.get(),"Gray Terracotta Tiles Wall");

        add(MtaBlocks.BLACK_TERRACOTTA_TILES.get(),"Black Terracotta Tiles");
        add(MtaBlocks.BLACK_TERRACOTTA_SLAB.get(),"Black Terracotta Slab");
        add(MtaBlocks.BLACK_TERRACOTTA_TILES_SLAB.get(),"Black Terracotta Tiles Slab");
        add(MtaBlocks.BLACK_TERRACOTTA_STAIRS.get(),"Black Terracotta Stairs");
        add(MtaBlocks.BLACK_TERRACOTTA_TILES_STAIRS.get(),"Black Terracotta Tiles Stairs");
        add(MtaBlocks.BLACK_TERRACOTTA_WALL.get(),"Black Terracotta Wall");
        add(MtaBlocks.BLACK_TERRACOTTA_TILES_WALL.get(),"Black Terracotta Tiles Wall");

        add(MtaBlocks.BROWN_TERRACOTTA_TILES.get(),"Brown Terracotta Tiles");
        add(MtaBlocks.BROWN_TERRACOTTA_SLAB.get(),"Brown Terracotta Slab");
        add(MtaBlocks.BROWN_TERRACOTTA_TILES_SLAB.get(),"Brown Terracotta Tiles Slab");
        add(MtaBlocks.BROWN_TERRACOTTA_STAIRS.get(),"Brown Terracotta Stairs");
        add(MtaBlocks.BROWN_TERRACOTTA_TILES_STAIRS.get(),"Brown Terracotta Tiles Stairs");
        add(MtaBlocks.BROWN_TERRACOTTA_WALL.get(),"Brown Terracotta Wall");
        add(MtaBlocks.BROWN_TERRACOTTA_TILES_WALL.get(),"Brown Terracotta Tiles Wall");

        add(MtaBlocks.RED_TERRACOTTA_TILES.get(),"Red Terracotta Tiles");
        add(MtaBlocks.RED_TERRACOTTA_SLAB.get(),"Red Terracotta Slab");
        add(MtaBlocks.RED_TERRACOTTA_TILES_SLAB.get(),"Red Terracotta Tiles Slab");
        add(MtaBlocks.RED_TERRACOTTA_STAIRS.get(),"Red Terracotta Stairs");
        add(MtaBlocks.RED_TERRACOTTA_TILES_STAIRS.get(),"Red Terracotta Tiles Stairs");
        add(MtaBlocks.RED_TERRACOTTA_WALL.get(),"Red Terracotta Wall");
        add(MtaBlocks.RED_TERRACOTTA_TILES_WALL.get(),"Red Terracotta Tiles Wall");

        add(MtaBlocks.ORANGE_TERRACOTTA_TILES.get(),"Orange Terracotta Tiles");
        add(MtaBlocks.ORANGE_TERRACOTTA_SLAB.get(),"Orange Terracotta Slab");
        add(MtaBlocks.ORANGE_TERRACOTTA_TILES_SLAB.get(),"Orange Terracotta Tiles Slab");
        add(MtaBlocks.ORANGE_TERRACOTTA_STAIRS.get(),"Orange Terracotta Stairs");
        add(MtaBlocks.ORANGE_TERRACOTTA_TILES_STAIRS.get(),"Orange Terracotta Tiles Stairs");
        add(MtaBlocks.ORANGE_TERRACOTTA_WALL.get(),"Orange Terracotta Wall");
        add(MtaBlocks.ORANGE_TERRACOTTA_TILES_WALL.get(),"Orange Terracotta Tiles Wall");

        add(MtaBlocks.YELLOW_TERRACOTTA_TILES.get(),"Yellow Terracotta Tiles");
        add(MtaBlocks.YELLOW_TERRACOTTA_SLAB.get(),"Yellow Terracotta Slab");
        add(MtaBlocks.YELLOW_TERRACOTTA_TILES_SLAB.get(),"Yellow Terracotta Tiles Slab");
        add(MtaBlocks.YELLOW_TERRACOTTA_STAIRS.get(),"Yellow Terracotta Stairs");
        add(MtaBlocks.YELLOW_TERRACOTTA_TILES_STAIRS.get(),"Yellow Terracotta Tiles Stairs");
        add(MtaBlocks.YELLOW_TERRACOTTA_WALL.get(),"Yellow Terracotta Wall");
        add(MtaBlocks.YELLOW_TERRACOTTA_TILES_WALL.get(),"Yellow Terracotta Tiles Wall");

        add(MtaBlocks.LIME_TERRACOTTA_TILES.get(),"Lime Terracotta Tiles");
        add(MtaBlocks.LIME_TERRACOTTA_SLAB.get(),"Lime Terracotta Slab");
        add(MtaBlocks.LIME_TERRACOTTA_TILES_SLAB.get(),"Lime Terracotta Tiles Slab");
        add(MtaBlocks.LIME_TERRACOTTA_STAIRS.get(),"Lime Terracotta Stairs");
        add(MtaBlocks.LIME_TERRACOTTA_TILES_STAIRS.get(),"Lime Terracotta Tiles Stairs");
        add(MtaBlocks.LIME_TERRACOTTA_WALL.get(),"Lime Terracotta Wall");
        add(MtaBlocks.LIME_TERRACOTTA_TILES_WALL.get(),"Lime Terracotta Tiles Wall");

        add(MtaBlocks.GREEN_TERRACOTTA_TILES.get(),"Green Terracotta Tiles");
        add(MtaBlocks.GREEN_TERRACOTTA_SLAB.get(),"Green Terracotta Slab");
        add(MtaBlocks.GREEN_TERRACOTTA_TILES_SLAB.get(),"Green Terracotta Tiles Slab");
        add(MtaBlocks.GREEN_TERRACOTTA_STAIRS.get(),"Green Terracotta Stairs");
        add(MtaBlocks.GREEN_TERRACOTTA_TILES_STAIRS.get(),"Green Terracotta Tiles Stairs");
        add(MtaBlocks.GREEN_TERRACOTTA_WALL.get(),"Green Terracotta Wall");
        add(MtaBlocks.GREEN_TERRACOTTA_TILES_WALL.get(),"Green Terracotta Tiles Wall");

        add(MtaBlocks.CYAN_TERRACOTTA_TILES.get(),"Cyan Terracotta Tiles");
        add(MtaBlocks.CYAN_TERRACOTTA_SLAB.get(),"Cyan Terracotta Slab");
        add(MtaBlocks.CYAN_TERRACOTTA_TILES_SLAB.get(),"Cyan Terracotta Tiles Slab");
        add(MtaBlocks.CYAN_TERRACOTTA_STAIRS.get(),"Cyan Terracotta Stairs");
        add(MtaBlocks.CYAN_TERRACOTTA_TILES_STAIRS.get(),"Cyan Terracotta Tiles Stairs");
        add(MtaBlocks.CYAN_TERRACOTTA_WALL.get(),"Cyan Terracotta Wall");
        add(MtaBlocks.CYAN_TERRACOTTA_TILES_WALL.get(),"Cyan Terracotta Tiles Wall");

        add(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES.get(),"Light Blue Terracotta Tiles");
        add(MtaBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get(),"Light Blue Terracotta Slab");
        add(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_SLAB.get(),"Light Blue Terracotta Tiles Slab");
        add(MtaBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get(),"Light Blue Terracotta Stairs");
        add(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_STAIRS.get(),"Light Blue Terracotta Tiles Stairs");
        add(MtaBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get(),"Light Blue Terracotta Wall");
        add(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES_WALL.get(),"Light Blue Terracotta Tiles Wall");

        add(MtaBlocks.BLUE_TERRACOTTA_TILES.get(),"Blue Terracotta Tiles");
        add(MtaBlocks.BLUE_TERRACOTTA_SLAB.get(),"Blue Terracotta Slab");
        add(MtaBlocks.BLUE_TERRACOTTA_TILES_SLAB.get(),"Blue Terracotta Tiles Slab");
        add(MtaBlocks.BLUE_TERRACOTTA_STAIRS.get(),"Blue Terracotta Stairs");
        add(MtaBlocks.BLUE_TERRACOTTA_TILES_STAIRS.get(),"Blue Terracotta Tiles Stairs");
        add(MtaBlocks.BLUE_TERRACOTTA_WALL.get(),"Blue Terracotta Wall");
        add(MtaBlocks.BLUE_TERRACOTTA_TILES_WALL.get(),"Blue Terracotta Tiles Wall");

        add(MtaBlocks.PURPLE_TERRACOTTA_TILES.get(),"Purple Terracotta Tiles");
        add(MtaBlocks.PURPLE_TERRACOTTA_SLAB.get(),"Purple Terracotta Slab");
        add(MtaBlocks.PURPLE_TERRACOTTA_TILES_SLAB.get(),"Purple Terracotta Tiles Slab");
        add(MtaBlocks.PURPLE_TERRACOTTA_STAIRS.get(),"Purple Terracotta Stairs");
        add(MtaBlocks.PURPLE_TERRACOTTA_TILES_STAIRS.get(),"Purple Terracotta Tiles Stairs");
        add(MtaBlocks.PURPLE_TERRACOTTA_WALL.get(),"Purple Terracotta Wall");
        add(MtaBlocks.PURPLE_TERRACOTTA_TILES_WALL.get(),"Purple Terracotta Tiles Wall");

        add(MtaBlocks.MAGENTA_TERRACOTTA_TILES.get(),"Magenta Terracotta Tiles");
        add(MtaBlocks.MAGENTA_TERRACOTTA_SLAB.get(),"Magenta Terracotta Slab");
        add(MtaBlocks.MAGENTA_TERRACOTTA_TILES_SLAB.get(),"Magenta Terracotta Tiles Slab");
        add(MtaBlocks.MAGENTA_TERRACOTTA_STAIRS.get(),"Magenta Terracotta Stairs");
        add(MtaBlocks.MAGENTA_TERRACOTTA_TILES_STAIRS.get(),"Magenta Terracotta Tiles Stairs");
        add(MtaBlocks.MAGENTA_TERRACOTTA_WALL.get(),"Magenta Terracotta Wall");
        add(MtaBlocks.MAGENTA_TERRACOTTA_TILES_WALL.get(),"Magenta Terracotta Tiles Wall");

        add(MtaBlocks.PINK_TERRACOTTA_TILES.get(),"Pink Terracotta Tiles");
        add(MtaBlocks.PINK_TERRACOTTA_SLAB.get(),"Pink Terracotta Slab");
        add(MtaBlocks.PINK_TERRACOTTA_TILES_SLAB.get(),"Pink Terracotta Tiles Slab");
        add(MtaBlocks.PINK_TERRACOTTA_STAIRS.get(),"Pink Terracotta Stairs");
        add(MtaBlocks.PINK_TERRACOTTA_TILES_STAIRS.get(),"Pink Terracotta Tiles Stairs");
        add(MtaBlocks.PINK_TERRACOTTA_WALL.get(),"Pink Terracotta Wall");
        add(MtaBlocks.PINK_TERRACOTTA_TILES_WALL.get(),"Pink Terracotta Tiles Wall");

        add(MtaBlocks.WHITE_CONCRETE_SLAB.get(),"White Concrete Slab");
        add(MtaBlocks.WHITE_CONCRETE_STAIRS.get(),"White Concrete Stairs");
        add(MtaBlocks.WHITE_CONCRETE_WALL.get(),"White Concrete Wall");

        add(MtaBlocks.LIGHT_GRAY_CONCRETE_SLAB.get(),"Light Gray Concrete Slab");
        add(MtaBlocks.LIGHT_GRAY_CONCRETE_STAIRS.get(),"Light Gray Concrete Stairs");
        add(MtaBlocks.LIGHT_GRAY_CONCRETE_WALL.get(),"Light Gray Concrete Wall");

        add(MtaBlocks.GRAY_CONCRETE_SLAB.get(),"Gray Concrete Slab");
        add(MtaBlocks.GRAY_CONCRETE_STAIRS.get(),"Gray Concrete Stairs");
        add(MtaBlocks.GRAY_CONCRETE_WALL.get(),"Gray Concrete Wall");

        add(MtaBlocks.BLACK_CONCRETE_SLAB.get(),"Black Concrete Slab");
        add(MtaBlocks.BLACK_CONCRETE_STAIRS.get(),"Black Concrete Stairs");
        add(MtaBlocks.BLACK_CONCRETE_WALL.get(),"Black Concrete Wall");

        add(MtaBlocks.BROWN_CONCRETE_SLAB.get(),"Brown Concrete Slab");
        add(MtaBlocks.BROWN_CONCRETE_STAIRS.get(),"Brown Concrete Stairs");
        add(MtaBlocks.BROWN_CONCRETE_WALL.get(),"Brown Concrete Wall");

        add(MtaBlocks.RED_CONCRETE_SLAB.get(),"Red Concrete Slab");
        add(MtaBlocks.RED_CONCRETE_STAIRS.get(),"Red Concrete Stairs");
        add(MtaBlocks.RED_CONCRETE_WALL.get(),"Red Concrete Wall");

        add(MtaBlocks.ORANGE_CONCRETE_SLAB.get(),"Orange Concrete Slab");
        add(MtaBlocks.ORANGE_CONCRETE_STAIRS.get(),"Orange Concrete Stairs");
        add(MtaBlocks.ORANGE_CONCRETE_WALL.get(),"Orange Concrete Wall");

        add(MtaBlocks.YELLOW_CONCRETE_SLAB.get(),"Yellow Concrete Slab");
        add(MtaBlocks.YELLOW_CONCRETE_STAIRS.get(),"Yellow Concrete Stairs");
        add(MtaBlocks.YELLOW_CONCRETE_WALL.get(),"Yellow Concrete Wall");

        add(MtaBlocks.LIME_CONCRETE_SLAB.get(),"Lime Concrete Slab");
        add(MtaBlocks.LIME_CONCRETE_STAIRS.get(),"Lime Concrete Stairs");
        add(MtaBlocks.LIME_CONCRETE_WALL.get(),"Lime Concrete Wall");

        add(MtaBlocks.GREEN_CONCRETE_SLAB.get(),"Green Concrete Slab");
        add(MtaBlocks.GREEN_CONCRETE_STAIRS.get(),"Green Concrete Stairs");
        add(MtaBlocks.GREEN_CONCRETE_WALL.get(),"Green Concrete Wall");

        add(MtaBlocks.CYAN_CONCRETE_SLAB.get(),"Blue Concrete Slab");
        add(MtaBlocks.CYAN_CONCRETE_STAIRS.get(),"Blue Concrete Stairs");
        add(MtaBlocks.CYAN_CONCRETE_WALL.get(),"Blue Concrete Wall");

        add(MtaBlocks.LIGHT_BLUE_CONCRETE_SLAB.get(),"Light Blue Concrete Slab");
        add(MtaBlocks.LIGHT_BLUE_CONCRETE_STAIRS.get(),"Light Blue Concrete Stairs");
        add(MtaBlocks.LIGHT_BLUE_CONCRETE_WALL.get(),"Light Blue Concrete Wall");

        add(MtaBlocks.BLUE_CONCRETE_SLAB.get(),"Blue Concrete Slab");
        add(MtaBlocks.BLUE_CONCRETE_STAIRS.get(),"Blue Concrete Stairs");
        add(MtaBlocks.BLUE_CONCRETE_WALL.get(),"Blue Concrete Wall");

        add(MtaBlocks.PURPLE_CONCRETE_SLAB.get(),"Purple Concrete Slab");
        add(MtaBlocks.PURPLE_CONCRETE_STAIRS.get(),"Purple Concrete Stairs");
        add(MtaBlocks.PURPLE_CONCRETE_WALL.get(),"Purple Concrete Wall");

        add(MtaBlocks.MAGENTA_CONCRETE_SLAB.get(),"Magenta Concrete Slab");
        add(MtaBlocks.MAGENTA_CONCRETE_STAIRS.get(),"Magenta Concrete Stairs");
        add(MtaBlocks.MAGENTA_CONCRETE_WALL.get(),"Magenta Concrete Wall");

        add(MtaBlocks.PINK_CONCRETE_SLAB.get(),"Pink Concrete Slab");
        add(MtaBlocks.PINK_CONCRETE_STAIRS.get(),"Pink Concrete Stairs");
        add(MtaBlocks.PINK_CONCRETE_WALL.get(),"Pink Concrete Wall");

        add(MtaBlocks.COARSE_DIRT_PATH.get(),"Coarse Dirt Path");
        add(MtaBlocks.NETHER_IRON_ORE.get(),"Nether Iron Ore");
        add(MtaBlocks.NETHER_DIAMOND_ORE.get(),"Nether Diamond Ore");
        add(MtaBlocks.END_LAPIS_ORE.get(),"End Lapis Ore");
        add(MtaBlocks.END_EMERALD_ORE.get(),"End Emerald Ore");
        add(MtaBlocks.CLEAR_QUARTZ_CLUSTER.get(),"Clear Quartz Cluster");
        add(MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_ORE.get(),"Deepslate Clear Quartz  Ore");
        add(MtaBlocks.CLEAR_QUARTZ_ORE.get(),"Clear Quartz Ore");
        add(MtaBlocks.CLEAR_QUARTZ_GROWTH.get(),"Clear Quartz Growth");
        add(MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_GROWTH.get(),"Deepslate Clear Quartz Growth");
        add(MtaBlocks.CALCITE_CLEAR_QUARTZ_GROWTH.get(),"Calcite Clear Quartz Growth");
        add(MtaBlocks.QUARTZ_LAMP.get(),"Quartz Lamp");
        add(MtaBlocks.NETHERITIC_CRYSTAL.get(),"Netheritic Crystal");

        add(MtaBlocks.AGATE_ORE.get(),"Agate Ore");
        add(MtaBlocks.DEEPSLATE_AGATE_ORE.get(),"Deepslate Agate Ore");
        add(MtaBlocks.ALEXANDRITE_ORE.get(),"Alexandrite Ore");
        add(MtaBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),"Deepslate Alexandrite Ore");
        add(MtaBlocks.AQUAMARINE_ORE.get(),"Aquamarine Ore");
        add(MtaBlocks.DEEPSLATE_AQUAMARINE_ORE.get(),"Deepslate Aquamarine Ore");
        add(MtaBlocks.BLOODSTONE_ORE.get(),"Bloodstone Ore");
        add(MtaBlocks.DEEPSLATE_BLOODSTONE_ORE.get(),"Deepslate Bloodstone Ore");
        add(MtaBlocks.CELESTITE_ORE.get(),"Celestite Ore");
        add(MtaBlocks.DEEPSLATE_CELESTITE_ORE.get(),"Deepslate Celestite Ore");
        add(MtaBlocks.CRYOLITE_ORE.get(),"Cryolite Ore");
        add(MtaBlocks.GARNET_ORE.get(),"Garnet Ore");
        add(MtaBlocks.DEEPSLATE_GARNET_ORE.get(),"Deepslate Garnet Ore");
        add(MtaBlocks.MOONSTONE_ORE.get(),"Moonstone Ore");
        add(MtaBlocks.DEEPSLATE_MOONSTONE_ORE.get(),"Deepslate Moonstone Ore");
        add(MtaBlocks.WISESTONE.get(),"Wisestone");
        add(MtaBlocks.END_WISESTONE.get(),"End Wisestone");
        add(MtaBlocks.DEEPSLATE_WISESTONE.get(),"Deepslate Wisestone");

        //CROPS
        add(MtaBlocks.ONION_CROP.get(), "Onion Crop");
        add(MtaBlocks.TOMATO_CROP.get(), "Tomato Crop");
        add(MtaBlocks.BELL_PEPPER_CROP.get(), "Bell Pepper Crop");
        add(MtaBlocks.CHILI_PEPPER_CROP.get(), "Chili Pepper Crop");


        //ITEM

        add(MtaItems.ALPINE_SIGN.get(),"Alpine Sign");
        add(MtaItems.ALPINE_HANGING_SIGN.get(),"Alpine Hanging Sign");
        add(MtaItems.AVOCADO_SIGN.get(),"Avocado Sign");
        add(MtaItems.AVOCADO_HANGING_SIGN.get(),"Avocado Hanging Sign");
        add(MtaItems.BOGGED_OAK_SIGN.get(),"Bogged Oak Sign");
        add(MtaItems.BOGGED_OAK_HANGING_SIGN.get(),"Bogged Oak Hanging Sign");
        add(MtaItems.IPE_SIGN.get(),"Ipe Sign");
        add(MtaItems.IPE_HANGING_SIGN.get(),"Ipe Hanging Sign");
        add(MtaItems.MANGO_SIGN.get(),"Mango Sign");
        add(MtaItems.MANGO_HANGING_SIGN.get(),"Mango Hanging Sign");
        add(MtaItems.MAPLE_SIGN.get(),"Maple Sign");
        add(MtaItems.MAPLE_HANGING_SIGN.get(),"Maple Hanging Sign");
        add(MtaItems.PALM_SIGN.get(),"Palm Sign");
        add(MtaItems.PALM_HANGING_SIGN.get(),"Palm Hanging Sign");
        add(MtaItems.SEAWOOD_SIGN.get(),"Seawood Sign");
        add(MtaItems.SEAWOOD_HANGING_SIGN.get(),"Seawood Hanging Sign");

        add(MtaItems.BIG_BOWL.get(),"Big Bowl");

        add(MtaItems.CLEAR_QUARTZ.get(),"Clear Quartz");
        add(MtaItems.NETHERSTEEL_INGOT.get(),"Nethersteel Ingot");
        add(MtaItems.NETHERITE_FRACTURE.get(),"Netherite Scrap Facture");

        add(MtaItems.HOST_HUSK.get(),"Host Husk");
        add(MtaItems.SAMURAI_CLOTH.get(),"Samurai Cloth");
        add(MtaItems.SIREN_SCALE.get(),"Siren Scale");
        add(MtaItems.BLACK_WIDOW_VENOM.get(),"Black Widow Venom");
        //add(MtaItems.NETHERITE_FRACTURE.get(),"Netherite Scrap Facture");
        add(MtaItems.SPIRIT_DUST.get(),"Spirit Dust");
        add(MtaItems.CHARRED_BONE.get(),"Charred Bone");
        //add(MtaItems.NETHERITE_FRACTURE.get(),"Netherite Scrap Facture");


        add(MtaItems.SCUBA_GEAR.get(),"Scuba Gear");
        add(MtaItems.WEIGHTED_DICE.get(),"Weighted Dice");
        add(MtaItems.CAT_MASK.get(),"Cat Mask");
        add(MtaItems.CLIMBING_CLAWS.get(),"Climbing Claws");
        add(MtaItems.PISTON_BOOTS.get(),"Piston Boots");
        add(MtaItems.REGENERATIVE_TALISMAN.get(),"Regenerative Talisman");
        add(MtaItems.SLEEPING_KIT.get(),"Sleeping Kit");
        add(MtaItems.STRIDER_BOOTS.get(),"Strider Boots");
        add(MtaItems.QUIVER.get(),"Quiver");

        add(MtaItems.AGATE.get(),"Agate");
        add(MtaItems.ALEXANDRITE.get(),"Alexandrite");
        add(MtaItems.AQUAMARINE.get(),"Aquamarine");
        add(MtaItems.BLOODSTONE.get(),"Bloodstone");
        add(MtaItems.CELESTITE.get(),"Celestite");
        add(MtaItems.CRYOLITE.get(),"Cryolite");
        add(MtaItems.GARNET.get(),"Garnet");
        add(MtaItems.MOONSTONE.get(),"Moonstone");

        add(MtaItems.AWAKENED_AGATE.get(),"Awakened Agate");
        add(MtaItems.AWAKENED_ALEXANDRITE.get(),"Awakened Alexandrite");
        add(MtaItems.AWAKENED_AQUAMARINE.get(),"Awakened Aquamarine");
        add(MtaItems.AWAKENED_BLOODSTONE.get(),"Awakened Bloodstone");
        add(MtaItems.AWAKENED_CELESTITE.get(),"Awakened Celestite");
        add(MtaItems.AWAKENED_CRYOLITE.get(),"Awakened Cryolite");
        add(MtaItems.AWAKENED_GARNET.get(),"Awakened Garnet");
        add(MtaItems.AWAKENED_MOONSTONE.get(),"Awakened Moonstone");

        add(MtaItems.ARMAMENT_UPGRADE.get(),"Armament Upgrade");
        add(MtaItems.ROYAL_UPGRADE.get(),"Royal Upgrade");
        add(MtaItems.AQUATIC_UPGRADE.get(),"Aquatic Upgrade");
        add(MtaItems.DEATHLY_UPGRADE.get(),"Deathly Upgrade");
        add(MtaItems.ANGELIC_UPGRADE.get(),"Angelic Upgrade");
        add(MtaItems.FREEZING_UPGRADE.get(),"Freezing Upgrade");
        add(MtaItems.BERSERK_UPGRADE.get(),"Berserk Upgrade");
        add(MtaItems.FEATHERWEIGHT_UPGRADE.get(),"Featherweight Upgrade");

        //ARMOR

        add(MtaItems.GREAT_SENTINELS_HELMET.get(), "Great Sentinel's Helmet");
        add(MtaItems.GREAT_SENTINELS_CHESTPLATE.get(), "Great Sentinel's Chestplate");
        add(MtaItems.GREAT_SENTINELS_LEGGINGS.get(), "Great Sentinel's Leggings");
        add(MtaItems.GREAT_SENTINELS_BOOTS.get(), "Great Sentinel's Boots");
        add(MtaItems.HOLY_KNIGHTS_HELMET.get(), "Holy Knight's Helmet");
        add(MtaItems.HOLY_KNIGHTS_CHESTPLATE.get(), "Holy Knight's Chestplate");
        add(MtaItems.HOLY_KNIGHTS_LEGGINGS.get(), "Holy Knight's Leggings");
        add(MtaItems.HOLY_KNIGHTS_BOOTS.get(), "Holy Knight's Boots");
        add(MtaItems.MYSTIC_MERMAIDS_HELMET.get(), "Mystic Mermaid's Helmet");
        add(MtaItems.MYSTIC_MERMAIDS_CHESTPLATE.get(), "Mystic Mermaid's Chestplate");
        add(MtaItems.MYSTIC_MERMAIDS_LEGGINGS.get(), "Mystic Mermaid's Leggings");
        add(MtaItems.MYSTIC_MERMAIDS_BOOTS.get(), "Mystic Mermaid's Boots");
        add(MtaItems.SILENT_REAPERS_HELMET.get(), "Silent Reaper's Helmet");
        add(MtaItems.SILENT_REAPERS_CHESTPLATE.get(), "Silent Reaper's Chestplate");
        add(MtaItems.SILENT_REAPERS_LEGGINGS.get(), "Silent Reaper's Leggings");
        add(MtaItems.SILENT_REAPERS_BOOTS.get(), "Silent Reaper's Boots");
        add(MtaItems.TEMPLE_ANGELS_HELMET.get(), "Temple Angel's Helmet");
        add(MtaItems.TEMPLE_ANGELS_CHESTPLATE.get(), "Temple Angel's Chestplate");
        add(MtaItems.TEMPLE_ANGELS_LEGGINGS.get(), "Temple Angel's Leggings");
        add(MtaItems.TEMPLE_ANGELS_BOOTS.get(), "Temple Angel's Boots");
        add(MtaItems.FREEZING_ICICLE_HELMET.get(), "Cold Set Helmet");
        add(MtaItems.FREEZING_ICICLE_CHESTPLATE.get(), "Cold Set Chestplate");
        add(MtaItems.FREEZING_ICICLE_LEGGINGS.get(), "Cold Set Leggings");
        add(MtaItems.FREEZING_ICICLE_BOOTS.get(), "Cold Set Boots");
        add(MtaItems.WRATHFUL_BERSERKERS_HELMET.get(), "Wrathful Berserker's Helmet");
        add(MtaItems.WRATHFUL_BERSERKERS_CHESTPLATE.get(), "Wrathful Berserker's Chestplate");
        add(MtaItems.WRATHFUL_BERSERKERS_LEGGINGS.get(), "Wrathful Berserker's Leggings");
        add(MtaItems.WRATHFUL_BERSERKERS_BOOTS.get(), "Wrathful Berserker's Boots");
        add(MtaItems.SHADOW_ROGUES_HELMET.get(), "Shadow Rogue's Helmet");
        add(MtaItems.SHADOW_ROGUES_CHESTPLATE.get(), "Shadow Rogue's Chestplate");
        add(MtaItems.SHADOW_ROGUES_LEGGINGS.get(), "Shadow Rogue's Leggings");
        add(MtaItems.SHADOW_ROGUES_BOOTS.get(), "Shadow Rogue's Boots");

        //TOOLS

        add(MtaItems.COPPER_PICKAXE.get(), "Copper Pickaxe");
        add(MtaItems.COPPER_AXE.get(), "Copper Axe");
        add(MtaItems.COPPER_SHOVEL.get(), "Copper Shovel");
        add(MtaItems.COPPER_HOE.get(), "Copper Hoe");

        add(MtaItems.NETHERSTEEL_PICKAXE.get(), "Nethersteel Pickaxe");
        add(MtaItems.NETHERSTEEL_AXE.get(), "Nethersteel Axe");
        add(MtaItems.NETHERSTEEL_SHOVEL.get(), "Nethersteel Shovel");
        add(MtaItems.NETHERSTEEL_HOE.get(), "Nethersteel Hoe");

        //WEAPONS
        add(MtaItems.COPPER_SWORD.get(), "Copper Sword");
        add(MtaItems.NETHERSTEEL_SWORD.get(), "Nethersteel Sword");
        add(MtaItems.NETHERITE_TRIDENT.get(), "Netherite Trident");
        add(MtaItems.NETHERITE_BOW.get(), "Netherite Bow");
        add(MtaItems.NETHERITE_MACE.get(), "Netherite Mace");

        add(MtaItems.POLEARM.get(), "Polearm");

        add(MtaItems.WOOD_ANCHOR.get(),"Wood Anchor");
        add(MtaItems.WOOD_CLAW.get(),"Wood Claw");
        add(MtaItems.WOOD_CLAYMORE.get(),"Wood Claymore");
        add(MtaItems.WOOD_CUTLASS.get(),"Wood Cutlass");
        add(MtaItems.WOOD_DAGGER.get(),"Wood Dagger");
        add(MtaItems.WOOD_DOUBLE_AXE.get(),"Wood Double Axe");
        add(MtaItems.WOOD_FLAIL.get(),"Wood Flail");
        add(MtaItems.WOOD_GLAIVE.get(),"Wood Glaive");
        add(MtaItems.WOOD_HALBERD.get(),"Wood Halberd");
        add(MtaItems.WOOD_KATANA.get(),"Wood Katana");
        add(MtaItems.WOOD_RAPIER.get(),"Wood Rapier");
        add(MtaItems.WOOD_SCYTHE.get(),"Woods Scythe");
        add(MtaItems.WOOD_SICKLE.get(),"Woods Sickle");
        add(MtaItems.WOOD_SPEAR.get(),"Wood Spear");
        add(MtaItems.WOOD_TWINBLADE.get(),"Wood Twinblade");
      //  add(MtaItems.WOOD_WHIP_SWORD.get(),"Wood Whip Sword");

        add(MtaItems.STONE_ANCHOR.get(),"Stone Anchor");
        add(MtaItems.STONE_CLAW.get(),"Stone Claw");
        add(MtaItems.STONE_CLAYMORE.get(),"Stone Claymore");
        add(MtaItems.STONE_CUTLASS.get(),"Stone Cutlass");
        add(MtaItems.STONE_DAGGER.get(),"Stone Dagger");
        add(MtaItems.STONE_DOUBLE_AXE.get(),"Stone Double Axe");
        add(MtaItems.STONE_FLAIL.get(),"Stone Flail");
        add(MtaItems.STONE_GLAIVE.get(),"Stone Glaive");
        add(MtaItems.STONE_HALBERD.get(),"Stone Halberd");
        add(MtaItems.STONE_KATANA.get(),"Stone Katana");
        add(MtaItems.STONE_RAPIER.get(),"Stone Rapier");
        add(MtaItems.STONE_SCYTHE.get(),"Stone Scythe");
        add(MtaItems.STONE_SICKLE.get(),"Stone Sickle");
        add(MtaItems.STONE_SPEAR.get(),"Stone Spear");
        add(MtaItems.STONE_TWINBLADE.get(),"Stone Twinblade");
       // add(MtaItems.STONE_WHIP_SWORD.get(),"Stone Whip Sword");

        add(MtaItems.COPPER_ANCHOR.get(),"Copper Anchor");
        add(MtaItems.COPPER_CLAW.get(),"Copper Claw");
        add(MtaItems.COPPER_CLAYMORE.get(),"Copper Claymore");
        add(MtaItems.COPPER_CUTLASS.get(),"Copper Cutlass");
        add(MtaItems.COPPER_DAGGER.get(),"Copper Dagger");
        add(MtaItems.COPPER_DOUBLE_AXE.get(),"Copper Double Axe");
        add(MtaItems.COPPER_FLAIL.get(),"Copper Flail");
        add(MtaItems.COPPER_GLAIVE.get(),"Copper Glaive");
        add(MtaItems.COPPER_HALBERD.get(),"Copper Halberd");
        add(MtaItems.COPPER_KATANA.get(),"Copper Katana");
        add(MtaItems.COPPER_RAPIER.get(),"Copper Rapier");
        add(MtaItems.COPPER_SCYTHE.get(),"Copper Scythe");
        add(MtaItems.COPPER_SICKLE.get(),"Copper Sickle");
        add(MtaItems.COPPER_SPEAR.get(),"Copper Spear");
        add(MtaItems.COPPER_TWINBLADE.get(),"Copper Twinblade");
      //  add(MtaItems.COPPER_WHIP_SWORD.get(),"Copper Whip Sword");

        add(MtaItems.IRON_ANCHOR.get(),"Iron Anchor");
        add(MtaItems.IRON_CLAW.get(),"Iron Claw");
        add(MtaItems.IRON_CLAYMORE.get(),"Iron Claymore");
        add(MtaItems.IRON_CUTLASS.get(),"Iron Cutlass");
        add(MtaItems.IRON_DAGGER.get(),"Iron Dagger");
        add(MtaItems.IRON_DOUBLE_AXE.get(),"Iron Double Axe");
        add(MtaItems.IRON_FLAIL.get(),"Iron Flail");
        add(MtaItems.IRON_GLAIVE.get(),"Iron Glaive");
        add(MtaItems.IRON_HALBERD.get(),"Iron Halberd");
        add(MtaItems.IRON_KATANA.get(),"Iron Katana");
        add(MtaItems.IRON_RAPIER.get(),"Iron Rapier");
        add(MtaItems.IRON_SCYTHE.get(),"Iron Scythe");
        add(MtaItems.IRON_SICKLE.get(),"Iron Sickle");
        add(MtaItems.IRON_SPEAR.get(),"Iron Spear");
        add(MtaItems.IRON_TWINBLADE.get(),"Iron Twinblade");
      //  add(MtaItems.IRON_WHIP_SWORD.get(),"Iron Whip Sword");

        add(MtaItems.GOLD_ANCHOR.get(),"Gold Anchor");
        add(MtaItems.GOLD_CLAW.get(),"Gold Claw");
        add(MtaItems.GOLD_CLAYMORE.get(),"Gold Claymore");
        add(MtaItems.GOLD_CUTLASS.get(),"Gold Cutlass");
        add(MtaItems.GOLD_DAGGER.get(),"Gold Dagger");
        add(MtaItems.GOLD_DOUBLE_AXE.get(),"Gold Double Axe");
        add(MtaItems.GOLD_FLAIL.get(),"Gold Flail");
        add(MtaItems.GOLD_GLAIVE.get(),"Gold Glaive");
        add(MtaItems.GOLD_HALBERD.get(),"Gold Halberd");
        add(MtaItems.GOLD_KATANA.get(),"Gold Katana");
        add(MtaItems.GOLD_RAPIER.get(),"Gold Rapier");
        add(MtaItems.GOLD_SCYTHE.get(),"Gold Scythe");
        add(MtaItems.GOLD_SICKLE.get(),"Gold Sickle");
        add(MtaItems.GOLD_SPEAR.get(),"Gold Spear");
        add(MtaItems.GOLD_TWINBLADE.get(),"Gold Twinblade");
       // add(MtaItems.GOLD_WHIP_SWORD.get(),"Gold Whip Sword");

        add(MtaItems.NETHERSTEEL_ANCHOR.get(),"Nethersteel Anchor");
        add(MtaItems.NETHERSTEEL_CLAW.get(),"Nethersteel Claw");
        add(MtaItems.NETHERSTEEL_CLAYMORE.get(),"Nethersteel Claymore");
        add(MtaItems.NETHERSTEEL_CUTLASS.get(),"Nethersteel Cutlass");
        add(MtaItems.NETHERSTEEL_DAGGER.get(),"Nethersteel Dagger");
        add(MtaItems.NETHERSTEEL_DOUBLE_AXE.get(),"Nethersteel Double Axe");
        add(MtaItems.NETHERSTEEL_FLAIL.get(),"Nethersteel Flail");
        add(MtaItems.NETHERSTEEL_GLAIVE.get(),"Nethersteel Glaive");
        add(MtaItems.NETHERSTEEL_HALBERD.get(),"Nethersteel Halberd");
        add(MtaItems.NETHERSTEEL_KATANA.get(),"Nethersteel Katana");
        add(MtaItems.NETHERSTEEL_RAPIER.get(),"Nethersteel Rapier");
        add(MtaItems.NETHERSTEEL_SCYTHE.get(),"Nethersteel Scythe");
        add(MtaItems.NETHERSTEEL_SICKLE.get(),"Nethersteel Sickle");
        add(MtaItems.NETHERSTEEL_SPEAR.get(),"Nethersteel Spear");
        add(MtaItems.NETHERSTEEL_TWINBLADE.get(),"Nethersteel Twinblade");
       // add(MtaItems.NETHERSTEEL_WHIP_SWORD.get(),"Nethersteel Whip Sword");

        add(MtaItems.DIAMOND_ANCHOR.get(),"Diamond Anchor");
        add(MtaItems.DIAMOND_CLAW.get(),"Diamond Claw");
        add(MtaItems.DIAMOND_CLAYMORE.get(),"Diamond Claymore");
        add(MtaItems.DIAMOND_CUTLASS.get(),"Diamond Cutlass");
        add(MtaItems.DIAMOND_DAGGER.get(),"Diamond Dagger");
        add(MtaItems.DIAMOND_DOUBLE_AXE.get(),"Diamond Double Axe");
        add(MtaItems.DIAMOND_FLAIL.get(),"Diamond Flail");
        add(MtaItems.DIAMOND_GLAIVE.get(),"Diamond Glaive");
        add(MtaItems.DIAMOND_HALBERD.get(),"Diamond Halberd");
        add(MtaItems.DIAMOND_KATANA.get(),"Diamond Katana");
        add(MtaItems.DIAMOND_RAPIER.get(),"Diamond Rapier");
        add(MtaItems.DIAMOND_SCYTHE.get(),"Diamond Scythe");
        add(MtaItems.DIAMOND_SICKLE.get(),"Diamond Sickle");
        add(MtaItems.DIAMOND_SPEAR.get(),"Diamond Spear");
        add(MtaItems.DIAMOND_TWINBLADE.get(),"Diamond Twinblade");
       // add(MtaItems.DIAMOND_WHIP_SWORD.get(),"Diamond Whip Sword");

        add(MtaItems.NETHERITE_ANCHOR.get(),"Netherite Anchor");
        add(MtaItems.NETHERITE_CLAW.get(),"Netherite Claw");
        add(MtaItems.NETHERITE_CLAYMORE.get(),"Netherite Claymore");
        add(MtaItems.NETHERITE_CUTLASS.get(),"Netherite Cutlass");
        add(MtaItems.NETHERITE_DAGGER.get(),"Netherite Dagger");
        add(MtaItems.NETHERITE_DOUBLE_AXE.get(),"Netherite Double Axe");
        add(MtaItems.NETHERITE_FLAIL.get(),"Netherite Flail");
        add(MtaItems.NETHERITE_GLAIVE.get(),"Netherite Glaive");
        add(MtaItems.NETHERITE_HALBERD.get(),"Netherite Halberd");
        add(MtaItems.NETHERITE_KATANA.get(),"Netherite Katana");
        add(MtaItems.NETHERITE_RAPIER.get(),"Netherite Rapier");
        add(MtaItems.NETHERITE_SCYTHE.get(),"Netherite Scythe");
        add(MtaItems.NETHERITE_SICKLE.get(),"Netherite Sickle");
        add(MtaItems.NETHERITE_SPEAR.get(),"Netherite Spear");
        add(MtaItems.NETHERITE_TWINBLADE.get(),"Netherite Twinblade");
       // add(MtaItems.NETHERITE_WHIP_SWORD.get(),"Netherite Whip Sword");

        add(MtaItems.LONG_BOW.get(), "Long Bow");
        add(MtaItems.REINFORCED_LONG_BOW.get(), "Reinforced Long Bow");
        add(MtaItems.SHORT_BOW.get(), "Short Bow");
        add(MtaItems.REINFORCED_SHORT_BOW.get(), "Reinforced Short Bow");
        add(MtaItems.TWIN_BOW.get(), "Twin Bow");
        add(MtaItems.REINFORCED_TWIN_BOW.get(), "Reinforced Twin Bow");

        add(MtaItems.LEATHER_WHIP.get(), "Leather Whip");
        add(MtaItems.CHAIN_WHIP.get(), "Chain Whip");
        add(MtaItems.NETHERITE_WHIP.get(), "Netherite Whip");

        add(MtaItems.GREAT_SENTINELS_WAR_HAMMER.get(), "Great Sentinel's War Hammer");
        add(MtaItems.HOLY_KNIGHTS_GREATSWORD.get(), "Holy Knight's Greatsword");
        add(MtaItems.MYSTIC_MERMAIDS_TRIDENT.get(), "Mystic Mermaid's Trident");
        add(MtaItems.SILENT_REAPERS_SCYTHE.get(), "Silent Reaper's Scythe");
        add(MtaItems.TEMPLE_ANGELS_BOW.get(), "Temple Angel's Bow");
        add(MtaItems.FREEZING_ICICLE_SPEAR.get(), "Cold Set Weapon");
        add(MtaItems.WRATHFUL_BERSERKERS_BATTLEAXE.get(), "Wrathful Berserker's Battleaxe");
        add(MtaItems.SHADOW_ROGUES_DAGGER.get(), "Shadow Rogue's Dagger");



        //FOODS
        add(MtaItems.ONION.get(),"Onion");
        add(MtaItems.RAW_HORSE.get(),"Horse");
        add(MtaItems.COOKED_HORSE.get(),"Cooked Horse");
        add(MtaItems.RAW_DEER.get(),"Deer");
        add(MtaItems.COOKED_DEER.get(),"Cooked Deer");
        add(MtaItems.RAW_DUCK.get(),"Duck");
        add(MtaItems.COOKED_DUCK.get(),"Cooked Duck");
        add(MtaItems.RAW_GOAT.get(),"Goat");
        add(MtaItems.COOKED_GOAT.get(),"Cooked Goat");
        add(MtaItems.RAW_TURKEY.get(),"Turkey");
        add(MtaItems.COOKED_TURKEY.get(),"Cooked Turkey");
        add(MtaItems.SHRIMP.get(),"Shrimp");
        add(MtaItems.COOKED_SHRIMP.get(),"Cooked Shrimp");
        add(MtaItems.TOMATO.get(),"Tomato");
        add(MtaItems.TOMATO_SEEDS.get(),"Tomato Seeds");
        add(MtaItems.BELL_PEPPER.get(),"Bell Pepper");
        add(MtaItems.BELL_PEPPER_SEEDS.get(),"Bell Pepper Seeds");
        add(MtaItems.CHILI_PEPPER.get(),"Chili Pepper");
        add(MtaItems.CHILI_PEPPER_SEEDS.get(),"Chili Pepper Seeds");
        add(MtaItems.RICE.get(),"Rice");
        add(MtaItems.ONIGIRI.get(),"Onigiri");
        add(MtaItems.COCONUT.get(),"Coconut");
        add(MtaItems.COCONUT_MILK.get(),"Coconut Milk");
        add(MtaItems.COCONUT_SLICE.get(),"Coconut Slice");
        add(MtaItems.SPICE_MIX.get(),"Spice Mix");
        add(MtaItems.SWEET_BEEF_CURRY.get(),"Sweet Beef Curry");
        add(MtaItems.SWEET_PORK_CURRY.get(),"Sweet Pork Curry");
        add(MtaItems.SWEET_CHICKEN_CURRY.get(),"Sweet Chicken Curry");
        add(MtaItems.SWEET_SHRIMP_CURRY.get(),"Sweet Shrimp Curry");
        add(MtaItems.MILD_BEEF_CURRY.get(),"Mild Beef Curry");
        add(MtaItems.MILD_PORK_CURRY.get(),"Mild Pork Curry");
        add(MtaItems.MILD_CHICKEN_CURRY.get(),"Mild Chicken Curry");
        add(MtaItems.MILD_SHRIMP_CURRY.get(),"Mild Shrimp Curry");
        add(MtaItems.SPICY_BEEF_CURRY.get(),"Spicy Beef Curry");
        add(MtaItems.SPICY_PORK_CURRY.get(),"Spicy Pork Curry");
        add(MtaItems.SPICY_CHICKEN_CURRY.get(),"Spicy Chicken Curry");
        add(MtaItems.SPICY_SHRIMP_CURRY.get(),"Spicy Shrimp Curry");
        add(MtaItems.APPLE_SLICE.get(), "Apple Slice");
        add(MtaItems.AVOCADO.get(), "Avocado");
        add(MtaItems.AVOCADO_SLICE.get(), "Avocado Slice");
        add(MtaItems.BANANA.get(), "Banana");
        add(MtaItems.CABBAGE.get(), "Cabbage");
        add(MtaItems.COFFEE_BEANS.get(), "Coffee Beans");
        add(MtaItems.COFFEE.get(), "Coffee");
        add(MtaItems.GRAPES.get(), "Grapes");
        add(MtaItems.MANGO.get(), "Mango");
        add(MtaItems.MANGO_SLICE.get(), "Mango Slice");
        add(MtaItems.STRAWBERRY.get(), "Strawberry");
        add(MtaItems.TEA_LEAVES.get(), "Tea Leaves");
        add(MtaItems.TEA.get(), "Tea");
        add(MtaItems.ICE_CUBES.get(), "Ice Cubes");
        add(MtaItems.SMOOTHIE.get(), "Smoothie");
        add(MtaItems.JUICE.get(), "Juice");

        //SPAWN EGGS

        add(MtaItems.YUKI_ONNA_SPAWN_EGG.get(),"Yuki Onna Spawn Egg");
        add(MtaItems.FALLEN_SAMURAI_SPAWN_EGG.get(),"Fallen Samurai Spawn Egg");
        add(MtaItems.ICICLE_CREEPER_SPAWN_EGG.get(),"Icicle Creeper Spawn Egg");
        add(MtaItems.ARMORED_SKELETON_SPAWN_EGG.get(),"Armored Skeleton Spawn Egg");
        add(MtaItems.BLACK_WIDOW_SPAWN_EGG.get(),"Black Widow Spawn Egg");
        add(MtaItems.CHARRED_SKELETON_SPAWN_EGG.get(),"Charred Skeleton Spawn Egg");
        add(MtaItems.CORROSIVE_CUBE_SPAWN_EGG.get(),"Corrosive Cube Spawn Egg");
        add(MtaItems.FROSTED_SLIME_SPAWN_EGG.get(),"Frosted Slime Spawn Egg");
        add(MtaItems.GLOW_SPIDER_SPAWN_EGG.get(),"Glow Spider Spawn Egg");
        add(MtaItems.HOST_SPAWN_EGG.get(),"Host Spawn Egg");
        add(MtaItems.MOSSY_ZOMBIE_SPAWN_EGG.get(),"Mossy Zombie Spawn Egg");
        add(MtaItems.SKELETON_FIGHTER_SPAWN_EGG.get(),"Skeleton Fighter Spawn Egg");
        add(MtaItems.TOXIC_ZOMBIE_SPAWN_EGG.get(),"Toxic Zombie Spawn Egg");
        add(MtaItems.WITHER_SOLDIER_SPAWN_EGG.get(),"Wither Soldier Spawn Egg");
        add(MtaItems.ZOMBIFIED_MINER_SPAWN_EGG.get(),"Zombified Miner Spawn Egg");
        add(MtaItems.SIREN_SPAWN_EGG.get(),"Siren Spawn Egg");
        add(MtaItems.WISPFLY_SPAWN_EGG.get(),"Wispfly Spawn Egg");
        add(MtaItems.BUTTERFLY_SPAWN_EGG.get(),"Butterfly Spawn Egg");
        add(MtaItems.BEARDED_DRAGON_SPAWN_EGG.get(),"Bearded Dragon Spawn Egg");
        add(MtaItems.CAPYBARA_SPAWN_EGG.get(),"Capybara Spawn Egg");
        add(MtaItems.DEER_SPAWN_EGG.get(),"Deer Spawn Egg");
        add(MtaItems.DUCK_SPAWN_EGG.get(),"Duck Spawn Egg");
        add(MtaItems.FERRET_SPAWN_EGG.get(),"Ferret Spawn Egg");
        add(MtaItems.GREAT_WHITE_SHARK_SPAWN_EGG.get(),"Great White Shark Spawn Egg");
        add(MtaItems.HORSESHOE_CRAB_SPAWN_EGG.get(),"Horseshoe Crab Spawn Egg");
        add(MtaItems.JELLYFISH_SPAWN_EGG.get(),"Jellyfish Spawn Egg");
        add(MtaItems.OCTOPUS_SPAWN_EGG.get(),"Octopus Spawn Egg");
        add(MtaItems.OWL_SPAWN_EGG.get(),"Owl Spawn Egg");
        add(MtaItems.PENGUIN_SPAWN_EGG.get(),"Penguin Spawn Egg");
        add(MtaItems.RACCOON_SPAWN_EGG.get(),"Raccoon Spawn Egg");
        add(MtaItems.SHRIMP_SPAWN_EGG.get(),"Shrimp Spawn Egg");
        add(MtaItems.TOUCAN_SPAWN_EGG.get(),"Toucan Spawn Egg");
        add(MtaItems.TURKEY_SPAWN_EGG.get(),"Turkey Spawn Egg");


        //ENTITIES
        add(MtaEntityTypes.YUKI_ONNA.get(),"Yuki Onna");
        add(MtaEntityTypes.FALLEN_SAMURAI.get(),"Fallen Samurai");
        add(MtaEntityTypes.ICICLE_CREEPER.get(),"Icicle Creeper");
        add(MtaEntityTypes.ARMORED_SKELETON.get(),"Armored Skeleton");
        add(MtaEntityTypes.WITHER_SOLDIER.get(),"Wither Soldier");
        add(MtaEntityTypes.BLACK_WIDOW.get(),"Black Widow");
        add(MtaEntityTypes.CHARRED_SKELETON.get(),"Charred Skeleton");
        add(MtaEntityTypes.CORROSIVE_CUBE.get(),"Corrosive Cube");
        add(MtaEntityTypes.FROSTED_SLIME.get(),"Frosted Slime");
        add(MtaEntityTypes.GLOW_SPIDER.get(),"Glow Spider");
        add(MtaEntityTypes.HOST.get(),"Host");
        add(MtaEntityTypes.MOSSY_ZOMBIE.get(),"Mossy Zombie");
        add(MtaEntityTypes.SKELETON_FIGHTER.get(),"Skeleton Fighter");
        add(MtaEntityTypes.TOXIC_ZOMBIE.get(),"Toxic Zombie");
        add(MtaEntityTypes.ZOMBIFIED_MINER.get(),"Zombified Miner");
        add(MtaEntityTypes.BEARDED_DRAGON.get(),"Bearded Dragon");
        add(MtaEntityTypes.BUTTERFLY.get(),"Butterfly");
        add(MtaEntityTypes.CAPIBARA.get(),"Capybara");
        add(MtaEntityTypes.DEER.get(),"Deer");
        add(MtaEntityTypes.DUCK.get(),"Duck");
        add(MtaEntityTypes.FERRET.get(),"Ferret");
        add(MtaEntityTypes.GREAT_WHITE_SHARK.get(),"Great White Shark");
        add(MtaEntityTypes.HORSESHOE_CRAB.get(),"Horseshoe Crab");
        add(MtaEntityTypes.JELLYFISH.get(),"Jellyfish");
        add(MtaEntityTypes.OCTOPUS.get(),"Octopus");
        add(MtaEntityTypes.OWL.get(),"Owl");
        add(MtaEntityTypes.WISPFLY.get(),"Wispfly");
        add(MtaEntityTypes.PENGUIN.get(),"Penguin");
        add(MtaEntityTypes.RACCOON.get(),"Raccoon");
        add(MtaEntityTypes.SHRIMP.get(),"Shrimp");
        add(MtaEntityTypes.TOUCAN.get(),"Toucan");
        add(MtaEntityTypes.TURKEY.get(),"Turkey");
        add(MtaEntityTypes.MTA_ARROW.get(),"Special Arrow");

        //ENCHANTMENTS
        add("enchantment.morethanadventure.disarm", "Disarm");





        //EFFECTS
        add(MtaEffects.FREEZING.get(),"Freezing");
        add(MtaEffects.STUN.get(),"Stunned");
        add(MtaEffects.BLEEDING.get(),"Bleeding");
        add(MtaEffects.VENOM.get(),"Venom");
        add(MtaEffects.CHARGING.get(),"Charging Skill");
        add(MtaEffects.BERSERK.get(),"Berserk");
        add(MtaEffects.TWO_HANDED_BLOCK.get(),"Improper Weapon Usage");

        //SPECIES
        add("morethanadventure.species.human","Human");
        add("morethanadventure.species.description.human","Human");
        add("morethanadventure.species.giant","Giant");
        add("morethanadventure.species.description.giant","Giant");;
        add("morethanadventure.species.elf","Elf");
        add("morethanadventure.species.description.elf","Elf");;
        add("morethanadventure.species.dwarf","Dwarf");
        add("morethanadventure.species.description.dwarf","Dwarf");



        //DEATH
        add("death.attack.bleed","%1$s bled out");
        add("death.attack.venom","%1$s could not resist the venom");
        add("death.attack.bleed.player","%1$s bled out whilst fighting %2$s");
        add("death.attack.venom.player","%1$s could not resist the venom whilst fighting %2$s");




        //OTHER
        sounds();

        commands();

        add("itemGroup.morethanadventure","More Than Adventure ALL");
        add("itemGroup.mtagenblocks","MTA: World Gen");
        add("itemGroup.mtabuilding","MTA: Building Blocks");
        add("itemGroup.mtaequip","MTA: Equipments");
        add("itemGroup.mtautil","MTA: Items & Utilities");
        add("itemGroup.mtafoods","MTA: Food");
        add("itemGroup.mtaspawn","MTA: Spawns Eggs");


        // KEYBINDS
        add("key.categories.morethanadventure","More Than Adventure");


        //CURIO
        add("curios.identifier.talisman", "Talisman");
        add("curios.modifiers.talisman", "On Wearing Talisman:");
        add("curios.identifier.totem", "Totem");
        add("curios.modifiers.totem", "On Wearing Totem:");
        add("mta.talisman.description.hint", "Press SHIFT to see description");

        //TalismanItem
        add(getTalismanDescriptionID(MtaItems.WEIGHTED_DICE), "MTA and Vanilla enchantments and effects that have luck based aspects will have more favorable odds");
        add(getTalismanDescriptionID(MtaItems.CAT_MASK), "Creepers become afraid of you as if you were a cat");
        add(getTalismanDescriptionID(MtaItems.CLIMBING_CLAWS), "Becomes capable of climbing up walls");
        add(getTalismanDescriptionID(MtaItems.PISTON_BOOTS), "Increases jump height");
        add(getTalismanDescriptionID(MtaItems.REGENERATIVE_TALISMAN), "Crouching heals you, allies, and pets in an area");
        add(getTalismanDescriptionID(MtaItems.SLEEPING_KIT), "Press \"Use Talisman\" key to sleep");
        add(getTalismanDescriptionID(MtaItems.STRIDER_BOOTS), "Boots made of Strider skin that allow you to walk on Lava");
        add(getTalismanDescriptionID(MtaItems.QUIVER), "Mobs killed by arrow have a random chance of dropping multiple arrows.");

    }

    private void sounds() {
        //add("sound.morethanadventure.bearded_dragon_ambient", "Bearded Dragon Barks");
        //add("sound.morethanadventure.bearded_dragon_hurt", "Bearded Dragon Hurts");
        //add("sound.morethanadventure.bearded_dragon_death", "Bearded Dragon Dies");
        //add("sound.morethanadventure.butterfly_ambient", "Butterfly Barks");
        //add("sound.morethanadventure.butterfly_hurt", "Butterfly Hurts");
        //add("sound.morethanadventure.butterfly_death", "Butterfly Dies");
        //add("sound.morethanadventure.capybara_ambient", "Capybara Barks");
        add("sound.morethanadventure.capybara_hurt", "Capybara Hurts");
        //add("sound.morethanadventure.capybara_death", "Capybara Dies");
        add("sound.morethanadventure.deer_ambient", "Deer Idles");
        add("sound.morethanadventure.deer_hurt", "Deer Hurts");
        add("sound.morethanadventure.deer_death", "Deer Dies");
        add("sound.morethanadventure.duck_ambient", "Duck Quacking");
        //add("sound.morethanadventure.duck_hurt", "Duck Hurts");
        //add("sound.morethanadventure.duck_death", "Duck Dies");
        add("sound.morethanadventure.ferret_ambient", "Ferret Dooking");
        add("sound.morethanadventure.ferret_hurt", "Ferret Hurts");
        //add("sound.morethanadventure.ferret_death", "Ferret Dies");
        //add("sound.morethanadventure.great_white_shark_ambient", "Great White Shark Dooking");
        //add("sound.morethanadventure.great_white_shark_hurt", "Great White Shark Hurts");
        //add("sound.morethanadventure.great_white_shark_death", "Great White Shark Dies");
        //add("sound.morethanadventure.horseshoe_crab_ambient", "Horseshoe Crab Dooking");
        //add("sound.morethanadventure.horseshoe_crab_ambient_hurt", "Horseshoe Crab Hurts");
        //add("sound.morethanadventure.horseshoe_crab_ambient_death", "Horseshoe Crab Dies");
        //add("sound.morethanadventure.jellyfish_ambient", "Jellyfish Dooking");
        //add("sound.morethanadventure.jellyfish_hurt", "Jellyfish Hurts");
        //add("sound.morethanadventure.jellyfish_death", "Jellyfish Dies");
        //add("sound.morethanadventure.octopus_ambient", "Octopus Dooking");
        //add("sound.morethanadventure.octopus_hurt", "Octopus Hurts");
        //add("sound.morethanadventure.octopus_death", "Octopus Dies");
        add("sound.morethanadventure.owl_ambient", "Owl Call");
        add("sound.morethanadventure.owl_hurt", "Owl Hurts");
        add("sound.morethanadventure.owl_death", "Owl Dies");
        //add("sound.morethanadventure.penguin_ambient", "Penguin Call");
        //add("sound.morethanadventure.penguin_hurt", "Penguin Hurts");
        //add("sound.morethanadventure.penguin_death", "Penguin Dies");
        //add("sound.morethanadventure.raccoon_ambient", "Raccoon Call");
        //add("sound.morethanadventure.raccoon_hurt", "Raccoon Hurts");
        //add("sound.morethanadventure.raccoon_death", "Raccoon Dies");
        //add("sound.morethanadventure.shrimp_ambient", "Shrimp Call");
        //add("sound.morethanadventure.shrimp_hurt", "Shrimp Hurts");
        //add("sound.morethanadventure.shrimp_death", "Shrimp Dies");
        add("sound.morethanadventure.toucan_ambient", "Toucan Call");
        add("sound.morethanadventure.toucan_hurt", "Toucan Hurts");
        add("sound.morethanadventure.toucan_death", "Toucan Dies");
        add("sound.morethanadventure.turkey_ambient", "Turkey Gobbles");
        add("sound.morethanadventure.turkey_hurt", "Turkey Hurts");
        add("sound.morethanadventure.turkey_death", "Turkey Dies");

        add("sound.morethanadventure.wisp_ambient", "Wispfly Sings");
        add("sound.morethanadventure.wisp_hurt", "Wispfly Hurts");
        add("sound.morethanadventure.wisp_death", "Wispfly Dies");

        add("sound.morethanadventure.armored_skeleton_ambient", "Armored Skeleton Rattles");
        add("sound.morethanadventure.armored_skeleton_hurt", "Armored Skeleton Hurts");
        add("sound.morethanadventure.armored_skeleton_death", "Armored Skeleton Dies");
        add("sound.morethanadventure.armored_skeleton_step", "Armored Skeleton Steps");
        add("sound.morethanadventure.charred_skeleton_ambient", "Charred Skeleton Rattles");
        add("sound.morethanadventure.charred_skeleton_hurt", "Charred Skeleton Hurts");
        add("sound.morethanadventure.charred_skeleton_death", "Charred Skeleton Dies");
        add("sound.morethanadventure.charred_skeleton_step", "Charred Skeleton Steps");
        //add("sound.morethanadventure.corrosive_cube_ambient", "Corrosive Cube Call");
        //add("sound.morethanadventure.corrosive_cube_hurt", "Corrosive Cube Hurts");
        //add("sound.morethanadventure.corrosive_cube_death", "Corrosive Cube Dies");
        add("sound.morethanadventure.fallen_samurai_ambient", "Fallen Samurai Breathes");
        add("sound.morethanadventure.fallen_samurai_hurt", "Fallen Samurai Hurts");
        add("sound.morethanadventure.fallen_samurai_death", "Fallen Samurai Dies");
        //add("sound.morethanadventure.frosted_slime_ambient", "Frosted Slime Call");
        //add("sound.morethanadventure.frosted_slime_hurt", "Frosted Slime Hurts");
        //add("sound.morethanadventure.frosted_slime_death", "Frosted Slime Dies");
        add("sound.morethanadventure.glow_spider_ambient", "Glow Spider Hisses");
        add("sound.morethanadventure.glow_spider_hurt", "Glow Spider Hurts");
        add("sound.morethanadventure.glow_spider_death", "Glow Spider Dies");
        add("sound.morethanadventure.host_hurt", "Host Hurts");
        add("sound.morethanadventure.host_death", "Host Dies");
        //add("sound.morethanadventure.icicle_creeper_ambient", "Icicle Creeper Call");
        //add("sound.morethanadventure.icicle_creeper_hurt", "Icicle Creeper Hurts");
        //add("sound.morethanadventure.icicle_creeper_death", "Icicle Creeper Dies");
        //add("sound.morethanadventure.mossy_zombie_ambient", "Mossy Zombie Call");
        //add("sound.morethanadventure.mossy_zombie_hurt", "Mossy Zombie Hurts");
        //add("sound.morethanadventure.mossy_zombie_death", "Mossy Zombie Dies");
        //add("sound.morethanadventure.siren_ambient", "Siren Call");
        //add("sound.morethanadventure.siren_hurt", "Siren Hurts");
        //add("sound.morethanadventure.siren_death", "Siren Dies");
        //add("sound.morethanadventure.skeleton_fighter_ambient", "Skeleton Fighter Call");
        //add("sound.morethanadventure.skeleton_fighter_hurt", "Skeleton Fighter Hurts");
        //add("sound.morethanadventure.skeleton_fighter_death", "Skeleton Fighter Dies");
        //add("sound.morethanadventure.toxic_zombie_ambient", "Toxic Zombie Call");
        //add("sound.morethanadventure.toxic_zombie_hurt", "Toxic Zombie Hurts");
        //add("sound.morethanadventure.toxic_zombie_death", "Toxic Zombie Dies");
        add("sound.morethanadventure.yuki_onna_ambient", "Yuki Onna Moans");
        add("sound.morethanadventure.yuki_onna_hurt", "Yuki Onna Hurts");
        add("sound.morethanadventure.yuki_onna_death", "Yuki Onna Dies");
        //add("sound.morethanadventure.zombified_miner_ambient", "Zombified Miner Call");
        //add("sound.morethanadventure.zombified_miner_hurt", "Zombified Miner Hurts");
        //add("sound.morethanadventure.zombified_miner_death", "Zombified Miner Dies");

        add("sound.morethanadventure.weapons.deep_swing", "Heavy Swing Attack");
        add("sound.morethanadventure.weapons.swing", "Swing Attack");
        add("sound.morethanadventure.weapons.punch", "Punching Attack");
        add("sound.morethanadventure.weapons.scrape", "Scraping Attack");
        add("sound.morethanadventure.weapons.stab_sharp", "Sharp Stab Attack");
        add("sound.morethanadventure.weapons.tear", "Tear Attack");
        add("sound.morethanadventure.weapons.throw", "Throw Attack");
        add("sound.morethanadventure.weapons.whip.hit", "Whip Attack");
        add("sound.morethanadventure.weapons.whip.swing", "Whip Swings");
        add("sound.morethanadventure.weapons.flail.hit", "Flail Attack");
        add("sound.morethanadventure.weapons.flail.swing", "Flail Swings");

        add("sound.morethanadventure.weapons.bow.longbow", "Longbow Fires Arrow");
        add("sound.morethanadventure.weapons.bow.short_bow", "Shortbow Fires Arrow");
        add("sound.morethanadventure.weapons.bow.twinbow", "Twinbow Fires Arrow");

        add("sound.morethanadventure.lightning_bolt.far", "Thunder roars");
        add("sound.morethanadventure.lightning_bolt.very_far", "Thunder roars");

        add("sound.morethanadventure.stove.crackle", "Stove Crackles");
        add("sound.morethanadventure.prickly_pear.shear", "Prickly Pear Sheared");



        add("items.morethanadventure.weapons.tag.throwable", "Throwable Item");
        add("items.morethanadventure.weapons.tag.two_handed", "Two-Handed Weapon");
        add("items.morethanadventure.weapons.tag.causes_bleeding", "Chance to cause Bleeding on Hit");
        add("items.morethanadventure.weapons.tag.stun", "Chance to Stun on Hit");
        add("items.morethanadventure.weapons.info.shift", "Press SHIFT to see chances");
        add("sound.morethanadventure.sprinkler.loop", "Sprinkler Irrigates");

        add("accessories.slot.talisman", "Talisman");



        add("mta.drink.tooltip", "Mix of:");
        add("respawn.mta.pet", "%1$s respawned at %2$s");

        add(MtaTags.Items.THROWABLE, "Throwable Item");
        add(MtaTags.Items.TWO_HANDED, "Two-Handed");
        add(MtaTags.Items.CAUSES_BLEEDING, "Causes Bleeding");
        add(MtaTags.Items.STUN, "Causes Stunning");



        add("mta.container.stove", "Stove");


        this.advancements();
    }

    private void advancements() {
        add("advancements.mta.adventure.root.title", "More Than Adventure!");
        add("advancements.mta.adventure.root.description", "The Root Advancement of More Than Adventure");

        add("advancements.mta.adventure.biomes.title", "More Than Biomes!");
        add("advancements.mta.adventure.biomes.description", "Come across a More Than Adventure Biome");

        add("advancements.mta.adventure.biomes_all.title", "All The Biomes!");
        add("advancements.mta.adventure.biomes_all.description", "Come across all More Than Adventure Biomes");

        add("advancements.mta.adventure.weapon.title", "More Than Swords!");
        add("advancements.mta.adventure.weapon.description", "Obtain yourself a weapon from More Than Adventure");



    }


    private void commands() {
        //%1$s
        //%2$s
        //%3$s


        add("mta.commands.species.error.data", "Could not find Species data for %1$s");
        add("mta.commands.species.set", "Changed Species of %1$s to %2$s");
        add("mta.commands.species.get", "%1$s is of species %2$s");

        //add("", "");




    }


    private String getTalismanDescriptionID(DeferredItem<? extends Item> item){
        return "mta.talisman.description." + BuiltInRegistries.ITEM.getKey(item.get()).getPath();
    }

}
