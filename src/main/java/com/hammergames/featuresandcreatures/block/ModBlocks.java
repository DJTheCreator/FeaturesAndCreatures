package com.hammergames.featuresandcreatures.block;

import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import com.hammergames.featuresandcreatures.block.custom.ModHurtCarpetBlock;
import com.hammergames.featuresandcreatures.block.custom.ModSaplingBlock;
import com.hammergames.featuresandcreatures.block.custom.ModUnflammableRotatedPillarBlock;
import com.hammergames.featuresandcreatures.item.ModCreativeModeTab;
import com.hammergames.featuresandcreatures.item.ModFoods;
import com.hammergames.featuresandcreatures.item.ModItems;
import com.hammergames.featuresandcreatures.world.feature.tree.BloodTreeGrower;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
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

    //Dream Dimension
    public static final RegistryObject<Block> DREAM_PLANKS = registerBlock("dream_planks", () ->
            new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2f).sound(SoundType.WOOD)), ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> DREAM_GRASS_BLOCK = registerBlock("dream_grass_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f).sound(SoundType.STONE)), ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> DREAM_ROCK = registerBlock("dream_rock", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).sound(SoundType.STONE).requiresCorrectToolForDrops()), ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> DREAM_DOOR = registerBlock("dream_door", () ->
            new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0f).sound(SoundType.WOOD)), ModCreativeModeTab.FEATURESANDCREATURES);


    //Blood Biome
    public static final RegistryObject<Block> BLOOD_LOG = registerBlock("blood_log", () ->
            new ModUnflammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return false;}}, ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> STRIPPED_BLOOD_LOG = registerBlock("stripped_blood_log", () ->
            new ModUnflammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)), ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> FLESH_BLOCK = registerBlock("flesh_block", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.HONEY_BLOCK)), ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> BLOOD_LEAVES = registerBlock("blood_leaves", () ->
            new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.SLIME_BLOCK)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return false;}}, ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> BLOOD_SAPLING = registerBlock("blood_sapling", () ->
            new ModSaplingBlock(new BloodTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING), () -> Blocks.NETHERRACK){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return false;}}, ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> BLOOD_BRAMBLES = registerBlock("blood_brambles", () ->
            new ModHurtCarpetBlock(BlockBehaviour.Properties.of(Material.MOSS).noOcclusion().sound(SoundType.SWEET_BERRY_BUSH)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return false;}}, ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> EYE_FAN = registerBlock("eye_fan", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.GRASS).sound(SoundType.SWEET_BERRY_BUSH)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return false;}}, ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> BLOOD_WORM = registerEdibleBlock("blood_worm", () ->
            new SeaPickleBlock(BlockBehaviour.Properties.copy(Blocks.SEA_PICKLE).sound(SoundType.WOOD)), ModCreativeModeTab.FEATURESANDCREATURES, ModFoods.BLOOD_WORM);
    public static final RegistryObject<Block> BLOOD_EYES = registerBlock("blood_eyes", () ->
            new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).sound(SoundType.BONE_BLOCK)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return false;}}, ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> BLOOD_SPROUTS = registerBlock("blood_sprouts", () ->
            new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).sound(SoundType.SWEET_BERRY_BUSH)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return false;}}, ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> BLOOD_SPROUTS_TALL = registerBlock("blood_sprouts_tall", () ->
            new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.GRASS).sound(SoundType.SWEET_BERRY_BUSH)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return false;}}, ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> BLOODSTONE = registerBlock("bloodstone", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)), ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> BLOODSTONE_BRICKS = registerBlock("bloodstone_bricks", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)), ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> CRACKED_BLOODSTONE_BRICKS = registerBlock("cracked_bloodstone_bricks", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)), ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> CHISELED_BLOODSTONE = registerBlock("chiseled_bloodstone", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.CHISELED_DEEPSLATE)), ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> SMOOTH_BLOODSTONE = registerBlock("smooth_bloodstone", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_DEEPSLATE)), ModCreativeModeTab.FEATURESANDCREATURES);


    //These methods create an item for the blocks automatically
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

    private static <T extends Block> RegistryObject<T> registerEdibleBlock(String name, Supplier<T> block, CreativeModeTab tab, FoodProperties food)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerEdibleBlockItem(name, toReturn, tab, food);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerEdibleBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab, FoodProperties food)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab).food(food)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
