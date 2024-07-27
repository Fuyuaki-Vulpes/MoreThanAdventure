package com.fuyuvulpes.morethanadventure.datagen.generators.lang;

import com.fuyuvulpes.morethanadventure.core.registry.MtaBlocks;
import com.fuyuvulpes.morethanadventure.core.registry.MtaEntityTypes;
import com.fuyuvulpes.morethanadventure.core.registry.MtaItems;
import com.fuyuvulpes.morethanadventure.core.registry.MtaTabs;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import java.awt.*;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class EN_US_LangProvider extends LanguageProvider {
    public EN_US_LangProvider(PackOutput output) {
        super(output, MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        //BLOCKS
        add(MtaBlocks.SPRINKLER.get(),"Sprinkler");

        //ITEM
        add(MtaItems.CLEAR_QUARTZ.get(),"Clear Quartz");
        add(MtaItems.NETHERITE_FRACTURE.get(),"Netherite Scrap Facture");
        add(MtaItems.AGATE.get(),"Agate");
        add(MtaItems.ALEXANDRITE.get(),"Alexandrite");
        add(MtaItems.AQUAMARINE.get(),"Aquamarine");
        add(MtaItems.CELESTITE.get(),"Celestite");
        add(MtaItems.GARNET.get(),"Garnet");
        add(MtaItems.MOONSTONE.get(),"Moonstone");
        add(MtaItems.ARMAMENT_UPGRADE.get(),"Armament_Upgrade");
        add(MtaItems.LOYALTY_UPGRADE.get(),"Loyalty_Upgrade");
        add(MtaItems.AQUATIC_UPGRADE.get(),"Aquatic_Upgrade");
        add(MtaItems.ANGELIC_UPGRADE.get(),"Angelic_Upgrade");
        add(MtaItems.BERSERK_UPGRADE.get(),"Berserk_Upgrade");
        add(MtaItems.FEATHERWEIGHT_UPGRADE.get(),"Featherweight_Upgrade");

        //ARMOR
        add(MtaItems.GREAT_SENTINELS_HELMET.get(), "Great Sentinel's Helmet");
        add(MtaItems.GREAT_SENTINELS_CHESTPLATE.get(), "Great Sentinel's Chestplate");
        add(MtaItems.GREAT_SENTINELS_LEGGINGS.get(), "Great Sentinel's Leggings");
        add(MtaItems.GREAT_SENTINELS_BOOTS.get(), "Great Sentinel's Boots");
        add(MtaItems.HOLY_KNIGHTS_HELMET.get(), "Holy Knight's Helmet");
        add(MtaItems.HOLY_KNIGHTS_CHESTPLATE.get(), "Holy Knight's Chestplate");
        add(MtaItems.HOLY_KNIGHTS_LEGGINGS.get(), "Holy Knight's Leggings");
        add(MtaItems.HOLY_KNIGHTS_BOOTS.get(), "Holy Knight's Boots");
        add(MtaItems.MYSTIC_MERMAIDS_HELMET.get(), "Mystic Mermaid's Helmet");
        add(MtaItems.MYSTIC_MERMAIDS_CHESTPLATE.get(), "Mystic Mermaid's Chestplate");
        add(MtaItems.MYSTIC_MERMAIDS_LEGGINGS.get(), "Mystic Mermaid's Leggings");
        add(MtaItems.MYSTIC_MERMAIDS_BOOTS.get(), "Mystic Mermaid's Boots");
        add(MtaItems.TEMPLE_ANGELS_HELMET.get(), "Temple Angel's Helmet");
        add(MtaItems.TEMPLE_ANGELS_CHESTPLATE.get(), "Temple Angel's Chestplate");
        add(MtaItems.TEMPLE_ANGELS_LEGGINGS.get(), "Temple Angel's Leggings");
        add(MtaItems.TEMPLE_ANGELS_BOOTS.get(), "Temple Angel's Boots");
        add(MtaItems.WRATHFUL_BERSERKERS_HELMET.get(), "Wrathful Berserker's Helmet");
        add(MtaItems.WRATHFUL_BERSERKERS_CHESTPLATE.get(), "Wrathful Berserker's Chestplate");
        add(MtaItems.WRATHFUL_BERSERKERS_LEGGINGS.get(), "Wrathful Berserker's Leggings");
        add(MtaItems.WRATHFUL_BERSERKERS_BOOTS.get(), "Wrathful Berserker's Boots");
        add(MtaItems.SHADOW_ROGUES_HELMET.get(), "Shadow Rogue's Helmet");
        add(MtaItems.SHADOW_ROGUES_CHESTPLATE.get(), "Shadow Rogue's Chestplate");
        add(MtaItems.SHADOW_ROGUES_LEGGINGS.get(), "Shadow Rogue's Leggings");
        add(MtaItems.SHADOW_ROGUES_BOOTS.get(), "Shadow Rogue's Boots");

        //FOODS
        add(MtaItems.ONION.get(),"Onion");
        add(MtaItems.SHRIMP.get(),"Shrimp");
        add(MtaItems.COOKED_SHRIMP.get(),"Cooked Shrimp");
        add(MtaItems.TOMATO.get(),"Tomato");
        add(MtaItems.RED_PEPPER.get(),"Red Pepper");
        add(MtaItems.CHILI_PEPPER.get(),"Chili Pepper");
        add(MtaItems.RICE.get(),"Rice");
        add(MtaItems.RICE_BALL.get(),"Rice Ball");
        add(MtaItems.COCONUT.get(),"Coconut");
        add(MtaItems.COCONUT_MILK.get(),"Coconut Milk");
        add(MtaItems.COCONUT_SLICE.get(),"Coconut Slice");
        add(MtaItems.SPICE_MIX.get(),"Spice Mix");
        add(MtaItems.SWEET_BEEF_CURRY.get(),"Sweet Beef Curry");
        add(MtaItems.SWEET_PORK_CURRY.get(),"Sweet Pork Curry");
        add(MtaItems.SWEET_CHICKEN_CURRY.get(),"Sweet Chicken Curry");
        add(MtaItems.SWEET_SHRIMP_CURRY.get(),"Sweet Shrimp Curry");
        add(MtaItems.MILD_BEEF_CURRY.get(),"Mild Beef Curry");
        add(MtaItems.MILD_CHICKEN_CURRY.get(),"Mild Chicken Curry");
        add(MtaItems.MILD_SHRIMP_CURRY.get(),"Mild Shrimp Curry");
        add(MtaItems.SPICY_BEEF_CURRY.get(),"Spicy Beef Curry");
        add(MtaItems.SPICY_PORK_CURRY.get(),"Spicy Pork Curry");
        add(MtaItems.SPICY_CHICKEN_CURRY.get(),"Spicy Chicken Curry");
        add(MtaItems.SPICY_SHRIMP_CURRY.get(),"Spicy Shrimp Curry");

        //SPAWN EGGS

        add(MtaItems.YUKI_ONNA_SPAWN_EGG.get(),"Yuki Onna Spawn Egg");
        add(MtaItems.FALLEN_SAMURAI_SPAWN_EGG.get(),"Fallen Samurai Spawn Egg");


        //ENTITIES
        add(MtaEntityTypes.YUKI_ONNA.get(),"Yuki Onna");
        add(MtaEntityTypes.FALLEN_SAMURAI.get(),"Fallen Samurai");

        //OTHER
        add("itemGroup.morethanadventure","More Than Adventure");

    }
}
