package com.fuyuvulpes.morethanadventure.datagen;

import com.fuyuvulpes.morethanadventure.datagen.generators.*;
import com.fuyuvulpes.morethanadventure.datagen.generators.lang.EN_US_LangProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class DataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(),new GenAdvancements(packOutput,lookupProvider,existingFileHelper,
                        List.of()
                )
        );
        generator.addProvider(event.includeServer(), new GenRecipes(packOutput,lookupProvider));
        generator.addProvider(event.includeServer(), GenLoot.create(packOutput,lookupProvider));

        generator.addProvider(event.includeClient(), new GenBlockstate(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new GenItemModels(packOutput, existingFileHelper));

        GenBlockTags blockTagGenerator = generator.addProvider(event.includeServer(),
                new GenBlockTags(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(),
                new GenItemTags(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));


        generator.addProvider(event.includeServer(),
                new GenBiomeTags(packOutput, lookupProvider, existingFileHelper));

        generator.addProvider(event.includeServer(),
                new GenWorld(packOutput, lookupProvider));


        generator.addProvider(event.includeClient(),
                new EN_US_LangProvider(packOutput));

    }

}
