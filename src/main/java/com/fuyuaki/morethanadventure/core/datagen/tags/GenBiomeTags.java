package com.fuyuaki.morethanadventure.core.datagen.tags;

import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class GenBiomeTags  extends IntrinsicHolderTagsProvider<Biome> {

    public GenBiomeTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider) {
        super(output, Registries.BIOME, provider, biome -> ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(MODID,biome.toString())),MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {


        this.tag(MtaTags.Biomes.GRASSY_DIRT_SHOULD_GENERATE)
                .addTag(Tags.Biomes.IS_DENSE_VEGETATION)
                .addTag(Tags.Biomes.IS_FOREST)
                ;


        this.tag(MtaTags.Biomes.HAS_CATTAIL)
                .addTag(Tags.Biomes.IS_SWAMP)
                .remove(Biomes.MANGROVE_SWAMP)
                ;

        this.tag(MtaTags.Biomes.HAS_IPE_TREE)
                .add(
                        Biomes.JUNGLE,
                        Biomes.SPARSE_JUNGLE)
                ;
        this.tag(MtaTags.Biomes.HAS_AVOCADO_TREE)
                .add(
                        Biomes.SPARSE_JUNGLE,
                        Biomes.PLAINS,
                        Biomes.SUNFLOWER_PLAINS)
                .addTag(Tags.Biomes.IS_PLAINS).remove(Tags.Biomes.IS_SNOWY).remove(Tags.Biomes.IS_DRY)
        ;

        this.tag(MtaTags.Biomes.HAS_MANGO_TREE)
                .add(
                        Biomes.SPARSE_JUNGLE,
                        Biomes.PLAINS,
                        Biomes.SUNFLOWER_PLAINS)
                .addTag(Tags.Biomes.IS_PLAINS).remove(Tags.Biomes.IS_SNOWY).remove(Tags.Biomes.IS_DRY)
                ;

        this.tag(Tags.Biomes.IS_LUSH)
                .add(MtaBiomes.LUSH_RIVER)
                .add(MtaBiomes.LUSH_MEADOW)
                ;

        this.tag(Tags.Biomes.IS_OCEAN)
                .add(MtaBiomes.UNDERWATER_FOREST)
                ;

        this.tag(Tags.Biomes.IS_RIVER).add(MtaBiomes.LUSH_RIVER,MtaBiomes.GRAVELLY_RIVER);

        this.tag(Tags.Biomes.IS_SPARSE_VEGETATION_OVERWORLD)
                .add(MtaBiomes.SPARSE_TAIGA,
                        MtaBiomes.SPARSE_CHERRY_GROVE, MtaBiomes.TUNDRA,MtaBiomes.CAATINGA);

        this.tag(Tags.Biomes.IS_DENSE_VEGETATION_OVERWORLD)
                .add(MtaBiomes.CERRADO,MtaBiomes.DENSE_SAVANNA);



        this.tag(BiomeTags.HAS_VILLAGE_SAVANNA).add(MtaBiomes.CERRADO,MtaBiomes.DENSE_SAVANNA);
        this.tag(BiomeTags.HAS_VILLAGE_PLAINS).add(MtaBiomes.MAPLE_FOREST);
        this.tag(BiomeTags.HAS_VILLAGE_DESERT).add(MtaBiomes.OASIS,MtaBiomes.CAATINGA);
        this.tag(BiomeTags.HAS_VILLAGE_SNOWY).add(MtaBiomes.TUNDRA, MtaBiomes.ALPINE_TUNDRA);

        this.tag(Tags.Biomes.IS_DESERT).add(MtaBiomes.OASIS, MtaBiomes.POLAR_DESERT,MtaBiomes.CAATINGA);
        this.tag(Tags.Biomes.IS_SNOWY).add(MtaBiomes.TUNDRA, MtaBiomes.ALPINE_TUNDRA, MtaBiomes.POLAR_DESERT);
        this.tag(Tags.Biomes.IS_FOREST).add(MtaBiomes.MAPLE_FOREST,MtaBiomes.DENSE_SAVANNA);
        this.tag(Tags.Biomes.IS_TAIGA).add(MtaBiomes.SPARSE_TAIGA);
        this.tag(Tags.Biomes.IS_COLD_OVERWORLD).add(MtaBiomes.TUNDRA, MtaBiomes.ALPINE_TUNDRA, MtaBiomes.POLAR_DESERT);

        this.tag(Tags.Biomes.IS_SNOWY_PLAINS).add(MtaBiomes.TUNDRA, MtaBiomes.POLAR_DESERT);

        this.tag(Tags.Biomes.IS_MOUNTAIN_SLOPE).add(MtaBiomes.ALPINE_TUNDRA);
        this.tag(BiomeTags.SPAWNS_SNOW_FOXES).add(MtaBiomes.TUNDRA, MtaBiomes.ALPINE_TUNDRA, MtaBiomes.POLAR_DESERT);
        this.tag(BiomeTags.SPAWNS_COLD_VARIANT_FROGS).add(MtaBiomes.TUNDRA, MtaBiomes.ALPINE_TUNDRA, MtaBiomes.POLAR_DESERT);
        this.tag(BiomeTags.SPAWNS_WARM_VARIANT_FROGS).add(MtaBiomes.CERRADO,MtaBiomes.DENSE_SAVANNA);
        this.tag(BiomeTags.HAS_SWAMP_HUT).add(MtaBiomes.BOG);
        this.tag(Tags.Biomes.IS_DRY_OVERWORLD).add(MtaBiomes.BOG, MtaBiomes.POLAR_DESERT,MtaBiomes.CAATINGA);

        this.tag(BiomeTags.IS_SAVANNA).add(MtaBiomes.CERRADO,MtaBiomes.DENSE_SAVANNA);
        this.tag(BiomeTags.HAS_MINESHAFT).add(MtaBiomes.CERRADO,MtaBiomes.OASIS,MtaBiomes.ALPINE_TUNDRA,MtaBiomes.MAPLE_FOREST,MtaBiomes.DENSE_SAVANNA);
        this.tag(BiomeTags.HAS_PILLAGER_OUTPOST).add(MtaBiomes.CERRADO,MtaBiomes.TUNDRA,MtaBiomes.DENSE_SAVANNA);


        this.tag(Tags.Biomes.IS_DEAD).add(MtaBiomes.BOG,MtaBiomes.POLAR_DESERT);






        this.tag(MtaTags.Biomes.OVERWORLD_GEYSERS)
                .add(   Biomes.STONY_PEAKS
                )
                .addTag(Tags.Biomes.IS_STONY_SHORES)
                .addTag(Tags.Biomes.IS_WINDSWEPT)
                .addTag(BiomeTags.IS_BADLANDS);

        this.tag(MtaTags.Biomes.NETHER_GEYSERS)
                .add(   Biomes.NETHER_WASTES,
                        Biomes.BASALT_DELTAS

                );

        this.tag(MtaTags.Biomes.HAS_BEARDED_DRAGON)
                .addTag(Tags.Biomes.IS_SAVANNA)
                .addTag(Tags.Biomes.IS_DESERT);
        this.tag(MtaTags.Biomes.HAS_BUTTERFLY)
                .addTag(Tags.Biomes.IS_PLAINS)
                .addTag(BiomeTags.IS_FOREST)
                .add(MtaBiomes.MAPLE_FOREST);


        this.tag(MtaTags.Biomes.HAS_CAPYBARA)
                .add(MtaBiomes.LUSH_RIVER)
                .addTag(Tags.Biomes.IS_SWAMP)
                .addTag(Tags.Biomes.IS_RIVER);
        this.tag(MtaTags.Biomes.HAS_DUCK)
                .addTag(Tags.Biomes.IS_RIVER);
        this.tag(MtaTags.Biomes.HAS_FERRET)
                .addTag(Tags.Biomes.IS_PLAINS);
        this.tag(MtaTags.Biomes.HAS_GREAT_WHITE_SHARK)
                .addTag(Tags.Biomes.IS_OCEAN);
        this.tag(MtaTags.Biomes.HAS_HORSESHOE_CRAB)
                .addTag(Tags.Biomes.IS_BEACH)
                .addTag(Tags.Biomes.IS_STONY_SHORES);
        this.tag(MtaTags.Biomes.HAS_JELLYFISH)
                .add(Biomes.OCEAN)
                .add(Biomes.COLD_OCEAN)
                .add(Biomes.LUKEWARM_OCEAN)
                .add(Biomes.DEEP_OCEAN)
                .add(Biomes.DEEP_COLD_OCEAN)
                .add(Biomes.DEEP_LUKEWARM_OCEAN);

        this.tag(MtaTags.Biomes.HAS_OCTOPUS)
                .add(Biomes.OCEAN)
                .add(Biomes.LUKEWARM_OCEAN);

        this.tag(MtaTags.Biomes.HAS_OWL)
                .addTag(Tags.Biomes.IS_FOREST)
                .add(MtaBiomes.CERRADO);

        this.tag(MtaTags.Biomes.HAS_DEER)
                .addTag(Tags.Biomes.IS_FOREST)
                .add(MtaBiomes.ALPINE_TUNDRA,MtaBiomes.CERRADO);

        this.tag(MtaTags.Biomes.HAS_TURKEY)
                .addTag(Tags.Biomes.IS_FOREST)
                .addTag(Tags.Biomes.IS_PLAINS)
                .remove(Tags.Biomes.IS_DRY);

        this.tag(MtaTags.Biomes.HAS_PENGUIN)
                .add(Biomes.FROZEN_OCEAN)
                .add(Biomes.ICE_SPIKES)
                .add(Biomes.SNOWY_PLAINS)
                .add(Biomes.SNOWY_BEACH)
                .add(Biomes.SNOWY_SLOPES);
        this.tag(MtaTags.Biomes.HAS_RACCOON)
                .addTag(Tags.Biomes.IS_FOREST);
        this.tag(MtaTags.Biomes.HAS_SHRIMP)
                .add(Biomes.OCEAN)
                .add(Biomes.COLD_OCEAN)
                .add(Biomes.LUKEWARM_OCEAN);
        this.tag(MtaTags.Biomes.HAS_TOUCAN)
                .addTag(Tags.Biomes.IS_JUNGLE);

        this.tag(MtaTags.Biomes.HAS_WISP_RARE)
                .add(Biomes.DARK_FOREST, Biomes.TAIGA);

        this.tag(MtaTags.Biomes.HAS_WISP)
                .add(Biomes.MUSHROOM_FIELDS);

        this.tag(MtaTags.Biomes.HAS_PALE_WOLF)
                .add(MtaBiomes.SPARSE_TAIGA);

        this.tag(MtaTags.Biomes.HAS_SPOTTED_WOLF)
                .add(MtaBiomes.OASIS);

        this.tag(MtaTags.Biomes.HAS_RUSTY_WOLF)
                .add(MtaBiomes.CERRADO);

        this.tag(MtaTags.Biomes.HAS_SNOWY_WOLF)
                .add(MtaBiomes.TUNDRA, MtaBiomes.ALPINE_TUNDRA);


        this.tag(MtaTags.Biomes.HAS_BLACK_WIDOW)
                .addTag(Tags.Biomes.IS_JUNGLE)
                .addTag(Tags.Biomes.IS_SWAMP)
        ;

        this.tag(MtaTags.Biomes.HAS_YUKI_ONNA)
                .addTag(Tags.Biomes.IS_COLD_OVERWORLD)
        ;

        this.tag(MtaTags.Biomes.HAS_CHARRED_SKELETON)
                .addTag(Tags.Biomes.IS_HOT_OVERWORLD)
                .remove(Tags.Biomes.IS_WET)
        ;

        this.tag(MtaTags.Biomes.HAS_GLOW_SPIDER)
                .addTag(Tags.Biomes.IS_LUSH)
                .addTag(Tags.Biomes.IS_DENSE_VEGETATION_OVERWORLD)
        ;

        this.tag(MtaTags.Biomes.HAS_HOST)
                .addTag(Tags.Biomes.IS_SPOOKY)
                .add(Biomes.DESERT, Biomes.STONY_PEAKS, Biomes.STONY_SHORE, MtaBiomes.BOG)
        ;
        this.tag(MtaTags.Biomes.HAS_SIREN)
                .add(MtaBiomes.UNDERWATER_FOREST)
        ;



        this.tag(MtaTags.Biomes.AGATE)
                .addTag(Tags.Biomes.IS_HOT_OVERWORLD)
                .addTag(Tags.Biomes.IS_DRY_OVERWORLD)
        ;

        this.tag(MtaTags.Biomes.ALEXANDRITE)
                .addTag(Tags.Biomes.IS_PLAINS)
                .addTag(Tags.Biomes.IS_FOREST)
                .addTag(Tags.Biomes.IS_FLORAL)

        ;

        this.tag(MtaTags.Biomes.AQUAMARINE)
                .addTag(Tags.Biomes.IS_WET_OVERWORLD)
                .addTag(Tags.Biomes.IS_OCEAN)
                .addTag(Tags.Biomes.IS_RIVER)
                .addTag(Tags.Biomes.IS_AQUATIC)
        ;

        this.tag(MtaTags.Biomes.BLOODSTONE)
                .addTag(Tags.Biomes.IS_SPOOKY)
                .addTag(Tags.Biomes.IS_DENSE_VEGETATION_OVERWORLD)
                .addTag(Tags.Biomes.IS_MAGICAL)
                .addTag(Tags.Biomes.IS_TAIGA)
        ;

        this.tag(MtaTags.Biomes.CELESTITE)
                .addTag(BiomeTags.IS_OVERWORLD)
        ;

        this.tag(MtaTags.Biomes.CRYOLITE)
                .addTag(Tags.Biomes.IS_SNOWY)
                .addTag(Tags.Biomes.IS_ICY)

        ;

        this.tag(MtaTags.Biomes.GARNET)
                .addTag(BiomeTags.IS_OVERWORLD)
        ;

        this.tag(MtaTags.Biomes.MOONSTONE)
                .addTag(Tags.Biomes.IS_MOUNTAIN)
                .addTag(Tags.Biomes.IS_SWAMP)
        ;



        this.tag(MtaTags.Biomes.MOONSTONE)
                .addTag(Tags.Biomes.IS_MOUNTAIN)
                .addTag(Tags.Biomes.IS_SWAMP)
        ;



        this.tag(MtaTags.Biomes.WISESTONE)
                .addTag(Tags.Biomes.IS_SNOWY)
                .addTag(Tags.Biomes.IS_DARK_FOREST)
                .add(Biomes.LUKEWARM_OCEAN,MtaBiomes.BOG,MtaBiomes.CRYSTALLINE_GROTTO)
        ;


        addWolfTags();
    }

    public void addWolfTags() {
  /*      //ashen
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("forge", "has_wolf_variant/ashen")))
                .addTag(MtaTags.Biomes.HAS_ASHEN_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("c", "has_wolf_variant/ashen")))
                .addTag(MtaTags.Biomes.HAS_ASHEN_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("minecraft", "has_wolf_variant/ashen")))
                .addTag(MtaTags.Biomes.HAS_ASHEN_WOLF)
        ;

        //black
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("forge", "has_wolf_variant/black")))
                .addTag(MtaTags.Biomes.HAS_BLACK_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("c", "has_wolf_variant/black")))
                .addTag(MtaTags.Biomes.HAS_BLACK_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("minecraft", "has_wolf_variant/black")))
                .addTag(MtaTags.Biomes.HAS_BLACK_WOLF)
        ;

        //chestnut
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("forge", "has_wolf_variant/chestnut")))
                .addTag(MtaTags.Biomes.HAS_CHESTNUT_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("c", "has_wolf_variant/chestnut")))
                .addTag(MtaTags.Biomes.HAS_CHESTNUT_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("minecraft", "has_wolf_variant/chestnut")))
                .addTag(MtaTags.Biomes.HAS_CHESTNUT_WOLF)
        ;
*/
        //pale
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("forge", "has_wolf_variant/pale")))
                .addTag(MtaTags.Biomes.HAS_PALE_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("c", "has_wolf_variant/pale")))
                .addTag(MtaTags.Biomes.HAS_PALE_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("minecraft", "has_wolf_variant/pale")))
                .addTag(MtaTags.Biomes.HAS_PALE_WOLF)
        ;

        //rusty
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("forge", "has_wolf_variant/rusty")))
                .addTag(MtaTags.Biomes.HAS_RUSTY_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("c", "has_wolf_variant/rusty")))
                .addTag(MtaTags.Biomes.HAS_RUSTY_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("minecraft", "has_wolf_variant/rusty")))
                .addTag(MtaTags.Biomes.HAS_RUSTY_WOLF)
        ;


        //snowy
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("forge", "has_wolf_variant/snowy")))
                .addTag(MtaTags.Biomes.HAS_SNOWY_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("c", "has_wolf_variant/snowy")))
                .addTag(MtaTags.Biomes.HAS_SNOWY_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("minecraft", "has_wolf_variant/snowy")))
                .addTag(MtaTags.Biomes.HAS_SNOWY_WOLF)
        ;

        //spotted
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("forge", "has_wolf_variant/spotted")))
                .addTag(MtaTags.Biomes.HAS_SPOTTED_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("c", "has_wolf_variant/spotted")))
                .addTag(MtaTags.Biomes.HAS_SPOTTED_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("minecraft", "has_wolf_variant/spotted")))
                .addTag(MtaTags.Biomes.HAS_SPOTTED_WOLF)
        ;

        /*
        //striped
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("forge", "has_wolf_variant/striped")))
                .addTag(MtaTags.Biomes.HAS_STRIPED_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("c", "has_wolf_variant/striped")))
                .addTag(MtaTags.Biomes.HAS_STRIPED_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("minecraft", "has_wolf_variant/striped")))
                .addTag(MtaTags.Biomes.HAS_STRIPED_WOLF)
        ;

        //woods
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("forge", "has_wolf_variant/woods")))
                .addTag(MtaTags.Biomes.HAS_WOODS_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("c", "has_wolf_variant/woods")))
                .addTag(MtaTags.Biomes.HAS_WOODS_WOLF)
        ;
        this.tag(TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("minecraft", "has_wolf_variant/woods")))
                .addTag(MtaTags.Biomes.HAS_WOODS_WOLF)
        ;
        */
    }
}
