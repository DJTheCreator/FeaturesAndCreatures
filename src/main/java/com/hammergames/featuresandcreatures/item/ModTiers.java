package com.hammergames.featuresandcreatures.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier RUBY = new ForgeTier(4, 2300, 10.0F, 4.5F, 17,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.RUBY.get()));
}
