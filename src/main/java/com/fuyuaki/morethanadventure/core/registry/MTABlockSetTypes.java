package com.fuyuaki.morethanadventure.core.registry;

import net.minecraft.world.level.block.state.properties.BlockSetType;

public class MTABlockSetTypes {
    public static final BlockSetType PALM = register("palm");

    public static BlockSetType register(String name) {
        return BlockSetType.register(new BlockSetType("mta" + name));
    }
}
