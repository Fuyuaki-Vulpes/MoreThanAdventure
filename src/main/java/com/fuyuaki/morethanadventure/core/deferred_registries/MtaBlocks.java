package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.core.registry.MTABlockSetTypes;
import com.fuyuaki.morethanadventure.core.registry.MTAWoodTypes;
import com.fuyuaki.morethanadventure.game.worldgen.MtaConfigFeatures;
import com.fuyuaki.morethanadventure.game.worldgen.tree.MtaTreeGrower;
import com.fuyuaki.morethanadventure.world.block.*;
import com.fuyuaki.morethanadventure.world.block.kitchen.StoveBlock;
import com.fuyuaki.morethanadventure.world.level.block.MtaCeilingHangingSignBlock;
import com.fuyuaki.morethanadventure.world.level.block.MtaStandingSignBlock;
import com.fuyuaki.morethanadventure.world.level.block.MtaWallHangingSignBlock;
import com.fuyuaki.morethanadventure.world.level.block.MtaWallSignBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;
import java.util.function.ToIntFunction;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MtaBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);


    public static final DeferredBlock<Block> SPRINKLER = registerCustomItemPropertiesBlock("sprinkler", Sprinkler::new,
            BlockBehaviour.Properties.of()
                    .strength(5.0F)
                    .sound(SoundType.METAL)
                    .noOcclusion(), new Item.Properties());





    public static final DeferredBlock<Block> STOVE = registerBlock("stove", StoveBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.DEEPSLATE)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(3.5F)
                    .lightLevel(litBlockEmission(13))
    );


    public static final DeferredBlock<Block> ALPINE_LOG = registerBlock("alpine_log",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> STRIPPED_ALPINE_LOG = registerBlock("stripped_alpine_log",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> ALPINE_WOOD = registerBlock("alpine_wood",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final DeferredBlock<Block> STRIPPED_ALPINE_WOOD = registerBlock("stripped_alpine_wood",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));

    public static final DeferredBlock<Block> ALPINE_PLANKS = registerBlock("alpine_planks",  Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final DeferredBlock<Block> ALPINE_LEAVES = registerBlock("alpine_leaves", LeavesBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_LEAVES));

    public static final DeferredBlock<Block> ALPINE_SAPLING = registerBlock("alpine_sapling",
            properties -> new SaplingBlock(MtaTreeGrower.ALPINE_TREE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_SAPLING));
    public static final DeferredBlock<Block> POTTED_ALPINE_SAPLING = registerBlock("potted_alpine_sapling",
            properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ALPINE_SAPLING::value, properties),flowerPotProperties());
    public static final DeferredBlock<Block> ALPINE_STAIRS = registerBlock("alpine_stairs",
            properties -> new StairBlock(Blocks.OAK_STAIRS.defaultBlockState(),properties),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS));

    public static final DeferredBlock<Block> ALPINE_SLAB = registerBlock("alpine_slab",
             SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB));

    public static final DeferredBlock<Block> ALPINE_PRESSURE_PLATE = registerBlock("alpine_pressure_plate",
            properties -> new PressurePlateBlock(MTABlockSetTypes.ALPINE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE));
    public static final DeferredBlock<Block> ALPINE_BUTTON = registerBlock("alpine_button",
            properties -> new ButtonBlock(MTABlockSetTypes.ALPINE, 10,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON));

    public static final DeferredBlock<Block> ALPINE_FENCE = registerBlock("alpine_fence",
            FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE));
    public static final DeferredBlock<Block> ALPINE_FENCE_GATE = registerBlock("alpine_fence_gate",
            properties -> new FenceGateBlock(MTAWoodTypes.ALPINE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE));

    public static final DeferredBlock<Block> ALPINE_DOOR = registerBlock("alpine_door",
            properties -> new DoorBlock(MTABlockSetTypes.ALPINE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR));
    public static final DeferredBlock<Block> ALPINE_TRAPDOOR = registerBlock("alpine_trapdoor",
            properties -> new TrapDoorBlock(MTABlockSetTypes.ALPINE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR));

    public static final DeferredBlock<Block> ALPINE_SIGN = registerNoItemBlock("alpine_sign",
            properties -> new MtaStandingSignBlock(MTAWoodTypes.ALPINE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_SIGN)
    );
    public static final DeferredBlock<Block> ALPINE_WALL_SIGN = registerNoItemBlock("alpine_wall_sign",
            properties -> new MtaWallSignBlock(MTAWoodTypes.ALPINE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_SIGN)
    );
    public static final DeferredBlock<Block> ALPINE_HANGING_SIGN = registerNoItemBlock("alpine_hanging_sign",
            properties -> new MtaCeilingHangingSignBlock(MTAWoodTypes.ALPINE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_HANGING_SIGN)
    );
    public static final DeferredBlock<Block> ALPINE_HANGING_WALL_SIGN = registerNoItemBlock("alpine_hanging_wall_sign",
            properties -> new MtaWallHangingSignBlock(MTAWoodTypes.ALPINE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_HANGING_SIGN)
    );


    public static final DeferredBlock<Block> AVOCADO_LOG = registerBlock("avocado_log",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> STRIPPED_AVOCADO_LOG = registerBlock("stripped_avocado_log",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> AVOCADO_WOOD = registerBlock("avocado_wood",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final DeferredBlock<Block> STRIPPED_AVOCADO_WOOD = registerBlock("stripped_avocado_wood",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));

    public static final DeferredBlock<Block> AVOCADO_PLANKS = registerBlock("avocado_planks",  Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final DeferredBlock<Block> AVOCADO_LEAVES = registerBlock("avocado_leaves",
            AvocadoLeaves::new,
            leavesProperties(SoundType.AZALEA_LEAVES));

    public static final DeferredBlock<Block> AVOCADO_SAPLING = registerBlock("avocado_sapling",
            properties -> new SaplingBlock(MtaTreeGrower.AVOCADO_TREE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));
    public static final DeferredBlock<Block> POTTED_AVOCADO_SAPLING = registerBlock("potted_avocado_sapling",
            properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, AVOCADO_SAPLING::value, properties),flowerPotProperties());
    public static final DeferredBlock<Block> AVOCADO_STAIRS = registerBlock("avocado_stairs",
            properties -> new StairBlock(MtaBlocks.AVOCADO_PLANKS.get().defaultBlockState(),properties),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS));
    public static final DeferredBlock<Block> AVOCADO_SLAB = registerBlock("avocado_slab",
             SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB));

    public static final DeferredBlock<Block> AVOCADO_PRESSURE_PLATE = registerBlock("avocado_pressure_plate",
            properties -> new PressurePlateBlock(MTABlockSetTypes.AVOCADO,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE));
    public static final DeferredBlock<Block> AVOCADO_BUTTON = registerBlock("avocado_button",
            properties -> new ButtonBlock(MTABlockSetTypes.AVOCADO, 10,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON));

    public static final DeferredBlock<Block> AVOCADO_FENCE = registerBlock("avocado_fence",
            FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE));
    public static final DeferredBlock<Block> AVOCADO_FENCE_GATE = registerBlock("avocado_fence_gate",
            properties -> new FenceGateBlock(MTAWoodTypes.AVOCADO,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE));

    public static final DeferredBlock<Block> AVOCADO_DOOR = registerBlock("avocado_door",
            properties -> new DoorBlock(MTABlockSetTypes.AVOCADO,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR));
    public static final DeferredBlock<Block> AVOCADO_TRAPDOOR = registerBlock("avocado_trapdoor",
            properties -> new TrapDoorBlock(MTABlockSetTypes.AVOCADO,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR));

    public static final DeferredBlock<Block> AVOCADO_SIGN = registerNoItemBlock("avocado_sign",
            properties -> new MtaStandingSignBlock(MTAWoodTypes.AVOCADO, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)
    );
    public static final DeferredBlock<Block> AVOCADO_WALL_SIGN = registerNoItemBlock("avocado_wall_sign",
            properties -> new MtaWallSignBlock(MTAWoodTypes.AVOCADO, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)
    );
    public static final DeferredBlock<Block> AVOCADO_HANGING_SIGN = registerNoItemBlock("avocado_hanging_sign",
            properties -> new MtaCeilingHangingSignBlock(MTAWoodTypes.AVOCADO, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)
    );
    public static final DeferredBlock<Block> AVOCADO_HANGING_WALL_SIGN = registerNoItemBlock("avocado_hanging_wall_sign",
            properties -> new MtaWallHangingSignBlock(MTAWoodTypes.AVOCADO, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)
    );


    public static final DeferredBlock<Block> BOGGED_OAK_LOG = registerBlock("bogged_oak_log",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final DeferredBlock<Block> STRIPPED_BOGGED_OAK_LOG = registerBlock("stripped_bogged_oak_log",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final DeferredBlock<Block> BOGGED_OAK_WOOD = registerBlock("bogged_oak_wood",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final DeferredBlock<Block> STRIPPED_BOGGED_OAK_WOOD = registerBlock("stripped_bogged_oak_wood",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));

    public static final DeferredBlock<Block> BOGGED_OAK_PLANKS = registerBlock("bogged_oak_planks",  Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));

    public static final DeferredBlock<Block> BOGGED_OAK_STAIRS = registerBlock("bogged_oak_stairs",
            properties -> new StairBlock(MtaBlocks.BOGGED_OAK_PLANKS.get().defaultBlockState(),properties),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS));
    public static final DeferredBlock<Block> BOGGED_OAK_SLAB = registerBlock("bogged_oak_slab",
             SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB));

    public static final DeferredBlock<Block> BOGGED_OAK_PRESSURE_PLATE = registerBlock("bogged_oak_pressure_plate",
            properties -> new PressurePlateBlock(MTABlockSetTypes.BOGGED_OAK,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE));
    public static final DeferredBlock<Block> BOGGED_OAK_BUTTON = registerBlock("bogged_oak_button",
            properties -> new ButtonBlock(MTABlockSetTypes.BOGGED_OAK, 10,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON));

    public static final DeferredBlock<Block> BOGGED_OAK_FENCE = registerBlock("bogged_oak_fence",
            FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL));
    public static final DeferredBlock<Block> BOGGED_OAK_FENCE_GATE = registerBlock("bogged_oak_fence_gate",
            properties -> new FenceGateBlock(MTAWoodTypes.BOGGED_OAK,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE_WALL));

    public static final DeferredBlock<Block> BOGGED_OAK_DOOR = registerBlock("bogged_oak_door",
            properties -> new DoorBlock(MTABlockSetTypes.BOGGED_OAK,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_DOOR));
    public static final DeferredBlock<Block> BOGGED_OAK_TRAPDOOR = registerBlock("bogged_oak_trapdoor",
            properties -> new TrapDoorBlock(MTABlockSetTypes.BOGGED_OAK,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_TRAPDOOR));
    public static final DeferredBlock<Block> BOGGED_OAK_SIGN = registerNoItemBlock("bogged_oak_sign",
            properties -> new MtaStandingSignBlock(MTAWoodTypes.BOGGED_OAK, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_SIGN)
    );
    public static final DeferredBlock<Block> BOGGED_OAK_WALL_SIGN = registerNoItemBlock("bogged_oak_wall_sign",
            properties -> new MtaWallSignBlock(MTAWoodTypes.BOGGED_OAK, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_SIGN)
    );
    public static final DeferredBlock<Block> BOGGED_OAK_HANGING_SIGN = registerNoItemBlock("bogged_oak_hanging_sign",
            properties -> new MtaCeilingHangingSignBlock(MTAWoodTypes.BOGGED_OAK, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_HANGING_SIGN)
    );
    public static final DeferredBlock<Block> BOGGED_OAK_HANGING_WALL_SIGN = registerNoItemBlock("bogged_oak_hanging_wall_sign",
            properties -> new MtaWallHangingSignBlock(MTAWoodTypes.BOGGED_OAK, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_HANGING_SIGN)
    );



    public static final DeferredBlock<Block> IPE_LOG = registerBlock("ipe_log",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_LOG));
    public static final DeferredBlock<Block> STRIPPED_IPE_LOG = registerBlock("stripped_ipe_log",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_LOG));
    public static final DeferredBlock<Block> IPE_WOOD = registerBlock("ipe_wood",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD));
    public static final DeferredBlock<Block> STRIPPED_IPE_WOOD = registerBlock("stripped_ipe_wood",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD));

    public static final DeferredBlock<Block> IPE_PLANKS = registerBlock("ipe_planks",  Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS));
    public static final DeferredBlock<Block> PINK_IPE_LEAVES = registerBlock("pink_ipe_leaves", LeavesBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_LEAVES).mapColor(DyeColor.PINK));
    public static final DeferredBlock<Block> PURPLE_IPE_LEAVES = registerBlock("purple_ipe_leaves", LeavesBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_LEAVES).mapColor(DyeColor.PURPLE));
    public static final DeferredBlock<Block> WHITE_IPE_LEAVES = registerBlock("white_ipe_leaves", LeavesBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_LEAVES).mapColor(DyeColor.WHITE));
    public static final DeferredBlock<Block> YELLOW_IPE_LEAVES = registerBlock("yellow_ipe_leaves", LeavesBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_LEAVES).mapColor(DyeColor.YELLOW));


    public static final DeferredBlock<Block> PINK_IPE_SAPLING = registerBlock("pink_ipe_sapling",
            properties -> new SaplingBlock(MtaTreeGrower.PINK_IPE_TREE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PROPAGULE));
    public static final DeferredBlock<Block> PURPLE_IPE_SAPLING = registerBlock("purple_ipe_sapling",
            properties -> new SaplingBlock(MtaTreeGrower.PURPLE_IPE_TREE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PROPAGULE));
    public static final DeferredBlock<Block> WHITE_IPE_SAPLING = registerBlock("white_ipe_sapling",
            properties -> new SaplingBlock(MtaTreeGrower.WHITE_IPE_TREE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PROPAGULE));
    public static final DeferredBlock<Block> YELLOW_IPE_SAPLING = registerBlock("yellow_ipe_sapling",
            properties -> new SaplingBlock(MtaTreeGrower.YELLOW_IPE_TREE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PROPAGULE));
    public static final DeferredBlock<Block> POTTED_PINK_IPE_SAPLING = registerBlock("potted_pink_ipe_sapling",
            properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PINK_IPE_SAPLING::value, properties),flowerPotProperties());
    public static final DeferredBlock<Block> POTTED_PURPLE_IPE_SAPLING = registerBlock("potted_purple_ipe_sapling",
            properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PURPLE_IPE_SAPLING::value, properties),flowerPotProperties());
    public static final DeferredBlock<Block> POTTED_WHITE_IPE_SAPLING = registerBlock("potted_white_ipe_sapling",
            properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, WHITE_IPE_SAPLING::value, properties),flowerPotProperties());
    public static final DeferredBlock<Block> POTTED_YELLOW_IPE_SAPLING = registerBlock("potted_yellow_ipe_sapling",
            properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, YELLOW_IPE_SAPLING::value, properties),flowerPotProperties());
    public static final DeferredBlock<Block> IPE_STAIRS = registerBlock("ipe_stairs",
            properties -> new StairBlock(MtaBlocks.IPE_PLANKS.get().defaultBlockState(),properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_STAIRS));
    public static final DeferredBlock<Block> IPE_SLAB = registerBlock("ipe_slab",
            SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_SLAB));

    public static final DeferredBlock<Block> IPE_PRESSURE_PLATE = registerBlock("ipe_pressure_plate",
            properties -> new PressurePlateBlock(MTABlockSetTypes.IPE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PRESSURE_PLATE));
    public static final DeferredBlock<Block> IPE_BUTTON = registerBlock("ipe_button",
            properties -> new ButtonBlock(MTABlockSetTypes.IPE, 10,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_BUTTON));

    public static final DeferredBlock<Block> IPE_FENCE = registerBlock("ipe_fence",
            FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_FENCE));
    public static final DeferredBlock<Block> IPE_FENCE_GATE = registerBlock("ipe_fence_gate",
            properties -> new FenceGateBlock(MTAWoodTypes.IPE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_FENCE_GATE));

    public static final DeferredBlock<Block> IPE_DOOR = registerBlock("ipe_door",
            properties -> new DoorBlock(MTABlockSetTypes.IPE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_DOOR));
    public static final DeferredBlock<Block> IPE_TRAPDOOR = registerBlock("ipe_trapdoor",
            properties -> new TrapDoorBlock(MTABlockSetTypes.IPE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_TRAPDOOR));

    public static final DeferredBlock<Block> IPE_SIGN = registerNoItemBlock("ipe_sign",
            properties -> new MtaStandingSignBlock(MTAWoodTypes.IPE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_SIGN)
    );
    public static final DeferredBlock<Block> IPE_WALL_SIGN = registerNoItemBlock("ipe_wall_sign",
            properties -> new MtaWallSignBlock(MTAWoodTypes.IPE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_SIGN)
    );
    public static final DeferredBlock<Block> IPE_HANGING_SIGN = registerNoItemBlock("ipe_hanging_sign",
            properties -> new MtaCeilingHangingSignBlock(MTAWoodTypes.IPE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_HANGING_SIGN)
    );
    public static final DeferredBlock<Block> IPE_HANGING_WALL_SIGN = registerNoItemBlock("ipe_hanging_wall_sign",
            properties -> new MtaWallHangingSignBlock(MTAWoodTypes.IPE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_HANGING_SIGN)
    );



    public static final DeferredBlock<Block> MANGO_LOG = registerBlock("mango_log",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> STRIPPED_MANGO_LOG = registerBlock("stripped_mango_log",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> MANGO_WOOD = registerBlock("mango_wood",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final DeferredBlock<Block> STRIPPED_MANGO_WOOD = registerBlock("stripped_mango_wood",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));

    public static final DeferredBlock<Block> MANGO_PLANKS = registerBlock("mango_planks",  Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final DeferredBlock<Block> MANGO_LEAVES = registerBlock("mango_leaves",
            MangoLeaves::new,
            leavesProperties(SoundType.AZALEA_LEAVES));

    public static final DeferredBlock<Block> MANGO_SAPLING = registerBlock("mango_sapling",
            properties -> new SaplingBlock(MtaTreeGrower.MANGO_TREE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));
    public static final DeferredBlock<Block> POTTED_MANGO_SAPLING = registerBlock("potted_mango_sapling",
            properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, MANGO_SAPLING::value, properties),flowerPotProperties());
    public static final DeferredBlock<Block> MANGO_STAIRS = registerBlock("mango_stairs",
            properties -> new StairBlock(MtaBlocks.MANGO_PLANKS.get().defaultBlockState(),properties),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS));
    public static final DeferredBlock<Block> MANGO_SLAB = registerBlock("mango_slab",
             SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB));

    public static final DeferredBlock<Block> MANGO_PRESSURE_PLATE = registerBlock("mango_pressure_plate",
            properties -> new PressurePlateBlock(MTABlockSetTypes.MANGO,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE));
    public static final DeferredBlock<Block> MANGO_BUTTON = registerBlock("mango_button",
            properties -> new ButtonBlock(MTABlockSetTypes.MANGO, 10,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON));

    public static final DeferredBlock<Block> MANGO_FENCE = registerBlock("mango_fence",
            FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE));
    public static final DeferredBlock<Block> MANGO_FENCE_GATE = registerBlock("mango_fence_gate",
            properties -> new FenceGateBlock(MTAWoodTypes.MANGO,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE));

    public static final DeferredBlock<Block> MANGO_DOOR = registerBlock("mango_door",
            properties -> new DoorBlock(MTABlockSetTypes.MANGO,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR));
    public static final DeferredBlock<Block> MANGO_TRAPDOOR = registerBlock("mango_trapdoor",
            properties -> new TrapDoorBlock(MTABlockSetTypes.MANGO,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR));

    public static final DeferredBlock<Block> MANGO_SIGN = registerNoItemBlock("mango_sign",
            properties -> new MtaStandingSignBlock(MTAWoodTypes.MANGO, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)
    );
    public static final DeferredBlock<Block> MANGO_WALL_SIGN = registerNoItemBlock("mango_wall_sign",
            properties -> new MtaWallSignBlock(MTAWoodTypes.MANGO, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)
    );
    public static final DeferredBlock<Block> MANGO_HANGING_SIGN = registerNoItemBlock("mango_hanging_sign",
            properties -> new MtaCeilingHangingSignBlock(MTAWoodTypes.MANGO, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)
    );
    public static final DeferredBlock<Block> MANGO_HANGING_WALL_SIGN = registerNoItemBlock("mango_hanging_wall_sign",
            properties -> new MtaWallHangingSignBlock(MTAWoodTypes.MANGO, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)
    );



