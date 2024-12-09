package com.fuyuaki.morethanadventure.core.registry;

import com.fuyuaki.morethanadventure.core.MTAMod;
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

    public static final Supplier<SoundEvent> BEARDED_DRAGON_AMBIENT = registerSoundEvent("bearded_dragon_ambient");
    public static final Supplier<SoundEvent> BEARDED_DRAGON_HURT = registerSoundEvent("bearded_dragon_hurt");
    public static final Supplier<SoundEvent> BEARDED_DRAGON_DEATH = registerSoundEvent("bearded_dragon_death");
    public static final Supplier<SoundEvent> BUTTERFLY_AMBIENT = registerSoundEvent("butterfly_ambient");
    public static final Supplier<SoundEvent> BUTTERFLY_HURT = registerSoundEvent("butterfly_hurt");
    public static final Supplier<SoundEvent> BUTTERFLY_DEATH = registerSoundEvent("butterfly_death");
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
    public static final Supplier<SoundEvent> GREAT_WHITE_SHARK_AMBIENT = registerSoundEvent("great_white_shark_ambient");
    public static final Supplier<SoundEvent> GREAT_WHITE_SHARK_HURT = registerSoundEvent("great_white_shark_hurt");
    public static final Supplier<SoundEvent> GREAT_WHITE_SHARK_DEATH = registerSoundEvent("great_white_shark_death");
    public static final Supplier<SoundEvent> HORSESHOE_CRAB_AMBIENT = registerSoundEvent("horseshoe_crab_ambient");
    public static final Supplier<SoundEvent> HORSESHOE_CRAB_HURT = registerSoundEvent("horseshoe_crab_hurt");
    public static final Supplier<SoundEvent> HORSESHOE_CRAB_DEATH = registerSoundEvent("horseshoe_crab_death");
    public static final Supplier<SoundEvent> JELLYFISH_AMBIENT = registerSoundEvent("jellyfish_ambient");
    public static final Supplier<SoundEvent> JELLYFISH_HURT = registerSoundEvent("jellyfish_hurt");
    public static final Supplier<SoundEvent> JELLYFISH_DEATH = registerSoundEvent("jellyfish_death");
    public static final Supplier<SoundEvent> OCTOPUS_AMBIENT = registerSoundEvent("octopus_ambient");
    public static final Supplier<SoundEvent> OCTOPUS_HURT = registerSoundEvent("octopus_hurt");
    public static final Supplier<SoundEvent> OCTOPUS_DEATH = registerSoundEvent("octopus_death");
    public static final Supplier<SoundEvent> OWL_AMBIENT = registerSoundEvent("owl_ambient");
    public static final Supplier<SoundEvent> OWL_HURT = registerSoundEvent("owl_hurt");
    public static final Supplier<SoundEvent> OWL_DEATH = registerSoundEvent("owl_death");
    public static final Supplier<SoundEvent> PENGUIN_AMBIENT = registerSoundEvent("penguin_ambient");
    public static final Supplier<SoundEvent> PENGUIN_HURT = registerSoundEvent("penguin_hurt");
    public static final Supplier<SoundEvent> PENGUIN_DEATH = registerSoundEvent("penguin_death");
    public static final Supplier<SoundEvent> RACCOON_AMBIENT = registerSoundEvent("raccoon_ambient");
    public static final Supplier<SoundEvent> RACCOON_HURT = registerSoundEvent("raccoon_hurt");
    public static final Supplier<SoundEvent> RACCOON_DEATH = registerSoundEvent("raccoon_death");
    public static final Supplier<SoundEvent> SHRIMP_AMBIENT = registerSoundEvent("shrimp_ambient");
    public static final Supplier<SoundEvent> SHRIMP_HURT = registerSoundEvent("shrimp_hurt");
    public static final Supplier<SoundEvent> SHRIMP_DEATH = registerSoundEvent("shrimp_death");
    public static final Supplier<SoundEvent> TOUCAN_AMBIENT = registerSoundEvent("toucan_ambient");
    public static final Supplier<SoundEvent> TOUCAN_HURT = registerSoundEvent("toucan_hurt");
    public static final Supplier<SoundEvent> TOUCAN_DEATH = registerSoundEvent("toucan_death");
    public static final Supplier<SoundEvent> TURKEY_AMBIENT = registerSoundEvent("turkey_ambient");
    public static final Supplier<SoundEvent> TURKEY_HURT = registerSoundEvent("turkey_hurt");
    public static final Supplier<SoundEvent> TURKEY_DEATH = registerSoundEvent("turkey_death");
    public static final Supplier<SoundEvent> WISPFLY_AMBIENT = registerSoundEvent("wispfly_ambient");
    public static final Supplier<SoundEvent> WISPFLY_HURT = registerSoundEvent("wispfly_hurt");
    public static final Supplier<SoundEvent> WISPFLY_DEATH = registerSoundEvent("wispfly_death");

    //Monsters

    public static final Supplier<SoundEvent> ARMORED_SKELETON_AMBIENT = registerSoundEvent("armored_skeleton_ambient");
    public static final Supplier<SoundEvent> ARMORED_SKELETON_HURT = registerSoundEvent("armored_skeleton_hurt");
    public static final Supplier<SoundEvent> ARMORED_SKELETON_DEATH = registerSoundEvent("armored_skeleton_death");
    public static final Supplier<SoundEvent> BLACK_WIDOW_AMBIENT = registerSoundEvent("black_widow_ambient");
    public static final Supplier<SoundEvent> BLACK_WIDOW_HURT = registerSoundEvent("black_widow_hurt");
    public static final Supplier<SoundEvent> BLACK_WIDOW_DEATH = registerSoundEvent("black_widow_death");
    public static final Supplier<SoundEvent> CHARRED_SKELETON_AMBIENT = registerSoundEvent("charred_skeleton_ambient");
    public static final Supplier<SoundEvent> CHARRED_SKELETON_HURT = registerSoundEvent("charred_skeleton_hurt");
    public static final Supplier<SoundEvent> CHARRED_SKELETON_DEATH = registerSoundEvent("charred_skeleton_death");
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
    public static final Supplier<SoundEvent> ZOMBIFIED_MINER_AMBIENT = registerSoundEvent("zombified_miner_ambient");
    public static final Supplier<SoundEvent> ZOMBIFIED_MINER_HURT = registerSoundEvent("zombified_miner_hurt");
    public static final Supplier<SoundEvent> ZOMBIFIED_MINER_DEATH = registerSoundEvent("zombified_miner_death");


    private static Supplier<SoundEvent> registerSoundEvent (String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
