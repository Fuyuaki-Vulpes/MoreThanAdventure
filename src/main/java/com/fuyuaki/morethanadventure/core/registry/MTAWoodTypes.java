package com.fuyuaki.morethanadventure.core.registry;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;


public class MTAWoodTypes {
    public static final WoodType ALPINE = register(":alpine", BlockSetType.OAK);
    public static final WoodType AVOCADO = register(":avocado", MTABlockSetTypes.AVOCADO);
    public static final WoodType BOGGED_OAK = registerFull(":bogged_oak", MTABlockSetTypes.BOGGED_OAK, SoundType.NETHER_WOOD, SoundType.NETHER_WOOD_HANGING_SIGN, SoundEvents.NETHER_WOOD_DOOR_CLOSE, SoundEvents.NETHER_WOOD_DOOR_OPEN);
    public static final WoodType IPE = register(":ipe", MTABlockSetTypes.IPE);
    public static final WoodType MANGO = register(":mango", MTABlockSetTypes.MANGO);
    public static final WoodType MAPLE = register(":maple", MTABlockSetTypes.MAPLE);
    public static final WoodType PALM = register(":palm", MTABlockSetTypes.PALM);
    public static final WoodType SEAWOOD = register(":seawood", MTABlockSetTypes.SEAWOOD);



    public static WoodType register(String name, BlockSetType type) {
        return WoodType.register(new WoodType(MODID + name,type));
    }

    public static WoodType registerFull(String name, BlockSetType setType, SoundType soundType, SoundType hangingSignSoundType, SoundEvent fenceGateClose, SoundEvent fenceGateOpen){
        return WoodType.register(new WoodType(MODID + name, setType, soundType, hangingSignSoundType, fenceGateClose, fenceGateOpen));
    }
}
