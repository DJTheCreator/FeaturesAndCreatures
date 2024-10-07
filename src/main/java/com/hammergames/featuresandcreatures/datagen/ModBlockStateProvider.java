package com.hammergames.featuresandcreatures.datagen;

import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import com.hammergames.featuresandcreatures.block.ModBlocks;
import com.hammergames.featuresandcreatures.block.custom.RubyLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FeaturesAndCreatures.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MAGIC_BLOCK);
        blockWithItem(ModBlocks.RUBY_ORE);
        customLamp();
    }

    private void blockWithItem(DeferredBlock<Block> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.RUBY_LAMP.get()).forAllStates(state -> {
           if(state.getValue(RubyLampBlock.CLICKED)) {
               return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("black_opal_lamp_on",
                       ResourceLocation.fromNamespaceAndPath(FeaturesAndCreatures.MOD_ID, "block/" + "black_opal_lamp_on")))};
           } else {
               return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("black_opal_lamp_off",
                       ResourceLocation.fromNamespaceAndPath(FeaturesAndCreatures.MOD_ID, "block/" + "black_opal_lamp_off")))};
           }
        });
        simpleBlockItem(ModBlocks.RUBY_LAMP.get(), models().cubeAll("black_opal_lamp_on",
                ResourceLocation.fromNamespaceAndPath(FeaturesAndCreatures.MOD_ID, "block/" + "black_opal_lamp_on")));
    }
}
