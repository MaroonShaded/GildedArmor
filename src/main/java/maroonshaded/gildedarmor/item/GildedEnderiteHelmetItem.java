package maroonshaded.gildedarmor.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class GildedEnderiteHelmetItem extends GildedArmorItem
{
    public GildedEnderiteHelmetItem(Properties properties)
    {
        super(ModArmorMaterials.GILDED_ENDERITE, EquipmentSlot.HEAD, properties);
    }

    @Override
    public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity)
    {
        return true;
    }
}
