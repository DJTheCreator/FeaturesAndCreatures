package com.hammergames.featuresandcreatures.event;

import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import com.hammergames.featuresandcreatures.entity.ModEntityTypes;
import com.hammergames.featuresandcreatures.entity.custom.NetherWolfEntity;
import com.hammergames.featuresandcreatures.entity.custom.WispEntity;
import com.hammergames.featuresandcreatures.recipe.GemCutterRecipe;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = FeaturesAndCreatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.WISP.get(), WispEntity.setAttributes());
        event.put(ModEntityTypes.NETHER_WOLF.get(), NetherWolfEntity.setAttributes());
    }

    @SubscribeEvent
    public static void registerRecipeTypes(final RegistryEvent.Register<RecipeSerializer<?>> event) {
        Registry.register(Registry.RECIPE_TYPE, GemCutterRecipe.Type.ID, GemCutterRecipe.Type.INSTANCE);
    }
}
