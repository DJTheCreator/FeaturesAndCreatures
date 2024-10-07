package com.hammergames.featuresandcreatures.datagen;

import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import com.hammergames.featuresandcreatures.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FeaturesAndCreatures.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.RAW_RUBY.get());
        basicItem(ModItems.RUBY.get());
        basicItem(ModItems.AMETHYST.get());
        basicItem(ModItems.TOPAZ.get());
        basicItem(ModItems.SAPPHIRE.get());
        basicItem(ModItems.CHAINSAW.get());
    }
}
