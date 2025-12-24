package net.fluxed.beginning.datagen;

import net.fluxed.beginning.TheBeginning;
import net.fluxed.beginning.block.ModBlocks;
import net.fluxed.beginning.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.neoforged.fml.common.Mod;

import java.util.List;
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
        shaped(RecipeCategory.MISC, ModItems.SODIUM.get())
                .pattern("SS")
                .pattern("SS")
                .define('S', ModItems.SODIUM_CHUNK.get())
                .unlockedBy("has_sodium_chunk", has(ModItems.SODIUM)).save(output, "flx_the_beginning:sodium_ingot_from_chunk");
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
                .unlockedBy("has_sodium", has(ModItems.SODIUM)).save(output, "flx_the_beginning:modularium_ingot_alloy");
        shaped(RecipeCategory.MISC, ModBlocks.MODULARIUM_BLOCK.get())
                .pattern("MMM")
                .pattern("MMM")
                .pattern("MMM")
                .define('M', ModItems.MODULARIUM.get())
                .unlockedBy("has_modularium", has(ModItems.MODULARIUM)).save(output);

        shapeless(RecipeCategory.MISC, ModItems.MODULARIUM.get(), 9)
                .requires(ModBlocks.MODULARIUM_BLOCK)
                .unlockedBy("has_modularium_block", has(ModBlocks.MODULARIUM_BLOCK)).save(output);
        shaped(RecipeCategory.MISC, ModBlocks.MODULARIUM_PLATING.get(),32)
                .pattern("MM")
                .pattern("MM")
                .define('M', ModItems.MODULARIUM.get())
                .unlockedBy("has_modularium", has(ModItems.MODULARIUM)).save(output);
        stairBuilder(ModBlocks.MODULARIUM_STAIRS.get(), Ingredient.of(ModBlocks.MODULARIUM_PLATING)).group("modularium_plating")
                .unlockedBy("has_modularium", has(ModItems.MODULARIUM)).save(output);
        slab(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MODULARIUM_SLAB.get(), ModBlocks.MODULARIUM_PLATING.get());
        wall(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MODULARIUM_WALL.get(), ModBlocks.MODULARIUM_PLATING.get());

        oreSmelting(output, List.of(ModItems.FLOAT_BERRY.get()),
                RecipeCategory.FOOD, ModItems.COOKED_FLOAT_BERRY.get(),
                0.1f, 200, "cook_float_berry");
        oreSmoking(output, List.of(ModItems.FLOAT_BERRY.get()),
                RecipeCategory.FOOD, ModItems.COOKED_FLOAT_BERRY.get(),
                0.1f, 100, "cook_float_berry");

        oreSmelting(output, List.of(ModBlocks.SODIUM_ORE.get()),
                RecipeCategory.MISC, ModItems.SODIUM.get(),
                0.25f,200,"sodium_smelt");
        oreBlasting(output, List.of(ModBlocks.SODIUM_ORE.get()),
                RecipeCategory.MISC, ModItems.SODIUM.get(),
                0.25f,100,"sodium_smelt");
    }

    protected void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                               float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                               float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected void oreSmoking(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                              float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMOKING_RECIPE, SmokingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_smoking");
    }

    protected <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, TheBeginning.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}