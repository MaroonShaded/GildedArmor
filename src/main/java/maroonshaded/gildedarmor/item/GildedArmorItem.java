package maroonshaded.gildedarmor.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class GildedArmorItem extends ArmorItem
{
    public GildedArmorItem(ArmorMaterial material, ArmorItem.Type slot, Properties properties)
    {
        super(material, slot, properties);
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }
}
