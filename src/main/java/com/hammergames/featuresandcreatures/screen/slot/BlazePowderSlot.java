package com.hammergames.featuresandcreatures.screen.slot;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class BlazePowderSlot extends SlotItemHandler {
    public BlazePowderSlot(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return BlazePowderSlot.isBlazePowder(stack);
    }

//    @Override
//    public int getMaxStackSize(ItemStack pStack) {
//        return ModFuelSlot.isBucket(pStack) ? 1 : super.getMaxStackSize(pStack);
//    }
//
//    public static boolean isBucket(ItemStack stack) {
//        return stack.is(Items.BUCKET);
//    }

    public static boolean isBlazePowder(ItemStack stack) {
        return stack.is(Items.BLAZE_POWDER);
    }
}