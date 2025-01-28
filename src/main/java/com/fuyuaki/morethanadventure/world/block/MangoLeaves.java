package com.fuyuaki.morethanadventure.world.block;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import net.minecraft.world.level.ItemLike;

public class MangoLeaves extends AgeableLeavesBlock{
    public MangoLeaves(Properties p_54422_) {
        super(p_54422_);
    }

    @Override
    public ItemLike getFruit() {
        return MtaItems.MANGO.get();
    }
}
