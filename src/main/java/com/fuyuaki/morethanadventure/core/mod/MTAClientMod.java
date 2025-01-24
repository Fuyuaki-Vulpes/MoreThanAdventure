package com.fuyuaki.morethanadventure.core.mod;


import com.fuyuaki.morethanadventure.network.MTANetwork;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = MTAMod.MODID, dist = Dist.CLIENT)
public class MTAClientMod {

    public MTAClientMod(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::onInitializeClient);

    }

    public void onInitializeClient(FMLClientSetupEvent event) {
        MTANetwork.initClient();
    }
}
