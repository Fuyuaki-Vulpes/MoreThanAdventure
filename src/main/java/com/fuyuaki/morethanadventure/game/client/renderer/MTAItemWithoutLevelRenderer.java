package com.fuyuaki.morethanadventure.game.client.renderer;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.MysticMermaidsTridentModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.NetheriteTridentModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)

public class MTAItemWithoutLevelRenderer  {


    private static final Minecraft minecraft = Minecraft.getInstance();
    private NetheriteTridentModel netheriteTrident;
    private MysticMermaidsTridentModel mysticMermaidsTrident;
    private final EntityModelSet entityModelSet;


    public static MTAItemWithoutLevelRenderer INSTANCE = new MTAItemWithoutLevelRenderer(minecraft.getBlockEntityRenderDispatcher(),minecraft.getEntityModels());


    public MTAItemWithoutLevelRenderer(BlockEntityRenderDispatcher pBlockEntityRenderDispatcher, EntityModelSet pEntityModelSet) {
        this.entityModelSet = pEntityModelSet;


    }

    public void onResourceManagerReload(ResourceManager pResourceManager) {

        this.netheriteTrident = new NetheriteTridentModel(this.entityModelSet.bakeLayer(MTAModelLayers.NETHERITE_TRIDENT));
        this.mysticMermaidsTrident = new MysticMermaidsTridentModel(this.entityModelSet.bakeLayer(MTAModelLayers.MYSTIC_MERMAIDS_TRIDENT));



    }

    public void renderByItem(ItemStack pStack, ItemDisplayContext pDisplayContext, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight, int pPackedOverlay) {
        Item item = pStack.getItem();



        if (pStack.is(MtaItems.NETHERITE_TRIDENT)) {
            pPoseStack.pushPose();
            pPoseStack.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer1 = ItemRenderer.getFoilBuffer(
                    pBuffer, this.netheriteTrident.renderType(NetheriteTridentModel.TEXTURE), false, pStack.hasFoil()
            );
            this.netheriteTrident.renderToBuffer(pPoseStack, vertexconsumer1, pPackedLight, pPackedOverlay);
            pPoseStack.popPose();
        }else if (pStack.is(MtaItems.MYSTIC_MERMAIDS_TRIDENT)) {
            pPoseStack.pushPose();
            pPoseStack.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer vertexconsumer1 = ItemRenderer.getFoilBuffer(
                    pBuffer, this.mysticMermaidsTrident.renderType(MysticMermaidsTridentModel.TEXTURE), false, pStack.hasFoil()
            );
            this.mysticMermaidsTrident.renderToBuffer(pPoseStack, vertexconsumer1, pPackedLight, pPackedOverlay);
            pPoseStack.popPose();
        }


    }
}
