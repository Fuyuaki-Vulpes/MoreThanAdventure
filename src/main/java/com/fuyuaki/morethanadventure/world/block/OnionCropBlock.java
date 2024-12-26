package com.fuyuaki.morethanadventure.world.block;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import com.mojang.serialization.MapCodec;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.CropBlock;

public class OnionCropBlock extends MtaCrops {
    public static final MapCodec<OnionCropBlock> CODEC = simpleCodec(OnionCropBlock::new);
    public static final int MAX_AGE = 7;
    public OnionCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return MtaItems.ONION;
    }

    @Override
    public MapCodec<? extends CropBlock> codec() {
        return super.codec();
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;


    }

}
