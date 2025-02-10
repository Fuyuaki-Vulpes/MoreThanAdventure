package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.world.block.entity.MtaHangingSignBlockEntity;
import com.fuyuaki.morethanadventure.world.block.entity.MtaSignBlockEntity;
import com.fuyuaki.morethanadventure.world.block.entity.SprinklerEntity;
import com.fuyuaki.morethanadventure.world.block.entity.StoveBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MtaBlockEntities {
        public static final DeferredRegister<BlockEntityType<?>> BL_ENTITY = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SprinklerEntity>> SPRINKLER =
            BL_ENTITY.register("sprinkler", () -> new BlockEntityType<>(SprinklerEntity::new, MtaBlocks.SPRINKLER.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<StoveBlockEntity>> STOVE =
            BL_ENTITY.register("stove", () -> new BlockEntityType<>(StoveBlockEntity::new, MtaBlocks.STOVE.get()));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MtaSignBlockEntity>> SIGN =
            BL_ENTITY.register("sign", () -> new BlockEntityType<>(MtaSignBlockEntity::new,
                    MtaBlocks.ALPINE_SIGN.get(),
                    MtaBlocks.ALPINE_WALL_SIGN.get(),
                    MtaBlocks.AVOCADO_SIGN.get(),
                    MtaBlocks.AVOCADO_WALL_SIGN.get(),
                    MtaBlocks.BOGGED_OAK_SIGN.get(),
                    MtaBlocks.BOGGED_OAK_WALL_SIGN.get(),
                    MtaBlocks.IPE_SIGN.get(),
                    MtaBlocks.IPE_WALL_SIGN.get(),
                    MtaBlocks.MANGO_SIGN.get(),
                    MtaBlocks.MANGO_WALL_SIGN.get(),
                    MtaBlocks.MAPLE_SIGN.get(),
                    MtaBlocks.MAPLE_WALL_SIGN.get(),
                    MtaBlocks.PALM_SIGN.get(),
                    MtaBlocks.PALM_WALL_SIGN.get(),
                    MtaBlocks.SEAWOOD_SIGN.get(),
                    MtaBlocks.SEAWOOD_WALL_SIGN.get()
            ));

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MtaHangingSignBlockEntity>> HANGING_SIGN =
            BL_ENTITY.register("hanging_sign", () -> new BlockEntityType<>(MtaHangingSignBlockEntity::new,
                    MtaBlocks.ALPINE_HANGING_SIGN.get(),
                    MtaBlocks.ALPINE_HANGING_WALL_SIGN.get(),
                    MtaBlocks.AVOCADO_HANGING_SIGN.get(),
                    MtaBlocks.AVOCADO_HANGING_WALL_SIGN.get(),
                    MtaBlocks.BOGGED_OAK_HANGING_SIGN.get(),
                    MtaBlocks.BOGGED_OAK_HANGING_WALL_SIGN.get(),
                    MtaBlocks.IPE_HANGING_SIGN.get(),
                    MtaBlocks.IPE_HANGING_WALL_SIGN.get(),
                    MtaBlocks.MANGO_HANGING_SIGN.get(),
                    MtaBlocks.MANGO_HANGING_WALL_SIGN.get(),
                    MtaBlocks.MAPLE_HANGING_SIGN.get(),
                    MtaBlocks.MAPLE_HANGING_WALL_SIGN.get(),
                    MtaBlocks.PALM_HANGING_SIGN.get(),
                    MtaBlocks.PALM_HANGING_WALL_SIGN.get(),
                    MtaBlocks.SEAWOOD_HANGING_SIGN.get(),
                    MtaBlocks.SEAWOOD_HANGING_WALL_SIGN.get()
            ));



        public static void register(IEventBus eventBus){
            BL_ENTITY.register(eventBus);
        }
    }
