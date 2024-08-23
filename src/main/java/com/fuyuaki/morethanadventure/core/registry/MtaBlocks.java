package com.fuyuaki.morethanadventure.core.registry;

import com.fuyuaki.morethanadventure.game.worldgen.tree.MtaTreeGrower;
import com.fuyuaki.morethanadventure.world.block.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MtaBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);


    public static final DeferredBlock<Sprinkler> SPRINKLER = registerBlock("sprinkler",() -> new Sprinkler(
            BlockBehaviour.Properties.of()
                    .strength(5.0F)
                    .sound(SoundType.METAL)
                    .noOcclusion()));

    public static final DeferredBlock<Block> PALM_LOG = registerBlock("palm_log", () -> new MtaFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));
    public static final DeferredBlock<Block> STRIPPED_PALM_LOG = registerBlock("stripped_palm_log", () -> new MtaFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG)));
    public static final DeferredBlock<Block> PALM_WOOD = registerBlock("palm_wood", () -> new MtaFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD)));
    public static final DeferredBlock<Block> STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood", () -> new MtaFlammableRotatedPillarBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD)));

    public static final DeferredBlock<Block> PALM_PLANKS = registerBlock("palm_planks", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS)) {
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 20;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 5;
        }
    });
    public static final DeferredBlock<Block> PALM_LEAVES = registerBlock("palm_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)) {
        @Override
        public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return true;
        }

        @Override
        public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 60;
        }

        @Override
        public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
            return 30;
        }
    });

    public static final DeferredBlock<Block> PALM_SAPLING = registerBlock("palm_sapling",
            () -> new SaplingBlock(MtaTreeGrower.PALM_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_SAPLING)){
                @Override
                protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
                    return super.mayPlaceOn(pState, pLevel, pPos) || pState.is(BlockTags.SAND);
                }
            });

    public static final DeferredBlock<Block> PALM_STAIRS = registerBlock("palm_stairs",
            () -> new StairBlock(MtaBlocks.PALM_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS)));
    public static final DeferredBlock<Block> PALM_SLAB = registerBlock("palm_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB)));

    public static final DeferredBlock<Block> PALM_PRESSURE_PLATE = registerBlock("palm_pressure_plate",
            () -> new PressurePlateBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE)));
    public static final DeferredBlock<Block> PALM_BUTTON = registerBlock("palm_button",
            () -> new ButtonBlock(BlockSetType.OAK, 10, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON)));

    public static final DeferredBlock<Block> PALM_FENCE = registerBlock("palm_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE)));
    public static final DeferredBlock<Block>PALM_FENCE_GATE = registerBlock("palm_fence_gate",
            () -> new FenceGateBlock(WoodType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE)));

    public static final DeferredBlock<Block> PALM_DOOR = registerBlock("palm_door",
            () -> new DoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR)));
    public static final DeferredBlock<Block> PALM_TRAPDOOR = registerBlock("palm_trapdoor",
            () -> new TrapDoorBlock(BlockSetType.OAK, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR)));







    public static final DeferredBlock<GeyserBlock> STONE_GEYSER = registerBlock("stone_geyser",() -> new GeyserBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE),false
    ));

    public static final DeferredBlock<GeyserBlock> TERRACOTTA_GEYSER = registerBlock("terracotta_geyser",() -> new GeyserBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.TERRACOTTA),false
    ));

    public static final DeferredBlock<GeyserBlock> NETHERRACK_GEYSER = registerBlock("netherrack_geyser",() -> new GeyserBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.NETHERRACK)
                    .strength(1.25F, 4.2F),true
    ));

    public static final DeferredBlock<GeyserBlock> BASALT_GEYSER = registerBlock("basalt_geyser",() -> new GeyserBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.BASALT), true
    ));

    public static final DeferredBlock<ShardClusterBlock> CLEAR_QUARTZ_CLUSTER = registerBlock("clear_quartz_cluster",
            () -> new ShardClusterBlock(
                    BlockBehaviour.Properties.ofFullCopy(Blocks.AMETHYST_CLUSTER)
            ));




    public static final DeferredBlock<Block> MOSSY_ANDESITE = registerBlock("mossy_andesite", BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE));

    public static final DeferredBlock<ShardGrowthBlock> CALCITE_CLEAR_QUARTZ_GROWTH = registerBlock("calcite_clear_quartz_growth",
            () -> new ShardGrowthBlock(Blocks.CALCITE,MtaBlocks.CLEAR_QUARTZ_CLUSTER.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE).strength(12.0F).randomTicks()
            ));
    public static final DeferredBlock<ShardGrowthBlock> DEEPSLATE_CLEAR_QUARTZ_GROWTH = registerBlock("deepslate_clear_quartz_growth",
            () -> new ShardGrowthBlock(Blocks.DEEPSLATE,MtaBlocks.CLEAR_QUARTZ_CLUSTER.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).strength(12.0F).randomTicks()
            ));
    public static final DeferredBlock<ShardGrowthBlock> CLEAR_QUARTZ_GROWTH = registerBlock("clear_quartz_growth",
            () -> new ShardGrowthBlock(Blocks.STONE,MtaBlocks.CLEAR_QUARTZ_CLUSTER.get(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(12.0F).randomTicks()
            ));


    public static final DeferredBlock<DropExperienceBlock> CLEAR_QUARTZ_ORE = registerBlock("clear_quartz_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(4, 6),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
            ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_CLEAR_QUARTZ_ORE = registerBlock("deepslate_clear_quartz_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(5, 7),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)
            ));

    public static final DeferredBlock<DropExperienceBlock> NETHER_IRON_ORE = registerBlock("nether_iron_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> NETHER_DIAMOND_ORE = registerBlock("nether_diamond_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(3, 8),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE)
            ));

    public static final DeferredBlock<DropExperienceBlock> END_LAPIS_ORE = registerBlock("end_lapis_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(6, 10),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)
            ));
    public static final DeferredBlock<DropExperienceBlock> END_EMERALD_ORE = registerBlock("end_emerald_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(6, 14),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)
            ));


    public static final DeferredBlock<DropExperienceBlock> NETHERITIC_CRYSTAL = registerBlock("netheritic_crystal",
            () -> new DropExperienceBlock(
                    UniformInt.of(1, 35),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE)
                            .strength(5.0F, 32.0F)

            ));


    public static final DeferredBlock<SandPathBlock> SAND_PATH = registerBlock("sand_path",() -> new SandPathBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.DIRT_PATH)
    ));

    public static final DeferredBlock<Block> GRASSY_DIRT = registerBlock("grassy_dirt",
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.DIRT)
    );

    public static final DeferredBlock<Block> COBBLED_DIRT = registerBlock("cobbled_dirt",
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.DIRT)
                    .strength(1.0F,3.0F)
    );

    public static final DeferredBlock<Block> COARSE_DIRT_PATH = registerBlock("coarse_dirt_path",() -> new MTAPathBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.COARSE_DIRT)
            , Blocks.DIRT)
    );

    public static final DeferredBlock<Block> STONE_TILES = registerBlock("stone_tiles", () -> new StoneTilesBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_BRICKS) ,0)
    );
    public static final DeferredBlock<Block> SLIGHTLY_DIRTY_STONE_TILES = registerBlock("slightly_dirty_stone_tiles", () -> new StoneTilesBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(MtaBlocks.STONE_TILES.get()) ,1)
    );
    public static final DeferredBlock<Block> DIRTY_STONE_TILES = registerBlock("dirty_stone_tiles", () -> new StoneTilesBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES.get()) ,2)
    );
    public static final DeferredBlock<Block> VERY_DIRTY_STONE_TILES = registerBlock("very_dirty_stone_tiles", () -> new StoneTilesBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(MtaBlocks.DIRTY_STONE_TILES.get()), 3)
    );

    public static final DeferredBlock<Block> SWEET_BERRY_LEAVES = registerBlock("sweet_berry_leaves", () -> new SweetBerryLeavesBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.SPRUCE_LEAVES)
                    .sound(SoundType.SWEET_BERRY_BUSH))
    );


    public static final DeferredBlock<DropExperienceBlock> AGATE_ORE = registerBlock("agate_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 5),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_AGATE_ORE = registerBlock("deepslate_agate_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 5),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_EMERALD_ORE)
            ));

    public static final DeferredBlock<DropExperienceBlock> ALEXANDRITE_ORE = registerBlock("alexandrite_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 5),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_ALEXANDRITE_ORE = registerBlock("deepslate_alexandrite_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 5),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_EMERALD_ORE)
            ));

    public static final DeferredBlock<DropExperienceBlock> AQUAMARINE_ORE = registerBlock("aquamarine_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 5),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_AQUAMARINE_ORE = registerBlock("deepslate_aquamarine_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 5),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_EMERALD_ORE)
            ));

    public static final DeferredBlock<DropExperienceBlock> CELESTITE_ORE = registerBlock("celestite_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 5),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_CELESTITE_ORE = registerBlock("deepslate_celestite_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 5),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_EMERALD_ORE)
            ));

    public static final DeferredBlock<DropExperienceBlock> GARNET_ORE = registerBlock("garnet_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 5),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_GARNET_ORE = registerBlock("deepslate_garnet_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 5),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_EMERALD_ORE)
            ));

    public static final DeferredBlock<DropExperienceBlock> MOONSTONE_ORE = registerBlock("moonstone_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 5),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_MOONSTONE_ORE = registerBlock("deepslate_moonstone_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 5),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_EMERALD_ORE)
            ));


    public static final DeferredBlock<Block> QUARTZ_LAMP = registerBlock("quartz_lamp", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SEA_LANTERN)));

    public static final DeferredBlock<Block> ONION_CROP = BLOCKS.register("onion_crop", () -> new OnionCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final DeferredBlock<Block> TOMATO_CROP = BLOCKS.register("tomato_crop", () -> new TomatoCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final DeferredBlock<Block> BELL_PEPPER_CROP = BLOCKS.register("bell_pepper_crop", () -> new BellPepperCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final DeferredBlock<Block> CHILI_PEPPER_CROP = BLOCKS.register("chili_pepper_crop", () -> new ChiliPepperCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));













    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

    private static <I extends Block> DeferredBlock<I> registerBlock(String name, Supplier<? extends I> block) {
        DeferredBlock<I> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <I extends Block> DeferredBlock<Block> registerNoItemBlock(String name, Supplier<? extends I> block) {
        return BLOCKS.register(name, block);
    }

    private static  DeferredBlock<Block> registerBlock(String name, BlockBehaviour.Properties block){
        DeferredBlock<Block> toReturn = BLOCKS.registerSimpleBlock(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    } private static  DeferredBlock<Block> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends Block> func, BlockBehaviour.Properties block){
        DeferredBlock<Block> toReturn = BLOCKS.registerBlock(name,func,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        MtaItems.ITEMS.registerSimpleBlockItem(name, block);
    }
    private static DeferredBlock<Block> registerCustomItemPropertiesBlock(String name, BlockBehaviour.Properties block, Item.Properties properties){
        DeferredBlock<Block>  toReturn = BLOCKS.registerSimpleBlock(name,block);
        registerCustomBlockItem(name, toReturn, properties);
        return toReturn;
    }
    private static <T extends Block> void registerCustomBlockItem(String name, DeferredBlock<T> block, Item.Properties properties){
        MtaItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    }


    protected static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
        return blockState -> blockState.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
    }

    private static Block log(MapColor pTopMapColor, MapColor pSideMapColor) {
        return new RotatedPillarBlock(
                BlockBehaviour.Properties.of()
                        .mapColor(p_152624_ -> p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? pTopMapColor : pSideMapColor)
                        .instrument(NoteBlockInstrument.BASS)
                        .strength(2.0F)
                        .sound(SoundType.WOOD)
                        .ignitedByLava()
        );
    }
    private static BlockBehaviour.Properties leaves(SoundType pSoundType) {
        return (
                BlockBehaviour.Properties.of()
                        .mapColor(MapColor.PLANT)
                        .strength(0.2F)
                        .randomTicks()
                        .sound(pSoundType)
                        .noOcclusion()
                        .isValidSpawn(MtaBlocks::ocelotOrParrot)
                        .isSuffocating(MtaBlocks::never)
                        .isViewBlocking(MtaBlocks::never)
                        .ignitedByLava()
                        .pushReaction(PushReaction.DESTROY)
                        .isRedstoneConductor(MtaBlocks::never)
        );
    }



    private static Block stair(Block pBaseBlock) {
        return new StairBlock(pBaseBlock.defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(pBaseBlock));
    }

    private static Boolean never(BlockState p_50779_, BlockGetter p_50780_, BlockPos p_50781_, EntityType<?> p_50782_) {
        return false;
    }

    private static Boolean always(BlockState p_50810_, BlockGetter p_50811_, BlockPos p_50812_, EntityType<?> p_50813_) {
        return true;
    }


    private static boolean always(BlockState p_50775_, BlockGetter p_50776_, BlockPos p_50777_) {
        return true;
    }

    private static boolean never(BlockState p_50806_, BlockGetter p_50807_, BlockPos p_50808_) {
        return false;
    }

    private static Boolean ocelotOrParrot(BlockState p_50822_, BlockGetter p_50823_, BlockPos p_50824_, EntityType<?> p_50825_) {
        return p_50825_ == EntityType.OCELOT || p_50825_ == EntityType.PARROT;
    }


    private static Block woodenButton(BlockSetType pType) {
        return new ButtonBlock(pType, 30, BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY));
    }


    private static Block flowerPot(Block pPotted) {
        return new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, () -> pPotted, BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY));
    }
}

