package com.fuyuaki.morethanadventure.core.datagen;

import com.fuyuaki.morethanadventure.core.datagen.lang.EN_US_LangProvider;
import com.fuyuaki.morethanadventure.core.datagen.loot.GlobalLootModifiers;
import com.fuyuaki.morethanadventure.core.datagen.other.GenAdvancements;
import com.fuyuaki.morethanadventure.core.datagen.other.GenSoundDefinition;
import com.fuyuaki.morethanadventure.core.datagen.other.GenWorld;
import com.fuyuaki.morethanadventure.core.datagen.tags.GenBiomeTags;
import com.fuyuaki.morethanadventure.core.datagen.tags.GenBlockTags;
import com.fuyuaki.morethanadventure.core.datagen.tags.GenEntityTags;
import com.fuyuaki.morethanadventure.core.datagen.tags.GenItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        var datapackRegistries = new DatapackBuiltinEntriesProvider(packOutput, event.getLookupProvider(), GenWorld.BUILDER, Set.of(MODID));


        generator.addProvider(true,new GenAdvancements(packOutput,datapackRegistries.getRegistryProvider(),
                        List.of()
                )
        );


        //generator.addProvider(true, new GenRecipes(lookupProvider,packOutput));
        //generator.addProvider(true, GenLoot.create(packOutput,lookupProvider));

        event.createBlockAndItemTags(GenBlockTags::new,GenItemTags::new);

        generator.addProvider(true,
                new GenBiomeTags(packOutput, datapackRegistries.getRegistryProvider(), event.getExistingFileHelper()));

        generator.addProvider(true,
                new GenEntityTags(packOutput, datapackRegistries.getRegistryProvider()));


        generator.addProvider(true,
                new GenWorld(packOutput, lookupProvider));

        generator.addProvider(true,
                new EN_US_LangProvider(packOutput));

        generator.addProvider(true,
                new GenSoundDefinition(packOutput,event.getExistingFileHelper()));

        generator.addProvider(true,
                new GlobalLootModifiers(packOutput,datapackRegistries.getRegistryProvider()));


    }

}
