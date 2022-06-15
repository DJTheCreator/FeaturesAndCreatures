package com.hammergames.featuresandcreatures.screen.slot;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class SandpaperSlot extends SlotItemHandler {
    public SandpaperSlot(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return SandpaperSlot.isPaper(stack);
    }

    public static boolean isPaper(ItemStack stack) {
        return stack.is(Items.PAPER);
    }
}
