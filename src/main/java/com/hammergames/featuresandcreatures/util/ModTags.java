package com.hammergames.featuresandcreatures.util;

import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class ModTags {

    public static void register() {
        Blocks.registerBlockTags();
        Items.registerItemTags();
    }

    public static class Blocks {

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(FeaturesAndCreatures.MOD_ID, name));
        }

        private static TagKey<Block> forgeTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }

        public static void registerBlockTags() {

        }

    }

    public static class Items {
        public static final TagKey<Item> STEEL_INGOTS = forgeTag("ingots/steel");


        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(FeaturesAndCreatures.MOD_ID, name));
        }

        private static TagKey<Item> forgeTag(String name) {
            return ItemTags.create(new ResourceLocation("forge", name));
        }

        public static void registerItemTags() {

        }

    }
}
