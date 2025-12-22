package net.fluxed.beginning.item;

import net.fluxed.beginning.TheBeginning;
import net.fluxed.beginning.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheBeginning.MOD_ID);

    public static final Supplier<CreativeModeTab> THE_BEGINNING_TAB = CREATIVE_MODE_TAB.register("the_beginning_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SODIUM.get()))
                    .title(Component.translatable("creativetab.flx_the_beginning.the_beginning_tab"))
                    .displayItems((itemDisplayPerameters, output) -> {
                        output.accept(ModItems.SODIUM);
                        output.accept(ModItems.SODIUM_CHUNK);
                        output.accept(ModBlocks.SODIUM_BLOCK);
                        output.accept(ModItems.MODULARIUM);
                        output.accept(ModBlocks.MODULARIUM_BLOCK);
                        output.accept(ModItems.MODULAR_SWORD);
                        output.accept(ModItems.MODULAR_PICKAXE);
                        output.accept(ModItems.MODULAR_AXE);
                        output.accept(ModItems.MODULAR_SHOVEL);
                        output.accept(ModItems.MODULAR_HOE);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
