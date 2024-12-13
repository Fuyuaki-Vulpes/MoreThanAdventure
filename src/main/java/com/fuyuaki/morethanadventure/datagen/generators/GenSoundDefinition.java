package com.fuyuaki.morethanadventure.datagen.generators;

import com.fuyuaki.morethanadventure.core.registry.MtaSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class GenSoundDefinition extends SoundDefinitionsProvider {
    public GenSoundDefinition(PackOutput output, ExistingFileHelper helper) {
        super(output, MODID, helper);
    }

    @Override
    public void registerSounds() {
        //Animals
        //add(MtaSounds.CAPYBARA_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/capybara/capybara_ambient")).subtitle("sound.morethanadventure.capybara_ambient"));
        add(MtaSounds.CAPYBARA_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/capybara/capybara_hurt")).subtitle("sound.morethanadventure.capybara_hurt"));
        //add(MtaSounds.CAPYBARA_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/capybara/capybara_death")).subtitle("sound.morethanadventure.capybara_death"));

        add(MtaSounds.DEER_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/deer/idle1"),
                        sound("morethanadventure:entity/deer/idle2"),
                        sound("morethanadventure:entity/deer/idle3"),
                        sound("morethanadventure:entity/deer/idle4"),
                        sound("morethanadventure:entity/deer/idle5"),
                        sound("morethanadventure:entity/deer/idle6")
                        )
                .subtitle("sound.morethanadventure.deer_ambient"));
        add(MtaSounds.DEER_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/deer/hurt1"),
                        sound("morethanadventure:entity/deer/hurt2")
                ).subtitle("sound.morethanadventure.deer_hurt"));
        add(MtaSounds.DEER_DEATH.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/deer/death")).subtitle("sound.morethanadventure.deer_death"));

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

        add(MtaSounds.OWL_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/owl/owl_ambient")).subtitle("sound.morethanadventure.owl_ambient"));
        add(MtaSounds.OWL_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/owl/owl_hurt")).subtitle("sound.morethanadventure.owl_hurt"));
        //add(MtaSounds.OWL_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/owl/owl_death")).subtitle("sound.morethanadventure.owl_death"));

        //add(MtaSounds.RACCOON_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/raccoon/raccoon_ambient")).subtitle("sound.morethanadventure.raccoon_ambient"));
        //add(MtaSounds.RACCOON_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/raccoon/raccoon_hurt")).subtitle("sound.morethanadventure.raccoon_hurt"));
        //add(MtaSounds.RACCOON_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/raccoon/raccoon_death")).subtitle("sound.morethanadventure.raccoon_death"));

        add(MtaSounds.TOUCAN_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/toucan/chirp1"),sound("morethanadventure:entity/toucan/chirp2"),sound("morethanadventure:entity/toucan/chirp3"))
                .subtitle("sound.morethanadventure.toucan_ambient"));
        add(MtaSounds.TOUCAN_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/toucan/hurt1"),sound("morethanadventure:entity/toucan/hurt2")).subtitle("sound.morethanadventure.toucan_hurt"));
        add(MtaSounds.TOUCAN_DEATH.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/toucan/death")).subtitle("sound.morethanadventure.toucan_death"));

        add(MtaSounds.TURKEY_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/turkey/ambient1")
                        ,sound("morethanadventure:entity/turkey/ambient2")
                        ,sound("morethanadventure:entity/turkey/ambient3")
                        ,sound("morethanadventure:entity/turkey/ambient4")
                        ,sound("morethanadventure:entity/turkey/ambient5")
                        ,sound("morethanadventure:entity/turkey/ambient6")
                )
                .subtitle("sound.morethanadventure.turkey_ambient"));
        add(MtaSounds.TURKEY_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/turkey/hurt1"),sound("morethanadventure:entity/turkey/hurt2")).subtitle("sound.morethanadventure.turkey_hurt"));
        add(MtaSounds.TURKEY_DEATH.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/turkey/death")).subtitle("sound.morethanadventure.turkey_death"));

        add(MtaSounds.WISPFLY_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/wispfly/sing1"),
                        sound("morethanadventure:entity/wispfly/sing2"),
                        sound("morethanadventure:entity/wispfly/sing3"),
                        sound("morethanadventure:entity/wispfly/sing4"),
                        sound("morethanadventure:entity/wispfly/sing5"),
                        sound("morethanadventure:entity/wispfly/sing6"))
                .subtitle("sound.morethanadventure.wisp_ambient"));
        add(MtaSounds.WISPFLY_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/wispfly/hurt1")
                        ,sound("morethanadventure:entity/wispfly/hurt2")
                ).subtitle("sound.morethanadventure.wisp_hurt"));
        add(MtaSounds.WISPFLY_DEATH.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/wispfly/death")).subtitle("sound.morethanadventure.wisp_death"));


        //Monsters


        add(MtaSounds.ARMORED_SKELETON_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/armored_skeleton/idle1"),sound("morethanadventure:entity/armored_skeleton/idle2"),sound("morethanadventure:entity/armored_skeleton/idle3"),sound("morethanadventure:entity/armored_skeleton/idle4"))
                .subtitle("sound.morethanadventure.armored_skeleton_ambient"));
        add(MtaSounds.ARMORED_SKELETON_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/armored_skeleton/hurt1"),sound("morethanadventure:entity/armored_skeleton/hurt2"),sound("morethanadventure:entity/armored_skeleton/hurt3"),sound("morethanadventure:entity/armored_skeleton/hurt4"))
                .subtitle("sound.morethanadventure.armored_skeleton_hurt"));
        add(MtaSounds.ARMORED_SKELETON_DEATH.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/armored_skeleton/death1"),sound("morethanadventure:entity/armored_skeleton/death2"))
                .subtitle("sound.morethanadventure.armored_skeleton_death"));
        add(MtaSounds.ARMORED_SKELETON_STEP.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/armored_skeleton/step1"),sound("morethanadventure:entity/armored_skeleton/step2"),sound("morethanadventure:entity/armored_skeleton/step3"),sound("morethanadventure:entity/armored_skeleton/step4"))
                .subtitle("sound.morethanadventure.armored_skeleton_step"));

        add(MtaSounds.CHARRED_SKELETON_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/charred_skeleton/idle1"),sound("morethanadventure:entity/charred_skeleton/idle2"),sound("morethanadventure:entity/charred_skeleton/idle3"))
                .subtitle("sound.morethanadventure.charred_skeleton_ambient"));
        add(MtaSounds.CHARRED_SKELETON_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/charred_skeleton/hurt1"),sound("morethanadventure:entity/charred_skeleton/hurt2"),sound("morethanadventure:entity/charred_skeleton/hurt3"),sound("morethanadventure:entity/charred_skeleton/hurt4"))
                .subtitle("sound.morethanadventure.charred_skeleton_hurt"));
        add(MtaSounds.CHARRED_SKELETON_DEATH.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/charred_skeleton/death1"),sound("morethanadventure:entity/charred_skeleton/death2"))
                .subtitle("sound.morethanadventure.charred_skeleton_death"));
        add(MtaSounds.CHARRED_SKELETON_STEP.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/charred_skeleton/step1"),sound("morethanadventure:entity/charred_skeleton/step2"),sound("morethanadventure:entity/charred_skeleton/step3"),sound("morethanadventure:entity/charred_skeleton/step4"))
                .subtitle("sound.morethanadventure.charred_skeleton_death"));

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

        add(MtaSounds.GLOW_SPIDER_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/glow_spider/say1"),sound("morethanadventure:entity/glow_spider/say2"),sound("morethanadventure:entity/glow_spider/say3"),sound("morethanadventure:entity/glow_spider/say4"))
                .subtitle("sound.morethanadventure.glow_spider_ambient"));

        add(MtaSounds.GLOW_SPIDER_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/glow_spider/say1"),sound("morethanadventure:entity/glow_spider/say2"),sound("morethanadventure:entity/glow_spider/say3"),sound("morethanadventure:entity/glow_spider/say4"))
                .subtitle("sound.morethanadventure.glow_spider_hurt"));

        add(MtaSounds.GLOW_SPIDER_DEATH.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/glow_spider/death"))
                .subtitle("sound.morethanadventure.glow_spider_death"));

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

        add(MtaSounds.WEAPON_DEEP_SWING.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:item/weaponry/deep_swing")).subtitle("sound.morethanadventure.weapons.deep_swing"));

        add(MtaSounds.WEAPON_SWING.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:item/weaponry/swing")).subtitle("sound.morethanadventure.weapons.swing"));

        add(MtaSounds.WEAPON_PUNCH.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:item/weaponry/punch")).subtitle("sound.morethanadventure.weapons.punch"));

        add(MtaSounds.WEAPON_SCRAPE.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:item/weaponry/scrape")).subtitle("sound.morethanadventure.weapons.scrape"));

        add(MtaSounds.WEAPON_STAB_SHARP.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:item/weaponry/stab_sharp")).subtitle("sound.morethanadventure.weapons.stab_sharp"));

        add(MtaSounds.WEAPON_TEAR.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:item/weaponry/tear")).subtitle("sound.morethanadventure.weapons.tear"));

        add(MtaSounds.WEAPON_THROW.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:item/weaponry/throw")).subtitle("sound.morethanadventure.weapons.throw"));

        add(MtaSounds.WEAPON_WHIP.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:item/weaponry/whip")).subtitle("sound.morethanadventure.weapons.whip"));

    }

    protected static SoundDefinition.Sound entitySound(final String name) {
        return sound(ResourceLocation.fromNamespaceAndPath(MODID,"entity/name"));
    }

}
