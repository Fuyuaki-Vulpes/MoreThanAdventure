package com.fuyuaki.morethanadventure.game.worldgen.tree;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.game.worldgen.MtaConfigFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class MtaTreeGrower {

    public static final TreeGrower PALM_TREE = new TreeGrower(MTAMod.MODID + "palm_tree",
            Optional.empty(), Optional.of(MtaConfigFeatures.PALM_TREE), Optional.empty());
}
