package com.hammergames.featuresandcreatures.screen.slot;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ModFuelSlot extends SlotItemHandler {
    public ModFuelSlot(IItemHandler itemHandler, int index, int x, int y) {
        super(itemHandler, index, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return ModFuelSlot.isBlazePower(stack);
    }

    public static boolean isBlazePower(ItemStack stack) {
        return stack.is(Items.BLAZE_POWDER);
    }
}