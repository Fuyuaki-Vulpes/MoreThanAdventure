package com.fuyuaki.morethanadventure.datagen;

import com.fuyuaki.morethanadventure.datagen.other.*;
import com.fuyuaki.morethanadventure.datagen.lang.EN_US_LangProvider;
import com.fuyuaki.morethanadventure.datagen.loot.GlobalLootModifiers;
import com.fuyuaki.morethanadventure.datagen.model.GenBlockModels;
import com.fuyuaki.morethanadventure.datagen.model.GenItemModels;
import com.fuyuaki.morethanadventure.datagen.tags.GenBiomeTags;
import com.fuyuaki.morethanadventure.datagen.tags.GenBlockTags;
import com.fuyuaki.morethanadventure.datagen.tags.GenEntityTags;
import com.fuyuaki.morethanadventure.datagen.tags.GenItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        var datapackRegistries = new DatapackBuiltinEntriesProvider(packOutput, event.getLookupProvider(), GenWorld.BUILDER, Set.of(MODID));


        generator.addProvider(true,new GenAdvancements(packOutput,datapackRegistries.getRegistryProvider(),existingFileHelper,
                        List.of()
                )
        );


        //generator.addProvider(true, new GenRecipes(lookupProvider,packOutput));
        generator.addProvider(true, GenLoot.create(packOutput,lookupProvider));


        GenBlockTags blockTagGenerator = generator.addProvider(true,
                new GenBlockTags(packOutput, datapackRegistries.getRegistryProvider()));

        generator.addProvider(true,
                new GenItemTags(packOutput, datapackRegistries.getRegistryProvider()));

        generator.addProvider(true,
                new GenBiomeTags(packOutput, datapackRegistries.getRegistryProvider()));

        generator.addProvider(true,
                new GenEntityTags(packOutput, datapackRegistries.getRegistryProvider()));


        generator.addProvider(true,
                new GenWorld(packOutput, lookupProvider));

        generator.addProvider(true,
                new EN_US_LangProvider(packOutput));

        generator.addProvider(true,
                new GenSoundDefinition(packOutput,existingFileHelper));

        generator.addProvider(true,
                new GlobalLootModifiers(packOutput,datapackRegistries.getRegistryProvider()));

        generator.addProvider(true,
                new GenCurioData(packOutput,existingFileHelper, datapackRegistries.getRegistryProvider()));

    }

}
