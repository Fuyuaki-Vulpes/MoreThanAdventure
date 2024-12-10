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
        //add(MtaSounds.BEARDED_DRAGON_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/bearded_dragon/bearded_dragon_ambient")).subtitle("sound.morethanadventure.bearded_dragon_ambient"));
        //add(MtaSounds.BEARDED_DRAGON_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/bearded_dragon/bearded_dragon_hurt")).subtitle("sound.morethanadventure.bearded_dragon_hurt"));
        //add(MtaSounds.BEARDED_DRAGON_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/bearded_dragon/bearded_dragon_death")).subtitle("sound.morethanadventure.bearded_dragon_death"));

        //add(MtaSounds.CAPYBARA_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/capybara/capybara_ambient")).subtitle("sound.morethanadventure.capybara_ambient"));
        add(MtaSounds.CAPYBARA_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/capybara/capybara_hurt")).subtitle("sound.morethanadventure.capybara_hurt"));
        //add(MtaSounds.CAPYBARA_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/capybara/capybara_death")).subtitle("sound.morethanadventure.capybara_death"));

        add(MtaSounds.DUCK_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/duck/duck_ambient_1"))
                .with(sound("morethanadventure:entity/duck/duck_ambient_2"))
                .with(sound("morethanadventure:entity/duck/duck_laugh_1"))
                .subtitle("sound.morethanadventure.duck_ambient"));
        //add(MtaSounds.DUCK_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/duck/duck_hurt")).subtitle("sound.morethanadventure.duck_hurt"));
        //add(MtaSounds.DUCK_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/duck/duck_death")).subtitle("sound.morethanadventure.duck_death"));

        add(MtaSounds.FERRET_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/ferret/ferret_ambient")).subtitle("sound.morethanadventure.ferret_ambient"));
        add(MtaSounds.FERRET_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/ferret/ferret_hurt")).subtitle("sound.morethanadventure.ferret_hurt"));
        //add(MtaSounds.FERRET_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/ferret/ferret_death")).subtitle("sound.morethanadventure.ferret_death"));

        //add(MtaSounds.GREAT_WHITE_SHARK_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/great_white_shark/great_white_shark_ambient")).subtitle("sound.morethanadventure.great_white_shark_ambient"));
        //add(MtaSounds.GREAT_WHITE_SHARK_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/great_white_shark/great_white_shark_hurt")).subtitle("sound.morethanadventure.great_white_shark_hurt"));
        //add(MtaSounds.GREAT_WHITE_SHARK_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/great_white_shark/great_white_shark_death")).subtitle("sound.morethanadventure.great_white_shark_death"));

        //add(MtaSounds.HORSESHOE_CRAB_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/horseshoe_crab/horseshoe_crab_ambient")).subtitle("sound.morethanadventure.horseshoe_crab_ambient"));
        //add(MtaSounds.HORSESHOE_CRAB_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/horseshoe_crab/horseshoe_crab_hurt")).subtitle("sound.morethanadventure.horseshoe_crab_hurt"));
        //add(MtaSounds.HORSESHOE_CRAB_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/horseshoe_crab/horseshoe_crab_death")).subtitle("sound.morethanadventure.horseshoe_crab_death"));

        //add(MtaSounds.JELLYFISH_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/jellyfish/jellyfish_ambient")).subtitle("sound.morethanadventure.jellyfish_ambient"));
        //add(MtaSounds.JELLYFISH_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/jellyfish/jellyfish_hurt")).subtitle("sound.morethanadventure.jellyfish_hurt"));
        //add(MtaSounds.JELLYFISH_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/jellyfish/jellyfish_death")).subtitle("sound.morethanadventure.jellyfish_death"));

        //add(MtaSounds.OCTOPUS_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/octopus/octopus_ambient")).subtitle("sound.morethanadventure.octopus_ambient"));
        //add(MtaSounds.OCTOPUS_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/octopus/octopus_hurt")).subtitle("sound.morethanadventure.octopus_hurt"));
        //add(MtaSounds.OCTOPUS_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/octopus/octopus_death")).subtitle("sound.morethanadventure.octopus_death"));

        add(MtaSounds.OWL_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/owl/owl_ambient")).subtitle("sound.morethanadventure.owl_ambient"));
        add(MtaSounds.OWL_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/owl/owl_hurt")).subtitle("sound.morethanadventure.owl_hurt"));
        //add(MtaSounds.OWL_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/owl/owl_death")).subtitle("sound.morethanadventure.owl_death"));

        //add(MtaSounds.PENGUIN_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/penguin/penguin_ambient")).subtitle("sound.morethanadventure.penguin_ambient"));
        //add(MtaSounds.PENGUIN_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/penguin/penguin_hurt")).subtitle("sound.morethanadventure.penguin_hurt"));
        //add(MtaSounds.PENGUIN_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/penguin/penguin_death")).subtitle("sound.morethanadventure.penguin_death"));

        //add(MtaSounds.RACCOON_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/raccoon/raccoon_ambient")).subtitle("sound.morethanadventure.raccoon_ambient"));
        //add(MtaSounds.RACCOON_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/raccoon/raccoon_hurt")).subtitle("sound.morethanadventure.raccoon_hurt"));
        //add(MtaSounds.RACCOON_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/raccoon/raccoon_death")).subtitle("sound.morethanadventure.raccoon_death"));

        //add(MtaSounds.TOUCAN_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/toucan/toucan_ambient")).subtitle("sound.morethanadventure.toucan_ambient"));
        //add(MtaSounds.TOUCAN_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/toucan/toucan_hurt")).subtitle("sound.morethanadventure.toucan_hurt"));
        //add(MtaSounds.TOUCAN_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/toucan/toucan_death")).subtitle("sound.morethanadventure.toucan_death"));

        //add(MtaSounds.WISPFLY_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/wisp/wisp_ambient")).subtitle("sound.morethanadventure.wisp_ambient"));
        //add(MtaSounds.WISPFLY_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/wisp/wisp_hurt")).subtitle("sound.morethanadventure.wisp_hurt"));
        //add(MtaSounds.WISPFLY_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/wisp/wisp_death")).subtitle("sound.morethanadventure.wisp_death"));


        //Monsters


        //add(MtaSounds.ARMORED_SKELETON_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/armored_skeleton/armored_skeleton_ambient")).subtitle("sound.morethanadventure.armored_skeleton_ambient"));
        //add(MtaSounds.ARMORED_SKELETON_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/armored_skeleton/armored_skeleton_hurt")).subtitle("sound.morethanadventure.armored_skeleton_hurt"));
        //add(MtaSounds.ARMORED_SKELETON_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/armored_skeleton/armored_skeleton_death")).subtitle("sound.morethanadventure.armored_skeleton_death"));

        //add(MtaSounds.BLACK_WIDOW_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/black_widow/black_widow_ambient")).subtitle("sound.morethanadventure.black_widow_ambient"));
        //add(MtaSounds.BLACK_WIDOW_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/black_widow/black_widow_hurt")).subtitle("sound.morethanadventure.black_widow_hurt"));
        //add(MtaSounds.BLACK_WIDOW_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/black_widow/black_widow_death")).subtitle("sound.morethanadventure.black_widow_death"));

        //add(MtaSounds.CHARRED_SKELETON_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/charred_skeleton/charred_skeleton_ambient")).subtitle("sound.morethanadventure.charred_skeleton_ambient"));
        //add(MtaSounds.CHARRED_SKELETON_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/charred_skeleton/charred_skeleton_hurt")).subtitle("sound.morethanadventure.charred_skeleton_hurt"));
        //add(MtaSounds.CHARRED_SKELETON_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/charred_skeleton/charred_skeleton_death")).subtitle("sound.morethanadventure.charred_skeleton_death"));

        //add(MtaSounds.CORROSIVE_CUBE_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/corrosive_cube/corrosive_cube_ambient")).subtitle("sound.morethanadventure.corrosive_cube_ambient"));
        //add(MtaSounds.CORROSIVE_CUBE_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/corrosive_cube/corrosive_cube_hurt")).subtitle("sound.morethanadventure.corrosive_cube_hurt"));
        //add(MtaSounds.CORROSIVE_CUBE_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/corrosive_cube/corrosive_cube_death")).subtitle("sound.morethanadventure.corrosive_cube_death"));

        add(MtaSounds.FALLEN_SAMURAI_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/fallen_samurai/say1"), sound("morethanadventure:entity/fallen_samurai/say2"), sound("morethanadventure:entity/fallen_samurai/say3"))
                .subtitle("sound.morethanadventure.fallen_samurai_ambient"));
        add(MtaSounds.FALLEN_SAMURAI_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/fallen_samurai/hurt1"), sound("morethanadventure:entity/fallen_samurai/hurt2"), sound("morethanadventure:entity/fallen_samurai/hurt3"), sound("morethanadventure:entity/fallen_samurai/hurt4"))
                .subtitle("sound.morethanadventure.fallen_samurai_hurt"));
        add(MtaSounds.FALLEN_SAMURAI_DEATH.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/fallen_samurai/death"))
                .subtitle("sound.morethanadventure.fallen_samurai_death"));

        //add(MtaSounds.FROSTED_SLIME_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/frosted_slime/frosted_slime_ambient")).subtitle("sound.morethanadventure.frosted_slime_ambient"));
        //add(MtaSounds.FROSTED_SLIME_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/frosted_slime/frosted_slime_hurt")).subtitle("sound.morethanadventure.frosted_slime_hurt"));
        //add(MtaSounds.FROSTED_SLIME_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/frosted_slime/frosted_slime_death")).subtitle("sound.morethanadventure.frosted_slime_death"));

        //add(MtaSounds.GLOW_SPIDER_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/glow_spider/glow_spider_ambient")).subtitle("sound.morethanadventure.glow_spider_ambient"));
        //add(MtaSounds.GLOW_SPIDER_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/glow_spider/glow_spider_hurt")).subtitle("sound.morethanadventure.glow_spider_hurt"));
        //add(MtaSounds.GLOW_SPIDER_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/glow_spider/glow_spider_death")).subtitle("sound.morethanadventure.glow_spider_death"));

        //add(MtaSounds.HOST_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/host/host_ambient")).subtitle("sound.morethanadventure.host_ambient"));
        //add(MtaSounds.HOST_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/host/host_hurt")).subtitle("sound.morethanadventure.host_hurt"));
        //add(MtaSounds.HOST_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/host/host_death")).subtitle("sound.morethanadventure.host_death"));

        //add(MtaSounds.ICICLE_CREEPER_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/icicle_creeper/icicle_creeper_ambient")).subtitle("sound.morethanadventure.icicle_creeper_ambient"));
        //add(MtaSounds.ICICLE_CREEPER_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/icicle_creeper/icicle_creeper_hurt")).subtitle("sound.morethanadventure.icicle_creeper_hurt"));
        //add(MtaSounds.ICICLE_CREEPER_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/icicle_creeper/icicle_creeper_death")).subtitle("sound.morethanadventure.icicle_creeper_death"));

        //add(MtaSounds.MOSSY_ZOMBIE_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/mossy_zombie/mossy_zombie_ambient")).subtitle("sound.morethanadventure.mossy_zombie_ambient"));
        //add(MtaSounds.MOSSY_ZOMBIE_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/mossy_zombie/mossy_zombie_hurt")).subtitle("sound.morethanadventure.mossy_zombie_hurt"));
        //add(MtaSounds.MOSSY_ZOMBIE_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/mossy_zombie/mossy_zombie_death")).subtitle("sound.morethanadventure.mossy_zombie_death"));

        //add(MtaSounds.SIREN_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/siren/siren_ambient")).subtitle("sound.morethanadventure.siren_ambient"));
        //add(MtaSounds.SIREN_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/siren/siren_hurt")).subtitle("sound.morethanadventure.siren_hurt"));
        //add(MtaSounds.SIREN_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/siren/siren_death")).subtitle("sound.morethanadventure.siren_death"));

        //add(MtaSounds.SKELETON_FIGTHTER_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/skeleton_fighter/skeleton_fighter_ambient")).subtitle("sound.morethanadventure.skeleton_fighter_ambient"));
        //add(MtaSounds.SKELETON_FIGTHTER_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/skeleton_fighter/skeleton_fighter_hurt")).subtitle("sound.morethanadventure.skeleton_fighter_hurt"));
        //add(MtaSounds.SKELETON_FIGTHTER_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/skeleton_fighter/skeleton_fighter_death")).subtitle("sound.morethanadventure.skeleton_fighter_death"));

        //add(MtaSounds.TOXIC_ZOMBIE_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/toxic_zombie/toxic_zombie_ambient")).subtitle("sound.morethanadventure.toxic_zombie_ambient"));
        //add(MtaSounds.TOXIC_ZOMBIE_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/toxic_zombie/toxic_zombie_hurt")).subtitle("sound.morethanadventure.toxic_zombie_hurt"));
        //add(MtaSounds.TOXIC_ZOMBIE_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/toxic_zombie/toxic_zombie_death")).subtitle("sound.morethanadventure.toxic_zombie_death"));

        add(MtaSounds.YUKI_ONNA_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/yuki_onna/ambient_1"),sound("morethanadventure:entity/yuki_onna/ambient_2")).subtitle("sound.morethanadventure.yuki_onna_ambient"));
        add(MtaSounds.YUKI_ONNA_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/yuki_onna/hurt")).subtitle("sound.morethanadventure.yuki_onna_hurt"));
        add(MtaSounds.YUKI_ONNA_DEATH.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/yuki_onna/death")).subtitle("sound.morethanadventure.yuki_onna_death"));

        //add(MtaSounds.ZOMBIFIED_MINER_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/zombified_miner/zombified_miner_ambient")).subtitle("sound.morethanadventure.zombified_miner_ambient"));
        //add(MtaSounds.ZOMBIFIED_MINER_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/zombified_miner/zombified_miner_hurt")).subtitle("sound.morethanadventure.zombified_miner_hurt"));
        //add(MtaSounds.ZOMBIFIED_MINER_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/zombified_miner/zombified_miner_death")).subtitle("sound.morethanadventure.zombified_miner_death"));


        //Other
    }
}
