package com.hammergames.featuresandcreatures.item;

import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import com.hammergames.featuresandcreatures.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FeaturesAndCreatures.MOD_ID);

    public static final Supplier<CreativeModeTab> DEV_TAB =
            CREATIVE_MODE_TABS.register("dev_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.featuresandcreatures.dev_tab"))
                    .icon(() -> new ItemStack(ModItems.RUBY.get()))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.RUBY);
                        output.accept(ModItems.RAW_RUBY);
                        output.accept(ModItems.TOPAZ);
                        output.accept(ModItems.SAPPHIRE);
                        output.accept(ModItems.AMETHYST);
                        output.accept(ModItems.CHAINSAW);

                        output.accept(ModBlocks.RUBY_ORE);
                        output.accept(ModBlocks.MAGIC_BLOCK);
                        output.accept(ModBlocks.RUBY_LAMP);
                    })
                    .build());

//    public static final Supplier<CreativeModeTab> DEV_TAB_two =
//            CREATIVE_MODE_TABS.register("dev_tab_2", () -> CreativeModeTab.builder()
//                    .title(Component.translatable("itemGroup.featuresandcreatures.dev_tab_2"))
//                    .icon(() -> new ItemStack(Items.COMMAND_BLOCK.asItem()))
//                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(FeaturesAndCreatures.MOD_ID, "dev_tab"))
//                    .displayItems((itemDisplayParameters, output) -> {
//                        output.accept(Blocks.BELL);
//                    }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
