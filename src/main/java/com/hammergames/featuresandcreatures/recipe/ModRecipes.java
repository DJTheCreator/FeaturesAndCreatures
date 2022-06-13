package com.hammergames.featuresandcreatures.recipe;

import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import net.minecraft.core.Registry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, FeaturesAndCreatures.MOD_ID);

    public static final RegistryObject<RecipeSerializer<GemCutterRecipe>> GEM_CUTTER_SERIALIZER =
            SERIALIZERS.register("gem_cutting", () -> GemCutterRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        Registry.register(Registry.RECIPE_TYPE, GemCutterRecipe.Type.ID, GemCutterRecipe.Type.INSTANCE);
    }


}
