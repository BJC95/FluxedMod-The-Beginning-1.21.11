package net.fluxed.beginning.item;

import net.fluxed.beginning.TheBeginning;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.component.Weapon;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TheBeginning.MOD_ID);

    public static final DeferredItem<Item> SODIUM = ITEMS.registerItem("sodium_ingot",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> SODIUM_CHUNK = ITEMS.registerItem("sodium_chunk",
            Item::new, new Item.Properties());
    public static final DeferredItem<Item> MODULARIUM = ITEMS.registerItem("modularium_ingot",
            Item::new, new Item.Properties());

    public static final DeferredItem<Item> MODULAR_SWORD = ITEMS.registerItem("modularium_sword",
            (properties) -> new Item(properties.sword(ModToolTiers.MODULARIUM, 6, -2.4f)));
    public static final DeferredItem<Item> MODULAR_PICKAXE = ITEMS.registerItem("modularium_pickaxe",
            (properties) -> new Item(properties.pickaxe(ModToolTiers.MODULARIUM, 4, -2.8f)));
    public static final DeferredItem<Item> MODULAR_AXE = ITEMS.registerItem("modularium_axe",
            (properties) -> new Item(properties.axe(ModToolTiers.MODULARIUM, 8, -3f)));
    public static final DeferredItem<Item> MODULAR_SHOVEL = ITEMS.registerItem("modularium_shovel",
            (properties) -> new Item(properties.shovel(ModToolTiers.MODULARIUM, 4.5f, -3f)));
    public static final DeferredItem<Item> MODULAR_HOE = ITEMS.registerItem("modularium_hoe",
            (properties) -> new Item(properties.hoe(ModToolTiers.MODULARIUM, 1, 0)));
//    public static final DeferredItem<Item> MODULARIUM_JAVELIN = ITEMS.registerItem("modularium_javelin",
//            TridentItem::new, new Item.Properties());
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
