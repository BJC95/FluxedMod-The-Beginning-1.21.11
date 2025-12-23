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
        tag(ItemTags.DURABILITY_ENCHANTABLE)
                .add(ModItems.MODULARIUM_HELMET.get())
                .add(ModItems.MODULARIUM_CHESTPLATE.get())
                .add(ModItems.MODULARIUM_LEGGINGS.get())
                .add(ModItems.MODULARIUM_BOOTS.get())
                .add(ModItems.MODULAR_SWORD.get())
                .add(ModItems.MODULAR_PICKAXE.get())
                .add(ModItems.MODULAR_SHOVEL.get())
                .add(ModItems.MODULAR_AXE.get())
                .add(ModItems.MODULAR_SPEAR.get());
        tag(ItemTags.MELEE_WEAPON_ENCHANTABLE)
                .add(ModItems.MODULAR_SWORD.get())
                .add(ModItems.MODULAR_AXE.get())
                .add(ModItems.MODULAR_SPEAR.get());

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

        tag(ItemTags.ARMOR_ENCHANTABLE)
                .add(ModItems.MODULARIUM_HELMET.get())
                .add(ModItems.MODULARIUM_CHESTPLATE.get())
                .add(ModItems.MODULARIUM_LEGGINGS.get())
                .add(ModItems.MODULARIUM_BOOTS.get());
        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
                .add(ModItems.MODULARIUM_HELMET.get());
        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
                .add(ModItems.MODULARIUM_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
                .add(ModItems.MODULARIUM_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
                .add(ModItems.MODULARIUM_BOOTS.get());

    }
}
