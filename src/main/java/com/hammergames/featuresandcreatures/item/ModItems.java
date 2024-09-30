package com.hammergames.featuresandcreatures.item;

import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(FeaturesAndCreatures.MOD_ID);

    public static final DeferredItem<Item> RUBY = ITEMS.registerSimpleItem("ruby");
    public static final DeferredItem<Item> RAW_RUBY =
            ITEMS.registerItem("raw_ruby", Item::new, new Item.Properties());



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
