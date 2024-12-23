package com.fuyuaki.morethanadventure.datagen.other;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import top.theillusivec4.curios.api.CuriosDataProvider;

import java.util.concurrent.CompletableFuture;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class GenCurioData extends CuriosDataProvider {
    public GenCurioData(PackOutput output, ExistingFileHelper fileHelper, CompletableFuture<HolderLookup.Provider> registries) {
        super(MODID, output, fileHelper, registries);
    }

    @Override
    public void generate(HolderLookup.Provider registries, ExistingFileHelper fileHelper) {
        this.slots();
        this.entities();
    }


    private void slots(){

        this.createSlot("talisman").icon(ResourceLocation.fromNamespaceAndPath(MODID,"slot/empty_talisman_slot"))
                .size(4)
        ;
        this.createSlot("totem").icon(ResourceLocation.fromNamespaceAndPath(MODID,"slot/empty_totem_slot"))
                .size(2)
        ;


    }
    private void entities(){
        this.createEntities("mta_player").addPlayer().replace(false).addSlots("talisman","totem");

    }
}
