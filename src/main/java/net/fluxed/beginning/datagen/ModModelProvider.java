package net.fluxed.beginning.datagen;

import net.fluxed.beginning.TheBeginning;
import net.fluxed.beginning.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput packOutput) {
        super(packOutput, TheBeginning.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItems.SODIUM.get(), ModelTemplates.FLAT_ITEM);
    }
}
