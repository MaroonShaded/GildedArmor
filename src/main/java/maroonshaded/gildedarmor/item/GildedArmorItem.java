package maroonshaded.gildedarmor.item;

import com.google.common.collect.Sets;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.Set;

public class GildedArmorItem extends ArmorItem
{
    private static final Set<Item> itemsAdded = Sets.newHashSet();
    private static int offset = 1;

    public GildedArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties)
    {
        super(material, slot, properties);
    }

    @Override
    public boolean makesPiglinsNeutral(ItemStack stack, LivingEntity wearer)
    {
        return true;
    }

    @Override
    public void fillItemCategory(CreativeModeTab pCategory, NonNullList<ItemStack> pItems)
    {
        if (allowedIn(pCategory))
        {
            if (itemsAdded.contains(this))
            {
                offset = 1;
                itemsAdded.clear();
            }

            int index = pItems.stream().map(ItemStack::getItem).toList().indexOf(Items.NETHERITE_BOOTS);
            if (index != -1)
            {
                pItems.add(index + offset++, new ItemStack(this));
                itemsAdded.add(this);
            } else pItems.add(new ItemStack(this));
        }
    }
}
