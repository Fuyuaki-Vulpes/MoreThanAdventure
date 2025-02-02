package com.fuyuaki.morethanadventure.core.registry;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;


public class MTAWoodTypes {
    public static final WoodType PALM = register("palm", MTABlockSetTypes.PALM);
    public static final WoodType BOGGED_OAK = registerFull("bogged_oak", MTABlockSetTypes.BOGGED_OAK, SoundType.NETHER_WOOD, SoundType.NETHER_WOOD_HANGING_SIGN, SoundEvents.NETHER_WOOD_DOOR_CLOSE, SoundEvents.NETHER_WOOD_DOOR_OPEN);



    public static WoodType register(String name, BlockSetType type) {
        return WoodType.register(new WoodType("mta_"+name,type));
    }

    public static WoodType registerFull(String name, BlockSetType setType, SoundType soundType, SoundType hangingSignSoundType, SoundEvent fenceGateClose, SoundEvent fenceGateOpen){
        return WoodType.register(new WoodType("mta_" + name, setType, soundType, hangingSignSoundType, fenceGateClose, fenceGateOpen));
    }
}
