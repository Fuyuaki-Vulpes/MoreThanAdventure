package com.fuyuaki.morethanadventure.world.block;

import net.minecraft.world.level.block.CropBlock;

public class MtaCrops extends CropBlock {

    public static final int MAX_AGE = 7;
    public MtaCrops(Properties properties) {
        super(properties);
    }


    @Override
    public int getMaxAge() {
        return MAX_AGE;


    }

}
