package com.fuyuaki.morethanadventure.world.event;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEffects;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ComputeFovModifierEvent;

import java.util.List;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME, value = Dist.CLIENT)
public class MTAGameClientEvents {


    @SubscribeEvent
    public static void computeFovModifierEvent(ComputeFovModifierEvent event) {
        List<Item> bows = List.of(
                MtaItems.NETHERITE_BOW.get(),
                MtaItems.LONG_BOW.get(),MtaItems.REINFORCED_LONG_BOW.get(),
                MtaItems.SHORT_BOW.get(),MtaItems.REINFORCED_SHORT_BOW.get(),
                MtaItems.TWIN_BOW.get(),MtaItems.REINFORCED_TWIN_BOW.get()
        );
        if (event.getPlayer().isUsingItem() && event.getPlayer().getUseItem().getItem() == MtaItems.NETHERITE_BOW.get() ) {
            float fovModifier = 1f;
            int tickUsingItem = event.getPlayer().getTicksUsingItem();
            float deltaTicks = (float) tickUsingItem / 10f;
            if (deltaTicks > 2f) {
                deltaTicks = 2f;
            } else {
                deltaTicks *= 0.5f * deltaTicks;
            }
            fovModifier *= 1f - deltaTicks * 0.15f;
            event.setNewFovModifier(fovModifier);

        }
        if (event.getPlayer().isUsingItem() && event.getPlayer().getUseItem().getItem() == MtaItems.TEMPLE_ANGELS_BOW.get()) {
            float fovModifier = 1f;
            int tickUsingItem = event.getPlayer().getTicksUsingItem();
            float deltaTicks = (float) tickUsingItem / 4f;
            if (deltaTicks > 5f) {
                deltaTicks = 5f;
            } else {
                deltaTicks *= 0.2f * deltaTicks;
            }
            fovModifier *= 1f - deltaTicks * 0.10f;
            event.setNewFovModifier(fovModifier);
        }
        if (event.getPlayer().isUsingItem() && event.getPlayer().getUseItem().getItem() == MtaItems.SHADOW_ROGUES_DAGGER.get()) {
            float fovModifier = 1f;
            int tickUsingItem = event.getPlayer().getTicksUsingItem();
            float deltaTicks = (float) tickUsingItem / 4f;
            if (deltaTicks > 5f) {
                deltaTicks = 5f;
            } else {
                deltaTicks *= 0.2f * deltaTicks;
            }
            fovModifier *= 1f - deltaTicks * 0.10f;
            event.setNewFovModifier(fovModifier);
        }

        if (event.getPlayer().hasEffect(MtaEffects.STUN)){
            event.setNewFovModifier(1 - (Mth.abs(Mth.sin((float) event.getPlayer().tickCount / 25)) * 0.3F));
        }
    }

}

