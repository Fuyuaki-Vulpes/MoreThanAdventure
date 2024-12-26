package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.world.level.feature.placers.PalmFoliagePlacer;
import com.fuyuaki.morethanadventure.world.level.feature.placers.PalmTrunkPlacer;
import com.fuyuaki.morethanadventure.world.level.feature.placers.SeawoodTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTAPlacers {
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACER = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, MODID);
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACER = DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, MODID);


    public static final DeferredHolder<TrunkPlacerType<?>,TrunkPlacerType<PalmTrunkPlacer>> PALM_TRUNK_PLACER =
            TRUNK_PLACER.register("palm_trunk_placer",() -> new TrunkPlacerType<>(PalmTrunkPlacer.CODEC));

    public static final DeferredHolder<TrunkPlacerType<?>,TrunkPlacerType<SeawoodTrunkPlacer>> SEAWOOD_TRUNK_PLACER =
            TRUNK_PLACER.register("seawood_trunk_placer",() -> new TrunkPlacerType<>(SeawoodTrunkPlacer.CODEC));


    public static final DeferredHolder<FoliagePlacerType<?>,FoliagePlacerType<PalmFoliagePlacer>> PALM_FOLIAGE_PLACER =
            FOLIAGE_PLACER.register("palm_trunk_placer",() -> new FoliagePlacerType<>(PalmFoliagePlacer.CODEC));


    public static void register(IEventBus eventBus){
        TRUNK_PLACER.register(eventBus);
        FOLIAGE_PLACER.register(eventBus);
    }

}
