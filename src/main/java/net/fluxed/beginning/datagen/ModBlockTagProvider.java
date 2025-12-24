package net.fluxed.beginning.datagen;

import net.fluxed.beginning.TheBeginning;
import net.fluxed.beginning.block.ModBlocks;
import net.fluxed.beginning.util.ModTags;
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
                .add(ModBlocks.MODULARIUM_BLOCK.get())
                .add(ModBlocks.SODIUM_ORE.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SODIUM_BLOCK.get())
                .add(ModBlocks.MODULARIUM_PLATING.get());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MODULARIUM_BLOCK.get())
                .add(ModBlocks.SODIUM_ORE.get());

        tag(ModTags.Blocks.INCORRECT_FOR_MODULARIUM_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
                .remove(ModTags.Blocks.NEEDS_MODULARIUM_TOOL);
        tag(ModTags.Blocks.NEEDS_MODULARIUM_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);

        tag(BlockTags.WALLS).add(ModBlocks.MODULARIUM_WALL.get());
    }
}
