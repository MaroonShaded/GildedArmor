package maroonshaded.gildedarmor.item.equipment;

import maroonshaded.gildedarmor.GildedArmor;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public class ModEquipmentAssets
{
    public static final ResourceKey<EquipmentAsset> GILDED_NETHERITE = ResourceKey.create(EquipmentAssets.ROOT_ID, GildedArmor.location("gilded_netherite"));
    public static final ResourceKey<EquipmentAsset> GILDED_ENDERITE = ResourceKey.create(EquipmentAssets.ROOT_ID, GildedArmor.location("gilded_enderite"));
}
