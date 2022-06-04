package com.hammergames.featuresandcreatures.item;

import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import com.hammergames.featuresandcreatures.item.custom.FireSwordItem;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FeaturesAndCreatures.MOD_ID);

    //Gems
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby", () ->
            new Item(new Item.Properties().tab(ModCreativeModeTab.FEATURESANDCREATURES)));
    public static final RegistryObject<Item> AMETHYST = ITEMS.register("amethyst", () ->
            new Item(new Item.Properties().tab(ModCreativeModeTab.FEATURESANDCREATURES)));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () ->
            new Item(new Item.Properties().tab(ModCreativeModeTab.FEATURESANDCREATURES)));
    public static final RegistryObject<Item> TOPAZ = ITEMS.register("topaz", () ->
            new Item(new Item.Properties().tab(ModCreativeModeTab.FEATURESANDCREATURES)));

    //Steel
    public static final RegistryObject<Item> STEEL = ITEMS.register("steel_ingot", () ->
            new Item(new Item.Properties().tab(ModCreativeModeTab.FEATURESANDCREATURES)));

    //Food
    public static final RegistryObject<Item> BLOODFRUIT = ITEMS.register("bloodfruit", () ->
            new Item(new Item.Properties().tab(ModCreativeModeTab.FEATURESANDCREATURES).food(ModFoods.BLOODFRUIT)));
    public static final RegistryObject<Item> ROASTED_BLOODFRUIT = ITEMS.register("roasted_bloodfruit", () ->
            new Item(new Item.Properties().tab(ModCreativeModeTab.FEATURESANDCREATURES).food(ModFoods.ROASTED_BLOODFRUIT)));

    //Tools
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword", () ->
            new FireSwordItem(ModTiers.RUBY, 3, -2f, new Item.Properties().tab(ModCreativeModeTab.FEATURESANDCREATURES)));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe", () ->
            new PickaxeItem(ModTiers.RUBY, 1, -2.5f, new Item.Properties().tab(ModCreativeModeTab.FEATURESANDCREATURES)));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe", () ->
            new AxeItem(ModTiers.RUBY, 5.0f, -2.8f, new Item.Properties().tab(ModCreativeModeTab.FEATURESANDCREATURES)));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel", () ->
            new ShovelItem(ModTiers.RUBY, 1.7f, -2.6f, new Item.Properties().tab(ModCreativeModeTab.FEATURESANDCREATURES)));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe", () ->
            new HoeItem(ModTiers.RUBY, -5, 0.0f, new Item.Properties().tab(ModCreativeModeTab.FEATURESANDCREATURES)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
