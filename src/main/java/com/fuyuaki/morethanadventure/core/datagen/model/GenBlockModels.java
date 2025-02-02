package com.fuyuaki.morethanadventure.core.datagen.model;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlocks;
import com.fuyuaki.morethanadventure.core.registry.MTAFamilies;
import com.fuyuaki.morethanadventure.game.client.renderer.special.SprinklerSpecialRenderer;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.client.color.item.GrassColorSource;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class GenBlockModels extends BlockModelGenerators {


    // CLEAR QUARTZ CLUSTER NEEDED

    final Consumer<BlockStateGenerator> blockStateOutput;
    final BiConsumer<ResourceLocation, ModelInstance> modelOutput;

    public GenBlockModels(Consumer<BlockStateGenerator> blockStateOutput, ItemModelOutput itemModelOutput, BiConsumer<ResourceLocation, ModelInstance> modelOutput) {
        super(blockStateOutput, itemModelOutput, modelOutput);
        this.blockStateOutput = blockStateOutput;
        this.modelOutput = modelOutput;
    }

    @Override
    public void run() {
        MTAFamilies.getAllFamilies()
                .filter(BlockFamily::shouldGenerateModel)
                .forEach(p_386718_ -> this.family(p_386718_.getBaseBlock()).generateFor(p_386718_));

        createSprinkler(MtaBlocks.SPRINKLER.get(),Blocks.BIRCH_PLANKS);


        this.createDoublePlantWithDefaultItem(MtaBlocks.CATTAIL.get(),PlantType.NOT_TINTED);
        //simpleBlock(MtaBlocks.CORPSE_LILY.get(), models().cross(blockTexture(MtaBlocks.CORPSE_LILY.get()).getPath(), blockTexture(MtaBlocks.CORPSE_LILY.get())).renderType("cutout"));
        //simpleBlock(MtaBlocks.POTTED_CORPSE_LILY.get(), models().singleTexture("potted_corpse_lily", ResourceLocation.parse("flower_pot_cross"), "plant", blockTexture(MtaBlocks.CORPSE_LILY.get())).renderType("cutout"));
        //simpleBlock(MtaBlocks.PITCHER_PLANT.get(), models().cross(blockTexture(MtaBlocks.PITCHER_PLANT.get()).getPath(), blockTexture(MtaBlocks.PITCHER_PLANT.get())).renderType("cutout"));
        //simpleBlock(MtaBlocks.POTTED_PITCHER_PLANT.get(), models().singleTexture("potted_pitcher_plant", ResourceLocation.parse("flower_pot_cross"), "plant", blockTexture(MtaBlocks.PITCHER_PLANT.get())).renderType("cutout"));
        //blockItem(MtaBlocks.VENUS_FLYTRAP);



        this.woodProvider(MtaBlocks.ALPINE_LOG.get()).logWithHorizontal(MtaBlocks.ALPINE_LOG.get()).wood(MtaBlocks.ALPINE_WOOD.get());
        this.woodProvider(MtaBlocks.STRIPPED_ALPINE_LOG.get()).logWithHorizontal(MtaBlocks.STRIPPED_ALPINE_LOG.get()).wood(MtaBlocks.STRIPPED_ALPINE_WOOD.get());
        createTintedLeaves(MtaBlocks.ALPINE_LEAVES.get(), TexturedModel.LEAVES,FoliageColor.FOLIAGE_DEFAULT);
        this.createPlantWithDefaultItem(MtaBlocks.ALPINE_SAPLING.get(),MtaBlocks.POTTED_ALPINE_SAPLING.get(),PlantType.NOT_TINTED);

        this.woodProvider(MtaBlocks.AVOCADO_LOG.get()).logWithHorizontal(MtaBlocks.AVOCADO_LOG.get()).wood(MtaBlocks.AVOCADO_WOOD.get());
        this.woodProvider(MtaBlocks.STRIPPED_AVOCADO_LOG.get()).logWithHorizontal(MtaBlocks.STRIPPED_AVOCADO_LOG.get()).wood(MtaBlocks.STRIPPED_AVOCADO_WOOD.get());
        this.createCropLeaves(MtaBlocks.AVOCADO_LEAVES.get(), BlockStateProperties.AGE_4,FoliageColor.FOLIAGE_DEFAULT,0,1,2,3,4);
        this.createPlantWithDefaultItem(MtaBlocks.AVOCADO_SAPLING.get(),MtaBlocks.POTTED_AVOCADO_SAPLING.get(),PlantType.NOT_TINTED);

        this.woodProvider(MtaBlocks.BOGGED_OAK_LOG.get()).logWithHorizontal(MtaBlocks.BOGGED_OAK_LOG.get()).wood(MtaBlocks.BOGGED_OAK_WOOD.get());
        this.woodProvider(MtaBlocks.STRIPPED_BOGGED_OAK_LOG.get()).logWithHorizontal(MtaBlocks.STRIPPED_BOGGED_OAK_LOG.get()).wood(MtaBlocks.STRIPPED_BOGGED_OAK_WOOD.get());

        this.woodProvider(MtaBlocks.MANGO_LOG.get()).logWithHorizontal(MtaBlocks.MANGO_LOG.get()).wood(MtaBlocks.MANGO_WOOD.get());
        this.woodProvider(MtaBlocks.STRIPPED_MANGO_LOG.get()).logWithHorizontal(MtaBlocks.STRIPPED_MANGO_LOG.get()).wood(MtaBlocks.STRIPPED_MANGO_WOOD.get());
        this.createCropLeaves(MtaBlocks.MANGO_LEAVES.get(), BlockStateProperties.AGE_4,FoliageColor.FOLIAGE_BIRCH,0,1,2,3,4);
        this.createPlantWithDefaultItem(MtaBlocks.MANGO_SAPLING.get(),MtaBlocks.POTTED_MANGO_SAPLING.get(),PlantType.NOT_TINTED);

        this.woodProvider(MtaBlocks.MAPLE_LOG.get()).logWithHorizontal(MtaBlocks.MAPLE_LOG.get()).wood(MtaBlocks.MAPLE_WOOD.get());
        this.woodProvider(MtaBlocks.STRIPPED_MAPLE_LOG.get()).logWithHorizontal(MtaBlocks.STRIPPED_MAPLE_LOG.get()).wood(MtaBlocks.STRIPPED_MAPLE_WOOD.get());
        createTintedLeaves(MtaBlocks.MAPLE_LEAVES.get(), TexturedModel.LEAVES,FoliageColor.FOLIAGE_DEFAULT);
        this.createPlantWithDefaultItem(MtaBlocks.MAPLE_SAPLING.get(),MtaBlocks.POTTED_MAPLE_SAPLING.get(),PlantType.NOT_TINTED);

        this.woodProvider(MtaBlocks.PALM_LOG.get()).logWithHorizontal(MtaBlocks.PALM_LOG.get()).wood(MtaBlocks.PALM_WOOD.get());
        this.woodProvider(MtaBlocks.STRIPPED_PALM_LOG.get()).logWithHorizontal(MtaBlocks.STRIPPED_PALM_LOG.get()).wood(MtaBlocks.STRIPPED_PALM_WOOD.get());
        createTintedLeaves(MtaBlocks.PALM_LEAVES.get(), TexturedModel.LEAVES,FoliageColor.FOLIAGE_DEFAULT);
        this.createPlantWithDefaultItem(MtaBlocks.PALM_SAPLING.get(),MtaBlocks.POTTED_PALM_SAPLING.get(),PlantType.NOT_TINTED);

        this.woodProvider(MtaBlocks.SEALOG.get()).logWithHorizontal(MtaBlocks.SEALOG.get()).wood(MtaBlocks.SEAWOOD.get());
        createTintedLeaves(MtaBlocks.SEAWOOD_LEAVES.get(), TexturedModel.LEAVES,FoliageColor.FOLIAGE_EVERGREEN);
        this.createCrossBlockWithDefaultItem(MtaBlocks.SEAWOOD_SAPLING.get(), BlockModelGenerators.PlantType.NOT_TINTED);

        this.registerSimpleTintedItemModel(MtaBlocks.SCATTERED_LEAVES.get(),
                this.createFlatItemModelWithBlockTexture(MtaBlocks.SCATTERED_LEAVES.get().asItem(),
                        MtaBlocks.SCATTERED_LEAVES.get()),ItemModelUtils.constantTint(FoliageColor.FOLIAGE_DEFAULT))
        ;
        this.createCrossBlock(MtaBlocks.SHALLOW_GRASS.get(),PlantType.TINTED);
        this.createCrossBlockWithDefaultItem(MtaBlocks.SAND_GRASS.get(),PlantType.NOT_TINTED);
        this.createCrossBlockWithDefaultItem(MtaBlocks.BEACHGRASS.get(), PlantType.NOT_TINTED);
        this.createItemWithGrassTint(MtaBlocks.SHALLOW_GRASS.get());

        this.createTrivialCube(MtaBlocks.PERMAFROST_DIRT.get());

        this.createTrivialCube(MtaBlocks.PERMAFROST_STONE.get());
        this.createAmethystCluster(MtaBlocks.CLEAR_QUARTZ_CLUSTER.get());

        createVerticalBlock(MtaBlocks.STONE_GEYSER.get(), Blocks.STONE, Blocks.STONE,MtaBlocks.STONE_GEYSER.get());
        createVerticalBlock(MtaBlocks.TERRACOTTA_GEYSER.get(), Blocks.TERRACOTTA, Blocks.TERRACOTTA,MtaBlocks.TERRACOTTA_GEYSER.get());
        createVerticalBlock(MtaBlocks.NETHERRACK_GEYSER.get(), Blocks.NETHERRACK, Blocks.NETHERRACK,MtaBlocks.NETHERRACK_GEYSER.get());
        this.createVerticalBlock(MtaBlocks.BASALT_GEYSER.get(), ResourceLocation.withDefaultNamespace("block/basalt_side"), ResourceLocation.withDefaultNamespace("block/basalt_top"),TextureMapping.getBlockTexture(MtaBlocks.BASALT_GEYSER.get()));
        this.createTrivialCube(MtaBlocks.MOSSY_ANDESITE.get());
        this.createTrivialCube(MtaBlocks.NETHER_IRON_ORE.get());
        this.createTrivialCube(MtaBlocks.NETHER_DIAMOND_ORE.get());
        this.createTrivialCube(MtaBlocks.END_LAPIS_ORE.get());
        this.createTrivialCube(MtaBlocks.END_EMERALD_ORE.get());
        this.createTrivialCube(MtaBlocks.CLEAR_QUARTZ_ORE.get());
        this.createTrivialCube(MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_ORE.get());
        this.createTrivialCube(MtaBlocks.CLEAR_QUARTZ_GROWTH.get());
        this.createTrivialCube(MtaBlocks.DEEPSLATE_CLEAR_QUARTZ_GROWTH.get());
        this.createTrivialCube(MtaBlocks.CALCITE_CLEAR_QUARTZ_GROWTH.get());
        this.createTrivialCube(MtaBlocks.QUARTZ_LAMP.get());
        this.createTrivialCube(MtaBlocks.NETHERITIC_CRYSTAL.get());
        this.createTrivialCube(MtaBlocks.POLAR_SAND.get());

        this.createTrivialCube(MtaBlocks.AGATE_ORE.get());
        this.createTrivialCube(MtaBlocks.DEEPSLATE_AGATE_ORE.get());
        this.createTrivialCube(MtaBlocks.ALEXANDRITE_ORE.get());
        this.createTrivialCube(MtaBlocks.DEEPSLATE_ALEXANDRITE_ORE.get());
        this.createTrivialCube(MtaBlocks.AQUAMARINE_ORE.get());
        this.createTrivialCube(MtaBlocks.DEEPSLATE_AQUAMARINE_ORE.get());
        this.createTrivialCube(MtaBlocks.BLOODSTONE_ORE.get());
        this.createTrivialCube(MtaBlocks.DEEPSLATE_BLOODSTONE_ORE.get());
        this.createTrivialCube(MtaBlocks.CELESTITE_ORE.get());
        this.createTrivialCube(MtaBlocks.DEEPSLATE_CELESTITE_ORE.get());
        this.createTrivialCube(MtaBlocks.CRYOLITE_ORE.get());
        this.createTrivialCube(MtaBlocks.GARNET_ORE.get());
        this.createTrivialCube(MtaBlocks.DEEPSLATE_GARNET_ORE.get());
        this.createTrivialCube(MtaBlocks.MOONSTONE_ORE.get());
        this.createTrivialCube(MtaBlocks.DEEPSLATE_MOONSTONE_ORE.get());
        this.createTrivialCube(MtaBlocks.COBBLED_DIRT.get());

        this.registerSimpleItemModel(MtaBlocks.COARSE_DIRT_PATH.asItem(),ModelLocationUtils.getModelLocation(MtaBlocks.COARSE_DIRT_PATH.get()));
        this.registerSimpleItemModel(MtaBlocks.SAND_PATH.asItem(),ModelLocationUtils.getModelLocation(MtaBlocks.SAND_PATH.get()));
        this.registerSimpleTintedItemModel(MtaBlocks.GRASSY_DIRT.get(),ModelLocationUtils.getModelLocation(MtaBlocks.GRASSY_DIRT.get()),new GrassColorSource());
        this.registerSimpleTintedItemModel(MtaBlocks.PERMAFROST_GRASS.get(),ModelLocationUtils.getModelLocation(MtaBlocks.PERMAFROST_GRASS.get()),new GrassColorSource());

        this.createGrassLikeBlock(MtaBlocks.TUNDRA_GRASS.get(),MtaBlocks.PERMAFROST_DIRT.get(),false);


        this.createCropBlock(MtaBlocks.ONION_CROP.get(), BlockStateProperties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);
        this.createCropBlock(MtaBlocks.TOMATO_CROP.get(), BlockStateProperties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);
        this.createCropBlock(MtaBlocks.BELL_PEPPER_CROP.get(), BlockStateProperties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);
        this.createCropBlock(MtaBlocks.CHILI_PEPPER_CROP.get(), BlockStateProperties.AGE_7, 0, 1, 2, 3, 4, 5, 6, 7);

    }

    public void createVerticalBlock(Block block, Block side, Block bottom, Block top){
        TextureMapping texturemapping = new TextureMapping()
                .put(TextureSlot.BOTTOM, TextureMapping.getBlockTexture(bottom))
                .put(TextureSlot.TOP, TextureMapping.getBlockTexture(top))
                .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(side));
        this.blockStateOutput.accept(createSimpleBlock(block, ModelTemplates.CUBE_BOTTOM_TOP.create(block, texturemapping, this.modelOutput)));
    }
    public void createVerticalBlock(Block block, ResourceLocation side, ResourceLocation bottom, ResourceLocation top){
        TextureMapping texturemapping = new TextureMapping()
                .put(TextureSlot.BOTTOM, bottom)
                .put(TextureSlot.TOP, side)
                .put(TextureSlot.SIDE, top);
        this.blockStateOutput.accept(createSimpleBlock(block, ModelTemplates.CUBE_BOTTOM_TOP.create(block, texturemapping, this.modelOutput)));
    }
    public void createGrassBlock(Block block, Block dirt, Block top,boolean snow) {
        ResourceLocation resourcelocation = TextureMapping.getBlockTexture(dirt);

        ResourceLocation resourcelocation1 = TexturedModel.CUBE_TOP_BOTTOM
                .get(block)
                .updateTextures(p_388599_ -> p_388599_.put(TextureSlot.BOTTOM, resourcelocation))
                .create(block, this.modelOutput);
        if (snow) {
            TextureMapping texturemapping = new TextureMapping()
                    .put(TextureSlot.BOTTOM, resourcelocation)
                    .copyForced(TextureSlot.BOTTOM, TextureSlot.PARTICLE)
                    .put(TextureSlot.TOP, TextureMapping.getBlockTexture(top, "_top"))
                    .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_snow"));
            Variant variant = Variant.variant()
                    .with(VariantProperties.MODEL, ModelTemplates.CUBE_BOTTOM_TOP.createWithSuffix(block, "_snow", texturemapping, this.modelOutput));
            List<Variant> list = Arrays.asList(createRotatedVariants(resourcelocation1));
            this.blockStateOutput
                    .accept(
                            MultiVariantGenerator.multiVariant(block)
                                    .with(PropertyDispatch.property(BlockStateProperties.SNOWY).select(true, variant).select(false, list))
                    );
        }
        else {
            this.blockStateOutput
                    .accept(
                            MultiVariantGenerator.multiVariant(block, createRotatedVariants(resourcelocation1))
                    );
        }
    }

    public void createGrassBlock(Block block, Block dirt,boolean snow) {
    this.createGrassBlock(block,dirt,block,snow);
    }


    public void createGrassLikeBlock(Block block, Block dirt, Block top,boolean snow) {
        ResourceLocation resourcelocation = TextureMapping.getBlockTexture(dirt);

        ResourceLocation resourcelocation1 = TexturedModel.CUBE_TOP_BOTTOM
                .get(block)
                .updateTextures(p_388599_ -> p_388599_.put(TextureSlot.BOTTOM, resourcelocation))
                .create(block, this.modelOutput);
        if (snow) {
            TextureMapping texturemapping = new TextureMapping()
                    .put(TextureSlot.BOTTOM, resourcelocation)
                    .copyForced(TextureSlot.BOTTOM, TextureSlot.PARTICLE)
                    .put(TextureSlot.TOP, TextureMapping.getBlockTexture(top, "_top"))
                    .put(TextureSlot.SIDE, TextureMapping.getBlockTexture(block, "_snow"));
            Variant variant = Variant.variant()
                    .with(VariantProperties.MODEL, ModelTemplates.CUBE_BOTTOM_TOP.createWithSuffix(block, "_snow", texturemapping, this.modelOutput));
            List<Variant> list = Arrays.asList(createRotatedVariants(resourcelocation1));
            this.blockStateOutput
                    .accept(
                            MultiVariantGenerator.multiVariant(block)
                                    .with(PropertyDispatch.property(BlockStateProperties.SNOWY).select(true, variant).select(false, list))
                    );
        }
        else {
            this.blockStateOutput
                    .accept(
                            MultiVariantGenerator.multiVariant(block, createRotatedVariants(resourcelocation1))
                    );
        }
        this.registerSimpleTintedItemModel(block, ModelLocationUtils.getModelLocation(block), new GrassColorSource());

    }
    public void createGrassLikeBlock(Block block, Block dirt,boolean snow) {
    this.createGrassLikeBlock(block,dirt,block,snow);

    }


    public void createSprinkler(Block block, Block particleBlock){
        this.createParticleOnlyBlock(block, particleBlock);
        Item item = block.asItem();
        ResourceLocation resourcelocation = MTAModelTemplates.SPRINKLER_INVENTORY.create(item, TextureMapping.particle(particleBlock), this.modelOutput);
        ItemModel.Unbaked itemmodel$unbaked = ItemModelUtils.specialModel(resourcelocation, new SprinklerSpecialRenderer.Unbaked());

            this.itemModelOutput.accept(item, itemmodel$unbaked);

    }


    public void createCropLeaves(Block block, Property<Integer> ageProperty, int tint, int... ageToVisualStageMapping) {
        if (ageProperty.getPossibleValues().size() != ageToVisualStageMapping.length) {
            throw new IllegalArgumentException();
        } else {
            Int2ObjectMap<ResourceLocation> int2objectmap = new Int2ObjectOpenHashMap<>();
            PropertyDispatch propertydispatch = PropertyDispatch.property(ageProperty)
                    .generate(
                            integer -> {
                                int i = ageToVisualStageMapping[integer];
                                ResourceLocation resourcelocation = int2objectmap.computeIfAbsent(
                                        i, p_387534_ -> this.createSuffixedVariant(block, "_stage" + i, ModelTemplates.LEAVES, TextureMapping::cube)
                                );
                                return Variant.variant().with(VariantProperties.MODEL, resourcelocation);
                            }
                    );
            ResourceLocation resourcelocation = TexturedModel.LEAVES.create(block, this.modelOutput);

            this.registerSimpleTintedItemModel(block, resourcelocation.withSuffix("_stage4"), ItemModelUtils.constantTint(tint));

            this.blockStateOutput.accept(MultiVariantGenerator.multiVariant(block).with(propertydispatch));
        }
    }


}
