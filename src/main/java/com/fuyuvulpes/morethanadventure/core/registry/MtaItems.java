package com.fuyuvulpes.morethanadventure.core.registry;

import com.fuyuvulpes.morethanadventure.world.item.MtaFoods;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class MtaItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);

    //ITEMS

    public static final DeferredItem<Item> CLEAR_QUARTZ = ITEMS.registerSimpleItem("clear_quartz");
    public static final DeferredItem<Item> NETHERITE_FRACTURE = ITEMS.registerSimpleItem("netherite_fracture", new Item.Properties().fireResistant());
    public static final DeferredItem<Item> AGATE = ITEMS.registerSimpleItem("agate", new Item.Properties());
    public static final DeferredItem<Item> ALEXANDRITE = ITEMS.registerSimpleItem("alexandrite", new Item.Properties());
    public static final DeferredItem<Item> AQUAMARINE = ITEMS.registerSimpleItem("aquamarine", new Item.Properties());
    public static final DeferredItem<Item> CELESTITE = ITEMS.registerSimpleItem("celestite", new Item.Properties());
    public static final DeferredItem<Item> GARNET = ITEMS.registerSimpleItem("garnet", new Item.Properties());
    public static final DeferredItem<Item> MOONSTONE = ITEMS.registerSimpleItem("moonstone", new Item.Properties());
    public static final DeferredItem<Item> ARMAMENT_UPGRADE = ITEMS.registerSimpleItem("armament_upgrade", new Item.Properties());
    public static final DeferredItem<Item> LOYALTY_UPGRADE = ITEMS.registerSimpleItem("loyalty_upgrade", new Item.Properties());
    public static final DeferredItem<Item> AQUATIC_UPGRADE = ITEMS.registerSimpleItem("aquatic_upgrade", new Item.Properties());
    public static final DeferredItem<Item> ANGELIC_UPGRADE = ITEMS.registerSimpleItem("angelic_upgrade", new Item.Properties());
    public static final DeferredItem<Item> BERSERK_UPGRADE = ITEMS.registerSimpleItem("berserk_upgrade", new Item.Properties());
    public static final DeferredItem<Item> FEATHERWEIGHT_UPGRADE = ITEMS.registerSimpleItem("featherweight_upgrade", new Item.Properties());

    //ARMOR

    //TOOLS

    //WEAPONS

    //FOODS
    public static final DeferredItem<Item> ONION = ITEMS.registerSimpleItem("onion", new Item.Properties().food(MtaFoods.ONION));
    public static final DeferredItem<Item> SHRIMP = ITEMS.registerSimpleItem("shrimp", new Item.Properties().food(MtaFoods.SHRIMP));
    public static final DeferredItem<Item> COOKED_SHRIMP = ITEMS.registerSimpleItem("cooked_shrimp", new Item.Properties().food(MtaFoods.COOKED_SHRIMP));
    public static final DeferredItem<Item> TOMATO = ITEMS.registerSimpleItem("tomato", new Item.Properties().food(MtaFoods.TOMATO));
    public static final DeferredItem<Item> RED_PEPPER = ITEMS.registerSimpleItem("red_pepper", new Item.Properties().food(MtaFoods.RED_PEPPER));
    public static final DeferredItem<Item> CHILI_PEPPER = ITEMS.registerSimpleItem("chili_pepper", new Item.Properties().food(MtaFoods.CHILI_PEPPER));
    public static final DeferredItem<Item> RICE = ITEMS.registerSimpleItem("rice", new Item.Properties());
    public static final DeferredItem<Item> RICE_BALL = ITEMS.registerSimpleItem("rice_ball", new Item.Properties().food(MtaFoods.RICE_BALL));
    public static final DeferredItem<Item> COCONUT = ITEMS.registerSimpleItem("coconut", new Item.Properties());
    public static final DeferredItem<Item> COCONUT_MILK = ITEMS.registerSimpleItem("coconut_milk", new Item.Properties());
    public static final DeferredItem<Item> COCONUT_SLICE = ITEMS.registerSimpleItem("coconut_slice", new Item.Properties().food(MtaFoods.COCONUT_SLICE));
    public static final DeferredItem<Item> SPICE_MIX = ITEMS.registerSimpleItem("spice_mix", new Item.Properties());
    public static final DeferredItem<Item> SWEET_BEEF_CURRY = ITEMS.registerSimpleItem("sweet_beef_curry", new Item.Properties().food(MtaFoods.SWEET_BEEF_CURRY));
    public static final DeferredItem<Item> SWEET_PORK_CURRY = ITEMS.registerSimpleItem("sweet_pork_curry", new Item.Properties().food(MtaFoods.SWEET_PORK_CURRY));
    public static final DeferredItem<Item> SWEET_CHICKEN_CURRY = ITEMS.registerSimpleItem("sweet_chicken_curry", new Item.Properties().food(MtaFoods.SWEET_CHICKEN_CURRY));
    public static final DeferredItem<Item> SWEET_SHRIMP_CURRY = ITEMS.registerSimpleItem("sweet_shrimp_curry", new Item.Properties().food(MtaFoods.SWEET_SHRIMP_CURRY));
    public static final DeferredItem<Item> MILD_BEEF_CURRY = ITEMS.registerSimpleItem("mild_beef_curry", new Item.Properties().food(MtaFoods.MILD_BEEF_CURRY));
    public static final DeferredItem<Item> MILD_PORK_CURRY = ITEMS.registerSimpleItem("mild_pork_curry", new Item.Properties().food(MtaFoods.MILD_PORK_CURRY));
    public static final DeferredItem<Item> MILD_CHICKEN_CURRY = ITEMS.registerSimpleItem("mild_chicken_curry", new Item.Properties().food(MtaFoods.MILD_CHICKEN_CURRY));
    public static final DeferredItem<Item> MILD_SHRIMP_CURRY = ITEMS.registerSimpleItem("mild_shrimp_curry", new Item.Properties().food(MtaFoods.MILD_SHRIMP_CURRY));
    public static final DeferredItem<Item> SPICY_BEEF_CURRY = ITEMS.registerSimpleItem("spicy_beef_curry", new Item.Properties().food(MtaFoods.SPICY_BEEF_CURRY));
    public static final DeferredItem<Item> SPICY_PORK_CURRY = ITEMS.registerSimpleItem("spicy_pork_curry", new Item.Properties().food(MtaFoods.SPICY_PORK_CURRY));
    public static final DeferredItem<Item> SPICY_CHICKEN_CURRY = ITEMS.registerSimpleItem("spicy_chicken_curry", new Item.Properties().food(MtaFoods.SPICY_CHICKEN_CURRY));
    public static final DeferredItem<Item> SPICY_SHRIMP_CURRY = ITEMS.registerSimpleItem("spicy_shrimp_curry", new Item.Properties().food(MtaFoods.SPICY_SHRIMP_CURRY));




    // SPAWN EGGS
    public static final DeferredItem<Item> YUKI_ONNA_SPAWN_EGG =  ITEMS.register("yuki_onna_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.YUKI_ONNA::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static final DeferredItem<Item> FALLEN_SAMURAI_SPAWN_EGG =  ITEMS.register("fallen_samurai_spawn_egg",
            () -> new DeferredSpawnEggItem(MtaEntityTypes.FALLEN_SAMURAI::get,0xFFFFFF,0xFFFFFF,new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
