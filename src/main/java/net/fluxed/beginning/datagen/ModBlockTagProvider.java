package net.fluxed.beginning.datagen;

import net.fluxed.beginning.TheBeginning;
import net.fluxed.beginning.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, TheBeginning.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.SODIUM_BLOCK.get())
                .add(ModBlocks.MODULARIUM_BLOCK.get());
        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SODIUM_BLOCK.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MODULARIUM_BLOCK.get())
                .add(ModBlocks.SODIUM_ORE.get());
    }
}
