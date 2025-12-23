package net.fluxed.beginning.item;

import net.fluxed.beginning.TheBeginning;
import net.fluxed.beginning.util.ModTags;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Util;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.EnumMap;

public class ModArmorMaterials {
    static ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID = ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));
    public static ResourceKey<EquipmentAsset> MODULARIUM = ResourceKey.create(ROOT_ID, Identifier.fromNamespaceAndPath(TheBeginning.MOD_ID, "modularium"));

    public static final ArmorMaterial MODULARIUM_ARMOR_MATERIAL = new ArmorMaterial(1200,
            Util.make(new EnumMap<>(ArmorType.class), attribute -> {
                attribute.put(ArmorType.BOOTS, 3);
                attribute.put(ArmorType.LEGGINGS, 6);
                attribute.put(ArmorType.CHESTPLATE, 8);
                attribute.put(ArmorType.HELMET, 3);
                attribute.put(ArmorType.BODY, 11);
            }), 16, SoundEvents.ARMOR_EQUIP_NETHERITE,
            2f, 0.1f, ModTags.Items.MODULARIUM_REPAIRABLE, MODULARIUM);
}