public static final DeferredBlock<Block> MAPLE_LOG = registerBlock("maple_log",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> STRIPPED_MAPLE_LOG = registerBlock("stripped_maple_log",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> MAPLE_WOOD = registerBlock("maple_wood",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final DeferredBlock<Block> STRIPPED_MAPLE_WOOD = registerBlock("stripped_maple_wood",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));

    public static final DeferredBlock<Block> MAPLE_PLANKS = registerBlock("maple_planks",  Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final DeferredBlock<Block> MAPLE_LEAVES = registerBlock("maple_leaves", LeavesBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));

    public static final DeferredBlock<Block> MAPLE_SAPLING = registerBlock("maple_sapling",
            properties -> new SaplingBlock(MtaTreeGrower.MAPLE_TREE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING));
    public static final DeferredBlock<Block> POTTED_MAPLE_SAPLING = registerBlock("potted_maple_sapling",
            properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, MAPLE_SAPLING::value, properties),flowerPotProperties());
    public static final DeferredBlock<Block> MAPLE_STAIRS = registerBlock("maple_stairs",
            properties -> new StairBlock(MtaBlocks.MANGO_PLANKS.get().defaultBlockState(),properties),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS));
    public static final DeferredBlock<Block> MAPLE_SLAB = registerBlock("maple_slab",
             SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB));

    public static final DeferredBlock<Block> MAPLE_PRESSURE_PLATE = registerBlock("maple_pressure_plate",
            properties -> new PressurePlateBlock(MTABlockSetTypes.MAPLE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE));
    public static final DeferredBlock<Block> MAPLE_BUTTON = registerBlock("maple_button",
            properties -> new ButtonBlock(MTABlockSetTypes.MAPLE, 10,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON));

    public static final DeferredBlock<Block> MAPLE_FENCE = registerBlock("maple_fence",
            FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE));
    public static final DeferredBlock<Block> MAPLE_FENCE_GATE = registerBlock("maple_fence_gate",
            properties -> new FenceGateBlock(MTAWoodTypes.MAPLE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE));

    public static final DeferredBlock<Block> MAPLE_DOOR = registerBlock("maple_door",
            properties -> new DoorBlock(MTABlockSetTypes.MAPLE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR));
    public static final DeferredBlock<Block> MAPLE_TRAPDOOR = registerBlock("maple_trapdoor",
            properties -> new TrapDoorBlock(MTABlockSetTypes.MAPLE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR));

    public static final DeferredBlock<Block> MAPLE_SIGN = registerNoItemBlock("maple_sign",
            properties -> new MtaStandingSignBlock(MTAWoodTypes.MAPLE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)
    );
    public static final DeferredBlock<Block> MAPLE_WALL_SIGN = registerNoItemBlock("maple_wall_sign",
            properties -> new MtaWallSignBlock(MTAWoodTypes.MAPLE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)
    );
    public static final DeferredBlock<Block> MAPLE_HANGING_SIGN = registerNoItemBlock("maple_hanging_sign",
            properties -> new MtaCeilingHangingSignBlock(MTAWoodTypes.MAPLE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)
    );
    public static final DeferredBlock<Block> MAPLE_HANGING_WALL_SIGN = registerNoItemBlock("maple_hanging_wall_sign",
            properties -> new MtaWallHangingSignBlock(MTAWoodTypes.MAPLE, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)
    );


    public static final DeferredBlock<Block> PALM_LOG = registerBlock("palm_log",  MtaFlammableRotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> STRIPPED_PALM_LOG = registerBlock("stripped_palm_log",  MtaFlammableRotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG));
    public static final DeferredBlock<Block> PALM_WOOD = registerBlock("palm_wood",  MtaFlammableRotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final DeferredBlock<Block> STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood",  MtaFlammableRotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD));

    public static final DeferredBlock<Block> PALM_PLANKS = registerBlock("palm_planks", properties -> new Block(properties){
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
    }, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));

    public static final DeferredBlock<Block> PALM_LEAVES = registerBlock("palm_leaves", properties -> new LeavesBlock(properties){
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
    }, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));

    public static final DeferredBlock<Block> PALM_SAPLING = registerBlock("palm_sapling",
            properties -> new SaplingBlock(MtaTreeGrower.PALM_TREE,properties){
                @Override
                protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
                    return super.mayPlaceOn(pState, pLevel, pPos) || pState.is(BlockTags.SAND);
                }
            }, BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_SAPLING));

    public static final DeferredBlock<Block> POTTED_PALM_SAPLING = registerBlock("potted_palm_sapling",
            properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, PALM_SAPLING::value, properties),flowerPotProperties());

    public static final DeferredBlock<Block> PALM_STAIRS = registerBlock("palm_stairs",
            properties -> new StairBlock(MtaBlocks.PALM_PLANKS.get().defaultBlockState(),properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS));
    public static final DeferredBlock<Block> PALM_SLAB = registerBlock("palm_slab",
            SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB));

    public static final DeferredBlock<Block> PALM_PRESSURE_PLATE = registerBlock("palm_pressure_plate",
            properties -> new PressurePlateBlock(MTABlockSetTypes.PALM,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE));
    public static final DeferredBlock<Block> PALM_BUTTON = registerBlock("palm_button",
            properties -> new ButtonBlock(MTABlockSetTypes.PALM, 10,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON));

    public static final DeferredBlock<Block> PALM_FENCE = registerBlock("palm_fence",
            FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE));
    public static final DeferredBlock<Block> PALM_FENCE_GATE = registerBlock("palm_fence_gate",
            properties -> new FenceGateBlock(MTAWoodTypes.PALM,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE));

    public static final DeferredBlock<Block> PALM_DOOR = registerBlock("palm_door",
            properties -> new DoorBlock(MTABlockSetTypes.PALM, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR));
    public static final DeferredBlock<Block> PALM_TRAPDOOR = registerBlock("palm_trapdoor",
            properties -> new TrapDoorBlock(MTABlockSetTypes.PALM, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR));

    public static final DeferredBlock<Block> PALM_SIGN = registerNoItemBlock("palm_sign",
            properties -> new MtaStandingSignBlock(MTAWoodTypes.PALM, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)
    );
    public static final DeferredBlock<Block> PALM_WALL_SIGN = registerNoItemBlock("palm_wall_sign",
            properties -> new MtaWallSignBlock(MTAWoodTypes.PALM, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)
    );
    public static final DeferredBlock<Block> PALM_HANGING_SIGN = registerNoItemBlock("palm_hanging_sign",
            properties -> new MtaCeilingHangingSignBlock(MTAWoodTypes.PALM, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)
    );
    public static final DeferredBlock<Block> PALM_HANGING_WALL_SIGN = registerNoItemBlock("palm_hanging_wall_sign",
            properties -> new MtaWallHangingSignBlock(MTAWoodTypes.PALM, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)
    );



    public static final DeferredBlock<Block> SEALOG = registerBlock("sealog",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> SEAWOOD = registerBlock("seawood",  RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD));

    public static final DeferredBlock<Block> SEAWOOD_PLANKS = registerBlock("seawood_planks",  Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final DeferredBlock<Block> SEAWOOD_LEAVES = registerBlock("seawood_leaves",  LeavesBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES));

    public static final DeferredBlock<Block> SEAWOOD_SAPLING = registerBlock("seawood_sapling",
            properties -> new SeaSaplingBlock(MtaTreeGrower.SEAWOOD_TREE,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_SAPLING));

    public static final DeferredBlock<Block> POTTED_SEAWOOD_SAPLING = registerBlock("potted_seawood_sapling",
            properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, SEAWOOD_SAPLING::value, properties),flowerPotProperties());

    public static final DeferredBlock<Block> SEAWOOD_STAIRS = registerBlock("seawood_stairs",
            properties -> new StairBlock(MtaBlocks.SEAWOOD_PLANKS.get().defaultBlockState(),properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_STAIRS));
    public static final DeferredBlock<Block> SEAWOOD_SLAB = registerBlock("seawood_slab",
            SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SLAB));

    public static final DeferredBlock<Block> SEAWOOD_PRESSURE_PLATE = registerBlock("seawood_pressure_plate",
            properties -> new PressurePlateBlock(MTABlockSetTypes.SEAWOOD,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE));
    public static final DeferredBlock<Block> SEAWOOD_BUTTON = registerBlock("seawood_button",
            properties -> new ButtonBlock(MTABlockSetTypes.SEAWOOD, 10,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_BUTTON));

    public static final DeferredBlock<Block> SEAWOOD_FENCE = registerBlock("seawood_fence",
            FenceBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE));
    public static final DeferredBlock<Block> SEAWOOD_FENCE_GATE = registerBlock("seawood_fence_gate",
            properties -> new FenceGateBlock(MTAWoodTypes.SEAWOOD,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_FENCE_GATE));

    public static final DeferredBlock<Block> SEAWOOD_DOOR = registerBlock("seawood_door",
            properties -> new DoorBlock(MTABlockSetTypes.SEAWOOD,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_DOOR));
    public static final DeferredBlock<Block> SEAWOOD_TRAPDOOR = registerBlock("seawood_trapdoor",
            properties -> new TrapDoorBlock(MTABlockSetTypes.SEAWOOD,properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_TRAPDOOR));

    public static final DeferredBlock<Block> SEAWOOD_SIGN = registerNoItemBlock("seawood_sign",
            properties -> new MtaStandingSignBlock(MTAWoodTypes.SEAWOOD, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)
    );
    public static final DeferredBlock<Block> SEAWOOD_WALL_SIGN = registerNoItemBlock("seawood_wall_sign",
            properties -> new MtaWallSignBlock(MTAWoodTypes.SEAWOOD, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SIGN)
    );
    public static final DeferredBlock<Block> SEAWOOD_HANGING_SIGN = registerNoItemBlock("seawood_hanging_sign",
            properties -> new MtaCeilingHangingSignBlock(MTAWoodTypes.SEAWOOD, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)
    );
    public static final DeferredBlock<Block> SEAWOOD_HANGING_WALL_SIGN = registerNoItemBlock("seawood_hanging_wall_sign",
            properties -> new MtaWallHangingSignBlock(MTAWoodTypes.SEAWOOD, properties), BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_HANGING_SIGN)
    );



    public static final DeferredBlock<GeyserBlock> STONE_GEYSER = registerBlock("stone_geyser", properties -> new  GeyserBlock(properties,false),
            copy(Blocks.STONE));

    public static final DeferredBlock<GeyserBlock> TERRACOTTA_GEYSER = registerBlock("terracotta_geyser",properties -> new GeyserBlock(properties,false),
            copy(Blocks.TERRACOTTA));

    public static final DeferredBlock<GeyserBlock> NETHERRACK_GEYSER = registerBlock("netherrack_geyser", properties -> new GeyserBlock(properties,true),
            copy(Blocks.NETHERRACK).strength(1.25F, 4.2F));

    public static final DeferredBlock<GeyserBlock> BASALT_GEYSER = registerBlock("basalt_geyser", properties -> new GeyserBlock(properties,true),
            copy(Blocks.BASALT));

    public static final DeferredBlock<ShardClusterBlock> CLEAR_QUARTZ_CLUSTER = registerBlock("clear_quartz_cluster", ShardClusterBlock::new,
                    copy(Blocks.AMETHYST_CLUSTER));




    public static final DeferredBlock<Block> MOSSY_ANDESITE = registerBlock("mossy_andesite", BlockBehaviour.Properties.ofFullCopy(Blocks.ANDESITE));

    public static final DeferredBlock<Block> CALCITE_CLEAR_QUARTZ_GROWTH = registerBlock("calcite_clear_quartz_growth",
             properties -> new ShardGrowthBlock(Blocks.CALCITE,MtaBlocks.CLEAR_QUARTZ_CLUSTER.get(), properties),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.CALCITE).strength(12.0F).randomTicks()
            );
    public static final DeferredBlock<Block> DEEPSLATE_CLEAR_QUARTZ_GROWTH = registerBlock("deepslate_clear_quartz_growth",
            properties -> new ShardGrowthBlock(Blocks.DEEPSLATE,MtaBlocks.CLEAR_QUARTZ_CLUSTER.get(), properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE).strength(12.0F).randomTicks()
            );
    public static final DeferredBlock<Block> CLEAR_QUARTZ_GROWTH = registerBlock("clear_quartz_growth",
            properties -> new ShardGrowthBlock(Blocks.STONE,MtaBlocks.CLEAR_QUARTZ_CLUSTER.get(), properties),
            BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).strength(12.0F).randomTicks()
            );


    public static final DeferredBlock<Block> CLEAR_QUARTZ_ORE = oreBlock("clear_quartz_ore",4, 6,copy(Blocks.STONE));
    public static final DeferredBlock<Block> DEEPSLATE_CLEAR_QUARTZ_ORE = oreBlock("deepslate_clear_quartz_ore",5, 7,copy(Blocks.DEEPSLATE_IRON_ORE));

    public static final DeferredBlock<Block> NETHER_IRON_ORE = oreBlock("nether_iron_ore",0,copy(Blocks.NETHER_QUARTZ_ORE));
    public static final DeferredBlock<Block> NETHER_DIAMOND_ORE = oreBlock("nether_diamond_ore",3, 8,copy(Blocks.NETHER_QUARTZ_ORE));

    public static final DeferredBlock<Block> END_LAPIS_ORE = oreBlock("end_lapis_ore",6, 10,copy(Blocks.END_STONE));
    public static final DeferredBlock<Block> END_EMERALD_ORE = oreBlock("end_emerald_ore",6, 14,copy(Blocks.END_STONE));


    public static final DeferredBlock<Block> NETHERITIC_CRYSTAL = oreBlock("netheritic_crystal",
             1, 35,copy(Blocks.NETHER_QUARTZ_ORE).strength(5.0F, 32.0F));


    public static final DeferredBlock<Block> SAND_PATH = registerBlock("sand_path", SandPathBlock::new,
            copy(Blocks.DIRT_PATH)
    );

    public static final DeferredBlock<Block> GRASSY_DIRT = registerBlock("grassy_dirt",
            copy(Blocks.DIRT)
    );

    public static final DeferredBlock<Block> GRASSY_SAND = registerBlock("grassy_sand",
            properties -> new ColoredFallingBlock(new ColorRGBA(14406560), properties),
            copy(Blocks.SAND)
    );

    public static final DeferredBlock<Block> COBBLED_DIRT = registerBlock("cobbled_dirt",
            copy(Blocks.DIRT)
                    .strength(1.0F,3.0F)
    );

    public static final DeferredBlock<Block> COARSE_DIRT_PATH = registerPath("coarse_dirt_path", Blocks.COARSE_DIRT, Blocks.DIRT);


    public static final DeferredBlock<Block> SHALLOW_GRASS = registerBlock("shallow_grass",
             ShortGrassBlock::new,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT)
                            .replaceable()
                            .noCollission()
                            .instabreak()
                            .sound(SoundType.GRASS)
                            .offsetType( BlockBehaviour.OffsetType.XYZ)
                            .ignitedByLava()
                            .pushReaction(PushReaction.DESTROY)
    );
    public static final DeferredBlock<Block> SAND_GRASS = registerBlock("sand_grass",
            SandVegetationBlock::new,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT)
                            .replaceable()
                            .noCollission()
                            .instabreak()
                            .sound(SoundType.GRASS)
                            .offsetType( BlockBehaviour.OffsetType.XYZ)
                            .ignitedByLava()
                            .pushReaction(PushReaction.DESTROY)
    );
    public static final DeferredBlock<Block> BEACHGRASS = registerBlock("beachgrass",
            SandVegetationBlock::new,
                    BlockBehaviour.Properties.of()
                            .mapColor(MapColor.PLANT)
                            .replaceable()
                            .noCollission()
                            .instabreak()
                            .sound(SoundType.GRASS)
                            .offsetType( BlockBehaviour.OffsetType.XYZ)
                            .ignitedByLava()
                            .pushReaction(PushReaction.DESTROY)
    );

    public static final DeferredBlock<Block> PEAT = registerBlock("peat",
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.DIRT)
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
             PermafrostDirtBlock::new,
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.GRASS_BLOCK)

    );
    public static final DeferredBlock<Block> POLAR_SAND = registerBlock("polar_sand",
            properties ->  new ColoredFallingBlock(new ColorRGBA(0xe1f0ed), properties),
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.SAND).mapColor(MapColor.SNOW)

    );
    public static final DeferredBlock<Block> TUNDRA_GRASS = registerBlock("tundra_grass",
             PermafrostDirtBlock::new,
            BlockBehaviour.Properties
                    .ofFullCopy(Blocks.PODZOL)

    );

    public static final DeferredBlock<Block> STONE_TILES = registerTiles("stone_tiles",0, Blocks.STONE_BRICKS);
    public static final DeferredBlock<Block> STONE_TILES_STAIRS = registerStair("stone_tiles_stairs", Blocks.STONE_BRICK_STAIRS);
    public static final DeferredBlock<Block> STONE_TILES_SLAB = registerSlab("stone_tiles_slab",Blocks.STONE_BRICK_SLAB);

    public static final DeferredBlock<Block> STONE_TILES_WALL = registerWall("stone_tiles_wall",Blocks.STONE_BRICK_WALL);

    public static final DeferredBlock<Block> SLIGHTLY_DIRTY_STONE_TILES = registerTiles("slightly_dirty_stone_tiles",1, Blocks.STONE_BRICKS);

    public static final DeferredBlock<Block> SLIGHTLY_DIRTY_STONE_TILES_STAIRS = registerStair("slightly_dirty_stone_tiles_stairs",
            Blocks.STONE_BRICK_STAIRS);

    public static final DeferredBlock<Block> SLIGHTLY_DIRTY_STONE_TILES_SLAB = registerSlab("slightly_dirty_stone_tiles_slab",
            Blocks.STONE_BRICK_STAIRS);

    public static final DeferredBlock<Block> SLIGHTLY_DIRTY_STONE_TILES_WALL = registerWall("sightly_dirty_stone_tiles_wall",
            Blocks.STONE_BRICK_WALL);
    public static final DeferredBlock<Block> DIRTY_STONE_TILES = registerTiles("dirty_stone_tiles",2, Blocks.STONE_BRICKS);

    public static final DeferredBlock<Block> DIRTY_STONE_TILES_STAIRS = registerStair("dirty_stone_tiles_stairs",
            Blocks.STONE_BRICK_STAIRS);
    public static final DeferredBlock<Block> DIRTY_STONE_TILES_SLAB = registerSlab("dirty_stone_tiles_slab",
            Blocks.STONE_BRICK_SLAB);

    public static final DeferredBlock<Block> DIRTY_STONE_TILES_WALL = registerWall("dirty_stone_tiles_wall",
            Blocks.STONE_BRICK_WALL);
    public static final DeferredBlock<Block> VERY_DIRTY_STONE_TILES = registerTiles("very_dirty_stone_tiles",3, Blocks.STONE_BRICKS);

    public static final DeferredBlock<Block> VERY_DIRTY_STONE_TILES_STAIRS = registerStair("very_dirty_stone_tiles_stairs",
            Blocks.STONE_BRICK_STAIRS);

    public static final DeferredBlock<Block> VERY_DIRTY_STONE_TILES_SLAB = registerSlab("very_dirty_stone_tiles_slab",
            Blocks.STONE_BRICK_SLAB);

    public static final DeferredBlock<Block> VERY_DIRTY_STONE_TILES_WALL = registerWall("very_dirty_stone_tiles_wall",
            Blocks.STONE_BRICK_WALL);


    public static final DeferredBlock<Block> AGATE_ORE = oreBlock("agate_ore",
        2, 16,stoneOreProperties());

    public static final DeferredBlock<Block> DEEPSLATE_AGATE_ORE = oreBlock("deepslate_agate_ore",
            2,16,deepslateOreProperties());


    public static final DeferredBlock<Block> ALEXANDRITE_ORE = oreBlock("alexandrite_ore",
            2, 16,stoneOreProperties());

    public static final DeferredBlock<Block> DEEPSLATE_ALEXANDRITE_ORE = oreBlock("deepslate_alexandrite_ore",
            2,16,deepslateOreProperties());


    public static final DeferredBlock<Block> AQUAMARINE_ORE = oreBlock("aquamarine_ore",
            2, 16,stoneOreProperties());

    public static final DeferredBlock<Block> DEEPSLATE_AQUAMARINE_ORE = oreBlock("deepslate_aquamarine_ore",
            2,16,deepslateOreProperties());

    public static final DeferredBlock<Block> BLOODSTONE_ORE = oreBlock("bloodstone_ore",
            2, 16,stoneOreProperties());

    public static final DeferredBlock<Block> DEEPSLATE_BLOODSTONE_ORE = oreBlock("deepslate_bloodstone_ore",
            2,16,deepslateOreProperties());

    public static final DeferredBlock<Block> CELESTITE_ORE = oreBlock("celestite_ore",
            2, 16,stoneOreProperties());

    public static final DeferredBlock<Block> CRYOLITE_ORE = oreBlock("cryolite_ore",
            2,16,
            stoneOreProperties().sound(SoundType.GLASS).lightLevel(l -> 4).friction(0.5F)
    );

    public static final DeferredBlock<Block> DEEPSLATE_CELESTITE_ORE = oreBlock("deepslate_celestite_ore",
             2,16,deepslateOreProperties().sound(SoundType.GLASS).lightLevel(l -> 4).friction(0.5F));

    public static final DeferredBlock<Block> GARNET_ORE = oreBlock("garnet_ore",
            2,16,stoneOreProperties());
    public static final DeferredBlock<Block> DEEPSLATE_GARNET_ORE = oreBlock("deepslate_garnet_ore",
            2,16,deepslateOreProperties());


    public static final DeferredBlock<Block> MOONSTONE_ORE = oreBlock("moonstone_ore",
            2,16,stoneOreProperties());
    public static final DeferredBlock<Block> DEEPSLATE_MOONSTONE_ORE = oreBlock("deepslate_moonstone_ore",
            2,16,deepslateOreProperties());



    public static final DeferredBlock<Block> WISESTONE = oreBlock("wisestone",
            16, 128,stoneOreProperties().noLootTable());


    public static final DeferredBlock<Block> END_WISESTONE = oreBlock("end_wisestone",
            16, 128,deepslateOreProperties().noLootTable());

    public static final DeferredBlock<Block> DEEPSLATE_WISESTONE = oreBlock("deepslate_wisestone",
            16,128,deepslateOreProperties().noLootTable());



    //Terracotta

    public static final DeferredBlock<Block> TERRACOTTA_SLAB = registerSlab("terracotta_slab", Blocks.TERRACOTTA);
    public static final DeferredBlock<Block> TERRACOTTA_STAIRS = registerStair("terracotta_stairs", Blocks.TERRACOTTA);
    public static final DeferredBlock<Block> TERRACOTTA_WALL = registerWall("terracotta_wall", Blocks.TERRACOTTA);
    public static final DeferredBlock<Block> WHITE_TERRACOTTA_SLAB = registerSlab("white_terracotta_slab", Blocks.WHITE_TERRACOTTA);
    public static final DeferredBlock<Block> WHITE_TERRACOTTA_STAIRS = registerStair("white_terracotta_stairs", Blocks.WHITE_TERRACOTTA);
    public static final DeferredBlock<Block> WHITE_TERRACOTTA_WALL = registerWall("white_terracotta_wall", Blocks.WHITE_TERRACOTTA);
    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_SLAB = registerSlab("light_gray_terracotta_slab", Blocks.LIGHT_GRAY_TERRACOTTA);
    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_STAIRS = registerStair("light_gray_terracotta_stairs", Blocks.LIGHT_GRAY_TERRACOTTA);
    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_WALL = registerWall("light_gray_terracotta_wall", Blocks.LIGHT_GRAY_TERRACOTTA);
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_SLAB = registerSlab("gray_terracotta_slab", Blocks.GRAY_TERRACOTTA);
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_STAIRS = registerStair("gray_terracotta_stairs", Blocks.GRAY_TERRACOTTA);
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_WALL = registerWall("gray_terracotta_wall", Blocks.GRAY_TERRACOTTA);
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_SLAB = registerSlab("black_terracotta_slab", Blocks.BLACK_TERRACOTTA);
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_STAIRS = registerStair("black_terracotta_stairs", Blocks.BLACK_TERRACOTTA);
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_WALL = registerWall("black_terracotta_wall", Blocks.BLACK_TERRACOTTA);
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_SLAB = registerSlab("brown_terracotta_slab", Blocks.BROWN_TERRACOTTA);
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_STAIRS = registerStair("brown_terracotta_stairs", Blocks.BROWN_TERRACOTTA);
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_WALL = registerWall("brown_terracotta_wall", Blocks.BROWN_TERRACOTTA);
    public static final DeferredBlock<Block> RED_TERRACOTTA_SLAB = registerSlab("red_terracotta_slab", Blocks.RED_TERRACOTTA);
    public static final DeferredBlock<Block> RED_TERRACOTTA_STAIRS = registerStair("red_terracotta_stairs",Blocks.RED_TERRACOTTA);
    public static final DeferredBlock<Block> RED_TERRACOTTA_WALL = registerWall("red_terracotta_wall", Blocks.RED_TERRACOTTA);
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_SLAB = registerSlab("orange_terracotta_slab", Blocks.ORANGE_TERRACOTTA);
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_STAIRS = registerStair("orange_terracotta_stairs", Blocks.ORANGE_TERRACOTTA);
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_WALL = registerWall("orange_terracotta_wall", Blocks.ORANGE_TERRACOTTA);
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_SLAB = registerSlab("yellow_terracotta_slab", Blocks.YELLOW_TERRACOTTA);
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_STAIRS = registerStair("yellow_terracotta_stairs", Blocks.YELLOW_TERRACOTTA);
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_WALL = registerWall("yellow_terracotta_wall", Blocks.YELLOW_TERRACOTTA);
    public static final DeferredBlock<Block> LIME_TERRACOTTA_SLAB = registerSlab("lime_terracotta_slab", Blocks.LIME_TERRACOTTA);
    public static final DeferredBlock<Block> LIME_TERRACOTTA_STAIRS = registerStair("lime_terracotta_stairs", Blocks.LIME_TERRACOTTA);
    public static final DeferredBlock<Block> LIME_TERRACOTTA_WALL = registerWall("lime_terracotta_wall", Blocks.LIME_TERRACOTTA);
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_SLAB = registerSlab("green_terracotta_slab", Blocks.GREEN_TERRACOTTA);
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_STAIRS = registerStair("green_terracotta_stairs", Blocks.GREEN_TERRACOTTA);
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_WALL = registerWall("green_terracotta_wall", Blocks.GREEN_TERRACOTTA);
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_SLAB = registerSlab("cyan_terracotta_slab", Blocks.CYAN_TERRACOTTA);
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_STAIRS = registerStair("cyan_terracotta_stairs", Blocks.CYAN_TERRACOTTA);
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_WALL = registerWall("cyan_terracotta_wall", Blocks.CYAN_TERRACOTTA);
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_SLAB = registerSlab("light_blue_terracotta_slab", Blocks.LIGHT_BLUE_TERRACOTTA);
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_STAIRS = registerStair("light_blue_terracotta_stairs", Blocks.LIGHT_BLUE_TERRACOTTA);
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_WALL = registerWall("light_blue_terracotta_wall", Blocks.LIGHT_BLUE_TERRACOTTA);
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_SLAB = registerSlab("blue_terracotta_slab", Blocks.BLUE_TERRACOTTA);
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_STAIRS = registerStair("blue_terracotta_stairs", Blocks.BLUE_TERRACOTTA);
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_WALL = registerWall("blue_terracotta_wall", Blocks.BLUE_TERRACOTTA);
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_SLAB = registerSlab("purple_terracotta_slab", Blocks.PURPLE_TERRACOTTA);
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_STAIRS = registerStair("purple_terracotta_stairs", Blocks.PURPLE_TERRACOTTA);
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_WALL = registerWall("purple_terracotta_wall", Blocks.PURPLE_TERRACOTTA);
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_SLAB = registerSlab("magenta_terracotta_slab", Blocks.MAGENTA_TERRACOTTA);
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_STAIRS = registerStair("magenta_terracotta_stairs", Blocks.MAGENTA_TERRACOTTA);
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_WALL = registerWall("magenta_terracotta_wall", Blocks.MAGENTA_TERRACOTTA);
    public static final DeferredBlock<Block> PINK_TERRACOTTA_SLAB = registerSlab("pink_terracotta_slab", Blocks.PINK_TERRACOTTA);
    public static final DeferredBlock<Block> PINK_TERRACOTTA_STAIRS = registerStair("pink_terracotta_stairs", Blocks.PINK_TERRACOTTA);
    public static final DeferredBlock<Block> PINK_TERRACOTTA_WALL = registerWall("pink_terracotta_wall", Blocks.PINK_TERRACOTTA);
    public static final DeferredBlock<Block> TERRACOTTA_TILES = registerBlock("terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.TERRACOTTA));
    public static final DeferredBlock<Block> TERRACOTTA_TILES_SLAB = registerSlab("terracotta_tiles_slab", Blocks.TERRACOTTA);
    public static final DeferredBlock<Block> TERRACOTTA_TILES_STAIRS = registerStair("terracotta_tiles_stairs", Blocks.TERRACOTTA);
    public static final DeferredBlock<Block> TERRACOTTA_TILES_WALL = registerWall("terracotta_tiles_wall", Blocks.TERRACOTTA);
    public static final DeferredBlock<Block> WHITE_TERRACOTTA_TILES = registerBlock("white_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_TERRACOTTA));
    public static final DeferredBlock<Block> WHITE_TERRACOTTA_TILES_SLAB = registerSlab("white_terracotta_tiles_slab", Blocks.WHITE_TERRACOTTA);
    public static final DeferredBlock<Block> WHITE_TERRACOTTA_TILES_STAIRS = registerStair("white_terracotta_tiles_stairs", Blocks.WHITE_TERRACOTTA);
    public static final DeferredBlock<Block> WHITE_TERRACOTTA_TILES_WALL = registerWall("white_terracotta_tiles_wall", Blocks.WHITE_TERRACOTTA);
    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_TILES = registerBlock("light_gray_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_GRAY_TERRACOTTA));
    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_TILES_SLAB = registerSlab("light_gray_terracotta_tiles_slab", Blocks.LIGHT_GRAY_TERRACOTTA);
    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_TILES_STAIRS = registerStair("light_gray_terracotta_tiles_stairs", Blocks.LIGHT_GRAY_TERRACOTTA);
    public static final DeferredBlock<Block> LIGHT_GRAY_TERRACOTTA_TILES_WALL = registerWall("light_gray_terracottas_tiles_wall", Blocks.LIGHT_GRAY_TERRACOTTA);
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_TILES = registerBlock("gray_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.GRAY_TERRACOTTA));
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_TILES_SLAB = registerSlab("gray_terracotta_tiles_slab", Blocks.GRAY_TERRACOTTA);
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_TILES_STAIRS = registerStair("gray_terracotta_tiles_stairs", Blocks.GRAY_TERRACOTTA);
    public static final DeferredBlock<Block> GRAY_TERRACOTTA_TILES_WALL = registerWall("gray_terracotta_tiles_wall", Blocks.GRAY_TERRACOTTA);
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_TILES = registerBlock("black_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.BLACK_TERRACOTTA));
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_TILES_SLAB = registerSlab("black_terracotta_tiles_slab", Blocks.BLACK_TERRACOTTA);
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_TILES_STAIRS = registerStair("black_terracotta_tiles_stairs", Blocks.BLACK_TERRACOTTA);
    public static final DeferredBlock<Block> BLACK_TERRACOTTA_TILES_WALL = registerWall("black_terracotta_tiles_wall", Blocks.BLACK_TERRACOTTA);
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_TILES = registerBlock("brown_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_TERRACOTTA));
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_TILES_SLAB = registerSlab("brown_terracotta_tiles_slab", Blocks.BROWN_TERRACOTTA);
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_TILES_STAIRS = registerStair("brown_terracotta_tiles_stairs", Blocks.BROWN_TERRACOTTA);
    public static final DeferredBlock<Block> BROWN_TERRACOTTA_TILES_WALL = registerWall("brown_terracotta_tiles_wall", Blocks.BROWN_TERRACOTTA);
    public static final DeferredBlock<Block> RED_TERRACOTTA_TILES = registerBlock("red_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.RED_TERRACOTTA));
    public static final DeferredBlock<Block> RED_TERRACOTTA_TILES_SLAB = registerSlab("red_terracotta_tiles_slab", Blocks.RED_TERRACOTTA);
    public static final DeferredBlock<Block> RED_TERRACOTTA_TILES_STAIRS = registerStair("red_terracotta_tiles_stairs", Blocks.RED_TERRACOTTA);
    public static final DeferredBlock<Block> RED_TERRACOTTA_TILES_WALL = registerWall("red_terracotta_tiles_wall", Blocks.RED_TERRACOTTA);
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_TILES = registerBlock("orange_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_TERRACOTTA));
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_TILES_SLAB = registerSlab("orange_terracotta_tiles_slab", Blocks.ORANGE_TERRACOTTA);
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_TILES_STAIRS = registerStair("orange_terracotta_tiles_stairs", Blocks.ORANGE_TERRACOTTA);
    public static final DeferredBlock<Block> ORANGE_TERRACOTTA_TILES_WALL = registerWall("orange_terracotta_tiles_wall", Blocks.ORANGE_TERRACOTTA);
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_TILES = registerBlock("yellow_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.YELLOW_TERRACOTTA));
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_TILES_SLAB = registerSlab("yellow_terracotta_tiles_slab", Blocks.YELLOW_TERRACOTTA);
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_TILES_STAIRS = registerStair("yellow_terracotta_tiles_stairs", Blocks.YELLOW_TERRACOTTA);
    public static final DeferredBlock<Block> YELLOW_TERRACOTTA_TILES_WALL = registerWall("yellow_terracotta_tiles_wall", Blocks.YELLOW_TERRACOTTA);
    public static final DeferredBlock<Block> LIME_TERRACOTTA_TILES = registerBlock("lime_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.LIME_TERRACOTTA));
    public static final DeferredBlock<Block> LIME_TERRACOTTA_TILES_SLAB = registerSlab("lime_terracotta_tiles_slab", Blocks.LIME_TERRACOTTA);
    public static final DeferredBlock<Block> LIME_TERRACOTTA_TILES_STAIRS = registerStair("lime_terracotta_tiles_stairs", Blocks.LIME_TERRACOTTA);
    public static final DeferredBlock<Block> LIME_TERRACOTTA_TILES_WALL = registerWall("lime_terracotta_tiles_wall", Blocks.LIME_TERRACOTTA);
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_TILES = registerBlock("green_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.GREEN_TERRACOTTA));
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_TILES_SLAB = registerSlab("green_terracotta_tiles_slab", Blocks.GREEN_TERRACOTTA);
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_TILES_STAIRS = registerStair("green_terracotta_tiles_stairs", Blocks.GREEN_TERRACOTTA);
    public static final DeferredBlock<Block> GREEN_TERRACOTTA_TILES_WALL = registerWall("green_terracotta_tiles_wall", Blocks.GREEN_TERRACOTTA);
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_TILES = registerBlock("cyan_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.CYAN_TERRACOTTA));
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_TILES_SLAB = registerSlab("cyan_terracotta_tiles_slab", Blocks.CYAN_TERRACOTTA);
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_TILES_STAIRS = registerStair("cyan_terracotta_tiles_stairs", Blocks.CYAN_TERRACOTTA);
    public static final DeferredBlock<Block> CYAN_TERRACOTTA_TILES_WALL = registerWall("cyan_terracotta_tileswall", Blocks.CYAN_TERRACOTTA);
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_TILES = registerBlock("light_blue_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.LIGHT_BLUE_TERRACOTTA));
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_TILES_SLAB = registerSlab("light_blue_terracotta_tiles_slab", Blocks.LIGHT_BLUE_TERRACOTTA);
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_TILES_STAIRS = registerStair("light_blue_terracotta_tiles_stairs", Blocks.LIGHT_BLUE_TERRACOTTA);
    public static final DeferredBlock<Block> LIGHT_BLUE_TERRACOTTA_TILES_WALL = registerWall("light_blue_terracotta_tiles_wall", Blocks.LIGHT_BLUE_TERRACOTTA);
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_TILES = registerBlock("blue_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.BLUE_TERRACOTTA));
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_TILES_SLAB = registerSlab("blue_terracotta_tiles_slab", Blocks.BLUE_TERRACOTTA);
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_TILES_STAIRS = registerStair("blue_terracotta_tiles_stairs", Blocks.BLUE_TERRACOTTA);
    public static final DeferredBlock<Block> BLUE_TERRACOTTA_TILES_WALL = registerWall("blue_terracotta_tiles_wall", Blocks.BLUE_TERRACOTTA);
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_TILES = registerBlock("purple_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.PURPLE_TERRACOTTA));
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_TILES_SLAB = registerSlab("purple_terracotta_tiles_slab", Blocks.PURPLE_TERRACOTTA);
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_TILES_STAIRS = registerStair("purple_terracotta_tiles_stairs", Blocks.PURPLE_TERRACOTTA);
    public static final DeferredBlock<Block> PURPLE_TERRACOTTA_TILES_WALL = registerWall("purple_terracotta_tiles_wall", Blocks.PURPLE_TERRACOTTA);
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_TILES = registerBlock("magenta_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.MAGENTA_TERRACOTTA));
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_TILES_SLAB = registerSlab("magenta_terracotta_tiles_slab", Blocks.MAGENTA_TERRACOTTA);
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_TILES_STAIRS = registerStair("magenta_terracotta_tiles_stairs", Blocks.MAGENTA_TERRACOTTA);
    public static final DeferredBlock<Block> MAGENTA_TERRACOTTA_TILES_WALL = registerWall("magenta_terracotta_tiles_wall", Blocks.MAGENTA_TERRACOTTA);
    public static final DeferredBlock<Block> PINK_TERRACOTTA_TILES = registerBlock("pink_terracotta_tiles", BlockBehaviour.Properties.ofFullCopy(Blocks.PINK_TERRACOTTA));
    public static final DeferredBlock<Block> PINK_TERRACOTTA_TILES_SLAB = registerSlab("pink_terracotta_tiles_slab", Blocks.PINK_TERRACOTTA);
    public static final DeferredBlock<Block> PINK_TERRACOTTA_TILES_STAIRS = registerStair("pink_terracotta_tiles_stairs", Blocks.PINK_TERRACOTTA);
    public static final DeferredBlock<Block> PINK_TERRACOTTA_TILES_WALL = registerWall("pink_terracotta_tiles_wall", Blocks.PINK_TERRACOTTA);
    public static final DeferredBlock<Block> WHITE_CONCRETE_SLAB = registerSlab("white_concrete_slab", Blocks.WHITE_CONCRETE);
    public static final DeferredBlock<Block> WHITE_CONCRETE_STAIRS = registerStair("white_concrete_stairs", Blocks.WHITE_CONCRETE);
    public static final DeferredBlock<Block> WHITE_CONCRETE_WALL = registerWall("white_concrete_wall", Blocks.WHITE_CONCRETE);
    public static final DeferredBlock<Block> LIGHT_GRAY_CONCRETE_SLAB = registerSlab("light_gray_concrete_slab", Blocks.LIGHT_GRAY_CONCRETE);
    public static final DeferredBlock<Block> LIGHT_GRAY_CONCRETE_STAIRS = registerStair("light_gray_concrete_stairs", Blocks.LIGHT_GRAY_CONCRETE);
    public static final DeferredBlock<Block> LIGHT_GRAY_CONCRETE_WALL = registerWall("light_gray_concretes_wall", Blocks.LIGHT_GRAY_CONCRETE);
    public static final DeferredBlock<Block> GRAY_CONCRETE_SLAB = registerSlab("gray_concrete_slab", Blocks.GRAY_CONCRETE);
    public static final DeferredBlock<Block> GRAY_CONCRETE_STAIRS = registerStair("gray_concrete_stairs", Blocks.GRAY_CONCRETE);
    public static final DeferredBlock<Block> GRAY_CONCRETE_WALL = registerWall("gray_concrete_wall", Blocks.GRAY_CONCRETE);
    public static final DeferredBlock<Block> BLACK_CONCRETE_SLAB = registerSlab("black_concrete_slab", Blocks.BLACK_CONCRETE);
    public static final DeferredBlock<Block> BLACK_CONCRETE_STAIRS = registerStair("black_concrete_stairs", Blocks.BLACK_CONCRETE);
    public static final DeferredBlock<Block> BLACK_CONCRETE_WALL = registerWall("black_concrete_wall", Blocks.BLACK_CONCRETE);
    public static final DeferredBlock<Block> BROWN_CONCRETE_SLAB = registerSlab("brown_concrete_slab", Blocks.BROWN_CONCRETE);
    public static final DeferredBlock<Block> BROWN_CONCRETE_STAIRS = registerStair("brown_concrete_stairs", Blocks.BROWN_CONCRETE);
    public static final DeferredBlock<Block> BROWN_CONCRETE_WALL = registerWall("brown_concrete_wall", Blocks.BROWN_CONCRETE);
    public static final DeferredBlock<Block> RED_CONCRETE_SLAB = registerSlab("red_concrete_slab", Blocks.RED_CONCRETE);
    public static final DeferredBlock<Block> RED_CONCRETE_STAIRS = registerStair("red_concrete_stairs", Blocks.RED_CONCRETE);
    public static final DeferredBlock<Block> RED_CONCRETE_WALL = registerWall("red_concrete_wall", Blocks.RED_CONCRETE);
    public static final DeferredBlock<Block> ORANGE_CONCRETE_SLAB = registerSlab("orange_concrete_slab", Blocks.ORANGE_CONCRETE);
    public static final DeferredBlock<Block> ORANGE_CONCRETE_STAIRS = registerStair("orange_concrete_stairs", Blocks.ORANGE_CONCRETE);
    public static final DeferredBlock<Block> ORANGE_CONCRETE_WALL = registerWall("orange_concrete_wall", Blocks.ORANGE_CONCRETE);
    public static final DeferredBlock<Block> YELLOW_CONCRETE_SLAB = registerSlab("yellow_concrete_slab", Blocks.YELLOW_CONCRETE);
    public static final DeferredBlock<Block> YELLOW_CONCRETE_STAIRS = registerStair("yellow_concrete_stairs", Blocks.YELLOW_CONCRETE);
    public static final DeferredBlock<Block> YELLOW_CONCRETE_WALL = registerWall("yellow_concrete_wall", Blocks.YELLOW_CONCRETE);
    public static final DeferredBlock<Block> LIME_CONCRETE_SLAB = registerSlab("lime_concrete_slab", Blocks.LIME_CONCRETE);
    public static final DeferredBlock<Block> LIME_CONCRETE_STAIRS = registerStair("lime_concrete_stairs", Blocks.LIME_CONCRETE);
    public static final DeferredBlock<Block> LIME_CONCRETE_WALL = registerWall("lime_concrete_wall", Blocks.LIME_CONCRETE);
    public static final DeferredBlock<Block> GREEN_CONCRETE_SLAB = registerSlab("green_concrete_slab", Blocks.GREEN_CONCRETE);
    public static final DeferredBlock<Block> GREEN_CONCRETE_STAIRS = registerStair("green_concrete_stairs", Blocks.GREEN_CONCRETE);
    public static final DeferredBlock<Block> GREEN_CONCRETE_WALL = registerWall("green_concrete_wall", Blocks.GREEN_CONCRETE);
    public static final DeferredBlock<Block> CYAN_CONCRETE_SLAB = registerSlab("cyan_concrete_slab", Blocks.CYAN_CONCRETE);
    public static final DeferredBlock<Block> CYAN_CONCRETE_STAIRS = registerStair("cyan_concrete_stairs", Blocks.CYAN_CONCRETE);
    public static final DeferredBlock<Block> CYAN_CONCRETE_WALL = registerWall("cyan_concrete_wall", Blocks.CYAN_CONCRETE);
    public static final DeferredBlock<Block> LIGHT_BLUE_CONCRETE_SLAB = registerSlab("light_blue_concrete_slab", Blocks.LIGHT_BLUE_CONCRETE);
    public static final DeferredBlock<Block> LIGHT_BLUE_CONCRETE_STAIRS = registerStair("light_blue_concrete_stairs", Blocks.LIGHT_BLUE_CONCRETE);
    public static final DeferredBlock<Block> LIGHT_BLUE_CONCRETE_WALL = registerWall("light_blue_concrete_wall", Blocks.LIGHT_BLUE_CONCRETE);
    public static final DeferredBlock<Block> BLUE_CONCRETE_SLAB = registerSlab("blue_concrete_slab", Blocks.BLUE_CONCRETE);
    public static final DeferredBlock<Block> BLUE_CONCRETE_STAIRS = registerStair("blue_concrete_stairs", Blocks.BLUE_CONCRETE);
    public static final DeferredBlock<Block> BLUE_CONCRETE_WALL = registerWall("blue_concrete_wall", Blocks.BLUE_CONCRETE);
    public static final DeferredBlock<Block> PURPLE_CONCRETE_SLAB = registerSlab("purple_concrete_slab", Blocks.PURPLE_CONCRETE);
    public static final DeferredBlock<Block> PURPLE_CONCRETE_STAIRS = registerStair("purple_concrete_stairs", Blocks.PURPLE_CONCRETE);
    public static final DeferredBlock<Block> PURPLE_CONCRETE_WALL = registerWall("purple_concrete_wall", Blocks.PURPLE_CONCRETE);
    public static final DeferredBlock<Block> MAGENTA_CONCRETE_SLAB = registerSlab("magenta_concrete_slab", Blocks.MAGENTA_CONCRETE);
    public static final DeferredBlock<Block> MAGENTA_CONCRETE_STAIRS = registerStair("magenta_concretestairs", Blocks.MAGENTA_CONCRETE);
    public static final DeferredBlock<Block> MAGENTA_CONCRETE_WALL = registerWall("magenta_concrete_wall", Blocks.MAGENTA_CONCRETE);
    public static final DeferredBlock<Block> PINK_CONCRETE_SLAB = registerSlab("pink_concrete_slab", Blocks.PINK_CONCRETE);
    public static final DeferredBlock<Block> PINK_CONCRETE_STAIRS = registerStair("pink_concrete_stairs", Blocks.PINK_CONCRETE);
    public static final DeferredBlock<Block> PINK_CONCRETE_WALL = registerWall("pink_concrete_wall", Blocks.PINK_CONCRETE);




    public static final DeferredBlock<Block> QUARTZ_LAMP = registerBlock("quartz_lamp",  Block::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SEA_LANTERN));

    public static final DeferredBlock<Block> ONION_CROP = registerNoItemBlock("onion_crop",  OnionCropBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));
    public static final DeferredBlock<Block> TOMATO_CROP = registerNoItemBlock("tomato_crop",  TomatoCropBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));
    public static final DeferredBlock<Block> BELL_PEPPER_CROP = registerNoItemBlock("bell_pepper_crop",  BellPepperCropBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));
    public static final DeferredBlock<Block> CHILI_PEPPER_CROP = registerNoItemBlock("chili_pepper_crop",  ChiliPepperCropBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.WHEAT));



    public static final DeferredBlock<Block> SCATTERED_LEAVES =  registerBlock("scattered_leaves",  PinkPetalsBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)
    );

    public static final DeferredBlock<Block> CATTAIL = registerBlock("cattail",
             WaterloggableDoublePlant::new, plantProperties());

    public static final DeferredBlock<Block> PRICKLY_PEAR = registerBlock("prickly_pear",
             CactusShrubBlock::new,
            BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT)
                    .replaceable()
                    .noCollission()
                    .instabreak()
                    .sound(SoundType.GRASS)
                    .offsetType(BlockBehaviour.OffsetType.XYZ)
                    .ignitedByLava()
                    .pushReaction(PushReaction.DESTROY)
    );

    public static final DeferredBlock<Block>  POTTED_PRICKLY_PEAR = registerBlock("potted_prickly_pear",
            properties -> new FlowerPotBlock(
                    () -> (FlowerPotBlock) Blocks.FLOWER_POT,
                    () -> PRICKLY_PEAR.get(),
                    properties),
            flowerPotProperties());

    public static final DeferredBlock<Block> DEATH_CAP = registerBlock(
            "death_cap",
            p_368320_ -> new MushroomBlock(MtaConfigFeatures.HUGE_DEATH_CAP, p_368320_),
            BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM)
                    .mapColor(MapColor.COLOR_RED)
    );

    public static final DeferredBlock<Block> POTTED_DEATH_CAP = registerBlock("potted_death_cap",
            properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, DEATH_CAP::value, properties),flowerPotProperties());


    public static final DeferredBlock<Block> DEATH_CAP_BLOCK = registerBlock(
            "death_cap_block",
            HugeMushroomBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD).ignitedByLava()
    );

    public static final DeferredBlock<Block> DEATH_ANGEL = registerBlock(
            "death_angel",
            p_368320_ -> new MushroomBlock(MtaConfigFeatures.HUGE_DEATH_ANGEL, p_368320_),
            BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM)
                    .mapColor(MapColor.COLOR_RED)
    );

    public static final DeferredBlock<Block> POTTED_DEATH_ANGEL = registerBlock("potted_death_angel",
            properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, DEATH_ANGEL::value, properties),flowerPotProperties());


    public static final DeferredBlock<Block> DEATH_ANGEL_BLOCK = registerBlock(
            "death_angel_block",
            HugeMushroomBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD).ignitedByLava()
    );

    public static final DeferredBlock<Block> FLY_AGARIC = registerBlock(
            "fly_agaric",
            p_368320_ -> new MushroomBlock(MtaConfigFeatures.HUGE_FLY_AGARIC, p_368320_),
            BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM)
    );

    public static final DeferredBlock<Block> POTTED_FLY_AGARIC = registerBlock("potted_fly_agaric",
            properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, FLY_AGARIC::value, properties),flowerPotProperties());


    public static final DeferredBlock<Block> FLY_AGARIC_BLOCK = registerBlock(
            "fly_agaric_block",
            HugeMushroomBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD).ignitedByLava()
    );

    public static final DeferredBlock<Block> KING_BOLETE = registerBlock(
            "king_bolete",
            p_368320_ -> new MushroomBlock(MtaConfigFeatures.HUGE_KING_BOLETE, p_368320_),
            BlockBehaviour.Properties.ofFullCopy(Blocks.RED_MUSHROOM)
                    .mapColor(MapColor.COLOR_RED)
    );

    public static final DeferredBlock<Block> POTTED_KING_BOLETE = registerBlock("potted_king_bolete",
            properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, KING_BOLETE::value, properties),flowerPotProperties());


    public static final DeferredBlock<Block> KING_BOLETE_BLOCK = registerBlock(
            "king_bolete_block",
            HugeMushroomBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD).ignitedByLava()
    );

    public static final DeferredBlock<Block> MAITAKE = registerBlock(
            "maitake",
            p_368320_ -> new MushroomBlock(MtaConfigFeatures.HUGE_MAITAKE, p_368320_),
            BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM)
    );

    public static final DeferredBlock<Block> POTTED_MAITAKE = registerBlock("potted_maitake",
            properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, MAITAKE::value, properties),flowerPotProperties());


    public static final DeferredBlock<Block> MAITAKE_BLOCK = registerBlock(
            "maitake_block",
            HugeMushroomBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD).ignitedByLava()
    );

    public static final DeferredBlock<Block> MOREL = registerBlock(
            "morel",
            p_368320_ -> new MushroomBlock(MtaConfigFeatures.HUGE_MOREL, p_368320_),
            BlockBehaviour.Properties.ofFullCopy(Blocks.BROWN_MUSHROOM)
                    .mapColor(MapColor.COLOR_RED)
    );

    public static final DeferredBlock<Block> POTTED_MOREL = registerBlock("potted_morel",
            properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, MOREL::value, properties),flowerPotProperties());


    public static final DeferredBlock<Block> MOREL_BLOCK = registerBlock(
            "morel_block",
            HugeMushroomBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).instrument(NoteBlockInstrument.BASS).strength(0.2F).sound(SoundType.WOOD).ignitedByLava()
    );

