package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEntityTypes;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import net.minecraft.core.dispenser.BoatDispenseItemBehavior;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.DispenserBlock;

public class MTADispenseBehavior {

    public static void bootStrap(){
        DispenserBlock.registerBehavior(MtaItems.ALPINE_BOAT, new BoatDispenseItemBehavior(MtaEntityTypes.ALPINE_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.ALPINE_CHEST_BOAT, new BoatDispenseItemBehavior(MtaEntityTypes.ALPINE_CHEST_BOAT.get()));

        DispenserBlock.registerBehavior(MtaItems.AVOCADO_BOAT, new BoatDispenseItemBehavior(MtaEntityTypes.AVOCADO_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.AVOCADO_CHEST_BOAT, new BoatDispenseItemBehavior(MtaEntityTypes.AVOCADO_CHEST_BOAT.get()));

        DispenserBlock.registerBehavior(MtaItems.BOGGED_OAK_BOAT, new BoatDispenseItemBehavior(MtaEntityTypes.BOGGED_OAK_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.BOGGED_OAK_CHEST_BOAT, new BoatDispenseItemBehavior(MtaEntityTypes.BOGGED_OAK_CHEST_BOAT.get()));

        DispenserBlock.registerBehavior(MtaItems.IPE_BOAT, new BoatDispenseItemBehavior(MtaEntityTypes.IPE_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.IPE_CHEST_BOAT, new BoatDispenseItemBehavior(MtaEntityTypes.IPE_CHEST_BOAT.get()));

        DispenserBlock.registerBehavior(MtaItems.MANGO_BOAT, new BoatDispenseItemBehavior(MtaEntityTypes.MANGO_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.MANGO_CHEST_BOAT, new BoatDispenseItemBehavior(MtaEntityTypes.MANGO_CHEST_BOAT.get()));

        DispenserBlock.registerBehavior(MtaItems.MAPLE_BOAT, new BoatDispenseItemBehavior(MtaEntityTypes.MAPLE_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.MAPLE_CHEST_BOAT, new BoatDispenseItemBehavior(MtaEntityTypes.MAPLE_CHEST_BOAT.get()));

        DispenserBlock.registerBehavior(MtaItems.PALM_BOAT, new BoatDispenseItemBehavior(MtaEntityTypes.PALM_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.PALM_CHEST_BOAT, new BoatDispenseItemBehavior(MtaEntityTypes.PALM_CHEST_BOAT.get()));

        DispenserBlock.registerBehavior(MtaItems.SEAWOOD_BOAT, new BoatDispenseItemBehavior(MtaEntityTypes.SEAWOOD_BOAT.get()));
        DispenserBlock.registerBehavior(MtaItems.SEAWOOD_CHEST_BOAT, new BoatDispenseItemBehavior(MtaEntityTypes.SEAWOOD_CHEST_BOAT.get()));

    }
}
