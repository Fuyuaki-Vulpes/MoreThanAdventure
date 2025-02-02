package com.fuyuaki.morethanadventure.world.block.kitchen;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MixingBowlBlock {
    private static final VoxelShape OUTER = Block.box(3, 0, 3, 13, 5, 13);
    private static final VoxelShape INNER = Block.box(4, 1, 4, 12, 5, 12);
    private static final VoxelShape SHAPE = Shapes.join(OUTER,INNER, BooleanOp.ONLY_FIRST);


}
