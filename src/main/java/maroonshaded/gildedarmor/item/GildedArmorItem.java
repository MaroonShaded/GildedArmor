package maroonshaded.gildedarmor.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;

public class GildedArmorItem extends ArmorItem
{
    public GildedArmorItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties properties)
    {
        super(materialIn, slot, properties);
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }
}