/*
    public static final DeferredBlock<Block> TEST_VINES =  registerBlock("test_vines",  VineFlowerBlock(
            BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)
            )
    );

    public static final DeferredBlock<Block> TEST_WALLSHROOM =  registerBlock("test_vines",  WallMushroomBlock(
            BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)
            )
    );
*/











    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }

   //REGISTERING FUNCTIONS

    private static <I extends Block> DeferredBlock<I> registerBlock(String name, Function<BlockBehaviour.Properties, ? extends I> func, BlockBehaviour.Properties props) {
        DeferredBlock<I> toReturn = BLOCKS.registerBlock(name, func,props);
        registerBlockItem(name, toReturn);
        return toReturn;
    }


    private static <I extends Block> DeferredBlock<Block> registerNoItemBlock(String name, Function<BlockBehaviour.Properties, ? extends I> func, BlockBehaviour.Properties props) {
        return BLOCKS.registerBlock(name, func, props);
    }

    private static  DeferredBlock<Block> registerBlock(String name, BlockBehaviour.Properties block){
        DeferredBlock<Block> toReturn = BLOCKS.registerSimpleBlock(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        MtaItems.ITEMS.registerSimpleBlockItem(name, block);
    }

    private static <I extends Block> DeferredBlock<Block> registerCustomItemPropertiesBlock(String name, Function<BlockBehaviour.Properties, ? extends I> func, BlockBehaviour.Properties props, Item.Properties properties){
        DeferredBlock<Block>  toReturn = BLOCKS.registerBlock(name,func,props);
        registerCustomBlockItem(name, toReturn, properties);
        return toReturn;
    }
    private static <T extends Block> void registerCustomBlockItem(String name, DeferredBlock<T> block, Item.Properties p){
        MtaItems.ITEMS.registerItem(name, properties ->  new BlockItem(block.get(),properties), p);
    }

    //BOOLEANS


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

    //REGISTRIES & PROPERTIES


    protected static ToIntFunction<BlockState> litBlockEmission(int pLightValue) {
        return blockState -> blockState.getValue(BlockStateProperties.LIT) ? pLightValue : 0;
    }

    private static BlockBehaviour.Properties logProperties(MapColor sideColor, MapColor topColor, SoundType sound) {
        return BlockBehaviour.Properties.of()
                .mapColor(p_152624_ -> p_152624_.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? sideColor : topColor)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sound(sound)
                .ignitedByLava();
    }


    private static BlockBehaviour.Properties buttonProperties() {
        return BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties flowerPotProperties() {
        return BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties plantProperties() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .noCollission()
                .instabreak()
                .sound(SoundType.GRASS)
                .offsetType( BlockBehaviour.OffsetType.XZ)
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY);
    }

    private static BlockBehaviour.Properties leavesProperties(SoundType sound) {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.PLANT)
                .strength(0.2F)
                .randomTicks()
                .sound(sound)
                .noOcclusion()
                .isValidSpawn(Blocks::ocelotOrParrot)
                .isSuffocating(MtaBlocks::never)
                .isViewBlocking(MtaBlocks::never)
                .ignitedByLava()
                .pushReaction(PushReaction.DESTROY)
                .isRedstoneConductor(MtaBlocks::never);
    }
    public static DeferredBlock<Block> registerSlab(String name, Block baseBlock) {
        return registerBlock(name, SlabBlock::new, BlockBehaviour.Properties.ofFullCopy(baseBlock));
}

    private static DeferredBlock<Block> registerStair(String name, Block baseBlock) {
        return registerBlock(name,
                properties -> new StairBlock(baseBlock.defaultBlockState(), properties),
                BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }

    public static DeferredBlock<Block> registerWall(String name, Block baseBlock){
        return registerBlock(name, WallBlock::new, BlockBehaviour.Properties.ofFullCopy(baseBlock));
    }


    public static DeferredBlock<Block> oreBlock(String name, int min, int max, BlockBehaviour.Properties block) {
        return registerBlock(name, properties -> new DropExperienceBlock(
                UniformInt.of(min, max), properties), block
        );
    }
    public static DeferredBlock<Block> oreBlock(String name, int count, BlockBehaviour.Properties block){
        return registerBlock(name, properties -> new DropExperienceBlock(
                ConstantInt.of(count),properties),block
        );
    }

    public static DeferredBlock<Block> registerTiles(String name, int dirtiness,Block base){
        return registerBlock(name, properties -> new StoneTilesBlock(properties,dirtiness) , copy(base));
    }

    public static DeferredBlock<Block> registerPath(String name, Block turnTo,Block copy){
        return registerBlock(name, properties -> new MTAPathBlock(properties,turnTo) , copy(copy));
    }

    public static BlockBehaviour.Properties oreProperties(Block copyFrom){
        return BlockBehaviour.Properties.ofFullCopy(copyFrom);
    }
    public static BlockBehaviour.Properties oreProperties(SoundType soundType,MapColor mapColor,NoteBlockInstrument instrument, float destroyTime, float explosionResistance){
        return BlockBehaviour.Properties.of().mapColor(mapColor).instrument(instrument).requiresCorrectToolForDrops().strength(destroyTime, explosionResistance).sound(soundType);
    }


    public static BlockBehaviour.Properties stoneOreProperties(float destroyTime, float explosionResistance){
        return BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(destroyTime, explosionResistance).sound(SoundType.STONE);
    }
    public static BlockBehaviour.Properties deepslateOreProperties(float destroyTime, float explosionResistance){
        return BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(destroyTime, explosionResistance).sound(SoundType.DEEPSLATE);
    }
    public static BlockBehaviour.Properties stoneOreProperties(){
        return BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(3.0F, 3.0F).sound(SoundType.STONE);
    }
    public static BlockBehaviour.Properties deepslateOreProperties(){
        return BlockBehaviour.Properties.of().mapColor(MapColor.DEEPSLATE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE);
    }



    private static BlockBehaviour.Properties copy(Block block) {
        return BlockBehaviour.Properties.ofFullCopy(block);
    }


    private static BlockBehaviour.Properties copy(DeferredBlock<? extends Block> block) {
        return BlockBehaviour.Properties.ofFullCopy(block.get()).setId(ResourceKey.create(Registries.BLOCK,block.getId()));
    }





    /*
    >>>>PLACEHOLDER<<<<


    public static final DeferredBlock<DropExperienceBlock> PLACEHOLDER_ORE = registerBlock("placeholder_ore",
             DropExperienceBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> DEEPSLATE_PLACEHOLDER_ORE = registerBlock("deepslate_placeholder_ore",
             DropExperienceBlock(ConstantInt.of(0),
                        BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)
            ));
    public static final DeferredBlock<DropExperienceBlock> NETHER_PLACEHOLDER_ORE = registerBlock("nether_placeholder_ore",
             DropExperienceBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE)
            ));

    public static final DeferredBlock<DropExperienceBlock> END_PLACEHOLDER_ORE = registerBlock("end_placeholder_ore",
             DropExperienceBlock(ConstantInt.of(0),
                    BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)
            ));


     */
}

