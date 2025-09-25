package maroonshaded.gildedarmor.item.equipment;

import maroonshaded.gildedarmor.GildedArmor;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;

public class ModArmorMaterials
{
    public static final ArmorMaterial GILDED_NETHERITE = new ArmorMaterial(37, Util.make(new EnumMap<>(ArmorType.class), defense ->
    {
        defense.put(ArmorType.BOOTS, 3);
        defense.put(ArmorType.LEGGINGS, 6);
        defense.put(ArmorType.CHESTPLATE, 8);
        defense.put(ArmorType.HELMET, 3);
        defense.put(ArmorType.BODY, 11);
    }), 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, ItemTags.REPAIRS_NETHERITE_ARMOR, ModEquipmentAssets.GILDED_NETHERITE);

    public static final ArmorMaterial GILDED_ENDERITE = new ArmorMaterial(37, Util.make(new EnumMap<>(ArmorType.class), defense ->
    {
        defense.put(ArmorType.BOOTS, 4);
        defense.put(ArmorType.LEGGINGS, 7);
        defense.put(ArmorType.CHESTPLATE, 9);
        defense.put(ArmorType.HELMET, 4);
        defense.put(ArmorType.BODY, 12);
    }), 17, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.1F, GildedArmor.REPAIRS_ENDERITE_ARMOR, ModEquipmentAssets.GILDED_ENDERITE);
}
