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
        //ITEMS
        add(MtaItems.YUKI_ONNA_SPAWN_EGG.get(), "Yuki Onna Spawn");

        //BLOCKS
        add(MtaBlocks.SPRINKLER.get(),"Sprinkler");


        //ENTITIES
        add(MtaEntityTypes.YUKI_ONNA.get(),"Yuki Onna");
        //BIOMES

        //TAGS

        //OTHER
        add("itemGroup.morethanadventure","More Than Adventure");

    }
}
