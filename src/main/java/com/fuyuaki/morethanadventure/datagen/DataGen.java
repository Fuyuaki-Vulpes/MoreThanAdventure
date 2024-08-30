package com.fuyuaki.morethanadventure.datagen;

import com.fuyuaki.morethanadventure.datagen.generators.*;
import com.fuyuaki.morethanadventure.datagen.generators.lang.EN_US_LangProvider;
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
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        var datapackRegistries = new DatapackBuiltinEntriesProvider(packOutput, event.getLookupProvider(), GenWorld.BUILDER, Set.of(MODID));


        generator.addProvider(event.includeServer(),new GenAdvancements(packOutput,datapackRegistries.getRegistryProvider(),existingFileHelper,
                        List.of()
                )
        );
        generator.addProvider(event.includeServer(), new GenRecipes(packOutput,lookupProvider));
        generator.addProvider(event.includeServer(), GenLoot.create(packOutput,lookupProvider));

        generator.addProvider(event.includeClient(), new GenBlockstate(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new GenItemModels(packOutput, existingFileHelper));

        GenBlockTags blockTagGenerator = generator.addProvider(event.includeServer(),
                new GenBlockTags(packOutput, datapackRegistries.getRegistryProvider(), existingFileHelper));

        generator.addProvider(event.includeServer(),
                new GenItemTags(packOutput, datapackRegistries.getRegistryProvider(), blockTagGenerator.contentsGetter(), existingFileHelper));

        generator.addProvider(event.includeServer(),
                new GenBiomeTags(packOutput, datapackRegistries.getRegistryProvider(), existingFileHelper));

        generator.addProvider(event.includeServer(),
                new GenEntityTags(packOutput, datapackRegistries.getRegistryProvider(), existingFileHelper));


        generator.addProvider(event.includeServer(),
                new GenWorld(packOutput, lookupProvider));

        generator.addProvider(event.includeClient(),
                new EN_US_LangProvider(packOutput));

        generator.addProvider(event.includeClient(),
                new GenSoundDefinition(packOutput,existingFileHelper));

    }

}
