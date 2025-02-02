package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.world.inventory.StoveMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTAMenuTypes {
    private static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(Registries.MENU, MODID);

    public static final DeferredHolder<MenuType<?>,MenuType<StoveMenu>> STOVE = registerMenu("stove", StoveMenu::new);


    public static <T extends AbstractContainerMenu> DeferredHolder<MenuType<?>, MenuType<T>> registerMenu(String key, MenuType.MenuSupplier<T> factory){
        return MENU_TYPES.register(key,() -> new MenuType<>(factory, FeatureFlags.VANILLA_SET));
    }

    public static void register(IEventBus eventBus){
        MENU_TYPES.register(eventBus);
    }
}
