package maroonshaded.gildedarmor.item;

import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;

public class GildedEnderiteHelmetItem extends GildedArmorItem
{
    public GildedEnderiteHelmetItem(Properties properties)
    {
        super(ModArmorMaterial.GILDED_ENDERITE, EquipmentSlotType.HEAD, properties);
    }

    @Override
    public boolean isEnderMask(ItemStack stack, PlayerEntity player, EndermanEntity endermanEntity)
    {
        return true;
    }
}
