package com.fuyuaki.morethanadventure.core.registry;

import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;


public class MTAWoodTypes {
    public static final WoodType PALM = register("mta_palm", MTABlockSetTypes.PALM);



    public static WoodType register(String name, BlockSetType type) {
        return WoodType.register(new WoodType("mta_"+name,type));
    }
}
