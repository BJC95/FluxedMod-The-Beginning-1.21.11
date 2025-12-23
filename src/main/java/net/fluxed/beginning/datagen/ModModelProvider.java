package net.fluxed.beginning.datagen;

import net.fluxed.beginning.TheBeginning;
import net.fluxed.beginning.block.ModBlocks;
import net.fluxed.beginning.item.ModArmorMaterials;
import net.fluxed.beginning.item.ModItems;
import net.fluxed.beginning.item.custom.ModArmorItem;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.stream.Stream;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput packOutput) {
        super(packOutput, TheBeginning.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        // --ITEMS--
        itemModels.generateFlatItem(ModItems.SODIUM.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.SODIUM_CHUNK.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.MODULARIUM.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.FLOAT_BERRY.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItems.COOKED_FLOAT_BERRY.get(), ModelTemplates.FLAT_ITEM);
        // -TOOLS-
        itemModels.generateFlatItem(ModItems.MODULAR_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.MODULAR_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.MODULAR_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.MODULAR_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(ModItems.MODULAR_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateSpear(ModItems.MODULAR_SPEAR.get());
        itemModels.generateTrimmableItem(ModItems.MODULARIUM_HELMET.get(), ModArmorMaterials.MODULARIUM, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
        itemModels.generateTrimmableItem(ModItems.MODULARIUM_CHESTPLATE.get(), ModArmorMaterials.MODULARIUM, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
        itemModels.generateTrimmableItem(ModItems.MODULARIUM_LEGGINGS.get(), ModArmorMaterials.MODULARIUM, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
        itemModels.generateTrimmableItem(ModItems.MODULARIUM_BOOTS.get(), ModArmorMaterials.MODULARIUM, ItemModelGenerators.TRIM_PREFIX_BOOTS, false);

        // --BLOCKS--
        blockModels.createTrivialCube(ModBlocks.SODIUM_BLOCK.get());
        blockModels.createTrivialCube(ModBlocks.MODULARIUM_BLOCK.get());
    }
    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream();
    }
    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return ModItems.ITEMS.getEntries().stream();
    }
}
