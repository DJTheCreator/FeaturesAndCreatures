package com.hammergames.featuresandcreatures.item;

import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FeaturesAndCreatures.MOD_ID);

    //Gems
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FEATURESANDCREATURES)));
    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FEATURESANDCREATURES)));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FEATURESANDCREATURES)));
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FEATURESANDCREATURES)));

    //Steel
    public static final RegistryObject<Item> STEEL = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().tab(ModCreativeModeTab.FEATURESANDCREATURES)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
