package com.fuyuaki.morethanadventure.core.registry;

import com.fuyuaki.morethanadventure.world.block.entity.SprinklerEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MtaBlockEntities {
        public static final DeferredRegister<BlockEntityType<?>> BL_ENTITY = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SprinklerEntity>> SPRINKLER =
            BL_ENTITY.register("sprinkler", () -> BlockEntityType.Builder.of(SprinklerEntity::new, MtaBlocks.SPRINKLER.get()).build(null));




        public static void register(IEventBus eventBus){
            BL_ENTITY.register(eventBus);
        }
    }
