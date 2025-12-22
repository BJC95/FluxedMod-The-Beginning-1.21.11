package net.fluxed.beginning.datagen;

import net.fluxed.beginning.TheBeginning;
import net.fluxed.beginning.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TheBeginning.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.SWORDS)
                .add(ModItems.MODULAR_SWORD.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.MODULAR_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.MODULAR_SHOVEL.get());
        tag(ItemTags.AXES)
                .add(ModItems.MODULAR_AXE.get());
        tag(ItemTags.HOES)
                .add(ModItems.MODULAR_HOE.get());
        tag(ItemTags.SPEARS)
                .add(ModItems.MODULAR_SPEAR.get());
    }
}
