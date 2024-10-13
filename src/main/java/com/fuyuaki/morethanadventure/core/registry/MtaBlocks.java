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
import net.minecraft.world.item.DyeColor;
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


    public static final DeferredBlock<Block> SHALLOW_GRASS = registerBlock("shallow_grass",
            () -> new ShortGrassBlock(
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT)
                            .replaceable()
                            .noCollission()
                            .instabreak()
                            .sound(SoundType.GRASS)
                            .offsetType(BlockBehaviour.OffsetType.XYZ)
                            .ignitedByLava()
                            .pushReaction(PushReaction.DESTROY)
            )
    );
    public static final DeferredBlock<Block> PERMAFROST_DIRT = registerBlock("permafrost_dirt",
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.DIRT)
    );
    public static final DeferredBlock<Block> PERMAFROST_STONE = registerBlock("permafrost_stone",
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE)
    );

    public static final DeferredBlock<Block> PERMAFROST_GRASS = registerBlock("permafrost_grass",
            () -> new PermafrostDirtBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.GRASS_BLOCK)
            )
    );
    public static final DeferredBlock<Block> TUNDRA_GRASS = registerBlock("tundra_grass",
            () -> new PermafrostDirtBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.PODZOL)
            )
    );

    public static final DeferredBlock<Block> STONE_TILES = registerBlock("stone_tiles", () -> new StoneTilesBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.STONE_BRICKS) ,0)
    );
    public static final DeferredBlock<Block> STONE_TILES_STAIRS = registerBlock("stone_tiles_stairs",
            () -> new StairBlock(MtaBlocks.STONE_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_STAIRS)));
    public static final DeferredBlock<Block> STONE_TILES_SLAB = registerBlock("stone_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_SLAB)));

    public static final DeferredBlock<Block> STONE_TILES_WALL = registerBlock("stone_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL)));

    public static final DeferredBlock<Block> SLIGHTLY_DIRTY_STONE_TILES = registerBlock("slightly_dirty_stone_tiles", () -> new StoneTilesBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(MtaBlocks.STONE_TILES.get()) ,1)
    );

    public static final DeferredBlock<Block> SLIGHTLY_DIRTY_STONE_TILES_STAIRS = registerBlock("slightly_dirty_stone_tiles_stairs",
            () -> new StairBlock(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.STONE_TILES_STAIRS.get()))
    );
    public static final DeferredBlock<Block> SLIGHTLY_DIRTY_STONE_TILES_SLAB = registerBlock("slightly_dirty_stone_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.STONE_TILES_SLAB.get()))
    );

    public static final DeferredBlock<Block> SLIGHTLY_DIRTY_STONE_TILES_WALL = registerBlock("sightly_dirty_stone_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.STONE_TILES_WALL.get()))
    );
    public static final DeferredBlock<Block> DIRTY_STONE_TILES = registerBlock("dirty_stone_tiles", () -> new StoneTilesBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES.get()) ,2)
    );

    public static final DeferredBlock<Block> DIRTY_STONE_TILES_STAIRS = registerBlock("dirty_stone_tiles_stairs",
            () -> new StairBlock(MtaBlocks.DIRTY_STONE_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_STAIRS.get()))
    );
    public static final DeferredBlock<Block> DIRTY_STONE_TILES_SLAB = registerBlock("dirty_stone_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_SLAB.get()))
    );

    public static final DeferredBlock<Block> DIRTY_STONE_TILES_WALL = registerBlock("dirty_stone_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.SLIGHTLY_DIRTY_STONE_TILES_WALL.get()))
    );
    public static final DeferredBlock<Block> VERY_DIRTY_STONE_TILES = registerBlock("very_dirty_stone_tiles", () -> new StoneTilesBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(MtaBlocks.DIRTY_STONE_TILES.get()), 3)
    );

    public static final DeferredBlock<Block> VERY_DIRTY_STONE_TILES_STAIRS = registerBlock("very_dirty_stone_tiles_stairs",
            () -> new StairBlock(MtaBlocks.VERY_DIRTY_STONE_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.DIRTY_STONE_TILES_STAIRS.get()))
    );
    public static final DeferredBlock<Block> VERY_DIRTY_STONE_TILES_SLAB = registerBlock("very_dirty_stone_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.DIRTY_STONE_TILES_SLAB.get()))
    );

    public static final DeferredBlock<Block> VERY_DIRTY_STONE_TILES_WALL = registerBlock("very_dirty_stone_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.DIRTY_STONE_TILES_WALL.get()))
    );

    public static final DeferredBlock<Block> SWEET_BERRY_LEAVES = registerBlock("sweet_berry_leaves", () -> new SweetBerryLeavesBlock(
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.SPRUCE_LEAVES)
                    .sound(SoundType.SWEET_BERRY_BUSH))
    );


    public static final DeferredBlock<DropExperienceBlock> AGATE_ORE = registerBlock("agate_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 16),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_AGATE_ORE = registerBlock("deepslate_agate_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 16),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_EMERALD_ORE)
            ));

    public static final DeferredBlock<DropExperienceBlock> ALEXANDRITE_ORE = registerBlock("alexandrite_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 16),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_ALEXANDRITE_ORE = registerBlock("deepslate_alexandrite_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 16),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_EMERALD_ORE)
            ));

    public static final DeferredBlock<DropExperienceBlock> AQUAMARINE_ORE = registerBlock("aquamarine_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 16),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_AQUAMARINE_ORE = registerBlock("deepslate_aquamarine_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 16),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_EMERALD_ORE)
            ));

    public static final DeferredBlock<DropExperienceBlock> BLOODSTONE_ORE = registerBlock("bloodstone_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 16),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_BLOODSTONE_ORE = registerBlock("deepslate_bloodstone_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 16),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_EMERALD_ORE)
            ));

    public static final DeferredBlock<DropExperienceBlock> CELESTITE_ORE = registerBlock("celestite_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 16),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> CRYOLITE_ORE = registerBlock("cryolite_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 16),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE).sound(SoundType.GLASS).lightLevel(l -> 4).friction(0.5F)
            ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_CELESTITE_ORE = registerBlock("deepslate_celestite_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 16),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_EMERALD_ORE)
            ));

    public static final DeferredBlock<DropExperienceBlock> GARNET_ORE = registerBlock("garnet_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 16),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_GARNET_ORE = registerBlock("deepslate_garnet_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 16),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_EMERALD_ORE)
            ));

    public static final DeferredBlock<DropExperienceBlock> MOONSTONE_ORE = registerBlock("moonstone_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 16),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.EMERALD_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_MOONSTONE_ORE = registerBlock("deepslate_moonstone_ore",
            () -> new DropExperienceBlock(
                    UniformInt.of(2, 16),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_EMERALD_ORE)
            ));

    //Terracotta

    public static final DeferredBlock<Block> TERRACOTTA_SLAB = registerBlock("terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> TERRACOTTA_STAIRS = registerBlock("terracotta_stairs",
            () -> new StairBlock(Blocks.TERRACOTTA.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> TERRACOTTA_WALL = registerBlock("terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));

    public static final DeferredBlock<Block> WHITE_TERRACOTTA_SLAB = registerBlock("white_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> WHITE_TERRACOTTA_STAIRS = registerBlock("white_terracotta_stairs",
            () -> new StairBlock(Blocks.WHITE_TERRACOTTA.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> WHITE_TERRACOTTA_WALL = registerBlock("white_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));

    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_SLAB = registerBlock("light_gray_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_STAIRS = registerBlock("light_gray_terracotta_stairs",
            () -> new StairBlock(Blocks.LIGHT_GRAY_TERRACOTTA.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F)));

    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_WALL = registerBlock("light_gray_terracottas_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));

    public static final DeferredBlock<Block> GRAY_TERRACOTTA_SLAB = registerBlock("gray_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_STAIRS = registerBlock("gray_terracotta_stairs",
            () -> new StairBlock(Blocks.GRAY_TERRACOTTA.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_WALL = registerBlock("gray_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));

    public static final DeferredBlock<Block> BLACK_TERRACOTTA_SLAB = registerBlock("black_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_STAIRS = registerBlock("black_terracotta_stairs",
            () -> new StairBlock(Blocks.BLACK_TERRACOTTA.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_WALL = registerBlock("black_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLACK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));

    public static final DeferredBlock<Block> BROWN_TERRACOTTA_SLAB = registerBlock("brown_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_STAIRS = registerBlock("brown_terracotta_stairs",
            () -> new StairBlock(Blocks.BROWN_TERRACOTTA.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_WALL = registerBlock("brown_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));

    public static final DeferredBlock<Block> RED_TERRACOTTA_SLAB = registerBlock("red_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> RED_TERRACOTTA_STAIRS = registerBlock("red_terracotta_stairs",
            () -> new StairBlock(Blocks.RED_TERRACOTTA.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> RED_TERRACOTTA_WALL = registerBlock("red_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));

    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_SLAB = registerBlock("orange_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_STAIRS = registerBlock("orange_terracotta_stairs",
            () -> new StairBlock(Blocks.ORANGE_TERRACOTTA.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_WALL = registerBlock("orange_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));

    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_SLAB = registerBlock("yellow_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_STAIRS = registerBlock("yellow_terracotta_stairs",
            () -> new StairBlock(Blocks.YELLOW_TERRACOTTA.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_WALL = registerBlock("yellow_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));

    public static final DeferredBlock<Block> LIME_TERRACOTTA_SLAB = registerBlock("lime_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> LIME_TERRACOTTA_STAIRS = registerBlock("lime_terracotta_stairs",
            () -> new StairBlock(Blocks.LIME_TERRACOTTA.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> LIME_TERRACOTTA_WALL = registerBlock("lime_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));

    public static final DeferredBlock<Block> GREEN_TERRACOTTA_SLAB = registerBlock("green_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_STAIRS = registerBlock("green_terracotta_stairs",
            () -> new StairBlock(Blocks.GREEN_TERRACOTTA.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_WALL = registerBlock("green_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));

    public static final DeferredBlock<Block> CYAN_TERRACOTTA_SLAB = registerBlock("cyan_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_CYAN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_STAIRS = registerBlock("cyan_terracotta_stairs",
            () -> new StairBlock(Blocks.CYAN_TERRACOTTA.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_CYAN)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_WALL = registerBlock("cyan_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_CYAN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));

    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_SLAB = registerBlock("light_blue_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_STAIRS = registerBlock("light_blue_terracotta_stairs",
            () -> new StairBlock(Blocks.LIGHT_BLUE_TERRACOTTA.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GREEN)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_WALL = registerBlock("light_blue_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_SLAB = registerBlock("blue_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_STAIRS = registerBlock("blue_terracotta_stairs",
            () -> new StairBlock(Blocks.BLUE_TERRACOTTA.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_WALL = registerBlock("blue_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_SLAB = registerBlock("purple_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_STAIRS = registerBlock("purple_terracotta_stairs",
            () -> new StairBlock(Blocks.PURPLE_TERRACOTTA.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_WALL = registerBlock("purple_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PURPLE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_SLAB = registerBlock("magenta_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_MAGENTA)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_STAIRS = registerBlock("magenta_terracottastairs",
            () -> new StairBlock(Blocks.MAGENTA_TERRACOTTA.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_MAGENTA)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_WALL = registerBlock("magenta_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_MAGENTA)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));

    public static final DeferredBlock<Block> PINK_TERRACOTTA_SLAB = registerBlock("pink_terracotta_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> PINK_TERRACOTTA_STAIRS = registerBlock("pink_terracotta_stairs",
            () -> new StairBlock(Blocks.PINK_TERRACOTTA.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F)));
    public static final DeferredBlock<Block> PINK_TERRACOTTA_WALL = registerBlock("pink_terracotta_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_PINK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.25F, 4.2F)));


    public static final DeferredBlock<Block> TERRACOTTA_TILES = registerBlock("terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA));
    public static final DeferredBlock<Block> TERRACOTTA_TILES_SLAB = registerBlock("terracotta_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.TERRACOTTA_SLAB.get())));
    public static final DeferredBlock<Block> TERRACOTTA_TILES_STAIRS = registerBlock("terracotta_tiles_stairs",
            () -> new StairBlock(MtaBlocks.TERRACOTTA_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.TERRACOTTA_STAIRS.get())));
    public static final DeferredBlock<Block> TERRACOTTA_TILES_WALL = registerBlock("terracotta_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.TERRACOTTA_WALL.get())));

    public static final DeferredBlock<Block> WHITE_TERRACOTTA_TILES = registerBlock("white_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA));
    public static final DeferredBlock<Block> WHITE_TERRACOTTA_TILES_SLAB = registerBlock("white_terracotta_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.WHITE_TERRACOTTA_SLAB.get())));
    public static final DeferredBlock<Block> WHITE_TERRACOTTA_TILES_STAIRS = registerBlock("white_terracotta_tiles_stairs",
            () -> new StairBlock(MtaBlocks.WHITE_TERRACOTTA_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.WHITE_TERRACOTTA_STAIRS.get())));
    public static final DeferredBlock<Block> WHITE_TERRACOTTA_TILES_WALL = registerBlock("white_terracotta_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.WHITE_TERRACOTTA_WALL.get())));

    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_TILES = registerBlock("light_gray_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA));
    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_TILES_SLAB = registerBlock("light_gray_terracotta_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.LIGHT_GRAY_TERRACOTTA_SLAB.get())));
    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_TILES_STAIRS = registerBlock("light_gray_terracotta_tiles_stairs",
            () -> new StairBlock(MtaBlocks.LIGHT_GRAY_TERRACOTTA_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS.get())));
    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_TILES_WALL = registerBlock("light_gray_terracottas_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.LIGHT_GRAY_TERRACOTTA_WALL.get())));

    public static final DeferredBlock<Block> GRAY_TERRACOTTA_TILES = registerBlock("gray_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA));
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_TILES_SLAB = registerBlock("gray_terracotta_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.GRAY_TERRACOTTA_SLAB.get())));
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_TILES_STAIRS = registerBlock("gray_terracotta_tiles_stairs",
            () -> new StairBlock(MtaBlocks.GRAY_TERRACOTTA_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.GRAY_TERRACOTTA_STAIRS.get())));
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_TILES_WALL = registerBlock("gray_terracotta_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.GRAY_TERRACOTTA_WALL.get())));

    public static final DeferredBlock<Block> BLACK_TERRACOTTA_TILES = registerBlock("black_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA));
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_TILES_SLAB = registerBlock("black_terracotta_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.BLACK_TERRACOTTA_SLAB.get())));
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_TILES_STAIRS = registerBlock("black_terracotta_tiles_stairs",
            () -> new StairBlock(MtaBlocks.BLACK_TERRACOTTA_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.BLACK_TERRACOTTA_STAIRS.get())));
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_TILES_WALL = registerBlock("black_terracotta_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.BLACK_TERRACOTTA_WALL.get())));

    public static final DeferredBlock<Block> BROWN_TERRACOTTA_TILES = registerBlock("brown_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA));
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_TILES_SLAB = registerBlock("brown_terracotta_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.BROWN_TERRACOTTA_SLAB.get())));
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_TILES_STAIRS = registerBlock("brown_terracotta_tiles_stairs",
            () -> new StairBlock(MtaBlocks.BROWN_TERRACOTTA_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.BROWN_TERRACOTTA_STAIRS.get())));
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_TILES_WALL = registerBlock("brown_terracotta_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.BROWN_TERRACOTTA_WALL.get())));

    public static final DeferredBlock<Block> RED_TERRACOTTA_TILES = registerBlock("red_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA));
    public static final DeferredBlock<Block> RED_TERRACOTTA_TILES_SLAB = registerBlock("red_terracotta_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.RED_TERRACOTTA_SLAB.get())));
    public static final DeferredBlock<Block> RED_TERRACOTTA_TILES_STAIRS = registerBlock("red_terracotta_tiles_stairs",
            () -> new StairBlock(MtaBlocks.RED_TERRACOTTA_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.RED_TERRACOTTA_STAIRS.get())));
    public static final DeferredBlock<Block> RED_TERRACOTTA_TILES_WALL = registerBlock("red_terracotta_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.RED_TERRACOTTA_WALL.get())));

    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_TILES = registerBlock("orange_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA));
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_TILES_SLAB = registerBlock("orange_terracotta_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.ORANGE_TERRACOTTA_SLAB.get())));
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_TILES_STAIRS = registerBlock("orange_terracotta_tiles_stairs",
            () -> new StairBlock(MtaBlocks.ORANGE_TERRACOTTA_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.ORANGE_TERRACOTTA_STAIRS.get())));
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_TILES_WALL = registerBlock("orange_terracotta_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.ORANGE_TERRACOTTA_WALL.get())));

    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_TILES = registerBlock("yellow_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA));
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_TILES_SLAB = registerBlock("yellow_terracotta_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.YELLOW_TERRACOTTA_SLAB.get())));
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_TILES_STAIRS = registerBlock("yellow_terracotta_tiles_stairs",
            () -> new StairBlock(MtaBlocks.YELLOW_TERRACOTTA_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.YELLOW_TERRACOTTA_STAIRS.get())));
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_TILES_WALL = registerBlock("yellow_terracotta_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.YELLOW_TERRACOTTA_WALL.get())));

    public static final DeferredBlock<Block> LIME_TERRACOTTA_TILES = registerBlock("lime_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA));
    public static final DeferredBlock<Block> LIME_TERRACOTTA_TILES_SLAB = registerBlock("lime_terracotta_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.LIME_TERRACOTTA_SLAB.get())));
    public static final DeferredBlock<Block> LIME_TERRACOTTA_TILES_STAIRS = registerBlock("lime_terracotta_tiles_stairs",
            () -> new StairBlock(MtaBlocks.LIME_TERRACOTTA_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.LIME_TERRACOTTA_STAIRS.get())));
    public static final DeferredBlock<Block> LIME_TERRACOTTA_TILES_WALL = registerBlock("lime_terracotta_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.LIME_TERRACOTTA_WALL.get())));

    public static final DeferredBlock<Block> GREEN_TERRACOTTA_TILES = registerBlock("green_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA));
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_TILES_SLAB = registerBlock("green_terracotta_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.GREEN_TERRACOTTA_SLAB.get())));
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_TILES_STAIRS = registerBlock("green_terracotta_tiles_stairs",
            () -> new StairBlock(MtaBlocks.GREEN_TERRACOTTA_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.GREEN_TERRACOTTA_STAIRS.get())));
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_TILES_WALL = registerBlock("green_terracotta_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.GREEN_TERRACOTTA_WALL.get())));

    public static final DeferredBlock<Block> CYAN_TERRACOTTA_TILES = registerBlock("cyan_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA));
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_TILES_SLAB = registerBlock("cyan_terracotta_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.CYAN_TERRACOTTA_SLAB.get())));
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_TILES_STAIRS = registerBlock("cyan_terracotta_tiles_stairs",
            () -> new StairBlock(MtaBlocks.CYAN_TERRACOTTA_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.CYAN_TERRACOTTA_STAIRS.get())));
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_TILES_WALL = registerBlock("cyan_terracotta_tileswall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.CYAN_TERRACOTTA_WALL.get())));

    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_TILES = registerBlock("light_blue_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA));
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_TILES_SLAB = registerBlock("light_blue_terracotta_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.LIGHT_BLUE_TERRACOTTA_SLAB.get())));
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_TILES_STAIRS = registerBlock("light_blue_terracotta_tiles_stairs",
            () -> new StairBlock(MtaBlocks.LIGHT_BLUE_TERRACOTTA_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS.get())));
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_TILES_WALL = registerBlock("light_blue_terracotta_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.LIGHT_BLUE_TERRACOTTA_WALL.get())));

    public static final DeferredBlock<Block> BLUE_TERRACOTTA_TILES = registerBlock("blue_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA));
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_TILES_SLAB = registerBlock("blue_terracotta_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.BLUE_TERRACOTTA_SLAB.get())));
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_TILES_STAIRS = registerBlock("blue_terracotta_tiles_stairs",
            () -> new StairBlock(MtaBlocks.BLUE_TERRACOTTA_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.BLUE_TERRACOTTA_STAIRS.get())));
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_TILES_WALL = registerBlock("blue_terracotta_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.BLUE_TERRACOTTA_WALL.get())));

    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_TILES = registerBlock("purple_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA));
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_TILES_SLAB = registerBlock("purple_terracotta_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.PURPLE_TERRACOTTA_SLAB.get())));
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_TILES_STAIRS = registerBlock("purple_terracotta_tiles_stairs",
            () -> new StairBlock(MtaBlocks.PURPLE_TERRACOTTA_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.PURPLE_TERRACOTTA_STAIRS.get())));
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_TILES_WALL = registerBlock("purple_terracotta_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.PURPLE_TERRACOTTA_WALL.get())));

    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_TILES = registerBlock("magenta_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA));
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_TILES_SLAB = registerBlock("magenta_terracotta_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.MAGENTA_TERRACOTTA_SLAB.get())));
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_TILES_STAIRS = registerBlock("magenta_terracotta_tiles_stairs",
            () -> new StairBlock(MtaBlocks.MAGENTA_TERRACOTTA_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.MAGENTA_TERRACOTTA_STAIRS.get())));
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_TILES_WALL = registerBlock("magenta_terracotta_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.MAGENTA_TERRACOTTA_WALL.get())));

    public static final DeferredBlock<Block> PINK_TERRACOTTA_TILES = registerBlock("pink_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA));
    public static final DeferredBlock<Block> PINK_TERRACOTTA_TILES_SLAB = registerBlock("pink_terracotta_tiles_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.PINK_TERRACOTTA_SLAB.get())));
    public static final DeferredBlock<Block> PINK_TERRACOTTA_TILES_STAIRS = registerBlock("pink_terracotta_tiles_stairs",
            () -> new StairBlock(MtaBlocks.PINK_TERRACOTTA_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.ofFullCopy(MtaBlocks.PINK_TERRACOTTA_STAIRS.get())));
    public static final DeferredBlock<Block> PINK_TERRACOTTA_TILES_WALL = registerBlock("pink_terracotta_tiles_wall",
            () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(MtaBlocks.PINK_TERRACOTTA_WALL.get())));


    public static final DeferredBlock<Block> WHITE_CONCRETE_SLAB = registerBlock("white_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> WHITE_CONCRETE_STAIRS = registerBlock("white_concrete_stairs",
            () -> new StairBlock(Blocks.WHITE_CONCRETE.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.8F)));
    public static final DeferredBlock<Block> WHITE_CONCRETE_WALL = registerBlock("white_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.WHITE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));

    public static final DeferredBlock<Block> LIGHT_GRAY_CONCRETE_SLAB = registerBlock("light_gray_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> LIGHT_GRAY_CONCRETE_STAIRS = registerBlock("light_gray_concrete_stairs",
            () -> new StairBlock(Blocks.LIGHT_GRAY_CONCRETE.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.8F)));

    public static final DeferredBlock<Block> LIGHT_GRAY_CONCRETE_WALL = registerBlock("light_gray_concretes_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));

    public static final DeferredBlock<Block> GRAY_CONCRETE_SLAB = registerBlock("gray_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> GRAY_CONCRETE_STAIRS = registerBlock("gray_concrete_stairs",
            () -> new StairBlock(Blocks.GRAY_CONCRETE.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.8F)));
    public static final DeferredBlock<Block> GRAY_CONCRETE_WALL = registerBlock("gray_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));

    public static final DeferredBlock<Block> BLACK_CONCRETE_SLAB = registerBlock("black_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> BLACK_CONCRETE_STAIRS = registerBlock("black_concrete_stairs",
            () -> new StairBlock(Blocks.BLACK_CONCRETE.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.8F)));
    public static final DeferredBlock<Block> BLACK_CONCRETE_WALL = registerBlock("black_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLACK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));

    public static final DeferredBlock<Block> BROWN_CONCRETE_SLAB = registerBlock("brown_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> BROWN_CONCRETE_STAIRS = registerBlock("brown_concrete_stairs",
            () -> new StairBlock(Blocks.BROWN_CONCRETE.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.8F)));
    public static final DeferredBlock<Block> BROWN_CONCRETE_WALL = registerBlock("brown_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BROWN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));

    public static final DeferredBlock<Block> RED_CONCRETE_SLAB = registerBlock("red_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> RED_CONCRETE_STAIRS = registerBlock("red_concrete_stairs",
            () -> new StairBlock(Blocks.RED_CONCRETE.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(DyeColor.RED)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.8F)));
    public static final DeferredBlock<Block> RED_CONCRETE_WALL = registerBlock("red_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.RED)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));

    public static final DeferredBlock<Block> ORANGE_CONCRETE_SLAB = registerBlock("orange_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> ORANGE_CONCRETE_STAIRS = registerBlock("orange_concrete_stairs",
            () -> new StairBlock(Blocks.ORANGE_CONCRETE.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.8F)));
    public static final DeferredBlock<Block> ORANGE_CONCRETE_WALL = registerBlock("orange_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.ORANGE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));

    public static final DeferredBlock<Block> YELLOW_CONCRETE_SLAB = registerBlock("yellow_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> YELLOW_CONCRETE_STAIRS = registerBlock("yellow_concrete_stairs",
            () -> new StairBlock(Blocks.YELLOW_CONCRETE.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.8F)));
    public static final DeferredBlock<Block> YELLOW_CONCRETE_WALL = registerBlock("yellow_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.YELLOW)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));

    public static final DeferredBlock<Block> LIME_CONCRETE_SLAB = registerBlock("lime_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIME)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> LIME_CONCRETE_STAIRS = registerBlock("lime_concrete_stairs",
            () -> new StairBlock(Blocks.LIME_CONCRETE.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(DyeColor.LIME)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.8F)));
    public static final DeferredBlock<Block> LIME_CONCRETE_WALL = registerBlock("lime_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIME)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));

    public static final DeferredBlock<Block> GREEN_CONCRETE_SLAB = registerBlock("green_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> GREEN_CONCRETE_STAIRS = registerBlock("green_concrete_stairs",
            () -> new StairBlock(Blocks.GREEN_CONCRETE.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.8F)));
    public static final DeferredBlock<Block> GREEN_CONCRETE_WALL = registerBlock("green_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.GREEN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));

    public static final DeferredBlock<Block> CYAN_CONCRETE_SLAB = registerBlock("cyan_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> CYAN_CONCRETE_STAIRS = registerBlock("cyan_concrete_stairs",
            () -> new StairBlock(Blocks.CYAN_CONCRETE.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.8F)));
    public static final DeferredBlock<Block> CYAN_CONCRETE_WALL = registerBlock("cyan_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.CYAN)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));

    public static final DeferredBlock<Block> LIGHT_BLUE_CONCRETE_SLAB = registerBlock("light_blue_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> LIGHT_BLUE_CONCRETE_STAIRS = registerBlock("light_blue_concrete_stairs",
            () -> new StairBlock(Blocks.LIGHT_BLUE_CONCRETE.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.8F)));
    public static final DeferredBlock<Block> LIGHT_BLUE_CONCRETE_WALL = registerBlock("light_blue_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.LIGHT_BLUE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> BLUE_CONCRETE_SLAB = registerBlock("blue_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> BLUE_CONCRETE_STAIRS = registerBlock("blue_concrete_stairs",
            () -> new StairBlock(Blocks.BLUE_CONCRETE.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.8F)));
    public static final DeferredBlock<Block> BLUE_CONCRETE_WALL = registerBlock("blue_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.BLUE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> PURPLE_CONCRETE_SLAB = registerBlock("purple_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> PURPLE_CONCRETE_STAIRS = registerBlock("purple_concrete_stairs",
            () -> new StairBlock(Blocks.PURPLE_CONCRETE.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.8F)));
    public static final DeferredBlock<Block> PURPLE_CONCRETE_WALL = registerBlock("purple_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PURPLE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> MAGENTA_CONCRETE_SLAB = registerBlock("magenta_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> MAGENTA_CONCRETE_STAIRS = registerBlock("magenta_concretestairs",
            () -> new StairBlock(Blocks.MAGENTA_CONCRETE.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.8F)));
    public static final DeferredBlock<Block> MAGENTA_CONCRETE_WALL = registerBlock("magenta_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.MAGENTA)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));

    public static final DeferredBlock<Block> PINK_CONCRETE_SLAB = registerBlock("pink_concrete_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));
    public static final DeferredBlock<Block> PINK_CONCRETE_STAIRS = registerBlock("pink_concrete_stairs",
            () -> new StairBlock(Blocks.PINK_CONCRETE.defaultBlockState(),
                    BlockBehaviour.Properties.of().mapColor(DyeColor.PINK)
                            .instrument(NoteBlockInstrument.BASEDRUM)
                            .requiresCorrectToolForDrops()
                            .strength(1.8F)));
    public static final DeferredBlock<Block> PINK_CONCRETE_WALL = registerBlock("pink_concrete_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(DyeColor.PINK)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(1.8F)));




    public static final DeferredBlock<Block> QUARTZ_LAMP = registerBlock("quartz_lamp", () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SEA_LANTERN)));

    public static final DeferredBlock<Block> ONION_CROP = BLOCKS.register("onion_crop", () -> new OnionCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final DeferredBlock<Block> TOMATO_CROP = BLOCKS.register("tomato_crop", () -> new TomatoCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final DeferredBlock<Block> BELL_PEPPER_CROP = BLOCKS.register("bell_pepper_crop", () -> new BellPepperCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final DeferredBlock<Block> CHILI_PEPPER_CROP = BLOCKS.register("chili_pepper_crop", () -> new ChiliPepperCropBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT)));



    public static final DeferredBlock<Block> SCATTERED_LEAVES =  registerBlock("scattered_leaves", () -> new PinkPetalsBlock(
            BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)
            )
    );












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


    /*
    >>>>PLACEHOLDER<<<<


    public static final DeferredBlock<DropExperienceBlock> PLACEHOLDER_ORE = registerBlock("placeholder_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_PLACEHOLDER_ORE = registerBlock("deepslate_placeholder_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> NETHER_PLACEHOLDER_ORE = registerBlock("nether_placeholder_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE)
            ));

    public static final DeferredBlock<DropExperienceBlock> END_PLACEHOLDER_ORE = registerBlock("end_placeholder_ore",
            () -> new DropExperienceBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)
            ));


     */
}

