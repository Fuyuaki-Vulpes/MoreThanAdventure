package com.fuyuaki.morethanadventure.world.block.entity;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlockEntities;
import com.fuyuaki.morethanadventure.world.block.kitchen.StoveBlock;
import com.fuyuaki.morethanadventure.world.inventory.StoveMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.StackedItemContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.FuelValues;
import net.minecraft.world.level.block.state.BlockState;

public class StoveBlockEntity extends BaseContainerBlockEntity implements StackedContentsCompatible {
    protected NonNullList<ItemStack> items = NonNullList.withSize(1, ItemStack.EMPTY);
    int litTimeRemaining;
    int litTotalTime;
    protected final ContainerData dataAccess = new ContainerData() {
        @Override
        public int get(int p_58431_) {
            switch (p_58431_) {
                case 0:
                    if (litTotalTime > Short.MAX_VALUE) {
                        // Neo: preserve litTime / litDuration ratio on the client as data slots are synced as shorts.
                        return net.minecraft.util.Mth.floor(((double) litTimeRemaining / litTotalTime) * Short.MAX_VALUE);
                    }

                    return StoveBlockEntity.this.litTimeRemaining;
                case 1:
                    return Math.min(StoveBlockEntity.this.litTotalTime, Short.MAX_VALUE);

                default:
                    return 0;
            }
        }

        @Override
        public void set(int p_58433_, int p_58434_) {
            switch (p_58433_) {
                case 0:
                    StoveBlockEntity.this.litTimeRemaining = p_58434_;
                    break;
                case 1:
                    StoveBlockEntity.this.litTotalTime = p_58434_;
                    break;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    };


    public StoveBlockEntity( BlockPos p_155077_, BlockState p_155078_) {
        super(MtaBlockEntities.STOVE.get(), p_155077_, p_155078_);
    }

    private boolean isLit() {
        return this.litTimeRemaining > 0;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("mta.container.stove");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> stacks) {
        this.items = stacks;
    }

    @Override
    public void setItem(int index, ItemStack stack) {
        ItemStack itemstack = this.items.get(index);
        boolean flag = !stack.isEmpty() && ItemStack.isSameItemSameComponents(itemstack, stack);
        this.items.set(index, stack);
        stack.limitSize(this.getMaxStackSize(stack));
        if (index == 0 && !flag && this.level instanceof ServerLevel serverlevel) {
            this.setChanged();
        }
    }

    @Override
    public boolean canPlaceItem(int index, ItemStack stack) {
        ItemStack itemstack = this.items.getFirst();
        return stack.getBurnTime(RecipeType.SMOKING, this.level.fuelValues()) > 0 || stack.is(Items.BUCKET) && !itemstack.is(Items.BUCKET);

    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new StoveMenu(containerId, inventory, this,this.dataAccess);
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.loadAdditional(tag, provider);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(tag, this.items, provider);
        this.litTimeRemaining = tag.getInt("lit_time_remaining");
        this.litTotalTime = tag.getInt("lit_total_time");

    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider provider) {
        super.saveAdditional(tag, provider);
        tag.putInt("lit_time_remaining", this.litTimeRemaining);
        tag.putInt("lit_total_time", this.litTotalTime);
        ContainerHelper.saveAllItems(tag, this.items, provider);
    }


    public static void serverTick(Level level, BlockPos pos, BlockState state, StoveBlockEntity stove) {
        boolean flag = stove.isLit();
        boolean flag1 = false;
        if (stove.isLit()) {
            stove.litTimeRemaining--;
        }

        ItemStack itemstack = stove.items.getFirst();
        boolean flag2 = !itemstack.isEmpty();
        if (!stove.isLit() && flag2) {

            stove.litTimeRemaining = stove.getBurnDuration(level.fuelValues(), itemstack);
            stove.litTotalTime = stove.litTimeRemaining;
            if (stove.isLit()){

                ItemStack stack = itemstack.copy();
                stack.shrink(1);
                flag1 = true;
                if (stack.isEmpty()) {
                    ItemStack remainder = itemstack.getCraftingRemainder();
                    stove.items.set(0, remainder);

                } else {
                    stove.items.set(0, stack);

                }

            }

        }


        if (flag != stove.isLit()) {
            flag1 = true;
            state = state.setValue(StoveBlock.LIT, Boolean.valueOf(stove.isLit()));
            level.setBlock(pos, state, 3);
        }

        if (flag1) {
            setChanged(level, pos, state);
        }
    }

    protected int getBurnDuration(FuelValues fuelValues, ItemStack stack) {
        return stack.getBurnTime(RecipeType.SMOKING, fuelValues) * 10;
    }

    @Override
    public void fillStackedContents(StackedItemContents p_363281_) {
        for (ItemStack itemstack : this.items) {
            p_363281_.accountStack(itemstack);
        }
    }


}
