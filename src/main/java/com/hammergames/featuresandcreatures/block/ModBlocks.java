package com.hammergames.featuresandcreatures.block;

import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import com.hammergames.featuresandcreatures.item.ModCreativeModeTab;
import com.hammergames.featuresandcreatures.item.ModItems;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FeaturesAndCreatures.MOD_ID);

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)), ModCreativeModeTab.FEATURESANDCREATURES);

    public static final RegistryObject<Block> DREAM_PLANKS = registerBlock("dream_planks", () ->
            new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2f).sound(SoundType.WOOD)), ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> DREAM_GRASS_BLOCK = registerBlock("dream_grass_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f).sound(SoundType.STONE)), ModCreativeModeTab.FEATURESANDCREATURES);



    //Helper methods
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
