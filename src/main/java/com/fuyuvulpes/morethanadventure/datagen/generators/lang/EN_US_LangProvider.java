package com.fuyuvulpes.morethanadventure.datagen.generators.lang;

import com.fuyuvulpes.morethanadventure.core.registry.MtaBlocks;
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
        add(MtaBlocks.SPRINKLER.get(),"Sprinkler");
        add("itemGroup.morethanadventure","More Than Adventure");

    }
}
