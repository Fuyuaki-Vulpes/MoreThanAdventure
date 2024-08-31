package com.fuyuaki.morethanadventure.datagen.generators;

import com.fuyuaki.morethanadventure.core.registry.MtaSounds;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class GenSoundDefinition extends SoundDefinitionsProvider {
    public GenSoundDefinition(PackOutput output, ExistingFileHelper helper) {
        super(output, MODID, helper);
    }

    @Override
    public void registerSounds() {
        //Animals
        add(MtaSounds.CAPYBARA_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/capybara/capybara_hurt")).subtitle("sound.morethanadventure.capybara_hurt"));
        add(MtaSounds.DUCK_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/duck/duck_ambient_1"))
                .with(sound("morethanadventure:entity/duck/duck_ambient_2"))
                .with(sound("morethanadventure:entity/duck/duck_laugh_1"))
                .subtitle("sound.morethanadventure.duck_ambient_1"));
        add(MtaSounds.FERRET_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/ferret/ferret_ambient")).subtitle("sound.morethanadventure.ferret_ambient"));
        add(MtaSounds.FERRET_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/ferret/ferret_hurt")).subtitle("sound.morethanadventure.ferret_hurt"));
        add(MtaSounds.OWL_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/owl/owl_ambient")).subtitle("sound.morethanadventure.owl_ambient"));
        add(MtaSounds.OWL_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/owl/owl_hurt")).subtitle("sound.morethanadventure.owl_hurt"));


        //Monsters



        //Other
    }
}
