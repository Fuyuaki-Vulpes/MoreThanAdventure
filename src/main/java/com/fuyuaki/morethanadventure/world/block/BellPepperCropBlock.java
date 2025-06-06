package com.fuyuaki.morethanadventure.world.block;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class BellPepperCropBlock extends MtaCrops {
    public static final int MAX_AGE = 7;
    public BellPepperCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return MtaItems.BELL_PEPPER_SEEDS;
    }


    @Override
    public int getMaxAge() {
        return MAX_AGE;


    }

}
