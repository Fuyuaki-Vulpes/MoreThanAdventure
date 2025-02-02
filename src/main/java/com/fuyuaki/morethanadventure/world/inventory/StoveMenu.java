package com.fuyuaki.morethanadventure.world.inventory;

import com.fuyuaki.morethanadventure.core.deferred_registries.MTAMenuTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class StoveMenu extends AbstractContainerMenu {
    private final Container stove;
    private final ContainerData data;

    public StoveMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, new SimpleContainer(1), new SimpleContainerData(2));
    }

    public StoveMenu(int containerId, Inventory playerInventory, Container container, ContainerData data) {
        super(MTAMenuTypes.STOVE.get(), containerId);
        this.stove = container;
        checkContainerSize(container, 1);
        checkContainerDataCount(data, 2);
        container.startOpen(playerInventory.player);
        this.data = data;
            this.addSlot(new Slot(container, 0, 80 , 20));


        this.addStandardInventorySlots(playerInventory, 8, 51);
        this.addDataSlots(data);
    }

    @Override
    public boolean stillValid(Player player) {
        return this.stove.stillValid(player);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (index < this.stove.getContainerSize()) {
                if (!this.moveItemStackTo(itemstack1, this.stove.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.stove.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    @Override
    public void removed(Player player) {
        super.removed(player);
        this.stove.stopOpen(player);
    }

    public float getLitProgress() {
        int i = this.data.get(1);
        if (i == 0) {
            i = 200;
        }

        return Mth.clamp((float)this.data.get(0) / (float)i, 0.0F, 1.0F);
    }

    public boolean isLit() {
        return this.data.get(0) > 0;
    }
}
