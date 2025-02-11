package com.fuyuaki.morethanadventure.core.datagen.other;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.SoundDefinition;
import net.neoforged.neoforge.common.data.SoundDefinitionsProvider;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class GenSoundDefinition extends SoundDefinitionsProvider {
    public GenSoundDefinition(PackOutput output) {
        super(output, MODID);
    }

    @Override
    public void registerSounds() {
        //Animals
        //add(MtaSounds.CAPYBARA_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/capybara/idle")).subtitle("sound.morethanadventure.capybara_ambient"));
        add(MtaSounds.CAPYBARA_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/capybara/hurt")).subtitle("sound.morethanadventure.capybara_hurt"));
        //add(MtaSounds.CAPYBARA_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/capybara/death")).subtitle("sound.morethanadventure.capybara_death"));

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
                .with(sound("morethanadventure:entity/duck/idle1"))
                .with(sound("morethanadventure:entity/duck/idle2"))
                .with(sound("morethanadventure:entity/duck/laugh"))
                .subtitle("sound.morethanadventure.duck_ambient"));
        //add(MtaSounds.DUCK_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/duck/hurt")).subtitle("sound.morethanadventure.duck_hurt"));
        //add(MtaSounds.DUCK_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/duck/death")).subtitle("sound.morethanadventure.duck_death"));

        add(MtaSounds.FERRET_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/ferret/idle")).subtitle("sound.morethanadventure.ferret_ambient"));
        add(MtaSounds.FERRET_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/ferret/hurt")).subtitle("sound.morethanadventure.ferret_hurt"));
        //add(MtaSounds.FERRET_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/ferret/death")).subtitle("sound.morethanadventure.ferret_death"));

        add(MtaSounds.OWL_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/owl/idle")).subtitle("sound.morethanadventure.owl_ambient"));
        add(MtaSounds.OWL_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/owl/hurt")).subtitle("sound.morethanadventure.owl_hurt"));
        //add(MtaSounds.OWL_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/owl/death")).subtitle("sound.morethanadventure.owl_death"));

        //add(MtaSounds.RACCOON_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/raccoon/idle")).subtitle("sound.morethanadventure.raccoon_ambient"));
        //add(MtaSounds.RACCOON_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/raccoon/hurt")).subtitle("sound.morethanadventure.raccoon_hurt"));
        //add(MtaSounds.RACCOON_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/raccoon/death")).subtitle("sound.morethanadventure.raccoon_death"));

        add(MtaSounds.TOUCAN_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/toucan/chirp1"),sound("morethanadventure:entity/toucan/chirp2"),sound("morethanadventure:entity/toucan/chirp3"))
                .subtitle("sound.morethanadventure.toucan_ambient"));
        add(MtaSounds.TOUCAN_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/toucan/hurt1"),sound("morethanadventure:entity/toucan/hurt2")).subtitle("sound.morethanadventure.toucan_hurt"));
        add(MtaSounds.TOUCAN_DEATH.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/toucan/death")).subtitle("sound.morethanadventure.toucan_death"));

        add(MtaSounds.TURKEY_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/turkey/idle1")
                        ,sound("morethanadventure:entity/turkey/idle2")
                        ,sound("morethanadventure:entity/turkey/idle3")
                        ,sound("morethanadventure:entity/turkey/idle4")
                        ,sound("morethanadventure:entity/turkey/idle5")
                        ,sound("morethanadventure:entity/turkey/idle6")
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
        //        .with(sound("morethanadventure:entity/corrosive_cube/idle")).subtitle("sound.morethanadventure.corrosive_cube_ambient"));
        //add(MtaSounds.CORROSIVE_CUBE_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/corrosive_cube/hurt")).subtitle("sound.morethanadventure.corrosive_cube_hurt"));
        //add(MtaSounds.CORROSIVE_CUBE_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/corrosive_cube/death")).subtitle("sound.morethanadventure.corrosive_cube_death"));

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
        //        .with(sound("morethanadventure:entity/frosted_slime/idle")).subtitle("sound.morethanadventure.frosted_slime_ambient"));
        //add(MtaSounds.FROSTED_SLIME_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/frosted_slime/hurt")).subtitle("sound.morethanadventure.frosted_slime_hurt"));
        //add(MtaSounds.FROSTED_SLIME_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/frosted_slime/death")).subtitle("sound.morethanadventure.frosted_slime_death"));

        add(MtaSounds.GLOW_SPIDER_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/glow_spider/say1"),sound("morethanadventure:entity/glow_spider/say2"),sound("morethanadventure:entity/glow_spider/say3"),sound("morethanadventure:entity/glow_spider/say4"))
                .subtitle("sound.morethanadventure.glow_spider_ambient"));

        add(MtaSounds.GLOW_SPIDER_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/glow_spider/say1"),sound("morethanadventure:entity/glow_spider/say2"),sound("morethanadventure:entity/glow_spider/say3"),sound("morethanadventure:entity/glow_spider/say4"))
                .subtitle("sound.morethanadventure.glow_spider_hurt"));

        add(MtaSounds.GLOW_SPIDER_DEATH.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/glow_spider/death"))
                .subtitle("sound.morethanadventure.glow_spider_death"));

        add(MtaSounds.HOST_HURT.get(), SoundDefinition.definition()
                .with(
                        sound("morethanadventure:entity/host/hurt1"),
                        sound("morethanadventure:entity/host/hurt2")
                ).subtitle("sound.morethanadventure.host_hurt"));
        add(MtaSounds.HOST_DEATH.get(), SoundDefinition.definition()
                .with(
                        sound("morethanadventure:entity/host/death")
                ).subtitle("sound.morethanadventure.host_death"));

        //add(MtaSounds.ICICLE_CREEPER_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/icicle_creeper/idle")).subtitle("sound.morethanadventure.icicle_creeper_ambient"));
        //add(MtaSounds.ICICLE_CREEPER_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/icicle_creeper/hurt")).subtitle("sound.morethanadventure.icicle_creeper_hurt"));
        //add(MtaSounds.ICICLE_CREEPER_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/icicle_creeper/death")).subtitle("sound.morethanadventure.icicle_creeper_death"));

        //add(MtaSounds.MOSSY_ZOMBIE_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/mossy_zombie/idle")).subtitle("sound.morethanadventure.mossy_zombie_ambient"));
        //add(MtaSounds.MOSSY_ZOMBIE_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/mossy_zombie/hurt")).subtitle("sound.morethanadventure.mossy_zombie_hurt"));
        //add(MtaSounds.MOSSY_ZOMBIE_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/mossy_zombie/death")).subtitle("sound.morethanadventure.mossy_zombie_death"));

        //add(MtaSounds.SIREN_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/siren/idle")).subtitle("sound.morethanadventure.siren_ambient"));
        //add(MtaSounds.SIREN_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/siren/hurt")).subtitle("sound.morethanadventure.siren_hurt"));
        //add(MtaSounds.SIREN_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/siren/death")).subtitle("sound.morethanadventure.siren_death"));

        //add(MtaSounds.SKELETON_FIGTHTER_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/skeleton_fighter/idle")).subtitle("sound.morethanadventure.skeleton_fighter_ambient"));
        //add(MtaSounds.SKELETON_FIGTHTER_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/skeleton_fighter/hurt")).subtitle("sound.morethanadventure.skeleton_fighter_hurt"));
        //add(MtaSounds.SKELETON_FIGTHTER_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/skeleton_fighter/death")).subtitle("sound.morethanadventure.skeleton_fighter_death"));

        //add(MtaSounds.TOXIC_ZOMBIE_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/toxic_zombie/idle")).subtitle("sound.morethanadventure.toxic_zombie_ambient"));
        //add(MtaSounds.TOXIC_ZOMBIE_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/toxic_zombie/hurt")).subtitle("sound.morethanadventure.toxic_zombie_hurt"));
        //add(MtaSounds.TOXIC_ZOMBIE_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/toxic_zombie/death")).subtitle("sound.morethanadventure.toxic_zombie_death"));

        add(MtaSounds.WITHER_SOLDIER_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/wither_soldier/idle1"),sound("morethanadventure:entity/wither_soldier/idle2"),sound("morethanadventure:entity/wither_soldier/idle3"),sound("morethanadventure:entity/wither_soldier/idle4"))
                .subtitle("sound.morethanadventure.wither_soldier_ambient"));
        add(MtaSounds.WITHER_SOLDIER_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/wither_soldier/hurt1"),sound("morethanadventure:entity/wither_soldier/hurt2"),sound("morethanadventure:entity/wither_soldier/hurt3"),sound("morethanadventure:entity/wither_soldier/hurt4"))
                .subtitle("sound.morethanadventure.wither_soldier_hurt"));
        add(MtaSounds.WITHER_SOLDIER_DEATH.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/wither_soldier/death1"),sound("morethanadventure:entity/wither_soldier/death2"))
                .subtitle("sound.morethanadventure.wither_soldier_death"));
        add(MtaSounds.WITHER_SOLDIER_STEP.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/wither_soldier/step1"),sound("morethanadventure:entity/wither_soldier/step2"),sound("morethanadventure:entity/wither_soldier/step3"),sound("morethanadventure:entity/wither_soldier/step4"))
                .subtitle("sound.morethanadventure.wither_soldier_step"));

        add(MtaSounds.YUKI_ONNA_AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/yuki_onna/idle1"),sound("morethanadventure:entity/yuki_onna/ambient_2")).subtitle("sound.morethanadventure.yuki_onna_ambient"));
        add(MtaSounds.YUKI_ONNA_HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/yuki_onna/hurt")).subtitle("sound.morethanadventure.yuki_onna_hurt"));
        add(MtaSounds.YUKI_ONNA_DEATH.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/yuki_onna/death")).subtitle("sound.morethanadventure.yuki_onna_death"));

        //add(MtaSounds.ZOMBIFIED_MINER_AMBIENT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/zombified_miner/idle")).subtitle("sound.morethanadventure.zombified_miner_ambient"));
        //add(MtaSounds.ZOMBIFIED_MINER_HURT.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/zombified_miner/hurt")).subtitle("sound.morethanadventure.zombified_miner_hurt"));
        //add(MtaSounds.ZOMBIFIED_MINER_DEATH.get(), SoundDefinition.definition()
        //        .with(sound("morethanadventure:entity/zombified_miner/death")).subtitle("sound.morethanadventure.zombified_miner_death"));

/*

        add(MtaSounds._AMBIENT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/mob/idle1"),sound("morethanadventure:entity/mob/idle2"),sound("morethanadventure:entity/mob/idle3"),sound("morethanadventure:entity/mob/idle4"))
                .subtitle("sound.morethanadventure._ambient"));
        add(MtaSounds._HURT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/mob/hurt1"),sound("morethanadventure:entity/mob/hurt2"),sound("morethanadventure:entity/mob/hurt3"),sound("morethanadventure:entity/mob/hurt4"))
                .subtitle("sound.morethanadventure._hurt"));
        add(MtaSounds._DEATH.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/mob/death1"),sound("morethanadventure:entity/mob/death2"))
                .subtitle("sound.morethanadventure._death"));
        add(MtaSounds._STEP.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:entity/mob/step1"),sound("morethanadventure:entity/mob/step2"),sound("morethanadventure:entity/armored_skeleton/step3"),sound("morethanadventure:entity/mob/step4"))
                .subtitle("sound.morethanadventure._step"));

 */
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
                .with(sound("morethanadventure:item/weaponry/whip_hit")).subtitle("sound.morethanadventure.weapons.whip.hit"));


        add(MtaSounds.WEAPON_FLAIL.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:item/weaponry/flail_hit")).subtitle("sound.morethanadventure.weapons.flail.hit"));


        add(MtaSounds.LONGBOW_SHOOT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:item/weaponry/bow/longbow")).subtitle("sound.morethanadventure.weapons.bow.longbow"));


        add(MtaSounds.SHORTBOW_SHOOT.get(), SoundDefinition.definition()
                .with(sound("morethanadventure:item/weaponry/bow/short_bow")).subtitle("sound.morethanadventure.weapons.bow.short_bow"));


        add(MtaSounds.TWINBOW_SHOOT.get(), SoundDefinition.definition()
                    .with(sound("morethanadventure:item/weaponry/bow/twinbow")).subtitle("sound.morethanadventure.weapons.bow.twinbow"));


        add(MtaSounds.WHIP_SWING.get(), SoundDefinition.definition()
                    .with(sound("morethanadventure:item/weaponry/whip_swing")).subtitle("sound.morethanadventure.weapons.whip.swing"));


        add(MtaSounds.LIGHTNING_BOLT_THUNDER_FAR.get(), SoundDefinition.definition()
                .with(
                        sound("morethanadventure:weather/misc/thunder/far1"),
                        sound("morethanadventure:weather/misc/thunder/far2"),
                        sound("morethanadventure:weather/misc/thunder/far3")
                ).subtitle("sound.morethanadventure.lightning_bolt.far"));
        add(MtaSounds.LIGHTNING_BOLT_THUNDER_VERY_FAR.get(), SoundDefinition.definition()
                .with(
                        sound("morethanadventure:weather/misc/thunder/very_far1"),
                        sound("morethanadventure:weather/misc/thunder/very_far2"),
                        sound("morethanadventure:weather/misc/thunder/very_far3"),
                        sound("morethanadventure:weather/misc/thunder/very_far4")
                ).subtitle("sound.morethanadventure.lightning_bolt.very_far"));

        add(MtaSounds.STOVE_CRACKLE.get(), SoundDefinition.definition()
                .with(
                        sound("morethanadventure:block/stove/stove1"),
                        sound("morethanadventure:block/stove/stove2"),
                        sound("morethanadventure:block/stove/stove3"),
                        sound("morethanadventure:block/stove/stove4"),
                        sound("morethanadventure:block/stove/stove5")
                ).subtitle("sound.morethanadventure.stove.crackle"));

    }

    protected static SoundDefinition.Sound entitySound(final String name) {
        return sound(ResourceLocation.fromNamespaceAndPath(MODID,"entity/name"));
    }

}
