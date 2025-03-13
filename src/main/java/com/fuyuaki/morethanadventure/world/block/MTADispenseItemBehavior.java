package com.fuyuaki.morethanadventure.world.block;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEntityTypes;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.DispenserBlock;

public class MTADispenseItemBehavior {
    public static void bootStrap() {
        DispenserBlock.registerBehavior(MtaItems.ALPINE_BOAT.get(), new BoatDispenseItemBehavior(MtaEntityTypes.ALPINE_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.ALPINE_CHEST_BOAT.get(), new BoatDispenseItemBehavior(MtaEntityTypes.ALPINE_CHEST_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.AVOCADO_BOAT.get(), new BoatDispenseItemBehavior(MtaEntityTypes.AVOCADO_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.AVOCADO_CHEST_BOAT.get(), new BoatDispenseItemBehavior(MtaEntityTypes.AVOCADO_CHEST_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.BOGGED_OAK_BOAT.get(), new BoatDispenseItemBehavior(MtaEntityTypes.BOGGED_OAK_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.BOGGED_OAK_CHEST_BOAT.get(), new BoatDispenseItemBehavior(MtaEntityTypes.BOGGED_OAK_CHEST_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.IPE_BOAT.get(), new BoatDispenseItemBehavior(MtaEntityTypes.IPE_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.IPE_CHEST_BOAT.get(), new BoatDispenseItemBehavior(MtaEntityTypes.IPE_CHEST_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.MANGO_BOAT.get(), new BoatDispenseItemBehavior(MtaEntityTypes.MANGO_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.MANGO_CHEST_BOAT.get(), new BoatDispenseItemBehavior(MtaEntityTypes.MANGO_CHEST_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.MAPLE_BOAT.get(), new BoatDispenseItemBehavior(MtaEntityTypes.MAPLE_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.MAPLE_CHEST_BOAT.get(), new BoatDispenseItemBehavior(MtaEntityTypes.MAPLE_CHEST_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.PALM_BOAT.get(), new BoatDispenseItemBehavior(MtaEntityTypes.PALM_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.PALM_CHEST_BOAT.get(), new BoatDispenseItemBehavior(MtaEntityTypes.PALM_CHEST_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.SEAWOOD_BOAT.get(), new BoatDispenseItemBehavior(MtaEntityTypes.SEAWOOD_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.SEAWOOD_CHEST_BOAT.get(), new BoatDispenseItemBehavior(MtaEntityTypes.SEAWOOD_CHEST_BOAT.get()));
    }
}
