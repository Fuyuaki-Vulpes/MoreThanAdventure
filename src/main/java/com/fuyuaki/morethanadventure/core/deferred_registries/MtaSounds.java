package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.core.mod.MTAMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MtaSounds {
    public static DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, MTAMod.MODID);


    //Animals
    public static final Supplier<SoundEvent> CAPYBARA_AMBIENT = registerSoundEvent("capybara_ambient");
    public static final Supplier<SoundEvent> CAPYBARA_HURT = registerSoundEvent("capybara_hurt");
    public static final Supplier<SoundEvent> CAPYBARA_DEATH = registerSoundEvent("capybara_death");
    public static final Supplier<SoundEvent> DEER_AMBIENT = registerSoundEvent("deer_ambient");
    public static final Supplier<SoundEvent> DEER_HURT = registerSoundEvent("deer_hurt");
    public static final Supplier<SoundEvent> DEER_DEATH = registerSoundEvent("deer_death");
    public static final Supplier<SoundEvent> DUCK_AMBIENT = registerSoundEvent("duck_ambient");
    public static final Supplier<SoundEvent> DUCK_HURT = registerSoundEvent("duck_hurt");
    public static final Supplier<SoundEvent> DUCK_DEATH = registerSoundEvent("duck_death");
    public static final Supplier<SoundEvent> FERRET_AMBIENT = registerSoundEvent("ferret_ambient");
    public static final Supplier<SoundEvent> FERRET_HURT = registerSoundEvent("ferret_hurt");
    public static final Supplier<SoundEvent> FERRET_DEATH = registerSoundEvent("ferret_death");
    public static final Supplier<SoundEvent> OWL_AMBIENT = registerSoundEvent("owl_ambient");
    public static final Supplier<SoundEvent> OWL_HURT = registerSoundEvent("owl_hurt");
    public static final Supplier<SoundEvent> OWL_DEATH = registerSoundEvent("owl_death");
    public static final Supplier<SoundEvent> RACCOON_AMBIENT = registerSoundEvent("raccoon_ambient");
    public static final Supplier<SoundEvent> RACCOON_HURT = registerSoundEvent("raccoon_hurt");
    public static final Supplier<SoundEvent> RACCOON_DEATH = registerSoundEvent("raccoon_death");
    public static final Supplier<SoundEvent> TOUCAN_AMBIENT = registerSoundEvent("toucan_ambient");
    public static final Supplier<SoundEvent> TOUCAN_HURT = registerSoundEvent("toucan_hurt");
    public static final Supplier<SoundEvent> TOUCAN_DEATH = registerSoundEvent("toucan_death");
    public static final Supplier<SoundEvent> TURKEY_AMBIENT = registerSoundEvent("turkey_ambient");
    public static final Supplier<SoundEvent> TURKEY_HURT = registerSoundEvent("turkey_hurt");
    public static final Supplier<SoundEvent> TURKEY_DEATH = registerSoundEvent("turkey_death");
    public static final Supplier<SoundEvent> WISPFLY_AMBIENT = registerSoundEvent("wisp_ambient");
    public static final Supplier<SoundEvent> WISPFLY_HURT = registerSoundEvent("wisp_hurt");
    public static final Supplier<SoundEvent> WISPFLY_DEATH = registerSoundEvent("wisp_death");

    //Monsters

    public static final Supplier<SoundEvent> ARMORED_SKELETON_AMBIENT = registerSoundEvent("armored_skeleton_ambient");
    public static final Supplier<SoundEvent> ARMORED_SKELETON_HURT = registerSoundEvent("armored_skeleton_hurt");
    public static final Supplier<SoundEvent> ARMORED_SKELETON_DEATH = registerSoundEvent("armored_skeleton_death");
    public static final Supplier<SoundEvent> ARMORED_SKELETON_STEP = registerSoundEvent("armored_skeleton_step");
    public static final Supplier<SoundEvent> CHARRED_SKELETON_AMBIENT = registerSoundEvent("charred_skeleton_ambient");
    public static final Supplier<SoundEvent> CHARRED_SKELETON_HURT = registerSoundEvent("charred_skeleton_hurt");
    public static final Supplier<SoundEvent> CHARRED_SKELETON_DEATH = registerSoundEvent("charred_skeleton_death");
    public static final Supplier<SoundEvent> CHARRED_SKELETON_STEP = registerSoundEvent("charred_skeleton_step");
    public static final Supplier<SoundEvent> CORROSIVE_CUBE_AMBIENT = registerSoundEvent("corrosive_cube_ambient");
    public static final Supplier<SoundEvent> CORROSIVE_CUBE_HURT = registerSoundEvent("corrosive_cube_hurt");
    public static final Supplier<SoundEvent> CORROSIVE_CUBE_DEATH = registerSoundEvent("corrosive_cube_death");
    public static final Supplier<SoundEvent> FALLEN_SAMURAI_AMBIENT = registerSoundEvent("fallen_samurai_ambient");
    public static final Supplier<SoundEvent> FALLEN_SAMURAI_HURT = registerSoundEvent("fallen_samurai_hurt");
    public static final Supplier<SoundEvent> FALLEN_SAMURAI_DEATH = registerSoundEvent("fallen_samurai_death");
    public static final Supplier<SoundEvent> FROSTED_SLIME_AMBIENT = registerSoundEvent("frosted_slime_ambient");
    public static final Supplier<SoundEvent> FROSTED_SLIME_HURT = registerSoundEvent("frosted_slime_hurt");
    public static final Supplier<SoundEvent> FROSTED_SLIME_DEATH = registerSoundEvent("frosted_slime_death");
    public static final Supplier<SoundEvent> GLOW_SPIDER_AMBIENT = registerSoundEvent("glow_spider_ambient");
    public static final Supplier<SoundEvent> GLOW_SPIDER_HURT = registerSoundEvent("glow_spider_hurt");
    public static final Supplier<SoundEvent> GLOW_SPIDER_DEATH = registerSoundEvent("glow_spider_death");
    public static final Supplier<SoundEvent> HOST_AMBIENT = registerSoundEvent("host_ambient");
    public static final Supplier<SoundEvent> HOST_HURT = registerSoundEvent("host_hurt");
    public static final Supplier<SoundEvent> HOST_DEATH = registerSoundEvent("host_death");
    public static final Supplier<SoundEvent> ICICLE_CREEPER_AMBIENT = registerSoundEvent("icicle_creeper_ambient");
    public static final Supplier<SoundEvent> ICICLE_CREEPER_HURT = registerSoundEvent("icicle_creeper_hurt");
    public static final Supplier<SoundEvent> ICICLE_CREEPER_DEATH = registerSoundEvent("icicle_creeper_death");
    public static final Supplier<SoundEvent> MOSSY_ZOMBIE_AMBIENT = registerSoundEvent("mossy_zombie_ambient");
    public static final Supplier<SoundEvent> MOSSY_ZOMBIE_HURT = registerSoundEvent("mossy_zombie_hurt");
    public static final Supplier<SoundEvent> MOSSY_ZOMBIE_DEATH = registerSoundEvent("mossy_zombie_death");
    public static final Supplier<SoundEvent> SIREN_AMBIENT = registerSoundEvent("siren_ambient");
    public static final Supplier<SoundEvent> SIREN_HURT = registerSoundEvent("siren_hurt");
    public static final Supplier<SoundEvent> SIREN_DEATH = registerSoundEvent("siren_death");
    public static final Supplier<SoundEvent> SKELETON_FIGTHTER_AMBIENT = registerSoundEvent("skeleton_fighter_ambient");
    public static final Supplier<SoundEvent> SKELETON_FIGTHTER_HURT = registerSoundEvent("skeleton_fighter_hurt");
    public static final Supplier<SoundEvent> SKELETON_FIGTHTER_DEATH = registerSoundEvent("skeleton_fighter_death");
    public static final Supplier<SoundEvent> TOXIC_ZOMBIE_AMBIENT = registerSoundEvent("toxic_zombie_ambient");
    public static final Supplier<SoundEvent> TOXIC_ZOMBIE_HURT = registerSoundEvent("toxic_zombie_hurt");
    public static final Supplier<SoundEvent> TOXIC_ZOMBIE_DEATH = registerSoundEvent("toxic_zombie_death");
    public static final Supplier<SoundEvent> YUKI_ONNA_AMBIENT = registerSoundEvent("yuki_onna_ambient");
    public static final Supplier<SoundEvent> YUKI_ONNA_HURT = registerSoundEvent("yuki_onna_hurt");
    public static final Supplier<SoundEvent> YUKI_ONNA_DEATH = registerSoundEvent("yuki_onna_death");

    public static final Supplier<SoundEvent> WITHER_SOLDIER_AMBIENT = registerSoundEvent("wither_soldier_ambient");
    public static final Supplier<SoundEvent> WITHER_SOLDIER_HURT = registerSoundEvent("wither_soldier_hurt");
    public static final Supplier<SoundEvent> WITHER_SOLDIER_DEATH = registerSoundEvent("wither_soldier_death");
    public static final Supplier<SoundEvent> WITHER_SOLDIER_STEP = registerSoundEvent("wither_soldier_step");

    public static final Supplier<SoundEvent> ZOMBIFIED_MINER_AMBIENT = registerSoundEvent("zombified_miner_ambient");
    public static final Supplier<SoundEvent> ZOMBIFIED_MINER_HURT = registerSoundEvent("zombified_miner_hurt");
    public static final Supplier<SoundEvent> ZOMBIFIED_MINER_DEATH = registerSoundEvent("zombified_miner_death");



    //WEAPONRY
    public static final Supplier<SoundEvent> WEAPON_DEEP_SWING = registerSoundEvent("weapon_deep_swing");
    public static final Supplier<SoundEvent> WEAPON_SWING = registerSoundEvent("weapon_swing");
    public static final Supplier<SoundEvent> WEAPON_PUNCH = registerSoundEvent("weapon_punch");
    public static final Supplier<SoundEvent> WEAPON_SCRAPE = registerSoundEvent("weapon_scrape");
    public static final Supplier<SoundEvent> WEAPON_STAB_SHARP = registerSoundEvent("weapon_stab_sharp");
    public static final Supplier<SoundEvent> WEAPON_TEAR = registerSoundEvent("weapon_tear");
    public static final Supplier<SoundEvent> WEAPON_THROW = registerSoundEvent("weapon_throw");
    public static final Supplier<SoundEvent> WEAPON_WHIP = registerSoundEvent("weapon_whip");
    public static final Supplier<SoundEvent> WEAPON_FLAIL = registerSoundEvent("weapon_flail");

    public static final Supplier<SoundEvent> LONGBOW_SHOOT = registerSoundEvent("longbow");
    public static final Supplier<SoundEvent> SHORTBOW_SHOOT = registerSoundEvent("short_bow");
    public static final Supplier<SoundEvent> TWINBOW_SHOOT = registerSoundEvent("twinbow");

    public static final Supplier<SoundEvent> FLAIL_SWING = registerSoundEvent("flail_swing");
    public static final Supplier<SoundEvent> WHIP_SWING = registerSoundEvent("whip_swing");


    public static final Supplier<SoundEvent> LIGHTNING_BOLT_THUNDER_FAR = registerSoundEvent("thunder_far");
    public static final Supplier<SoundEvent> LIGHTNING_BOLT_THUNDER_VERY_FAR = registerSoundEvent("thunder_very_far");


    public static final Supplier<SoundEvent> STOVE_CRACKLE = registerSoundEvent("stove_crackle");


    private static Supplier<SoundEvent> registerSoundEvent (String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
