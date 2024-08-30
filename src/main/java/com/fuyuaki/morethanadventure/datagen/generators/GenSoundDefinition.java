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
        add(MtaSounds.DUCK_AMBIENT_1.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/duck/duck_ambient_1")).subtitle("sound.morethanadventure.duck_ambient_1"));
        add(MtaSounds.DUCK_AMBIENT_2.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/duck/duck_ambient_2")).subtitle("sound.morethanadventure.duck_ambient_2"));
        add(MtaSounds.DUCK_LAUGH_1.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/duck/duck_laugh_1")).subtitle("sound.morethanadventure.duck_laugh_1"));


        //Monsters



        //Other
    }
}
