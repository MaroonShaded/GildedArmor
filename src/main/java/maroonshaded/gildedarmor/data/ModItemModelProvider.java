package maroonshaded.gildedarmor.data;

import maroonshaded.gildedarmor.GildedArmor;
import maroonshaded.gildedarmor.init.ModItems;
import maroonshaded.gildedarmor.item.equipment.ModEquipmentAssets;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModItemModelProvider extends ModelProvider
{
    public ModItemModelProvider(PackOutput output)
    {
        super(output, GildedArmor.MODID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels)
    {
        itemModels.generateFlatItem(ModItems.GILDING_UPGRADE_SMITHING_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);

        // Pay attention to replace with the _darker variants when applicable
        itemModels.generateTrimmableItem(ModItems.GILDED_NETHERITE_HELMET.get(), ModEquipmentAssets.GILDED_NETHERITE, "helmet", false);
        itemModels.generateTrimmableItem(ModItems.GILDED_NETHERITE_CHESTPLATE.get(), ModEquipmentAssets.GILDED_NETHERITE, "chestplate", false);
        itemModels.generateTrimmableItem(ModItems.GILDED_NETHERITE_LEGGINGS.get(), ModEquipmentAssets.GILDED_NETHERITE, "leggings", false);
        itemModels.generateTrimmableItem(ModItems.GILDED_NETHERITE_BOOTS.get(), ModEquipmentAssets.GILDED_NETHERITE, "boots", false);

        itemModels.generateTrimmableItem(ModItems.GILDED_ENDERITE_HELMET.get(), ModEquipmentAssets.GILDED_ENDERITE, "helmet", false);
        itemModels.generateTrimmableItem(ModItems.GILDED_ENDERITE_CHESTPLATE.get(), ModEquipmentAssets.GILDED_ENDERITE, "chestplate", false);
        itemModels.generateTrimmableItem(ModItems.GILDED_ENDERITE_LEGGINGS.get(), ModEquipmentAssets.GILDED_ENDERITE, "leggings", false);
        itemModels.generateTrimmableItem(ModItems.GILDED_ENDERITE_BOOTS.get(), ModEquipmentAssets.GILDED_ENDERITE, "boots", false);
    }
}
