package net.fluxed.beginning.item;

import net.fluxed.beginning.TheBeginning;
import net.fluxed.beginning.item.custom.ModArmorItem;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static net.minecraft.world.item.Items.registerItem;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TheBeginning.MOD_ID);

    public static final DeferredItem<Item> SODIUM = ITEMS.registerItem("sodium_ingot",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> SODIUM_CHUNK = ITEMS.registerItem("sodium_chunk",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> MODULARIUM = ITEMS.registerItem("modularium_ingot",
            Item::new, new Item.Properties());

    public static final DeferredItem<Item> FLOAT_BERRY = ITEMS.registerItem("levity_berry",
            (properties) -> new Item(properties.food(ModFoodProperties.FLOAT_BERRY, ModFoodProperties.FLOAT_EFFECT)));
    public static final DeferredItem<Item> COOKED_FLOAT_BERRY = ITEMS.registerItem("roasted_levity_berry",
            (properties) -> new Item(properties.food(ModFoodProperties.FLOAT_BERRY, ModFoodProperties.STRONG_FLOAT_EFFECT)));

    public static final DeferredItem<Item> MODULAR_SWORD = ITEMS.registerItem("modularium_sword",
            (properties) -> new Item(properties.sword(ModToolTiers.MODULARIUM, 3, -2.4f)));
    public static final DeferredItem<Item> MODULAR_PICKAXE = ITEMS.registerItem("modularium_pickaxe",
            (properties) -> new Item(properties.pickaxe(ModToolTiers.MODULARIUM, 1, -2.8f)));
    public static final DeferredItem<Item> MODULAR_AXE = ITEMS.registerItem("modularium_axe",
            (properties) -> new Item(properties.axe(ModToolTiers.MODULARIUM, 5, -3f)));
    public static final DeferredItem<Item> MODULAR_SHOVEL = ITEMS.registerItem("modularium_shovel",
            (properties) -> new Item(properties.shovel(ModToolTiers.MODULARIUM, 1.5f, -3f)));
    public static final DeferredItem<Item> MODULAR_HOE = ITEMS.registerItem("modularium_hoe",
            (properties) -> new Item(properties.hoe(ModToolTiers.MODULARIUM, -3.0f, 0)));
    public static final DeferredItem<Item> MODULAR_SPEAR = ITEMS.registerItem("modularium_spear",
            (properties) -> new Item(properties.spear(ModToolTiers.MODULARIUM, 0.85f, 1.075f,
                    0.5f, 3.0f, 7.5f, 6.5f, 5.1f,
                    10.0f, 4.6f)));
    public static final DeferredItem<Item> MODULARIUM_HELMET = ITEMS.registerItem("modularium_helmet",
            (properties) -> new ModArmorItem(properties.humanoidArmor(ModArmorMaterials.MODULARIUM_ARMOR_MATERIAL, ArmorType.HELMET)));
    public static final DeferredItem<Item> MODULARIUM_CHESTPLATE = ITEMS.registerItem("modularium_chestplate",
            (properties) -> new ModArmorItem(properties.humanoidArmor(ModArmorMaterials.MODULARIUM_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> MODULARIUM_LEGGINGS = ITEMS.registerItem("modularium_leggings",
            (properties) -> new ModArmorItem(properties.humanoidArmor(ModArmorMaterials.MODULARIUM_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> MODULARIUM_BOOTS = ITEMS.registerItem("modularium_boots",
            (properties) -> new ModArmorItem(properties.humanoidArmor(ModArmorMaterials.MODULARIUM_ARMOR_MATERIAL, ArmorType.BOOTS)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
