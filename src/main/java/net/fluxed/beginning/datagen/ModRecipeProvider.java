package net.fluxed.beginning.datagen;

import net.fluxed.beginning.block.ModBlocks;
import net.fluxed.beginning.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    protected ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
            super(packOutput, provider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "My Recipes";
        }
    }

    @Override
    protected void buildRecipes() {
        // Sodium - Sodium Chunk to Ingot is made manually...
        shaped(RecipeCategory.MISC, ModBlocks.SODIUM_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SODIUM.get())
                .unlockedBy("has_sodium", has(ModItems.SODIUM)).save(output);
        shapeless(RecipeCategory.MISC, ModItems.SODIUM.get(), 9)
                .requires(ModBlocks.SODIUM_BLOCK)
                .unlockedBy("has_sodium_block", has(ModBlocks.SODIUM_BLOCK)).save(output);
        shapeless(RecipeCategory.MISC, ModItems.SODIUM_CHUNK.get(), 4)
                .requires(ModItems.SODIUM)
                .unlockedBy("has_sodium", has(ModItems.SODIUM)).save(output);
        // Modularium
        shapeless(RecipeCategory.MISC, ModItems.MODULARIUM.get())
                .requires(ModItems.SODIUM)
                .requires(ModItems.SODIUM)
                .requires(ModItems.SODIUM)
                .requires(ModItems.SODIUM)
                .requires(Items.NETHERITE_SCRAP)
                .requires(Items.NETHERITE_SCRAP)
                .unlockedBy("has_sodium", has(ModItems.SODIUM)).save(output);
        shaped(RecipeCategory.MISC, ModBlocks.MODULARIUM_BLOCK.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.MODULARIUM.get())
                .unlockedBy("has_modularium", has(ModItems.MODULARIUM)).save(output);
    }
}
