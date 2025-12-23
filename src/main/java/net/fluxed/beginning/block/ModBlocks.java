package net.fluxed.beginning.block;

import net.fluxed.beginning.TheBeginning;
import net.fluxed.beginning.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TheBeginning.MOD_ID);

    public static final DeferredBlock<Block> SODIUM_BLOCK = registerBlock("sodium_block",
            (properties) -> new Block(properties
                    .strength(1.2f).explosionResistance(5).requiresCorrectToolForDrops().sound(SoundType.IRON)));
    public static final DeferredBlock<Block> SODIUM_ORE = registerBlock("sodium_ore",
            (properties) -> new Block(properties
                    .strength(3.2f).explosionResistance(12).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> MODULARIUM_BLOCK = registerBlock("modularium_block",
            (properties) -> new Block(properties
                    .strength(10).explosionResistance(40).requiresCorrectToolForDrops().sound(SoundType.NETHERITE_BLOCK)));

    private static <T extends Block> DeferredBlock<@NotNull T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, (properties) -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
