package com.fuyuaki.morethanadventure.game.worldgen.tree;

import com.fuyuaki.morethanadventure.core.mod.MTAMod;
import com.fuyuaki.morethanadventure.game.worldgen.MtaConfigFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class MtaTreeGrower {

    public static final TreeGrower ALPINE_TREE = new TreeGrower(MTAMod.MODID + "alpine_tree",
            Optional.empty(), Optional.of(MtaConfigFeatures.ALPINE_TREE), Optional.empty());

    public static final TreeGrower AVOCADO_TREE = new TreeGrower(MTAMod.MODID + "avocado_tree",
            Optional.empty(), Optional.of(MtaConfigFeatures.AVOCADO_TREE), Optional.empty());

    public static final TreeGrower BOGGED_OAK_TREE = new TreeGrower(MTAMod.MODID + "bogged_oak_tree",
            Optional.empty(), Optional.of(MtaConfigFeatures.BOGGED_OAK_TREE), Optional.empty());

    public static final TreeGrower PINK_IPE_TREE = new TreeGrower(MTAMod.MODID + "pink_ipe_tree",
            Optional.empty(), Optional.of(MtaConfigFeatures.PINK_IPE_TREE), Optional.empty());

    public static final TreeGrower PURPLE_IPE_TREE = new TreeGrower(MTAMod.MODID + "purple_ipe_tree",
            Optional.empty(), Optional.of(MtaConfigFeatures.PURPLE_IPE_TREE), Optional.empty());

    public static final TreeGrower WHITE_IPE_TREE = new TreeGrower(MTAMod.MODID + "white-ipe_tree",
            Optional.empty(), Optional.of(MtaConfigFeatures.WHITE_IPE_TREE), Optional.empty());

    public static final TreeGrower YELLOW_IPE_TREE = new TreeGrower(MTAMod.MODID + "yellow_ipe_tree",
            Optional.empty(), Optional.of(MtaConfigFeatures.YELLOW_IPE_TREE), Optional.empty());

    public static final TreeGrower MANGO_TREE = new TreeGrower(MTAMod.MODID + "mango_tree",
            Optional.empty(), Optional.of(MtaConfigFeatures.MANGO_TREE), Optional.empty());

    public static final TreeGrower MAPLE_TREE = new TreeGrower(MTAMod.MODID + "maple_tree",
            Optional.empty(), Optional.of(MtaConfigFeatures.MAPLE_TREE), Optional.empty());

    public static final TreeGrower PALM_TREE = new TreeGrower(MTAMod.MODID + "palm_tree",
            Optional.empty(), Optional.of(MtaConfigFeatures.PALM_TREE), Optional.empty());

    public static final TreeGrower SEAWOOD_TREE = new TreeGrower(MTAMod.MODID + "seawood_tree",
            Optional.of(MtaConfigFeatures.SEAWOOD_TREE),Optional.empty(), Optional.empty());
}
